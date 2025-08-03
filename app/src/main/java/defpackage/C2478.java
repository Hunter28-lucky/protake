package defpackage;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import okhttp3.Protocol;

/* compiled from: Jdk9Platform.kt */
/* renamed from: Ǎ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2478 extends C2708 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final boolean f9179;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C2479 f9180 = new C2479(0 == true ? 1 : 0);

    /* compiled from: Jdk9Platform.kt */
    /* renamed from: Ǎ$Ϳ, reason: contains not printable characters */
    public static final class C2479 {
        public C2479() {
        }

        public /* synthetic */ C2479(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2478 m9078() {
            if (m9079()) {
                return new C2478();
            }
            return null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m9079() {
            return C2478.f9179;
        }
    }

    static {
        String property = System.getProperty("java.specification.version");
        Integer numM5892 = property != null ? d0.m5892(property) : null;
        boolean z = true;
        if (numM5892 == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
            }
        } else if (numM5892.intValue() < 9) {
            z = false;
        }
        f9179 = z;
    }

    @Override // defpackage.C2708
    /* renamed from: ԫ */
    public void mo8811(SSLSocket sSLSocket, String str, List<Protocol> list) {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        List<String> listM9959 = C2708.f10025.m9959(list);
        C3921.m12663(sSLParameters, "sslParameters");
        Object[] array = listM9959.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        sSLParameters.setApplicationProtocols((String[]) array);
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // defpackage.C2708
    /* renamed from: Ԯ */
    public String mo8812(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                return null;
            }
            if (C3921.m12662(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
