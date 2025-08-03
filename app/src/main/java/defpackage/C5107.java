package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* compiled from: ModelCache.java */
/* renamed from: န, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5107<A, B> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4658<C5109<A>, B> f16945;

    /* compiled from: ModelCache.java */
    /* renamed from: န$Ϳ, reason: contains not printable characters */
    public class C5108 extends C4658<C5109<A>, B> {
        public C5108(long j) {
            super(j);
        }

        @Override // defpackage.C4658
        /* renamed from: ؠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo9579(@NonNull C5109<A> c5109, @Nullable B b) {
            c5109.m14936();
        }
    }

    /* compiled from: ModelCache.java */
    @VisibleForTesting
    /* renamed from: န$Ԩ, reason: contains not printable characters */
    public static final class C5109<A> {

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final Queue<C5109<?>> f16947 = j5.m7088(0);

        /* renamed from: Ϳ, reason: contains not printable characters */
        public int f16948;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f16949;

        /* renamed from: ԩ, reason: contains not printable characters */
        public A f16950;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static <A> C5109<A> m14934(A a, int i, int i2) {
            C5109<A> c5109;
            Queue<C5109<?>> queue = f16947;
            synchronized (queue) {
                c5109 = (C5109) queue.poll();
            }
            if (c5109 == null) {
                c5109 = new C5109<>();
            }
            c5109.m14935(a, i, i2);
            return c5109;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C5109)) {
                return false;
            }
            C5109 c5109 = (C5109) obj;
            return this.f16949 == c5109.f16949 && this.f16948 == c5109.f16948 && this.f16950.equals(c5109.f16950);
        }

        public int hashCode() {
            return (((this.f16948 * 31) + this.f16949) * 31) + this.f16950.hashCode();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m14935(A a, int i, int i2) {
            this.f16950 = a;
            this.f16949 = i;
            this.f16948 = i2;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m14936() {
            Queue<C5109<?>> queue = f16947;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public C5107(long j) {
        this.f16945 = new C5108(j);
    }

    @Nullable
    /* renamed from: Ϳ, reason: contains not printable characters */
    public B m14931(A a, int i, int i2) {
        C5109<A> c5109M14934 = C5109.m14934(a, i, i2);
        B bM14137 = this.f16945.m14137(c5109M14934);
        c5109M14934.m14936();
        return bM14137;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m14932(A a, int i, int i2, B b) {
        this.f16945.m14139(C5109.m14934(a, i, i2), b);
    }
}
