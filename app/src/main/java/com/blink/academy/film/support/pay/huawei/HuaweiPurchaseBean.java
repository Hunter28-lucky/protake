package com.blink.academy.film.support.pay.huawei;

/* loaded from: classes.dex */
public class HuaweiPurchaseBean {
    private String signature;
    private String signedData;

    public String getSignature() {
        return this.signature;
    }

    public String getSignedData() {
        return this.signedData;
    }

    public HuaweiPurchaseBean setSignature(String str) {
        this.signature = str;
        return this;
    }

    public HuaweiPurchaseBean setSignedData(String str) {
        this.signedData = str;
        return this;
    }
}
