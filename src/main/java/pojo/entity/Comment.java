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
public class Comment {
    private Integer comId;

    private Integer userId;

    private Integer movId;

    private String comContent;

    private Date creatTime;

    private Date updateTime;


}