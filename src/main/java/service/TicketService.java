package service;

import pojo.entity.Ticket;

import java.util.List;

public interface TicketService {

    /**
     * 用于查询用户购买电影票记录
     */
    List<Ticket> selectPaymentRecordById(Integer userid) throws Exception;


}
