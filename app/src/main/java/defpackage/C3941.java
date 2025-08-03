package defpackage;

import com.google.android.gms.common.internal.ImagesContract;
import java.net.Proxy;

/* compiled from: RequestLine.kt */
/* renamed from: ࡑ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3941 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3941 f13581 = new C3941();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m12714(C4539 c4539, Proxy.Type type) {
        C3921.m12667(c4539, "request");
        C3921.m12667(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(c4539.m13923());
        sb.append(' ');
        C3941 c3941 = f13581;
        if (c3941.m12715(c4539, type)) {
            sb.append(c4539.m13925());
        } else {
            sb.append(c3941.m12716(c4539.m13925()));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        C3921.m12663(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m12715(C4539 c4539, Proxy.Type type) {
        return !c4539.m13922() && type == Proxy.Type.HTTP;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m12716(C3573 c3573) {
        C3921.m12667(c3573, ImagesContract.URL);
        String strM11528 = c3573.m11528();
        String strM11530 = c3573.m11530();
        if (strM11530 == null) {
            return strM11528;
        }
        return strM11528 + '?' + strM11530;
    }
}
