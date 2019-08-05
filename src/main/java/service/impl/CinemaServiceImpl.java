package service.impl;

import dao.CinemaMapper;
import org.springframework.stereotype.Service;
import pojo.entity.Cinema;
import service.CinemaService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {


    @Resource
    private CinemaMapper cinemaMapper;

    @Override
    public List<Cinema> selectAllCinema() {
        return cinemaMapper.selectAll();
    }

    @Override
    public Boolean updateCinema(Cinema cinema) {

        return cinemaMapper.updateByPrimaryKey(cinema)>0;
    }

    @Override
    public Boolean insertCinema(Cinema cinema) {

        return cinemaMapper.insert(cinema) > 0;
    }
}
