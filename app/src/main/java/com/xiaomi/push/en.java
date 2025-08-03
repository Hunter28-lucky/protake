package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
final class en {

    public static class a {
        public ej a;

        /* renamed from: a, reason: collision with other field name */
        public String f5855a;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m5445a(Exception exc) {
        exc.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Throwable] */
    public static a b(Exception exc) {
        Throwable cause;
        m5445a(exc);
        boolean z = exc instanceof fj;
        Exception excA = exc;
        if (z) {
            fj fjVar = (fj) exc;
            excA = exc;
            if (fjVar.a() != null) {
                excA = fjVar.a();
            }
        }
        a aVar = new a();
        String message = excA.getMessage();
        if (excA.getCause() != null) {
            message = excA.getCause().getMessage();
        }
        int iA = fd.a(excA);
        String str = excA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA != 0) {
            ej ejVarA = ej.a(ej.CONN_SUCCESS.a() + iA);
            aVar.a = ejVarA;
            if (ejVarA == ej.CONN_BOSH_ERR && (cause = excA.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.a = ej.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.a = ej.CONN_XMPP_ERR;
        }
        ej ejVar = aVar.a;
        if (ejVar == ej.CONN_TCP_ERR_OTHER || ejVar == ej.CONN_XMPP_ERR || ejVar == ej.CONN_BOSH_ERR) {
            aVar.f5855a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    public static a c(Exception exc) {
        m5445a(exc);
        boolean z = exc instanceof fj;
        Exception excA = exc;
        if (z) {
            fj fjVar = (fj) exc;
            excA = exc;
            if (fjVar.a() != null) {
                excA = fjVar.a();
            }
        }
        a aVar = new a();
        String message = excA.getMessage();
        if (excA.getCause() != null) {
            message = excA.getCause().getMessage();
        }
        int iA = fd.a(excA);
        String str = excA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA == 105) {
            aVar.a = ej.BIND_TCP_READ_TIMEOUT;
        } else if (iA == 199) {
            aVar.a = ej.BIND_TCP_ERR;
        } else if (iA == 499) {
            aVar.a = ej.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.a = ej.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (iA == 109) {
            aVar.a = ej.BIND_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.a = ej.BIND_XMPP_ERR;
        } else {
            aVar.a = ej.BIND_TCP_BROKEN_PIPE;
        }
        ej ejVar = aVar.a;
        if (ejVar == ej.BIND_TCP_ERR || ejVar == ej.BIND_XMPP_ERR || ejVar == ej.BIND_BOSH_ERR) {
            aVar.f5855a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    public static a d(Exception exc) {
        m5445a(exc);
        boolean z = exc instanceof fj;
        Exception excA = exc;
        if (z) {
            fj fjVar = (fj) exc;
            excA = exc;
            if (fjVar.a() != null) {
                excA = fjVar.a();
            }
        }
        a aVar = new a();
        String message = excA.getMessage();
        int iA = fd.a(excA);
        String str = excA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA == 105) {
            aVar.a = ej.CHANNEL_TCP_READTIMEOUT;
        } else if (iA == 199) {
            aVar.a = ej.CHANNEL_TCP_ERR;
        } else if (iA == 499) {
            aVar.a = ej.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.a = ej.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (iA == 109) {
            aVar.a = ej.CHANNEL_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.a = ej.CHANNEL_XMPPEXCEPTION;
        } else {
            aVar.a = ej.CHANNEL_TCP_BROKEN_PIPE;
        }
        ej ejVar = aVar.a;
        if (ejVar == ej.CHANNEL_TCP_ERR || ejVar == ej.CHANNEL_XMPPEXCEPTION || ejVar == ej.CHANNEL_BOSH_EXCEPTION) {
            aVar.f5855a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    public static a a(Exception exc) {
        m5445a(exc);
        boolean z = exc instanceof fj;
        Exception excA = exc;
        if (z) {
            fj fjVar = (fj) exc;
            excA = exc;
            if (fjVar.a() != null) {
                excA = fjVar.a();
            }
        }
        a aVar = new a();
        String message = excA.getMessage();
        if (excA.getCause() != null) {
            message = excA.getCause().getMessage();
        }
        String str = excA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int iA = fd.a(excA);
        if (iA != 0) {
            aVar.a = ej.a(ej.GSLB_REQUEST_SUCCESS.a() + iA);
        }
        if (aVar.a == null) {
            aVar.a = ej.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == ej.GSLB_TCP_ERR_OTHER) {
            aVar.f5855a = str;
        }
        return aVar;
    }
}
