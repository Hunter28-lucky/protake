package com.blink.academy.film.widgets.looks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blink.academy.film.netbean.store.FilterGroupCollectionBean;
import com.blink.academy.film.widgets.looks.C1360;
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

/* compiled from: StylePreviewViewHolder.java */
/* renamed from: com.blink.academy.film.widgets.looks.Ԩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1360 extends C4734 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final PreviewItemView f3871;

    /* renamed from: ԯ, reason: contains not printable characters */
    public AbstractC4975.InterfaceC4980 f3872;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final PreviewItemView.InterfaceC1353 f3873;

    /* compiled from: StylePreviewViewHolder.java */
    /* renamed from: com.blink.academy.film.widgets.looks.Ԩ$Ϳ, reason: contains not printable characters */
    public class C1361 implements PreviewItemView.InterfaceC1353 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC4975.InterfaceC4980 f3874;

        public C1361(AbstractC4975.InterfaceC4980 interfaceC4980) {
            this.f3874 = interfaceC4980;
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: Ϳ */
        public void mo3854() {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3874;
            if (interfaceC4980 != null) {
                interfaceC4980.mo1558(C1360.this.getAdapterPosition());
            }
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: Ԩ */
        public void mo3855() {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3874;
            if (interfaceC4980 != null) {
                interfaceC4980.mo3673(C1360.this.getAdapterPosition());
            }
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: ԩ */
        public void mo3856() {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3874;
            if (interfaceC4980 != null) {
                interfaceC4980.mo3675();
            }
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: Ԫ */
        public void mo3857(float f) {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3874;
            if (interfaceC4980 != null) {
                interfaceC4980.mo3676(f);
            }
        }

        @Override // com.blink.academy.film.widgets.looks.PreviewItemView.InterfaceC1353
        /* renamed from: ԫ */
        public void mo3858() {
            AbstractC4975.InterfaceC4980 interfaceC4980 = this.f3874;
            if (interfaceC4980 != null) {
                interfaceC4980.mo3674(C1360.this.getAdapterPosition());
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public C1360(View view, Context context, AbstractC4975.InterfaceC4977<C4196> interfaceC4977, AbstractC4975.InterfaceC4980 interfaceC4980) {
        super(view, context, interfaceC4977, interfaceC4980);
        PreviewItemView previewItemView = (PreviewItemView) view;
        this.f3871 = previewItemView;
        this.f3872 = interfaceC4980;
        ViewGroup.LayoutParams layoutParams = previewItemView.getLayoutParams();
        layoutParams = layoutParams == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams;
        layoutParams.width = -2;
        layoutParams.height = -2;
        previewItemView.setLayoutParams(layoutParams);
        view.setOnClickListener(new View.OnClickListener() { // from class: j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C1360.m3876(view2);
            }
        });
        this.f3873 = new C1361(interfaceC4980);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static /* synthetic */ void m3876(View view) {
    }

    @Override // defpackage.C4734, defpackage.AbstractC2769
    /* renamed from: Ԫ */
    public void mo3871(C4196 c4196, int i) {
        String name_th;
        super.mo3871(c4196, i);
        this.f3871.setStyleName(String.format("%s", c4196.m13232()));
        h0 h0VarM13228 = c4196.m13228();
        if (getAdapterPosition() == 0 || c4196.m13231() == 3) {
            this.f3871.setPreviewIv(R.drawable.portrait);
        } else {
            this.f3871.m3851(h0VarM13228.m6137(), R.drawable.portrait);
        }
        m3878(c4196.m13231(), getAdapterPosition());
        this.f3871.m3853(getAdapterPosition() == 0, h0VarM13228.m6139());
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
        int iM14477 = C4792.m14375().m14477(52.0f, C4792.m14375().m14434()) + ((int) ((C2579.f9594 - C2579.m9450(m10050())) / 2.0f));
        int iM144772 = C4792.m14375().m14477(32.0f, C4792.m14375().m14434());
        this.f3871.m3850("", 0);
        if (getAdapterPosition() == 0) {
            this.f3871.setPaddingLeft(iM14477);
        } else if (getAdapterPosition() == m14765().mo11699().size() - 1) {
            this.f3871.setPaddingRight(iM14477);
        } else if (h0VarM13228.m6143() && r1.m8143(name_th)) {
            this.f3871.setPaddingLeft(iM144772);
            if (h0VarM13228.m6148()) {
                this.f3871.m3850(name_th, filterGroupCollectionBeanM6140.getFilter_groups().length);
            } else {
                this.f3871.m3850("", 0);
            }
        } else {
            this.f3871.m3850("", 0);
            this.f3871.setPaddingLeft(0);
            this.f3871.setPaddingRight(0);
        }
        this.f3871.setOnStrengthChange(this.f3873);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m3877(boolean z, float f) {
        this.f3871.m3853(z, f);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3878(int i, int i2) {
        this.f3871.m3852(i, i2);
    }
}
