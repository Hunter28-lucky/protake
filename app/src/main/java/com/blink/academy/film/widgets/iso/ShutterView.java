package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.iso.ISOView;
import com.blink.academy.protake.R;
import defpackage.AbstractC3640;
import defpackage.AbstractC4012;
import defpackage.AbstractC4975;
import defpackage.C2798;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4720;
import defpackage.C4792;
import defpackage.C4842;
import defpackage.r1;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ShutterView extends ConstraintLayout {

    /* renamed from: ދ, reason: contains not printable characters */
    public static final String f3398 = ShutterView.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3640 f3399;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public List<C2798> f3400;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<C2798> f3401;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4720 f3402;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C4720 f3403;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3404;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3405;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f3406;

    /* renamed from: ׯ, reason: contains not printable characters */
    public List<Float> f3407;

    /* renamed from: ؠ, reason: contains not printable characters */
    public List<Float> f3408;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f3409;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f3410;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f3411;

    /* renamed from: ރ, reason: contains not printable characters */
    public float f3412;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f3413;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f3414;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f3415;

    /* renamed from: އ, reason: contains not printable characters */
    public int f3416;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f3417;

    /* renamed from: މ, reason: contains not printable characters */
    public InterfaceC1236 f3418;

    /* renamed from: ފ, reason: contains not printable characters */
    public ISOView.InterfaceC1186 f3419;

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1219 implements View.OnClickListener {
        public ViewOnClickListenerC1219() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408) && !C3947.m12727().m12764()) {
                C3947.m12727().m12777(true);
                ShutterView.this.m3438(true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1220 implements View.OnClickListener {
        public ViewOnClickListenerC1220() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408) && C3947.m12727().m12764()) {
                C3947.m12727().m12777(false);
                ShutterView.this.m3438(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$Ԫ, reason: contains not printable characters */
    public class C1221 implements SwitchButton.InterfaceC0969 {
        public C1221() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12779(z);
            ShutterView.this.m3418(z);
            if (ShutterView.this.f3418 != null) {
                ShutterView.this.f3418.mo3443();
            }
            if (!z && r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408)) {
                ShutterView.this.f3399.f12641.m2326(ShutterView.this.m3423(C3947.m12727().m12739()), false, ShutterView.this.getAngleStr());
                ShutterView.this.f3399.f12642.m2326(ShutterView.this.m3426(C3947.m12727().m12735()), false, ShutterView.this.getSpeedStr());
                ShutterView.this.f3399.f12637.setValueAndUpdateUI(ShutterView.this.m3422(C3947.m12727().m12739()));
                ShutterView.this.f3399.f12640.setValueAndUpdateUI(ShutterView.this.m3425(C3947.m12727().m12735()));
                ShutterView.this.m3419();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$Ԭ, reason: contains not printable characters */
    public class RunnableC1222 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3423;

        public RunnableC1222(String str) {
            this.f3423 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = ShutterView.this.f3399.f12645.getPaint().measureText(this.f3423);
            ViewGroup.LayoutParams layoutParams = ShutterView.this.f3399.f12645.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            ShutterView.this.f3399.f12645.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$Ԯ, reason: contains not printable characters */
    public class RunnableC1223 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3425;

        public RunnableC1223(String str) {
            this.f3425 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = ShutterView.this.f3399.f12647.getPaint().measureText(this.f3425);
            ViewGroup.LayoutParams layoutParams = ShutterView.this.f3399.f12647.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            ShutterView.this.f3399.f12647.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ՠ, reason: contains not printable characters */
    public class C1224 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f3427;

        public C1224(int i) {
            this.f3427 = i;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ShutterView.this.m3436();
            if (this.f3427 == 0 || ShutterView.this.f3419 == null) {
                return;
            }
            ShutterView.this.f3419.mo3302(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ֈ, reason: contains not printable characters */
    public class RunnableC1225 implements Runnable {
        public RunnableC1225() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ShutterView.this.f3419.mo3302(false);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$֏, reason: contains not printable characters */
    public class RunnableC1226 implements Runnable {
        public RunnableC1226() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = ShutterView.this.getLayoutParams().width - (ShutterView.this.f3404 * 2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ShutterView.this.f3399.f12644.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) ShutterView.this.f3399.f12638.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) ShutterView.this.f3399.f12635.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ((((((((i - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).width) - C4792.m14375().m14476(10)) - (C4792.m14375().m14476(C4792.m14375().m14474()) * 3)) - ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) ShutterView.this.f3399.f12646.getLayoutParams())).leftMargin) - ShutterView.this.f3399.f12646.getMeasuredWidth()) - ShutterView.this.f3399.f12644.getMeasuredWidth()) / 2) + C4792.m14375().m14476(20);
            ShutterView.this.f3399.f12644.setLayoutParams(layoutParams);
            ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = C4792.m14375().m14476(120);
            ShutterView.this.f3399.f12635.setLayoutParams(layoutParams3);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ׯ, reason: contains not printable characters */
    public class C1227 implements AbstractC4975.InterfaceC4976 {
        public C1227() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if (!C3947.m12727().m12765() && i != ShutterView.this.f3405 && r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408)) {
                if (ShutterView.this.f3405 != -1) {
                    ((C2798) ShutterView.this.f3400.get(ShutterView.this.f3405)).setSelected(false);
                    C4842 c4842 = (C4842) ShutterView.this.f3399.f12634.findViewHolderForAdapterPosition(ShutterView.this.f3405);
                    if (c4842 != null) {
                        c4842.m14568(false);
                    }
                    ((C2798) ShutterView.this.f3401.get(ShutterView.this.f3405)).setSelected(false);
                    C4842 c48422 = (C4842) ShutterView.this.f3399.f12636.findViewHolderForAdapterPosition(ShutterView.this.f3405);
                    if (c48422 != null) {
                        c48422.m14568(false);
                    }
                }
                C2798 c2798 = (C2798) ShutterView.this.f3400.get(i);
                c2798.setSelected(true);
                C4842 c48423 = (C4842) ShutterView.this.f3399.f12634.findViewHolderForAdapterPosition(i);
                if (c48423 != null) {
                    c48423.m14568(true);
                }
                C2798 c27982 = (C2798) ShutterView.this.f3401.get(i);
                c27982.setSelected(true);
                C4842 c48424 = (C4842) ShutterView.this.f3399.f12636.findViewHolderForAdapterPosition(i);
                if (c48424 != null) {
                    c48424.m14568(true);
                }
                ShutterView.this.f3405 = i;
                ShutterView.this.f3406 = i;
                float fM10112 = c27982.m10112();
                float fM10110 = c2798.m10110();
                C3947.m12727().m12784(fM10112);
                C3947.m12727().m12788(fM10110);
                ShutterView.this.f3399.f12637.setValueAndUpdateUI(ShutterView.this.m3422(C3947.m12727().m12739()));
                ShutterView.this.f3399.f12640.setValueAndUpdateUI(ShutterView.this.m3425(C3947.m12727().m12735()));
                ShutterView.this.f3399.f12641.m2326(ShutterView.this.m3423(C3947.m12727().m12739()), false, ShutterView.this.getAngleStr());
                ShutterView.this.f3399.f12642.m2326(ShutterView.this.m3426(C3947.m12727().m12735()), false, ShutterView.this.getSpeedStr());
                if (ShutterView.this.f3418 != null) {
                    ShutterView.this.f3418.onChange();
                }
                C4535.m13880().m13915();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ؠ, reason: contains not printable characters */
    public class C1228 implements AbstractC4975.InterfaceC4976 {
        public C1228() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if (!C3947.m12727().m12765() && i != ShutterView.this.f3406 && r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408)) {
                if (ShutterView.this.f3406 != -1) {
                    ((C2798) ShutterView.this.f3401.get(ShutterView.this.f3406)).setSelected(false);
                    C4842 c4842 = (C4842) ShutterView.this.f3399.f12636.findViewHolderForAdapterPosition(ShutterView.this.f3406);
                    if (c4842 != null) {
                        c4842.m14568(false);
                    }
                    ((C2798) ShutterView.this.f3400.get(ShutterView.this.f3406)).setSelected(false);
                    C4842 c48422 = (C4842) ShutterView.this.f3399.f12634.findViewHolderForAdapterPosition(ShutterView.this.f3406);
                    if (c48422 != null) {
                        c48422.m14568(false);
                    }
                }
                C2798 c2798 = (C2798) ShutterView.this.f3401.get(i);
                c2798.setSelected(true);
                C4842 c48423 = (C4842) ShutterView.this.f3399.f12636.findViewHolderForAdapterPosition(i);
                if (c48423 != null) {
                    c48423.m14568(true);
                }
                C2798 c27982 = (C2798) ShutterView.this.f3400.get(i);
                c27982.setSelected(true);
                C4842 c48424 = (C4842) ShutterView.this.f3399.f12634.findViewHolderForAdapterPosition(i);
                if (c48424 != null) {
                    c48424.m14568(true);
                }
                ShutterView.this.f3406 = i;
                ShutterView.this.f3405 = i;
                float fM10112 = c2798.m10112();
                float fM10110 = c27982.m10110();
                C3947.m12727().m12784(fM10112);
                C3947.m12727().m12788(fM10110);
                ShutterView.this.f3399.f12637.setValueAndUpdateUI(ShutterView.this.m3422(C3947.m12727().m12739()));
                ShutterView.this.f3399.f12640.setValueAndUpdateUI(ShutterView.this.m3425(C3947.m12727().m12735()));
                ShutterView.this.f3399.f12641.m2326(ShutterView.this.m3423(C3947.m12727().m12739()), false, ShutterView.this.getAngleStr());
                ShutterView.this.f3399.f12642.m2326(ShutterView.this.m3426(C3947.m12727().m12735()), false, ShutterView.this.getSpeedStr());
                if (ShutterView.this.f3418 != null) {
                    ShutterView.this.f3418.onChange();
                }
                C4535.m13880().m13915();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC1229 implements View.OnClickListener {
        public ViewOnClickListenerC1229() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ށ, reason: contains not printable characters */
    public class C1230 implements FilmSeekBar.InterfaceC0896 {
        public C1230() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            if (r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408)) {
                if (C3947.f13602) {
                    C4638.m14099(ShutterView.f3398, "angel pro:" + f + " progress:" + f2);
                }
                ShutterView.this.m3434(f, true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ނ, reason: contains not printable characters */
    public class C1231 implements FilmSeekBar.InterfaceC0896 {
        public C1231() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            if (r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408)) {
                if (C3947.f13602) {
                    C4638.m14099(ShutterView.f3398, "speed pro:" + f + " progress:" + f2);
                }
                ShutterView.this.m3435(f);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ރ, reason: contains not printable characters */
    public class C1232 implements FilmSeekBar.InterfaceC0897 {
        public C1232() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ϳ */
        public void mo2145() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ԩ */
        public void mo2146() {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ބ, reason: contains not printable characters */
    public class C1233 implements FilmSeekBar.InterfaceC0897 {
        public C1233() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ϳ */
        public void mo2145() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0897
        /* renamed from: Ԩ */
        public void mo2146() {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ޅ, reason: contains not printable characters */
    public class C1234 implements FilmStopView.InterfaceC0908 {
        public C1234() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            if (r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408)) {
                ShutterView.this.m3440(i);
                ShutterView.this.m3419();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$ކ, reason: contains not printable characters */
    public class C1235 implements FilmStopView.InterfaceC0908 {
        public C1235() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            if (r1.m8144(ShutterView.this.f3407) && r1.m8144(ShutterView.this.f3408)) {
                ShutterView.this.m3439(i);
                ShutterView.this.m3419();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterView$އ, reason: contains not printable characters */
    public interface InterfaceC1236 {
        void onChange();

        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo3442();

        /* renamed from: ֏, reason: contains not printable characters */
        void mo3443();
    }

    public ShutterView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAngleStr() {
        float fM12739 = C3947.m12727().m12739();
        return new DecimalFormat("#.#").format(fM12739) + "°";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSpeedStr() {
        float fM12735 = C3947.m12727().m12735();
        if (fM12735 <= 1.0f) {
            return "1/" + Math.round(1.0f / fM12735);
        }
        float fFloatValue = new BigDecimal(fM12735).setScale(1, 4).floatValue();
        if (String.valueOf(fFloatValue).endsWith("0")) {
            return "" + ((long) fFloatValue);
        }
        return "" + fFloatValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3416 = i2;
        if (this.f3417) {
            return;
        }
        m3427(0, null);
    }

    public void setOnExposureChange(InterfaceC1236 interfaceC1236) {
        this.f3418 = interfaceC1236;
    }

    public void setOnVStateChange(ISOView.InterfaceC1186 interfaceC1186) {
        this.f3419 = interfaceC1186;
    }

    public void setPadding(int i) {
        this.f3404 = i;
        ConstraintLayout constraintLayout = this.f3399.f12633;
        if (constraintLayout != null) {
            constraintLayout.setPadding(i, 0, i, 0);
        }
    }

    public void setPro(float f) {
        this.f3399.f12637.setValueAndUpdateUI(m3422(C3947.m12727().m12739()));
        this.f3399.f12640.setValueAndUpdateUI(m3425(C3947.m12727().m12735()));
        m3434(f, false);
    }

    public void setShutterViewEnable(boolean z) {
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            this.f3399.f12638.setAlpha(1.0f);
            this.f3399.f12638.setEnabled(true);
            this.f3399.f12638.m2630(false, zM12765);
            m3418(zM12765);
            return;
        }
        this.f3399.f12638.m2630(false, true);
        this.f3399.f12638.setEnabled(false);
        this.f3399.f12638.setAlpha(this.f3415);
        m3418(zM12765);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m3418(boolean z) {
        if (z) {
            this.f3399.f12641.m2318();
            this.f3399.f12642.m2318();
            m3420(this.f3399.f12644);
            m3420(this.f3399.f12646);
            m3420(this.f3399.f12634);
            m3420(this.f3399.f12636);
            this.f3399.f12637.setEnabled(false);
            this.f3399.f12640.setEnabled(false);
            this.f3399.f12637.setPaintAlpha(this.f3415);
            this.f3399.f12640.setPaintAlpha(this.f3415);
            return;
        }
        this.f3399.f12641.m2320();
        this.f3399.f12642.m2320();
        m3421(this.f3399.f12644);
        m3421(this.f3399.f12646);
        m3421(this.f3399.f12634);
        m3421(this.f3399.f12636);
        this.f3399.f12637.setPaintAlpha(1.0f);
        this.f3399.f12640.setPaintAlpha(1.0f);
        this.f3399.f12637.setEnabled(true);
        this.f3399.f12640.setEnabled(true);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m3419() {
        C3947.m12727().m12739();
        float fRound = (1.0f / Math.round(1.0f / C3947.m12727().m12735())) * 360.0f * C3947.m12727().m12747();
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fRound = C3947.m12727().m12760(iM12471) * (1.0f / Math.round(1.0f / C3947.m12727().m12735())) * 360.0f;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.f3400.size(); i2++) {
            if (Math.abs(this.f3400.get(i2).m10110() - fRound) < 0.1f) {
                i = i2;
            }
        }
        String angleStr = getAngleStr();
        int i3 = -1;
        for (int i4 = 0; i4 < this.f3400.size(); i4++) {
            if (angleStr.equals(this.f3400.get(i4).m10111())) {
                i3 = i4;
            }
        }
        if (this.f3405 > this.f3400.size()) {
            this.f3405 = 0;
        }
        if (this.f3406 > this.f3401.size()) {
            this.f3406 = 0;
        }
        int i5 = this.f3405;
        if (i5 != -1 && i5 <= this.f3400.size() - 1) {
            this.f3400.get(this.f3405).setSelected(false);
            C4842 c4842 = (C4842) this.f3399.f12634.findViewHolderForAdapterPosition(this.f3405);
            if (c4842 != null) {
                c4842.m14568(false);
            }
        } else if (i3 == -1 && r1.m8144(this.f3400)) {
            int i6 = -1;
            for (int i7 = 0; i7 < this.f3400.size(); i7++) {
                if (this.f3400.get(i7).isSelected()) {
                    i6 = i7;
                }
            }
            if (i6 != -1) {
                this.f3400.get(i6).setSelected(false);
                C4842 c48422 = (C4842) this.f3399.f12634.findViewHolderForAdapterPosition(i6);
                if (c48422 != null) {
                    c48422.m14568(false);
                }
            }
        }
        int i8 = this.f3406;
        if (i8 != -1 && i8 <= this.f3401.size() - 1) {
            this.f3401.get(this.f3406).setSelected(false);
            C4842 c48423 = (C4842) this.f3399.f12636.findViewHolderForAdapterPosition(this.f3406);
            if (c48423 != null) {
                c48423.m14568(false);
            }
        } else if (i == -1 && r1.m8144(this.f3401)) {
            int i9 = -1;
            for (int i10 = 0; i10 < this.f3401.size(); i10++) {
                if (this.f3401.get(i10).isSelected()) {
                    i9 = i10;
                }
            }
            if (i9 != -1) {
                this.f3401.get(i9).setSelected(false);
                C4842 c48424 = (C4842) this.f3399.f12636.findViewHolderForAdapterPosition(i9);
                if (c48424 != null) {
                    c48424.m14568(false);
                }
            }
        }
        if (i3 != -1) {
            this.f3400.get(i3).setSelected(true);
            C4842 c48425 = (C4842) this.f3399.f12634.findViewHolderForAdapterPosition(i3);
            if (c48425 != null) {
                c48425.m14568(true);
            }
        }
        if (i != -1) {
            this.f3401.get(i).setSelected(true);
            C4842 c48426 = (C4842) this.f3399.f12636.findViewHolderForAdapterPosition(i);
            if (c48426 != null) {
                c48426.m14568(true);
            }
        }
        this.f3405 = i3;
        this.f3406 = i;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m3420(View view) {
        view.setEnabled(false);
        view.setAlpha(this.f3415);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m3421(View view) {
        view.setEnabled(true);
        view.setAlpha(1.0f);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final int m3422(float f) {
        float f2 = (f - this.f3410) / this.f3411;
        int max = (int) (this.f3399.f12637.getMax() * f2);
        if (C3947.f13602) {
            C4638.m14099("slim", "getAngelProByValue angle:" + f + " return:" + max + " p:" + f2);
        }
        return max;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final float m3423(float f) {
        boolean z = false;
        int i = 0;
        float f2 = 0.0f;
        while (true) {
            if (i >= this.f3407.size()) {
                break;
            }
            float fFloatValue = this.f3407.get(i).floatValue() - f;
            if (Math.abs(fFloatValue) <= 1.0E-4f) {
                f2 = i;
                z = true;
                break;
            }
            if (fFloatValue > 0.0f) {
                f2 = i;
            }
            i++;
        }
        float size = (this.f3407.size() - 1) - f2;
        return !z ? size - 0.5f : size;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final List<String> m3424(List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.reverse(arrayList);
        return arrayList;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final int m3425(float f) {
        int iM12743 = (int) (C3947.m12727().m12743((f - this.f3413) / this.f3414) * this.f3399.f12640.getMax());
        if (C3947.f13602) {
            C4638.m14099(f3398, "getAngelProByValue speed:" + f + " return:" + iM12743);
        }
        return iM12743;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final float m3426(float f) {
        boolean z = false;
        int i = 0;
        float f2 = 0.0f;
        while (true) {
            if (i >= this.f3408.size()) {
                break;
            }
            float fFloatValue = this.f3408.get(i).floatValue();
            if (fFloatValue == f) {
                f2 = i;
                z = true;
                break;
            }
            if (fFloatValue - f > 0.0f) {
                f2 = i;
            }
            i++;
        }
        float size = (this.f3408.size() - 1) - f2;
        return !z ? size - 0.5f : size;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m3427(int i, AbstractC4012 abstractC4012) {
        this.f3417 = false;
        C4008.m12886(this, 0.0f, this.f3416, i, abstractC4012);
        if (i == 0 || this.f3419 == null) {
            return;
        }
        postDelayed(new RunnableC1225(), i);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m3428() {
        this.f3399 = AbstractC3640.m11707(LayoutInflater.from(getContext()), this, true);
        m3430();
        m3432();
        m3431();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc  */
    /* renamed from: ޗ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3429() {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.ShutterView.m3429():void");
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m3430() {
        this.f3399.f12647.setContentTextColor(-1);
        float fM14434 = C4792.m14375().m14434();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3399.f12633.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14408();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C4792.m14375().m14406();
        this.f3399.f12633.setLayoutParams(layoutParams);
        this.f3399.f12645.setContentTextColor(-1);
        this.f3399.f12645.m2562(0, C4792.m14375().m14482());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f3399.f12645.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = C4792.m14375().m14476(37);
        this.f3399.f12645.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f3399.f12638.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) (C4792.m14375().m14409() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (C4792.m14375().m14410() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = (int) (C4792.m14375().m14411() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = C4792.m14375().m14476(93);
        this.f3399.f12638.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f3399.f12643.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = C4792.m14375().m14476(490);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = C4792.m14375().m14476(100);
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin - C4792.m14375().m14476(10);
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = C4792.m14375().m14476(80);
        this.f3399.f12643.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f3399.f12639.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = C4792.m14375().m14476(90);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = C4792.m14375().m14476(73);
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = C4792.m14375().m14476(1270);
        this.f3399.f12639.setLayoutParams(layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f3399.f12644.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = C4792.m14375().m14476(185);
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = C4792.m14375().m14476(60);
        this.f3399.f12644.setLayoutParams(layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f3399.f12646.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin = C4792.m14375().m14476(93);
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = C4792.m14375().m14476(60);
        this.f3399.f12646.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f3399.f12635.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = C4792.m14375().m14476(40);
        this.f3399.f12635.setLayoutParams(layoutParams8);
        this.f3399.f12644.m2576(0, C4792.m14375().m14386());
        this.f3399.f12646.m2576(0, C4792.m14375().m14386());
        this.f3399.f12644.setTextColor(-1);
        this.f3399.f12646.setTextColor(-1);
        this.f3399.f12644.setText(getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_ANGLE));
        this.f3399.f12646.setText(getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_SPEED));
        this.f3399.f12647.m2562(0, C4792.m14375().m14381());
        this.f3399.f12638.setTextSize(C4792.m14375().m14481());
        this.f3399.f12641.setTextColor(-1);
        this.f3399.f12642.setTextColor(-1);
        this.f3399.f12641.m2327(0, C4792.m14375().m14386());
        this.f3399.f12642.m2327(0, C4792.m14375().m14386());
        ViewGroup.LayoutParams layoutParams9 = this.f3399.f12647.getLayoutParams();
        layoutParams9.width = (int) (this.f3399.f12647.getPaint().measureText(getResources().getString(R.string.RECORDING_INFO_SHUTTER).toUpperCase()) + C4792.f16138);
        this.f3399.f12647.setLayoutParams(layoutParams9);
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m3431() {
        this.f3399.f12633.setOnClickListener(new ViewOnClickListenerC1229());
        this.f3399.f12637.setOnProChange(new C1230());
        this.f3399.f12640.setOnProChange(new C1231());
        this.f3399.f12640.setOnTouchStateChange(new C1232());
        this.f3399.f12637.setOnTouchStateChange(new C1233());
        this.f3399.f12642.setOnStopClick(new C1234());
        this.f3399.f12641.setOnStopClick(new C1235());
        this.f3399.f12644.setOnClickListener(new ViewOnClickListenerC1219());
        this.f3399.f12646.setOnClickListener(new ViewOnClickListenerC1220());
        this.f3399.f12638.setOnCheckedChangeListener(new C1221());
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m3432() {
        this.f3400 = new ArrayList();
        this.f3401 = new ArrayList();
        this.f3402 = new C4720(getContext(), this.f3400, new C1227());
        this.f3403 = new C4720(getContext(), this.f3401, new C1228());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), 0, false);
        this.f3399.f12636.setLayoutManager(linearLayoutManager);
        this.f3399.f12636.setAdapter(this.f3403);
        this.f3399.f12634.setLayoutManager(linearLayoutManager2);
        this.f3399.f12634.setAdapter(this.f3402);
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public boolean m3433() {
        return this.f3417;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m3434(float f, boolean z) {
        float fM12739 = this.f3410 + (this.f3411 * f);
        float fM12747 = fM12739 / (C3947.m12727().m12747() * 360);
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fM12747 = fM12739 / (C3947.m12727().m12760(iM12471) * 360.0f);
        }
        if (!z) {
            fM12739 = C3947.m12727().m12739();
            fM12747 = C3947.m12727().m12735();
        }
        C3947.m12727().m12784(fM12747);
        C3947.m12727().m12788(fM12739);
        InterfaceC1236 interfaceC1236 = this.f3418;
        if (interfaceC1236 != null && z) {
            interfaceC1236.onChange();
        }
        this.f3399.f12641.m2326(m3423(C3947.m12727().m12739()), false, getAngleStr());
        this.f3399.f12642.m2326(m3426(C3947.m12727().m12735()), false, getSpeedStr());
        this.f3399.f12640.setValueAndUpdateUI(m3425(C3947.m12727().m12735()));
        m3419();
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final void m3435(float f) {
        float fM12755 = this.f3413 + (this.f3414 * C3947.m12727().m12755(f));
        float f2 = 360.0f * fM12755;
        float fM12747 = C3947.m12727().m12747() * f2;
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fM12747 = C3947.m12727().m12760(iM12471) * f2;
        }
        C3947.m12727().m12784(fM12755);
        C3947.m12727().m12788(fM12747);
        InterfaceC1236 interfaceC1236 = this.f3418;
        if (interfaceC1236 != null) {
            interfaceC1236.onChange();
        }
        this.f3399.f12641.m2326(m3423(C3947.m12727().m12739()), false, getAngleStr());
        this.f3399.f12642.m2326(m3426(C3947.m12727().m12735()), false, getSpeedStr());
        this.f3399.f12637.setValueAndUpdateUI(m3422(C3947.m12727().m12739()));
        m3419();
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public void m3436() {
        this.f3407 = C3947.m12727().m12740();
        this.f3408 = C3947.m12727().m12745();
        this.f3399.f12641.setStringDataList(m3424(C3947.m12727().m12741()));
        this.f3399.f12642.setStringDataList(m3424(C3947.m12727().m12746()));
        m3429();
        m3438(C3947.m12727().m12764());
        boolean zM12765 = C3947.m12727().m12765();
        this.f3399.f12638.m2630(false, zM12765);
        this.f3399.f12637.setMax(1000.0f);
        this.f3399.f12637.setMin(0.0f);
        this.f3399.f12640.setMax(1000.0f);
        this.f3399.f12640.setMin(0.0f);
        if (r1.m8144(this.f3407) && r1.m8144(this.f3408)) {
            this.f3409 = this.f3407.get(0).floatValue();
            float fFloatValue = this.f3407.get(r1.size() - 1).floatValue();
            this.f3410 = fFloatValue;
            this.f3411 = this.f3409 - fFloatValue;
            this.f3412 = this.f3408.get(0).floatValue();
            float fFloatValue2 = this.f3408.get(r1.size() - 1).floatValue();
            this.f3413 = fFloatValue2;
            this.f3414 = this.f3412 - fFloatValue2;
            this.f3399.f12641.m2326(m3423(C3947.m12727().m12739()), false, getAngleStr());
            this.f3399.f12642.m2326(m3426(C3947.m12727().m12735()), false, getSpeedStr());
            this.f3399.f12637.setValueAndUpdateUI(m3422(C3947.m12727().m12739()));
            this.f3399.f12640.setValueAndUpdateUI(m3425(C3947.m12727().m12735()));
        }
        m3418(zM12765);
        this.f3399.f12644.setText(getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_ANGLE));
        this.f3399.f12646.setText(getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_SPEED));
        String upperCase = getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_AE).toUpperCase();
        this.f3399.f12645.m2561(upperCase);
        this.f3399.f12645.post(new RunnableC1222(upperCase));
        String upperCase2 = getResources().getString(R.string.RECORDING_INFO_SHUTTER).toUpperCase();
        this.f3399.f12647.setText(upperCase2);
        this.f3399.f12647.post(new RunnableC1223(upperCase2));
        m3419();
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public void m3437(int i) {
        this.f3417 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C1224(i));
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final void m3438(boolean z) {
        if (z) {
            this.f3399.f12644.m2575(true, 0);
            this.f3399.f12646.m2575(false, 0);
            this.f3399.f12641.setVisibility(0);
            this.f3399.f12642.setVisibility(8);
            this.f3399.f12634.setVisibility(0);
            this.f3399.f12636.setVisibility(8);
            this.f3399.f12640.setVisibility(8);
            this.f3399.f12637.setVisibility(0);
        } else {
            this.f3399.f12646.m2575(true, 0);
            this.f3399.f12644.m2575(false, 0);
            this.f3399.f12641.setVisibility(8);
            this.f3399.f12642.setVisibility(0);
            this.f3399.f12634.setVisibility(8);
            this.f3399.f12636.setVisibility(0);
            this.f3399.f12640.setVisibility(0);
            this.f3399.f12637.setVisibility(8);
        }
        InterfaceC1236 interfaceC1236 = this.f3418;
        if (interfaceC1236 != null) {
            interfaceC1236.mo3442();
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m3439(int i) {
        float fFloatValue = this.f3407.get((this.f3407.size() - 1) - i).floatValue();
        C3947.m12727().m12788(fFloatValue);
        float fM12747 = fFloatValue / (C3947.m12727().m12747() * 360);
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fM12747 = fFloatValue / (C3947.m12727().m12760(iM12471) * 360.0f);
        }
        C3947.m12727().m12784(fM12747);
        this.f3399.f12637.setValueAndUpdateUI(m3422(C3947.m12727().m12739()));
        this.f3399.f12640.setValueAndUpdateUI(m3425(C3947.m12727().m12735()));
        this.f3399.f12642.m2326(m3426(C3947.m12727().m12735()), false, getSpeedStr());
        InterfaceC1236 interfaceC1236 = this.f3418;
        if (interfaceC1236 != null) {
            interfaceC1236.onChange();
        }
        C4535.m13880().m13915();
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m3440(int i) {
        float fFloatValue = this.f3408.get((this.f3408.size() - 1) - i).floatValue();
        C3947.m12727().m12784(fFloatValue);
        float f = fFloatValue * 360.0f;
        float fM12747 = C3947.m12727().m12747() * f;
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fM12747 = C3947.m12727().m12760(iM12471) * f;
        }
        C3947.m12727().m12788(fM12747);
        this.f3399.f12637.setValueAndUpdateUI(m3422(C3947.m12727().m12739()));
        this.f3399.f12640.setValueAndUpdateUI(m3425(C3947.m12727().m12735()));
        this.f3399.f12641.m2326(m3423(C3947.m12727().m12739()), false, getAngleStr());
        InterfaceC1236 interfaceC1236 = this.f3418;
        if (interfaceC1236 != null) {
            interfaceC1236.onChange();
        }
        C4535.m13880().m13915();
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public void m3441() {
        this.f3399.f12646.post(new RunnableC1226());
    }

    public ShutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShutterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3405 = -1;
        this.f3406 = -1;
        this.f3415 = 0.2f;
        m3428();
    }
}
