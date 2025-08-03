package defpackage;

import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;

/* compiled from: LooksStyleChooseViewHoder.java */
/* renamed from: ʪ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2712 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public StrokeTextViewWithBottomBlock f10032;

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        if (c4196.m13233() != 0) {
            this.f10032.setText(c4196.m13233());
        } else {
            this.f10032.setText(String.format("%s", c4196.m13232()));
        }
        if (c4196.isSelected()) {
            this.f10032.m2575(true, 0);
        } else {
            this.f10032.m2575(false, 0);
        }
        if (c4196.m13229() != 0) {
            this.f10032.setPadding(c4196.m13229(), 0, c4196.m13229(), 0);
        }
    }

    @Override // defpackage.C4734
    /* renamed from: ԫ */
    public void mo8729(boolean z) {
        this.f10032.m2575(z, 100);
    }
}
