package defpackage;

import androidx.core.app.NotificationCompat;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* compiled from: ExchangeFinder.kt */
/* renamed from: ɭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2611 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public RouteSelector.C2219 f9707;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public RouteSelector f9708;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f9709;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f9710;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f9711;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C4799 f9712;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C2861 f9713;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C3972 f9714;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C2503 f9715;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final AbstractC3415 f9716;

    public C2611(C2861 c2861, C3972 c3972, C2503 c2503, AbstractC3415 abstractC3415) {
        C3921.m12667(c2861, "connectionPool");
        C3921.m12667(c3972, "address");
        C3921.m12667(c2503, NotificationCompat.CATEGORY_CALL);
        C3921.m12667(abstractC3415, "eventListener");
        this.f9713 = c2861;
        this.f9714 = c3972;
        this.f9715 = c2503;
        this.f9716 = abstractC3415;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC2891 m9546(C5121 c5121, C3739 c3739) {
        C3921.m12667(c5121, "client");
        C3921.m12667(c3739, "chain");
        try {
            return m9548(c3739.m11977(), c3739.m11979(), c3739.m11981(), c5121.m14972(), c5121.m14978(), !C3921.m12662(c3739.m11980().m13923(), "GET")).m7820(c5121, c3739);
        } catch (IOException e2) {
            m9553(e2);
            throw new RouteException(e2);
        } catch (RouteException e3) {
            m9553(e3.m7835());
            throw e3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015c  */
    /* renamed from: Ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.internal.connection.RealConnection m9547(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C2611.m9547(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final RealConnection m9548(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection realConnectionM9547 = m9547(i, i2, i3, i4, z);
            if (realConnectionM9547.m7818(z2)) {
                return realConnectionM9547;
            }
            realConnectionM9547.m7822();
            if (this.f9712 == null) {
                RouteSelector.C2219 c2219 = this.f9707;
                if (c2219 != null ? c2219.m7846() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector = this.f9708;
                    if (!(routeSelector != null ? routeSelector.m7837() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C3972 m9549() {
        return this.f9714;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m9550() {
        RouteSelector routeSelector;
        if (this.f9709 == 0 && this.f9710 == 0 && this.f9711 == 0) {
            return false;
        }
        if (this.f9712 != null) {
            return true;
        }
        C4799 c4799M9551 = m9551();
        if (c4799M9551 != null) {
            this.f9712 = c4799M9551;
            return true;
        }
        RouteSelector.C2219 c2219 = this.f9707;
        if ((c2219 == null || !c2219.m7846()) && (routeSelector = this.f9708) != null) {
            return routeSelector.m7837();
        }
        return true;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C4799 m9551() {
        RealConnection realConnectionM9234;
        if (this.f9709 > 1 || this.f9710 > 1 || this.f9711 > 0 || (realConnectionM9234 = this.f9715.m9234()) == null) {
            return null;
        }
        synchronized (realConnectionM9234) {
            if (realConnectionM9234.m7814() != 0) {
                return null;
            }
            if (i5.m6237(realConnectionM9234.m7823().m14511().m12820(), this.f9714.m12820())) {
                return realConnectionM9234.m7823();
            }
            return null;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m9552(C3573 c3573) {
        C3921.m12667(c3573, ImagesContract.URL);
        C3573 c3573M12820 = this.f9714.m12820();
        return c3573.m11537() == c3573M12820.m11537() && C3921.m12662(c3573.m11532(), c3573M12820.m11532());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m9553(IOException iOException) {
        C3921.m12667(iOException, TsConstants.kLinkParam_machine);
        this.f9712 = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.f9709++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.f9710++;
        } else {
            this.f9711++;
        }
    }
}
