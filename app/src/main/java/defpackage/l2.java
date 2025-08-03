package defpackage;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class l2 implements InterfaceC2839, InterfaceC3684 {

    /* renamed from: ԫ, reason: contains not printable characters */
    @Nullable
    public final InterfaceC2839 f7943;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC3684 f7944;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC3684 f7945;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f7946;

    @VisibleForTesting
    public l2() {
        this(null);
    }

    @Override // defpackage.InterfaceC3684
    public void clear() {
        this.f7946 = false;
        this.f7945.clear();
        this.f7944.clear();
    }

    @Override // defpackage.InterfaceC3684
    public boolean isCancelled() {
        return this.f7944.isCancelled();
    }

    @Override // defpackage.InterfaceC3684
    public boolean isComplete() {
        return this.f7944.isComplete() || this.f7945.isComplete();
    }

    @Override // defpackage.InterfaceC3684
    public boolean isRunning() {
        return this.f7944.isRunning();
    }

    @Override // defpackage.InterfaceC3684
    public void pause() {
        this.f7946 = false;
        this.f7944.pause();
        this.f7945.pause();
    }

    @Override // defpackage.InterfaceC3684
    public void recycle() {
        this.f7944.recycle();
        this.f7945.recycle();
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo7472(InterfaceC3684 interfaceC3684) {
        InterfaceC2839 interfaceC2839;
        if (interfaceC3684.equals(this.f7944) && (interfaceC2839 = this.f7943) != null) {
            interfaceC2839.mo7472(this);
        }
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo7473(InterfaceC3684 interfaceC3684) {
        if (interfaceC3684.equals(this.f7945)) {
            return;
        }
        InterfaceC2839 interfaceC2839 = this.f7943;
        if (interfaceC2839 != null) {
            interfaceC2839.mo7473(this);
        }
        if (this.f7945.isComplete()) {
            return;
        }
        this.f7945.clear();
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ԩ */
    public boolean mo5028(InterfaceC3684 interfaceC3684) {
        if (!(interfaceC3684 instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) interfaceC3684;
        InterfaceC3684 interfaceC36842 = this.f7944;
        if (interfaceC36842 == null) {
            if (l2Var.f7944 != null) {
                return false;
            }
        } else if (!interfaceC36842.mo5028(l2Var.f7944)) {
            return false;
        }
        InterfaceC3684 interfaceC36843 = this.f7945;
        InterfaceC3684 interfaceC36844 = l2Var.f7945;
        if (interfaceC36843 == null) {
            if (interfaceC36844 != null) {
                return false;
            }
        } else if (!interfaceC36843.mo5028(interfaceC36844)) {
            return false;
        }
        return true;
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean mo7474() {
        return m7481() || mo5030();
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ԫ */
    public boolean mo5030() {
        return this.f7944.mo5030() || this.f7945.mo5030();
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean mo7475(InterfaceC3684 interfaceC3684) {
        return m7478() && interfaceC3684.equals(this.f7944);
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean mo7476(InterfaceC3684 interfaceC3684) {
        return m7479() && interfaceC3684.equals(this.f7944) && !mo7474();
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: Ԯ */
    public boolean mo5032() {
        return this.f7944.mo5032();
    }

    @Override // defpackage.InterfaceC2839
    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean mo7477(InterfaceC3684 interfaceC3684) {
        return m7480() && (interfaceC3684.equals(this.f7944) || !this.f7944.mo5030());
    }

    @Override // defpackage.InterfaceC3684
    /* renamed from: ՠ */
    public void mo5034() {
        this.f7946 = true;
        if (!this.f7944.isComplete() && !this.f7945.isRunning()) {
            this.f7945.mo5034();
        }
        if (!this.f7946 || this.f7944.isRunning()) {
            return;
        }
        this.f7944.mo5034();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean m7478() {
        InterfaceC2839 interfaceC2839 = this.f7943;
        return interfaceC2839 == null || interfaceC2839.mo7475(this);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean m7479() {
        InterfaceC2839 interfaceC2839 = this.f7943;
        return interfaceC2839 == null || interfaceC2839.mo7476(this);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final boolean m7480() {
        InterfaceC2839 interfaceC2839 = this.f7943;
        return interfaceC2839 == null || interfaceC2839.mo7477(this);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final boolean m7481() {
        InterfaceC2839 interfaceC2839 = this.f7943;
        return interfaceC2839 != null && interfaceC2839.mo7474();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m7482(InterfaceC3684 interfaceC3684, InterfaceC3684 interfaceC36842) {
        this.f7944 = interfaceC3684;
        this.f7945 = interfaceC36842;
    }

    public l2(@Nullable InterfaceC2839 interfaceC2839) {
        this.f7943 = interfaceC2839;
    }
}
