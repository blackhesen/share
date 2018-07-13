package com.hesen.share.domain.result;

import java.util.Date;

/**
 * The table H_INFORMATION
 */
public class InformationDTO {

    /**
     * id ID.
     */
    private String id;
    /**
     * orders 排序.
     */
    private Integer orders;
    /**
     * infoUrl 资讯图片.
     */
    private String infoUrl;
    /**
     * downTime 下架时间.
     */
    private Date downTime;
    /**
     * infoType 资讯类型.
     */
    private Integer infoType;
    /**
     * infoTitle 资讯标题.
     */
    private String infoTitle;
    /**
     * reportSts 发布状态(0待发布 1已发布).
     */
    private Integer reportSts;
    /**
     * reportTime 发布时间.
     */
    private Date reportTime;

    public String getId() {
        return id;
    }

    public InformationDTO setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getOrders() {
        return orders;
    }

    public InformationDTO setOrders(Integer orders) {
        this.orders = orders;
        return this;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public InformationDTO setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
        return this;
    }

    public Date getDownTime() {
        return downTime;
    }

    public InformationDTO setDownTime(Date downTime) {
        this.downTime = downTime;
        return this;
    }

    public Integer getInfoType() {
        return infoType;
    }

    public InformationDTO setInfoType(Integer infoType) {
        this.infoType = infoType;
        return this;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public InformationDTO setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
        return this;
    }

    public Integer getReportSts() {
        return reportSts;
    }

    public InformationDTO setReportSts(Integer reportSts) {
        this.reportSts = reportSts;
        return this;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public InformationDTO setReportTime(Date reportTime) {
        this.reportTime = reportTime;
        return this;
    }
}
