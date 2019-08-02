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
}
