package service;

import java.util.List;


import pojo.VO.MovieVO;
import pojo.entity.Cinema;
import pojo.entity.Movie;

public interface MovieService {
	/**
	 * 根据电影查找电影院(需要 电影id)
	 */
	public List<Cinema> selectCinemaByMovie(int mov_id);
	/**
	 * 查找正在热映
	 */
	public List<Movie> selectMovieByHot(int status);
	/**
	 * 查找即将上映
	 */
	public List<Movie> selectMovieByCome(int status);
	/**
	 * 查看电影详细信息,包括评论信息(需要 电影id)
	 */
	public MovieVO selectDetailMovieInfo(int mov_id);
	/**
	 * 对电影进行评论(需要 用户id,电影id,评论内容)
	 */
	public Boolean insertCommentToMovie(int userid,int mov_id,String com_content);
	/**
	 * 根据电影名称搜索电影(需要 电影名称)
	 */
	public List<Movie> selectMovieByMov_name(String mov_name);
	/**
	 * 根据地区筛选电影(需要 地区)
	 */
	public List<Movie> selectMovieByMov_area(String mov_area);
	/*
	 * 根据电影院查询所有的电影
	 */
	public List<Movie> selectMovieByCinema(int cine_id);
}
