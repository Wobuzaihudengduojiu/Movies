package pojo.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dictionary {
    private Integer dictId;

    private Integer movId;

    private Integer cineId;

    private Date dictStartTime;

    private Date dictEndTime;

    private Integer dictHall;

    private BigDecimal dictPrice;

    private String dictSeat;

    private Date creatTime;

    private Date updateTime;

}