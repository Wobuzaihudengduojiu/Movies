package dao;

import java.util.List;
import pojo.entity.Ticket;

public interface TicketMapper {
    int deleteByPrimaryKey(Integer tkId);

    int insert(Ticket record);

    Ticket selectByPrimaryKey(Integer tkId);

    List<Ticket> selectAll();

    int updateByPrimaryKey(Ticket record);
}