package defpackage;

import androidx.annotation.NonNull;

/* compiled from: PriorityRunnable.java */
/* renamed from: ඡ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC4803 implements Runnable, Comparable<AbstractRunnableC4803> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f16279;

    public AbstractRunnableC4803(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.f16279 = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public int compareTo(@NonNull AbstractRunnableC4803 abstractRunnableC4803) {
        int iM14520 = m14520();
        int iM145202 = abstractRunnableC4803.m14520();
        if (iM14520 < iM145202) {
            return 1;
        }
        return iM14520 > iM145202 ? -1 : 0;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m14520() {
        return this.f16279;
    }
}
