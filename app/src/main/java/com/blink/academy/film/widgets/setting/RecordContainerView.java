package com.blink.academy.film.widgets.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.film.widgets.FilmPointView;
import com.blink.academy.film.widgets.setting.RecordSettingPage2View;
import com.blink.academy.film.widgets.setting.RecordSettingView;
import defpackage.AbstractC2822;
import defpackage.C2579;
import defpackage.C3891;
import defpackage.C4792;
import defpackage.C5092;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RecordContainerView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public RecordSettingView f4044;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public RecordSettingPage2View f4045;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4046;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public AbstractC2822 f4047;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C5092 f4048;

    /* renamed from: ՠ, reason: contains not printable characters */
    public List<View> f4049;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC1464 f4050;

    /* renamed from: com.blink.academy.film.widgets.setting.RecordContainerView$Ϳ, reason: contains not printable characters */
    public class C1460 implements ViewPager.OnPageChangeListener {
        public C1460() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            RecordContainerView.this.f4046 = i;
            RecordContainerView.this.m4045();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordContainerView$Ԩ, reason: contains not printable characters */
    public class C1461 implements RecordSettingView.InterfaceC1508 {
        public C1461() {
        }

        @Override // com.blink.academy.film.widgets.setting.RecordSettingView.InterfaceC1508
        /* renamed from: Ϳ */
        public void mo1735() {
            RecordContainerView.this.f4050.mo1830(1, null);
        }

        @Override // com.blink.academy.film.widgets.setting.RecordSettingView.InterfaceC1508
        /* renamed from: Ԩ */
        public void mo1736() {
            RecordContainerView.this.f4050.mo1830(7, null);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordContainerView$Ԫ, reason: contains not printable characters */
    public class C1462 implements RecordSettingView.InterfaceC1509 {
        public C1462() {
        }

        @Override // com.blink.academy.film.widgets.setting.RecordSettingView.InterfaceC1509
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo4052() {
            RecordContainerView.this.f4050.mo1830(24, null);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordContainerView$Ԭ, reason: contains not printable characters */
    public class C1463 implements RecordSettingPage2View.InterfaceC1471 {
        public C1463() {
        }

        @Override // com.blink.academy.film.widgets.setting.RecordSettingPage2View.InterfaceC1471
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo4053() {
            RecordContainerView.this.f4050.mo1830(32, null);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordContainerView$Ԯ, reason: contains not printable characters */
    public interface InterfaceC1464 {
        /* renamed from: Ϳ */
        void mo1830(int i, C3891 c3891);
    }

    public RecordContainerView(Context context) {
        this(context, null);
    }

    public void setOnCallback(InterfaceC1464 interfaceC1464) {
        this.f4050 = interfaceC1464;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4045() {
        int childCount = this.f4047.f10289.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                FilmPointView filmPointView = (FilmPointView) this.f4047.f10289.getChildAt(i);
                filmPointView.m2292(false);
                if (i == this.f4046) {
                    filmPointView.m2292(true);
                }
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4046() {
        this.f4047 = AbstractC2822.m10165(LayoutInflater.from(getContext()), this, true);
        m4047();
        m4049();
        m4048();
        m4045();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4047() {
        C2579.m9439(getContext());
        int iM9440 = C2579.m9440(getContext());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4047.f10291.getLayoutParams();
        C4792.m14375().m14442();
        float f = iM9440;
        layoutParams.height = (int) (0.09919571f * f);
        layoutParams.topMargin = (int) (f * 0.04021448f);
        this.f4047.f10291.setLayoutParams(layoutParams);
        this.f4044 = new RecordSettingView(getContext());
        this.f4044.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f4045 = new RecordSettingPage2View(getContext());
        this.f4045.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        for (int i = 0; i < 2; i++) {
            View filmPointView = new FilmPointView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(C2579.m9438(6.0f), C2579.m9438(6.0f));
            layoutParams2.leftMargin = C2579.m9438(1.0f);
            layoutParams2.rightMargin = C2579.m9438(1.0f);
            filmPointView.setLayoutParams(layoutParams2);
            this.f4047.f10289.addView(filmPointView);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4048() {
        this.f4044.setOnButtonClick(new C1461());
        this.f4044.setOnInfoClick(new C1462());
        this.f4045.setOnInfoClick(new C1463());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4049() {
        m4050();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m4050() {
        this.f4049 = new ArrayList();
        C5092 c5092 = new C5092();
        this.f4048 = c5092;
        c5092.m14921(this.f4049);
        this.f4049.add(this.f4044);
        this.f4047.f10289.setVisibility(8);
        this.f4047.f10290.setAdapter(this.f4048);
        this.f4047.f10290.setOverScrollMode(2);
        this.f4047.f10290.addOnPageChangeListener(new C1460());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4051() {
        this.f4044.m4076();
        this.f4045.m4059();
    }

    public RecordContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4046();
    }
}
