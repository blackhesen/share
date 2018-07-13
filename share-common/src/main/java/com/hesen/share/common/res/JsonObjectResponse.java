package com.hesen.share.common.res;

/**
 * JsonObjectResponse
 * Created by ShenHua on 2017/9/27.
 */
public class JsonObjectResponse<T> extends JsonBaseResponse {

    private T data;

    public JsonObjectResponse() {
        super();
    }

    public JsonObjectResponse(Integer code) {
        super(code);
    }

    public JsonObjectResponse(Integer code, String errmsg) {
        super(code, errmsg);
    }

    public JsonObjectResponse(Integer code, String errmsg, T data) {
        super(code, errmsg);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
