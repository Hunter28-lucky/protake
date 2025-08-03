package com.blink.academy.film.widgets;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.R$styleable;
import com.blink.academy.protake.R;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.r1;

/* loaded from: classes.dex */
public class SwitchButton extends View implements Checkable {

    /* renamed from: ࡧ, reason: contains not printable characters */
    public static final String f2570 = SwitchButton.class.getSimpleName();

    /* renamed from: ࡨ, reason: contains not printable characters */
    public static final int f2571 = C2579.m9438(58.0f);

    /* renamed from: ࡩ, reason: contains not printable characters */
    public static final int f2572 = C2579.m9438(36.0f);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f2573;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f2574;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f2575;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f2576;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f2577;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int f2578;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f2579;

    /* renamed from: ֏, reason: contains not printable characters */
    public float[] f2580;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float[] f2581;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final float[] f2582;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f2583;

    /* renamed from: ށ, reason: contains not printable characters */
    public String f2584;

    /* renamed from: ނ, reason: contains not printable characters */
    public String f2585;

    /* renamed from: ރ, reason: contains not printable characters */
    public float f2586;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f2587;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f2588;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f2589;

    /* renamed from: އ, reason: contains not printable characters */
    public float f2590;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f2591;

    /* renamed from: މ, reason: contains not printable characters */
    public float f2592;

    /* renamed from: ފ, reason: contains not printable characters */
    public float f2593;

    /* renamed from: ދ, reason: contains not printable characters */
    public float f2594;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f2595;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f2596;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f2597;

    /* renamed from: ޏ, reason: contains not printable characters */
    public float f2598;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f2599;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f2600;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f2601;

    /* renamed from: ޓ, reason: contains not printable characters */
    public float f2602;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f2603;

    /* renamed from: ޕ, reason: contains not printable characters */
    public float f2604;

    /* renamed from: ޖ, reason: contains not printable characters */
    public float f2605;

    /* renamed from: ޗ, reason: contains not printable characters */
    public float f2606;

    /* renamed from: ޘ, reason: contains not printable characters */
    public float f2607;

    /* renamed from: ޙ, reason: contains not printable characters */
    public float f2608;

    /* renamed from: ޚ, reason: contains not printable characters */
    public float f2609;

    /* renamed from: ޛ, reason: contains not printable characters */
    public Paint f2610;

    /* renamed from: ޜ, reason: contains not printable characters */
    public Paint f2611;

    /* renamed from: ޝ, reason: contains not printable characters */
    public Paint f2612;

    /* renamed from: ޞ, reason: contains not printable characters */
    public C0971 f2613;

    /* renamed from: ޟ, reason: contains not printable characters */
    public C0971 f2614;

    /* renamed from: ޠ, reason: contains not printable characters */
    public C0971 f2615;

    /* renamed from: ޡ, reason: contains not printable characters */
    public RectF f2616;

    /* renamed from: ޢ, reason: contains not printable characters */
    public int f2617;

    /* renamed from: ޣ, reason: contains not printable characters */
    public ValueAnimator f2618;

    /* renamed from: ޤ, reason: contains not printable characters */
    public boolean f2619;

    /* renamed from: ޥ, reason: contains not printable characters */
    public boolean f2620;

    /* renamed from: ޱ, reason: contains not printable characters */
    public boolean f2621;

    /* renamed from: ߾, reason: contains not printable characters */
    public boolean f2622;

    /* renamed from: ߿, reason: contains not printable characters */
    public boolean f2623;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public boolean f2624;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public InterfaceC0969 f2625;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public long f2626;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public Runnable f2627;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public ValueAnimator.AnimatorUpdateListener f2628;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public Animator.AnimatorListener f2629;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public InterfaceC0970 f2630;

