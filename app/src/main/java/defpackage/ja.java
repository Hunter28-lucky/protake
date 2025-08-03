package defpackage;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ja {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final CookieManager f7740 = new CookieManager();

    /* renamed from: ja$Ϳ, reason: contains not printable characters */
    public static final class C2123 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f7741;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final byte[] f7742;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final Map<String, String> f7743;

        public C2123(String str, Map<String, String> map, byte[] bArr) {
            this.f7741 = str;
            this.f7742 = bArr;
            this.f7743 = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", this.f7741, this.f7743);
        }
    }

    /* renamed from: ja$Ԩ, reason: contains not printable characters */
    public static final class C2124 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Map<String, List<String>> f7744;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final String f7745;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final byte[] f7746;

        public C2124(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f7744 = map;
            this.f7745 = str;
            this.f7746 = bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: Ϳ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static defpackage.ja.C2124 m7106(android.content.Context r11, defpackage.ja.C2123 r12) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja.m7106(android.content.Context, ja$Ϳ):ja$Ԩ");
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m7107(Context context) {
        try {
            NetworkInfo networkInfoM8222 = sb.m8222(null, context);
            if (networkInfoM8222 != null && networkInfoM8222.isAvailable()) {
                return networkInfoM8222.getType() == 1 ? NetworkUtil.NETWORK_TYPE_WIFI : networkInfoM8222.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return Constants.CP_NONE;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m7108(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static Proxy m7109(Context context) {
        String strM7107 = m7107(context);
        if (strM7107 != null && !strM7107.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
        } catch (Throwable unused) {
            return null;
        }
    }
}
