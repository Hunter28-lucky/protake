package defpackage;

import androidx.core.app.NotificationCompat;
import com.polidea.rxandroidble2.ClientComponent;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.CertificatePinner;
import okhttp3.internal.connection.RealConnection;
import okio.AsyncTimeout;

/* compiled from: RealCall.kt */
/* renamed from: ǽ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2503 implements InterfaceC5054 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C2861 f9280;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC3415 f9281;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C2506 f9282;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AtomicBoolean f9283;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Object f9284;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C2611 f9285;

    /* renamed from: ֈ, reason: contains not printable characters */
    public RealConnection f9286;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f9287;

    /* renamed from: ׯ, reason: contains not printable characters */
    public C3282 f9288;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f9289;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f9290;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f9291;

    /* renamed from: ނ, reason: contains not printable characters */
    public volatile boolean f9292;

    /* renamed from: ރ, reason: contains not printable characters */
    public volatile C3282 f9293;

    /* renamed from: ބ, reason: contains not printable characters */
    public volatile RealConnection f9294;

    /* renamed from: ޅ, reason: contains not printable characters */
    public final C5121 f9295;

    /* renamed from: ކ, reason: contains not printable characters */
    public final C4539 f9296;

    /* renamed from: އ, reason: contains not printable characters */
    public final boolean f9297;

    /* compiled from: RealCall.kt */
    /* renamed from: ǽ$Ϳ, reason: contains not printable characters */
    public final class RunnableC2504 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public volatile AtomicInteger f9298;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC3428 f9299;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2503 f9300;

        public RunnableC2504(C2503 c2503, InterfaceC3428 interfaceC3428) {
            C3921.m12667(interfaceC3428, "responseCallback");
            this.f9300 = c2503;
            this.f9299 = interfaceC3428;
            this.f9298 = new AtomicInteger(0);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Throwable th;
            IOException e2;
            C2319 c2319M14961;
            String str = "OkHttp " + this.f9300.m9243();
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "currentThread");
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                try {
                    this.f9300.f9282.enter();
                    try {
                        z = true;
                        try {
                            this.f9299.onResponse(this.f9300, this.f9300.m9239());
                            c2319M14961 = this.f9300.m9233().m14961();
                        } catch (IOException e3) {
                            e2 = e3;
                            if (z) {
                                C2708.f10025.m9964().m9955("Callback failure for " + this.f9300.m9249(), 4, e2);
                            } else {
                                this.f9299.onFailure(this.f9300, e2);
                            }
                            c2319M14961 = this.f9300.m9233().m14961();
                            c2319M14961.m8718(this);
                        } catch (Throwable th2) {
                            th = th2;
                            this.f9300.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                iOException.addSuppressed(th);
                                this.f9299.onFailure(this.f9300, iOException);
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        z = false;
                        e2 = e4;
                    } catch (Throwable th3) {
                        z = false;
                        th = th3;
                    }
                    c2319M14961.m8718(this);
                } catch (Throwable th4) {
                    this.f9300.m9233().m14961().m8718(this);
                    throw th4;
                }
            } finally {
                threadCurrentThread.setName(name);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m9250(ExecutorService executorService) {
            C3921.m12667(executorService, "executorService");
            C2319 c2319M14961 = this.f9300.m9233().m14961();
            if (i5.f6770 && Thread.holdsLock(c2319M14961)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                C3921.m12663(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c2319M14961);
                throw new AssertionError(sb.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    this.f9300.m9242(interruptedIOException);
                    this.f9299.onFailure(this.f9300, interruptedIOException);
                    this.f9300.m9233().m14961().m8718(this);
                }
            } catch (Throwable th) {
                this.f9300.m9233().m14961().m8718(this);
                throw th;
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C2503 m9251() {
            return this.f9300;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final AtomicInteger m9252() {
            return this.f9298;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final String m9253() {
            return this.f9300.m9238().m13925().m11532();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final void m9254(RunnableC2504 runnableC2504) {
            C3921.m12667(runnableC2504, "other");
            this.f9298 = runnableC2504.f9298;
        }
    }

    /* compiled from: RealCall.kt */
    /* renamed from: ǽ$Ԩ, reason: contains not printable characters */
    public static final class C2505 extends WeakReference<C2503> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Object f9301;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2505(C2503 c2503, Object obj) {
            super(c2503);
            C3921.m12667(c2503, "referent");
            this.f9301 = obj;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Object m9255() {
            return this.f9301;
        }
    }

    /* compiled from: RealCall.kt */
    /* renamed from: ǽ$Ԫ, reason: contains not printable characters */
    public static final class C2506 extends AsyncTimeout {
        public C2506() {
        }

        @Override // okio.AsyncTimeout
        public void timedOut() throws IOException {
            C2503.this.cancel();
        }
    }

    public C2503(C5121 c5121, C4539 c4539, boolean z) {
        C3921.m12667(c5121, "client");
        C3921.m12667(c4539, "originalRequest");
        this.f9295 = c5121;
        this.f9296 = c4539;
        this.f9297 = z;
        this.f9280 = c5121.m14958().m15169();
        this.f9281 = c5121.m14963().create(this);
        C2506 c2506 = new C2506();
        c2506.timeout(c5121.m14954(), TimeUnit.MILLISECONDS);
        this.f9282 = c2506;
        this.f9283 = new AtomicBoolean();
        this.f9291 = true;
    }

    @Override // defpackage.InterfaceC5054
    public void cancel() throws IOException {
        if (this.f9292) {
            return;
        }
        this.f9292 = true;
        C3282 c3282 = this.f9293;
        if (c3282 != null) {
            c3282.m10957();
        }
        RealConnection realConnection = this.f9294;
        if (realConnection != null) {
            realConnection.m7801();
        }
        this.f9281.canceled(this);
    }

    @Override // defpackage.InterfaceC5054
    public C4770 execute() {
        if (!this.f9283.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f9282.enter();
        m9228();
        try {
            this.f9295.m14961().m8714(this);
            return m9239();
        } finally {
            this.f9295.m14961().m8719(this);
        }
    }

    @Override // defpackage.InterfaceC5054
    public boolean isCanceled() {
        return this.f9292;
    }

    @Override // defpackage.InterfaceC5054
    public C4539 request() {
        return this.f9296;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m9225(RealConnection realConnection) {
        C3921.m12667(realConnection, "connection");
        if (!i5.f6770 || Thread.holdsLock(realConnection)) {
            if (!(this.f9286 == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.f9286 = realConnection;
            realConnection.m7811().add(new C2505(this, this.f9284));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        C3921.m12663(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(realConnection);
        throw new AssertionError(sb.toString());
    }

    @Override // defpackage.InterfaceC5054
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo9226(InterfaceC3428 interfaceC3428) {
        C3921.m12667(interfaceC3428, "responseCallback");
        if (!this.f9283.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        m9228();
        this.f9295.m14961().m8713(new RunnableC2504(this, interfaceC3428));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final <E extends IOException> E m9227(E e2) throws IOException {
        Socket socketM9244;
        boolean z = i5.f6770;
        if (z && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        RealConnection realConnection = this.f9286;
        if (realConnection != null) {
            if (z && Thread.holdsLock(realConnection)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread threadCurrentThread2 = Thread.currentThread();
                C3921.m12663(threadCurrentThread2, "Thread.currentThread()");
                sb2.append(threadCurrentThread2.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(realConnection);
                throw new AssertionError(sb2.toString());
            }
            synchronized (realConnection) {
                socketM9244 = m9244();
            }
            if (this.f9286 == null) {
                if (socketM9244 != null) {
                    i5.m6241(socketM9244);
                }
                this.f9281.connectionReleased(this, realConnection);
            } else {
                if (!(socketM9244 == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e3 = (E) m9248(e2);
        if (e2 != null) {
            AbstractC3415 abstractC3415 = this.f9281;
            if (e3 == null) {
                C3921.m12675();
            }
            abstractC3415.callFailed(this, e3);
        } else {
            this.f9281.callEnd(this);
        }
        return e3;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m9228() {
        this.f9284 = C2708.f10025.m9964().mo9953("response.body().close()");
        this.f9281.callStart(this);
    }

    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C2503 clone() {
        return new C2503(this.f9295, this.f9296, this.f9297);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C3972 m9230(C3573 c3573) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierM14967;
        CertificatePinner certificatePinnerM14956;
        if (c3573.m11533()) {
            SSLSocketFactory sSLSocketFactoryM14980 = this.f9295.m14980();
            hostnameVerifierM14967 = this.f9295.m14967();
            sSLSocketFactory = sSLSocketFactoryM14980;
            certificatePinnerM14956 = this.f9295.m14956();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierM14967 = null;
            certificatePinnerM14956 = null;
        }
        return new C3972(c3573.m11532(), c3573.m11537(), this.f9295.m14962(), this.f9295.m14979(), sSLSocketFactory, hostnameVerifierM14967, certificatePinnerM14956, this.f9295.m14975(), this.f9295.m14974(), this.f9295.m14973(), this.f9295.m14959(), this.f9295.m14976());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m9231(C4539 c4539, boolean z) {
        C3921.m12667(c4539, "request");
        if (!(this.f9288 == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.f9290)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.f9289)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            i4 i4Var = i4.f6762;
        }
        if (z) {
            this.f9285 = new C2611(this.f9280, m9230(c4539.m13925()), this, this.f9281);
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m9232(boolean z) {
        C3282 c3282;
        synchronized (this) {
            if (!this.f9291) {
                throw new IllegalStateException("released".toString());
            }
            i4 i4Var = i4.f6762;
        }
        if (z && (c3282 = this.f9293) != null) {
            c3282.m10959();
        }
        this.f9288 = null;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final C5121 m9233() {
        return this.f9295;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final RealConnection m9234() {
        return this.f9286;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final AbstractC3415 m9235() {
        return this.f9281;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final boolean m9236() {
        return this.f9297;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final C3282 m9237() {
        return this.f9288;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final C4539 m9238() {
        return this.f9296;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3  */
    /* renamed from: ނ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final defpackage.C4770 m9239() throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            လ r0 = r11.f9295
            java.util.List r0 = r0.m14968()
            defpackage.C3864.m12311(r2, r0)
            ѭ r0 = new ѭ
            လ r1 = r11.f9295
            r0.<init>(r1)
            r2.add(r0)
            ߊ r0 = new ߊ
            လ r1 = r11.f9295
            х r1 = r1.m14960()
            r0.<init>(r1)
            r2.add(r0)
            ɿ r0 = new ɿ
            လ r1 = r11.f9295
            ܙ r1 = r1.m14953()
            r0.<init>(r1)
            r2.add(r0)
            ཡ r0 = defpackage.C5056.f16837
            r2.add(r0)
            boolean r0 = r11.f9297
            if (r0 != 0) goto L46
            လ r0 = r11.f9295
            java.util.List r0 = r0.m14970()
            defpackage.C3864.m12311(r2, r0)
        L46:
            າ r0 = new າ
            boolean r1 = r11.f9297
            r0.<init>(r1)
            r2.add(r0)
            ݡ r9 = new ݡ
            r3 = 0
            r4 = 0
            థ r5 = r11.f9296
            လ r0 = r11.f9295
            int r6 = r0.m14957()
            လ r0 = r11.f9295
            int r7 = r0.m14977()
            လ r0 = r11.f9295
            int r8 = r0.m14982()
            r0 = r9
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            థ r2 = r11.f9296     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            අ r2 = r9.mo10160(r2)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            boolean r3 = r11.isCanceled()     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            if (r3 != 0) goto L7f
            r11.m9242(r1)
            return r2
        L7f:
            defpackage.i5.m6240(r2)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            throw r2     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
        L8a:
            r2 = move-exception
            goto La1
        L8c:
            r0 = move-exception
            r2 = 1
            java.io.IOException r0 = r11.m9242(r0)     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L9c
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L9d
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9c:
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9d:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
        La1:
            if (r0 != 0) goto La6
            r11.m9242(r1)
        La6:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C2503.m9239():අ");
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final C3282 m9240(C3739 c3739) throws IOException {
        C3921.m12667(c3739, "chain");
        synchronized (this) {
            if (!this.f9291) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.f9290)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.f9289)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            i4 i4Var = i4.f6762;
        }
        C2611 c2611 = this.f9285;
        if (c2611 == null) {
            C3921.m12675();
        }
        C3282 c3282 = new C3282(this, this.f9281, c2611, c2611.m9546(this.f9295, c3739));
        this.f9288 = c3282;
        this.f9293 = c3282;
        synchronized (this) {
            this.f9289 = true;
            this.f9290 = true;
        }
        if (this.f9292) {
            throw new IOException("Canceled");
        }
        return c3282;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final <E extends IOException> E m9241(C3282 c3282, boolean z, boolean z2, E e2) {
        boolean z3;
        C3921.m12667(c3282, "exchange");
        boolean z4 = true;
        if (!C3921.m12662(c3282, this.f9293)) {
            return e2;
        }
        synchronized (this) {
            z3 = false;
            if (z) {
                try {
                    if (!this.f9289) {
                        if (z2 || !this.f9290) {
                            z4 = false;
                        }
                    }
                    if (z) {
                        this.f9289 = false;
                    }
                    if (z2) {
                        this.f9290 = false;
                    }
                    boolean z5 = this.f9289;
                    boolean z6 = (z5 || this.f9290) ? false : true;
                    if (z5 || this.f9290 || this.f9291) {
                        z4 = false;
                    }
                    z3 = z6;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z2) {
                }
                z4 = false;
            }
            i4 i4Var = i4.f6762;
        }
        if (z3) {
            this.f9293 = null;
            RealConnection realConnection = this.f9286;
            if (realConnection != null) {
                realConnection.m7816();
            }
        }
        return z4 ? (E) m9227(e2) : e2;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final IOException m9242(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.f9291) {
                this.f9291 = false;
                if (!this.f9289 && !this.f9290) {
                    z = true;
                }
            }
            i4 i4Var = i4.f6762;
        }
        return z ? m9227(iOException) : iOException;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final String m9243() {
        return this.f9296.m13925().m11541();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final Socket m9244() {
        RealConnection realConnection = this.f9286;
        if (realConnection == null) {
            C3921.m12675();
        }
        if (i5.f6770 && !Thread.holdsLock(realConnection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnection);
            throw new AssertionError(sb.toString());
        }
        List<Reference<C2503>> listM7811 = realConnection.m7811();
        Iterator<Reference<C2503>> it = listM7811.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (C3921.m12662(it.next().get(), this)) {
                break;
            }
            i++;
        }
        if (!(i != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        listM7811.remove(i);
        this.f9286 = null;
        if (listM7811.isEmpty()) {
            realConnection.m7825(System.nanoTime());
            if (this.f9280.m10200(realConnection)) {
                return realConnection.m7827();
            }
        }
        return null;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final boolean m9245() {
        C2611 c2611 = this.f9285;
        if (c2611 == null) {
            C3921.m12675();
        }
        return c2611.m9550();
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m9246(RealConnection realConnection) {
        this.f9294 = realConnection;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m9247() {
        if (!(!this.f9287)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f9287 = true;
        this.f9282.exit();
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final <E extends IOException> E m9248(E e2) {
        if (this.f9287 || !this.f9282.exit()) {
            return e2;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(ClientComponent.NamedSchedulers.TIMEOUT);
        if (e2 != null) {
            interruptedIOException.initCause(e2);
        }
        return interruptedIOException;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final String m9249() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f9297 ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(m9243());
        return sb.toString();
    }
}
