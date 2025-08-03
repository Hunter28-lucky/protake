package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.looks.FilmStopRecycleView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4975;
import defpackage.AbstractC5311;
import defpackage.C2513;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C2685;
import defpackage.C2886;
import defpackage.C2944;
import defpackage.C3227;
import defpackage.C3255;
import defpackage.C3444;
import defpackage.C3502;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4102;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4460;
import defpackage.C4535;
import defpackage.C4792;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public class GridsSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC5311 f2220;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public RecyclerView f2221;

    /* renamed from: ԭ, reason: contains not printable characters */
    public RecyclerView f2222;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C2685> f2223;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f2224;

    /* renamed from: ՠ, reason: contains not printable characters */
    public ArrayList<C4196> f2225;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ArrayList<C4196> f2226;

    /* renamed from: ֏, reason: contains not printable characters */
    public ArrayList<C4196> f2227;

    /* renamed from: ׯ, reason: contains not printable characters */
    public C3227 f2228;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C4194 f2229;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f2230;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f2231;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f2232;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f2233;

    /* renamed from: ބ, reason: contains not printable characters */
    public RelativeLayout f2234;

    /* renamed from: ޅ, reason: contains not printable characters */
    public SwitchButton f2235;

    /* renamed from: ކ, reason: contains not printable characters */
    public SwitchButton f2236;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f2237;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f2238;

    /* renamed from: މ, reason: contains not printable characters */
    public LinearLayoutManager f2239;

    /* renamed from: ފ, reason: contains not printable characters */
    public C4102 f2240;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f2241;

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean f2242;

    /* renamed from: ލ, reason: contains not printable characters */
    public InterfaceC0917 f2243;

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$Ϳ, reason: contains not printable characters */
    public class C0909 implements AbstractC4975.InterfaceC4976 {
        public C0909() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            C2685 c2685 = (C2685) GridsSettingView.this.f2223.get(i);
            if (c2685 == null || c2685.isSelected() || GridsSettingView.this.f2230 == i) {
                return;
            }
            C2618.m9571("grids_select_sp", i);
            C2513.m9282().m9292(GridsSettingView.this.f2230).setSelected(false);
            ((C3502) GridsSettingView.this.f2221.findViewHolderForAdapterPosition(GridsSettingView.this.f2230)).m11440(false);
            c2685.setSelected(true);
            ((C3502) GridsSettingView.this.f2221.findViewHolderForAdapterPosition(i)).m11440(c2685.isSelected());
            GridsSettingView.this.m2357(c2685);
            GridsSettingView.this.f2230 = i;
            C2513.m9282().m9297(i);
            GridsSettingView gridsSettingView = GridsSettingView.this;
            gridsSettingView.setShowFrame(gridsSettingView.f2231 == 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$Ԩ, reason: contains not printable characters */
    public class C0910 implements AbstractC4975.InterfaceC4976 {
        public C0910() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            InterfaceC0917 interfaceC0917;
            C4196 c4196 = (C4196) GridsSettingView.this.f2224.get(i);
            int i2 = GridsSettingView.this.f2231;
            if (i2 == 1) {
                C4460 c4460M13230 = c4196.m13230();
                ((C4196) GridsSettingView.this.f2224.get(GridsSettingView.this.f2233)).setSelected(false);
                ((C4196) GridsSettingView.this.f2226.get(GridsSettingView.this.f2233)).setSelected(false);
                ((C2886) GridsSettingView.this.f2222.findViewHolderForAdapterPosition(GridsSettingView.this.f2233)).mo8729(false);
                c4460M13230.setSelected(true);
                ((C4196) GridsSettingView.this.f2226.get(i)).setSelected(true);
                ((C2886) GridsSettingView.this.f2222.findViewHolderForAdapterPosition(i)).mo8729(c4460M13230.isSelected());
                GridsSettingView.this.f2233 = i;
                C2513.m9282().m9299(i);
                InterfaceC0917 interfaceC09172 = GridsSettingView.this.f2243;
                if (interfaceC09172 != null) {
                    interfaceC09172.mo2368(c4460M13230.m13721());
                    return;
                }
                return;
            }
            if (i2 != 2) {
                return;
            }
            C2944 c2944M13227 = c4196.m13227();
            c2944M13227.setSelected(!c2944M13227.isSelected());
            ((C2886) GridsSettingView.this.f2222.findViewHolderForAdapterPosition(i)).mo8729(c2944M13227.isSelected());
            ((C4196) GridsSettingView.this.f2227.get(i)).setSelected(c2944M13227.isSelected());
            int type = c2944M13227.getType();
            if (type == 0) {
                InterfaceC0917 interfaceC09173 = GridsSettingView.this.f2243;
                if (interfaceC09173 != null) {
                    interfaceC09173.mo2370(c2944M13227.isSelected());
                    return;
                }
                return;
            }
            if (type != 1) {
                if (type == 2 && (interfaceC0917 = GridsSettingView.this.f2243) != null) {
                    interfaceC0917.mo2369(c2944M13227.isSelected());
                    return;
                }
                return;
            }
            InterfaceC0917 interfaceC09174 = GridsSettingView.this.f2243;
            if (interfaceC09174 != null) {
                interfaceC09174.mo2371(c2944M13227.isSelected());
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$Ԫ, reason: contains not printable characters */
    public class C0911 implements SwitchButton.InterfaceC0969 {
        public C0911() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            InterfaceC0917 interfaceC0917 = GridsSettingView.this.f2243;
            if (interfaceC0917 != null) {
                return interfaceC0917.mo2366();
            }
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            InterfaceC0917 interfaceC0917 = GridsSettingView.this.f2243;
            if (interfaceC0917 != null) {
                interfaceC0917.mo2373(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$Ԭ, reason: contains not printable characters */
    public class C0912 implements SwitchButton.InterfaceC0969 {
        public C0912() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            InterfaceC0917 interfaceC0917 = GridsSettingView.this.f2243;
            if (interfaceC0917 != null) {
                interfaceC0917.mo2367(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC0913 implements View.OnClickListener {
        public ViewOnClickListenerC0913() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$ՠ, reason: contains not printable characters */
    public class C0914 implements FilmStopRecycleView.InterfaceC1323 {
        public C0914() {
        }

        @Override // com.blink.academy.film.widgets.looks.FilmStopRecycleView.InterfaceC1323
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo2363() {
            InterfaceC0917 interfaceC0917 = GridsSettingView.this.f2243;
            if (interfaceC0917 != null) {
                return interfaceC0917.mo2366();
            }
            return true;
        }

        @Override // com.blink.academy.film.widgets.looks.FilmStopRecycleView.InterfaceC1323
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo2364(int i) {
            GridsSettingView.this.f2220.f17572.setCurrentI(i);
            C3255 c3255M13225 = ((C4196) GridsSettingView.this.f2225.get(i)).m13225();
            GridsSettingView.this.m2362(i);
            GridsSettingView.this.f2232 = i;
            C2513.m9282().m9298(i);
            if (GridsSettingView.this.f2243 != null) {
                GridsSettingView.this.m2359(c3255M13225.m10921());
                GridsSettingView.this.f2243.mo2372(c3255M13225.m10924(), c3255M13225.m10920(), c3255M13225.isSelected());
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$ֈ, reason: contains not printable characters */
    public class C0915 implements FilmStopRecycleView.InterfaceC1322 {
        public C0915() {
        }

        @Override // com.blink.academy.film.widgets.looks.FilmStopRecycleView.InterfaceC1322
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo2365() {
            GridsSettingView gridsSettingView = GridsSettingView.this;
            gridsSettingView.setShowFrame(gridsSettingView.f2231 == 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$֏, reason: contains not printable characters */
    public class C0916 extends AbstractC4012 {
        public C0916() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            if (GridsSettingView.this.f2228 != null) {
                GridsSettingView.this.f2228.notifyDataSetChanged();
            }
            if (GridsSettingView.this.f2229 != null) {
                GridsSettingView.this.f2229.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.GridsSettingView$ׯ, reason: contains not printable characters */
    public interface InterfaceC0917 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo2366();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo2367(boolean z);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo2368(float f);

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo2369(boolean z);

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo2370(boolean z);

        /* renamed from: Ԭ, reason: contains not printable characters */
        void mo2371(boolean z);

        /* renamed from: ހ, reason: contains not printable characters */
        void mo2372(float f, float f2, boolean z);

        /* renamed from: ރ, reason: contains not printable characters */
        void mo2373(boolean z);
    }

    public GridsSettingView(@NonNull Context context) {
        this(context, null);
    }

    private void setCropChecked(float f) {
        boolean zM2352 = m2352(f);
        this.f2220.f17571.setEnabled(true);
        this.f2220.f17571.m2630(false, zM2352);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowFrame(boolean z) {
        if (z) {
            this.f2220.f17572.m3658();
            this.f2220.f17572.setVisibility(0);
            this.f2222.setVisibility(8);
        } else {
            this.f2220.f17572.m3656();
            this.f2220.f17572.setVisibility(8);
            this.f2222.setVisibility(0);
        }
        this.f2222.setEnabled(!z);
        this.f2222.setAlpha(z ? 0.0f : 1.0f);
        this.f2220.f17572.setAlpha(z ? 1.0f : 0.0f);
        m2359(this.f2225.get(this.f2232).m13225().m10921());
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2241 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f2242) {
            return;
        }
        m2349(0, null);
    }

    public void setGridsChangeListener(InterfaceC0917 interfaceC0917) {
        this.f2243 = interfaceC0917;
    }

    public void setPadding(int i) {
        RelativeLayout relativeLayout = this.f2220.f17567;
        if (relativeLayout != null) {
            relativeLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final boolean m2348(float f) {
        if (this.f2237) {
            return false;
        }
        if (this.f2238 != 0) {
            return this.f2232 != 0;
        }
        Objects.requireNonNull(C4792.m14375());
        return (f == 1.7777778f || this.f2232 == 0) ? false : true;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m2349(int i, AbstractC4012 abstractC4012) {
        this.f2242 = false;
        C4008.m12886(this, 0.0f, this.f2241, i, abstractC4012);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m2350() {
        this.f2220 = (AbstractC5311) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_grids_setting, this, true);
        float fM14434 = C4792.m14375().m14434();
        this.f2220.f17570.m2562(0, C4792.m14375().m14381() * fM14434);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2220.f17570.getLayoutParams();
        layoutParams.bottomMargin = C4792.m14375().m14408();
        layoutParams.width = (int) (this.f2220.f17570.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_TITLE_GRIDS).toUpperCase()) + C4792.f16138);
        ViewGroup.LayoutParams layoutParams2 = this.f2220.f17564.getLayoutParams();
        layoutParams2.height = C4792.m14375().m14406();
        this.f2220.f17564.setLayoutParams(layoutParams2);
        AbstractC5311 abstractC5311 = this.f2220;
        this.f2221 = abstractC5311.f17575;
        this.f2222 = abstractC5311.f17573;
        this.f2234 = abstractC5311.f17567;
        this.f2235 = abstractC5311.f17571;
        this.f2236 = abstractC5311.f17574;
        abstractC5311.f17566.setContentTextColor(-1);
        this.f2220.f17566.m2562(0, C4792.m14375().m14482() * fM14434);
        int iM14420 = C4792.m14375().m14420();
        this.f2220.f17566.m2560(iM14420, 0, 0, 0);
        this.f2235.setTextSize(C4792.m14375().m14481() * fM14434);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2220.f17565.getLayoutParams();
        layoutParams3.rightMargin = (int) (C4792.m14375().m14476(90) * fM14434);
        this.f2220.f17565.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f2235.getLayoutParams();
        layoutParams4.width = (int) (C4792.m14375().m14410() * fM14434);
        layoutParams4.height = (int) (C4792.m14375().m14409() * fM14434);
        layoutParams4.topMargin = (int) (C4792.m14375().m14411() * fM14434);
        this.f2235.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f2220.f17566.getLayoutParams();
        float f = iM14420;
        layoutParams5.width = (int) (this.f2220.f17566.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_GRIDS_CROP).toUpperCase()) + f + C4792.f16138);
        Paint.FontMetrics fontMetrics = this.f2220.f17566.getPaint().getFontMetrics();
        layoutParams5.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f2220.f17566.setLayoutParams(layoutParams5);
        this.f2220.f17569.setContentTextColor(-1);
        this.f2220.f17569.m2562(0, C4792.m14375().m14482() * fM14434);
        this.f2220.f17569.m2560(iM14420, 0, 0, 0);
        this.f2220.f17574.setTextSize(C4792.m14375().m14481() * fM14434);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f2220.f17568.getLayoutParams();
        layoutParams6.rightMargin = (int) (C4792.m14375().m14476(90) * fM14434);
        this.f2220.f17568.setLayoutParams(layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f2236.getLayoutParams();
        layoutParams7.width = (int) (C4792.m14375().m14410() * fM14434);
        layoutParams7.height = (int) (C4792.m14375().m14409() * fM14434);
        layoutParams7.topMargin = (int) (C4792.m14375().m14411() * fM14434);
        this.f2236.setLayoutParams(layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.f2220.f17569.getLayoutParams();
        layoutParams8.width = (int) (this.f2220.f17569.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_GRIDS_SAFE_COVER).toUpperCase()) + f + C4792.f16138);
        Paint.FontMetrics fontMetrics2 = this.f2220.f17569.getPaint().getFontMetrics();
        layoutParams8.height = (int) ((fontMetrics2.bottom - fontMetrics2.top) + C4792.f16138);
        this.f2220.f17569.setLayoutParams(layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.f2221.getLayoutParams();
        layoutParams9.width = -2;
        this.f2221.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f2220.f17572.getLayoutParams();
        layoutParams10.height = -1;
        layoutParams10.topMargin = (int) (C4792.m14375().m14476(20) * fM14434);
        RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.f2222.getLayoutParams();
        layoutParams11.topMargin = layoutParams10.topMargin;
        this.f2222.setLayoutParams(layoutParams11);
        m2358(fM14434, layoutParams2, layoutParams3, layoutParams10, layoutParams7.height);
        this.f2223 = C2513.m9282().m9287();
        this.f2228 = new C3227(getContext(), this.f2223, new C0909());
        this.f2224 = C2513.m9282().m9289();
        this.f2229 = new C4194(getContext(), this.f2224, new C0910());
        C4102 c4102 = new C4102("right_decoration", C2579.m9438(20.0f));
        this.f2240 = c4102;
        this.f2221.addItemDecoration(c4102);
        this.f2221.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        if (C4792.m14375().m14498()) {
            this.f2222.setLayoutManager(new GridLayoutManager(getContext(), 3));
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
            this.f2239 = linearLayoutManager;
            this.f2222.setLayoutManager(linearLayoutManager);
        }
        this.f2221.setAdapter(this.f2228);
        this.f2222.setAdapter(this.f2229);
        this.f2235.setOnCheckedChangeListener(new C0911());
        this.f2236.setOnCheckedChangeListener(new C0912());
        setOnClickListener(new ViewOnClickListenerC0913());
        m2351();
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m2351() {
        this.f2220.f17572.setOnStopClick(new C0914());
        this.f2220.f17572.m3670();
        this.f2220.f17572.setScrollType(1);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final boolean m2352(float f) {
        C3891 c3891M13890 = C4535.m13880().m13890();
        this.f2238 = c3891M13890.m12429();
        return c3891M13890.m12494();
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean m2353() {
        return this.f2242;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m2354(boolean z) {
        this.f2220.f17571.setEnabled(z);
        this.f2220.f17571.setAlpha(z ? 1.0f : 0.2f);
        this.f2220.f17566.setAlpha(z ? 1.0f : 0.2f);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m2355(C3891 c3891) {
        int iM12429 = c3891.m12429();
        if (iM12429 == 0) {
            if (this.f2225.get(0).m13225().m10921() != 1.7777778f) {
                this.f2225.get(0).m13244(C3444.m11227().m11243());
            }
        } else if (iM12429 == 2) {
            if (this.f2225.get(0).m13225().m10921() != 2.76f) {
                this.f2225.get(0).m13244(C3444.m11227().m11236());
            }
        } else if (this.f2225.get(0).m13225().m10921() != 2.37f) {
            this.f2225.get(0).m13244(C3444.m11227().m11235());
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m2356(int i) {
        C4008.m12886(this.f2222, 0.0f, 0.0f, 0, null);
        if (i == 0) {
            this.f2220.f17565.setVisibility(0);
            this.f2220.f17568.setVisibility(8);
        } else if (i == 1) {
            if (!C4792.m14375().m14498()) {
                float fM14434 = C4792.m14375().m14434();
                C4008.m12886(this.f2222, (-((int) ((C4792.m14375().m14476(90) * fM14434) + (C4792.m14375().m14410() * fM14434)))) / 2, 0.0f, 0, null);
            }
            this.f2220.f17568.setVisibility(0);
            this.f2220.f17565.setVisibility(8);
        } else if (i == 2) {
            this.f2220.f17568.setVisibility(8);
            this.f2220.f17565.setVisibility(8);
        }
        this.f2229.notifyDataSetChanged();
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m2357(C2685 c2685) {
        this.f2231 = c2685.getType();
        C2513.m9282().m9296(this.f2231);
        C2513.m9282().m9300();
        m2356(this.f2231);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final void m2358(float f, ViewGroup.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, RelativeLayout.LayoutParams layoutParams3, int i) {
        if (C4792.m14375().m14498()) {
            layoutParams.height = C4792.m14375().m14412();
            layoutParams3.width = C2579.m9450(getContext());
            layoutParams3.height = C4792.m14375().m14405();
            layoutParams3.addRule(14);
            this.f2220.f17572.setLayoutParams(layoutParams3);
            layoutParams2.height = C4792.m14375().m14405();
            layoutParams2.addRule(3, R.id.grids_frame_list);
            layoutParams2.addRule(14);
            this.f2220.f17565.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2220.f17568.getLayoutParams();
            layoutParams4.addRule(12);
            layoutParams4.addRule(11);
            layoutParams4.bottomMargin = ((C4792.m14375().m14405() / 2) - (i / 2)) + (C4792.m14375().m14404() / 2);
            layoutParams4.rightMargin = ((((C2579.f9594 / 2) - (((int) (C4792.m14375().m14410() * f)) / 2)) - (C4792.m14375().m14386() + C4792.m14375().m14386())) - C4792.m14375().m14386()) - C4792.m14375().m14476(85);
            this.f2220.f17568.setLayoutParams(layoutParams4);
        } else {
            layoutParams.height = C4792.m14375().m14406();
            layoutParams3.width = (int) (C2579.m9439(getContext()) * 0.775f);
            layoutParams3.height = C4792.m14375().m14405();
            layoutParams3.leftMargin = C4792.m14375().m14476(50);
            this.f2220.f17572.setLayoutParams(layoutParams3);
            layoutParams2.rightMargin = (int) (C4792.m14375().m14476(90) * f);
            layoutParams2.addRule(11);
            this.f2220.f17565.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f2220.f17568.getLayoutParams();
            layoutParams5.addRule(11);
            layoutParams5.addRule(15);
            layoutParams5.rightMargin = (int) (C4792.m14375().m14476(90) * f);
            this.f2220.f17568.setLayoutParams(layoutParams5);
        }
        this.f2220.f17572.m3672(layoutParams3.width, layoutParams3.height);
        this.f2220.f17564.setLayoutParams(layoutParams);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m2359(float f) {
        setCropChecked(f);
        m2354(m2348(f));
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m2360() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        this.f2238 = c3891M13890.m12429();
        C2513.m9282().m9294();
        this.f2225 = C2513.m9282().m9283();
        this.f2226 = C2513.m9282().m9291();
        this.f2227 = C2513.m9282().m9288();
        this.f2233 = C2513.m9282().m9286();
        this.f2230 = C2513.m9282().m9284();
        this.f2232 = C2513.m9282().m9285();
        m2359(C2513.m9282().m9283().get(this.f2232).m13225().m10921());
        this.f2220.f17572.setDataList(this.f2225);
        this.f2220.f17572.setCurrentI(this.f2232);
        C2685 c2685 = this.f2223.get(this.f2230);
        C3444.m11227().m11265(c3891M13890.m12444());
        this.f2220.f17571.setChecked(C3444.m11227().m11256());
        this.f2220.f17574.setChecked(C3444.m11227().m11257());
        m2357(c2685);
        C3227 c3227 = this.f2228;
        if (c3227 != null) {
            c3227.notifyDataSetChanged();
        }
        C4194 c4194 = this.f2229;
        if (c4194 != null) {
            c4194.notifyDataSetChanged();
        }
        this.f2220.f17572.m3665(new C0915());
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m2361(int i) {
        this.f2242 = true;
        C3891 c3891M13890 = C4535.m13880().m13890();
        this.f2237 = c3891M13890.m12460() == 1;
        this.f2220.f17571.setEnabled(true);
        this.f2220.f17571.m2630(false, c3891M13890.m12494());
        this.f2220.f17574.setEnabled(true);
        this.f2220.f17574.m2630(false, c3891M13890.m12445());
        m2355(c3891M13890);
        setShowFrame(this.f2231 == 0);
        this.f2220.f17572.m3666(this.f2232);
        this.f2220.f17572.m3664();
        m2354(true ^ this.f2237);
        m2359((c3891M13890.m12404() * 1.0f) / c3891M13890.m12403());
        if (C4792.m14375().m14498()) {
            C2513.m9282().m9293(this.f2223);
        }
        C4008.m12886(this, 0.0f, 0.0f, i, new C0916());
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m2362(int i) {
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12425 = c3891M13890.m12425();
        if (i == 0) {
            if (iM12425 == 1) {
                c3891M13890.m12541(0);
                C4535.m13880().m13915();
                return;
            }
            return;
        }
        if (iM12425 == 0) {
            c3891M13890.m12541(1);
            C4535.m13880().m13915();
        }
    }

    public GridsSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridsSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2350();
    }
}
