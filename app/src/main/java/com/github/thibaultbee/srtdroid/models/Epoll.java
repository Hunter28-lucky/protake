package com.github.thibaultbee.srtdroid.models;

import com.github.thibaultbee.srtdroid.Srt;
import com.github.thibaultbee.srtdroid.enums.EpollFlag;
import com.github.thibaultbee.srtdroid.enums.EpollOpt;
import com.umeng.analytics.pro.d;
import defpackage.C3131;
import defpackage.C3921;
import defpackage.C4184;
import java.security.InvalidParameterException;
import java.util.List;

/* compiled from: Epoll.kt */
/* loaded from: classes.dex */
public final class Epoll {
    public static final Companion Companion = new Companion(null);
    private int eid = create();

    /* compiled from: Epoll.kt */
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

    private final native int create();

    private final native int nativeAddUSock(Socket socket, List<? extends EpollOpt> list);

    private final native int nativeClearUSock();

    private final native List<EpollFlag> nativeGetFlags();

    private final native boolean nativeIsValid();

    private final native int nativeRelease();

    private final native int nativeRemoveUSock(Socket socket);

    private final native List<EpollFlag> nativeSetFlags(List<? extends EpollFlag> list);

    private final native int nativeUWait(List<EpollEvent> list, long j);

    private final native int nativeUpdateUSock(Socket socket, List<? extends EpollOpt> list);

    private final native int nativeWait(List<Socket> list, List<Socket> list2, long j);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void wait$default(Epoll epoll, List list, List list2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = C3131.m10712();
        }
        if ((i & 2) != 0) {
            list2 = C3131.m10712();
        }
        epoll.wait(list, list2, j);
    }

    public final void addUSock(Socket socket, List<? extends EpollOpt> list) {
        C3921.m12666(socket, "socket");
        if (nativeAddUSock(socket, list) != 0) {
            throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final void clearUSock() {
        if (nativeClearUSock() != 0) {
            throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final List<EpollFlag> getFlags() {
        List<EpollFlag> listNativeGetFlags = nativeGetFlags();
        if (listNativeGetFlags != null) {
            return listNativeGetFlags;
        }
        throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
    }

    public final boolean isValid() {
        return nativeIsValid();
    }

    public final void release() {
        if (nativeRelease() != 0) {
            throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final void removeUSock(Socket socket) {
        C3921.m12666(socket, "socket");
        if (nativeRemoveUSock(socket) != 0) {
            throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final List<EpollFlag> setFlags(List<? extends EpollFlag> list) {
        C3921.m12666(list, d.ar);
        List<EpollFlag> listNativeSetFlags = nativeSetFlags(list);
        if (listNativeSetFlags != null) {
            return listNativeSetFlags;
        }
        throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
    }

    public final void uWait(List<EpollEvent> list, long j) {
        C3921.m12666(list, "fdsSet");
        if (nativeUWait(list, j) != 0) {
            throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final void updateUSock(Socket socket, List<? extends EpollOpt> list) {
        C3921.m12666(socket, "socket");
        if (nativeUpdateUSock(socket, list) != 0) {
            throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final void wait(List<Socket> list, List<Socket> list2, long j) {
        C3921.m12666(list, "readFds");
        C3921.m12666(list2, "writeFds");
        if (nativeWait(list, list2, j) != 0) {
            throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    /* renamed from: setFlags, reason: collision with other method in class */
    public final void m5052setFlags(List<? extends EpollFlag> list) {
        C3921.m12666(list, "value");
        if (nativeSetFlags(list) == null) {
            throw new InvalidParameterException(Error.INSTANCE.getLastErrorMessage());
        }
    }
}
