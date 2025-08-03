package defpackage;

import android.content.Context;
import android.os.Build;

/* compiled from: NotchLoader.java */
/* renamed from: ਢ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4257 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f14609;

    /* compiled from: NotchLoader.java */
    /* renamed from: ਢ$Ԩ, reason: contains not printable characters */
    public static class C4259 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C4257 f14610 = new C4257();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C4257 m13373() {
        return C4259.f14610;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m13374(Context context) {
        if (context == null) {
            return 0;
        }
        int i = this.f14609;
        if (i != -1) {
            return i;
        }
        if (Build.MODEL.equals("DE106")) {
            int iM9438 = C2579.m9438(27.0f);
            this.f14609 = iM9438;
            return iM9438;
        }
        if (C4482.m13739(context)) {
            int[] iArrM13738 = C4482.m13738(context);
            if (iArrM13738 != null && iArrM13738.length > 1) {
                this.f14609 = iArrM13738[1];
            }
        } else if (C4482.m13740(context)) {
            this.f14609 = 80;
        } else if (C4482.m13741(context)) {
            this.f14609 = C2579.m9438(27.0f);
        }
        if (this.f14609 == -1) {
            this.f14609 = 0;
        }
        return this.f14609;
    }

    public C4257() {
        this.f14609 = -1;
    }
}
