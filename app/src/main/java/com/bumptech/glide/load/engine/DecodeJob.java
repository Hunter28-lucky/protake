package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.C1812;
import com.bumptech.glide.load.engine.InterfaceC1809;
import com.bumptech.glide.load.resource.bitmap.C1835;
import defpackage.AbstractC3541;
import defpackage.C2380;
import defpackage.C2851;
import defpackage.C2964;
import defpackage.C3225;
import defpackage.C3442;
import defpackage.C3475;
import defpackage.C3854;
import defpackage.C4238;
import defpackage.C4564;
import defpackage.C4904;
import defpackage.C5147;
import defpackage.InterfaceC2866;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC3238;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC4190;
import defpackage.InterfaceC4536;
import defpackage.InterfaceC4797;
import defpackage.a3;
import defpackage.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DecodeJob<R> implements InterfaceC1809.InterfaceC1810, Runnable, Comparable<DecodeJob<?>>, C2380.InterfaceC2386 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC1800 f5182;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final Pools.Pool<DecodeJob<?>> f5183;

    /* renamed from: ֏, reason: contains not printable characters */
    public C2964 f5186;

    /* renamed from: ׯ, reason: contains not printable characters */
    public InterfaceC3773 f5187;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Priority f5188;

    /* renamed from: ހ, reason: contains not printable characters */
    public C3225 f5189;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f5190;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f5191;

    /* renamed from: ރ, reason: contains not printable characters */
    public AbstractC3541 f5192;

    /* renamed from: ބ, reason: contains not printable characters */
    public C3475 f5193;

    /* renamed from: ޅ, reason: contains not printable characters */
    public InterfaceC1797<R> f5194;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f5195;

    /* renamed from: އ, reason: contains not printable characters */
    public Stage f5196;

    /* renamed from: ވ, reason: contains not printable characters */
    public RunReason f5197;

    /* renamed from: މ, reason: contains not printable characters */
    public long f5198;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f5199;

    /* renamed from: ދ, reason: contains not printable characters */
    public Object f5200;

    /* renamed from: ތ, reason: contains not printable characters */
    public Thread f5201;

    /* renamed from: ލ, reason: contains not printable characters */
    public InterfaceC3773 f5202;

    /* renamed from: ގ, reason: contains not printable characters */
    public InterfaceC3773 f5203;

    /* renamed from: ޏ, reason: contains not printable characters */
    public Object f5204;

    /* renamed from: ސ, reason: contains not printable characters */
    public DataSource f5205;

    /* renamed from: ޑ, reason: contains not printable characters */
    public InterfaceC3129<?> f5206;

    /* renamed from: ޒ, reason: contains not printable characters */
    public volatile InterfaceC1809 f5207;

    /* renamed from: ޓ, reason: contains not printable characters */
    public volatile boolean f5208;

    /* renamed from: ޔ, reason: contains not printable characters */
    public volatile boolean f5209;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C1811<R> f5179 = new C1811<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final List<Throwable> f5180 = new ArrayList();

    /* renamed from: ԭ, reason: contains not printable characters */
    public final i f5181 = i.m6228();

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C1799<?> f5184 = new C1799<>();

    /* renamed from: ֈ, reason: contains not printable characters */
    public final C1801 f5185 = new C1801();

    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C1796 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f5221;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f5222;

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f5223;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f5223 = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5223[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f5222 = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5222[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5222[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5222[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5222[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f5221 = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5221[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5221[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1797<R> {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4882(InterfaceC4536<R> interfaceC4536, DataSource dataSource);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo4883(GlideException glideException);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo4884(DecodeJob<?> decodeJob);
    }

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$Ԫ, reason: contains not printable characters */
    public final class C1798<Z> implements C1812.InterfaceC1813<Z> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final DataSource f5224;

        public C1798(DataSource dataSource) {
            this.f5224 = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.C1812.InterfaceC1813
        @NonNull
        /* renamed from: Ϳ, reason: contains not printable characters */
        public InterfaceC4536<Z> mo4885(@NonNull InterfaceC4536<Z> interfaceC4536) {
            return DecodeJob.this.m4874(this.f5224, interfaceC4536);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$Ԭ, reason: contains not printable characters */
    public static class C1799<Z> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public InterfaceC3773 f5226;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public InterfaceC4797<Z> f5227;

        /* renamed from: ԩ, reason: contains not printable characters */
        public C3854<Z> f5228;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m4886() {
            this.f5226 = null;
            this.f5227 = null;
            this.f5228 = null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m4887(InterfaceC1800 interfaceC1800, C3475 c3475) {
            C3442.m11218("DecodeJob.encode");
            try {
                interfaceC1800.mo4890().mo10208(this.f5226, new C5147(this.f5227, this.f5228, c3475));
            } finally {
                this.f5228.m12290();
                C3442.m11221();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean m4888() {
            return this.f5228 != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: Ԫ, reason: contains not printable characters */
        public <X> void m4889(InterfaceC3773 interfaceC3773, InterfaceC4797<X> interfaceC4797, C3854<X> c3854) {
            this.f5226 = interfaceC3773;
            this.f5227 = interfaceC4797;
            this.f5228 = c3854;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$Ԯ, reason: contains not printable characters */
    public interface InterfaceC1800 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        InterfaceC3238 mo4890();
    }

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$ՠ, reason: contains not printable characters */
    public static class C1801 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean f5229;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean f5230;

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean f5231;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m4891(boolean z) {
            return (this.f5231 || z || this.f5230) && this.f5229;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public synchronized boolean m4892() {
            this.f5230 = true;
            return m4891(false);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public synchronized boolean m4893() {
            this.f5231 = true;
            return m4891(false);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public synchronized boolean m4894(boolean z) {
            this.f5229 = true;
            return m4891(z);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public synchronized void m4895() {
            this.f5230 = false;
            this.f5229 = false;
            this.f5231 = false;
        }
    }

    public DecodeJob(InterfaceC1800 interfaceC1800, Pools.Pool<DecodeJob<?>> pool) {
        this.f5182 = interfaceC1800;
        this.f5183 = pool;
    }

    @Override // java.lang.Runnable
    public void run() {
        C3442.m11219("DecodeJob#run(model=%s)", this.f5200);
        InterfaceC3129<?> interfaceC3129 = this.f5206;
        try {
        } catch (Throwable th) {
            try {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.f5209 + ", stage: " + this.f5196, th);
                }
                if (this.f5196 != Stage.ENCODE) {
                    this.f5180.add(th);
                    m4871();
                }
                if (!this.f5209) {
                    throw th;
                }
                if (interfaceC3129 != null) {
                }
            } finally {
                if (interfaceC3129 != null) {
                    interfaceC3129.mo7076();
                }
                C3442.m11221();
            }
        }
        if (this.f5209) {
            m4871();
            return;
        }
        m4879();
        if (interfaceC3129 != null) {
            interfaceC3129.mo7076();
        }
        C3442.m11221();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4853() {
        this.f5209 = true;
        InterfaceC1809 interfaceC1809 = this.f5207;
        if (interfaceC1809 != null) {
            interfaceC1809.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809.InterfaceC1810
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo4854(InterfaceC3773 interfaceC3773, Object obj, InterfaceC3129<?> interfaceC3129, DataSource dataSource, InterfaceC3773 interfaceC37732) {
        this.f5202 = interfaceC3773;
        this.f5204 = obj;
        this.f5206 = interfaceC3129;
        this.f5205 = dataSource;
        this.f5203 = interfaceC37732;
        if (Thread.currentThread() != this.f5201) {
            this.f5197 = RunReason.DECODE_DATA;
            this.f5194.mo4884(this);
        } else {
            C3442.m11218("DecodeJob.decodeFromRetrievedData");
            try {
                m4861();
            } finally {
                C3442.m11221();
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int iM4865 = m4865() - decodeJob.m4865();
        return iM4865 == 0 ? this.f5195 - decodeJob.f5195 : iM4865;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809.InterfaceC1810
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo4856(InterfaceC3773 interfaceC3773, Exception exc, InterfaceC3129<?> interfaceC3129, DataSource dataSource) {
        interfaceC3129.mo7076();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.m4905(interfaceC3773, dataSource, interfaceC3129.mo7075());
        this.f5180.add(glideException);
        if (Thread.currentThread() == this.f5201) {
            m4877();
        } else {
            this.f5197 = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f5194.mo4884(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC1809.InterfaceC1810
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo4857() {
        this.f5197 = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f5194.mo4884(this);
    }

    @Override // defpackage.C2380.InterfaceC2386
    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public i mo4858() {
        return this.f5181;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final <Data> InterfaceC4536<R> m4859(InterfaceC3129<?> interfaceC3129, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long jM14630 = C4904.m14630();
            InterfaceC4536<R> interfaceC4536M4860 = m4860(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                m4867("Decoded result " + interfaceC4536M4860, jM14630);
            }
            return interfaceC4536M4860;
        } finally {
            interfaceC3129.mo7076();
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final <Data> InterfaceC4536<R> m4860(Data data, DataSource dataSource) throws GlideException {
        return m4878(data, dataSource, this.f5179.m4927(data.getClass()));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m4861() {
        if (Log.isLoggable("DecodeJob", 2)) {
            m4868("Retrieved data", this.f5198, "data: " + this.f5204 + ", cache key: " + this.f5202 + ", fetcher: " + this.f5206);
        }
        InterfaceC4536<R> interfaceC4536M4859 = null;
        try {
            interfaceC4536M4859 = m4859(this.f5206, this.f5204, this.f5205);
        } catch (GlideException e2) {
            e2.m4904(this.f5203, this.f5205);
            this.f5180.add(e2);
        }
        if (interfaceC4536M4859 != null) {
            m4870(interfaceC4536M4859, this.f5205);
        } else {
            m4877();
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final InterfaceC1809 m4862() {
        int i = C1796.f5222[this.f5196.ordinal()];
        if (i == 1) {
            return new C1827(this.f5179, this);
        }
        if (i == 2) {
            return new C1808(this.f5179, this);
        }
        if (i == 3) {
            return new C1828(this.f5179, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f5196);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final Stage m4863(Stage stage) {
        int i = C1796.f5222[stage.ordinal()];
        if (i == 1) {
            return this.f5192.mo11482() ? Stage.DATA_CACHE : m4863(Stage.DATA_CACHE);
        }
        if (i == 2) {
            return this.f5199 ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i == 3 || i == 4) {
            return Stage.FINISHED;
        }
        if (i == 5) {
            return this.f5192.mo11483() ? Stage.RESOURCE_CACHE : m4863(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    @NonNull
    /* renamed from: ֏, reason: contains not printable characters */
    public final C3475 m4864(DataSource dataSource) {
        C3475 c3475 = this.f5193;
        if (Build.VERSION.SDK_INT < 26) {
            return c3475;
        }
        C4238<Boolean> c4238 = C1835.f5377;
        if (c3475.m11329(c4238) != null) {
            return c3475;
        }
        if (dataSource != DataSource.RESOURCE_DISK_CACHE && !this.f5179.m4941()) {
            return c3475;
        }
        C3475 c34752 = new C3475();
        c34752.m11330(this.f5193);
        c34752.m11331(c4238, Boolean.TRUE);
        return c34752;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final int m4865() {
        return this.f5188.ordinal();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public DecodeJob<R> m4866(C2964 c2964, Object obj, C3225 c3225, InterfaceC3773 interfaceC3773, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, AbstractC3541 abstractC3541, Map<Class<?>, a3<?>> map, boolean z, boolean z2, boolean z3, C3475 c3475, InterfaceC1797<R> interfaceC1797, int i3) {
        this.f5179.m4939(c2964, obj, interfaceC3773, i, i2, abstractC3541, cls, cls2, priority, c3475, map, z, z2, this.f5182);
        this.f5186 = c2964;
        this.f5187 = interfaceC3773;
        this.f5188 = priority;
        this.f5189 = c3225;
        this.f5190 = i;
        this.f5191 = i2;
        this.f5192 = abstractC3541;
        this.f5199 = z3;
        this.f5193 = c3475;
        this.f5194 = interfaceC1797;
        this.f5195 = i3;
        this.f5197 = RunReason.INITIALIZE;
        this.f5200 = obj;
        return this;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m4867(String str, long j) {
        m4868(str, j, null);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m4868(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(C4904.m14629(j));
        sb.append(", load key: ");
        sb.append(this.f5189);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m4869(InterfaceC4536<R> interfaceC4536, DataSource dataSource) {
        m4880();
        this.f5194.mo4882(interfaceC4536, dataSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4870(InterfaceC4536<R> interfaceC4536, DataSource dataSource) {
        if (interfaceC4536 instanceof InterfaceC4190) {
            ((InterfaceC4190) interfaceC4536).mo9995();
        }
        C3854 c3854 = 0;
        if (this.f5184.m4888()) {
            interfaceC4536 = C3854.m12287(interfaceC4536);
            c3854 = interfaceC4536;
        }
        m4869(interfaceC4536, dataSource);
        this.f5196 = Stage.ENCODE;
        try {
            if (this.f5184.m4888()) {
                this.f5184.m4887(this.f5182, this.f5193);
            }
            m4872();
        } finally {
            if (c3854 != 0) {
                c3854.m12290();
            }
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m4871() {
        m4880();
        this.f5194.mo4883(new GlideException("Failed to load resource", new ArrayList(this.f5180)));
        m4873();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m4872() {
        if (this.f5185.m4892()) {
            m4876();
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m4873() {
        if (this.f5185.m4893()) {
            m4876();
        }
    }

    @NonNull
    /* renamed from: އ, reason: contains not printable characters */
    public <Z> InterfaceC4536<Z> m4874(DataSource dataSource, @NonNull InterfaceC4536<Z> interfaceC4536) {
        InterfaceC4536<Z> interfaceC4536Mo5;
        a3<Z> a3Var;
        EncodeStrategy encodeStrategyMo9992;
        InterfaceC3773 c2851;
        Class<?> cls = interfaceC4536.get().getClass();
        InterfaceC4797<Z> interfaceC4797M4932 = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            a3<Z> a3VarM4936 = this.f5179.m4936(cls);
            a3Var = a3VarM4936;
            interfaceC4536Mo5 = a3VarM4936.mo5(this.f5186, interfaceC4536, this.f5190, this.f5191);
        } else {
            interfaceC4536Mo5 = interfaceC4536;
            a3Var = null;
        }
        if (!interfaceC4536.equals(interfaceC4536Mo5)) {
            interfaceC4536.recycle();
        }
        if (this.f5179.m4940(interfaceC4536Mo5)) {
            interfaceC4797M4932 = this.f5179.m4932(interfaceC4536Mo5);
            encodeStrategyMo9992 = interfaceC4797M4932.mo9992(this.f5193);
        } else {
            encodeStrategyMo9992 = EncodeStrategy.NONE;
        }
        InterfaceC4797 interfaceC4797 = interfaceC4797M4932;
        if (!this.f5192.mo11485(!this.f5179.m4942(this.f5202), dataSource, encodeStrategyMo9992)) {
            return interfaceC4536Mo5;
        }
        if (interfaceC4797 == null) {
            throw new Registry.NoResultEncoderAvailableException(interfaceC4536Mo5.get().getClass());
        }
        int i = C1796.f5223[encodeStrategyMo9992.ordinal()];
        if (i == 1) {
            c2851 = new C2851(this.f5202, this.f5187);
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategyMo9992);
            }
            c2851 = new C4564(this.f5179.m4921(), this.f5202, this.f5187, this.f5190, this.f5191, a3Var, cls, this.f5193);
        }
        C3854 c3854M12287 = C3854.m12287(interfaceC4536Mo5);
        this.f5184.m4889(c2851, interfaceC4797, c3854M12287);
        return c3854M12287;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m4875(boolean z) {
        if (this.f5185.m4894(z)) {
            m4876();
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m4876() {
        this.f5185.m4895();
        this.f5184.m4886();
        this.f5179.m4920();
        this.f5208 = false;
        this.f5186 = null;
        this.f5187 = null;
        this.f5193 = null;
        this.f5188 = null;
        this.f5189 = null;
        this.f5194 = null;
        this.f5196 = null;
        this.f5207 = null;
        this.f5201 = null;
        this.f5202 = null;
        this.f5204 = null;
        this.f5205 = null;
        this.f5206 = null;
        this.f5198 = 0L;
        this.f5209 = false;
        this.f5200 = null;
        this.f5180.clear();
        this.f5183.release(this);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m4877() {
        this.f5201 = Thread.currentThread();
        this.f5198 = C4904.m14630();
        boolean zMo4916 = false;
        while (!this.f5209 && this.f5207 != null && !(zMo4916 = this.f5207.mo4916())) {
            this.f5196 = m4863(this.f5196);
            this.f5207 = m4862();
            if (this.f5196 == Stage.SOURCE) {
                mo4857();
                return;
            }
        }
        if ((this.f5196 == Stage.FINISHED || this.f5209) && !zMo4916) {
            m4871();
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final <Data, ResourceType> InterfaceC4536<R> m4878(Data data, DataSource dataSource, C1826<Data, ResourceType, R> c1826) throws GlideException {
        C3475 c3475M4864 = m4864(dataSource);
        InterfaceC2866<Data> interfaceC2866M4843 = this.f5186.m10377().m4843(data);
        try {
            return c1826.m4983(interfaceC2866M4843, c3475M4864, this.f5190, this.f5191, new C1798(dataSource));
        } finally {
            interfaceC2866M4843.mo9067();
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m4879() {
        int i = C1796.f5221[this.f5197.ordinal()];
        if (i == 1) {
            this.f5196 = m4863(Stage.INITIALIZE);
            this.f5207 = m4862();
            m4877();
        } else if (i == 2) {
            m4877();
        } else {
            if (i == 3) {
                m4861();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f5197);
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m4880() {
        this.f5181.mo6230();
        if (this.f5208) {
            throw new IllegalStateException("Already notified");
        }
        this.f5208 = true;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean m4881() {
        Stage stageM4863 = m4863(Stage.INITIALIZE);
        return stageM4863 == Stage.RESOURCE_CACHE || stageM4863 == Stage.DATA_CACHE;
    }
}
