package okhttp3.internal.http2;

import defpackage.C4184;

/* compiled from: ErrorCode.kt */
/* loaded from: classes2.dex */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    /* renamed from: ޅ, reason: contains not printable characters */
    public static final C2220 f8228 = new C2220(null);
    private final int httpCode;

    /* compiled from: ErrorCode.kt */
    /* renamed from: okhttp3.internal.http2.ErrorCode$Ϳ, reason: contains not printable characters */
    public static final class C2220 {
        public C2220() {
        }

        public /* synthetic */ C2220(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ErrorCode m7849(int i) {
            for (ErrorCode errorCode : ErrorCode.values()) {
                if (errorCode.m7848() == i) {
                    return errorCode;
                }
            }
            return null;
        }
    }

    ErrorCode(int i) {
        this.httpCode = i;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m7848() {
        return this.httpCode;
    }
}
