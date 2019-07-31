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
public class Comment {
    private Integer comId;

    private Integer userId;

    private Integer movId;

    private String comContent;

    private Date creatTime;

    private Date updateTime;

}