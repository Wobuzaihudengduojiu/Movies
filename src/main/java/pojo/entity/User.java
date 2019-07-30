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
public class User {
    private Integer userid;

    private String userName;

    private String userPwd;

    private String userEmail;

    private Integer userClass;

    private Date creatTime;

    private Date updateTime;


}