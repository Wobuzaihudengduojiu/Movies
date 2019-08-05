package service;

import pojo.VO.MovieVO;
import pojo.entity.Cinema;
import pojo.entity.Movie;

import java.util.List;

public interface MovieService {
	/**
	 * 根据电影查找电影院(需要 电影id)
	 */
	List<Cinema> selectCinemaByMovie(int mov_id);
	/**
	 * 查找正在热映
	 */
	List<Movie> selectMovieByHot(int status);
	/**
	 * 查找即将上映
	 */
	List<Movie> selectMovieByCome(int status);
	/**
	 * 查看电影详细信息,包括评论信息(需要 电影id)
	 */
	MovieVO selectDetailMovieInfo(int mov_id);
	/**
	 * 对电影进行评论(需要 用户id,电影id,评论内容)
	 */
	Boolean insertCommentToMovie(int userid,int mov_id,String com_content);
	/**
	 * 根据电影名称搜索电影(需要 电影名称)
	 */
	List<Movie> selectMovieByMov_name(String mov_name);
	/**
	 * 根据地区筛选电影(需要 地区)
	 */
	List<Movie> selectMovieByMov_area(String mov_area);
	/*
	 * 根据电影院查询所有的电影
	 */
	List<Movie> selectMovieByCinema(int cine_id);
	/**
	 * 管理员添加电影信息
	 */
	Boolean insertMovie(Movie movie);
}
