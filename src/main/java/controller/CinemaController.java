package controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pojo.entity.Cinema;
import service.CinemaService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/cinema")
@Api(value = "电影院")
public class CinemaController {


    @Resource
    private CinemaService cinemaService;


    @ApiOperation("/查询所有影院")
    @GetMapping("/select")
    public List<Cinema> selectAllCinemas(){

        return  cinemaService.selectAllCinema();
    }

}
