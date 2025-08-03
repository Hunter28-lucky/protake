package defpackage;

import android.app.Activity;
import androidx.annotation.Nullable;
import defpackage.C3981;

/* compiled from: AliPayHelper.java */
/* renamed from: ࢬ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3980 implements InterfaceC4183, C3981.InterfaceC3983 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C3981 f13920;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Activity f13921;

    /* renamed from: ԩ, reason: contains not printable characters */
    public InterfaceC4533 f13922;

    public C3980(Activity activity) {
        this.f13921 = activity;
        this.f13920 = new C3981(activity, this);
    }

    @Override // defpackage.InterfaceC4183
    public void destroy() {
        this.f13921 = null;
        this.f13920.m12842();
        this.f13920 = null;
    }

    @Override // defpackage.C3981.InterfaceC3983
    public void onSuccess(String str) {
        InterfaceC4533 interfaceC4533 = this.f13922;
        if (interfaceC4533 != null) {
            interfaceC4533.mo13877(str);
        }
    }

    @Override // defpackage.InterfaceC4183
    public void startPay(String str, InterfaceC4533 interfaceC4533, boolean z, boolean z2) {
        this.f13922 = interfaceC4533;
        this.f13920.m12843(str);
    }

    @Override // defpackage.C3981.InterfaceC3983
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo12837(String str) {
        InterfaceC4533 interfaceC4533 = this.f13922;
        if (interfaceC4533 != null) {
            interfaceC4533.mo13874(str);
        }
    }

    @Override // defpackage.C3981.InterfaceC3983
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo12838(@Nullable String str, int i) {
        InterfaceC4533 interfaceC4533 = this.f13922;
        if (interfaceC4533 != null) {
            interfaceC4533.mo13876(str, String.valueOf(i));
        }
    }

    @Override // defpackage.C3981.InterfaceC3983
    /* renamed from: ԩ, reason: contains not printable characters */
    public void mo12839(String str) {
        InterfaceC4533 interfaceC4533 = this.f13922;
        if (interfaceC4533 != null) {
            interfaceC4533.mo13875(str);
        }
    }
}
