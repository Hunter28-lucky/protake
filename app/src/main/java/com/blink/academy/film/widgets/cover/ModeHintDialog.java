package com.blink.academy.film.widgets.cover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmPointView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextView2;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4364;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4535;
import defpackage.C4792;

/* loaded from: classes.dex */
public class ModeHintDialog extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4364 f2896;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f2897;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC1014 f2898;

    /* renamed from: com.blink.academy.film.widgets.cover.ModeHintDialog$Ϳ, reason: contains not printable characters */
    public class C1012 extends AbstractC4012 {
        public C1012() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ModeHintDialog.this.setVisibility(8);
            view.clearAnimation();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.cover.ModeHintDialog$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1013 implements View.OnClickListener {
        public ViewOnClickListenerC1013() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1014 interfaceC1014 = ModeHintDialog.this.f2898;
            if (interfaceC1014 != null) {
                interfaceC1014.onClose();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.cover.ModeHintDialog$Ԫ, reason: contains not printable characters */
    public interface InterfaceC1014 {
        void onClose();
    }

    public ModeHintDialog(@NonNull Context context) {
        this(context, null);
    }

    public void setOnCloseListener(InterfaceC1014 interfaceC1014) {
        this.f2898 = interfaceC1014;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m2849() {
        C4008.m12876(this.f2896.f15012, 0.0f, 100, new C1012());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2850() {
        this.f2896 = (AbstractC4364) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_mode_hint_dialog, this, true);
        m2853();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2851() {
        m2855(this.f2896.f15013, getResources().getString(R.string.GUIDE_BUTTON_CLOSE).toUpperCase());
        m2855(this.f2896.f15017, getResources().getString(R.string.GUIDE_TITLE_CAMERA_MODES));
        m2856(this.f2896.f15015, getResources().getString(R.string.GUIDE_DESC_CAMERA_MODES));
        this.f2897 = false;
        if (FilmApp.m405().m406()) {
            this.f2897 = C4535.m13880().m13890().m12495();
        }
        m2854(this.f2897);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2852() {
        m2851();
        float fM9450 = (C2579.f9594 - C2579.m9450(getContext())) / 2.0f;
        float fM9440 = (C2579.f9593 - C2579.m9440(getContext())) / 2.0f;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2896.f15013.getLayoutParams();
        layoutParams.width = (int) (this.f2896.f15013.getPaint().measureText(getResources().getString(R.string.GUIDE_BUTTON_CLOSE).toUpperCase()) + C4792.f16138);
        this.f2896.f15013.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2896.f15017.getLayoutParams();
        layoutParams2.topMargin = C4792.m14375().m14476(30);
        layoutParams2.width = (int) (this.f2896.f15017.getPaint().measureText(getResources().getString(R.string.GUIDE_TITLE_CAMERA_MODES)) + C4792.f16138 + 0.5f);
        this.f2896.f15017.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f2896.f15016.getLayoutParams();
        layoutParams3.width = C4792.m14375().m14476(113);
        layoutParams3.height = C4792.m14375().m14476(113);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2896.f15011.getLayoutParams();
        int iM14439 = (int) (C4792.m14375().m14439() * 2.5f);
        layoutParams4.width = iM14439;
        layoutParams4.height = iM14439;
        layoutParams4.bottomMargin = (int) (((-(iM14439 - C4792.m14375().m14439())) / 2.0f) + C4792.m14375().m14476(10) + fM9440);
        layoutParams4.rightMargin = (int) (((C4792.m14375().m14454() + C4792.m14375().m14476(171)) + fM9450) - ((layoutParams4.width - layoutParams3.width) / 2.0f));
        this.f2896.f15011.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f2896.f15018.getLayoutParams();
        int iM144392 = (int) C4792.m14375().m14439();
        layoutParams5.width = iM144392;
        layoutParams5.height = iM144392;
        this.f2896.f15018.setLayoutParams(layoutParams5);
        this.f2896.f15016.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f2896.f15020.getLayoutParams();
        layoutParams6.bottomMargin = (int) (-((layoutParams4.bottomMargin - C4792.m14375().m14476(39)) - fM9440));
        this.f2896.f15020.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f2896.f15010.getLayoutParams();
        layoutParams7.width = (int) C4792.m14375().m14439();
        layoutParams7.height = layoutParams5.width;
        layoutParams7.rightMargin = (int) (C4792.m14375().m14454() - ((layoutParams7.width - layoutParams3.width) / 2.0f));
        this.f2896.f15010.setLayoutParams(layoutParams7);
        this.f2896.f15018.m2859(layoutParams7.width, layoutParams7.height);
        this.f2896.f15010.m2859(layoutParams7.width, layoutParams7.height);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.f2896.f15019.getLayoutParams();
        layoutParams8.bottomMargin = -C4792.m14375().m14476(16);
        this.f2896.f15019.setLayoutParams(layoutParams8);
        int iM14476 = C4792.m14375().m14476(435);
        this.f2896.f15015.setMaxWidth(iM14476);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f2896.f15022.getLayoutParams();
        layoutParams9.width = iM14476;
        layoutParams9.rightMargin = (int) (C4792.m14375().m14476(70) + fM9450);
        layoutParams9.topMargin = (int) (C4792.m14375().m14476(430) + fM9440);
        this.f2896.f15022.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f2896.f15015.getLayoutParams();
        layoutParams10.topMargin = C4792.m14375().m14476(35);
        layoutParams10.width = iM14476;
        layoutParams10.rightMargin = (int) (fM9450 + C4792.m14375().m14476(70));
        layoutParams10.height = C4792.m14375().m14476(500);
        this.f2896.f15015.setLayoutParams(layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.f2896.f15009.getLayoutParams();
        layoutParams11.rightMargin = (layoutParams9.rightMargin + layoutParams.rightMargin) - C4792.m14375().m14377();
        layoutParams11.topMargin = (int) ((layoutParams9.topMargin - (C2579.m9438(44.0f) / 2.0f)) + (this.f2896.f15013.getPaint().measureText(getResources().getString(R.string.GUIDE_BUTTON_CLOSE).toUpperCase()) / 2.0f));
        int iM9438 = C2579.m9438(44.0f);
        layoutParams11.width = iM9438;
        layoutParams11.height = iM9438;
        this.f2896.f15009.setLayoutParams(layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) this.f2896.f15014.getLayoutParams();
        int iM94382 = C2579.m9438(8.0f);
        layoutParams12.width = iM94382;
        layoutParams12.height = iM94382;
        layoutParams12.rightMargin = C4792.m14375().m14476(15);
        this.f2896.f15014.setLayoutParams(layoutParams12);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m2853() {
        View view = this.f2896.f15012;
        if (view != null) {
            view.setOnClickListener(new ViewOnClickListenerC1013());
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2854(boolean z) {
        if (z) {
            this.f2896.f15016.setImageResource(R.drawable.icon_50_mode_pro);
        } else {
            this.f2896.f15016.setImageResource(R.drawable.icon_50_mode_auto);
        }
        for (int i = 0; i < 2; i++) {
            FilmPointView filmPointView = (FilmPointView) this.f2896.f15019.getChildAt(i);
            filmPointView.m2292(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) filmPointView.getLayoutParams();
            int iM14395 = C4792.m14375().m14395();
            layoutParams.width = iM14395;
            layoutParams.height = iM14395;
            if (i == 0) {
                layoutParams.rightMargin = C4792.m14375().m14388();
            } else {
                layoutParams.leftMargin = C4792.m14375().m14388();
            }
            filmPointView.setLayoutParams(layoutParams);
        }
        if (z) {
            ((FilmPointView) this.f2896.f15019.getChildAt(1)).m2292(true);
        } else {
            ((FilmPointView) this.f2896.f15019.getChildAt(0)).m2292(true);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2855(StrokeTextView strokeTextView, String str) {
        strokeTextView.setTypeface(FilmApp.m404());
        strokeTextView.m2562(0, C4792.m14375().m14397());
        strokeTextView.setText(str);
        strokeTextView.setContentTextColor(C4792.m14375().m14431());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m2856(StrokeTextView2 strokeTextView2, String str) {
        strokeTextView2.m2568(FilmApp.m404()).m2567(C4792.m14375().m14397()).m2566(C4792.m14375().m14431()).m2569(((C4792.m14375().m14397() * 1.0f) / C4792.m14375().m14378()) * C4792.m14375().m14441()).m2570(str).m2565();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2857() {
        if (this.f2896.f15012 != null) {
            setVisibility(0);
            C4008.m12883(this.f2896.f15018, 1.0f, 2.5f, 0.8f, 0.0f, 2000, null);
        }
    }

    public ModeHintDialog(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ModeHintDialog(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2850();
    }
}
