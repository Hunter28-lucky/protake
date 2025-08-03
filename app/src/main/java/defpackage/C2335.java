package defpackage;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingIgnoringReceiver.java */
/* renamed from: ĩ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2335 extends CountDownLatch implements InterfaceC2857<Throwable>, InterfaceC3809 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Throwable f8868;

    public C2335() {
        super(1);
    }

    @Override // defpackage.InterfaceC3809
    public void run() {
        countDown();
    }

    @Override // defpackage.InterfaceC2857
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        this.f8868 = th;
        countDown();
    }
}
