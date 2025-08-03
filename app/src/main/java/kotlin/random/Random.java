package kotlin.random;

import defpackage.C4184;
import defpackage.C4714;
import java.io.Serializable;

/* compiled from: Random.kt */
/* loaded from: classes2.dex */
public abstract class Random {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Default f7841 = new Default(null);

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final Random f7842 = C4714.f15980.mo10778();

    /* compiled from: Random.kt */
    public static final class Default extends Random implements Serializable {

        /* compiled from: Random.kt */
        public static final class Serialized implements Serializable {
            private static final long serialVersionUID = 0;

            /* renamed from: ԫ, reason: contains not printable characters */
            public static final Serialized f7843 = new Serialized();

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.f7841;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(C4184 c4184) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.f7843;
        }

        @Override // kotlin.random.Random
        /* renamed from: Ԩ */
        public int mo7258() {
            return Random.f7842.mo7258();
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public abstract int mo7258();
}
