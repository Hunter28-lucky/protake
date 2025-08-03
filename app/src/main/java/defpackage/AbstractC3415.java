package defpackage;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;

/* compiled from: EventListener.kt */
/* renamed from: װ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3415 {
    public static final C3417 Companion = new C3417(null);
    public static final AbstractC3415 NONE = new C3416();

    /* compiled from: EventListener.kt */
    /* renamed from: װ$Ϳ, reason: contains not printable characters */
    public static final class C3416 extends AbstractC3415 {
    }

    /* compiled from: EventListener.kt */
    /* renamed from: װ$Ԩ, reason: contains not printable characters */
    public static final class C3417 {
        public C3417() {
        }

        public /* synthetic */ C3417(C4184 c4184) {
            this();
        }
    }

    /* compiled from: EventListener.kt */
    /* renamed from: װ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC3418 {
        AbstractC3415 create(InterfaceC5054 interfaceC5054);
    }

    public void cacheConditionalHit(InterfaceC5054 interfaceC5054, C4770 c4770) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(c4770, "cachedResponse");
    }

    public void cacheHit(InterfaceC5054 interfaceC5054, C4770 c4770) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(c4770, "response");
    }

    public void cacheMiss(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void callEnd(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void callFailed(InterfaceC5054 interfaceC5054, IOException iOException) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(iOException, "ioe");
    }

    public void callStart(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void canceled(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void connectEnd(InterfaceC5054 interfaceC5054, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(inetSocketAddress, "inetSocketAddress");
        C3921.m12667(proxy, "proxy");
    }

    public void connectFailed(InterfaceC5054 interfaceC5054, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(inetSocketAddress, "inetSocketAddress");
        C3921.m12667(proxy, "proxy");
        C3921.m12667(iOException, "ioe");
    }

    public void connectStart(InterfaceC5054 interfaceC5054, InetSocketAddress inetSocketAddress, Proxy proxy) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(inetSocketAddress, "inetSocketAddress");
        C3921.m12667(proxy, "proxy");
    }

    public void connectionAcquired(InterfaceC5054 interfaceC5054, InterfaceC5051 interfaceC5051) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(interfaceC5051, "connection");
    }

    public void connectionReleased(InterfaceC5054 interfaceC5054, InterfaceC5051 interfaceC5051) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(interfaceC5051, "connection");
    }

    public void dnsEnd(InterfaceC5054 interfaceC5054, String str, List<InetAddress> list) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(str, "domainName");
        C3921.m12667(list, "inetAddressList");
    }

    public void dnsStart(InterfaceC5054 interfaceC5054, String str) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(str, "domainName");
    }

    public void proxySelectEnd(InterfaceC5054 interfaceC5054, C3573 c3573, List<Proxy> list) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(c3573, ImagesContract.URL);
        C3921.m12667(list, "proxies");
    }

    public void proxySelectStart(InterfaceC5054 interfaceC5054, C3573 c3573) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(c3573, ImagesContract.URL);
    }

    public void requestBodyEnd(InterfaceC5054 interfaceC5054, long j) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void requestBodyStart(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void requestFailed(InterfaceC5054 interfaceC5054, IOException iOException) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(iOException, "ioe");
    }

    public void requestHeadersEnd(InterfaceC5054 interfaceC5054, C4539 c4539) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(c4539, "request");
    }

    public void requestHeadersStart(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyEnd(InterfaceC5054 interfaceC5054, long j) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyStart(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void responseFailed(InterfaceC5054 interfaceC5054, IOException iOException) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(iOException, "ioe");
    }

    public void responseHeadersEnd(InterfaceC5054 interfaceC5054, C4770 c4770) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(c4770, "response");
    }

    public void responseHeadersStart(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void satisfactionFailure(InterfaceC5054 interfaceC5054, C4770 c4770) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(c4770, "response");
    }

    public void secureConnectEnd(InterfaceC5054 interfaceC5054, Handshake handshake) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }

    public void secureConnectStart(InterfaceC5054 interfaceC5054) {
        C3921.m12667(interfaceC5054, NotificationCompat.CATEGORY_CALL);
    }
}
