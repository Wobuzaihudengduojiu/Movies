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
public class Ticket {
    private Integer tkId;

    private Integer tkStatus;

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