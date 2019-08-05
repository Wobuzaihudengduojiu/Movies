package service;

import pojo.entity.Cinema;

import java.util.List;

public interface CinemaService {



    List<Cinema> selectAllCinema();


    Boolean insertCinema(Cinema cinema);

    Boolean updateCinema(Cinema cinema);
}
