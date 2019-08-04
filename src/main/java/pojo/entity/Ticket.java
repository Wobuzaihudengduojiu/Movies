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
@ApiModel(value = "电影票实体类")
public class Ticket {

    private Integer tkId;

    private Integer tkStatus = 0;

    private String dictSeat;

    private String dictHall;

    private Date dictStartTime;

    private Date dickEndTime;

    private String cineAddress;

    private Integer userId;

    private Date creatTime;

    private Date updateTime;

    private Integer movId;
}