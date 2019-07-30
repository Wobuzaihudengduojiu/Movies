package pojo.VO;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserVO {
    private Integer userid;

    private String userName;

    private String userEmail;

    private Integer userClass;

    private Date creatTime;

    private Date updateTime;
}
