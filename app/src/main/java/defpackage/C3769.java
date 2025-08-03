package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.widgets.adapter.fps.FpsAutoStrokeView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;

/* compiled from: FPSAutoTextChooseViewHolder.java */
/* renamed from: ݸ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3769 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public FpsAutoStrokeView f13010;

    public C3769(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976) {
        super(view, context, interfaceC4977, interfaceC4976);
        FpsAutoStrokeView fpsAutoStrokeView = (FpsAutoStrokeView) view;
        this.f13010 = fpsAutoStrokeView;
        ViewGroup.LayoutParams layoutParams = fpsAutoStrokeView.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = C4792.m14375().m14405();
        this.f13010.setLayoutParams(layoutParams);
        this.f13010.setPadding(C4792.m14375().m14386(), 0, C4792.m14375().m14386(), 0);
        this.f13010.m2760(0, C4792.m14375().m14386());
        this.f13010.m2761(0, C4792.m14375().m14482());
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        this.f13010.setText(String.format("%s", c4196.m13232()));
        int type = c4196.m13235().getType();
        if (type == 1) {
            this.f13010.setRightImageVisible(0);
            String upperCase = m10050().getString(R.string.RECORDING_FPS_CONVERTED).toUpperCase();
            if (c4196.m13235().m8466() == 1) {
                upperCase = upperCase + " H.265";
            }
            this.f13010.setTopText(String.format("%s", upperCase));
            this.f13010.m2758(upperCase);
            if (C4792.m14375().m14498()) {
                this.f13010.setPadding((int) (C4792.m14375().m14386() - (C4792.m14375().m14476(50) / 2.0f)), 0, C4792.m14375().m14386(), 0);
            }
        } else if (type == 2) {
            this.f13010.setRightImageVisible(8);
            String upperCase2 = m10050().getString(R.string.RECORDING_FPS_DIRECT).toUpperCase();
            if (c4196.m13235().m8466() == 1) {
                upperCase2 = upperCase2 + " H.265";
            }
            this.f13010.setTopText(String.format("%s", upperCase2));
            this.f13010.m2758(upperCase2);
        } else {
            this.f13010.setRightImageVisible(8);
            String str = "";
            if (c4196.m13235().m8466() == 1) {
                str = " H.265";
            }
            this.f13010.setTopText(String.format("%s", str));
            this.f13010.m2758(str);
        }
        if (c4196.isSelected()) {
            this.f13010.m2759(true, 0);
        } else {
            this.f13010.m2759(false, 0);
        }
        if (c4196.m13238()) {
            this.f13010.setEnabled(false);
            this.f13010.setAlpha(0.3f);
        } else {
            this.f13010.setEnabled(true);
            this.f13010.setAlpha(1.0f);
        }
    }

    @Override // defpackage.C4734
    /* renamed from: ԫ */
    public void mo8729(boolean z) {
        this.f13010.m2759(z, 100);
    }
}
