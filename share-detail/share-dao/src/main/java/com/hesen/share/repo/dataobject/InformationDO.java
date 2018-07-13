package com.hesen.share.repo.dataobject;

import java.util.Date;

/**
 * The table H_INFORMATION
 */
public class InformationDO{

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
     * version 版本.
     */
    private Integer version;
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
     * createTime 创建时间.
     */
    private Long createTime;
    /**
     * createUser 创建人.
     */
    private String createUser;
    /**
     * deleteFlag 删除标记(N正常 Y删除).
     */
    private String deleteFlag;
    /**
     * reportTime 发布时间.
     */
    private Date reportTime;
    /**
     * updateTime 更新时间.
     */
    private Long updateTime;
    /**
     * updateUser 更新人.
     */
    private String updateUser;

    /**
     * Set id ID.
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public String getId(){
        return id;
    }

    /**
     * Set orders 排序.
     */
    public void setOrders(Integer orders){
        this.orders = orders;
    }

    /**
     * Get orders 排序.
     *
     * @return the string
     */
    public Integer getOrders(){
        return orders;
    }

    /**
     * Set infoUrl 资讯图片.
     */
    public void setInfoUrl(String infoUrl){
        this.infoUrl = infoUrl;
    }

    /**
     * Get infoUrl 资讯图片.
     *
     * @return the string
     */
    public String getInfoUrl(){
        return infoUrl;
    }

    /**
     * Set version 版本.
     */
    public void setVersion(Integer version){
        this.version = version;
    }

    /**
     * Get version 版本.
     *
     * @return the string
     */
    public Integer getVersion(){
        return version;
    }

    /**
     * Set downTime 下架时间.
     */
    public void setDownTime(Date downTime){
        this.downTime = downTime;
    }

    /**
     * Get downTime 下架时间.
     *
     * @return the string
     */
    public Date getDownTime(){
        return downTime;
    }

    /**
     * Set infoType 资讯类型.
     */
    public void setInfoType(Integer infoType){
        this.infoType = infoType;
    }

    /**
     * Get infoType 资讯类型.
     *
     * @return the string
     */
    public Integer getInfoType(){
        return infoType;
    }

    /**
     * Set infoTitle 资讯标题.
     */
    public void setInfoTitle(String infoTitle){
        this.infoTitle = infoTitle;
    }

    /**
     * Get infoTitle 资讯标题.
     *
     * @return the string
     */
    public String getInfoTitle(){
        return infoTitle;
    }

    /**
     * Set reportSts 发布状态(0待发布 1已发布).
     */
    public void setReportSts(Integer reportSts){
        this.reportSts = reportSts;
    }

    /**
     * Get reportSts 发布状态(0待发布 1已发布).
     *
     * @return the string
     */
    public Integer getReportSts(){
        return reportSts;
    }

    /**
     * Set createTime 创建时间.
     */
    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime 创建时间.
     *
     * @return the string
     */
    public Long getCreateTime(){
        return createTime;
    }

    /**
     * Set createUser 创建人.
     */
    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }

    /**
     * Get createUser 创建人.
     *
     * @return the string
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * Set deleteFlag 删除标记(N正常 Y删除).
     */
    public void setDeleteFlag(String deleteFlag){
        this.deleteFlag = deleteFlag;
    }

    /**
     * Get deleteFlag 删除标记(N正常 Y删除).
     *
     * @return the string
     */
    public String getDeleteFlag(){
        return deleteFlag;
    }

    /**
     * Set reportTime 发布时间.
     */
    public void setReportTime(Date reportTime){
        this.reportTime = reportTime;
    }

    /**
     * Get reportTime 发布时间.
     *
     * @return the string
     */
    public Date getReportTime(){
        return reportTime;
    }

    /**
     * Set updateTime 更新时间.
     */
    public void setUpdateTime(Long updateTime){
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime 更新时间.
     *
     * @return the string
     */
    public Long getUpdateTime(){
        return updateTime;
    }

    /**
     * Set updateUser 更新人.
     */
    public void setUpdateUser(String updateUser){
        this.updateUser = updateUser;
    }

    /**
     * Get updateUser 更新人.
     *
     * @return the string
     */
    public String getUpdateUser(){
        return updateUser;
    }
}
