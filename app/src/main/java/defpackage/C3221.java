package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.StrokeImageViewWithBottomBlock;
import defpackage.AbstractC4975;

/* compiled from: FilmImageChooseViewHolder.java */
/* renamed from: Շ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3221 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public StrokeImageViewWithBottomBlock f11346;

    public C3221(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        StrokeImageViewWithBottomBlock strokeImageViewWithBottomBlock = (StrokeImageViewWithBottomBlock) view;
        this.f11346 = strokeImageViewWithBottomBlock;
        ViewGroup.LayoutParams layoutParams = strokeImageViewWithBottomBlock.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = -1;
        this.f11346.setLayoutParams(layoutParams);
        int iM9438 = C2579.m9438(C4062.f14090);
        this.f11346.setPadding(iM9438, 0, iM9438, 0);
        int iM14476 = C4792.m14375().m14476(100);
        this.f11346.m2553(iM14476, iM14476);
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        this.f11346.setImageResBitmap(c4196.m13237().m8508());
        if (c4196.isSelected()) {
            this.f11346.m2554(true, 0);
        } else {
            this.f11346.m2554(false, 0);
        }
        if (c4196.m13229() != 0) {
            this.f11346.setPadding(c4196.m13229(), 0, c4196.m13229(), 0);
        }
    }

    @Override // defpackage.C4734
    /* renamed from: ԫ */
    public void mo8729(boolean z) {
        this.f11346.m2554(z, 100);
    }
}
