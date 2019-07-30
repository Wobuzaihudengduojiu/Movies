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

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public String getMovName() {
        return movName;
    }

    public void setMovName(String movName) {
        this.movName = movName == null ? null : movName.trim();
    }

    public String getMovDescription() {
        return movDescription;
    }

    public void setMovDescription(String movDescription) {
        this.movDescription = movDescription == null ? null : movDescription.trim();
    }

    public String getMovType() {
        return movType;
    }

    public void setMovType(String movType) {
        this.movType = movType == null ? null : movType.trim();
    }

    public Integer getMovStatus() {
        return movStatus;
    }

    public void setMovStatus(Integer movStatus) {
        this.movStatus = movStatus;
    }

    public Integer getMovLastTime() {
        return movLastTime;
    }

    public void setMovLastTime(Integer movLastTime) {
        this.movLastTime = movLastTime;
    }

    public String getMovDirector() {
        return movDirector;
    }

    public void setMovDirector(String movDirector) {
        this.movDirector = movDirector == null ? null : movDirector.trim();
    }

    public Double getMovCore() {
        return movCore;
    }

    public void setMovCore(Double movCore) {
        this.movCore = movCore;
    }

    public Date getMovReleaseTime() {
        return movReleaseTime;
    }

    public void setMovReleaseTime(Date movReleaseTime) {
        this.movReleaseTime = movReleaseTime;
    }

    public String getMovActor() {
        return movActor;
    }

    public void setMovActor(String movActor) {
        this.movActor = movActor == null ? null : movActor.trim();
    }

    public Integer getMovIsCome() {
        return movIsCome;
    }

    public void setMovIsCome(Integer movIsCome) {
        this.movIsCome = movIsCome;
    }

    public Integer getMovIsHot() {
        return movIsHot;
    }

    public void setMovIsHot(Integer movIsHot) {
        this.movIsHot = movIsHot;
    }

    public String getMovImage() {
        return movImage;
    }

    public void setMovImage(String movImage) {
        this.movImage = movImage == null ? null : movImage.trim();
    }

    public String getMovPhotos() {
        return movPhotos;
    }

    public void setMovPhotos(String movPhotos) {
        this.movPhotos = movPhotos == null ? null : movPhotos.trim();
    }

    public String getMovArea() {
        return movArea;
    }

    public void setMovArea(String movArea) {
        this.movArea = movArea == null ? null : movArea.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}