    /* renamed from: com.blink.academy.film.widgets.SwitchButton$Ϳ, reason: contains not printable characters */
    public class RunnableC0966 implements Runnable {
        public RunnableC0966() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwitchButton.this.m2625()) {
                return;
            }
            SwitchButton.this.m2628();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton$Ԩ, reason: contains not printable characters */
    public class C0967 implements ValueAnimator.AnimatorUpdateListener {
        public C0967() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = SwitchButton.this.f2617;
            if (i == 1 || i == 3 || i == 4) {
                if (SwitchButton.this.f2617 != 1) {
                    SwitchButton.this.f2613.f2634 = SwitchButton.this.f2614.f2634 + ((SwitchButton.this.f2615.f2634 - SwitchButton.this.f2614.f2634) * fFloatValue);
                    SwitchButton.this.f2613.f2636 = SwitchButton.this.f2614.f2636 + ((SwitchButton.this.f2615.f2636 - SwitchButton.this.f2614.f2636) * fFloatValue);
                    SwitchButton.this.f2613.f2637 = SwitchButton.this.f2614.f2637 + ((SwitchButton.this.f2615.f2637 - SwitchButton.this.f2614.f2637) * fFloatValue);
                }
                float f = (SwitchButton.this.f2613.f2634 - SwitchButton.this.f2604) / (SwitchButton.this.f2606 - SwitchButton.this.f2604);
                SwitchButton switchButton = SwitchButton.this;
                switchButton.f2582[0] = switchButton.f2581[0] + ((SwitchButton.this.f2580[0] - SwitchButton.this.f2581[0]) * f);
                SwitchButton switchButton2 = SwitchButton.this;
                switchButton2.f2582[1] = switchButton2.f2581[1] + ((SwitchButton.this.f2580[1] - SwitchButton.this.f2581[1]) * f);
                SwitchButton switchButton3 = SwitchButton.this;
                switchButton3.f2582[2] = switchButton3.f2581[2] + ((SwitchButton.this.f2580[2] - SwitchButton.this.f2581[2]) * f);
                SwitchButton.this.f2613.f2635 = Color.HSVToColor(SwitchButton.this.f2582);
            } else if (i == 5) {
                SwitchButton.this.f2613.f2634 = SwitchButton.this.f2614.f2634 + ((SwitchButton.this.f2615.f2634 - SwitchButton.this.f2614.f2634) * fFloatValue);
                float f2 = (SwitchButton.this.f2613.f2634 - SwitchButton.this.f2604) / (SwitchButton.this.f2606 - SwitchButton.this.f2604);
                SwitchButton.this.f2613.f2636 = SwitchButton.this.f2614.f2636 + ((SwitchButton.this.f2615.f2636 - SwitchButton.this.f2614.f2636) * fFloatValue);
                SwitchButton.this.f2613.f2637 = SwitchButton.this.f2614.f2637 + ((SwitchButton.this.f2615.f2637 - SwitchButton.this.f2614.f2637) * fFloatValue);
                SwitchButton switchButton4 = SwitchButton.this;
                switchButton4.f2582[0] = switchButton4.f2581[0] + ((SwitchButton.this.f2580[0] - SwitchButton.this.f2581[0]) * f2);
                SwitchButton switchButton5 = SwitchButton.this;
                switchButton5.f2582[1] = switchButton5.f2581[1] + ((SwitchButton.this.f2580[1] - SwitchButton.this.f2581[1]) * f2);
                SwitchButton switchButton6 = SwitchButton.this;
                switchButton6.f2582[2] = switchButton6.f2581[2] + ((SwitchButton.this.f2580[2] - SwitchButton.this.f2581[2]) * f2);
                SwitchButton.this.f2613.f2635 = Color.HSVToColor(SwitchButton.this.f2582);
            }
            SwitchButton.this.postInvalidate();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton$Ԫ, reason: contains not printable characters */
    public class C0968 implements Animator.AnimatorListener {
        public C0968() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i = SwitchButton.this.f2617;
            if (i == 1) {
                SwitchButton.this.f2617 = 2;
                SwitchButton.this.postInvalidate();
                return;
            }
            if (i == 3) {
                SwitchButton.this.f2617 = 0;
                SwitchButton.this.postInvalidate();
                return;
            }
            if (i == 4) {
                SwitchButton.this.f2617 = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m2619();
            } else {
                if (i != 5) {
                    return;
                }
                SwitchButton switchButton = SwitchButton.this;
                switchButton.f2619 = true ^ switchButton.f2619;
                SwitchButton.this.f2617 = 0;
                if (SwitchButton.this.f2619) {
                    SwitchButton.this.f2613.f2635 = SwitchButton.this.f2601;
                } else {
                    SwitchButton.this.f2613.f2635 = SwitchButton.this.f2600;
                }
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m2619();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton$Ԭ, reason: contains not printable characters */
    public interface InterfaceC0969 {
        /* renamed from: Ϳ */
        boolean mo2143();

        /* renamed from: Ԩ */
        void mo2144(SwitchButton switchButton, boolean z);
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton$Ԯ, reason: contains not printable characters */
    public interface InterfaceC0970 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo2633();
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton$ՠ, reason: contains not printable characters */
    public static class C0971 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public float f2634;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f2635;

        /* renamed from: ԩ, reason: contains not printable characters */
        public float f2636;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float f2637;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m2635(C0971 c0971) {
            this.f2634 = c0971.f2634;
            this.f2635 = c0971.f2635;
            this.f2636 = c0971.f2636;
            this.f2637 = c0971.f2637;
        }
    }

    public SwitchButton(Context context) {
        super(context);
        this.f2573 = 0;
        this.f2574 = 1;
        this.f2575 = 2;
        this.f2576 = 3;
        this.f2577 = 4;
        this.f2578 = 5;
        this.f2580 = new float[3];
        this.f2581 = new float[3];
        this.f2582 = new float[3];
        this.f2616 = new RectF();
        this.f2617 = 0;
        this.f2622 = false;
        this.f2623 = false;
        this.f2624 = false;
        this.f2627 = new RunnableC0966();
        this.f2628 = new C0967();
        this.f2629 = new C0968();
        m2623(context, null);
    }

    private void setCheckedViewState(C0971 c0971) {
        c0971.f2635 = this.f2601;
        c0971.f2634 = this.f2606;
        c0971.f2637 = this.f2608 + 500.0f;
        c0971.f2636 = this.f2607;
    }

    private void setUncheckViewState(C0971 c0971) {
        c0971.f2635 = this.f2600;
        c0971.f2634 = this.f2604;
        c0971.f2636 = this.f2607 - 500.0f;
        c0971.f2637 = this.f2608;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static boolean m2614(TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static int m2615(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static int m2616(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static float m2617(TypedArray typedArray, int i, float f) {
        return typedArray == null ? f : typedArray.getDimension(i, f);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static String m2618(TypedArray typedArray, int i, String str) {
        if (typedArray == null) {
            return str;
        }
        String string = typedArray.getString(i);
        return r1.m8143(string) ? string : str;
    }

    public float getViewRealPadding() {
        return Math.max(this.f2586 + this.f2587, this.f2602);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2619;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2612.setStyle(Paint.Style.FILL);
        this.f2612.setColor(this.f2613.f2635);
        m2621(canvas, this.f2593, this.f2594, this.f2595, this.f2596, this.f2589, this.f2612);
        canvas.save();
        float f = this.f2593;
        float f2 = this.f2602;
        canvas.clipRect(f + (f2 * 2.0f), this.f2594, this.f2595 - (f2 * 2.0f), this.f2596);
        m2622(canvas, this.f2584, this.f2613.f2636);
        m2622(canvas, this.f2585, this.f2613.f2637);
        canvas.restore();
        m2620(canvas, this.f2613.f2634, this.f2598);
        this.f2612.setStrokeWidth(this.f2602);
        this.f2612.setStyle(Paint.Style.STROKE);
        this.f2612.setColor(this.f2603);
        m2621(canvas, this.f2593, this.f2594, this.f2595, this.f2596, this.f2589, this.f2612);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(f2571, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f2572, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float fMax = Math.max(this.f2586 + this.f2587, this.f2602);
        float f = i2 - fMax;
        float f2 = f - fMax;
        this.f2591 = f2;
        float f3 = i - fMax;
        this.f2592 = f3 - fMax;
        float f4 = f2 * 0.5f;
        this.f2589 = f4;
        this.f2590 = f4 - (C4792.m14375().m14476(6) * 2);
        this.f2593 = fMax;
        this.f2594 = fMax;
        this.f2595 = f3;
        this.f2596 = f;
        this.f2597 = (fMax + f3) * 0.5f;
        this.f2598 = (f + fMax) * 0.5f;
        float f5 = this.f2589;
        float f6 = fMax + f5;
        this.f2604 = f6;
        this.f2606 = f3 - f5;
        this.f2607 = f6;
        Paint.FontMetricsInt fontMetricsInt = this.f2611.getFontMetricsInt();
        this.f2608 = (this.f2606 - this.f2611.measureText(this.f2579 ? getContext().getString(R.string.TOGGLE_OFF).toUpperCase() : getContext().getString(R.string.TOGGLE_OFF))) + 5.0f;
        this.f2605 = this.f2611.measureText(this.f2579 ? getContext().getString(R.string.TOGGLE_ON).toUpperCase() : getContext().getString(R.string.TOGGLE_ON)) + 5.0f;
        this.f2609 = (fMax / 2.0f) + (fontMetricsInt.bottom - fontMetricsInt.top);
        if (isChecked()) {
            setCheckedViewState(this.f2613);
        } else {
            setUncheckViewState(this.f2613);
        }
        this.f2623 = true;
        postInvalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            InterfaceC0970 interfaceC0970 = this.f2630;
            if (interfaceC0970 != null) {
                interfaceC0970.mo2633();
            }
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2622 = true;
            this.f2626 = System.currentTimeMillis();
            removeCallbacks(this.f2627);
            postDelayed(this.f2627, 100L);
        } else if (actionMasked == 1) {
            this.f2622 = false;
            removeCallbacks(this.f2627);
            if (System.currentTimeMillis() - this.f2626 <= 300) {
                toggle();
            } else if (m2624()) {
                boolean z = Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f;
                if (z == isChecked()) {
                    m2627();
                } else {
                    this.f2619 = z;
                    m2629();
                }
            } else if (m2626()) {
                m2627();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (m2626()) {
                float fMax = Math.max(0.0f, Math.min(1.0f, x / getWidth()));
                C0971 c0971 = this.f2613;
                float f = this.f2604;
                float f2 = this.f2606;
                c0971.f2634 = ((f2 - f) * fMax) + f;
                float f3 = this.f2605;
                c0971.f2636 = ((this.f2607 + f3) * fMax) - f3;
                c0971.f2637 = this.f2608 + ((f2 - f) * fMax);
            } else if (m2624()) {
                float fMax2 = Math.max(0.0f, Math.min(1.0f, x / getWidth()));
                C0971 c09712 = this.f2613;
                float f4 = this.f2604;
                c09712.f2634 = f4 + ((this.f2606 - f4) * fMax2);
                float[] fArr = this.f2582;
                float[] fArr2 = this.f2581;
                float f5 = fArr2[0];
                float[] fArr3 = this.f2580;
                fArr[0] = f5 + ((fArr3[0] - f5) * fMax2);
                float f6 = fArr2[1];
                fArr[1] = f6 + ((fArr3[1] - f6) * fMax2);
                float f7 = fArr2[2];
                fArr[2] = f7 + ((fArr3[2] - f7) * fMax2);
                c09712.f2635 = Color.HSVToColor(fArr);
                C0971 c09713 = this.f2613;
                float f8 = this.f2605;
                c09713.f2636 = ((this.f2607 + f8) * fMax2) - f8;
                c09713.f2637 = this.f2608 + ((this.f2606 - this.f2604) * fMax2);
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.f2622 = false;
            removeCallbacks(this.f2627);
            if (m2626() || m2624()) {
                m2627();
            }
        }
        return true;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z == isChecked()) {
            postInvalidate();
        } else {
            m2632(this.f2620, false);
        }
    }

    public void setEnableEffect(boolean z) {
        this.f2620 = z;
    }

    public void setOnCheckedChangeListener(InterfaceC0969 interfaceC0969) {
        this.f2625 = interfaceC0969;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public void setOnInterceptToggle(InterfaceC0970 interfaceC0970) {
        this.f2630 = interfaceC0970;
    }

    @Override // android.view.View
    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setTextSize(float f) {
        this.f2583 = f;
        this.f2611.setTextSize(f);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        m2631(true);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m2619() {
        InterfaceC0969 interfaceC0969 = this.f2625;
        if (interfaceC0969 != null) {
            this.f2624 = true;
            interfaceC0969.mo2144(this, isChecked());
        }
        this.f2624 = false;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m2620(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.f2590, this.f2610);
        this.f2612.setStyle(Paint.Style.STROKE);
        this.f2612.setStrokeWidth(1.0f);
        this.f2612.setColor(-2236963);
        canvas.drawCircle(f, f2, this.f2590, this.f2612);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m2621(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m2622(Canvas canvas, String str, float f) {
        canvas.drawText(str, f, this.f2609, this.f2611);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m2623(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R$styleable.SwitchButton) : null;
        this.f2621 = m2614(typedArrayObtainStyledAttributes, 11, true);
        this.f2579 = m2614(typedArrayObtainStyledAttributes, 17, true);
        this.f2584 = m2618(typedArrayObtainStyledAttributes, 14, getResources().getString(R.string.TOGGLE_ON));
        this.f2585 = m2618(typedArrayObtainStyledAttributes, 16, getResources().getString(R.string.TOGGLE_OFF));
        if (this.f2579) {
            this.f2584 = this.f2584.toUpperCase();
            this.f2585 = this.f2585.toUpperCase();
        }
        this.f2586 = m2617(typedArrayObtainStyledAttributes, 13, C4792.m14375().m14428(7.5f));
        this.f2587 = m2617(typedArrayObtainStyledAttributes, 12, C4792.m14375().m14428(4.5f));
        this.f2588 = m2615(typedArrayObtainStyledAttributes, 10, 855638016);
        this.f2600 = m2615(typedArrayObtainStyledAttributes, 18, -14540254);
        this.f2601 = m2615(typedArrayObtainStyledAttributes, 5, -17920);
        this.f2603 = m2615(typedArrayObtainStyledAttributes, 1, ViewCompat.MEASURED_STATE_MASK);
        this.f2602 = C4792.m14375().m14443();
        int iM2615 = m2615(typedArrayObtainStyledAttributes, 3, -1);
        int iM2616 = m2616(typedArrayObtainStyledAttributes, 8, 300);
        this.f2619 = m2614(typedArrayObtainStyledAttributes, 4, false);
        this.f2599 = m2615(typedArrayObtainStyledAttributes, 0, -14540254);
        Color.colorToHSV(Color.parseColor("#ffffba00"), this.f2580);
        Color.colorToHSV(Color.parseColor("#ff222222"), this.f2581);
        this.f2620 = m2614(typedArrayObtainStyledAttributes, 9, true);
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2612 = new Paint(1);
        this.f2610 = new Paint(1);
        Paint paint = new Paint(1);
        this.f2611 = paint;
        paint.setTextSize(this.f2583);
        this.f2611.setColor(-1);
        this.f2611.setTypeface(FilmApp.m404());
        this.f2610.setColor(iM2615);
        if (this.f2621) {
            this.f2610.setShadowLayer(this.f2586, 0.0f, this.f2587, this.f2588);
        }
        this.f2613 = new C0971();
        this.f2614 = new C0971();
        this.f2615 = new C0971();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2618 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(iM2616);
        this.f2618.setRepeatCount(0);
        this.f2618.addUpdateListener(this.f2628);
        this.f2618.addListener(this.f2629);
        this.f2618.setInterpolator(new LinearInterpolator());
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        setLayerType(1, null);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final boolean m2624() {
        return this.f2617 == 2;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final boolean m2625() {
        return this.f2617 != 0;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final boolean m2626() {
        int i = this.f2617;
        return i == 1 || i == 3;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m2627() {
        if (m2624() || m2626()) {
            if (this.f2618.isRunning()) {
                this.f2618.cancel();
            }
            this.f2617 = 3;
            this.f2614.m2635(this.f2613);
            if (isChecked()) {
                setCheckedViewState(this.f2615);
            } else {
                setUncheckViewState(this.f2615);
            }
            this.f2618.start();
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final void m2628() {
        if (!m2625() && this.f2622) {
            if (this.f2618.isRunning()) {
                this.f2618.cancel();
            }
            this.f2617 = 1;
            this.f2614.m2635(this.f2613);
            this.f2615.m2635(this.f2613);
            if (isChecked()) {
                C0971 c0971 = this.f2615;
                c0971.f2635 = this.f2601;
                c0971.f2634 = this.f2606;
                c0971.f2637 = this.f2608 + 500.0f;
                c0971.f2636 = this.f2607;
            } else {
                C0971 c09712 = this.f2615;
                c09712.f2635 = this.f2600;
                c09712.f2634 = this.f2604;
                c09712.f2637 = this.f2608;
                c09712.f2636 = this.f2607 - 500.0f;
            }
            this.f2618.start();
        }
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m2629() {
        if (this.f2618.isRunning()) {
            this.f2618.cancel();
        }
        this.f2617 = 4;
        this.f2614.m2635(this.f2613);
        if (isChecked()) {
            setCheckedViewState(this.f2615);
        } else {
            setUncheckViewState(this.f2615);
        }
        this.f2618.start();
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m2630(boolean z, boolean z2) {
        if (z2 == isChecked()) {
            postInvalidate();
        } else {
            m2632(z, false);
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m2631(boolean z) {
        m2632(z, true);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m2632(boolean z, boolean z2) {
        if (isEnabled()) {
            if (this.f2624) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            }
            InterfaceC0969 interfaceC0969 = this.f2625;
            if (interfaceC0969 == null || interfaceC0969.mo2143()) {
                if (!this.f2623) {
                    this.f2619 = !this.f2619;
                    if (z2) {
                        m2619();
                        return;
                    }
                    return;
                }
                if (this.f2618.isRunning()) {
                    this.f2618.cancel();
                }
                if (this.f2620 && z) {
                    this.f2617 = 5;
                    this.f2614.m2635(this.f2613);
                    if (isChecked()) {
                        setUncheckViewState(this.f2615);
                    } else {
                        setCheckedViewState(this.f2615);
                    }
                    this.f2618.start();
                    return;
                }
                this.f2619 = !this.f2619;
                if (isChecked()) {
                    setCheckedViewState(this.f2613);
                } else {
                    setUncheckViewState(this.f2613);
                }
                postInvalidate();
                if (z2) {
                    m2619();
                }
            }
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2573 = 0;
        this.f2574 = 1;
        this.f2575 = 2;
        this.f2576 = 3;
        this.f2577 = 4;
        this.f2578 = 5;
        this.f2580 = new float[3];
        this.f2581 = new float[3];
        this.f2582 = new float[3];
        this.f2616 = new RectF();
        this.f2617 = 0;
        this.f2622 = false;
        this.f2623 = false;
        this.f2624 = false;
        this.f2627 = new RunnableC0966();
        this.f2628 = new C0967();
        this.f2629 = new C0968();
        m2623(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2573 = 0;
        this.f2574 = 1;
        this.f2575 = 2;
        this.f2576 = 3;
        this.f2577 = 4;
        this.f2578 = 5;
        this.f2580 = new float[3];
        this.f2581 = new float[3];
        this.f2582 = new float[3];
        this.f2616 = new RectF();
        this.f2617 = 0;
        this.f2622 = false;
        this.f2623 = false;
        this.f2624 = false;
        this.f2627 = new RunnableC0966();
        this.f2628 = new C0967();
        this.f2629 = new C0968();
        m2623(context, attributeSet);
    }
}
