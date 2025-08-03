package defpackage;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: StandardAndroidSocketAdapter.kt */
/* loaded from: classes2.dex */
public final class g extends C4003 {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final C1960 f6642 = new C1960(null);

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Class<? super SSLSocketFactory> f6643;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final Class<?> f6644;

    /* compiled from: StandardAndroidSocketAdapter.kt */
    /* renamed from: g$Ϳ, reason: contains not printable characters */
    public static final class C1960 {
        public C1960() {
        }

        public /* synthetic */ C1960(C4184 c4184) {
            this();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static /* synthetic */ InterfaceC4233 m6070(C1960 c1960, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return c1960.m6071(str);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC4233 m6071(String str) throws ClassNotFoundException {
            C3921.m12667(str, "packageName");
            try {
                Class<?> cls = Class.forName(str + ".OpenSSLSocketImpl");
                Class<?> cls2 = Class.forName(str + ".OpenSSLSocketFactoryImpl");
                Class<?> cls3 = Class.forName(str + ".SSLParametersImpl");
                C3921.m12663(cls3, "paramsClass");
                return new g(cls, cls2, cls3);
            } catch (Exception e2) {
                C2708.f10025.m9964().m9955("unable to load android socket classes", 5, e2);
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        C3921.m12667(cls, "sslSocketClass");
        C3921.m12667(cls2, "sslSocketFactoryClass");
        C3921.m12667(cls3, "paramClass");
        this.f6643 = cls2;
        this.f6644 = cls3;
    }
}
