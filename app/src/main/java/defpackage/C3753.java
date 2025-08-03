package defpackage;

import java.util.NoSuchElementException;

/* compiled from: ProgressionIterators.kt */
/* renamed from: ݪ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3753 extends AbstractC2348 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f12972;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f12973;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f12974;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f12975;

    public C3753(int i, int i2, int i3) {
        this.f12972 = i3;
        this.f12973 = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f12974 = z;
        this.f12975 = z ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12974;
    }

    @Override // defpackage.AbstractC2348
    public int nextInt() {
        int i = this.f12975;
        if (i != this.f12973) {
            this.f12975 = this.f12972 + i;
        } else {
            if (!this.f12974) {
                throw new NoSuchElementException();
            }
            this.f12974 = false;
        }
        return i;
    }
}
