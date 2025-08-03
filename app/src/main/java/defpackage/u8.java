package defpackage;

import android.view.Surface;

/* compiled from: WindowSurface.java */
/* loaded from: classes.dex */
public class u8 extends C2379 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Surface f8638;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f8639;

    public u8(C2377 c2377, Surface surface, boolean z) {
        super(c2377);
        m8859(surface);
        this.f8638 = surface;
        this.f8639 = z;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m8365() {
        m8861();
        Surface surface = this.f8638;
        if (surface != null) {
            if (this.f8639) {
                surface.release();
            }
            this.f8638 = null;
        }
    }
}
