package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import defpackage.AbstractC4975;

/* compiled from: GridsSafeTextChooseViewHolder.java */
/* renamed from: и, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2886 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public StrokeTextViewWithBottomBlock f10563;

    public C2886(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock = (StrokeTextViewWithBottomBlock) view;
        this.f10563 = strokeTextViewWithBottomBlock;
        ViewGroup.LayoutParams layoutParams = strokeTextViewWithBottomBlock.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = C4792.m14375().m14405();
        this.f10563.setLayoutParams(layoutParams);
        this.f10563.setPadding(C4792.m14375().m14386(), 0, C4792.m14375().m14386(), 0);
        this.f10563.m2576(0, C4792.m14375().m14386());
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        if (c4196.m13224() != 0) {
            this.f10563.m2576(0, c4196.m13224());
        }
        if (c4196.m13223() != null) {
            if (c4196.m13223().m12141()) {
                this.f10563.setText(String.format("%s", c4196.m13232()));
            } else {
                this.f10563.setText(c4196.m13233());
            }
        } else if (c4196.m13233() != 0) {
            this.f10563.setText(c4196.m13233());
        } else {
            this.f10563.setText(String.format("%s", c4196.m13232()));
        }
        if (c4196.isSelected()) {
            this.f10563.m2575(true, 0);
        } else {
            this.f10563.m2575(false, 0);
        }
        if (c4196.m13238()) {
            this.f10563.setEnabled(false);
            this.f10563.setAlpha(0.3f);
        } else {
            this.f10563.setEnabled(true);
            this.f10563.setAlpha(1.0f);
        }
        if (c4196.m13229() != 0) {
            this.f10563.setPadding(c4196.m13229(), 0, c4196.m13229(), 0);
        }
    }

    @Override // defpackage.C4734
    /* renamed from: ԫ */
    public void mo8729(boolean z) {
        this.f10563.m2575(z, 100);
    }
}
