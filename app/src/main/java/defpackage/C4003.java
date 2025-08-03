package defpackage;

import defpackage.C4453;
import io.jsonwebtoken.JwtParser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* compiled from: AndroidSocketAdapter.kt */
/* renamed from: ࢻ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4003 implements InterfaceC4233 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C4453.InterfaceC4454 f13957;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C4004 f13958;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Method f13959;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Method f13960;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Method f13961;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Method f13962;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Class<? super SSLSocket> f13963;

    /* compiled from: AndroidSocketAdapter.kt */
    /* renamed from: ࢻ$Ϳ, reason: contains not printable characters */
    public static final class C4004 {

        /* compiled from: AndroidSocketAdapter.kt */
        /* renamed from: ࢻ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C4005 implements C4453.InterfaceC4454 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ String f13964;

            public C4005(String str) {
                this.f13964 = str;
            }

            @Override // defpackage.C4453.InterfaceC4454
            /* renamed from: Ϳ */
            public boolean mo8822(SSLSocket sSLSocket) {
                C3921.m12667(sSLSocket, "sslSocket");
                String name = sSLSocket.getClass().getName();
                C3921.m12663(name, "sslSocket.javaClass.name");
                return e0.m5980(name, this.f13964 + JwtParser.SEPARATOR_CHAR, false, 2, null);
            }

            @Override // defpackage.C4453.InterfaceC4454
            /* renamed from: Ԩ */
            public InterfaceC4233 mo8823(SSLSocket sSLSocket) {
                C3921.m12667(sSLSocket, "sslSocket");
                return C4003.f13958.m12871(sSLSocket.getClass());
            }
        }

        public C4004() {
        }

        public /* synthetic */ C4004(C4184 c4184) {
            this();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C4003 m12871(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> superclass = cls;
            while (superclass != null && (!C3921.m12662(superclass.getSimpleName(), "OpenSSLSocketImpl"))) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            if (superclass == null) {
                C3921.m12675();
            }
            return new C4003(superclass);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C4453.InterfaceC4454 m12872(String str) {
            C3921.m12667(str, "packageName");
            return new C4005(str);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C4453.InterfaceC4454 m12873() {
            return C4003.f13957;
        }
    }

    static {
        C4004 c4004 = new C4004(null);
        f13958 = c4004;
        f13957 = c4004.m12872("com.google.android.gms.org.conscrypt");
    }

    public C4003(Class<? super SSLSocket> cls) throws NoSuchMethodException, SecurityException {
        C3921.m12667(cls, "sslSocketClass");
        this.f13963 = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        C3921.m12663(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f13959 = declaredMethod;
        this.f13960 = cls.getMethod("setHostname", String.class);
        this.f13961 = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f13962 = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ϳ */
    public boolean mo8818(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        return this.f13963.isInstance(sSLSocket);
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԩ */
    public boolean mo8819() {
        return C3997.f13950.m12866();
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: ԩ */
    public String mo8820(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        if (!mo8818(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f13961.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            C3921.m12663(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (NullPointerException e3) {
            if (C3921.m12662(e3.getMessage(), "ssl == null")) {
                return null;
            }
            throw e3;
        } catch (InvocationTargetException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԫ */
    public void mo8821(SSLSocket sSLSocket, String str, List<? extends Protocol> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        if (mo8818(sSLSocket)) {
            try {
                this.f13959.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f13960.invoke(sSLSocket, str);
                }
                this.f13962.invoke(sSLSocket, C2708.f10025.m9960(list));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }
    }
}
