package com.mob.socketservice;

import com.mob.tools.proguard.ClassKeeper;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class ServiceMessageData implements ClassKeeper, Serializable {
    private static final long serialVersionUID = -2803395666058828237L;
    private String appKey;
    private String appSecret;
    private String guardId;
    private String rid;
    private HashMap<String, Object> tokenMap;
    private HashMap<Integer, String> typeMap;

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public String getGuardId() {
        return this.guardId;
    }

    public String getRid() {
        return this.rid;
    }

    public HashMap<String, Object> getTokenMap() {
        return this.tokenMap;
    }

    public HashMap<Integer, String> getTypeMap() {
        return this.typeMap;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setAppSecret(String str) {
        this.appSecret = str;
    }

    public void setGuardId(String str) {
        this.guardId = str;
    }

    public void setRid(String str) {
        this.rid = str;
    }

    public void setTokenMap(HashMap<String, Object> map) {
        this.tokenMap = map;
    }

    public void setTypeMap(HashMap<Integer, String> map) {
        this.typeMap = map;
    }

    public String toString() {
        return "rid={" + this.rid + "},guardId={" + this.guardId + "},typeMap={" + this.typeMap + "},tokenMap={" + this.tokenMap + "}";
    }
}
