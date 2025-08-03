package com.blink.academy.film.widgets.looks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.protake.R;
import defpackage.AbstractC4975;
import defpackage.C2324;
import defpackage.C2579;
import defpackage.C2712;
import defpackage.C4008;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4734;
import defpackage.C4792;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FilmStopRecycleView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public C4194 f3723;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public ArrayList<C4196> f3724;

    /* renamed from: ԭ, reason: contains not printable characters */
    public LinearLayoutManager f3725;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3726;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f3727;

    /* renamed from: ՠ, reason: contains not printable characters */
    public ArrayList<Integer> f3728;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3729;

    /* renamed from: ֏, reason: contains not printable characters */
    public LinearLayout f3730;

    /* renamed from: ׯ, reason: contains not printable characters */
    public ImageView f3731;

    /* renamed from: ؠ, reason: contains not printable characters */
    public RelativeLayout f3732;

    /* renamed from: ހ, reason: contains not printable characters */
    public RecyclerView f3733;

    /* renamed from: ށ, reason: contains not printable characters */
    public LinearLayout f3734;

    /* renamed from: ނ, reason: contains not printable characters */
    public ImageView f3735;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f3736;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f3737;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f3738;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f3739;

    /* renamed from: އ, reason: contains not printable characters */
    public InterfaceC1323 f3740;

    /* renamed from: ވ, reason: contains not printable characters */
    public InterfaceC1321 f3741;

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$Ϳ, reason: contains not printable characters */
    public class C1315 implements AbstractC4975.InterfaceC4980 {
        public C1315() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3673(int i) {
            InterfaceC1321 interfaceC1321 = FilmStopRecycleView.this.f3741;
            if (interfaceC1321 == null || !interfaceC1321.mo3677()) {
                return;
            }
            FilmStopRecycleView.this.f3741.mo3679(i);
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo3674(int i) {
            InterfaceC1321 interfaceC1321 = FilmStopRecycleView.this.f3741;
            if (interfaceC1321 == null || !interfaceC1321.mo3677()) {
                return;
            }
            FilmStopRecycleView.this.f3741.mo3678(i);
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo3675() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo3676(float f) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            C4734 c4734;
            if ((FilmStopRecycleView.this.f3740 != null && !FilmStopRecycleView.this.f3740.mo2363()) || FilmStopRecycleView.this.f3736 == i || i == -1) {
                return;
            }
            C4196 c4196 = (C4196) FilmStopRecycleView.this.f3724.get(FilmStopRecycleView.this.f3736);
            int itemViewType = c4196.getItemViewType();
            c4196.setSelected(false);
            C4734 c47342 = null;
            if (itemViewType == 2) {
                c47342 = (C2712) FilmStopRecycleView.this.f3733.findViewHolderForAdapterPosition(FilmStopRecycleView.this.f3736);
                c4734 = (C2712) FilmStopRecycleView.this.f3733.findViewHolderForAdapterPosition(i);
            } else if (itemViewType == 3) {
                c47342 = (C2324) FilmStopRecycleView.this.f3733.findViewHolderForAdapterPosition(FilmStopRecycleView.this.f3736);
                c4734 = (C2324) FilmStopRecycleView.this.f3733.findViewHolderForAdapterPosition(i);
            } else {
                c4734 = null;
            }
            if (c47342 != null) {
                c47342.mo8729(false);
            }
            ((C4196) FilmStopRecycleView.this.f3724.get(i)).setSelected(true);
            if (c4734 != null) {
                c4734.mo8729(true);
            }
            FilmStopRecycleView.this.f3736 = i;
            if (FilmStopRecycleView.this.f3740 != null) {
                FilmStopRecycleView.this.f3740.mo2364(FilmStopRecycleView.this.f3736);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1316 implements View.OnClickListener {
        public ViewOnClickListenerC1316() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FilmStopRecycleView.this.m3667();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1317 implements View.OnClickListener {
        public ViewOnClickListenerC1317() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FilmStopRecycleView.this.m3668();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$Ԭ, reason: contains not printable characters */
    public class C1318 extends RecyclerView.OnScrollListener {
        public C1318() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            FilmStopRecycleView.this.f3735.setEnabled(false);
            FilmStopRecycleView.this.f3731.setEnabled(false);
            if (i == 0) {
                FilmStopRecycleView.this.m3658();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$Ԯ, reason: contains not printable characters */
    public class RunnableC1319 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC1322 f3746;

        public RunnableC1319(InterfaceC1322 interfaceC1322) {
            this.f3746 = interfaceC1322;
        }

        @Override // java.lang.Runnable
        public void run() {
            FilmStopRecycleView.this.f3723.notifyDataSetChanged();
            InterfaceC1322 interfaceC1322 = this.f3746;
            if (interfaceC1322 != null) {
                interfaceC1322.mo2365();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$ՠ, reason: contains not printable characters */
    public class RunnableC1320 implements Runnable {
        public RunnableC1320() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FilmStopRecycleView filmStopRecycleView = FilmStopRecycleView.this;
            filmStopRecycleView.m3657(filmStopRecycleView.f3735);
            FilmStopRecycleView filmStopRecycleView2 = FilmStopRecycleView.this;
            filmStopRecycleView2.m3657(filmStopRecycleView2.f3731);
            FilmStopRecycleView filmStopRecycleView3 = FilmStopRecycleView.this;
            filmStopRecycleView3.f3725 = (LinearLayoutManager) filmStopRecycleView3.f3733.getLayoutManager();
            if (FilmStopRecycleView.this.f3725 != null) {
                int iFindFirstCompletelyVisibleItemPosition = FilmStopRecycleView.this.f3725.findFirstCompletelyVisibleItemPosition();
                int iFindLastVisibleItemPosition = FilmStopRecycleView.this.f3725.findLastVisibleItemPosition();
                if (iFindFirstCompletelyVisibleItemPosition <= 0) {
                    FilmStopRecycleView filmStopRecycleView4 = FilmStopRecycleView.this;
                    filmStopRecycleView4.m3663(filmStopRecycleView4.f3731);
                }
                if (iFindLastVisibleItemPosition >= FilmStopRecycleView.this.f3724.size() - 1) {
                    FilmStopRecycleView filmStopRecycleView5 = FilmStopRecycleView.this;
                    filmStopRecycleView5.m3663(filmStopRecycleView5.f3735);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$ֈ, reason: contains not printable characters */
    public interface InterfaceC1321 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean mo3677();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo3678(int i);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo3679(int i);
    }

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$֏, reason: contains not printable characters */
    public interface InterfaceC1322 {
        /* renamed from: Ϳ */
        void mo2365();
    }

    /* renamed from: com.blink.academy.film.widgets.looks.FilmStopRecycleView$ׯ, reason: contains not printable characters */
    public interface InterfaceC1323 {
        /* renamed from: Ϳ */
        boolean mo2363();

        /* renamed from: Ԩ */
        void mo2364(int i);
    }

    public FilmStopRecycleView(@NonNull Context context) {
        this(context, null);
    }

    public void setCenterTextViewWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.f3733.getLayoutParams();
        layoutParams.width = i;
        this.f3733.setLayoutParams(layoutParams);
    }

    public void setCurrentI(int i) {
        this.f3736 = i;
        int i2 = 0;
        while (i2 < this.f3724.size()) {
            this.f3724.get(i2).setSelected(i2 == i);
            i2++;
        }
        m3664();
    }

    public void setCurrentIUnRefresh(int i) {
        this.f3736 = i;
        int i2 = 0;
        while (i2 < this.f3724.size()) {
            this.f3724.get(i2).setSelected(i2 == i);
            i2++;
        }
    }

    public void setDataList(ArrayList<C4196> arrayList) {
        this.f3724.clear();
        this.f3724.addAll(arrayList);
    }

    public void setMaxWidth(float f) {
        this.f3737 = f;
    }

    public void setOnLongClickListener(InterfaceC1321 interfaceC1321) {
        this.f3741 = interfaceC1321;
    }

    public void setOnStopClick(InterfaceC1323 interfaceC1323) {
        this.f3740 = interfaceC1323;
    }

    public void setScrollType(int i) {
        this.f3726 = i;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m3655(View view) {
        if (view == this.f3735) {
            this.f3734.setEnabled(false);
        } else {
            this.f3730.setEnabled(false);
        }
        view.setEnabled(false);
        view.setAlpha(this.f3738);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m3656() {
        m3655(this.f3735);
        m3655(this.f3731);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m3657(View view) {
        if (view == this.f3735) {
            this.f3734.setEnabled(true);
        } else {
            this.f3730.setEnabled(true);
        }
        view.setEnabled(true);
        view.setAlpha(1.0f);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m3658() {
        WeakHandler weakHandler = FilmApp.m405().f341;
        if (weakHandler != null) {
            weakHandler.postDelayed(new RunnableC1320(), 100L);
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m3659() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_stop_recycle, (ViewGroup) this, true);
        this.f3730 = (LinearLayout) findViewById(R.id.stop_pre_parent);
        this.f3731 = (ImageView) findViewById(R.id.iv_stop_pre);
        this.f3732 = (RelativeLayout) findViewById(R.id.tv_stop_parent);
        this.f3733 = (RecyclerView) findViewById(R.id.list_stop);
        this.f3734 = (LinearLayout) findViewById(R.id.stop_next_parent);
        this.f3735 = (ImageView) findViewById(R.id.iv_stop_next);
        m3661();
        m3662();
        m3660();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m3660() {
        this.f3723 = new C4194(getContext(), this.f3724, new C1315());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f3725 = linearLayoutManager;
        this.f3733.setLayoutManager(linearLayoutManager);
        this.f3733.setAdapter(this.f3723);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m3661() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3735.getLayoutParams();
        int iM14476 = (int) (C4792.m14375().m14476(100) * C4792.m14375().m14434());
        layoutParams.height = iM14476;
        layoutParams.width = iM14476;
        this.f3727 = C2579.m9438(44.0f);
        this.f3735.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3731.getLayoutParams();
        layoutParams2.height = layoutParams.height;
        layoutParams2.width = layoutParams.height;
        this.f3735.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f3730.getLayoutParams();
        layoutParams3.width = (int) this.f3727;
        this.f3730.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f3734.getLayoutParams();
        layoutParams4.width = (int) this.f3727;
        this.f3734.setLayoutParams(layoutParams4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m3662() {
        this.f3734.setOnClickListener(new ViewOnClickListenerC1316());
        this.f3730.setOnClickListener(new ViewOnClickListenerC1317());
        this.f3733.addOnScrollListener(new C1318());
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m3663(View view) {
        if (view == this.f3735) {
            this.f3734.setEnabled(false);
        } else {
            this.f3730.setEnabled(false);
        }
        view.setEnabled(false);
        view.setAlpha(this.f3739);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m3664() {
        C4194 c4194 = this.f3723;
        if (c4194 != null) {
            c4194.notifyDataSetChanged();
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m3665(InterfaceC1322 interfaceC1322) {
        if (this.f3723 == null || this.f3737 == 0.0f || m3671() == 0) {
            return;
        }
        new Handler().postDelayed(new RunnableC1319(interfaceC1322), 50L);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m3666(int i) {
        if (this.f3733 != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f3728.size()) {
                    i2 = 1;
                    break;
                } else if (this.f3728.get(i2).intValue() > i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != this.f3729) {
                this.f3733.smoothScrollBy((int) ((i2 - r6) * this.f3737), 0, C4008.m12881(), 100);
            }
            this.f3729 = i2;
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m3667() {
        if (this.f3729 == this.f3728.size() - 1) {
            return;
        }
        this.f3729++;
        for (int i = 0; i < this.f3728.size(); i++) {
            if (this.f3729 == i) {
                this.f3733.smoothScrollBy((int) this.f3737, 0, C4008.m12881(), 100);
            }
        }
        if (this.f3729 == this.f3728.size() - 1) {
            m3663(this.f3735);
        } else {
            m3657(this.f3735);
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m3668() {
        int i = this.f3729;
        if (i == 0) {
            return;
        }
        this.f3729 = i - 1;
        for (int i2 = 0; i2 < this.f3728.size(); i2++) {
            if (this.f3729 == i2) {
                this.f3733.smoothScrollBy((int) (-this.f3737), 0, C4008.m12881(), 100);
            }
        }
        if (this.f3729 == 0) {
            m3663(this.f3731);
        } else {
            m3657(this.f3731);
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m3669() {
        RecyclerView recyclerView = this.f3733;
        if (recyclerView == null || this.f3729 == 0) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
        this.f3729 = 0;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m3670() {
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public int m3671() {
        int i;
        int i2;
        int i3;
        this.f3728.clear();
        if (this.f3737 == 0.0f) {
            return 0;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14386());
        textPaint.setTypeface(FilmApp.m404());
        int iCeil = 0;
        int i4 = 0;
        int iCeil2 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.f3724.size(); i6++) {
            C4196 c4196 = this.f3724.get(i6);
            String string = c4196.m13233() != 0 ? getResources().getString(c4196.m13233()) : c4196.m13232();
            i4++;
            iCeil2 += (int) Math.ceil(textPaint.measureText(string) + C4792.f16138);
            if ((C4792.m14375().m14476(60) * 2 * i4) + iCeil2 >= this.f3737) {
                int i7 = i4 - 1;
                iCeil = (int) (((this.f3737 - (iCeil2 - ((int) Math.ceil(textPaint.measureText(string) + C4792.f16138)))) / i7) / 2.0f);
                int i8 = i5;
                while (true) {
                    i2 = i7 + i5;
                    if (i8 >= i2) {
                        break;
                    }
                    this.f3724.get(i8).m13248(iCeil);
                    i8++;
                }
                this.f3728.add(Integer.valueOf(i2));
                int iCeil3 = ((int) Math.ceil(textPaint.measureText(string) + C4792.f16138)) + 0;
                if (i6 == this.f3724.size() - 1) {
                    iCeil = (int) (((this.f3737 - iCeil3) / 1) / 2.0f);
                    int i9 = i2;
                    while (true) {
                        i3 = 1 + i2;
                        if (i9 >= i3) {
                            break;
                        }
                        this.f3724.get(i9).m13248(iCeil);
                        i9++;
                    }
                    this.f3728.add(Integer.valueOf(i3));
                    i4 = 0;
                    iCeil2 = 0;
                    i5 = 0;
                } else {
                    iCeil2 = iCeil3;
                    i4 = 1;
                    i5 = i2;
                }
            } else if (i6 == this.f3724.size() - 1) {
                iCeil = (int) (((this.f3737 - iCeil2) / i4) / 2.0f);
                int i10 = i5;
                while (true) {
                    i = i4 + i5;
                    if (i10 >= i) {
                        break;
                    }
                    this.f3724.get(i10).m13248(iCeil);
                    i10++;
                }
                this.f3728.add(Integer.valueOf(i));
                i4 = 0;
                iCeil2 = 0;
                i5 = 0;
            }
        }
        return iCeil;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m3672(int i, int i2) {
        setMaxWidth(i - (this.f3727 * 2.0f));
        m3665(null);
    }

    public FilmStopRecycleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilmStopRecycleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3724 = new ArrayList<>();
        this.f3728 = new ArrayList<>();
        this.f3738 = 0.2f;
        this.f3739 = 0.2f;
        m3659();
    }
}
