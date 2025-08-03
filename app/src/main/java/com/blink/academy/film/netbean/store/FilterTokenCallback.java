package com.blink.academy.film.netbean.store;

import java.util.List;

/* loaded from: classes.dex */
public class FilterTokenCallback {
    private String client_nonce;
    private List<FilterTokenBean> download_signs;
    private int timestamp;

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public List<FilterTokenBean> getDownload_signs() {
        return this.download_signs;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public FilterTokenCallback setClient_nonce(String str) {
        this.client_nonce = str;
        return this;
    }

    public FilterTokenCallback setDownload_signs(List<FilterTokenBean> list) {
        this.download_signs = list;
        return this;
    }

    public FilterTokenCallback setTimestamp(int i) {
        this.timestamp = i;
        return this;
    }
}
