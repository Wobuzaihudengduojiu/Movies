package controller;


import dao.CinemaMapper;
import exception.ParameterException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.entity.Cinema;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/demo")
@Slf4j
@Api
public class DemoController {


    @Resource
    private CinemaMapper cinemaMapper;

    @ApiOperation(value = "demo")
    @GetMapping("/aa.dos")
    public Boolean getCinema(){

        log.info("Cinema:{}",cinemaMapper.selectAll());

        if(true){
            throw new ParameterException("参数解析错误");
        }

        return cinemaMapper.insert(null)>0;
    }

}
