package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import defpackage.C2380;
import defpackage.ExecutorServiceC2561;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC4536;
import defpackage.InterfaceC4798;
import defpackage.InterfaceC4966;
import defpackage.i;
import defpackage.j5;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EngineJob.java */
/* renamed from: com.bumptech.glide.load.engine.ֈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1821<R> implements DecodeJob.InterfaceC1797<R>, C2380.InterfaceC2386 {

    /* renamed from: ލ, reason: contains not printable characters */
    public static final C1822 f5304 = new C1822();

    /* renamed from: ގ, reason: contains not printable characters */
    public static final Handler f5305 = new Handler(Looper.getMainLooper(), new C1823());

    /* renamed from: ԫ, reason: contains not printable characters */
    public final List<InterfaceC4798> f5306;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final i f5307;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Pools.Pool<C1821<?>> f5308;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C1822 f5309;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC4966 f5310;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final ExecutorServiceC2561 f5311;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final ExecutorServiceC2561 f5312;

    /* renamed from: ֏, reason: contains not printable characters */
    public final ExecutorServiceC2561 f5313;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final ExecutorServiceC2561 f5314;

    /* renamed from: ؠ, reason: contains not printable characters */
    public InterfaceC3773 f5315;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f5316;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f5317;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f5318;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f5319;

    /* renamed from: ބ, reason: contains not printable characters */
    public InterfaceC4536<?> f5320;

    /* renamed from: ޅ, reason: contains not printable characters */
    public DataSource f5321;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f5322;

    /* renamed from: އ, reason: contains not printable characters */
    public GlideException f5323;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f5324;

    /* renamed from: މ, reason: contains not printable characters */
    public List<InterfaceC4798> f5325;

    /* renamed from: ފ, reason: contains not printable characters */
    public C1824<?> f5326;

    /* renamed from: ދ, reason: contains not printable characters */
    public DecodeJob<R> f5327;

    /* renamed from: ތ, reason: contains not printable characters */
    public volatile boolean f5328;

    /* compiled from: EngineJob.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.ֈ$Ϳ, reason: contains not printable characters */
    public static class C1822 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public <R> C1824<R> m4975(InterfaceC4536<R> interfaceC4536, boolean z) {
            return new C1824<>(interfaceC4536, z, true);
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.engine.ֈ$Ԩ, reason: contains not printable characters */
    public static class C1823 implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            C1821 c1821 = (C1821) message.obj;
            int i = message.what;
            if (i == 1) {
                c1821.m4968();
            } else if (i == 2) {
                c1821.m4967();
            } else {
                if (i != 3) {
                    throw new IllegalStateException("Unrecognized message: " + message.what);
                }
                c1821.m4966();
            }
            return true;
        }
    }

    public C1821(ExecutorServiceC2561 executorServiceC2561, ExecutorServiceC2561 executorServiceC25612, ExecutorServiceC2561 executorServiceC25613, ExecutorServiceC2561 executorServiceC25614, InterfaceC4966 interfaceC4966, Pools.Pool<C1821<?>> pool) {
        this(executorServiceC2561, executorServiceC25612, executorServiceC25613, executorServiceC25614, interfaceC4966, pool, f5304);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC1797
    /* renamed from: Ϳ */
    public void mo4882(InterfaceC4536<R> interfaceC4536, DataSource dataSource) {
        this.f5320 = interfaceC4536;
        this.f5321 = dataSource;
        f5305.obtainMessage(1, this).sendToTarget();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC1797
    /* renamed from: Ԩ */
    public void mo4883(GlideException glideException) {
        this.f5323 = glideException;
        f5305.obtainMessage(2, this).sendToTarget();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC1797
    /* renamed from: ԩ */
    public void mo4884(DecodeJob<?> decodeJob) {
        m4965().execute(decodeJob);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m4962(InterfaceC4798 interfaceC4798) {
        j5.m7084();
        this.f5307.mo6230();
        if (this.f5322) {
            interfaceC4798.mo5026(this.f5326, this.f5321);
        } else if (this.f5324) {
            interfaceC4798.mo5027(this.f5323);
        } else {
            this.f5306.add(interfaceC4798);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4963(InterfaceC4798 interfaceC4798) {
        if (this.f5325 == null) {
            this.f5325 = new ArrayList(2);
        }
        if (this.f5325.contains(interfaceC4798)) {
            return;
        }
        this.f5325.add(interfaceC4798);
    }

    @Override // defpackage.C2380.InterfaceC2386
    @NonNull
    /* renamed from: Ԭ */
    public i mo4858() {
        return this.f5307;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4964() {
        if (this.f5324 || this.f5322 || this.f5328) {
            return;
        }
        this.f5328 = true;
        this.f5327.m4853();
        this.f5310.mo4947(this, this.f5315);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final ExecutorServiceC2561 m4965() {
        return this.f5317 ? this.f5313 : this.f5318 ? this.f5314 : this.f5312;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4966() {
        this.f5307.mo6230();
        if (!this.f5328) {
            throw new IllegalStateException("Not cancelled");
        }
        this.f5310.mo4947(this, this.f5315);
        m4972(false);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4967() {
        this.f5307.mo6230();
        if (this.f5328) {
            m4972(false);
            return;
        }
        if (this.f5306.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
        if (this.f5324) {
            throw new IllegalStateException("Already failed once");
        }
        this.f5324 = true;
        this.f5310.mo4949(this, this.f5315, null);
        for (InterfaceC4798 interfaceC4798 : this.f5306) {
            if (!m4970(interfaceC4798)) {
                interfaceC4798.mo5027(this.f5323);
            }
        }
        m4972(false);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m4968() {
        this.f5307.mo6230();
        if (this.f5328) {
            this.f5320.recycle();
            m4972(false);
            return;
        }
        if (this.f5306.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        if (this.f5322) {
            throw new IllegalStateException("Already have resource");
        }
        C1824<?> c1824M4975 = this.f5309.m4975(this.f5320, this.f5316);
        this.f5326 = c1824M4975;
        this.f5322 = true;
        c1824M4975.m4976();
        this.f5310.mo4949(this, this.f5315, this.f5326);
        int size = this.f5306.size();
        for (int i = 0; i < size; i++) {
            InterfaceC4798 interfaceC4798 = this.f5306.get(i);
            if (!m4970(interfaceC4798)) {
                this.f5326.m4976();
                interfaceC4798.mo5026(this.f5326, this.f5321);
            }
        }
        this.f5326.m4981();
        m4972(false);
    }

    @VisibleForTesting
    /* renamed from: ֏, reason: contains not printable characters */
    public C1821<R> m4969(InterfaceC3773 interfaceC3773, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5315 = interfaceC3773;
        this.f5316 = z;
        this.f5317 = z2;
        this.f5318 = z3;
        this.f5319 = z4;
        return this;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final boolean m4970(InterfaceC4798 interfaceC4798) {
        List<InterfaceC4798> list = this.f5325;
        return list != null && list.contains(interfaceC4798);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean m4971() {
        return this.f5319;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m4972(boolean z) {
        j5.m7084();
        this.f5306.clear();
        this.f5315 = null;
        this.f5326 = null;
        this.f5320 = null;
        List<InterfaceC4798> list = this.f5325;
        if (list != null) {
            list.clear();
        }
        this.f5324 = false;
        this.f5328 = false;
        this.f5322 = false;
        this.f5327.m4875(z);
        this.f5327 = null;
        this.f5323 = null;
        this.f5321 = null;
        this.f5308.release(this);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m4973(InterfaceC4798 interfaceC4798) {
        j5.m7084();
        this.f5307.mo6230();
        if (this.f5322 || this.f5324) {
            m4963(interfaceC4798);
            return;
        }
        this.f5306.remove(interfaceC4798);
        if (this.f5306.isEmpty()) {
            m4964();
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m4974(DecodeJob<R> decodeJob) {
        this.f5327 = decodeJob;
        (decodeJob.m4881() ? this.f5311 : m4965()).execute(decodeJob);
    }

    @VisibleForTesting
    public C1821(ExecutorServiceC2561 executorServiceC2561, ExecutorServiceC2561 executorServiceC25612, ExecutorServiceC2561 executorServiceC25613, ExecutorServiceC2561 executorServiceC25614, InterfaceC4966 interfaceC4966, Pools.Pool<C1821<?>> pool, C1822 c1822) {
        this.f5306 = new ArrayList(2);
        this.f5307 = i.m6228();
        this.f5311 = executorServiceC2561;
        this.f5312 = executorServiceC25612;
        this.f5313 = executorServiceC25613;
        this.f5314 = executorServiceC25614;
        this.f5310 = interfaceC4966;
        this.f5308 = pool;
        this.f5309 = c1822;
    }
}
