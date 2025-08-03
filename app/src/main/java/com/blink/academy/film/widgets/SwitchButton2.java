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
public class SwitchButton2 extends View implements Checkable {

    /* renamed from: ࡨ, reason: contains not printable characters */
    public static final String f2638 = SwitchButton2.class.getSimpleName();

    /* renamed from: ࡩ, reason: contains not printable characters */
    public static final int f2639 = C2579.m9438(58.0f);

    /* renamed from: ࡪ, reason: contains not printable characters */
    public static final int f2640 = C2579.m9438(36.0f);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f2641;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f2642;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f2643;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f2644;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f2645;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int f2646;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f2647;

    /* renamed from: ֏, reason: contains not printable characters */
    public float[] f2648;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float[] f2649;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f2650;

    /* renamed from: ހ, reason: contains not printable characters */
    public final float[] f2651;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f2652;

    /* renamed from: ނ, reason: contains not printable characters */
    public String f2653;

    /* renamed from: ރ, reason: contains not printable characters */
    public String f2654;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f2655;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f2656;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f2657;

    /* renamed from: އ, reason: contains not printable characters */
    public float f2658;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f2659;

    /* renamed from: މ, reason: contains not printable characters */
    public float f2660;

    /* renamed from: ފ, reason: contains not printable characters */
    public float f2661;

    /* renamed from: ދ, reason: contains not printable characters */
    public float f2662;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f2663;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f2664;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f2665;

    /* renamed from: ޏ, reason: contains not printable characters */
    public float f2666;

    /* renamed from: ސ, reason: contains not printable characters */
    public float f2667;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f2668;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f2669;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f2670;

    /* renamed from: ޔ, reason: contains not printable characters */
    public float f2671;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f2672;

    /* renamed from: ޖ, reason: contains not printable characters */
    public float f2673;

    /* renamed from: ޗ, reason: contains not printable characters */
    public float f2674;

    /* renamed from: ޘ, reason: contains not printable characters */
    public float f2675;

    /* renamed from: ޙ, reason: contains not printable characters */
    public float f2676;

    /* renamed from: ޚ, reason: contains not printable characters */
    public float f2677;

    /* renamed from: ޛ, reason: contains not printable characters */
    public float f2678;

    /* renamed from: ޜ, reason: contains not printable characters */
    public Paint f2679;

    /* renamed from: ޝ, reason: contains not printable characters */
    public Paint f2680;

    /* renamed from: ޞ, reason: contains not printable characters */
    public Paint f2681;

    /* renamed from: ޟ, reason: contains not printable characters */
    public C0977 f2682;

    /* renamed from: ޠ, reason: contains not printable characters */
    public C0977 f2683;

    /* renamed from: ޡ, reason: contains not printable characters */
    public C0977 f2684;

    /* renamed from: ޢ, reason: contains not printable characters */
    public RectF f2685;

    /* renamed from: ޣ, reason: contains not printable characters */
    public int f2686;

    /* renamed from: ޤ, reason: contains not printable characters */
    public ValueAnimator f2687;

    /* renamed from: ޥ, reason: contains not printable characters */
    public boolean f2688;

    /* renamed from: ޱ, reason: contains not printable characters */
    public boolean f2689;

    /* renamed from: ߾, reason: contains not printable characters */
    public boolean f2690;

    /* renamed from: ߿, reason: contains not printable characters */
    public boolean f2691;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public boolean f2692;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public boolean f2693;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public InterfaceC0975 f2694;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public long f2695;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public Runnable f2696;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public ValueAnimator.AnimatorUpdateListener f2697;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public Animator.AnimatorListener f2698;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public InterfaceC0976 f2699;

