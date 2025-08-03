package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* compiled from: Android10Platform.kt */
/* renamed from: ࢲ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3988 extends C2708 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final boolean f13938;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C3989 f13939 = new C3989(null);

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<InterfaceC4233> f13940;

    /* compiled from: Android10Platform.kt */
    /* renamed from: ࢲ$Ϳ, reason: contains not printable characters */
    public static final class C3989 {
        public C3989() {
        }

        public /* synthetic */ C3989(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2708 m12853() {
            if (m12854()) {
                return new C3988();
            }
            return null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m12854() {
            return C3988.f13938;
        }
    }

    static {
        f13938 = C2708.f10025.m9965() && Build.VERSION.SDK_INT >= 29;
    }

    public C3988() {
        List listM10715 = C3131.m10715(C3990.f13941.m12855(), new C4453(C4003.f13958.m12873()), new C4453(C2694.f9997.m9922()), new C4453(C2357.f8900.m8824()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM10715) {
            if (((InterfaceC4233) obj).mo8819()) {
                arrayList.add(obj);
            }
        }
        this.f13940 = arrayList;
    }

    @Override // defpackage.C2708
    /* renamed from: ԩ */
    public AbstractC2918 mo9949(X509TrustManager x509TrustManager) {
        C3921.m12667(x509TrustManager, "trustManager");
        C3992 c3992M12857 = C3992.f13942.m12857(x509TrustManager);
        return c3992M12857 != null ? c3992M12857 : super.mo9949(x509TrustManager);
    }

    @Override // defpackage.C2708
    /* renamed from: ԫ */
    public void mo8811(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        Object next;
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        Iterator<T> it = this.f13940.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((InterfaceC4233) next).mo8818(sSLSocket)) {
                    break;
                }
            }
        }
        InterfaceC4233 interfaceC4233 = (InterfaceC4233) next;
        if (interfaceC4233 != null) {
            interfaceC4233.mo8821(sSLSocket, str, list);
        }
    }

    @Override // defpackage.C2708
    /* renamed from: Ԯ */
    public String mo8812(SSLSocket sSLSocket) {
        Object next;
        C3921.m12667(sSLSocket, "sslSocket");
        Iterator<T> it = this.f13940.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((InterfaceC4233) next).mo8818(sSLSocket)) {
                break;
            }
        }
        InterfaceC4233 interfaceC4233 = (InterfaceC4233) next;
        if (interfaceC4233 != null) {
            return interfaceC4233.mo8820(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.C2708
    @SuppressLint({"NewApi"})
    /* renamed from: ՠ */
    public boolean mo9954(String str) {
        C3921.m12667(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
