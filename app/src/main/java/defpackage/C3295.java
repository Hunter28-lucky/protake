package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.home.HomeActivity;
import com.blink.academy.film.home.fragment.FragmentCallback;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.PingHelper;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.widgets.AudioSettingView;
import com.blink.academy.film.widgets.FPSSettingView;
import com.blink.academy.film.widgets.FilmPointView;
import com.blink.academy.film.widgets.GridsSettingView;
import com.blink.academy.film.widgets.HorizonCircleRectView;
import com.blink.academy.film.widgets.LensSettingView;
import com.blink.academy.film.widgets.RecordButton;
import com.blink.academy.film.widgets.ResolutionSettingView;
import com.blink.academy.film.widgets.WbSettingView;
import com.blink.academy.film.widgets.ZebraSettingView;
import com.blink.academy.film.widgets.beauty.BeautySettingView;
import com.blink.academy.film.widgets.camerainfo.DoubleTextLayout;
import com.blink.academy.film.widgets.exposure.CameraTouchView;
import com.blink.academy.film.widgets.exposure.SlideBarView;
import com.blink.academy.film.widgets.iso.ABPointWheelView;
import com.blink.academy.film.widgets.iso.AutoZoomWheelView;
import com.blink.academy.film.widgets.iso.FocusZoomWheelView;
import com.blink.academy.film.widgets.iso.ISOView;
import com.blink.academy.film.widgets.iso.IsoEtWheelView;
import com.blink.academy.film.widgets.iso.ShutterView;
import com.blink.academy.film.widgets.looks.LooksPreviewView;
import com.blink.academy.protake.R;
import com.google.mlkit.common.MlKitException;
import com.umeng.analytics.pro.am;
import defpackage.AbstractC5160;
import defpackage.C2650;
import defpackage.C4202;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.json.JSONException;

