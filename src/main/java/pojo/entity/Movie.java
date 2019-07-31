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
public class Movie {
    private Integer movId;

    private String movName;

    private String movDescription;

    private String movType;

    private Integer movStatus;

    private Integer movLastTime;

    private String movDirector;

    private Double movCore;

    private Date movReleaseTime;

    private String movActor;

    private Integer movIsCome;

    private Integer movIsHot;

    private String movImage;

    private String movPhotos;

    private String movArea;

    private Date creatTime;

    private Date updateTime;


}