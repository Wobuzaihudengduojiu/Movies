package extra.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pojo.entity.Cinema;
import service.CinemaService;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/admin/cinema")
@Api(value = "管理员")
public class CinemaAdminCotroller {


    @Resource
    private CinemaService cinemaService;


    @ApiOperation("添加电影院")
    @PostMapping("/insert")
    public Boolean insertCinema(@ApiParam(value = "cinema对象") @RequestBody Cinema cinema){

        return cinemaService.insertCinema(cinema);
    }

    @ApiOperation("修改电影院信息")
    @PutMapping("/update")
    public Boolean updateCinema(@ApiParam(value = "cinema对象") @RequestBody Cinema cinema){

        return cinemaService.updateCinema(cinema);
    }



}
