package com.blink.academy.film.netbean.store;

/* loaded from: classes.dex */
public class NvtReceiveRewardCallbackEntity {
    private long award_amount;
    private long balance;
    private String client_nonce;
    private String server_nonce;
    private long timestamp;

    public long getAward_amount() {
        return this.award_amount;
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

    public void setAward_amount(long j) {
        this.award_amount = j;
    }

    public void setBalance(long j) {
        this.balance = j;
    }

    public void setClient_nonce(String str) {
        this.client_nonce = str;
    }

    public void setServer_nonce(String str) {
        this.server_nonce = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
