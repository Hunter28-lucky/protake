package defpackage;

import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.support.pay.google.GooglePayHelper;
import com.blink.academy.film.support.pay.huawei.HuaweiPay;
import java.util.List;

/* compiled from: PayHelper.java */
/* renamed from: ဿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5145 implements InterfaceC4183 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4183 f17076;

    public C5145(int i, Activity activity) {
        if (i == 1) {
            this.f17076 = new C3980(activity);
            return;
        }
        if (i == 2) {
            this.f17076 = new GooglePayHelper(activity);
            return;
        }
        if (i == 3) {
            this.f17076 = new z7(activity);
        } else if (i != 4) {
            this.f17076 = null;
        } else {
            this.f17076 = new HuaweiPay(activity);
        }
    }

    @Override // defpackage.InterfaceC4183
    public void destroy() {
        InterfaceC4183 interfaceC4183 = this.f17076;
        if (interfaceC4183 != null) {
            interfaceC4183.destroy();
        }
    }

    @Override // defpackage.InterfaceC4183
    public void startPay(String str, InterfaceC4533 interfaceC4533, boolean z, boolean z2) {
        InterfaceC4183 interfaceC4183 = this.f17076;
        if (interfaceC4183 != null) {
            interfaceC4183.startPay(str, interfaceC4533, z, z2);
        } else if (interfaceC4533 != null) {
            interfaceC4533.mo13876(str, "not valid PayType");
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m15055(List<Purchase> list, InterfaceC3866 interfaceC3866) {
        InterfaceC4183 interfaceC4183 = this.f17076;
        if (interfaceC4183 instanceof GooglePayHelper) {
            ((GooglePayHelper) interfaceC4183).checkInAppsPurchase(list, interfaceC3866);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m15056(String str, InterfaceC4875 interfaceC4875) {
        InterfaceC4183 interfaceC4183 = this.f17076;
        if (interfaceC4183 instanceof GooglePayHelper) {
            ((GooglePayHelper) interfaceC4183).checkIfHasSubHistory(str, interfaceC4875);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m15057(boolean z, InterfaceC4886 interfaceC4886) {
        InterfaceC4183 interfaceC4183 = this.f17076;
        if (interfaceC4183 instanceof GooglePayHelper) {
            ((GooglePayHelper) interfaceC4183).queryPurchases(z, interfaceC4886);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m15058(String str, InterfaceC4533 interfaceC4533) {
        startPay(str, interfaceC4533, false, false);
    }
}
