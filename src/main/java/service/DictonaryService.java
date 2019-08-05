package service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pojo.entity.Dictionary;

import java.util.List;

public interface DictonaryService {


    /**
     * 查询电影场次
     */
    List<Dictionary> queryByMovIdAndCineId(Integer movId,Integer cineId);

    /**
     * 查询已选过的座位 Json字符串
     */
    String selectSeats(Integer dictId);

    /**
     * 添加场次
     */
    Boolean insertDictonary(Dictionary dictionary);

    /**
     * 修改场次信息
     */
    Boolean updateDictionary(Dictionary dictionary);


}
