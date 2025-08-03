package androidx.core.os;

import android.os.Handler;
import defpackage.C3921;
import defpackage.InterfaceC4090;
import defpackage.i4;

/* compiled from: Handler.kt */
/* loaded from: classes.dex */
public final class HandlerKt {
    public static final Runnable postAtTime(Handler handler, long j, Object obj, InterfaceC4090<i4> interfaceC4090) {
        C3921.m12666(handler, "<this>");
        C3921.m12666(interfaceC4090, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(interfaceC4090);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j, Object obj, InterfaceC4090 interfaceC4090, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        C3921.m12666(handler, "<this>");
        C3921.m12666(interfaceC4090, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(interfaceC4090);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    public static final Runnable postDelayed(Handler handler, long j, Object obj, InterfaceC4090<i4> interfaceC4090) {
        C3921.m12666(handler, "<this>");
        C3921.m12666(interfaceC4090, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(interfaceC4090);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j, Object obj, InterfaceC4090 interfaceC4090, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        C3921.m12666(handler, "<this>");
        C3921.m12666(interfaceC4090, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(interfaceC4090);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
