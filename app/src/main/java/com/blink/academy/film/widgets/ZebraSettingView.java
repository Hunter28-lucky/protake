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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC3480;
import defpackage.AbstractC4012;
import defpackage.AbstractC4975;
import defpackage.C2334;
import defpackage.C2579;
import defpackage.C3444;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4351;
import defpackage.C4792;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ZebraSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3480 f2765;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public RecyclerView f2766;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4194 f2767;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f2768;

    /* renamed from: ԯ, reason: contains not printable characters */
    public LinearLayoutManager f2769;

    /* renamed from: ՠ, reason: contains not printable characters */
    public SwitchButton f2770;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2771;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC0992 f2772;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f2773;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f2774;

    /* renamed from: com.blink.academy.film.widgets.ZebraSettingView$Ϳ, reason: contains not printable characters */
    public class C0988 implements AbstractC4975.InterfaceC4976 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f2775;

        public C0988() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if ((ZebraSettingView.this.f2772 == null || ZebraSettingView.this.f2772.mo2755()) && System.currentTimeMillis() - this.f2775 >= 200) {
                this.f2775 = System.currentTimeMillis();
                if (i == ZebraSettingView.this.f2771) {
                    C4196 c4196 = (C4196) ZebraSettingView.this.f2768.get(i);
                    if (c4196.isSelected()) {
                        c4196.setSelected(false);
                        c4196.m13226().m13507(false);
                        C2334 c2334 = (C2334) ZebraSettingView.this.f2766.findViewHolderForAdapterPosition(i);
                        if (c2334 != null) {
                            c2334.mo8729(false);
                        }
                        if (ZebraSettingView.this.f2772 != null) {
                            ZebraSettingView.this.f2772.mo2756(-1);
                        }
                        ZebraSettingView.this.f2771 = -1;
                        return;
                    }
                }
                C4196 c41962 = ZebraSettingView.this.f2771 != -1 ? (C4196) ZebraSettingView.this.f2768.get(ZebraSettingView.this.f2771) : null;
                C4196 c41963 = (C4196) ZebraSettingView.this.f2768.get(i);
                if (ZebraSettingView.this.f2772 != null) {
                    ZebraSettingView.this.f2772.mo2756(i);
                }
                if (c41962 != null) {
                    c41962.setSelected(false);
                    c41962.m13226().m13507(false);
                }
                c41963.setSelected(true);
                c41963.m13226().m13507(true);
                C2334 c23342 = (C2334) ZebraSettingView.this.f2766.findViewHolderForAdapterPosition(ZebraSettingView.this.f2771);
                C2334 c23343 = (C2334) ZebraSettingView.this.f2766.findViewHolderForAdapterPosition(i);
                ZebraSettingView.this.f2771 = i;
                if (c23342 != null) {
                    c23342.mo8729(false);
                }
                if (c23343 != null) {
                    c23343.mo8729(true);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.ZebraSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC0989 implements View.OnClickListener {
        public ViewOnClickListenerC0989() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.ZebraSettingView$Ԫ, reason: contains not printable characters */
    public class C0990 implements SwitchButton.InterfaceC0969 {
        public C0990() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            if (ZebraSettingView.this.f2772 != null) {
                return ZebraSettingView.this.f2772.mo2755();
            }
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            if (ZebraSettingView.this.f2772 != null) {
                ZebraSettingView.this.f2772.mo2754(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.ZebraSettingView$Ԭ, reason: contains not printable characters */
    public class C0991 extends AbstractC4012 {
        public C0991() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.ZebraSettingView$Ԯ, reason: contains not printable characters */
    public interface InterfaceC0992 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo2754(boolean z);

        /* renamed from: Ԩ, reason: contains not printable characters */
        boolean mo2755();

        /* renamed from: ׯ, reason: contains not printable characters */
        void mo2756(int i);
    }

    public ZebraSettingView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2773 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f2774) {
            return;
        }
        m2746(0, null);
    }

    public void setPadding(int i) {
        LinearLayout linearLayout = this.f2765.f11988;
        if (linearLayout != null) {
            linearLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2746(int i, AbstractC4012 abstractC4012) {
        this.f2774 = false;
        C4008.m12886(this, 0.0f, this.f2773, i, abstractC4012);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2747(Context context, AttributeSet attributeSet, int i) {
        AbstractC3480 abstractC3480 = (AbstractC3480) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_zebra_setting, this, true);
        this.f2765 = abstractC3480;
        LinearLayout linearLayout = abstractC3480.f11988;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        this.f2765.f11989.m2562(0, C4792.m14375().m14381());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2765.f11989.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = C4792.m14375().m14408();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (this.f2765.f11989.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_TITLE_ASSISTANTS).toUpperCase()) + C4792.f16138);
        this.f2765.f11989.m2562(0, C4792.m14375().m14381());
        AbstractC3480 abstractC34802 = this.f2765;
        this.f2766 = abstractC34802.f11991;
        this.f2770 = abstractC34802.f11990;
        abstractC34802.f11987.setContentTextColor(-1);
        this.f2765.f11987.m2562(0, C4792.m14375().m14482());
        this.f2770.setTextSize(C4792.m14375().m14481());
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f2765.f11992.getLayoutParams();
        layoutParams3.width = C4792.m14375().m14386();
        this.f2765.f11992.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2770.getLayoutParams();
        layoutParams4.width = C4792.m14375().m14410();
        layoutParams4.height = C4792.m14375().m14409();
        this.f2770.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f2765.f11987.getLayoutParams();
        layoutParams5.width = (int) (this.f2765.f11987.getPaint().measureText(getResources().getString(R.string.RECORDING_ASSISTANTS_AUTO).toUpperCase()) + C4792.f16138);
        Paint.FontMetrics fontMetrics = this.f2765.f11987.getPaint().getFontMetrics();
        layoutParams5.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f2765.f11987.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f2765.f11986.getLayoutParams();
        if (C4792.m14375().m14498()) {
            layoutParams.height = C4792.m14375().m14406();
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f2766.getLayoutParams();
            layoutParams7.width = -2;
            layoutParams7.height = C4792.m14375().m14405();
            linearLayout.setGravity(1);
            this.f2766.setLayoutParams(layoutParams7);
            layoutParams6.width = layoutParams4.width;
            layoutParams6.height = C4792.m14375().m14405();
            layoutParams6.gravity = 1;
            this.f2765.f11986.setLayoutParams(layoutParams6);
            this.f2765.f11992.setVisibility(8);
        } else {
            layoutParams.height = C4792.m14375().m14405();
            linearLayout.setOrientation(0);
            layoutParams6.leftMargin = (int) ((C4792.m14375().m14386() - this.f2770.getViewRealPadding()) + C4792.m14375().m14443());
            this.f2765.f11986.setLayoutParams(layoutParams6);
            this.f2765.f11992.setVisibility(0);
        }
        ArrayList<C4196> arrayList = new ArrayList<>();
        this.f2768 = arrayList;
        this.f2767 = new C4194(context, arrayList, new C0988());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.f2769 = linearLayoutManager;
        this.f2766.setLayoutManager(linearLayoutManager);
        this.f2766.setAdapter(this.f2767);
        setOnClickListener(new ViewOnClickListenerC0989());
        this.f2770.setOnCheckedChangeListener(new C0990());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m2748() {
        return this.f2774;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final float m2749() {
        float fMeasureText;
        int iM14386;
        Paint paint = new Paint();
        paint.setTextSize(C4792.m14375().m14386());
        paint.setTypeface(FilmApp.m404());
        Iterator<C4196> it = this.f2768.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            C4196 next = it.next();
            if (next.m13233() != 0) {
                fMeasureText = paint.measureText(getResources().getString(next.m13233()));
                iM14386 = C4792.m14375().m14386();
            } else {
                fMeasureText = paint.measureText(next.m13232());
                iM14386 = C4792.m14375().m14386();
            }
            f += fMeasureText + (iM14386 * 2) + 2.0f;
        }
        float fM9450 = C2579.m9450(getContext());
        if (f > fM9450) {
            return fM9450 / f;
        }
        return 1.0f;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2750() {
        ArrayList<C4351> arrayListM11226 = C3444.m11226();
        this.f2770.m2630(false, C3947.m12727().m12729() == 1);
        this.f2768.clear();
        Iterator<C4351> it = arrayListM11226.iterator();
        while (it.hasNext()) {
            C4351 next = it.next();
            C4196 c4196M13245 = new C4196().m13251(next.m13503()).m13252(next.m13504()).m13245(next);
            c4196M13245.setSelected(next.m13505());
            this.f2768.add(c4196M13245);
            if (next.m13505()) {
                this.f2771 = this.f2768.size() - 1;
            }
        }
        m2752();
        this.f2767.notifyDataSetChanged();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public ZebraSettingView m2751(InterfaceC0992 interfaceC0992) {
        this.f2772 = interfaceC0992;
        return this;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m2752() {
        float fM2749 = m2749();
        Iterator<C4196> it = this.f2768.iterator();
        while (it.hasNext()) {
            C4196 next = it.next();
            next.m13243((int) (C4792.m14375().m14386() * fM2749));
            next.m13248((int) (C4792.m14375().m14386() * fM2749));
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m2753(int i) {
        this.f2774 = true;
        m2750();
        C4008.m12886(this, 0.0f, 0.0f, i, new C0991());
    }

    public ZebraSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZebraSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2771 = -1;
        m2747(context, attributeSet, i);
    }
}
