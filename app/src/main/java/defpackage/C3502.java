package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.GridsTypeChooseView;
import defpackage.AbstractC4975;

/* compiled from: FilmTextGridsTypeViewHolder.java */
/* renamed from: ٺ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3502 extends AbstractC4956<C2685> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final GridsTypeChooseView f12267;

    public C3502(View view, Context context, AbstractC4975.InterfaceC4977<C2685> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        GridsTypeChooseView gridsTypeChooseView = (GridsTypeChooseView) view;
        this.f12267 = gridsTypeChooseView;
        ViewGroup.LayoutParams layoutParams = gridsTypeChooseView.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = (int) (C4792.m14375().m14476(165) * C4792.m14375().m14434());
        gridsTypeChooseView.setLayoutParams(layoutParams);
        int iM9438 = C2579.m9438(0.0f);
        gridsTypeChooseView.setPadding(iM9438, 0, iM9438, 0);
        gridsTypeChooseView.m2376(0, C4792.m14375().m14381() * C4792.m14375().m14434());
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(C2685 c2685, int i) {
        if (c2685.m9905() != 0) {
            this.f12267.setText(c2685.m9905());
        } else {
            this.f12267.setText(String.format("%s", c2685.m9904()));
        }
        if (c2685.isSelected()) {
            this.f12267.m2375(true, 0);
        } else {
            this.f12267.m2375(false, 0);
        }
        if (c2685.m9903() != 0) {
            this.f12267.setViewPadding(c2685.m9903());
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m11440(boolean z) {
        this.f12267.m2375(z, 200);
    }
}
