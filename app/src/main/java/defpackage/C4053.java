package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

/* compiled from: ScalarXMapZHelper.java */
/* renamed from: ऑ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4053 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> boolean m12972(Object obj, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, InterfaceC5053 interfaceC5053) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            a aVar = (Object) ((Callable) obj).call();
            InterfaceC2837 interfaceC2837 = aVar != null ? (InterfaceC2837) C4246.m13353(interfaceC2368.apply(aVar), "The mapper returned a null CompletableSource") : null;
            if (interfaceC2837 == null) {
                EmptyDisposable.complete(interfaceC5053);
            } else {
                interfaceC2837.mo10180(interfaceC5053);
            }
            return true;
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5053);
            return true;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T, R> boolean m12973(Object obj, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, InterfaceC5102<? super R> interfaceC5102) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            a aVar = (Object) ((Callable) obj).call();
            InterfaceC3517 interfaceC3517 = aVar != null ? (InterfaceC3517) C4246.m13353(interfaceC2368.apply(aVar), "The mapper returned a null MaybeSource") : null;
            if (interfaceC3517 == null) {
                EmptyDisposable.complete(interfaceC5102);
            } else {
                interfaceC3517.mo11463(MaybeToObservable.m6676(interfaceC5102));
            }
            return true;
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
            return true;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T, R> boolean m12974(Object obj, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, InterfaceC5102<? super R> interfaceC5102) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            a aVar = (Object) ((Callable) obj).call();
            InterfaceC3951 interfaceC3951 = aVar != null ? (InterfaceC3951) C4246.m13353(interfaceC2368.apply(aVar), "The mapper returned a null SingleSource") : null;
            if (interfaceC3951 == null) {
                EmptyDisposable.complete(interfaceC5102);
            } else {
                interfaceC3951.subscribe(SingleToObservable.m6963(interfaceC5102));
            }
            return true;
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
            return true;
        }
    }
}