/* compiled from: HomeLandscapeFragment.java */
/* renamed from: פ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3295 extends AbstractC5160 implements SensorEventListener {

    /* renamed from: ԯ, reason: contains not printable characters */
    public AbstractC2853 f11555;

    /* renamed from: ՠ, reason: contains not printable characters */
    public FragmentCallback f11556;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f11557;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f11558;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f11559;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f11560;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f11561;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f11562;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f11567;

    /* renamed from: އ, reason: contains not printable characters */
    public int f11568;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f11569;

    /* renamed from: މ, reason: contains not printable characters */
    public int f11570;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f11571;

    /* renamed from: ތ, reason: contains not printable characters */
    public long f11573;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f11574;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f11575;

    /* renamed from: ޏ, reason: contains not printable characters */
    public SensorManager f11576;

    /* renamed from: ސ, reason: contains not printable characters */
    public Sensor f11577;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f11578;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f11579;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f11580;

    /* renamed from: ޕ, reason: contains not printable characters */
    public float f11582;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f11583;

    /* renamed from: ޗ, reason: contains not printable characters */
    public int f11584;

    /* renamed from: ޘ, reason: contains not printable characters */
    public int f11585;

    /* renamed from: ޚ, reason: contains not printable characters */
    public long f11587;

    /* renamed from: ޛ, reason: contains not printable characters */
    public int f11588;

    /* renamed from: ޜ, reason: contains not printable characters */
    public int f11589;

    /* renamed from: ޝ, reason: contains not printable characters */
    public GestureDetector f11590;

    /* renamed from: ޞ, reason: contains not printable characters */
    public float f11591;

    /* renamed from: ޟ, reason: contains not printable characters */
    public float f11592;

    /* renamed from: ޠ, reason: contains not printable characters */
    public boolean f11593;

    /* renamed from: ޡ, reason: contains not printable characters */
    public ValueAnimator f11594;

    /* renamed from: ޢ, reason: contains not printable characters */
    public boolean f11595;

    /* renamed from: ޣ, reason: contains not printable characters */
    public int f11596;

    /* renamed from: ޤ, reason: contains not printable characters */
    public int f11597;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public int f11602;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public int f11603;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public int f11604;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public int f11605;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public int f11606;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public int f11607;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public int f11608;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public int f11609;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public boolean f11610;

    /* renamed from: ࡩ, reason: contains not printable characters */
    public boolean f11611;

    /* renamed from: ࡪ, reason: contains not printable characters */
    public boolean f11612;

    /* renamed from: ࢠ, reason: contains not printable characters */
    public boolean f11613;

    /* renamed from: ࢡ, reason: contains not printable characters */
    public boolean f11614;

    /* renamed from: ࢢ, reason: contains not printable characters */
    public RectF f11615;

    /* renamed from: ࢣ, reason: contains not printable characters */
    public int f11616;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f11563 = 35;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f11564 = 45;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f11565 = 360;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f11566 = JpegConst.RST2;

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean f11572 = false;

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean f11581 = false;

    /* renamed from: ޙ, reason: contains not printable characters */
    public int f11586 = 0;

    /* renamed from: ޥ, reason: contains not printable characters */
    public int f11598 = 124;

    /* renamed from: ޱ, reason: contains not printable characters */
    public int f11599 = 124;

    /* renamed from: ߾, reason: contains not printable characters */
    public int f11600 = 47;

    /* renamed from: ߿, reason: contains not printable characters */
    public int f11601 = 35;

    /* renamed from: ࢤ, reason: contains not printable characters */
    public final float[][] f11617 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 8, 3);

    /* renamed from: ࢥ, reason: contains not printable characters */
    public int f11618 = 0;

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$Ϳ, reason: contains not printable characters */
    public class C3296 implements ShutterView.InterfaceC1236 {
        public C3296() {
        }

        @Override // com.blink.academy.film.widgets.iso.ShutterView.InterfaceC1236
        public void onChange() {
            C3295.this.mo10618();
            C3295.this.m11108();
            C3295.this.f11556.mo1295();
        }

        @Override // com.blink.academy.film.widgets.iso.ShutterView.InterfaceC1236
        /* renamed from: Ϳ */
        public void mo3442() {
            C3295.this.m11108();
            C3295.this.mo10618();
        }

        @Override // com.blink.academy.film.widgets.iso.ShutterView.InterfaceC1236
        /* renamed from: ֏ */
        public void mo3443() {
            C3295.this.f11556.mo1192();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$Ԩ, reason: contains not printable characters */
    public class C3297 implements ISOView.InterfaceC1185 {
        public C3297() {
        }

        @Override // com.blink.academy.film.widgets.iso.ISOView.InterfaceC1185
        public void onChange() {
            C3295.this.mo10606();
            C3295.this.f11556.mo1295();
            C3295.this.mo10534();
        }

        @Override // com.blink.academy.film.widgets.iso.ISOView.InterfaceC1185
        /* renamed from: ֏ */
        public void mo3301() {
            C3295.this.f11556.mo1192();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$Ԫ, reason: contains not printable characters */
    public class C3298 implements ISOView.InterfaceC1186 {
        public C3298() {
        }

        @Override // com.blink.academy.film.widgets.iso.ISOView.InterfaceC1186
        /* renamed from: Ϳ */
        public void mo3302(boolean z) {
            if (C3947.m12727().m12729() == 1) {
                C3295.this.f11556.mo1257(z);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$Ԭ, reason: contains not printable characters */
    public class C3299 implements ISOView.InterfaceC1186 {
        public C3299() {
        }

        @Override // com.blink.academy.film.widgets.iso.ISOView.InterfaceC1186
        /* renamed from: Ϳ */
        public void mo3302(boolean z) {
            if (C3947.m12727().m12729() == 1) {
                C3295.this.f11556.mo1257(z);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$Ԯ, reason: contains not printable characters */
    public class C3300 implements IsoEtWheelView.InterfaceC1200 {
        public C3300() {
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        public void onTouchChange(boolean z) {
            if (z) {
                C3295.this.f11610 = true;
                C4008.m12884(C3295.this.f11555.f10406, 1.3f, 1.3f, 100, null);
                if (!C3947.m12727().m12765()) {
                    if (C3947.m12727().m12749()) {
                        C3295.this.mo10607(C4792.m14375().m14431());
                        C3295.this.mo10619(-1);
                    } else {
                        C3295.this.mo10607(-1);
                        C3295.this.mo10619(C4792.m14375().m14431());
                    }
                }
            } else {
                C3295.this.f11610 = false;
                C4008.m12884(C3295.this.f11555.f10406, 1.0f, 1.0f, 100, null);
                C3295.this.mo10607(-1);
                C3295.this.mo10619(-1);
            }
            if (C3947.m12727().m12729() == 1) {
                C3295.this.f11556.mo1257(z);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: Ϳ */
        public void mo3336() {
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: Ԩ */
        public void mo3337() {
            C3295.this.f11556.mo1230();
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: ԩ */
        public void mo3338(float f) {
            C3295.this.f11556.mo1266(f);
            C3295.this.mo10618();
            if (C3295.this.f11555.f10432.m3433()) {
                C3295.this.f11555.f10432.setPro(f);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: Ԫ */
        public void mo3339() {
            C3295.this.f11556.mo1271();
            C3295.this.mo10606();
            if (C3295.this.f11555.f10407.m3295()) {
                C3295.this.f11555.f10407.m3298();
            }
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: ԭ */
        public void mo3340() {
            C3295.this.f11556.mo1187();
            if (C3295.this.f11555.f10432.m3433()) {
                C3295.this.f11555.f10432.m3436();
            }
            if (C3295.this.f11555.f10407.m3295()) {
                C3295.this.f11555.f10407.m3299();
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ՠ, reason: contains not printable characters */
    public class C3301 implements FocusZoomWheelView.InterfaceC1176 {
        public C3301() {
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onAnimChange(boolean z) {
            C3295.this.f11612 = z;
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onFocusChange(float f) {
            C3295.this.f11555.f10337.setDegree(C3295.this.f11555.f10366.m3261(false));
            C3947.m12727().m12785(f);
            C3295.this.f11556.mo1279(f);
            C3295.this.mo10553(f);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onHideAB() {
            C3295.this.f11555.f10337.setVisibility(8);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onModeChange(boolean z) {
            if (z) {
                C3295.this.f11555.f10357.setVisibility(0);
                C3295.this.f11555.f10356.setVisibility(8);
            } else {
                C3295.this.f11555.f10357.setVisibility(8);
                C3295.this.f11555.f10356.setVisibility(0);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onTouchChange(boolean z) {
            C3295.this.f11556.mo1273(z);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onTouchChange2(boolean z) {
            if (!z) {
                C3295.this.f11611 = false;
                C4008.m12884(C3295.this.f11555.f10366, 1.0f, 1.0f, 100, null);
                C4008.m12884(C3295.this.f11555.f10338, 1.0f, 1.0f, 100, null);
                C4008.m12884(C3295.this.f11555.f10337, 1.0f, 1.0f, 100, null);
                C3295.this.f11556.getHandler().sendEmptyMessageDelayed(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 1000L);
                return;
            }
            C3295.this.f11556.getHandler().removeMessages(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR);
            ACHelper.getInstance().setFocusZoomWheelTouching(z);
            C3295.this.f11611 = true;
            C4008.m12884(C3295.this.f11555.f10366, 1.3f, 1.3f, 100, null);
            C4008.m12884(C3295.this.f11555.f10338, 1.3f, 1.3f, 100, null);
            C4008.m12884(C3295.this.f11555.f10337, 1.3f, 1.3f, 100, null);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onZoomChange(float f) {
            C3295.this.f11555.f10338.setDegree(C3295.this.f11555.f10366.m3261(true));
            C3947.m12727().m12789(f);
            float fM12754 = C3947.m12727().m12754(f);
            if (C3295.this.f17095) {
                C4638.m14099("slimmm", "pro:" + f + "  proZoomValueByPro:" + fM12754 + " ProZoomProByValue:" + C3947.m12727().m12753(fM12754));
            }
            C3295.this.f11556.mo1278(fM12754);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onZoomEnableChange(boolean z) {
            C3295.this.f11555.f10338.setEnabled(z);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ֈ, reason: contains not printable characters */
    public class C3302 implements ABPointWheelView.InterfaceC1151 {
        public C3302() {
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        public void onFocusChange(float f) {
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        public void onZoomChange(float f) {
            C3295.this.f11556.mo1278(f);
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        /* renamed from: Ϳ */
        public boolean mo3195() {
            return C3295.this.f11556.mo1267() == 1;
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        /* renamed from: Ԩ */
        public void mo3196(int i) {
            if (i == 1) {
                C3295.this.f11555.f10338.setStartDegree(C3295.this.f11555.f10366.m3261(true));
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$֏, reason: contains not printable characters */
    public class C3303 implements ABPointWheelView.InterfaceC1151 {
        public C3303() {
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        public void onFocusChange(float f) {
            C3295.this.f11556.mo1253(f);
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        public void onZoomChange(float f) {
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        /* renamed from: Ϳ */
        public boolean mo3195() {
            return C3295.this.f11556.mo1267() == 1;
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        /* renamed from: Ԩ */
        public void mo3196(int i) {
            if (i == 1) {
                C3295.this.f11555.f10337.setStartDegree(C3295.this.f11555.f10366.m3261(false));
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC3304 implements View.OnClickListener {
        public ViewOnClickListenerC3304() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC3305 implements View.OnClickListener {
        public ViewOnClickListenerC3305() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC3306 implements View.OnClickListener {
        public ViewOnClickListenerC3306() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.f11555.f10425.m2521()) {
                C3295.this.m11153();
                return;
            }
            if (C3295.this.f11555.f10369.m2265()) {
                C3295.this.m11157();
                return;
            }
            if (C3295.this.f11555.f10444.m2722()) {
                C3295.this.m11160();
                return;
            }
            if (C3295.this.f11555.f10412.m2452()) {
                C3295.this.m11152();
                return;
            }
            if (C3295.this.f11555.f10432.m3433()) {
                C3295.this.m11161();
                return;
            }
            if (C3295.this.f11555.f10407.m3295()) {
                C3295.this.m11127();
                return;
            }
            if (C3295.this.m11142()) {
                C3295.this.m11121();
                return;
            }
            if (C3295.this.f11555.f10446.m2748()) {
                C3295.this.m11130();
                return;
            }
            if (C3295.this.f11555.f10340.m2170()) {
                C3295.this.m11116();
                return;
            }
            if (C3295.this.f11555.f10414.m3770()) {
                if (C3295.this.f11555.f10414.m3768()) {
                    C3295.this.f11555.f10414.m3781();
                    return;
                } else {
                    C3295.this.m11149();
                    return;
                }
            }
            if (!C3295.this.f11555.f10344.m2813()) {
                C3295.this.m11118(8);
            } else {
                if (!C3295.this.f11555.f10344.m2812()) {
                    C3295.this.m11119();
                    return;
                }
                C3295.this.f11555.f10344.m2815();
                C3295.this.f11556.mo1301(C3295.this.f11555.f10344.getCurrentBeautyType(), C3295.this.f11555.f10344.getCurrentBeautyLevel());
                C3295.this.f11555.f10344.m2826(100);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ށ, reason: contains not printable characters */
    public class ViewOnTouchListenerC3307 implements View.OnTouchListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ށ$Ϳ, reason: contains not printable characters */
        public class RunnableC3308 implements Runnable {
            public RunnableC3308() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C3295.this.f11555.f10342.setAlpha(C3295.this.f11556.mo1292() ? 1.0f : 0.2f);
            }
        }

        public ViewOnTouchListenerC3307() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                C3295.this.f11555.f10342.setAlpha(C3295.this.f11556.mo1292() ? 0.3f : 0.2f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC3308(), 100L);
            return false;
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ނ, reason: contains not printable characters */
    public class ViewOnClickListenerC3309 implements View.OnClickListener {
        public ViewOnClickListenerC3309() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3295.this.f11556.mo1210();
            if (C3295.this.f11556.mo1222() == 1) {
                C3295.this.f11555.f10433.setVisibility(8);
                C3295.this.f11555.f10434.setVisibility(0);
            } else {
                C3295.this.f11555.f10434.setVisibility(8);
                C3295.this.f11555.f10433.setVisibility(0);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ރ, reason: contains not printable characters */
    public class ViewOnClickListenerC3310 implements View.OnClickListener {
        public ViewOnClickListenerC3310() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e5.m5988().m5993()) {
                C3295.this.f11555.f10421.performClick();
            } else if (C3295.this.f11556.mo1270()) {
                C3295.this.f11556.mo1259();
            } else {
                C3295.this.f11555.f10421.performClick();
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ބ, reason: contains not printable characters */
    public class ViewOnClickListenerC3311 implements View.OnClickListener {
        public ViewOnClickListenerC3311() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3295.this.f11556.mo1245();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޅ, reason: contains not printable characters */
    public class ViewOnClickListenerC3312 implements View.OnClickListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޅ$Ϳ, reason: contains not printable characters */
        public class C3313 extends AbstractC4012 {
            public C3313() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public ViewOnClickListenerC3312() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.f11556 == null || C3295.this.f11556.mo1269()) {
                if (C3295.this.f11555.f10340.m2170()) {
                    C3295.this.f11555.f10340.m2166(100, new C3313());
                } else {
                    C3295.this.mo10520(8);
                }
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ކ, reason: contains not printable characters */
    public class ViewOnClickListenerC3314 implements View.OnClickListener {
        public ViewOnClickListenerC3314() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3295.this.f11556.mo1236();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$އ, reason: contains not printable characters */
    public class ViewOnClickListenerC3315 implements View.OnClickListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$އ$Ϳ, reason: contains not printable characters */
        public class C3316 extends AbstractC4012 {
            public C3316() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public ViewOnClickListenerC3315() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.m11142()) {
                C3295.this.m11147(100, new C3316());
            } else {
                C3295.this.mo10520(9);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ވ, reason: contains not printable characters */
    public class ViewOnClickListenerC3317 implements View.OnClickListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ވ$Ϳ, reason: contains not printable characters */
        public class C3318 extends AbstractC4012 {
            public C3318() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public ViewOnClickListenerC3317() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.f11555.f10446.m2748()) {
                C3295.this.f11555.f10446.m2746(100, new C3318());
            } else {
                C3295.this.mo10520(10);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$މ, reason: contains not printable characters */
    public class C3319 implements RecordButton.InterfaceC0941 {
        public C3319() {
        }

        @Override // com.blink.academy.film.widgets.RecordButton.InterfaceC0941
        /* renamed from: Ϳ */
        public boolean mo2506() {
            return C3295.this.f11556.mo1228();
        }

        @Override // com.blink.academy.film.widgets.RecordButton.InterfaceC0941
        /* renamed from: Ԩ */
        public void mo2507(int i) {
            C3295.this.f11556.mo1298(i);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ފ, reason: contains not printable characters */
    public class C3320 implements C2650.InterfaceC2658 {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ފ$Ϳ, reason: contains not printable characters */
        public class RunnableC3321 implements Runnable {
            public RunnableC3321() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C3295.this.f11555.f10440.getVisibility() == 0 && C3295.this.f11555.f10440.isAvailable() && C2650.m9784()) {
                    int width = C3295.this.f11555.f10440.getWidth();
                    int height = C3295.this.f11555.f10440.getHeight();
                    if (C3295.this.f17095) {
                        C4638.m14099("HomeLandscapeFragment", String.format("width : %s , height : %s ", Integer.valueOf(width), Integer.valueOf(height)));
                    }
                    C2650.m9794(C3295.this.f11555.f10440.getSurfaceTexture(), width, height);
                }
            }
        }

        public C3320() {
        }

        @Override // defpackage.C2650.InterfaceC2658
        /* renamed from: Ϳ */
        public void mo9800() {
            if (C3295.this.f17095) {
                C4638.m14099("HomeLandscapeFragment", String.format("FilmLittlePreview : %s ", "onUpdateSharedContextFinished"));
            }
            if (C3295.this.getActivity() == null) {
                return;
            }
            C3295.this.getActivity().runOnUiThread(new RunnableC3321());
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ދ, reason: contains not printable characters */
    public class ViewOnClickListenerC3322 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f11645 = false;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f11646;

        public ViewOnClickListenerC3322() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11645) {
                return;
            }
            this.f11645 = true;
            int iM9788 = C2650.m9788(C3295.this.f11556.mo1262());
            C3295.this.f11556.mo1304(iM9788);
            C2650.m9777(iM9788);
            this.f11645 = false;
            C3295.this.mo10581();
            this.f11646 = true ^ this.f11646;
            C4535.m13880().m13890().m12367(iM9788);
            C4535.m13880().m13915();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ތ, reason: contains not printable characters */
    public class ViewOnClickListenerC3323 implements View.OnClickListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ތ$Ϳ, reason: contains not printable characters */
        public class C3324 extends AbstractC4012 {
            public C3324() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public ViewOnClickListenerC3323() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (C3295.this.f11573 == 0 || jCurrentTimeMillis - C3295.this.f11573 >= C4062.f14091) {
                C3295.this.f11573 = jCurrentTimeMillis;
                if (!C3295.this.f11556.mo1292()) {
                    C3295.this.f11556.mo1285(26);
                } else if (C3295.this.f11555.f10344.m2813()) {
                    C3295.this.f11555.f10344.m2807(100, new C3324());
                } else {
                    C3295.this.mo10520(11);
                }
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ލ, reason: contains not printable characters */
    public class TextureViewSurfaceTextureListenerC3325 implements TextureView.SurfaceTextureListener {
        public TextureViewSurfaceTextureListenerC3325() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            C3295.this.f11584 = i;
            C3295.this.f11585 = i2;
            C2650.m9795(C3295.this.f11584, C3295.this.f11585);
            if (C2650.m9784()) {
                if (C3295.this.f17095) {
                    C4638.m14099("HomeLandscapeFragment", String.format("width : %s , height : %s ", Integer.valueOf(i), Integer.valueOf(i2)));
                }
                C2650.m9794(C3295.this.f11555.f10440.getSurfaceTexture(), i, i2);
            }
            if (C3295.this.f17095) {
                C4638.m14099("HomeLandscapeFragment", String.format("onSurfaceTextureAvailable : %s , width : %s , height : %s ", Long.valueOf(surfaceTexture.getTimestamp()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (C3295.this.f17095) {
                C4638.m14099("HomeLandscapeFragment", String.format("onSurfaceTextureDestroyed : %s  ", Long.valueOf(surfaceTexture.getTimestamp())));
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (C3295.this.f17095) {
                C4638.m14099("HomeLandscapeFragment", String.format("onSurfaceTextureSizeChanged : %s , width : %s , height : %s ", Long.valueOf(surfaceTexture.getTimestamp()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ގ, reason: contains not printable characters */
    public class C3326 implements ACHelper.OnDeviceInit {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ގ$Ϳ, reason: contains not printable characters */
        public class RunnableC3327 implements Runnable {
            public RunnableC3327() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C2813.f10275) {
                    C3295.this.f11555.f10386.setAlpha(1.0f);
                } else {
                    C3295.this.f11555.f10386.setAlpha(0.3f);
                }
            }
        }

        public C3326() {
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnDeviceInit
        public void onInit() {
            FilmApp.m405().m427(new RunnableC3327());
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޏ, reason: contains not printable characters */
    public class ViewOnTouchListenerC3328 implements View.OnTouchListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޏ$Ϳ, reason: contains not printable characters */
        public class RunnableC3329 implements Runnable {
            public RunnableC3329() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C3295.this.f11555.f10386.setAlpha(1.0f);
                C3295.this.f11555.f10402.setAlpha(1.0f);
                C3295.this.f11555.f10399.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC3328() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!C2813.f10275) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                C3295.this.f11555.f10386.setAlpha(0.3f);
                C3295.this.f11555.f10402.setAlpha(0.3f);
                C3295.this.f11555.f10399.setAlpha(0.3f);
            } else if (action == 1 || action == 3) {
                new Handler(Looper.myLooper()).postDelayed(new RunnableC3329(), 100L);
            }
            return false;
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ސ, reason: contains not printable characters */
    public class ViewOnClickListenerC3330 implements View.OnClickListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ސ$Ϳ, reason: contains not printable characters */
        public class C3331 extends AbstractC4012 {
            public C3331() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.f11556.mo1246(true, true);
            }
        }

        public ViewOnClickListenerC3330() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.m11111()) {
                return;
            }
            if (!C2813.f10275) {
                C3295.this.f11556.mo1272(C3295.this.getResources().getString(R.string.MONITOR_ERROR_H265_GENERAL));
                return;
            }
            C2618.m9571("transmit_is_first_int", 2);
            C3295.this.m11102(false);
            C4008.m12876(C3295.this.f11555.f10370, 1.0f, 100, new C3331());
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޑ, reason: contains not printable characters */
    public class ViewOnClickListenerC3332 implements View.OnClickListener {
        public ViewOnClickListenerC3332() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3295.this.f11556.mo1243();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޒ, reason: contains not printable characters */
    public class ViewOnClickListenerC3333 implements View.OnClickListener {
        public ViewOnClickListenerC3333() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3295.this.f11556.mo1299();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޓ, reason: contains not printable characters */
    public class ViewOnClickListenerC3334 implements View.OnClickListener {
        public ViewOnClickListenerC3334() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3295.this.f11556.mo1240();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޔ, reason: contains not printable characters */
    public class ViewOnTouchListenerC3335 implements View.OnTouchListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޔ$Ϳ, reason: contains not printable characters */
        public class RunnableC3336 implements Runnable {
            public RunnableC3336() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C3295.this.f11555.f10362.setAlpha(!(C3295.this.f11556.getRecordMode() == 1) ? 1.0f : 0.3f);
                C3295.this.f11555.f10400.setAlpha(1.0f);
                C3295.this.f11555.f10401.setAlpha(0.0f);
                C3295.this.f11555.f10413.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC3335() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                C3295.this.f11555.f10362.setAlpha(0.3f);
                C3295.this.f11555.f10400.setAlpha(0.3f);
                C3295.this.f11555.f10401.setAlpha(0.3f);
                C3295.this.f11555.f10413.setAlpha(0.3f);
            } else if (action == 1 || action == 3) {
                new Handler().postDelayed(new RunnableC3336(), 100L);
                C3295 c3295 = C3295.this;
                if (c3295.f17097) {
                    c3295.f17097 = false;
                    c3295.f11556.mo1280();
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޕ, reason: contains not printable characters */
    public class ViewOnClickListenerC3337 implements View.OnClickListener {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޕ$Ϳ, reason: contains not printable characters */
        public class C3338 extends AbstractC4012 {
            public C3338() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public ViewOnClickListenerC3337() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (C3295.this.f11573 == 0 || jCurrentTimeMillis - C3295.this.f11573 >= C4062.f14091) {
                C3295.this.f11573 = jCurrentTimeMillis;
                C3295.this.f17097 = false;
                if (C4535.m13880().m13890().m12460() == 1) {
                    C3295.this.f11556.mo1285(25);
                } else if (C3295.this.f11555.f10414.m3770()) {
                    C3295.this.f11555.f10414.m3764(100, new C3338());
                } else {
                    C3295.this.mo10520(7);
                }
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޖ, reason: contains not printable characters */
    public class ViewOnLongClickListenerC3339 implements View.OnLongClickListener {
        public ViewOnLongClickListenerC3339() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (C4535.m13880().m13890().m12442() == 0) {
                return false;
            }
            C3295 c3295 = C3295.this;
            c3295.f17097 = true;
            c3295.f11556.mo1241();
            return true;
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޗ, reason: contains not printable characters */
    public class ViewOnClickListenerC3340 implements View.OnClickListener {
        public ViewOnClickListenerC3340() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3295.this.f11556.mo1231();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޘ, reason: contains not printable characters */
    public class ViewOnClickListenerC3341 implements View.OnClickListener {
        public ViewOnClickListenerC3341() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3295.this.f11555.f10418.setEnabled(false);
            C3295.this.f11556.mo1263();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޙ, reason: contains not printable characters */
    public class C3342 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޙ$Ϳ, reason: contains not printable characters */
        public class C3343 extends AbstractC4012 {
            public C3343() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public C3342() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C3295.this.f11556.mo1248() != 1) {
                return;
            }
            if (C3295.this.f11555.f10425.m2521()) {
                C3295.this.f11555.f10425.m2519(100, new C3343());
            } else {
                C3295.this.mo10520(1);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޚ, reason: contains not printable characters */
    public class C3344 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޚ$Ϳ, reason: contains not printable characters */
        public class C3345 extends AbstractC4012 {
            public C3345() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public C3344() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C3295.this.f11556.mo1248() != 1) {
                return;
            }
            if (C3295.this.f11555.f10369.m2265()) {
                C3295.this.f11555.f10369.m2263(100, new C3345());
            } else {
                C3295.this.mo10520(2);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޛ, reason: contains not printable characters */
    public class C3346 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޛ$Ϳ, reason: contains not printable characters */
        public class C3347 extends AbstractC4012 {
            public C3347() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public C3346() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C3295.this.f11556.mo1248() == 1) {
                if (C3295.this.f11555.f10432.m3433()) {
                    C3295.this.f11555.f10432.m3427(100, new C3347());
                } else {
                    C3295.this.mo10520(3);
                }
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޜ, reason: contains not printable characters */
    public class C3348 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޜ$Ϳ, reason: contains not printable characters */
        public class C3349 extends AbstractC4012 {
            public C3349() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public C3348() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C3295.this.f11556.mo1248() == 1) {
                if (C3295.this.f11555.f10407.m3295()) {
                    C3295.this.f11555.f10407.m3291(100, new C3349());
                } else {
                    C3295.this.mo10520(4);
                }
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޝ, reason: contains not printable characters */
    public class C3350 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޝ$Ϳ, reason: contains not printable characters */
        public class C3351 extends AbstractC4012 {
            public C3351() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public C3350() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C3295.this.f11556.mo1248() != 1) {
                return;
            }
            if (C3295.this.f11555.f10444.m2722()) {
                C3295.this.f11555.f10444.m2719(100, new C3351());
            } else {
                C3295.this.mo10520(5);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޞ, reason: contains not printable characters */
    public class C3352 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޞ$Ϳ, reason: contains not printable characters */
        public class C3353 extends AbstractC4012 {
            public C3353() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C3295.this.mo10630();
                C3295.this.m11118(8);
            }
        }

        public C3352() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C3295.this.f11556.mo1248() == 1 && C3295.this.f11556.mo1270()) {
                if (C3295.this.f11555.f10412.m2452()) {
                    C3295.this.f11555.f10412.m2450(100, new C3353());
                } else {
                    C3295.this.mo10520(6);
                }
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޟ, reason: contains not printable characters */
    public class C3354 implements AutoZoomWheelView.InterfaceC1160 {
        public C3354() {
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        public void onAnimChange(boolean z) {
            C3295.this.f11614 = z;
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        public void onTouchChange(boolean z) {
            C3295.this.f11613 = z;
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        /* renamed from: Ϳ */
        public void mo3236(float f, float f2, float f3) {
            C3295.this.f11556.mo1254(f, f2, f3);
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        /* renamed from: Ԩ */
        public boolean mo3237(float f, float f2) {
            return (C3295.this.f11556 == null || !C3295.this.f11555.f10341.m3206(f, f2) || C3295.this.f11556.mo1234()) && C3295.this.f11556.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        /* renamed from: ԩ */
        public void mo3238(boolean z, int i) {
            C3295.this.f11556.mo1303(z, i);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC3355 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public float f11680;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public float f11681;

        /* renamed from: ԭ, reason: contains not printable characters */
        public float f11682;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public float f11683;

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޠ$Ϳ, reason: contains not printable characters */
        public class C3356 implements C4202.InterfaceC4205 {
            public C3356() {
            }

            @Override // defpackage.C4202.InterfaceC4205
            public void end() {
                C3295.this.f11555.f10355.setDrawIcon(true);
                C3295.this.f11556.mo1289(true);
                C3295.this.f11556.getHandler().sendEmptyMessageDelayed(109, 1500L);
            }

            @Override // defpackage.C4202.InterfaceC4205
            /* renamed from: Ϳ */
            public void mo10644(float f) {
                C3295.this.f11555.f10355.setViewScale(Float.valueOf(f));
            }
        }

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ޠ$Ԩ, reason: contains not printable characters */
        public class C3357 implements C4202.InterfaceC4205 {
            public C3357() {
            }

            @Override // defpackage.C4202.InterfaceC4205
            public void end() {
                C3295.this.f11555.f10355.setDrawIcon(true);
                C3295.this.f11556.mo1289(true);
                C3295.this.f11556.getHandler().sendEmptyMessageDelayed(109, 1500L);
            }

            @Override // defpackage.C4202.InterfaceC4205
            /* renamed from: Ϳ */
            public void mo10644(float f) {
                C3295.this.f11555.f10355.setViewScale(Float.valueOf(f));
            }
        }

        public ViewOnTouchListenerC3355() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    C3295 c3295 = C3295.this;
                    c3295.f17098 = false;
                    if (c3295.f11555.f10355.getVisibility() == 0) {
                        if (C3295.this.f11556.mo1223()) {
                            C3295.this.f11556.mo1224(false);
                            if (C3295.this.f11594 != null) {
                                C3295.this.f11594.end();
                            }
                            C3295.this.f11556.getHandler().removeMessages(107);
                            C3295.this.f11556.getHandler().removeMessages(105);
                            C3295.this.f11556.getHandler().removeMessages(108);
                            C3295.this.f11556.getHandler().removeMessages(109);
                            if (C3295.this.f11555.f10354.getVisibility() == 0) {
                                C3295.this.f11555.f10355.setAlpha(1.0f);
                                C3295.this.f11556.mo1289(false);
                                C4202.m13274().m13279(C4202.m13274().m13280(), C4202.m13274().m13282(), 100, new C3356());
                            } else {
                                C3295.this.f11555.f10355.setAlpha(1.0f);
                                C3295.this.f11556.mo1289(false);
                                C4202.m13274().m13279(C4202.m13274().m13280(), C4202.m13274().m13282(), 100, new C3357());
                            }
                        } else if (C3295.this.f11593) {
                            C3295.this.f11556.getHandler().sendEmptyMessageDelayed(109, 1500L);
                        }
                    }
                    if (!C3295.this.f11555.f10355.isShown() && !C3295.this.f11556.mo1227() && C3295.this.m11129()) {
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        if (C3295.this.m11167(this.f11683, this.f11682)) {
                            float fAbs = Math.abs(rawX - this.f11683);
                            float fAbs2 = Math.abs(rawY - this.f11682);
                            if (Math.max(fAbs, fAbs2) >= 20.0f) {
                                if (fAbs <= fAbs2) {
                                    C3295.this.f11556.mo1255();
                                } else if (C4151.m13162().m13176() != 2 && C4151.m13162().m13176() != 3) {
                                    C3295.this.f11556.mo1239(this.f11683 > rawX);
                                }
                            }
                        }
                    }
                } else if (action == 2) {
                    if (C3295.this.f11555.f10355.isShown() && !C3295.this.f11556.mo1223() && C3295.this.f11556.mo1294()) {
                        C3295.this.f11556.mo1249(false);
                        C3295.this.f11593 = true;
                        C3295.this.f11555.f10355.setViewAlpha(1.0f);
                        C3295.this.f11555.f10355.m3149();
                        C3295.this.m11133(motionEvent);
                        C3295.this.f11595 = true;
                    } else if (!C3295.this.f11555.f10355.isShown() && C3295.this.f11556.mo1227() && C3295.this.m11129()) {
                        C3295.this.f11556.mo1282(this.f11681 + (motionEvent.getX() - C3295.this.f11592), this.f11680 + (motionEvent.getY() - C3295.this.f11591));
                    }
                }
            } else {
                this.f11683 = motionEvent.getRawX();
                this.f11682 = motionEvent.getRawY();
                C3295.this.f11591 = motionEvent.getY();
                C3295.this.f11592 = motionEvent.getX();
                this.f11681 = C3295.this.f11556.mo1213();
                this.f11680 = C3295.this.f11556.mo1226();
                C3295 c32952 = C3295.this;
                c32952.f17098 = true;
                c32952.f11556.getHandler().removeMessages(107);
                C3295.this.f11556.getHandler().removeMessages(105);
                C3295.this.f11556.getHandler().removeMessages(108);
                C3295.this.f11556.getHandler().removeMessages(109);
            }
            if (!C3295.this.f11556.mo1270() && !C3295.this.f11556.mo1227()) {
                C3295.this.f11590.onTouchEvent(motionEvent);
            }
            return true;
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޡ, reason: contains not printable characters */
    public class C3358 implements BeautySettingView.InterfaceC1008 {
        public C3358() {
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: Ϳ */
        public void mo2830(int i) {
            C3295.this.f11556.mo1264(i);
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: Ԩ */
        public void mo2831(int i, float f) {
            C3295.this.f11556.mo1301(i, f);
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: ބ */
        public void mo2832(int i) {
            C3295.this.f11556.mo1199(i);
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: ކ */
        public void mo2833(int i, float f) {
            C3295.this.f11556.mo1201(i, f);
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: ދ */
        public void mo2834(boolean z) {
            C3295.this.f11556.mo1206(z);
            C3295 c3295 = C3295.this;
            c3295.m11148(z && c3295.f11556.mo1293());
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޢ, reason: contains not printable characters */
    public class C3359 implements SlideBarView.InterfaceC1144 {
        public C3359() {
        }

        @Override // com.blink.academy.film.widgets.exposure.SlideBarView.InterfaceC1144
        /* renamed from: Ϳ */
        public void mo3171(float f) {
            C3295.this.f11556.mo1238(f);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޣ, reason: contains not printable characters */
    public class GestureDetectorOnGestureListenerC3360 implements GestureDetector.OnGestureListener {
        public GestureDetectorOnGestureListenerC3360() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            C3295.this.f11595 = false;
            if (!C3295.this.f11555.f10355.isShown()) {
                return false;
            }
            C3295.this.f11555.f10355.m3150();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return (motionEvent == null || motionEvent2 == null) ? false : true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if ((C3295.this.f11556.mo1268() || C3295.this.f11556.mo1284()) && C3295.this.f11556.mo1248() == 1) {
                C3295.this.f11556.mo1224(true);
                C3295.this.f11556.mo1290(motionEvent.getX(), motionEvent.getY(), false, false);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            C3295.this.f11555.f10354.setVisibility(8);
            C3295.this.f11555.f10353.setVisibility(8);
            if ((C3295.this.f11556.mo1291() || C3295.this.f11556.mo1251()) && C3295.this.f11556.mo1248() == 1) {
                C3295.this.f11556.mo1290(motionEvent.getX(), motionEvent.getY(), true, false);
            }
            return true;
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޤ, reason: contains not printable characters */
    public class C3361 implements GridsSettingView.InterfaceC0917 {
        public C3361() {
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: Ϳ */
        public boolean mo2366() {
            return C3295.this.f11556.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: Ԩ */
        public void mo2367(boolean z) {
            C3295.this.f11556.mo1242(z);
            C3295.this.f11555.f10383.invalidate();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: ԩ */
        public void mo2368(float f) {
            C3295.this.f11555.f10383.m2421(f);
            C4535.m13880().m13890().m12352((int) (f * 100.0f));
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: Ԫ */
        public void mo2369(boolean z) {
            C3295.this.mo10635(z);
            HorizonCircleRectView.f2347 = false;
            C3295.this.f11555.f10384.m2441(C3295.this.f11556.mo1250(), C3295.this.f11556.mo1244(), false);
            C4535.m13880().m13890().m12543(z ? 1 : 0);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: ԫ */
        public void mo2370(boolean z) {
            C3295.this.f11555.f10383.m2418(z);
            C4535.m13880().m13890().m12435(z ? 1 : 0);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: Ԭ */
        public void mo2371(boolean z) {
            C3295.this.f11555.f10383.m2419(z);
            C4535.m13880().m13890().m12521(z ? 1 : 0);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: ހ */
        public void mo2372(float f, float f2, boolean z) {
            C3295.this.f11556.mo1195(f, f2, z);
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: ރ */
        public void mo2373(boolean z) {
            C3295.this.f11556.mo1198(z);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޥ, reason: contains not printable characters */
    public class C3362 implements CameraTouchView.InterfaceC1143 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ CameraTouchView.InterfaceC1143 f11691;

        public C3362(CameraTouchView.InterfaceC1143 interfaceC1143) {
            this.f11691 = interfaceC1143;
        }

        @Override // com.blink.academy.film.widgets.exposure.CameraTouchView.InterfaceC1143
        /* renamed from: Ϳ */
        public void mo1326() {
            this.f11691.mo1326();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ޱ, reason: contains not printable characters */
    public class C3363 implements FocusZoomWheelView.InterfaceC1175 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ FocusZoomWheelView.InterfaceC1175 f11693;

        public C3363(FocusZoomWheelView.InterfaceC1175 interfaceC1175) {
            this.f11693 = interfaceC1175;
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1175
        /* renamed from: Ϳ */
        public void mo1325() {
            FocusZoomWheelView.InterfaceC1175 interfaceC1175 = this.f11693;
            if (interfaceC1175 != null) {
                interfaceC1175.mo1325();
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$߾, reason: contains not printable characters */
    public class RunnableC3364 implements Runnable {
        public RunnableC3364() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3295.this.f11555.f10365.setVisibility(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$߿, reason: contains not printable characters */
    public class C3365 extends AbstractC4012 {
        public C3365() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡠ, reason: contains not printable characters */
    public class C3366 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f11697;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ ConstraintLayout.LayoutParams f11698;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ TextPaint f11699;

        public C3366(String str, ConstraintLayout.LayoutParams layoutParams, TextPaint textPaint) {
            this.f11697 = str;
            this.f11698 = layoutParams;
            this.f11699 = textPaint;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.f11555.f10400.setText(this.f11697);
            C3295.this.f11555.f10400.setAlpha(1.0f);
            C3295.this.f11555.f10401.setAlpha(0.0f);
            C3295.this.f11555.f10401.setText("");
            ((ViewGroup.MarginLayoutParams) this.f11698).width = (int) (this.f11699.measureText(this.f11697) + C4792.f16138);
            C3295.this.f11555.f10400.setLayoutParams(this.f11698);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡡ, reason: contains not printable characters */
    public class C3367 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ float f11701;

        public C3367(float f) {
            this.f11701 = f;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            C3295.this.f11596 = (int) (this.f11701 / 2.0f);
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            int i = (int) (C3295.this.f11596 + (((this.f11701 / 2.0f) - C3295.this.f11596) * f));
            ViewGroup.LayoutParams layoutParams = C3295.this.f11555.f10346.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = C2579.f9593;
            C3295.this.f11555.f10346.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = C3295.this.f11555.f10347.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            C3295.this.f11555.f10347.setLayoutParams(layoutParams2);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡢ, reason: contains not printable characters */
    public class C3368 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ float f11703;

        public C3368(float f) {
            this.f11703 = f;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            C3295.this.f11597 = (int) (this.f11703 / 2.0f);
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            int i = (int) (C3295.this.f11597 + (((this.f11703 / 2.0f) - C3295.this.f11597) * f));
            ViewGroup.LayoutParams layoutParams = C3295.this.f11555.f10348.getLayoutParams();
            layoutParams.width = C2579.f9594;
            layoutParams.height = i;
            C3295.this.f11555.f10348.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = C3295.this.f11555.f10345.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            C3295.this.f11555.f10345.setLayoutParams(layoutParams2);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡣ, reason: contains not printable characters */
    public class C3369 implements LooksPreviewView.InterfaceC1338 {
        public C3369() {
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: Ϳ */
        public void mo3785() {
            C3295.this.f11556.mo1181();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: Ԩ */
        public void mo3786() {
            C3295.this.f11556.mo1182();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: ԩ */
        public void mo3787() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: Ԫ */
        public void mo3788(int i, float f) {
            C3295.this.f11556.mo1184(i, f);
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: ԫ */
        public void mo3789(int i) {
            ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
            if (r1.m8144(arrayListM11244)) {
                h0 h0Var = arrayListM11244.get(i);
                if (r1.m8142(h0Var)) {
                    C3295.this.f11556.mo1260(h0Var.m6136());
                }
            }
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: Ԭ */
        public void mo3790(int i) {
            C3295.this.f11556.mo1241();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: ԭ */
        public boolean mo3791() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: Ԯ */
        public void mo3792(int i) {
            C3295.this.f11556.mo1280();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: ԯ */
        public void mo3793(int i) {
            ArrayList<h0> arrayListM11244 = C3444.m11227().m11244();
            if (r1.m8144(arrayListM11244)) {
                h0 h0Var = arrayListM11244.get(i);
                if (r1.m8142(h0Var)) {
                    C3295.this.f11556.mo1233(h0Var.m6136());
                }
            }
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewView.InterfaceC1338
        /* renamed from: ՠ */
        public void mo3794(int i) {
            C3295.this.f11556.mo1190(i);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡤ, reason: contains not printable characters */
    public class ViewOnClickListenerC3370 implements View.OnClickListener {
        public ViewOnClickListenerC3370() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.f11556.mo1267() == 1 || !C3295.this.m11129()) {
                return;
            }
            C3295.this.f11556.mo1243();
            C3295.this.f11555.f10397.setEnabled(false);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡥ, reason: contains not printable characters */
    public class ViewOnClickListenerC3371 implements View.OnClickListener {
        public ViewOnClickListenerC3371() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.m11117()) {
                C3295.this.f11556.mo1265();
                C3295 c3295 = C3295.this;
                c3295.m11113(c3295.f11555.f10388, C3295.this.f11555.f10389, C3295.this.f11556.mo1221());
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡦ, reason: contains not printable characters */
    public class ViewOnClickListenerC3372 implements View.OnClickListener {
        public ViewOnClickListenerC3372() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.m11117()) {
                C3295.this.f11556.mo1277();
                C3295 c3295 = C3295.this;
                c3295.m11113(c3295.f11555.f10390, C3295.this.f11555.f10391, C3295.this.f11556.mo1227());
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡧ, reason: contains not printable characters */
    public class ViewOnClickListenerC3373 implements View.OnClickListener {
        public ViewOnClickListenerC3373() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3295.this.m11117()) {
                C3295.this.f11556.mo1217();
                C3295.this.f11556.mo1215();
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡨ, reason: contains not printable characters */
    public class C3374 implements C4202.InterfaceC4205 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f11710;

        public C3374(boolean z) {
            this.f11710 = z;
        }

        @Override // defpackage.C4202.InterfaceC4205
        public void end() {
            C3295.this.f11556.mo1289(true);
            C4202.m13274().m13278(C3295.this.f11556.getHandler(), true, this.f11710);
        }

        @Override // defpackage.C4202.InterfaceC4205
        /* renamed from: Ϳ */
        public void mo10644(float f) {
            C3295.this.f11555.f10355.setViewScale(Float.valueOf(f));
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡩ, reason: contains not printable characters */
    public class C3375 implements ValueAnimator.AnimatorUpdateListener {
        public C3375() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (C3295.this.f11555 == null || C3295.this.f17098) {
                return;
            }
            C3295.this.f11555.f10355.setLineAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࡪ, reason: contains not printable characters */
    public class C3376 implements Animator.AnimatorListener {
        public C3376() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (C3295.this.f11555 == null) {
                return;
            }
            C3295 c3295 = C3295.this;
            if (c3295.f17098) {
                return;
            }
            c3295.f11555.f10355.setNeedDrawLine(false);
            C3295.this.mo10472();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢠ, reason: contains not printable characters */
    public class C3377 implements C4202.InterfaceC4205 {
        public C3377() {
        }

        @Override // defpackage.C4202.InterfaceC4205
        public void end() {
            if (C3295.this.f11555 == null) {
                return;
            }
            C3295 c3295 = C3295.this;
            if (c3295.f17098) {
                return;
            }
            c3295.f11556.mo1289(true);
            C3295.this.f11556.mo1249(true);
            C3295.this.f11555.f10355.setNeedDrawLine(false);
        }

        @Override // defpackage.C4202.InterfaceC4205
        /* renamed from: Ϳ */
        public void mo10644(float f) {
            if (C3295.this.f11555 != null && C3295.this.f11556.mo1252()) {
                C3295 c3295 = C3295.this;
                if (c3295.f17098) {
                    return;
                }
                c3295.f11555.f10355.setSlidebarAndTouchAlpha(f);
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢡ, reason: contains not printable characters */
    public class RunnableC3378 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ long f11715;

        public RunnableC3378(long j) {
            this.f11715 = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3295.this.f11555.f10371.getVisibility() != 0) {
                C3295.this.f11555.f10371.setVisibility(0);
            }
            C3295.this.f11555.f10371.setText(String.format(C3295.this.getString(R.string.RECORDING_ALERT_FRAME_DROP), Long.valueOf(this.f11715)).toUpperCase(Locale.US));
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢢ, reason: contains not printable characters */
    public class C3379 extends AbstractC4012 {
        public C3379() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢣ, reason: contains not printable characters */
    public class C3380 implements AudioSettingView.InterfaceC0870 {
        public C3380() {
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: Ϳ */
        public void mo2175() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: Ԩ */
        public void mo2176(int i) {
            C3295.this.mo10589(i);
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: ނ */
        public void mo2177(boolean z) {
            C3295.this.f11556.mo1197(z);
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: ވ */
        public boolean mo2178() {
            return C3295.this.f11556.mo1203();
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: ފ */
        public void mo2179(float f) {
            C3295.this.f11556.mo1205(f);
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: ތ */
        public void mo2180(int i) {
            C3295.this.f11556.mo1207(i);
            C3295.this.mo10589(i);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢤ, reason: contains not printable characters */
    public class RunnableC3381 implements Runnable {
        public RunnableC3381() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢥ, reason: contains not printable characters */
    public class C3382 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f11720;

        public C3382(Runnable runnable) {
            this.f11720 = runnable;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            Runnable runnable = this.f11720;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢦ, reason: contains not printable characters */
    public class RunnableC3383 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f11722;

        /* compiled from: HomeLandscapeFragment.java */
        /* renamed from: פ$ࢦ$Ϳ, reason: contains not printable characters */
        public class RunnableC3384 implements Runnable {
            public RunnableC3384() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C3295.this.f11572 = false;
                C3295.this.m11118(0);
            }
        }

        public RunnableC3383(int i) {
            this.f11722 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3295.this.m11175(null);
            switch (this.f11722) {
                case 1:
                    C3295.this.f11555.f10425.m2526(100);
                    break;
                case 2:
                    C3295.this.f11555.f10369.m2275(100);
                    break;
                case 3:
                    C3295.this.f11555.f10432.m3437(100);
                    break;
                case 4:
                    C3295.this.f11555.f10407.m3300(100);
                    break;
                case 5:
                    C3295.this.f11555.f10444.m2732(100);
                    break;
                case 6:
                    C3295.this.f11555.f10412.m2459(100);
                    break;
                case 7:
                    C3295.this.f11555.f10414.m3784(100);
                    break;
                case 8:
                    C3295.this.f11555.f10340.m2174(100);
                    C3295.this.m11136(true);
                    break;
                case 9:
                    C3295.this.m11159(100);
                    break;
                case 10:
                    C3295.this.f11555.f10446.m2753(100);
                    break;
                case 11:
                    C3295.this.f11555.f10344.m2825(100);
                    break;
            }
            C3295.this.f11556.getHandler().postDelayed(new RunnableC3384(), 100L);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢧ, reason: contains not printable characters */
    public class C3385 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f11725;

        public C3385(boolean z) {
            this.f11725 = z;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            boolean z = !this.f11725;
            C3295.this.f11556.mo1274(z);
            C3295.this.f11555.f10423.setEnabled(z);
            C3295.this.f11555.f10367.setEnabled(z);
            C3295.this.f11555.f10430.setEnabled(z);
            C3295.this.f11555.f10404.setEnabled(z);
            C3295.this.f11555.f10442.setEnabled(z);
            C3295.this.f11555.f10410.setEnabled(z);
            C3295.this.f11556.mo1212();
            C3295.this.f11555.f10363.setEnabled(z);
            C3295.this.f11555.f10429.setEnabled(z);
            C3295.this.f11555.f10364.setEnabled(z);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢨ, reason: contains not printable characters */
    public class C3386 extends AbstractC4012 {
        public C3386() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.f11555.f10439.setVisibility(0);
            C3295.this.f11555.f10445.setVisibility(0);
            C3295.this.f11555.f10441.setVisibility(0);
            C3295.this.f11555.f10431.setVisibility(0);
            C3295.this.f11555.f10430.setVisibility(0);
            C3295.this.f11555.f10405.setVisibility(0);
            C3295.this.f11555.f10404.setVisibility(0);
            C3295.this.f11555.f10443.setVisibility(0);
            C3295.this.f11555.f10442.setVisibility(0);
            C3295.this.f11555.f10411.setVisibility(0);
            C3295.this.f11555.f10410.setVisibility(0);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢩ, reason: contains not printable characters */
    public class C3387 extends AbstractC4012 {
        public C3387() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.f11555.f10439.setVisibility(8);
            C3295.this.f11555.f10445.setVisibility(8);
            C3295.this.f11555.f10441.setVisibility(8);
            C3295.this.f11555.f10431.setVisibility(8);
            C3295.this.f11555.f10430.setVisibility(8);
            C3295.this.f11555.f10405.setVisibility(8);
            C3295.this.f11555.f10404.setVisibility(8);
            C3295.this.f11555.f10443.setVisibility(8);
            C3295.this.f11555.f10442.setVisibility(8);
            C3295.this.f11555.f10411.setVisibility(8);
            C3295.this.f11555.f10410.setVisibility(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢪ, reason: contains not printable characters */
    public class C3388 extends AbstractC4012 {
        public C3388() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.f11555.f10409.setVisibility(0);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢫ, reason: contains not printable characters */
    public class C3389 extends AbstractC4012 {
        public C3389() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.f11555.f10409.setVisibility(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢬ, reason: contains not printable characters */
    public class C3390 implements FPSSettingView.InterfaceC0894 {
        public C3390() {
        }

        @Override // com.blink.academy.film.widgets.FPSSettingView.InterfaceC0894
        /* renamed from: Ϳ */
        public void mo2277(int i, int i2, String str) {
            C3295 c3295 = C3295.this;
            c3295.m11172(str, c3295.f11556.mo1281(), C3295.this.f11556.mo1287(), i2, i);
        }

        @Override // com.blink.academy.film.widgets.FPSSettingView.InterfaceC0894
        /* renamed from: Ԩ */
        public boolean mo2278() {
            return C3295.this.f11556.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.FPSSettingView.InterfaceC0894
        /* renamed from: ԫ */
        public void mo2279(boolean z, boolean z2, boolean z3) {
            C3295.this.f11556.mo1185(z, z2, z3);
        }

        @Override // com.blink.academy.film.widgets.FPSSettingView.InterfaceC0894
        /* renamed from: Ԭ */
        public void mo2280(int i, int i2, String str, int i3) {
            C3295.this.f11556.mo1186(i, i2, str, i3);
        }

        @Override // com.blink.academy.film.widgets.FPSSettingView.InterfaceC0894
        /* renamed from: ԯ */
        public void mo2281(int i, String str) {
            C3295.this.f11556.mo1189(i, str);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢭ, reason: contains not printable characters */
    public class C3391 implements ResolutionSettingView.InterfaceC0947 {
        public C3391() {
        }

        @Override // com.blink.academy.film.widgets.ResolutionSettingView.InterfaceC0947
        /* renamed from: Ϳ */
        public boolean mo2527() {
            return C3295.this.f11556.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.ResolutionSettingView.InterfaceC0947
        /* renamed from: Ԩ */
        public boolean mo2528() {
            return C3295.this.f11556.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.ResolutionSettingView.InterfaceC0947
        /* renamed from: ޅ */
        public void mo2529(int i) {
            C3295.this.f11556.mo1200(i);
        }

        @Override // com.blink.academy.film.widgets.ResolutionSettingView.InterfaceC0947
        /* renamed from: އ */
        public void mo2530(w5 w5Var) {
            C3295.this.mo10574(w5Var.m8506().m8845());
            C3295.this.f11556.mo1202(w5Var);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢮ, reason: contains not printable characters */
    public class C3392 implements ZebraSettingView.InterfaceC0992 {
        public C3392() {
        }

        @Override // com.blink.academy.film.widgets.ZebraSettingView.InterfaceC0992
        /* renamed from: Ϳ */
        public void mo2754(boolean z) {
            C3947.m12727().m12778(z ? 1 : 0);
        }

        @Override // com.blink.academy.film.widgets.ZebraSettingView.InterfaceC0992
        /* renamed from: Ԩ */
        public boolean mo2755() {
            return C3295.this.f11556.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.ZebraSettingView.InterfaceC0992
        /* renamed from: ׯ */
        public void mo2756(int i) {
            C3295.this.f11556.mo1193(i);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢯ, reason: contains not printable characters */
    public class C3393 extends AbstractC4012 {
        public C3393() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢰ, reason: contains not printable characters */
    public class C3394 extends AbstractC4012 {
        public C3394() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢱ, reason: contains not printable characters */
    public class C3395 extends AbstractC4012 {
        public C3395() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢲ, reason: contains not printable characters */
    public class C3396 extends AbstractC4012 {
        public C3396() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢳ, reason: contains not printable characters */
    public class C3397 extends AbstractC4012 {
        public C3397() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢴ, reason: contains not printable characters */
    public class C3398 extends AbstractC4012 {
        public C3398() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢶ, reason: contains not printable characters */
    public class C3399 extends AbstractC4012 {
        public C3399() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢷ, reason: contains not printable characters */
    public class C3400 extends AbstractC4012 {
        public C3400() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢸ, reason: contains not printable characters */
    public class C3401 extends AbstractC4012 {
        public C3401() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢹ, reason: contains not printable characters */
    public class C3402 extends AbstractC4012 {
        public C3402() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢺ, reason: contains not printable characters */
    public class C3403 implements WbSettingView.InterfaceC0987 {
        public C3403() {
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: Ϳ */
        public boolean mo2735() {
            return C3295.this.f11556.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: Ԩ */
        public void mo2736() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: ԩ */
        public void mo2737() {
            C3295.this.f11556.mo1256();
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: ؠ */
        public void mo2738(int i, int i2) {
            C3295.this.f11556.mo1194(i, i2);
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: ށ */
        public void mo2739(w7 w7Var) {
            C3295.this.f11556.mo1196(w7Var);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢻ, reason: contains not printable characters */
    public class C3404 extends AbstractC4012 {
        public C3404() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C3295.this.mo10630();
            C3295.this.m11118(8);
        }
    }

    /* compiled from: HomeLandscapeFragment.java */
    /* renamed from: פ$ࢼ, reason: contains not printable characters */
    public class C3405 implements LensSettingView.InterfaceC0928 {
        public C3405() {
        }

        @Override // com.blink.academy.film.widgets.LensSettingView.InterfaceC0928
        /* renamed from: Ϳ */
        public boolean mo2460() {
            return C3295.this.f11556.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.LensSettingView.InterfaceC0928
        /* renamed from: ލ */
        public void mo2461(C3828 c3828) {
            C3295.this.f11556.mo1208(c3828);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ང, reason: contains not printable characters */
    public /* synthetic */ void m11076(ValueAnimator valueAnimator) {
        this.f11555.f10355.setViewScale((Float) valueAnimator.getAnimatedValue());
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) throws JSONException {
        if (this.f11555 == null) {
            this.f11555 = AbstractC2853.m10192(layoutInflater, viewGroup, false);
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.setClassLoader(getClass().getClassLoader());
            }
            if (arguments != null) {
                try {
                    this.f11556 = (FragmentCallback) arguments.getParcelable("fcallback");
                } catch (Exception unused) {
                    this.f11556 = C4425.m13657().m13658();
                }
            }
            m11162();
            this.f11556.mo1275();
        }
        this.f11576 = (SensorManager) getActivity().getSystemService(am.ac);
        return this.f11555.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        m11139();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = new float[3];
        m11132((float[]) sensorEvent.values.clone(), fArr);
        float f = (-fArr[0]) / 9.80665f;
        float f2 = (-fArr[1]) / 9.80665f;
        float f3 = (-fArr[2]) / 9.80665f;
        double dAtan2 = (Math.atan2(f3, Math.sqrt((f * f) + (f2 * f2))) / 3.141592653589793d) * 180.0d;
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null) {
            HorizonCircleRectView.f2347 = false;
            abstractC2853.f10384.m2442(f, f2, f3, dAtan2);
        }
    }

    /* renamed from: Ĩ, reason: contains not printable characters */
    public final void m11099() {
        this.f11555.f10393.m2562(0, C4792.m14375().m14397());
        this.f11555.f10393.setContentTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10393.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = C4792.m14375().m14476(30);
        this.f11555.f10393.setLayoutParams(layoutParams);
    }

    /* renamed from: ĩ, reason: contains not printable characters */
    public final void m11100(int i) {
        int iM14476 = C4792.m14375().m14476(95);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11555.f10406.getLayoutParams();
        int iM144762 = (int) ((C4792.m14375().m14476((C4792.m14375().m14488() * 2) + 658) * this.f17096) + 0.5f);
        int i2 = iM144762 + (iM144762 % 2);
        layoutParams.width = i2;
        layoutParams.height = i2;
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f11555.f10361.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = layoutParams.height + C4792.m14375().m14476(20);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((int) ((C4792.m14375().m14476(C4792.m14375().m14488() + 242) * this.f17096) + 0.5f)) + iM14476 + i;
        this.f11555.f10361.setLayoutParams(layoutParams2);
        this.f11607 = (int) (((ViewGroup.MarginLayoutParams) layoutParams2).width - (C4792.m14375().m14488() * this.f17096));
        layoutParams.leftMargin = -((layoutParams.width - ((ViewGroup.MarginLayoutParams) layoutParams2).width) + iM14476);
        this.f11555.f10406.setLayoutParams(layoutParams);
        this.f11555.f10406.setCardWidth(((ViewGroup.MarginLayoutParams) layoutParams2).width);
        this.f11555.f10406.setOnChange(new C3300());
        if (this.f11556.mo1270()) {
            this.f11555.f10406.m3333(0);
        } else {
            this.f11555.f10406.m3319(0);
        }
    }

    /* renamed from: ī, reason: contains not printable characters */
    public final void m11101(int i) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10407.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10407.setLayoutParams(layoutParams);
        this.f11555.f10407.setPadding(this.f11580);
        this.f11555.f10407.setOnISOChange(new C3297());
        this.f11555.f10407.setOnVStateChange(new C3298());
        this.f11555.f10432.setOnVStateChange(new C3299());
        this.f11555.f10407.m3291(0, null);
    }

    /* renamed from: ĭ, reason: contains not printable characters */
    public void m11102(boolean z) {
        if (z) {
            this.f11555.f10437.setVisibility(0);
        } else {
            this.f11555.f10437.setVisibility(8);
        }
    }

    /* renamed from: ı, reason: contains not printable characters */
    public final void m11103() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10371.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C4792.m14375().m14421();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14424();
        this.f11555.f10371.setPadding(C4792.m14375().m14422(), 0, C4792.m14375().m14423(), 0);
        this.f11555.f10371.setLayoutParams(layoutParams);
    }

    /* renamed from: ĺ, reason: contains not printable characters */
    public final void m11104(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10414.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10414.setLayoutParams(layoutParams);
        this.f11555.f10414.setPadding(this.f11580);
        this.f11555.f10414.setOnLooksStyleChangeListener(new C3369());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ľ, reason: contains not printable characters */
    public final void m11105() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10428.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (C4792.m14375().m14462() * this.f17096);
        float fM14462 = C4792.m14375().m14462();
        float f = this.f17096;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (fM14462 * f);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) ((this.f11601 * this.f11582 * f) + C2579.m9438(1.0f) + ((((int) ((this.f11599 * this.f11582) * this.f17096)) - ((ViewGroup.MarginLayoutParams) layoutParams).height) / 2));
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (C4792.m14375().m14472() * this.f17096);
        this.f11555.f10428.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f11555.f10427.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (C4792.m14375().m14465() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (C4792.m14375().m14465() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = (int) (C4792.m14375().m14465() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = (int) (C4792.m14375().m14418() * this.f17096);
        this.f11555.f10427.setLayoutParams(layoutParams2);
        this.f11555.f10415.setOnClickListener(new ViewOnClickListenerC3332());
        AbstractC2853 abstractC2853 = this.f11555;
        abstractC2853.f10415.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC2853.f10427));
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f11555.f10362.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (C4792.m14375().m14462() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) (C4792.m14375().m14462() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = (int) (C4792.m14375().m14418() * this.f17096);
        this.f11555.f10362.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f11555.f10413.getLayoutParams();
        int iM14476 = (int) (C4792.m14375().m14476(27) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (int) ((((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + C4792.m14375().m14476(5)) - (((ViewGroup.MarginLayoutParams) layoutParams4).width / 2.0f));
        this.f11555.f10413.setStyle(false);
        this.f11555.f10413.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f11555.f10408.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) (m15085(50) * this.f17096);
        int iM15085 = (int) (m15085(50) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = iM15085;
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((int) ((((ViewGroup.MarginLayoutParams) layoutParams3).height / 2.0f) - iM15085));
        ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = (int) ((((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin - (((ViewGroup.MarginLayoutParams) layoutParams5).width / 2.0f)) + m15085(10));
        this.f11555.f10408.setLayoutParams(layoutParams5);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f11555.f10417.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (C4792.m14375().m14462() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = (int) (C4792.m14375().m14462() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = (int) (C4792.m14375().m14445() * this.f17096);
        this.f11555.f10417.setLayoutParams(layoutParams6);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14398());
        textPaint.setTypeface(FilmApp.m404());
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.f11559 = ((ViewGroup.MarginLayoutParams) layoutParams6).height + ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin + C4792.m14375().m14476(C4792.m14375().m14483()) + C4792.m14375().m14476(10) + Math.round(fontMetrics.bottom - fontMetrics.top) + this.f11571;
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f11555.f10375.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = ((int) ((this.f11598 * this.f11582) * this.f17096)) - C2579.m9438(2.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = ((int) ((this.f11599 * this.f11582) * this.f17096)) - C2579.m9438(2.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = ((int) (this.f11601 * this.f11582 * this.f17096)) + C2579.m9438(1.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin = ((int) (this.f11600 * this.f11582 * this.f17096)) + C2579.m9438(1.0f);
        this.f11555.f10375.setLayoutParams(layoutParams7);
        int i = ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
        this.f11588 = i + (i - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (((ViewGroup.MarginLayoutParams) layoutParams7).width / 2);
        ViewGroup.LayoutParams layoutParams8 = this.f11555.f10376.getLayoutParams();
        layoutParams8.width = (int) (((ViewGroup.MarginLayoutParams) layoutParams7).width * 0.6917293f);
        layoutParams8.height = (int) (((ViewGroup.MarginLayoutParams) layoutParams7).width * 0.6917293f);
        this.f11555.f10376.setLayoutParams(layoutParams8);
        m11154();
        this.f11555.f10375.setOnClickListener(new ViewOnClickListenerC3333());
        FrameLayout frameLayout = this.f11555.f10375;
        frameLayout.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(frameLayout));
        AbstractC2853 abstractC28532 = this.f11555;
        abstractC28532.f10429.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC28532.f10428));
        this.f11555.f10429.setOnClickListener(new ViewOnClickListenerC3334());
        this.f11555.f10363.setOnTouchListener(new ViewOnTouchListenerC3335());
        this.f11555.f10363.setOnClickListener(new ViewOnClickListenerC3337());
        this.f11555.f10363.setOnLongClickListener(new ViewOnLongClickListenerC3339());
        this.f11555.f10364.setOnClickListener(new ViewOnClickListenerC3340());
        AbstractC2853 abstractC28533 = this.f11555;
        abstractC28533.f10418.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC28533.f10417));
        this.f11555.f10418.setOnClickListener(new ViewOnClickListenerC3341());
    }

    /* renamed from: ŀ, reason: contains not printable characters */
    public final void m11106() {
        this.f11602 = this.f11607;
        this.f11604 = this.f11578 - Math.max(this.f11606, this.f11608);
        this.f11603 = this.f11583 + C2579.m9438(5.0f);
        this.f11605 = this.f11579 - (this.f11609 + C2579.m9438(5.0f));
    }

    /* renamed from: ł, reason: contains not printable characters */
    public void m11107() {
        if (!m11117()) {
            this.f11555.f10435.setVisibility(8);
            this.f11555.f10436.setVisibility(8);
            return;
        }
        float fM11123 = m11123();
        this.f11555.f10435.setVisibility(0);
        this.f11555.f10436.setVisibility(0);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10435.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (C4792.m14375().m14476(70) * fM11123);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (C4792.m14375().m14476(70) * fM11123);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (((((this.f11578 - C2579.m9450(getActivity())) / 2.0f) - ((ViewGroup.MarginLayoutParams) layoutParams).width) - C4792.m14375().m14442()) / 2.0f);
        this.f11555.f10435.setLayoutParams(layoutParams);
    }

    /* renamed from: ſ, reason: contains not printable characters */
    public void m11108() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3330();
    }

    /* renamed from: ǃ, reason: contains not printable characters */
    public final void m11109(int i, int i2) {
        int iM14476 = C4792.m14375().m14476(50);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11555.f10366.getLayoutParams();
        int iM144762 = (int) ((C4792.m14375().m14476((C4792.m14375().m14488() * 2) + 658) * this.f17096) + 0.5f);
        int i3 = iM144762 + (iM144762 % 2);
        layoutParams.width = i3;
        layoutParams.height = i3;
        layoutParams.leftMargin = iM14476;
        this.f11555.f10366.setLayoutParams(layoutParams);
        this.f11555.f10366.setHandler(this.f11556.getHandler());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f11555.f10360.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = layoutParams.height + C4792.m14375().m14476(30);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((int) (C4792.m14375().m14476(C4792.m14375().m14488() + 242) * this.f17096)) + iM14476 + i2;
        this.f11555.f10360.setLayoutParams(layoutParams2);
        this.f11606 = (int) (((ViewGroup.MarginLayoutParams) layoutParams2).width - ((C4792.m14375().m14488() * 2) * this.f17096));
        m11126(layoutParams.width, layoutParams.height, i2);
        this.f11555.f10366.setOnValueChange(new C3301());
        this.f11555.f10366.setCardWidth(((ViewGroup.MarginLayoutParams) layoutParams2).width);
        this.f11589 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
        if (this.f11556.mo1270()) {
            this.f11555.f10366.m3278(0);
            this.f11555.f10337.m3192(0);
            this.f11555.f10338.m3192(0);
        } else {
            this.f11555.f10366.m3265(0);
            this.f11555.f10337.m3188(0);
            this.f11555.f10338.m3188(0);
        }
        if (C3947.m12727().m12772()) {
            this.f11555.f10357.setVisibility(0);
            this.f11555.f10356.setVisibility(8);
        } else {
            this.f11555.f10357.setVisibility(8);
            this.f11555.f10356.setVisibility(0);
        }
    }

    /* renamed from: ǐ, reason: contains not printable characters */
    public final void m11110(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10350.getLayoutParams();
        layoutParams.width = i;
        if (i == 0) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = C2579.m9440(getContext());
        }
        this.f11555.f10350.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f11555.f10351.getLayoutParams();
        layoutParams2.width = i;
        if (i == 0) {
            layoutParams2.height = 0;
        } else {
            layoutParams2.height = C2579.m9440(getContext());
        }
        this.f11555.f10351.setLayoutParams(layoutParams2);
        this.f11555.f10350.setOnClickListener(new ViewOnClickListenerC3304());
        ViewGroup.LayoutParams layoutParams3 = this.f11555.f10352.getLayoutParams();
        layoutParams3.height = i2;
        if (i2 == 0) {
            layoutParams3.width = 0;
        }
        this.f11555.f10352.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f11555.f10349.getLayoutParams();
        layoutParams4.height = i2;
        if (i == 0) {
            layoutParams4.width = 0;
        }
        this.f11555.f10349.setLayoutParams(layoutParams4);
        this.f11555.f10351.setOnClickListener(new ViewOnClickListenerC3305());
    }

    /* renamed from: ȉ, reason: contains not printable characters */
    public final boolean m11111() {
        if (this.f11587 == 0) {
            this.f11587 = System.currentTimeMillis();
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f11587 < 500) {
            return true;
        }
        this.f11587 = jCurrentTimeMillis;
        return false;
    }

    /* renamed from: ȋ, reason: contains not printable characters */
    public void m11112() {
        this.f11555 = null;
    }

    /* renamed from: ɾ, reason: contains not printable characters */
    public void m11113(ImageView imageView, View view, boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        if (imageView == abstractC2853.f10396) {
            z = true;
        }
        C4008.m12876(imageView, z ? C4792.m14375().m14402() : 0.2f, 100, null);
    }

    /* renamed from: ɿ, reason: contains not printable characters */
    public void m11114() {
        C4008.m12876(this.f11555.f10370, 0.0f, 200, null);
    }

    /* renamed from: ʰ, reason: contains not printable characters */
    public final HomeActivity m11115() {
        return (HomeActivity) getActivity();
    }

    /* renamed from: ʱ, reason: contains not printable characters */
    public final void m11116() {
        m11136(false);
        this.f11555.f10340.m2166(100, new C3395());
    }

    /* renamed from: ʲ, reason: contains not printable characters */
    public final boolean m11117() {
        if (getActivity() != null) {
            if (C2579.m9451(getActivity())) {
                this.f11557 = true;
            } else {
                this.f11557 = C4792.m14375().m14484() >= 2.0f;
            }
        }
        return this.f11557;
    }

    /* renamed from: ʴ, reason: contains not printable characters */
    public void m11118(int i) {
        this.f11555.f10339.setVisibility(i);
    }

    /* renamed from: ʵ, reason: contains not printable characters */
    public final void m11119() {
        this.f11555.f10344.m2807(100, new C3393());
    }

    /* renamed from: ʶ, reason: contains not printable characters */
    public float m11120() {
        return this.f11559;
    }

    /* renamed from: ʷ, reason: contains not printable characters */
    public final void m11121() {
        m11147(100, new C3397());
    }

    /* renamed from: ʸ, reason: contains not printable characters */
    public final boolean m11122() {
        return this.f11555.f10425.m2521() || this.f11555.f10369.m2265() || this.f11555.f10444.m2722() || this.f11555.f10412.m2452() || this.f11555.f10432.m3433() || this.f11555.f10407.m3295() || m11142() || this.f11555.f10446.m2748() || this.f11555.f10340.m2170() || this.f11555.f10414.m3770() || this.f11555.f10344.m2813();
    }

    /* renamed from: ʺ, reason: contains not printable characters */
    public final float m11123() {
        float fM14476 = C2579.f9597 + (C4792.m14375().m14476(70) * 2);
        float fM9444 = C2579.m9444() - (C4792.m14375().m14442() * 2.0f);
        if (fM9444 < fM14476) {
            return fM9444 / fM14476;
        }
        return 1.0f;
    }

    /* renamed from: ˌ, reason: contains not printable characters */
    public final void m11124(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10359.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i;
        this.f11555.f10359.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f11555.f10355.getLayoutParams();
        layoutParams2.width = C2579.m9438(C4792.m14375().m14415());
        layoutParams2.height = C2579.m9438(C4792.m14375().m14415());
        this.f11555.f10355.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f11555.f10353.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = C4792.m14375().m14421();
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = C2579.m9438(20.0f);
        this.f11555.f10353.setPadding(C4792.m14375().m14422(), 0, C4792.m14375().m14423(), 0);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f11555.f10354.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = C4792.m14375().m14421();
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = C2579.m9438(20.0f);
        this.f11555.f10354.setPadding(C4792.m14375().m14422(), 0, C4792.m14375().m14423(), 0);
        ViewGroup.LayoutParams layoutParams5 = this.f11555.f10398.getLayoutParams();
        layoutParams5.width = i2;
        layoutParams5.height = i;
        this.f11555.f10398.setLayoutParams(layoutParams5);
        this.f11555.f10398.setOnTouchListener(new ViewOnTouchListenerC3355());
        this.f11555.f10355.setSlidebarCallback(new C3359());
        m11168();
    }

    /* renamed from: ˍ, reason: contains not printable characters */
    public final void m11125(int i, int i2) {
    }

    /* renamed from: ˎ, reason: contains not printable characters */
    public final void m11126(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10357.getLayoutParams();
        int iM14476 = (int) ((C4792.m14375().m14476(C4792.m14375().m14488() + 242) * this.f17096) + 0.5f);
        int iM144762 = C4792.m14375().m14476(105);
        layoutParams.width = iM14476 + iM144762 + i3;
        this.f11555.f10357.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f11555.f10338.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i2;
        layoutParams2.leftMargin = iM144762 - C4792.m14375().m14476(4);
        this.f11555.f10338.setLayoutParams(layoutParams2);
        this.f11555.f10338.setZoom(true);
        this.f11555.f10338.m3194();
        this.f11555.f10338.setHandler(this.f11556.getHandler());
        this.f11555.f10338.setOnABStateChange(new C3302());
        ViewGroup.LayoutParams layoutParams3 = this.f11555.f10356.getLayoutParams();
        layoutParams3.width = layoutParams.width;
        this.f11555.f10356.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f11555.f10337.getLayoutParams();
        layoutParams4.width = i;
        layoutParams4.height = i2;
        layoutParams4.leftMargin = iM144762;
        this.f11555.f10337.setLayoutParams(layoutParams4);
        this.f11555.f10337.m3194();
        this.f11555.f10337.setZoom(false);
        this.f11555.f10337.setHandler(this.f11556.getHandler());
        this.f11555.f10337.setOnABStateChange(new C3303());
        this.f11555.f10356.setVisibility(8);
        this.f11555.f10338.setCardWidth(layoutParams.width);
        this.f11555.f10337.setCardWidth(layoutParams4.width);
        mo10553(C4535.m13880().m13890().m12412());
    }

    /* renamed from: ˏ, reason: contains not printable characters */
    public final void m11127() {
        this.f11555.f10407.m3291(100, new C3398());
    }

    /* renamed from: ː, reason: contains not printable characters */
    public final void m11128(int i) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10425.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10425.setLayoutParams(layoutParams);
        this.f11555.f10425.setPadding(this.f11580);
        this.f11555.f10425.m2525(new C3391());
        this.f11555.f10425.m2519(0, null);
    }

    /* renamed from: ˑ, reason: contains not printable characters */
    public final boolean m11129() {
        return (this.f11610 || this.f11611 || this.f11612 || this.f11613 || this.f11614) ? false : true;
    }

    /* renamed from: ˠ, reason: contains not printable characters */
    public final void m11130() {
        this.f11555.f10446.m2746(100, new C3396());
    }

    /* renamed from: ˢ, reason: contains not printable characters */
    public void m11131() {
        C4008.m12876(this.f11555.f10370, 1.0f, 200, null);
    }

    /* renamed from: ˣ, reason: contains not printable characters */
    public final void m11132(float[] fArr, float[] fArr2) {
        float[][] fArr3 = this.f11617;
        int i = this.f11618;
        float[] fArr4 = fArr3[i];
        fArr4[0] = fArr[0];
        fArr4[1] = fArr[1];
        fArr4[2] = fArr[2];
        float f = 0.0f;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
        for (int i2 = 0; i2 < 8; i2++) {
            float[] fArr5 = this.f11617[i];
            float f2 = fArr5[0];
            float f3 = fArr5[1];
            float f4 = fArr5[2];
            float fAbs = (1.0f / (Math.abs(((float) Math.sqrt(((f2 * f2) + (f3 * f3)) + (f4 * f4))) - 9.80665f) + 0.1f)) * (8 - i2);
            f += fAbs;
            float f5 = fArr2[0];
            float[] fArr6 = this.f11617[i2];
            fArr2[0] = f5 + (fArr6[0] * fAbs);
            fArr2[1] = fArr2[1] + (fArr6[1] * fAbs);
            fArr2[2] = fArr2[2] + (fAbs * fArr6[2]);
            i = ((i + 8) - 1) & 7;
        }
        fArr2[0] = fArr2[0] / f;
        fArr2[1] = fArr2[1] / f;
        fArr2[2] = fArr2[2] / f;
        this.f11618 = (this.f11618 + 1) & 7;
    }

    /* renamed from: ˮ, reason: contains not printable characters */
    public final void m11133(MotionEvent motionEvent) {
        float y = ((((motionEvent.getY() - this.f11591) * 1.0f) / (this.f11579 / 2.0f)) * C2579.m9438(C4792.m14375().m14415())) / 20.0f;
        this.f11555.f10355.setNeedDrawLine(true);
        this.f11555.f10355.setLineAlpha(255);
        this.f11555.f10355.m3153(y, true, -1.0f);
    }

    /* renamed from: ͱ, reason: contains not printable characters */
    public boolean m11134() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null) {
            return abstractC2853.f10418.isEnabled();
        }
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ͺ, reason: contains not printable characters */
    public final void m11135(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11555.f10434.getLayoutParams();
        layoutParams.width = (int) (C4792.m14375().m14462() * this.f17096 * 0.9f);
        layoutParams.height = (int) (C4792.m14375().m14462() * this.f17096 * 0.9f);
        this.f11555.f10434.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f11555.f10433.getLayoutParams();
        layoutParams2.width = (int) (C4792.m14375().m14462() * this.f17096 * 0.9f);
        layoutParams2.height = (int) (C4792.m14375().m14462() * this.f17096 * 0.9f);
        this.f11555.f10433.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f11555.f10409.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = m15085(50);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = m15085(50);
        this.f11555.f10409.setLayoutParams(layoutParams3);
        AbstractC2853 abstractC2853 = this.f11555;
        abstractC2853.f10436.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC2853.f10435));
        this.f11555.f10436.setOnClickListener(new ViewOnClickListenerC3309());
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f11555.f10421.getLayoutParams();
        float f = this.f11598;
        float f2 = this.f11582;
        float f3 = this.f17096;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (f * f2 * f3);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = (int) (this.f11599 * f2 * f3);
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = (int) (this.f11601 * f2 * f3);
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (int) (this.f11600 * f2 * f3);
        this.f11555.f10421.setLayoutParams(layoutParams4);
        this.f11555.f10421.m2505(((ViewGroup.MarginLayoutParams) layoutParams4).width, ((ViewGroup.MarginLayoutParams) layoutParams4).height);
        C4792.m14375().m14508(((ViewGroup.MarginLayoutParams) layoutParams4).width);
        C4792.m14375().m14506(((ViewGroup.MarginLayoutParams) layoutParams4).height);
        C4792.m14375().m14507(((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin);
        C4792.m14375().m14505(((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin);
        this.f11561 = this.f11560 / 2.0f;
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f11555.f10422.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) (((ViewGroup.MarginLayoutParams) layoutParams4).width + (((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin * 1.5f));
        int i3 = (int) (((ViewGroup.MarginLayoutParams) layoutParams4).height + (((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin * 1.5f));
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = i3;
        this.f11609 = i3;
        this.f11555.f10422.setLayoutParams(layoutParams5);
        this.f11555.f10422.setOnClickListener(new ViewOnClickListenerC3310());
        float f4 = this.f11565;
        float f5 = this.f11582;
        int i4 = (((int) (f4 * f5)) >> 1) << 1;
        int i5 = this.f11566;
        int i6 = (((int) (i5 * f5)) >> 1) << 1;
        this.f11567 = (int) (this.f11564 * f5);
        int i7 = (int) (this.f11563 * f5);
        this.f11568 = (int) (r7 + i4 + ((C2579.f9594 - C2579.f9598) / 2.0f));
        this.f11560 = this.f11562 + i4;
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f11555.f10373.getLayoutParams();
        int iM14476 = (int) (C4792.m14375().m14476(i5) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = iM14476;
        float f6 = i5;
        float f7 = 90.0f / f6;
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (iM14476 * f7);
        float f8 = 17.0f / f6;
        int i8 = (int) (iM14476 * f8);
        this.f11562 = i8;
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = i8 + this.f11567 + i4;
        float f9 = 35.0f / f6;
        ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = (int) (iM14476 * f9);
        this.f11555.f10373.setLayoutParams(layoutParams6);
        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
        int i10 = (int) ((18.0f / f6) * i9);
        int i11 = (int) ((4.0f / f6) * i9);
        int iM144762 = (int) (((((ViewGroup.MarginLayoutParams) layoutParams6).width - (i10 * 2)) - C4792.m14375().m14476(12)) / 2.0f);
        float f10 = 13.0f / f6;
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
        int i13 = (int) (f10 * i12);
        this.f11555.f10373.m2113(iM144762, i13, ((ViewGroup.MarginLayoutParams) layoutParams6).width - iM144762, i12 - i13, i10, i11);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f11555.f10374.getLayoutParams();
        int iM144763 = (int) (C4792.m14375().m14476(27) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = iM144763;
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = iM144763;
        this.f11555.f10374.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f11555.f10378.getLayoutParams();
        int i14 = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
        ((ViewGroup.MarginLayoutParams) layoutParams8).height = i14;
        ((ViewGroup.MarginLayoutParams) layoutParams8).width = (int) (f7 * i14);
        ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin = (int) (f8 * i14);
        ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = (int) (f9 * i14);
        this.f11555.f10378.setLayoutParams(layoutParams8);
        this.f11555.f10378.m2183(((ViewGroup.MarginLayoutParams) layoutParams8).width, ((ViewGroup.MarginLayoutParams) layoutParams8).height);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f11555.f10377.getLayoutParams();
        int iM144764 = (int) (C4792.m14375().m14476(27) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = iM144764;
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = iM144764;
        this.f11555.f10377.setLayoutParams(layoutParams9);
        this.f11555.f10378.setOnClickListener(new ViewOnClickListenerC3311());
        this.f11555.f10373.setOnClickListener(new ViewOnClickListenerC3312());
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f11555.f10392.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = (int) (C4792.m14375().m14476(120) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = (int) this.f11555.f10392.getLayoutWidth();
        ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin;
        this.f11574 = ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin;
        this.f11575 = ((ViewGroup.MarginLayoutParams) layoutParams10).height;
        this.f11555.f10392.setLayoutParams(layoutParams10);
        this.f11555.f10392.setRecordMode(C4535.m13880().m13890().m12460() == 1);
        m11141(i, ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin + (((ViewGroup.MarginLayoutParams) layoutParams6).width * 2) + this.f11562);
        m11107();
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f11555.f10445.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams11).rightMargin = (int) (C4792.m14375().m14491() * this.f17096);
        layoutParams11.topToTop = this.f11555.f10392.getId();
        layoutParams11.bottomToBottom = this.f11555.f10392.getId();
        ((ViewGroup.MarginLayoutParams) layoutParams11).width = (int) (C4792.m14375().m14432() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams11).height = (int) (C4792.m14375().m14432() * this.f17096);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f11555.f10372.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams12).width = (int) (C4792.m14375().m14432() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = (int) (C4792.m14375().m14432() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams12).rightMargin = ((int) (C4792.m14375().m14433() * this.f17096)) + ((ViewGroup.MarginLayoutParams) layoutParams11).width + ((ViewGroup.MarginLayoutParams) layoutParams11).rightMargin;
        layoutParams12.topToTop = this.f11555.f10392.getId();
        layoutParams12.bottomToBottom = this.f11555.f10392.getId();
        this.f11569 = ((ViewGroup.MarginLayoutParams) layoutParams11).rightMargin + ((ViewGroup.MarginLayoutParams) layoutParams11).width;
        ImageView imageView = this.f11555.f10419;
        imageView.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(imageView));
        this.f11555.f10419.setOnClickListener(new ViewOnClickListenerC3314());
        ImageView imageView2 = this.f11555.f10372;
        imageView2.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(imageView2));
        this.f11555.f10372.setOnClickListener(new ViewOnClickListenerC3315());
        ImageView imageView3 = this.f11555.f10445;
        imageView3.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(imageView3));
        this.f11555.f10445.setOnClickListener(new ViewOnClickListenerC3317());
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f11555.f10419.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = (int) (C4792.m14375().m14453() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams13).height = (int) (C4792.m14375().m14453() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams13).rightMargin = (int) (C4792.m14375().m14454() * this.f17096);
        layoutParams13.topToTop = this.f11555.f10392.getId();
        layoutParams13.bottomToBottom = this.f11555.f10392.getId();
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = (int) (C4792.m14375().m14476(113) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams13).height = (int) (C4792.m14375().m14476(113) * this.f17096);
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f11555.f10420.getLayoutParams();
        int i15 = ((ViewGroup.MarginLayoutParams) layoutParams13).height;
        ((ViewGroup.MarginLayoutParams) layoutParams14).bottomMargin = (int) (i15 - (i15 * 0.13461539f));
        int childCount = this.f11555.f10420.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = this.f11555.f10420.getChildAt(i16);
            LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams15.width = C4792.m14375().m14395();
            layoutParams15.height = C4792.m14375().m14395();
            if (i16 == 0) {
                layoutParams15.leftMargin = C4792.m14375().m14388();
                layoutParams15.rightMargin = C4792.m14375().m14388();
            } else if (i16 == childCount - 1) {
                layoutParams15.leftMargin = C4792.m14375().m14388();
                layoutParams15.rightMargin = C4792.m14375().m14388();
            }
            childAt.setLayoutParams(layoutParams15);
        }
        this.f11555.f10421.setOnRecordButtonClick(new C3319());
        C2650.m9796(new C3320());
        ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) this.f11555.f10439.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams16).width = i4;
        ((ViewGroup.MarginLayoutParams) layoutParams16).height = i6;
        ((ViewGroup.MarginLayoutParams) layoutParams16).leftMargin = this.f11567;
        ((ViewGroup.MarginLayoutParams) layoutParams16).bottomMargin = i7;
        int iM144765 = C4792.m14375().m14476(10);
        int iM144766 = C4792.m14375().m14476(3);
        this.f11555.f10439.setPadding(iM144765, iM144765, iM144765, iM144765);
        int i17 = iM144765 * 2;
        int i18 = ((i4 - i17) >> 1) << 1;
        int i19 = i6 - i17;
        this.f11555.f10438.getLayoutParams().width = i18;
        this.f11555.f10438.getLayoutParams().height = (i19 >> 1) << 1;
        this.f11555.f10440.getLayoutParams().width = i18;
        this.f11555.f10440.getLayoutParams().height = ((i19 - (iM144766 * 2)) >> 1) << 1;
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f11555.f10441.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams17).width = C4792.m14375().m14486();
        ((ViewGroup.MarginLayoutParams) layoutParams17).height = C4792.m14375().m14485();
        int childCount2 = this.f11555.f10441.getChildCount();
        for (int i20 = 0; i20 < childCount2; i20++) {
            View childAt2 = this.f11555.f10441.getChildAt(i20);
            LinearLayout.LayoutParams layoutParams18 = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
            layoutParams18.width = C4792.m14375().m14395();
            layoutParams18.height = C4792.m14375().m14395();
            layoutParams18.leftMargin = C4792.m14375().m14388();
            layoutParams18.rightMargin = C4792.m14375().m14388();
            if (i20 == 0) {
                layoutParams18.leftMargin = C4792.m14375().m14388();
            } else if (i20 == childCount2 - 1) {
                layoutParams18.rightMargin = C4792.m14375().m14388();
            }
            childAt2.setLayoutParams(layoutParams18);
        }
        C2650.m9797(this.f11556.mo1262());
        mo10581();
        this.f11616 = ((ViewGroup.MarginLayoutParams) layoutParams16).height + ((ViewGroup.MarginLayoutParams) layoutParams16).bottomMargin + (((ViewGroup.MarginLayoutParams) layoutParams17).height * 2) + this.f11571;
        this.f11561 = this.f11560 / 2.0f;
        this.f11555.f10440.setOpaque(false);
        this.f11555.f10439.setOnClickListener(new ViewOnClickListenerC3322());
        this.f11555.f10440.setSurfaceTextureListener(new TextureViewSurfaceTextureListenerC3325());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ϳ */
    public void mo10463(boolean z) {
        if (this.f11555 == null) {
            return;
        }
        if (z) {
            int i = this.f11556.mo1261() ? 0 : this.f11616;
            C4008.m12876(this.f11555.f10431, 1.0f, 100, null);
            C4008.m12876(this.f11555.f10430, 1.0f, 100, null);
            C4008.m12876(this.f11555.f10405, 1.0f, 100, null);
            C4008.m12876(this.f11555.f10404, 1.0f, 100, null);
            C4008.m12876(this.f11555.f10443, 1.0f, 100, null);
            C4008.m12876(this.f11555.f10442, 1.0f, 100, null);
            C4008.m12876(this.f11555.f10411, 1.0f, 100, null);
            C4008.m12876(this.f11555.f10410, 1.0f, 100, null);
            float f = i;
            C4008.m12886(this.f11555.f10441, 0.0f, f, 100, null);
            C4008.m12876(this.f11555.f10441, 1.0f, 100, null);
            C4008.m12886(this.f11555.f10439, 0.0f, f, 100, null);
            C4008.m12876(this.f11555.f10439, 1.0f, 100, null);
            C4008.m12886(this.f11555.f10373, 0.0f, f, 100, null);
            C4008.m12886(this.f11555.f10374, 0.0f, f, 100, null);
            C4008.m12886(this.f11555.f10378, 0.0f, f, 100, null);
            C4008.m12886(this.f11555.f10377, 0.0f, f, 100, null);
            C4008.m12886(this.f11555.f10386, 0.0f, f, 100, null);
            C4008.m12886(this.f11555.f10402, 0.0f, f, 100, null);
            C4008.m12886(this.f11555.f10387, 0.0f, f, 100, null);
            C4008.m12886(this.f11555.f10437, 0.0f, f, 100, null);
            C4008.m12886(this.f11555.f10399, 0.0f, f, 100, null);
            C4008.m12876(this.f11555.f10445, 1.0f, 100, null);
            C4008.m12886(this.f11555.f10372, 0.0f, f, 100, new C3386());
            return;
        }
        int i2 = this.f11556.mo1261() ? 0 : this.f11616;
        C4008.m12876(this.f11555.f10431, 0.0f, 100, null);
        C4008.m12876(this.f11555.f10430, 0.0f, 100, null);
        C4008.m12876(this.f11555.f10405, 0.0f, 100, null);
        C4008.m12876(this.f11555.f10404, 0.0f, 100, null);
        C4008.m12876(this.f11555.f10443, 0.0f, 100, null);
        C4008.m12876(this.f11555.f10442, 0.0f, 100, null);
        C4008.m12876(this.f11555.f10411, 0.0f, 100, null);
        C4008.m12876(this.f11555.f10410, 0.0f, 100, null);
        float f2 = i2;
        C4008.m12886(this.f11555.f10441, -this.f11568, f2, 100, null);
        C4008.m12876(this.f11555.f10441, 0.0f, 100, null);
        C4008.m12886(this.f11555.f10439, -this.f11568, f2, 100, null);
        C4008.m12876(this.f11555.f10439, 0.0f, 100, null);
        float f3 = (m11122() || !this.f11556.mo1261()) ? this.f11616 : 0;
        C4008.m12886(this.f11555.f10373, -this.f11560, f3, 100, null);
        C4008.m12886(this.f11555.f10374, -this.f11560, f3, 100, null);
        C4008.m12886(this.f11555.f10378, -this.f11560, f3, 100, null);
        C4008.m12886(this.f11555.f10377, -this.f11560, f3, 100, null);
        C4008.m12886(this.f11555.f10386, -this.f11561, f3, 100, null);
        C4008.m12886(this.f11555.f10402, -this.f11561, f3, 100, null);
        C4008.m12886(this.f11555.f10437, -this.f11561, f3, 100, null);
        C4008.m12886(this.f11555.f10387, -this.f11561, f3, 100, null);
        C4008.m12886(this.f11555.f10399, -this.f11561, f3, 100, null);
        C4008.m12876(this.f11555.f10445, 0.0f, 100, null);
        C4008.m12886(this.f11555.f10372, this.f11569, f3, 100, new C3387());
    }

    /* renamed from: Γ, reason: contains not printable characters */
    public final void m11136(boolean z) {
        this.f11555.f10373.setEnabled(true);
        float f = z ? -this.f11555.f10340.getAudioSettingHeight() : this.f11556.mo1261() ? 0 : this.f11616;
        C4008.m12886(this.f11555.f10374, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10373, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
    }

    /* renamed from: Ι, reason: contains not printable characters */
    public final void m11137(int i) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10412.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10412.setLayoutParams(layoutParams);
        this.f11555.f10412.setPadding(this.f11580);
        this.f11555.f10412.m2457(new C3405());
        this.f11555.f10412.m2450(0, null);
    }

    /* renamed from: ι, reason: contains not printable characters */
    public final void m11138(int i) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10432.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10432.setLayoutParams(layoutParams);
        this.f11555.f10432.setPadding(this.f11580);
        this.f11555.f10432.m3441();
        this.f11555.f10432.setOnExposureChange(new C3296());
        this.f11555.f10407.m3291(0, null);
    }

    /* renamed from: Г, reason: contains not printable characters */
    public final void m11139() {
        SensorManager sensorManager = this.f11576;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.f11577);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: г, reason: contains not printable characters */
    public final void m11140() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10424.getLayoutParams();
        int iM14460 = C4792.m14375().m14460() - 10;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = iM14460;
        this.f11583 = iM14460 + C2579.m9438(44.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = C4792.m14375().m14459();
        this.f11555.f10423.getLayoutParams().width = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        int iM14420 = C4792.m14375().m14420();
        int iM14464 = C4792.m14375().m14464();
        this.f11555.f10424.m2845(iM14420, 0, 0, 0);
        this.f11555.f10424.setPadding(0, 10, iM14464, 10);
        this.f11555.f10424.setTopTextContent(m15086(R.string.RECORDING_INFO_RES));
        this.f11555.f10424.setBottomTextContent("N/A");
        this.f11555.f10424.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f11555.f10424));
        this.f11555.f10424.setOnUnQuickClickListener(new C3342());
        this.f11555.f10367.getLayoutParams().width = this.f11555.f10368.getLayoutParams().width;
        this.f11555.f10368.m2845(iM14420, 0, 0, 0);
        this.f11555.f10368.setPadding(0, 10, iM14464, 10);
        this.f11555.f10368.setTopTextContent(m15086(R.string.RECORDING_INFO_FPS));
        this.f11555.f10368.setBottomTextContent("N/A");
        this.f11555.f10368.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f11555.f10368));
        this.f11555.f10368.setOnUnQuickClickListener(new C3344());
        ViewGroup.LayoutParams layoutParams2 = this.f11555.f10431.getLayoutParams();
        C4792.m14375().m14500();
        layoutParams2.width = C4792.m14375().m14475();
        this.f11555.f10430.getLayoutParams().width = layoutParams2.width;
        this.f11555.f10431.m2845(iM14420, 0, 0, 0);
        this.f11555.f10431.setPadding(0, 10, iM14464, 10);
        this.f11555.f10431.setTopTextContent(m15086(R.string.RECORDING_INFO_SHUTTER));
        mo10618();
        this.f11555.f10431.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f11555.f10431));
        this.f11555.f10431.setOnUnQuickClickListener(new C3346());
        ViewGroup.LayoutParams layoutParams3 = this.f11555.f10405.getLayoutParams();
        layoutParams3.width = C4792.m14375().m14436();
        this.f11555.f10404.getLayoutParams().width = layoutParams3.width;
        this.f11555.f10405.m2845(iM14420, 0, 0, 0);
        this.f11555.f10405.setPadding(0, 10, iM14464, 10);
        this.f11555.f10405.setTopTextContent(m15086(R.string.RECORDING_INFO_ISO));
        mo10606();
        DoubleTextLayout doubleTextLayout = this.f11555.f10405;
        doubleTextLayout.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(doubleTextLayout));
        this.f11555.f10405.setOnUnQuickClickListener(new C3348());
        ViewGroup.LayoutParams layoutParams4 = this.f11555.f10443.getLayoutParams();
        layoutParams4.width = C4792.m14375().m14487();
        this.f11555.f10442.getLayoutParams().width = layoutParams4.width;
        this.f11555.f10443.m2845(iM14420, 0, 0, 0);
        this.f11555.f10443.setPadding(0, 10, iM14464, 10);
        this.f11555.f10443.setTopTextContent(m15086(R.string.RECORDING_INFO_WB));
        float fM12469 = C4535.m13880().m13890().m12469();
        this.f11555.f10443.setBottomTextContent(Math.round(fM12469) + "K");
        this.f11555.f10443.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f11555.f10443));
        this.f11555.f10443.setOnUnQuickClickListener(new C3350());
        this.f11555.f10410.getLayoutParams().width = this.f11555.f10411.getLayoutParams().width;
        this.f11555.f10411.m2845(iM14420, 0, 0, 0);
        this.f11555.f10411.setPadding(0, 10, iM14464, 10);
        this.f11555.f10411.setTopTextContent(m15086(R.string.RECORDING_INFO_LENS));
        this.f11555.f10411.setCameraLensName(C2520.m9312().m9314());
        this.f11555.f10411.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f11555.f10411));
        this.f11555.f10411.setOnUnQuickClickListener(new C3352());
    }

    /* renamed from: і, reason: contains not printable characters */
    public final void m11141(int i, int i2) {
        int iM14432 = C4792.m14375().m14432();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10386.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = C2579.m9438(this.f17096 * 50.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = iM14432;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) (((i2 + ((((i - ((int) this.f11555.f10392.getLayoutWidth())) / 2) - i2) / 2)) - (((ViewGroup.MarginLayoutParams) layoutParams).width / 2)) + (C4792.f16138 / 2.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) (this.f11574 + ((this.f11575 - C4792.m14375().m14476(63)) / 2.0f));
        this.f11555.f10386.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f11555.f10387.getLayoutParams();
        layoutParams2.width = C2579.m9438(44.0f);
        layoutParams2.height = C2579.m9438(44.0f);
        this.f11555.f10387.setLayoutParams(layoutParams2);
        this.f11555.f10402.m4177(0, C4792.m14375().m14396(), FilmApp.m403(), C4792.m14375().m14391());
        this.f11555.f10402.m4175(R.drawable.icon_15_monitor_cloud_stroke15_monitor_cloud_stroke, R.drawable.icon_15_monitor_cloud);
        this.f11555.f10402.m4176(C4792.m14375().m14476(36), C4792.m14375().m14476(36));
        this.f11555.f10399.m2562(0, (int) ((C4792.m14375().m14378() * this.f17096) + 0.5f));
        this.f11555.f10399.setContentTypeFace(FilmApp.m403());
        TextPaint paint = this.f11555.f10399.getPaint();
        float f = paint.getFontMetrics().bottom;
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f11555.f10399.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin - 3;
        float f2 = iM14432;
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = (int) (((((ViewGroup.MarginLayoutParams) layoutParams).width - iM14432) / 2.0f) + f2 + C4792.m14375().m14480(5.0f, this.f17096));
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (paint.measureText(ExifInterface.LONGITUDE_WEST) + C4792.f16138);
        this.f11555.f10399.setLayoutParams(layoutParams3);
        this.f11555.f10399.m2560((int) C4792.f16138, 0, 0, 0);
        this.f11555.f10437.setLayoutParams((ConstraintLayout.LayoutParams) this.f11555.f10437.getLayoutParams());
        this.f11555.f10386.m4170(f2, f2);
        m11102(C2618.m9566("transmit_is_first_int", 0) <= 1);
        int i3 = !"Wi-Fi".equals(C3688.m11833(FilmApp.m402())) ? 1 : 0;
        if (!TransmitHelper.getInstance().isStartCameraTransmit()) {
            i3 = 0;
        }
        this.f11555.f10386.m4159(i3);
        m11170(false, 0, "", 5);
        ACHelper.getInstance().onCheck265Done(new C3326());
        this.f11555.f10387.setOnTouchListener(new ViewOnTouchListenerC3328());
        this.f11555.f10387.setOnClickListener(new ViewOnClickListenerC3330());
    }

    /* renamed from: ї, reason: contains not printable characters */
    public boolean m11142() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return false;
        }
        return abstractC2853.f10382.m2353();
    }

    /* renamed from: ӏ, reason: contains not printable characters */
    public final void m11143(int i) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10416.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = C2579.f9597;
        this.f11555.f10416.setLayoutParams(layoutParams);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ԩ */
    public boolean mo10470() {
        AbstractC2853 abstractC2853 = this.f11555;
        return (abstractC2853 == null || abstractC2853.f10355.getVisibility() != 0 || this.f11555.f10354.getVisibility() == 0) ? false : true;
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ԩ */
    public void mo10471(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3314(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ԫ */
    public void mo10472() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        if (!abstractC2853.f10355.m3152()) {
            C4202.m13274().m13277(1.0f, 0.5f, 300, new C3377());
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new C3375());
        valueAnimatorOfInt.addListener(new C3376());
        valueAnimatorOfInt.start();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ԫ */
    public void mo10473(float f, float f2) {
        this.f11555.f10366.m3257(f, f2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ԭ */
    public void mo10474(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        int currentChoosePos = abstractC2853.f10369.getCurrentChoosePos();
        if (z) {
            if (currentChoosePos > 0) {
                this.f11555.f10369.m2266(currentChoosePos - 1);
                return;
            }
            return;
        }
        if (currentChoosePos < this.f11555.f10369.getFpsSize() - 1) {
            this.f11555.f10369.m2266(currentChoosePos + 1);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ԭ */
    public void mo10475(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10405.m2842(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ԯ */
    public void mo10476(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10417.setAlpha(z ? 1.0f : 0.2f);
        this.f11555.f10418.setEnabled(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ԯ */
    public void mo10477(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        int currentChoosePos = abstractC2853.f10425.getCurrentChoosePos();
        if (z) {
            if (currentChoosePos > 0) {
                this.f11555.f10425.m2522(currentChoosePos - 1);
                return;
            }
            return;
        }
        if (currentChoosePos < this.f11555.f10425.getResSize() - 1) {
            this.f11555.f10425.m2522(currentChoosePos + 1);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ՠ */
    public void mo10478(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10429.setEnabled(z);
    }

    /* renamed from: ւ, reason: contains not printable characters */
    public final void m11144() {
        int iM14461 = C4792.m14375().m14461();
        if (iM14461 == 0) {
            float fM14462 = C4792.m14375().m14462();
            float f = this.f17096;
            int i = (int) (fM14462 * f);
            int iM9438 = (int) ((this.f11601 * this.f11582 * f) + C2579.m9438(1.0f) + ((((int) ((this.f11599 * this.f11582) * this.f17096)) - i) / 2));
            int iM14476 = C4792.m14375().m14476(70);
            iM14461 = (int) (((C2579.f9597 - (((int) (iM9438 + ((i - iM14476) / 2.0f))) * 2)) - (iM14476 * 2)) / 3.0f);
            C4792.m14375().m14510(iM14461);
        }
        if (C2579.m9451(getActivity())) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10395.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = C2579.f9594;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (((this.f11579 - C2579.m9440(getContext())) / 2.0f) - 0);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.f11555.f10426);
            constraintSet.connect(this.f11555.f10395.getId(), 4, 0, 4);
            constraintSet.applyTo(this.f11555.f10426);
            this.f11555.f10395.setLayoutParams(layoutParams);
            int iM144762 = (int) (C4792.m14375().m14476(70) * 1.0f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f11555.f10388.getLayoutParams();
            layoutParams2.width = iM144762;
            layoutParams2.height = iM144762;
            layoutParams2.leftMargin = (int) (((C2579.m9444() - (iM144762 * 4)) - (iM14461 * 3)) / 2.0f);
            layoutParams2.addRule(9);
            layoutParams2.addRule(15);
            layoutParams2.removeRule(10);
            this.f11555.f10388.setLayoutParams(layoutParams2);
            int iM94382 = (int) ((C2579.m9438(44.0f) - layoutParams2.width) / 2.0f);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f11555.f10389.getLayoutParams();
            layoutParams3.leftMargin = layoutParams2.leftMargin - iM94382;
            int iM94383 = C2579.m9438(44.0f);
            layoutParams3.width = iM94383;
            layoutParams3.height = iM94383;
            layoutParams3.addRule(9);
            layoutParams3.addRule(15);
            layoutParams3.removeRule(10);
            this.f11555.f10389.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f11555.f10390.getLayoutParams();
            layoutParams4.width = layoutParams2.width;
            layoutParams4.height = layoutParams2.height;
            C2579.m9439(getContext());
            layoutParams4.leftMargin = layoutParams2.leftMargin + layoutParams2.width + iM14461;
            layoutParams4.addRule(9);
            layoutParams4.addRule(15);
            layoutParams4.removeRule(12);
            this.f11555.f10390.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f11555.f10391.getLayoutParams();
            layoutParams5.leftMargin = layoutParams4.leftMargin - iM94382;
            layoutParams5.width = layoutParams3.width;
            layoutParams5.height = layoutParams3.height;
            layoutParams5.addRule(9);
            layoutParams5.addRule(15);
            layoutParams5.removeRule(12);
            this.f11555.f10391.setLayoutParams(layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f11555.f10381.getLayoutParams();
            layoutParams6.width = layoutParams2.width;
            layoutParams6.height = layoutParams2.height;
            layoutParams6.rightMargin = layoutParams4.leftMargin;
            layoutParams6.addRule(11);
            layoutParams6.addRule(15);
            layoutParams6.removeRule(10);
            this.f11555.f10381.setLayoutParams(layoutParams6);
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f11555.f10403.getLayoutParams();
            layoutParams7.rightMargin = layoutParams6.rightMargin - iM94382;
            layoutParams7.width = layoutParams3.width;
            layoutParams7.height = layoutParams3.height;
            layoutParams7.addRule(11);
            layoutParams7.addRule(15);
            layoutParams7.removeRule(10);
            this.f11555.f10403.setLayoutParams(layoutParams7);
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f11555.f10380.getLayoutParams();
            layoutParams8.width = layoutParams2.width;
            layoutParams8.height = layoutParams2.height;
            layoutParams8.rightMargin = layoutParams2.leftMargin;
            layoutParams8.addRule(11);
            layoutParams8.addRule(15);
            layoutParams8.removeRule(12);
            this.f11555.f10380.setLayoutParams(layoutParams8);
            RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f11555.f10385.getLayoutParams();
            layoutParams9.rightMargin = layoutParams8.rightMargin - iM94382;
            layoutParams9.width = layoutParams3.width;
            layoutParams9.height = layoutParams3.height;
            layoutParams9.addRule(11);
            layoutParams9.addRule(15);
            layoutParams9.removeRule(12);
            this.f11555.f10385.setLayoutParams(layoutParams9);
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f11555.f10396.getLayoutParams();
            layoutParams10.width = iM144762;
            layoutParams10.height = iM144762;
            layoutParams10.rightMargin = layoutParams2.leftMargin;
            layoutParams10.addRule(11);
            layoutParams10.addRule(15);
            layoutParams10.removeRule(12);
            this.f11555.f10396.setLayoutParams(layoutParams10);
            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.f11555.f10397.getLayoutParams();
            layoutParams11.rightMargin = (int) (layoutParams10.rightMargin - ((C2579.m9438(44.0f) - layoutParams10.width) / 2.0f));
            layoutParams11.width = layoutParams3.width;
            layoutParams11.height = layoutParams3.height;
            layoutParams11.addRule(11);
            layoutParams11.addRule(15);
            layoutParams11.removeRule(12);
            this.f11555.f10397.setLayoutParams(layoutParams11);
        } else {
            this.f11555.f10397.setEnabled(true);
            ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f11555.f10395.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams12).width = (int) ((this.f11578 - C2579.m9439(getContext())) / 2.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams12).height = C2579.m9440(getActivity());
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.clone(this.f11555.f10426);
            constraintSet2.connect(this.f11555.f10395.getId(), 2, 0, 2);
            constraintSet2.applyTo(this.f11555.f10426);
            this.f11555.f10395.setLayoutParams(layoutParams12);
            RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.f11555.f10388.getLayoutParams();
            layoutParams13.width = C4792.m14375().m14476(70);
            layoutParams13.height = C4792.m14375().m14476(70);
            int iM14462 = (int) (C4792.m14375().m14462() * this.f17096);
            layoutParams13.topMargin = (int) (((int) ((this.f11601 * this.f11582 * r6) + C2579.m9438(1.0f) + ((((int) ((this.f11599 * this.f11582) * this.f17096)) - iM14462) / 2))) + ((iM14462 - layoutParams13.height) / 2.0f));
            this.f11555.f10388.setLayoutParams(layoutParams13);
            int iM94384 = (int) ((C2579.m9438(44.0f) - layoutParams13.height) / 2.0f);
            RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) this.f11555.f10389.getLayoutParams();
            layoutParams14.topMargin = layoutParams13.topMargin - iM94384;
            int iM94385 = C2579.m9438(44.0f);
            layoutParams14.width = iM94385;
            layoutParams14.height = iM94385;
            this.f11555.f10389.setLayoutParams(layoutParams14);
            RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) this.f11555.f10390.getLayoutParams();
            layoutParams15.width = layoutParams13.width;
            layoutParams15.height = layoutParams13.height;
            layoutParams15.bottomMargin = (int) ((C2579.f9597 / 2.0f) + (((r8 - (layoutParams13.topMargin * 2)) - (layoutParams13.height * 2)) / 6.0f));
            this.f11555.f10390.setLayoutParams(layoutParams15);
            RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.f11555.f10391.getLayoutParams();
            layoutParams16.bottomMargin = layoutParams15.bottomMargin - iM94384;
            layoutParams16.width = layoutParams14.width;
            layoutParams16.height = layoutParams14.height;
            this.f11555.f10391.setLayoutParams(layoutParams16);
            RelativeLayout.LayoutParams layoutParams17 = (RelativeLayout.LayoutParams) this.f11555.f10381.getLayoutParams();
            layoutParams17.width = layoutParams13.width;
            layoutParams17.height = layoutParams13.height;
            layoutParams17.topMargin = layoutParams16.bottomMargin;
            this.f11555.f10381.setLayoutParams(layoutParams17);
            RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) this.f11555.f10403.getLayoutParams();
            layoutParams18.topMargin = layoutParams17.topMargin - iM94384;
            layoutParams18.width = layoutParams14.width;
            layoutParams18.height = layoutParams14.height;
            this.f11555.f10403.setLayoutParams(layoutParams18);
            RelativeLayout.LayoutParams layoutParams19 = (RelativeLayout.LayoutParams) this.f11555.f10380.getLayoutParams();
            layoutParams19.width = layoutParams13.width;
            layoutParams19.height = layoutParams13.height;
            layoutParams19.bottomMargin = layoutParams13.topMargin;
            this.f11555.f10380.setLayoutParams(layoutParams19);
            RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) this.f11555.f10385.getLayoutParams();
            layoutParams20.bottomMargin = layoutParams19.bottomMargin - iM94384;
            layoutParams20.width = layoutParams14.width;
            layoutParams20.height = layoutParams14.height;
            this.f11555.f10385.setLayoutParams(layoutParams20);
            RelativeLayout.LayoutParams layoutParams21 = (RelativeLayout.LayoutParams) this.f11555.f10396.getLayoutParams();
            layoutParams21.width = C4792.m14375().m14476(70);
            layoutParams21.height = C4792.m14375().m14476(70);
            layoutParams21.bottomMargin = (int) (layoutParams13.topMargin + ((layoutParams13.height - r2) / 2.0f));
            this.f11555.f10396.setLayoutParams(layoutParams21);
            RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) this.f11555.f10397.getLayoutParams();
            layoutParams22.bottomMargin = (int) (layoutParams21.bottomMargin - ((C2579.m9438(44.0f) - layoutParams21.height) / 2.0f));
            layoutParams22.width = layoutParams14.width;
            layoutParams22.height = layoutParams14.height;
            this.f11555.f10397.setLayoutParams(layoutParams22);
        }
        AbstractC2853 abstractC2853 = this.f11555;
        abstractC2853.f10397.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC2853.f10396));
        this.f11555.f10397.setOnClickListener(new ViewOnClickListenerC3370());
        this.f11555.f10389.setOnClickListener(new ViewOnClickListenerC3371());
        this.f11555.f10391.setOnClickListener(new ViewOnClickListenerC3372());
        this.f11555.f10403.setOnClickListener(new ViewOnClickListenerC3373());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ֈ */
    public void mo10480(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10431.m2842(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ֏ */
    public void mo10481(int i, int i2, int i3) {
        if (this.f11555 == null) {
            return;
        }
        String strM9060 = C2462.m9035().m9060(i2);
        String strM90602 = C2462.m9035().m9060(i3);
        this.f11555.f10401.setText(strM9060);
        this.f11555.f10400.setText(strM90602);
        TextPaint paint = this.f11555.f10401.getPaint();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10401.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(strM9060) + C4792.f16138);
        this.f11555.f10401.setLayoutParams(layoutParams);
        TextPaint paint2 = this.f11555.f10400.getPaint();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f11555.f10400.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (paint2.measureText(strM90602) + C4792.f16138);
        this.f11555.f10400.setLayoutParams(layoutParams2);
        if (i != 0) {
            C4008.m12877(this.f11555.f10400, 0.0f, i, null);
            C4008.m12877(this.f11555.f10401, 1.0f, i, new C3366(strM9060, layoutParams2, paint2));
            return;
        }
        this.f11555.f10400.setText(strM9060);
        this.f11555.f10400.setAlpha(1.0f);
        this.f11555.f10401.setAlpha(0.0f);
        this.f11555.f10401.setText("");
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (paint2.measureText(strM9060) + C4792.f16138);
        this.f11555.f10400.setLayoutParams(layoutParams2);
    }

    /* renamed from: ו, reason: contains not printable characters */
    public final void m11145() {
        this.f11555.f10400.m2562(0, C4792.m14375().m14398());
        this.f11555.f10401.m2562(0, C4792.m14375().m14398());
        this.f11555.f10400.setContentTextColor(-1);
        this.f11555.f10401.setContentTextColor(-1);
        this.f11555.f10400.setContentTypeFace(FilmApp.m403());
        this.f11555.f10401.setContentTypeFace(FilmApp.m403());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10400.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (C4792.m14375().m14476(4) * this.f17096);
        Paint.FontMetrics fontMetrics = this.f11555.f10400.getPaint().getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((fontMetrics.bottom - fontMetrics.top) + 10.0f);
        this.f11555.f10400.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f11555.f10401.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) (C4792.m14375().m14476(4) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((ViewGroup.MarginLayoutParams) layoutParams).height;
        this.f11555.f10401.setLayoutParams(layoutParams2);
    }

    /* renamed from: ז, reason: contains not printable characters */
    public final void m11146(int i) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10444.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10444.setLayoutParams(layoutParams);
        this.f11555.f10444.setPadding(this.f11580);
        this.f11555.f10444.m2731(new C3403());
        this.f11555.f10444.m2719(0, null);
    }

    /* renamed from: י, reason: contains not printable characters */
    public void m11147(int i, AbstractC4012 abstractC4012) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10382.m2349(i, abstractC4012);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ׯ */
    public void mo10485(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10443.m2842(z);
    }

    /* renamed from: ײ, reason: contains not printable characters */
    public void m11148(boolean z) {
        if (this.f11556 != null) {
            if (z) {
                this.f11555.f10342.setImageResource(R.drawable.icon_60_beauty_on);
            } else {
                this.f11555.f10342.setImageResource(R.drawable.icon_60_beauty_default);
            }
            this.f11555.f10342.setAlpha(this.f11556.mo1292() ? 1.0f : 0.2f);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ؠ */
    public int mo10487() {
        if (this.f11555.f10425.m2521()) {
            return 1;
        }
        if (this.f11555.f10369.m2265()) {
            return 2;
        }
        if (this.f11555.f10432.m3433()) {
            return 3;
        }
        if (this.f11555.f10407.m3295()) {
            return 4;
        }
        if (this.f11555.f10444.m2722()) {
            return 5;
        }
        if (this.f11555.f10412.m2452()) {
            return 6;
        }
        if (this.f11555.f10414.m3770()) {
            return 7;
        }
        if (this.f11555.f10340.m2170()) {
            return 8;
        }
        if (m11142()) {
            return 9;
        }
        if (this.f11555.f10446.m2748()) {
            return 10;
        }
        return this.f11555.f10344.m2813() ? 11 : 0;
    }

    /* renamed from: ء, reason: contains not printable characters */
    public final void m11149() {
        this.f11555.f10414.m3764(100, new C3394());
    }

    /* renamed from: آ, reason: contains not printable characters */
    public final void m11150(int i, int i2) throws JSONException {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10340.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10340.setLayoutParams(layoutParams);
        this.f11555.f10340.m2173();
        this.f11555.f10340.setPadding(this.f11580);
        this.f11555.f10340.setAudioChangeListener(new C3380());
    }

    /* renamed from: أ, reason: contains not printable characters */
    public final void m11151(int i, int i2) {
        int iM14476 = C4792.m14375().m14476(50);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11555.f10341.getLayoutParams();
        int iM144762 = (int) (C4792.m14375().m14476((C4792.m14375().m14488() * 2) + 620) * this.f17096);
        int i3 = (int) (((iM144762 + (iM144762 % 2)) * 1.2f) + 0.5f);
        layoutParams.width = i3;
        layoutParams.height = i3;
        layoutParams.leftMargin = ((int) (C4792.m14375().m14476(70) * 1.2f * this.f17096)) + iM14476;
        this.f11555.f10341.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f11555.f10358.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = this.f11579;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((int) (C4792.m14375().m14476(C4792.m14375().m14488() + 262) * this.f17096 * 1.3f)) + iM14476 + i2;
        this.f11555.f10358.setLayoutParams(layoutParams2);
        this.f11608 = (int) (((ViewGroup.MarginLayoutParams) layoutParams2).width - ((C4792.m14375().m14488() * 2) * this.f17096));
        this.f11555.f10341.setOnValueChange(new C3354());
        this.f11555.f10341.setCardWidth(((ViewGroup.MarginLayoutParams) layoutParams2).width);
        this.f11555.f10341.m3222(((ViewGroup.MarginLayoutParams) layoutParams2).width - layoutParams.leftMargin, (C2579.f9594 - i) / 2, (int) (this.f11598 * this.f11582 * this.f17096));
        this.f11555.f10341.setNeedCheckMag(true);
        this.f11555.f10341.m3224();
        if (this.f11556.mo1270()) {
            this.f11555.f10341.m3213(0);
        } else {
            this.f11555.f10341.m3226(0);
        }
        C4008.m12884(this.f11555.f10341, 1.3f, 1.3f, 0, null);
    }

    /* renamed from: ا, reason: contains not printable characters */
    public final void m11152() {
        this.f11555.f10412.m2450(100, new C3400());
    }

    /* renamed from: ـ, reason: contains not printable characters */
    public final void m11153() {
        this.f11555.f10425.m2519(100, new C3404());
    }

    /* renamed from: ٱ, reason: contains not printable characters */
    public final void m11154() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10342.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (C4792.m14375().m14403() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (C4792.m14375().m14403() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (C4792.m14375().m14418() + (((C4792.m14375().m14462() * this.f17096) - ((ViewGroup.MarginLayoutParams) layoutParams).width) / 2.0f));
        this.f11555.f10342.setLayoutParams(layoutParams);
        m11148(this.f11556.mo1296() && this.f11556.mo1293());
        this.f11555.f10343.setOnTouchListener(new ViewOnTouchListenerC3307());
        this.f11555.f10343.setOnClickListener(new ViewOnClickListenerC3323());
    }

    /* renamed from: ٲ, reason: contains not printable characters */
    public final void m11155(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10344.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10344.setLayoutParams(layoutParams);
        this.f11555.f10344.m2822();
        this.f11555.f10344.setPadding(this.f11580);
        this.f11555.f10344.setBeautyChangeCallBack(new C3358());
    }

    /* renamed from: ٵ, reason: contains not printable characters */
    public final void m11156(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10383.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f11555.f10383.setLayoutParams(layoutParams);
        m11169();
        m11125(i, i2);
        m11174(i3);
        mo10528();
        mo10560(this.f11556.mo1227());
        mo10573();
    }

    /* renamed from: ۥ, reason: contains not printable characters */
    public final void m11157() {
        this.f11555.f10369.m2263(100, new C3402());
    }

    /* renamed from: ۦ, reason: contains not printable characters */
    public final void m11158(int i) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10369.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10369.setLayoutParams(layoutParams);
        this.f11555.f10369.setPadding(this.f11580);
        this.f11555.f10369.m2274(new C3390());
        this.f11555.f10369.m2263(0, null);
    }

    /* renamed from: ܙ, reason: contains not printable characters */
    public void m11159(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10382.m2361(i);
    }

    /* renamed from: ݳ, reason: contains not printable characters */
    public final void m11160() {
        this.f11555.f10444.m2719(100, new C3401());
    }

    /* renamed from: ݴ, reason: contains not printable characters */
    public final void m11161() {
        this.f11555.f10432.m3427(100, new C3399());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ހ */
    public void mo10500() {
        this.f11555.f10366.m3256();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ށ */
    public void mo10501() {
        if (this.f11555 == null) {
            return;
        }
        String strM9060 = C2462.m9035().m9060(0);
        this.f11555.f10401.setText(strM9060);
        this.f11555.f10400.setText(strM9060);
        TextPaint paint = this.f11555.f10401.getPaint();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10401.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(strM9060) + C4792.f16138);
        this.f11555.f10401.setLayoutParams(layoutParams);
        TextPaint paint2 = this.f11555.f10400.getPaint();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f11555.f10400.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (paint2.measureText(strM9060) + C4792.f16138);
        this.f11555.f10400.setLayoutParams(layoutParams2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ނ */
    public void mo10502() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null && abstractC2853.f10355.isShown()) {
            this.f11555.f10355.m3149();
            mo10600();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ރ */
    public void mo10503() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null && abstractC2853.f10414.m3770()) {
            this.f11555.f10414.m3764(0, new C3365());
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ބ */
    public void mo10504(boolean z) {
        if (z) {
            this.f11555.f10406.m3334(true);
            this.f11555.f10366.m3279(false);
        } else {
            this.f11555.f10406.m3334(false);
            this.f11555.f10366.m3279(true);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޅ */
    public void mo10505() {
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ކ */
    public void mo10506(float f, boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10341.m3208(f, z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: އ */
    public void mo10507(int i, FocusZoomWheelView.InterfaceC1175 interfaceC1175) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10366.m3260(i, new C3363(interfaceC1175));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ވ */
    public void mo10508(boolean z, int i) {
        if (this.f11555 == null) {
            return;
        }
        float f = this.f11556.mo1261() ? 0.0f : -this.f11559;
        if (z) {
            C4008.m12886(this.f11555.f10428, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10429, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10408, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10364, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10362, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10363, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10342, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10343, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10427, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10415, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10417, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10418, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10413, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10400, -this.f11588, f, i, null);
            C4008.m12886(this.f11555.f10401, -this.f11588, f, i, null);
            return;
        }
        C4008.m12886(this.f11555.f10428, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10429, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10408, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10364, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10362, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10363, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10342, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10343, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10427, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10415, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10417, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10418, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10413, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10400, 0.0f, f, i, null);
        C4008.m12886(this.f11555.f10401, 0.0f, f, i, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: މ */
    public void mo10509() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10341.m3205();
        this.f11555.f10366.m3255();
        if (this.f11555.f10337.getCurrentState() != 0) {
            this.f11556.getHandler().removeMessages(200);
            this.f11555.f10337.m3191();
            this.f11555.f10337.m3190();
        }
        if (this.f11555.f10338.getCurrentState() != 0) {
            this.f11556.getHandler().removeMessages(200);
            this.f11555.f10338.m3191();
            this.f11555.f10338.m3190();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ފ */
    public void mo10510() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10366.m3280();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ދ */
    public float mo10511(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return 0.0f;
        }
        return abstractC2853.f10341.m3212(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ތ */
    public float mo10512(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return 0.0f;
        }
        return abstractC2853.f10341.m3209(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ލ */
    public RectF mo10513() {
        return this.f11615;
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ގ */
    public float mo10514() {
        return this.f11555.f10366.getCurrentFocusWheelDegree();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޏ */
    public int mo10515() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return 0;
        }
        return abstractC2853.f10414.getCurrentStylePos();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ސ */
    public float[] mo10516() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return null;
        }
        return abstractC2853.f10341.getFocalLengthAndZoomRatio();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޑ */
    public float mo10517() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return 0.0f;
        }
        return abstractC2853.f10383.getTargetCameraHeight();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޒ */
    public float mo10518() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return 0.0f;
        }
        return abstractC2853.f10383.getTargetCameraWidth();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޓ */
    public float mo10519(float f, float f2, float f3) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return 0.0f;
        }
        return abstractC2853.f10406.m3317(f, f2, f3);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޖ */
    public void mo10520(int i) {
        super.mo10520(i);
        if (this.f11572) {
            return;
        }
        if (i == 8 && Build.VERSION.SDK_INT >= 31 && !C2618.m9565("bluetooth_scan_connect_request_sp", false)) {
            C2618.m9570("bluetooth_scan_connect_request_sp", true);
            if (ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_SCAN") != 0 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                try {
                    m11115().m959();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
        this.f11572 = true;
        if (i != 0) {
            mo10525();
        }
        m11118(0);
        m11175(new RunnableC3383(i));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޗ */
    public void mo10521(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
        }
        switch (i) {
            case 1:
                m11153();
                break;
            case 2:
                m11157();
                break;
            case 3:
                m11161();
                break;
            case 4:
                m11127();
                break;
            case 5:
                m11160();
                break;
            case 6:
                m11152();
                break;
            case 7:
                abstractC2853.f10414.m3781();
                m11149();
                break;
            case 8:
                m11116();
                break;
            case 9:
                m11121();
                break;
            case 10:
                m11130();
                break;
            case 11:
                m11119();
                break;
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޘ */
    public void mo10522() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10371.setVisibility(8);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޙ */
    public void mo10523() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10366.m3265(100);
        this.f11555.f10406.m3319(100);
        this.f11555.f10337.m3188(100);
        this.f11555.f10338.m3188(100);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޚ */
    public void mo10524(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        C4008.m12876(abstractC2853.f10409, 0.0f, i, new C3389());
        C4008.m12876(this.f11555.f10421, 1.0f, i, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޛ */
    public void mo10525() {
        if (this.f11555.f10425.m2521()) {
            this.f11555.f10425.m2519(100, null);
            return;
        }
        if (this.f11555.f10369.m2265()) {
            this.f11555.f10369.m2263(100, null);
            return;
        }
        if (this.f11555.f10444.m2722()) {
            this.f11555.f10444.m2719(100, null);
            return;
        }
        if (this.f11555.f10412.m2452()) {
            this.f11555.f10412.m2450(100, null);
            return;
        }
        if (this.f11555.f10432.m3433()) {
            this.f11555.f10432.m3427(100, null);
            return;
        }
        if (this.f11555.f10407.m3295()) {
            this.f11555.f10407.m3291(100, null);
            return;
        }
        if (m11142()) {
            m11147(100, null);
            return;
        }
        if (this.f11555.f10446.m2748()) {
            this.f11555.f10446.m2746(100, null);
            return;
        }
        if (this.f11555.f10340.m2170()) {
            this.f11555.f10340.m2166(100, null);
        } else if (this.f11555.f10414.m3770()) {
            this.f11555.f10414.m3764(100, null);
        } else if (this.f11555.f10344.m2813()) {
            this.f11555.f10344.m2807(100, null);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޜ */
    public void mo10526(int i, int i2, int i3) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        if (i == -1) {
            i = this.f11589;
        }
        C4008.m12886(abstractC2853.f10375, i, i2, i3, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޝ */
    public void mo10527(float f, int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        C4008.m12876(abstractC2853.f10377, f, i, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޞ */
    public void mo10528() {
        if (this.f11555 == null) {
            return;
        }
        this.f11556.mo1232();
        C3891 c3891M13890 = C4535.m13880().m13890();
        this.f11555.f10383.m2416(this.f11556.mo1250(), this.f11556.mo1244(), false);
        this.f11555.f10383.m2418(c3891M13890.m12470() == 1);
        this.f11555.f10383.m2421((c3891M13890.m12464() * 1.0f) / 100.0f);
        this.f11555.f10383.m2419(c3891M13890.m12405() == 1);
        this.f11555.f10383.m2422(c3891M13890.m12444() ? 255 : C4792.m14375().m14413());
        HorizonCircleRectView.f2347 = false;
        this.f11555.f10384.m2441(this.f11556.mo1250(), this.f11556.mo1244(), false);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޟ */
    public void mo10529(long j, int i, boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10392.m2511(j, i, z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޠ */
    public boolean mo10530() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return false;
        }
        return abstractC2853.f10341.m3217();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޡ */
    public boolean mo10531() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return false;
        }
        return abstractC2853.f10366.m3270();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޢ */
    public void mo10532() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3335();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޣ */
    public void mo10533() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3332();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޤ */
    public void mo10534() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3327();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޥ */
    public void mo10535(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3328(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޱ */
    public void mo10536(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3331(f);
    }

    /* renamed from: ߊ, reason: contains not printable characters */
    public void m11162() throws JSONException {
        int i = C2579.f9594;
        this.f11578 = i;
        int i2 = C2579.f9593;
        this.f11579 = i2;
        if ((i * 1.0f) / i2 > 1.7777778f) {
            this.f11581 = true;
        }
        int iM9439 = C2579.m9439(getActivity());
        int iM9440 = C2579.m9440(getActivity());
        this.f17096 = C4792.m14375().m14434();
        this.f11582 = C4792.m14375().m14455(1125.0f);
        int i3 = this.f11578;
        if (iM9439 > i3) {
            iM9440 = (((int) ((i3 * 9.0f) / 16.0f)) >> 1) << 1;
            iM9439 = i3;
        }
        ViewGroup.LayoutParams layoutParams = this.f11555.f10379.getLayoutParams();
        layoutParams.width = iM9439;
        layoutParams.height = iM9440;
        this.f11555.f10379.setLayoutParams(layoutParams);
        this.f11570 = (this.f11578 - C2579.f9598) / 2;
        this.f11571 = (this.f11579 - C2579.f9597) / 2;
        ViewGroup.LayoutParams layoutParams2 = this.f11555.f10426.getLayoutParams();
        layoutParams2.width = C2579.f9594;
        layoutParams2.height = C2579.f9593;
        this.f11555.f10426.setLayoutParams(layoutParams2);
        m11110(this.f11570, this.f11571);
        int i4 = C2579.f9594;
        this.f11580 = (int) ((i4 - C2579.f9598) / 2.0f);
        m11143(i4);
        m11156(iM9439, iM9440, i4);
        if (m11117()) {
            this.f11555.f10395.setVisibility(0);
            m11144();
            mo10576();
        } else {
            this.f11555.f10395.setVisibility(8);
        }
        m11124(iM9440, iM9439);
        m11151(iM9439, (this.f11578 - iM9439) / 2);
        m11140();
        m11105();
        this.f11555.f10339.setOnClickListener(new ViewOnClickListenerC3306());
        m11103();
        m11145();
        if (this.f11581) {
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f11555.f10365.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (C4792.m14375().m14427() * this.f17096);
            ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) (C4792.m14375().m14425() * this.f17096);
            ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = (int) (C4792.m14375().m14426() * this.f17096);
            this.f11555.f10365.setLayoutParams(layoutParams3);
        }
        m11135(iM9439, iM9440);
        m11099();
        m11109(iM9439, (this.f11578 - iM9439) / 2);
        m11100((this.f11578 - iM9439) / 2);
        m11128(i4);
        m11158(i4);
        m11101(i4);
        m11138(i4);
        m11137(i4);
        m11146(i4);
        m11166(i4);
        m11150(i4, iM9440);
        m11104(i4, iM9440);
        m11155(i4, iM9440);
        m11106();
        if (this.f11556.mo1270()) {
            mo10526(this.f11589, 0, 100);
            mo10508(false, 0);
        } else {
            mo10526(0, 0, 100);
            mo10508(true, 0);
        }
    }

    /* renamed from: ߴ, reason: contains not printable characters */
    public void m11163(boolean z) {
    }

    /* renamed from: ߵ, reason: contains not printable characters */
    public void m11164(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        m11113(abstractC2853.f10381, abstractC2853.f10403, z);
    }

    /* renamed from: ߺ, reason: contains not printable characters */
    public void m11165(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        m11113(abstractC2853.f10388, abstractC2853.f10389, z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ߾ */
    public void mo10541() {
        if (this.f11555 == null) {
            return;
        }
        if (this.f11556.mo1302() || this.f11556.mo1297()) {
            this.f11555.f10366.setAlpha(1.0f);
            this.f11555.f10356.setAlpha(1.0f);
            this.f11555.f10357.setAlpha(1.0f);
        } else {
            this.f11555.f10366.setAlpha(0.0f);
            this.f11555.f10356.setAlpha(0.0f);
            this.f11555.f10357.setAlpha(0.0f);
        }
        if ((this.f11556.mo1211() && this.f11556.mo1247()) || this.f11556.mo1294()) {
            this.f11555.f10406.setAlpha(1.0f);
        } else {
            this.f11555.f10406.setAlpha(0.0f);
        }
        this.f11555.f10406.setShutterWheelEnable(this.f11556.mo1247());
        this.f11555.f10406.setEtWheelEnable(this.f11556.mo1294());
        this.f11555.f10406.setIsoWheelEnable(this.f11556.mo1211());
        this.f11555.f10406.setIconEnable(this.f11556.mo1211() || this.f11556.mo1247());
        this.f11555.f10407.setIsoViewEnable(this.f11556.mo1211());
        this.f11555.f10432.setShutterViewEnable(this.f11556.mo1247());
        this.f11555.f10366.setFocusEnable(this.f11556.mo1297());
        this.f11555.f10366.setZoomEnable(this.f11556.mo1302());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ߿ */
    public void mo10542(int i, boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        View view = null;
        switch (i) {
            case 0:
                view = abstractC2853.f10422;
                break;
            case 1:
                view = abstractC2853.f10435;
                break;
            case 2:
                view = abstractC2853.f10419;
                break;
            case 3:
                view = abstractC2853.f10403;
                break;
            case 5:
                view = abstractC2853.f10429;
                break;
            case 6:
                view = abstractC2853.f10418;
                break;
            case 7:
                view = abstractC2853.f10368;
                break;
            case 8:
                view = abstractC2853.f10424;
                break;
            case 9:
                abstractC2853.f10406.m3324();
                return;
        }
        if (view != null) {
            if (!z || view.isEnabled()) {
                view.performClick();
            }
        }
    }

    /* renamed from: ࡅ, reason: contains not printable characters */
    public final void m11166(int i) {
        int iM12375 = C4535.m13880().m13890().m12375();
        ArrayList<C4351> arrayListM11226 = C3444.m11226();
        Iterator<C4351> it = arrayListM11226.iterator();
        while (it.hasNext()) {
            it.next().m13507(false);
        }
        if (iM12375 >= 0 && iM12375 < arrayListM11226.size()) {
            arrayListM11226.get(iM12375).m13507(true);
        }
        this.f11556.mo1209(iM12375);
        ViewGroup.LayoutParams layoutParams = this.f11555.f10446.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10446.setLayoutParams(layoutParams);
        this.f11555.f10446.setPadding(this.f11580);
        this.f11555.f10446.m2751(new C3392());
        this.f11555.f10446.m2746(0, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡠ */
    public void mo10544() throws JSONException {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10340.m2173();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡡ */
    public void mo10545() throws JSONException {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10340.m2172();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡢ */
    public void mo10546() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10341.m3218();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡣ */
    public void mo10547() {
        if (this.f11555 == null) {
            return;
        }
        m11148(this.f11556.mo1296() && this.f11556.mo1293());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡤ */
    public void mo10548(boolean z) {
        float f;
        int i;
        if (this.f11555 == null) {
            return;
        }
        boolean zM12444 = C4535.m13880().m13890().m12444();
        float targetCameraWidth = this.f11555.f10383.getTargetCameraWidth();
        float targetCameraHeight = this.f11555.f10383.getTargetCameraHeight();
        if (zM12444) {
            f = this.f11578 - (targetCameraWidth * 2.0f);
            i = this.f11579;
        } else {
            f = -this.f11578;
            i = this.f11579;
        }
        float f2 = i - (targetCameraHeight * 2.0f);
        if (f > 0.0f || this.f11555.f10346.getAlpha() != 0.0f) {
            boolean z2 = f > 0.0f;
            C4008.m12876(this.f11555.f10346, z2 ? 1.0f : 0.0f, 200, null);
            C4008.m12876(this.f11555.f10347, z2 ? 1.0f : 0.0f, 200, null);
            C4008.m12880(0.0f, 1.0f, z ? 200L : 0L, new C3367(f));
        } else {
            this.f11596 = 0;
            ViewGroup.LayoutParams layoutParams = this.f11555.f10346.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.height = 0;
            this.f11555.f10346.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f11555.f10347.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            this.f11555.f10347.setLayoutParams(layoutParams2);
        }
        if (f2 > 0.0f || this.f11555.f10348.getAlpha() != 0.0f) {
            boolean z3 = f2 > 0.0f;
            C4008.m12876(this.f11555.f10348, z3 ? 1.0f : 0.0f, 200, null);
            C4008.m12876(this.f11555.f10345, z3 ? 1.0f : 0.0f, 200, null);
            C4008.m12880(0.0f, 1.0f, z ? 200L : 0L, new C3368(f2));
            return;
        }
        this.f11597 = 0;
        ViewGroup.LayoutParams layoutParams3 = this.f11555.f10348.getLayoutParams();
        layoutParams3.width = 0;
        layoutParams3.height = 0;
        this.f11555.f10348.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f11555.f10345.getLayoutParams();
        layoutParams4.width = layoutParams3.width;
        layoutParams4.height = layoutParams3.height;
        this.f11555.f10345.setLayoutParams(layoutParams4);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡥ */
    public void mo10549(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10364.setVisibility(8);
        if (i == 1) {
            this.f11555.f10363.setEnabled(true);
            this.f11555.f10362.setAlpha(0.2f);
            mo10567(false);
        } else {
            this.f11555.f10363.setEnabled(true);
            this.f11555.f10362.setAlpha(1.0f);
            mo10567(this.f11556.mo1286());
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡦ */
    public void mo10550() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10369.m2267();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡧ */
    public void mo10551() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3325();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡨ */
    public void mo10552(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3326(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡩ */
    public void mo10553(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        if (f >= 0.0f && f <= 1.0f) {
            abstractC2853.f10337.setVisibility(0);
            return;
        }
        abstractC2853.f10337.setVisibility(8);
        this.f11555.f10337.m3191();
        this.f11555.f10337.m3190();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡪ */
    public void mo10554() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10366.m3271();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢠ */
    public void mo10555(float f) {
        if (this.f11555 == null) {
            return;
        }
        C3947.m12727().m12785(f);
        this.f11555.f10366.m3271();
        this.f11555.f10337.setDegree(this.f11555.f10366.m3262(false));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢡ */
    public void mo10556(float f, float f2) {
        if (this.f11555 == null) {
            return;
        }
        C3947.m12727().m12785(f);
        this.f11555.f10366.m3272(f2);
        this.f11555.f10337.setDegree(this.f11555.f10366.m3262(false));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢢ */
    public void mo10557(String str, int i, String str2) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10368.m2846(str, i, str2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢣ */
    public void mo10558() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10369.m2273();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢤ */
    public void mo10559(long j) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10371.post(new RunnableC3378(j));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢥ */
    public void mo10560(boolean z) {
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢦ */
    public void mo10561() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null && abstractC2853.f10407.m3295()) {
            this.f11555.f10407.m3298();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢧ */
    public void mo10562() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = abstractC2853.f10405.getLayoutParams();
        layoutParams.width = C4792.m14375().m14436();
        this.f11555.f10405.setLayoutParams(layoutParams);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢨ */
    public void mo10563() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10406.m3329();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢩ */
    public void mo10564() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10407.m3299();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢪ */
    public void mo10565() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10412.m2456();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢫ */
    public void mo10566() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null) {
            m11113(abstractC2853.f10388, abstractC2853.f10389, this.f11556.mo1221());
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢬ */
    public void mo10567(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10413.setVisibility(z ? 0 : 4);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢭ */
    public void mo10568() throws Resources.NotFoundException {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10414.m3780();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢮ */
    public void mo10569(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10400.setVisibility(z ? 0 : 8);
        this.f11555.f10401.setVisibility(z ? 0 : 8);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢯ */
    public void mo10570(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null && i == 0) {
            abstractC2853.f10382.m2360();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢰ */
    public void mo10571() {
        if (this.f11555 == null) {
            return;
        }
        if (this.f11556.mo1270()) {
            this.f11555.f10419.setImageResource(R.drawable.icon_50_mode_pro);
        } else {
            this.f11555.f10419.setImageResource(R.drawable.icon_50_mode_auto);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢱ */
    public void mo10572() {
        if (this.f11555 == null) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            ((FilmPointView) this.f11555.f10420.getChildAt(i)).m2292(false);
        }
        if (this.f11556.mo1270()) {
            ((FilmPointView) this.f11555.f10420.getChildAt(1)).m2292(true);
        } else {
            ((FilmPointView) this.f11555.f10420.getChildAt(0)).m2292(true);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢲ */
    public void mo10573() {
        int iM9450;
        float fMo1244;
        int iM9449;
        if (this.f11555 == null) {
            return;
        }
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12429 = c3891M13890.m12429();
        boolean zM12444 = c3891M13890.m12444();
        int iM12460 = c3891M13890.m12460();
        int iM14489 = this.f11555.f10383.m2402() ? C4792.m14375().m14489() * 2 : 0;
        int iM144892 = this.f11555.f10383.m2403() ? C4792.m14375().m14489() * 2 : 0;
        if (zM12444) {
            if (iM12460 == 1) {
                iM9450 = C2579.f9598;
                iM9449 = C2579.f9597;
            } else {
                iM9450 = ((int) this.f11555.f10383.getTargetCameraWidth()) + iM144892;
                fMo1244 = this.f11555.f10383.getTargetCameraHeight();
                iM9449 = ((int) fMo1244) + iM14489;
            }
        } else if (iM12429 == 1 || iM12429 == 2) {
            iM9450 = C2579.m9450(getActivity());
            fMo1244 = (C2579.f9598 * 1.0f) / this.f11556.mo1244();
            iM9449 = ((int) fMo1244) + iM14489;
        } else {
            iM9450 = C2579.m9450(getActivity());
            iM9449 = C2579.m9449(getActivity());
        }
        this.f11555.f10394.m2515(iM9450, iM9449);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢳ */
    public void mo10574(String str) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10424.setBottomTextContent(str);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢴ */
    public void mo10575() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10425.m2524();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢶ */
    public void mo10576() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        m11113(abstractC2853.f10381, abstractC2853.f10403, !this.f11556.mo1261());
        AbstractC2853 abstractC28532 = this.f11555;
        m11113(abstractC28532.f10388, abstractC28532.f10389, this.f11556.mo1221());
        AbstractC2853 abstractC28533 = this.f11555;
        m11113(abstractC28533.f10390, abstractC28533.f10391, this.f11556.mo1227());
        AbstractC2853 abstractC28534 = this.f11555;
        m11113(abstractC28534.f10396, abstractC28534.f10397, this.f11556.mo1227());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢷ */
    public void mo10577() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null && abstractC2853.f10432.m3433()) {
            this.f11555.f10432.m3436();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢸ */
    public void mo10578() throws Resources.NotFoundException {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10414.m3777();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢹ */
    public void mo10579() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10414.m3778();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢺ */
    public void mo10580(float f, float f2) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10383.m2416(f, f2, true);
        HorizonCircleRectView.f2347 = false;
        this.f11555.f10384.m2441(this.f11556.mo1250(), this.f11556.mo1244(), true);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢻ */
    public void mo10581() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        int childCount = abstractC2853.f10441.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((FilmPointView) this.f11555.f10441.getChildAt(i)).m2292(false);
        }
        int iMo1262 = this.f11556.mo1262();
        if (iMo1262 == 0) {
            ((FilmPointView) this.f11555.f10441.getChildAt(2)).m2292(true);
            return;
        }
        if (iMo1262 == 1) {
            ((FilmPointView) this.f11555.f10441.getChildAt(3)).m2292(true);
            return;
        }
        if (iMo1262 == 2) {
            ((FilmPointView) this.f11555.f10441.getChildAt(0)).m2292(true);
        } else if (iMo1262 == 3) {
            ((FilmPointView) this.f11555.f10441.getChildAt(1)).m2292(true);
        } else {
            if (iMo1262 != 4) {
                return;
            }
            ((FilmPointView) this.f11555.f10441.getChildAt(4)).m2292(true);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢼ */
    public void mo10582(String str) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10443.setBottomTextContent(str);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢽ */
    public void mo10583() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10444.m2728();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢾ */
    public void mo10584() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10366.m3275();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢿ */
    public void mo10585(float f) {
        if (this.f11555 == null) {
            return;
        }
        C3947.m12727().m12789(f);
        this.f11555.f10366.m3275();
        this.f11555.f10338.setDegree(this.f11555.f10366.m3262(true));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣀ */
    public void mo10586(float f, float f2) {
        if (this.f11555 == null) {
            return;
        }
        C3947.m12727().m12789(f);
        this.f11555.f10366.m3276(f2);
        this.f11555.f10338.setDegree(this.f11555.f10366.m3262(true));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣁ */
    public void mo10587() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10366.m3274();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣂ */
    public void mo10588() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = abstractC2853.f10346.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = 0;
        this.f11555.f10346.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f11555.f10347.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.f11555.f10347.setLayoutParams(layoutParams2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣃ */
    public void mo10589(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        if (i == 1) {
            abstractC2853.f10374.setImageResource(R.drawable.icon_13_microphone_external);
            m11173(true);
        } else if (i != 2) {
            m11173(false);
        } else {
            abstractC2853.f10374.setImageResource(R.drawable.icon_13_microphone_bluetooth);
            m11173(true);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣄ */
    public void mo10590() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10341.m3220();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣅ */
    public void mo10591(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10341.setNeedCheckMag(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣆ */
    public void mo10592() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10341.m3223();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣇ */
    public void mo10593(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10378.setBattery(i);
    }

    /* renamed from: ॽ, reason: contains not printable characters */
    public final boolean m11167(float f, float f2) {
        return f >= ((float) this.f11602) && f <= ((float) this.f11604) && f2 >= ((float) this.f11603) && f2 <= ((float) this.f11605);
    }

    /* renamed from: ৲, reason: contains not printable characters */
    public final void m11168() {
        this.f11590 = new GestureDetector(getActivity(), new GestureDetectorOnGestureListenerC3360());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ৼ */
    public void mo10596(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        float f = z ? 1.0f : 0.3f;
        abstractC2853.f10368.setEnabled(z);
        this.f11555.f10367.setEnabled(z);
        this.f11555.f10424.setEnabled(z);
        this.f11555.f10423.setEnabled(z);
        this.f11555.f10431.setEnabled(z);
        this.f11555.f10430.setEnabled(z);
        this.f11555.f10405.setEnabled(z);
        this.f11555.f10404.setEnabled(z);
        this.f11555.f10443.setEnabled(z);
        this.f11555.f10442.setEnabled(z);
        this.f11555.f10411.setEnabled(z);
        this.f11555.f10410.setEnabled(z);
        this.f11555.f10362.setEnabled(z);
        this.f11555.f10427.setEnabled(z);
        boolean zM10019 = C2764.m10018().m10019();
        this.f11555.f10342.setEnabled(zM10019 && z);
        this.f11555.f10417.setEnabled(z);
        this.f11555.f10428.setEnabled(z);
        this.f11555.f10372.setEnabled(z);
        this.f11555.f10445.setEnabled(z);
        this.f11555.f10419.setEnabled(z);
        this.f11555.f10363.setEnabled(z);
        this.f11555.f10415.setEnabled(z);
        this.f11555.f10343.setEnabled(z);
        this.f11555.f10429.setEnabled(z);
        this.f11555.f10418.setEnabled(z);
        this.f11555.f10373.setEnabled(z);
        this.f11555.f10375.setEnabled(z);
        this.f11555.f10368.setAlpha(f);
        this.f11555.f10424.setAlpha(f);
        this.f11555.f10431.setAlpha(f);
        this.f11555.f10405.setAlpha(f);
        this.f11555.f10443.setAlpha(f);
        this.f11555.f10411.setAlpha(f);
        this.f11555.f10362.setAlpha(f);
        this.f11555.f10427.setAlpha(f);
        this.f11555.f10342.setAlpha(zM10019 ? f : 0.2f);
        this.f11555.f10417.setAlpha(f);
        this.f11555.f10428.setAlpha(f);
        this.f11555.f10372.setAlpha(f);
        this.f11555.f10445.setAlpha(f);
        this.f11555.f10419.setAlpha(f);
        this.f11555.f10419.setAlpha(f);
        this.f11555.f10420.setAlpha(f);
        this.f11555.f10375.setAlpha(f);
        if (this.f11556.mo1286()) {
            this.f11555.f10413.setAlpha(f);
        }
        if (this.f11556.mo1229()) {
            this.f11555.f10400.setAlpha(f);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ૹ */
    public void mo10597(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10414.setCurrentStylePos(i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ಀ */
    public void mo10598(String str) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10414.setDownloadProgress(str);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ೱ */
    public void mo10599(int i) {
        if (this.f11555 == null || getActivity() == null || !this.f11581) {
            return;
        }
        getActivity().runOnUiThread(new RunnableC3364());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ೲ */
    public void mo10600() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10355.setVisibility(8);
        this.f11555.f10353.setVisibility(8);
        this.f11555.f10354.setVisibility(8);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ഄ */
    public void mo10601(boolean z, float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10366.m3277(z, f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ഩ */
    public void mo10602(float f) {
        if (this.f11555 == null) {
            return;
        }
        boolean zM12444 = C4535.m13880().m13890().m12444();
        this.f11555.f10383.m2414(f, zM12444, zM12444 ? 1.0f : f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ഺ */
    public void mo10603(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10383.m2422(i);
    }

    /* renamed from: ഽ, reason: contains not printable characters */
    public final void m11169() {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10394.getLayoutParams();
        layoutParams.width = C2579.m9450(getActivity());
        layoutParams.height = C2579.m9449(getActivity());
        this.f11555.f10394.setLayoutParams(layoutParams);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൎ */
    public void mo10605(float f, float f2) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10383.setScaleX(f);
        this.f11555.f10383.setScaleY(f2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൔ */
    public void mo10606() {
        if (this.f11555 == null) {
            return;
        }
        float fM12738 = C3947.m12727().m12738();
        if (!C3947.m12727().m12769()) {
            this.f11555.f10405.setBottomTextContent("N/A");
            return;
        }
        this.f11555.f10405.setBottomTextContent("" + ((int) fM12738));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൕ */
    public void mo10607(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10405.setTvsColor(i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൖ */
    public void mo10608(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10350.setAlpha(f);
        this.f11555.f10351.setAlpha(f);
        this.f11555.f10352.setAlpha(f);
        this.f11555.f10349.setAlpha(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൟ */
    public void mo10609(C3828 c3828) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10411.setCameraLensName(c3828);
    }

    /* renamed from: ำ, reason: contains not printable characters */
    public void m11170(boolean z, int i, String str, int i2) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        if (!z) {
            abstractC2853.f10386.m4159(0);
            this.f11555.f10386.m4168(5);
            this.f11555.f10386.setCenterState(1);
            m11171(false, i);
            this.f11555.f10402.setVisibility(8);
            return;
        }
        this.f11555.f10386.m4159(!"Wi-Fi".equals(C3688.m11833(FilmApp.m402())) ? 1 : 0);
        this.f11555.f10386.m4168(i2);
        this.f11555.f10386.setCenterState(3);
        this.f11555.f10386.m4165(i, str);
        m11171(true, i);
        try {
            this.f11555.f10399.setContentTextColor(getResources().getColor(TransmitHelper.getSignalColor(i2), null));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f11555.f10386.m4168(i2);
        if (!ACHelper.getInstance().isCloudPush()) {
            this.f11555.f10402.setVisibility(8);
            return;
        }
        this.f11555.f10402.setVisibility(0);
        String roomId = ACHelper.getInstance().getRoomId();
        if (r1.m8143(roomId) && !roomId.equals(this.f11555.f10402.getText())) {
            this.f11555.f10402.setText(roomId);
        }
        this.f11555.f10402.m4174(ACHelper.getInstance().getWifiViewLevelByLevel(ACHelper.getInstance().wifiLevel(PingHelper.getInstance().getProtakeWifiStatus())));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຆ */
    public void mo10611(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10421.m2504(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຉ */
    public void mo10612(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10421.setState(i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຌ */
    public void mo10613(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10392.setRecordMode(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຎ */
    public void mo10614() {
        if (this.f11555 == null) {
            return;
        }
        String strM9057 = C2462.m9035().m9057();
        ACHelper.getInstance().setAlbumHomeDesStr(strM9057);
        this.f11555.f10393.setText(strM9057);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f11555.f10393.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (this.f11555.f10393.getPaint().measureText(strM9057) + C4792.f16138);
        this.f11555.f10393.setLayoutParams(layoutParams);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຏ */
    public void mo10615(float f, float f2) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10394.setScaleX(f);
        this.f11555.f10394.setScaleY(f2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຐ */
    public void mo10616(float f, float f2) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10394.setTranslationX(f);
        this.f11555.f10394.setTranslationY(f2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຑ */
    public void mo10617(float f, float f2, boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10373.m2114(f, f2, z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຒ */
    public void mo10618() {
        String str;
        if (this.f11555 == null) {
            return;
        }
        C4792.m14375().m14500();
        int iM14475 = C4792.m14375().m14475();
        ViewGroup.LayoutParams layoutParams = this.f11555.f10431.getLayoutParams();
        if (layoutParams.width != iM14475) {
            layoutParams.width = iM14475;
            this.f11555.f10431.setLayoutParams(layoutParams);
        }
        float fM12735 = C3947.m12727().m12735();
        if (!C3947.m12727().m12767()) {
            this.f11555.f10431.setBottomTextContent("N/A");
            return;
        }
        if (C3947.m12727().m12764()) {
            float fM12739 = C3947.m12727().m12739();
            this.f11555.f10431.setBottomTextContent(new DecimalFormat("0.0").format(fM12739) + "°");
            return;
        }
        if (fM12735 > 1.0f) {
            float fFloatValue = new BigDecimal(fM12735).setScale(1, 4).floatValue();
            if (String.valueOf(fFloatValue).endsWith("0")) {
                str = "" + ((long) fFloatValue);
            } else {
                str = "" + fFloatValue;
            }
        } else {
            str = "1/" + Math.round(1.0f / fM12735);
        }
        this.f11555.f10431.setBottomTextContent(str);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຓ */
    public void mo10619(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10431.setTvsColor(i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຘ */
    public void mo10620(float f) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 != null && abstractC2853.f10432.m3433()) {
            this.f11555.f10432.setPro(f);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຠ */
    public void mo10621(String str, int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10378.m2184(str, i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຨ */
    public void mo10622() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10341.m3224();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຩ */
    public void mo10623(boolean z, boolean z2) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10435.setEnabled(z);
        this.f11555.f10435.setAlpha(z ? 1.0f : 0.3f);
        if (z2) {
            this.f11555.f10433.setVisibility(8);
            this.f11555.f10434.setVisibility(0);
        } else {
            this.f11555.f10433.setVisibility(0);
            this.f11555.f10434.setVisibility(8);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຬ */
    public void mo10624(float f, int i, CameraTouchView.InterfaceC1143 interfaceC1143) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10355.m3157(f, i, new C3362(interfaceC1143));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ໞ */
    public void mo10625(String str) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10414.setUpdateProgress(str);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ໟ */
    public void mo10626(int i, int i2) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10444.m2730(i, i2);
    }

    /* renamed from: ར, reason: contains not printable characters */
    public final void m11171(boolean z, int i) {
        if (!z || i <= 0) {
            if (this.f11555.f10399.getVisibility() != 8) {
                this.f11555.f10399.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f11555.f10399.getVisibility() != 0) {
            this.f11555.f10399.setVisibility(0);
        }
        if (this.f11586 != i) {
            this.f11555.f10399.m2561(i + "");
            this.f11586 = i;
        }
    }

    /* renamed from: ཪ, reason: contains not printable characters */
    public final void m11172(String str, int i, int i2, int i3, int i4) {
        String str2 = "";
        int i5 = 0;
        if (i3 != 0 && str != null && !"".equalsIgnoreCase(str)) {
            str2 = String.format("(%s)", str);
        }
        ACHelper.getInstance().setFpsTimeLapseValue(str2);
        if (this.f17095) {
            C4638.m14099("HomeLandscapeFragment", String.format("onVideoFpsChoose  timeLapseTimeMs : %s ", Integer.valueOf(i3)));
        }
        if (i2 == 2 && i == 1) {
            i5 = R.drawable.icon_13_alert;
        }
        mo10557(String.valueOf(i4), i5, str2);
    }

    /* renamed from: ཬ, reason: contains not printable characters */
    public void m11173(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        C4008.m12876(abstractC2853.f10374, z ? 1.0f : 0.0f, 100, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ྈ */
    public void mo10630() {
        if (this.f11555 == null) {
            return;
        }
        float f = this.f11556.mo1261() ? 0 : this.f11616;
        C4008.m12886(this.f11555.f10439, this.f11556.mo1270() ? 0.0f : -this.f11568, f, 100, null);
        C4008.m12886(this.f11555.f10441, this.f11556.mo1270() ? 0.0f : -this.f11568, f, 100, null);
        C4008.m12886(this.f11555.f10373, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10374, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10378, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10377, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10392, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10372, this.f11556.mo1270() ? 0.0f : this.f11569, f, 100, null);
        C4008.m12886(this.f11555.f10445, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10419, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10420, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10393, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10386, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10402, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10387, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10399, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10437, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10409, 0.0f, 0.0f, 100, null);
        C4008.m12886(this.f11555.f10421, 0.0f, 0.0f, 100, new C3379());
        this.f11556.getHandler().postDelayed(new RunnableC3381(), 100L);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ྉ */
    public void mo10631(float f, float f2, boolean z, boolean z2) {
        if (this.f11555 == null) {
            return;
        }
        this.f11556.mo1249(false);
        this.f11555.f10355.m3148();
        this.f11555.f10355.setSlidebarAlpha(1.0f);
        this.f11555.f10355.m3154();
        this.f11555.f10355.setDrawIcon(true);
        if (z2) {
            this.f11555.f10355.setDrawIcon(false);
        }
        float fM14415 = C4792.m14375().m14415() / 2;
        ViewGroup.LayoutParams layoutParams = this.f11555.f10379.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        float f3 = i;
        float fMin = Math.min(f3, f - C2579.m9438(fM14415));
        float f4 = i2;
        float fMin2 = Math.min(f4, f2 - C2579.m9438(fM14415));
        this.f11555.f10355.setX(fMin);
        this.f11555.f10355.setY(fMin2);
        this.f11555.f10355.m3155();
        C3947.m12727().m12783(0.5f);
        float fM12734 = C3947.m12727().m12734();
        this.f11556.mo1283((int) C3947.m12727().m12744(), C3947.m12727().m12734());
        this.f11555.f10355.m3153(-1.0f, false, 1.0f - fM12734);
        if (fMin + C2579.m9438(fM14415) + C2579.m9438(40.0f) + C2579.m9438(20.0f) > f3) {
            this.f11555.f10355.m3156();
        } else {
            this.f11555.f10355.m3158();
        }
        if (this.f11615 == null) {
            this.f11615 = new RectF();
        }
        float fM9438 = (C2579.m9438(130.0f) * C4202.m13274().m13282()) / 2.0f;
        float f5 = f - fM9438;
        float f6 = f + fM9438;
        float f7 = f2 - fM9438;
        float f8 = f2 + fM9438;
        float fMax = Math.max(0.0f, f5 / f3);
        float fMin3 = Math.min(1.0f, f6 / f3);
        float fMax2 = Math.max(0.0f, f7 / f4);
        float fMin4 = Math.min(1.0f, f8 / f4);
        if (fMin3 < 0.0f) {
            fMin3 = 0.0f;
        }
        if (fMin4 < 0.0f) {
            fMin4 = 0.0f;
        }
        if (z2) {
            float[] focalLengthAndZoomRatio = this.f11555.f10341.getFocalLengthAndZoomRatio();
            this.f11556.mo1220(focalLengthAndZoomRatio[0], focalLengthAndZoomRatio[1]);
        } else {
            float fM5922 = d9.m5921().m5922();
            if (fM5922 != 1.0f) {
                float f9 = 1.0f / fM5922;
                float f10 = (1.0f - f9) / 2.0f;
                float f11 = f10 * f3;
                float f12 = f10 * f4;
                float f13 = (f7 * f9) + f12;
                float f14 = f12 + (f8 * f9);
                float fMax3 = Math.max(0.0f, ((f5 * f9) + f11) / f3);
                fMin3 = Math.min(1.0f, (f11 + (f6 * f9)) / f3);
                fMax2 = Math.max(0.0f, f13 / f4);
                fMin4 = Math.min(1.0f, f14 / f4);
                fMax = fMax3;
            }
            RectF rectF = this.f11615;
            if (rectF.left != fMax || rectF.top != fMax2 || rectF.right != fMin3 || rectF.bottom != fMin4) {
                rectF.left = fMax;
                rectF.top = fMax2;
                rectF.right = fMin3;
                rectF.bottom = fMin4;
                this.f11556.mo1276(rectF);
            }
        }
        this.f11555.f10355.setViewScale(Float.valueOf(C4202.m13274().m13280()));
        this.f11555.f10354.setVisibility(8);
        this.f11555.f10353.setVisibility(8);
        this.f11555.f10355.setVisibility(0);
        this.f11558 = 0;
        if (z) {
            this.f11556.mo1289(false);
            this.f11556.getHandler().removeMessages(105);
            this.f11556.getHandler().removeMessages(108);
            this.f11556.getHandler().removeMessages(107);
            this.f11556.getHandler().removeMessages(109);
            C4202.m13274().m13279(C4202.m13274().m13280(), C4202.m13274().m13282(), 100, new C3374(z2));
            return;
        }
        this.f11556.mo1289(true);
        this.f11555.f10355.setDrawIcon(false);
        this.f11556.getHandler().removeMessages(105);
        this.f11556.getHandler().removeMessages(108);
        this.f11556.getHandler().removeMessages(107);
        this.f11556.getHandler().removeMessages(109);
        C4202.m13274().m13278(this.f11556.getHandler(), false, z2);
    }

    /* renamed from: ྋ, reason: contains not printable characters */
    public final void m11174(int i) {
        ViewGroup.LayoutParams layoutParams = this.f11555.f10382.getLayoutParams();
        layoutParams.width = i;
        this.f11555.f10382.setLayoutParams(layoutParams);
        this.f11555.f10382.setPadding(this.f11580);
        this.f11555.f10382.setGridsChangeListener(new C3361());
        this.f11555.f10382.m2360();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ྌ */
    public void mo10633(boolean z, int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        if (z) {
            abstractC2853.f10341.m3226(i);
        } else {
            abstractC2853.f10341.m3213(i);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ဢ */
    public void mo10634(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        C4008.m12876(abstractC2853.f10394, z ? 1.0f : 0.0f, 100, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ဨ */
    public void mo10635(boolean z) {
        if (this.f11555 == null) {
            return;
        }
        HorizonCircleRectView.f2347 = false;
        if (z) {
            Sensor defaultSensor = this.f11576.getDefaultSensor(1);
            this.f11577 = defaultSensor;
            this.f11576.registerListener(this, defaultSensor, 1);
        } else {
            m11139();
        }
        this.f11555.f10384.setVisibility(z ? 0 : 8);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၚ */
    public void mo10636(boolean z) {
        if (z) {
            mo10633(false, 100);
            mo10526(-1, 0, 100);
            if (m11117()) {
                m11163(true);
            }
        } else {
            mo10633(true, 100);
            mo10526(0, 0, 100);
            if (m11117()) {
                m11163(false);
            }
        }
        this.f11556.mo1219(!z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၛ */
    public void mo10637(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        if (z) {
            abstractC2853.f10406.m3319(100);
            this.f11555.f10366.m3265(100);
            this.f11555.f10337.m3188(100);
            this.f11555.f10338.m3188(100);
            if (m11117()) {
                m11163(true);
            }
        } else {
            abstractC2853.f10406.m3333(100);
            this.f11555.f10366.m3278(100);
            this.f11555.f10337.m3192(100);
            this.f11555.f10338.m3192(100);
            if (m11117()) {
                m11163(z || !this.f11556.mo1270());
            }
        }
        this.f11556.mo1219(!z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၜ */
    public void mo10638(boolean z) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        float f = z ? this.f11616 : 0;
        C4008.m12886(abstractC2853.f10439, this.f11556.mo1270() ? 0.0f : -this.f11568, f, 100, null);
        C4008.m12886(this.f11555.f10441, this.f11556.mo1270() ? 0.0f : -this.f11568, f, 100, null);
        C4008.m12886(this.f11555.f10373, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10374, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10378, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10377, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10392, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10372, this.f11556.mo1270() ? 0.0f : this.f11569, f, 100, null);
        C4008.m12886(this.f11555.f10445, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10419, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10420, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10393, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10386, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10402, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10387, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10437, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10399, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        float f2 = z ? (int) (-m11120()) : 0;
        C4008.m12886(this.f11555.f10424, 0.0f, f2, 100, null);
        C4008.m12886(this.f11555.f10368, 0.0f, f2, 100, null);
        C4008.m12886(this.f11555.f10431, 0.0f, f2, 100, null);
        C4008.m12886(this.f11555.f10405, 0.0f, f2, 100, null);
        C4008.m12886(this.f11555.f10443, 0.0f, f2, 100, null);
        C4008.m12886(this.f11555.f10411, 0.0f, f2, 100, null);
        C4008.m12886(this.f11555.f10401, 0.0f, f2, 100, null);
        C4008.m12886(this.f11555.f10400, 0.0f, f2, 100, null);
        C4008.m12886(this.f11555.f10413, 0.0f, f2, 100, null);
        float f3 = this.f11556.mo1270() ? 0 : -this.f11588;
        C4008.m12886(this.f11555.f10408, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10362, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10342, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10343, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10427, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10415, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10417, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10418, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10401, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10400, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10413, f3, f2, 100, null);
        C4008.m12886(this.f11555.f10428, f3, f2, 100, new C3385(z));
        m11164(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၝ */
    public void mo10639() {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        abstractC2853.f10366.m3278(100);
        this.f11555.f10406.m3333(100);
        this.f11555.f10337.m3192(100);
        this.f11555.f10338.m3192(100);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၡ */
    public void mo10640(int i) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        C4008.m12876(abstractC2853.f10409, 1.0f, i, new C3388());
        C4008.m12876(this.f11555.f10421, 0.2f, i, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၥ */
    public void mo10641() {
        this.f11555.f10354.setVisibility(0);
        this.f11555.f10354.setRotation(0.0f);
        this.f11555.f10353.setVisibility(0);
        this.f11555.f10353.setDrawText(false);
        this.f11555.f10353.setRotation(0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(C4202.m13274().m13281(), 1.0f);
        this.f11594 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.f11594.setRepeatCount(2);
        this.f11594.setRepeatMode(2);
        this.f11594.setInterpolator(new LinearInterpolator());
        this.f11594.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ǩ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f9191.m11076(valueAnimator);
            }
        });
        this.f11594.start();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၦ */
    public void mo10642() {
        this.f11555.f10406.m3334(false);
        this.f11555.f10366.m3279(false);
    }

    /* renamed from: ჼ, reason: contains not printable characters */
    public void m11175(Runnable runnable) {
        AbstractC2853 abstractC2853 = this.f11555;
        if (abstractC2853 == null) {
            return;
        }
        float f = this.f11616;
        C4008.m12886(abstractC2853.f10439, this.f11556.mo1270() ? 0.0f : -this.f11568, f, 100, null);
        C4008.m12886(this.f11555.f10441, this.f11556.mo1270() ? 0.0f : -this.f11568, f, 100, null);
        C4008.m12886(this.f11555.f10373, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10374, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10378, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10377, this.f11556.mo1270() ? 0.0f : -this.f11560, f, 100, null);
        C4008.m12886(this.f11555.f10392, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10372, this.f11556.mo1270() ? 0.0f : this.f11569, f, 100, null);
        C4008.m12886(this.f11555.f10445, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10419, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10420, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10393, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10386, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10402, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10387, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10437, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10399, this.f11556.mo1270() ? 0.0f : -this.f11561, f, 100, null);
        C4008.m12886(this.f11555.f10409, 0.0f, f, 100, null);
        C4008.m12886(this.f11555.f10421, 0.0f, f, 100, new C3382(runnable));
    }
}
