package com.hesen.share.common.res;

import java.io.Serializable;

/**
 * @Author Hesen
 * @Date   2018/4/20 15:58
 */
public class JsonBaseResponse implements Serializable {

    private Integer code;

    private String errmsg;

    public JsonBaseResponse() {
        super();
    }

    public JsonBaseResponse(Integer code) {
        this.code = code;
    }

    public JsonBaseResponse(Integer code, String errmsg) {
        this.code = code;
        this.errmsg = errmsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Boolean success() {
        if (this.code == 0) {
            return true;
        }
        return false;
    }
}