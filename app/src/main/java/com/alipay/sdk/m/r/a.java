package com.alipay.sdk.m.r;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;

/* loaded from: classes.dex */
public enum a {
    None(Constants.CP_NONE),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");

    public String a;

    a(String str) {
        this.a = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        for (a aVar2 : values()) {
            if (str.startsWith(aVar2.a)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
