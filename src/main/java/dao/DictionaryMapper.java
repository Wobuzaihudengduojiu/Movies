package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.entity.Dictionary;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer dictId);

    int insert(Dictionary record);

    Dictionary selectByPrimaryKey(Integer dictId);

    List<Dictionary> selectAll();

    int updateByPrimaryKey(Dictionary record);

    List<Dictionary> queryByMovIdAndCineId(@Param(value = "movId") Integer movId,@Param(value = "cineId") Integer cineId);
}