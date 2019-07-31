package pojo.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel (value = "电影院实体类")
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