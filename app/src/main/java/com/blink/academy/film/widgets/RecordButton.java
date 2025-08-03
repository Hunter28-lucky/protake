package com.blink.academy.film.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.protake.R;
import defpackage.AbstractC4366;
import defpackage.C2579;
import defpackage.C4638;

/* loaded from: classes.dex */
public class RecordButton extends FrameLayout {

    /* renamed from: ރ, reason: contains not printable characters */
    public static final String f2437 = RecordButton.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public float f2438;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2439;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2440;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public AbstractC4366 f2441;

    /* renamed from: ԯ, reason: contains not printable characters */
    public GradientDrawable f2442;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2443;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2444;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2445;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f2446;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f2447;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f2448;

    /* renamed from: ށ, reason: contains not printable characters */
    public View.OnClickListener f2449;

    /* renamed from: ނ, reason: contains not printable characters */
    public InterfaceC0941 f2450;

    /* renamed from: com.blink.academy.film.widgets.RecordButton$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC0937 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.RecordButton$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC0938 implements Runnable {
            public RunnableC0938() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RecordButton.this.setEnabled(true);
            }
        }

        public ViewOnClickListenerC0937() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC0941 interfaceC0941 = RecordButton.this.f2450;
            if ((interfaceC0941 == null || interfaceC0941.mo2506()) && RecordButton.this.f2447) {
                RecordButton.this.setEnabled(false);
                if (RecordButton.this.f2448) {
                    RecordButton.this.postDelayed(new RunnableC0938(), 100L);
                }
                int i = RecordButton.this.f2440 == 0 ? 1 : 0;
                if (RecordButton.this.f2450 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("按钮点击 state: 目标：");
                    sb.append(i == 0 ? "停止" : "录制");
                    sb.append("  当前：");
                    sb.append(RecordButton.this.f2440 != 0 ? "录制" : "停止");
                    C4638.m14099("slimmmmmmmm", sb.toString());
                    RecordButton.this.f2450.mo2507(i);
                }
                if (RecordButton.this.f2448) {
                    RecordButton.this.m2501(i, true);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.RecordButton$Ԩ, reason: contains not printable characters */
    public class C0939 implements ValueAnimator.AnimatorUpdateListener {
        public C0939() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) RecordButton.this.f2441.f15023.getLayoutParams();
            int i = (int) fFloatValue;
            layoutParams.width = i;
            layoutParams.height = i;
            RecordButton.this.f2441.f15023.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.RecordButton$Ԫ, reason: contains not printable characters */
    public class C0940 implements Animator.AnimatorListener {
        public C0940() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.RecordButton$Ԭ, reason: contains not printable characters */
    public interface InterfaceC0941 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo2506();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo2507(int i);
    }

    public RecordButton(@NonNull Context context) {
        this(context, null);
    }

    public int getState() {
        return this.f2440;
    }

    public void setOnRecordButtonClick(InterfaceC0941 interfaceC0941) {
        this.f2450 = interfaceC0941;
    }

    public void setState(int i) {
        this.f2440 = i;
        m2501(i, false);
    }

    public void setStateWithAnim(int i) {
        if (this.f2440 == i) {
            return;
        }
        this.f2440 = i;
        m2501(i, true);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2501(int i, boolean z) {
        float f;
        float f2;
        int i2;
        int i3;
        int i4 = z ? 100 : 0;
        if (i == 0) {
            f = this.f2438;
            f2 = this.f2439;
            i2 = this.f2445;
            i3 = this.f2446;
        } else {
            f = this.f2439;
            f2 = this.f2438;
            i2 = this.f2446;
            i3 = this.f2445;
        }
        this.f2440 = i;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2442, "cornerRadius", f, f2);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i2, i3);
        valueAnimatorOfFloat.addUpdateListener(new C0939());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(i4);
        animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat);
        animatorSet.addListener(new C0940());
        animatorSet.start();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2502() {
        this.f2441 = AbstractC4366.m13527(LayoutInflater.from(getContext()), this, true);
        setOnClickListener(this.f2449);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public RecordButton m2503(boolean z) {
        this.f2448 = z;
        return this;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public RecordButton m2504(boolean z) {
        this.f2447 = z;
        return this;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2505(int i, int i2) {
        this.f2443 = i;
        this.f2444 = i2;
        int iM9438 = (i - (C2579.m9438(3.5f) * 2)) - (C2579.m9438(0.0f) * 2);
        this.f2446 = iM9438;
        this.f2445 = (int) (iM9438 * 0.55f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2441.f15024.getLayoutParams();
        layoutParams.width = this.f2443;
        layoutParams.height = this.f2444;
        this.f2441.f15024.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f2441.f15023.getLayoutParams();
        int i3 = this.f2446;
        layoutParams2.width = i3;
        layoutParams2.height = i3;
        this.f2441.f15023.setLayoutParams(layoutParams2);
        this.f2442 = (GradientDrawable) getResources().getDrawable(R.drawable.video_player_innerbg, getContext().getTheme()).mutate();
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.video_player_outerbg, getContext().getTheme()).mutate();
        this.f2439 = (this.f2443 * 1.0f) / 2.0f;
        this.f2438 = 10.0f;
        this.f2442.setColor(Color.parseColor("#E02727"));
        this.f2441.f15023.setBackground(this.f2442);
        this.f2441.f15024.setBackground(gradientDrawable);
        postInvalidate();
    }

    public RecordButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2443 = 0;
        this.f2444 = 0;
        this.f2447 = true;
        this.f2448 = true;
        this.f2449 = new ViewOnClickListenerC0937();
        m2502();
    }
}
