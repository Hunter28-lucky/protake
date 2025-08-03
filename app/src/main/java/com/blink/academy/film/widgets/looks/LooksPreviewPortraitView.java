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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.netbean.store.FilterGroupCollectionBean;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.looks.StyleDownloadingView;
import com.blink.academy.film.widgets.looks.StyleUpdateView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4281;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C3444;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4102;
import defpackage.C4151;
import defpackage.C4194;
import defpackage.C4196;
import defpackage.C4511;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.C5213;
import defpackage.h0;
import defpackage.o4;
import defpackage.r1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LooksPreviewPortraitView extends FrameLayout implements View.OnClickListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4281 f3749;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f3750;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3751;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f3752;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f3753;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3754;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f3755;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f3756;

    /* renamed from: ׯ, reason: contains not printable characters */
    public C4194 f3757;

    /* renamed from: ؠ, reason: contains not printable characters */
    public StaggeredGridLayoutManager f3758;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f3759;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f3760;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3761;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f3762;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f3763;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f3764;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f3765;

    /* renamed from: އ, reason: contains not printable characters */
    public int f3766;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f3767;

    /* renamed from: މ, reason: contains not printable characters */
    public int f3768;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f3769;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f3770;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f3771;

    /* renamed from: ލ, reason: contains not printable characters */
    public InterfaceC1331 f3772;

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewPortraitView$Ϳ, reason: contains not printable characters */
    public class C1324 implements StyleDownloadingView.InterfaceC1355 {
        public C1324() {
        }

        @Override // com.blink.academy.film.widgets.looks.StyleDownloadingView.InterfaceC1355
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo3732() {
            InterfaceC1331 interfaceC1331;
            if (LooksPreviewPortraitView.this.m3700() || (interfaceC1331 = LooksPreviewPortraitView.this.f3772) == null) {
                return;
            }
            interfaceC1331.mo3735();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewPortraitView$Ԩ, reason: contains not printable characters */
    public class C1325 implements StyleUpdateView.InterfaceC1357 {
        public C1325() {
        }

        @Override // com.blink.academy.film.widgets.looks.StyleUpdateView.InterfaceC1357
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3733() {
            InterfaceC1331 interfaceC1331;
            if (LooksPreviewPortraitView.this.m3700() || (interfaceC1331 = LooksPreviewPortraitView.this.f3772) == null) {
                return;
            }
            interfaceC1331.mo3734();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewPortraitView$Ԫ, reason: contains not printable characters */
    public class C1326 extends RecyclerView.OnScrollListener {
        public C1326() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            View viewFindViewByPosition;
            super.onScrolled(recyclerView, i, i2);
            int[] iArrFindFirstVisibleItemPositions = LooksPreviewPortraitView.this.f3758.findFirstVisibleItemPositions(new int[2]);
            LooksPreviewPortraitView looksPreviewPortraitView = LooksPreviewPortraitView.this;
            int i3 = iArrFindFirstVisibleItemPositions[0];
            looksPreviewPortraitView.f3766 = i3;
            int i4 = looksPreviewPortraitView.f3761 - LooksPreviewPortraitView.this.f3760;
            if (((C4196) LooksPreviewPortraitView.this.f3752.get(i3)).m13228().m6143()) {
                LooksPreviewPortraitView looksPreviewPortraitView2 = LooksPreviewPortraitView.this;
                looksPreviewPortraitView2.f3767 = looksPreviewPortraitView2.f3766;
            } else {
                int size = LooksPreviewPortraitView.this.f3752.size() - 1;
                if (i3 < LooksPreviewPortraitView.this.f3752.size() - 1) {
                    size = (LooksPreviewPortraitView.this.m3714(i3) || LooksPreviewPortraitView.this.m3712(i3)) ? i3 + 1 : i3 + 2;
                }
                if (((C4196) LooksPreviewPortraitView.this.f3752.get(size)).m13228().m6143()) {
                    LooksPreviewPortraitView.this.f3767 = size;
                }
            }
            LooksPreviewPortraitView looksPreviewPortraitView3 = LooksPreviewPortraitView.this;
            if (looksPreviewPortraitView3.f3767 == 0 || (viewFindViewByPosition = looksPreviewPortraitView3.f3758.findViewByPosition(LooksPreviewPortraitView.this.f3767)) == null) {
                return;
            }
            int left = viewFindViewByPosition.getLeft();
            h0 h0VarM13228 = ((C4196) LooksPreviewPortraitView.this.f3752.get(LooksPreviewPortraitView.this.f3767)).m13228();
            h0 h0VarM132282 = ((C4196) LooksPreviewPortraitView.this.f3752.get(LooksPreviewPortraitView.this.f3766)).m13228();
            int i5 = LooksPreviewPortraitView.this.f3761;
            LooksPreviewPortraitView looksPreviewPortraitView4 = LooksPreviewPortraitView.this;
            int i6 = i5 + looksPreviewPortraitView4.f3765 + looksPreviewPortraitView4.f3760;
            int i7 = (-LooksPreviewPortraitView.this.f3761) - LooksPreviewPortraitView.this.f3760;
            if (left <= 0) {
                LooksPreviewPortraitView.this.f3749.f14674.setAlpha(1.0f);
                LooksPreviewPortraitView looksPreviewPortraitView5 = LooksPreviewPortraitView.this;
                looksPreviewPortraitView5.m3729(looksPreviewPortraitView5.f3749.f14674, h0VarM13228);
                LooksPreviewPortraitView looksPreviewPortraitView6 = LooksPreviewPortraitView.this;
                if (left < (i7 - looksPreviewPortraitView6.f3765) - looksPreviewPortraitView6.f3764) {
                    if (i != 0) {
                        looksPreviewPortraitView6.m3720(h0VarM13228, !h0VarM13228.m6148(), true);
                    }
                } else if (i != 0) {
                    looksPreviewPortraitView6.m3720(h0VarM13228, h0VarM13228.m6148(), false);
                }
                LooksPreviewPortraitView looksPreviewPortraitView7 = LooksPreviewPortraitView.this;
                if (looksPreviewPortraitView7.f3765 == 0) {
                    looksPreviewPortraitView7.f3749.f14675.setAlpha(0.0f);
                    LooksPreviewPortraitView looksPreviewPortraitView8 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView8.m3729(looksPreviewPortraitView8.f3749.f14675, h0VarM132282);
                }
                if (i > 0) {
                    LooksPreviewPortraitView.this.m3728(0.0f, 0);
                    return;
                } else {
                    LooksPreviewPortraitView looksPreviewPortraitView9 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView9.m3728(0.0f, i7 - looksPreviewPortraitView9.f3765);
                    return;
                }
            }
            if (left >= i6) {
                LooksPreviewPortraitView.this.f3749.f14675.setAlpha(0.0f);
                LooksPreviewPortraitView looksPreviewPortraitView10 = LooksPreviewPortraitView.this;
                looksPreviewPortraitView10.m3729(looksPreviewPortraitView10.f3749.f14675, h0VarM132282);
                if (i > 0) {
                    LooksPreviewPortraitView.this.m3728(0.0f, 0);
                } else {
                    LooksPreviewPortraitView looksPreviewPortraitView11 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView11.m3728(0.0f, i7 - looksPreviewPortraitView11.f3765);
                }
                LooksPreviewPortraitView.this.f3749.f14674.setAlpha(1.0f);
                LooksPreviewPortraitView looksPreviewPortraitView12 = LooksPreviewPortraitView.this;
                looksPreviewPortraitView12.m3729(looksPreviewPortraitView12.f3749.f14674, h0VarM132282);
                if (left > i4) {
                    if (i != 0) {
                        LooksPreviewPortraitView.this.m3720(h0VarM13228, !h0VarM13228.m6148(), true);
                        return;
                    }
                    return;
                } else {
                    if (i != 0) {
                        LooksPreviewPortraitView.this.m3720(h0VarM13228, h0VarM13228.m6148(), false);
                        return;
                    }
                    return;
                }
            }
            LooksPreviewPortraitView looksPreviewPortraitView13 = LooksPreviewPortraitView.this;
            int i8 = looksPreviewPortraitView13.f3768 - i;
            looksPreviewPortraitView13.f3768 = i8;
            if (i8 <= 0 || i >= 0) {
                int i9 = looksPreviewPortraitView13.f3765;
                if (i8 < i7 - i9 && i > 0) {
                    looksPreviewPortraitView13.f3768 = i7 - i9;
                }
            } else {
                looksPreviewPortraitView13.f3768 = 0;
            }
            looksPreviewPortraitView13.m3728(1.0f, looksPreviewPortraitView13.f3768);
            LooksPreviewPortraitView looksPreviewPortraitView14 = LooksPreviewPortraitView.this;
            looksPreviewPortraitView14.m3729(looksPreviewPortraitView14.f3749.f14675, h0VarM132282);
            if (left >= i4) {
                if (i != 0) {
                    LooksPreviewPortraitView.this.m3720(h0VarM13228, !h0VarM13228.m6148(), true);
                }
                LooksPreviewPortraitView.this.f3749.f14674.setAlpha(0.0f);
                LooksPreviewPortraitView looksPreviewPortraitView15 = LooksPreviewPortraitView.this;
                looksPreviewPortraitView15.m3729(looksPreviewPortraitView15.f3749.f14674, h0VarM132282);
                return;
            }
            LooksPreviewPortraitView.this.f3749.f14674.setAlpha(1.0f);
            LooksPreviewPortraitView looksPreviewPortraitView16 = LooksPreviewPortraitView.this;
            looksPreviewPortraitView16.m3729(looksPreviewPortraitView16.f3749.f14674, h0VarM13228);
            if (i != 0) {
                LooksPreviewPortraitView.this.m3720(h0VarM13228, h0VarM13228.m6148(), false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewPortraitView$Ԭ, reason: contains not printable characters */
    public class C1327 implements AbstractC4975.InterfaceC4980 {
        public C1327() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ϳ */
        public void mo3673(int i) {
            LooksPreviewPortraitView looksPreviewPortraitView = LooksPreviewPortraitView.this;
            if (looksPreviewPortraitView.m3719(((C4196) looksPreviewPortraitView.f3752.get(i)).m13228())) {
                return;
            }
            LooksPreviewPortraitView looksPreviewPortraitView2 = LooksPreviewPortraitView.this;
            if (looksPreviewPortraitView2.f3772 != null) {
                int iM13231 = ((C4196) looksPreviewPortraitView2.f3752.get(i)).m13231();
                if (i == 0 || iM13231 == 2) {
                    return;
                }
                if (LooksPreviewPortraitView.this.f3754 == i) {
                    LooksPreviewPortraitView looksPreviewPortraitView3 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView3.f3772.mo3741(((C4196) looksPreviewPortraitView3.f3752.get(i)).m13228().m6136());
                } else {
                    LooksPreviewPortraitView looksPreviewPortraitView4 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView4.f3772.mo3738(((C4196) looksPreviewPortraitView4.f3752.get(i)).m13228().m6136());
                }
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ԩ */
        public void mo3674(int i) {
            LooksPreviewPortraitView looksPreviewPortraitView = LooksPreviewPortraitView.this;
            if (looksPreviewPortraitView.m3719(((C4196) looksPreviewPortraitView.f3752.get(i)).m13228())) {
                return;
            }
            LooksPreviewPortraitView looksPreviewPortraitView2 = LooksPreviewPortraitView.this;
            if (looksPreviewPortraitView2.f3772 != null) {
                int iM13231 = ((C4196) looksPreviewPortraitView2.f3752.get(i)).m13231();
                if (i == 0 || iM13231 == 2) {
                    return;
                }
                if (LooksPreviewPortraitView.this.f3754 == i) {
                    LooksPreviewPortraitView looksPreviewPortraitView3 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView3.f3772.mo3739(((C4196) looksPreviewPortraitView3.f3752.get(i)).m13228().m6136());
                } else {
                    LooksPreviewPortraitView looksPreviewPortraitView4 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView4.f3772.mo3742(((C4196) looksPreviewPortraitView4.f3752.get(i)).m13228().m6136());
                }
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: ԩ */
        public void mo3675() {
            InterfaceC1331 interfaceC1331 = LooksPreviewPortraitView.this.f3772;
            if (interfaceC1331 != null) {
                interfaceC1331.mo3736();
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4980
        /* renamed from: Ԫ */
        public void mo3676(float f) {
            LooksPreviewPortraitView looksPreviewPortraitView = LooksPreviewPortraitView.this;
            if (looksPreviewPortraitView.f3772 != null) {
                h0 h0VarM13228 = ((C4196) looksPreviewPortraitView.f3752.get(LooksPreviewPortraitView.this.f3754)).m13228();
                int iM6136 = h0VarM13228.m6136();
                h0VarM13228.m6175(f);
                LooksPreviewPortraitView.this.f3772.mo3737(iM6136, f);
            }
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            LooksPreviewPortraitView looksPreviewPortraitView;
            InterfaceC1331 interfaceC1331;
            if (i == -1) {
                return;
            }
            LooksPreviewPortraitView looksPreviewPortraitView2 = LooksPreviewPortraitView.this;
            if (looksPreviewPortraitView2.m3719(((C4196) looksPreviewPortraitView2.f3752.get(i)).m13228()) && (interfaceC1331 = (looksPreviewPortraitView = LooksPreviewPortraitView.this).f3772) != null) {
                interfaceC1331.mo3743(((C4196) looksPreviewPortraitView.f3752.get(i)).m13228().m6136());
                return;
            }
            InterfaceC1331 interfaceC13312 = LooksPreviewPortraitView.this.f3772;
            if (interfaceC13312 == null || interfaceC13312.mo3740()) {
                C1358 c1358 = (C1358) LooksPreviewPortraitView.this.f3749.f14672.findViewHolderForAdapterPosition(LooksPreviewPortraitView.this.f3754);
                if (LooksPreviewPortraitView.this.f3754 == i) {
                    if (C4511.m13838().m13839()) {
                        C4196 c4196 = (C4196) LooksPreviewPortraitView.this.f3752.get(LooksPreviewPortraitView.this.f3754);
                        if (C4511.m13838().m13846(c4196) == 1) {
                            LooksPreviewPortraitView.this.f3759 = true;
                            C4511.m13838().m13861(LooksPreviewPortraitView.this.f3759);
                            C4511.m13838().m13862(2, c4196);
                            if (c1358 != null) {
                                c1358.m3874(2, LooksPreviewPortraitView.this.f3754);
                                return;
                            } else {
                                LooksPreviewPortraitView.this.f3757.notifyItemChanged(LooksPreviewPortraitView.this.f3754);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                h0 h0VarM13228 = ((C4196) LooksPreviewPortraitView.this.f3752.get(i)).m13228();
                if (h0VarM13228 != null) {
                    LooksPreviewPortraitView.this.f3759 = false;
                    C4511.m13838().m13861(LooksPreviewPortraitView.this.f3759);
                    int iM13844 = C4511.m13838().m13844(h0VarM13228);
                    C4511.m13838().m13859(LooksPreviewPortraitView.this.f3752, LooksPreviewPortraitView.this.f3754);
                    if (c1358 != null) {
                        c1358.m3874(0, LooksPreviewPortraitView.this.f3754);
                        c1358.m3873(i == 0, 100.0f);
                    } else {
                        LooksPreviewPortraitView.this.f3757.notifyItemChanged(LooksPreviewPortraitView.this.f3754);
                    }
                    C4511.m13838().m13857(LooksPreviewPortraitView.this.f3752, i);
                    C1358 c13582 = (C1358) LooksPreviewPortraitView.this.f3749.f14672.findViewHolderForAdapterPosition(i);
                    if (c13582 != null) {
                        c13582.m3874(1, i);
                        c13582.m3873(i == 0, 100.0f);
                    } else {
                        LooksPreviewPortraitView.this.f3757.notifyItemChanged(i);
                    }
                    InterfaceC1331 interfaceC13313 = LooksPreviewPortraitView.this.f3772;
                    if (interfaceC13313 != null) {
                        interfaceC13313.mo3737(iM13844, C4511.m13838().m13847(h0VarM13228));
                        LooksPreviewPortraitView.this.f3772.mo3736();
                    }
                }
                LooksPreviewPortraitView.this.f3754 = i;
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewPortraitView$Ԯ, reason: contains not printable characters */
    public class RunnableC1328 implements Runnable {
        public RunnableC1328() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LooksPreviewPortraitView looksPreviewPortraitView = LooksPreviewPortraitView.this;
            if (looksPreviewPortraitView.m3714(looksPreviewPortraitView.f3754)) {
                LooksPreviewPortraitView.this.f3758.scrollToPositionWithOffset(LooksPreviewPortraitView.this.f3754 - 1, 0);
            } else {
                LooksPreviewPortraitView.this.f3758.scrollToPositionWithOffset(LooksPreviewPortraitView.this.f3754, 0);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewPortraitView$ՠ, reason: contains not printable characters */
    public class RunnableC1329 implements Runnable {
        public RunnableC1329() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewFindViewByPosition;
            int[] iArrFindFirstCompletelyVisibleItemPositions = LooksPreviewPortraitView.this.f3758.findFirstCompletelyVisibleItemPositions(new int[2]);
            int[] iArrFindFirstVisibleItemPositions = LooksPreviewPortraitView.this.f3758.findFirstVisibleItemPositions(new int[2]);
            int[] iArrFindLastVisibleItemPositions = LooksPreviewPortraitView.this.f3758.findLastVisibleItemPositions(new int[2]);
            int i = iArrFindFirstCompletelyVisibleItemPositions[0];
            int i2 = iArrFindFirstVisibleItemPositions[0];
            int i3 = iArrFindLastVisibleItemPositions[0];
            if (r1.m8139(LooksPreviewPortraitView.this.f3752) || i == -1) {
                return;
            }
            h0 h0VarM13228 = ((C4196) LooksPreviewPortraitView.this.f3752.get(i)).m13228();
            if (i2 != i) {
                h0 h0VarM132282 = ((C4196) LooksPreviewPortraitView.this.f3752.get(i2)).m13228();
                LooksPreviewPortraitView looksPreviewPortraitView = LooksPreviewPortraitView.this;
                looksPreviewPortraitView.m3729(looksPreviewPortraitView.f3749.f14675, h0VarM132282);
                LooksPreviewPortraitView looksPreviewPortraitView2 = LooksPreviewPortraitView.this;
                looksPreviewPortraitView2.m3729(looksPreviewPortraitView2.f3749.f14674, h0VarM132282);
            } else {
                if (i > 0) {
                    h0 h0VarM132283 = ((C4196) LooksPreviewPortraitView.this.f3752.get(i - 1)).m13228();
                    LooksPreviewPortraitView looksPreviewPortraitView3 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView3.m3729(looksPreviewPortraitView3.f3749.f14675, h0VarM132283);
                } else {
                    LooksPreviewPortraitView looksPreviewPortraitView4 = LooksPreviewPortraitView.this;
                    looksPreviewPortraitView4.m3729(looksPreviewPortraitView4.f3749.f14675, h0VarM13228);
                }
                LooksPreviewPortraitView looksPreviewPortraitView5 = LooksPreviewPortraitView.this;
                looksPreviewPortraitView5.m3729(looksPreviewPortraitView5.f3749.f14674, h0VarM13228);
            }
            for (int i4 = 0; i4 < LooksPreviewPortraitView.this.f3752.size(); i4++) {
                if (i4 >= i2 && i4 <= i3) {
                    h0 h0VarM132284 = ((C4196) LooksPreviewPortraitView.this.f3752.get(i4)).m13228();
                    if (h0VarM132284.m6143() && (viewFindViewByPosition = LooksPreviewPortraitView.this.f3758.findViewByPosition(i4)) != null && viewFindViewByPosition.getLeft() >= (-(C4792.m14375().m14477(32.0f, LooksPreviewPortraitView.this.f3755) + LooksPreviewPortraitView.this.f3764)) && viewFindViewByPosition.getLeft() <= LooksPreviewPortraitView.this.f3761 - C4792.m14375().m14477(32.0f, LooksPreviewPortraitView.this.f3755)) {
                        h0VarM132284.m6172(false);
                        LooksPreviewPortraitView.this.f3762 = false;
                        C4511.m13838().m13860(LooksPreviewPortraitView.this.f3762);
                    }
                }
            }
            if (LooksPreviewPortraitView.this.f3757 != null) {
                LooksPreviewPortraitView.this.f3757.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewPortraitView$ֈ, reason: contains not printable characters */
    public class C1330 extends AbstractC4012 {
        public C1330() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksPreviewPortraitView$֏, reason: contains not printable characters */
    public interface InterfaceC1331 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo3734();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo3735();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo3736();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo3737(int i, float f);

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo3738(int i);

        /* renamed from: Ԭ, reason: contains not printable characters */
        void mo3739(int i);

        /* renamed from: ԭ, reason: contains not printable characters */
        boolean mo3740();

        /* renamed from: Ԯ, reason: contains not printable characters */
        void mo3741(int i);

        /* renamed from: ԯ, reason: contains not printable characters */
        void mo3742(int i);

        /* renamed from: ՠ, reason: contains not printable characters */
        void mo3743(int i);
    }

    public LooksPreviewPortraitView(@NonNull Context context) {
        this(context, null);
    }

    public int getCurrentStylePos() {
        for (int i = 0; i < this.f3752.size(); i++) {
            h0 h0VarM13228 = this.f3752.get(i).m13228();
            if (this.f3754 == i) {
                return h0VarM13228.m6135();
            }
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3751 = (int) (i2 + ((C2579.m9444() - C2579.m9439(getContext())) / 2.0f));
        if (this.f3750) {
            return;
        }
        m3705(0, null);
    }

    public void setCurrentStylePos(int i) {
        for (int i2 = 0; i2 < this.f3752.size(); i2++) {
            if (this.f3752.get(i2).m13228().m6135() == i) {
                this.f3754 = i2;
            }
        }
    }

    public void setDownloadProgress(String str) {
        if (this.f3749.f14671 != null) {
            String str2 = String.format(getResources().getString(R.string.LOOKS_DOWNLOADING), String.format("(%s%s)", str, "%"));
            this.f3749.f14671.setShowType(1);
            this.f3749.f14671.setContentText(str2);
        }
    }

    public void setDownloadSize(long j) {
        if (this.f3749.f14671 != null) {
            String str = String.format(getResources().getString(R.string.LOOKS_DOWNLOAD), String.format("(%s)", o4.m7682(j)));
            this.f3749.f14671.setShowType(0);
            this.f3749.f14671.setContentText(str);
        }
    }

    public void setOnLooksStyleChangeListener(InterfaceC1331 interfaceC1331) {
        this.f3772 = interfaceC1331;
    }

    public void setPadding(int i) {
        this.f3763 = i;
    }

    public void setUpdateProgress(String str) {
        if (this.f3749.f14673 != null) {
            this.f3749.f14673.setContentText(String.format(getResources().getString(R.string.LOOKS_DOWNLOADING), String.format("(%s%s)", str, "%")));
        }
    }

    public void setUpdateSize(long j) {
        if (this.f3749.f14673 != null) {
            this.f3749.f14673.setContentText(String.format(getResources().getString(R.string.LOOKS_UPDATE_AVAILABLE), String.format("(%s)", o4.m7682(j))));
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final boolean m3700() {
        if (this.f3756 == 0) {
            this.f3756 = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - this.f3756 < 200) {
            return true;
        }
        this.f3756 = System.currentTimeMillis();
        return false;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final int m3701(boolean z, int i) {
        int iM6127 = this.f3752.get(i).m13228().m6127();
        return (z ? iM6127 % 2 == 0 ? iM6127 / 2 : (iM6127 + 1) / 2 : iM6127 % 2 == 0 ? iM6127 / 2 : (iM6127 - 1) / 2) + 1;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final int m3702(boolean z, int i) {
        return (i - m3701(z, i)) + 1;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final int m3703(boolean z, int i) {
        int length = this.f3752.get(i).m13228().m6140().getFilter_groups().length;
        return ((z ? length % 2 == 0 ? (length / 2) + 1 : (length + 1) / 2 : length % 2 == 0 ? length / 2 : (length + 1) / 2) + i) - m3701(z, i);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public int m3704(int i) {
        return C4792.m14375().m14477(i, this.f3755);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m3705(int i, AbstractC4012 abstractC4012) {
        this.f3750 = false;
        this.f3758.scrollToPositionWithOffset(0, 0);
        C4008.m12886(this, 0.0f, this.f3751, i, abstractC4012);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m3706() {
        this.f3749 = (AbstractC4281) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_looks_portrait_preview, this, true);
        this.f3755 = C4792.m14375().m14434();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3749.f14670.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = C4792.m14375().m14408();
        this.f3749.f14670.m2562(0, C4792.m14375().m14381());
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (this.f3749.f14670.getPaint().measureText(getContext().getString(R.string.RECORDING_SETTINGS_TITLE_LOOKS).toUpperCase()) + C4792.f16138);
        this.f3749.f14670.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f3749.f14668.getLayoutParams();
        layoutParams2.height = C4792.m14375().m14406() + C4792.m14375().m14477(384.0f, this.f3755);
        this.f3749.f14668.setLayoutParams(layoutParams2);
        setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3749.f14671.getLayoutParams();
        layoutParams3.topMargin = (int) (m3704(80) * this.f3755);
        this.f3749.f14671.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f3749.f14673.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = layoutParams2.height - ((int) (this.f3749.f14673.getUpdateHeight() / 2.0f));
        this.f3749.f14673.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f3749.f14676.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = this.f3749.f14673.getWidth();
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) (this.f3749.f14673.getUpdateHeight() + C2579.m9438(20.0f));
        this.f3749.f14676.setLayoutParams(layoutParams5);
        this.f3749.f14674.setContentTextColor(-1);
        this.f3749.f14674.m2562(0, C4792.m14375().m14397());
        this.f3749.f14674.setContentTypeFace(FilmApp.m404());
        this.f3749.f14675.setContentTextColor(-1);
        this.f3749.f14675.m2562(0, C4792.m14375().m14397());
        this.f3749.f14675.setContentTypeFace(FilmApp.m404());
        this.f3761 = C2579.m9438(10.0f);
        this.f3760 = C4792.m14375().m14477(32.0f, this.f3755);
        m3707();
        m3709();
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m3707() {
        this.f3757 = new C4194(getContext(), this.f3752, new C1327());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 0);
        this.f3758 = staggeredGridLayoutManager;
        this.f3749.f14672.setLayoutManager(staggeredGridLayoutManager);
        this.f3749.f14672.setAdapter(this.f3757);
        this.f3749.f14672.addItemDecoration(new C4102("right_decoration", this.f3760));
        this.f3749.f14672.setHasFixedSize(false);
        if (this.f3749.f14672.getItemAnimator() != null) {
            ((DefaultItemAnimator) this.f3749.f14672.getItemAnimator()).setSupportsChangeAnimations(false);
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m3708() throws Resources.NotFoundException {
        String string;
        this.f3752.clear();
        C3891 c3891M13890 = C4535.m13880().m13890();
        ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
        int iM12442 = c3891M13890.m12442();
        float fM12438 = c3891M13890.m12438();
        if (r1.m8144(arrayListM11244)) {
            int i = 0;
            while (i < arrayListM11244.size()) {
                h0 h0Var = arrayListM11244.get(i);
                h0Var.setSelected(h0Var.m6136() == iM12442);
                C4196 c4196M13247 = new C4196().m13247(h0Var);
                c4196M13247.setSelected(h0Var.isSelected());
                if (m3719(h0Var)) {
                    c4196M13247.m13250(3);
                } else if (m3710()) {
                    c4196M13247.m13250(h0Var.isSelected() ? 2 : 0);
                } else {
                    c4196M13247.m13250(h0Var.isSelected() ? 1 : 0);
                }
                h0Var.m6175(h0Var.isSelected() ? fM12438 : 100.0f);
                if (i == this.f3767 && !this.f3762) {
                    h0Var.m6172(false);
                }
                if (!C5213.m15210()) {
                    string = C5213.m15213() ? i == 0 ? FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF) : h0Var.m6131() : C5213.m15216() ? i == 0 ? FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF) : h0Var.m6132() : C5213.m15217() ? i == 0 ? FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF) : h0Var.m6133() : i == 0 ? FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF) : h0Var.m6130();
                } else if (i == 0) {
                    string = FilmApp.m402().getResources().getString(R.string.RECORDING_SETTINGS_LOOKS_LOOK_OFF);
                } else {
                    string = h0Var.m6129();
                    if (C5213.m15219() && r1.m8143(h0Var.m6134())) {
                        string = h0Var.m6134();
                    }
                }
                c4196M13247.m13251(string);
                c4196M13247.setItemViewType(7);
                h0 h0VarM13228 = c4196M13247.m13228();
                h0VarM13228.m6155(h0VarM13228.m6125());
                this.f3752.add(c4196M13247);
                if (h0Var.isSelected()) {
                    this.f3754 = i;
                }
                i++;
            }
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m3709() {
        this.f3749.f14671.setOnDownloadListener(new C1324());
        this.f3749.f14673.setOnUpdateListener(new C1325());
        this.f3749.f14672.addOnScrollListener(new C1326());
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public boolean m3710() {
        return this.f3759;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final boolean m3711() {
        return C4151.m13162().m13176() == 3;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final boolean m3712(int i) {
        h0 h0VarM13228 = this.f3752.get(i).m13228();
        if (h0VarM13228.m6144() && h0VarM13228.m6127() % 2 == 0) {
            return true;
        }
        return h0VarM13228.m6144() && h0VarM13228.m6127() % 2 == 1 && m3713(h0VarM13228.m6140());
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final boolean m3713(FilterGroupCollectionBean filterGroupCollectionBean) {
        String name_th;
        if (!r1.m8142(filterGroupCollectionBean)) {
            name_th = "";
        } else if (C5213.m15210()) {
            name_th = filterGroupCollectionBean.getName_cn();
            if (C5213.m15219() && r1.m8143(filterGroupCollectionBean.getName_zht())) {
                name_th = filterGroupCollectionBean.getName_zht();
            }
        } else {
            name_th = C5213.m15217() ? filterGroupCollectionBean.getName_th() : C5213.m15216() ? filterGroupCollectionBean.getName_kr() : C5213.m15213() ? filterGroupCollectionBean.getName_ja() : filterGroupCollectionBean.getName_en();
        }
        return r1.m8138(name_th);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final boolean m3714(int i) {
        C4196 c4196 = this.f3752.get(i);
        return c4196 != null && c4196.m13228().m6127() % 2 == 1;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean m3715() {
        return this.f3750;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final boolean m3716() {
        return C4151.m13162().m13176() == 4;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final boolean m3717() {
        return C4151.m13162().m13176() == 2;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final boolean m3718() {
        return C4151.m13162().m13176() == 1;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final boolean m3719(h0 h0Var) {
        return C4511.m13838().m13853(h0Var);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m3720(h0 h0Var, boolean z, boolean z2) {
        if (z) {
            h0Var.m6172(z2);
            this.f3762 = z2;
            C4511.m13838().m13860(this.f3762);
            this.f3757.notifyItemChanged(this.f3767);
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m3721() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12442 = c3891M13890.m12442();
        float fM12438 = c3891M13890.m12438();
        for (int i = 0; i < this.f3752.size(); i++) {
            C4196 c4196 = this.f3752.get(i);
            h0 h0VarM13228 = c4196.m13228();
            c4196.setSelected(h0VarM13228.m6136() == iM12442);
            if (m3719(h0VarM13228)) {
                c4196.m13250(3);
                if (h0VarM13228.m6136() == iM12442) {
                    c4196.setSelected(false);
                    this.f3752.get(0).setSelected(true);
                } else {
                    c4196.setSelected(h0VarM13228.m6136() == iM12442);
                }
            } else {
                c4196.m13250(h0VarM13228.m6136() == iM12442 ? 1 : 0);
                c4196.setSelected(h0VarM13228.m6136() == iM12442);
            }
            c4196.m13228().m6175(h0VarM13228.m6136() == iM12442 ? fM12438 : 100.0f);
            c4196.m13228().m6172(true);
            if (c4196.isSelected()) {
                this.f3754 = i;
            }
        }
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m3722() {
        if (m3724()) {
            return;
        }
        m3721();
        if (this.f3754 >= 2) {
            this.f3749.f14672.postDelayed(new RunnableC1328(), 0L);
        }
        new Handler().postDelayed(new RunnableC1329(), 50L);
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public void m3723() throws Resources.NotFoundException {
        m3726();
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public boolean m3724() {
        if (m3717()) {
            this.f3749.f14673.setVisibility(8);
            this.f3749.f14671.setVisibility(0);
            this.f3749.f14672.setVisibility(8);
            this.f3749.f14674.setVisibility(8);
            this.f3749.f14675.setVisibility(8);
            this.f3749.f14671.setShowType(0);
            setDownloadSize(C4151.m13162().m13178());
            return true;
        }
        if (m3711()) {
            this.f3749.f14673.setVisibility(8);
            this.f3749.f14671.setVisibility(0);
            this.f3749.f14672.setVisibility(8);
            this.f3749.f14674.setVisibility(8);
            this.f3749.f14675.setVisibility(8);
            this.f3749.f14671.setShowType(1);
            return true;
        }
        if (m3718()) {
            this.f3749.f14673.setVisibility(0);
            this.f3749.f14671.setVisibility(8);
            this.f3749.f14672.setVisibility(0);
            this.f3749.f14674.setVisibility(0);
            this.f3749.f14675.setVisibility(0);
            setUpdateSize(C4151.m13162().m13187());
        } else if (m3716()) {
            this.f3749.f14673.setVisibility(0);
            this.f3749.f14671.setVisibility(8);
            this.f3749.f14672.setVisibility(0);
            this.f3749.f14674.setVisibility(0);
            this.f3749.f14675.setVisibility(0);
        } else {
            this.f3749.f14673.setVisibility(8);
            this.f3749.f14671.setVisibility(8);
            this.f3749.f14672.setVisibility(0);
            this.f3749.f14674.setVisibility(0);
            this.f3749.f14675.setVisibility(0);
        }
        return false;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m3725(StrokeTextView strokeTextView, String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) strokeTextView.getLayoutParams();
        TextPaint paint = strokeTextView.getPaint();
        if (r1.m8138(str)) {
            layoutParams.width = 0;
        } else {
            layoutParams.width = (int) (paint.measureText(str) + C4792.f16138);
        }
        if (strokeTextView == this.f3749.f14675) {
            this.f3765 = layoutParams.width;
        } else {
            this.f3764 = layoutParams.width;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        layoutParams.leftMargin = this.f3761;
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        layoutParams.topMargin = (int) (((C4792.m14375().m14406() - (((((fontMetrics2.bottom - fontMetrics2.top) + C4792.f16138) * 2.0f) + C4792.m14375().m14477(40.0f, this.f3755)) + C4792.m14375().m14477(262.0f, this.f3755))) / 2.0f) + 0.5f);
        strokeTextView.setLayoutParams(layoutParams);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m3726() throws Resources.NotFoundException {
        m3708();
        m3731();
        this.f3757.notifyDataSetChanged();
        m3724();
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public void m3727() {
        if (r1.m8144(this.f3752)) {
            this.f3752.get(this.f3754).m13250(1);
            this.f3759 = false;
            C4511.m13838().m13861(this.f3759);
            C1358 c1358 = (C1358) this.f3749.f14672.findViewHolderForAdapterPosition(this.f3754);
            if (c1358 != null) {
                c1358.m3874(1, this.f3754);
            }
        }
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m3728(float f, int i) {
        this.f3749.f14675.setAlpha(f);
        this.f3768 = i;
        this.f3749.f14675.setTranslationX(i);
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m3729(StrokeTextView strokeTextView, h0 h0Var) {
        String strM13842 = C4511.m13838().m13842(h0Var);
        strokeTextView.setText(strM13842);
        m3725(strokeTextView, strM13842);
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m3730(int i) {
        this.f3750 = true;
        this.f3759 = false;
        C4511.m13838().m13861(this.f3759);
        m3722();
        C4008.m12886(this, 0.0f, 0.0f, i, new C1330());
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public final void m3731() {
        int iM3702;
        C3891 c3891M13890 = C4535.m13880().m13890();
        this.f3769 = 0;
        this.f3770 = 0;
        this.f3771 = 0;
        if (!r1.m8139(this.f3752) || this.f3752.size() > 1) {
            this.f3753.clear();
            int i = 0;
            while (i < this.f3752.size()) {
                h0 h0VarM13228 = this.f3752.get(i).m13228();
                int iM6127 = h0VarM13228.m6127();
                if (m3713(h0VarM13228.m6140())) {
                    this.f3771++;
                    iM3702 = i == 0 ? i : iM6127 % 2 == 0 ? m3703(true, i) : m3702(true, i);
                } else {
                    iM3702 = iM6127 % 2 == 0 ? m3702(false, i) : m3703(false, i);
                }
                if (iM3702 < this.f3752.size()) {
                    h0VarM13228.m6167(i);
                    this.f3753.add(this.f3752.get(iM3702));
                }
                i++;
            }
            this.f3752.clear();
            this.f3752.addAll(this.f3753);
            for (int i2 = 0; i2 < this.f3752.size(); i2++) {
                h0 h0VarM132282 = this.f3752.get(i2).m13228();
                boolean zM3713 = m3713(h0VarM132282.m6140());
                if (h0VarM132282.m6143()) {
                    this.f3769 = 0;
                    h0VarM132282.m6155(0);
                } else {
                    if (!zM3713) {
                        this.f3769++;
                    } else if (!r1.m8137(h0VarM132282.m6140()) && i2 >= 2) {
                        this.f3769++;
                    } else {
                        this.f3769 = 0;
                    }
                    h0VarM132282.m6155(this.f3769);
                }
                h0VarM132282.m6157(this.f3769 == 1);
                h0VarM132282.m6174(false);
                h0VarM132282.m6152(false);
                if (r1.m8137(h0VarM132282.m6140())) {
                    h0VarM132282.m6156(this.f3771 == 1);
                    h0VarM132282.m6174(true);
                } else if (zM3713) {
                    h0VarM132282.m6156(this.f3769 == h0VarM132282.m6140().getFilter_groups().length - 1 && this.f3769 % 2 == 1);
                    h0VarM132282.m6174(this.f3769 == 0);
                } else {
                    h0VarM132282.m6156(this.f3769 == h0VarM132282.m6140().getFilter_groups().length - 1 && this.f3769 % 2 == 0);
                    FilterGroupCollectionBean filterGroupCollectionBeanM6140 = h0VarM132282.m6140();
                    if (filterGroupCollectionBeanM6140.getGroupIndex() != filterGroupCollectionBeanM6140.getGroupCount() - 1) {
                        h0VarM132282.m6152(false);
                    } else if (filterGroupCollectionBeanM6140.getFilter_groups().length % 2 == 0) {
                        h0VarM132282.m6152(this.f3769 == filterGroupCollectionBeanM6140.getFilter_groups().length - 1 || this.f3769 == filterGroupCollectionBeanM6140.getFilter_groups().length - 2);
                    } else {
                        h0VarM132282.m6152(this.f3769 == filterGroupCollectionBeanM6140.getFilter_groups().length - 1);
                    }
                }
                if (h0VarM132282.m6136() == c3891M13890.m12442()) {
                    this.f3754 = i2;
                }
            }
        }
    }

    public LooksPreviewPortraitView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LooksPreviewPortraitView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3752 = new ArrayList<>();
        this.f3753 = new ArrayList<>();
        this.f3766 = 0;
        this.f3767 = 0;
        this.f3768 = 0;
        m3706();
    }
}
