package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: TypedValues.java */
/* loaded from: classes.dex */
public final /* synthetic */ class z3 {
    static {
        String str = TypedValues.MotionScene.NAME;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m8644(String str) {
        str.hashCode();
        if (str.equals(TypedValues.MotionScene.S_DEFAULT_DURATION)) {
            return 600;
        }
        return !str.equals(TypedValues.MotionScene.S_LAYOUT_DURING_TRANSITION) ? -1 : 601;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m8645(int i) {
        if (i != 600) {
            return i != 601 ? -1 : 1;
        }
        return 2;
    }
}
