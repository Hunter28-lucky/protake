package com.blink.academy.film.widgets.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.setting.RecordSettingView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4141;
import defpackage.C2462;
import defpackage.C2579;
import defpackage.C2813;
import defpackage.C4112;
import defpackage.C4535;
import defpackage.C4792;
import java.util.List;

/* loaded from: classes.dex */
public class DataSettingView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4141 f3909;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f3910;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3911;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3912;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3913;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3914;

    /* renamed from: ֈ, reason: contains not printable characters */
    public List<String> f3915;

    /* renamed from: ֏, reason: contains not printable characters */
    public List<String> f3916;

    /* renamed from: ׯ, reason: contains not printable characters */
    public RecordSettingView.InterfaceC1508 f3917;

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$Ϳ, reason: contains not printable characters */
    public class RunnableC1367 implements Runnable {
        public RunnableC1367() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = DataSettingView.this.f3909.f14352.getPaint().measureText(DataSettingView.this.getResources().getString(R.string.SETTINGS_CLIP_COUNT).toUpperCase());
            ViewGroup.LayoutParams layoutParams = DataSettingView.this.f3909.f14352.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            DataSettingView.this.f3909.f14352.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$Ԩ, reason: contains not printable characters */
    public class RunnableC1368 implements Runnable {
        public RunnableC1368() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = DataSettingView.this.f3909.f14351.getPaint().measureText("88888");
            ViewGroup.LayoutParams layoutParams = DataSettingView.this.f3909.f14351.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            DataSettingView.this.f3909.f14351.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$Ԫ, reason: contains not printable characters */
    public class RunnableC1369 implements Runnable {
        public RunnableC1369() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = DataSettingView.this.f3909.f14357.getPaint().measureText(DataSettingView.this.getResources().getString(R.string.SETTINGS_SUFFIX).toUpperCase());
            ViewGroup.LayoutParams layoutParams = DataSettingView.this.f3909.f14357.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            DataSettingView.this.f3909.f14357.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$Ԭ, reason: contains not printable characters */
    public class RunnableC1370 implements Runnable {
        public RunnableC1370() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = DataSettingView.this.f3909.f14358.getPaint().measureText("WWWW");
            ViewGroup.LayoutParams layoutParams = DataSettingView.this.f3909.f14358.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            DataSettingView.this.f3909.f14358.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$Ԯ, reason: contains not printable characters */
    public class RunnableC1371 implements Runnable {
        public RunnableC1371() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            float fMeasureText = DataSettingView.this.f3909.f14353.getPaint().measureText(DataSettingView.this.getResources().getString(R.string.SETTINGS_FORMATS).toUpperCase());
            ViewGroup.LayoutParams layoutParams = DataSettingView.this.f3909.f14353.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            DataSettingView.this.f3909.f14353.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ՠ, reason: contains not printable characters */
    public class RunnableC1372 implements Runnable {
        public RunnableC1372() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            float fMeasureText = DataSettingView.this.f3909.f14354.getPaint().measureText(DataSettingView.this.getResources().getString(R.string.SETTINGS_LOCATION).toUpperCase());
            ViewGroup.LayoutParams layoutParams = DataSettingView.this.f3909.f14354.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            DataSettingView.this.f3909.f14354.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ֈ, reason: contains not printable characters */
    public class C1373 implements FilmStopView.InterfaceC0908 {
        public C1373() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            DataSettingView.this.f3914 = i;
            DataSettingView.this.m3925();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$֏, reason: contains not printable characters */
    public class C1374 implements FilmStopView.InterfaceC0908 {
        public C1374() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            DataSettingView.this.f3913 = i;
            DataSettingView.this.m3925();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1375 implements View.OnClickListener {
        public ViewOnClickListenerC1375() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DataSettingView.this.f3917 != null) {
                DataSettingView.this.f3917.mo1735();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1376 implements View.OnClickListener {
        public ViewOnClickListenerC1376() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DataSettingView.this.f3909.f14342.m2574()) {
                return;
            }
            DataSettingView.this.m3917(true, 100);
            C4535.m13880().m13890().m12343(0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC1377 implements View.OnClickListener {
        public ViewOnClickListenerC1377() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DataSettingView.this.f3909.f14343.m2574()) {
                return;
            }
            DataSettingView.this.m3917(false, 100);
            C4535.m13880().m13890().m12343(1);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ށ, reason: contains not printable characters */
    public class C1378 implements SwitchButton.InterfaceC0970 {
        public C1378() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0970
        /* renamed from: Ϳ */
        public void mo2633() {
            if (DataSettingView.this.m3918()) {
                DataSettingView.this.f3909.f14347.setEnabled(true);
                DataSettingView.this.f3909.f14347.m2630(true, true);
            } else if (DataSettingView.this.f3917 != null) {
                DataSettingView.this.f3917.mo1736();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ނ, reason: contains not printable characters */
    public class C1379 implements SwitchButton.InterfaceC0969 {
        public C1379() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C4535.m13880().m13890().m12551(z ? 1 : 0);
            C4535.m13880().m13915();
            DataSettingView.this.m3923();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ރ, reason: contains not printable characters */
    public class RunnableC1380 implements Runnable {
        public RunnableC1380() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = DataSettingView.this.f3909.f14350.getPaint().measureText(DataSettingView.this.getResources().getString(R.string.SETTINGS_CAMERA_UNIT).toUpperCase());
            ViewGroup.LayoutParams layoutParams = DataSettingView.this.f3909.f14350.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            DataSettingView.this.f3909.f14350.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ބ, reason: contains not printable characters */
    public class RunnableC1381 implements Runnable {
        public RunnableC1381() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = DataSettingView.this.f3909.f14355.getPaint().measureText(DataSettingView.this.getResources().getString(R.string.SETTINGS_REEL_NUMBER).toUpperCase());
            ViewGroup.LayoutParams layoutParams = DataSettingView.this.f3909.f14355.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            DataSettingView.this.f3909.f14355.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ޅ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1382 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f3933;

        /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ޅ$Ϳ, reason: contains not printable characters */
        public class RunnableC1383 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f3934;

            public RunnableC1383(View view) {
                this.f3934 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f3934.isEnabled()) {
                    ViewOnTouchListenerC1382.this.f3933.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1382(View view) {
            this.f3933 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f3933.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1383(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ކ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1384 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public StrokeTextViewWithBottomBlock f3936;

        /* renamed from: com.blink.academy.film.widgets.setting.DataSettingView$ކ$Ϳ, reason: contains not printable characters */
        public class RunnableC1385 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f3937;

            public RunnableC1385(View view) {
                this.f3937 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f3937.isEnabled()) {
                    ViewOnTouchListenerC1384.this.f3936.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1384(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock) {
            this.f3936 = strokeTextViewWithBottomBlock;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (this.f3936.m2574()) {
                    return false;
                }
                this.f3936.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1385(view), 100L);
            return false;
        }
    }

    public DataSettingView(Context context) {
        this(context, null);
    }

    public void setOnButtonClick(RecordSettingView.InterfaceC1508 interfaceC1508) {
        this.f3917 = interfaceC1508;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m3917(boolean z, int i) {
        if (z) {
            this.f3909.f14342.m2575(true, i);
            this.f3909.f14343.m2575(false, i);
        } else {
            this.f3909.f14342.m2575(false, i);
            this.f3909.f14343.m2575(true, i);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean m3918() {
        return C4112.m13054();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m3919() {
        C2462.m9035().m9065();
        C4535.m13880().m13890().m12524(1001);
        C4535.m13880().m13915();
        m3924();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m3920() {
        this.f3909 = AbstractC4141.m13119(LayoutInflater.from(getContext()), this, true);
        m3922();
        m3921();
        m3924();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m3921() {
        this.f3911 = C2579.m9444();
        this.f3912 = C2579.m9440(getContext());
        float fM14471 = C4792.m14375().m14471();
        int iM14468 = C4792.m14375().m14468();
        int i = (this.f3911 - (iM14468 * 2)) / 4;
        Paint paint = new Paint();
        paint.setTypeface(FilmApp.m404());
        float fM14384 = (int) ((C4792.m14375().m14384() * fM14471) + 0.5f);
        paint.setTextSize(fM14384);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3909.f14350.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = iM14468;
        this.f3909.f14350.setLayoutParams(layoutParams);
        this.f3909.f14350.setContentTextColor(-1);
        float fM14397 = (int) ((C4792.m14375().m14397() * fM14471) + 0.5f);
        this.f3909.f14350.m2562(0, fM14397);
        this.f3909.f14348.m2327(0, fM14384);
        this.f3909.f14348.setTextColor(-1);
        int iM14386 = C4792.m14375().m14386();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f3909.f14348.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = C4792.m14375().m14377();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) ((((C4792.m14375().m14390() * 2) + (C4792.m14375().m14377() * 2) + paint.measureText("M")) * fM14471) + 0.5f);
        float fMax = Math.max(iM14386, (int) ((this.f3909.f14348.getTextHeight() * fM14471) + 0.5f));
        int i2 = (int) ((fMax * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = i2;
        float f = (fMax * 10.0f) / 51.0f;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = (int) (iM14468 - f);
        this.f3909.f14348.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f3909.f14355.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = i;
        this.f3909.f14355.setLayoutParams(layoutParams3);
        this.f3909.f14355.setContentTextColor(-1);
        this.f3909.f14355.m2562(0, fM14397);
        this.f3909.f14349.m2327(0, fM14384);
        this.f3909.f14349.setTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f3909.f14349.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = C4792.m14375().m14377();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (((C4792.m14375().m14390() * 2) + (C4792.m14375().m14377() * 2) + paint.measureText("888")) * fM14471);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = i2;
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (int) (i - f);
        this.f3909.f14349.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f3909.f14352.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = i;
        this.f3909.f14352.setLayoutParams(layoutParams5);
        this.f3909.f14352.setContentTextColor(-1);
        this.f3909.f14352.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f3909.f14351.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = C4792.m14375().m14377();
        this.f3909.f14351.setLayoutParams(layoutParams6);
        this.f3909.f14351.setContentTextColor(-1);
        this.f3909.f14351.m2562(0, fM14384);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f3909.f14357.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin = i;
        this.f3909.f14357.setLayoutParams(layoutParams7);
        this.f3909.f14357.setContentTextColor(-1);
        this.f3909.f14357.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f3909.f14358.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = C4792.m14375().m14377();
        this.f3909.f14358.setLayoutParams(layoutParams8);
        this.f3909.f14358.setContentTextColor(-1);
        this.f3909.f14358.m2562(0, fM14384);
        this.f3909.f14356.setTypeface(FilmApp.m404());
        this.f3909.f14356.setTextSize(0, C4792.m14375().m14397());
        this.f3909.f14356.setText(R.string.BUTTON_RESET);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f3909.f14341.getLayoutParams();
        TextPaint paint2 = this.f3909.f14356.getPaint();
        int iM14476 = C4792.m14375().m14476(23);
        int iM144762 = C4792.m14375().m14476(26);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float f2 = (int) (fontMetrics.descent - fontMetrics.ascent);
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = (int) (paint2.measureText(getContext().getString(R.string.BUTTON_RESET).toUpperCase()) + (iM144762 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = (int) (f2 + (iM14476 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams9).rightMargin = iM14468;
        this.f3909.f14341.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f3909.f14346.getLayoutParams();
        int iM14377 = C4792.m14375().m14377();
        int i3 = iM14377 * 2;
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = ((ViewGroup.MarginLayoutParams) layoutParams9).height + i3;
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = ((ViewGroup.MarginLayoutParams) layoutParams9).width + i3;
        ((ViewGroup.MarginLayoutParams) layoutParams10).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams9).rightMargin - iM14377;
        this.f3909.f14346.setLayoutParams(layoutParams10);
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f3909.f14353.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams11).topMargin = (int) (C4792.m14375().m14389() - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        ((ViewGroup.MarginLayoutParams) layoutParams11).leftMargin = iM14468;
        this.f3909.f14353.setLayoutParams(layoutParams11);
        this.f3909.f14353.setContentTextColor(-1);
        this.f3909.f14353.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f3909.f14342.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams12).topMargin = C4792.m14375().m14377();
        this.f3909.f14342.setLayoutParams(layoutParams12);
        this.f3909.f14342.m2576(0, fM14384);
        this.f3909.f14342.setTextColor(-1);
        this.f3909.f14342.setTextForSetting(getResources().getString(R.string.SETTINGS_FORMATS_H264));
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f3909.f14343.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams13).leftMargin = C4792.m14375().m14385() + C4792.m14375().m14377();
        this.f3909.f14343.setLayoutParams(layoutParams13);
        this.f3909.f14343.m2576(0, fM14384);
        this.f3909.f14343.setTextColor(-1);
        this.f3909.f14343.setTextForSetting(getResources().getString(R.string.SETTINGS_FORMATS_H265));
        LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) this.f3909.f14345.getLayoutParams();
        layoutParams14.topMargin = (int) (C4792.m14375().m14389() - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        this.f3909.f14345.setLayoutParams(layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) this.f3909.f14354.getLayoutParams();
        layoutParams15.leftMargin = iM14468;
        this.f3909.f14354.setLayoutParams(layoutParams15);
        this.f3909.f14354.setContentTextColor(-1);
        this.f3909.f14354.m2562(0, fM14397);
        LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) this.f3909.f14347.getLayoutParams();
        layoutParams16.width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        layoutParams16.height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        layoutParams16.leftMargin = (int) (layoutParams15.leftMargin - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        layoutParams16.topMargin = C4792.m14375().m14377();
        this.f3909.f14347.setLayoutParams(layoutParams16);
        this.f3909.f14347.setTextSize(C4792.m14375().m14481() * fM14471);
        m3926();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m3922() {
        AbstractC4141 abstractC4141 = this.f3909;
        abstractC4141.f14346.setOnTouchListener(new ViewOnTouchListenerC1382(abstractC4141.f14341));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock = this.f3909.f14342;
        strokeTextViewWithBottomBlock.setOnTouchListener(new ViewOnTouchListenerC1384(strokeTextViewWithBottomBlock));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2 = this.f3909.f14343;
        strokeTextViewWithBottomBlock2.setOnTouchListener(new ViewOnTouchListenerC1384(strokeTextViewWithBottomBlock2));
        this.f3909.f14349.setOnStopClick(new C1373());
        this.f3909.f14348.setOnStopClick(new C1374());
        this.f3909.f14346.setOnClickListener(new ViewOnClickListenerC1375());
        this.f3909.f14342.setOnClickListener(new ViewOnClickListenerC1376());
        this.f3909.f14343.setOnClickListener(new ViewOnClickListenerC1377());
        this.f3909.f14347.setOnInterceptToggle(new C1378());
        this.f3909.f14347.setOnCheckedChangeListener(new C1379());
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m3923() {
        this.f3909.f14347.setEnabled(true);
        if (m3918() && C4535.m13880().m13890().m12437() == 1) {
            this.f3909.f14347.m2630(false, true);
            this.f3909.f14347.setEnabled(true);
        } else {
            this.f3909.f14347.m2630(false, false);
            this.f3909.f14347.setEnabled(false);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m3924() {
        this.f3910 = C2813.f10275;
        this.f3915 = C2462.m9035().m9040();
        this.f3916 = C2462.m9035().m9058();
        this.f3909.f14348.setStringDataList(this.f3915);
        this.f3909.f14349.setStringDataList(this.f3916);
        this.f3909.f14348.setCurrentI(0);
        this.f3909.f14349.setCurrentI(0);
        int iM12408 = C4535.m13880().m13890().m12408();
        int i = iM12408 / 1000;
        int i2 = i - 1;
        this.f3913 = i2;
        this.f3914 = (iM12408 - (i * 1000)) - 1;
        this.f3909.f14348.setCurrentI(i2);
        this.f3909.f14349.setCurrentI(this.f3914);
        this.f3909.f14358.setText(C2462.m9035().m9064());
        m3917(C4535.m13880().m13890().m12478() == 0, 0);
        if (this.f3910) {
            this.f3909.f14344.setVisibility(0);
        } else {
            this.f3909.f14344.setVisibility(8);
        }
        m3925();
        m3923();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m3925() {
        int i = ((this.f3913 + 1) * 1000) + this.f3914 + 1;
        this.f3909.f14351.setText(C2462.m9035().m9042(i));
        C4535.m13880().m13890().m12524(i);
        C4535.m13880().m13915();
        if (C2462.m9035().m9037()) {
            this.f3909.f14351.setText(C2462.m9035().m9042(i));
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m3926() {
        this.f3909.f14350.setDrawBorder(false);
        this.f3909.f14355.setDrawBorder(false);
        this.f3909.f14352.setDrawBorder(false);
        this.f3909.f14351.setDrawBorder(false);
        this.f3909.f14357.setDrawBorder(false);
        this.f3909.f14358.setDrawBorder(false);
        this.f3909.f14348.m2316();
        this.f3909.f14349.m2316();
        this.f3909.f14353.setDrawBorder(false);
        this.f3909.f14342.m2571();
        this.f3909.f14343.m2571();
        this.f3909.f14354.setDrawBorder(false);
        this.f3909.f14350.post(new RunnableC1380());
        this.f3909.f14355.post(new RunnableC1381());
        this.f3909.f14352.post(new RunnableC1367());
        this.f3909.f14351.post(new RunnableC1368());
        this.f3909.f14357.post(new RunnableC1369());
        this.f3909.f14358.post(new RunnableC1370());
        this.f3909.f14353.post(new RunnableC1371());
        this.f3909.f14354.post(new RunnableC1372());
    }

    public DataSettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DataSettingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3920();
    }
}
