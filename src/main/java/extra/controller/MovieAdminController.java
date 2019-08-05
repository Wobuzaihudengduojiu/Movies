package extra.controller;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.entity.Movie;
import service.MovieService;
import util.GetFileUrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/movie")
@Slf4j
public class MovieAdminController {

    @Resource
    private MovieService movieService;


    @ApiOperation(value = "添加电影")
    @PostMapping(value = "/insertMovie.do")
    @ApiImplicitParams({
    })
    @ResponseBody
    public Boolean insertMovie(
            @RequestParam("movName") @ApiParam(value = "电影名称") String movName,
            @RequestParam("movDescription") @ApiParam(value = "描述") String movDescription,
            @RequestParam("movType") @ApiParam(value = "类型") String movType,
            @RequestParam("movStatus") @ApiParam(value = "状态0下架1未下架") int movStatus,
            @RequestParam("movLastTime") @ApiParam(value = "持续时间") int movLastTime,
            @RequestParam("movDirector") @ApiParam(value = "导演") String movDirector,
            @RequestParam("movCore") @ApiParam(value = "评分") Double movCore,
            @RequestParam("movReleaseTime") @ApiParam(value = "上映时间") Date movReleaseTime,
            @RequestParam("movActor") @ApiParam(value = "主演") String movActor,
            @RequestParam("movIsCome") @ApiParam(value = "即将上映") int movIsCome,
            @RequestParam("movIsHot") @ApiParam(value = "正在热映") int movIsHot,
            //@RequestParam("movImage") @ApiParam(value = "海报") String movImage,
            //@RequestParam("movPhotos") @ApiParam(value = "剧照") String movPhotos,
            @RequestParam("movArea") @ApiParam(value = "地区") String movArea,
            @RequestParam(value = "imagefile",required = false) @ApiParam(value = "海报") MultipartFile imagefile,
            @RequestParam(name="photosfiles",required = false) @ApiParam(value = "剧照") List<MultipartFile> photosfiles,
            HttpServletRequest request
    ) throws IOException {
        String movImage = GetFileUrl.get(imagefile,movName,request);

        StringBuffer movPhotosBuffer = new StringBuffer();
        for(MultipartFile file : photosfiles){
            movPhotosBuffer= movPhotosBuffer.append(GetFileUrl.get(file,movName,request)+" ");
        }
        String movPhotos = movPhotosBuffer.toString();
        Movie movie = new Movie(null,movName, movDescription, movType, movStatus,
                movLastTime,  movDirector,movCore, movReleaseTime, movActor,
                movIsCome, movIsHot, movImage, movPhotos, movArea,null,null);
        System.out.println(movie);


        return  movieService.insertMovie(movie);
    }




}
