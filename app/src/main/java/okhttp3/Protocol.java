package okhttp3;

import defpackage.C3921;
import defpackage.C4184;
import java.io.IOException;

/* compiled from: Protocol.kt */
/* loaded from: classes2.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: ֏, reason: contains not printable characters */
    public static final C2210 f8120 = new C2210(null);
    private final String protocol;

    /* compiled from: Protocol.kt */
    /* renamed from: okhttp3.Protocol$Ϳ, reason: contains not printable characters */
    public static final class C2210 {
        public C2210() {
        }

        public /* synthetic */ C2210(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Protocol m7735(String str) throws IOException {
            C3921.m12667(str, "protocol");
            Protocol protocol = Protocol.HTTP_1_0;
            if (!C3921.m12662(str, protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!C3921.m12662(str, protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!C3921.m12662(str, protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!C3921.m12662(str, protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!C3921.m12662(str, protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!C3921.m12662(str, protocol.protocol)) {
                                    throw new IOException("Unexpected protocol: " + str);
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) throws IOException {
        return f8120.m7735(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
