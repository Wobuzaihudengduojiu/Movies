package service;

import pojo.entity.Dictionary;

import java.util.List;

public interface DictonaryService {


    /**
     * 查询电影场次
     */
    List<Dictionary> queryByMovIdAndCineId(Integer movId,Integer cineId);



}
