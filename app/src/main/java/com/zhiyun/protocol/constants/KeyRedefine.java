package com.zhiyun.protocol.constants;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class KeyRedefine {
    private int KeyValue;
    private int[] keyEvents;
    private int keyGroup;
    private int keyType;

    public int[] getKeyEvents() {
        return this.keyEvents;
    }

    public int getKeyGroup() {
        return this.keyGroup;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public int getKeyValue() {
        return this.KeyValue;
    }

    public void setKeyEvents(int... iArr) {
        this.keyEvents = iArr;
    }

    public void setKeyGroup(int i) {
        this.keyGroup = i;
    }

    public void setKeyType(int i) {
        this.keyType = i;
    }

    public void setKeyValue(int i) {
        this.KeyValue = i;
    }

    public String toString() {
        return "KeyRedefine{keyType=" + this.keyType + ", keyGroup=" + this.keyGroup + ", KeyValue=" + this.KeyValue + ", keyEvents=" + Arrays.toString(this.keyEvents) + '}';
    }
}
