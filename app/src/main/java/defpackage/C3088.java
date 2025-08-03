package defpackage;

import android.app.Activity;
import android.os.Build;

/* compiled from: DisplayCutoutSupport.java */
/* renamed from: һ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3088 implements InterfaceC3463 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C3088 f10973;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public InterfaceC3463 f10974;

    public C3088() {
        int i = Build.VERSION.SDK_INT;
        C4638.m14098(String.format("Build.VERSION.SDK_INT : %s ", Integer.valueOf(i)));
        if (i >= 27) {
            this.f10974 = new C3919();
        } else {
            this.f10974 = new C4713();
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static InterfaceC3463 m10679() {
        if (f10973 == null) {
            synchronized (C3088.class) {
                if (f10973 == null) {
                    f10973 = new C3088();
                }
            }
        }
        return f10973;
    }

    @Override // defpackage.InterfaceC3463
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo10680(Activity activity) {
        this.f10974.mo10680(activity);
    }
}
