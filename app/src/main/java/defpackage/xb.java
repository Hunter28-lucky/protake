package defpackage;

import android.content.Context;

/* loaded from: classes.dex */
public class xb implements x9 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static x9 f8740;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static jb f8741;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static x9 m8600(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f8740 == null) {
            f8741 = bf.m169(context, str);
            f8740 = new xb();
        }
        return f8740;
    }

    @Override // defpackage.x9
    public boolean logCollect(String str) {
        return f8741.logCollect(str);
    }

    @Override // defpackage.x9
    /* renamed from: Ϳ */
    public be mo8595(df dfVar) {
        return wb.m8525(f8741.mo7110(wb.m8526(dfVar)));
    }
}
