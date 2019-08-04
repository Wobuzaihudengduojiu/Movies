package service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dao.CinemaMapper;
import dao.DictionaryMapper;
import dao.MovieMapper;
import dao.TicketMapper;
import exception.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.VO.TicketVO;
import pojo.entity.Dictionary;
import pojo.entity.*;
import service.TicketService;
import util.Constants;
import util.Utils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    @Resource
    private TicketMapper ticketMapper;

    @Resource
    private MovieMapper movieMapper;

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Resource
    private CinemaMapper cinemaMapper;

    @Override
    public List<TicketVO> selectPaymentRecordById(Integer userid, Integer movid) {

        List<TicketVO> ticketVo;

        List<TicketVO> ticketVOList;

        if (userid == null) {
            throw new ParameterException("您还没有登录");
        } else {

            //movies--->ticket 用户一次可以买多张票，用于合并座位和订单id（根据场次）
            Map<Integer, List<Ticket>> movies = ticketMapper.selectByUserId(userid)
                    .stream()
                    .collect(Collectors.groupingBy(Ticket::getDictId));


            ticketVo = ticketMapper.selectByUserId(userid)
                    .stream()
                    .map(
                            v -> {

                                Movie movie = movieMapper.selectByPrimaryKey(v.getMovId());

                                //合并座位--->根据场次
                                String seats = movies.get(v.getDictId())
                                        .stream()
                                        .map(Ticket::getDictSeat)
                                        .collect(Collectors.joining(" "));

                                //合并id
                                String ticketPayRecord = movies.get(v.getDictId())
                                        .stream()
                                        .map(v1 -> v1.getTkId().toString())
                                        .collect(joining(" "));

                                TicketVO ticketVO = TicketVO.builder()
                                        .userId(v.getUserId())
                                        .dictStartTime(v.getDictStartTime())
                                        .dickEndTime(v.getDickEndTime())
                                        .cineAddress(v.getCineAddress())
                                        .dictSeat(seats)
                                        .tkStatus(v.getTkStatus())
                                        .total(movies.get(v.getDictId()).size())
                                        .dictHall(v.getDictHall())
                                        .image(movie.getMovImage())
                                        .movId(v.getMovId())
                                        .movName(movie.getMovName())
                                        .payRecord(ticketPayRecord)
                                        .dictId(v.getDictId())
                                        .build();

                                return ticketVO;
                            })
                    .collect(Collectors.toList());

            /**
             * 去重
             */
            ticketVOList = ticketVo.stream().collect(
                    collectingAndThen(
                            toCollection(() -> new TreeSet<>(Comparator.comparing(TicketVO::getMovId))), ArrayList::new
                    )
            );

        }


        /**
         * 根据订单查询电影详细信息
         */
        if (!StringUtils.isEmpty(movid)) {

            return ticketVOList.stream()
                    .filter(v -> v.getMovId().equals(movid))
                    .collect(Collectors.toList());
        }

        return ticketVOList;

    }

    @Override
    public Boolean updateTicketStatus(String payRecord) {

        List<Integer> tickets = new ArrayList<>();

        if (!StringUtils.isEmpty(payRecord)) {

            tickets = Arrays.stream(payRecord.split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

        }

        return ticketMapper.updateStatusByTkIds(tickets) > 0;

    }

    @Override
    public Boolean insertTickets(String seat, Integer dictId) {

        Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(dictId);
        Cinema cinema = cinemaMapper.selectByDictId(dictId);


        /**
         * 将座位号按照空格进行切割，团购记录，修改座位状态
         */

        int[][] selectedSeat = jsonToTwoArr(dictionary.getDictSeat());


        List<Ticket> tickets = Arrays.stream(seat.split(" "))
                .map(
                        v -> {

                            /**
                             * 修改座位状态,将座位修改为占有 1
                             */

                            int i = v.charAt(0)-'0';

                            int j = v.charAt(2)-'0';

                            selectedSeat[i - 1][j - 1] = 1;

                            Ticket ticket = new Ticket();
                            BeanUtils.copyProperties(dictionary, ticket);
                            ticket.setDictHall(dictionary.getDictHall());
                            ticket.setDickEndTime(dictionary.getDictEndTime());
                            ticket.setDictSeat(v);
                            ticket.setCineAddress(cinema.getCineAddress());
                            ticket.setTkStatus(0);

                            Object o = Utils.getRequest().getSession().getAttribute(Constants.SESSION_USER_INFO);
                            if (o != null) {
                                User user = (User) o;
                                ticket.setUserId(user.getUserid());
                            } else {
                                ticket.setUserId(1);
                            }

                            return ticket;

                        })
                .collect(toList());

        String seats = JSONObject.toJSONString(selectedSeat);

        dictionary.setDictSeat(seats);

        return ticketMapper.insertTickets(tickets) > 0 && dictionaryMapper.updateByPrimaryKey(dictionary)>0;
    }


    /**
     * 将字符串转换为二维数组
     */

    private int[][] jsonToTwoArr(String str) {

        int[][] param = new int[10][5];

        final JSONArray arr = JSON.parseArray(str);

        for (int i = 0; i < arr.size(); i++) {

            JSONArray jsonArray = JSON.parseArray(arr.get(i).toString());
            for (int j = 0; j < jsonArray.size(); j++) {

                param[i][j] = (int) jsonArray.get(j);
            }
        }

        return param;
    }
}
