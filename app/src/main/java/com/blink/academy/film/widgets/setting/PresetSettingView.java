package com.blink.academy.film.widgets.setting;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.setting.pager.PresetPagerItem;
import com.blink.academy.film.widgets.FilmPointView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4289;
import defpackage.C2579;
import defpackage.C2938;
import defpackage.C3891;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.C4802;
import defpackage.r1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PresetSettingView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4289 f3994;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C2938 f3995;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<PresetPagerItem> f3996;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public List<C4802> f3997;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3998;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3999;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f4000;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC1434 f4001;

    /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$Ϳ, reason: contains not printable characters */
    public class C1426 implements ViewPager.OnPageChangeListener {
        public C1426() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            C4638.m14097();
            if (i == 1 && PresetSettingView.this.f3999 > 1) {
                PresetSettingView.this.m4017(false);
            } else {
                ((PresetPagerItem) PresetSettingView.this.f3996.get(PresetSettingView.this.f3998)).m1871();
                PresetSettingView.this.m4017(true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PresetSettingView.this.f3998 = i;
            PresetSettingView.this.m4004();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$Ԩ, reason: contains not printable characters */
    public class C1427 implements PresetPagerItem.InterfaceC0780 {
        public C1427() {
        }

        @Override // com.blink.academy.film.setting.pager.PresetPagerItem.InterfaceC0780
        /* renamed from: Ϳ */
        public void mo1872(C3891 c3891) {
            if (PresetSettingView.this.f4001 != null) {
                PresetSettingView.this.f4001.mo1841(c3891);
            }
        }

        @Override // com.blink.academy.film.setting.pager.PresetPagerItem.InterfaceC0780
        /* renamed from: Ԩ */
        public void mo1873(C3891 c3891, String str) {
            if (PresetSettingView.this.f4001 != null) {
                PresetSettingView.this.f4001.mo1838(c3891, str);
            }
        }

        @Override // com.blink.academy.film.setting.pager.PresetPagerItem.InterfaceC0780
        /* renamed from: ԩ */
        public void mo1874(int i, int i2) {
            if (i2 == -1 || i2 == i) {
                return;
            }
            ((PresetPagerItem) PresetSettingView.this.f3996.get(PresetSettingView.this.f3998)).m1871();
        }

        @Override // com.blink.academy.film.setting.pager.PresetPagerItem.InterfaceC0780
        /* renamed from: Ԫ */
        public void mo1875(C3891 c3891) {
            if (PresetSettingView.this.f4001 != null) {
                PresetSettingView.this.f4001.mo1842(c3891);
            }
        }

        @Override // com.blink.academy.film.setting.pager.PresetPagerItem.InterfaceC0780
        /* renamed from: ԫ */
        public void mo1876(C3891 c3891) {
            if (PresetSettingView.this.f4001 != null) {
                PresetSettingView.this.f4001.mo1840(c3891);
            }
        }

        @Override // com.blink.academy.film.setting.pager.PresetPagerItem.InterfaceC0780
        /* renamed from: Ԭ */
        public void mo1877(C3891 c3891) {
            if (PresetSettingView.this.f4001 != null) {
                PresetSettingView.this.f4001.mo1839(c3891);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1428 implements View.OnClickListener {
        public ViewOnClickListenerC1428() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PresetSettingView.this.f4001 != null) {
                PresetSettingView.this.f4001.mo1843();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1429 implements View.OnClickListener {
        public ViewOnClickListenerC1429() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PresetSettingView.this.f4001 != null) {
                PresetSettingView.this.f4001.mo1844();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1430 implements View.OnClickListener {
        public ViewOnClickListenerC1430() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PresetSettingView.this.f3998 < PresetSettingView.this.f3999 - 1) {
                PresetSettingView.m3996(PresetSettingView.this);
                PresetSettingView.this.f3994.f14697.setCurrentItem(PresetSettingView.this.f3998);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1431 implements View.OnClickListener {
        public ViewOnClickListenerC1431() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PresetSettingView.this.f3998 > 0) {
                PresetSettingView.m3997(PresetSettingView.this);
                PresetSettingView.this.f3994.f14697.setCurrentItem(PresetSettingView.this.f3998);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$ֈ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1432 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4008;

        /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$ֈ$Ϳ, reason: contains not printable characters */
        public class RunnableC1433 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4009;

            public RunnableC1433(View view) {
                this.f4009 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4009.isEnabled()) {
                    ViewOnTouchListenerC1432.this.f4008.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1432(View view) {
            this.f4008 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4008.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1433(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PresetSettingView$֏, reason: contains not printable characters */
    public interface InterfaceC1434 {
        /* renamed from: Ϳ */
        void mo1838(C3891 c3891, String str);

        /* renamed from: Ԩ */
        void mo1839(C3891 c3891);

        /* renamed from: ԩ */
        void mo1840(C3891 c3891);

        /* renamed from: Ԫ */
        void mo1841(C3891 c3891);

        /* renamed from: ԫ */
        void mo1842(C3891 c3891);

        /* renamed from: Ԭ */
        void mo1843();

        /* renamed from: ԭ */
        void mo1844();
    }

    public PresetSettingView(Context context) {
        this(context, null);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static /* synthetic */ int m3996(PresetSettingView presetSettingView) {
        int i = presetSettingView.f3998;
        presetSettingView.f3998 = i + 1;
        return i;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static /* synthetic */ int m3997(PresetSettingView presetSettingView) {
        int i = presetSettingView.f3998;
        presetSettingView.f3998 = i - 1;
        return i;
    }

    public void setOnButtonClick(InterfaceC1434 interfaceC1434) {
        this.f4001 = interfaceC1434;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m4004() {
        int childCount = this.f3994.f14691.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                FilmPointView filmPointView = (FilmPointView) this.f3994.f14691.getChildAt(i);
                filmPointView.m2292(false);
                if (i == this.f3998) {
                    filmPointView.m2292(true);
                }
            }
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m4005() {
        if (r1.m8144(this.f3997)) {
            ((PresetPagerItem) this.f3994.f14697.getChildAt(0)).m1866();
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean m4006() {
        PresetPagerItem presetPagerItem;
        if (!r1.m8144(this.f3996) || (presetPagerItem = this.f3996.get(this.f3998)) == null) {
            return false;
        }
        return presetPagerItem.m1867();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m4007() {
        this.f3994 = AbstractC4289.m13401(LayoutInflater.from(getContext()), this, true);
        m4008();
        m4010();
        m4009();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m4008() {
        int iM9439 = C2579.m9439(getContext());
        int iM9440 = C2579.m9440(getContext());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3994.f14701.getLayoutParams();
        float fM14442 = C4792.m14375().m14442();
        float f = iM9440;
        int i = (int) (0.09919571f * f);
        layoutParams.height = i;
        layoutParams.topMargin = (int) (0.04021448f * f);
        this.f3994.f14701.setLayoutParams(layoutParams);
        float f2 = iM9439;
        int iMin = Math.min(C4792.m14375().m14469(60), (int) (0.101726264f * f2));
        int i2 = (int) (0.50268096f * f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3994.f14697.getLayoutParams();
        layoutParams2.topMargin = i;
        layoutParams2.height = i2;
        this.f3994.f14697.setLayoutParams(layoutParams2);
        int i3 = (int) (0.049597856f * f);
        int i4 = (int) (0.12228261f * f);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3994.f14692.getLayoutParams();
        layoutParams3.width = i3;
        layoutParams3.height = i3;
        layoutParams3.rightMargin = C4792.m14375().m14468();
        layoutParams3.bottomMargin = i4;
        this.f3994.f14692.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f3994.f14695.getLayoutParams();
        layoutParams4.width = i3;
        layoutParams4.height = i3;
        layoutParams4.rightMargin = (int) (f2 * 0.03699137f);
        layoutParams4.bottomMargin = i4;
        this.f3994.f14695.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f3994.f14699.getLayoutParams();
        layoutParams5.width = C2579.m9438(44.0f);
        int iM9438 = C2579.m9438(44.0f);
        layoutParams5.height = iM9438;
        layoutParams5.rightMargin = layoutParams3.rightMargin - ((layoutParams5.width - layoutParams3.width) / 2);
        layoutParams5.bottomMargin = layoutParams3.bottomMargin - ((iM9438 - layoutParams3.height) / 2);
        this.f3994.f14699.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f3994.f14702.getLayoutParams();
        layoutParams6.width = C2579.m9438(44.0f);
        layoutParams6.height = C2579.m9438(44.0f);
        layoutParams6.rightMargin = Math.max(10, layoutParams4.rightMargin - (((layoutParams6.width - layoutParams4.width) / 2) * 2));
        layoutParams6.bottomMargin = layoutParams5.bottomMargin;
        this.f3994.f14702.setLayoutParams(layoutParams6);
        int i5 = (int) (f * 0.053619303f);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f3994.f14693.getLayoutParams();
        layoutParams7.width = i5;
        layoutParams7.height = i5;
        layoutParams7.topMargin = (i + (i2 / 2)) - (i5 / 2);
        if (fM14442 <= (iMin - i5) / 2.0f) {
            fM14442 = (iMin - i5) / 2.0f;
        }
        layoutParams7.rightMargin = (int) fM14442;
        this.f3994.f14693.setLayoutParams(layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f3994.f14694.getLayoutParams();
        layoutParams8.width = i5;
        layoutParams8.height = i5;
        layoutParams8.topMargin = layoutParams7.topMargin;
        layoutParams8.leftMargin = layoutParams7.rightMargin;
        this.f3994.f14694.setLayoutParams(layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f3994.f14696.getLayoutParams();
        int i6 = layoutParams.height;
        layoutParams9.height = i6;
        layoutParams9.width = i6;
        layoutParams9.topMargin = layoutParams7.topMargin - ((i6 - layoutParams7.height) / 2);
        layoutParams9.rightMargin = layoutParams7.rightMargin - ((i6 - layoutParams7.width) / 2);
        this.f3994.f14696.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f3994.f14698.getLayoutParams();
        int i7 = layoutParams.height;
        layoutParams10.height = i7;
        layoutParams10.width = i7;
        layoutParams10.topMargin = layoutParams7.topMargin - ((layoutParams9.height - layoutParams7.height) / 2);
        layoutParams10.leftMargin = layoutParams8.leftMargin - ((i7 - layoutParams8.width) / 2);
        this.f3994.f14698.setLayoutParams(layoutParams10);
        this.f3994.f14703.setTypeface(FilmApp.m404());
        this.f3994.f14703.setTextSize(0, C4792.m14375().m14381());
        this.f3994.f14703.setTextColor(Color.parseColor("#4cffffff"));
        this.f3994.f14703.setText(getResources().getString(R.string.SETTINGS_PRESET_EMPTY));
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m4009() {
        AbstractC4289 abstractC4289 = this.f3994;
        abstractC4289.f14699.setOnTouchListener(new ViewOnTouchListenerC1432(abstractC4289.f14692));
        AbstractC4289 abstractC42892 = this.f3994;
        abstractC42892.f14702.setOnTouchListener(new ViewOnTouchListenerC1432(abstractC42892.f14695));
        this.f3994.f14699.setOnClickListener(new ViewOnClickListenerC1428());
        this.f3994.f14702.setOnClickListener(new ViewOnClickListenerC1429());
        this.f3994.f14696.setOnClickListener(new ViewOnClickListenerC1430());
        this.f3994.f14698.setOnClickListener(new ViewOnClickListenerC1431());
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m4010() {
        m4012();
        m4011();
        this.f3994.f14697.setOverScrollMode(2);
        this.f3994.f14697.addOnPageChangeListener(new C1426());
        m4015();
        m4004();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4011() {
        this.f3996 = new ArrayList();
        C2938 c2938 = new C2938();
        this.f3995 = c2938;
        c2938.m10336(this.f3996);
        m4016();
        this.f3994.f14697.setAdapter(this.f3995);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m4012() {
        m4014();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m4013(int i) {
        if (i == 1) {
            this.f3998 = 0;
            this.f3994.f14697.setCurrentItem(0);
        }
        m4014();
        if (i == 2) {
            int i2 = this.f3998;
            int i3 = this.f3999;
            if (i2 > i3 - 1) {
                this.f3998 = i3 - 1;
            }
        }
        m4016();
        if (i != 3 && i != 4) {
            m4015();
        }
        m4004();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m4014() {
        this.f3997 = new ArrayList();
        List<C3891> listM13889 = C4535.m13880().m13889();
        if (r1.m8144(listM13889)) {
            for (C3891 c3891 : listM13889) {
                if (!c3891.m12493()) {
                    C4802 c4802 = new C4802();
                    c4802.m14517(c3891);
                    this.f3997.add(c4802);
                }
            }
            if (r1.m8144(this.f3997)) {
                this.f3999 = (int) Math.ceil((this.f3997.size() * 1.0f) / 3.0f);
            } else {
                this.f3999 = 1;
            }
        }
        if (r1.m8144(this.f3997)) {
            this.f3994.f14700.setVisibility(8);
        } else {
            this.f3994.f14700.setVisibility(0);
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m4015() {
        if (this.f3999 <= 1) {
            this.f3994.f14701.setVisibility(8);
            return;
        }
        this.f3994.f14701.setVisibility(0);
        this.f3994.f14691.removeAllViews();
        for (int i = 0; i < this.f3999; i++) {
            View filmPointView = new FilmPointView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(C2579.m9438(6.0f), C2579.m9438(6.0f));
            layoutParams.leftMargin = C2579.m9438(1.0f);
            layoutParams.rightMargin = C2579.m9438(1.0f);
            filmPointView.setLayoutParams(layoutParams);
            this.f3994.f14691.addView(filmPointView);
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m4016() {
        if (!r1.m8144(this.f3997)) {
            this.f3994.f14697.removeAllViews();
            this.f3996.clear();
            this.f3995.notifyDataSetChanged();
            return;
        }
        if (this.f3996.size() < this.f3999) {
            int size = this.f3996.size();
            for (int i = 0; i < this.f3999 - size; i++) {
                PresetPagerItem presetPagerItem = new PresetPagerItem(getContext());
                presetPagerItem.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                presetPagerItem.setDealClick(new C1427());
                this.f3996.add(presetPagerItem);
            }
        } else if (this.f3996.size() > this.f3999) {
            this.f3994.f14697.removeView(this.f3996.get(r1.size() - 1));
            List<PresetPagerItem> list = this.f3996;
            list.remove(list.get(list.size() - 1));
        }
        this.f3995.notifyDataSetChanged();
        if (r1.m8144(this.f3997)) {
            for (int i2 = 0; i2 < this.f3999; i2++) {
                PresetPagerItem presetPagerItem2 = this.f3996.get(i2);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i3 = i2 * 3;
                arrayList.add(Integer.valueOf(i3));
                arrayList.add(Integer.valueOf(i3 + 1));
                arrayList.add(Integer.valueOf(i3 + 2));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    if (iIntValue < this.f3997.size()) {
                        arrayList2.add(this.f3997.get(iIntValue));
                    }
                }
                presetPagerItem2.setData(arrayList2);
                presetPagerItem2.m1871();
            }
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m4017(boolean z) {
        int i = z ? 0 : 8;
        this.f3994.f14695.setVisibility(i);
        this.f3994.f14692.setVisibility(i);
        this.f3994.f14702.setVisibility(i);
        this.f3994.f14699.setVisibility(i);
    }

    public PresetSettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PresetSettingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3998 = 0;
        this.f4000 = 0.2f;
        m4007();
    }
}
