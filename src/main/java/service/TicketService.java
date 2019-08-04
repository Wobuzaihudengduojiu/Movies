package service;

import pojo.VO.TicketVO;
import pojo.entity.Ticket;

import java.util.List;

public interface TicketService {

    /**
     * 用于查询用户购买电影票记录
     */
    List<TicketVO> selectPaymentRecordById(Integer userid,Integer movid);

    /**
     * 修改电影票状态为已领取
     */
    Boolean updateTicketStatus(String payRecord);

    /**
     * 批量插入ticket对象
     */
    Boolean insertTickets(String seat,Integer dictId);



}
