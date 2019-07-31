package controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.entity.Dictionary;
import service.DictonaryService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dicrionary")
@Api("场次相关操作")
public class DictionaryController {


    @Resource
    private DictonaryService dictonaryService;


    @GetMapping("/query/movId")
    @ApiOperation(value = "根据电影id和影院id查询场次")
    public List<Dictionary> queryDictByMovIdAndCineId(
            @ApiParam(value = "影院id") @RequestParam("cineId") Integer cineId,
            @ApiParam(value = "电影id") @RequestParam("movId") Integer movId) {

            return dictonaryService.queryByMovIdAndCineId(movId,cineId);
    }
}
