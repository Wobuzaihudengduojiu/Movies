package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.entity.Ticket;

public interface TicketMapper {
    int deleteByPrimaryKey(Integer tkId);

    int insert(Ticket record);

    Ticket selectByPrimaryKey(Integer tkId);

    List<Ticket> selectAll();

    int updateByPrimaryKey(Ticket record);

    List<Ticket> selectByUserId(Integer userid);

    int updateStatusByTkIds(@Param(value = "tkIds") List<Integer> tkIds);

    int insertTickets(@Param(value = "tickets") List<Ticket> tickets);
}