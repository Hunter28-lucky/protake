package com.bumptech.glide.load.engine;

import android.os.Looper;
import androidx.annotation.NonNull;
import defpackage.C4513;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC4536;

/* compiled from: EngineResource.java */
/* renamed from: com.bumptech.glide.load.engine.֏, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1824<Z> implements InterfaceC4536<Z> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean f5329;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f5330;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC1825 f5331;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC3773 f5332;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f5333;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f5334;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final InterfaceC4536<Z> f5335;

    /* compiled from: EngineResource.java */
    /* renamed from: com.bumptech.glide.load.engine.֏$Ϳ, reason: contains not printable characters */
    public interface InterfaceC1825 {
        /* renamed from: Ԩ */
        void mo4948(InterfaceC3773 interfaceC3773, C1824<?> c1824);
    }

    public C1824(InterfaceC4536<Z> interfaceC4536, boolean z, boolean z2) {
        this.f5335 = (InterfaceC4536) C4513.m13867(interfaceC4536);
        this.f5329 = z;
        this.f5330 = z2;
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    public Z get() {
        return this.f5335.get();
    }

    @Override // defpackage.InterfaceC4536
    public void recycle() {
        if (this.f5333 > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f5334) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f5334 = true;
        if (this.f5330) {
            this.f5335.recycle();
        }
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.f5329 + ", listener=" + this.f5331 + ", key=" + this.f5332 + ", acquired=" + this.f5333 + ", isRecycled=" + this.f5334 + ", resource=" + this.f5335 + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4976() {
        if (this.f5334) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.f5333++;
    }

    @Override // defpackage.InterfaceC4536
    /* renamed from: Ԩ, reason: contains not printable characters */
    public int mo4977() {
        return this.f5335.mo4977();
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public Class<Z> mo4978() {
        return this.f5335.mo4978();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public InterfaceC4536<Z> m4979() {
        return this.f5335;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m4980() {
        return this.f5329;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4981() {
        if (this.f5333 <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.f5333 - 1;
        this.f5333 = i;
        if (i == 0) {
            this.f5331.mo4948(this.f5332, this);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4982(InterfaceC3773 interfaceC3773, InterfaceC1825 interfaceC1825) {
        this.f5332 = interfaceC3773;
        this.f5331 = interfaceC1825;
    }
}
