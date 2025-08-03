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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.adapter.layout_manager.AutoLineFeedLayoutManager;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4917;
import defpackage.AbstractC4975;
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
public class FPSPortraitSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f2067;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AbstractC4917 f2068;

    /* renamed from: ԭ, reason: contains not printable characters */
    public ArrayList<C4196> f2069;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<String> f2070;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<String> f2071;

    /* renamed from: ՠ, reason: contains not printable characters */
    public SwitchButton f2072;

    /* renamed from: ֈ, reason: contains not printable characters */
    public FilmStopView f2073;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f2074;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f2075;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C4194 f2076;

    /* renamed from: ހ, reason: contains not printable characters */
    public RecyclerView f2077;

    /* renamed from: ށ, reason: contains not printable characters */
    public AutoLineFeedLayoutManager f2078;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f2079;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f2080;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f2081;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f2082;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f2083;

    /* renamed from: އ, reason: contains not printable characters */
    public int f2084;

    /* renamed from: ވ, reason: contains not printable characters */
    public InterfaceC0882 f2085;

    /* renamed from: މ, reason: contains not printable characters */
    public int f2086;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f2087;

    /* renamed from: com.blink.academy.film.widgets.FPSPortraitSettingView$Ϳ, reason: contains not printable characters */
    public class C0876 implements AbstractC4975.InterfaceC4976 {
        public C0876() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            FPSPortraitSettingView.this.m2229(i);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSPortraitSettingView$Ԩ, reason: contains not printable characters */
    public class C0877 implements FilmStopView.InterfaceC0908 {
        public C0877() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            FPSPortraitSettingView.this.f2084 = i;
            FPSPortraitSettingView fPSPortraitSettingView = FPSPortraitSettingView.this;
            fPSPortraitSettingView.m2236(fPSPortraitSettingView.f2084);
            FPSPortraitSettingView.this.m2232();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSPortraitSettingView$Ԫ, reason: contains not printable characters */
    public class C0878 implements SwitchButton.InterfaceC0969 {
        public C0878() {
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
                FPSPortraitSettingView fPSPortraitSettingView = FPSPortraitSettingView.this;
                fPSPortraitSettingView.m2236(fPSPortraitSettingView.f2084);
            } else {
                C3444.m11227().m11270(false);
                FPSPortraitSettingView.this.m2236(-1);
            }
            FPSPortraitSettingView.this.m2235(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSPortraitSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC0879 implements View.OnClickListener {
        public ViewOnClickListenerC0879() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSPortraitSettingView$Ԯ, reason: contains not printable characters */
    public class RunnableC0880 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f2092;

        public RunnableC0880(String str) {
            this.f2092 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = FPSPortraitSettingView.this.f2068.f16596.getPaint().measureText(this.f2092);
            ViewGroup.LayoutParams layoutParams = FPSPortraitSettingView.this.f2068.f16596.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            Paint.FontMetrics fontMetrics = FPSPortraitSettingView.this.f2068.f16596.getPaint().getFontMetrics();
            layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
            FPSPortraitSettingView.this.f2068.f16596.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSPortraitSettingView$ՠ, reason: contains not printable characters */
    public class C0881 extends AbstractC4012 {
        public C0881() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FPSPortraitSettingView$ֈ, reason: contains not printable characters */
    public interface InterfaceC0882 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo2240(int i, int i2, String str);

        /* renamed from: Ԩ, reason: contains not printable characters */
        boolean mo2241();

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo2242(boolean z, boolean z2, boolean z3);

        /* renamed from: Ԭ, reason: contains not printable characters */
        void mo2243(int i, int i2, String str, int i3);

        /* renamed from: ԯ, reason: contains not printable characters */
        void mo2244(int i, String str);
    }

    public FPSPortraitSettingView(@NonNull Context context) {
        this(context, null);
    }

    public int getCurrentChoosePos() {
        return this.f2083;
    }

    public int getFpsSize() {
        ArrayList<C4196> arrayList = this.f2069;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2086 = (int) (i2 + ((C2579.m9444() - C2579.m9439(getContext())) / 2.0f));
        if (this.f2087) {
            return;
        }
        m2226(0, null);
    }

    public void setListPadding(ArrayList<C4196> arrayList) {
        int iM9450;
        int size;
        if (r1.m8139(arrayList) || arrayList.size() == 0 || (iM9450 = C2579.m9450(getContext()) - (this.f2081 * 2)) == 0) {
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
        ConstraintLayout constraintLayout = this.f2068.f16591;
        if (constraintLayout != null) {
            constraintLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2223(int i) {
        this.f2070.clear();
        this.f2071.clear();
        if (this.f2083 < this.f2069.size()) {
            int iM8464 = this.f2069.get(this.f2083).m13235().m8464();
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
                        this.f2071.add(String.format(i2 > 1 ? resources.getString(R.string.RECORDING_FPS_TIMELAPSE_UNITS) : resources.getString(R.string.RECORDING_FPS_TIMELAPSE_UNIT), String.valueOf(i2)));
                        this.f2070.add(String.format("%s×", String.valueOf(i2 * iM8464)));
                    } else if (f == fFloatValue) {
                        Resources resources2 = getResources();
                        this.f2071.add(String.format(i2 > 1 ? resources2.getString(R.string.RECORDING_FPS_TIMELAPSE_UNITS) : resources2.getString(R.string.RECORDING_FPS_TIMELAPSE_UNIT), String.valueOf(i2)));
                        this.f2070.add(String.format("%s×", String.valueOf(i2 * iM8464)));
                    } else {
                        this.f2071.add(String.format(fFloatValue > 1.0f ? getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_UNITS) : getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_UNIT), String.valueOf(fFloatValue)));
                        float f2 = iM8464 * fFloatValue;
                        int i3 = (int) f2;
                        if (f2 == i3) {
                            this.f2070.add(String.format("%s×", String.valueOf(i3)));
                        } else {
                            this.f2070.add(String.format("%s×", String.valueOf(f2)));
                        }
                    }
                    if (fFloatValue == fM12471) {
                        this.f2084 = this.f2070.size() - 1;
                    }
                }
            } else {
                Iterator<Float> it2 = arrayListM11228.iterator();
                while (it2.hasNext()) {
                    float fFloatValue2 = it2.next().floatValue();
                    int i4 = (int) fFloatValue2;
                    if (fFloatValue2 == i4) {
                        this.f2070.add(String.format("%s×", String.valueOf(i4 * iM8464)));
                    } else {
                        float f3 = iM8464 * fFloatValue2;
                        int i5 = (int) f3;
                        if (i5 == f3) {
                            this.f2070.add(String.format("%s×", String.valueOf(i5)));
                        } else {
                            this.f2070.add(String.format("%s×", String.valueOf(f3)));
                        }
                    }
                    if (fFloatValue2 == fM12471) {
                        this.f2084 = this.f2070.size() - 1;
                    }
                }
            }
            if (this.f2067) {
                C4638.m14099("FPSSettingView", String.format("content : %s", this.f2070));
            }
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String m2224(int i, int i2, float f) {
        float fFloatValue = new BigDecimal((((i * 1.0f) * 60.0f) / i2) / f).setScale(1, 4).floatValue();
        int i3 = (int) fFloatValue;
        if (fFloatValue == i3) {
            return i3 + "";
        }
        return fFloatValue + "";
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int m2225(int i) {
        return C3444.m11227().m11260(i) ? 1 : 0;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2226(int i, AbstractC4012 abstractC4012) {
        this.f2087 = false;
        C4008.m12886(this, 0.0f, this.f2086, i, abstractC4012);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m2227(Context context, AttributeSet attributeSet, int i) {
        float fM14447;
        AbstractC4917 abstractC4917 = (AbstractC4917) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_fps_portrait_setting, this, true);
        this.f2068 = abstractC4917;
        abstractC4917.f16591.getLayoutParams().height = C4792.m14375().m14405();
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f2068.f16592.getLayoutParams())).bottomMargin = C4792.m14375().m14408();
        this.f2068.f16592.m2562(0, C4792.m14375().m14381());
        AbstractC4917 abstractC49172 = this.f2068;
        this.f2072 = abstractC49172.f16595;
        this.f2073 = abstractC49172.f16597;
        this.f2077 = abstractC49172.f16594;
        int i2 = 150;
        if (C4792.m14375().m14498()) {
            fM14447 = C4792.m14375().m14447();
            i2 = (int) (150 / 2.0f);
        } else {
            fM14447 = 1.0f;
        }
        float fM14434 = C4792.m14375().m14434();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2072.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (C4792.m14375().m14410() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (C4792.m14375().m14409() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (C4792.m14375().m14411() * fM14434);
        this.f2072.setTextSize(C4792.m14375().m14481() * fM14434);
        this.f2072.setLayoutParams(layoutParams);
        this.f2068.f16597.setTextColor(-1);
        this.f2068.f16597.m2327(0, C4792.m14375().m14386() * fM14434 * fM14447);
        TextPaint textPaint = new TextPaint();
        textPaint.setTypeface(FilmApp.m404());
        textPaint.setTextSize(C4792.m14375().m14386() * fM14434);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2073.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (C4792.m14375().m14476(100) * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) ((textPaint.measureText(getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_UNITS)) + C4792.m14375().m14476(i2) + (((ViewGroup.MarginLayoutParams) layoutParams2).height * 2)) * fM14447);
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = (int) (C4792.m14375().m14476(i2) * fM14447 * fM14434);
        this.f2073.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f2077.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = C4792.m14375().m14406();
        this.f2077.setLayoutParams(layoutParams3);
        this.f2068.f16598.setContentTextColor(-1);
        this.f2068.f16598.m2562(0, C4792.m14375().m14482() * fM14434);
        this.f2068.f16596.setContentTextColor(-1);
        this.f2068.f16596.m2562(0, C4792.m14375().m14482() * fM14434);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f2068.f16598.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = ((int) this.f2068.f16596.getPaint().measureText(getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_CALCULATION).toUpperCase())) + 8;
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = (int) (((((ViewGroup.MarginLayoutParams) layoutParams).height - fM14434) - ((ViewGroup.MarginLayoutParams) layoutParams2).height) / 2.0f);
        this.f2068.f16598.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.f2068.f16596.getLayoutParams();
        layoutParams5.width = (int) this.f2068.f16596.getPaint().measureText(getResources().getString(R.string.RECORDING_FPS_TIMELAPSE).toUpperCase());
        this.f2068.f16596.setLayoutParams(layoutParams5);
        this.f2068.f16593.setPadding(C2579.m9438(15.0f), 0, C2579.m9438(15.0f), 0);
        C4792.m14375().m14499("12.5×");
        C4792.m14375().m14499("125×");
        this.f2070 = new ArrayList<>();
        this.f2071 = new ArrayList<>();
        ArrayList<C4196> arrayList = new ArrayList<>();
        this.f2069 = arrayList;
        this.f2076 = new C4194(context, arrayList, new C0876());
        AutoLineFeedLayoutManager autoLineFeedLayoutManager = new AutoLineFeedLayoutManager();
        this.f2078 = autoLineFeedLayoutManager;
        this.f2077.setLayoutManager(autoLineFeedLayoutManager);
        this.f2077.setAdapter(this.f2076);
        this.f2073.setOnStopClick(new C0877());
        this.f2072.setOnCheckedChangeListener(new C0878());
        setOnClickListener(new ViewOnClickListenerC0879());
        m2237();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean m2228() {
        return this.f2087;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m2229(int i) {
        InterfaceC0882 interfaceC0882;
        InterfaceC0882 interfaceC08822;
        String str;
        int iFloatValue;
        InterfaceC0882 interfaceC08823;
        if ((this.f2075 || this.f2074) && i == this.f2069.size() - 1 && (interfaceC0882 = this.f2085) != null) {
            interfaceC0882.mo2242(this.f2074, this.f2075, false);
            C2618.m9570("fps_converted_sp", true);
            C2618.m9570("fps_direct_sp", true);
            return;
        }
        InterfaceC0882 interfaceC08824 = this.f2085;
        if ((interfaceC08824 == null || interfaceC08824.mo2241()) && i != this.f2083 && System.currentTimeMillis() - this.f2082 >= 200) {
            this.f2082 = System.currentTimeMillis();
            C4196 c4196 = this.f2069.get(this.f2083);
            C4196 c41962 = this.f2069.get(i);
            v5 v5VarM13235 = c41962.m13235();
            if (v5VarM13235.getType() == 1) {
                if (!C2618.m9565("fps_converted_sp", false) && (interfaceC08823 = this.f2085) != null) {
                    interfaceC08823.mo2242(true, false, true);
                    C2618.m9570("fps_converted_sp", true);
                    this.f2080 = this.f2083;
                    this.f2083 = i;
                    return;
                }
            } else if (v5VarM13235.getType() == 2 && !C2618.m9565("fps_direct_sp", false) && (interfaceC08822 = this.f2085) != null) {
                interfaceC08822.mo2242(false, true, true);
                C2618.m9570("fps_direct_sp", true);
                this.f2080 = this.f2083;
                this.f2083 = i;
                return;
            }
            c4196.setSelected(false);
            c4196.m13235().setSelected(false);
            c41962.setSelected(true);
            c41962.m13235().setSelected(true);
            C3769 c3769 = (C3769) this.f2077.findViewHolderForAdapterPosition(this.f2083);
            C3769 c37692 = (C3769) this.f2077.findViewHolderForAdapterPosition(i);
            this.f2083 = i;
            this.f2079 = c41962.m13235().getType();
            m2234();
            ArrayList<Float> arrayListM11228 = C3444.m11228();
            if (this.f2084 < 0 || !C3444.m11227().m11259() || this.f2079 == 2) {
                str = "";
                iFloatValue = 0;
            } else {
                str = this.f2070.get(this.f2084);
                iFloatValue = (int) (arrayListM11228.get(this.f2084).floatValue() * 1000.0f);
            }
            InterfaceC0882 interfaceC08825 = this.f2085;
            if (interfaceC08825 != null) {
                interfaceC08825.mo2243(c41962.m13235().m8464(), iFloatValue, str, c41962.m13235().getType());
            }
            if (c3769 != null) {
                c3769.mo8729(false);
            }
            if (c37692 != null) {
                c37692.mo8729(true);
            }
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m2230() {
        String str;
        int iFloatValue;
        InterfaceC0882 interfaceC0882 = this.f2085;
        if (interfaceC0882 == null || !interfaceC0882.mo2241()) {
            return;
        }
        C4196 c4196 = this.f2069.get(this.f2080);
        C4196 c41962 = this.f2069.get(this.f2083);
        c4196.setSelected(false);
        c4196.m13235().setSelected(false);
        c41962.setSelected(true);
        c41962.m13235().setSelected(true);
        C3769 c3769 = (C3769) this.f2077.findViewHolderForAdapterPosition(this.f2080);
        C3769 c37692 = (C3769) this.f2077.findViewHolderForAdapterPosition(this.f2083);
        this.f2079 = c41962.m13235().getType();
        m2234();
        ArrayList<Float> arrayListM11228 = C3444.m11228();
        if (this.f2084 < 0 || !C3444.m11227().m11259() || this.f2079 == 2) {
            str = "";
            iFloatValue = 0;
        } else {
            str = this.f2070.get(this.f2084);
            iFloatValue = (int) (arrayListM11228.get(this.f2084).floatValue() * 1000.0f);
        }
        InterfaceC0882 interfaceC08822 = this.f2085;
        if (interfaceC08822 != null) {
            interfaceC08822.mo2243(c41962.m13235().m8464(), iFloatValue, str, c41962.m13235().getType());
        }
        if (c3769 != null) {
            c3769.mo8729(false);
        }
        if (c37692 != null) {
            c37692.mo8729(true);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m2231(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2077.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i;
        this.f2077.setLayoutParams(layoutParams);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m2232() {
        ArrayList<v5> arrayListM11248 = C3444.m11227().m11248();
        if (r1.m8144(arrayListM11248)) {
            this.f2068.f16598.m2561(String.format(getResources().getString(R.string.RECORDING_FPS_TIMELAPSE_CALCULATION), "5", m2224(5, arrayListM11248.get(this.f2083).m8464(), C3444.m11228().get(this.f2084).floatValue())));
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m2233(int i) {
        this.f2068.f16591.getLayoutParams().height = i;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m2234() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        c3891M13890.m12460();
        int iM12485 = c3891M13890.m12485();
        m2223(iM12485);
        if (iM12485 == 2) {
            this.f2073.setStringDataList(this.f2071);
            int size = this.f2071.size();
            int i = this.f2084;
            if (size > i && i != -1) {
                this.f2073.setCurrentI(i);
            }
            m2232();
        }
        m2235(false);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m2235(boolean z) {
        int iM12485 = C4535.m13880().m13890().m12485();
        if (!C3444.m11227().m11259()) {
            if (iM12485 == 2) {
                if (this.f2079 == 2) {
                    this.f2072.m2630(false, false);
                    this.f2073.m2318();
                    this.f2072.setAlpha(C4792.m14375().m14416());
                    this.f2068.f16596.setAlpha(C4792.m14375().m14416());
                    this.f2072.setEnabled(false);
                    this.f2068.f16598.setAlpha(C4792.m14375().m14416());
                    return;
                }
                this.f2072.setEnabled(true);
                this.f2072.setAlpha(1.0f);
                this.f2072.m2630(z, false);
                this.f2068.f16596.setAlpha(1.0f);
                this.f2073.m2318();
                this.f2068.f16598.setAlpha(C4792.m14375().m14416());
                return;
            }
            return;
        }
        if (iM12485 == 2) {
            if (this.f2079 != 2) {
                this.f2072.setEnabled(true);
                this.f2072.setAlpha(1.0f);
                this.f2072.m2630(z, true);
                this.f2068.f16596.setAlpha(1.0f);
                this.f2073.m2320();
                this.f2068.f16598.setAlpha(1.0f);
                return;
            }
            this.f2072.m2630(false, false);
            this.f2073.m2318();
            this.f2072.setAlpha(C4792.m14375().m14416());
            this.f2072.setEnabled(false);
            this.f2068.f16598.setAlpha(C4792.m14375().m14416());
            this.f2068.f16596.setAlpha(C4792.m14375().m14416());
            C3444.m11227().m11270(false);
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m2236(int i) {
        ArrayList<Float> arrayListM11228 = C3444.m11228();
        InterfaceC0882 interfaceC0882 = this.f2085;
        if (interfaceC0882 != null) {
            if (i < 0) {
                interfaceC0882.mo2244(0, "");
                return;
            }
            String str = this.f2070.get(i);
            this.f2085.mo2244((int) (arrayListM11228.get(i).floatValue() * 1000.0f), str);
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m2237() {
        String str;
        int iFloatValue;
        this.f2068.f16596.post(new RunnableC0880(getContext().getString(R.string.RECORDING_FPS_TIMELAPSE).toUpperCase()));
        C3891 c3891M13890 = C4535.m13880().m13890();
        c3891M13890.m12460();
        int iM12485 = c3891M13890.m12485();
        ArrayList<v5> arrayListM11248 = C3444.m11227().m11248();
        this.f2069.clear();
        this.f2083 = 0;
        if (iM12485 == 2) {
            this.f2074 = false;
            this.f2075 = false;
            for (int i = 0; i < arrayListM11248.size(); i++) {
                v5 v5Var = arrayListM11248.get(i);
                C4196 c4196 = new C4196();
                c4196.setItemViewType(4);
                if (v5Var.getType() == 1) {
                    this.f2074 = true;
                }
                if (v5Var.getType() == 2) {
                    this.f2075 = true;
                }
                v5Var.m8469(m2225(v5Var.m8464()));
                c4196.m13253(v5Var);
                if (v5Var.isSelected()) {
                    c4196.setSelected(true);
                    this.f2083 = i;
                    this.f2079 = v5Var.getType();
                }
                c4196.m13251(String.valueOf(v5Var.m8464()));
                this.f2069.add(c4196);
            }
            if (this.f2074 || this.f2075) {
                C4196 c41962 = new C4196();
                c41962.setItemViewType(8);
                v5 v5Var2 = new v5();
                v5Var2.m8467(R.drawable.icon_30_info);
                c41962.m13253(v5Var2);
                this.f2069.add(c41962);
            }
            this.f2076.notifyDataSetChanged();
        } else {
            for (int i2 = 0; i2 < arrayListM11248.size(); i2++) {
                v5 v5Var3 = arrayListM11248.get(i2);
                C4196 c41963 = new C4196();
                c41963.m13253(v5Var3);
                if (v5Var3.isSelected()) {
                    c41963.setSelected(true);
                    this.f2083 = i2;
                }
                c41963.m13251(String.valueOf(v5Var3.m8464()));
                this.f2069.add(c41963);
            }
        }
        m2234();
        if (this.f2085 != null && this.f2069.size() > 0) {
            C4196 c41964 = this.f2069.get(this.f2083);
            ArrayList<Float> arrayListM11228 = C3444.m11228();
            if (this.f2084 < 0 || !C3444.m11227().m11259()) {
                str = "";
                iFloatValue = 0;
            } else {
                str = this.f2070.get(this.f2084);
                iFloatValue = (int) (arrayListM11228.get(this.f2084).floatValue() * 1000.0f);
            }
            this.f2085.mo2240(c41964.m13235().m8464(), iFloatValue, str);
        }
        this.f2068.f16593.setVisibility(0);
        this.f2068.f16594.setVisibility(0);
        AutoLineFeedLayoutManager autoLineFeedLayoutManager = this.f2078;
        if (autoLineFeedLayoutManager == null || !autoLineFeedLayoutManager.m2764()) {
            m2233(C4792.m14375().m14406());
            m2231(C4792.m14375().m14405());
        } else {
            m2233(C4792.m14375().m14412());
            m2231(C4792.m14375().m14406());
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public FPSPortraitSettingView m2238(InterfaceC0882 interfaceC0882) {
        this.f2085 = interfaceC0882;
        return this;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m2239(int i) {
        this.f2087 = true;
        m2237();
        C4008.m12886(this, 0.0f, 0.0f, i, new C0881());
    }

    public FPSPortraitSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FPSPortraitSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2067 = true;
        this.f2074 = true;
        this.f2075 = true;
        this.f2084 = 0;
        m2227(context, attributeSet, i);
    }
}
