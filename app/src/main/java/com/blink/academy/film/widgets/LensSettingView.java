package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.adapter.layout_manager.AutoLineFeedLayoutManager;
import com.blink.academy.protake.R;
import defpackage.AbstractC2962;
import defpackage.AbstractC4012;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C3444;
import defpackage.C3828;
import defpackage.C4008;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4311;
import defpackage.C4792;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class LensSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2962 f2398;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public RecyclerView f2399;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4194 f2400;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f2401;

    /* renamed from: ԯ, reason: contains not printable characters */
    public LinearLayoutManager f2402;

    /* renamed from: ՠ, reason: contains not printable characters */
    public AutoLineFeedLayoutManager f2403;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f2404;

    /* renamed from: ֏, reason: contains not printable characters */
    public ViewGroup.LayoutParams f2405;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f2406;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f2407;

    /* renamed from: ހ, reason: contains not printable characters */
    public InterfaceC0928 f2408;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f2409;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f2410;

    /* renamed from: com.blink.academy.film.widgets.LensSettingView$Ϳ, reason: contains not printable characters */
    public class C0925 implements AbstractC4975.InterfaceC4976 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f2411;

        public C0925() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if ((LensSettingView.this.f2408 == null || LensSettingView.this.f2408.mo2460()) && i != LensSettingView.this.f2406 && System.currentTimeMillis() - this.f2411 >= 200) {
                this.f2411 = System.currentTimeMillis();
                C4196 c4196 = (C4196) LensSettingView.this.f2401.get(LensSettingView.this.f2406);
                C4196 c41962 = (C4196) LensSettingView.this.f2401.get(i);
                if (LensSettingView.this.f2408 != null) {
                    LensSettingView.this.f2408.mo2461(c41962.m13223());
                }
                c4196.setSelected(false);
                c4196.m13223().m12147(false);
                c41962.setSelected(true);
                c41962.m13223().m12147(true);
                C4311 c4311 = (C4311) LensSettingView.this.f2399.findViewHolderForAdapterPosition(LensSettingView.this.f2406);
                C4311 c43112 = (C4311) LensSettingView.this.f2399.findViewHolderForAdapterPosition(i);
                LensSettingView.this.f2406 = i;
                if (c4311 != null) {
                    c4311.mo8729(false);
                }
                if (c43112 != null) {
                    c43112.mo8729(true);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.LensSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC0926 implements View.OnClickListener {
        public ViewOnClickListenerC0926() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.LensSettingView$Ԫ, reason: contains not printable characters */
    public class C0927 extends AbstractC4012 {
        public C0927() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            LensSettingView.this.m2456();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.LensSettingView$Ԭ, reason: contains not printable characters */
    public interface InterfaceC0928 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo2460();

        /* renamed from: ލ, reason: contains not printable characters */
        void mo2461(C3828 c3828);
    }

    public LensSettingView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2409 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f2410) {
            return;
        }
        m2450(0, null);
    }

    public void setPadding(int i) {
        LinearLayout linearLayout = this.f2398.f10696;
        if (linearLayout != null) {
            linearLayout.setPadding(i, 0, i, 0);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2450(int i, AbstractC4012 abstractC4012) {
        this.f2410 = false;
        C4008.m12886(this, 0.0f, this.f2409, i, abstractC4012);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2451(Context context, AttributeSet attributeSet, int i) {
        this.f2398 = (AbstractC2962) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_lens_setting, this, true);
        this.f2404 = C4792.m14375().m14498();
        ViewGroup.LayoutParams layoutParams = this.f2398.f10696.getLayoutParams();
        this.f2405 = layoutParams;
        layoutParams.height = C4792.m14375().m14405();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2398.f10697.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = C4792.m14375().m14408();
        this.f2398.f10697.m2562(0, C4792.m14375().m14381());
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (this.f2398.f10697.getPaint().measureText(getResources().getString(R.string.RECORDING_SETTINGS_TITLE_LENS).toUpperCase()) + C4792.f16138);
        this.f2398.f10697.setLayoutParams(layoutParams2);
        this.f2399 = this.f2398.f10698;
        ArrayList<C4196> arrayList = new ArrayList<>();
        this.f2401 = arrayList;
        this.f2400 = new C4194(context, arrayList, new C0925());
        this.f2402 = new LinearLayoutManager(context, 0, false);
        this.f2403 = new AutoLineFeedLayoutManager();
        this.f2399.setLayoutManager(this.f2402);
        this.f2399.setAdapter(this.f2400);
        setOnClickListener(new ViewOnClickListenerC0926());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m2452() {
        return this.f2410;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final float m2453() {
        float fMeasureText;
        int iM14386;
        Paint paint = new Paint();
        paint.setTextSize(C4792.m14375().m14386());
        paint.setTypeface(FilmApp.m404());
        Iterator<C4196> it = this.f2401.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            C4196 next = it.next();
            if (next.m13233() != 0) {
                fMeasureText = paint.measureText(FilmApp.m402().getResources().getString(next.m13233()));
                iM14386 = C4792.m14375().m14386();
            } else {
                fMeasureText = paint.measureText(next.m13232());
                iM14386 = C4792.m14375().m14386();
            }
            f = f + fMeasureText + (iM14386 * 2) + 2.0f + C4792.f16138;
        }
        float f2 = C2579.f9598;
        if (f > f2) {
            return f2 / f;
        }
        return 1.0f;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean m2454() {
        ArrayList<C4196> arrayList;
        if (!this.f2404 || (arrayList = this.f2401) == null) {
            return false;
        }
        arrayList.size();
        return false;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m2455() {
        if (m2454()) {
            this.f2405.height = C4792.m14375().m14406();
            this.f2399.setLayoutManager(this.f2403);
            this.f2407 = true;
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m2456() {
        ArrayList<C3828> arrayListM11230 = C3444.m11230();
        this.f2401.clear();
        Iterator<C3828> it = arrayListM11230.iterator();
        while (it.hasNext()) {
            C3828 next = it.next();
            if (next.m12143()) {
                C4196 c4196M13241 = new C4196().m13251(next.m12139()).m13252(next.m12140()).m13241(next);
                c4196M13241.setSelected(next.m12142());
                c4196M13241.setItemViewType(6);
                this.f2401.add(c4196M13241);
                if (next.m12142()) {
                    this.f2406 = this.f2401.size() - 1;
                }
            }
        }
        if (!this.f2407) {
            m2455();
        }
        m2458();
        this.f2400.notifyDataSetChanged();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public LensSettingView m2457(InterfaceC0928 interfaceC0928) {
        this.f2408 = interfaceC0928;
        return this;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m2458() {
        float fM2453 = m2453();
        Iterator<C4196> it = this.f2401.iterator();
        while (it.hasNext()) {
            C4196 next = it.next();
            next.m13243((int) (C4792.m14375().m14386() * fM2453));
            next.m13248((int) (C4792.m14375().m14386() * fM2453));
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m2459(int i) {
        this.f2410 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C0927());
    }

    public LensSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LensSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2451(context, attributeSet, i);
    }
}
