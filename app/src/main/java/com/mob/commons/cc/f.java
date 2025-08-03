package com.mob.commons.cc;

import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

/* loaded from: classes2.dex */
public class f {
    private final SharePrefrenceHelper a;

    public f(String str, int i) {
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.a = sharePrefrenceHelper;
        sharePrefrenceHelper.open(str, i);
    }

    public void a(String str, long j) {
        this.a.putLong(str, Long.valueOf(j));
    }

    public long b(String str, long j) {
        return this.a.getLong(str, j);
    }

    public void a(String str, int i) {
        this.a.putInt(str, Integer.valueOf(i));
    }

    public int b(String str, int i) {
        return this.a.getInt(str, i);
    }

    public void a(String str, boolean z) {
        this.a.putBoolean(str, Boolean.valueOf(z));
    }

    public boolean b(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            this.a.remove(str);
        } else {
            this.a.putString(str, str2);
        }
    }

    public String b(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public Object a(String str) {
        return this.a.get(str);
    }
}
