package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import defpackage.AbstractC3415;
import defpackage.C3131;
import defpackage.C3573;
import defpackage.C3864;
import defpackage.C3921;
import defpackage.C3972;
import defpackage.C4184;
import defpackage.C4488;
import defpackage.C4799;
import defpackage.C5064;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC5054;
import defpackage.i5;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: RouteSelector.kt */
/* loaded from: classes2.dex */
public final class RouteSelector {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C2218 f8202 = new C2218(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<? extends Proxy> f8203;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f8204;

    /* renamed from: ԩ, reason: contains not printable characters */
    public List<? extends InetSocketAddress> f8205;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<C4799> f8206;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3972 f8207;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C4488 f8208;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5054 f8209;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC3415 f8210;

    /* compiled from: RouteSelector.kt */
    /* renamed from: okhttp3.internal.connection.RouteSelector$Ϳ, reason: contains not printable characters */
    public static final class C2218 {
        public C2218() {
        }

        public /* synthetic */ C2218(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String m7844(InetSocketAddress inetSocketAddress) {
            C3921.m12667(inetSocketAddress, "$this$socketHost");
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                String hostAddress = address.getHostAddress();
                C3921.m12663(hostAddress, "address.hostAddress");
                return hostAddress;
            }
            String hostName = inetSocketAddress.getHostName();
            C3921.m12663(hostName, "hostName");
            return hostName;
        }
    }

    /* compiled from: RouteSelector.kt */
    /* renamed from: okhttp3.internal.connection.RouteSelector$Ԩ, reason: contains not printable characters */
    public static final class C2219 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public int f8211;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final List<C4799> f8212;

        public C2219(List<C4799> list) {
            C3921.m12667(list, "routes");
            this.f8212 = list;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final List<C4799> m7845() {
            return this.f8212;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m7846() {
            return this.f8211 < this.f8212.size();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C4799 m7847() {
            if (!m7846()) {
                throw new NoSuchElementException();
            }
            List<C4799> list = this.f8212;
            int i = this.f8211;
            this.f8211 = i + 1;
            return list.get(i);
        }
    }

    public RouteSelector(C3972 c3972, C4488 c4488, InterfaceC5054 interfaceC5054, AbstractC3415 abstractC3415) {
        C3921.m12667(c3972, "address");
        C3921.m12667(c4488, "routeDatabase");
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(abstractC3415, "eventListener");
        this.f8207 = c3972;
        this.f8208 = c4488;
        this.f8209 = interfaceC5054;
        this.f8210 = abstractC3415;
        this.f8203 = C3131.m10712();
        this.f8205 = C3131.m10712();
        this.f8206 = new ArrayList();
        m7842(c3972.m12820(), c3972.m12815());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m7837() {
        return m7838() || (this.f8206.isEmpty() ^ true);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m7838() {
        return this.f8204 < this.f8203.size();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C2219 m7839() throws IOException {
        if (!m7837()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (m7838()) {
            Proxy proxyM7840 = m7840();
            Iterator<? extends InetSocketAddress> it = this.f8205.iterator();
            while (it.hasNext()) {
                C4799 c4799 = new C4799(this.f8207, proxyM7840, it.next());
                if (this.f8208.m13750(c4799)) {
                    this.f8206.add(c4799);
                } else {
                    arrayList.add(c4799);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            C3864.m12311(arrayList, this.f8206);
            this.f8206.clear();
        }
        return new C2219(arrayList);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Proxy m7840() throws IOException {
        if (m7838()) {
            List<? extends Proxy> list = this.f8203;
            int i = this.f8204;
            this.f8204 = i + 1;
            Proxy proxy = list.get(i);
            m7841(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f8207.m12820().m11532() + "; exhausted proxy configurations: " + this.f8203);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m7841(Proxy proxy) throws IOException {
        String strM11532;
        int iM11537;
        ArrayList arrayList = new ArrayList();
        this.f8205 = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strM11532 = this.f8207.m12820().m11532();
            iM11537 = this.f8207.m12820().m11537();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strM11532 = f8202.m7844(inetSocketAddress);
            iM11537 = inetSocketAddress.getPort();
        }
        if (1 > iM11537 || 65535 < iM11537) {
            throw new SocketException("No route to " + strM11532 + ':' + iM11537 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(strM11532, iM11537));
            return;
        }
        this.f8210.dnsStart(this.f8209, strM11532);
        List<InetAddress> listMo10704 = this.f8207.m12811().mo10704(strM11532);
        if (listMo10704.isEmpty()) {
            throw new UnknownHostException(this.f8207.m12811() + " returned no addresses for " + strM11532);
        }
        this.f8210.dnsEnd(this.f8209, strM11532, listMo10704);
        Iterator<InetAddress> it = listMo10704.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), iM11537));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.connection.RouteSelector$resetNextProxy$1] */
    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m7842(final C3573 c3573, final Proxy proxy) {
        ?? r0 = new InterfaceC4090<List<? extends Proxy>>() { // from class: okhttp3.internal.connection.RouteSelector$resetNextProxy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // defpackage.InterfaceC4090
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public final List<Proxy> invoke() {
                Proxy proxy2 = proxy;
                if (proxy2 != null) {
                    return C5064.m14877(proxy2);
                }
                URI uriM11544 = c3573.m11544();
                if (uriM11544.getHost() == null) {
                    return i5.m6250(Proxy.NO_PROXY);
                }
                List<Proxy> listSelect = this.this$0.f8207.m12817().select(uriM11544);
                return listSelect == null || listSelect.isEmpty() ? i5.m6250(Proxy.NO_PROXY) : i5.m6271(listSelect);
            }
        };
        this.f8210.proxySelectStart(this.f8209, c3573);
        List<Proxy> listM7843 = r0.invoke();
        this.f8203 = listM7843;
        this.f8204 = 0;
        this.f8210.proxySelectEnd(this.f8209, c3573, listM7843);
    }
}
