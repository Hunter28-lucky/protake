package com.blink.academy.film.widgets.iso;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.widgets.iso.WheelProgressView;
import com.blink.academy.protake.R;
import defpackage.AbstractC3089;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.r1;
import java.util.List;

/* loaded from: classes.dex */
public class IsoEtWheelView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3089 f3328;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3329;

    /* renamed from: ԭ, reason: contains not printable characters */
    public ValueAnimator f3330;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ValueAnimator f3331;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ValueAnimator f3332;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3333;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC1200 f3334;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f3335;

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1187 implements View.OnClickListener {
        public ViewOnClickListenerC1187() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.mo3340();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$Ԩ, reason: contains not printable characters */
    public class C1188 extends AnimatorListenerAdapter {
        public C1188() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$Ԫ, reason: contains not printable characters */
    public class C1189 extends AnimatorListenerAdapter {
        public C1189() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$Ԭ, reason: contains not printable characters */
    public class C1190 extends AnimatorListenerAdapter {
        public C1190() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$Ԯ, reason: contains not printable characters */
    public class RunnableC1191 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3340;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f3341;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f3342;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ float f3343;

        public RunnableC1191(String str, String str2, String str3, float f) {
            this.f3340 = str;
            this.f3341 = str2;
            this.f3342 = str3;
            this.f3343 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) IsoEtWheelView.this.f3328.f10985.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) IsoEtWheelView.this.f3328.f10976.getLayoutParams();
            int iMeasureText = (int) IsoEtWheelView.this.f3328.f10984.getPaint().measureText(this.f3340);
            int iMeasureText2 = (int) IsoEtWheelView.this.f3328.f10986.getPaint().measureText(this.f3341);
            float fMax = Math.max(IsoEtWheelView.this.f3328.f10983.getPaint().measureText(this.f3342), iMeasureText);
            int i = iMeasureText2 / 2;
            int i2 = iMeasureText / 2;
            float fMax2 = Math.max(fMax, iMeasureText2);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) IsoEtWheelView.this.f3328.f10983.getLayoutParams();
            layoutParams3.width = (int) (C4792.f16138 + fMax2);
            layoutParams3.height = layoutParams.width;
            layoutParams3.rightMargin = (int) (((layoutParams2.rightMargin + layoutParams2.width) - (fMax2 / 2.0f)) + (C4792.m14375().m14476(65) * this.f3343) + 0.5f);
            IsoEtWheelView.this.f3328.f10983.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) IsoEtWheelView.this.f3328.f10984.getLayoutParams();
            layoutParams4.width = (int) (C4792.f16138 + fMax2);
            layoutParams4.rightMargin = layoutParams3.rightMargin;
            layoutParams4.height = layoutParams.width;
            int i3 = (i - i2) / 2;
            layoutParams4.topMargin = i2 + i3 + C4792.m14375().m14476(30);
            IsoEtWheelView.this.f3328.f10984.setLayoutParams(layoutParams4);
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) IsoEtWheelView.this.f3328.f10986.getLayoutParams();
            layoutParams5.width = (int) (fMax2 + C4792.f16138);
            layoutParams5.rightMargin = layoutParams3.rightMargin;
            layoutParams5.height = layoutParams.width;
            layoutParams5.topMargin = ((-i) + i3) - C4792.m14375().m14476(30);
            IsoEtWheelView.this.f3328.f10986.setLayoutParams(layoutParams5);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$ՠ, reason: contains not printable characters */
    public class C1192 implements WheelProgressView.InterfaceC1251 {
        public C1192() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1251
        public void onChange(float f) {
            if (r1.m8144(C3947.m12727().m12748())) {
                int iM12751 = C3947.m12727().m12751();
                int iM12752 = C3947.m12727().m12752();
                C3947.m12727().m12787((int) (iM12752 + ((iM12751 - iM12752) * C3947.m12727().m12757(f))));
                if (IsoEtWheelView.this.f3334 != null) {
                    IsoEtWheelView.this.f3334.mo3339();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$ֈ, reason: contains not printable characters */
    public class C1193 implements WheelProgressView.InterfaceC1251 {
        public C1193() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1251
        public void onChange(float f) {
            float fM12755;
            float fM12747;
            float fM12760;
            List<Float> listM12740 = C3947.m12727().m12740();
            if (r1.m8144(listM12740)) {
                float fFloatValue = listM12740.get(0).floatValue();
                float fFloatValue2 = listM12740.get(listM12740.size() - 1).floatValue();
                float f2 = fFloatValue - fFloatValue2;
                if (C3947.m12727().m12764()) {
                    fM12755 = fFloatValue2 + (f2 * f);
                    fM12747 = fM12755 / (C3947.m12727().m12747() * 360);
                    int iM12471 = C4535.m13880().m13890().m12471();
                    if (iM12471 != 0) {
                        fM12760 = C3947.m12727().m12760(iM12471);
                        fM12747 = fM12755 / (fM12760 * 360.0f);
                    }
                } else {
                    fM12755 = fFloatValue2 + (f2 * C3947.m12727().m12755(f));
                    fM12747 = fM12755 / (C3947.m12727().m12747() * 360);
                    int iM124712 = C4535.m13880().m13890().m12471();
                    if (iM124712 != 0) {
                        fM12760 = C3947.m12727().m12760(iM124712);
                        fM12747 = fM12755 / (fM12760 * 360.0f);
                    }
                }
                C3947.m12727().m12784(fM12747);
                C3947.m12727().m12788(fM12755);
                if (IsoEtWheelView.this.f3334 != null) {
                    IsoEtWheelView.this.f3334.mo3338(f);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$֏, reason: contains not printable characters */
    public class C1194 implements WheelProgressView.InterfaceC1251 {
        public C1194() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1251
        public void onChange(float f) {
            C3947.m12727().m12783(f);
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.mo3337();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$ׯ, reason: contains not printable characters */
    public class C1195 implements WheelProgressView.InterfaceC1252 {
        public C1195() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onAnimChange(boolean z) {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onDown() {
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.onTouchChange(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onUp() {
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.onTouchChange(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$ؠ, reason: contains not printable characters */
    public class C1196 implements WheelProgressView.InterfaceC1252 {
        public C1196() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onAnimChange(boolean z) {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onDown() {
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.onTouchChange(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onUp() {
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.onTouchChange(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$ހ, reason: contains not printable characters */
    public class C1197 implements WheelProgressView.InterfaceC1252 {
        public C1197() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onAnimChange(boolean z) {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onDown() {
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.onTouchChange(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressView.InterfaceC1252
        public void onUp() {
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.onTouchChange(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$ށ, reason: contains not printable characters */
    public class ViewOnClickListenerC1198 implements View.OnClickListener {
        public ViewOnClickListenerC1198() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3947.m12727().m12765() || IsoEtWheelView.this.f3335) {
                return;
            }
            IsoEtWheelView.this.f3335 = true;
            C3947.m12727().m12792(IsoEtWheelView.this.f3335);
            IsoEtWheelView.this.m3315();
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.mo3336();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$ނ, reason: contains not printable characters */
    public class ViewOnClickListenerC1199 implements View.OnClickListener {
        public ViewOnClickListenerC1199() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3947.m12727().m12765() || !IsoEtWheelView.this.f3335) {
                return;
            }
            IsoEtWheelView.this.f3335 = false;
            C3947.m12727().m12792(IsoEtWheelView.this.f3335);
            IsoEtWheelView.this.m3315();
            if (IsoEtWheelView.this.f3334 != null) {
                IsoEtWheelView.this.f3334.mo3336();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.IsoEtWheelView$ރ, reason: contains not printable characters */
    public interface InterfaceC1200 {
        void onTouchChange(boolean z);

        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo3336();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo3337();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo3338(float f);

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo3339();

        /* renamed from: ԭ, reason: contains not printable characters */
        void mo3340();
    }

    public IsoEtWheelView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ބ, reason: contains not printable characters */
    public /* synthetic */ void m3311(ValueAnimator valueAnimator) {
        this.f3328.f10975.setPro(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޅ, reason: contains not printable characters */
    public /* synthetic */ void m3312(ValueAnimator valueAnimator) {
        this.f3328.f10977.setPro(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ކ, reason: contains not printable characters */
    public /* synthetic */ void m3313(ValueAnimator valueAnimator) {
        this.f3328.f10982.setPro(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public float getCurrentShutterPro() {
        return this.f3328.f10982.getCurrentPro();
    }

    public void setCardWidth(int i) {
        this.f3333 = i;
    }

    public void setEtWheelEnable(boolean z) {
        this.f3328.f10975.setEnabled(z);
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            m3325();
            if (zM12765) {
                this.f3328.f10975.setAlpha(1.0f);
                this.f3328.f10983.setAlpha(1.0f);
                this.f3328.f10976.setAlpha(1.0f);
                return;
            }
            return;
        }
        this.f3328.f10975.setPro(0.0f);
        if (zM12765) {
            this.f3328.f10975.setAlpha(0.2f);
            this.f3328.f10983.setAlpha(0.2f);
            this.f3328.f10976.setAlpha(0.2f);
        }
    }

    public void setIconEnable(boolean z) {
        this.f3328.f10978.setEnabled(z);
    }

    public void setIsoWheelEnable(boolean z) {
        this.f3328.f10977.setEnabled(z);
        this.f3328.f10980.setEnabled(z);
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            m3327();
            if (zM12765) {
                return;
            }
            this.f3328.f10977.setAlpha(1.0f);
            this.f3328.f10984.setAlpha(1.0f);
            this.f3328.f10976.setAlpha(1.0f);
            return;
        }
        this.f3328.f10977.setPro(0.0f);
        if (zM12765) {
            return;
        }
        if (this.f3328.f10982.isEnabled()) {
            this.f3335 = false;
            C3947.m12727().m12792(this.f3335);
            m3315();
        } else {
            this.f3328.f10977.setAlpha(0.2f);
            this.f3328.f10984.setAlpha(0.2f);
            this.f3328.f10976.setAlpha(0.2f);
        }
    }

    public void setOnChange(InterfaceC1200 interfaceC1200) {
        this.f3334 = interfaceC1200;
    }

    public void setShutterWheelEnable(boolean z) {
        this.f3328.f10982.setEnabled(z);
        this.f3328.f10981.setEnabled(z);
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            m3330();
            if (zM12765) {
                return;
            }
            this.f3328.f10982.setAlpha(1.0f);
            this.f3328.f10984.setAlpha(1.0f);
            this.f3328.f10976.setAlpha(1.0f);
            return;
        }
        this.f3328.f10982.setPro(0.0f);
        if (zM12765) {
            return;
        }
        this.f3335 = true;
        C3947.m12727().m12792(this.f3335);
        m3315();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3314(float f) {
        this.f3328.f10978.setAlpha(f);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m3315() {
        if (this.f3335) {
            this.f3328.f10984.setContentTextColor(C4792.m14375().m14431());
            this.f3328.f10986.setContentTextColor(this.f3329);
            this.f3328.f10982.setVisibility(8);
            this.f3328.f10977.setVisibility(0);
            return;
        }
        this.f3328.f10986.setContentTextColor(C4792.m14375().m14431());
        this.f3328.f10984.setContentTextColor(this.f3329);
        this.f3328.f10982.setVisibility(0);
        this.f3328.f10977.setVisibility(8);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final Bitmap m3316(Resources resources, int i) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        resources.openRawResource(i, typedValue);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inTargetDensity = typedValue.density;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public float m3317(float f, float f2, float f3) {
        return (f - f2) / f3;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final Bitmap m3318(float f, float f2) throws Resources.NotFoundException {
        Bitmap bitmap;
        Rect rect;
        Rect rect2;
        float f3;
        float fM14434 = C4792.m14375().m14434();
        int iM14476 = (int) ((C4792.m14375().m14476((C4792.m14375().m14476(C4792.m14375().m14488()) * 2) + 658) * fM14434) + 0.5f);
        int i = iM14476 + (iM14476 % 2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        boolean z = true;
        Paint paint = new Paint(1);
        paint.setColor(Color.parseColor("#4c000000"));
        Paint paint2 = new Paint(1);
        paint2.setColor(Color.parseColor("#ffffff"));
        Paint paint3 = new Paint(1);
        paint3.setColor(Color.parseColor("#80ffffff"));
        float fM14476 = C4792.m14375().m14476(2) * fM14434;
        float fM144762 = C4792.m14375().m14476(2) * fM14434;
        Paint paint4 = new Paint(1);
        paint4.setColor(Color.parseColor("#000000"));
        paint4.setStrokeWidth(fM14476);
        paint4.setStyle(Paint.Style.STROKE);
        Paint paint5 = new Paint(1);
        paint5.setColor(Color.parseColor("#ffffff"));
        paint5.setStrokeWidth(fM144762);
        paint5.setStyle(Paint.Style.STROKE);
        Paint paint6 = new Paint(3);
        float f4 = i;
        float f5 = f4 / 2.0f;
        float f6 = 0.9f * f5;
        canvas.drawCircle(f5, f5, f6, paint);
        paint2.setStrokeWidth(0.004166667f * f4);
        paint3.setStrokeWidth(1.0f);
        float f7 = f4 - (0.077083334f * f4);
        float f8 = f7 - (0.029166667f * f4);
        float f9 = f7 - (0.020833334f * f4);
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int i2 = (int) (0.0375f * f4);
        int i3 = (int) (f6 + f5 + (f4 * 0.00625f));
        rect4.left = i3;
        rect4.right = i3 + i2;
        int i4 = (int) (f5 - (i2 / 2.0f));
        rect4.top = i4;
        rect4.bottom = i4 + i2;
        int i5 = 0;
        while (i5 < 60) {
            int i6 = i5 * 6;
            float f10 = i6;
            boolean z2 = ((f10 > f || i6 < 0) && f10 < f2 + 360.0f) ? false : z;
            if (i5 % 5 == 0) {
                if (z2) {
                    f3 = f10;
                    rect = rect4;
                    bitmap = bitmapCreateBitmap;
                    rect2 = rect3;
                    canvas.drawLine(f8, f5, f7, f5, paint2);
                } else {
                    bitmap = bitmapCreateBitmap;
                    f3 = f10;
                    rect = rect4;
                    rect2 = rect3;
                }
                if (f3 == f) {
                    Bitmap bitmapM3316 = m3316(getResources(), R.drawable.icon_15_wheel_exposure_max_2);
                    rect2.left = 0;
                    rect2.right = bitmapM3316.getWidth();
                    rect2.top = 0;
                    rect2.bottom = bitmapM3316.getHeight();
                    canvas.drawBitmap(bitmapM3316, rect2, rect, paint6);
                } else if (f3 == f2 + 360.0f) {
                    Bitmap bitmapM33162 = m3316(getResources(), R.drawable.icon_15_wheel_exposure_min);
                    rect2.left = 0;
                    rect2.right = bitmapM33162.getWidth();
                    rect2.top = 0;
                    rect2.bottom = bitmapM33162.getHeight();
                    canvas.drawBitmap(bitmapM33162, rect2, rect, paint6);
                }
            } else {
                bitmap = bitmapCreateBitmap;
                rect = rect4;
                rect2 = rect3;
                if (z2) {
                    canvas.drawLine(f9, f5, f7, f5, paint3);
                }
            }
            canvas.rotate(6.0f, f5, f5);
            i5++;
            rect3 = rect2;
            rect4 = rect;
            bitmapCreateBitmap = bitmap;
            z = true;
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m3319(int i) {
        C4008.m12886(this, -this.f3333, 0.0f, i, null);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m3320() {
        this.f3328 = AbstractC3089.m10681(LayoutInflater.from(getContext()), this, true);
        m3321();
        m3323();
        m3322();
        m3315();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m3321() {
        float fM14434 = C4792.m14375().m14434();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3328.f10976.getLayoutParams();
        layoutParams.width = (int) (((C4792.m14375().m14476(33) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        int iM14476 = (int) (((C4792.m14375().m14476(20) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        layoutParams.height = iM14476;
        layoutParams.height = iM14476 + (iM14476 % 2);
        layoutParams.rightMargin = (int) (((C4792.m14375().m14476(161) + C4792.m14375().m14443()) * fM14434) + 0.5f);
        this.f3328.f10976.setLayoutParams(layoutParams);
        int iM144762 = C4792.m14375().m14476(C4792.m14375().m14488());
        this.f3328.f10977.setPadding(iM144762, iM144762, iM144762, iM144762);
        this.f3328.f10982.setPadding(iM144762, iM144762, iM144762, iM144762);
        this.f3328.f10975.setPadding(iM144762, iM144762, iM144762, iM144762);
        this.f3328.f10977.setDegrees(60.0f, -60.0f);
        this.f3328.f10982.setDegrees(60.0f, -60.0f);
        this.f3328.f10975.setDegrees(60.0f, -60.0f);
        this.f3328.f10977.setRightView(false);
        this.f3328.f10982.setRightView(false);
        this.f3328.f10975.setRightView(false);
        this.f3328.f10975.setExposure(true);
        this.f3328.f10977.setVisibility(0);
        this.f3328.f10982.setVisibility(8);
        this.f3328.f10975.setVisibility(8);
        this.f3328.f10984.setAlpha(1.0f);
        this.f3328.f10983.setAlpha(0.0f);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3328.f10985.getLayoutParams();
        layoutParams2.rightMargin = (int) (((C4792.m14375().m14476(20) + layoutParams.width + layoutParams.rightMargin) * fM14434) + 0.5f);
        layoutParams2.width = (int) ((C4792.m14375().m14476(88) * fM14434) + 0.5f);
        layoutParams2.height = (int) ((C4792.m14375().m14476(325) * fM14434) + 0.5f);
        this.f3328.f10985.setLayoutParams(layoutParams2);
        int iM144763 = (int) ((C4792.m14375().m14476(C4792.m14375().m14401()) * fM14434) + 0.5f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f3328.f10978.getLayoutParams();
        float f = iM144763 * 2;
        layoutParams3.width = (int) ((C4792.m14375().m14476(C4792.m14375().m14399()) * fM14434) + 0.5f + f);
        layoutParams3.height = (int) ((C4792.m14375().m14476(C4792.m14375().m14399()) * fM14434) + 0.5f + f);
        this.f3328.f10978.setLayoutParams(layoutParams3);
        this.f3328.f10978.setPadding(iM144763, 0, iM144763, 0);
        this.f3335 = C3947.m12727().m12749();
        InterfaceC1200 interfaceC1200 = this.f3334;
        if (interfaceC1200 != null) {
            interfaceC1200.mo3336();
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m3322() {
        this.f3328.f10977.setOnProChange(new C1192());
        this.f3328.f10982.setOnProChange(new C1193());
        this.f3328.f10975.setOnProChange(new C1194());
        this.f3328.f10977.setOnTouchStateChange(new C1195());
        this.f3328.f10982.setOnTouchStateChange(new C1196());
        this.f3328.f10975.setOnTouchStateChange(new C1197());
        this.f3328.f10980.setOnClickListener(new ViewOnClickListenerC1198());
        this.f3328.f10981.setOnClickListener(new ViewOnClickListenerC1199());
        this.f3328.f10978.setOnClickListener(new ViewOnClickListenerC1187());
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m3323() {
        float fM14434 = C4792.m14375().m14434();
        this.f3328.f10977.setWheelImage(m3318(60.0f, -60.0f));
        this.f3328.f10982.setWheelImage(m3318(60.0f, -60.0f));
        this.f3328.f10975.setWheelImage(m3318(60.0f, -60.0f));
        String upperCase = getResources().getString(R.string.RECORDING_WHEELS_ISO).toUpperCase();
        this.f3328.f10984.setText(upperCase);
        this.f3328.f10984.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3328.f10984.setContentTextColor(C4792.m14375().m14431());
        String upperCase2 = getResources().getString(R.string.RECORDING_WHEELS_EXPOSURE).toUpperCase();
        this.f3328.f10983.setText(upperCase2);
        this.f3328.f10983.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3328.f10983.setContentTextColor(-1);
        String upperCase3 = getResources().getString(R.string.RECORDING_INFO_SHUTTER).toUpperCase();
        this.f3328.f10986.setText(upperCase3);
        this.f3328.f10986.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3328.f10986.setContentTextColor(-1);
        this.f3328.f10983.setAlpha(0.0f);
        this.f3328.f10984.setAlpha(1.0f);
        this.f3328.f10983.post(new RunnableC1191(upperCase, upperCase3, upperCase2, fM14434));
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m3324() {
        if (this.f3328.f10978.isEnabled()) {
            this.f3328.f10978.performClick();
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m3325() {
        if (this.f3328.f10975.isEnabled()) {
            this.f3328.f10975.setPro(C3947.m12727().m12734());
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m3326(float f) {
        if (this.f3328.f10975.isEnabled()) {
            float fM12734 = C3947.m12727().m12734();
            ValueAnimator valueAnimator = this.f3330;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f3330.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, fM12734);
            this.f3330 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(100L);
            this.f3330.setInterpolator(new LinearInterpolator());
            this.f3330.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ஃ
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f15332.m3311(valueAnimator2);
                }
            });
            this.f3330.addListener(new C1190());
            this.f3330.start();
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m3327() {
        if (this.f3328.f10977.isEnabled()) {
            float fM12738 = C3947.m12727().m12738();
            if (r1.m8144(C3947.m12727().m12748())) {
                int iM12751 = C3947.m12727().m12751();
                int iM12752 = C3947.m12727().m12752();
                int i = iM12751 - iM12752;
                float f = fM12738 - iM12752;
                float f2 = 1.0f;
                float f3 = (f * 1.0f) / i;
                if (f3 < 0.0f) {
                    f2 = 0.0f;
                } else if (f3 <= 1.0f) {
                    f2 = f3;
                }
                this.f3328.f10977.setPro(C3947.m12727().m12750(f2));
            }
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m3328(float f) {
        if (this.f3328.f10977.isEnabled()) {
            float fM12738 = C3947.m12727().m12738();
            if (r1.m8144(C3947.m12727().m12748())) {
                int iM12751 = C3947.m12727().m12751();
                int iM12752 = C3947.m12727().m12752();
                int i = iM12751 - iM12752;
                float f2 = fM12738 - iM12752;
                float f3 = 1.0f;
                float f4 = (f2 * 1.0f) / i;
                if (f4 < 0.0f) {
                    f3 = 0.0f;
                } else if (f4 <= 1.0f) {
                    f3 = f4;
                }
                float fM12750 = C3947.m12727().m12750(f3);
                ValueAnimator valueAnimator = this.f3331;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f3331.cancel();
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, fM12750);
                this.f3331 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(100L);
                this.f3331.setInterpolator(new LinearInterpolator());
                this.f3331.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ҙ
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f10695.m3312(valueAnimator2);
                    }
                });
                this.f3331.addListener(new C1188());
                this.f3331.start();
            }
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m3329() {
        m3327();
        m3330();
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m3330() {
        float fFloatValue;
        float fFloatValue2;
        if (this.f3328.f10982.isEnabled()) {
            float fM12739 = C3947.m12727().m12739();
            float fM12735 = C3947.m12727().m12735();
            List<Float> listM12740 = C3947.m12727().m12740();
            List<Float> listM12745 = C3947.m12727().m12745();
            boolean zM12764 = C3947.m12727().m12764();
            if (r1.m8144(listM12740)) {
                if (zM12764) {
                    fFloatValue = listM12740.get(0).floatValue();
                    fFloatValue2 = listM12740.get(listM12740.size() - 1).floatValue();
                } else {
                    float fFloatValue3 = listM12745.get(0).floatValue();
                    float fFloatValue4 = listM12745.get(listM12745.size() - 1).floatValue();
                    fFloatValue = fFloatValue3;
                    fFloatValue2 = fFloatValue4;
                }
                float f = fFloatValue - fFloatValue2;
                float fM3317 = zM12764 ? m3317(fM12739, fFloatValue2, f) : m3317(fM12735, fFloatValue2, f);
                if (fM3317 < 0.0f) {
                    fM3317 = 0.0f;
                } else if (fM3317 > 1.0f) {
                    fM3317 = 1.0f;
                }
                if (!zM12764) {
                    fM3317 = C3947.m12727().m12743(fM3317);
                }
                this.f3328.f10982.setPro(fM3317);
            }
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m3331(float f) {
        float fFloatValue;
        float fFloatValue2;
        if (this.f3328.f10982.isEnabled()) {
            float fM12739 = C3947.m12727().m12739();
            float fM12735 = C3947.m12727().m12735();
            List<Float> listM12740 = C3947.m12727().m12740();
            List<Float> listM12745 = C3947.m12727().m12745();
            boolean zM12764 = C3947.m12727().m12764();
            if (r1.m8144(listM12740)) {
                if (zM12764) {
                    fFloatValue = listM12740.get(0).floatValue();
                    fFloatValue2 = listM12740.get(listM12740.size() - 1).floatValue();
                } else {
                    float fFloatValue3 = listM12745.get(0).floatValue();
                    float fFloatValue4 = listM12745.get(listM12745.size() - 1).floatValue();
                    fFloatValue = fFloatValue3;
                    fFloatValue2 = fFloatValue4;
                }
                float f2 = fFloatValue - fFloatValue2;
                float fM3317 = zM12764 ? m3317(fM12739, fFloatValue2, f2) : m3317(fM12735, fFloatValue2, f2);
                if (fM3317 < 0.0f) {
                    fM3317 = 0.0f;
                } else if (fM3317 > 1.0f) {
                    fM3317 = 1.0f;
                }
                if (!zM12764) {
                    fM3317 = C3947.m12727().m12743(fM3317);
                }
                ValueAnimator valueAnimator = this.f3332;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f3332.cancel();
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, fM3317);
                this.f3332 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(100L);
                this.f3332.setInterpolator(new LinearInterpolator());
                this.f3332.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: Α
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f10159.m3313(valueAnimator2);
                    }
                });
                this.f3332.addListener(new C1189());
                this.f3332.start();
            }
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m3332() {
        if (C3947.m12727().m12765()) {
            this.f3328.f10977.setVisibility(8);
            this.f3328.f10982.setVisibility(8);
            this.f3328.f10975.setVisibility(0);
            this.f3328.f10984.setAlpha(0.0f);
            this.f3328.f10986.setAlpha(0.0f);
            if (this.f3328.f10975.isEnabled()) {
                this.f3328.f10983.setAlpha(1.0f);
                this.f3328.f10976.setAlpha(1.0f);
            } else {
                this.f3328.f10983.setAlpha(0.2f);
                this.f3328.f10976.setAlpha(0.2f);
            }
            this.f3328.f10985.setVisibility(8);
            return;
        }
        this.f3328.f10975.setVisibility(8);
        this.f3328.f10983.setAlpha(0.0f);
        this.f3328.f10985.setVisibility(0);
        this.f3328.f10976.setAlpha(0.2f);
        if (this.f3328.f10977.isEnabled()) {
            this.f3328.f10984.setAlpha(1.0f);
            this.f3328.f10976.setAlpha(1.0f);
        } else {
            this.f3328.f10984.setAlpha(0.2f);
        }
        if (this.f3328.f10982.isEnabled()) {
            this.f3328.f10986.setAlpha(1.0f);
            this.f3328.f10976.setAlpha(1.0f);
        } else {
            this.f3328.f10986.setAlpha(0.2f);
        }
        m3315();
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m3333(int i) {
        C4008.m12886(this, 0.0f, 0.0f, i, null);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m3334(boolean z) {
        this.f3328.f10979.setVisibility(z ? 0 : 8);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m3335() {
        if (this.f3335) {
            this.f3328.f10981.performClick();
        } else {
            this.f3328.f10980.performClick();
        }
    }

    public IsoEtWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IsoEtWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3329 = -1;
        this.f3330 = null;
        this.f3331 = null;
        this.f3332 = null;
        m3320();
    }
}
