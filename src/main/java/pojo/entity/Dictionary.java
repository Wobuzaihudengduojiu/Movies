package pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary {

    private Integer dictId;

    private Integer movId;

    private Integer cineId;

    private Date dictStartTime;

    private Date dictEndTime;

    private String dictHall;

    private BigDecimal dictPrice;

    private String dictSeat;

    private Date creatTime;

    private Date updateTime;

}