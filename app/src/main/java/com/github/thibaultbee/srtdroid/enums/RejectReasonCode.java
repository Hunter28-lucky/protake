package com.github.thibaultbee.srtdroid.enums;

import com.github.thibaultbee.srtdroid.Srt;
import defpackage.C4184;

/* compiled from: RejectReasonCode.kt */
/* loaded from: classes.dex */
public enum RejectReasonCode {
    UNKNOWN,
    SYSTEM,
    PEER,
    RESOURCE,
    ROGUE,
    BACKLOG,
    IPE,
    CLOSE,
    VERSION,
    RDVCOOKIE,
    BADSECRET,
    UNSECURE,
    MESSAGEAPI,
    CONGESTION,
    FILTER,
    GROUP,
    TIMEOUT;

    public static final Companion Companion = new Companion(null);
    public static final int PREDEFINED_OFFSET = 1000;
    public static final int USERDEFINED_OFFSET = 2000;

    /* compiled from: RejectReasonCode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C4184 c4184) {
            this();
        }
    }

    static {
        Srt.INSTANCE.startUp();
    }

    @Override // java.lang.Enum
    public native String toString();
}
