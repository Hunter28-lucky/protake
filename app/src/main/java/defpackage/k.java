package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;

/* compiled from: StatusLine.kt */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C2135 f7814 = new C2135(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Protocol f7815;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f7816;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String f7817;

    /* compiled from: StatusLine.kt */
    /* renamed from: k$Ϳ, reason: contains not printable characters */
    public static final class C2135 {
        public C2135() {
        }

        public /* synthetic */ C2135(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final k m7170(String str) throws NumberFormatException, IOException {
            Protocol protocol;
            String strSubstring;
            C3921.m12667(str, "statusLine");
            int i = 9;
            if (e0.m5980(str, "HTTP/1.", false, 2, null)) {
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!e0.m5980(str, "ICY ", false, 2, null)) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                protocol = Protocol.HTTP_1_0;
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() < i2) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            try {
                String strSubstring2 = str.substring(i, i2);
                C3921.m12663(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int i3 = Integer.parseInt(strSubstring2);
                if (str.length() <= i2) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i2) != ' ') {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    strSubstring = str.substring(i + 4);
                    C3921.m12663(strSubstring, "(this as java.lang.String).substring(startIndex)");
                }
                return new k(protocol, i3, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
    }

    public k(Protocol protocol, int i, String str) {
        C3921.m12667(protocol, "protocol");
        C3921.m12667(str, "message");
        this.f7815 = protocol;
        this.f7816 = i;
        this.f7817 = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f7815 == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f7816);
        sb.append(' ');
        sb.append(this.f7817);
        String string = sb.toString();
        C3921.m12663(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
