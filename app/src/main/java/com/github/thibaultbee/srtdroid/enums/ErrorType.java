package com.github.thibaultbee.srtdroid.enums;

import com.github.thibaultbee.srtdroid.Srt;
import defpackage.C4184;

/* compiled from: ErrorType.kt */
/* loaded from: classes.dex */
public enum ErrorType {
    EUNKNOWN,
    SUCCESS,
    ECONNSETUP,
    ENOSERVER,
    ECONNREJ,
    ESOCKFAIL,
    ESECFAIL,
    ESCLOSED,
    ECONNFAIL,
    ECONNLOST,
    ENOCONN,
    ERESOURCE,
    ETHREAD,
    ENOBUF,
    ESYSOBJ,
    EFILE,
    EINVRDOFF,
    ERDPERM,
    EINVWROFF,
    EWRPERM,
    EINVOP,
    EBOUNDSOCK,
    ECONNSOCK,
    EINVPARAM,
    EINVSOCK,
    EUNBOUNDSOCK,
    ENOLISTEN,
    ERDVNOSERV,
    ERDVUNBOUND,
    EINVALMSGAPI,
    EINVALBUFFERAPI,
    EDUPLISTEN,
    ELARGEMSG,
    EINVPOLLID,
    EPOLLEMPTY,
    EASYNCFAIL,
    EASYNCSND,
    EASYNCRCV,
    ETIMEOUT,
    ECONGEST,
    EPEERERR;

    public static final Companion Companion = new Companion(null);

    /* compiled from: ErrorType.kt */
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
