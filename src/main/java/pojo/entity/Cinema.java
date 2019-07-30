package pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {
    private Integer cineId;

    private String cineName;

    private String cineProvince;

    private String cineCity;

    private String cineArea;

    private String cineAddress;

    private Date creatTime;

    private Date updateTime;


}