package controller;


import dao.CinemaMapper;
import dao.DictionaryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pojo.VO.TicketVO;
import pojo.entity.Cinema;
import pojo.entity.Dictionary;
import pojo.entity.Ticket;
import pojo.entity.User;
import service.DictonaryService;
import service.TicketService;
import util.Constants;
import util.Utils;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@Api(value = "电影票")
@RequestMapping("/ticket")
public class TicketController {

    @Resource
    private TicketService ticketService;

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Resource
    private CinemaMapper cinemaMapper;

    @ApiOperation(value = "查询用户电影票记录,若movid未空则是查询所有记录，不为空则是查询电影票详细信息")
    @GetMapping("/query/id")
    public List<TicketVO> queryPaymentByUserId(
            @ApiParam(value = "用户id") @RequestParam(value = "userid") Integer userid,
            @ApiParam(value = "电影id") @RequestParam(value = "movid", required = false) Integer movid

    ) {
        return ticketService.selectPaymentRecordById(userid, movid);
    }

    @ApiOperation(value = "用于修改电影票状态，通过扫描二维码，将电影票状态改为已领取")
    @PutMapping("/update/status")
    public Boolean updateTicketStatus(
            @ApiParam(value = "支付记录id") @RequestParam(value = "payRecord") String payRecord) {

        return ticketService.updateTicketStatus(payRecord);
    }

    @ApiOperation("购买电影票")
    @PostMapping("/insert")
    public Boolean buyTickets(
            @ApiParam(value = "座位信息")
            @RequestParam String seat,
            @ApiParam("场次id")
            @RequestParam Integer dictId) {
        Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(dictId);
        Cinema cinema=cinemaMapper.selectByDictId(dictId);
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(dictionary, ticket);
        ticket.setDictHall(dictionary.getDictHall());
        ticket.setDickEndTime(dictionary.getDictEndTime());
        ticket.setDictSeat(seat);
        ticket.setCineAddress(cinema.getCineAddress());
        Object o = Utils.getRequest().getSession().getAttribute(Constants.SESSION_USER_INFO);
        if (o != null) {
            User user = (User) o;
            ticket.setUserId(user.getUserid());
        } else {
            ticket.setUserId(1);
        }
        System.out.println(ticket);
        return ticketService.insertTickets(ticket);
    }


}
