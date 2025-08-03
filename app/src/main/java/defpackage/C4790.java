package defpackage;

import androidx.annotation.NonNull;

/* compiled from: SimpleResource.java */
/* renamed from: ඔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4790<T> implements InterfaceC4536<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T f16135;

    public C4790(@NonNull T t) {
        this.f16135 = (T) C4513.m13867(t);
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    public final T get() {
        return this.f16135;
    }

    @Override // defpackage.InterfaceC4536
    public void recycle() {
    }

    @Override // defpackage.InterfaceC4536
    /* renamed from: Ԩ */
    public final int mo4977() {
        return 1;
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: ԩ */
    public Class<T> mo4978() {
        return (Class<T>) this.f16135.getClass();
    }
}
