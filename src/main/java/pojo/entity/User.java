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
public class User {
    private Integer userid;

    private String userName;

    private String userPwd;

    private String userEmail;

    private Integer userClass;

    private Date creatTime;

    private Date updateTime;

    
}