package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.VO.MovieVO;
import pojo.entity.Cinema;
import pojo.entity.Movie;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer movId);

    int insert(Movie record);

    Movie selectByPrimaryKey(Integer movId);

    List<Movie> selectAll();

    int updateByPrimaryKey(Movie record);
    
	/**
	 * 查找正在热映
	 */
	public List<Movie> selectMovieByHot(int status);
	/**
	 * 查找即将上映
	 */
	public List<Movie> selectMovieByCome(int status);
	
	/**
	 * 对电影进行评论(需要 用户id,电影id,评论内容)
	 */
	public Boolean insertCommentToMovie(@Param("userid")int userid,@Param("mov_id")int mov_id,@Param("com_content")String com_content);
	/**
	 * 根据电影名称搜索电影(需要 电影名称)
	 */
	public List<Movie> selectMovieByMov_name(@Param("mov_name")String mov_name);
	/**
	 * 根据地区筛选电影(需要 地区)
	 */
	public List<Movie> selectMovieByMov_area(@Param("mov_area")String mov_area);
	/**
	 * <!-- 根据电影院查询所有的电影 -->
	 */
	public List<Movie> selectMovieByCinema(@Param("cine_id")int cine_id);
}