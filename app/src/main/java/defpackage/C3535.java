package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;

/* compiled from: Strings.kt */
/* renamed from: ڔ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3535 implements InterfaceC4590<C2523> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final CharSequence f12327;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f12328;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f12329;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC2849<CharSequence, Integer, Pair<Integer, Integer>> f12330;

    /* compiled from: Strings.kt */
    /* renamed from: ڔ$Ϳ, reason: contains not printable characters */
    public static final class C3536 implements Iterator<C2523>, InterfaceC4947 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f12331 = -1;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f12332;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f12333;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public C2523 f12334;

        /* renamed from: ԯ, reason: contains not printable characters */
        public int f12335;

        public C3536() {
            int iM13947 = C4542.m13947(C3535.this.f12328, 0, C3535.this.f12327.length());
            this.f12332 = iM13947;
            this.f12333 = iM13947;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12331 == -1) {
                m11477();
            }
            return this.f12331 == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /* renamed from: Ϳ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m11477() {
            /*
                r6 = this;
                int r0 = r6.f12333
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f12331 = r1
                r0 = 0
                r6.f12334 = r0
                goto L9e
            Lc:
                ڔ r0 = defpackage.C3535.this
                int r0 = defpackage.C3535.m11475(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f12335
                int r0 = r0 + r3
                r6.f12335 = r0
                ڔ r4 = defpackage.C3535.this
                int r4 = defpackage.C3535.m11475(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f12333
                ڔ r4 = defpackage.C3535.this
                java.lang.CharSequence r4 = defpackage.C3535.m11474(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                ș r0 = new ș
                int r1 = r6.f12332
                ڔ r4 = defpackage.C3535.this
                java.lang.CharSequence r4 = defpackage.C3535.m11474(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.m7280(r4)
                r0.<init>(r1, r4)
                r6.f12334 = r0
                r6.f12333 = r2
                goto L9c
            L47:
                ڔ r0 = defpackage.C3535.this
                Ϥ r0 = defpackage.C3535.m11473(r0)
                ڔ r4 = defpackage.C3535.this
                java.lang.CharSequence r4 = defpackage.C3535.m11474(r4)
                int r5 = r6.f12333
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                ș r0 = new ș
                int r1 = r6.f12332
                ڔ r4 = defpackage.C3535.this
                java.lang.CharSequence r4 = defpackage.C3535.m11474(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.m7280(r4)
                r0.<init>(r1, r4)
                r6.f12334 = r0
                r6.f12333 = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.m7207()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.m7208()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f12332
                ș r4 = defpackage.C4542.m13950(r4, r2)
                r6.f12334 = r4
                int r2 = r2 + r0
                r6.f12332 = r2
                if (r0 != 0) goto L99
                r1 = r3
            L99:
                int r2 = r2 + r1
                r6.f12333 = r2
            L9c:
                r6.f12331 = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C3535.C3536.m11477():void");
        }

        @Override // java.util.Iterator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public C2523 next() {
            if (this.f12331 == -1) {
                m11477();
            }
            if (this.f12331 == 0) {
                throw new NoSuchElementException();
            }
            C2523 c2523 = this.f12334;
            if (c2523 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.f12334 = null;
            this.f12331 = -1;
            return c2523;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3535(CharSequence charSequence, int i, int i2, InterfaceC2849<? super CharSequence, ? super Integer, Pair<Integer, Integer>> interfaceC2849) {
        C3921.m12666(charSequence, "input");
        C3921.m12666(interfaceC2849, "getNextMatch");
        this.f12327 = charSequence;
        this.f12328 = i;
        this.f12329 = i2;
        this.f12330 = interfaceC2849;
    }

    @Override // defpackage.InterfaceC4590
    public Iterator<C2523> iterator() {
        return new C3536();
    }
}
