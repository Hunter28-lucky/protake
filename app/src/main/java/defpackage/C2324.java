package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.grids.GridsItemView;
import defpackage.AbstractC4975;

/* compiled from: GridsFrameChooseViewHolder.java */
/* renamed from: Ĕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2324 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public GridsItemView f8836;

    public C2324(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        GridsItemView gridsItemView = (GridsItemView) view;
        this.f8836 = gridsItemView;
        ViewGroup.LayoutParams layoutParams = gridsItemView.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = -1;
        this.f8836.setLayoutParams(layoutParams);
        this.f8836.m3175(0, C4792.m14375().m14386());
        this.f8836.m3176(0, C4792.m14375().m14398());
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        C3255 c3255M13225 = c4196.m13225();
        if (c4196.m13233() != 0) {
            this.f8836.m3178(c4196.m13233(), c3255M13225.m10919());
        } else {
            this.f8836.m3179(String.format("%s", c4196.m13232()), c3255M13225.m10919());
        }
        if (c4196.isSelected()) {
            this.f8836.m3177(true, 0);
        } else {
            this.f8836.m3177(false, 0);
        }
        this.f8836.setPadding(c4196.m13229(), 0, c4196.m13229(), 0);
    }

    @Override // defpackage.C4734
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo8729(boolean z) {
        this.f8836.m3177(z, 100);
    }
}
