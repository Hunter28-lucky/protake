package com.blink.academy.film.widgets;

import android.content.Context;
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
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4722;
import defpackage.AbstractC4975;
import defpackage.C2334;
import defpackage.C2579;
import defpackage.C2811;
import defpackage.C3444;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.r5;
import defpackage.w5;
import java.util.ArrayList;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* loaded from: classes.dex */
public class ResolutionSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f2470;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AbstractC4722 f2471;

    /* renamed from: ԭ, reason: contains not printable characters */
    public RecyclerView f2472;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4194 f2473;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f2474;

    /* renamed from: ՠ, reason: contains not printable characters */
    public LinearLayoutManager f2475;

    /* renamed from: ֈ, reason: contains not printable characters */
    public FilmStopView f2476;

    /* renamed from: ֏, reason: contains not printable characters */
    public ArrayList<r5> f2477;

    /* renamed from: ׯ, reason: contains not printable characters */
    public long f2478;

    /* renamed from: ؠ, reason: contains not printable characters */
    public LinearLayout f2479;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f2480;

    /* renamed from: ށ, reason: contains not printable characters */
    public InterfaceC0947 f2481;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f2482;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f2483;

    /* renamed from: com.blink.academy.film.widgets.ResolutionSettingView$Ϳ, reason: contains not printable characters */
    public class C0943 implements AbstractC4975.InterfaceC4976 {
        public C0943() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            ResolutionSettingView.this.m2522(i);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.ResolutionSettingView$Ԩ, reason: contains not printable characters */
    public class C0944 implements FilmStopView.InterfaceC0908 {
        public C0944() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            if (ResolutionSettingView.this.f2481 != null) {
                return ResolutionSettingView.this.f2481.mo2528();
            }
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            int size = ResolutionSettingView.this.f2477.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((r5) ResolutionSettingView.this.f2477.get(i2)).m8150(false);
                ((FilmPointView) ResolutionSettingView.this.f2471.f15986.getChildAt(i2)).m2292(false);
            }
            ((r5) ResolutionSettingView.this.f2477.get(i)).m8150(true);
            ((FilmPointView) ResolutionSettingView.this.f2471.f15986.getChildAt(i)).m2292(true);
            if (ResolutionSettingView.this.f2481 != null) {
                ResolutionSettingView.this.f2481.mo2529(i);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.ResolutionSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC0945 implements View.OnClickListener {
        public ViewOnClickListenerC0945() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.ResolutionSettingView$Ԭ, reason: contains not printable characters */
    public class C0946 extends AbstractC4012 {
        public C0946() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ResolutionSettingView.this.m2524();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.ResolutionSettingView$Ԯ, reason: contains not printable characters */
    public interface InterfaceC0947 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo2527();

        /* renamed from: Ԩ, reason: contains not printable characters */
        boolean mo2528();

        /* renamed from: ޅ, reason: contains not printable characters */
        void mo2529(int i);

        /* renamed from: އ, reason: contains not printable characters */
        void mo2530(w5 w5Var);
    }

    public ResolutionSettingView(@NonNull Context context) {
        this(context, null);
    }

    public int getCurrentChoosePos() {
        return this.f2480;
    }

    public int getResSize() {
        ArrayList<C4196> arrayList = this.f2474;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2482 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f2483) {
            return;
        }
        m2519(0, null);
    }

    public void setPadding(int i) {
        LinearLayout linearLayout = this.f2471.f15984;
        if (linearLayout != null) {
            linearLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2519(int i, AbstractC4012 abstractC4012) {
        this.f2483 = false;
        C4008.m12886(this, 0.0f, this.f2482, i, abstractC4012);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m2520(Context context, AttributeSet attributeSet, int i) {
        AbstractC4722 abstractC4722 = (AbstractC4722) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_resolution_setting, this, true);
        this.f2471 = abstractC4722;
        LinearLayout linearLayout = abstractC4722.f15984;
        this.f2479 = linearLayout;
        this.f2472 = abstractC4722.f15988;
        this.f2476 = abstractC4722.f15987;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2471.f15985.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = C4792.m14375().m14408();
        this.f2471.f15985.m2562(0, C4792.m14375().m14381());
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (this.f2471.f15985.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_TITLE_RESOLUTION).toUpperCase()) + C4792.f16138);
        this.f2471.f15985.setLayoutParams(layoutParams2);
        this.f2471.f15987.setTextColor(-1);
        this.f2471.f15987.m2327(0, C4792.m14375().m14386());
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2471.f15987.getLayoutParams();
        float fM14434 = C4792.m14375().m14434();
        layoutParams3.height = (int) (C4792.m14375().m14476(100) * fM14434);
        layoutParams3.width = (int) (C4792.m14375().m14476(570) * fM14434);
        this.f2471.f15987.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f2471.f15989.getLayoutParams();
        if (C4792.m14375().m14498()) {
            layoutParams.height = C4792.m14375().m14406();
            this.f2479.setOrientation(1);
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f2472.getLayoutParams();
            layoutParams5.width = -2;
            layoutParams5.height = C4792.m14375().m14405();
            this.f2479.setGravity(1);
            this.f2472.setLayoutParams(layoutParams5);
            layoutParams4.weight = 1.0f;
            layoutParams4.width = layoutParams3.width;
            layoutParams4.gravity = 1;
            this.f2471.f15989.setLayoutParams(layoutParams4);
        } else {
            layoutParams.height = C4792.m14375().m14405();
            this.f2479.setOrientation(0);
            layoutParams4.width = layoutParams3.width;
            layoutParams4.leftMargin = (int) (C4792.m14375().m14476(MPEGConst.SEQUENCE_ERROR_CODE) * fM14434);
            layoutParams4.rightMargin = (int) (C4792.m14375().m14476(MPEGConst.SEQUENCE_ERROR_CODE) * fM14434);
            this.f2471.f15989.setLayoutParams(layoutParams4);
        }
        ((RelativeLayout.LayoutParams) this.f2471.f15986.getLayoutParams()).bottomMargin = -C4792.m14375().m14476(8);
        ArrayList<C4196> arrayList = new ArrayList<>();
        this.f2474 = arrayList;
        this.f2473 = new C4194(context, arrayList, new C0943());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.f2475 = linearLayoutManager;
        this.f2472.setLayoutManager(linearLayoutManager);
        this.f2472.setAdapter(this.f2473);
        this.f2476.setOnStopClick(new C0944());
        setOnClickListener(new ViewOnClickListenerC0945());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean m2521() {
        return this.f2483;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m2522(int i) {
        InterfaceC0947 interfaceC0947 = this.f2481;
        if ((interfaceC0947 == null || interfaceC0947.mo2527()) && i != this.f2480 && System.currentTimeMillis() - this.f2478 >= 200) {
            this.f2478 = System.currentTimeMillis();
            C4196 c4196 = this.f2474.get(this.f2480);
            C4196 c41962 = this.f2474.get(i);
            InterfaceC0947 interfaceC09472 = this.f2481;
            if (interfaceC09472 != null) {
                interfaceC09472.mo2530(c41962.m13236());
            }
            c4196.setSelected(false);
            c4196.m13236().setSelected(false);
            c41962.setSelected(true);
            c41962.m13236().setSelected(true);
            C2334 c2334 = (C2334) this.f2472.findViewHolderForAdapterPosition(this.f2480);
            C2334 c23342 = (C2334) this.f2472.findViewHolderForAdapterPosition(i);
            this.f2480 = i;
            if (c2334 != null) {
                c2334.mo8729(false);
            }
            if (c23342 != null) {
                c23342.mo8729(true);
            }
            m2523();
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m2523() {
        if (this.f2470) {
            C4638.m14099("ResolutionSettingView", String.format("mFilmTextChooseEntities.size : %s , mCurrentChoosePos : %s ", Integer.valueOf(this.f2474.size()), Integer.valueOf(this.f2480)));
        }
        if (this.f2474.size() == 0) {
            return;
        }
        int i = this.f2480;
        if (i < 0 || i >= this.f2474.size()) {
            this.f2480 = 0;
        }
        int[] iArrM10147 = C2811.m10147(this.f2474.get(this.f2480).m13236().m8506());
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12482 = c3891M13890.m12482();
        int iM12484 = c3891M13890.m12484();
        int iM12478 = c3891M13890.m12478();
        this.f2477 = new ArrayList<>();
        for (int i2 : iArrM10147) {
            this.f2477.add(new r5().m8149(C2811.m10144(i2, iM12484, iM12478)));
        }
        ArrayList arrayList = new ArrayList();
        if (this.f2477.size() > 0) {
            int size = this.f2477.size();
            this.f2471.f15986.removeAllViews();
            int i3 = 0;
            while (i3 < size) {
                arrayList.add(this.f2477.get(i3).m8148());
                FilmPointView filmPointView = new FilmPointView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int iM9438 = (int) (C2579.m9438(7.0f) * 0.8f);
                layoutParams.width = iM9438;
                layoutParams.height = iM9438;
                if (i3 != size - 1) {
                    layoutParams.rightMargin = (int) (C2579.m9438(4.0f) * 0.8f);
                }
                filmPointView.setWhiteLinWidth(0.8f);
                filmPointView.m2292(i3 == iM12482);
                filmPointView.setLayoutParams(layoutParams);
                this.f2471.f15986.addView(filmPointView);
                i3++;
            }
            this.f2476.setStringDataList(arrayList);
            this.f2476.setCurrentI(iM12482);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2524() {
        ArrayList<w5> arrayListM11247 = C3444.m11227().m11247();
        this.f2474.clear();
        for (int i = 0; i < arrayListM11247.size(); i++) {
            w5 w5Var = arrayListM11247.get(i);
            C4196 c4196 = new C4196();
            if (w5Var.isSelected()) {
                c4196.setSelected(true);
                this.f2480 = i;
            }
            c4196.m13251(w5Var.m8506().m8845());
            this.f2474.add(c4196.m13254(w5Var));
        }
        this.f2473.notifyDataSetChanged();
        m2523();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public ResolutionSettingView m2525(InterfaceC0947 interfaceC0947) {
        this.f2481 = interfaceC0947;
        return this;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2526(int i) {
        this.f2483 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C0946());
    }

    public ResolutionSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResolutionSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2470 = false;
        m2520(context, attributeSet, i);
    }
}
