package pojo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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