    /* renamed from: com.blink.academy.film.widgets.SwitchButton2$Ϳ, reason: contains not printable characters */
    public class RunnableC0972 implements Runnable {
        public RunnableC0972() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwitchButton2.this.m2665()) {
                return;
            }
            SwitchButton2.this.m2668();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton2$Ԩ, reason: contains not printable characters */
    public class C0973 implements ValueAnimator.AnimatorUpdateListener {
        public C0973() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = SwitchButton2.this.f2686;
            if (i == 1 || i == 3 || i == 4) {
                if (SwitchButton2.this.f2686 != 1) {
                    SwitchButton2.this.f2682.f2703 = SwitchButton2.this.f2683.f2703 + ((SwitchButton2.this.f2684.f2703 - SwitchButton2.this.f2683.f2703) * fFloatValue);
                    SwitchButton2.this.f2682.f2705 = SwitchButton2.this.f2683.f2705 + ((SwitchButton2.this.f2684.f2705 - SwitchButton2.this.f2683.f2705) * fFloatValue);
                    SwitchButton2.this.f2682.f2706 = SwitchButton2.this.f2683.f2706 + ((SwitchButton2.this.f2684.f2706 - SwitchButton2.this.f2683.f2706) * fFloatValue);
                }
                float f = (SwitchButton2.this.f2682.f2703 - SwitchButton2.this.f2673) / (SwitchButton2.this.f2675 - SwitchButton2.this.f2673);
                SwitchButton2 switchButton2 = SwitchButton2.this;
                switchButton2.f2651[0] = switchButton2.f2649[0] + ((SwitchButton2.this.f2648[0] - SwitchButton2.this.f2649[0]) * f);
                SwitchButton2 switchButton22 = SwitchButton2.this;
                switchButton22.f2651[1] = switchButton22.f2649[1] + ((SwitchButton2.this.f2648[1] - SwitchButton2.this.f2649[1]) * f);
                SwitchButton2 switchButton23 = SwitchButton2.this;
                switchButton23.f2651[2] = switchButton23.f2649[2] + ((SwitchButton2.this.f2648[2] - SwitchButton2.this.f2649[2]) * f);
                SwitchButton2.this.f2682.f2704 = Color.HSVToColor(SwitchButton2.this.f2651);
            } else if (i == 5) {
                SwitchButton2.this.f2682.f2703 = SwitchButton2.this.f2683.f2703 + ((SwitchButton2.this.f2684.f2703 - SwitchButton2.this.f2683.f2703) * fFloatValue);
                float f2 = (SwitchButton2.this.f2682.f2703 - SwitchButton2.this.f2673) / (SwitchButton2.this.f2675 - SwitchButton2.this.f2673);
                SwitchButton2.this.f2682.f2705 = SwitchButton2.this.f2683.f2705 + ((SwitchButton2.this.f2684.f2705 - SwitchButton2.this.f2683.f2705) * fFloatValue);
                SwitchButton2.this.f2682.f2706 = SwitchButton2.this.f2683.f2706 + ((SwitchButton2.this.f2684.f2706 - SwitchButton2.this.f2683.f2706) * fFloatValue);
                SwitchButton2 switchButton24 = SwitchButton2.this;
                switchButton24.f2651[0] = switchButton24.f2649[0] + ((SwitchButton2.this.f2648[0] - SwitchButton2.this.f2649[0]) * f2);
                SwitchButton2 switchButton25 = SwitchButton2.this;
                switchButton25.f2651[1] = switchButton25.f2649[1] + ((SwitchButton2.this.f2648[1] - SwitchButton2.this.f2649[1]) * f2);
                SwitchButton2 switchButton26 = SwitchButton2.this;
                switchButton26.f2651[2] = switchButton26.f2649[2] + ((SwitchButton2.this.f2648[2] - SwitchButton2.this.f2649[2]) * f2);
                SwitchButton2.this.f2682.f2704 = Color.HSVToColor(SwitchButton2.this.f2651);
            }
            SwitchButton2.this.postInvalidate();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton2$Ԫ, reason: contains not printable characters */
    public class C0974 implements Animator.AnimatorListener {
        public C0974() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i = SwitchButton2.this.f2686;
            if (i == 1) {
                SwitchButton2.this.f2686 = 2;
                SwitchButton2.this.postInvalidate();
                return;
            }
            if (i == 3) {
                SwitchButton2.this.f2686 = 0;
                SwitchButton2.this.postInvalidate();
                return;
            }
            if (i == 4) {
                SwitchButton2.this.f2686 = 0;
                SwitchButton2.this.postInvalidate();
                SwitchButton2 switchButton2 = SwitchButton2.this;
                switchButton2.m2658(switchButton2.f2650);
                return;
            }
            if (i != 5) {
                return;
            }
            SwitchButton2 switchButton22 = SwitchButton2.this;
            switchButton22.f2688 = true ^ switchButton22.f2688;
            SwitchButton2.this.f2686 = 0;
            if (SwitchButton2.this.f2688) {
                SwitchButton2.this.f2682.f2704 = SwitchButton2.this.f2670;
            } else {
                SwitchButton2.this.f2682.f2704 = SwitchButton2.this.f2669;
            }
            SwitchButton2.this.postInvalidate();
            SwitchButton2 switchButton23 = SwitchButton2.this;
            switchButton23.m2658(switchButton23.f2650);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton2$Ԭ, reason: contains not printable characters */
    public interface InterfaceC0975 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo2673();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo2674(SwitchButton2 switchButton2, boolean z, boolean z2);
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton2$Ԯ, reason: contains not printable characters */
    public interface InterfaceC0976 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo2675();
    }

