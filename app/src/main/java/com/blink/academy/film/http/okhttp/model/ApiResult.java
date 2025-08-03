package com.blink.academy.film.http.okhttp.model;

/* loaded from: classes.dex */
public class ApiResult<T> {
    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isOk() {
        return this.code == 0;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "ApiResult{code='" + this.code + "', msg='" + this.msg + "', data=" + this.data + '}';
    }
}
