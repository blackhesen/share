package com.hesen.share.common.res;


import java.util.List;

/**
 * @Author Hesen
 * @Date   2018/4/20 15:58
 */
public class JsonListResponse<T> extends JsonBaseResponse {

    private List<T> data;

    public JsonListResponse() {
        super();
    }

    public JsonListResponse(Integer code) {
        super(code);
    }

    public JsonListResponse(Integer code, String errmsg) {
        super(code, errmsg);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
