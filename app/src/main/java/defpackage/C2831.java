package defpackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import okhttp3.Protocol;

/* compiled from: Jdk8WithJettyBootPlatform.kt */
/* renamed from: ϐ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2831 extends C2708 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C2833 f10303 = new C2833(null);

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Method f10304;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Method f10305;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Method f10306;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Class<?> f10307;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Class<?> f10308;

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    /* renamed from: ϐ$Ϳ, reason: contains not printable characters */
    public static final class C2832 implements InvocationHandler {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean f10309;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String f10310;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final List<String> f10311;

        public C2832(List<String> list) {
            C3921.m12667(list, "protocols");
            this.f10311 = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            C3921.m12667(obj, "proxy");
            C3921.m12667(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (C3921.m12662(name, "supports") && C3921.m12662(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (C3921.m12662(name, "unsupported") && C3921.m12662(Void.TYPE, returnType)) {
                this.f10309 = true;
                return null;
            }
            if (C3921.m12662(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.f10311;
                }
            }
            if ((C3921.m12662(name, "selectProtocol") || C3921.m12662(name, "select")) && C3921.m12662(String.class, returnType) && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    if (obj2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj2;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj3 = list.get(i);
                            if (obj3 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj3;
                            if (!this.f10311.contains(str)) {
                                if (i == size) {
                                    break;
                                }
                                i++;
                            } else {
                                this.f10310 = str;
                                return str;
                            }
                        }
                    }
                    String str2 = this.f10311.get(0);
                    this.f10310 = str2;
                    return str2;
                }
            }
            if ((!C3921.m12662(name, "protocolSelected") && !C3921.m12662(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj4 = objArr[0];
            if (obj4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            this.f10310 = (String) obj4;
            return null;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String m10175() {
            return this.f10310;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m10176() {
            return this.f10309;
        }
    }

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    /* renamed from: ϐ$Ԩ, reason: contains not printable characters */
    public static final class C2833 {
        public C2833() {
        }

        public /* synthetic */ C2833(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2708 m10177() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                C3921.m12663(property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                Method method2 = cls.getMethod("get", SSLSocket.class);
                Method method3 = cls.getMethod("remove", SSLSocket.class);
                C3921.m12663(method, "putMethod");
                C3921.m12663(method2, "getMethod");
                C3921.m12663(method3, "removeMethod");
                C3921.m12663(cls3, "clientProviderClass");
                C3921.m12663(cls4, "serverProviderClass");
                return new C2831(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public C2831(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        C3921.m12667(method, "putMethod");
        C3921.m12667(method2, "getMethod");
        C3921.m12667(method3, "removeMethod");
        C3921.m12667(cls, "clientProviderClass");
        C3921.m12667(cls2, "serverProviderClass");
        this.f10304 = method;
        this.f10305 = method2;
        this.f10306 = method3;
        this.f10307 = cls;
        this.f10308 = cls2;
    }

    @Override // defpackage.C2708
    /* renamed from: Ԩ */
    public void mo9948(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C3921.m12667(sSLSocket, "sslSocket");
        try {
            this.f10306.invoke(null, sSLSocket);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to remove ALPN", e3);
        }
    }

    @Override // defpackage.C2708
    /* renamed from: ԫ */
    public void mo8811(SSLSocket sSLSocket, String str, List<? extends Protocol> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        try {
            this.f10304.invoke(null, sSLSocket, Proxy.newProxyInstance(C2708.class.getClassLoader(), new Class[]{this.f10307, this.f10308}, new C2832(C2708.f10025.m9959(list))));
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to set ALPN", e3);
        }
    }

    @Override // defpackage.C2708
    /* renamed from: Ԯ */
    public String mo8812(SSLSocket sSLSocket) throws IllegalArgumentException {
        C3921.m12667(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f10305.invoke(null, sSLSocket));
            if (invocationHandler == null) {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            C2832 c2832 = (C2832) invocationHandler;
            if (!c2832.m10176() && c2832.m10175() == null) {
                C2708.m9947(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (c2832.m10176()) {
                return null;
            }
            return c2832.m10175();
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to get ALPN selected protocol", e3);
        }
    }
}
