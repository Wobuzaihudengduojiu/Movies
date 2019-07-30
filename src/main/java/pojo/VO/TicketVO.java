package pojo.VO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 用于显示电影票详细信息和查询电影票记录
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TicketVO {

    private Integer tkStatus;

    private String dictHall;

    private Date dictStartTime;

    private Date dickEndTime;

    private String cineAddress;

    private Integer userId;

    private Integer movId;

    private String movName;

    /**
     * 一次买的总数
     */
    private Integer total;

    /**
     * 座位连排
     */
    private String dictSeat;

    /**
     * 剧照
     */
    private String image;

    /**
     * 支付记录
     */
    private String payRecord;


}
