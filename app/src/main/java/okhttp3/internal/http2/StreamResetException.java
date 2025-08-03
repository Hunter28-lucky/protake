package okhttp3.internal.http2;

import defpackage.C3921;
import java.io.IOException;

/* compiled from: StreamResetException.kt */
/* loaded from: classes2.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        C3921.m12667(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
