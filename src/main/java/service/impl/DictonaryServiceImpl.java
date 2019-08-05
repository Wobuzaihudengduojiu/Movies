package service.impl;

import dao.DictionaryMapper;
import dao.MovieMapper;
import enmu.ErrorEnum;
import exception.MoviesException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.entity.Dictionary;
import service.DictonaryService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DictonaryServiceImpl implements DictonaryService {


    @Resource
    private DictionaryMapper dictionaryMapper;

    @Resource
    private MovieMapper movieMapper;


    @Override
    public List<Dictionary> queryByMovIdAndCineId(Integer movId, Integer cineId) {

        if (StringUtils.isEmpty(movId) || StringUtils.isEmpty(cineId)) {

            throw new MoviesException(ErrorEnum.E_90003);
        }

        return dictionaryMapper.queryByMovIdAndCineId(movId, cineId);
    }

    @Override
    public Boolean insertDictonary(Dictionary dictionary) {

        return dictionaryMapper.insert(dictionary) > 0;
    }

    @Override
    public Boolean updateDictionary(Dictionary dictionary) {

        return dictionaryMapper.updateByPrimaryKey(dictionary) > 0;
    }

    @Override
    public String selectSeats(Integer dictId) {

        if (StringUtils.isEmpty(dictId)) {

            throw new MoviesException(ErrorEnum.E_90003);
        }

        return dictionaryMapper.selectByPrimaryKey(dictId)
                .getDictSeat();

    }
}
