package defpackage;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

/* compiled from: NullProxySelector.kt */
/* renamed from: ஶ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4487 extends ProxySelector {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C4487 f15394 = new C4487();

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return C5064.m14877(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
