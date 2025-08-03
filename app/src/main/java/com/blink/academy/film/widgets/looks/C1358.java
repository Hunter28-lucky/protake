package com.blink.academy.film.widgets.looks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blink.academy.film.netbean.store.FilterGroupCollectionBean;
import com.blink.academy.film.widgets.looks.C1358;
import com.blink.academy.film.widgets.looks.PreviewItemView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C4196;
import defpackage.C4734;
import defpackage.C4792;
import defpackage.C5213;
import defpackage.h0;
import defpackage.r1;

/* compiled from: StylePortraitPreviewViewHolder.java */
/* renamed from: com.blink.academy.film.widgets.looks.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1358 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final PreviewItemView f3866;

    /* renamed from: ԯ, reason: contains not printable characters */
    public AbstractC4975.InterfaceC4980 f3867;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final PreviewItemView.InterfaceC1353 f3868;

    /* compiled from: StylePortraitPreviewViewHolder.java */
    /* renamed from: com.blink.academy.film.widgets.looks.Ϳ$Ϳ, reason: contains not printable characters */
    public class C1359 implements PreviewItemView.InterfaceC1353 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4980 f3869;

        public C1359(AbstractC4975.InterfaceC4980 interfaceC4980) {
            this.f3869 = interfaceC4980;
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: Ϳ */
        public void mo3854() {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3869;
            if (interfaceC4980 != null) {
                interfaceC4980.mo1558(C1358.this.getAdapterPosition());
            }
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: Ԩ */
        public void mo3855() {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3869;
            if (interfaceC4980 != null) {
                interfaceC4980.mo3673(C1358.this.getAdapterPosition());
            }
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: ԩ */
        public void mo3856() {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3869;
            if (interfaceC4980 != null) {
                interfaceC4980.mo3675();
            }
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: Ԫ */
        public void mo3857(float f) {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3869;
            if (interfaceC4980 != null) {
                interfaceC4980.mo3676(f);
            }
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: ԫ */
        public void mo3858() {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3869;
            if (interfaceC4980 != null) {
                interfaceC4980.mo3674(C1358.this.getAdapterPosition());
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public C1358(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4980 interfaceC4980) {
        super(view, context, interfaceC4977, interfaceC4980);
        this.f3866 = (PreviewItemView) view;
        this.f3867 = interfaceC4980;
        view.setOnClickListener(new View.OnClickListener() { // from class: i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C1358.m3870(view2);
            }
        });
        this.f3868 = new C1359(interfaceC4980);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static /* synthetic */ void m3870(View view) {
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo3871(C4196 c4196, int i) {
        String name_th;
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        super.mo3871(c4196, i);
        this.f3866.setStyleName(String.format("%s", c4196.m13232()));
        h0 h0VarM13228 = c4196.m13228();
        ((ViewGroup.MarginLayoutParams) new StaggeredGridLayoutManager.LayoutParams(-2, -2)).height = this.f3866.getTotalHeight();
        FilterGroupCollectionBean filterGroupCollectionBeanM6140 = h0VarM13228.m6140();
        if (!r1.m8142(filterGroupCollectionBeanM6140)) {
            name_th = "";
        } else if (C5213.m15210()) {
            name_th = filterGroupCollectionBeanM6140.getName_cn();
            if (C5213.m15219() && r1.m8143(filterGroupCollectionBeanM6140.getName_zht())) {
                name_th = filterGroupCollectionBeanM6140.getName_zht();
            }
        } else {
            name_th = C5213.m15217() ? filterGroupCollectionBeanM6140.getName_th() : C5213.m15216() ? filterGroupCollectionBeanM6140.getName_kr() : C5213.m15213() ? filterGroupCollectionBeanM6140.getName_ja() : filterGroupCollectionBeanM6140.getName_en();
        }
        if (h0VarM13228.m6144() && h0VarM13228.m6127() % 2 == 0) {
            layoutParams = new StaggeredGridLayoutManager.LayoutParams(-2, -1);
            layoutParams.setFullSpan(true);
            this.f3866.setLayoutParams(layoutParams);
        } else if (h0VarM13228.m6144() && h0VarM13228.m6127() % 2 == 1 && r1.m8138(name_th)) {
            layoutParams = new StaggeredGridLayoutManager.LayoutParams(-2, -1);
            layoutParams.setFullSpan(true);
            this.f3866.setLayoutParams(layoutParams);
        } else {
            layoutParams = new StaggeredGridLayoutManager.LayoutParams(-2, -2);
        }
        int iM14477 = C4792.m14375().m14477(52.0f, C4792.m14375().m14434()) + ((int) ((C2579.f9594 - C2579.m9450(m10050())) / 2.0f));
        int iM144772 = C4792.m14375().m14477(32.0f, C4792.m14375().m14434());
        this.f3866.m3850("", 0);
        if (h0VarM13228.m6149()) {
            this.f3866.setPaddingLeft(iM14477);
        } else if (h0VarM13228.m6142()) {
            this.f3866.setPaddingRight(iM14477);
        } else if (h0VarM13228.m6143() && r1.m8143(name_th)) {
            this.f3866.setPaddingLeft(iM144772);
            if (h0VarM13228.m6148()) {
                this.f3866.m3850(name_th, filterGroupCollectionBeanM6140.getFilter_groups().length);
            } else {
                this.f3866.m3850("", 0);
            }
        } else if (h0VarM13228.m6145() && r1.m8143(name_th)) {
            this.f3866.setPaddingLeft(iM144772);
        } else {
            this.f3866.m3850("", 0);
            this.f3866.setPaddingLeft(0);
            this.f3866.setPaddingRight(0);
        }
        this.f3866.setLayoutParams(layoutParams);
        if (getAdapterPosition() == 0 || c4196.m13231() == 3) {
            this.f3866.setPreviewIv(R.drawable.portrait);
        } else {
            this.f3866.m3851(h0VarM13228.m6137(), R.drawable.portrait);
        }
        m3874(c4196.m13231(), getAdapterPosition());
        this.f3866.m3853(getAdapterPosition() == 0, h0VarM13228.m6139());
        this.f3866.setOnStrengthChange(this.f3868);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m3873(boolean z, float f) {
        this.f3866.m3853(z, f);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3874(int i, int i2) {
        this.f3866.m3852(i, i2);
    }
}
