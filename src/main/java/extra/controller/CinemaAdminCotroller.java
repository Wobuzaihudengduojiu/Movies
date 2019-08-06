package extra.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pojo.entity.Cinema;
import service.CinemaService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/admin/cinema")
@Api(value = "管理员")
public class CinemaAdminCotroller {


    @Resource
    private CinemaService cinemaService;


    @ApiOperation("添加电影院")
    @PostMapping("/insert")
    public Boolean insertCinema(@ApiParam(value = "cinema对象")  Cinema cinema) {

        return cinemaService.insertCinema(cinema);
    }

    @ApiOperation("修改电影院信息")
    @PutMapping("/update")
    public Boolean updateCinema(@ApiParam(value = "cinema对象") Cinema cinema) {

        return cinemaService.updateCinema(cinema);
    }

    @ApiOperation("查询所有影院")
    @GetMapping("/select/{pageSize}/{pageIndex}")
    public PageInfo<Cinema> selectAllCinemas(
            @PathVariable(value = "pageSize") int pageSize,
            @PathVariable(value = "pageIndex") int pageIndex,
            @RequestParam(defaultValue = "",required = false) String name) {

        PageInfo<Cinema> pageInfo = PageHelper.startPage(pageIndex, pageSize)
                .doSelectPageInfo(() -> cinemaService.selectAllCinema());
        if (!name.equals("")) {
            List<Cinema> list = pageInfo.getList()
                    .stream()
                    .filter(e -> e.getCineName().contains(name))
                    .collect(Collectors.toList());
            pageInfo.setList(list);
        }
        return pageInfo;
    }


}

