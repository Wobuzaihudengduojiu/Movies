package service.impl;

import dao.CinemaMapper;
import dao.CommentMapper;
import dao.MovieMapper;
import org.springframework.stereotype.Service;
import pojo.VO.MovieVO;
import pojo.entity.Cinema;
import pojo.entity.Comment;
import pojo.entity.Movie;
import service.MovieService;

import javax.annotation.Resource;
import java.util.List;

@Service
//@SpringBootApplication(junit测试时用)
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
public class MovieServiceImpl implements MovieService {
	
	@Resource
	private MovieMapper movieMapper;
	@Resource
	private CommentMapper commentMapper;
	@Resource
	private CinemaMapper cinemaMapper;

	@Override
	public List<Cinema> selectCinemaByMovie(int mov_id) {
		// TODO Auto-generated method stub
		return cinemaMapper.selectCinemaByMovie(mov_id);
	}

	@Override
	public List<Movie> selectMovieByHot(int status) {
		// TODO Auto-generated method stub
		return movieMapper.selectMovieByHot(status);
	}

	@Override
	public List<Movie> selectMovieByCome(int status) {
		// TODO Auto-generated method stub
		return movieMapper.selectMovieByCome(status);
	}

	@Override
	public MovieVO selectDetailMovieInfo(int mov_id) {
		
		List<Comment> comments = commentMapper.selectCommentByMovId(mov_id);
		Movie movie = movieMapper.selectByPrimaryKey(mov_id);
		MovieVO movieVo = new MovieVO(movie, comments);
		// TODO Auto-generated method stub
		return movieVo;
	}

	@Override
	public Boolean insertCommentToMovie(int userid, int mov_id, String com_content) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setUserId(userid);
		comment.setMovId(mov_id);
		comment.setComContent(com_content);
		
		return commentMapper.insert(comment)>0;
	}

	@Override
	public List<Movie> selectMovieByMov_name(String mov_name) {
		
		
		// TODO Auto-generated method stub
		return movieMapper.selectMovieByMov_name(mov_name);
	}

	@Override
	public List<Movie> selectMovieByMov_area(String mov_area) {
		// TODO Auto-generated method stub
		return movieMapper.selectMovieByMov_area(mov_area);
	}

	@Override
	public List<Movie> selectMovieByCinema(int cine_id) {
		return movieMapper.selectMovieByCinema(cine_id);
	}


	@Override
	public Boolean insertMovie(Movie movie){
		return movieMapper.insert(movie)>0;
	}

//	@Test
//	public void test() {
//		int code = moviemapper.hashCode();
//		System.out.println(code);
//	}


	
}
