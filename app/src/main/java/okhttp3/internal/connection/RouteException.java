package okhttp3.internal.connection;

import com.blink.academy.film.support.stream.ts.TsConstants;
import defpackage.C3921;
import java.io.IOException;

/* compiled from: RouteException.kt */
/* loaded from: classes2.dex */
public final class RouteException extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteException(IOException iOException) {
        super(iOException);
        C3921.m12667(iOException, "firstConnectException");
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m7833(IOException iOException) {
        C3921.m12667(iOException, TsConstants.kLinkParam_machine);
        this.firstConnectException.addSuppressed(iOException);
        this.lastConnectException = iOException;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final IOException m7834() {
        return this.firstConnectException;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final IOException m7835() {
        return this.lastConnectException;
    }
}
