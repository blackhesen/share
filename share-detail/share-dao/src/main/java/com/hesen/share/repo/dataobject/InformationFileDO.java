package com.hesen.share.repo.dataobject;


/**
 * The table H_INFORMATION_FILE
 */
public class InformationFileDO{

    /**
     * id ID.
     */
    private String id;
    /**
     * infoId 资讯ID.
     */
    private String infoId;
    /**
     * orders 排序.
     */
    private Integer orders;
    /**
     * picUrl 附件URL.
     */
    private String picUrl;
    /**
     * version 版本.
     */
    private Integer version;
    /**
     * fileType 附件类型（图片-PIC）.
     */
    private String fileType;
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
     * Set infoId 资讯ID.
     */
    public void setInfoId(String infoId){
        this.infoId = infoId;
    }

    /**
     * Get infoId 资讯ID.
     *
     * @return the string
     */
    public String getInfoId(){
        return infoId;
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
     * Set picUrl 附件URL.
     */
    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }

    /**
     * Get picUrl 附件URL.
     *
     * @return the string
     */
    public String getPicUrl(){
        return picUrl;
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
     * Set fileType 附件类型（图片-PIC）.
     */
    public void setFileType(String fileType){
        this.fileType = fileType;
    }

    /**
     * Get fileType 附件类型（图片-PIC）.
     *
     * @return the string
     */
    public String getFileType(){
        return fileType;
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
