package defpackage;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.TypeCastException;

/* compiled from: JavaNetAuthenticator.kt */
/* renamed from: ສ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4985 implements InterfaceC5130 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC3113 f16739;

    public C4985(InterfaceC3113 interfaceC3113) {
        C3921.m12667(interfaceC3113, "defaultDns");
        this.f16739 = interfaceC3113;
    }

    @Override // defpackage.InterfaceC5130
    /* renamed from: Ϳ, reason: contains not printable characters */
    public C4539 mo14770(C4799 c4799, C4770 c4770) throws IOException {
        Proxy proxyM14512;
        InterfaceC3113 interfaceC3113M12811;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        C3972 c3972M14511;
        C3921.m12667(c4770, "response");
        List<C2671> listM14333 = c4770.m14333();
        C4539 c4539M14347 = c4770.m14347();
        C3573 c3573M13925 = c4539M14347.m13925();
        boolean z = c4770.m14334() == 407;
        if (c4799 == null || (proxyM14512 = c4799.m14512()) == null) {
            proxyM14512 = Proxy.NO_PROXY;
        }
        for (C2671 c2671 : listM14333) {
            if (e0.m5967("Basic", c2671.m9814(), true)) {
                if (c4799 == null || (c3972M14511 = c4799.m14511()) == null || (interfaceC3113M12811 = c3972M14511.m12811()) == null) {
                    interfaceC3113M12811 = this.f16739;
                }
                if (z) {
                    SocketAddress socketAddressAddress = proxyM14512.address();
                    if (socketAddressAddress == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    C3921.m12663(proxyM14512, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, m14771(proxyM14512, c3573M13925, interfaceC3113M12811), inetSocketAddress.getPort(), c3573M13925.m11543(), c2671.m9813(), c2671.m9814(), c3573M13925.m11545(), Authenticator.RequestorType.PROXY);
                } else {
                    String strM11532 = c3573M13925.m11532();
                    C3921.m12663(proxyM14512, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strM11532, m14771(proxyM14512, c3573M13925, interfaceC3113M12811), c3573M13925.m11537(), c3573M13925.m11543(), c2671.m9813(), c2671.m9814(), c3573M13925.m11545(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    C3921.m12663(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    C3921.m12663(password, "auth.password");
                    return c4539M14347.m13924().m13929(str, C2374.m8841(userName, new String(password), c2671.m9812())).m13927();
                }
            }
        }
        return null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InetAddress m14771(Proxy proxy, C3573 c3573, InterfaceC3113 interfaceC3113) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && C2622.f9734[type.ordinal()] == 1) {
            return (InetAddress) C2543.m9370(interfaceC3113.mo10704(c3573.m11532()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        if (socketAddressAddress == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        C3921.m12663(address, "(address() as InetSocketAddress).address");
        return address;
    }

    public /* synthetic */ C4985(InterfaceC3113 interfaceC3113, int i, C4184 c4184) {
        this((i & 1) != 0 ? InterfaceC3113.f11070 : interfaceC3113);
    }
}
