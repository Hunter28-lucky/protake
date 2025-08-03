package defpackage;

/* compiled from: Char.kt */
/* renamed from: ڏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3527 extends C5042 {
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final boolean m11467(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }
}
