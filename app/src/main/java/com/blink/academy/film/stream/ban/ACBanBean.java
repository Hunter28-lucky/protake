package com.blink.academy.film.stream.ban;

/* loaded from: classes.dex */
public class ACBanBean {
    private long db_id;
    private String name;
    private String suffix;
    private String uuid;

    public ACBanBean(long j, String str, String str2, String str3) {
        this.db_id = j;
        this.uuid = str;
        this.name = str2;
        this.suffix = str3;
    }

    public long getDb_id() {
        return this.db_id;
    }

    public String getName() {
        return this.name;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setDb_id(long j) {
        this.db_id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public ACBanBean() {
    }
}
