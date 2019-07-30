package service.impl;

import dao.TicketMapper;
import exception.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pojo.VO.TicketVO;
import pojo.entity.Ticket;
import service.TicketService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    @Resource
    private TicketMapper ticketMapper;

    @Override
    public List<Ticket> selectPaymentRecordById(Integer userid) throws Exception {


        List<TicketVO> ticketVo = null;

        if (userid == null) {
            throw new ParameterException("您还没有登录");
        } else {

//            Map<Integer, Long> movies = ticketMapper.selectByUserId(userid)
//                    .stream()
//                    .collect(Collectors.groupingBy(Ticket::getMovId, Collectors.counting()));
//
//            ticketMapper.selectByUserId(userid)
//                    .stream()
//                    .map(
//                            v -> {
//
//
//                            })

        }
        return null;
    }
}
