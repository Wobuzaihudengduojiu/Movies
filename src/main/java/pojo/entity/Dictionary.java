package pojo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Dictionary {
    private Integer dictId;

    private Integer movId;

    private Integer cineId;

    private Date dictStartTime;

    private Date dictEndTime;

    private Integer dictHall;

    private BigDecimal dictPrice;

    private String dictSeat;

    private Date creatTime;

    private Date updateTime;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public Integer getCineId() {
        return cineId;
    }

    public void setCineId(Integer cineId) {
        this.cineId = cineId;
    }

    public Date getDictStartTime() {
        return dictStartTime;
    }

    public void setDictStartTime(Date dictStartTime) {
        this.dictStartTime = dictStartTime;
    }

    public Date getDictEndTime() {
        return dictEndTime;
    }

    public void setDictEndTime(Date dictEndTime) {
        this.dictEndTime = dictEndTime;
    }

    public Integer getDictHall() {
        return dictHall;
    }

    public void setDictHall(Integer dictHall) {
        this.dictHall = dictHall;
    }

    public BigDecimal getDictPrice() {
        return dictPrice;
    }

    public void setDictPrice(BigDecimal dictPrice) {
        this.dictPrice = dictPrice;
    }

    public String getDictSeat() {
        return dictSeat;
    }

    public void setDictSeat(String dictSeat) {
        this.dictSeat = dictSeat == null ? null : dictSeat.trim();
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