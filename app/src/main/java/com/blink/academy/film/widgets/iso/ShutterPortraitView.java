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
import com.blink.academy.film.widgets.iso.ShutterView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.AbstractC4975;
import defpackage.AbstractC5095;
import defpackage.C2579;
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
public class ShutterPortraitView extends ConstraintLayout {

    /* renamed from: ލ, reason: contains not printable characters */
    public static final String f3353 = ShutterView.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC5095 f3354;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public List<C2798> f3355;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<C2798> f3356;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4720 f3357;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C4720 f3358;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3359;

    /* renamed from: ֈ, reason: contains not printable characters */
    public LinearLayoutManager f3360;

    /* renamed from: ֏, reason: contains not printable characters */
    public LinearLayoutManager f3361;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f3362;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f3363;

    /* renamed from: ހ, reason: contains not printable characters */
    public List<Float> f3364;

    /* renamed from: ށ, reason: contains not printable characters */
    public List<Float> f3365;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f3366;

    /* renamed from: ރ, reason: contains not printable characters */
    public float f3367;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f3368;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f3369;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f3370;

    /* renamed from: އ, reason: contains not printable characters */
    public float f3371;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f3372;

    /* renamed from: މ, reason: contains not printable characters */
    public int f3373;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f3374;

    /* renamed from: ދ, reason: contains not printable characters */
    public ShutterView.InterfaceC1236 f3375;

