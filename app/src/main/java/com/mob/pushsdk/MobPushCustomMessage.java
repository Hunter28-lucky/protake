package com.mob.pushsdk;

import com.mob.tools.proguard.ClassKeeper;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MobPushCustomMessage implements ClassKeeper, Serializable {
    private String content;
    private HashMap<String, String> extrasMap;
    private String messageId;
    private int offlineFlag;
    private long timestamp;

    public MobPushCustomMessage(String str, HashMap<String, String> map, String str2, long j) {
        this.content = str;
        this.extrasMap = map;
        this.messageId = str2;
        this.timestamp = j;
    }

    public String getContent() {
        return this.content;
    }

    public HashMap<String, String> getExtrasMap() {
        return this.extrasMap;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getOfflineFlag() {
        return this.offlineFlag;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setExtrasMap(HashMap<String, String> map) {
        this.extrasMap = map;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setOfflineFlag(int i) {
        this.offlineFlag = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        return "messageId={" + this.messageId + "},content={" + this.content + "},offlineFlag={" + this.offlineFlag + "},extrasMap={" + this.extrasMap + "},timestamp={" + this.timestamp + "}";
    }
}
