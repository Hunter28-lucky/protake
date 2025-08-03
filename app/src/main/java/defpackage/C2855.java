package defpackage;

import androidx.annotation.NonNull;

/* compiled from: GifDrawableResource.java */
/* renamed from: ϰ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2855 extends AbstractC5149<C3465> {
    public C2855(C3465 c3465) {
        super(c3465);
    }

    @Override // defpackage.InterfaceC4536
    public void recycle() {
        ((C3465) this.f17081).stop();
        ((C3465) this.f17081).m11293();
    }

    @Override // defpackage.AbstractC5149, defpackage.InterfaceC4190
    /* renamed from: Ϳ */
    public void mo9995() {
        ((C3465) this.f17081).m11288().prepareToDraw();
    }

    @Override // defpackage.InterfaceC4536
    /* renamed from: Ԩ */
    public int mo4977() {
        return ((C3465) this.f17081).m11292();
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: ԩ */
    public Class<C3465> mo4978() {
        return C3465.class;
    }
}
