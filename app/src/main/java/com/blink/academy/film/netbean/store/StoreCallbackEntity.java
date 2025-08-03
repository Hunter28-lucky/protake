package com.blink.academy.film.netbean.store;

import java.util.List;

/* loaded from: classes.dex */
public class StoreCallbackEntity {
    private String client_nonce;
    private long current_user_id;
    private List<FilterGroupCollectionBean> filter_group_collections;
    private List<FilterGroupBean> filter_groups;
    private List<FilterBean> filters;
    private String server_nonce;
    private boolean subscription_is_valid;
    private long timestamp;

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public long getCurrent_user_id() {
        return this.current_user_id;
    }

    public List<FilterGroupCollectionBean> getFilter_group_collections() {
        return this.filter_group_collections;
    }

    public List<FilterGroupBean> getFilter_groups() {
        return this.filter_groups;
    }

    public List<FilterBean> getFilters() {
        return this.filters;
    }

    public String getServer_nonce() {
        return this.server_nonce;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isSubscription_is_valid() {
        return this.subscription_is_valid;
    }

    public void setClient_nonce(String str) {
        this.client_nonce = str;
    }

    public void setCurrent_user_id(long j) {
        this.current_user_id = j;
    }

    public StoreCallbackEntity setFilter_group_collections(List<FilterGroupCollectionBean> list) {
        this.filter_group_collections = list;
        return this;
    }

    public void setFilter_groups(List<FilterGroupBean> list) {
        this.filter_groups = list;
    }

    public void setFilters(List<FilterBean> list) {
        this.filters = list;
    }

    public void setServer_nonce(String str) {
        this.server_nonce = str;
    }

    public void setSubscription_is_valid(boolean z) {
        this.subscription_is_valid = z;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
