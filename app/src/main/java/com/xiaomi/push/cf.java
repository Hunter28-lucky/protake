package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* loaded from: classes2.dex */
public final class cf {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private String f5659a;

    public cf(String str, int i) {
        this.f5659a = str;
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public String toString() {
        if (this.a <= 0) {
            return this.f5659a;
        }
        return this.f5659a + Constants.COLON_SEPARATOR + this.a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5291a() {
        return this.f5659a;
    }

    public static cf a(String str, int i) throws NumberFormatException {
        int iLastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (iLastIndexOf != -1) {
            String strSubstring = str.substring(0, iLastIndexOf);
            try {
                int i2 = Integer.parseInt(str.substring(iLastIndexOf + 1));
                if (i2 > 0) {
                    i = i2;
                }
            } catch (NumberFormatException unused) {
            }
            str = strSubstring;
        }
        return new cf(str, i);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m5290a(String str, int i) throws NumberFormatException {
        cf cfVarA = a(str, i);
        return new InetSocketAddress(cfVarA.m5291a(), cfVarA.a());
    }
}
