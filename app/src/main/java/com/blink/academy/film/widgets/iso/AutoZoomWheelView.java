package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.iso.WheelProgressZoomView;
import defpackage.AbstractC4012;
import defpackage.AbstractC4145;
import defpackage.C2579;
import defpackage.C3410;
import defpackage.C3485;
import defpackage.C3947;
import defpackage.C4008;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public class AutoZoomWheelView extends FrameLayout {

    /* renamed from: ރ, reason: contains not printable characters */
    public static final String f3250 = AutoZoomWheelView.class.getSimpleName();

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4145 f3251;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3252;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3253;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3254;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3255;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f3256;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3257;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC1160 f3258;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f3259;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f3260;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f3261;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f3262;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f3263;

    /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ϳ, reason: contains not printable characters */
    public class C1152 implements WheelProgressZoomView.InterfaceC1257 {
        public C1152() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressZoomView.InterfaceC1257
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3230(float f, boolean z) {
            float fM3212 = AutoZoomWheelView.this.m3212(f);
            if (C3947.f13602) {
                C4638.m14099(AutoZoomWheelView.f3250, "zoom pro:" + f + " value:" + fM3212 + " highP:" + z);
            }
            if (AutoZoomWheelView.this.f3258 != null) {
                AutoZoomWheelView.this.m3208(fM3212, z);
            }
            AutoZoomWheelView.this.m3228(f, z);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ԩ, reason: contains not printable characters */
    public class C1153 implements WheelProgressZoomView.InterfaceC1258 {

        /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC1154 implements Runnable {
            public RunnableC1154() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AutoZoomWheelView.this.m3227(true, 100);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ԩ$Ԩ, reason: contains not printable characters */
        public class RunnableC1155 implements Runnable {
            public RunnableC1155() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AutoZoomWheelView.this.m3227(true, 100);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ԩ$Ԫ, reason: contains not printable characters */
        public class RunnableC1156 implements Runnable {
            public RunnableC1156() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AutoZoomWheelView.this.m3227(false, 100);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ԩ$Ԭ, reason: contains not printable characters */
        public class RunnableC1157 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f3269;

            public RunnableC1157(int i) {
                this.f3269 = i;
            }

            /* JADX WARN: Removed duplicated region for block: B:40:0x015b A[PHI: r1
              0x015b: PHI (r1v19 float) = (r1v12 float), (r1v14 float), (r1v16 float), (r1v23 float) binds: [B:51:0x0182, B:48:0x0177, B:44:0x016a, B:39:0x0159] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x015e A[PHI: r1
              0x015e: PHI (r1v17 float) = (r1v12 float), (r1v14 float), (r1v16 float), (r1v23 float) binds: [B:51:0x0182, B:48:0x0177, B:44:0x016a, B:39:0x0159] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 673
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.AutoZoomWheelView.C1153.RunnableC1157.run():void");
            }
        }

        public C1153() {
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressZoomView.InterfaceC1258
        public void onAnimChange(boolean z) {
            if (AutoZoomWheelView.this.f3258 != null) {
                AutoZoomWheelView.this.f3258.onAnimChange(z);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressZoomView.InterfaceC1258
        public void onDown() {
            if (AutoZoomWheelView.this.f3258 != null) {
                AutoZoomWheelView.this.f3258.onTouchChange(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressZoomView.InterfaceC1258
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3231(boolean z) {
            if (AutoZoomWheelView.this.f3258 != null) {
                AutoZoomWheelView.this.f3258.onTouchChange(false);
            }
            if (z) {
                C4535.m13880().m13915();
            }
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressZoomView.InterfaceC1258
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo3232() {
            AutoZoomWheelView.this.post(new RunnableC1154());
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressZoomView.InterfaceC1258
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo3233(int i) {
            AutoZoomWheelView.this.post(new RunnableC1157(i));
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressZoomView.InterfaceC1258
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo3234() {
            AutoZoomWheelView.this.post(new RunnableC1155());
        }

        @Override // com.blink.academy.film.widgets.iso.WheelProgressZoomView.InterfaceC1258
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo3235() {
            AutoZoomWheelView.this.post(new RunnableC1156());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ԫ, reason: contains not printable characters */
    public class C1158 extends AbstractC4012 {
        public C1158() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            AutoZoomWheelView.this.f3259 = false;
            C4638.m14099("slim", "show end  touching:" + AutoZoomWheelView.this.f3251.f14373.m3515());
            if (AutoZoomWheelView.this.f3251.f14373.m3515()) {
                return;
            }
            AutoZoomWheelView.this.f3251.f14373.m3510();
            AutoZoomWheelView.this.f3251.f14373.m3516();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ԭ, reason: contains not printable characters */
    public class C1159 extends AbstractC4012 {
        public C1159() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C4638.m14099("slim", "hide end");
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.AutoZoomWheelView$Ԯ, reason: contains not printable characters */
    public interface InterfaceC1160 {
        void onAnimChange(boolean z);

        void onTouchChange(boolean z);

        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo3236(float f, float f2, float f3);

        /* renamed from: Ԩ, reason: contains not printable characters */
        boolean mo3237(float f, float f2);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo3238(boolean z, int i);
    }

    public AutoZoomWheelView(@NonNull Context context) {
        this(context, null);
    }

    private int getGroupCount() {
        int i = this.f3261;
        if (i == 1 || i == 2) {
            return 2;
        }
        if (i == 3 || i == 4) {
            return 3;
        }
        return i != 5 ? 1 : 4;
    }

    public float[] getFocalLengthAndZoomRatio() {
        float fM11187;
        float fM111872;
        float[] fArr = new float[2];
        float fM12732 = this.f3260 ? C3947.m12727().m12732() : C3947.m12727().m12733();
        if (this.f3261 != 0) {
            C3410.C3411 c3411 = C3410.InterfaceC3412.f11765;
            if (fM12732 < c3411.m11187()) {
                C3485 c3485M11183 = c3411.m11183();
                C3410.C3411 c34112 = C3410.InterfaceC3412.f11764;
                fM11184 = c3485M11183 == c34112.m11183() ? c34112.m11184() : 0.0f;
                float fM11186 = c34112.m11186();
                fM111872 = fM11186 + ((fM12732 - c34112.m11187()) * (c34112.m11185() - fM11186));
                fArr[0] = fM11184;
                fArr[1] = fM111872;
                return fArr;
            }
            C3410.C3411 c34113 = C3410.InterfaceC3412.f11767;
            if (!c34113.m11188() || fM12732 < c34113.m11187()) {
                C3410.C3411 c34114 = C3410.InterfaceC3412.f11766;
                if (!c34114.m11188() || fM12732 < c34114.m11187()) {
                    fM11184 = c3411.m11183() == C3410.InterfaceC3412.f11764.m11183() ? c3411.m11184() : 0.0f;
                    fM11187 = c3411.m11187();
                } else {
                    fM11184 = c3411.m11183() == c34114.m11183() ? c34114.m11184() : 0.0f;
                    fM11187 = c34114.m11187();
                }
            } else {
                fM11184 = C3410.InterfaceC3412.f11766.m11183() == c34113.m11183() ? c34113.m11184() : 0.0f;
                fM11187 = c34113.m11187();
            }
        } else {
            fM11187 = C3410.InterfaceC3412.f11765.m11187();
        }
        fM111872 = fM12732 / fM11187;
        fArr[0] = fM11184;
        fArr[1] = fM111872;
        return fArr;
    }

    public void setCardWidth(int i) {
        this.f3257 = i;
    }

    public void setNeedCheckMag(boolean z) {
        this.f3251.f14373.setNeedCheckMag(z);
    }

    public void setOnValueChange(InterfaceC1160 interfaceC1160) {
        this.f3258 = interfaceC1160;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3205() {
        this.f3251.f14373.cancelClickMove();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean m3206(float f, float f2) {
        View rl1x = this.f3251.f14372.getRl1x();
        View rl2x = this.f3251.f14372.getRl2x();
        View rlHalfX = this.f3251.f14372.getRlHalfX();
        View rlS2X = this.f3251.f14372.getRlS2X();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        int[] iArr4 = new int[2];
        rl1x.getLocationOnScreen(iArr);
        rl2x.getLocationOnScreen(iArr2);
        rlHalfX.getLocationOnScreen(iArr3);
        rlS2X.getLocationOnScreen(iArr4);
        if (m3207(iArr, this.f3253, f, f2)) {
            return !this.f3263 || rl1x.getAlpha() == 1.0f;
        }
        if (m3207(iArr2, this.f3253, f, f2)) {
            return !this.f3263 || rl2x.getAlpha() == 1.0f;
        }
        if (m3207(iArr3, this.f3253, f, f2)) {
            return !this.f3263 || rlHalfX.getAlpha() == 1.0f;
        }
        if (m3207(iArr4, this.f3253, f, f2)) {
            return !this.f3263 || rlS2X.getAlpha() == 1.0f;
        }
        return false;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean m3207(int[] iArr, int i, float f, float f2) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        return f >= ((float) i2) && f <= ((float) (i2 + i)) && f2 >= ((float) i3) && f2 <= ((float) (i3 + i));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m3208(float f, boolean z) {
        float fM11187;
        float fM111872;
        if (this.f3261 != 0) {
            C3410.C3411 c3411 = C3410.InterfaceC3412.f11765;
            if (f < c3411.m11187()) {
                C3485 c3485M11183 = c3411.m11183();
                C3410.C3411 c34112 = C3410.InterfaceC3412.f11764;
                fM11184 = c3485M11183 == c34112.m11183() ? c34112.m11184() : 0.0f;
                float fM11186 = c34112.m11186();
                float fM11185 = c34112.m11185() - fM11186;
                fM111872 = (((f - c34112.m11187()) / c34112.m11187()) * fM11185) + fM11186;
                C4638.m14099("slimmm", "zoomValue:" + f + " zoomV:" + fM111872 + " min:" + fM11186 + " range:" + fM11185);
                this.f3258.mo3236(fM11184, fM111872, f);
            }
            C3410.C3411 c34113 = C3410.InterfaceC3412.f11767;
            if (!c34113.m11188() || f < c34113.m11187()) {
                C3410.C3411 c34114 = C3410.InterfaceC3412.f11766;
                if (!c34114.m11188() || f < c34114.m11187()) {
                    fM11184 = c3411.m11183() == C3410.InterfaceC3412.f11764.m11183() ? c3411.m11184() : 0.0f;
                    fM11187 = c3411.m11187();
                } else {
                    fM11184 = c3411.m11183() == c34114.m11183() ? c34114.m11184() : 0.0f;
                    fM11187 = c34114.m11187();
                }
            } else {
                fM11184 = C3410.InterfaceC3412.f11766.m11183() == c34113.m11183() ? c34113.m11184() : 0.0f;
                fM11187 = c34113.m11187();
            }
        } else {
            fM11187 = C3410.InterfaceC3412.f11765.m11187();
        }
        fM111872 = f / fM11187;
        this.f3258.mo3236(fM11184, fM111872, f);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public float m3209(float f) {
        float fM11187;
        float fM111872;
        float fM111873;
        float fM111874;
        int i = this.f3252;
        if (i == 1) {
            fM111872 = C3410.InterfaceC3412.f11766.m11187();
        } else {
            if (i != 6) {
                if (i == 2) {
                    C3410.C3411 c3411 = C3410.InterfaceC3412.f11764;
                    fM111872 = c3411.m11188() ? c3411.m11187() : 0.5f;
                    fM11187 = (C3410.InterfaceC3412.f11765.m11187() * 2.0f) - 0.001f;
                } else if (i == 3) {
                    C3410.C3411 c34112 = C3410.InterfaceC3412.f11764;
                    fM111872 = c34112.m11188() ? c34112.m11187() : 0.5f;
                    fM111874 = C3410.InterfaceC3412.f11765.m11187();
                    fM11187 = fM111874 - 0.001f;
                } else {
                    float f2 = 4.0f;
                    if (i == 4) {
                        fM111872 = C3410.InterfaceC3412.f11765.m11187();
                        C3410.C3411 c34113 = C3410.InterfaceC3412.f11766;
                        if (c34113.m11188()) {
                            fM111873 = c34113.m11187();
                            f2 = fM111873 * 2.0f;
                        }
                        fM11187 = f2 - 0.001f;
                    } else if (i == 5) {
                        C3410.C3411 c34114 = C3410.InterfaceC3412.f11764;
                        fM111872 = c34114.m11188() ? c34114.m11187() : 0.5f;
                        C3410.C3411 c34115 = C3410.InterfaceC3412.f11766;
                        if (c34115.m11188()) {
                            fM111873 = c34115.m11187();
                            f2 = fM111873 * 2.0f;
                        }
                        fM11187 = f2 - 0.001f;
                    } else {
                        C3410.C3411 c34116 = C3410.InterfaceC3412.f11765;
                        fM11187 = (c34116.m11187() * 2.0f) - 0.001f;
                        fM111872 = c34116.m11187();
                    }
                }
                double dLog = Math.log(fM111872) / Math.log(2.0d);
                return (float) (((Math.log(f) / Math.log(2.0d)) - dLog) / ((Math.log(fM11187) / Math.log(2.0d)) - dLog));
            }
            fM111872 = C3410.InterfaceC3412.f11767.m11187();
        }
        fM111874 = 2.0f * fM111872;
        fM11187 = fM111874 - 0.001f;
        double dLog2 = Math.log(fM111872) / Math.log(2.0d);
        return (float) (((Math.log(f) / Math.log(2.0d)) - dLog2) / ((Math.log(fM11187) / Math.log(2.0d)) - dLog2));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final int m3210(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i = 0; i < length; i++) {
            iCeil += (int) Math.ceil(r2[i]);
        }
        return iCeil;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0220  */
    /* renamed from: ހ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap m3211(int r28, int r29) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.AutoZoomWheelView.m3211(int, int):android.graphics.Bitmap");
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public float m3212(float f) {
        float fM11187;
        float fM111872;
        float fM111873;
        float fM111874;
        int i = this.f3252;
        if (i == 1) {
            fM111872 = C3410.InterfaceC3412.f11766.m11187();
        } else {
            if (i != 6) {
                if (i == 2) {
                    C3410.C3411 c3411 = C3410.InterfaceC3412.f11764;
                    fM111872 = c3411.m11188() ? c3411.m11187() : 0.5f;
                    fM11187 = (C3410.InterfaceC3412.f11765.m11187() * 2.0f) - 0.001f;
                } else if (i == 3) {
                    C3410.C3411 c34112 = C3410.InterfaceC3412.f11764;
                    fM111872 = c34112.m11188() ? c34112.m11187() : 0.5f;
                    fM111874 = C3410.InterfaceC3412.f11765.m11187();
                    fM11187 = fM111874 - 0.001f;
                } else {
                    float f2 = 4.0f;
                    if (i == 4) {
                        fM111872 = C3410.InterfaceC3412.f11765.m11187();
                        C3410.C3411 c34113 = C3410.InterfaceC3412.f11766;
                        if (c34113.m11188()) {
                            fM111873 = c34113.m11187();
                            f2 = fM111873 * 2.0f;
                        }
                        fM11187 = f2 - 0.001f;
                    } else if (i == 5) {
                        C3410.C3411 c34114 = C3410.InterfaceC3412.f11764;
                        fM111872 = c34114.m11188() ? c34114.m11187() : 0.5f;
                        C3410.C3411 c34115 = C3410.InterfaceC3412.f11766;
                        if (c34115.m11188()) {
                            fM111873 = c34115.m11187();
                            f2 = fM111873 * 2.0f;
                        }
                        fM11187 = f2 - 0.001f;
                    } else {
                        C3410.C3411 c34116 = C3410.InterfaceC3412.f11765;
                        fM11187 = (c34116.m11187() * 2.0f) - 0.001f;
                        fM111872 = c34116.m11187();
                    }
                }
                double dLog = Math.log(fM111872) / Math.log(2.0d);
                return (float) Math.pow(2.0d, (((Math.log(fM11187) / Math.log(2.0d)) - dLog) * f) + dLog);
            }
            fM111872 = C3410.InterfaceC3412.f11767.m11187();
        }
        fM111874 = 2.0f * fM111872;
        fM11187 = fM111874 - 0.001f;
        double dLog2 = Math.log(fM111872) / Math.log(2.0d);
        return (float) Math.pow(2.0d, (((Math.log(fM11187) / Math.log(2.0d)) - dLog2) * f) + dLog2);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m3213(int i) {
        C4008.m12886(this, this.f3257, 0.0f, i, null);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m3214() {
        this.f3251 = AbstractC4145.m13127(LayoutInflater.from(getContext()), this, true);
        m3215();
        m3219();
        this.f3251.f14372.m3524(this.f3261, false);
        m3216();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m3215() {
        float fM14434 = C4792.m14375().m14434();
        float fM9440 = C2579.m9440(getContext());
        this.f3253 = (int) ((0.0855615f * fM9440 * fM14434) + 0.5f);
        this.f3255 = (int) ((fM9440 * 0.016934047f * fM14434) + 0.5f);
        this.f3254 = (int) ((C4792.m14375().m14476(15) * fM14434) + 0.5f);
        this.f3254 = this.f3255 / 2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3251.f14369.getLayoutParams();
        int iM14476 = (int) (((C4792.m14375().m14476(25) + (C4792.m14375().m14443() * 2.0f)) * fM14434 * 1.2f) + 0.5f);
        int iM144762 = (int) (((C4792.m14375().m14476(15) + (C4792.m14375().m14443() * 2.0f)) * fM14434 * 1.2f) + 0.5f);
        layoutParams.width = iM14476 + (iM14476 % 2);
        layoutParams.height = iM144762 + (iM144762 % 2);
        layoutParams.leftMargin = (int) (((C4792.m14375().m14476(169) + C4792.m14375().m14443()) * 1.2f * fM14434) + 0.5f);
        this.f3251.f14369.setLayoutParams(layoutParams);
        this.f3251.f14373.setRightView(true);
        this.f3251.f14373.setAutoZoomWheelView(this);
        m3227(false, 0);
        this.f3256 = 0.8333333f;
        C4008.m12884(this.f3251.f14372, 0.8333333f, 0.8333333f, 0, null);
        ZoomButtonBgView zoomButtonBgView = this.f3251.f14370;
        float f = this.f3256;
        C4008.m12884(zoomButtonBgView, f, f, 0, null);
        this.f3251.f14371.setVisibility(8);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m3216() {
        this.f3251.f14373.setOnProChange(new C1152());
        this.f3251.f14373.setOnTouchStateChange(new C1153());
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean m3217() {
        return this.f3251.f14373.m3513();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m3218() {
        float fM12732 = FilmApp.m405().m406() ? this.f3260 ? C3947.m12727().m12732() : C3947.m12727().m12733() : 1.0f;
        float fM3209 = m3209(fM12732);
        this.f3251.f14373.setPro(fM3209);
        C3410.C3411 c3411 = C3410.InterfaceC3412.f11766;
        m3228(fM3209, c3411.m11188() && fM12732 >= c3411.m11187());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r0 < defpackage.C3410.InterfaceC3412.f11765.m11187()) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r0 >= defpackage.C3410.InterfaceC3412.f11766.m11187()) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008b, code lost:
    
        if (r0 >= defpackage.C3410.InterfaceC3412.f11766.m11187()) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ae, code lost:
    
        if (r0 >= defpackage.C3410.InterfaceC3412.f11767.m11187()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c6, code lost:
    
        if (r0 >= defpackage.C3410.InterfaceC3412.f11766.m11187()) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* renamed from: ވ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3219() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.AutoZoomWheelView.m3219():void");
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m3220() {
        this.f3263 = false;
        this.f3251.f14372.m3525(true, this.f3262);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m3221() {
        int i;
        boolean z;
        this.f3262 = 0;
        if (this.f3261 == 0) {
            this.f3251.f14371.setVisibility(8);
            return;
        }
        int i2 = 2;
        if (!this.f3260) {
            C3410.C3411 c3411 = C3410.InterfaceC3412.f11764;
            if (c3411.m11188() && c3411.m11183() == C3410.InterfaceC3412.f11765.m11183()) {
                this.f3262 = 1;
                i = 2;
            } else {
                i = 1;
            }
            C3410.C3411 c34112 = C3410.InterfaceC3412.f11766;
            if (c34112.m11188() && c34112.m11183() == C3410.InterfaceC3412.f11765.m11183()) {
                int i3 = i + 1;
                if (this.f3262 == 1) {
                    this.f3262 = 3;
                } else {
                    this.f3262 = 2;
                }
                i2 = i3;
                z = true;
            } else {
                i2 = i;
                z = false;
            }
        } else if (C3410.InterfaceC3412.f11768.m11183() == C3410.InterfaceC3412.f11769.m11183()) {
            this.f3262 = 1;
            z = false;
        } else {
            z = false;
            i2 = 1;
        }
        if (i2 <= 1) {
            this.f3251.f14371.setVisibility(8);
        } else {
            this.f3251.f14371.setVisibility(0);
            m3225(i2, z, false);
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m3222(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3251.f14372.getLayoutParams();
        C4792.m14375().m14434();
        int i4 = this.f3253;
        layoutParams.width = i4;
        layoutParams.height = (i4 * 4) + (this.f3255 * 3);
        layoutParams.leftMargin = ((i - i4) - i2) - ((i3 - i4) / 2);
        this.f3251.f14372.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3251.f14370.getLayoutParams();
        layoutParams2.leftMargin = layoutParams.leftMargin - this.f3254;
        this.f3251.f14370.setLayoutParams(layoutParams2);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m3223() {
        this.f3263 = true;
        this.f3251.f14372.m3525(false, this.f3262);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /* renamed from: ލ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3224() {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.widgets.iso.AutoZoomWheelView.m3224():void");
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m3225(int i, boolean z, boolean z2) {
        int groupCount = getGroupCount();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3251.f14370.getLayoutParams();
        int i2 = 0;
        if (i < 2) {
            this.f3251.f14370.m3518(0, 0);
            layoutParams.width = 0;
            layoutParams.height = 0;
            this.f3251.f14370.setLayoutParams(layoutParams);
            return;
        }
        int i3 = this.f3253;
        int i4 = this.f3254;
        layoutParams.width = (i4 * 2) + i3;
        int i5 = this.f3255;
        layoutParams.height = (i3 * i) + ((i - 1) * i5) + (i4 * 2);
        int i6 = (i3 * groupCount) + ((groupCount - 1) * i5);
        if (!z2 && groupCount > 2 && groupCount % 2 == 0) {
            i2 = i5 / 2;
        }
        if (z2) {
            layoutParams.topMargin = (getLayoutParams().height - layoutParams.height) / 2;
        } else if (z) {
            layoutParams.topMargin = ((getLayoutParams().height - i6) / 2) + i2;
        } else {
            layoutParams.topMargin = ((getLayoutParams().height - i6) / 2) + ((i6 - layoutParams.height) - i2);
        }
        this.f3251.f14370.m3518(layoutParams.width, layoutParams.height);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m3226(int i) {
        m3218();
        C4008.m12886(this, 0.0f, 0.0f, i, null);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m3227(boolean z, int i) {
        if (!z) {
            this.f3259 = false;
            C4008.m12876(this.f3251.f14369, 0.0f, i, null);
            C4008.m12876(this.f3251.f14373, 0.0f, i, null);
            C4008.m12884(this.f3251.f14373, 0.0f, 0.0f, i, null);
            C4008.m12876(this.f3251.f14370, 1.0f, i, null);
            C4008.m12876(this.f3251.f14372, 1.0f, i, new C1159());
            return;
        }
        if (this.f3259) {
            return;
        }
        this.f3259 = true;
        C4008.m12876(this.f3251.f14369, 1.0f, i, null);
        C4008.m12876(this.f3251.f14373, 1.0f, i, null);
        C4008.m12884(this.f3251.f14373, 1.0f, 1.0f, i, null);
        C4008.m12876(this.f3251.f14370, 0.0f, i, null);
        C4008.m12876(this.f3251.f14372, 0.0f, i, new C1158());
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m3228(float f, boolean z) {
        float fM3212 = m3212(f);
        float fRound = f == 1.0f ? Math.round(10.0f * fM3212) / 10 : (float) (Math.floor(10.0f * fM3212) / 10.0d);
        String str = new DecimalFormat("#.#").format(fRound) + "×";
        if (this.f3261 == 0) {
            this.f3251.f14372.m3523(0, str);
            return;
        }
        if (fM3212 < 1.0f) {
            this.f3251.f14372.m3523(2, str);
            return;
        }
        C3410.C3411 c3411 = C3410.InterfaceC3412.f11767;
        if (c3411.m11188() && fM3212 >= c3411.m11187()) {
            this.f3251.f14372.m3523(3, str);
            return;
        }
        C3410.C3411 c34112 = C3410.InterfaceC3412.f11766;
        if (!c34112.m11188() || fM3212 < c34112.m11187()) {
            this.f3251.f14372.m3523(0, str);
        } else {
            this.f3251.f14372.m3523(1, str);
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public int m3229(MotionEvent motionEvent) {
        if (!this.f3258.mo3237(motionEvent.getRawX(), motionEvent.getRawY())) {
            return -1;
        }
        View rl1x = this.f3251.f14372.getRl1x();
        View rl2x = this.f3251.f14372.getRl2x();
        View rlHalfX = this.f3251.f14372.getRlHalfX();
        View rlS2X = this.f3251.f14372.getRlS2X();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        int[] iArr4 = new int[2];
        rl1x.getLocationOnScreen(iArr);
        rl2x.getLocationOnScreen(iArr2);
        rlHalfX.getLocationOnScreen(iArr3);
        rlS2X.getLocationOnScreen(iArr4);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (m3207(iArr, this.f3253, rawX, rawY)) {
            return (!this.f3263 || rl1x.getAlpha() == 1.0f) ? 0 : -1;
        }
        if (m3207(iArr2, this.f3253, rawX, rawY)) {
            return (!this.f3263 || rl2x.getAlpha() == 1.0f) ? 1 : -1;
        }
        if (m3207(iArr3, this.f3253, rawX, rawY)) {
            return (!this.f3263 || rlHalfX.getAlpha() == 1.0f) ? 2 : -1;
        }
        if (m3207(iArr4, this.f3253, rawX, rawY)) {
            return (!this.f3263 || rlS2X.getAlpha() == 1.0f) ? 3 : -1;
        }
        return -1;
    }

    public AutoZoomWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoZoomWheelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3252 = -1;
        this.f3259 = false;
        this.f3262 = 0;
        this.f3263 = false;
        m3214();
    }
}
