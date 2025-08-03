package com.blink.academy.film.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4653;
import defpackage.AbstractC4975;
import defpackage.C2334;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C3444;
import defpackage.C3769;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4062;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.r1;
import defpackage.v5;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FPSSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f2095;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AbstractC4653 f2096;

    /* renamed from: ԭ, reason: contains not printable characters */
    public RecyclerView f2097;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4194 f2098;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f2099;

    /* renamed from: ՠ, reason: contains not printable characters */
    public LinearLayoutManager f2100;

    /* renamed from: ֈ, reason: contains not printable characters */
    public FilmStopView f2101;

    /* renamed from: ֏, reason: contains not printable characters */
    public ArrayList<String> f2102;

    /* renamed from: ׯ, reason: contains not printable characters */
    public ArrayList<String> f2103;

    /* renamed from: ؠ, reason: contains not printable characters */
    public SwitchButton f2104;

    /* renamed from: ހ, reason: contains not printable characters */
    public SwitchButton f2105;

    /* renamed from: ށ, reason: contains not printable characters */
    public FilmStopView f2106;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f2107;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f2108;

    /* renamed from: ބ, reason: contains not printable characters */
    public C4194 f2109;

    /* renamed from: ޅ, reason: contains not printable characters */
    public RecyclerView f2110;

    /* renamed from: ކ, reason: contains not printable characters */
    public LinearLayoutManager f2111;

    /* renamed from: އ, reason: contains not printable characters */
    public int f2112;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f2113;

    /* renamed from: މ, reason: contains not printable characters */
    public int f2114;

    /* renamed from: ފ, reason: contains not printable characters */
    public long f2115;

    /* renamed from: ދ, reason: contains not printable characters */
    public HorizontalScrollView f2116;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f2117;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f2118;

    /* renamed from: ގ, reason: contains not printable characters */
    public InterfaceC0894 f2119;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f2120;

    /* renamed from: ސ, reason: contains not printable characters */
    public boolean f2121;

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$Ϳ, reason: contains not printable characters */
    public class RunnableC0883 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2122;

        public RunnableC0883(String str) {
            this.f2122 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = FPSSettingView.this.f2096.f15832.getPaint().measureText(this.f2122);
            ViewGroup.LayoutParams layoutParams = FPSSettingView.this.f2096.f15832.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            Paint.FontMetrics fontMetrics = FPSSettingView.this.f2096.f15832.getPaint().getFontMetrics();
            layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
            FPSSettingView.this.f2096.f15832.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$Ԩ, reason: contains not printable characters */
    public class C0884 extends AbstractC4012 {
        public C0884() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            FPSSettingView.this.m2273();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$Ԫ, reason: contains not printable characters */
    public class C0885 implements AbstractC4975.InterfaceC4976 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f2125;

        public C0885() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            String str;
            int iFloatValue;
            if ((FPSSettingView.this.f2119 == null || FPSSettingView.this.f2119.mo2278()) && i != FPSSettingView.this.f2117 && System.currentTimeMillis() - this.f2125 >= 200) {
                this.f2125 = System.currentTimeMillis();
                C4196 c4196 = (C4196) FPSSettingView.this.f2099.get(FPSSettingView.this.f2117);
                C4196 c41962 = (C4196) FPSSettingView.this.f2099.get(i);
                c4196.setSelected(false);
                c4196.m13235().setSelected(false);
                c41962.setSelected(true);
                c41962.m13235().setSelected(true);
                C2334 c2334 = (C2334) FPSSettingView.this.f2097.findViewHolderForAdapterPosition(FPSSettingView.this.f2117);
                C2334 c23342 = (C2334) FPSSettingView.this.f2097.findViewHolderForAdapterPosition(i);
                FPSSettingView.this.f2117 = i;
                FPSSettingView.this.m2270();
                ArrayList<Float> arrayListM11228 = C3444.m11228();
                if (FPSSettingView.this.f2118 < 0 || !C3444.m11227().m11259()) {
                    str = "";
                    iFloatValue = 0;
                } else {
                    str = (String) FPSSettingView.this.f2102.get(FPSSettingView.this.f2118);
                    iFloatValue = (int) (arrayListM11228.get(FPSSettingView.this.f2118).floatValue() * 1000.0f);
                }
                if (FPSSettingView.this.f2119 != null) {
                    FPSSettingView.this.f2119.mo2280(c41962.m13235().m8464(), iFloatValue, str, c4196.m13235().getType());
                }
                if (c2334 != null) {
                    c2334.mo8729(false);
                }
                if (c23342 != null) {
                    c23342.mo8729(true);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$Ԭ, reason: contains not printable characters */
    public class C0886 implements AbstractC4975.InterfaceC4976 {
        public C0886() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            FPSSettingView.this.m2266(i);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$Ԯ, reason: contains not printable characters */
    public class C0887 implements FilmStopView.InterfaceC0908 {
        public C0887() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            FPSSettingView.this.f2118 = i;
            FPSSettingView fPSSettingView = FPSSettingView.this;
            fPSSettingView.m2272(fPSSettingView.f2118);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$ՠ, reason: contains not printable characters */
    public class C0888 implements FilmStopView.InterfaceC0908 {
        public C0888() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            FPSSettingView.this.f2118 = i;
            FPSSettingView fPSSettingView = FPSSettingView.this;
            fPSSettingView.m2272(fPSSettingView.f2118);
            FPSSettingView.this.m2268();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$ֈ, reason: contains not printable characters */
    public class C0889 implements SwitchButton.InterfaceC0969 {
        public C0889() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            if (z) {
                C3444.m11227().m11270(true);
                FPSSettingView fPSSettingView = FPSSettingView.this;
                fPSSettingView.m2272(fPSSettingView.f2118);
            } else {
                C3444.m11227().m11270(false);
                FPSSettingView.this.m2272(-1);
            }
            FPSSettingView.this.m2271(false);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$֏, reason: contains not printable characters */
    public class C0890 implements SwitchButton.InterfaceC0969 {
        public C0890() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            if (z) {
                C3444.m11227().m11270(true);
                FPSSettingView fPSSettingView = FPSSettingView.this;
                fPSSettingView.m2272(fPSSettingView.f2118);
            } else {
                C3444.m11227().m11270(false);
                FPSSettingView.this.m2272(-1);
            }
            FPSSettingView.this.m2271(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC0891 implements View.OnClickListener {
        public ViewOnClickListenerC0891() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC0892 implements View.OnClickListener {
        public ViewOnClickListenerC0892() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FPSSettingView.this.f2119 != null) {
                FPSSettingView.this.f2119.mo2279(FPSSettingView.this.f2107, FPSSettingView.this.f2108, false);
                C2618.m9570("fps_converted_sp", true);
                C2618.m9570("fps_direct_sp", true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$ހ, reason: contains not printable characters */
    public class RunnableC0893 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2134;

        public RunnableC0893(String str) {
            this.f2134 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = FPSSettingView.this.f2096.f15840.getPaint().measureText(this.f2134);
            ViewGroup.LayoutParams layoutParams = FPSSettingView.this.f2096.f15840.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            FPSSettingView.this.f2096.f15840.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSSettingView$ށ, reason: contains not printable characters */
    public interface InterfaceC0894 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo2277(int i, int i2, String str);

        /* renamed from: Ԩ, reason: contains not printable characters */
        boolean mo2278();

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo2279(boolean z, boolean z2, boolean z3);

        /* renamed from: Ԭ, reason: contains not printable characters */
        void mo2280(int i, int i2, String str, int i3);

        /* renamed from: ԯ, reason: contains not printable characters */
        void mo2281(int i, String str);
    }

    public FPSSettingView(@NonNull Context context) {
        this(context, null);
    }

    public int getCurrentChoosePos() {
        return this.f2117;
    }

    public int getFpsSize() {
        ArrayList<C4196> arrayList = this.f2099;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2120 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f2121) {
            return;
        }
        m2263(0, null);
    }

    public void setListPadding(ArrayList<C4196> arrayList) {
        int iM9450;
        int size;
        if (r1.m8139(arrayList) || arrayList.size() == 0 || (iM9450 = C2579.m9450(getContext()) - (this.f2114 * 2)) == 0) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14386());
        textPaint.setTypeface(FilmApp.m404());
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setTextSize(C4792.m14375().m14482());
        textPaint2.setTypeface(FilmApp.m404());
        int iMeasureText = (int) (textPaint2.measureText(getResources().getString(R.string.RECORDING_FPS_CONVERTED).toUpperCase()) + C4792.f16138 + C4792.m14375().m14476(50));
        int iMeasureText2 = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            String strM13232 = arrayList.get(i).m13232();
            iMeasureText2 = textPaint.measureText(strM13232) < ((float) iMeasureText) ? iMeasureText2 + iMeasureText : (int) (iMeasureText2 + textPaint.measureText(strM13232));
        }
        if ((C2579.m9438(C4062.f14090) * 2 * arrayList.size()) + iMeasureText2 < iM9450 || (size = (int) (((iM9450 - iMeasureText2) / arrayList.size()) / 2.0f)) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).m13248(size);
        }
    }

    public void setPadding(int i) {
        ConstraintLayout constraintLayout = this.f2096.f15826;
        if (constraintLayout != null) {
            constraintLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m2260(int i) {
        this.f2102.clear();
        this.f2103.clear();
        if (this.f2117 < this.f2099.size()) {
            int iM8464 = this.f2099.get(this.f2117).m13235().m8464();
            ArrayList<Float> arrayListM11228 = C3444.m11228();
            float fM12471 = C4535.m13880().m13890().m12471() / 1000.0f;
            if (i == 2) {
                Iterator<Float> it = arrayListM11228.iterator();
                while (it.hasNext()) {
                    float fFloatValue = it.next().floatValue();
                    int i2 = (int) fFloatValue;
                    float f = i2;
                    if (fFloatValue == f) {
                        Resources resources = getResources();
                        this.f2103.add(String.format(i2 > 1 ? resources.getString(R.string.RECORDING_FPS_TIMELAPSE_UNITS) : resources.getString(R.string.RECORDING_FPS_TIMELAPSE_UNIT), String.valueOf(i2)));
                        this.f2102.add(String.format("%s×", String.valueOf(i2 * iM8464)));
                    } else if (f == fFloatValue) {
                        Resources resources2 = getResources();
                        this.f2103.add(String.format(i2 > 1 ? resources2.getString(R.string.RECORDING_FPS_TIMELAPSE_UNITS) : resources2.getString(R.string.RECORDING_FPS_TIMELAPSE_UNIT), String.valueOf(i2)));
                        this.f2102.add(String.format("%s×", String.valueOf(i2 * iM8464)));
                    } else {
                        this.f2103.add(String.format(fFloatValue > 1.0f ? getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_UNITS) : getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_UNIT), String.valueOf(fFloatValue)));
                        float f2 = iM8464 * fFloatValue;
                        int i3 = (int) f2;
                        if (f2 == i3) {
                            this.f2102.add(String.format("%s×", String.valueOf(i3)));
                        } else {
                            this.f2102.add(String.format("%s×", String.valueOf(f2)));
                        }
                    }
                    if (fFloatValue == fM12471) {
                        this.f2118 = this.f2102.size() - 1;
                    }
                }
            } else {
                Iterator<Float> it2 = arrayListM11228.iterator();
                while (it2.hasNext()) {
                    float fFloatValue2 = it2.next().floatValue();
                    int i4 = (int) fFloatValue2;
                    if (fFloatValue2 == i4) {
                        this.f2102.add(String.format("%s×", String.valueOf(i4 * iM8464)));
                    } else {
                        float f3 = iM8464 * fFloatValue2;
                        int i5 = (int) f3;
                        if (i5 == f3) {
                            this.f2102.add(String.format("%s×", String.valueOf(i5)));
                        } else {
                            this.f2102.add(String.format("%s×", String.valueOf(f3)));
                        }
                    }
                    if (fFloatValue2 == fM12471) {
                        this.f2118 = this.f2102.size() - 1;
                    }
                }
            }
            if (this.f2095) {
                C4638.m14099("FPSSettingView", String.format("content : %s", this.f2102));
            }
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final String m2261(int i, int i2, float f) {
        float fFloatValue = new BigDecimal((((i * 1.0f) * 60.0f) / i2) / f).setScale(1, 4).floatValue();
        int i3 = (int) fFloatValue;
        if (fFloatValue == i3) {
            return i3 + "";
        }
        return fFloatValue + "";
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final int m2262(int i) {
        return C3444.m11227().m11260(i) ? 1 : 0;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m2263(int i, AbstractC4012 abstractC4012) {
        this.f2121 = false;
        C4008.m12886(this, 0.0f, this.f2120, i, abstractC4012);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m2264(Context context, AttributeSet attributeSet, int i) {
        float fM14447;
        AbstractC4653 abstractC4653 = (AbstractC4653) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_fps_setting, this, true);
        this.f2096 = abstractC4653;
        abstractC4653.f15826.getLayoutParams().height = C4792.m14375().m14405();
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f2096.f15827.getLayoutParams())).bottomMargin = C4792.m14375().m14408();
        this.f2096.f15827.m2562(0, C4792.m14375().m14381());
        AbstractC4653 abstractC46532 = this.f2096;
        this.f2097 = abstractC46532.f15837;
        this.f2101 = abstractC46532.f15839;
        this.f2104 = abstractC46532.f15838;
        this.f2105 = abstractC46532.f15831;
        this.f2106 = abstractC46532.f15833;
        this.f2110 = abstractC46532.f15830;
        this.f2116 = abstractC46532.f15829;
        int i2 = 150;
        if (C4792.m14375().m14498()) {
            fM14447 = C4792.m14375().m14447();
            i2 = (int) (150 / 2.0f);
        } else {
            fM14447 = 1.0f;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2104.getLayoutParams();
        float fM14434 = C4792.m14375().m14434();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (C4792.m14375().m14410() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (C4792.m14375().m14409() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (C4792.m14375().m14411() * fM14434);
        this.f2104.setTextSize(C4792.m14375().m14481() * fM14434);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2105.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (C4792.m14375().m14410() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (C4792.m14375().m14409() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) (C4792.m14375().m14411() * fM14434);
        this.f2105.setTextSize(C4792.m14375().m14481() * fM14434);
        this.f2105.setLayoutParams(layoutParams2);
        this.f2096.f15833.setTextColor(-1);
        this.f2096.f15833.m2327(0, C4792.m14375().m14386() * fM14434 * fM14447);
        TextPaint textPaint = new TextPaint();
        textPaint.setTypeface(FilmApp.m404());
        textPaint.setTextSize(C4792.m14375().m14386() * fM14434);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f2106.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) (C4792.m14375().m14476(100) * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) ((textPaint.measureText(getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_UNITS)) + C4792.m14375().m14476(i2) + (((ViewGroup.MarginLayoutParams) layoutParams3).height * 2)) * fM14447);
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = (int) (C4792.m14375().m14476(i2) * fM14434);
        this.f2106.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f2097.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = C4792.m14375().m14405();
        this.f2097.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f2116.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = C4792.m14375().m14405();
        this.f2116.setLayoutParams(layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f2110.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = C4792.m14375().m14405();
        this.f2110.setLayoutParams(layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f2096.f15841.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = C4792.m14375().m14386();
        this.f2096.f15841.setLayoutParams(layoutParams7);
        this.f2096.f15834.setContentTextColor(-1);
        this.f2096.f15834.m2562(0, C4792.m14375().m14482() * fM14434);
        this.f2096.f15832.setContentTextColor(-1);
        this.f2096.f15832.m2562(0, C4792.m14375().m14482() * fM14434);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f2096.f15835.getLayoutParams();
        int iM14476 = C4792.m14375().m14476(68);
        ((ViewGroup.MarginLayoutParams) layoutParams8).width = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams8).height = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin = C4792.m14375().m14476(30);
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = (int) (((((ViewGroup.MarginLayoutParams) layoutParams6).height - ((ViewGroup.MarginLayoutParams) layoutParams8).height) / 2.0f) - C4792.m14375().m14476(20));
        this.f2096.f15835.setLayoutParams(layoutParams8);
        this.f2114 = C2579.m9438(44.0f);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f2096.f15836.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = (int) (((ViewGroup.MarginLayoutParams) layoutParams8).topMargin - ((C2579.m9438(44.0f) - ((ViewGroup.MarginLayoutParams) layoutParams8).height) / 2.0f));
        this.f2096.f15836.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f2096.f15834.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = ((int) this.f2096.f15832.getPaint().measureText(getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_CALCULATION).toUpperCase())) + 8;
        ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = (int) (((((ViewGroup.MarginLayoutParams) layoutParams2).height - fM14434) - ((ViewGroup.MarginLayoutParams) layoutParams3).height) / 2.0f);
        this.f2096.f15834.setLayoutParams(layoutParams10);
        ViewGroup.LayoutParams layoutParams11 = this.f2096.f15832.getLayoutParams();
        layoutParams11.width = (int) this.f2096.f15832.getPaint().measureText(getResources().getString(R.string.RECORDING_FPS_TIMELAPSE).toUpperCase());
        this.f2096.f15832.setLayoutParams(layoutParams11);
        this.f2096.f15840.setContentTextColor(-1);
        this.f2096.f15840.m2562(0, C4792.m14375().m14482() * fM14434);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f2096.f15839.getLayoutParams();
        int iM14499 = C4792.m14375().m14499("12.5×");
        int iM144992 = C4792.m14375().m14499("125×");
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = (int) (C4792.m14375().m14476(100) * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams12).leftMargin = (int) (C4792.m14375().m14476(85) * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams12).rightMargin = (int) (C4792.m14375().m14476(85) * fM14434);
        int i3 = (int) ((iM14499 * fM14434) + (r3 * 2) + (10.0f * fM14434));
        if (this.f2095) {
            C4638.m14099("FPSSettingView", String.format("textMaxWidth : %s , textMaxWidth2 : %s , width : %s ", Integer.valueOf(iM14499), Integer.valueOf(iM144992), Integer.valueOf(i3)));
        }
        ((ViewGroup.MarginLayoutParams) layoutParams12).width = (int) (C4792.m14375().m14476(440) * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin = (int) (C4792.m14375().m14476(13) * fM14434);
        this.f2096.f15839.setLayoutParams(layoutParams12);
        this.f2096.f15839.setTextColor(-1);
        this.f2096.f15839.m2327(0, C4792.m14375().m14386());
        this.f2102 = new ArrayList<>();
        this.f2103 = new ArrayList<>();
        ArrayList<C4196> arrayList = new ArrayList<>();
        this.f2099 = arrayList;
        this.f2098 = new C4194(context, arrayList, new C0885());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.f2100 = linearLayoutManager;
        this.f2097.setLayoutManager(linearLayoutManager);
        this.f2097.setAdapter(this.f2098);
        this.f2109 = new C4194(context, this.f2099, new C0886());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context, 0, false);
        this.f2111 = linearLayoutManager2;
        this.f2110.setLayoutManager(linearLayoutManager2);
        this.f2110.setNestedScrollingEnabled(false);
        this.f2110.setAdapter(this.f2109);
        this.f2101.setOnStopClick(new C0887());
        this.f2106.setOnStopClick(new C0888());
        this.f2104.setOnCheckedChangeListener(new C0889());
        this.f2105.setOnCheckedChangeListener(new C0890());
        setOnClickListener(new ViewOnClickListenerC0891());
        m2273();
        this.f2096.f15836.setOnClickListener(new ViewOnClickListenerC0892());
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean m2265() {
        return this.f2121;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m2266(int i) {
        InterfaceC0894 interfaceC0894;
        String str;
        int iFloatValue;
        InterfaceC0894 interfaceC08942;
        InterfaceC0894 interfaceC08943 = this.f2119;
        if ((interfaceC08943 == null || interfaceC08943.mo2278()) && i != this.f2117 && System.currentTimeMillis() - this.f2115 >= 200) {
            this.f2115 = System.currentTimeMillis();
            C4196 c4196 = this.f2099.get(this.f2117);
            C4196 c41962 = this.f2099.get(i);
            v5 v5VarM13235 = c41962.m13235();
            if (v5VarM13235.getType() == 1) {
                if (!C2618.m9565("fps_converted_sp", false) && (interfaceC08942 = this.f2119) != null) {
                    interfaceC08942.mo2279(true, false, true);
                    C2618.m9570("fps_converted_sp", true);
                    this.f2113 = this.f2117;
                    this.f2117 = i;
                    return;
                }
            } else if (v5VarM13235.getType() == 2 && !C2618.m9565("fps_direct_sp", false) && (interfaceC0894 = this.f2119) != null) {
                interfaceC0894.mo2279(false, true, true);
                C2618.m9570("fps_direct_sp", true);
                this.f2113 = this.f2117;
                this.f2117 = i;
                return;
            }
            c4196.setSelected(false);
            c4196.m13235().setSelected(false);
            c41962.setSelected(true);
            c41962.m13235().setSelected(true);
            C3769 c3769 = (C3769) this.f2110.findViewHolderForAdapterPosition(this.f2117);
            C3769 c37692 = (C3769) this.f2110.findViewHolderForAdapterPosition(i);
            this.f2117 = i;
            this.f2112 = c41962.m13235().getType();
            m2270();
            ArrayList<Float> arrayListM11228 = C3444.m11228();
            if (this.f2118 < 0 || !C3444.m11227().m11259() || this.f2112 == 2) {
                str = "";
                iFloatValue = 0;
            } else {
                str = this.f2102.get(this.f2118);
                iFloatValue = (int) (arrayListM11228.get(this.f2118).floatValue() * 1000.0f);
            }
            InterfaceC0894 interfaceC08944 = this.f2119;
            if (interfaceC08944 != null) {
                interfaceC08944.mo2280(c41962.m13235().m8464(), iFloatValue, str, c41962.m13235().getType());
            }
            if (c3769 != null) {
                c3769.mo8729(false);
            }
            if (c37692 != null) {
                c37692.mo8729(true);
            }
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m2267() {
        String str;
        int iFloatValue;
        InterfaceC0894 interfaceC0894 = this.f2119;
        if (interfaceC0894 == null || !interfaceC0894.mo2278()) {
            return;
        }
        C4196 c4196 = this.f2099.get(this.f2113);
        C4196 c41962 = this.f2099.get(this.f2117);
        c4196.setSelected(false);
        c4196.m13235().setSelected(false);
        c41962.setSelected(true);
        c41962.m13235().setSelected(true);
        C3769 c3769 = (C3769) this.f2110.findViewHolderForAdapterPosition(this.f2113);
        C3769 c37692 = (C3769) this.f2110.findViewHolderForAdapterPosition(this.f2117);
        this.f2112 = c41962.m13235().getType();
        m2270();
        ArrayList<Float> arrayListM11228 = C3444.m11228();
        if (this.f2118 < 0 || !C3444.m11227().m11259() || this.f2112 == 2) {
            str = "";
            iFloatValue = 0;
        } else {
            str = this.f2102.get(this.f2118);
            iFloatValue = (int) (arrayListM11228.get(this.f2118).floatValue() * 1000.0f);
        }
        InterfaceC0894 interfaceC08942 = this.f2119;
        if (interfaceC08942 != null) {
            interfaceC08942.mo2280(c41962.m13235().m8464(), iFloatValue, str, c41962.m13235().getType());
        }
        if (c3769 != null) {
            c3769.mo8729(false);
        }
        if (c37692 != null) {
            c37692.mo8729(true);
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m2268() {
        ArrayList<v5> arrayListM11248 = C3444.m11227().m11248();
        if (r1.m8144(arrayListM11248)) {
            this.f2096.f15834.m2561(String.format(getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_CALCULATION), "5", m2261(5, arrayListM11248.get(this.f2117).m8464(), C3444.m11228().get(this.f2118).floatValue())));
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m2269(int i) {
        this.f2096.f15826.getLayoutParams().height = i;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m2270() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        c3891M13890.m12460();
        int iM12485 = c3891M13890.m12485();
        m2260(iM12485);
        if (iM12485 == 2) {
            this.f2106.setStringDataList(this.f2103);
            int size = this.f2103.size();
            int i = this.f2118;
            if (size > i && i != -1) {
                this.f2106.setCurrentI(i);
            }
            m2268();
        } else {
            this.f2101.setStringDataList(this.f2102);
            int size2 = this.f2102.size();
            int i2 = this.f2118;
            if (size2 > i2 && i2 != -1) {
                this.f2101.setCurrentI(i2);
            }
        }
        m2271(false);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m2271(boolean z) {
        int iM12485 = C4535.m13880().m13890().m12485();
        if (!C3444.m11227().m11259()) {
            if (iM12485 != 2) {
                this.f2101.m2318();
                this.f2104.setChecked(false);
                return;
            }
            if (this.f2112 == 2) {
                this.f2105.m2630(false, false);
                this.f2106.m2318();
                this.f2105.setAlpha(C4792.m14375().m14416());
                this.f2096.f15832.setAlpha(C4792.m14375().m14416());
                this.f2105.setEnabled(false);
                this.f2096.f15834.setAlpha(C4792.m14375().m14416());
                return;
            }
            this.f2105.setEnabled(true);
            this.f2105.setAlpha(1.0f);
            this.f2105.m2630(z, false);
            this.f2096.f15832.setAlpha(1.0f);
            this.f2106.m2318();
            this.f2096.f15834.setAlpha(C4792.m14375().m14416());
            return;
        }
        if (iM12485 != 2) {
            this.f2101.m2320();
            this.f2104.setChecked(true);
            return;
        }
        if (this.f2112 != 2) {
            this.f2105.setEnabled(true);
            this.f2105.setAlpha(1.0f);
            this.f2105.m2630(z, true);
            this.f2096.f15832.setAlpha(1.0f);
            this.f2106.m2320();
            this.f2096.f15834.setAlpha(1.0f);
            return;
        }
        this.f2105.m2630(false, false);
        this.f2106.m2318();
        this.f2105.setAlpha(C4792.m14375().m14416());
        this.f2105.setEnabled(false);
        this.f2096.f15834.setAlpha(C4792.m14375().m14416());
        this.f2096.f15832.setAlpha(C4792.m14375().m14416());
        C3444.m11227().m11270(false);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m2272(int i) {
        ArrayList<Float> arrayListM11228 = C3444.m11228();
        InterfaceC0894 interfaceC0894 = this.f2119;
        if (interfaceC0894 != null) {
            if (i < 0) {
                interfaceC0894.mo2281(0, "");
                return;
            }
            String str = this.f2102.get(i);
            this.f2119.mo2281((int) (arrayListM11228.get(i).floatValue() * 1000.0f), str);
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m2273() {
        String str;
        int iFloatValue;
        String upperCase = getContext().getString(R.string.RECORDING_FPS_TIMELAPSE).toUpperCase();
        this.f2096.f15840.m2561(upperCase);
        this.f2096.f15840.post(new RunnableC0893(upperCase));
        this.f2096.f15832.post(new RunnableC0883(upperCase));
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12460 = c3891M13890.m12460();
        int iM12485 = c3891M13890.m12485();
        ArrayList<v5> arrayListM11248 = C3444.m11227().m11248();
        this.f2099.clear();
        this.f2117 = 0;
        if (iM12485 == 2) {
            this.f2107 = false;
            this.f2108 = false;
            for (int i = 0; i < arrayListM11248.size(); i++) {
                v5 v5Var = arrayListM11248.get(i);
                C4196 c4196 = new C4196();
                c4196.setItemViewType(4);
                if (v5Var.getType() == 1) {
                    this.f2107 = true;
                }
                if (v5Var.getType() == 2) {
                    this.f2108 = true;
                }
                v5Var.m8469(m2262(v5Var.m8464()));
                c4196.m13253(v5Var);
                if (v5Var.isSelected()) {
                    c4196.setSelected(true);
                    this.f2117 = i;
                    this.f2112 = v5Var.getType();
                }
                c4196.m13251(String.valueOf(v5Var.m8464()));
                this.f2099.add(c4196);
            }
            this.f2109.notifyDataSetChanged();
        } else {
            for (int i2 = 0; i2 < arrayListM11248.size(); i2++) {
                v5 v5Var2 = arrayListM11248.get(i2);
                C4196 c41962 = new C4196();
                c41962.m13253(v5Var2);
                if (v5Var2.isSelected()) {
                    c41962.setSelected(true);
                    this.f2117 = i2;
                }
                c41962.m13251(String.valueOf(v5Var2.m8464()));
                this.f2099.add(c41962);
            }
            this.f2098.notifyDataSetChanged();
        }
        m2270();
        if (this.f2119 != null && this.f2099.size() > 0) {
            C4196 c41963 = this.f2099.get(this.f2117);
            ArrayList<Float> arrayListM11228 = C3444.m11228();
            if (this.f2118 < 0 || !C3444.m11227().m11259()) {
                str = "";
                iFloatValue = 0;
            } else {
                str = this.f2102.get(this.f2118);
                iFloatValue = (int) (arrayListM11228.get(this.f2118).floatValue() * 1000.0f);
            }
            this.f2119.mo2277(c41963.m13235().m8464(), iFloatValue, str);
        }
        if (iM12485 == 2) {
            this.f2096.f15840.setVisibility(8);
            this.f2096.f15838.setVisibility(8);
            this.f2096.f15839.setVisibility(8);
            this.f2096.f15828.setVisibility(0);
            if (this.f2107 || this.f2108) {
                m2276(true);
            } else {
                m2276(false);
            }
            this.f2096.f15830.setVisibility(0);
            this.f2096.f15837.setVisibility(8);
            m2269(C4792.m14375().m14406());
            return;
        }
        if (iM12460 == 1) {
            this.f2096.f15840.setVisibility(8);
            this.f2096.f15838.setVisibility(8);
            this.f2096.f15839.setVisibility(8);
            this.f2096.f15828.setVisibility(8);
            m2276(false);
            this.f2096.f15830.setVisibility(8);
            this.f2096.f15837.setVisibility(0);
            m2269(C4792.m14375().m14405());
            return;
        }
        this.f2096.f15840.setVisibility(0);
        this.f2096.f15838.setVisibility(0);
        this.f2096.f15839.setVisibility(0);
        this.f2096.f15828.setVisibility(8);
        m2276(false);
        this.f2096.f15830.setVisibility(8);
        this.f2096.f15837.setVisibility(0);
        m2269(C4792.m14375().m14405());
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public FPSSettingView m2274(InterfaceC0894 interfaceC0894) {
        this.f2119 = interfaceC0894;
        return this;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m2275(int i) {
        this.f2121 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C0884());
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m2276(boolean z) {
        int i = z ? 0 : 8;
        this.f2096.f15841.setVisibility(i);
        this.f2096.f15835.setVisibility(i);
        this.f2096.f15836.setVisibility(i);
    }

    public FPSSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FPSSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2095 = true;
        this.f2107 = true;
        this.f2108 = true;
        this.f2118 = 0;
        m2264(context, attributeSet, i);
    }
}