    /* renamed from: com.blink.academy.film.widgets.SwitchButton2$ՠ, reason: contains not printable characters */
    public static class C0977 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public float f2703;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f2704;

        /* renamed from: ԩ, reason: contains not printable characters */
        public float f2705;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float f2706;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m2677(C0977 c0977) {
            this.f2703 = c0977.f2703;
            this.f2704 = c0977.f2704;
            this.f2705 = c0977.f2705;
            this.f2706 = c0977.f2706;
        }
    }

    public SwitchButton2(Context context) {
        super(context);
        this.f2641 = 0;
        this.f2642 = 1;
        this.f2643 = 2;
        this.f2644 = 3;
        this.f2645 = 4;
        this.f2646 = 5;
        this.f2648 = new float[3];
        this.f2649 = new float[3];
        this.f2651 = new float[3];
        this.f2685 = new RectF();
        this.f2686 = 0;
        this.f2691 = false;
        this.f2692 = false;
        this.f2693 = false;
        this.f2696 = new RunnableC0972();
        this.f2697 = new C0973();
        this.f2698 = new C0974();
        m2663(context, null);
    }

    private void setCheckedViewState(C0977 c0977) {
        c0977.f2704 = this.f2670;
        c0977.f2703 = this.f2675;
        c0977.f2706 = this.f2677 + 500.0f;
        c0977.f2705 = this.f2676;
    }

