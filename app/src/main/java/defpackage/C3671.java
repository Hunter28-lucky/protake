package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.schedulers.C2117;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

/* compiled from: RxJavaPlugins.java */
/* renamed from: ܜ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3671 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static volatile InterfaceC2857<? super Throwable> f12721;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super Runnable, ? extends Runnable> f12722;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> f12723;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> f12724;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> f12725;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> f12726;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC4585, ? extends AbstractC4585> f12727;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC4585, ? extends AbstractC4585> f12728;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC4585, ? extends AbstractC4585> f12729;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC3630, ? extends AbstractC3630> f12730;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC3731, ? extends AbstractC3731> f12731;

    /* renamed from: ֏, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC4262, ? extends AbstractC4262> f12732;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC4945, ? extends AbstractC4945> f12733;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC4274, ? extends AbstractC4274> f12734;

    /* renamed from: ހ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC4838, ? extends AbstractC4838> f12735;

    /* renamed from: ށ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC2900, ? extends AbstractC2900> f12736;

    /* renamed from: ނ, reason: contains not printable characters */
    public static volatile InterfaceC2368<? super AbstractC2624, ? extends AbstractC2624> f12737;

    /* renamed from: ރ, reason: contains not printable characters */
    public static volatile InterfaceC5247<? super AbstractC3630, ? super Subscriber, ? extends Subscriber> f12738;

    /* renamed from: ބ, reason: contains not printable characters */
    public static volatile InterfaceC5247<? super AbstractC4274, ? super InterfaceC5216, ? extends InterfaceC5216> f12739;

    /* renamed from: ޅ, reason: contains not printable characters */
    public static volatile InterfaceC5247<? super AbstractC4262, ? super InterfaceC5102, ? extends InterfaceC5102> f12740;

    /* renamed from: ކ, reason: contains not printable characters */
    public static volatile InterfaceC5247<? super AbstractC4838, ? super InterfaceC4782, ? extends InterfaceC4782> f12741;

    /* renamed from: އ, reason: contains not printable characters */
    public static volatile InterfaceC5247<? super AbstractC2900, ? super InterfaceC5053, ? extends InterfaceC5053> f12742;

    /* renamed from: ވ, reason: contains not printable characters */
    public static volatile InterfaceC2881 f12743;

    /* renamed from: މ, reason: contains not printable characters */
    public static volatile boolean f12744;

    /* renamed from: ފ, reason: contains not printable characters */
    public static volatile boolean f12745;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T, U, R> R m11782(InterfaceC5247<T, U, R> interfaceC5247, T t, U u) {
        try {
            return interfaceC5247.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.m7024(th);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T, R> R m11783(InterfaceC2368<T, R> interfaceC2368, T t) {
        try {
            return interfaceC2368.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.m7024(th);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static AbstractC4585 m11784(InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> interfaceC2368, Callable<AbstractC4585> callable) {
        return (AbstractC4585) C4246.m13353(m11783(interfaceC2368, callable), "Scheduler Callable result can't be null");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static AbstractC4585 m11785(Callable<AbstractC4585> callable) {
        try {
            return (AbstractC4585) C4246.m13353(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.m7024(th);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static AbstractC4585 m11786(ThreadFactory threadFactory) {
        return new C2117((ThreadFactory) C4246.m13353(threadFactory, "threadFactory is null"));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static AbstractC4585 m11787(Callable<AbstractC4585> callable) {
        C4246.m13353(callable, "Scheduler Callable can't be null");
        InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> interfaceC2368 = f12723;
        return interfaceC2368 == null ? m11785(callable) : m11784(interfaceC2368, callable);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static AbstractC4585 m11788(Callable<AbstractC4585> callable) {
        C4246.m13353(callable, "Scheduler Callable can't be null");
        InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> interfaceC2368 = f12725;
        return interfaceC2368 == null ? m11785(callable) : m11784(interfaceC2368, callable);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static AbstractC4585 m11789(Callable<AbstractC4585> callable) {
        C4246.m13353(callable, "Scheduler Callable can't be null");
        InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> interfaceC2368 = f12726;
        return interfaceC2368 == null ? m11785(callable) : m11784(interfaceC2368, callable);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static AbstractC4585 m11790(Callable<AbstractC4585> callable) {
        C4246.m13353(callable, "Scheduler Callable can't be null");
        InterfaceC2368<? super Callable<AbstractC4585>, ? extends AbstractC4585> interfaceC2368 = f12724;
        return interfaceC2368 == null ? m11785(callable) : m11784(interfaceC2368, callable);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static boolean m11791(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static boolean m11792() {
        return f12745;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static AbstractC2900 m11793(AbstractC2900 abstractC2900) {
        InterfaceC2368<? super AbstractC2900, ? extends AbstractC2900> interfaceC2368 = f12736;
        return interfaceC2368 != null ? (AbstractC2900) m11783(interfaceC2368, abstractC2900) : abstractC2900;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static <T> AbstractC3731<T> m11794(AbstractC3731<T> abstractC3731) {
        InterfaceC2368<? super AbstractC3731, ? extends AbstractC3731> interfaceC2368 = f12731;
        return interfaceC2368 != null ? (AbstractC3731) m11783(interfaceC2368, abstractC3731) : abstractC3731;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static <T> AbstractC4945<T> m11795(AbstractC4945<T> abstractC4945) {
        InterfaceC2368<? super AbstractC4945, ? extends AbstractC4945> interfaceC2368 = f12733;
        return interfaceC2368 != null ? (AbstractC4945) m11783(interfaceC2368, abstractC4945) : abstractC4945;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static <T> AbstractC3630<T> m11796(AbstractC3630<T> abstractC3630) {
        InterfaceC2368<? super AbstractC3630, ? extends AbstractC3630> interfaceC2368 = f12730;
        return interfaceC2368 != null ? (AbstractC3630) m11783(interfaceC2368, abstractC3630) : abstractC3630;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static <T> AbstractC4274<T> m11797(AbstractC4274<T> abstractC4274) {
        InterfaceC2368<? super AbstractC4274, ? extends AbstractC4274> interfaceC2368 = f12734;
        return interfaceC2368 != null ? (AbstractC4274) m11783(interfaceC2368, abstractC4274) : abstractC4274;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static <T> AbstractC4262<T> m11798(AbstractC4262<T> abstractC4262) {
        InterfaceC2368<? super AbstractC4262, ? extends AbstractC4262> interfaceC2368 = f12732;
        return interfaceC2368 != null ? (AbstractC4262) m11783(interfaceC2368, abstractC4262) : abstractC4262;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static <T> AbstractC2624<T> m11799(AbstractC2624<T> abstractC2624) {
        InterfaceC2368<? super AbstractC2624, ? extends AbstractC2624> interfaceC2368 = f12737;
        return interfaceC2368 != null ? (AbstractC2624) m11783(interfaceC2368, abstractC2624) : abstractC2624;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static <T> AbstractC4838<T> m11800(AbstractC4838<T> abstractC4838) {
        InterfaceC2368<? super AbstractC4838, ? extends AbstractC4838> interfaceC2368 = f12735;
        return interfaceC2368 != null ? (AbstractC4838) m11783(interfaceC2368, abstractC4838) : abstractC4838;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static boolean m11801() {
        InterfaceC2881 interfaceC2881 = f12743;
        if (interfaceC2881 == null) {
            return false;
        }
        try {
            return interfaceC2881.mo6378();
        } catch (Throwable th) {
            throw ExceptionHelper.m7024(th);
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static AbstractC4585 m11802(AbstractC4585 abstractC4585) {
        InterfaceC2368<? super AbstractC4585, ? extends AbstractC4585> interfaceC2368 = f12727;
        return interfaceC2368 == null ? abstractC4585 : (AbstractC4585) m11783(interfaceC2368, abstractC4585);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static void m11803(Throwable th) {
        InterfaceC2857<? super Throwable> interfaceC2857 = f12721;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m11791(th)) {
            th = new UndeliverableException(th);
        }
        if (interfaceC2857 != null) {
            try {
                interfaceC2857.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m11813(th2);
            }
        }
        th.printStackTrace();
        m11813(th);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static AbstractC4585 m11804(AbstractC4585 abstractC4585) {
        InterfaceC2368<? super AbstractC4585, ? extends AbstractC4585> interfaceC2368 = f12729;
        return interfaceC2368 == null ? abstractC4585 : (AbstractC4585) m11783(interfaceC2368, abstractC4585);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public static Runnable m11805(Runnable runnable) {
        C4246.m13353(runnable, "run is null");
        InterfaceC2368<? super Runnable, ? extends Runnable> interfaceC2368 = f12722;
        return interfaceC2368 == null ? runnable : (Runnable) m11783(interfaceC2368, runnable);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static AbstractC4585 m11806(AbstractC4585 abstractC4585) {
        InterfaceC2368<? super AbstractC4585, ? extends AbstractC4585> interfaceC2368 = f12728;
        return interfaceC2368 == null ? abstractC4585 : (AbstractC4585) m11783(interfaceC2368, abstractC4585);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static InterfaceC5053 m11807(AbstractC2900 abstractC2900, InterfaceC5053 interfaceC5053) {
        InterfaceC5247<? super AbstractC2900, ? super InterfaceC5053, ? extends InterfaceC5053> interfaceC5247 = f12742;
        return interfaceC5247 != null ? (InterfaceC5053) m11782(interfaceC5247, abstractC2900, interfaceC5053) : interfaceC5053;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static <T> InterfaceC5216<? super T> m11808(AbstractC4274<T> abstractC4274, InterfaceC5216<? super T> interfaceC5216) {
        InterfaceC5247<? super AbstractC4274, ? super InterfaceC5216, ? extends InterfaceC5216> interfaceC5247 = f12739;
        return interfaceC5247 != null ? (InterfaceC5216) m11782(interfaceC5247, abstractC4274, interfaceC5216) : interfaceC5216;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static <T> InterfaceC5102<? super T> m11809(AbstractC4262<T> abstractC4262, InterfaceC5102<? super T> interfaceC5102) {
        InterfaceC5247<? super AbstractC4262, ? super InterfaceC5102, ? extends InterfaceC5102> interfaceC5247 = f12740;
        return interfaceC5247 != null ? (InterfaceC5102) m11782(interfaceC5247, abstractC4262, interfaceC5102) : interfaceC5102;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static <T> InterfaceC4782<? super T> m11810(AbstractC4838<T> abstractC4838, InterfaceC4782<? super T> interfaceC4782) {
        InterfaceC5247<? super AbstractC4838, ? super InterfaceC4782, ? extends InterfaceC4782> interfaceC5247 = f12741;
        return interfaceC5247 != null ? (InterfaceC4782) m11782(interfaceC5247, abstractC4838, interfaceC4782) : interfaceC4782;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static <T> Subscriber<? super T> m11811(AbstractC3630<T> abstractC3630, Subscriber<? super T> subscriber) {
        InterfaceC5247<? super AbstractC3630, ? super Subscriber, ? extends Subscriber> interfaceC5247 = f12738;
        return interfaceC5247 != null ? (Subscriber) m11782(interfaceC5247, abstractC3630, subscriber) : subscriber;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static void m11812(InterfaceC2857<? super Throwable> interfaceC2857) {
        if (f12744) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f12721 = interfaceC2857;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static void m11813(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
