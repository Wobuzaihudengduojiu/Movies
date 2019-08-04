package controller;


import dao.DictionaryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pojo.VO.TicketVO;
import pojo.entity.Cinema;
import pojo.entity.Dictionary;
import pojo.entity.Ticket;
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


    @ApiOperation(value = "查询用户电影票记录,若movid未空则是查询所有记录，不为空则是查询电影票详细信息")
    @GetMapping("/query/id")
    public List<TicketVO> queryPaymentByUserId(
         @ApiParam(value = "用户id") @RequestParam(value = "userid")Integer userid,
         @ApiParam(value = "电影id") @RequestParam(value = "movid",required = false)Integer movid

    ) {
        return ticketService.selectPaymentRecordById(userid,movid);
    }

    @ApiOperation(value = "用于修改电影票状态，通过扫描二维码，将电影票状态改为已领取")
    @PutMapping("/update/status")
    public Boolean updateTicketStatus(
         @ApiParam(value = "支付记录id")  @RequestParam(value = "payRecord") String payRecord){

        return ticketService.updateTicketStatus(payRecord);
    }


//    @Deprecated
//    @ApiOperation("购买电影票")
//    @PostMapping("/insert")
//    public Boolean buyTickets(
//       @ApiParam(value = "ticket对象")  @RequestBody Ticket ticket){
//
//        return ticketService.insertTickets(tickest);
//    }

    @ApiOperation("购买电影票")
    @PostMapping("/insert")
    public Boolean buyTickets(
            @ApiParam(value = "座位信息")
            @RequestParam String seat,
            @ApiParam("场次id")
            @RequestParam Integer dictId) {

        return ticketService.insertTickets(seat, dictId);

    }


}
