package defpackage;

import java.util.Arrays;
import java.util.List;

/* compiled from: _ArraysJvm.kt */
/* renamed from: ຓ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4955 extends C4954 {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> List<T> m14725(T[] tArr) {
        C3921.m12666(tArr, "<this>");
        List<T> listM14750 = C4971.m14750(tArr);
        C3921.m12665(listM14750, "asList(this)");
        return listM14750;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final byte[] m14726(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        C3921.m12666(bArr, "<this>");
        C3921.m12666(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final <T> T[] m14727(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        C3921.m12666(tArr, "<this>");
        C3921.m12666(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static /* synthetic */ byte[] m14728(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return m14726(bArr, bArr2, i, i2, i3);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static /* synthetic */ Object[] m14729(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return m14727(objArr, objArr2, i, i2, i3);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final byte[] m14730(byte[] bArr, int i, int i2) {
        C3921.m12666(bArr, "<this>");
        C4953.m14724(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        C3921.m12665(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final <T> T[] m14731(T[] tArr, int i, int i2) {
        C3921.m12666(tArr, "<this>");
        C4953.m14724(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        C3921.m12665(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final <T> void m14732(T[] tArr, T t, int i, int i2) {
        C3921.m12666(tArr, "<this>");
        Arrays.fill(tArr, i, i2, t);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static /* synthetic */ void m14733(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        m14732(objArr, obj, i, i2);
    }
}
