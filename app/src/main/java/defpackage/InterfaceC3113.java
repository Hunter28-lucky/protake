package defpackage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: Dns.kt */
/* renamed from: ӟ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC3113 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C3114 f11071 = new C3114(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC3113 f11070 = new C3114.C3115();

    /* compiled from: Dns.kt */
    /* renamed from: ӟ$Ϳ, reason: contains not printable characters */
    public static final class C3114 {

        /* compiled from: Dns.kt */
        /* renamed from: ӟ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C3115 implements InterfaceC3113 {
            @Override // defpackage.InterfaceC3113
            /* renamed from: Ϳ */
            public List<InetAddress> mo10704(String str) throws UnknownHostException {
                C3921.m12667(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    C3921.m12663(allByName, "InetAddress.getAllByName(hostname)");
                    return C4962.m14746(allByName);
                } catch (NullPointerException e2) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e2);
                    throw unknownHostException;
                }
            }
        }

        public C3114() {
        }

        public /* synthetic */ C3114(C4184 c4184) {
            this();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    List<InetAddress> mo10704(String str) throws UnknownHostException;
}
