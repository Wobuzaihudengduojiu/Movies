package controller;


import dao.CinemaMapper;
import exception.ParameterException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pojo.VO.ResultVO;
import pojo.entity.Cinema;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/demo")
@Slf4j
@Api
public class DemoController {

//    @Resource
//    private CinemaMapper cinemaMapper;
//
//    @ApiOperation(value = "demo")
//    @GetMapping("/aa.dos")
//    public List<Cinema> getCinema(@ApiParam(value="sss") @RequestParam String id){
//
//        log.info("Cinema:{}",cinemaMapper.selectAll());
//
////        if(true){
////            throw new ParameterException("参数解析错误");
////        }
//
//        return cinemaMapper.selectAll();
//    }

}
