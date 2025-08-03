package defpackage;

import defpackage.C3927;
import java.util.List;

/* compiled from: FilmPreviewFilter.java */
/* renamed from: ఽ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4565 extends AbstractC3724 {

    /* renamed from: ވ, reason: contains not printable characters */
    public C4972 f15611;

    /* renamed from: މ, reason: contains not printable characters */
    public C2641 f15612;

    /* renamed from: ފ, reason: contains not printable characters */
    public C2591 f15613;

    /* renamed from: ދ, reason: contains not printable characters */
    public C4974 f15614;

    /* renamed from: ތ, reason: contains not printable characters */
    public C5106 f15615;

    /* renamed from: ލ, reason: contains not printable characters */
    public C5194 f15616;

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean f15617;

    public C4565() {
        this(C2764.m10018().m10029());
    }

    @Override // defpackage.AbstractC3724
    /* renamed from: ԩ */
    public void mo11903() {
        if (this.f12893 == 0) {
            C4972 c4972 = new C4972();
            this.f15611 = c4972;
            c4972.m10884(this.f12895.m8883());
            this.f15611.m14756(C5083.f16883);
            this.f12894.m11636(this.f15611);
            return;
        }
        C2641 c2641 = new C2641();
        this.f15612 = c2641;
        c2641.m10884(this.f12895.m8883());
        this.f15612.m9743(C5083.f16883);
        this.f12894.m11636(this.f15612);
    }

    @Override // defpackage.AbstractC3724
    /* renamed from: ԭ */
    public void mo11907() {
        super.mo11907();
        C2591 c2591 = this.f15613;
        if (c2591 != null) {
            c2591.m13471();
        }
        C5106 c5106 = this.f15615;
        if (c5106 != null) {
            c5106.m13471();
        }
        C5194 c5194 = this.f15616;
        if (c5194 != null) {
            c5194.m13471();
        }
        C4974 c4974 = this.f15614;
        if (c4974 != null) {
            c4974.m13471();
            this.f15614.mo10877();
        }
        C4972 c4972 = this.f15611;
        if (c4972 != null) {
            c4972.m13471();
            this.f15611.mo10877();
        }
        C2641 c2641 = this.f15612;
        if (c2641 != null) {
            c2641.m13471();
            this.f15612.mo10877();
        }
    }

    @Override // defpackage.AbstractC3724
    /* renamed from: ބ */
    public void mo11919() {
        if (this.f12893 == 0) {
            this.f15611.m14756(C5083.f16883);
        } else {
            this.f15612.m9743(C5083.f16883);
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m13987(boolean z) {
        if (!z) {
            m13990();
            return;
        }
        m13991(false);
        if (this.f15614 == null) {
            try {
                C3927.C3928 c3928M12686 = C3927.m12686(C5015.m14801("lut/lut_false_color.dat"));
                C4974 c4974 = new C4974();
                this.f15614 = c4974;
                c4974.m10882(c3928M12686.m12689(), false);
                this.f15614.m14761(c3928M12686.m12690());
                this.f15614.m13477();
            } catch (Exception e2) {
                e2.printStackTrace();
                C4974 c49742 = this.f15614;
                if (c49742 != null) {
                    c49742.m13471();
                    this.f15614.mo10877();
                }
                this.f15614 = null;
            }
        }
        C4974 c49743 = this.f15614;
        if (c49743 != null) {
            this.f12894.m11636(c49743);
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m13988(boolean z) {
        if (!z) {
            if (this.f12893 == 0) {
                this.f15611.m14759(0.0f);
            } else {
                this.f15612.m9746(0.0f);
            }
            m13990();
            return;
        }
        m13990();
        C2591 c2591 = this.f15613;
        if (c2591 != null) {
            c2591.m13471();
            this.f15613.mo10877();
            this.f15613 = null;
        }
        if (this.f15613 == null) {
            C2591 c25912 = new C2591();
            this.f15613 = c25912;
            c25912.m9492(2.0f);
            this.f15613.m13477();
        }
        if (this.f12893 == 0) {
            this.f15611.m14759(2.0f);
        } else {
            this.f15612.m9746(2.0f);
        }
        this.f12894.m11636(this.f15613);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m13989(boolean z) {
        if (!z) {
            if (this.f12893 == 0) {
                this.f15611.m14759(0.0f);
            } else {
                this.f15612.m9746(0.0f);
            }
            m13990();
            return;
        }
        m13990();
        C2591 c2591 = this.f15613;
        if (c2591 != null) {
            c2591.m13471();
            this.f15613.mo10877();
            this.f15613 = null;
        }
        if (this.f15613 == null) {
            C2591 c25912 = new C2591();
            this.f15613 = c25912;
            c25912.m9492(1.0f);
            this.f15613.m13477();
        }
        if (this.f12893 == 0) {
            this.f15611.m14759(1.0f);
        } else {
            this.f15612.m9746(1.0f);
        }
        this.f12894.m11636(this.f15613);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m13990() {
        m13991(true);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m13991(boolean z) {
        List<C4327> listM11637 = this.f12894.m11637();
        if (listM11637 != null) {
            listM11637.clear();
        }
        List<C4327> listM11638 = this.f12894.m11638();
        if (listM11638 != null) {
            listM11638.clear();
        }
        if (z) {
            if (this.f12893 == 0) {
                if (!this.f15611.m13478()) {
                    this.f15611.m13477();
                }
                this.f12894.m11636(this.f15611);
            } else {
                if (!this.f15612.m13478()) {
                    this.f15612.m13477();
                }
                this.f12894.m11636(this.f15612);
            }
            this.f15617 = false;
            return;
        }
        if (this.f12893 == 0) {
            if (this.f15615 == null) {
                C5106 c5106 = new C5106();
                this.f15615 = c5106;
                c5106.m13477();
            }
            this.f12894.m11636(this.f15615);
        } else {
            if (this.f15616 == null) {
                C5194 c5194 = new C5194();
                this.f15616 = c5194;
                c5194.m13477();
            }
            this.f12894.m11636(this.f15616);
        }
        this.f15617 = true;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m13992(float[] fArr) {
        C5194 c5194;
        C5106 c5106;
        if (this.f12893 == 0) {
            this.f15611.m14760(fArr);
            if (!this.f15617 || (c5106 = this.f15615) == null) {
                return;
            }
            c5106.m14930(fArr);
            return;
        }
        this.f15612.m9747(fArr);
        if (!this.f15617 || (c5194 = this.f15616) == null) {
            return;
        }
        c5194.m15167(fArr);
    }

    public C4565(int i) {
        super(i, C2764.m10018().m10032());
        this.f15617 = false;
    }
}
