package defpackage;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import defpackage.g;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import okhttp3.Protocol;

/* compiled from: AndroidPlatform.kt */
/* renamed from: ࢹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3997 extends C2708 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final boolean f13949;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C3998 f13950 = new C3998(null);

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<InterfaceC4233> f13951;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C4920 f13952;

    /* compiled from: AndroidPlatform.kt */
    /* renamed from: ࢹ$Ϳ, reason: contains not printable characters */
    public static final class C3998 {
        public C3998() {
        }

        public /* synthetic */ C3998(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2708 m12865() {
            if (m12866()) {
                return new C3997();
            }
            return null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m12866() {
            return C3997.f13949;
        }
    }

    /* compiled from: AndroidPlatform.kt */
    /* renamed from: ࢹ$Ԩ, reason: contains not printable characters */
    public static final class C3999 implements q3 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final X509TrustManager f13953;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Method f13954;

        public C3999(X509TrustManager x509TrustManager, Method method) {
            C3921.m12667(x509TrustManager, "trustManager");
            C3921.m12667(method, "findByIssuerAndSignatureMethod");
            this.f13953 = x509TrustManager;
            this.f13954 = method;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C3999)) {
                return false;
            }
            C3999 c3999 = (C3999) obj;
            return C3921.m12662(this.f13953, c3999.f13953) && C3921.m12662(this.f13954, c3999.f13954);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f13953;
            int iHashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f13954;
            return iHashCode + (method != null ? method.hashCode() : 0);
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f13953 + ", findByIssuerAndSignatureMethod=" + this.f13954 + ")";
        }

        @Override // defpackage.q3
        /* renamed from: Ϳ */
        public X509Certificate mo7997(X509Certificate x509Certificate) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C3921.m12667(x509Certificate, "cert");
            try {
                Object objInvoke = this.f13954.invoke(this.f13953, x509Certificate);
                if (objInvoke != null) {
                    return ((TrustAnchor) objInvoke).getTrustedCert();
                }
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e2) {
                throw new AssertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }
    }

    static {
        boolean z = false;
        if (C2708.f10025.m9965() && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        f13949 = z;
    }

    public C3997() {
        List listM10715 = C3131.m10715(g.C1960.m6070(g.f6642, null, 1, null), new C4453(C4003.f13958.m12873()), new C4453(C2694.f9997.m9922()), new C4453(C2357.f8900.m8824()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM10715) {
            if (((InterfaceC4233) obj).mo8819()) {
                arrayList.add(obj);
            }
        }
        this.f13951 = arrayList;
        this.f13952 = C4920.f16603.m14649();
    }

    @Override // defpackage.C2708
    /* renamed from: ԩ */
    public AbstractC2918 mo9949(X509TrustManager x509TrustManager) {
        C3921.m12667(x509TrustManager, "trustManager");
        C3992 c3992M12857 = C3992.f13942.m12857(x509TrustManager);
        return c3992M12857 != null ? c3992M12857 : super.mo9949(x509TrustManager);
    }

    @Override // defpackage.C2708
    /* renamed from: Ԫ */
    public q3 mo9950(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        C3921.m12667(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            C3921.m12663(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new C3999(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo9950(x509TrustManager);
        }
    }

    @Override // defpackage.C2708
    /* renamed from: ԫ */
    public void mo8811(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Object next;
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        Iterator<T> it = this.f13951.iterator();
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
    /* renamed from: Ԭ */
    public void mo9951(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        C3921.m12667(socket, "socket");
        C3921.m12667(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new IOException("Exception in connect", e2);
        }
    }

    @Override // defpackage.C2708
    /* renamed from: Ԯ */
    public String mo8812(SSLSocket sSLSocket) {
        Object next;
        C3921.m12667(sSLSocket, "sslSocket");
        Iterator<T> it = this.f13951.iterator();
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
    /* renamed from: ԯ */
    public Object mo9953(String str) {
        C3921.m12667(str, "closer");
        return this.f13952.m14647(str);
    }

    @Override // defpackage.C2708
    /* renamed from: ՠ */
    public boolean mo9954(String str) {
        C3921.m12667(str, "hostname");
        if (Build.VERSION.SDK_INT >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        C3921.m12663(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
        return networkSecurityPolicy.isCleartextTrafficPermitted();
    }

    @Override // defpackage.C2708
    /* renamed from: ׯ */
    public void mo9956(String str, Object obj) {
        C3921.m12667(str, "message");
        if (this.f13952.m14648(obj)) {
            return;
        }
        C2708.m9947(this, str, 5, null, 4, null);
    }
}
