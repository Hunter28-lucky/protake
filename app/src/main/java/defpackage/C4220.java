package defpackage;

import androidx.annotation.Nullable;

/* compiled from: ErrorRequestCoordinator.java */
/* renamed from: ৳, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4220 implements InterfaceC2839, InterfaceC3684 {

    /* renamed from: ԫ, reason: contains not printable characters */
    @Nullable
    public final InterfaceC2839 f14512;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC3684 f14513;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC3684 f14514;

    public C4220(@Nullable InterfaceC2839 interfaceC2839) {
        this.f14512 = interfaceC2839;
    }

    @Override // defpackage.InterfaceC3684
    public void clear() {
        this.f14513.clear();
        if (this.f14514.isRunning()) {
            this.f14514.clear();
        }
    }

    @Override // defpackage.InterfaceC3684
    public boolean isCancelled() {
        return (this.f14513.mo5032() ? this.f14514 : this.f14513).isCancelled();
    }

    @Override // defpackage.InterfaceC3684
    public boolean isComplete() {
        return (this.f14513.mo5032() ? this.f14514 : this.f14513).isComplete();
    }

    @Override // defpackage.InterfaceC3684
    public boolean isRunning() {
        return (this.f14513.mo5032() ? this.f14514 : this.f14513).isRunning();
    }

    @Override // defpackage.InterfaceC3684
    public void pause() {
        if (!this.f14513.mo5032()) {
            this.f14513.pause();
        }
        if (this.f14514.isRunning()) {
            this.f14514.pause();
        }
    }

    @Override // defpackage.InterfaceC3684
    public void recycle() {
        this.f14513.recycle();
        this.f14514.recycle();
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: Ϳ */
    public void mo7472(InterfaceC3684 interfaceC3684) {
        if (!interfaceC3684.equals(this.f14514)) {
            if (this.f14514.isRunning()) {
                return;
            }
            this.f14514.mo5034();
        } else {
            InterfaceC2839 interfaceC2839 = this.f14512;
            if (interfaceC2839 != null) {
                interfaceC2839.mo7472(this);
            }
        }
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: Ԩ */
    public void mo7473(InterfaceC3684 interfaceC3684) {
        InterfaceC2839 interfaceC2839 = this.f14512;
        if (interfaceC2839 != null) {
            interfaceC2839.mo7473(this);
        }
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ԩ */
    public boolean mo5028(InterfaceC3684 interfaceC3684) {
        if (!(interfaceC3684 instanceof C4220)) {
            return false;
        }
        C4220 c4220 = (C4220) interfaceC3684;
        return this.f14513.mo5028(c4220.f14513) && this.f14514.mo5028(c4220.f14514);
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: Ԫ */
    public boolean mo7474() {
        return m13307() || mo5030();
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ԫ */
    public boolean mo5030() {
        return (this.f14513.mo5032() ? this.f14514 : this.f14513).mo5030();
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: Ԭ */
    public boolean mo7475(InterfaceC3684 interfaceC3684) {
        return m13304() && m13303(interfaceC3684);
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: ԭ */
    public boolean mo7476(InterfaceC3684 interfaceC3684) {
        return m13305() && m13303(interfaceC3684);
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: Ԯ */
    public boolean mo5032() {
        return this.f14513.mo5032() && this.f14514.mo5032();
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: ԯ */
    public boolean mo7477(InterfaceC3684 interfaceC3684) {
        return m13306() && m13303(interfaceC3684);
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ՠ */
    public void mo5034() {
        if (this.f14513.isRunning()) {
            return;
        }
        this.f14513.mo5034();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean m13303(InterfaceC3684 interfaceC3684) {
        return interfaceC3684.equals(this.f14513) || (this.f14513.mo5032() && interfaceC3684.equals(this.f14514));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean m13304() {
        InterfaceC2839 interfaceC2839 = this.f14512;
        return interfaceC2839 == null || interfaceC2839.mo7475(this);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final boolean m13305() {
        InterfaceC2839 interfaceC2839 = this.f14512;
        return interfaceC2839 == null || interfaceC2839.mo7476(this);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final boolean m13306() {
        InterfaceC2839 interfaceC2839 = this.f14512;
        return interfaceC2839 == null || interfaceC2839.mo7477(this);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final boolean m13307() {
        InterfaceC2839 interfaceC2839 = this.f14512;
        return interfaceC2839 != null && interfaceC2839.mo7474();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m13308(InterfaceC3684 interfaceC3684, InterfaceC3684 interfaceC36842) {
        this.f14513 = interfaceC3684;
        this.f14514 = interfaceC36842;
    }
}
