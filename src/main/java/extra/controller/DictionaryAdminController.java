package extra.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import pojo.entity.Dictionary;
import service.DictonaryService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/dicrionary")
public class DictionaryAdminController {


    @Resource
    private DictonaryService dictonaryService;


    @ApiOperation("/添加场次")
    @PostMapping("/insert")
    public Boolean insertDictionary(@ApiParam(value = "dicionary对象")  Dictionary dictionary){

        return dictonaryService.insertDictonary(dictionary);
    }

    @ApiOperation("/修改场次信息")
    @PostMapping("/update")
    public Boolean updateDictionary(@ApiParam(value = "dicionary对象") Dictionary dictionary){

        return dictonaryService.updateDictionary(dictionary);
    }


}
