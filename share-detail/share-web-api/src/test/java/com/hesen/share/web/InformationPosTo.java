package com.hesen.share.web;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class InformationPosTo implements Serializable {

    public interface Add {
    }

    public interface Modify {
    }

    public interface Delete {
    }

    public interface QueryList {
    }

    public interface Query {
    }

    private String uuid;

    @NotBlank(message = "所属产业不能为空", groups = {InformationPosTo.Add.class, InformationPosTo.Modify.class})
    private String belongIndustry;

    @NotBlank(message = "位置编码不能为空", groups = {InformationPosTo.Add.class, InformationPosTo.Modify.class})
    @Length(message = "位置编码长度限制为50", max = 50, groups = {InformationPosTo.Add.class, InformationPosTo.Modify.class})
    private String positionNo;

    @NotBlank(message = "位置名称不能为空", groups = {InformationPosTo.Add.class, InformationPosTo.Modify.class})
    @Length(message = "位置名称长度限制为50", max = 50, groups = {InformationPosTo.Add.class, InformationPosTo.Modify.class})
    private String positionName;

    private String sketchImg;

    @Length(message = "备注长度限制为200", max = 200, groups = {InformationPosTo.Add.class, InformationPosTo.Modify.class})
    private String remarks;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBelongIndustry() {
        return belongIndustry;
    }

    public void setBelongIndustry(String belongIndustry) {
        this.belongIndustry = belongIndustry;
    }

    public String getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(String positionNo) {
        this.positionNo = positionNo;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getSketchImg() {
        return sketchImg;
    }

    public void setSketchImg(String sketchImg) {
        this.sketchImg = sketchImg;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
