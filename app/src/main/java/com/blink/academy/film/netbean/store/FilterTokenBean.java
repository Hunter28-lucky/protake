package com.blink.academy.film.netbean.store;

/* loaded from: classes.dex */
public class FilterTokenBean {
    private String download_sign;
    private String download_sign_timeout;
    private int file_id;

    public String getDownload_sign() {
        return this.download_sign;
    }

    public String getDownload_sign_timeout() {
        return this.download_sign_timeout;
    }

    public int getFile_id() {
        return this.file_id;
    }

    public FilterTokenBean setDownload_sign(String str) {
        this.download_sign = str;
        return this;
    }

    public FilterTokenBean setDownload_sign_timeout(String str) {
        this.download_sign_timeout = str;
        return this;
    }

    public FilterTokenBean setFile_id(int i) {
        this.file_id = i;
        return this;
    }
}
