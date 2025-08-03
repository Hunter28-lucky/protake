package com.blink.academy.film.widgets.looks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.looks.StyleDownloadingView;
import com.blink.academy.film.widgets.looks.StyleUpdateView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4253;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C2685;
import defpackage.C4008;
import defpackage.C4102;
import defpackage.C4151;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4511;
import defpackage.C4792;
import defpackage.h0;
import defpackage.o4;
import defpackage.r1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LooksPreviewView extends FrameLayout implements View.OnClickListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4253 f3780;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f3781;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3782;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C2685> f3783;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f3784;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3785;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f3786;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f3787;

    /* renamed from: ׯ, reason: contains not printable characters */
    public C4194 f3788;

    /* renamed from: ؠ, reason: contains not printable characters */
    public LinearLayoutManager f3789;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f3790;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f3791;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3792;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f3793;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f3794;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f3795;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f3796;

    /* renamed from: އ, reason: contains not printable characters */
    public int f3797;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f3798;

    /* renamed from: މ, reason: contains not printable characters */
    public int f3799;

    /* renamed from: ފ, reason: contains not printable characters */
    public InterfaceC1338 f3800;

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewView$Ϳ, reason: contains not printable characters */
    public class C1332 implements StyleDownloadingView.InterfaceC1355 {
        public C1332() {
        }

        @Override // com.blink.academy.film.widgets.looks.StyleDownloadingView.InterfaceC1355
        /* renamed from: Ԩ */
        public void mo3732() {
            InterfaceC1338 interfaceC1338;
            if (LooksPreviewView.this.m3762() || (interfaceC1338 = LooksPreviewView.this.f3800) == null) {
                return;
            }
            interfaceC1338.mo3786();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewView$Ԩ, reason: contains not printable characters */
    public class C1333 implements StyleUpdateView.InterfaceC1357 {
        public C1333() {
        }

        @Override // com.blink.academy.film.widgets.looks.StyleUpdateView.InterfaceC1357
        /* renamed from: Ϳ */
        public void mo3733() {
            InterfaceC1338 interfaceC1338;
            if (LooksPreviewView.this.m3762() || (interfaceC1338 = LooksPreviewView.this.f3800) == null) {
                return;
            }
            interfaceC1338.mo3785();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewView$Ԫ, reason: contains not printable characters */
    public class C1334 extends RecyclerView.OnScrollListener {
        public C1334() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            View viewFindViewByPosition;
            super.onScrolled(recyclerView, i, i2);
            LooksPreviewView looksPreviewView = LooksPreviewView.this;
            int iFindFirstVisibleItemPosition = looksPreviewView.f3789.findFirstVisibleItemPosition();
            looksPreviewView.f3797 = iFindFirstVisibleItemPosition;
            int i3 = LooksPreviewView.this.f3792 - LooksPreviewView.this.f3791;
            if (C4511.m13838().m13848(iFindFirstVisibleItemPosition).m6143()) {
                LooksPreviewView looksPreviewView2 = LooksPreviewView.this;
                looksPreviewView2.f3798 = looksPreviewView2.f3797;
            } else {
                int size = LooksPreviewView.this.f3784.size() - 1;
                if (iFindFirstVisibleItemPosition < LooksPreviewView.this.f3784.size() - 1) {
                    size = iFindFirstVisibleItemPosition + 1;
                }
                if (C4511.m13838().m13848(size).m6143()) {
                    LooksPreviewView.this.f3798 = size;
                }
            }
            LooksPreviewView looksPreviewView3 = LooksPreviewView.this;
            if (looksPreviewView3.f3798 == 0 || (viewFindViewByPosition = looksPreviewView3.f3789.findViewByPosition(LooksPreviewView.this.f3798)) == null) {
                return;
            }
            int left = viewFindViewByPosition.getLeft();
            h0 h0VarM13848 = C4511.m13838().m13848(LooksPreviewView.this.f3798);
            h0 h0VarM138482 = C4511.m13838().m13848(LooksPreviewView.this.f3797);
            int i4 = LooksPreviewView.this.f3792;
            LooksPreviewView looksPreviewView4 = LooksPreviewView.this;
            int i5 = i4 + looksPreviewView4.f3796 + looksPreviewView4.f3791;
            int i6 = (-LooksPreviewView.this.f3792) - LooksPreviewView.this.f3791;
            if (left <= 0) {
                LooksPreviewView.this.f3780.f14590.setAlpha(1.0f);
                LooksPreviewView looksPreviewView5 = LooksPreviewView.this;
                looksPreviewView5.m3783(looksPreviewView5.f3780.f14590, h0VarM13848);
                LooksPreviewView looksPreviewView6 = LooksPreviewView.this;
                if (left < (i6 - looksPreviewView6.f3796) - looksPreviewView6.f3795) {
                    if (i != 0) {
                        looksPreviewView6.m3775(h0VarM13848, !h0VarM13848.m6148(), true);
                    }
                } else if (i != 0) {
                    looksPreviewView6.m3775(h0VarM13848, h0VarM13848.m6148(), false);
                }
                LooksPreviewView looksPreviewView7 = LooksPreviewView.this;
                if (looksPreviewView7.f3796 == 0) {
                    looksPreviewView7.f3780.f14591.setAlpha(0.0f);
                    LooksPreviewView looksPreviewView8 = LooksPreviewView.this;
                    looksPreviewView8.m3783(looksPreviewView8.f3780.f14591, h0VarM138482);
                }
                if (i > 0) {
                    LooksPreviewView.this.m3782(0.0f, 0);
                    return;
                } else {
                    LooksPreviewView looksPreviewView9 = LooksPreviewView.this;
                    looksPreviewView9.m3782(0.0f, i6 - looksPreviewView9.f3796);
                    return;
                }
            }
            if (left >= i5) {
                LooksPreviewView.this.f3780.f14591.setAlpha(0.0f);
                LooksPreviewView looksPreviewView10 = LooksPreviewView.this;
                looksPreviewView10.m3783(looksPreviewView10.f3780.f14591, h0VarM138482);
                if (i > 0) {
                    LooksPreviewView.this.m3782(0.0f, 0);
                } else {
                    LooksPreviewView looksPreviewView11 = LooksPreviewView.this;
                    looksPreviewView11.m3782(0.0f, i6 - looksPreviewView11.f3796);
                }
                LooksPreviewView.this.f3780.f14590.setAlpha(1.0f);
                LooksPreviewView looksPreviewView12 = LooksPreviewView.this;
                looksPreviewView12.m3783(looksPreviewView12.f3780.f14590, h0VarM138482);
                if (left > i3) {
                    if (i != 0) {
                        LooksPreviewView.this.m3775(h0VarM13848, !h0VarM13848.m6148(), true);
                        return;
                    }
                    return;
                } else {
                    if (i != 0) {
                        LooksPreviewView.this.m3775(h0VarM13848, h0VarM13848.m6148(), false);
                        return;
                    }
                    return;
                }
            }
            LooksPreviewView looksPreviewView13 = LooksPreviewView.this;
            int i7 = looksPreviewView13.f3799 - i;
            looksPreviewView13.f3799 = i7;
            if (i7 <= 0 || i >= 0) {
                int i8 = looksPreviewView13.f3796;
                if (i7 < i6 - i8 && i > 0) {
                    looksPreviewView13.f3799 = i6 - i8;
                }
            } else {
                looksPreviewView13.f3799 = 0;
            }
            looksPreviewView13.m3782(1.0f, looksPreviewView13.f3799);
            LooksPreviewView looksPreviewView14 = LooksPreviewView.this;
            looksPreviewView14.m3783(looksPreviewView14.f3780.f14591, h0VarM138482);
            if (left >= i3) {
                if (i != 0) {
                    LooksPreviewView.this.m3775(h0VarM13848, !h0VarM13848.m6148(), true);
                }
                LooksPreviewView.this.f3780.f14590.setAlpha(0.0f);
                LooksPreviewView looksPreviewView15 = LooksPreviewView.this;
                looksPreviewView15.m3783(looksPreviewView15.f3780.f14590, h0VarM138482);
                return;
            }
            LooksPreviewView.this.f3780.f14590.setAlpha(1.0f);
            LooksPreviewView looksPreviewView16 = LooksPreviewView.this;
            looksPreviewView16.m3783(looksPreviewView16.f3780.f14590, h0VarM13848);
            if (i != 0) {
                LooksPreviewView.this.m3775(h0VarM13848, h0VarM13848.m6148(), false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewView$Ԭ, reason: contains not printable characters */
    public class C1335 implements AbstractC4975.InterfaceC4980 {
        public C1335() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ϳ */
        public void mo3673(int i) {
            if (LooksPreviewView.this.m3774(C4511.m13838().m13848(i)) || LooksPreviewView.this.f3800 == null) {
                return;
            }
            int iM13231 = C4511.m13838().m13841(i).m13231();
            if (i == 0 || iM13231 == 2) {
                return;
            }
            if (LooksPreviewView.this.f3785 == i) {
                LooksPreviewView.this.f3800.mo3792(i);
            } else {
                LooksPreviewView.this.f3800.mo3789(i);
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ԩ */
        public void mo3674(int i) {
            if (LooksPreviewView.this.m3774(C4511.m13838().m13848(i)) || LooksPreviewView.this.f3800 == null) {
                return;
            }
            int iM13231 = C4511.m13838().m13841(i).m13231();
            if (i == 0 || iM13231 == 2) {
                return;
            }
            if (LooksPreviewView.this.f3785 == i) {
                LooksPreviewView.this.f3800.mo3790(i);
            } else {
                LooksPreviewView.this.f3800.mo3793(i);
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: ԩ */
        public void mo3675() {
            InterfaceC1338 interfaceC1338 = LooksPreviewView.this.f3800;
            if (interfaceC1338 != null) {
                interfaceC1338.mo3787();
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ԫ */
        public void mo3676(float f) {
            if (LooksPreviewView.this.f3800 != null) {
                h0 h0VarM13848 = C4511.m13838().m13848(LooksPreviewView.this.f3785);
                int iM6136 = h0VarM13848.m6136();
                h0VarM13848.m6175(f);
                LooksPreviewView.this.f3800.mo3788(iM6136, f);
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            InterfaceC1338 interfaceC1338;
            if (i == -1) {
                return;
            }
            if (LooksPreviewView.this.m3774(C4511.m13838().m13848(i)) && (interfaceC1338 = LooksPreviewView.this.f3800) != null) {
                interfaceC1338.mo3794(i);
                return;
            }
            InterfaceC1338 interfaceC13382 = LooksPreviewView.this.f3800;
            if (interfaceC13382 == null || interfaceC13382.mo3791()) {
                C1360 c1360 = (C1360) LooksPreviewView.this.f3780.f14588.findViewHolderForAdapterPosition(LooksPreviewView.this.f3785);
                if (LooksPreviewView.this.f3785 == i) {
                    if (C4511.m13838().m13839()) {
                        C4196 c4196M13841 = C4511.m13838().m13841(LooksPreviewView.this.f3785);
                        if (C4511.m13838().m13846(c4196M13841) == 1) {
                            LooksPreviewView.this.f3790 = true;
                            C4511.m13838().m13861(LooksPreviewView.this.f3790);
                            C4511.m13838().m13862(2, c4196M13841);
                            if (c1360 != null) {
                                c1360.m3878(2, LooksPreviewView.this.f3785);
                                return;
                            } else {
                                LooksPreviewView.this.f3788.notifyItemChanged(LooksPreviewView.this.f3785);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                h0 h0VarM13848 = C4511.m13838().m13848(i);
                if (h0VarM13848 != null) {
                    LooksPreviewView.this.f3790 = false;
                    C4511.m13838().m13861(LooksPreviewView.this.f3790);
                    int iM13844 = C4511.m13838().m13844(h0VarM13848);
                    C4511.m13838().m13858(LooksPreviewView.this.f3785);
                    if (c1360 != null) {
                        c1360.m3878(0, LooksPreviewView.this.f3785);
                        c1360.m3877(i == 0, 100.0f);
                    } else {
                        LooksPreviewView.this.f3788.notifyItemChanged(LooksPreviewView.this.f3785);
                    }
                    C4511.m13838().m13856(i);
                    C1360 c13602 = (C1360) LooksPreviewView.this.f3780.f14588.findViewHolderForAdapterPosition(i);
                    if (c13602 != null) {
                        c13602.m3878(1, i);
                        c13602.m3877(i == 0, 100.0f);
                    } else {
                        LooksPreviewView.this.f3788.notifyItemChanged(i);
                    }
                    InterfaceC1338 interfaceC13383 = LooksPreviewView.this.f3800;
                    if (interfaceC13383 != null) {
                        interfaceC13383.mo3788(iM13844, C4511.m13838().m13847(h0VarM13848));
                        LooksPreviewView.this.f3800.mo3787();
                    }
                }
                LooksPreviewView.this.f3785 = i;
                C4511.m13838().m13855(i);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewView$Ԯ, reason: contains not printable characters */
    public class RunnableC1336 implements Runnable {
        public RunnableC1336() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewFindViewByPosition;
            int iFindFirstCompletelyVisibleItemPosition = LooksPreviewView.this.f3789.findFirstCompletelyVisibleItemPosition();
            int iFindFirstVisibleItemPosition = LooksPreviewView.this.f3789.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = LooksPreviewView.this.f3789.findLastVisibleItemPosition();
            if (r1.m8139(LooksPreviewView.this.f3784)) {
                return;
            }
            h0 h0VarM13848 = C4511.m13838().m13848(iFindFirstCompletelyVisibleItemPosition);
            if (iFindFirstVisibleItemPosition != iFindFirstCompletelyVisibleItemPosition) {
                h0 h0VarM138482 = C4511.m13838().m13848(iFindFirstVisibleItemPosition);
                LooksPreviewView looksPreviewView = LooksPreviewView.this;
                looksPreviewView.m3783(looksPreviewView.f3780.f14591, h0VarM138482);
                LooksPreviewView looksPreviewView2 = LooksPreviewView.this;
                looksPreviewView2.m3783(looksPreviewView2.f3780.f14590, h0VarM138482);
            } else {
                if (iFindFirstCompletelyVisibleItemPosition > 0) {
                    h0 h0VarM138483 = C4511.m13838().m13848(iFindFirstCompletelyVisibleItemPosition - 1);
                    LooksPreviewView looksPreviewView3 = LooksPreviewView.this;
                    looksPreviewView3.m3783(looksPreviewView3.f3780.f14591, h0VarM138483);
                } else {
                    LooksPreviewView looksPreviewView4 = LooksPreviewView.this;
                    looksPreviewView4.m3783(looksPreviewView4.f3780.f14591, h0VarM13848);
                }
                LooksPreviewView looksPreviewView5 = LooksPreviewView.this;
                looksPreviewView5.m3783(looksPreviewView5.f3780.f14590, h0VarM13848);
            }
            for (int i = 0; i < LooksPreviewView.this.f3784.size(); i++) {
                if (i >= iFindFirstVisibleItemPosition && i <= iFindLastVisibleItemPosition) {
                    h0 h0VarM138484 = C4511.m13838().m13848(i);
                    if (h0VarM138484.m6143() && (viewFindViewByPosition = LooksPreviewView.this.f3789.findViewByPosition(i)) != null && viewFindViewByPosition.getLeft() >= (-(C4792.m14375().m14477(32.0f, LooksPreviewView.this.f3786) + LooksPreviewView.this.f3795)) && viewFindViewByPosition.getLeft() <= LooksPreviewView.this.f3792 - C4792.m14375().m14477(32.0f, LooksPreviewView.this.f3786)) {
                        h0VarM138484.m6172(false);
                        LooksPreviewView.this.f3793 = false;
                        C4511.m13838().m13860(LooksPreviewView.this.f3793);
                    }
                }
            }
            if (LooksPreviewView.this.f3788 != null) {
                LooksPreviewView.this.f3788.notifyDataSetChanged();
                LooksPreviewView.this.f3785 = C4511.m13838().m13840();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewView$ՠ, reason: contains not printable characters */
    public class C1337 extends AbstractC4012 {
        public C1337() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewView$ֈ, reason: contains not printable characters */
    public interface InterfaceC1338 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo3785();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo3786();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo3787();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo3788(int i, float f);

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo3789(int i);

        /* renamed from: Ԭ, reason: contains not printable characters */
        void mo3790(int i);

        /* renamed from: ԭ, reason: contains not printable characters */
        boolean mo3791();

        /* renamed from: Ԯ, reason: contains not printable characters */
        void mo3792(int i);

        /* renamed from: ԯ, reason: contains not printable characters */
        void mo3793(int i);

        /* renamed from: ՠ, reason: contains not printable characters */
        void mo3794(int i);
    }

    public LooksPreviewView(@NonNull Context context) {
        this(context, null);
    }

    public int getCurrentStylePos() {
        return C4511.m13838().m13840();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3782 = i2;
        if (this.f3781) {
            return;
        }
        m3764(0, null);
    }

    public void setCurrentStylePos(int i) {
        this.f3785 = i;
        C4511.m13838().m13855(i);
    }

    public void setDownloadProgress(String str) {
        if (this.f3780.f14587 != null) {
            String str2 = String.format(getResources().getString(R.string.LOOKS_DOWNLOADING), String.format("(%s%s)", str, "%"));
            this.f3780.f14587.setShowType(1);
            this.f3780.f14587.setContentText(str2);
        }
    }

    public void setDownloadSize(long j) {
        if (this.f3780.f14587 != null) {
            String str = String.format(getResources().getString(R.string.LOOKS_DOWNLOAD), String.format("(%s)", o4.m7682(j)));
            this.f3780.f14587.setShowType(0);
            this.f3780.f14587.setContentText(str);
        }
    }

    public void setOnLooksStyleChangeListener(InterfaceC1338 interfaceC1338) {
        this.f3800 = interfaceC1338;
    }

    public void setPadding(int i) {
        this.f3794 = i;
    }

    public void setUpdateProgress(String str) {
        if (this.f3780.f14589 != null) {
            this.f3780.f14589.setContentText(String.format(getResources().getString(R.string.LOOKS_DOWNLOADING), String.format("(%s%s)", str, "%")));
        }
    }

    public void setUpdateSize(long j) {
        if (this.f3780.f14589 != null) {
            this.f3780.f14589.setContentText(String.format(getResources().getString(R.string.LOOKS_UPDATE_AVAILABLE), String.format("(%s)", o4.m7682(j))));
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final boolean m3762() {
        if (this.f3787 == 0) {
            this.f3787 = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - this.f3787 < 200) {
            return true;
        }
        this.f3787 = System.currentTimeMillis();
        return false;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public int m3763(int i) {
        return C4792.m14375().m14477(i, this.f3786);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m3764(int i, AbstractC4012 abstractC4012) {
        this.f3781 = false;
        this.f3789.scrollToPositionWithOffset(0, 0);
        C4008.m12886(this, 0.0f, this.f3782, i, abstractC4012);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m3765() {
        this.f3780 = (AbstractC4253) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_looks_preview, this, true);
        this.f3786 = C4792.m14375().m14434();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3780.f14586.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = C4792.m14375().m14408();
        this.f3780.f14586.m2562(0, C4792.m14375().m14381());
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (this.f3780.f14586.getPaint().measureText(getContext().getString(R.string.RECORDING_SETTINGS_TITLE_LOOKS).toUpperCase()) + C4792.f16138);
        this.f3780.f14586.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f3780.f14584.getLayoutParams();
        layoutParams2.height = C4792.m14375().m14406();
        this.f3780.f14584.setLayoutParams(layoutParams2);
        setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3780.f14587.getLayoutParams();
        layoutParams3.topMargin = (int) (m3763(80) * this.f3786);
        this.f3780.f14587.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f3780.f14589.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = layoutParams2.height - ((int) (this.f3780.f14589.getUpdateHeight() / 2.0f));
        this.f3780.f14589.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f3780.f14592.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = this.f3780.f14589.getWidth();
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) (this.f3780.f14589.getUpdateHeight() + C2579.m9438(20.0f));
        this.f3780.f14592.setLayoutParams(layoutParams5);
        this.f3780.f14590.setContentTextColor(-1);
        this.f3780.f14590.m2562(0, C4792.m14375().m14397());
        this.f3780.f14590.setContentTypeFace(FilmApp.m404());
        this.f3780.f14591.setContentTextColor(-1);
        this.f3780.f14591.m2562(0, C4792.m14375().m14397());
        this.f3780.f14591.setContentTypeFace(FilmApp.m404());
        if (C4792.m14375().m14498()) {
            this.f3792 = C2579.m9438(10.0f);
        } else {
            this.f3792 = (int) (C2579.m9438(10.0f) + C4792.m14375().m14442());
        }
        this.f3791 = C4792.m14375().m14477(32.0f, this.f3786);
        m3766();
        m3767();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m3766() {
        this.f3784 = C4511.m13838().m13843();
        this.f3788 = new C4194(getContext(), this.f3784, new C1335());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f3789 = linearLayoutManager;
        this.f3780.f14588.setLayoutManager(linearLayoutManager);
        this.f3780.f14588.setAdapter(this.f3788);
        this.f3780.f14588.addItemDecoration(new C4102("right_decoration", this.f3791));
        if (this.f3780.f14588.getItemAnimator() != null) {
            ((DefaultItemAnimator) this.f3780.f14588.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f3780.f14588.getItemAnimator().setChangeDuration(0L);
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m3767() {
        this.f3780.f14587.setOnDownloadListener(new C1332());
        this.f3780.f14589.setOnUpdateListener(new C1333());
        this.f3780.f14588.addOnScrollListener(new C1334());
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean m3768() {
        return this.f3790;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final boolean m3769() {
        return C4151.m13162().m13176() == 3;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean m3770() {
        return this.f3781;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final boolean m3771() {
        return C4151.m13162().m13176() == 4;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final boolean m3772() {
        return C4151.m13162().m13176() == 2;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final boolean m3773() {
        return C4151.m13162().m13176() == 1;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final boolean m3774(h0 h0Var) {
        return C4511.m13838().m13853(h0Var);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m3775(h0 h0Var, boolean z, boolean z2) {
        if (z) {
            h0Var.m6172(z2);
            this.f3793 = z2;
            C4511.m13838().m13860(this.f3793);
            this.f3788.notifyItemChanged(this.f3798);
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m3776() {
        if (m3778()) {
            return;
        }
        C4511.m13838().m13854();
        this.f3785 = C4511.m13838().m13840();
        this.f3789.findFirstCompletelyVisibleItemPosition();
        this.f3789.findLastCompletelyVisibleItemPosition();
        this.f3785 = C4511.m13838().m13840();
        int i = C4792.m14375().m14498() ? 1 : 2;
        int i2 = this.f3785;
        if (i2 >= i) {
            this.f3789.scrollToPositionWithOffset(i2 - i, 0);
        } else {
            this.f3789.scrollToPositionWithOffset(0, 0);
        }
        new Handler().postDelayed(new RunnableC1336(), 50L);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m3777() throws Resources.NotFoundException {
        m3780();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean m3778() {
        if (m3772()) {
            this.f3780.f14589.setVisibility(8);
            this.f3780.f14587.setVisibility(0);
            this.f3780.f14588.setVisibility(8);
            this.f3780.f14590.setVisibility(8);
            this.f3780.f14591.setVisibility(8);
            this.f3780.f14587.setShowType(0);
            setDownloadSize(C4151.m13162().m13178());
            return true;
        }
        if (m3769()) {
            this.f3780.f14589.setVisibility(8);
            this.f3780.f14587.setVisibility(0);
            this.f3780.f14588.setVisibility(8);
            this.f3780.f14590.setVisibility(8);
            this.f3780.f14591.setVisibility(8);
            this.f3780.f14587.setShowType(1);
            return true;
        }
        if (m3773()) {
            this.f3780.f14589.setVisibility(0);
            this.f3780.f14587.setVisibility(8);
            this.f3780.f14588.setVisibility(0);
            this.f3780.f14590.setVisibility(0);
            this.f3780.f14591.setVisibility(0);
            setUpdateSize(C4151.m13162().m13187());
        } else if (m3771()) {
            this.f3780.f14589.setVisibility(0);
            this.f3780.f14587.setVisibility(8);
            this.f3780.f14588.setVisibility(0);
            this.f3780.f14590.setVisibility(0);
            this.f3780.f14591.setVisibility(0);
        } else {
            this.f3780.f14589.setVisibility(8);
            this.f3780.f14587.setVisibility(8);
            this.f3780.f14588.setVisibility(0);
            this.f3780.f14590.setVisibility(0);
            this.f3780.f14591.setVisibility(0);
        }
        return false;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m3779(StrokeTextView strokeTextView, String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) strokeTextView.getLayoutParams();
        TextPaint paint = strokeTextView.getPaint();
        if (r1.m8138(str)) {
            layoutParams.width = 0;
        } else {
            layoutParams.width = (int) (paint.measureText(str) + C4792.f16138);
        }
        if (strokeTextView == this.f3780.f14591) {
            this.f3796 = layoutParams.width;
        } else {
            this.f3795 = layoutParams.width;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        layoutParams.leftMargin = this.f3792;
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        layoutParams.topMargin = (int) (((C4792.m14375().m14406() - (((((fontMetrics2.bottom - fontMetrics2.top) + C4792.f16138) * 2.0f) + C4792.m14375().m14477(40.0f, this.f3786)) + C4792.m14375().m14477(262.0f, this.f3786))) / 2.0f) + 0.5f);
        strokeTextView.setLayoutParams(layoutParams);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m3780() throws Resources.NotFoundException {
        C4511.m13838().m13849();
        this.f3784 = C4511.m13838().m13843();
        this.f3788.notifyDataSetChanged();
        this.f3785 = C4511.m13838().m13840();
        m3778();
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m3781() {
        if (r1.m8144(this.f3784)) {
            C4511.m13838().m13841(this.f3785).m13250(1);
            this.f3790 = false;
            C4511.m13838().m13861(this.f3790);
            C1360 c1360 = (C1360) this.f3780.f14588.findViewHolderForAdapterPosition(this.f3785);
            if (c1360 != null) {
                c1360.m3878(1, this.f3785);
            }
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m3782(float f, int i) {
        this.f3780.f14591.setAlpha(f);
        this.f3799 = i;
        this.f3780.f14591.setTranslationX(i);
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m3783(StrokeTextView strokeTextView, h0 h0Var) {
        String strM13842 = C4511.m13838().m13842(h0Var);
        strokeTextView.setText(strM13842);
        m3779(strokeTextView, strM13842);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m3784(int i) {
        this.f3781 = true;
        this.f3790 = false;
        C4511.m13838().m13861(this.f3790);
        m3776();
        C4008.m12886(this, 0.0f, 0.0f, i, new C1337());
    }

    public LooksPreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LooksPreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3783 = new ArrayList<>();
        this.f3784 = new ArrayList<>();
        this.f3797 = 0;
        this.f3798 = 0;
        this.f3799 = 0;
        m3765();
    }
}
