package defpackage;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.blink.academy.film.widgets.StrokeBorderView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: PlayListViewHolder.java */
/* renamed from: ව, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4846 extends AbstractC4956<C5202> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public View f16359;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ImageView f16360;

    /* renamed from: ՠ, reason: contains not printable characters */
    public StrokeBorderView f16361;

    /* renamed from: ֈ, reason: contains not printable characters */
    public StrokeTextView f16362;

    /* renamed from: ֏, reason: contains not printable characters */
    public StrokeTextView f16363;

    /* renamed from: ׯ, reason: contains not printable characters */
    public StrokeTextView f16364;

    /* renamed from: ؠ, reason: contains not printable characters */
    public ImageView f16365;

    /* renamed from: ހ, reason: contains not printable characters */
    public ImageView f16366;

    /* renamed from: ށ, reason: contains not printable characters */
    public View f16367;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f16368;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f16369;

    /* renamed from: ބ, reason: contains not printable characters */
    public C4272 f16370;

    public C4846(View view, Context context, AbstractC4975.InterfaceC4977<C5202> interfaceC4977, AbstractC4975.InterfaceC4976 interfaceC4976, int i, int i2, C4272 c4272) {
        super(view, context, interfaceC4977, interfaceC4976);
        this.f16367 = view;
        this.f16370 = c4272;
        this.f16359 = view.findViewById(R.id.top);
        this.f16360 = (ImageView) view.findViewById(R.id.top_iv);
        this.f16361 = (StrokeBorderView) view.findViewById(R.id.top_border);
        this.f16362 = (StrokeTextView) view.findViewById(R.id.tv_name);
        this.f16363 = (StrokeTextView) view.findViewById(R.id.tv_res);
        this.f16364 = (StrokeTextView) view.findViewById(R.id.tv_duration);
        this.f16365 = (ImageView) view.findViewById(R.id.iv_state);
        this.f16366 = (ImageView) view.findViewById(R.id.iv_multiple);
        this.f16368 = i;
        this.f16369 = i2;
        m14574();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m14574() {
        boolean zM13382 = this.f16370.m13382();
        ViewGroup.LayoutParams layoutParams = this.f16367.getLayoutParams();
        if (zM13382) {
            layoutParams.width = (int) (this.f16368 * 0.8784314f);
            layoutParams.height = this.f16369;
        } else {
            int i = this.f16368;
            layoutParams.width = (int) (i * 0.8784314f);
            layoutParams.height = i;
        }
        this.f16367.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f16359.getLayoutParams();
        if (zM13382) {
            int i2 = (int) (((int) (layoutParams.width * 0.5625f)) * 1.7777778f);
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            layoutParams2.topMargin = (int) (this.f16368 * 0.11764706f);
        } else {
            int i3 = (int) (layoutParams.width * 0.5625f);
            layoutParams2.height = i3;
            layoutParams2.width = (int) (i3 * 1.7777778f);
            layoutParams2.topMargin = (int) (this.f16368 * 0.11764706f);
        }
        this.f16359.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f16362.getLayoutParams();
        layoutParams3.topMargin = (int) (this.f16368 * 0.044444446f);
        this.f16362.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f16363.getLayoutParams();
        layoutParams4.topMargin = (int) (this.f16368 * 0.017777778f);
        this.f16363.setLayoutParams(layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.f16364.getLayoutParams();
        int i4 = layoutParams2.width;
        layoutParams5.bottomMargin = (int) (i4 * 0.067204304f);
        layoutParams5.leftMargin = (int) (i4 * 0.067204304f);
        this.f16364.setLayoutParams(layoutParams5);
        this.f16362.setContentTextColor(-1);
        this.f16363.setContentTextColor(-1);
        this.f16364.setContentTextColor(-1);
        this.f16362.m2562(0, C4792.m14375().m14396());
        this.f16363.m2562(0, C4792.m14375().m14396());
        this.f16364.m2562(0, C4792.m14375().m14396());
        Paint.FontMetrics fontMetrics = this.f16363.getPaint().getFontMetrics();
        int i5 = (int) (fontMetrics.bottom - fontMetrics.top);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f16365.getLayoutParams();
        int i6 = (int) (this.f16368 * 0.12444445f);
        layoutParams6.width = i6;
        layoutParams6.height = i6;
        layoutParams6.topMargin = layoutParams4.topMargin - ((i6 - i5) / 2);
        this.f16365.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f16366.getLayoutParams();
        int i7 = (int) (layoutParams.width * 0.15060242f);
        layoutParams7.width = i7;
        if (zM13382) {
            layoutParams7.width = (int) (i7 * 1.1590909f);
        }
        layoutParams7.height = layoutParams7.width;
        int i8 = this.f16368;
        layoutParams7.topMargin = (int) (i8 * 0.053333335f);
        layoutParams7.rightMargin = (int) (i8 * 0.053333335f);
        this.f16366.setLayoutParams(layoutParams7);
    }

    @Override // defpackage.AbstractC2769
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo3871(C5202 c5202, int i) {
        C2628 c2628M15171 = c5202.m15171();
        this.f16363.setText(c2628M15171.m9590());
        if (C4792.m14375().m14498()) {
            this.f16362.setText(c2628M15171.m9629().replace(".MP4", ""));
        } else {
            this.f16362.setText(c2628M15171.m9629());
        }
        float fMeasureText = this.f16363.getPaint().measureText(c2628M15171.m9590());
        ViewGroup.LayoutParams layoutParams = this.f16363.getLayoutParams();
        layoutParams.width = (int) (fMeasureText + C4792.f16138);
        this.f16363.setLayoutParams(layoutParams);
        float fMeasureText2 = C4792.m14375().m14498() ? this.f16362.getPaint().measureText(c2628M15171.m9629().replace(".MP4", "")) : this.f16362.getPaint().measureText(c2628M15171.m9629());
        ViewGroup.LayoutParams layoutParams2 = this.f16362.getLayoutParams();
        layoutParams2.width = (int) (fMeasureText2 + C4792.f16138);
        this.f16362.setLayoutParams(layoutParams2);
        String strM14576 = m14576(c2628M15171.m9591());
        this.f16364.setText(strM14576);
        float fMeasureText3 = this.f16364.getPaint().measureText(strM14576);
        ViewGroup.LayoutParams layoutParams3 = this.f16364.getLayoutParams();
        layoutParams3.width = (int) (fMeasureText3 + C4792.f16138);
        this.f16364.setLayoutParams(layoutParams3);
        m14577(c5202);
        m14578(c5202);
        String strM9635 = r1.m8143(c2628M15171.m9635()) ? c2628M15171.m9635() : c2628M15171.m9634();
        if (C4792.m14375().m14498()) {
            C5299.m15341().m15345(m10050(), this.f16360, strM9635);
        } else {
            C5299.m15341().m15343(m10050(), this.f16360, strM9635);
        }
        if (!C5049.m14852().m14858()) {
            this.f16366.setVisibility(8);
            return;
        }
        this.f16366.setVisibility(0);
        if (c5202.m15172()) {
            this.f16366.setImageResource(R.drawable.icon_25_selected);
        } else {
            this.f16366.setImageResource(R.drawable.icon_25_unselected);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String m14576(long j) {
        if (j <= 0) {
            return "00:00:00";
        }
        long j2 = j / 1000;
        int i = (int) (j2 % 60);
        int i2 = (int) ((j2 / 60) % 60);
        int i3 = (int) (j2 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return i3 > 0 ? formatter.format("%02d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i)).toString();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m14577(C5202 c5202) {
        this.f16361.setAlpha(0.0f);
        if (c5202.isSelected()) {
            this.f16361.setAlpha(1.0f);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m14578(C5202 c5202) {
        C2628 c2628M15171 = c5202.m15171();
        this.f16365.setAlpha(0.0f);
        if (c2628M15171.m9594() == 1) {
            this.f16365.setAlpha(1.0f);
            C5299.m15341().m15342(m10050(), this.f16365, R.drawable.icon_30_player_good_selected);
        }
        if (c2628M15171.m9596() == 1) {
            this.f16365.setAlpha(1.0f);
            C5299.m15341().m15342(m10050(), this.f16365, R.drawable.icon_30_player_keep_selected);
        }
        if (c2628M15171.m9630() == 1) {
            this.f16365.setAlpha(1.0f);
            C5299.m15341().m15342(m10050(), this.f16365, R.drawable.icon_30_player_ng_selected);
        }
    }
}
