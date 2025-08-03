package com.blink.academy.film.setting.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blink.academy.protake.R;
import defpackage.AbstractC3865;
import defpackage.C2579;
import defpackage.C3891;
import defpackage.C4321;
import defpackage.C4792;
import defpackage.C4802;
import defpackage.C5101;
import defpackage.C5267;
import defpackage.InterfaceC4172;
import defpackage.r1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PresetPagerItem extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3865 f1516;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C4321 f1517;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<C4802> f1518;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public LinearLayoutManager f1519;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC0780 f1520;

    /* renamed from: com.blink.academy.film.setting.pager.PresetPagerItem$Ϳ, reason: contains not printable characters */
    public class C0779 implements InterfaceC4172 {
        public C0779() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            PresetPagerItem.this.f1520.mo1876(((C4802) PresetPagerItem.this.f1518.get(i)).m14515());
        }

        @Override // defpackage.InterfaceC4172
        /* renamed from: ՠ */
        public void mo1559(int i, int i2, Object obj) {
            if (i2 == 1) {
                if (PresetPagerItem.this.f1520 != null) {
                    PresetPagerItem.this.f1520.mo1873(((C4802) PresetPagerItem.this.f1518.get(i)).m14515(), (String) obj);
                }
            } else if (i2 == 2) {
                if (PresetPagerItem.this.f1520 != null) {
                    PresetPagerItem.this.f1520.mo1872(((C4802) PresetPagerItem.this.f1518.get(i)).m14515());
                }
            } else if (i2 == 3) {
                PresetPagerItem.this.f1520.mo1875(((C4802) PresetPagerItem.this.f1518.get(i)).m14515());
            } else if (i2 == 4) {
                PresetPagerItem.this.f1520.mo1877(((C4802) PresetPagerItem.this.f1518.get(i)).m14515());
            } else {
                if (i2 != 5) {
                    return;
                }
                PresetPagerItem.this.f1520.mo1874(i, ((Integer) obj).intValue());
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.pager.PresetPagerItem$Ԩ, reason: contains not printable characters */
    public interface InterfaceC0780 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo1872(C3891 c3891);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo1873(C3891 c3891, String str);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo1874(int i, int i2);

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo1875(C3891 c3891);

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo1876(C3891 c3891);

        /* renamed from: Ԭ, reason: contains not printable characters */
        void mo1877(C3891 c3891);
    }

    public PresetPagerItem(@NonNull Context context) {
        this(context, null);
    }

    public void setData(List<C4802> list) {
        if (r1.m8144(this.f1518)) {
            this.f1518.clear();
        }
        this.f1518.addAll(list);
        C4321 c4321 = this.f1517;
        if (c4321 != null) {
            c4321.notifyDataSetChanged();
        }
    }

    public void setDealClick(InterfaceC0780 interfaceC0780) {
        this.f1520 = interfaceC0780;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m1866() {
        View childAt;
        LinearLayoutManager linearLayoutManager = this.f1519;
        if (linearLayoutManager == null || (childAt = linearLayoutManager.getChildAt(0)) == null || !(this.f1516.f13302.getChildViewHolder(childAt) instanceof C5267)) {
            return;
        }
        this.f1518.get(0).m14518(true);
        C5267 c5267 = (C5267) this.f1516.f13302.getChildViewHolder(childAt);
        c5267.m15320(0);
        c5267.m15318();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean m1867() {
        boolean z = false;
        if (r1.m8144(this.f1518)) {
            boolean z2 = false;
            for (int i = 0; i < this.f1518.size(); i++) {
                C4802 c4802 = this.f1518.get(i);
                if (c4802.m14516()) {
                    c4802.m14518(false);
                    View childAt = this.f1519.getChildAt(i);
                    if (childAt != null && (this.f1516.f13302.getChildViewHolder(childAt) instanceof C5267)) {
                        ((C5267) this.f1516.f13302.getChildViewHolder(childAt)).m15321();
                    }
                    z2 = true;
                }
            }
            z = z2;
        }
        if (z) {
            m1871();
        }
        return z;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m1868() {
        this.f1516 = AbstractC3865.m12313(LayoutInflater.from(getContext()), this, true);
        m1870();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m1869() {
        this.f1517 = new C4321(getContext(), this.f1518, new C0779());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m1870() {
        int iMin = Math.min(C4792.m14375().m14469(60), (int) (C2579.m9439(getContext()) * 0.101726264f));
        this.f1516.f13302.setPadding(iMin, 0, iMin, 0);
        this.f1518 = new ArrayList();
        m1869();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.f1519 = linearLayoutManager;
        this.f1516.f13302.setLayoutManager(linearLayoutManager);
        this.f1516.f13302.setNestedScrollingEnabled(false);
        this.f1516.f13302.setAdapter(this.f1517);
        C5101 c5101 = new C5101(getContext(), 1);
        c5101.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.preset_divider_item));
        this.f1516.f13302.addItemDecoration(c5101);
        this.f1516.f13302.setOverScrollMode(2);
        ((SimpleItemAnimator) this.f1516.f13302.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f1516.f13302.getItemAnimator().setChangeDuration(0L);
        this.f1516.f13302.setItemAnimator(null);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m1871() {
        C4321 c4321 = this.f1517;
        if (c4321 != null) {
            c4321.notifyDataSetChanged();
        }
    }

    public PresetPagerItem(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PresetPagerItem(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1868();
    }
}