    /* renamed from: ތ, reason: contains not printable characters */
    public ISOView.InterfaceC1186 f3376;

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1201 implements View.OnClickListener {
        public ViewOnClickListenerC1201() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365) && !C3947.m12727().m12764()) {
                C3947.m12727().m12777(true);
                ShutterPortraitView.this.m3388(true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1202 implements View.OnClickListener {
        public ViewOnClickListenerC1202() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365) && C3947.m12727().m12764()) {
                C3947.m12727().m12777(false);
                ShutterPortraitView.this.m3388(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$Ԫ, reason: contains not printable characters */
    public class C1203 implements SwitchButton.InterfaceC0969 {
        public C1203() {
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
            ShutterPortraitView.this.m3367(z);
            if (ShutterPortraitView.this.f3375 != null) {
                ShutterPortraitView.this.f3375.mo3443();
            }
            if (!z && r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365)) {
                ShutterPortraitView.this.f3354.f16922.m2326(ShutterPortraitView.this.m3372(C3947.m12727().m12739()), false, ShutterPortraitView.this.getAngleStr());
                ShutterPortraitView.this.f3354.f16923.m2326(ShutterPortraitView.this.m3375(C3947.m12727().m12735()), false, ShutterPortraitView.this.getSpeedStr());
                ShutterPortraitView.this.f3354.f16918.setValueAndUpdateUI(ShutterPortraitView.this.m3371(C3947.m12727().m12739()));
                ShutterPortraitView.this.f3354.f16921.setValueAndUpdateUI(ShutterPortraitView.this.m3374(C3947.m12727().m12735()));
                ShutterPortraitView.this.m3368();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$Ԭ, reason: contains not printable characters */
    public class RunnableC1204 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3380;

        public RunnableC1204(String str) {
            this.f3380 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = ShutterPortraitView.this.f3354.f16927.getPaint().measureText(this.f3380);
            ViewGroup.LayoutParams layoutParams = ShutterPortraitView.this.f3354.f16927.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            ShutterPortraitView.this.f3354.f16927.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$Ԯ, reason: contains not printable characters */
    public class RunnableC1205 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3382;

        public RunnableC1205(String str) {
            this.f3382 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = ShutterPortraitView.this.f3354.f16929.getPaint().measureText(this.f3382);
            ViewGroup.LayoutParams layoutParams = ShutterPortraitView.this.f3354.f16929.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            ShutterPortraitView.this.f3354.f16929.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ՠ, reason: contains not printable characters */
    public class RunnableC1206 implements Runnable {
        public RunnableC1206() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShutterPortraitView.this.f3362 > 0) {
                ShutterPortraitView.this.f3354.f16913.scrollTo(C2579.f9598, 0);
            }
            if (ShutterPortraitView.this.f3363 > 0) {
                ShutterPortraitView.this.f3354.f16913.scrollTo(C2579.f9598, 0);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ֈ, reason: contains not printable characters */
    public class C1207 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f3385;

        public C1207(int i) {
            this.f3385 = i;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ShutterPortraitView.this.m3385();
            if (this.f3385 != 0 && ShutterPortraitView.this.f3376 != null) {
                ShutterPortraitView.this.f3376.mo3302(true);
            }
            ShutterPortraitView.this.m3386();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$֏, reason: contains not printable characters */
    public class RunnableC1208 implements Runnable {
        public RunnableC1208() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ShutterPortraitView.this.f3376.mo3302(false);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ׯ, reason: contains not printable characters */
    public class RunnableC1209 implements Runnable {
        public RunnableC1209() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ؠ, reason: contains not printable characters */
    public class C1210 implements AbstractC4975.InterfaceC4976 {
        public C1210() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if (!C3947.m12727().m12765() && i != ShutterPortraitView.this.f3362 && r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365)) {
                if (ShutterPortraitView.this.f3362 != -1) {
                    ((C2798) ShutterPortraitView.this.f3355.get(ShutterPortraitView.this.f3362)).setSelected(false);
                    C4842 c4842 = (C4842) ShutterPortraitView.this.f3354.f16915.findViewHolderForAdapterPosition(ShutterPortraitView.this.f3362);
                    if (c4842 != null) {
                        c4842.m14568(false);
                    }
                    ((C2798) ShutterPortraitView.this.f3356.get(ShutterPortraitView.this.f3362)).setSelected(false);
                    C4842 c48422 = (C4842) ShutterPortraitView.this.f3354.f16917.findViewHolderForAdapterPosition(ShutterPortraitView.this.f3362);
                    if (c48422 != null) {
                        c48422.m14568(false);
                    }
                }
                C2798 c2798 = (C2798) ShutterPortraitView.this.f3355.get(i);
                c2798.setSelected(true);
                C4842 c48423 = (C4842) ShutterPortraitView.this.f3354.f16915.findViewHolderForAdapterPosition(i);
                if (c48423 != null) {
                    c48423.m14568(true);
                }
                C2798 c27982 = (C2798) ShutterPortraitView.this.f3356.get(i);
                c27982.setSelected(true);
                C4842 c48424 = (C4842) ShutterPortraitView.this.f3354.f16917.findViewHolderForAdapterPosition(i);
                if (c48424 != null) {
                    c48424.m14568(true);
                }
                ShutterPortraitView.this.f3362 = i;
                ShutterPortraitView.this.f3363 = i;
                float fM10112 = c27982.m10112();
                float fM10110 = c2798.m10110();
                C3947.m12727().m12784(fM10112);
                C3947.m12727().m12788(fM10110);
                ShutterPortraitView.this.f3354.f16918.setValueAndUpdateUI(ShutterPortraitView.this.m3371(C3947.m12727().m12739()));
                ShutterPortraitView.this.f3354.f16921.setValueAndUpdateUI(ShutterPortraitView.this.m3374(C3947.m12727().m12735()));
                ShutterPortraitView.this.f3354.f16922.m2326(ShutterPortraitView.this.m3372(C3947.m12727().m12739()), false, ShutterPortraitView.this.getAngleStr());
                ShutterPortraitView.this.f3354.f16923.m2326(ShutterPortraitView.this.m3375(C3947.m12727().m12735()), false, ShutterPortraitView.this.getSpeedStr());
                if (ShutterPortraitView.this.f3375 != null) {
                    ShutterPortraitView.this.f3375.onChange();
                }
                C4535.m13880().m13915();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ހ, reason: contains not printable characters */
    public class C1211 implements AbstractC4975.InterfaceC4976 {
        public C1211() {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: ԭ */
        public void mo1557(int i) {
        }

        @Override // defpackage.AbstractC4975.InterfaceC4976
        /* renamed from: Ԯ */
        public void mo1558(int i) {
            if (!C3947.m12727().m12765() && i != ShutterPortraitView.this.f3363 && r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365)) {
                if (ShutterPortraitView.this.f3363 != -1) {
                    ((C2798) ShutterPortraitView.this.f3356.get(ShutterPortraitView.this.f3363)).setSelected(false);
                    C4842 c4842 = (C4842) ShutterPortraitView.this.f3354.f16917.findViewHolderForAdapterPosition(ShutterPortraitView.this.f3363);
                    if (c4842 != null) {
                        c4842.m14568(false);
                    }
                    ((C2798) ShutterPortraitView.this.f3355.get(ShutterPortraitView.this.f3363)).setSelected(false);
                    C4842 c48422 = (C4842) ShutterPortraitView.this.f3354.f16915.findViewHolderForAdapterPosition(ShutterPortraitView.this.f3363);
                    if (c48422 != null) {
                        c48422.m14568(false);
                    }
                }
                C2798 c2798 = (C2798) ShutterPortraitView.this.f3356.get(i);
                c2798.setSelected(true);
                C4842 c48423 = (C4842) ShutterPortraitView.this.f3354.f16917.findViewHolderForAdapterPosition(i);
                if (c48423 != null) {
                    c48423.m14568(true);
                }
                C2798 c27982 = (C2798) ShutterPortraitView.this.f3355.get(i);
                c27982.setSelected(true);
                C4842 c48424 = (C4842) ShutterPortraitView.this.f3354.f16915.findViewHolderForAdapterPosition(i);
                if (c48424 != null) {
                    c48424.m14568(true);
                }
                ShutterPortraitView.this.f3363 = i;
                ShutterPortraitView.this.f3362 = i;
                float fM10112 = c2798.m10112();
                float fM10110 = c27982.m10110();
                C3947.m12727().m12784(fM10112);
                C3947.m12727().m12788(fM10110);
                ShutterPortraitView.this.f3354.f16918.setValueAndUpdateUI(ShutterPortraitView.this.m3371(C3947.m12727().m12739()));
                ShutterPortraitView.this.f3354.f16921.setValueAndUpdateUI(ShutterPortraitView.this.m3374(C3947.m12727().m12735()));
                ShutterPortraitView.this.f3354.f16922.m2326(ShutterPortraitView.this.m3372(C3947.m12727().m12739()), false, ShutterPortraitView.this.getAngleStr());
                ShutterPortraitView.this.f3354.f16923.m2326(ShutterPortraitView.this.m3375(C3947.m12727().m12735()), false, ShutterPortraitView.this.getSpeedStr());
                if (ShutterPortraitView.this.f3375 != null) {
                    ShutterPortraitView.this.f3375.onChange();
                }
                C4535.m13880().m13915();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ށ, reason: contains not printable characters */
    public class ViewOnClickListenerC1212 implements View.OnClickListener {
        public ViewOnClickListenerC1212() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ނ, reason: contains not printable characters */
    public class C1213 implements FilmSeekBar.InterfaceC0896 {
        public C1213() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            if (r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365)) {
                if (C3947.f13602) {
                    C4638.m14099(ShutterPortraitView.f3353, "angel pro:" + f + " progress:" + f2);
                }
                ShutterPortraitView.this.m3383(f, true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ރ, reason: contains not printable characters */
    public class C1214 implements FilmSeekBar.InterfaceC0896 {
        public C1214() {
        }

        @Override // com.blink.academy.film.widgets.FilmSeekBar.InterfaceC0896
        /* renamed from: Ϳ */
        public void mo1561(float f, float f2) {
            if (r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365)) {
                if (C3947.f13602) {
                    C4638.m14099(ShutterPortraitView.f3353, "speed pro:" + f + " progress:" + f2);
                }
                ShutterPortraitView.this.m3384(f);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ބ, reason: contains not printable characters */
    public class C1215 implements FilmSeekBar.InterfaceC0897 {
        public C1215() {
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

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ޅ, reason: contains not printable characters */
    public class C1216 implements FilmSeekBar.InterfaceC0897 {
        public C1216() {
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

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$ކ, reason: contains not printable characters */
    public class C1217 implements FilmStopView.InterfaceC0908 {
        public C1217() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            if (r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365)) {
                ShutterPortraitView.this.m3390(i);
                ShutterPortraitView.this.m3368();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.ShutterPortraitView$އ, reason: contains not printable characters */
    public class C1218 implements FilmStopView.InterfaceC0908 {
        public C1218() {
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ϳ */
        public boolean mo2147() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.FilmStopView.InterfaceC0908
        /* renamed from: Ԩ */
        public void mo2148(int i) {
            if (r1.m8144(ShutterPortraitView.this.f3364) && r1.m8144(ShutterPortraitView.this.f3365)) {
                ShutterPortraitView.this.m3389(i);
                ShutterPortraitView.this.m3368();
            }
        }
    }

    public ShutterPortraitView(Context context) {
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
        this.f3373 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f3374) {
            return;
        }
        m3376(0, null);
    }

    public void setOnExposureChange(ShutterView.InterfaceC1236 interfaceC1236) {
        this.f3375 = interfaceC1236;
    }

    public void setOnVStateChange(ISOView.InterfaceC1186 interfaceC1186) {
        this.f3376 = interfaceC1186;
    }

    public void setPadding(int i) {
        this.f3359 = i;
        ConstraintLayout constraintLayout = this.f3354.f16914;
    }

    public void setPro(float f) {
        this.f3354.f16918.setValueAndUpdateUI(m3371(C3947.m12727().m12739()));
        this.f3354.f16921.setValueAndUpdateUI(m3374(C3947.m12727().m12735()));
        m3383(f, false);
    }

    public void setShutterViewEnable(boolean z) {
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            this.f3354.f16919.setAlpha(1.0f);
            this.f3354.f16919.setEnabled(true);
            this.f3354.f16919.m2630(false, zM12765);
            m3367(zM12765);
            return;
        }
        this.f3354.f16919.m2630(false, true);
        this.f3354.f16919.setEnabled(false);
        this.f3354.f16919.setAlpha(this.f3372);
        m3367(zM12765);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m3367(boolean z) {
        if (z) {
            this.f3354.f16922.m2318();
            this.f3354.f16923.m2318();
            m3369(this.f3354.f16926);
            m3369(this.f3354.f16928);
            m3369(this.f3354.f16915);
            m3369(this.f3354.f16917);
            this.f3354.f16918.setEnabled(false);
            this.f3354.f16921.setEnabled(false);
            this.f3354.f16918.setPaintAlpha(this.f3372);
            this.f3354.f16921.setPaintAlpha(this.f3372);
            return;
        }
        this.f3354.f16922.m2320();
        this.f3354.f16923.m2320();
        m3370(this.f3354.f16926);
        m3370(this.f3354.f16928);
        m3370(this.f3354.f16915);
        m3370(this.f3354.f16917);
        this.f3354.f16918.setPaintAlpha(1.0f);
        this.f3354.f16921.setPaintAlpha(1.0f);
        this.f3354.f16918.setEnabled(true);
        this.f3354.f16921.setEnabled(true);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m3368() {
        C3947.m12727().m12739();
        float fRound = (1.0f / Math.round(1.0f / C3947.m12727().m12735())) * 360.0f * C3947.m12727().m12747();
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fRound = C3947.m12727().m12760(iM12471) * (1.0f / Math.round(1.0f / C3947.m12727().m12735())) * 360.0f;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.f3355.size(); i2++) {
            if (Math.abs(this.f3355.get(i2).m10110() - fRound) < 0.1f) {
                i = i2;
            }
        }
        String angleStr = getAngleStr();
        int i3 = -1;
        for (int i4 = 0; i4 < this.f3355.size(); i4++) {
            if (angleStr.equals(this.f3355.get(i4).m10111())) {
                i3 = i4;
            }
        }
        if (this.f3362 > this.f3355.size()) {
            this.f3362 = 0;
        }
        if (this.f3363 > this.f3356.size()) {
            this.f3363 = 0;
        }
        int i5 = this.f3362;
        if (i5 != -1 && i5 <= this.f3355.size() - 1) {
            this.f3355.get(this.f3362).setSelected(false);
            C4842 c4842 = (C4842) this.f3354.f16915.findViewHolderForAdapterPosition(this.f3362);
            if (c4842 != null) {
                c4842.m14568(false);
            }
        } else if (i3 == -1 && r1.m8144(this.f3355)) {
            int i6 = -1;
            for (int i7 = 0; i7 < this.f3355.size(); i7++) {
                if (this.f3355.get(i7).isSelected()) {
                    i6 = i7;
                }
            }
            if (i6 != -1) {
                this.f3355.get(i6).setSelected(false);
                C4842 c48422 = (C4842) this.f3354.f16915.findViewHolderForAdapterPosition(i6);
                if (c48422 != null) {
                    c48422.m14568(false);
                }
            }
        }
        int i8 = this.f3363;
        if (i8 != -1 && i8 <= this.f3356.size() - 1) {
            this.f3356.get(this.f3363).setSelected(false);
            C4842 c48423 = (C4842) this.f3354.f16917.findViewHolderForAdapterPosition(this.f3363);
            if (c48423 != null) {
                c48423.m14568(false);
            }
        } else if (i == -1 && r1.m8144(this.f3356)) {
            int i9 = -1;
            for (int i10 = 0; i10 < this.f3356.size(); i10++) {
                if (this.f3356.get(i10).isSelected()) {
                    i9 = i10;
                }
            }
            if (i9 != -1) {
                this.f3356.get(i9).setSelected(false);
                C4842 c48424 = (C4842) this.f3354.f16917.findViewHolderForAdapterPosition(i9);
                if (c48424 != null) {
                    c48424.m14568(false);
                }
            }
        }
        if (i3 != -1) {
            this.f3355.get(i3).setSelected(true);
            C4842 c48425 = (C4842) this.f3354.f16915.findViewHolderForAdapterPosition(i3);
            if (c48425 != null) {
                c48425.m14568(true);
            }
        }
        if (i != -1) {
            this.f3356.get(i).setSelected(true);
            C4842 c48426 = (C4842) this.f3354.f16917.findViewHolderForAdapterPosition(i);
            if (c48426 != null) {
                c48426.m14568(true);
            }
        }
        this.f3362 = i3;
        this.f3363 = i;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m3369(View view) {
        view.setEnabled(false);
        view.setAlpha(this.f3372);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m3370(View view) {
        view.setEnabled(true);
        view.setAlpha(1.0f);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final int m3371(float f) {
        float f2 = (f - this.f3367) / this.f3368;
        int max = (int) (this.f3354.f16918.getMax() * f2);
        if (C3947.f13602) {
            C4638.m14099("slim", "getAngelProByValue angle:" + f + " return:" + max + " p:" + f2);
        }
        return max;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final float m3372(float f) {
        boolean z = false;
        int i = 0;
        float f2 = 0.0f;
        while (true) {
            if (i >= this.f3364.size()) {
                break;
            }
            float fFloatValue = this.f3364.get(i).floatValue() - f;
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
        float size = (this.f3364.size() - 1) - f2;
        return !z ? size - 0.5f : size;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final List<String> m3373(List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.reverse(arrayList);
        return arrayList;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final int m3374(float f) {
        int iM12743 = (int) (C3947.m12727().m12743((f - this.f3370) / this.f3371) * this.f3354.f16921.getMax());
        if (C3947.f13602) {
            C4638.m14099(f3353, "getAngelProByValue speed:" + f + " return:" + iM12743);
        }
        return iM12743;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final float m3375(float f) {
        boolean z = false;
        int i = 0;
        float f2 = 0.0f;
        while (true) {
            if (i >= this.f3365.size()) {
                break;
            }
            float fFloatValue = this.f3365.get(i).floatValue();
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
        float size = (this.f3365.size() - 1) - f2;
        return !z ? size - 0.5f : size;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m3376(int i, AbstractC4012 abstractC4012) {
        this.f3374 = false;
        C4008.m12886(this, 0.0f, this.f3373, i, abstractC4012);
        if (i == 0 || this.f3376 == null) {
            return;
        }
        postDelayed(new RunnableC1208(), i);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m3377() {
        this.f3354 = AbstractC5095.m14924(LayoutInflater.from(getContext()), this, true);
        m3379();
        m3381();
        m3380();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc  */
    /* renamed from: ޗ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3378() {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.ShutterPortraitView.m3378():void");
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m3379() {
        this.f3354.f16929.setContentTextColor(-1);
        float fM14434 = C4792.m14375().m14434();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f3354.f16914.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14408();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C4792.m14375().m14412();
        this.f3354.f16914.setLayoutParams(layoutParams);
        int iM9445 = (int) ((C2579.m9445() * 0.085d) + ((C2579.m9445() - C2579.m9440(getContext())) / 2.0f));
        int iM14405 = C4792.m14375().m14405();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f3354.f16925.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = iM14405;
        this.f3354.f16925.setLayoutParams(layoutParams2);
        this.f3354.f16927.setContentTextColor(-1);
        this.f3354.f16927.m2562(0, C4792.m14375().m14482());
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f3354.f16927.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = C4792.m14375().m14476(37);
        this.f3354.f16927.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f3354.f16919.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = (int) (C4792.m14375().m14409() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (C4792.m14375().m14410() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (int) (C4792.m14375().m14411() * fM14434);
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = iM9445;
        this.f3354.f16919.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f3354.f16924.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = C4792.m14375().m14476(490);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = C4792.m14375().m14476(100);
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin - C4792.m14375().m14476(10);
        this.f3354.f16924.setLayoutParams(layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f3354.f16913.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = iM14405;
        this.f3354.f16913.setLayoutParams(layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f3354.f16920.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = ((ViewGroup.MarginLayoutParams) layoutParams).height - (iM14405 * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = C2579.f9594 - (iM9445 * 2);
        this.f3354.f16920.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f3354.f16926.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin = C4792.m14375().m14476(93);
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = C4792.m14375().m14476(60);
        this.f3354.f16926.setLayoutParams(layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f3354.f16928.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).rightMargin = iM9445;
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = C4792.m14375().m14476(60);
        this.f3354.f16928.setLayoutParams(layoutParams9);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f3354.f16916.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).leftMargin = C4792.m14375().m14476(93);
        this.f3354.f16916.setLayoutParams(layoutParams10);
        this.f3354.f16926.m2576(0, C4792.m14375().m14386());
        this.f3354.f16928.m2576(0, C4792.m14375().m14386());
        this.f3354.f16926.setTextColor(-1);
        this.f3354.f16928.setTextColor(-1);
        this.f3354.f16926.setText(getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_ANGLE));
        this.f3354.f16928.setText(getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_SPEED));
        this.f3354.f16929.m2562(0, C4792.m14375().m14381());
        this.f3354.f16919.setTextSize(C4792.m14375().m14481());
        this.f3354.f16922.setTextColor(-1);
        this.f3354.f16923.setTextColor(-1);
        this.f3354.f16922.m2327(0, C4792.m14375().m14386());
        this.f3354.f16923.m2327(0, C4792.m14375().m14386());
        ViewGroup.LayoutParams layoutParams11 = this.f3354.f16929.getLayoutParams();
        layoutParams11.width = (int) (this.f3354.f16929.getPaint().measureText(getResources().getString(R.string.RECORDING_INFO_SHUTTER).toUpperCase()) + C4792.f16138);
        this.f3354.f16929.setLayoutParams(layoutParams11);
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m3380() {
        this.f3354.f16914.setOnClickListener(new ViewOnClickListenerC1212());
        this.f3354.f16918.setOnProChange(new C1213());
        this.f3354.f16921.setOnProChange(new C1214());
        this.f3354.f16921.setOnTouchStateChange(new C1215());
        this.f3354.f16918.setOnTouchStateChange(new C1216());
        this.f3354.f16923.setOnStopClick(new C1217());
        this.f3354.f16922.setOnStopClick(new C1218());
        this.f3354.f16926.setOnClickListener(new ViewOnClickListenerC1201());
        this.f3354.f16928.setOnClickListener(new ViewOnClickListenerC1202());
        this.f3354.f16919.setOnCheckedChangeListener(new C1203());
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m3381() {
        this.f3355 = new ArrayList();
        this.f3356 = new ArrayList();
        this.f3357 = new C4720(getContext(), this.f3355, new C1210());
        this.f3358 = new C4720(getContext(), this.f3356, new C1211());
        this.f3360 = new LinearLayoutManager(getContext(), 0, false);
        this.f3361 = new LinearLayoutManager(getContext(), 0, false);
        this.f3354.f16917.setLayoutManager(this.f3360);
        this.f3354.f16915.setHasFixedSize(true);
        this.f3354.f16915.setNestedScrollingEnabled(false);
        this.f3354.f16917.setAdapter(this.f3358);
        this.f3354.f16915.setLayoutManager(this.f3361);
        this.f3354.f16915.setHasFixedSize(true);
        this.f3354.f16915.setNestedScrollingEnabled(false);
        this.f3354.f16915.setAdapter(this.f3357);
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public boolean m3382() {
        return this.f3374;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final void m3383(float f, boolean z) {
        float fM12739 = this.f3367 + (this.f3368 * f);
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
        ShutterView.InterfaceC1236 interfaceC1236 = this.f3375;
        if (interfaceC1236 != null && z) {
            interfaceC1236.onChange();
        }
        this.f3354.f16922.m2326(m3372(C3947.m12727().m12739()), false, getAngleStr());
        this.f3354.f16923.m2326(m3375(C3947.m12727().m12735()), false, getSpeedStr());
        this.f3354.f16921.setValueAndUpdateUI(m3374(C3947.m12727().m12735()));
        m3368();
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final void m3384(float f) {
        float fM12755 = this.f3370 + (this.f3371 * C3947.m12727().m12755(f));
        float f2 = 360.0f * fM12755;
        float fM12747 = C3947.m12727().m12747() * f2;
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fM12747 = C3947.m12727().m12760(iM12471) * f2;
        }
        C3947.m12727().m12784(fM12755);
        C3947.m12727().m12788(fM12747);
        ShutterView.InterfaceC1236 interfaceC1236 = this.f3375;
        if (interfaceC1236 != null) {
            interfaceC1236.onChange();
        }
        this.f3354.f16922.m2326(m3372(C3947.m12727().m12739()), false, getAngleStr());
        this.f3354.f16923.m2326(m3375(C3947.m12727().m12735()), false, getSpeedStr());
        this.f3354.f16918.setValueAndUpdateUI(m3371(C3947.m12727().m12739()));
        m3368();
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public void m3385() {
        this.f3364 = C3947.m12727().m12740();
        this.f3365 = C3947.m12727().m12745();
        this.f3354.f16922.setStringDataList(m3373(C3947.m12727().m12741()));
        this.f3354.f16923.setStringDataList(m3373(C3947.m12727().m12746()));
        m3378();
        m3388(C3947.m12727().m12764());
        boolean zM12765 = C3947.m12727().m12765();
        this.f3354.f16919.m2630(false, zM12765);
        this.f3354.f16918.setMax(1000.0f);
        this.f3354.f16918.setMin(0.0f);
        this.f3354.f16921.setMax(1000.0f);
        this.f3354.f16921.setMin(0.0f);
        if (r1.m8144(this.f3364) && r1.m8144(this.f3365)) {
            this.f3366 = this.f3364.get(0).floatValue();
            float fFloatValue = this.f3364.get(r1.size() - 1).floatValue();
            this.f3367 = fFloatValue;
            this.f3368 = this.f3366 - fFloatValue;
            this.f3369 = this.f3365.get(0).floatValue();
            float fFloatValue2 = this.f3365.get(r1.size() - 1).floatValue();
            this.f3370 = fFloatValue2;
            this.f3371 = this.f3369 - fFloatValue2;
            this.f3354.f16922.m2326(m3372(C3947.m12727().m12739()), false, getAngleStr());
            this.f3354.f16923.m2326(m3375(C3947.m12727().m12735()), false, getSpeedStr());
            this.f3354.f16918.setValueAndUpdateUI(m3371(C3947.m12727().m12739()));
            this.f3354.f16921.setValueAndUpdateUI(m3374(C3947.m12727().m12735()));
        }
        m3367(zM12765);
        this.f3354.f16926.setText(getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_ANGLE));
        this.f3354.f16928.setText(getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_SPEED));
        String upperCase = getResources().getString(R.string.RECORDING_SETTINGS_SHUTTER_AE).toUpperCase();
        this.f3354.f16927.m2561(upperCase);
        this.f3354.f16927.post(new RunnableC1204(upperCase));
        String upperCase2 = getResources().getString(R.string.RECORDING_INFO_SHUTTER).toUpperCase();
        this.f3354.f16929.setText(upperCase2);
        this.f3354.f16929.post(new RunnableC1205(upperCase2));
        m3368();
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m3386() {
        this.f3354.f16913.post(new RunnableC1206());
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m3387(int i) {
        this.f3374 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C1207(i));
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m3388(boolean z) {
        if (z) {
            this.f3354.f16926.m2575(true, 0);
            this.f3354.f16928.m2575(false, 0);
            this.f3354.f16922.setVisibility(0);
            this.f3354.f16923.setVisibility(8);
            this.f3354.f16915.setVisibility(0);
            this.f3354.f16917.setVisibility(8);
            this.f3354.f16921.setVisibility(8);
            this.f3354.f16918.setVisibility(0);
        } else {
            this.f3354.f16928.m2575(true, 0);
            this.f3354.f16926.m2575(false, 0);
            this.f3354.f16922.setVisibility(8);
            this.f3354.f16923.setVisibility(0);
            this.f3354.f16915.setVisibility(8);
            this.f3354.f16917.setVisibility(0);
            this.f3354.f16921.setVisibility(0);
            this.f3354.f16918.setVisibility(8);
        }
        ShutterView.InterfaceC1236 interfaceC1236 = this.f3375;
        if (interfaceC1236 != null) {
            interfaceC1236.mo3442();
        }
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m3389(int i) {
        float fFloatValue = this.f3364.get((this.f3364.size() - 1) - i).floatValue();
        C3947.m12727().m12788(fFloatValue);
        float fM12747 = fFloatValue / (C3947.m12727().m12747() * 360);
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fM12747 = fFloatValue / (C3947.m12727().m12760(iM12471) * 360.0f);
        }
        C3947.m12727().m12784(fM12747);
        this.f3354.f16918.setValueAndUpdateUI(m3371(C3947.m12727().m12739()));
        this.f3354.f16921.setValueAndUpdateUI(m3374(C3947.m12727().m12735()));
        this.f3354.f16923.m2326(m3375(C3947.m12727().m12735()), false, getSpeedStr());
        ShutterView.InterfaceC1236 interfaceC1236 = this.f3375;
        if (interfaceC1236 != null) {
            interfaceC1236.onChange();
        }
        C4535.m13880().m13915();
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m3390(int i) {
        float fFloatValue = this.f3365.get((this.f3365.size() - 1) - i).floatValue();
        C3947.m12727().m12784(fFloatValue);
        float f = fFloatValue * 360.0f;
        float fM12747 = C3947.m12727().m12747() * f;
        int iM12471 = C4535.m13880().m13890().m12471();
        if (iM12471 != 0) {
            fM12747 = C3947.m12727().m12760(iM12471) * f;
        }
        C3947.m12727().m12788(fM12747);
        this.f3354.f16918.setValueAndUpdateUI(m3371(C3947.m12727().m12739()));
        this.f3354.f16921.setValueAndUpdateUI(m3374(C3947.m12727().m12735()));
        this.f3354.f16922.m2326(m3372(C3947.m12727().m12739()), false, getAngleStr());
        ShutterView.InterfaceC1236 interfaceC1236 = this.f3375;
        if (interfaceC1236 != null) {
            interfaceC1236.onChange();
        }
        C4535.m13880().m13915();
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m3391() {
        this.f3354.f16928.post(new RunnableC1209());
    }

    public ShutterPortraitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShutterPortraitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3362 = -1;
        this.f3363 = -1;
        this.f3372 = 0.2f;
        m3377();
    }
}
