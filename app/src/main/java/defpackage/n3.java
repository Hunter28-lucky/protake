package defpackage;

import defpackage.n3;

/* compiled from: TransitionOptions.java */
/* loaded from: classes.dex */
public abstract class n3<CHILD extends n3<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public m3<? super TranscodeType> f8046 = C4176.m13199();

    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final m3<? super TranscodeType> m7624() {
        return this.f8046;
    }
}
