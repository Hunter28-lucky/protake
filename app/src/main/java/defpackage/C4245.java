package defpackage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: PlatformThreadLocalRandom.kt */
/* renamed from: ਘ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4245 extends AbstractC3422 {
    @Override // defpackage.AbstractC3422
    /* renamed from: ԩ */
    public Random mo11199() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        C3921.m12665(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
