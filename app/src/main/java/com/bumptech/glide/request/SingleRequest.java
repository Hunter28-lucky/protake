package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.C1814;
import com.bumptech.glide.load.engine.GlideException;
import defpackage.C2380;
import defpackage.C2964;
import defpackage.C3900;
import defpackage.C4904;
import defpackage.C5026;
import defpackage.InterfaceC2839;
import defpackage.InterfaceC3684;
import defpackage.InterfaceC4536;
import defpackage.InterfaceC4752;
import defpackage.InterfaceC4798;
import defpackage.InterfaceC4828;
import defpackage.c1;
import defpackage.i;
import defpackage.j5;
import defpackage.m3;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements InterfaceC3684, InterfaceC4752, InterfaceC4798, C2380.InterfaceC2386 {

    /* renamed from: ސ, reason: contains not printable characters */
    public static final Pools.Pool<SingleRequest<?>> f5391 = C2380.m8867(150, new C1841());

    /* renamed from: ޑ, reason: contains not printable characters */
    public static final boolean f5392 = Log.isLoggable("Request", 2);

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f5393;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @Nullable
    public final String f5394;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final i f5395;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public InterfaceC4828<R> f5396;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC2839 f5397;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Context f5398;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C2964 f5399;

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public Object f5400;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Class<R> f5401;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C3900 f5402;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f5403;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f5404;

    /* renamed from: ނ, reason: contains not printable characters */
    public Priority f5405;

    /* renamed from: ރ, reason: contains not printable characters */
    public c1<R> f5406;

    /* renamed from: ބ, reason: contains not printable characters */
    public InterfaceC4828<R> f5407;

    /* renamed from: ޅ, reason: contains not printable characters */
    public C1814 f5408;

    /* renamed from: ކ, reason: contains not printable characters */
    public m3<? super R> f5409;

    /* renamed from: އ, reason: contains not printable characters */
    public InterfaceC4536<R> f5410;

    /* renamed from: ވ, reason: contains not printable characters */
    public C1814.C1820 f5411;

    /* renamed from: މ, reason: contains not printable characters */
    public long f5412;

    /* renamed from: ފ, reason: contains not printable characters */
    public Status f5413;

    /* renamed from: ދ, reason: contains not printable characters */
    public Drawable f5414;

    /* renamed from: ތ, reason: contains not printable characters */
    public Drawable f5415;

    /* renamed from: ލ, reason: contains not printable characters */
    public Drawable f5416;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f5417;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f5418;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    /* renamed from: com.bumptech.glide.request.SingleRequest$Ϳ, reason: contains not printable characters */
    public class C1841 implements C2380.InterfaceC2384<SingleRequest<?>> {
        @Override // defpackage.C2380.InterfaceC2384
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public SingleRequest<?> mo4957() {
            return new SingleRequest<>();
        }
    }

    public SingleRequest() {
        this.f5394 = f5392 ? String.valueOf(super.hashCode()) : null;
        this.f5395 = i.m6228();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static int m5024(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public static <R> SingleRequest<R> m5025(Context context, C2964 c2964, Object obj, Class<R> cls, C3900 c3900, int i, int i2, Priority priority, c1<R> c1Var, InterfaceC4828<R> interfaceC4828, InterfaceC4828<R> interfaceC48282, InterfaceC2839 interfaceC2839, C1814 c1814, m3<? super R> m3Var) {
        SingleRequest<R> singleRequest = (SingleRequest) f5391.acquire();
        if (singleRequest == null) {
            singleRequest = new SingleRequest<>();
        }
        singleRequest.m5041(context, c2964, obj, cls, c3900, i, i2, priority, c1Var, interfaceC4828, interfaceC48282, interfaceC2839, c1814, m3Var);
        return singleRequest;
    }

    @Override // defpackage.InterfaceC3684
    public void clear() {
        j5.m7084();
        m5031();
        this.f5395.mo6230();
        Status status = this.f5413;
        Status status2 = Status.CLEARED;
        if (status == status2) {
            return;
        }
        m5037();
        InterfaceC4536<R> interfaceC4536 = this.f5410;
        if (interfaceC4536 != null) {
            m5049(interfaceC4536);
        }
        if (m5033()) {
            this.f5406.mo182(m5040());
        }
        this.f5413 = status2;
    }

    @Override // defpackage.InterfaceC3684
    public boolean isCancelled() {
        Status status = this.f5413;
        return status == Status.CANCELLED || status == Status.CLEARED;
    }

    @Override // defpackage.InterfaceC3684
    public boolean isComplete() {
        return this.f5413 == Status.COMPLETE;
    }

    @Override // defpackage.InterfaceC3684
    public boolean isRunning() {
        Status status = this.f5413;
        return status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
    }

    @Override // defpackage.InterfaceC3684
    public void pause() {
        clear();
        this.f5413 = Status.PAUSED;
    }

    @Override // defpackage.InterfaceC3684
    public void recycle() {
        m5031();
        this.f5398 = null;
        this.f5399 = null;
        this.f5400 = null;
        this.f5401 = null;
        this.f5402 = null;
        this.f5403 = -1;
        this.f5404 = -1;
        this.f5406 = null;
        this.f5407 = null;
        this.f5396 = null;
        this.f5397 = null;
        this.f5409 = null;
        this.f5411 = null;
        this.f5414 = null;
        this.f5415 = null;
        this.f5416 = null;
        this.f5417 = -1;
        this.f5418 = -1;
        f5391.release(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.InterfaceC4798
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo5026(InterfaceC4536<?> interfaceC4536, DataSource dataSource) {
        this.f5395.mo6230();
        this.f5411 = null;
        if (interfaceC4536 == null) {
            mo5027(new GlideException("Expected to receive a Resource<R> with an object of " + this.f5401 + " inside, but instead got null."));
            return;
        }
        Object obj = interfaceC4536.get();
        if (obj != null && this.f5401.isAssignableFrom(obj.getClass())) {
            if (m5036()) {
                m5048(interfaceC4536, obj, dataSource);
                return;
            } else {
                m5049(interfaceC4536);
                this.f5413 = Status.COMPLETE;
                return;
            }
        }
        m5049(interfaceC4536);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.f5401);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : "");
        sb.append("{");
        sb.append(obj);
        sb.append("} inside Resource{");
        sb.append(interfaceC4536);
        sb.append("}.");
        sb.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        mo5027(new GlideException(sb.toString()));
    }

    @Override // defpackage.InterfaceC4798
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo5027(GlideException glideException) {
        m5047(glideException, 5);
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean mo5028(InterfaceC3684 interfaceC3684) {
        if (!(interfaceC3684 instanceof SingleRequest)) {
            return false;
        }
        SingleRequest singleRequest = (SingleRequest) interfaceC3684;
        if (this.f5403 != singleRequest.f5403 || this.f5404 != singleRequest.f5404 || !j5.m7085(this.f5400, singleRequest.f5400) || !this.f5401.equals(singleRequest.f5401) || !this.f5402.equals(singleRequest.f5402) || this.f5405 != singleRequest.f5405) {
            return false;
        }
        InterfaceC4828<R> interfaceC4828 = this.f5407;
        InterfaceC4828<R> interfaceC48282 = singleRequest.f5407;
        if (interfaceC4828 != null) {
            if (interfaceC48282 == null) {
                return false;
            }
        } else if (interfaceC48282 != null) {
            return false;
        }
        return true;
    }

    @Override // defpackage.InterfaceC4752
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo5029(int i, int i2) {
        this.f5395.mo6230();
        boolean z = f5392;
        if (z) {
            m5044("Got onSizeReady in " + C4904.m14629(this.f5412));
        }
        if (this.f5413 != Status.WAITING_FOR_SIZE) {
            return;
        }
        Status status = Status.RUNNING;
        this.f5413 = status;
        float fM12603 = this.f5402.m12603();
        this.f5417 = m5024(i, fM12603);
        this.f5418 = m5024(i2, fM12603);
        if (z) {
            m5044("finished setup for calling load in " + C4904.m14629(this.f5412));
        }
        this.f5411 = this.f5408.m4952(this.f5399, this.f5400, this.f5402.m12602(), this.f5417, this.f5418, this.f5402.m12601(), this.f5401, this.f5405, this.f5402.m12589(), this.f5402.m12605(), this.f5402.m12613(), this.f5402.m12610(), this.f5402.m12595(), this.f5402.m12608(), this.f5402.m12607(), this.f5402.m12606(), this.f5402.m12594(), this);
        if (this.f5413 != status) {
            this.f5411 = null;
        }
        if (z) {
            m5044("finished onSizeReady in " + C4904.m14629(this.f5412));
        }
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean mo5030() {
        return isComplete();
    }

    @Override // defpackage.C2380.InterfaceC2386
    @NonNull
    /* renamed from: Ԭ */
    public i mo4858() {
        return this.f5395;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m5031() {
        if (this.f5393) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean mo5032() {
        return this.f5413 == Status.FAILED;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean m5033() {
        InterfaceC2839 interfaceC2839 = this.f5397;
        return interfaceC2839 == null || interfaceC2839.mo7475(this);
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ՠ, reason: contains not printable characters */
    public void mo5034() {
        m5031();
        this.f5395.mo6230();
        this.f5412 = C4904.m14630();
        if (this.f5400 == null) {
            if (j5.m7101(this.f5403, this.f5404)) {
                this.f5417 = this.f5403;
                this.f5418 = this.f5404;
            }
            m5047(new GlideException("Received null model"), m5039() == null ? 5 : 3);
            return;
        }
        Status status = this.f5413;
        Status status2 = Status.RUNNING;
        if (status == status2) {
            throw new IllegalArgumentException("Cannot restart a running request");
        }
        if (status == Status.COMPLETE) {
            mo5026(this.f5410, DataSource.MEMORY_CACHE);
            return;
        }
        Status status3 = Status.WAITING_FOR_SIZE;
        this.f5413 = status3;
        if (j5.m7101(this.f5403, this.f5404)) {
            mo5029(this.f5403, this.f5404);
        } else {
            this.f5406.mo175(this);
        }
        Status status4 = this.f5413;
        if ((status4 == status2 || status4 == status3) && m5035()) {
            this.f5406.mo180(m5040());
        }
        if (f5392) {
            m5044("finished run method in " + C4904.m14629(this.f5412));
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean m5035() {
        InterfaceC2839 interfaceC2839 = this.f5397;
        return interfaceC2839 == null || interfaceC2839.mo7476(this);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean m5036() {
        InterfaceC2839 interfaceC2839 = this.f5397;
        return interfaceC2839 == null || interfaceC2839.mo7477(this);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m5037() {
        m5031();
        this.f5395.mo6230();
        this.f5406.mo177(this);
        this.f5413 = Status.CANCELLED;
        C1814.C1820 c1820 = this.f5411;
        if (c1820 != null) {
            c1820.m4961();
            this.f5411 = null;
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final Drawable m5038() {
        if (this.f5414 == null) {
            Drawable drawableM12591 = this.f5402.m12591();
            this.f5414 = drawableM12591;
            if (drawableM12591 == null && this.f5402.m12590() > 0) {
                this.f5414 = m5043(this.f5402.m12590());
            }
        }
        return this.f5414;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final Drawable m5039() {
        if (this.f5416 == null) {
            Drawable drawableM12592 = this.f5402.m12592();
            this.f5416 = drawableM12592;
            if (drawableM12592 == null && this.f5402.m12593() > 0) {
                this.f5416 = m5043(this.f5402.m12593());
            }
        }
        return this.f5416;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final Drawable m5040() {
        if (this.f5415 == null) {
            Drawable drawableM12598 = this.f5402.m12598();
            this.f5415 = drawableM12598;
            if (drawableM12598 == null && this.f5402.m12599() > 0) {
                this.f5415 = m5043(this.f5402.m12599());
            }
        }
        return this.f5415;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m5041(Context context, C2964 c2964, Object obj, Class<R> cls, C3900 c3900, int i, int i2, Priority priority, c1<R> c1Var, InterfaceC4828<R> interfaceC4828, InterfaceC4828<R> interfaceC48282, InterfaceC2839 interfaceC2839, C1814 c1814, m3<? super R> m3Var) {
        this.f5398 = context;
        this.f5399 = c2964;
        this.f5400 = obj;
        this.f5401 = cls;
        this.f5402 = c3900;
        this.f5403 = i;
        this.f5404 = i2;
        this.f5405 = priority;
        this.f5406 = c1Var;
        this.f5396 = interfaceC4828;
        this.f5407 = interfaceC48282;
        this.f5397 = interfaceC2839;
        this.f5408 = c1814;
        this.f5409 = m3Var;
        this.f5413 = Status.PENDING;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final boolean m5042() {
        InterfaceC2839 interfaceC2839 = this.f5397;
        return interfaceC2839 == null || !interfaceC2839.mo7474();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final Drawable m5043(@DrawableRes int i) {
        return C5026.m14815(this.f5399, i, this.f5402.m12604() != null ? this.f5402.m12604() : this.f5398.getTheme());
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m5044(String str) {
        Log.v("Request", str + " this: " + this.f5394);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m5045() {
        InterfaceC2839 interfaceC2839 = this.f5397;
        if (interfaceC2839 != null) {
            interfaceC2839.mo7472(this);
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m5046() {
        InterfaceC2839 interfaceC2839 = this.f5397;
        if (interfaceC2839 != null) {
            interfaceC2839.mo7473(this);
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m5047(GlideException glideException, int i) {
        InterfaceC4828<R> interfaceC4828;
        this.f5395.mo6230();
        int iM10376 = this.f5399.m10376();
        if (iM10376 <= i) {
            Log.w("Glide", "Load failed for " + this.f5400 + " with size [" + this.f5417 + "x" + this.f5418 + "]", glideException);
            if (iM10376 <= 4) {
                glideException.m4902("Glide");
            }
        }
        this.f5411 = null;
        this.f5413 = Status.FAILED;
        this.f5393 = true;
        try {
            InterfaceC4828<R> interfaceC48282 = this.f5407;
            if ((interfaceC48282 == null || !interfaceC48282.m14561(glideException, this.f5400, this.f5406, m5042())) && ((interfaceC4828 = this.f5396) == null || !interfaceC4828.m14561(glideException, this.f5400, this.f5406, m5042()))) {
                m5050();
            }
            this.f5393 = false;
            m5045();
        } catch (Throwable th) {
            this.f5393 = false;
            throw th;
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m5048(InterfaceC4536<R> interfaceC4536, R r, DataSource dataSource) {
        InterfaceC4828<R> interfaceC4828;
        boolean zM5042 = m5042();
        this.f5413 = Status.COMPLETE;
        this.f5410 = interfaceC4536;
        if (this.f5399.m10376() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.f5400 + " with size [" + this.f5417 + "x" + this.f5418 + "] in " + C4904.m14629(this.f5412) + " ms");
        }
        this.f5393 = true;
        try {
            InterfaceC4828<R> interfaceC48282 = this.f5407;
            if ((interfaceC48282 == null || !interfaceC48282.m14562(r, this.f5400, this.f5406, dataSource, zM5042)) && ((interfaceC4828 = this.f5396) == null || !interfaceC4828.m14562(r, this.f5400, this.f5406, dataSource, zM5042))) {
                this.f5406.mo179(r, this.f5409.mo7537(dataSource, zM5042));
            }
            this.f5393 = false;
            m5046();
        } catch (Throwable th) {
            this.f5393 = false;
            throw th;
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m5049(InterfaceC4536<?> interfaceC4536) {
        this.f5408.m4955(interfaceC4536);
        this.f5410 = null;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m5050() {
        if (m5035()) {
            Drawable drawableM5039 = this.f5400 == null ? m5039() : null;
            if (drawableM5039 == null) {
                drawableM5039 = m5038();
            }
            if (drawableM5039 == null) {
                drawableM5039 = m5040();
            }
            this.f5406.mo178(drawableM5039);
        }
    }
}