    private void setUncheckViewState(C0977 c0977) {
        c0977.f2704 = this.f2669;
        c0977.f2703 = this.f2673;
        c0977.f2705 = this.f2676 - 500.0f;
        c0977.f2706 = this.f2677;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static boolean m2653(TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static int m2654(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static int m2655(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static int m2656(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static String m2657(TypedArray typedArray, int i, String str) {
        if (typedArray == null) {
            return str;
        }
        String string = typedArray.getString(i);
        return r1.m8143(string) ? string : str;
    }

    public float getViewRealPadding() {
        return Math.max(this.f2655 + this.f2656, this.f2671);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2688;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2681.setStyle(Paint.Style.FILL);
        this.f2681.setColor(this.f2682.f2704);
        m2661(canvas, this.f2662, this.f2663, this.f2664, this.f2665, this.f2658, this.f2681);
        canvas.save();
        float f = this.f2662;
        float f2 = this.f2671;
        canvas.clipRect(f + (f2 * 2.0f), this.f2663, this.f2664 - (f2 * 2.0f), this.f2665);
        m2662(canvas, this.f2653, this.f2682.f2705);
        m2662(canvas, this.f2654, this.f2682.f2706);
        canvas.restore();
        m2660(canvas, this.f2682.f2703, this.f2667);
        this.f2681.setStrokeWidth(this.f2671);
        this.f2681.setStyle(Paint.Style.STROKE);
        this.f2681.setColor(this.f2672);
        m2661(canvas, this.f2662, this.f2663, this.f2664, this.f2665, this.f2658, this.f2681);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(f2639, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f2640, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float fMax = Math.max(this.f2655 + this.f2656, this.f2671);
        float f = i2 - fMax;
        float f2 = f - fMax;
        this.f2660 = f2;
        float f3 = i - fMax;
        this.f2661 = f3 - fMax;
        float f4 = f2 * 0.5f;
        this.f2658 = f4;
        this.f2659 = f4 - (C2579.m9438(2.0f) * 2);
        this.f2662 = fMax;
        this.f2663 = fMax;
        this.f2664 = f3;
        this.f2665 = f;
        this.f2666 = (fMax + f3) * 0.5f;
        this.f2667 = (f + fMax) * 0.5f;
        float f5 = this.f2658;
        float f6 = fMax + f5;
        this.f2673 = f6;
        this.f2675 = f3 - f5;
        this.f2676 = f6;
        Paint.FontMetricsInt fontMetricsInt = this.f2680.getFontMetricsInt();
        this.f2677 = (this.f2675 - this.f2680.measureText(this.f2647 ? getContext().getString(R.string.TOGGLE_OFF).toUpperCase() : getContext().getString(R.string.TOGGLE_OFF))) + 5.0f;
        this.f2674 = this.f2680.measureText(this.f2647 ? getContext().getString(R.string.TOGGLE_ON).toUpperCase() : getContext().getString(R.string.TOGGLE_ON)) + 5.0f;
        this.f2678 = (fMax / 2.0f) + (fontMetricsInt.bottom - fontMetricsInt.top);
        if (isChecked()) {
            setCheckedViewState(this.f2682);
        } else {
            setUncheckViewState(this.f2682);
        }
        this.f2692 = true;
        postInvalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            InterfaceC0976 interfaceC0976 = this.f2699;
            if (interfaceC0976 != null) {
                interfaceC0976.mo2675();
            }
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2691 = true;
            this.f2695 = System.currentTimeMillis();
            removeCallbacks(this.f2696);
            postDelayed(this.f2696, 100L);
        } else if (actionMasked == 1) {
            this.f2691 = false;
            removeCallbacks(this.f2696);
            if (System.currentTimeMillis() - this.f2695 <= 300) {
                toggle();
            } else if (m2664()) {
                boolean z = Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f;
                if (z == isChecked()) {
                    m2667();
                } else {
                    this.f2688 = z;
                    m2669();
                }
            } else if (m2666()) {
                m2667();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (m2666()) {
                float fMax = Math.max(0.0f, Math.min(1.0f, x / getWidth()));
                C0977 c0977 = this.f2682;
                float f = this.f2673;
                float f2 = this.f2675;
                c0977.f2703 = ((f2 - f) * fMax) + f;
                float f3 = this.f2674;
                c0977.f2705 = ((this.f2676 + f3) * fMax) - f3;
                c0977.f2706 = this.f2677 + ((f2 - f) * fMax);
            } else if (m2664()) {
                float fMax2 = Math.max(0.0f, Math.min(1.0f, x / getWidth()));
                C0977 c09772 = this.f2682;
                float f4 = this.f2673;
                c09772.f2703 = f4 + ((this.f2675 - f4) * fMax2);
                float[] fArr = this.f2651;
                float[] fArr2 = this.f2649;
                float f5 = fArr2[0];
                float[] fArr3 = this.f2648;
                fArr[0] = f5 + ((fArr3[0] - f5) * fMax2);
                float f6 = fArr2[1];
                fArr[1] = f6 + ((fArr3[1] - f6) * fMax2);
                float f7 = fArr2[2];
                fArr[2] = f7 + ((fArr3[2] - f7) * fMax2);
                c09772.f2704 = Color.HSVToColor(fArr);
                C0977 c09773 = this.f2682;
                float f8 = this.f2674;
                c09773.f2705 = ((this.f2676 + f8) * fMax2) - f8;
                c09773.f2706 = this.f2677 + ((this.f2675 - this.f2673) * fMax2);
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.f2691 = false;
            removeCallbacks(this.f2696);
            if (m2666() || m2664()) {
                m2667();
            }
        }
        return true;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z == isChecked()) {
            postInvalidate();
        } else {
            m2672(this.f2689, false, false);
        }
    }

    public void setEnableEffect(boolean z) {
        this.f2689 = z;
    }

    public void setOnCheckedChangeListener(InterfaceC0975 interfaceC0975) {
        this.f2694 = interfaceC0975;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public void setOnInterceptToggle(InterfaceC0976 interfaceC0976) {
        this.f2699 = interfaceC0976;
    }

    @Override // android.view.View
    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setTextSize(float f) {
        this.f2652 = f;
        this.f2680.setTextSize(f);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        m2671(true, true);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m2658(boolean z) {
        InterfaceC0975 interfaceC0975 = this.f2694;
        if (interfaceC0975 != null) {
            this.f2693 = true;
            interfaceC0975.mo2674(this, isChecked(), z);
        }
        this.f2693 = false;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m2659(int i) {
        Color.colorToHSV(i, this.f2648);
        this.f2670 = i;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m2660(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.f2659, this.f2679);
        this.f2681.setStyle(Paint.Style.STROKE);
        this.f2681.setStrokeWidth(1.0f);
        this.f2681.setColor(-2236963);
        canvas.drawCircle(f, f2, this.f2659, this.f2681);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m2661(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m2662(Canvas canvas, String str, float f) {
        canvas.drawText(str, f, this.f2678, this.f2680);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m2663(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R$styleable.SwitchButton) : null;
        this.f2690 = m2653(typedArrayObtainStyledAttributes, 11, true);
        this.f2647 = m2653(typedArrayObtainStyledAttributes, 17, true);
        this.f2653 = m2657(typedArrayObtainStyledAttributes, 14, getResources().getString(R.string.TOGGLE_ON));
        this.f2654 = m2657(typedArrayObtainStyledAttributes, 16, getResources().getString(R.string.TOGGLE_OFF));
        if (this.f2647) {
            this.f2653 = this.f2653.toUpperCase();
            this.f2654 = this.f2654.toUpperCase();
        }
        this.f2655 = m2656(typedArrayObtainStyledAttributes, 13, C2579.m9438(2.5f));
        this.f2656 = m2656(typedArrayObtainStyledAttributes, 12, C2579.m9438(1.5f));
        this.f2657 = m2654(typedArrayObtainStyledAttributes, 10, 855638016);
        this.f2669 = m2654(typedArrayObtainStyledAttributes, 18, -14540254);
        this.f2670 = m2654(typedArrayObtainStyledAttributes, 5, -17920);
        this.f2672 = m2654(typedArrayObtainStyledAttributes, 1, ViewCompat.MEASURED_STATE_MASK);
        this.f2671 = C4792.m14375().m14443();
        int iM2654 = m2654(typedArrayObtainStyledAttributes, 3, -1);
        int iM2655 = m2655(typedArrayObtainStyledAttributes, 8, 300);
        this.f2688 = m2653(typedArrayObtainStyledAttributes, 4, false);
        this.f2668 = m2654(typedArrayObtainStyledAttributes, 0, -14540254);
        Color.colorToHSV(Color.parseColor("#ffffba00"), this.f2648);
        Color.colorToHSV(Color.parseColor("#ff222222"), this.f2649);
        this.f2689 = m2653(typedArrayObtainStyledAttributes, 9, true);
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2681 = new Paint(1);
        this.f2679 = new Paint(1);
        Paint paint = new Paint(1);
        this.f2680 = paint;
        paint.setTextSize(this.f2652);
        this.f2680.setColor(-1);
        this.f2680.setTypeface(FilmApp.m404());
        this.f2679.setColor(iM2654);
        if (this.f2690) {
            this.f2679.setShadowLayer(this.f2655, 0.0f, this.f2656, this.f2657);
        }
        this.f2682 = new C0977();
        this.f2683 = new C0977();
        this.f2684 = new C0977();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2687 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(iM2655);
        this.f2687.setRepeatCount(0);
        this.f2687.addUpdateListener(this.f2697);
        this.f2687.addListener(this.f2698);
        this.f2687.setInterpolator(new LinearInterpolator());
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        setLayerType(1, null);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final boolean m2664() {
        return this.f2686 == 2;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final boolean m2665() {
        return this.f2686 != 0;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final boolean m2666() {
        int i = this.f2686;
        return i == 1 || i == 3;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m2667() {
        if (m2664() || m2666()) {
            if (this.f2687.isRunning()) {
                this.f2687.cancel();
            }
            this.f2686 = 3;
            this.f2683.m2677(this.f2682);
            if (isChecked()) {
                setCheckedViewState(this.f2684);
            } else {
                setUncheckViewState(this.f2684);
            }
            this.f2687.start();
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m2668() {
        if (!m2665() && this.f2691) {
            if (this.f2687.isRunning()) {
                this.f2687.cancel();
            }
            this.f2686 = 1;
            this.f2683.m2677(this.f2682);
            this.f2684.m2677(this.f2682);
            if (isChecked()) {
                C0977 c0977 = this.f2684;
                c0977.f2704 = this.f2670;
                c0977.f2703 = this.f2675;
                c0977.f2706 = this.f2677 + 500.0f;
                c0977.f2705 = this.f2676;
            } else {
                C0977 c09772 = this.f2684;
                c09772.f2704 = this.f2669;
                c09772.f2703 = this.f2673;
                c09772.f2706 = this.f2677;
                c09772.f2705 = this.f2676 - 500.0f;
            }
            this.f2687.start();
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m2669() {
        if (this.f2687.isRunning()) {
            this.f2687.cancel();
        }
        this.f2686 = 4;
        this.f2683.m2677(this.f2682);
        if (isChecked()) {
            setCheckedViewState(this.f2684);
        } else {
            setUncheckViewState(this.f2684);
        }
        this.f2687.start();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m2670(boolean z, boolean z2) {
        if (z2 == isChecked()) {
            postInvalidate();
        } else {
            m2672(z, false, false);
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m2671(boolean z, boolean z2) {
        m2672(z, true, z2);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m2672(boolean z, boolean z2, boolean z3) {
        if (isEnabled()) {
            if (this.f2693) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            }
            InterfaceC0975 interfaceC0975 = this.f2694;
            if (interfaceC0975 == null || interfaceC0975.mo2673()) {
                if (!this.f2692) {
                    this.f2688 = !this.f2688;
                    if (z2) {
                        m2658(z3);
                        return;
                    }
                    return;
                }
                if (this.f2687.isRunning()) {
                    this.f2687.cancel();
                }
                if (this.f2689 && z) {
                    this.f2686 = 5;
                    this.f2683.m2677(this.f2682);
                    if (isChecked()) {
                        setUncheckViewState(this.f2684);
                    } else {
                        setCheckedViewState(this.f2684);
                    }
                    this.f2650 = z3;
                    this.f2687.start();
                    return;
                }
                this.f2688 = !this.f2688;
                if (isChecked()) {
                    setCheckedViewState(this.f2682);
                } else {
                    setUncheckViewState(this.f2682);
                }
                postInvalidate();
                if (z2) {
                    m2658(z3);
                }
            }
        }
    }

    public SwitchButton2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2641 = 0;
        this.f2642 = 1;
        this.f2643 = 2;
        this.f2644 = 3;
        this.f2645 = 4;
        this.f2646 = 5;
        this.f2648 = new float[3];
        this.f2649 = new float[3];
        this.f2651 = new float[3];
        this.f2685 = new RectF();
        this.f2686 = 0;
        this.f2691 = false;
        this.f2692 = false;
        this.f2693 = false;
        this.f2696 = new RunnableC0972();
        this.f2697 = new C0973();
        this.f2698 = new C0974();
        m2663(context, attributeSet);
    }

    public SwitchButton2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2641 = 0;
        this.f2642 = 1;
        this.f2643 = 2;
        this.f2644 = 3;
        this.f2645 = 4;
        this.f2646 = 5;
        this.f2648 = new float[3];
        this.f2649 = new float[3];
        this.f2651 = new float[3];
        this.f2685 = new RectF();
        this.f2686 = 0;
        this.f2691 = false;
        this.f2692 = false;
        this.f2693 = false;
        this.f2696 = new RunnableC0972();
        this.f2697 = new C0973();
        this.f2698 = new C0974();
        m2663(context, attributeSet);
    }
}
