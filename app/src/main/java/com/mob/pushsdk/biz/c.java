package com.mob.pushsdk.biz;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class c {
    private static c b;
    private SharePrefrenceHelper a;
    private Object c = new Object();

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private void b() {
        if (this.a == null) {
            synchronized (this.c) {
                if (this.a == null) {
                    SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
                    this.a = sharePrefrenceHelper;
                    sharePrefrenceHelper.open("PUSH_SDK_pt", 1);
                }
            }
        }
    }

    public HashSet<String> a(String str) {
        HashSet<String> hashSet;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b();
        synchronized (this.c) {
            hashSet = (HashSet) this.a.get(str);
        }
        return hashSet;
    }

    public void a(String str, HashSet<String> hashSet) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b();
        synchronized (this.c) {
            if (hashSet == null) {
                this.a.remove(str);
            } else {
                this.a.put(str, hashSet);
            }
        }
    }
}
