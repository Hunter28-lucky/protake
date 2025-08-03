package kotlinx.coroutines;

import defpackage.C2596;
import defpackage.C2610;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4355;
import defpackage.g4;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: CoroutineStart.kt */
/* loaded from: classes2.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* compiled from: CoroutineStart.kt */
    /* renamed from: kotlinx.coroutines.CoroutineStart$Ϳ, reason: contains not printable characters */
    public /* synthetic */ class C2148 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f7861;

        static {
            int[] iArr = new int[CoroutineStart.valuesCustom().length];
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            f7861 = iArr;
        }
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static CoroutineStart[] valuesCustom() {
        CoroutineStart[] coroutineStartArrValuesCustom = values();
        return (CoroutineStart[]) Arrays.copyOf(coroutineStartArrValuesCustom, coroutineStartArrValuesCustom.length);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final <R, T> void m7326(InterfaceC2849<? super R, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, R r, InterfaceC4355<? super T> interfaceC4355) {
        int i = C2148.f7861[ordinal()];
        if (i == 1) {
            C2596.m9499(interfaceC2849, r, interfaceC4355, null, 4, null);
            return;
        }
        if (i == 2) {
            C2610.m9545(interfaceC2849, r, interfaceC4355);
        } else if (i == 3) {
            g4.m6075(interfaceC2849, r, interfaceC4355);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m7327() {
        return this == LAZY;
    }
}
