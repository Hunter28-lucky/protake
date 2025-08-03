package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.adapter.fps.ImageClickView;
import defpackage.AbstractC4975;

/* compiled from: FilmImageClickViewHolder.java */
/* renamed from: ष, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4098 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ImageClickView f14237;

    public C4098(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        ImageClickView imageClickView = (ImageClickView) view;
        this.f14237 = imageClickView;
        ViewGroup.LayoutParams layoutParams = imageClickView.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = C4792.m14375().m14405();
        this.f14237.setLayoutParams(layoutParams);
        int iM9438 = C2579.m9438(C4062.f14090);
        this.f14237.setPadding(iM9438, 0, iM9438, 0);
        int iM14476 = C4792.m14375().m14476(68);
        this.f14237.m2763(iM14476, iM14476);
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        this.f14237.setImageRes(c4196.m13235().m8465());
        if (c4196.m13229() != 0) {
            this.f14237.setPadding(c4196.m13229(), 0, c4196.m13229(), 0);
        }
    }
}
