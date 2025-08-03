package defpackage;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* renamed from: ഺ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4741<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int f16006;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Object[] f16007;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Object[] f16008;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f16009;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: ഺ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC4742<T> extends InterfaceC4178<T> {
        @Override // defpackage.InterfaceC4178
        boolean test(T t);
    }

    public C4741(int i) {
        this.f16006 = i;
        Object[] objArr = new Object[i + 1];
        this.f16007 = objArr;
        this.f16008 = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /* renamed from: Ϳ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean m14280(defpackage.InterfaceC5102<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16007
            int r1 = r4.f16006
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4741.m14280(ဏ):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /* renamed from: Ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean m14281(org.reactivestreams.Subscriber<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16007
            int r1 = r4.f16006
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4741.m14281(org.reactivestreams.Subscriber):boolean");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m14282(T t) {
        int i = this.f16006;
        int i2 = this.f16009;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f16008[i] = objArr;
            this.f16008 = objArr;
            i2 = 0;
        }
        this.f16008[i2] = t;
        this.f16009 = i2 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m14283(defpackage.C4741.InterfaceC4742<? super T> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16007
            int r1 = r4.f16006
        L4:
            if (r0 == 0) goto L1d
            r2 = 0
        L7:
            if (r2 >= r1) goto L18
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L18
        Le:
            boolean r3 = r5.test(r3)
            if (r3 == 0) goto L15
            return
        L15:
            int r2 = r2 + 1
            goto L7
        L18:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C4741.m14283(ഺ$Ϳ):void");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m14284(T t) {
        this.f16007[0] = t;
    }
}
