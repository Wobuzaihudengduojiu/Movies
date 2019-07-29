package pojo.entity;

import java.util.Date;

public class Cinema {
    private Integer cineId;

    private String cineName;

    private String cineProvince;

    private String cineCity;

    private String cineArea;

    private String cineAddress;

    private Date creatTime;

    private Date updateTime;

    public Integer getCineId() {
        return cineId;
    }

    public void setCineId(Integer cineId) {
        this.cineId = cineId;
    }

    public String getCineName() {
        return cineName;
    }

    public void setCineName(String cineName) {
        this.cineName = cineName == null ? null : cineName.trim();
    }

    public String getCineProvince() {
        return cineProvince;
    }

    public void setCineProvince(String cineProvince) {
        this.cineProvince = cineProvince == null ? null : cineProvince.trim();
    }

    public String getCineCity() {
        return cineCity;
    }

    public void setCineCity(String cineCity) {
        this.cineCity = cineCity == null ? null : cineCity.trim();
    }

    public String getCineArea() {
        return cineArea;
    }

    public void setCineArea(String cineArea) {
        this.cineArea = cineArea == null ? null : cineArea.trim();
    }

    public String getCineAddress() {
        return cineAddress;
    }

    public void setCineAddress(String cineAddress) {
        this.cineAddress = cineAddress == null ? null : cineAddress.trim();
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