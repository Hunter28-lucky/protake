package com.blink.academy.film.netbean.store;

/* loaded from: classes.dex */
public class NvtInfoCallbackEntity {
    private long available_monitoring_time;
    private long balance;
    private String client_nonce;
    private boolean receive_award;
    private String server_nonce;
    private long timestamp;

    public long getAvailable_monitoring_time() {
        return this.available_monitoring_time;
    }

    public long getBalance() {
        return this.balance;
    }

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public String getServer_nonce() {
        return this.server_nonce;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isReceive_award() {
        return this.receive_award;
    }

    public void setAvailable_monitoring_time(long j) {
        this.available_monitoring_time = j;
    }

    public void setBalance(long j) {
        this.balance = j;
    }

    public void setClient_nonce(String str) {
        this.client_nonce = str;
    }

    public void setReceive_award(boolean z) {
        this.receive_award = z;
    }

    public void setServer_nonce(String str) {
        this.server_nonce = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
