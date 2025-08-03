package com.blink.academy.film.netbean.srt;

/* loaded from: classes.dex */
public class SRTConnectionRoomIdCallbackEntity {
    private String client_nonce;
    private long expire_at;
    private String server_nonce;
    private String srt_room_id;
    private long timestamp;

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public long getExpire_at() {
        return this.expire_at;
    }

    public String getServer_nonce() {
        return this.server_nonce;
    }

    public String getSrt_room_id() {
        return this.srt_room_id;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setClient_nonce(String str) {
        this.client_nonce = str;
    }

    public void setExpire_at(long j) {
        this.expire_at = j;
    }

    public void setServer_nonce(String str) {
        this.server_nonce = str;
    }

    public void setSrt_room_id(String str) {
        this.srt_room_id = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
