package com.mob.pushsdk;

import com.mob.tools.proguard.ClassKeeper;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MobPushNotifyMessage implements ClassKeeper, Serializable {
    public static final int CHANNEL_FCM = 4;
    public static final int CHANNEL_HUAWEI = 1;
    public static final int CHANNEL_MEIZU = 3;
    public static final int CHANNEL_MOBPUSH = 0;
    public static final int CHANNEL_VIVO = 5;
    public static final int CHANNEL_XIAOMI = 2;
    public static final int STYLE_BIG_PICTURE = 2;
    public static final int STYLE_BIG_TEXT = 1;
    public static final int STYLE_INBOX = 3;
    public static final int STYLE_NORMAL = 0;
    private int androidBadge;
    private int androidBadgeType;
    private String androidChannelId;
    private int channel;
    private String content;
    private String dropId;
    private int dropType;
    private HashMap<String, String> extrasMap;
    private String icon;
    private String iconColor;
    private String iconPath;
    private String image;
    private String imagePath;
    private String[] inboxStyleContent;
    private boolean isGuardMsg;
    private boolean light;
    private String messageId;
    private String mobNotifyId;
    private String notifySound;
    private int offlineFlag;
    private boolean shake;
    private int style;
    private String styleContent;
    private long timestamp;
    private String title;
    private boolean voice;

    public MobPushNotifyMessage() {
        this.voice = true;
        this.shake = true;
        this.light = true;
        this.isGuardMsg = false;
    }

    public int getAndroidBadge() {
        return this.androidBadge;
    }

    public int getAndroidBadgeType() {
        return this.androidBadgeType;
    }

    public String getAndroidChannelId() {
        return this.androidChannelId;
    }

    public int getChannel() {
        return this.channel;
    }

    public String getContent() {
        return this.content;
    }

    public String getDropId() {
        return this.dropId;
    }

    public int getDropType() {
        return this.dropType;
    }

    public HashMap<String, String> getExtrasMap() {
        return this.extrasMap;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIconColor() {
        return this.iconColor;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getImage() {
        return this.image;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public String[] getInboxStyleContent() {
        return this.inboxStyleContent;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMobNotifyId() {
        return this.mobNotifyId;
    }

    public String getNotifySound() {
        return this.notifySound;
    }

    public int getOfflineFlag() {
        return this.offlineFlag;
    }

    public int getStyle() {
        return this.style;
    }

    public String getStyleContent() {
        return this.styleContent;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isGuardMsg() {
        return this.isGuardMsg;
    }

    public boolean isLight() {
        return this.light;
    }

    public boolean isShake() {
        return this.shake;
    }

    public boolean isVoice() {
        return this.voice;
    }

    public void setAndroidBadge(int i) {
        this.androidBadge = i;
    }

    public void setAndroidBadgeType(int i) {
        this.androidBadgeType = i;
    }

    public void setAndroidChannelId(String str) {
        this.androidChannelId = str;
    }

    public void setChannel(int i) {
        this.channel = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDropId(String str) {
        this.dropId = str;
    }

    public void setDropType(int i) {
        this.dropType = i;
    }

    public void setExtrasMap(HashMap<String, String> map) {
        this.extrasMap = map;
    }

    public void setGuardMsg(boolean z) {
        this.isGuardMsg = z;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconColor(String str) {
        this.iconColor = str;
    }

    public void setIconPath(String str) {
        this.iconPath = str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public void setInboxStyleContent(String[] strArr) {
        this.inboxStyleContent = strArr;
    }

    public void setLight(boolean z) {
        this.light = z;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMobNotifyId(String str) {
        this.mobNotifyId = str;
    }

    public void setNotifySound(String str) {
        this.notifySound = str;
    }

    public void setOfflineFlag(int i) {
        this.offlineFlag = i;
    }

    public void setShake(boolean z) {
        this.shake = z;
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setStyleContent(String str) {
        this.styleContent = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVoice(boolean z) {
        this.voice = z;
    }

    public String toString() {
        return "MobPushNotifyMessage{style=" + this.style + ", title='" + this.title + "', content='" + this.content + "', styleContent='" + this.styleContent + "', inboxStyleContent=" + Arrays.toString(this.inboxStyleContent) + ", extrasMap=" + this.extrasMap + ", messageId='" + this.messageId + "', timestamp=" + this.timestamp + ", voice=" + this.voice + ", shake=" + this.shake + ", light=" + this.light + ", channel=" + this.channel + ", notifySound='" + this.notifySound + "', dropType=" + this.dropType + ", dropId='" + this.dropId + "', mobNotifyId='" + this.mobNotifyId + "', offlineFlag=" + this.offlineFlag + ", isGuardMsg=" + this.isGuardMsg + ", icon='" + this.icon + "', image='" + this.image + "', androidBadgeType=" + this.androidBadgeType + ", androidBadge=" + this.androidBadge + ", androidChannelId='" + this.androidChannelId + "'}";
    }

    public MobPushNotifyMessage(int i, String str, String str2, String str3, String[] strArr, HashMap<String, String> map, String str4, long j, boolean z, boolean z2, boolean z3) {
        this.isGuardMsg = false;
        this.style = i;
        this.title = str;
        this.content = str2;
        this.styleContent = str3;
        this.inboxStyleContent = strArr;
        this.extrasMap = map;
        this.messageId = str4;
        this.timestamp = j;
        this.voice = z;
        this.shake = z2;
        this.light = z3;
    }
}
