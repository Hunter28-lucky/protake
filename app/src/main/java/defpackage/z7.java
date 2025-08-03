package defpackage;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.blink.academy.film.support.controller.StoreController;
import defpackage.t7;

/* compiled from: WechatPayHelper.java */
/* loaded from: classes.dex */
public final class z7 implements InterfaceC4183, t7.InterfaceC2286 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public t7 f8777;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC4533 f8778;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Activity f8779;

    public z7(Activity activity) {
        this.f8779 = activity;
        t7.m8289(activity, StoreController.WECHAT_APP_ID);
        this.f8777 = t7.m8288();
    }

    @Override // defpackage.InterfaceC4183
    public void destroy() {
        this.f8779 = null;
        this.f8777.m8291();
        this.f8777 = null;
        this.f8778 = null;
    }

    @Override // defpackage.t7.InterfaceC2286
    public void onSuccess(@Nullable String str) {
        InterfaceC4533 interfaceC4533 = this.f8778;
        if (interfaceC4533 != null) {
            interfaceC4533.mo13877("");
        }
    }

    @Override // defpackage.InterfaceC4183
    public void startPay(String str, InterfaceC4533 interfaceC4533, boolean z, boolean z2) {
        this.f8778 = interfaceC4533;
        this.f8777.m8292(str, this);
    }

    @Override // defpackage.t7.InterfaceC2286
    /* renamed from: Ϳ */
    public void mo8295(@Nullable String str) {
        InterfaceC4533 interfaceC4533 = this.f8778;
        if (interfaceC4533 != null) {
            interfaceC4533.mo13874("");
        }
    }

    @Override // defpackage.t7.InterfaceC2286
    /* renamed from: Ԩ */
    public void mo8296(@Nullable String str, int i) {
        InterfaceC4533 interfaceC4533 = this.f8778;
        if (interfaceC4533 != null) {
            interfaceC4533.mo13876("", String.valueOf(i));
        }
    }
}
