package defpackage;

import android.os.Handler;
import android.os.Message;
import defpackage.AbstractC4585;
import io.reactivex.disposables.C1972;
import java.util.concurrent.TimeUnit;

/* compiled from: HandlerScheduler.java */
/* renamed from: ע, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3291 extends AbstractC4585 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Handler f11548;

    /* compiled from: HandlerScheduler.java */
    /* renamed from: ע$Ϳ, reason: contains not printable characters */
    public static final class C3292 extends AbstractC4585.AbstractC4588 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Handler f11549;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public volatile boolean f11550;

        public C3292(Handler handler) {
            this.f11549 = handler;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11550 = true;
            this.f11549.removeCallbacksAndMessages(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11550;
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: ԩ */
        public InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f11550) {
                return C1972.m6299();
            }
            RunnableC3293 runnableC3293 = new RunnableC3293(this.f11549, C3671.m11805(runnable));
            Message messageObtain = Message.obtain(this.f11549, runnableC3293);
            messageObtain.obj = this;
            this.f11549.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.f11550) {
                return runnableC3293;
            }
            this.f11549.removeCallbacks(runnableC3293);
            return C1972.m6299();
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: ע$Ԩ, reason: contains not printable characters */
    public static final class RunnableC3293 implements Runnable, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Handler f11551;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Runnable f11552;

        /* renamed from: ԭ, reason: contains not printable characters */
        public volatile boolean f11553;

        public RunnableC3293(Handler handler, Runnable runnable) {
            this.f11551 = handler;
            this.f11552 = runnable;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11553 = true;
            this.f11551.removeCallbacks(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11553;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f11552.run();
            } catch (Throwable th) {
                C3671.m11803(th);
            }
        }
    }

    public C3291(Handler handler) {
        this.f11548 = handler;
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ϳ */
    public AbstractC4585.AbstractC4588 mo6986() {
        return new C3292(this.f11548);
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԫ */
    public InterfaceC4478 mo6988(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC3293 runnableC3293 = new RunnableC3293(this.f11548, C3671.m11805(runnable));
        this.f11548.postDelayed(runnableC3293, timeUnit.toMillis(j));
        return runnableC3293;
    }
}
