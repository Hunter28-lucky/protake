package com.blink.academy.film.netbean.store;

import java.util.List;

/* loaded from: classes.dex */
public class NvtProductListCallbackEntity {
    private String client_nonce;
    private List<NvtProductItem> items;
    private String server_nonce;
    private long timestamp;

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public List<NvtProductItem> getItems() {
        return this.items;
    }

    public String getServer_nonce() {
        return this.server_nonce;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setClient_nonce(String str) {
        this.client_nonce = str;
    }

    public void setItems(List<NvtProductItem> list) {
        this.items = list;
    }

    public void setServer_nonce(String str) {
        this.server_nonce = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
