package defpackage;

/* compiled from: ArrayQueue.kt */
/* renamed from: ຏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4951<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Object[] f16668 = new Object[16];

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f16669;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f16670;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m14720(T t) {
        Object[] objArr = this.f16668;
        int i = this.f16670;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.f16670 = length;
        if (length == this.f16669) {
            m14721();
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m14721() {
        Object[] objArr = this.f16668;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        C4955.m14729(objArr, objArr2, 0, this.f16669, 0, 10, null);
        Object[] objArr3 = this.f16668;
        int length2 = objArr3.length;
        int i = this.f16669;
        C4955.m14729(objArr3, objArr2, length2 - i, 0, i, 4, null);
        this.f16668 = objArr2;
        this.f16669 = 0;
        this.f16670 = length;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m14722() {
        return this.f16669 == this.f16670;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final T m14723() {
        int i = this.f16669;
        if (i == this.f16670) {
            return null;
        }
        Object[] objArr = this.f16668;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.f16669 = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
