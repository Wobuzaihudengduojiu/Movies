package extra.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.entity.Cinema;
import pojo.entity.Movie;
import service.MovieService;
import util.GetFileUrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/movie")
@Slf4j
public class MovieAdminController {

    @Resource
    private MovieService movieService;

    @GetMapping("/selectAllMovies.do")
    @ApiOperation(value = "查询所有的电影信息")
    public PageInfo<Movie> selectAllMovies(@ApiParam(value = "页码") @RequestParam(defaultValue = "1") int pageNumber,
                                           @ApiParam(value = "页面数据大小") @RequestParam(defaultValue = "0") int pageSize,
                                           @RequestParam(defaultValue = "",required = false) String movName) {

        PageInfo<Movie> pageInfo = PageHelper.startPage(pageNumber, pageSize)
                .doSelectPageInfo(() -> movieService.selectMovieByMov_name(movName));

        return pageInfo;
    }




    @ApiOperation(value = "添加电影")
    @PostMapping(value = "/insertMovie.do")
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
            @RequestParam("movArea") @ApiParam(value = "地区") String movArea,
            @RequestParam("imagefile") @ApiParam(value = "海报") MultipartFile imagefile,
            @RequestParam(name = "photosfiles") @ApiParam(value = "剧照") List<MultipartFile> photosfiles,
            HttpServletRequest request
    ) throws IOException {
        String movImage = GetFileUrl.get(imagefile, movName, request);

        StringBuffer movPhotosBuffer = new StringBuffer();
        for (MultipartFile file : photosfiles) {
            movPhotosBuffer = movPhotosBuffer.append(GetFileUrl.get(file, movName, request) + " ");
        }
        String movPhotos = movPhotosBuffer.toString();
        Movie movie = new Movie(null, movName, movDescription, movType, movStatus,
                movLastTime, movDirector, movCore, movReleaseTime, movActor,
                movIsCome, movIsHot, movImage, movPhotos, movArea, null, null);
        System.out.println(movie);
        return movieService.insertMovie(movie);
    }

    @PostMapping("/updateMovieInfo.do")
    @ApiOperation(value = "修改电影信息")
    public Boolean updateupdateMovieInfo(
            @RequestParam("movId") @ApiParam(value = "电影id movId")int movId,
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
            @RequestParam("movArea") @ApiParam(value = "地区") String movArea,
            @RequestParam("imagefile") @ApiParam(value = "海报") MultipartFile imagefile,
            @RequestParam(name = "photosfiles") @ApiParam(value = "剧照") List<MultipartFile> photosfiles,
            HttpServletRequest request
    ) throws IOException {
        //电影图片文件夹是否存在
        Boolean directory = false;
        StringBuffer url = request.getRequestURL();
        String rootpathDatabase =url.delete(url.length() - request.getRequestURI().length(), url.length())
                .append(request.getServletContext().getContextPath())
                .append("/moviesImg/"+movName+"/")
                .toString();
        String rootpath = request.getServletContext().getRealPath("/static/") + "moviesImg/" + movName + "/";
        String movImage = rootpathDatabase + imagefile.getOriginalFilename();
        File movImageFile = new File(rootpath);
        if(movImageFile.exists()&&movImageFile.isDirectory()) {
            System.out.println("电影图片文件夹存在！");
            directory = true;
        }
        movImageFile = new File(rootpath+imagefile.getOriginalFilename());
        //判断海报的图片文件是否存在如果不存在则创建
        if (directory) {//判断文件目录的存在
            if (!movImageFile.isDirectory()) {//判断文件的存在性
                imagefile.transferTo(new File(rootpath + imagefile.getOriginalFilename()));
                System.out.println("创建海报文件成功！");
            }
        }else{
            System.out.println("海报文件夹不存在！");
            File file2 = new File(rootpath);
            file2.mkdirs();
            System.out.println("创建海报文件夹成功！");
            imagefile.transferTo(new File(rootpath + imagefile.getOriginalFilename()));
            System.out.println("海报文件不存在，创建海报文件成功！");
        }
        //判断剧照的图片文件是否存在如果不存在则创建
        StringBuffer movPhotosBuffer = new StringBuffer();
        for(MultipartFile photosfile : photosfiles) {
            File file = new File(rootpath+photosfile.getOriginalFilename());
            if (directory) {//判断文件目录的存在
                photosfile.transferTo(new File(rootpath + photosfile.getOriginalFilename()));
                System.out.println("创建剧照文件成功！");
            }else{
                System.out.println("剧照文件夹不存在！");
                File file2 = new File(rootpath);
                file2.mkdirs();
                System.out.println("创建剧照文件夹成功！");
                photosfile.transferTo(new File(rootpath + photosfile.getOriginalFilename()));
                System.out.println("剧照文件不存在，创建剧照文件成功！");
            }
            movPhotosBuffer = movPhotosBuffer.append(rootpathDatabase + photosfile.getOriginalFilename()+" ");
        }
        String movPhotos = movPhotosBuffer.toString();
        Movie movie = new Movie(movId, movName, movDescription, movType, movStatus,
                movLastTime, movDirector, movCore, movReleaseTime, movActor,
                movIsCome, movIsHot, movImage, movPhotos, movArea, null, null);
        return movieService.updateMovieInfo(movie);
        }
}