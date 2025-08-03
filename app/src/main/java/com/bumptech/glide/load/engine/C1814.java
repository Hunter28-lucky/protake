package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.C1824;
import com.bumptech.glide.load.engine.DecodeJob;
import defpackage.AbstractC3541;
import defpackage.C2380;
import defpackage.C2552;
import defpackage.C2964;
import defpackage.C3225;
import defpackage.C3475;
import defpackage.C3537;
import defpackage.C4513;
import defpackage.C4849;
import defpackage.C4904;
import defpackage.C4965;
import defpackage.ExecutorServiceC2561;
import defpackage.InterfaceC3238;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC3889;
import defpackage.InterfaceC4536;
import defpackage.InterfaceC4798;
import defpackage.InterfaceC4966;
import defpackage.a3;
import defpackage.j5;
import java.util.Map;

/* compiled from: Engine.java */
/* renamed from: com.bumptech.glide.load.engine.ՠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1814 implements InterfaceC4966, InterfaceC3889.InterfaceC3890, C1824.InterfaceC1825 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final boolean f5280 = Log.isLoggable("Engine", 2);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C2552 f5281;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C3537 f5282;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC3889 f5283;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C1817 f5284;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C4849 f5285;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C1819 f5286;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C1815 f5287;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C1803 f5288;

    /* compiled from: Engine.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.ՠ$Ϳ, reason: contains not printable characters */
    public static class C1815 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final DecodeJob.InterfaceC1800 f5289;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Pools.Pool<DecodeJob<?>> f5290 = C2380.m8867(150, new C1816());

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f5291;

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.engine.ՠ$Ϳ$Ϳ, reason: contains not printable characters */
        public class C1816 implements C2380.InterfaceC2384<DecodeJob<?>> {
            public C1816() {
            }

            @Override // defpackage.C2380.InterfaceC2384
            /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public DecodeJob<?> mo4957() {
                C1815 c1815 = C1815.this;
                return new DecodeJob<>(c1815.f5289, c1815.f5290);
            }
        }

        public C1815(DecodeJob.InterfaceC1800 interfaceC1800) {
            this.f5289 = interfaceC1800;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public <R> DecodeJob<R> m4956(C2964 c2964, Object obj, C3225 c3225, InterfaceC3773 interfaceC3773, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, AbstractC3541 abstractC3541, Map<Class<?>, a3<?>> map, boolean z, boolean z2, boolean z3, C3475 c3475, DecodeJob.InterfaceC1797<R> interfaceC1797) {
            DecodeJob decodeJob = (DecodeJob) C4513.m13867(this.f5290.acquire());
            int i3 = this.f5291;
            this.f5291 = i3 + 1;
            return decodeJob.m4866(c2964, obj, c3225, interfaceC3773, i, i2, cls, cls2, priority, abstractC3541, map, z, z2, z3, c3475, interfaceC1797, i3);
        }
    }

    /* compiled from: Engine.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.ՠ$Ԩ, reason: contains not printable characters */
    public static class C1817 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ExecutorServiceC2561 f5293;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final ExecutorServiceC2561 f5294;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final ExecutorServiceC2561 f5295;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final ExecutorServiceC2561 f5296;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4966 f5297;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Pools.Pool<C1821<?>> f5298 = C2380.m8867(150, new C1818());

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.engine.ՠ$Ԩ$Ϳ, reason: contains not printable characters */
        public class C1818 implements C2380.InterfaceC2384<C1821<?>> {
            public C1818() {
            }

            @Override // defpackage.C2380.InterfaceC2384
            /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public C1821<?> mo4957() {
                C1817 c1817 = C1817.this;
                return new C1821<>(c1817.f5293, c1817.f5294, c1817.f5295, c1817.f5296, c1817.f5297, c1817.f5298);
            }
        }

        public C1817(ExecutorServiceC2561 executorServiceC2561, ExecutorServiceC2561 executorServiceC25612, ExecutorServiceC2561 executorServiceC25613, ExecutorServiceC2561 executorServiceC25614, InterfaceC4966 interfaceC4966) {
            this.f5293 = executorServiceC2561;
            this.f5294 = executorServiceC25612;
            this.f5295 = executorServiceC25613;
            this.f5296 = executorServiceC25614;
            this.f5297 = interfaceC4966;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public <R> C1821<R> m4959(InterfaceC3773 interfaceC3773, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((C1821) C4513.m13867(this.f5298.acquire())).m4969(interfaceC3773, z, z2, z3, z4);
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.engine.ՠ$Ԫ, reason: contains not printable characters */
    public static class C1819 implements DecodeJob.InterfaceC1800 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC3238.InterfaceC3239 f5300;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public volatile InterfaceC3238 f5301;

        public C1819(InterfaceC3238.InterfaceC3239 interfaceC3239) {
            this.f5300 = interfaceC3239;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.InterfaceC1800
        /* renamed from: Ϳ */
        public InterfaceC3238 mo4890() {
            if (this.f5301 == null) {
                synchronized (this) {
                    if (this.f5301 == null) {
                        this.f5301 = this.f5300.build();
                    }
                    if (this.f5301 == null) {
                        this.f5301 = new C4965();
                    }
                }
            }
            return this.f5301;
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.engine.ՠ$Ԭ, reason: contains not printable characters */
    public static class C1820 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C1821<?> f5302;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final InterfaceC4798 f5303;

        public C1820(InterfaceC4798 interfaceC4798, C1821<?> c1821) {
            this.f5303 = interfaceC4798;
            this.f5302 = c1821;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m4961() {
            this.f5302.m4973(this.f5303);
        }
    }

    public C1814(InterfaceC3889 interfaceC3889, InterfaceC3238.InterfaceC3239 interfaceC3239, ExecutorServiceC2561 executorServiceC2561, ExecutorServiceC2561 executorServiceC25612, ExecutorServiceC2561 executorServiceC25613, ExecutorServiceC2561 executorServiceC25614, boolean z) {
        this(interfaceC3889, interfaceC3239, executorServiceC2561, executorServiceC25612, executorServiceC25613, executorServiceC25614, null, null, null, null, null, null, z);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m4946(String str, long j, InterfaceC3773 interfaceC3773) {
        Log.v("Engine", str + " in " + C4904.m14629(j) + "ms, key: " + interfaceC3773);
    }

    @Override // defpackage.InterfaceC4966
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo4947(C1821<?> c1821, InterfaceC3773 interfaceC3773) {
        j5.m7084();
        this.f5281.m9399(interfaceC3773, c1821);
    }

    @Override // com.bumptech.glide.load.engine.C1824.InterfaceC1825
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo4948(InterfaceC3773 interfaceC3773, C1824<?> c1824) {
        j5.m7084();
        this.f5288.m4910(interfaceC3773);
        if (c1824.m4980()) {
            this.f5283.mo9575(interfaceC3773, c1824);
        } else {
            this.f5285.m14580(c1824);
        }
    }

    @Override // defpackage.InterfaceC4966
    /* renamed from: ԩ, reason: contains not printable characters */
    public void mo4949(C1821<?> c1821, InterfaceC3773 interfaceC3773, C1824<?> c1824) {
        j5.m7084();
        if (c1824 != null) {
            c1824.m4982(interfaceC3773, this);
            if (c1824.m4980()) {
                this.f5288.m4907(interfaceC3773, c1824);
            }
        }
        this.f5281.m9399(interfaceC3773, c1821);
    }

    @Override // defpackage.InterfaceC3889.InterfaceC3890
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo4950(@NonNull InterfaceC4536<?> interfaceC4536) {
        j5.m7084();
        this.f5285.m14580(interfaceC4536);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C1824<?> m4951(InterfaceC3773 interfaceC3773) {
        InterfaceC4536<?> interfaceC4536Mo9577 = this.f5283.mo9577(interfaceC3773);
        if (interfaceC4536Mo9577 == null) {
            return null;
        }
        return interfaceC4536Mo9577 instanceof C1824 ? (C1824) interfaceC4536Mo9577 : new C1824<>(interfaceC4536Mo9577, true, true);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public <R> C1820 m4952(C2964 c2964, Object obj, InterfaceC3773 interfaceC3773, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, AbstractC3541 abstractC3541, Map<Class<?>, a3<?>> map, boolean z, boolean z2, C3475 c3475, boolean z3, boolean z4, boolean z5, boolean z6, InterfaceC4798 interfaceC4798) {
        j5.m7084();
        boolean z7 = f5280;
        long jM14630 = z7 ? C4904.m14630() : 0L;
        C3225 c3225M11479 = this.f5282.m11479(obj, interfaceC3773, i, i2, map, cls, cls2, c3475);
        C1824<?> c1824M4953 = m4953(c3225M11479, z3);
        if (c1824M4953 != null) {
            interfaceC4798.mo5026(c1824M4953, DataSource.MEMORY_CACHE);
            if (z7) {
                m4946("Loaded resource from active resources", jM14630, c3225M11479);
            }
            return null;
        }
        C1824<?> c1824M4954 = m4954(c3225M11479, z3);
        if (c1824M4954 != null) {
            interfaceC4798.mo5026(c1824M4954, DataSource.MEMORY_CACHE);
            if (z7) {
                m4946("Loaded resource from cache", jM14630, c3225M11479);
            }
            return null;
        }
        C1821<?> c1821M9396 = this.f5281.m9396(c3225M11479, z6);
        if (c1821M9396 != null) {
            c1821M9396.m4962(interfaceC4798);
            if (z7) {
                m4946("Added to existing load", jM14630, c3225M11479);
            }
            return new C1820(interfaceC4798, c1821M9396);
        }
        C1821<R> c1821M4959 = this.f5284.m4959(c3225M11479, z3, z4, z5, z6);
        DecodeJob<R> decodeJobM4956 = this.f5287.m4956(c2964, obj, c3225M11479, interfaceC3773, i, i2, cls, cls2, priority, abstractC3541, map, z, z2, z6, c3475, c1821M4959);
        this.f5281.m9398(c3225M11479, c1821M4959);
        c1821M4959.m4962(interfaceC4798);
        c1821M4959.m4974(decodeJobM4956);
        if (z7) {
            m4946("Started new load", jM14630, c3225M11479);
        }
        return new C1820(interfaceC4798, c1821M4959);
    }

    @Nullable
    /* renamed from: ԭ, reason: contains not printable characters */
    public final C1824<?> m4953(InterfaceC3773 interfaceC3773, boolean z) {
        if (!z) {
            return null;
        }
        C1824<?> c1824M4911 = this.f5288.m4911(interfaceC3773);
        if (c1824M4911 != null) {
            c1824M4911.m4976();
        }
        return c1824M4911;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C1824<?> m4954(InterfaceC3773 interfaceC3773, boolean z) {
        if (!z) {
            return null;
        }
        C1824<?> c1824M4951 = m4951(interfaceC3773);
        if (c1824M4951 != null) {
            c1824M4951.m4976();
            this.f5288.m4907(interfaceC3773, c1824M4951);
        }
        return c1824M4951;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4955(InterfaceC4536<?> interfaceC4536) {
        j5.m7084();
        if (!(interfaceC4536 instanceof C1824)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((C1824) interfaceC4536).m4981();
    }

    @VisibleForTesting
    public C1814(InterfaceC3889 interfaceC3889, InterfaceC3238.InterfaceC3239 interfaceC3239, ExecutorServiceC2561 executorServiceC2561, ExecutorServiceC2561 executorServiceC25612, ExecutorServiceC2561 executorServiceC25613, ExecutorServiceC2561 executorServiceC25614, C2552 c2552, C3537 c3537, C1803 c1803, C1817 c1817, C1815 c1815, C4849 c4849, boolean z) {
        this.f5283 = interfaceC3889;
        C1819 c1819 = new C1819(interfaceC3239);
        this.f5286 = c1819;
        C1803 c18032 = c1803 == null ? new C1803(z) : c1803;
        this.f5288 = c18032;
        c18032.m4913(this);
        this.f5282 = c3537 == null ? new C3537() : c3537;
        this.f5281 = c2552 == null ? new C2552() : c2552;
        this.f5284 = c1817 == null ? new C1817(executorServiceC2561, executorServiceC25612, executorServiceC25613, executorServiceC25614, this) : c1817;
        this.f5287 = c1815 == null ? new C1815(c1819) : c1815;
        this.f5285 = c4849 == null ? new C4849() : c4849;
        interfaceC3889.mo9576(this);
    }
}
