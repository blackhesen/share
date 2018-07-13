package com.hesen.share.common.page;

import java.io.Serializable;

/**
 * @Author Hesen
 * @Date   2018/4/20 16:00
 */
public class PageDTO implements Serializable {

    private Object result;

    private Object page;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }
}