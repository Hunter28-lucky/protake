package com.blink.academy.film.widgets.looks;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmSeekBar;
import defpackage.AbstractC4266;
import defpackage.C4792;
import defpackage.C5299;

/* loaded from: classes.dex */
public class PreviewItemView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4266 f3843;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f3844;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3845;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC1353 f3846;

    /* renamed from: com.blink.academy.film.widgets.looks.PreviewItemView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1348 implements View.OnClickListener {
        public ViewOnClickListenerC1348() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1353 interfaceC1353 = PreviewItemView.this.f3846;
            if (interfaceC1353 != null) {
                interfaceC1353.mo3854();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.PreviewItemView$Ԩ, reason: contains not printable characters */
    public class ViewOnLongClickListenerC1349 implements View.OnLongClickListener {
        public ViewOnLongClickListenerC1349() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PreviewItemView previewItemView = PreviewItemView.this;
            if (previewItemView.f3846 != null) {
                previewItemView.f3844 = true;
                PreviewItemView.this.f3846.mo3858();
            }
            return true;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.PreviewItemView$Ԫ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1350 implements View.OnTouchListener {
        public ViewOnTouchListenerC1350() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && PreviewItemView.this.f3844) {
                PreviewItemView.this.f3844 = false;
                InterfaceC1353 interfaceC1353 = PreviewItemView.this.f3846;
                if (interfaceC1353 != null) {
                    interfaceC1353.mo3855();
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.PreviewItemView$Ԭ, reason: contains not printable characters */
    public class C1351 implements FilmSeekBar.InterfaceC0896 {
        public C1351() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            PreviewItemView previewItemView = PreviewItemView.this;
            if (previewItemView.f3846 != null) {
                float fM3846 = previewItemView.m3846(f2 / 1000.0f, 200.0f, 0.0f);
                if (fM3846 == 100000.0f) {
                    PreviewItemView.this.f3843.f14637.setValueAndUpdateUI(100000.0f);
                } else {
                    PreviewItemView.this.f3843.f14637.setValueAndUpdateUI(1000.0f * fM3846);
                }
                PreviewItemView.this.m3853(false, fM3846);
                PreviewItemView.this.f3846.mo3857(fM3846);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.PreviewItemView$Ԯ, reason: contains not printable characters */
    public class C1352 implements FilmSeekBar.InterfaceC0897 {
        public C1352() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ϳ */
        public void mo2145() {
            InterfaceC1353 interfaceC1353 = PreviewItemView.this.f3846;
            if (interfaceC1353 != null) {
                interfaceC1353.mo3856();
            }
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ԩ */
        public void mo2146() {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.PreviewItemView$ՠ, reason: contains not printable characters */
    public interface InterfaceC1353 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo3854();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo3855();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo3856();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo3857(float f);

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo3858();
    }

    public PreviewItemView(@NonNull Context context) {
        this(context, null);
    }

    public int getTotalHeight() {
        return this.f3845;
    }

    public void setOnStrengthChange(InterfaceC1353 interfaceC1353) {
        this.f3846 = interfaceC1353;
    }

    public void setPaddingLeft(int i) {
        setPadding(i, 0, 0, 0);
    }

    public void setPaddingRight(int i) {
        setPadding(0, 0, i, 0);
    }

    public void setPreviewIv(int i) {
        C5299.m15341().m15346(getContext(), this.f3843.f14632, i);
    }

    public void setStyleName(String str) {
        TextPaint paint = this.f3843.f14641.getPaint();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3843.f14641.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(str) + C4792.f16138);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f3843.f14641.setLayoutParams(layoutParams);
        this.f3843.f14641.setText(str);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final float m3846(float f, float f2, float f3) {
        float f4 = (f2 + f3) / 2.0f;
        float f5 = f2 - f3;
        float f6 = 0.1f * f5;
        float f7 = f - f4;
        if (Math.abs(f7) <= f6) {
            f2 = f4;
        } else if (f <= f6) {
            f2 = f3;
        } else if (f2 - f > f6) {
            f2 = f4 + (((f > f4 ? f7 - f6 : f7 + f6) * (f5 - 2.0f)) / (f5 - (f6 * 4.0f)));
        }
        return Math.round(f2 * 1000.0f) / 1000.0f;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m3847() {
        this.f3843 = AbstractC4266.m13378(LayoutInflater.from(getContext()), this, true);
        m3848();
        m3849();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m3848() {
        float fM14434 = C4792.m14375().m14434();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3843.f14636.getLayoutParams();
        int iM14477 = C4792.m14375().m14477(262.0f, fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = iM14477;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) ((iM14477 * 16.0f) / 9.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14477(25.0f, fM14434);
        this.f3843.f14636.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f3843.f14641.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = C4792.m14375().m14477(15.0f, fM14434);
        this.f3843.f14641.setLayoutParams(layoutParams2);
        this.f3843.f14641.m2562(0, C4792.m14375().m14397());
        this.f3843.f14641.setContentTypeFace(FilmApp.m404());
        this.f3843.f14641.setContentTextColor(-1);
        this.f3843.f14642.m2562(0, C4792.m14375().m14397());
        this.f3843.f14642.setContentTypeFace(FilmApp.m404());
        this.f3843.f14642.setContentTextColor(-1);
        this.f3843.f14640.m2562(0, C4792.m14375().m14397());
        this.f3843.f14640.setContentTypeFace(FilmApp.m404());
        this.f3843.f14640.setContentTextColor(-1);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3843.f14637.getLayoutParams();
        layoutParams3.width = C4792.m14375().m14477(350.0f, fM14434);
        layoutParams3.height = C4792.m14375().m14477(150.0f, fM14434);
        this.f3843.f14637.setCircleRadius(C4792.m14375().m14477(26.0f, fM14434));
        this.f3843.f14637.setShowCenterLine(true);
        this.f3843.f14637.setClearStroke(true);
        this.f3843.f14637.setLineWidth(C4792.m14375().m14476(5));
        this.f3843.f14637.setLayoutParams(layoutParams3);
        this.f3843.f14630.setStrokeWidth(C4792.m14375().m14476(4));
        ViewGroup.LayoutParams layoutParams4 = this.f3843.f14638.getLayoutParams();
        layoutParams4.height = ((ViewGroup.MarginLayoutParams) layoutParams).height;
        layoutParams4.width = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        this.f3843.f14638.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f3843.f14631.getLayoutParams();
        layoutParams5.width = C4792.m14375().m14477(60.0f, fM14434);
        layoutParams5.height = C4792.m14375().m14477(20.0f, fM14434);
        layoutParams5.bottomMargin = C4792.m14375().m14477(30.0f, fM14434);
        layoutParams5.rightMargin = C4792.m14375().m14477(25.0f, fM14434);
        this.f3843.f14631.setLayoutParams(layoutParams5);
        this.f3843.f14631.m2463(C4792.m14375().m14476(5), C4792.m14375().m14476(4));
        this.f3843.f14643.setAlpha(0.7f);
        ViewGroup.LayoutParams layoutParams6 = this.f3843.f14633.getLayoutParams();
        int iM144772 = C4792.m14375().m14477(90.0f, fM14434);
        layoutParams6.width = iM144772;
        layoutParams6.height = iM144772;
        this.f3843.f14633.setLayoutParams(layoutParams6);
        Paint.FontMetrics fontMetrics = this.f3843.f14640.getPaint().getFontMetrics();
        this.f3845 = (int) (((ViewGroup.MarginLayoutParams) layoutParams).height + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + (((fontMetrics.bottom - fontMetrics.top) + C4792.f16138) * 2.0f));
        this.f3843.f14637.setOnProChange(new C1351());
        this.f3843.f14637.setOnTouchStateChange(new C1352());
        this.f3843.f14637.setMax(200000.0f);
        this.f3843.f14637.setMin(0.0f);
        this.f3843.f14637.setValueAndUpdateUI(100000.0f);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m3849() {
        this.f3843.f14635.setOnClickListener(new ViewOnClickListenerC1348());
        this.f3843.f14635.setOnLongClickListener(new ViewOnLongClickListenerC1349());
        this.f3843.f14635.setOnTouchListener(new ViewOnTouchListenerC1350());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3850(String str, int i) {
        TextPaint paint = this.f3843.f14640.getPaint();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3843.f14640.getLayoutParams();
        String str2 = String.format("%s (%s)", str, Integer.valueOf(i));
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(str2) + C4792.f16138);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f3843.f14640.setLayoutParams(layoutParams);
        if (i == 0) {
            this.f3843.f14640.setText("");
        } else {
            this.f3843.f14640.setText(str2);
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m3851(String str, int i) {
        C5299.m15341().m15344(getContext(), this.f3843.f14632, str, i);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m3852(int i, int i2) {
        if (i == 0) {
            this.f3843.f14635.setVisibility(0);
            this.f3843.f14639.setVisibility(4);
            this.f3843.f14642.setVisibility(4);
            this.f3843.f14638.setVisibility(8);
            this.f3843.f14631.setVisibility(4);
            this.f3843.f14629.setVisibility(4);
            this.f3843.f14634.setVisibility(4);
            return;
        }
        if (i == 1) {
            this.f3843.f14635.setVisibility(0);
            this.f3843.f14639.setVisibility(4);
            this.f3843.f14642.setVisibility(0);
            this.f3843.f14638.setVisibility(8);
            if (i2 == 0) {
                this.f3843.f14631.setVisibility(4);
            } else {
                this.f3843.f14631.setVisibility(0);
            }
            this.f3843.f14629.setVisibility(4);
            this.f3843.f14634.setVisibility(0);
            return;
        }
        if (i == 2) {
            this.f3843.f14635.setVisibility(4);
            this.f3843.f14639.setVisibility(0);
            this.f3843.f14642.setVisibility(0);
            this.f3843.f14638.setVisibility(0);
            this.f3843.f14631.setVisibility(4);
            this.f3843.f14629.setVisibility(4);
            this.f3843.f14634.setVisibility(4);
            return;
        }
        if (i != 3) {
            return;
        }
        this.f3843.f14635.setVisibility(0);
        this.f3843.f14639.setVisibility(4);
        this.f3843.f14642.setVisibility(4);
        this.f3843.f14638.setVisibility(8);
        this.f3843.f14631.setVisibility(4);
        this.f3843.f14629.setVisibility(0);
        this.f3843.f14634.setVisibility(4);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m3853(boolean z, float f) {
        TextPaint paint = this.f3843.f14642.getPaint();
        String str = Math.round(f) + "%";
        if (z) {
            str = "";
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3843.f14642.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(str) + C4792.f16138);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f3843.f14642.setLayoutParams(layoutParams);
        this.f3843.f14637.setValueAndUpdateUI(f * 1000.0f);
        this.f3843.f14642.setText(str);
    }

    public PreviewItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3847();
    }
}
