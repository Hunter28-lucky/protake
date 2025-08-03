package com.blink.academy.film.widgets.looks;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.looks.FilmStopRecycleView;
import com.blink.academy.film.widgets.looks.StyleDownloadingView;
import com.blink.academy.film.widgets.looks.StyleUpdateView;
import com.blink.academy.protake.R;
import defpackage.AbstractC3153;
import defpackage.AbstractC4012;
import defpackage.AbstractC4975;
import defpackage.C2579;
import defpackage.C2685;
import defpackage.C3133;
import defpackage.C3227;
import defpackage.C3741;
import defpackage.C4008;
import defpackage.C4102;
import defpackage.C4151;
import defpackage.C4196;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.h0;
import defpackage.o4;
import defpackage.r1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LooksSettingView extends FrameLayout implements View.OnClickListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3153 f3807;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f3808;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3809;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<C2685> f3810;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ArrayList<C4196> f3811;

    /* renamed from: ՠ, reason: contains not printable characters */
    public ArrayList<String> f3812;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ArrayList<String> f3813;

    /* renamed from: ֏, reason: contains not printable characters */
    public ArrayList<String> f3814;

    /* renamed from: ׯ, reason: contains not printable characters */
    public ArrayList<String> f3815;

    /* renamed from: ؠ, reason: contains not printable characters */
    public ArrayList<String> f3816;

    /* renamed from: ހ, reason: contains not printable characters */
    public ArrayList<Integer> f3817;

    /* renamed from: ށ, reason: contains not printable characters */
    public ArrayList<Integer> f3818;

    /* renamed from: ނ, reason: contains not printable characters */
    public ArrayList<Integer> f3819;

    /* renamed from: ރ, reason: contains not printable characters */
    public ArrayList<Integer> f3820;

    /* renamed from: ބ, reason: contains not printable characters */
    public ArrayList<Integer> f3821;

    /* renamed from: ޅ, reason: contains not printable characters */
    public ArrayList<String> f3822;

    /* renamed from: ކ, reason: contains not printable characters */
    public ArrayList<Integer> f3823;

    /* renamed from: އ, reason: contains not printable characters */
    public C3227 f3824;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f3825;

    /* renamed from: މ, reason: contains not printable characters */
    public ArrayList<C3741> f3826;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f3827;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f3828;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f3829;

    /* renamed from: ލ, reason: contains not printable characters */
    public Handler f3830;

    /* renamed from: ގ, reason: contains not printable characters */
    public C4102 f3831;

    /* renamed from: ޏ, reason: contains not printable characters */
    public long f3832;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f3833;

    /* renamed from: ޑ, reason: contains not printable characters */
    public InterfaceC1347 f3834;

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$Ϳ, reason: contains not printable characters */
    public class C1339 implements StyleDownloadingView.InterfaceC1355 {
        public C1339() {
        }

        @Override // com.blink.academy.film.widgets.looks.StyleDownloadingView.InterfaceC1355
        /* renamed from: Ԩ */
        public void mo3732() {
            InterfaceC1347 interfaceC1347;
            if (LooksSettingView.this.m3812() || (interfaceC1347 = LooksSettingView.this.f3834) == null) {
                return;
            }
            interfaceC1347.m3831();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$Ԩ, reason: contains not printable characters */
    public class C1340 implements StyleUpdateView.InterfaceC1357 {
        public C1340() {
        }

        @Override // com.blink.academy.film.widgets.looks.StyleUpdateView.InterfaceC1357
        /* renamed from: Ϳ */
        public void mo3733() {
            InterfaceC1347 interfaceC1347;
            if (LooksSettingView.this.m3812() || (interfaceC1347 = LooksSettingView.this.f3834) == null) {
                return;
            }
            interfaceC1347.m3830();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1341 implements View.OnClickListener {
        public ViewOnClickListenerC1341() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LooksSettingView.this.m3827();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$Ԭ, reason: contains not printable characters */
    public class C1342 implements FilmStopRecycleView.InterfaceC1323 {
        public C1342() {
        }

        @Override // com.blink.academy.film.widgets.looks.FilmStopRecycleView.InterfaceC1323
        /* renamed from: Ϳ */
        public boolean mo2363() {
            InterfaceC1347 interfaceC1347 = LooksSettingView.this.f3834;
            if (interfaceC1347 != null) {
                return interfaceC1347.m3836();
            }
            return false;
        }

        @Override // com.blink.academy.film.widgets.looks.FilmStopRecycleView.InterfaceC1323
        /* renamed from: Ԩ */
        public void mo2364(int i) {
            h0 h0VarM13228;
            LooksSettingView.this.f3807.f11193.setCurrentI(i);
            C2685 c2685 = (C2685) LooksSettingView.this.f3810.get(LooksSettingView.this.f3825);
            if (c2685 == null || c2685.getType() != 0) {
                return;
            }
            C3741 c3741M9902 = c2685.m9902();
            if (c3741M9902 != null && (h0VarM13228 = ((C4196) LooksSettingView.this.f3811.get(i)).m13228()) != null) {
                int iM6136 = h0VarM13228.m6136();
                boolean z = iM6136 != 0;
                c3741M9902.m11988(z);
                C3133 c3133 = (C3133) LooksSettingView.this.f3807.f11195.findViewHolderForAdapterPosition(LooksSettingView.this.f3825);
                c3741M9902.m11988(z);
                c3133.m10722(z);
                C3133 c31332 = (C3133) LooksSettingView.this.f3807.f11195.findViewHolderForAdapterPosition(LooksSettingView.this.f3825 + 1);
                C3741 c3741M99022 = ((C2685) LooksSettingView.this.f3810.get(LooksSettingView.this.f3825 + 1)).m9902();
                c3741M99022.m11988(false);
                c31332.m10722(false);
                c3741M99022.m11989((c3741M99022.m11985() + c3741M99022.m11986()) / 2.0f);
                InterfaceC1347 interfaceC1347 = LooksSettingView.this.f3834;
                if (interfaceC1347 != null) {
                    interfaceC1347.m3833(iM6136, c3741M99022.m11984());
                }
            }
            LooksSettingView.this.f3828 = i;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$Ԯ, reason: contains not printable characters */
    public class C1343 implements FilmStopRecycleView.InterfaceC1321 {
        public C1343() {
        }

        @Override // com.blink.academy.film.widgets.looks.FilmStopRecycleView.InterfaceC1321
        /* renamed from: Ϳ */
        public boolean mo3677() {
            InterfaceC1347 interfaceC1347 = LooksSettingView.this.f3834;
            if (interfaceC1347 != null) {
                return interfaceC1347.m3836();
            }
            return false;
        }

        @Override // com.blink.academy.film.widgets.looks.FilmStopRecycleView.InterfaceC1321
        /* renamed from: Ԩ */
        public void mo3678(int i) {
            LooksSettingView looksSettingView = LooksSettingView.this;
            if (looksSettingView.f3834 == null || i == 0) {
                return;
            }
            if (looksSettingView.f3828 == i) {
                LooksSettingView.this.f3834.m3835(i);
            } else {
                LooksSettingView.this.f3834.m3838(i);
            }
        }

        @Override // com.blink.academy.film.widgets.looks.FilmStopRecycleView.InterfaceC1321
        /* renamed from: ԩ */
        public void mo3679(int i) {
            LooksSettingView looksSettingView = LooksSettingView.this;
            if (looksSettingView.f3834 == null || i == 0) {
                return;
            }
            if (looksSettingView.f3828 == i) {
                LooksSettingView.this.f3834.m3837(i);
            } else {
                LooksSettingView.this.f3834.m3834(i);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$ՠ, reason: contains not printable characters */
    public class C1344 implements FilmSeekBar.InterfaceC0896 {
        public C1344() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            C2685 c2685;
            InterfaceC1347 interfaceC1347;
            InterfaceC1347 interfaceC13472 = LooksSettingView.this.f3834;
            if ((interfaceC13472 == null || interfaceC13472.m3836()) && (c2685 = (C2685) LooksSettingView.this.f3810.get(LooksSettingView.this.f3825)) != null) {
                C3741 c3741M9902 = c2685.m9902();
                float fM3814 = LooksSettingView.this.m3814(f2 / 1000.0f, c3741M9902.m11985(), c3741M9902.m11986());
                if (fM3814 == (c3741M9902.m11985() - c3741M9902.m11986()) / 2.0f) {
                    LooksSettingView.this.f3807.f11197.setValueAndUpdateUI(((c3741M9902.m11985() - c3741M9902.m11986()) / 2.0f) * 1000.0f);
                } else {
                    LooksSettingView.this.f3807.f11197.setValueAndUpdateUI(1000.0f * fM3814);
                }
                float fM3813 = LooksSettingView.this.m3813(fM3814, c3741M9902.m11985(), c3741M9902.m11986());
                int type = c3741M9902.getType();
                LooksSettingView.this.f3807.f11194.m2326(fM3813, false, LooksSettingView.this.m3815(fM3814, type));
                if (type == 1) {
                    h0 h0VarM13228 = ((C4196) LooksSettingView.this.f3811.get(LooksSettingView.this.f3828)).m13228();
                    InterfaceC1347 interfaceC13473 = LooksSettingView.this.f3834;
                    if (interfaceC13473 != null) {
                        interfaceC13473.m3833(h0VarM13228.m6136(), fM3814);
                    }
                } else if (type == 2) {
                    InterfaceC1347 interfaceC13474 = LooksSettingView.this.f3834;
                    if (interfaceC13474 != null) {
                        interfaceC13474.m3832(fM3814);
                    }
                } else if (type == 3) {
                    InterfaceC1347 interfaceC13475 = LooksSettingView.this.f3834;
                    if (interfaceC13475 != null) {
                        interfaceC13475.m3839(fM3814);
                    }
                } else if (type == 4) {
                    InterfaceC1347 interfaceC13476 = LooksSettingView.this.f3834;
                    if (interfaceC13476 != null) {
                        interfaceC13476.m3840(fM3814);
                    }
                } else if (type == 5 && (interfaceC1347 = LooksSettingView.this.f3834) != null) {
                    interfaceC1347.m3841(fM3814);
                }
                c3741M9902.m11989(fM3814);
                C3133 c3133 = (C3133) LooksSettingView.this.f3807.f11195.findViewHolderForAdapterPosition(LooksSettingView.this.f3825);
                boolean z = ((float) Math.round(fM3814)) != (c3741M9902.m11985() + c3741M9902.m11986()) / 2.0f;
                c3741M9902.m11988(z);
                c3133.m10722(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$ֈ, reason: contains not printable characters */
    public class C1345 implements FilmStopView.InterfaceC0908 {
        public C1345() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return !LooksSettingView.this.f3807.f11197.m2303();
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            InterfaceC1347 interfaceC1347;
            InterfaceC1347 interfaceC13472 = LooksSettingView.this.f3834;
            if (interfaceC13472 == null || interfaceC13472.m3836()) {
                int iIntValue = ((Integer) LooksSettingView.this.f3823.get(i)).intValue();
                LooksSettingView.this.f3807.f11194.setCurrentI(i);
                LooksSettingView.this.f3807.f11197.setValueAndUpdateUI(iIntValue * 1000);
                C2685 c2685 = (C2685) LooksSettingView.this.f3810.get(LooksSettingView.this.f3825);
                if (c2685 == null) {
                    return;
                }
                C3741 c3741M9902 = c2685.m9902();
                int type = c3741M9902.getType();
                if (c3741M9902.getType() == 1) {
                    h0 h0VarM13228 = ((C4196) LooksSettingView.this.f3811.get(LooksSettingView.this.f3828)).m13228();
                    InterfaceC1347 interfaceC13473 = LooksSettingView.this.f3834;
                    if (interfaceC13473 != null) {
                        interfaceC13473.m3833(h0VarM13228.m6136(), iIntValue);
                    }
                } else if (type == 2) {
                    InterfaceC1347 interfaceC13474 = LooksSettingView.this.f3834;
                    if (interfaceC13474 != null) {
                        interfaceC13474.m3832(iIntValue);
                    }
                } else if (type == 3) {
                    InterfaceC1347 interfaceC13475 = LooksSettingView.this.f3834;
                    if (interfaceC13475 != null) {
                        interfaceC13475.m3839(iIntValue);
                    }
                } else if (type == 4) {
                    InterfaceC1347 interfaceC13476 = LooksSettingView.this.f3834;
                    if (interfaceC13476 != null) {
                        interfaceC13476.m3840(iIntValue);
                    }
                } else if (type == 5 && (interfaceC1347 = LooksSettingView.this.f3834) != null) {
                    interfaceC1347.m3841(iIntValue);
                }
                float f = iIntValue;
                c3741M9902.m11989(f);
                C3133 c3133 = (C3133) LooksSettingView.this.f3807.f11195.findViewHolderForAdapterPosition(LooksSettingView.this.f3825);
                boolean z = ((float) Math.round(f)) != (c3741M9902.m11985() + c3741M9902.m11986()) / 2.0f;
                c3741M9902.m11988(z);
                c3133.m10722(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$֏, reason: contains not printable characters */
    public class C1346 implements AbstractC4975.InterfaceC4976 {
        public C1346() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            C2685 c2685;
            InterfaceC1347 interfaceC1347 = LooksSettingView.this.f3834;
            if ((interfaceC1347 != null && !interfaceC1347.m3836()) || (c2685 = (C2685) LooksSettingView.this.f3810.get(i)) == null || c2685.isSelected() || LooksSettingView.this.f3825 == i) {
                return;
            }
            ((C2685) LooksSettingView.this.f3810.get(LooksSettingView.this.f3825)).setSelected(false);
            ((C3133) LooksSettingView.this.f3807.f11195.findViewHolderForAdapterPosition(LooksSettingView.this.f3825)).m10723(false);
            c2685.setSelected(true);
            ((C3133) LooksSettingView.this.f3807.f11195.findViewHolderForAdapterPosition(i)).m10723(c2685.isSelected());
            LooksSettingView.this.f3827 = c2685.getType();
            LooksSettingView.this.f3825 = i;
            LooksSettingView.this.m3828();
            LooksSettingView.this.m3829();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.looks.LooksSettingView$ׯ, reason: contains not printable characters */
    public interface InterfaceC1347 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m3830();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void m3831();

        /* renamed from: ԩ, reason: contains not printable characters */
        void m3832(float f);

        /* renamed from: Ԫ, reason: contains not printable characters */
        void m3833(int i, float f);

        /* renamed from: ԫ, reason: contains not printable characters */
        void m3834(int i);

        /* renamed from: Ԭ, reason: contains not printable characters */
        void m3835(int i);

        /* renamed from: ԭ, reason: contains not printable characters */
        boolean m3836();

        /* renamed from: Ԯ, reason: contains not printable characters */
        void m3837(int i);

        /* renamed from: ԯ, reason: contains not printable characters */
        void m3838(int i);

        /* renamed from: ՠ, reason: contains not printable characters */
        void m3839(float f);

        /* renamed from: ֈ, reason: contains not printable characters */
        void m3840(float f);

        /* renamed from: ֏, reason: contains not printable characters */
        void m3841(float f);
    }

    public LooksSettingView(@NonNull Context context) {
        this(context, null);
    }

    private void setEnableClick(boolean z) {
        if (z) {
            this.f3807.f11194.m2320();
        } else {
            this.f3807.f11194.m2318();
        }
        this.f3807.f11197.setEnabled(z);
        float fM14416 = z ? 1.0f : C4792.m14375().m14416();
        this.f3807.f11194.setAlpha(fM14416);
        this.f3807.f11197.setAlpha(fM14416);
    }

    public int getCurrentStylePos() {
        return this.f3828;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3809 = i2;
        if (this.f3808) {
            return;
        }
        m3817(0, null);
    }

    public void setCurrentStylePos(int i) {
        this.f3828 = i;
    }

    public void setDownloadProgress(String str) {
        if (this.f3807.f11191 != null) {
            String str2 = String.format(getResources().getString(R.string.LOOKS_DOWNLOADING), String.format("(%s%s)", str, "%"));
            this.f3807.f11191.setShowType(1);
            this.f3807.f11191.setContentText(str2);
        }
    }

    public void setDownloadSize(long j) {
        if (this.f3807.f11191 != null) {
            String str = String.format(getResources().getString(R.string.LOOKS_DOWNLOAD), String.format("(%s)", o4.m7682(j)));
            this.f3807.f11191.setShowType(0);
            this.f3807.f11191.setContentText(str);
        }
    }

    public void setListPadding(ArrayList<C2685> arrayList) {
        int iM9450 = C2579.m9450(getContext());
        if (iM9450 == 0) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14381());
        textPaint.setTypeface(FilmApp.m404());
        int iMeasureText = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            iMeasureText = (int) (iMeasureText + textPaint.measureText(arrayList.get(i).m9904()));
        }
        int iM14476 = (C4792.m14375().m14476(28) * (arrayList.size() - 1)) + iMeasureText + (C4792.m14375().m14386() * 2 * arrayList.size());
        int iM14386 = iMeasureText + (C4792.m14375().m14386() * 2 * arrayList.size());
        if (iM14476 < iM9450) {
            C4102 c4102 = this.f3831;
            if (c4102 != null) {
                this.f3807.f11195.removeItemDecoration(c4102);
            }
            C4102 c41022 = new C4102("right_decoration", C4792.m14375().m14476(28));
            this.f3831 = c41022;
            this.f3807.f11195.addItemDecoration(c41022);
            return;
        }
        int iRound = Math.round(((iM9450 - iM14386) * 1.0f) / (arrayList.size() - 1));
        C4102 c41023 = this.f3831;
        if (c41023 != null) {
            this.f3807.f11195.removeItemDecoration(c41023);
        }
        C4102 c41024 = new C4102("right_decoration", iRound);
        this.f3831 = c41024;
        this.f3807.f11195.addItemDecoration(c41024);
    }

    public void setOnLooksStyleChangeListener(InterfaceC1347 interfaceC1347) {
        this.f3834 = interfaceC1347;
    }

    public void setPadding(int i) {
        this.f3833 = i;
        LinearLayout linearLayout = this.f3807.f11187;
        if (linearLayout != null) {
            linearLayout.setPadding(i, 0, i, 0);
        }
    }

    public void setUpdateProgress(String str) {
        if (this.f3807.f11196 != null) {
            this.f3807.f11196.setContentText(String.format(getResources().getString(R.string.LOOKS_DOWNLOADING), String.format("(%s%s)", str, "%")));
        }
    }

    public void setUpdateSize(long j) {
        if (this.f3807.f11196 != null) {
            this.f3807.f11196.setContentText(String.format(getResources().getString(R.string.LOOKS_UPDATE_AVAILABLE), String.format("(%s)", o4.m7682(j))));
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final boolean m3811() {
        if (this.f3811 != null) {
            return !m3822(C4535.m13880().m13890().m12442());
        }
        return false;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final boolean m3812() {
        if (this.f3832 == 0) {
            this.f3832 = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - this.f3832 < 200) {
            return true;
        }
        this.f3832 = System.currentTimeMillis();
        return false;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final float m3813(float f, float f2, float f3) {
        return ((f - f3) / (f2 - f3)) * (this.f3822.size() - 1);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final float m3814(float f, float f2, float f3) {
        float f4 = (f2 + f3) / 2.0f;
        float f5 = f2 - f3;
        float f6 = 0.02f * f5;
        float f7 = f - f4;
        if (Math.abs(f7) > f6) {
            f4 += ((f > f4 ? f7 - f6 : f7 + f6) * f5) / (f5 - (f6 * 2.0f));
        }
        return Math.round(f4 * 1000.0f) / 1000.0f;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final String m3815(float f, int i) {
        if (i != 1) {
            return String.valueOf(Math.round(f));
        }
        return Math.round(f) + "%";
    }

    /* renamed from: އ, reason: contains not printable characters */
    public int m3816(int i) {
        return C4792.m14375().m14477(i, this.f3829);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m3817(int i, AbstractC4012 abstractC4012) {
        this.f3808 = false;
        C4008.m12886(this, 0.0f, this.f3809, i, abstractC4012);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m3818() {
        this.f3807 = (AbstractC3153) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_looks_setting, this, true);
        this.f3829 = C4792.m14375().m14434();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3807.f11189.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = C4792.m14375().m14408();
        this.f3807.f11189.m2562(0, C4792.m14375().m14381());
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (this.f3807.f11189.getPaint().measureText(getContext().getString(R.string.RECORDING_SETTINGS_TITLE_LOOKS).toUpperCase()) + C4792.f16138 + 0.5f);
        this.f3807.f11189.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f3807.f11187.getLayoutParams();
        layoutParams2.height = C4792.m14375().m14406();
        this.f3807.f11187.setLayoutParams(layoutParams2);
        setOnClickListener(this);
        this.f3807.f11200.setTypeface(FilmApp.m404());
        this.f3807.f11200.setTextSize(0, C4792.m14375().m14396());
        int iM14476 = C4792.m14375().m14476(23);
        int iM144762 = C4792.m14375().m14476(14);
        this.f3807.f11200.setPadding(iM14476, iM144762, iM14476, iM144762);
        this.f3807.f11199.setRadius(4);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f3807.f11190.getLayoutParams();
        TextPaint paint = this.f3807.f11200.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = (int) (fontMetrics.bottom - fontMetrics.top);
        Paint.FontMetrics fontMetrics2 = this.f3807.f11189.getPaint().getFontMetrics();
        float f2 = f + (iM144762 * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = (int) ((((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((fontMetrics2.bottom - fontMetrics2.top) / 2.0f)) - (f2 / 2.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = C4792.m14375().m14476(56);
        float f3 = iM14476 * 2;
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (paint.measureText(getContext().getString(R.string.BUTTON_RESET_ALL).toUpperCase()) + f3);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) f2;
        this.f3807.f11190.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f3807.f11192.getLayoutParams();
        int iM14377 = C4792.m14375().m14377();
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin - iM14377;
        float fMeasureText = paint.measureText(getContext().getString(R.string.BUTTON_RESET_ALL).toUpperCase()) + f3;
        float f4 = iM14377 * 2;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (fMeasureText + f4);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = (int) (f2 + f4 + C4792.f16138);
        this.f3807.f11192.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f3807.f11195.getLayoutParams();
        layoutParams5.width = -2;
        this.f3807.f11195.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f3807.f11194.getLayoutParams();
        layoutParams6.height = C4792.m14375().m14476(100);
        layoutParams6.width = C4792.m14375().m14476(TypedValues.CycleType.TYPE_EASING);
        layoutParams6.leftMargin = C4792.m14375().m14476(20);
        this.f3807.f11194.setLayoutParams(layoutParams6);
        this.f3807.f11194.setTextColor(-1);
        this.f3807.f11194.m2327(0, C4792.m14375().m14386());
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f3807.f11198.getLayoutParams();
        layoutParams7.width = C4792.m14375().m14476(1360);
        layoutParams7.leftMargin = C4792.m14375().m14476(150);
        this.f3807.f11198.setLayoutParams(layoutParams7);
        this.f3807.f11197.setShowCenterLine(true);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f3807.f11193.getLayoutParams();
        layoutParams8.height = C4792.m14375().m14476(277);
        layoutParams8.width = C4792.m14375().m14476(1880);
        layoutParams8.topMargin = (int) (m3816(60) * this.f3829);
        this.f3807.f11193.setLayoutParams(layoutParams8);
        this.f3807.f11193.m3672(layoutParams8.width, layoutParams8.height);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f3807.f11191.getLayoutParams();
        layoutParams9.topMargin = (int) (m3816(80) * this.f3829);
        this.f3807.f11191.setLayoutParams(layoutParams9);
        m3819();
        m3820();
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m3819() {
        this.f3824 = new C3227(getContext(), this.f3810, new C1346());
        this.f3807.f11195.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f3807.f11195.setAdapter(this.f3824);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m3820() {
        this.f3807.f11191.setOnDownloadListener(new C1339());
        this.f3807.f11196.setOnUpdateListener(new C1340());
        this.f3807.f11192.setOnClickListener(new ViewOnClickListenerC1341());
        this.f3807.f11193.setOnStopClick(new C1342());
        this.f3807.f11193.setOnLongClickListener(new C1343());
        this.f3807.f11193.setScrollType(2);
        this.f3807.f11197.setOnProChange(new C1344());
        this.f3807.f11194.setOnStopClick(new C1345());
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final boolean m3821() {
        return C4151.m13162().m13176() == 3;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final boolean m3822(int i) {
        return i == 0;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final boolean m3823() {
        return C4151.m13162().m13176() == 4;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final boolean m3824() {
        return C4151.m13162().m13176() == 2;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final boolean m3825() {
        return C4151.m13162().m13176() == 1;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public boolean m3826() {
        if (this.f3827 != 0) {
            return false;
        }
        if (m3824()) {
            this.f3807.f11196.setVisibility(8);
            this.f3807.f11191.setVisibility(0);
            this.f3807.f11193.setVisibility(8);
            this.f3807.f11191.setShowType(0);
            setDownloadSize(C4151.m13162().m13178());
            return true;
        }
        if (m3821()) {
            this.f3807.f11196.setVisibility(8);
            this.f3807.f11191.setVisibility(0);
            this.f3807.f11193.setVisibility(8);
            this.f3807.f11191.setShowType(1);
            return true;
        }
        if (m3825()) {
            this.f3807.f11196.setVisibility(0);
            this.f3807.f11191.setVisibility(8);
            this.f3807.f11193.setVisibility(0);
            setUpdateSize(C4151.m13162().m13187());
        } else if (m3823()) {
            this.f3807.f11196.setVisibility(0);
            this.f3807.f11191.setVisibility(8);
            this.f3807.f11193.setVisibility(0);
        } else {
            this.f3807.f11196.setVisibility(8);
            this.f3807.f11191.setVisibility(8);
            this.f3807.f11193.setVisibility(0);
        }
        return false;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m3827() {
        if (this.f3826 != null) {
            for (int i = 0; i < this.f3826.size(); i++) {
                C3741 c3741 = this.f3826.get(i);
                c3741.m11988(false);
                c3741.m11989((c3741.m11985() + c3741.m11986()) / 2.0f);
                if (c3741.getType() != 0) {
                    if (c3741.getType() == 1) {
                        float fM11985 = (c3741.m11985() + c3741.m11986()) / 2.0f;
                        if (r1.m8144(this.f3811)) {
                            for (int i2 = 0; i2 < this.f3811.size(); i2++) {
                                h0 h0VarM13228 = this.f3811.get(i2).m13228();
                                h0VarM13228.m6175(fM11985);
                                if (h0VarM13228.m6136() == 0) {
                                    h0VarM13228.setSelected(true);
                                    this.f3828 = i2;
                                } else {
                                    h0VarM13228.setSelected(false);
                                }
                            }
                            this.f3807.f11193.setDataList(this.f3811);
                            this.f3807.f11193.setCurrentI(this.f3828);
                            float fM11984 = c3741.m11984();
                            float fM3813 = m3813(fM11984, c3741.m11985(), c3741.m11986());
                            if (i == this.f3825) {
                                this.f3807.f11194.m2326(fM3813, false, m3815(fM11984, c3741.getType()));
                                this.f3807.f11197.setValueAndUpdateUI(fM11984 * 1000.0f);
                            }
                            InterfaceC1347 interfaceC1347 = this.f3834;
                            if (interfaceC1347 != null) {
                                interfaceC1347.m3833(0, c3741.m11984());
                            }
                        }
                    } else {
                        float fM119842 = c3741.m11984();
                        float fM38132 = m3813(fM119842, c3741.m11985(), c3741.m11986());
                        if (i == this.f3825) {
                            this.f3807.f11194.m2326(fM38132, false, m3815(fM119842, c3741.getType()));
                            this.f3807.f11197.setValueAndUpdateUI(1000.0f * fM119842);
                        }
                        if (this.f3834 != null) {
                            int type = c3741.getType();
                            if (type == 2) {
                                this.f3834.m3832(fM119842);
                            } else if (type == 3) {
                                this.f3834.m3839(fM119842);
                            } else if (type == 4) {
                                this.f3834.m3840(fM119842);
                            } else if (type == 5) {
                                this.f3834.m3841(fM119842);
                            }
                        }
                    }
                }
            }
            if (this.f3827 == 1) {
                setEnableClick(false);
            }
            C3227 c3227 = this.f3824;
            if (c3227 != null) {
                c3227.notifyDataSetChanged();
            }
            this.f3807.f11193.m3669();
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m3828() {
        float fM11984;
        float fM3813;
        float f;
        C3741 c3741 = this.f3826.get(this.f3825);
        if (this.f3827 == 0) {
            this.f3807.f11194.setVisibility(4);
            this.f3807.f11198.setVisibility(4);
            if (m3824() || m3821()) {
                m3826();
            } else {
                this.f3807.f11193.setVisibility(0);
                if (m3825() || m3823()) {
                    this.f3807.f11196.setVisibility(0);
                } else {
                    this.f3807.f11196.setVisibility(8);
                }
            }
            this.f3807.f11193.m3664();
            return;
        }
        this.f3807.f11193.setVisibility(4);
        this.f3807.f11191.setVisibility(4);
        this.f3807.f11194.setVisibility(0);
        this.f3807.f11198.setVisibility(0);
        this.f3807.f11196.setVisibility(8);
        this.f3807.f11197.setMax(c3741.m11985() * 1000.0f);
        this.f3807.f11197.setMin(c3741.m11986() * 1000.0f);
        int i = this.f3827;
        float f2 = 0.0f;
        if (i == 1) {
            ArrayList<String> arrayList = this.f3812;
            this.f3822 = arrayList;
            this.f3823 = this.f3817;
            this.f3807.f11194.setStringDataList(arrayList);
            fM11984 = c3741.m11984();
            fM3813 = m3813(fM11984, c3741.m11985(), c3741.m11986());
        } else if (i == 2) {
            ArrayList<String> arrayList2 = this.f3813;
            this.f3822 = arrayList2;
            this.f3823 = this.f3818;
            this.f3807.f11194.setStringDataList(arrayList2);
            fM11984 = c3741.m11984();
            fM3813 = m3813(fM11984, c3741.m11985(), c3741.m11986());
        } else if (i == 3) {
            ArrayList<String> arrayList3 = this.f3814;
            this.f3822 = arrayList3;
            this.f3823 = this.f3819;
            this.f3807.f11194.setStringDataList(arrayList3);
            fM11984 = c3741.m11984();
            fM3813 = m3813(fM11984, c3741.m11985(), c3741.m11986());
        } else if (i == 4) {
            ArrayList<String> arrayList4 = this.f3815;
            this.f3822 = arrayList4;
            this.f3823 = this.f3820;
            this.f3807.f11194.setStringDataList(arrayList4);
            fM11984 = c3741.m11984();
            fM3813 = m3813(fM11984, c3741.m11985(), c3741.m11986());
        } else if (i != 5) {
            f = 0.0f;
            this.f3807.f11194.m2326(f2, false, m3815(f, this.f3827));
            this.f3807.f11197.setValueAndUpdateUI(f * 1000.0f);
        } else {
            ArrayList<String> arrayList5 = this.f3816;
            this.f3822 = arrayList5;
            this.f3823 = this.f3821;
            this.f3807.f11194.setStringDataList(arrayList5);
            fM11984 = c3741.m11984();
            fM3813 = m3813(fM11984, c3741.m11985(), c3741.m11986());
        }
        float f3 = fM11984;
        f2 = fM3813;
        f = f3;
        this.f3807.f11194.m2326(f2, false, m3815(f, this.f3827));
        this.f3807.f11197.setValueAndUpdateUI(f * 1000.0f);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m3829() {
        if (this.f3827 == 1) {
            setEnableClick(m3811());
        } else {
            setEnableClick(true);
        }
    }

    public LooksSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LooksSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3810 = new ArrayList<>();
        this.f3811 = new ArrayList<>();
        this.f3812 = new ArrayList<>();
        this.f3813 = new ArrayList<>();
        this.f3814 = new ArrayList<>();
        this.f3815 = new ArrayList<>();
        this.f3816 = new ArrayList<>();
        this.f3817 = new ArrayList<>();
        this.f3818 = new ArrayList<>();
        this.f3819 = new ArrayList<>();
        this.f3820 = new ArrayList<>();
        this.f3821 = new ArrayList<>();
        this.f3822 = new ArrayList<>();
        this.f3823 = new ArrayList<>();
        this.f3826 = new ArrayList<>();
        this.f3830 = new Handler();
        m3818();
    }
}
