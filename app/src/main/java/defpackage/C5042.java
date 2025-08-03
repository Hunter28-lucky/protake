package defpackage;

/* compiled from: CharJVM.kt */
/* renamed from: པ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5042 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int m14848(int i) {
        boolean z = false;
        if (2 <= i && i < 37) {
            z = true;
        }
        if (z) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new C2523(2, 36));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final int m14849(char c, int i) {
        return Character.digit((int) c, i);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final boolean m14850(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
