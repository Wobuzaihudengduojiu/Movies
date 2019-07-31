package service.impl;

import dao.MovieMapper;
import dao.TicketMapper;
import exception.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.VO.TicketVO;
import pojo.entity.Movie;
import pojo.entity.Ticket;
import service.TicketService;

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

    @Override
    public List<TicketVO> selectPaymentRecordById(Integer userid, Integer movid) {

        List<TicketVO> ticketVo;

        List<TicketVO> ticketVOList;

        if (userid == null) {
            throw new ParameterException("您还没有登录");
        } else {

            //movies--->ticket 用户一次可以买多张票，用于合并座位和订单id
            Map<Integer, List<Ticket>> movies = ticketMapper.selectByUserId(userid)
                    .stream()
                    .collect(Collectors.groupingBy(Ticket::getMovId));


            ticketVo = ticketMapper.selectByUserId(userid)
                    .stream()
                    .map(
                            v -> {

                                Movie movie = movieMapper.selectByPrimaryKey(v.getMovId());

                                //合并座位
                                String seats = movies.get(v.getMovId())
                                        .stream()
                                        .map(Ticket::getDictSeat)
                                        .collect(Collectors.joining(" "));

                                //合并id
                                String ticketPayRecord = movies.get(v.getMovId())
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
                                        .total(movies.get(v.getMovId()).size())
                                        .dictHall(v.getDictHall())
                                        .image(movie.getMovImage())
                                        .movId(v.getMovId())
                                        .movName(movie.getMovName())
                                        .payRecord(ticketPayRecord)
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
    public Boolean insertTickets(Ticket ticket) {

        /**
         *
         * 将座位号按照空格进行切割，团购记录
         */

        List<Ticket> tickets;

        if (StringUtils.isEmpty(ticket.getMovId())
                || StringUtils.isEmpty(ticket.getDictSeat())
                || StringUtils.isEmpty(ticket.getUserId())
                || StringUtils.isEmpty(ticket.getCineAddress())
                || StringUtils.isEmpty(ticket.getDictStartTime())
                || StringUtils.isEmpty(ticket.getDictHall())
                || StringUtils.isEmpty(ticket.getDickEndTime())) {

            throw new ParameterException("请检查参数是否正确");
        }else{

        tickets=Arrays.stream(ticket.getDictSeat().split(" "))
                .map(
                        v->{

                            Ticket ticket1=Ticket.builder()
                                    .cineAddress(ticket.getCineAddress())
                                    .dickEndTime(ticket.getDickEndTime())
                                    .dictHall(ticket.getDictHall())
                                    .dictSeat(v)
                                    .dictStartTime(ticket.getDictStartTime())
                                    .movId(ticket.getMovId())
                                    .userId(ticket.getUserId())
                                    .tkStatus(0)
                                    .build();

                            return ticket1;

                })
                .collect(toList());
        }

        return ticketMapper.insertTickets(tickets)>0;
    }
}
