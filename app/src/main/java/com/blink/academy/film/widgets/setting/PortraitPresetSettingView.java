package com.blink.academy.film.widgets.setting;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC5232;
import defpackage.C2545;
import defpackage.C2579;
import defpackage.C3891;
import defpackage.C4291;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.C4802;
import defpackage.C5101;
import defpackage.InterfaceC4172;
import defpackage.r1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PortraitPresetSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC5232 f3973;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C2545 f3974;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<C4802> f3975;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public LinearLayoutManager f3976;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC1411 f3977;

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitPresetSettingView$Ϳ, reason: contains not printable characters */
    public class C1410 implements InterfaceC4172 {
        public C1410() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if (PortraitPresetSettingView.this.f3977 != null) {
                PortraitPresetSettingView.this.f3977.mo1744(((C4802) PortraitPresetSettingView.this.f3975.get(i)).m14515());
            }
        }

        @Override // defpackage.InterfaceC4172
        /* renamed from: ՠ */
        public void mo1559(int i, int i2, Object obj) {
            int iIntValue;
            if (i2 == 1) {
                if (PortraitPresetSettingView.this.f3977 != null) {
                    PortraitPresetSettingView.this.f3977.mo1742(((C4802) PortraitPresetSettingView.this.f3975.get(i)).m14515(), (String) obj);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (PortraitPresetSettingView.this.f3977 != null) {
                    PortraitPresetSettingView.this.f3977.mo1745(((C4802) PortraitPresetSettingView.this.f3975.get(i)).m14515());
                    return;
                }
                return;
            }
            if (i2 == 3) {
                if (PortraitPresetSettingView.this.f3977 != null) {
                    PortraitPresetSettingView.this.f3977.mo1746(((C4802) PortraitPresetSettingView.this.f3975.get(i)).m14515());
                }
            } else if (i2 == 4) {
                if (PortraitPresetSettingView.this.f3977 != null) {
                    PortraitPresetSettingView.this.f3977.mo1743(((C4802) PortraitPresetSettingView.this.f3975.get(i)).m14515());
                }
            } else {
                if (i2 != 5 || (iIntValue = ((Integer) obj).intValue()) == -1 || iIntValue == i) {
                    return;
                }
                PortraitPresetSettingView.this.f3974.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitPresetSettingView$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1411 {
        /* renamed from: Ϳ */
        void mo1742(C3891 c3891, String str);

        /* renamed from: Ԩ */
        void mo1743(C3891 c3891);

        /* renamed from: ԩ */
        void mo1744(C3891 c3891);

        /* renamed from: Ԫ */
        void mo1745(C3891 c3891);

        /* renamed from: ԫ */
        void mo1746(C3891 c3891);
    }

    public PortraitPresetSettingView(@NonNull Context context) {
        this(context, null);
    }

    public void setData(List<C4802> list) {
        if (r1.m8144(this.f3975)) {
            this.f3975.clear();
        }
        this.f3975.addAll(list);
        C2545 c2545 = this.f3974;
        if (c2545 != null) {
            c2545.notifyDataSetChanged();
        }
    }

    public void setOnButtonClick(InterfaceC1411 interfaceC1411) {
        this.f3977 = interfaceC1411;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m3979() {
        View childAt;
        LinearLayoutManager linearLayoutManager = this.f3976;
        if (linearLayoutManager == null || (childAt = linearLayoutManager.getChildAt(0)) == null || !(this.f3973.f17347.getChildViewHolder(childAt) instanceof C4291)) {
            return;
        }
        this.f3975.get(0).m14518(true);
        C4291 c4291 = (C4291) this.f3973.f17347.getChildViewHolder(childAt);
        c4291.m13414(0);
        c4291.m13412();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m3980() {
        boolean z = false;
        if (r1.m8144(this.f3975)) {
            boolean z2 = false;
            for (int i = 0; i < this.f3975.size(); i++) {
                C4802 c4802 = this.f3975.get(i);
                if (c4802.m14516()) {
                    c4802.m14518(false);
                    View childAt = this.f3976.getChildAt(i);
                    if (childAt != null && (this.f3973.f17347.getChildViewHolder(childAt) instanceof C4291)) {
                        ((C4291) this.f3973.f17347.getChildViewHolder(childAt)).m13415();
                    }
                    z2 = true;
                }
            }
            z = z2;
        }
        if (z) {
            m3985();
        }
        return z;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m3981() {
        this.f3973 = AbstractC5232.m15249(LayoutInflater.from(getContext()), this, true);
        m3983();
        this.f3973.f17348.setTypeface(FilmApp.m404());
        this.f3973.f17348.setTextSize(0, C4792.m14375().m14381());
        this.f3973.f17348.setTextColor(Color.parseColor("#4cffffff"));
        this.f3973.f17348.setText(getResources().getString(R.string.SETTINGS_PRESET_EMPTY));
        m3986();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m3982() {
        this.f3974 = new C2545(getContext(), this.f3975, new C1410());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m3983() {
        this.f3973.f17347.setPadding(C2579.m9438(30.0f), 0, C2579.m9438(30.0f), 0);
        this.f3975 = new ArrayList();
        m3982();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.f3976 = linearLayoutManager;
        this.f3973.f17347.setLayoutManager(linearLayoutManager);
        this.f3973.f17347.setNestedScrollingEnabled(false);
        this.f3973.f17347.setAdapter(this.f3974);
        C5101 c5101 = new C5101(getContext(), 1);
        c5101.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.preset_divider_item2));
        this.f3973.f17347.addItemDecoration(c5101);
        this.f3973.f17347.setOverScrollMode(2);
        ((SimpleItemAnimator) this.f3973.f17347.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f3973.f17347.getItemAnimator().setChangeDuration(0L);
        this.f3973.f17347.setItemAnimator(null);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3984(int i) {
        if (i == 1) {
            this.f3973.f17347.scrollToPosition(0);
        }
        m3986();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m3985() {
        C2545 c2545 = this.f3974;
        if (c2545 != null) {
            c2545.notifyDataSetChanged();
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m3986() {
        this.f3975.clear();
        List<C3891> listM13889 = C4535.m13880().m13889();
        if (r1.m8144(listM13889)) {
            for (C3891 c3891 : listM13889) {
                if (!c3891.m12493()) {
                    C4802 c4802 = new C4802();
                    c4802.m14517(c3891);
                    this.f3975.add(c4802);
                }
            }
        }
        if (r1.m8144(this.f3975)) {
            this.f3973.f17346.setVisibility(8);
        } else {
            this.f3973.f17346.setVisibility(0);
        }
        this.f3974.notifyDataSetChanged();
    }

    public PortraitPresetSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PortraitPresetSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3981();
    }
}
