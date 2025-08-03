package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4134;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C3444;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4062;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4535;
import defpackage.C4734;
import defpackage.C4792;
import defpackage.r1;
import defpackage.w7;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class WbSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4134 f2732;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public RecyclerView f2733;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4194 f2734;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f2735;

    /* renamed from: ԯ, reason: contains not printable characters */
    public LinearLayoutManager f2736;

    /* renamed from: ՠ, reason: contains not printable characters */
    public ArrayList<String> f2737;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ArrayList<String> f2738;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f2739;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f2740;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f2741;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f2742;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f2743;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f2744;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f2745;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f2746;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f2747;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f2748;

    /* renamed from: އ, reason: contains not printable characters */
    public InterfaceC0987 f2749;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f2750;

    /* renamed from: މ, reason: contains not printable characters */
    public boolean f2751;

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$Ϳ, reason: contains not printable characters */
    public class C0979 implements AbstractC4975.InterfaceC4976 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f2752;

        public C0979() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if ((WbSettingView.this.f2749 == null || WbSettingView.this.f2749.mo2735()) && i != -1) {
                int iM8513 = ((C4196) WbSettingView.this.f2735.get(i)).m13237().m8513();
                if (i == WbSettingView.this.f2748 && ((iM8513 == 2 || iM8513 == 9) && !WbSettingView.this.f2740)) {
                    WbSettingView.this.f2740 = true;
                    WbSettingView.this.m2729();
                    WbSettingView.this.m2723(i);
                    WbSettingView.this.m2727(i);
                    return;
                }
                WbSettingView.this.f2740 = false;
                WbSettingView.this.m2723(i);
                if (System.currentTimeMillis() - this.f2752 < 200) {
                    return;
                }
                this.f2752 = System.currentTimeMillis();
                WbSettingView.this.m2725(i);
                WbSettingView.this.m2727(i);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC0980 implements View.OnClickListener {
        public ViewOnClickListenerC0980() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC0981 implements View.OnClickListener {
        public ViewOnClickListenerC0981() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WbSettingView.this.f2739) {
                return;
            }
            WbSettingView.this.f2739 = true;
            WbSettingView.this.f2740 = true;
            WbSettingView.this.m2724();
            WbSettingView.this.m2729();
            WbSettingView.this.f2732.f14316.setVisibility(8);
            if (WbSettingView.this.f2749 != null) {
                WbSettingView.this.f2749.mo2737();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$Ԭ, reason: contains not printable characters */
    public class C0982 implements FilmStopView.InterfaceC0908 {
        public C0982() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) throws NumberFormatException {
            String str = (String) WbSettingView.this.f2737.get(i);
            if (r1.m8143(str)) {
                Float fValueOf = Float.valueOf(str);
                WbSettingView.this.f2743 = fValueOf.intValue();
                WbSettingView.this.f2732.f14326.m2326(i, false, WbSettingView.this.m2718(fValueOf.floatValue()));
                WbSettingView.this.f2732.f14325.setValueAndUpdateUI(Float.valueOf(str).floatValue());
                WbSettingView.this.f2740 = true;
                WbSettingView.this.m2729();
                if (WbSettingView.this.f2749 != null) {
                    WbSettingView.this.f2749.mo2738(WbSettingView.this.f2743, WbSettingView.this.f2744);
                    WbSettingView.this.f2749.mo2736();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$Ԯ, reason: contains not printable characters */
    public class C0983 implements FilmStopView.InterfaceC0908 {
        public C0983() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) throws NumberFormatException {
            Float fValueOf = Float.valueOf((String) WbSettingView.this.f2738.get(i));
            WbSettingView.this.f2744 = fValueOf.intValue();
            WbSettingView.this.f2732.f14327.m2326(i, false, WbSettingView.this.m2716(fValueOf.floatValue()));
            WbSettingView.this.f2740 = true;
            WbSettingView.this.m2729();
            WbSettingView.this.m2726("");
            if (WbSettingView.this.f2749 != null) {
                WbSettingView.this.f2749.mo2738(WbSettingView.this.f2743, WbSettingView.this.f2744);
                WbSettingView.this.f2749.mo2736();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$ՠ, reason: contains not printable characters */
    public class C0984 implements FilmSeekBar.InterfaceC0896 {
        public C0984() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            WbSettingView.this.f2732.f14326.m2326(((f2 - C3444.m11227().m11250()) * 1.0f) / WbSettingView.this.f2741, false, WbSettingView.this.m2718(f2));
            WbSettingView.this.f2743 = (int) f2;
            WbSettingView.this.f2740 = true;
            WbSettingView.this.m2734();
            if (WbSettingView.this.f2749 != null) {
                WbSettingView.this.f2749.mo2738(WbSettingView.this.f2743, WbSettingView.this.f2744);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$ֈ, reason: contains not printable characters */
    public class C0985 implements FilmSeekBar.InterfaceC0897 {
        public C0985() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ϳ */
        public void mo2145() {
            if (WbSettingView.this.f2749 != null) {
                WbSettingView.this.f2749.mo2736();
            }
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ԩ */
        public void mo2146() {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$֏, reason: contains not printable characters */
    public class C0986 extends AbstractC4012 {
        public C0986() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            WbSettingView.this.m2728();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.WbSettingView$ׯ, reason: contains not printable characters */
    public interface InterfaceC0987 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo2735();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo2736();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo2737();

        /* renamed from: ؠ, reason: contains not printable characters */
        void mo2738(int i, int i2);

        /* renamed from: ށ, reason: contains not printable characters */
        void mo2739(w7 w7Var);
    }

    public WbSettingView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2750 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f2751) {
            return;
        }
        m2719(0, null);
    }

    public void setListPadding(ArrayList<C4196> arrayList) {
        int iM9450 = C2579.m9450(getContext());
        if (iM9450 == 0) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14386());
        textPaint.setTypeface(FilmApp.m404());
        int i = 0;
        int iMeasureText = 0;
        while (i < arrayList.size()) {
            iMeasureText = (i == 0 || i == 1) ? (int) (iMeasureText + textPaint.measureText(arrayList.get(i).m13232())) : iMeasureText + C2579.m9438(33.0f);
            i++;
        }
        if ((C2579.m9438(C4062.f14090) * 2 * arrayList.size()) + iMeasureText >= iM9450) {
            int size = !C4792.m14375().m14498() ? (int) (((iM9450 - iMeasureText) / arrayList.size()) / 2.0f) : 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList.get(i2).m13248(size);
            }
        }
    }

    public void setPadding(int i) {
        RelativeLayout relativeLayout = this.f2732.f14318;
        if (relativeLayout != null) {
            relativeLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final boolean m2713(int i) {
        int iM8513;
        ArrayList<C4196> arrayList = this.f2735;
        if (arrayList == null || !((iM8513 = arrayList.get(i).m13237().m8513()) == 2 || iM8513 == 9)) {
            this.f2732.f14316.setVisibility(8);
            return true;
        }
        if (this.f2740) {
            this.f2732.f14316.setVisibility(8);
            return true;
        }
        this.f2732.f14316.setVisibility(0);
        return false;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final boolean m2714() {
        return !this.f2740;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public float m2715(int i) {
        return ((i - C3444.m11227().m11252()) * 1.0f) / this.f2742;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final String m2716(float f) {
        return ((int) f) + "";
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public float m2717(int i) {
        return ((i - C3444.m11227().m11250()) * 1.0f) / this.f2741;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final String m2718(float f) {
        return ((int) f) + "K";
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m2719(int i, AbstractC4012 abstractC4012) {
        this.f2751 = false;
        C4008.m12886(this, 0.0f, this.f2750, i, abstractC4012);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m2720(Context context, AttributeSet attributeSet, int i) {
        AbstractC4134 abstractC4134 = (AbstractC4134) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_wb_setting, this, true);
        this.f2732 = abstractC4134;
        ViewGroup.LayoutParams layoutParams = abstractC4134.f14317.getLayoutParams();
        layoutParams.height = C4792.m14375().m14406();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2732.f14319.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = C4792.m14375().m14408();
        this.f2732.f14319.m2562(0, C4792.m14375().m14381());
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) this.f2732.f14319.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_TITLE_WB).toUpperCase() + C4792.f16138);
        this.f2732.f14319.setLayoutParams(layoutParams2);
        int iM14476 = C4792.m14375().m14476(50);
        int i2 = C4792.m14375().m14498() ? (int) ((C2579.f9594 - C2579.f9598) / 2.0f) : 0;
        this.f2732.f14324.setPadding(i2, iM14476, i2, 0);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f2732.f14318.getLayoutParams();
        layoutParams3.topMargin = C4792.m14375().m14476(20);
        this.f2732.f14318.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2732.f14326.getLayoutParams();
        layoutParams4.height = C4792.m14375().m14476(100);
        layoutParams4.width = C4792.m14375().m14476(450);
        layoutParams4.leftMargin = C4792.m14375().m14476(40);
        this.f2732.f14326.setLayoutParams(layoutParams4);
        this.f2732.f14326.setTextColor(-1);
        this.f2732.f14326.m2327(0, C4792.m14375().m14386());
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f2732.f14327.getLayoutParams();
        layoutParams5.height = C4792.m14375().m14476(100);
        layoutParams5.width = C4792.m14375().m14476(350);
        layoutParams5.rightMargin = C4792.m14375().m14476(40);
        this.f2732.f14327.setLayoutParams(layoutParams5);
        this.f2732.f14327.setTextColor(-1);
        this.f2732.f14327.m2327(0, C4792.m14375().m14386());
        this.f2732.f14328.setText(getResources().getString(R.string.RECORDING_SETTINGS_WB_TINT).toUpperCase());
        this.f2732.f14328.setTextColor(-1);
        this.f2732.f14328.m2562(0, C4792.m14375().m14398());
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f2732.f14328.getLayoutParams();
        layoutParams6.width = (int) (this.f2732.f14328.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_WB_TINT).toUpperCase()) + C4792.f16138);
        Paint.FontMetrics fontMetrics = this.f2732.f14328.getPaint().getFontMetrics();
        layoutParams6.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        layoutParams6.rightMargin = (int) (layoutParams5.rightMargin + ((layoutParams5.width - layoutParams6.width) / 2.0f));
        layoutParams6.bottomMargin = C4792.m14375().m14476(20);
        this.f2732.f14328.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f2732.f14322.getLayoutParams();
        layoutParams7.width = C4792.m14375().m14476(940);
        this.f2732.f14322.setLayoutParams(layoutParams7);
        this.f2732.f14325.setShowCenterLine(false);
        this.f2732.f14323.setContentTextColor(-1);
        this.f2732.f14323.m2562(0, C4792.m14375().m14398());
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f2732.f14321.getLayoutParams();
        layoutParams8.width = layoutParams4.width;
        layoutParams8.leftMargin = layoutParams4.leftMargin;
        layoutParams8.bottomMargin = layoutParams6.bottomMargin;
        this.f2732.f14321.setLayoutParams(layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f2732.f14320.getLayoutParams();
        layoutParams9.height = C4792.m14375().m14405();
        this.f2732.f14320.setLayoutParams(layoutParams9);
        if (C4792.m14375().m14498()) {
            layoutParams.height = C4792.m14375().m14412();
            layoutParams7.addRule(14);
            layoutParams7.addRule(3, R.id.center_parent);
            layoutParams7.height = C4792.m14375().m14405();
            this.f2732.f14322.setLayoutParams(layoutParams7);
        } else {
            layoutParams.height = C4792.m14375().m14406();
        }
        m2721();
        this.f2733 = this.f2732.f14324;
        ArrayList<C4196> arrayList = new ArrayList<>();
        this.f2735 = arrayList;
        this.f2734 = new C4194(context, arrayList, new C0979());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.f2736 = linearLayoutManager;
        this.f2733.setLayoutManager(linearLayoutManager);
        this.f2733.setAdapter(this.f2734);
        setOnClickListener(new ViewOnClickListenerC0980());
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m2721() {
        this.f2732.f14316.setOnClickListener(new ViewOnClickListenerC0981());
        this.f2732.f14326.setOnStopClick(new C0982());
        this.f2732.f14327.setOnStopClick(new C0983());
        this.f2732.f14325.setOnProChange(new C0984());
        this.f2732.f14325.setOnTouchStateChange(new C0985());
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean m2722() {
        return this.f2751;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m2723(int i) {
        this.f2739 = m2713(i);
        m2724();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m2724() {
        float fM14416 = this.f2739 ? 1.0f : C4792.m14375().m14416();
        this.f2732.f14326.setAlpha(fM14416);
        this.f2732.f14325.setAlpha(fM14416);
        this.f2732.f14327.setAlpha(fM14416);
        this.f2732.f14328.setAlpha(fM14416);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m2725(int i) {
        C4196 c4196 = this.f2735.get(this.f2748);
        C4196 c41962 = this.f2735.get(i);
        InterfaceC0987 interfaceC0987 = this.f2749;
        if (interfaceC0987 != null) {
            interfaceC0987.mo2739(c41962.m13237());
        }
        c4196.setSelected(false);
        c4196.m13237().m8517(false);
        c41962.setSelected(true);
        c41962.m13237().m8517(true);
        C4734 c4734 = (C4734) this.f2733.findViewHolderForAdapterPosition(this.f2748);
        C4734 c47342 = (C4734) this.f2733.findViewHolderForAdapterPosition(i);
        this.f2748 = i;
        this.f2745 = i;
        if (c4734 != null) {
            c4734.mo8729(false);
        }
        if (c47342 != null) {
            c47342.mo8729(true);
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m2726(String str) {
        this.f2732.f14323.setText(str);
        TextPaint paint = this.f2732.f14323.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2732.f14323.getLayoutParams();
        float fMeasureText = paint.measureText(str);
        float f = C4792.f16138;
        layoutParams.width = (int) (fMeasureText + f);
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + f);
        this.f2732.f14323.setLayoutParams(layoutParams);
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m2727(int i) {
        ArrayList<C4196> arrayList = this.f2735;
        if (arrayList != null) {
            C4196 c4196 = arrayList.get(i);
            int iM8511 = c4196.m13237().m8511();
            m2726((iM8511 == 0 || !c4196.isSelected() || i <= 1) ? "" : getResources().getString(iM8511));
        }
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m2728() {
        this.f2735.clear();
        this.f2737.clear();
        this.f2738.clear();
        C3444.m11227().m11253();
        C3891 c3891M13890 = C4535.m13880().m13890();
        ArrayList<w7> arrayListM11229 = C3444.m11229();
        for (int i = 0; i < arrayListM11229.size(); i++) {
            w7 w7Var = arrayListM11229.get(i);
            if (w7Var.m8514()) {
                C4196 c4196 = new C4196();
                c4196.m13255(w7Var);
                c4196.setItemViewType(w7Var.m8512());
                c4196.m13251(w7Var.m8510());
                c4196.m13252(w7Var.m8511());
                c4196.setSelected(w7Var.m8513() == c3891M13890.m12488());
                this.f2735.add(c4196);
                if (c4196.isSelected()) {
                    this.f2748 = this.f2735.size() - 1;
                }
            }
        }
        setListPadding(this.f2735);
        m2723(this.f2748);
        m2727(this.f2748);
        int i2 = this.f2748;
        if (i2 > 0 && !this.f2740) {
            this.f2736.scrollToPositionWithOffset(i2, (int) (((C2579.f9594 / 2.0f) - (C4792.m14375().m14476(25) * 2)) - C4792.m14375().m14476(100)));
        }
        this.f2734.notifyDataSetChanged();
        int iM11249 = C3444.m11227().m11249();
        int iM11250 = C3444.m11227().m11250();
        this.f2732.f14325.setMax(iM11249);
        this.f2732.f14325.setMin(iM11250);
        while (iM11250 <= iM11249) {
            this.f2737.add(iM11250 + "");
            iM11250 += this.f2741;
        }
        this.f2732.f14326.setStringDataList(this.f2737);
        float fM12469 = c3891M13890.m12469();
        this.f2743 = Math.round(fM12469);
        int i3 = (int) fM12469;
        this.f2732.f14326.m2326(m2717(i3), false, m2718(i3));
        this.f2732.f14325.setValueAndUpdateUI(fM12469);
        int iM11251 = C3444.m11227().m11251();
        for (int iM11252 = C3444.m11227().m11252(); iM11252 <= iM11251; iM11252 += 10) {
            this.f2738.add(m2716(iM11252));
        }
        this.f2732.f14327.setStringDataList(this.f2738);
        float fM12473 = c3891M13890.m12473();
        this.f2744 = Math.round(fM12473);
        int i4 = (int) fM12473;
        this.f2732.f14327.m2326(m2715(i4), false, m2716(i4));
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m2729() {
        m2734();
        m2733();
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m2730(int i, int i2) {
        if (m2714()) {
            C3891 c3891M13890 = C4535.m13880().m13890();
            if (this.f2746 != i) {
                this.f2743 = i;
                if (r1.m8144(this.f2737)) {
                    this.f2732.f14326.m2326(m2717(i), false, m2718(i));
                }
                this.f2732.f14325.setValueAndUpdateUI(i);
                this.f2746 = i;
                c3891M13890.m12347(this.f2743);
            }
            if (i2 != this.f2747) {
                this.f2744 = i2;
                if (r1.m8144(this.f2738)) {
                    this.f2732.f14327.m2326(m2715(i2), false, m2716(i2));
                }
                this.f2747 = i2;
                c3891M13890.m12373(this.f2744);
            }
            if (this.f2739) {
                C4535.m13880().m13915();
            }
        }
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public WbSettingView m2731(InterfaceC0987 interfaceC0987) {
        this.f2749 = interfaceC0987;
        return this;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public void m2732(int i) {
        this.f2751 = true;
        this.f2740 = C4535.m13880().m13890().m12488() == 1;
        C4008.m12886(this, 0.0f, 0.0f, i, new C0986());
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final void m2733() {
        C4535.m13880().m13890().m12392(1);
        C4535.m13880().m13915();
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m2734() {
        Iterator<C4196> it = this.f2735.iterator();
        while (it.hasNext()) {
            it.next().setSelected(false);
        }
        C4194 c4194 = this.f2734;
        if (c4194 != null) {
            c4194.notifyDataSetChanged();
        }
    }

    public WbSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WbSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2737 = new ArrayList<>();
        this.f2738 = new ArrayList<>();
        this.f2741 = 100;
        this.f2742 = 10;
        m2720(context, attributeSet, i);
    }
}
