package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;

/* compiled from: ShutterTextChooseViewHolder.java */
/* renamed from: ඹ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4842 extends AbstractC4956<C2798> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public StrokeTextViewWithBottomBlock f16349;

    /* renamed from: ԯ, reason: contains not printable characters */
    public View f16350;

    public C4842(View view, Context context, AbstractC4975.InterfaceC4977<C2798> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        view.setPadding(0, C4792.m14375().m14476(20), 0, 0);
        this.f16349 = (StrokeTextViewWithBottomBlock) view.findViewById(R.id.stroke_tv);
        View viewFindViewById = view.findViewById(R.id.root);
        this.f16350 = viewFindViewById;
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.width = C4792.m14375().m14476(C4792.m14375().m14474());
        this.f16350.setLayoutParams(layoutParams);
        this.f16349.m2576(0, C4792.m14375().m14386());
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(C2798 c2798, int i) {
        this.f16349.setText(c2798.m10114() ? c2798.m10113() : c2798.m10111());
        if (c2798.isSelected()) {
            this.f16349.m2575(true, 0);
        } else {
            this.f16349.m2575(false, 0);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m14568(boolean z) {
        this.f16349.m2575(z, 200);
    }
}
