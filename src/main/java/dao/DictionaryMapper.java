package dao;

import java.util.List;
import pojo.entity.Dictionary;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer dictId);

    int insert(Dictionary record);

    Dictionary selectByPrimaryKey(Integer dictId);

    List<Dictionary> selectAll();

    int updateByPrimaryKey(Dictionary record);
}