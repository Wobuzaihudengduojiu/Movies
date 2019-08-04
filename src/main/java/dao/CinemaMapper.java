package dao;

import java.util.List;

import io.swagger.models.auth.In;
import pojo.entity.Cinema;

public interface CinemaMapper {
    int deleteByPrimaryKey(Integer cineId);

    int insert(Cinema record);

    Cinema selectByPrimaryKey(Integer cineId);

    List<Cinema> selectAll();

    int updateByPrimaryKey(Cinema record);
    
    /**
	 * 根据电影查找电影院(需要 电影id)
	 */
	List<Cinema> selectCinemaByMovie(int mov_id);

	Cinema selectByDictId(Integer dictId);
}