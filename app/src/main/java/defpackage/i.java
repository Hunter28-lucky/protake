package defpackage;

import androidx.annotation.NonNull;

/* compiled from: StateVerifier.java */
/* loaded from: classes.dex */
public abstract class i {

    /* compiled from: StateVerifier.java */
    /* renamed from: i$Ԩ, reason: contains not printable characters */
    public static class C1969 extends i {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public volatile boolean f6759;

        public C1969() {
            super();
        }

        @Override // defpackage.i
        /* renamed from: Ԩ */
        public void mo6229(boolean z) {
            this.f6759 = z;
        }

        @Override // defpackage.i
        /* renamed from: ԩ */
        public void mo6230() {
            if (this.f6759) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public i() {
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static i m6228() {
        return new C1969();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public abstract void mo6229(boolean z);

    /* renamed from: ԩ, reason: contains not printable characters */
    public abstract void mo6230();
}
