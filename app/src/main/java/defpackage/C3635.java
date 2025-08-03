package defpackage;

import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* renamed from: ۏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3635 extends AbstractC3422 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C3636 f12626 = new C3636();

    /* compiled from: PlatformRandom.kt */
    /* renamed from: ۏ$Ϳ, reason: contains not printable characters */
    public static final class C3636 extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // defpackage.AbstractC3422
    /* renamed from: ԩ */
    public Random mo11199() {
        Random random = this.f12626.get();
        C3921.m12665(random, "implStorage.get()");
        return random;
    }
}
