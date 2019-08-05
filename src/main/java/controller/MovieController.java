package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.VO.MovieVO;
import pojo.entity.Cinema;
import pojo.entity.Movie;
import service.MovieService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/movie")
@Slf4j
@Api
public class MovieController {
	
	@Resource
	private MovieService movieService;
	
	@ApiOperation(value = "根据电影查找电影院(需要 电影id)")
    @GetMapping("/selectCinemaByMovie.do")
	public List<Cinema> selectCinemaByMovie(@ApiParam(value="电影id  movId") @RequestParam(name="movId") int mov_id){
		return movieService.selectCinemaByMovie(mov_id);
	}

	
	@ApiOperation(value = "根据状态查找电影")
    @GetMapping("/selectMovieByStatus.do")
	public List<Movie> selectMovieByCome(@ApiParam(value="即将上映  status (0或1)") @RequestParam(name="status") int status){
		return movieService.selectMovieByCome(status);
	}
	
	@ApiOperation(value = "查看电影详细信息,包括评论信息(需要 电影id)")
    @GetMapping("/selectDetailMovieInfo.do")
	public MovieVO selectDetailMovieInfo(@ApiParam(value="电影id  movId") @RequestParam(name="movId") int mov_id) {
		
		return movieService.selectDetailMovieInfo(mov_id);
	}


	
	@ApiOperation(value = "根据电影名称搜索电影(需要 电影名称)")
    @GetMapping("/selectMovieByMov_name.do")
	public List<Movie> selectMovieByMov_name(@ApiParam(value="电影名字  movName") @RequestParam(name="movName") String mov_name){
		
		return movieService.selectMovieByMov_name(mov_name);
	}
	
	@ApiOperation(value = "根据地区筛选电影(需要 地区)")
    @GetMapping("/selectMovieByMov_area.do")
	public List<Movie> selectMovieByMov_area(@ApiParam(value="电影地区  movArea") @RequestParam(name="movArea") String mov_area){
		
		return movieService.selectMovieByMov_area(mov_area);
	}
	
	@ApiOperation(value = "根据电影院查询所有电影")
    @GetMapping("/selectMovieByCinema.do")
	public List<Movie> selectMovieByCinema(@ApiParam(value="电影院id  cineId") @RequestParam(name="cineId")int cine_id){
		return movieService.selectMovieByCinema(cine_id);
	}


	/**
	 *  该方法在CommentController中
	 */
	@Deprecated()
	@ApiOperation(value = "对电影进行评论(需要 用户id,电影id,评论内容)")
	@GetMapping("/insertCommentToMovie.do")
	public Boolean insertCommentToMovie(
			@ApiParam(value="用户id  userId") @RequestParam(name="userId") int userid,
			@ApiParam(value="电影id  movId") @RequestParam(name="movId") int mov_id,
			@ApiParam(value="评论内容 comContent") @RequestParam(name="comContent") String com_content) {

		return movieService.insertCommentToMovie(userid, mov_id, com_content);
	}
}
