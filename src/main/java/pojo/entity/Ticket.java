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