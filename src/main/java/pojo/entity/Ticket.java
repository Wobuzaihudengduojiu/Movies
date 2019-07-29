package pojo.entity;

import java.util.Date;

public class Ticket {
    private Integer tkId;

    private Integer tkStatus;

    private String dictSeat;

    private Integer dictHall;

    private String dictStartTime;

    private String cineAddress;

    private Integer userId;

    private Date creatTime;

    private Date updateTime;

    public Integer getTkId() {
        return tkId;
    }

    public void setTkId(Integer tkId) {
        this.tkId = tkId;
    }

    public Integer getTkStatus() {
        return tkStatus;
    }

    public void setTkStatus(Integer tkStatus) {
        this.tkStatus = tkStatus;
    }

    public String getDictSeat() {
        return dictSeat;
    }

    public void setDictSeat(String dictSeat) {
        this.dictSeat = dictSeat == null ? null : dictSeat.trim();
    }

    public Integer getDictHall() {
        return dictHall;
    }

    public void setDictHall(Integer dictHall) {
        this.dictHall = dictHall;
    }

    public String getDictStartTime() {
        return dictStartTime;
    }

    public void setDictStartTime(String dictStartTime) {
        this.dictStartTime = dictStartTime == null ? null : dictStartTime.trim();
    }

    public String getCineAddress() {
        return cineAddress;
    }

    public void setCineAddress(String cineAddress) {
        this.cineAddress = cineAddress == null ? null : cineAddress.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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