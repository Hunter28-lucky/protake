package com.blink.academy.film.widgets.setting.accessories;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.film.widgets.FilmPointView;
import com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View;
import com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView;
import defpackage.AbstractC3107;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.C5092;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AccessoriesContainerView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f4111;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AccessoriesSettingView f4112;

    /* renamed from: ԭ, reason: contains not printable characters */
    public AccessoriesPage2View f4113;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public AccessoriesPage3View f4114;

    /* renamed from: ԯ, reason: contains not printable characters */
    public AbstractC3107 f4115;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C5092 f4116;

    /* renamed from: ֈ, reason: contains not printable characters */
    public List<View> f4117;

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesContainerView$Ϳ, reason: contains not printable characters */
    public class C1510 implements ViewPager.OnPageChangeListener {
        public C1510() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AccessoriesContainerView.this.f4111 = i;
            AccessoriesContainerView.this.m4084();
        }
    }

    public AccessoriesContainerView(Context context) {
        this(context, null);
    }

    public void setOnButtonClick(AccessoriesSettingView.InterfaceC1524 interfaceC1524) {
        this.f4112.setOnButtonClick(interfaceC1524);
    }

    public void setOnPageCallback(AccessoriesPage2View.InterfaceC1516 interfaceC1516) {
        this.f4113.setOnPageCallback(interfaceC1516);
        this.f4114.setOnPageCallback(interfaceC1516);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4083() {
        this.f4114.m4106();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4084() {
        int childCount = this.f4115.f11057.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                FilmPointView filmPointView = (FilmPointView) this.f4115.f11057.getChildAt(i);
                filmPointView.m2292(false);
                if (i == this.f4111) {
                    filmPointView.m2292(true);
                }
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4085() {
        C2579.m9439(getContext());
        int iM9440 = C2579.m9440(getContext());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4115.f11059.getLayoutParams();
        C4792.m14375().m14442();
        float f = iM9440;
        layoutParams.height = (int) (0.09919571f * f);
        layoutParams.topMargin = (int) (f * 0.04021448f);
        this.f4115.f11059.setLayoutParams(layoutParams);
        this.f4112 = new AccessoriesSettingView(getContext());
        this.f4112.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f4113 = new AccessoriesPage2View(getContext());
        this.f4113.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f4114 = new AccessoriesPage3View(getContext());
        this.f4114.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        for (int i = 0; i < 3; i++) {
            View filmPointView = new FilmPointView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(C2579.m9438(6.0f), C2579.m9438(6.0f));
            layoutParams2.leftMargin = C2579.m9438(1.0f);
            layoutParams2.rightMargin = C2579.m9438(1.0f);
            filmPointView.setLayoutParams(layoutParams2);
            this.f4115.f11057.addView(filmPointView);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4086() {
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4087() {
        this.f4117 = new ArrayList();
        C5092 c5092 = new C5092();
        this.f4116 = c5092;
        c5092.m14921(this.f4117);
        this.f4117.add(this.f4112);
        this.f4117.add(this.f4113);
        this.f4117.add(this.f4114);
        this.f4115.f11057.setVisibility(0);
        this.f4115.f11058.setAdapter(this.f4116);
        this.f4115.f11058.setOverScrollMode(2);
        this.f4115.f11058.addOnPageChangeListener(new C1510());
        m4084();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m4088() {
        this.f4112.m4116();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4089() {
        this.f4113.m4101();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4090() {
        this.f4112.m4117();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m4091() {
        this.f4113.m4102();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m4092() {
        this.f4112.m4118();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m4093() {
        this.f4113.m4103();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m4094() {
        this.f4113.m4104();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m4095() {
        this.f4112.m4119();
        this.f4113.m4104();
        this.f4114.m4110();
    }

    public AccessoriesContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccessoriesContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4115 = AbstractC3107.m10695(LayoutInflater.from(getContext()), this, true);
        m4085();
        m4087();
        m4086();
    }
}
