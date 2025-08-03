package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.TextWithPointChooseView;
import defpackage.AbstractC4975;
import java.util.List;

/* compiled from: FilmTextLooksTypeViewHolder.java */
/* renamed from: ӻ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3133 extends AbstractC4956<C2685> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TextWithPointChooseView f11133;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final List<C2685> f11134;

    public C3133(View view, Context context, AbstractC4975.InterfaceC4977<C2685> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        TextWithPointChooseView textWithPointChooseView = (TextWithPointChooseView) view;
        this.f11133 = textWithPointChooseView;
        ViewGroup.LayoutParams layoutParams = textWithPointChooseView.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = C4792.m14375().m14476(165);
        textWithPointChooseView.setLayoutParams(layoutParams);
        int iM9438 = C2579.m9438(0.0f);
        textWithPointChooseView.setPadding(iM9438, 0, iM9438, 0);
        textWithPointChooseView.m2683(0, C4792.m14375().m14381());
        this.f11134 = interfaceC4977.mo11699();
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(C2685 c2685, int i) {
        if (c2685.m9905() != 0) {
            this.f11133.setText(c2685.m9905());
        } else {
            this.f11133.setText(String.format("%s", c2685.m9904()));
        }
        C3741 c3741M9902 = c2685.m9902();
        this.f11133.setShowPoint(true);
        this.f11133.setShowPointParent(c3741M9902.m11987());
        if (c2685.isSelected()) {
            this.f11133.m2682(true, 0);
            this.f11133.setPointSelect(true);
        } else {
            this.f11133.m2682(false, 0);
            this.f11133.setPointSelect(false);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m10722(boolean z) {
        this.f11133.setShowPointParent(z);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m10723(boolean z) {
        this.f11133.m2682(z, 200);
        this.f11133.setPointSelect(z);
    }
}
