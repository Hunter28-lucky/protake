package okhttp3;

import defpackage.C3921;
import defpackage.C4184;

/* compiled from: TlsVersion.kt */
/* loaded from: classes2.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    /* renamed from: ֈ, reason: contains not printable characters */
    public static final C2211 f8127 = new C2211(null);
    private final String javaName;

    /* compiled from: TlsVersion.kt */
    /* renamed from: okhttp3.TlsVersion$Ϳ, reason: contains not printable characters */
    public static final class C2211 {
        public C2211() {
        }

        public /* synthetic */ C2211(C4184 c4184) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* renamed from: Ϳ, reason: contains not printable characters */
        public final TlsVersion m7737(String str) {
            C3921.m12667(str, "javaName");
            int iHashCode = str.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (str.equals("SSLv3")) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    TlsVersion(String str) {
        this.javaName = str;
    }

    public static final TlsVersion forJavaName(String str) {
        return f8127.m7737(str);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m7736() {
        return this.javaName;
    }
}
