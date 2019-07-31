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
<<<<<<< HEAD
=======


>>>>>>> 85c1e1886c6bbd026b6dbf5089741a88bdd58139
}