package com.blink.academy.film.widgets.beauty;

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
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC2963;
import defpackage.AbstractC4012;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C3444;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.C5183;
import defpackage.ViewOnTouchListenerC3426;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BeautySettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2963 f2834;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public RecyclerView f2835;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4194 f2836;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f2837;

    /* renamed from: ԯ, reason: contains not printable characters */
    public StrokeTextView f2838;

    /* renamed from: ՠ, reason: contains not printable characters */
    public StrokeTextView f2839;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f2840;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2841;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f2842;

    /* renamed from: ؠ, reason: contains not printable characters */
    public ConstraintLayout f2843;

    /* renamed from: ހ, reason: contains not printable characters */
    public FilmSeekBar f2844;

    /* renamed from: ށ, reason: contains not printable characters */
    public View f2845;

    /* renamed from: ނ, reason: contains not printable characters */
    public View f2846;

    /* renamed from: ރ, reason: contains not printable characters */
    public RelativeLayout f2847;

    /* renamed from: ބ, reason: contains not printable characters */
    public HorizontalScrollView f2848;

    /* renamed from: ޅ, reason: contains not printable characters */
    public SwitchButton f2849;

    /* renamed from: ކ, reason: contains not printable characters */
    public LinearLayout f2850;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f2851;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f2852;

    /* renamed from: މ, reason: contains not printable characters */
    public boolean f2853;

    /* renamed from: ފ, reason: contains not printable characters */
    public ViewGroup.LayoutParams f2854;

    /* renamed from: ދ, reason: contains not printable characters */
    public LinearLayoutManager f2855;

    /* renamed from: ތ, reason: contains not printable characters */
    public RelativeLayout f2856;

    /* renamed from: ލ, reason: contains not printable characters */
    public ConstraintLayout.LayoutParams f2857;

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean f2858;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f2859;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f2860;

    /* renamed from: ޑ, reason: contains not printable characters */
    public InterfaceC1008 f2861;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f2862;

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean f2863;

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$Ϳ, reason: contains not printable characters */
    public class C0993 implements SwitchButton.InterfaceC0969 {
        public C0993() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            BeautySettingView.this.f2851 = z;
            BeautySettingView.this.m2816(z);
            BeautySettingView.this.m2818(z);
            InterfaceC1008 interfaceC1008 = BeautySettingView.this.f2861;
            if (interfaceC1008 != null) {
                interfaceC1008.mo2834(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$Ԩ, reason: contains not printable characters */
    public class C0994 extends AbstractC4012 {
        public C0994() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            BeautySettingView.this.f2848.setVisibility(0);
            BeautySettingView.this.f2843.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$Ԫ, reason: contains not printable characters */
    public class C0995 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C5183 f2866;

        public C0995(C5183 c5183) {
            this.f2866 = c5183;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) throws Resources.NotFoundException {
            super.onAnimationEnd(view);
            BeautySettingView.this.f2848.setVisibility(8);
            BeautySettingView.this.f2843.setVisibility(0);
            C5183 c5183 = this.f2866;
            if (c5183 != null) {
                BeautySettingView.this.f2852 = c5183.m15143();
                BeautySettingView.this.m2819(r2.f2852);
                BeautySettingView beautySettingView = BeautySettingView.this;
                BeautySettingView.this.m2821(beautySettingView.m2806(beautySettingView.f2852));
                BeautySettingView.this.m2817();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$Ԭ, reason: contains not printable characters */
    public class C0996 extends AbstractC4012 {
        public C0996() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$Ԯ, reason: contains not printable characters */
    public class C0997 implements AbstractC4975.InterfaceC4978 {
        public C0997() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4978
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo2828(int i) {
            if (BeautySettingView.this.f2851) {
                BeautySettingView beautySettingView = BeautySettingView.this;
                if (beautySettingView.f2861 != null) {
                    BeautySettingView.this.f2861.mo2833(((C4196) beautySettingView.f2837.get(i)).m13222().m15145(), r3.m15143());
                }
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4978
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo2829(int i) {
            if (BeautySettingView.this.f2851) {
                BeautySettingView beautySettingView = BeautySettingView.this;
                if (beautySettingView.f2861 != null) {
                    BeautySettingView.this.f2861.mo2833(((C4196) beautySettingView.f2837.get(i)).m13222().m15145(), 0.0f);
                }
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if (BeautySettingView.this.f2851 && !BeautySettingView.this.f2853) {
                C5183 c5183M13222 = ((C4196) BeautySettingView.this.f2837.get(i)).m13222();
                BeautySettingView.this.f2841 = c5183M13222.m15145();
                BeautySettingView.this.m2814(100, c5183M13222);
                BeautySettingView.this.f2842 = i;
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ՠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0998 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ՠ$Ϳ, reason: contains not printable characters */
        public class RunnableC0999 implements Runnable {
            public RunnableC0999() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BeautySettingView.this.f2851) {
                    BeautySettingView.this.f2856.setAlpha(1.0f);
                } else {
                    BeautySettingView.this.f2856.setAlpha(C4792.m14375().m14416());
                }
            }
        }

        public ViewOnTouchListenerC0998() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1 && action != 3) {
                    return false;
                }
                new Handler().postDelayed(new RunnableC0999(), 100L);
                return false;
            }
            if (BeautySettingView.this.f2851) {
                BeautySettingView.this.f2856.setAlpha(0.3f);
                return false;
            }
            BeautySettingView.this.f2856.setAlpha(C4792.m14375().m14416());
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1000 implements View.OnClickListener {
        public ViewOnClickListenerC1000() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeautySettingView.this.m2823();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$֏, reason: contains not printable characters */
    public class ViewOnTouchListenerC1001 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$֏$Ϳ, reason: contains not printable characters */
        public class RunnableC1002 implements Runnable {
            public RunnableC1002() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BeautySettingView.this.f2834.f10710.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC1001() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                BeautySettingView.this.f2834.f10710.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1002(), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1003 implements View.OnClickListener {
        public ViewOnClickListenerC1003() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeautySettingView.this.m2824();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1004 implements View.OnClickListener {
        public ViewOnClickListenerC1004() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC1005 implements View.OnClickListener {
        public ViewOnClickListenerC1005() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeautySettingView beautySettingView = BeautySettingView.this;
            beautySettingView.f2861.mo2830(beautySettingView.f2841);
            BeautySettingView.this.f2841 = 0;
            BeautySettingView.this.m2814(100, null);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ށ, reason: contains not printable characters */
    public class ViewOnClickListenerC1006 implements View.OnClickListener {
        public ViewOnClickListenerC1006() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeautySettingView beautySettingView = BeautySettingView.this;
            beautySettingView.f2861.mo2831(beautySettingView.f2841, BeautySettingView.this.f2852);
            BeautySettingView.this.f2841 = 0;
            BeautySettingView.this.m2815();
            BeautySettingView.this.m2814(100, null);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ނ, reason: contains not printable characters */
    public class C1007 implements FilmSeekBar.InterfaceC0896 {
        public C1007() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) throws Resources.NotFoundException {
            BeautySettingView beautySettingView = BeautySettingView.this;
            if (beautySettingView.f2861 == null || beautySettingView.f2841 == 0) {
                return;
            }
            BeautySettingView beautySettingView2 = BeautySettingView.this;
            beautySettingView2.f2861.mo2833(beautySettingView2.f2841, f2);
            BeautySettingView beautySettingView3 = BeautySettingView.this;
            beautySettingView3.f2852 = beautySettingView3.m2803(f2);
            BeautySettingView beautySettingView4 = BeautySettingView.this;
            BeautySettingView.this.m2821(beautySettingView4.m2806(beautySettingView4.f2852));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.beauty.BeautySettingView$ރ, reason: contains not printable characters */
    public interface InterfaceC1008 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo2830(int i);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo2831(int i, float f);

        /* renamed from: ބ, reason: contains not printable characters */
        void mo2832(int i);

        /* renamed from: ކ, reason: contains not printable characters */
        void mo2833(int i, float f);

        /* renamed from: ދ, reason: contains not printable characters */
        void mo2834(boolean z);
    }

    public BeautySettingView(@NonNull Context context) {
        super(context);
        this.f2837 = new ArrayList<>();
        this.f2858 = true;
        m2808();
    }

    private void setLevelToDefault(C5183 c5183) {
        int iM2803;
        switch (c5183.m15145()) {
            case 1:
                iM2803 = m2803(5.0f);
                break;
            case 2:
                iM2803 = m2803(4.0f);
                break;
            case 3:
                iM2803 = m2803(3.0f);
                break;
            case 4:
                iM2803 = m2803(3.0f);
                break;
            case 5:
                iM2803 = m2803(6.0f);
                break;
            case 6:
                iM2803 = m2803(10.0f);
                break;
            case 7:
                iM2803 = m2803(6.0f);
                break;
            default:
                iM2803 = 0;
                break;
        }
        this.f2852 = iM2803;
        c5183.m15147(iM2803);
    }

    public float getCurrentBeautyLevel() {
        return this.f2852;
    }

    public int getCurrentBeautyType() {
        return this.f2841;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2862 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f2863) {
            return;
        }
        m2807(0, null);
    }

    public void setBeautyChangeCallBack(InterfaceC1008 interfaceC1008) {
        this.f2861 = interfaceC1008;
    }

    public void setPadding(int i) {
        RelativeLayout relativeLayout = this.f2847;
        if (relativeLayout != null) {
            relativeLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final boolean m2801() {
        Iterator<C4196> it = this.f2837.iterator();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (it.hasNext()) {
            C5183 c5183M13222 = it.next().m13222();
            switch (c5183M13222.m15145()) {
                case 1:
                    if (c5183M13222.m15143() == m2803(5.0f)) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 2:
                    if (c5183M13222.m15143() == m2803(4.0f)) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                case 3:
                    if (c5183M13222.m15143() == m2803(3.0f)) {
                        z3 = false;
                        break;
                    } else {
                        z3 = true;
                        break;
                    }
                case 4:
                    if (c5183M13222.m15143() == m2803(3.0f)) {
                        z4 = false;
                        break;
                    } else {
                        z4 = true;
                        break;
                    }
                case 5:
                    if (c5183M13222.m15143() == m2803(6.0f)) {
                        z5 = false;
                        break;
                    } else {
                        z5 = true;
                        break;
                    }
                case 6:
                    if (c5183M13222.m15143() == m2803(10.0f)) {
                        z6 = false;
                        break;
                    } else {
                        z6 = true;
                        break;
                    }
                case 7:
                    if (c5183M13222.m15143() == m2803(6.0f)) {
                        z7 = false;
                        break;
                    } else {
                        z7 = true;
                        break;
                    }
            }
        }
        return z || z2 || z3 || z4 || z5 || z6 || z7;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final boolean m2802() {
        switch (this.f2841) {
            case 1:
                if (this.f2852 == m2803(5.0f)) {
                    break;
                }
                break;
            case 2:
                if (this.f2852 == m2803(4.0f)) {
                    break;
                }
                break;
            case 3:
                if (this.f2852 == m2803(3.0f)) {
                    break;
                }
                break;
            case 4:
                if (this.f2852 == m2803(3.0f)) {
                    break;
                }
                break;
            case 5:
                if (this.f2852 == m2803(6.0f)) {
                    break;
                }
                break;
            case 6:
                if (this.f2852 == m2803(10.0f)) {
                    break;
                }
                break;
            case 7:
                if (this.f2852 == m2803(6.0f)) {
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final int m2803(float f) {
        return (int) f;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final int m2804(int i) {
        return C4792.m14375().m14452(i);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final String m2805(int i) {
        return getResources().getString(i);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final String m2806(int i) throws Resources.NotFoundException {
        String string = getResources().getString(R.string.RECORDING_SETTINGS_BEAUTY);
        String strM2805 = m2805(this.f2837.get(this.f2842).m13222().m15146());
        if (this.f2841 == 0) {
            return string.toUpperCase();
        }
        return string.toUpperCase() + " > " + strM2805 + " (" + i + ") ";
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m2807(int i, AbstractC4012 abstractC4012) {
        this.f2863 = false;
        C4008.m12886(this, 0.0f, this.f2862, i, abstractC4012);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final void m2808() {
        this.f2834 = (AbstractC2963) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_beauty_setting, this, true);
        m2810();
        m2809();
        m2811();
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m2809() {
        this.f2836 = new C4194(getContext(), this.f2837, new C0997());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f2855 = linearLayoutManager;
        this.f2835.setLayoutManager(linearLayoutManager);
        this.f2835.setHasFixedSize(false);
        this.f2835.setHasFixedSize(true);
        this.f2835.setAdapter(this.f2836);
        ((SimpleItemAnimator) this.f2835.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f2835.getItemAnimator().setChangeDuration(0L);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m2810() {
        AbstractC2963 abstractC2963 = this.f2834;
        this.f2850 = abstractC2963.f10702;
        this.f2847 = abstractC2963.f10703;
        this.f2848 = abstractC2963.f10705;
        this.f2835 = abstractC2963.f10701;
        this.f2838 = abstractC2963.f10716;
        this.f2839 = abstractC2963.f10717;
        this.f2843 = abstractC2963.f10704;
        this.f2844 = abstractC2963.f10712;
        this.f2845 = abstractC2963.f10708;
        this.f2846 = abstractC2963.f10707;
        this.f2849 = abstractC2963.f10715;
        this.f2856 = abstractC2963.f10709;
        this.f2840 = C4792.m14375().m14434();
        this.f2834.f10706.m2562(0, C4792.m14375().m14381());
        this.f2834.f10706.setContentTypeFace(FilmApp.m404());
        this.f2834.f10706.setContentTextColor(-1);
        this.f2834.f10715.setTextSize(C4792.m14375().m14481());
        m2821(getResources().getString(R.string.RECORDING_SETTINGS_BEAUTY).toUpperCase());
        this.f2834.f10718.setTypeface(FilmApp.m404());
        this.f2834.f10718.setTextSize(0, C4792.m14375().m14397());
        this.f2834.f10719.setTypeface(FilmApp.m404());
        this.f2834.f10719.setTextSize(0, C4792.m14375().m14397());
        this.f2859 = C4792.m14375().m14476(26);
        this.f2860 = C4792.m14375().m14476(23);
        this.f2834.f10713.setRadius(4);
        this.f2834.f10714.setRadius(4);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2834.f10709.getLayoutParams();
        TextPaint paint = this.f2834.f10718.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = (int) (fontMetrics.descent - fontMetrics.ascent);
        Paint.FontMetrics fontMetrics2 = this.f2834.f10706.getPaint().getFontMetrics();
        int i = (int) ((((ViewGroup.MarginLayoutParams) this.f2857).bottomMargin + ((fontMetrics2.bottom - fontMetrics2.top) / 2.0f)) - (((this.f2860 * 2) + f) / 2.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = C4792.m14375().m14476(56);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_RESET_ALL).toUpperCase()) + (this.f2859 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((this.f2860 * 2) + f);
        this.f2834.f10709.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2834.f10711.getLayoutParams();
        int iM14377 = C4792.m14375().m14377();
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iM14377;
        float fMeasureText = paint.measureText(getContext().getString(R.string.BUTTON_RESET_ALL).toUpperCase()) + (this.f2859 * 2);
        float f2 = iM14377 * 2;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (fMeasureText + f2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) ((this.f2860 * 2) + f + f2 + C4792.f16138);
        this.f2834.f10711.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f2834.f10710.getLayoutParams();
        TextPaint paint2 = this.f2834.f10718.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = i;
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = C4792.m14375().m14476(56);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (paint2.measureText(getContext().getString(R.string.BUTTON_RESET).toUpperCase()) + (this.f2859 * 2));
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) ((this.f2860 * 2) + f);
        this.f2834.f10710.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f2834.f10700.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin - iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (paint2.measureText(getContext().getString(R.string.BUTTON_RESET).toUpperCase()) + (this.f2859 * 2) + f2);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = (int) (f + (this.f2860 * 2) + f2 + C4792.f16138);
        this.f2834.f10700.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.f2850.getLayoutParams();
        this.f2854 = layoutParams5;
        layoutParams5.height = (int) (C4792.m14375().m14407() * this.f2840);
        this.f2850.setLayoutParams(this.f2854);
        this.f2838.setContentTypeFace(FilmApp.m404());
        this.f2838.m2562(0, C4792.m14375().m14381() * this.f2840);
        this.f2839.setContentTypeFace(FilmApp.m404());
        this.f2839.m2562(0, C4792.m14375().m14381() * this.f2840);
        int iM14476 = (int) (C4792.m14375().m14476(135) * this.f2840);
        int iM144762 = (int) (C4792.m14375().m14476(1000) * this.f2840);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f2838.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (this.f2838.getPaint().measureText(getResources().getString(R.string.BUTTON_CANCEL)) + C4792.f16138);
        int iMeasureText = (int) (this.f2838.getPaint().measureText(getResources().getString(R.string.BUTTON_OK)) + C4792.f16138);
        if (C4792.m14375().m14498()) {
            iM14476 = m2804(iM14476);
            iM144762 = ((C2579.f9594 - iMeasureText) - ((ViewGroup.MarginLayoutParams) layoutParams6).width) - (iM14476 * 4);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = iM14476;
        this.f2838.setLayoutParams(layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f2839.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = iMeasureText;
        this.f2839.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f2834.f10712.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).width = iM144762;
        this.f2834.f10712.setLayoutParams(layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f2845.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = (int) (C2579.m9438(44.0f) * this.f2840);
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = (int) (C2579.m9438(44.0f) * this.f2840);
        this.f2845.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f2846.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = (int) (C2579.m9438(44.0f) * this.f2840);
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = (int) (C2579.m9438(44.0f) * this.f2840);
        this.f2846.setLayoutParams(layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.f2849.getLayoutParams();
        layoutParams11.width = (int) (C4792.m14375().m14410() * this.f2840);
        layoutParams11.height = (int) (C4792.m14375().m14409() * this.f2840);
        int iM144763 = C4792.m14375().m14476(150);
        int iM14386 = (iM144763 - C4792.m14375().m14386()) - C4792.m14375().m14476(20);
        if (C4792.m14375().m14498()) {
            iM144763 = m2804(iM144763);
            iM14386 = m2804(iM14386);
        }
        layoutParams11.leftMargin = iM144763;
        layoutParams11.rightMargin = iM14386;
        this.f2849.setLayoutParams(layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) this.f2834.f10699.getLayoutParams();
        layoutParams12.width = layoutParams11.rightMargin;
        this.f2834.f10699.setLayoutParams(layoutParams12);
        Paint paint3 = new Paint();
        paint3.setTypeface(FilmApp.m404());
        paint3.setTextSize(C4792.m14375().m14398());
        Paint.FontMetrics fontMetrics3 = paint3.getFontMetrics();
        RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.f2835.getLayoutParams();
        layoutParams13.topMargin = (int) (((((this.f2854.height - C4792.m14375().m14476(135)) - fontMetrics3.bottom) + fontMetrics3.top) - C4792.m14375().m14476(20)) / 2.0f);
        this.f2835.setLayoutParams(layoutParams13);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m2811() {
        this.f2834.f10711.setOnTouchListener(new ViewOnTouchListenerC0998());
        this.f2834.f10711.setOnClickListener(new ViewOnClickListenerC1000());
        this.f2834.f10700.setOnTouchListener(new ViewOnTouchListenerC1001());
        this.f2834.f10700.setOnClickListener(new ViewOnClickListenerC1003());
        this.f2850.setOnClickListener(new ViewOnClickListenerC1004());
        this.f2846.setOnTouchListener(new ViewOnTouchListenerC3426(this.f2838));
        this.f2846.setOnClickListener(new ViewOnClickListenerC1005());
        this.f2845.setOnTouchListener(new ViewOnTouchListenerC3426(this.f2839));
        this.f2845.setOnClickListener(new ViewOnClickListenerC1006());
        this.f2844.setOnProChange(new C1007());
        this.f2849.setOnCheckedChangeListener(new C0993());
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean m2812() {
        return this.f2853;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean m2813() {
        return this.f2863;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m2814(int i, C5183 c5183) {
        if (this.f2841 == 0) {
            m2826(i);
        } else {
            m2827(i, c5183);
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m2815() {
        this.f2837.get(this.f2842).m13222().m15147(this.f2852);
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m2816(boolean z) {
        if (z) {
            this.f2835.setAlpha(1.0f);
            this.f2835.setEnabled(true);
        } else {
            this.f2835.setAlpha(0.3f);
            this.f2835.setEnabled(false);
        }
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m2817() {
        if (this.f2841 == 0) {
            this.f2834.f10710.setVisibility(8);
            this.f2834.f10700.setVisibility(8);
            this.f2856.setVisibility(0);
            this.f2834.f10711.setVisibility(0);
            return;
        }
        this.f2856.setVisibility(8);
        this.f2834.f10711.setVisibility(8);
        this.f2834.f10710.setVisibility(0);
        this.f2834.f10700.setVisibility(0);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m2818(boolean z) {
        if (z) {
            this.f2856.setAlpha(C4792.m14375().m14402());
            this.f2834.f10711.setEnabled(true);
        } else {
            this.f2856.setAlpha(C4792.m14375().m14416());
            this.f2834.f10711.setEnabled(false);
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final void m2819(float f) {
        this.f2844.setValueAndUpdateUI(f);
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m2820() {
        boolean zM12389 = C4535.m13880().m13890().m12389();
        this.f2849.m2630(false, zM12389);
        m2818(zM12389);
        this.f2851 = zM12389;
        m2816(zM12389);
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final void m2821(String str) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2834.f10706.getLayoutParams();
        this.f2857 = layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = C4792.m14375().m14408();
        if (this.f2841 == 0) {
            ((ViewGroup.MarginLayoutParams) this.f2857).width = (int) (this.f2834.f10706.getPaint().measureText(str) + C4792.f16138);
        } else {
            ((ViewGroup.MarginLayoutParams) this.f2857).width = (int) (this.f2834.f10706.getPaint().measureText(m2806(10)) + C4792.f16138);
        }
        this.f2834.f10706.setLayoutParams(this.f2857);
        this.f2834.f10706.setText(str);
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public void m2822() {
        ArrayList<C5183> arrayListM11240 = C3444.m11227().m11240();
        this.f2837.clear();
        C3891 c3891M13890 = C4535.m13880().m13890();
        Iterator<C5183> it = arrayListM11240.iterator();
        while (it.hasNext()) {
            C5183 next = it.next();
            C4196 c4196 = new C4196();
            c4196.setItemViewType(9);
            int iM2803 = 0;
            switch (next.m15145()) {
                case 1:
                    iM2803 = m2803(c3891M13890.m12385());
                    break;
                case 2:
                    iM2803 = m2803(c3891M13890.m12390());
                    break;
                case 3:
                    iM2803 = m2803(c3891M13890.m12386());
                    break;
                case 4:
                    iM2803 = m2803(c3891M13890.m12382());
                    break;
                case 5:
                    iM2803 = m2803(c3891M13890.m12387());
                    break;
                case 6:
                    iM2803 = m2803(c3891M13890.m12383());
                    break;
                case 7:
                    iM2803 = m2803(c3891M13890.m12396());
                    break;
            }
            c4196.m13240(next);
            next.m15147(iM2803);
            this.f2837.add(c4196);
        }
        this.f2836.notifyDataSetChanged();
        this.f2844.setMax(10.0f);
        this.f2844.setMin(0.0f);
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m2823() {
        if (this.f2851 && m2801()) {
            InterfaceC1008 interfaceC1008 = this.f2861;
            if (interfaceC1008 != null) {
                interfaceC1008.mo2832(this.f2841);
            }
            Iterator<C4196> it = this.f2837.iterator();
            while (it.hasNext()) {
                setLevelToDefault(it.next().m13222());
            }
            this.f2836.notifyItemRangeChanged(0, this.f2837.size());
        }
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final void m2824() {
        if (this.f2851 && m2802()) {
            InterfaceC1008 interfaceC1008 = this.f2861;
            if (interfaceC1008 != null) {
                interfaceC1008.mo2832(this.f2841);
            }
            setLevelToDefault(this.f2837.get(this.f2842).m13222());
            this.f2836.notifyItemChanged(this.f2842);
            this.f2844.setValueAndUpdateUI(r0.m15143());
            m2821(m2806(this.f2852));
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public void m2825(int i) {
        this.f2863 = true;
        this.f2853 = false;
        this.f2841 = 0;
        m2820();
        m2822();
        m2814(0, null);
        this.f2836.notifyDataSetChanged();
        C4008.m12886(this, 0.0f, 0.0f, i, new C0996());
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public void m2826(int i) {
        this.f2853 = false;
        this.f2836.notifyItemChanged(this.f2842);
        this.f2841 = 0;
        this.f2842 = 0;
        C4008.m12886(this.f2848, 0.0f, 0.0f, i, null);
        C4008.m12886(this.f2843, 0.0f, this.f2854.height, i, new C0994());
        m2817();
        m2821(getResources().getString(R.string.RECORDING_SETTINGS_BEAUTY).toUpperCase());
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m2827(int i, C5183 c5183) {
        this.f2853 = true;
        C4008.m12886(this.f2848, 0.0f, this.f2854.height, i, null);
        C4008.m12886(this.f2843, 0.0f, 0.0f, i, new C0995(c5183));
    }

    public BeautySettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2837 = new ArrayList<>();
        this.f2858 = true;
        m2808();
    }

    public BeautySettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2837 = new ArrayList<>();
        this.f2858 = true;
        m2808();
    }
}
