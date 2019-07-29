package controller;


import dao.CinemaMapper;
import exception.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.entity.Cinema;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {


    @Resource
    private CinemaMapper cinemaMapper;

    @GetMapping("/aa.dos")
    public List<Cinema> getCinema(){

        log.info("Cinema:{}",cinemaMapper.selectAll());

//        if(true){
//            throw new ParameterException("参数解析错误");
//        }

        return cinemaMapper.selectAll();
    }

}
