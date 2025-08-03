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
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.home.HomeActivity;
import com.blink.academy.film.home.fragment.FragmentCallback;
import com.blink.academy.film.widgets.AudioSettingView;
import com.blink.academy.film.widgets.FPSPortraitSettingView;
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
import com.blink.academy.film.widgets.looks.LooksPreviewPortraitView;
import com.blink.academy.protake.R;
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
import org.json.JSONException;

/* compiled from: HomePortraitFragment.java */
/* renamed from: ҫ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2970 extends AbstractC5160 implements SensorEventListener {

    /* renamed from: ԯ, reason: contains not printable characters */
    public AbstractC3481 f10732;

    /* renamed from: ՠ, reason: contains not printable characters */
    public FragmentCallback f10733;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f10734;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f10735;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f10736;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f10737;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f10738;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f10739;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f10744;

    /* renamed from: އ, reason: contains not printable characters */
    public int f10745;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f10746;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f10750;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f10751;

    /* renamed from: ގ, reason: contains not printable characters */
    public int f10752;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f10753;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f10754;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f10755;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f10756;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f10757;

    /* renamed from: ޔ, reason: contains not printable characters */
    public float f10758;

    /* renamed from: ޕ, reason: contains not printable characters */
    public float f10759;

    /* renamed from: ޖ, reason: contains not printable characters */
    public float f10760;

    /* renamed from: ޗ, reason: contains not printable characters */
    public int f10761;

    /* renamed from: ޘ, reason: contains not printable characters */
    public int f10762;

    /* renamed from: ޙ, reason: contains not printable characters */
    public int f10763;

    /* renamed from: ޚ, reason: contains not printable characters */
    public int f10764;

    /* renamed from: ޜ, reason: contains not printable characters */
    public int f10766;

    /* renamed from: ޝ, reason: contains not printable characters */
    public int f10767;

    /* renamed from: ޞ, reason: contains not printable characters */
    public int f10768;

    /* renamed from: ޟ, reason: contains not printable characters */
    public int f10769;

    /* renamed from: ޠ, reason: contains not printable characters */
    public int f10770;

    /* renamed from: ޡ, reason: contains not printable characters */
    public int f10771;

    /* renamed from: ޢ, reason: contains not printable characters */
    public String f10772;

    /* renamed from: ޣ, reason: contains not printable characters */
    public float f10773;

    /* renamed from: ޤ, reason: contains not printable characters */
    public float f10774;

    /* renamed from: ޥ, reason: contains not printable characters */
    public float f10775;

    /* renamed from: ޱ, reason: contains not printable characters */
    public int f10776;

    /* renamed from: ߾, reason: contains not printable characters */
    public int f10777;

    /* renamed from: ߿, reason: contains not printable characters */
    public int f10778;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public int f10779;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public int f10780;

    /* renamed from: ࡣ, reason: contains not printable characters */
    public long f10782;

    /* renamed from: ࡤ, reason: contains not printable characters */
    public SensorManager f10783;

    /* renamed from: ࡥ, reason: contains not printable characters */
    public Sensor f10784;

    /* renamed from: ࡦ, reason: contains not printable characters */
    public int f10785;

    /* renamed from: ࡧ, reason: contains not printable characters */
    public int f10786;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public int f10787;

    /* renamed from: ࡪ, reason: contains not printable characters */
    public float f10789;

    /* renamed from: ࢠ, reason: contains not printable characters */
    public int f10790;

    /* renamed from: ࢡ, reason: contains not printable characters */
    public int f10791;

    /* renamed from: ࢢ, reason: contains not printable characters */
    public int f10792;

    /* renamed from: ࢣ, reason: contains not printable characters */
    public int f10793;

    /* renamed from: ࢤ, reason: contains not printable characters */
    public int f10794;

    /* renamed from: ࢥ, reason: contains not printable characters */
    public GestureDetector f10795;

    /* renamed from: ࢦ, reason: contains not printable characters */
    public float f10796;

    /* renamed from: ࢧ, reason: contains not printable characters */
    public float f10797;

    /* renamed from: ࢨ, reason: contains not printable characters */
    public boolean f10798;

    /* renamed from: ࢩ, reason: contains not printable characters */
    public ValueAnimator f10799;

    /* renamed from: ࢪ, reason: contains not printable characters */
    public boolean f10800;

    /* renamed from: ࢫ, reason: contains not printable characters */
    public int f10801;

    /* renamed from: ࢬ, reason: contains not printable characters */
    public int f10802;

    /* renamed from: ࢱ, reason: contains not printable characters */
    public int f10807;

    /* renamed from: ࢲ, reason: contains not printable characters */
    public int f10808;

    /* renamed from: ࢳ, reason: contains not printable characters */
    public int f10809;

    /* renamed from: ࢴ, reason: contains not printable characters */
    public int f10810;

    /* renamed from: ࢶ, reason: contains not printable characters */
    public int f10811;

    /* renamed from: ࢷ, reason: contains not printable characters */
    public int f10812;

    /* renamed from: ࢸ, reason: contains not printable characters */
    public int f10813;

    /* renamed from: ࢹ, reason: contains not printable characters */
    public int f10814;

    /* renamed from: ࢺ, reason: contains not printable characters */
    public boolean f10815;

    /* renamed from: ࢻ, reason: contains not printable characters */
    public boolean f10816;

    /* renamed from: ࢼ, reason: contains not printable characters */
    public boolean f10817;

    /* renamed from: ࢽ, reason: contains not printable characters */
    public boolean f10818;

    /* renamed from: ࢾ, reason: contains not printable characters */
    public boolean f10819;

    /* renamed from: ࢿ, reason: contains not printable characters */
    public RectF f10820;

    /* renamed from: ࣀ, reason: contains not printable characters */
    public int f10821;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f10740 = 35;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f10741 = 47;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f10742 = 323;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f10743 = 90;

    /* renamed from: މ, reason: contains not printable characters */
    public int f10747 = 17;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f10748 = 67;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f10749 = 67;

    /* renamed from: ޛ, reason: contains not printable characters */
    public float f10765 = 1.0f;

    /* renamed from: ࡢ, reason: contains not printable characters */
    public boolean f10781 = false;

    /* renamed from: ࡩ, reason: contains not printable characters */
    public boolean f10788 = false;

    /* renamed from: ࢭ, reason: contains not printable characters */
    public int f10803 = 124;

    /* renamed from: ࢮ, reason: contains not printable characters */
    public int f10804 = 124;

    /* renamed from: ࢯ, reason: contains not printable characters */
    public int f10805 = 47;

    /* renamed from: ࢰ, reason: contains not printable characters */
    public int f10806 = 50;

    /* renamed from: ࣁ, reason: contains not printable characters */
    public final float[][] f10822 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 8, 3);

    /* renamed from: ࣂ, reason: contains not printable characters */
    public int f10823 = 0;

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$Ϳ, reason: contains not printable characters */
    public class C2971 implements ISOView.InterfaceC1186 {
        public C2971() {
        }

        @Override // com.blink.academy.film.widgets.iso.ISOView.InterfaceC1186
        /* renamed from: Ϳ */
        public void mo3302(boolean z) {
            if (C3947.m12727().m12729() == 1) {
                C2970.this.f10733.mo1257(z);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$Ԩ, reason: contains not printable characters */
    public class C2972 implements ISOView.InterfaceC1186 {
        public C2972() {
        }

        @Override // com.blink.academy.film.widgets.iso.ISOView.InterfaceC1186
        /* renamed from: Ϳ */
        public void mo3302(boolean z) {
            if (C3947.m12727().m12729() == 1) {
                C2970.this.f10733.mo1257(z);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$Ԫ, reason: contains not printable characters */
    public class C2973 implements IsoEtWheelView.InterfaceC1200 {
        public C2973() {
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        public void onTouchChange(boolean z) {
            if (z) {
                C2970.this.f10815 = true;
                C4008.m12884(C2970.this.f10732.f12060, 1.3f, 1.3f, 100, null);
                if (!C3947.m12727().m12765()) {
                    if (C3947.m12727().m12749()) {
                        C2970.this.mo10607(C4792.m14375().m14431());
                        C2970.this.mo10619(-1);
                    } else {
                        C2970.this.mo10607(-1);
                        C2970.this.mo10619(C4792.m14375().m14431());
                    }
                }
            } else {
                C2970.this.f10815 = false;
                C4008.m12884(C2970.this.f10732.f12060, 1.0f, 1.0f, 100, null);
                C2970.this.mo10607(-1);
                C2970.this.mo10619(-1);
            }
            if (C3947.m12727().m12729() == 1) {
                C2970.this.f10733.mo1257(z);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: Ϳ */
        public void mo3336() {
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: Ԩ */
        public void mo3337() {
            C2970.this.f10733.mo1230();
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: ԩ */
        public void mo3338(float f) {
            C2970.this.f10733.mo1266(f);
            C2970.this.mo10618();
            if (C2970.this.f10732.f12088.m3382()) {
                C2970.this.f10732.f12088.setPro(f);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: Ԫ */
        public void mo3339() {
            C2970.this.f10733.mo1271();
            C2970.this.mo10606();
            if (C2970.this.f10732.f12061.m3295()) {
                C2970.this.f10732.f12061.m3298();
            }
        }

        @Override // com.blink.academy.film.widgets.iso.IsoEtWheelView.InterfaceC1200
        /* renamed from: ԭ */
        public void mo3340() {
            C2970.this.f10733.mo1187();
            if (C2970.this.f10732.f12088.m3382()) {
                C2970.this.f10732.f12088.m3385();
            }
            if (C2970.this.f10732.f12061.m3295()) {
                C2970.this.f10732.f12061.m3299();
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$Ԭ, reason: contains not printable characters */
    public class C2974 implements FocusZoomWheelView.InterfaceC1176 {
        public C2974() {
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onAnimChange(boolean z) {
            C2970.this.f10817 = z;
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onFocusChange(float f) {
            C2970.this.f10732.f11993.setDegree(C2970.this.f10732.f12024.m3261(false));
            C3947.m12727().m12785(f);
            C2970.this.f10733.mo1279(f);
            C2970.this.mo10553(f);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onHideAB() {
            C2970.this.f10732.f11993.setVisibility(8);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onModeChange(boolean z) {
            if (z) {
                C2970.this.f10732.f12013.setVisibility(0);
                C2970.this.f10732.f12012.setVisibility(8);
            } else {
                C2970.this.f10732.f12013.setVisibility(8);
                C2970.this.f10732.f12012.setVisibility(0);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onTouchChange(boolean z) {
            C2970.this.f10733.mo1273(z);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onTouchChange2(boolean z) {
            if (z) {
                C2970.this.f10816 = true;
                C4008.m12884(C2970.this.f10732.f12024, 1.3f, 1.3f, 100, null);
                C4008.m12884(C2970.this.f10732.f11994, 1.3f, 1.3f, 100, null);
                C4008.m12884(C2970.this.f10732.f11993, 1.3f, 1.3f, 100, null);
                return;
            }
            C2970.this.f10816 = false;
            C4008.m12884(C2970.this.f10732.f12024, 1.0f, 1.0f, 100, null);
            C4008.m12884(C2970.this.f10732.f11994, 1.0f, 1.0f, 100, null);
            C4008.m12884(C2970.this.f10732.f11993, 1.0f, 1.0f, 100, null);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onZoomChange(float f) {
            C2970.this.f10732.f11994.setDegree(C2970.this.f10732.f12024.m3261(true));
            C3947.m12727().m12789(f);
            float fM12754 = C3947.m12727().m12754(f);
            if (C2970.this.f17095) {
                C4638.m14099("slimmm", "pro:" + f + "  proZoomValueByPro:" + fM12754 + " ProZoomProByValue:" + C3947.m12727().m12753(fM12754));
            }
            C2970.this.f10733.mo1278(fM12754);
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1176
        public void onZoomEnableChange(boolean z) {
            C2970.this.f10732.f11994.setEnabled(z);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$Ԯ, reason: contains not printable characters */
    public class C2975 implements ABPointWheelView.InterfaceC1151 {
        public C2975() {
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        public void onFocusChange(float f) {
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        public void onZoomChange(float f) {
            C2970.this.f10733.mo1278(f);
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        /* renamed from: Ϳ */
        public boolean mo3195() {
            return C2970.this.f10733.mo1267() == 1;
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        /* renamed from: Ԩ */
        public void mo3196(int i) {
            if (i == 1) {
                C2970.this.f10732.f11994.setStartDegree(C2970.this.f10732.f12024.m3261(true));
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ՠ, reason: contains not printable characters */
    public class C2976 implements ABPointWheelView.InterfaceC1151 {
        public C2976() {
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        public void onFocusChange(float f) {
            C2970.this.f10733.mo1253(f);
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        public void onZoomChange(float f) {
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        /* renamed from: Ϳ */
        public boolean mo3195() {
            return C2970.this.f10733.mo1267() == 1;
        }

        @Override // com.blink.academy.film.widgets.iso.ABPointWheelView.InterfaceC1151
        /* renamed from: Ԩ */
        public void mo3196(int i) {
            if (i == 1) {
                C2970.this.f10732.f11993.setStartDegree(C2970.this.f10732.f12024.m3261(false));
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC2977 implements View.OnClickListener {
        public ViewOnClickListenerC2977() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC2978 implements View.OnClickListener {
        public ViewOnClickListenerC2978() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC2979 implements View.OnClickListener {
        public ViewOnClickListenerC2979() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC2980 implements View.OnClickListener {
        public ViewOnClickListenerC2980() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC2981 implements View.OnClickListener {
        public ViewOnClickListenerC2981() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2970.this.f10732.f12080.m2521()) {
                C2970.this.m10492();
                return;
            }
            if (C2970.this.f10732.f12027.m2228()) {
                C2970.this.m10496();
                return;
            }
            if (C2970.this.f10732.f12098.m2722()) {
                C2970.this.m10498();
                return;
            }
            if (C2970.this.f10732.f12066.m2452()) {
                C2970.this.m10491();
                return;
            }
            if (C2970.this.f10732.f12088.m3382()) {
                C2970.this.m10499();
                return;
            }
            if (C2970.this.f10732.f12061.m3295()) {
                C2970.this.m10454();
                return;
            }
            if (C2970.this.m10461()) {
                C2970.this.m10448();
                return;
            }
            if (C2970.this.f10732.f12100.m2748()) {
                C2970.this.m10457();
                return;
            }
            if (C2970.this.f10732.f11996.m2136()) {
                C2970.this.m10444();
                return;
            }
            if (C2970.this.f10732.f12068.m3715()) {
                if (C2970.this.f10732.f12068.m3710()) {
                    C2970.this.f10732.f12068.m3727();
                    return;
                } else {
                    C2970.this.m10488();
                    return;
                }
            }
            if (!C2970.this.f10732.f12000.m2813()) {
                C2970.this.m10538(8);
            } else {
                if (!C2970.this.f10732.f12000.m2812()) {
                    C2970.this.m10446();
                    return;
                }
                C2970.this.f10732.f12000.m2815();
                C2970.this.f10733.mo1301(C2970.this.f10732.f12000.getCurrentBeautyType(), C2970.this.f10732.f12000.getCurrentBeautyLevel());
                C2970.this.f10732.f12000.m2826(100);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ށ, reason: contains not printable characters */
    public class ViewOnClickListenerC2982 implements View.OnClickListener {
        public ViewOnClickListenerC2982() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f10733.mo1210();
            if (C2970.this.f10733.mo1222() == 1) {
                C2970.this.f10732.f12089.setVisibility(8);
                C2970.this.f10732.f12090.setVisibility(0);
            } else {
                C2970.this.f10732.f12090.setVisibility(8);
                C2970.this.f10732.f12089.setVisibility(0);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ނ, reason: contains not printable characters */
    public class ViewOnClickListenerC2983 implements View.OnClickListener {
        public ViewOnClickListenerC2983() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e5.m5988().m5993()) {
                C2970.this.f10732.f12076.performClick();
            } else if (C2970.this.f10733.mo1270()) {
                C2970.this.f10733.mo1259();
            } else {
                C2970.this.f10732.f12076.performClick();
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ރ, reason: contains not printable characters */
    public class ViewOnClickListenerC2984 implements View.OnClickListener {
        public ViewOnClickListenerC2984() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f10733.mo1245();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ބ, reason: contains not printable characters */
    public class ViewOnClickListenerC2985 implements View.OnClickListener {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ބ$Ϳ, reason: contains not printable characters */
        public class C2986 extends AbstractC4012 {
            public C2986() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public ViewOnClickListenerC2985() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2970.this.f10733 == null || C2970.this.f10733.mo1269()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (C2970.this.f10782 == 0 || jCurrentTimeMillis - C2970.this.f10782 >= C4062.f14091) {
                    C2970.this.f10782 = jCurrentTimeMillis;
                    if (C2970.this.f10732.f11996.m2136()) {
                        C2970.this.f10732.f11996.m2132(100, new C2986());
                    } else {
                        C2970.this.mo10520(8);
                    }
                }
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޅ, reason: contains not printable characters */
    public class ViewOnClickListenerC2987 implements View.OnClickListener {
        public ViewOnClickListenerC2987() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f10733.mo1243();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ކ, reason: contains not printable characters */
    public class ViewOnClickListenerC2988 implements View.OnClickListener {
        public ViewOnClickListenerC2988() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f10733.mo1236();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$އ, reason: contains not printable characters */
    public class ViewOnClickListenerC2989 implements View.OnClickListener {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$އ$Ϳ, reason: contains not printable characters */
        public class C2990 extends AbstractC4012 {
            public C2990() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public ViewOnClickListenerC2989() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2970.this.m10461()) {
                C2970.this.m10484(100, new C2990());
            } else {
                C2970.this.mo10520(9);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ވ, reason: contains not printable characters */
    public class ViewOnClickListenerC2991 implements View.OnClickListener {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ވ$Ϳ, reason: contains not printable characters */
        public class C2992 extends AbstractC4012 {
            public C2992() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public ViewOnClickListenerC2991() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2970.this.f10732.f12100.m2748()) {
                C2970.this.f10732.f12100.m2746(100, new C2992());
            } else {
                C2970.this.mo10520(10);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$މ, reason: contains not printable characters */
    public class C2993 implements RecordButton.InterfaceC0941 {
        public C2993() {
        }

        @Override // com.blink.academy.film.widgets.RecordButton.InterfaceC0941
        /* renamed from: Ϳ */
        public boolean mo2506() {
            return C2970.this.f10733.mo1228();
        }

        @Override // com.blink.academy.film.widgets.RecordButton.InterfaceC0941
        /* renamed from: Ԩ */
        public void mo2507(int i) {
            C2970.this.m10540();
            C2970.this.f10733.mo1298(i);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ފ, reason: contains not printable characters */
    public class C2994 implements C2650.InterfaceC2658 {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ފ$Ϳ, reason: contains not printable characters */
        public class RunnableC2995 implements Runnable {
            public RunnableC2995() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C2970.this.f10732.f12094.getVisibility() == 0 && C2970.this.f10732.f12094.isAvailable() && C2650.m9784()) {
                    int width = C2970.this.f10732.f12094.getWidth();
                    int height = C2970.this.f10732.f12094.getHeight();
                    if (C2970.this.f17095) {
                        C4638.m14099("HomePortraitFragment", String.format("width : %s , height : %s ", Integer.valueOf(width), Integer.valueOf(height)));
                    }
                    C2650.m9794(C2970.this.f10732.f12094.getSurfaceTexture(), width, height);
                }
            }
        }

        public C2994() {
        }

        @Override // defpackage.C2650.InterfaceC2658
        /* renamed from: Ϳ */
        public void mo9800() {
            if (C2970.this.f17095) {
                C4638.m14099("HomePortraitFragment", String.format("FilmLittlePreview : %s ", "onUpdateSharedContextFinished"));
            }
            if (C2970.this.getActivity() == null) {
                return;
            }
            C2970.this.getActivity().runOnUiThread(new RunnableC2995());
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ދ, reason: contains not printable characters */
    public class C2996 implements BeautySettingView.InterfaceC1008 {
        public C2996() {
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: Ϳ */
        public void mo2830(int i) {
            C2970.this.f10733.mo1264(i);
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: Ԩ */
        public void mo2831(int i, float f) {
            C2970.this.f10733.mo1301(i, f);
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: ބ */
        public void mo2832(int i) {
            C2970.this.f10733.mo1199(i);
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: ކ */
        public void mo2833(int i, float f) {
            C2970.this.f10733.mo1201(i, f);
        }

        @Override // com.blink.academy.film.widgets.beauty.BeautySettingView.InterfaceC1008
        /* renamed from: ދ */
        public void mo2834(boolean z) {
            C2970.this.f10733.mo1206(z);
            C2970 c2970 = C2970.this;
            c2970.m10627(z && c2970.f10733.mo1293());
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ތ, reason: contains not printable characters */
    public class ViewOnClickListenerC2997 implements View.OnClickListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f10850 = false;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f10851;

        public ViewOnClickListenerC2997() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10850) {
                return;
            }
            this.f10850 = true;
            int iM9788 = C2650.m9788(C2970.this.f10733.mo1262());
            C2970.this.f10733.mo1304(iM9788);
            C2650.m9777(iM9788);
            this.f10850 = false;
            C2970.this.mo10581();
            this.f10851 = true ^ this.f10851;
            C4535.m13880().m13890().m12367(iM9788);
            C4535.m13880().m13915();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ލ, reason: contains not printable characters */
    public class TextureViewSurfaceTextureListenerC2998 implements TextureView.SurfaceTextureListener {
        public TextureViewSurfaceTextureListenerC2998() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            C2970.this.f10791 = i;
            C2970.this.f10792 = i2;
            C2650.m9795(C2970.this.f10791, C2970.this.f10792);
            if (C2650.m9784()) {
                if (C2970.this.f17095) {
                    C4638.m14099("HomePortraitFragment", String.format("width : %s , height : %s ", Integer.valueOf(i), Integer.valueOf(i2)));
                }
                C2650.m9794(C2970.this.f10732.f12094.getSurfaceTexture(), i, i2);
            }
            if (C2970.this.f17095) {
                C4638.m14099("HomePortraitFragment", String.format("onSurfaceTextureAvailable : %s , width : %s , height : %s ", Long.valueOf(surfaceTexture.getTimestamp()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (C2970.this.f17095) {
                C4638.m14099("HomePortraitFragment", String.format("onSurfaceTextureDestroyed : %s  ", Long.valueOf(surfaceTexture.getTimestamp())));
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (C2970.this.f17095) {
                C4638.m14099("HomePortraitFragment", String.format("onSurfaceTextureSizeChanged : %s , width : %s , height : %s ", Long.valueOf(surfaceTexture.getTimestamp()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ގ, reason: contains not printable characters */
    public class ViewOnClickListenerC2999 implements View.OnClickListener {
        public ViewOnClickListenerC2999() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f10733.mo1299();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޏ, reason: contains not printable characters */
    public class ViewOnClickListenerC3000 implements View.OnClickListener {
        public ViewOnClickListenerC3000() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f10733.mo1240();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ސ, reason: contains not printable characters */
    public class ViewOnTouchListenerC3001 implements View.OnTouchListener {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ސ$Ϳ, reason: contains not printable characters */
        public class RunnableC3002 implements Runnable {
            public RunnableC3002() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C2970.this.f10732.f12019.setAlpha(!(C2970.this.f10733.getRecordMode() == 1) ? 1.0f : 0.3f);
                C2970.this.f10732.f12055.setAlpha(1.0f);
                C2970.this.f10732.f12056.setAlpha(0.0f);
                C2970.this.f10732.f12067.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC3001() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                C2970.this.f10732.f12019.setAlpha(0.3f);
                C2970.this.f10732.f12055.setAlpha(0.3f);
                C2970.this.f10732.f12056.setAlpha(0.3f);
                C2970.this.f10732.f12067.setAlpha(0.3f);
            } else if (action == 1 || action == 3) {
                new Handler().postDelayed(new RunnableC3002(), 100L);
                C2970 c2970 = C2970.this;
                if (c2970.f17097) {
                    c2970.f17097 = false;
                    c2970.f10733.mo1280();
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޑ, reason: contains not printable characters */
    public class ViewOnClickListenerC3003 implements View.OnClickListener {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޑ$Ϳ, reason: contains not printable characters */
        public class C3004 extends AbstractC4012 {
            public C3004() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public ViewOnClickListenerC3003() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f17097 = false;
            if (C4535.m13880().m13890().m12460() == 1) {
                C2970.this.f10733.mo1285(25);
            } else if (C2970.this.f10732.f12068.m3715()) {
                C2970.this.f10732.f12068.m3705(100, new C3004());
            } else {
                C2970.this.mo10520(7);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޒ, reason: contains not printable characters */
    public class ViewOnLongClickListenerC3005 implements View.OnLongClickListener {
        public ViewOnLongClickListenerC3005() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (C4535.m13880().m13890().m12442() == 0) {
                return false;
            }
            C2970 c2970 = C2970.this;
            c2970.f17097 = true;
            c2970.f10733.mo1241();
            return true;
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޓ, reason: contains not printable characters */
    public class ViewOnClickListenerC3006 implements View.OnClickListener {
        public ViewOnClickListenerC3006() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f10733.mo1231();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޔ, reason: contains not printable characters */
    public class ViewOnClickListenerC3007 implements View.OnClickListener {
        public ViewOnClickListenerC3007() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2970.this.f10732.f12073.setEnabled(false);
            C2970.this.f10733.mo1263();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޕ, reason: contains not printable characters */
    public class ViewOnTouchListenerC3008 implements View.OnTouchListener {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޕ$Ϳ, reason: contains not printable characters */
        public class RunnableC3009 implements Runnable {
            public RunnableC3009() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C2970.this.f10732.f11998.setAlpha(C2970.this.f10733.mo1292() ? 1.0f : 0.2f);
            }
        }

        public ViewOnTouchListenerC3008() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                C2970.this.f10732.f11998.setAlpha(C2970.this.f10733.mo1292() ? 0.3f : 0.2f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC3009(), 100L);
            return false;
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޖ, reason: contains not printable characters */
    public class C3010 implements LooksPreviewPortraitView.InterfaceC1331 {
        public C3010() {
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: Ϳ */
        public void mo3734() {
            C2970.this.f10733.mo1181();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: Ԩ */
        public void mo3735() {
            C2970.this.f10733.mo1182();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: ԩ */
        public void mo3736() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: Ԫ */
        public void mo3737(int i, float f) {
            C2970.this.f10733.mo1184(i, f);
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: ԫ */
        public void mo3738(int i) {
            C2970.this.f10733.mo1260(i);
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: Ԭ */
        public void mo3739(int i) {
            C2970.this.f10733.mo1241();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: ԭ */
        public boolean mo3740() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: Ԯ */
        public void mo3741(int i) {
            C2970.this.f10733.mo1280();
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: ԯ */
        public void mo3742(int i) {
            C2970.this.f10733.mo1233(i);
        }

        @Override // com.blink.academy.film.widgets.looks.LooksPreviewPortraitView.InterfaceC1331
        /* renamed from: ՠ */
        public void mo3743(int i) {
            C2970.this.f10733.mo1190(i);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޗ, reason: contains not printable characters */
    public class ViewOnClickListenerC3011 implements View.OnClickListener {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޗ$Ϳ, reason: contains not printable characters */
        public class C3012 extends AbstractC4012 {
            public C3012() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public ViewOnClickListenerC3011() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C2970.this.f10733.mo1292()) {
                C2970.this.f10733.mo1285(26);
            } else if (C2970.this.f10732.f12000.m2813()) {
                C2970.this.f10732.f12000.m2807(100, new C3012());
            } else {
                C2970.this.mo10520(11);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޘ, reason: contains not printable characters */
    public class C3013 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޘ$Ϳ, reason: contains not printable characters */
        public class C3014 extends AbstractC4012 {
            public C3014() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public C3013() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C2970.this.f10733.mo1248() != 1) {
                return;
            }
            if (C2970.this.f10732.f12080.m2521()) {
                C2970.this.f10732.f12080.m2519(100, new C3014());
            } else {
                C2970.this.mo10520(1);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޙ, reason: contains not printable characters */
    public class C3015 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޙ$Ϳ, reason: contains not printable characters */
        public class C3016 extends AbstractC4012 {
            public C3016() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public C3015() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C2970.this.f10733.mo1248() != 1) {
                return;
            }
            if (C2970.this.f10732.f12027.m2228()) {
                C2970.this.f10732.f12027.m2226(100, new C3016());
            } else {
                C2970.this.mo10520(2);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޚ, reason: contains not printable characters */
    public class C3017 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޚ$Ϳ, reason: contains not printable characters */
        public class C3018 extends AbstractC4012 {
            public C3018() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public C3017() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C2970.this.f10733.mo1248() == 1) {
                if (C2970.this.f10732.f12088.m3382()) {
                    C2970.this.f10732.f12088.m3376(100, new C3018());
                } else {
                    C2970.this.mo10520(3);
                }
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޛ, reason: contains not printable characters */
    public class C3019 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޛ$Ϳ, reason: contains not printable characters */
        public class C3020 extends AbstractC4012 {
            public C3020() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public C3019() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C2970.this.f10733.mo1248() == 1) {
                if (C2970.this.f10732.f12061.m3295()) {
                    C2970.this.f10732.f12061.m3291(100, new C3020());
                } else {
                    C2970.this.mo10520(4);
                }
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޜ, reason: contains not printable characters */
    public class C3021 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޜ$Ϳ, reason: contains not printable characters */
        public class C3022 extends AbstractC4012 {
            public C3022() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public C3021() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C2970.this.f10733.mo1248() != 1) {
                return;
            }
            if (C2970.this.f10732.f12098.m2722()) {
                C2970.this.f10732.f12098.m2719(100, new C3022());
            } else {
                C2970.this.mo10520(5);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޝ, reason: contains not printable characters */
    public class C3023 implements DoubleTextLayout.InterfaceC1011 {

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޝ$Ϳ, reason: contains not printable characters */
        public class C3024 extends AbstractC4012 {
            public C3024() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                C2970.this.mo10630();
                C2970.this.m10538(8);
            }
        }

        public C3023() {
        }

        @Override // com.blink.academy.film.widgets.camerainfo.DoubleTextLayout.InterfaceC1011
        public void onClick(View view) {
            if (C2970.this.f10733.mo1248() == 1 && C2970.this.f10733.mo1270()) {
                if (C2970.this.f10732.f12066.m2452()) {
                    C2970.this.f10732.f12066.m2450(100, new C3024());
                } else {
                    C2970.this.mo10520(6);
                }
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޞ, reason: contains not printable characters */
    public class C3025 implements AutoZoomWheelView.InterfaceC1160 {
        public C3025() {
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        public void onAnimChange(boolean z) {
            C2970.this.f10819 = z;
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        public void onTouchChange(boolean z) {
            C2970.this.f10818 = z;
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        /* renamed from: Ϳ */
        public void mo3236(float f, float f2, float f3) {
            C2970.this.f10733.mo1254(f, f2, f3);
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        /* renamed from: Ԩ */
        public boolean mo3237(float f, float f2) {
            return (C2970.this.f10733 == null || !C2970.this.f10732.f11997.m3206(f, f2) || C2970.this.f10733.mo1234()) && C2970.this.f10733.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.iso.AutoZoomWheelView.InterfaceC1160
        /* renamed from: ԩ */
        public void mo3238(boolean z, int i) {
            C2970.this.f10733.mo1303(z, i);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޟ, reason: contains not printable characters */
    public class ViewOnTouchListenerC3026 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public float f10881;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public float f10882;

        /* renamed from: ԭ, reason: contains not printable characters */
        public float f10883;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public float f10884;

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޟ$Ϳ, reason: contains not printable characters */
        public class C3027 implements C4202.InterfaceC4205 {
            public C3027() {
            }

            @Override // defpackage.C4202.InterfaceC4205
            public void end() {
                C2970.this.f10732.f12011.setDrawIcon(true);
                C2970.this.f10733.mo1289(true);
                C2970.this.f10733.getHandler().sendEmptyMessageDelayed(109, 1500L);
            }

            @Override // defpackage.C4202.InterfaceC4205
            /* renamed from: Ϳ, reason: contains not printable characters */
            public void mo10644(float f) {
                C2970.this.f10732.f12011.setViewScale(Float.valueOf(f));
            }
        }

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ޟ$Ԩ, reason: contains not printable characters */
        public class C3028 implements C4202.InterfaceC4205 {
            public C3028() {
            }

            @Override // defpackage.C4202.InterfaceC4205
            public void end() {
                C2970.this.f10732.f12011.setDrawIcon(true);
                C2970.this.f10733.mo1289(true);
                C2970.this.f10733.getHandler().sendEmptyMessageDelayed(109, 1500L);
            }

            @Override // defpackage.C4202.InterfaceC4205
            /* renamed from: Ϳ */
            public void mo10644(float f) {
                C2970.this.f10732.f12011.setViewScale(Float.valueOf(f));
            }
        }

        public ViewOnTouchListenerC3026() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    C2970 c2970 = C2970.this;
                    c2970.f17098 = false;
                    if (c2970.f10732.f12011.getVisibility() == 0) {
                        if (C2970.this.f10733.mo1223()) {
                            C2970.this.f10733.mo1224(false);
                            if (C2970.this.f10799 != null) {
                                C2970.this.f10799.end();
                            }
                            C2970.this.f10733.getHandler().removeMessages(107);
                            C2970.this.f10733.getHandler().removeMessages(105);
                            C2970.this.f10733.getHandler().removeMessages(108);
                            C2970.this.f10733.getHandler().removeMessages(109);
                            if (C2970.this.f10732.f12010.getVisibility() == 0) {
                                C2970.this.f10732.f12011.setAlpha(1.0f);
                                C2970.this.f10733.mo1289(false);
                                C4202.m13274().m13279(C4202.m13274().m13280(), C4202.m13274().m13282(), 100, new C3027());
                            } else {
                                C2970.this.f10732.f12011.setAlpha(1.0f);
                                C2970.this.f10733.mo1289(false);
                                C4202.m13274().m13279(C4202.m13274().m13280(), C4202.m13274().m13282(), 100, new C3028());
                            }
                        } else if (C2970.this.f10798) {
                            C2970.this.f10733.getHandler().sendEmptyMessageDelayed(109, 1500L);
                        }
                    }
                    if (!C2970.this.f10732.f12011.isShown() && !C2970.this.f10733.mo1227() && C2970.this.m10460()) {
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        if (C2970.this.m10440(this.f10884, this.f10883)) {
                            float fAbs = Math.abs(rawX - this.f10884);
                            float fAbs2 = Math.abs(rawY - this.f10883);
                            if (Math.max(fAbs, fAbs2) >= 20.0f) {
                                if (fAbs <= fAbs2) {
                                    C2970.this.f10733.mo1255();
                                } else if (C4151.m13162().m13176() != 2 && C4151.m13162().m13176() != 3) {
                                    C2970.this.f10733.mo1239(this.f10884 > rawX);
                                }
                            }
                        }
                    }
                } else if (action == 2) {
                    if (C2970.this.f10732.f12011.isShown() && !C2970.this.f10733.mo1223() && C2970.this.f10733.mo1294()) {
                        C2970.this.f10733.mo1249(false);
                        C2970.this.f10798 = true;
                        C2970.this.f10732.f12011.setViewAlpha(1.0f);
                        C2970.this.f10732.f12011.m3149();
                        C2970.this.m10458(motionEvent);
                        C2970.this.f10800 = true;
                    } else if (!C2970.this.f10732.f12011.isShown() && C2970.this.f10733.mo1227() && C2970.this.m10460()) {
                        float y = motionEvent.getY();
                        float x = motionEvent.getX() - C2970.this.f10797;
                        float f = y - C2970.this.f10796;
                        C4638.m14101("WME_", "x: " + this.f10882 + x + " y: " + this.f10881 + f);
                        C2970.this.f10733.mo1282(this.f10882 + x, this.f10881 + f);
                    }
                }
            } else {
                this.f10884 = motionEvent.getRawX();
                this.f10883 = motionEvent.getRawY();
                C2970.this.f10796 = motionEvent.getY();
                C2970.this.f10797 = motionEvent.getX();
                this.f10882 = C2970.this.f10733.mo1213();
                this.f10881 = C2970.this.f10733.mo1226();
                C2970 c29702 = C2970.this;
                c29702.f17098 = true;
                c29702.f10733.getHandler().removeMessages(107);
                C2970.this.f10733.getHandler().removeMessages(105);
                C2970.this.f10733.getHandler().removeMessages(108);
                C2970.this.f10733.getHandler().removeMessages(109);
            }
            if (!C2970.this.f10733.mo1270() && !C2970.this.f10733.mo1227()) {
                C2970.this.f10795.onTouchEvent(motionEvent);
            }
            return true;
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޠ, reason: contains not printable characters */
    public class C3029 implements SlideBarView.InterfaceC1144 {
        public C3029() {
        }

        @Override // com.blink.academy.film.widgets.exposure.SlideBarView.InterfaceC1144
        /* renamed from: Ϳ */
        public void mo3171(float f) {
            C2970.this.f10733.mo1238(f);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޡ, reason: contains not printable characters */
    public class C3030 implements AudioSettingView.InterfaceC0870 {
        public C3030() {
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: Ϳ */
        public void mo2175() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: Ԩ */
        public void mo2176(int i) {
            C2970.this.mo10589(i);
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: ނ */
        public void mo2177(boolean z) {
            C2970.this.f10733.mo1197(z);
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: ވ */
        public boolean mo2178() {
            return C2970.this.f10733.mo1203();
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: ފ */
        public void mo2179(float f) {
            C2970.this.f10733.mo1205(f);
        }

        @Override // com.blink.academy.film.widgets.AudioSettingView.InterfaceC0870
        /* renamed from: ތ */
        public void mo2180(int i) {
            C2970.this.f10733.mo1207(i);
            C2970.this.mo10589(i);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޢ, reason: contains not printable characters */
    public class GestureDetectorOnGestureListenerC3031 implements GestureDetector.OnGestureListener {
        public GestureDetectorOnGestureListenerC3031() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            C2970.this.f10800 = false;
            if (!C2970.this.f10732.f12011.isShown()) {
                return false;
            }
            C2970.this.f10732.f12011.m3150();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return (motionEvent == null || motionEvent2 == null) ? false : true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if ((C2970.this.f10733.mo1268() || C2970.this.f10733.mo1284()) && C2970.this.f10733.mo1248() == 1) {
                C2970.this.f10733.mo1224(true);
                C2970.this.f10733.mo1290(motionEvent.getX(), motionEvent.getY(), false, false);
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
            C2970.this.f10732.f12010.setVisibility(8);
            C2970.this.f10732.f12009.setVisibility(8);
            C2970.this.m10540();
            if ((C2970.this.f10733.mo1291() || C2970.this.f10733.mo1251()) && C2970.this.f10733.mo1248() == 1) {
                C2970.this.f10733.mo1290(motionEvent.getX(), motionEvent.getY(), true, false);
            }
            return true;
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޣ, reason: contains not printable characters */
    public class C3032 implements GridsSettingView.InterfaceC0917 {
        public C3032() {
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: Ϳ */
        public boolean mo2366() {
            return C2970.this.f10733.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: Ԩ */
        public void mo2367(boolean z) {
            C2970.this.f10733.mo1242(z);
            C2970.this.f10732.f12041.invalidate();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: ԩ */
        public void mo2368(float f) {
            C2970.this.f10732.f12041.m2421(f);
            C4535.m13880().m13890().m12352((int) (f * 100.0f));
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: Ԫ */
        public void mo2369(boolean z) {
            C2970.this.mo10635(z);
            HorizonCircleRectView.f2347 = true;
            C2970.this.f10732.f12042.m2441(C2970.this.f10733.mo1250(), C2970.this.f10733.mo1244(), false);
            C4535.m13880().m13890().m12543(z ? 1 : 0);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: ԫ */
        public void mo2370(boolean z) {
            C2970.this.f10732.f12041.m2418(z);
            C4535.m13880().m13890().m12435(z ? 1 : 0);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: Ԭ */
        public void mo2371(boolean z) {
            C2970.this.f10732.f12041.m2419(z);
            C4535.m13880().m13890().m12521(z ? 1 : 0);
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: ހ */
        public void mo2372(float f, float f2, boolean z) {
            C2970.this.f10733.mo1195(f, f2, z);
        }

        @Override // com.blink.academy.film.widgets.GridsSettingView.InterfaceC0917
        /* renamed from: ރ */
        public void mo2373(boolean z) {
            C2970.this.f10733.mo1198(z);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޤ, reason: contains not printable characters */
    public class C3033 implements CameraTouchView.InterfaceC1143 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ CameraTouchView.InterfaceC1143 f10892;

        public C3033(CameraTouchView.InterfaceC1143 interfaceC1143) {
            this.f10892 = interfaceC1143;
        }

        @Override // com.blink.academy.film.widgets.exposure.CameraTouchView.InterfaceC1143
        /* renamed from: Ϳ */
        public void mo1326() {
            this.f10892.mo1326();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޥ, reason: contains not printable characters */
    public class C3034 implements FocusZoomWheelView.InterfaceC1175 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ FocusZoomWheelView.InterfaceC1175 f10894;

        public C3034(FocusZoomWheelView.InterfaceC1175 interfaceC1175) {
            this.f10894 = interfaceC1175;
        }

        @Override // com.blink.academy.film.widgets.iso.FocusZoomWheelView.InterfaceC1175
        /* renamed from: Ϳ */
        public void mo1325() {
            FocusZoomWheelView.InterfaceC1175 interfaceC1175 = this.f10894;
            if (interfaceC1175 != null) {
                interfaceC1175.mo1325();
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ޱ, reason: contains not printable characters */
    public class RunnableC3035 implements Runnable {
        public RunnableC3035() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2970.this.f10732.f12023.setVisibility(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$߾, reason: contains not printable characters */
    public class C3036 extends AbstractC4012 {
        public C3036() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$߿, reason: contains not printable characters */
    public class C3037 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f10898;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ ConstraintLayout.LayoutParams f10899;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ TextPaint f10900;

        public C3037(String str, ConstraintLayout.LayoutParams layoutParams, TextPaint textPaint) {
            this.f10898 = str;
            this.f10899 = layoutParams;
            this.f10900 = textPaint;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.f10732.f12055.setText(this.f10898);
            C2970.this.f10732.f12055.setAlpha(1.0f);
            C2970.this.f10732.f12056.setAlpha(0.0f);
            C2970.this.f10732.f12056.setText("");
            ((ViewGroup.MarginLayoutParams) this.f10899).width = (int) (this.f10900.measureText(this.f10898) + C4792.f16138);
            C2970.this.f10732.f12055.setLayoutParams(this.f10899);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡠ, reason: contains not printable characters */
    public class C3038 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ float f10902;

        public C3038(float f) {
            this.f10902 = f;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            C2970.this.f10801 = (int) (this.f10902 / 2.0f);
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            int i = (int) (C2970.this.f10801 + (((this.f10902 / 2.0f) - C2970.this.f10801) * f));
            ViewGroup.LayoutParams layoutParams = C2970.this.f10732.f12002.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = C2579.f9593;
            C2970.this.f10732.f12002.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = C2970.this.f10732.f12003.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            C2970.this.f10732.f12003.setLayoutParams(layoutParams2);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡡ, reason: contains not printable characters */
    public class C3039 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ float f10904;

        public C3039(float f) {
            this.f10904 = f;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            C2970.this.f10802 = (int) (this.f10904 / 2.0f);
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            int i = (int) (C2970.this.f10802 + (((this.f10904 / 2.0f) - C2970.this.f10802) * f));
            ViewGroup.LayoutParams layoutParams = C2970.this.f10732.f12004.getLayoutParams();
            layoutParams.width = C2579.f9594;
            layoutParams.height = i;
            C2970.this.f10732.f12004.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = C2970.this.f10732.f12001.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            C2970.this.f10732.f12001.setLayoutParams(layoutParams2);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡢ, reason: contains not printable characters */
    public class ViewOnClickListenerC3040 implements View.OnClickListener {
        public ViewOnClickListenerC3040() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2970.this.f10733.mo1267() == 1 || !C2970.this.m10460()) {
                return;
            }
            C2970.this.f10733.mo1243();
            C2970.this.f10732.f12053.setEnabled(false);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡣ, reason: contains not printable characters */
    public class C3041 implements ZebraSettingView.InterfaceC0992 {
        public C3041() {
        }

        @Override // com.blink.academy.film.widgets.ZebraSettingView.InterfaceC0992
        /* renamed from: Ϳ */
        public void mo2754(boolean z) {
            C3947.m12727().m12778(z ? 1 : 0);
        }

        @Override // com.blink.academy.film.widgets.ZebraSettingView.InterfaceC0992
        /* renamed from: Ԩ */
        public boolean mo2755() {
            return C2970.this.f10733.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.ZebraSettingView.InterfaceC0992
        /* renamed from: ׯ */
        public void mo2756(int i) {
            C2970.this.f10733.mo1193(i);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡤ, reason: contains not printable characters */
    public class ViewOnClickListenerC3042 implements View.OnClickListener {
        public ViewOnClickListenerC3042() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2970.this.m10445()) {
                C2970.this.f10733.mo1265();
                C2970 c2970 = C2970.this;
                c2970.m10441(c2970.f10732.f12044, C2970.this.f10732.f12045, C2970.this.f10733.mo1221());
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡥ, reason: contains not printable characters */
    public class ViewOnClickListenerC3043 implements View.OnClickListener {
        public ViewOnClickListenerC3043() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2970.this.m10445()) {
                C2970.this.f10733.mo1277();
                C2970 c2970 = C2970.this;
                c2970.m10441(c2970.f10732.f12046, C2970.this.f10732.f12047, C2970.this.f10733.mo1227());
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡦ, reason: contains not printable characters */
    public class ViewOnClickListenerC3044 implements View.OnClickListener {
        public ViewOnClickListenerC3044() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2970.this.m10445()) {
                C2970.this.f10733.mo1217();
                C2970.this.f10733.mo1215();
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡧ, reason: contains not printable characters */
    public class C3045 implements C4202.InterfaceC4205 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f10911;

        public C3045(boolean z) {
            this.f10911 = z;
        }

        @Override // defpackage.C4202.InterfaceC4205
        public void end() {
            C2970.this.f10733.mo1289(true);
            C4202.m13274().m13278(C2970.this.f10733.getHandler(), true, this.f10911);
        }

        @Override // defpackage.C4202.InterfaceC4205
        /* renamed from: Ϳ */
        public void mo10644(float f) {
            C2970.this.f10732.f12011.setViewScale(Float.valueOf(f));
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡨ, reason: contains not printable characters */
    public class C3046 implements ValueAnimator.AnimatorUpdateListener {
        public C3046() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (C2970.this.f10732 == null || C2970.this.f17098) {
                return;
            }
            C2970.this.f10732.f12011.setLineAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡩ, reason: contains not printable characters */
    public class C3047 implements Animator.AnimatorListener {
        public C3047() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (C2970.this.f10732 == null) {
                return;
            }
            C2970 c2970 = C2970.this;
            if (c2970.f17098) {
                return;
            }
            c2970.f10732.f12011.setNeedDrawLine(false);
            C2970.this.mo10472();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࡪ, reason: contains not printable characters */
    public class C3048 implements C4202.InterfaceC4205 {
        public C3048() {
        }

        @Override // defpackage.C4202.InterfaceC4205
        public void end() {
            if (C2970.this.f10732 == null) {
                return;
            }
            C2970 c2970 = C2970.this;
            if (c2970.f17098) {
                return;
            }
            c2970.f10733.mo1289(true);
            C2970.this.f10733.mo1249(true);
            C2970.this.f10732.f12011.setNeedDrawLine(false);
        }

        @Override // defpackage.C4202.InterfaceC4205
        /* renamed from: Ϳ */
        public void mo10644(float f) {
            if (C2970.this.f10732 != null && C2970.this.f10733.mo1252()) {
                C2970 c2970 = C2970.this;
                if (c2970.f17098) {
                    return;
                }
                c2970.f10732.f12011.setSlidebarAndTouchAlpha(f);
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢠ, reason: contains not printable characters */
    public class RunnableC3049 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ long f10916;

        public RunnableC3049(long j) {
            this.f10916 = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2970.this.f10732.f12028.getVisibility() != 0) {
                C2970.this.f10732.f12028.setVisibility(0);
            }
            C2970.this.f10732.f12028.setText(String.format(C2970.this.getString(R.string.RECORDING_ALERT_FRAME_DROP), Long.valueOf(this.f10916)).toUpperCase(Locale.US));
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢡ, reason: contains not printable characters */
    public class C3050 extends AbstractC4012 {
        public C3050() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢢ, reason: contains not printable characters */
    public class RunnableC3051 implements Runnable {
        public RunnableC3051() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢣ, reason: contains not printable characters */
    public class C3052 implements WbSettingView.InterfaceC0987 {
        public C3052() {
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: Ϳ */
        public boolean mo2735() {
            return C2970.this.f10733.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: Ԩ */
        public void mo2736() {
            C4535.m13880().m13915();
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: ԩ */
        public void mo2737() {
            C2970.this.f10733.mo1256();
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: ؠ */
        public void mo2738(int i, int i2) {
            C2970.this.f10733.mo1194(i, i2);
        }

        @Override // com.blink.academy.film.widgets.WbSettingView.InterfaceC0987
        /* renamed from: ށ */
        public void mo2739(w7 w7Var) {
            C2970.this.f10733.mo1196(w7Var);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢤ, reason: contains not printable characters */
    public class C3053 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f10921;

        public C3053(Runnable runnable) {
            this.f10921 = runnable;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            Runnable runnable = this.f10921;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢥ, reason: contains not printable characters */
    public class RunnableC3054 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f10923;

        /* compiled from: HomePortraitFragment.java */
        /* renamed from: ҫ$ࢥ$Ϳ, reason: contains not printable characters */
        public class RunnableC3055 implements Runnable {
            public RunnableC3055() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C2970.this.f10781 = false;
                C2970.this.m10538(0);
            }
        }

        public RunnableC3054(int i) {
            this.f10923 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2970.this.m10643(null);
            switch (this.f10923) {
                case 1:
                    C2970.this.f10732.f12080.m2526(100);
                    break;
                case 2:
                    C2970.this.f10732.f12027.m2239(100);
                    break;
                case 3:
                    C2970.this.f10732.f12088.m3387(100);
                    break;
                case 4:
                    C2970.this.f10732.f12061.m3300(100);
                    break;
                case 5:
                    C2970.this.f10732.f12098.m2732(100);
                    break;
                case 6:
                    C2970.this.f10732.f12066.m2459(100);
                    break;
                case 7:
                    C2970.this.f10732.f12068.m3730(100);
                    break;
                case 8:
                    C2970.this.f10732.f11996.m2142(100);
                    break;
                case 9:
                    C2970.this.m10442(100);
                    break;
                case 10:
                    C2970.this.f10732.f12100.m2753(100);
                    break;
                case 11:
                    C2970.this.f10732.f12000.m2825(100);
                    break;
            }
            C2970.this.f10733.getHandler().postDelayed(new RunnableC3055(), 100L);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢦ, reason: contains not printable characters */
    public class C3056 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f10926;

        public C3056(boolean z) {
            this.f10926 = z;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            boolean z = !this.f10926;
            C2970.this.f10733.mo1274(z);
            C2970.this.f10732.f12078.setEnabled(z);
            C2970.this.f10732.f12025.setEnabled(z);
            C2970.this.f10732.f12086.setEnabled(z);
            C2970.this.f10732.f12058.setEnabled(z);
            C2970.this.f10732.f12096.setEnabled(z);
            C2970.this.f10732.f12064.setEnabled(z);
            C2970.this.f10733.mo1212();
            C2970.this.f10732.f12020.setEnabled(z);
            C2970.this.f10732.f12085.setEnabled(z);
            C2970.this.f10732.f12021.setEnabled(z);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢧ, reason: contains not printable characters */
    public class C3057 extends AbstractC4012 {
        public C3057() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.f10732.f12093.setEnabled(true);
            C2970.this.f10732.f12099.setVisibility(0);
            C2970.this.f10732.f12095.setVisibility(0);
            C2970.this.f10732.f12087.setVisibility(0);
            C2970.this.f10732.f12086.setVisibility(0);
            C2970.this.f10732.f12059.setVisibility(0);
            C2970.this.f10732.f12058.setVisibility(0);
            C2970.this.f10732.f12097.setVisibility(0);
            C2970.this.f10732.f12096.setVisibility(0);
            C2970.this.f10732.f12065.setVisibility(0);
            C2970.this.f10732.f12064.setVisibility(0);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢨ, reason: contains not printable characters */
    public class C3058 extends AbstractC4012 {
        public C3058() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.f10732.f12093.setEnabled(false);
            C2970.this.f10732.f12099.setVisibility(8);
            C2970.this.f10732.f12095.setVisibility(8);
            C2970.this.f10732.f12087.setVisibility(8);
            C2970.this.f10732.f12086.setVisibility(8);
            C2970.this.f10732.f12059.setVisibility(8);
            C2970.this.f10732.f12058.setVisibility(8);
            C2970.this.f10732.f12097.setVisibility(8);
            C2970.this.f10732.f12096.setVisibility(8);
            C2970.this.f10732.f12065.setVisibility(8);
            C2970.this.f10732.f12064.setVisibility(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢩ, reason: contains not printable characters */
    public class C3059 extends AbstractC4012 {
        public C3059() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.f10732.f12063.setVisibility(0);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢪ, reason: contains not printable characters */
    public class C3060 extends AbstractC4012 {
        public C3060() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.f10732.f12063.setVisibility(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢫ, reason: contains not printable characters */
    public class C3061 implements FPSPortraitSettingView.InterfaceC0882 {
        public C3061() {
        }

        @Override // com.blink.academy.film.widgets.FPSPortraitSettingView.InterfaceC0882
        /* renamed from: Ϳ */
        public void mo2240(int i, int i2, String str) {
            C2970 c2970 = C2970.this;
            c2970.m10628(str, c2970.f10733.mo1281(), C2970.this.f10733.mo1287(), i2, i);
        }

        @Override // com.blink.academy.film.widgets.FPSPortraitSettingView.InterfaceC0882
        /* renamed from: Ԩ */
        public boolean mo2241() {
            return C2970.this.f10733.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.FPSPortraitSettingView.InterfaceC0882
        /* renamed from: ԫ */
        public void mo2242(boolean z, boolean z2, boolean z3) {
            C2970.this.f10733.mo1185(z, z2, z3);
        }

        @Override // com.blink.academy.film.widgets.FPSPortraitSettingView.InterfaceC0882
        /* renamed from: Ԭ */
        public void mo2243(int i, int i2, String str, int i3) {
            C2970.this.f10733.mo1186(i, i2, str, i3);
        }

        @Override // com.blink.academy.film.widgets.FPSPortraitSettingView.InterfaceC0882
        /* renamed from: ԯ */
        public void mo2244(int i, String str) {
            C2970.this.f10733.mo1189(i, str);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢬ, reason: contains not printable characters */
    public class C3062 implements ResolutionSettingView.InterfaceC0947 {
        public C3062() {
        }

        @Override // com.blink.academy.film.widgets.ResolutionSettingView.InterfaceC0947
        /* renamed from: Ϳ */
        public boolean mo2527() {
            return C2970.this.f10733.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.ResolutionSettingView.InterfaceC0947
        /* renamed from: Ԩ */
        public boolean mo2528() {
            return C2970.this.f10733.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.ResolutionSettingView.InterfaceC0947
        /* renamed from: ޅ */
        public void mo2529(int i) {
            C2970.this.f10733.mo1200(i);
        }

        @Override // com.blink.academy.film.widgets.ResolutionSettingView.InterfaceC0947
        /* renamed from: އ */
        public void mo2530(w5 w5Var) {
            C2970.this.mo10574(w5Var.m8506().m8845());
            C2970.this.f10733.mo1202(w5Var);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢭ, reason: contains not printable characters */
    public class C3063 extends AbstractC4012 {
        public C3063() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢮ, reason: contains not printable characters */
    public class C3064 implements LensSettingView.InterfaceC0928 {
        public C3064() {
        }

        @Override // com.blink.academy.film.widgets.LensSettingView.InterfaceC0928
        /* renamed from: Ϳ */
        public boolean mo2460() {
            return C2970.this.f10733.mo1248() == 1;
        }

        @Override // com.blink.academy.film.widgets.LensSettingView.InterfaceC0928
        /* renamed from: ލ */
        public void mo2461(C3828 c3828) {
            C2970.this.f10733.mo1208(c3828);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢯ, reason: contains not printable characters */
    public class C3065 extends AbstractC4012 {
        public C3065() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢰ, reason: contains not printable characters */
    public class C3066 extends AbstractC4012 {
        public C3066() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢱ, reason: contains not printable characters */
    public class C3067 extends AbstractC4012 {
        public C3067() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢲ, reason: contains not printable characters */
    public class C3068 extends AbstractC4012 {
        public C3068() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢳ, reason: contains not printable characters */
    public class C3069 extends AbstractC4012 {
        public C3069() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢴ, reason: contains not printable characters */
    public class C3070 extends AbstractC4012 {
        public C3070() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢶ, reason: contains not printable characters */
    public class C3071 extends AbstractC4012 {
        public C3071() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢷ, reason: contains not printable characters */
    public class C3072 extends AbstractC4012 {
        public C3072() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢸ, reason: contains not printable characters */
    public class C3073 extends AbstractC4012 {
        public C3073() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢹ, reason: contains not printable characters */
    public class C3074 extends AbstractC4012 {
        public C3074() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C2970.this.mo10630();
            C2970.this.m10538(8);
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢺ, reason: contains not printable characters */
    public class C3075 implements ShutterView.InterfaceC1236 {
        public C3075() {
        }

        @Override // com.blink.academy.film.widgets.iso.ShutterView.InterfaceC1236
        public void onChange() {
            C2970.this.mo10618();
            C2970.this.m10437();
            C2970.this.f10733.mo1295();
        }

        @Override // com.blink.academy.film.widgets.iso.ShutterView.InterfaceC1236
        /* renamed from: Ϳ */
        public void mo3442() {
            C2970.this.m10437();
            C2970.this.mo10618();
            C2970.this.m10431();
        }

        @Override // com.blink.academy.film.widgets.iso.ShutterView.InterfaceC1236
        /* renamed from: ֏ */
        public void mo3443() {
            C2970.this.f10733.mo1192();
        }
    }

    /* compiled from: HomePortraitFragment.java */
    /* renamed from: ҫ$ࢻ, reason: contains not printable characters */
    public class C3076 implements ISOView.InterfaceC1185 {
        public C3076() {
        }

        @Override // com.blink.academy.film.widgets.iso.ISOView.InterfaceC1185
        public void onChange() {
            C2970.this.mo10606();
            C2970.this.f10733.mo1295();
            C2970.this.mo10534();
        }

        @Override // com.blink.academy.film.widgets.iso.ISOView.InterfaceC1185
        /* renamed from: ֏ */
        public void mo3301() {
            C2970.this.f10733.mo1192();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ང, reason: contains not printable characters */
    public /* synthetic */ void m10405(ValueAnimator valueAnimator) {
        this.f10732.f12011.setViewScale((Float) valueAnimator.getAnimatedValue());
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) throws JSONException {
        if (this.f10732 == null) {
            this.f10732 = AbstractC3481.m11334(layoutInflater, viewGroup, false);
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.setClassLoader(getClass().getClassLoader());
            }
            if (arguments != null) {
                try {
                    this.f10733 = (FragmentCallback) arguments.getParcelable("fcallback");
                } catch (Exception unused) {
                    this.f10733 = C4425.m13657().m13658();
                }
            }
            m10543();
            this.f10733.mo1275();
        }
        this.f10783 = (SensorManager) getActivity().getSystemService(am.ac);
        return this.f10732.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        m10629();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = new float[3];
        m10459((float[]) sensorEvent.values.clone(), fArr);
        float f = (-fArr[0]) / 9.80665f;
        float f2 = (-fArr[1]) / 9.80665f;
        float f3 = (-fArr[2]) / 9.80665f;
        double dAtan2 = 180.0d * (Math.atan2(f3, Math.sqrt((f * f) + (f2 * f2))) / 3.141592653589793d);
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 != null) {
            HorizonCircleRectView.f2347 = true;
            abstractC3481.f12042.m2442(f, f2, f3, dAtan2);
        }
    }

    /* renamed from: Ĩ, reason: contains not printable characters */
    public final void m10428(int i) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12070.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = this.f10751;
        this.f10732.f12070.setLayoutParams(layoutParams);
    }

    /* renamed from: ĩ, reason: contains not printable characters */
    public final void m10429(int i) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12061.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12061.setLayoutParams(layoutParams);
        this.f10732.f12061.setPadding(this.f10787);
        this.f10732.f12061.setOnISOChange(new C3076());
        this.f10732.f12061.setOnVStateChange(new C2971());
        this.f10732.f12088.setOnVStateChange(new C2972());
        this.f10732.f12061.m3291(0, null);
    }

    /* renamed from: ī, reason: contains not printable characters */
    public final void m10430(int i, int i2) {
    }

    /* renamed from: ĭ, reason: contains not printable characters */
    public final void m10431() {
        if (this.f10733.mo1270()) {
            int iM14464 = this.f10766 + this.f10767 + this.f10768 + this.f10769 + this.f10770 + this.f10771 + (this.f10744 * 2) + (C4792.m14375().m14464() * 4);
            this.f10765 = 1.0f;
            if (iM14464 > C2579.m9440(getContext())) {
                this.f10765 = (C2579.m9440(getContext()) * 1.0f) / iM14464;
            }
            C4792.m14375().m14509(this.f10765);
        } else {
            int iM144642 = this.f10766 + this.f10767 + C4792.m14375().m14464();
            this.f10765 = 1.0f;
            int i = this.f10791;
            if (iM144642 > i) {
                this.f10765 = (i * 1.0f) / iM144642;
            }
        }
        if (this.f10733.mo1270()) {
            this.f10732.f12022.setPivotX(this.f10773);
            this.f10732.f12022.setPivotY(this.f10774);
        } else {
            this.f10732.f12022.setPivotX(this.f10773);
            this.f10732.f12022.setPivotY(this.f10775);
        }
        this.f10732.f12022.setScaleX(this.f10765);
        this.f10732.f12022.setScaleY(this.f10765);
    }

    /* renamed from: ı, reason: contains not printable characters */
    public final void m10432(int i) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12027.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12027.setLayoutParams(layoutParams);
        this.f10732.f12027.setPadding(this.f10787);
        this.f10732.f12027.m2238(new C3061());
        this.f10732.f12027.m2226(0, null);
    }

    /* renamed from: ĺ, reason: contains not printable characters */
    public final void m10433(int i) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12066.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12066.setLayoutParams(layoutParams);
        this.f10732.f12066.setPadding(this.f10787);
        this.f10732.f12066.m2457(new C3064());
        this.f10732.f12066.m2450(0, null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ľ, reason: contains not printable characters */
    public final void m10434() {
        int iM14420 = C4792.m14375().m14420();
        int iM14464 = C4792.m14375().m14464();
        int iM14460 = C4792.m14375().m14460() - 10;
        int iM144602 = ((int) (this.f10743 * this.f10789)) + iM14460 + C4792.m14375().m14460();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12022.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = C2579.f9598 * 2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C2579.m9438(44.0f) + iM144602;
        this.f10732.f12022.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12079.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = iM144602;
        float f = iM144602;
        this.f10759 = f;
        this.f10760 = this.f10732.f12079.getDoubleHeight() - 10;
        this.f10790 = C2579.m9438(44.0f) + iM14460;
        this.f10778 = iM14460;
        int iM14459 = C4792.m14375().m14459() + ((int) (C2579.f9598 / 2.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = iM14459;
        this.f10773 = iM14459;
        this.f10774 = f;
        this.f10775 = C4792.m14375().m14460() + ((this.f10743 * this.f10789) / 2.0f);
        this.f10732.f12078.getLayoutParams().width = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
        this.f10732.f12079.m2845(iM14420, 0, 0, 0);
        this.f10732.f12079.setPadding(0, 10, iM14464, 10);
        this.f10732.f12079.setTopTextContent(m15086(R.string.RECORDING_INFO_RES));
        this.f10732.f12079.setBottomTextContent("N/A");
        this.f10732.f12079.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f10732.f12079));
        this.f10732.f12079.setOnUnQuickClickListener(new C3013());
        this.f10732.f12025.getLayoutParams().width = this.f10732.f12026.getLayoutParams().width;
        this.f10732.f12026.m2845(iM14420, 0, 0, 0);
        this.f10732.f12026.setPadding(0, 10, iM14464, 10);
        this.f10732.f12026.setTopTextContent(m15086(R.string.RECORDING_INFO_FPS));
        this.f10732.f12026.setBottomTextContent("N/A");
        this.f10732.f12026.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f10732.f12026));
        this.f10732.f12026.setOnUnQuickClickListener(new C3015());
        ViewGroup.LayoutParams layoutParams3 = this.f10732.f12087.getLayoutParams();
        C4792.m14375().m14500();
        layoutParams3.width = C4792.m14375().m14475();
        this.f10732.f12086.getLayoutParams().width = layoutParams3.width;
        this.f10732.f12087.m2845(iM14420, 0, 0, 0);
        this.f10732.f12087.setPadding(0, 10, iM14464, 10);
        this.f10732.f12087.setTopTextContent(m15086(R.string.RECORDING_INFO_SHUTTER));
        mo10618();
        this.f10732.f12087.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f10732.f12087));
        this.f10732.f12087.setOnUnQuickClickListener(new C3017());
        ViewGroup.LayoutParams layoutParams4 = this.f10732.f12059.getLayoutParams();
        layoutParams4.width = C4792.m14375().m14436();
        this.f10732.f12058.getLayoutParams().width = layoutParams4.width;
        this.f10732.f12059.m2845(iM14420, 0, 0, 0);
        this.f10732.f12059.setPadding(0, 10, iM14464, 10);
        this.f10732.f12059.setTopTextContent(m15086(R.string.RECORDING_INFO_ISO));
        mo10606();
        DoubleTextLayout doubleTextLayout = this.f10732.f12059;
        doubleTextLayout.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(doubleTextLayout));
        this.f10732.f12059.setOnUnQuickClickListener(new C3019());
        ViewGroup.LayoutParams layoutParams5 = this.f10732.f12097.getLayoutParams();
        layoutParams5.width = C4792.m14375().m14487();
        this.f10732.f12096.getLayoutParams().width = layoutParams5.width;
        this.f10732.f12097.m2845(iM14420, 0, 0, 0);
        this.f10732.f12097.setPadding(0, 10, iM14464, 10);
        this.f10732.f12097.setTopTextContent(m15086(R.string.RECORDING_INFO_WB));
        float fM12469 = C4535.m13880().m13890().m12469();
        this.f10732.f12097.setBottomTextContent(Math.round(fM12469) + "K");
        this.f10732.f12097.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f10732.f12097));
        this.f10732.f12097.setOnUnQuickClickListener(new C3021());
        this.f10732.f12064.getLayoutParams().width = this.f10732.f12065.getLayoutParams().width;
        this.f10732.f12065.m2845(iM14420, 0, 0, 0);
        this.f10732.f12065.setPadding(0, 10, iM14464, 10);
        this.f10732.f12065.setTopTextContent(m15086(R.string.RECORDING_INFO_LENS));
        this.f10732.f12065.setCameraLensName(C2520.m9312().m9314());
        this.f10732.f12065.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(this.f10732.f12065));
        this.f10732.f12065.setOnUnQuickClickListener(new C3023());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ŀ, reason: contains not printable characters */
    public final void m10435() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12084.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (C4792.m14375().m14462() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (C4792.m14375().m14462() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (C4792.m14375().m14476(this.f10749) * this.f17096);
        this.f10732.f12084.setLayoutParams(layoutParams);
        this.f10756 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        this.f10757 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12019.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (C4792.m14375().m14462() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (C4792.m14375().m14462() * this.f17096);
        this.f10732.f12019.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f10732.f12067.getLayoutParams();
        int iM14476 = (int) (C4792.m14375().m14476(27) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams2).height - iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = (int) ((((ViewGroup.MarginLayoutParams) layoutParams2).width - (iM14476 / 2.0f)) - C4792.m14375().m14476(5));
        this.f10732.f12067.setStyle(false);
        this.f10732.f12067.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f10732.f12062.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (m15085(50) * this.f17096);
        int iM15085 = (int) (m15085(50) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = iM15085;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((int) ((((ViewGroup.MarginLayoutParams) layoutParams2).height / 2.0f) - iM15085));
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (int) ((((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin - (((ViewGroup.MarginLayoutParams) layoutParams4).width / 2.0f)) + m15085(10));
        this.f10732.f12062.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f10732.f12072.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) (C4792.m14375().m14462() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) (C4792.m14375().m14462() * this.f17096);
        this.f10732.f12072.setLayoutParams(layoutParams5);
        this.f10754 = ((ViewGroup.MarginLayoutParams) layoutParams5).height;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14398());
        textPaint.setTypeface(FilmApp.m404());
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        Math.round(fontMetrics.bottom - fontMetrics.top);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f10732.f12032.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = ((int) ((this.f10803 * this.f10789) * this.f17096)) - C2579.m9438(2.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = ((int) ((this.f10804 * this.f10789) * this.f17096)) - C2579.m9438(2.0f);
        this.f10732.f12032.setLayoutParams(layoutParams6);
        int i = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        this.f10794 = this.f10757 + i;
        int i2 = ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
        this.f10793 = i2 + (i2 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (i / 2);
        ViewGroup.LayoutParams layoutParams7 = this.f10732.f12033.getLayoutParams();
        layoutParams7.width = (int) (((ViewGroup.MarginLayoutParams) layoutParams6).width * 0.6917293f);
        layoutParams7.height = (int) (((ViewGroup.MarginLayoutParams) layoutParams6).width * 0.6917293f);
        this.f10732.f12033.setLayoutParams(layoutParams7);
        this.f10732.f12032.setOnClickListener(new ViewOnClickListenerC2999());
        FrameLayout frameLayout = this.f10732.f12032;
        frameLayout.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(frameLayout));
        AbstractC3481 abstractC3481 = this.f10732;
        abstractC3481.f12085.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC3481.f12084));
        this.f10732.f12085.setOnClickListener(new ViewOnClickListenerC3000());
        this.f10732.f12020.setOnTouchListener(new ViewOnTouchListenerC3001());
        this.f10732.f12020.setOnClickListener(new ViewOnClickListenerC3003());
        this.f10732.f12020.setOnLongClickListener(new ViewOnLongClickListenerC3005());
        this.f10732.f12021.setOnClickListener(new ViewOnClickListenerC3006());
        AbstractC3481 abstractC34812 = this.f10732;
        abstractC34812.f12073.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC34812.f12072));
        this.f10732.f12073.setOnClickListener(new ViewOnClickListenerC3007());
    }

    /* renamed from: ł, reason: contains not printable characters */
    public void m10436(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        C4008.m12876(abstractC3481.f12031, z ? 1.0f : 0.0f, 100, null);
    }

    /* renamed from: ſ, reason: contains not printable characters */
    public void m10437() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3330();
    }

    /* renamed from: ǃ, reason: contains not printable characters */
    public final void m10438(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12041.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f10732.f12041.setLayoutParams(layoutParams);
        m10455();
        m10430(i, i2);
        m10452(i3);
        mo10528();
        mo10560(this.f10733.mo1227());
        mo10573();
    }

    /* renamed from: ǐ, reason: contains not printable characters */
    public final void m10439(int i) {
        int iM14476 = C4792.m14375().m14476(95);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10732.f12060.getLayoutParams();
        int iM144762 = (int) ((C4792.m14375().m14476((C4792.m14375().m14488() * 2) + 658) * this.f17096) + 0.5f);
        int i2 = iM144762 + (iM144762 % 2);
        layoutParams.width = i2;
        layoutParams.height = i2;
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12018.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = layoutParams.height + C4792.m14375().m14476(20);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((int) ((C4792.m14375().m14476(C4792.m14375().m14488() + 242) * this.f17096) + 0.5f)) + iM14476 + i;
        this.f10732.f12018.setLayoutParams(layoutParams2);
        this.f10812 = (int) (((ViewGroup.MarginLayoutParams) layoutParams2).width - (C4792.m14375().m14488() * this.f17096));
        layoutParams.leftMargin = -((layoutParams.width - ((ViewGroup.MarginLayoutParams) layoutParams2).width) + iM14476);
        this.f10732.f12060.setLayoutParams(layoutParams);
        this.f10732.f12060.setCardWidth(((ViewGroup.MarginLayoutParams) layoutParams2).width);
        this.f10732.f12060.setOnChange(new C2973());
        if (this.f10733.mo1270()) {
            this.f10732.f12060.m3333(0);
        } else {
            this.f10732.f12060.m3319(0);
        }
    }

    /* renamed from: ȉ, reason: contains not printable characters */
    public final boolean m10440(float f, float f2) {
        return this.f10733.mo1270() ? f >= ((float) this.f10807) && f <= ((float) this.f10809) && f2 >= ((float) this.f10808) && f2 <= ((float) this.f10810) : f >= 0.0f && f <= ((float) this.f10809) && f2 >= ((float) (this.f10808 - this.f10790)) && f2 <= ((float) this.f10810);
    }

    /* renamed from: ȋ, reason: contains not printable characters */
    public void m10441(ImageView imageView, View view, boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        if (imageView == abstractC3481.f12052) {
            z = true;
        }
        C4008.m12876(imageView, z ? C4792.m14375().m14402() : 0.2f, 100, null);
    }

    /* renamed from: ɾ, reason: contains not printable characters */
    public void m10442(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12040.m2361(i);
    }

    /* renamed from: ʰ, reason: contains not printable characters */
    public final HomeActivity m10443() {
        return (HomeActivity) getActivity();
    }

    /* renamed from: ʱ, reason: contains not printable characters */
    public final void m10444() {
        this.f10732.f11996.m2132(100, new C3065());
    }

    /* renamed from: ʲ, reason: contains not printable characters */
    public final boolean m10445() {
        if (getActivity() != null) {
            if (C2579.m9451(getActivity())) {
                this.f10734 = true;
            } else {
                this.f10734 = C4792.m14375().m14484() >= 2.0f;
            }
        }
        return this.f10734;
    }

    /* renamed from: ʵ, reason: contains not printable characters */
    public final void m10446() {
        this.f10732.f12000.m2807(100, new C3066());
    }

    /* renamed from: ʶ, reason: contains not printable characters */
    public float m10447() {
        return this.f10736;
    }

    /* renamed from: ʷ, reason: contains not printable characters */
    public final void m10448() {
        m10484(100, new C3068());
    }

    /* renamed from: ʸ, reason: contains not printable characters */
    public final boolean m10449() {
        return this.f10732.f12080.m2521() || this.f10732.f12027.m2228() || this.f10732.f12098.m2722() || this.f10732.f12066.m2452() || this.f10732.f12088.m3382() || this.f10732.f12061.m3295() || m10461() || this.f10732.f12100.m2748() || this.f10732.f11996.m2136() || this.f10732.f12068.m3715() || this.f10732.f12000.m2813();
    }

    /* renamed from: ʺ, reason: contains not printable characters */
    public final float m10450() {
        float fM14476 = C2579.f9597 + (C4792.m14375().m14476(70) * 2);
        float fM9444 = C2579.m9444() - (C4792.m14375().m14442() * 2.0f);
        if (fM9444 < fM14476) {
            return fM9444 / fM14476;
        }
        return 1.0f;
    }

    /* renamed from: ˌ, reason: contains not printable characters */
    public final void m10451(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12015.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i;
        this.f10732.f12015.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f10732.f12011.getLayoutParams();
        layoutParams2.width = C2579.m9438(C4792.m14375().m14415());
        layoutParams2.height = C2579.m9438(C4792.m14375().m14415());
        this.f10732.f12011.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f10732.f12009.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = C4792.m14375().m14421();
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = C4792.m14375().m14460();
        this.f10732.f12009.setPadding(C4792.m14375().m14422(), 0, C4792.m14375().m14423(), 0);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f10732.f12010.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = C4792.m14375().m14421();
        int iM14460 = C4792.m14375().m14460();
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = iM14460;
        this.f10776 = iM14460;
        this.f10732.f12010.setPadding(C4792.m14375().m14422(), 0, C4792.m14375().m14423(), 0);
        ViewGroup.LayoutParams layoutParams5 = this.f10732.f12054.getLayoutParams();
        layoutParams5.width = i2;
        layoutParams5.height = i;
        this.f10732.f12054.setLayoutParams(layoutParams5);
        this.f10732.f12054.setOnTouchListener(new ViewOnTouchListenerC3026());
        this.f10732.f12011.setSlidebarCallback(new C3029());
        m10632();
    }

    /* renamed from: ˍ, reason: contains not printable characters */
    public final void m10452(int i) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12040.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12040.setLayoutParams(layoutParams);
        this.f10732.f12040.setPadding(this.f10787);
        this.f10732.f12040.setGridsChangeListener(new C3032());
        this.f10732.f12040.m2360();
    }

    /* renamed from: ˎ, reason: contains not printable characters */
    public final void m10453(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12013.getLayoutParams();
        int iM14476 = (int) ((C4792.m14375().m14476(C4792.m14375().m14488() + 242) * this.f17096) + 0.5f);
        int iM144762 = C4792.m14375().m14476(105);
        layoutParams.width = iM14476 + iM144762 + i3;
        this.f10732.f12013.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f10732.f11994.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i2;
        layoutParams2.leftMargin = iM144762 - C4792.m14375().m14476(4);
        this.f10732.f11994.setLayoutParams(layoutParams2);
        this.f10732.f11994.setZoom(true);
        this.f10732.f11994.m3194();
        this.f10732.f11994.setHandler(this.f10733.getHandler());
        this.f10732.f11994.setOnABStateChange(new C2975());
        ViewGroup.LayoutParams layoutParams3 = this.f10732.f12012.getLayoutParams();
        layoutParams3.width = layoutParams.width;
        this.f10732.f12012.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f10732.f11993.getLayoutParams();
        layoutParams4.width = i;
        layoutParams4.height = i2;
        layoutParams4.leftMargin = iM144762;
        this.f10732.f11993.setLayoutParams(layoutParams4);
        this.f10732.f11993.m3194();
        this.f10732.f11993.setZoom(false);
        this.f10732.f11993.setHandler(this.f10733.getHandler());
        this.f10732.f11993.setOnABStateChange(new C2976());
        this.f10732.f12012.setVisibility(8);
        this.f10732.f11994.setCardWidth(layoutParams.width);
        this.f10732.f11993.setCardWidth(layoutParams4.width);
        mo10553(C4535.m13880().m13890().m12412());
    }

    /* renamed from: ˏ, reason: contains not printable characters */
    public final void m10454() {
        this.f10732.f12061.m3291(100, new C3069());
    }

    /* renamed from: ː, reason: contains not printable characters */
    public final void m10455() {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12050.getLayoutParams();
        layoutParams.width = C2579.m9450(getActivity());
        layoutParams.height = C2579.m9449(getActivity());
        this.f10732.f12050.setLayoutParams(layoutParams);
    }

    /* renamed from: ˑ, reason: contains not printable characters */
    public void m10456(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        m10441(abstractC3481.f12039, abstractC3481.f12057, z);
    }

    /* renamed from: ˠ, reason: contains not printable characters */
    public final void m10457() {
        this.f10732.f12100.m2746(100, new C3067());
    }

    /* renamed from: ˢ, reason: contains not printable characters */
    public final void m10458(MotionEvent motionEvent) {
        float y = ((((motionEvent.getY() - this.f10796) * 1.0f) / (this.f10786 / 2.0f)) * C2579.m9438(C4792.m14375().m14415())) / 20.0f;
        this.f10732.f12011.setNeedDrawLine(true);
        this.f10732.f12011.setLineAlpha(255);
        this.f10732.f12011.m3153(y, true, -1.0f);
    }

    /* renamed from: ˣ, reason: contains not printable characters */
    public final void m10459(float[] fArr, float[] fArr2) {
        float[][] fArr3 = this.f10822;
        int i = this.f10823;
        float[] fArr4 = fArr3[i];
        fArr4[0] = fArr[0];
        fArr4[1] = fArr[1];
        fArr4[2] = fArr[2];
        float f = 0.0f;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
        for (int i2 = 0; i2 < 8; i2++) {
            float[] fArr5 = this.f10822[i];
            float f2 = fArr5[0];
            float f3 = fArr5[1];
            float f4 = fArr5[2];
            float fAbs = (1.0f / (Math.abs(((float) Math.sqrt(((f2 * f2) + (f3 * f3)) + (f4 * f4))) - 9.80665f) + 0.1f)) * (8 - i2);
            f += fAbs;
            float f5 = fArr2[0];
            float[] fArr6 = this.f10822[i2];
            fArr2[0] = f5 + (fArr6[0] * fAbs);
            fArr2[1] = fArr2[1] + (fArr6[1] * fAbs);
            fArr2[2] = fArr2[2] + (fAbs * fArr6[2]);
            i = ((i + 8) - 1) & 7;
        }
        fArr2[0] = fArr2[0] / f;
        fArr2[1] = fArr2[1] / f;
        fArr2[2] = fArr2[2] / f;
        this.f10823 = (this.f10823 + 1) & 7;
    }

    /* renamed from: ˮ, reason: contains not printable characters */
    public final boolean m10460() {
        return (this.f10815 || this.f10816 || this.f10817 || this.f10818 || this.f10819) ? false : true;
    }

    /* renamed from: ͱ, reason: contains not printable characters */
    public boolean m10461() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return false;
        }
        return abstractC3481.f12040.m2353();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ͺ, reason: contains not printable characters */
    public final void m10462(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10732.f12090.getLayoutParams();
        layoutParams.width = (int) (C4792.m14375().m14462() * this.f17096 * 0.9f);
        layoutParams.height = (int) (C4792.m14375().m14462() * this.f17096 * 0.9f);
        this.f10732.f12090.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f10732.f12089.getLayoutParams();
        layoutParams2.width = (int) (C4792.m14375().m14462() * this.f17096 * 0.9f);
        layoutParams2.height = (int) (C4792.m14375().m14462() * this.f17096 * 0.9f);
        this.f10732.f12089.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f10732.f12063.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = m15085(50);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = m15085(50);
        this.f10732.f12063.setLayoutParams(layoutParams3);
        FrameLayout frameLayout = this.f10732.f12091;
        frameLayout.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(frameLayout));
        this.f10732.f12091.setOnClickListener(new ViewOnClickListenerC2982());
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f10732.f12076.getLayoutParams();
        float f = this.f10803;
        float f2 = this.f10789;
        float f3 = this.f17096;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (f * f2 * f3);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = (int) (this.f10804 * f2 * f3);
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = (int) (this.f10806 * f2 * f3);
        this.f10732.f12076.setLayoutParams(layoutParams4);
        this.f10732.f12076.m2505(((ViewGroup.MarginLayoutParams) layoutParams4).width, ((ViewGroup.MarginLayoutParams) layoutParams4).height);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f10732.f12077.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) (((ViewGroup.MarginLayoutParams) layoutParams4).width * 1.5f);
        int i3 = (int) (((ViewGroup.MarginLayoutParams) layoutParams4).height * 1.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = i3;
        this.f10814 = i3;
        this.f10732.f12077.setLayoutParams(layoutParams5);
        this.f10732.f12077.setOnClickListener(new ViewOnClickListenerC2983());
        int iM14476 = (int) (((this.f10750 / 2.0f) - C4792.m14375().m14476(this.f10741 + this.f10747)) / 1.5f);
        float f4 = this.f10743;
        float f5 = this.f10789;
        int i4 = (((int) (f4 * f5)) >> 1) << 1;
        this.f10744 = (int) (this.f10741 * f5);
        this.f10763 = C4792.m14375().m14460();
        this.f10745 = this.f10744 + iM14476;
        this.f10737 = this.f10739 + iM14476;
        int i5 = this.f10743;
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f10732.f12030.getLayoutParams();
        int iM144762 = (int) (C4792.m14375().m14476(i5) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = iM144762;
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = iM14476;
        float f6 = i5;
        int i6 = (int) (((this.f10747 * 1.0f) / f6) * iM144762);
        this.f10739 = i6;
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = i6;
        this.f10732.f12030.setLayoutParams(layoutParams6);
        int i7 = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
        int i8 = (int) ((4.0f / f6) * i7);
        int i9 = (int) ((18.0f / f6) * i7);
        int iM144763 = (int) (((i7 - (i9 * 2)) - C4792.m14375().m14476(12)) / 2.0f);
        float f7 = 26.0f / f6;
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
        int i11 = (int) (f7 * i10);
        this.f10732.f12030.m2769(i11, iM144763, ((ViewGroup.MarginLayoutParams) layoutParams6).width - i11, i10 - iM144763, i8, i9);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f10732.f12031.getLayoutParams();
        int iM144764 = (int) (C4792.m14375().m14476(27) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = iM144764;
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = iM144764;
        ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin = (int) ((this.f10763 - iM144764) / 2.0f);
        this.f10732.f12031.setLayoutParams(layoutParams7);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f10732.f12035.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).height = ((ViewGroup.MarginLayoutParams) layoutParams6).height;
        ((ViewGroup.MarginLayoutParams) layoutParams8).width = ((ViewGroup.MarginLayoutParams) layoutParams6).width;
        ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin = this.f10744;
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = this.f10763;
        this.f10732.f12035.setLayoutParams(layoutParams8);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f10732.f12034.getLayoutParams();
        int iM144765 = (int) (C4792.m14375().m14476(27) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = iM144765;
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = iM144765;
        ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin = (int) ((this.f10763 - iM144765) / 2.0f);
        this.f10732.f12034.setLayoutParams(layoutParams9);
        this.f10732.f12035.setOnClickListener(new ViewOnClickListenerC2984());
        this.f10732.f12030.setOnClickListener(new ViewOnClickListenerC2985());
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f10732.f12048.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = (int) (C4792.m14375().m14476(120) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = (int) this.f10732.f12048.getLayoutWidth();
        ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = C4792.m14375().m14476(66);
        this.f10732.f12048.setLayoutParams(layoutParams10);
        this.f10732.f12048.setRecordMode(C4535.m13880().m13890().m12460() == 1);
        float f8 = ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin;
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams4).height;
        this.f10755 = (int) (f8 + (i12 / 2.0f) + (i12 / 2.0f));
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f10732.f12099.getLayoutParams();
        layoutParams11.topToTop = this.f10732.f12048.getId();
        layoutParams11.bottomToBottom = this.f10732.f12048.getId();
        ((ViewGroup.MarginLayoutParams) layoutParams11).width = (int) (C4792.m14375().m14432() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams11).height = (int) (C4792.m14375().m14432() * this.f17096);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f10732.f12029.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams12).width = (int) (C4792.m14375().m14432() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = (int) (C4792.m14375().m14432() * this.f17096);
        int iM144766 = (int) (C4792.m14375().m14476(108) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin = iM144766;
        this.f10746 = (int) (iM144766 + (((ViewGroup.MarginLayoutParams) layoutParams11).height / 2.0f));
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f10732.f12083.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = (int) (C4792.m14375().m14465() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams13).height = (int) (C4792.m14375().m14465() * this.f17096);
        this.f10732.f12083.setLayoutParams(layoutParams13);
        this.f10732.f12069.setOnClickListener(new ViewOnClickListenerC2987());
        AbstractC3481 abstractC3481 = this.f10732;
        abstractC3481.f12069.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC3481.f12083));
        ImageView imageView = this.f10732.f12074;
        imageView.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(imageView));
        this.f10732.f12074.setOnClickListener(new ViewOnClickListenerC2988());
        ImageView imageView2 = this.f10732.f12029;
        imageView2.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(imageView2));
        this.f10732.f12029.setOnClickListener(new ViewOnClickListenerC2989());
        ImageView imageView3 = this.f10732.f12099;
        imageView3.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(imageView3));
        this.f10732.f12099.setOnClickListener(new ViewOnClickListenerC2991());
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f10732.f12074.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams14).leftMargin = (int) (C4792.m14375().m14476(this.f10748) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams14).width = (int) (C4792.m14375().m14476(113) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams14).height = (int) (C4792.m14375().m14476(113) * this.f17096);
        ConstraintLayout.LayoutParams layoutParams15 = (ConstraintLayout.LayoutParams) this.f10732.f12075.getLayoutParams();
        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams14).height;
        ((ViewGroup.MarginLayoutParams) layoutParams15).bottomMargin = (int) (i13 - (i13 * 0.13461539f));
        int childCount = this.f10732.f12075.getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = this.f10732.f12075.getChildAt(i14);
            LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams16.width = C4792.m14375().m14395();
            layoutParams16.height = C4792.m14375().m14395();
            if (i14 == 0) {
                layoutParams16.leftMargin = C4792.m14375().m14388();
                layoutParams16.rightMargin = C4792.m14375().m14388();
            } else if (i14 == childCount - 1) {
                layoutParams16.leftMargin = C4792.m14375().m14388();
                layoutParams16.rightMargin = C4792.m14375().m14388();
            }
            childAt.setLayoutParams(layoutParams16);
        }
        this.f10732.f12076.setOnRecordButtonClick(new C2993());
        C2650.m9796(new C2994());
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f10732.f12093.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams17).width = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams17).height = i4;
        ((ViewGroup.MarginLayoutParams) layoutParams17).leftMargin = this.f10744;
        int i15 = this.f10763;
        ((ViewGroup.MarginLayoutParams) layoutParams17).topMargin = i15;
        this.f10752 = i15;
        this.f10753 = i4;
        int iM144767 = C4792.m14375().m14476(10);
        int iM144768 = C4792.m14375().m14476(3);
        this.f10732.f12093.setPadding(iM144767, iM144767, iM144767, iM144767);
        int i16 = iM144767 * 2;
        int i17 = ((iM14476 - i16) >> 1) << 1;
        int i18 = i4 - i16;
        this.f10732.f12092.getLayoutParams().width = i17;
        this.f10732.f12092.getLayoutParams().height = (i18 >> 1) << 1;
        this.f10732.f12094.getLayoutParams().width = i17;
        this.f10732.f12094.getLayoutParams().height = ((i18 - (iM144768 * 2)) >> 1) << 1;
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f10732.f12095.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams18).width = C4792.m14375().m14486();
        ((ViewGroup.MarginLayoutParams) layoutParams18).height = this.f10752;
        int childCount2 = this.f10732.f12095.getChildCount();
        for (int i19 = 0; i19 < childCount2; i19++) {
            View childAt2 = this.f10732.f12095.getChildAt(i19);
            LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
            layoutParams19.width = C4792.m14375().m14395();
            layoutParams19.height = C4792.m14375().m14395();
            layoutParams19.leftMargin = C4792.m14375().m14388();
            layoutParams19.rightMargin = C4792.m14375().m14388();
            if (i19 == 0) {
                layoutParams19.leftMargin = C4792.m14375().m14388();
            } else if (i19 == childCount2 - 1) {
                layoutParams19.rightMargin = C4792.m14375().m14388();
            }
            childAt2.setLayoutParams(layoutParams19);
        }
        C2650.m9797(this.f10733.mo1262());
        mo10581();
        int i20 = ((ViewGroup.MarginLayoutParams) layoutParams13).height + ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin;
        int i21 = ((ViewGroup.MarginLayoutParams) layoutParams10).height;
        int i22 = ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin;
        this.f10821 = (int) (i20 + i21 + i22 + ((ViewGroup.MarginLayoutParams) layoutParams4).height + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin + ((this.f10786 - this.f10751) / 2.0f));
        this.f10777 = i21 + i22;
        this.f10732.f12094.setOpaque(false);
        this.f10732.f12093.setOnClickListener(new ViewOnClickListenerC2997());
        this.f10732.f12094.setSurfaceTextureListener(new TextureViewSurfaceTextureListenerC2998());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo10463(boolean z) {
        if (this.f10732 == null) {
            return;
        }
        if (z) {
            int i = this.f10733.mo1261() ? 0 : this.f10821;
            C4008.m12876(this.f10732.f12087, 1.0f, 100, null);
            C4008.m12876(this.f10732.f12086, 1.0f, 100, null);
            C4008.m12876(this.f10732.f12059, 1.0f, 100, null);
            C4008.m12876(this.f10732.f12058, 1.0f, 100, null);
            C4008.m12876(this.f10732.f12097, 1.0f, 100, null);
            C4008.m12876(this.f10732.f12096, 1.0f, 100, null);
            C4008.m12876(this.f10732.f12065, 1.0f, 100, null);
            C4008.m12876(this.f10732.f12064, 1.0f, 100, null);
            C4008.m12876(this.f10732.f12093, 1.0f, 100, null);
            C4008.m12886(this.f10732.f12091, this.f10733.mo1216() ? 0.0f : this.f10738, 0.0f, 100, null);
            C4008.m12876(this.f10732.f12099, 1.0f, 100, null);
            C4008.m12886(this.f10732.f12029, 0.0f, i, 100, new C3057());
            return;
        }
        this.f10733.mo1261();
        C4008.m12876(this.f10732.f12087, 0.0f, 100, null);
        C4008.m12876(this.f10732.f12086, 0.0f, 100, null);
        C4008.m12876(this.f10732.f12059, 0.0f, 100, null);
        C4008.m12876(this.f10732.f12058, 0.0f, 100, null);
        C4008.m12876(this.f10732.f12097, 0.0f, 100, null);
        C4008.m12876(this.f10732.f12096, 0.0f, 100, null);
        C4008.m12876(this.f10732.f12065, 0.0f, 100, null);
        C4008.m12876(this.f10732.f12064, 0.0f, 100, null);
        C4008.m12876(this.f10732.f12093, 0.0f, 100, null);
        int i2 = this.f10746;
        if (m10449() || !this.f10733.mo1261()) {
            i2 = this.f10821;
        }
        C4008.m12886(this.f10732.f12091, this.f10733.mo1216() ? 0.0f : this.f10738, -this.f10762, 100, null);
        C4008.m12876(this.f10732.f12099, 0.0f, 100, null);
        C4008.m12886(this.f10732.f12029, 0.0f, i2, 100, new C3058());
    }

    /* renamed from: Ι, reason: contains not printable characters */
    public final void m10464(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12006.getLayoutParams();
        layoutParams.height = i;
        if (i == 0) {
            layoutParams.width = 0;
        }
        this.f10732.f12006.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f10732.f12007.getLayoutParams();
        layoutParams2.height = i;
        if (i == 0) {
            layoutParams2.width = 0;
        }
        this.f10732.f12007.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f10732.f12008.getLayoutParams();
        layoutParams3.width = i2;
        layoutParams3.height = C2579.m9439(getContext());
        if (i2 == 0) {
            layoutParams3.height = 0;
        }
        this.f10732.f12008.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f10732.f12005.getLayoutParams();
        layoutParams4.width = i2;
        layoutParams4.height = C2579.m9439(getContext());
        if (i2 == 0) {
            layoutParams4.height = 0;
        }
        this.f10732.f12005.setLayoutParams(layoutParams4);
        this.f10732.f12006.setOnClickListener(new ViewOnClickListenerC2977());
        this.f10732.f12007.setOnClickListener(new ViewOnClickListenerC2978());
        this.f10732.f12008.setOnClickListener(new ViewOnClickListenerC2979());
        this.f10732.f12005.setOnClickListener(new ViewOnClickListenerC2980());
    }

    /* renamed from: ι, reason: contains not printable characters */
    public final void m10465() {
        int iM14442;
        int i;
        int iM14461 = C4792.m14375().m14461();
        if (iM14461 == 0) {
            float fM14462 = C4792.m14375().m14462();
            float f = this.f17096;
            int i2 = (int) (fM14462 * f);
            int iM9438 = (int) ((this.f10806 * this.f10789 * f) + C2579.m9438(1.0f) + ((((int) ((this.f10804 * this.f10789) * this.f17096)) - i2) / 2));
            int iM14476 = C4792.m14375().m14476(70);
            iM14461 = (int) (((C2579.m9440(getContext()) - (((int) (iM9438 + ((i2 - iM14476) / 2.0f))) * 2)) - (iM14476 * 2)) / 3.0f);
            C4792.m14375().m14510(iM14461);
        }
        if (C2579.m9451(getActivity())) {
            this.f10732.f12053.setEnabled(true);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12051.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).height = C2579.m9444();
            if (m10486()) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) C4792.m14375().m14442();
                i = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            } else {
                i = 0;
            }
            float fM10450 = m10450();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (((this.f10785 - C2579.f9598) / 2.0f) - i);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.f10732.f12082);
            constraintSet.connect(this.f10732.f12051.getId(), 2, 0, 2);
            constraintSet.applyTo(this.f10732.f12082);
            this.f10732.f12051.setLayoutParams(layoutParams);
            int iM144762 = (int) (C4792.m14375().m14476(70) * fM10450);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f10732.f12044.getLayoutParams();
            layoutParams2.width = iM144762;
            layoutParams2.height = iM144762;
            layoutParams2.topMargin = (int) (((C2579.m9444() - (iM144762 * 4)) - (iM14461 * 3)) / 2.0f);
            layoutParams2.addRule(10);
            layoutParams2.addRule(14);
            layoutParams2.removeRule(9);
            this.f10732.f12044.setLayoutParams(layoutParams2);
            int iM94382 = (int) ((C2579.m9438(44.0f) - layoutParams2.height) / 2.0f);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f10732.f12045.getLayoutParams();
            layoutParams3.topMargin = layoutParams2.topMargin - iM94382;
            int iM94383 = C2579.m9438(44.0f);
            layoutParams3.width = iM94383;
            layoutParams3.height = iM94383;
            layoutParams3.addRule(10);
            layoutParams3.addRule(14);
            layoutParams3.removeRule(9);
            this.f10732.f12045.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f10732.f12046.getLayoutParams();
            layoutParams4.width = layoutParams2.width;
            layoutParams4.height = layoutParams2.height;
            layoutParams4.bottomMargin = (int) ((C2579.f9593 / 2.0f) + (iM14461 / 2.0f));
            layoutParams4.addRule(12);
            layoutParams4.addRule(14);
            layoutParams4.removeRule(11);
            this.f10732.f12046.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f10732.f12047.getLayoutParams();
            layoutParams5.bottomMargin = layoutParams4.bottomMargin - iM94382;
            layoutParams5.width = layoutParams3.width;
            layoutParams5.height = layoutParams3.height;
            layoutParams5.addRule(12);
            layoutParams5.addRule(14);
            layoutParams5.removeRule(11);
            this.f10732.f12047.setLayoutParams(layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f10732.f12039.getLayoutParams();
            layoutParams6.width = layoutParams2.width;
            layoutParams6.height = layoutParams2.height;
            layoutParams6.topMargin = layoutParams5.bottomMargin;
            layoutParams6.addRule(10);
            layoutParams6.addRule(14);
            layoutParams6.removeRule(9);
            this.f10732.f12039.setLayoutParams(layoutParams6);
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f10732.f12057.getLayoutParams();
            layoutParams7.topMargin = layoutParams6.topMargin - iM94382;
            layoutParams7.width = layoutParams3.width;
            layoutParams7.height = layoutParams3.height;
            layoutParams7.addRule(10);
            layoutParams7.addRule(14);
            layoutParams7.removeRule(9);
            this.f10732.f12057.setLayoutParams(layoutParams7);
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f10732.f12038.getLayoutParams();
            layoutParams8.width = layoutParams2.width;
            layoutParams8.height = layoutParams2.height;
            layoutParams8.topMargin = layoutParams2.topMargin;
            layoutParams8.addRule(12);
            layoutParams8.addRule(14);
            layoutParams8.removeRule(11);
            this.f10732.f12038.setLayoutParams(layoutParams8);
            RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f10732.f12043.getLayoutParams();
            layoutParams9.topMargin = layoutParams8.bottomMargin - iM94382;
            layoutParams9.width = layoutParams3.width;
            layoutParams9.height = layoutParams3.height;
            layoutParams9.addRule(12);
            layoutParams9.addRule(14);
            layoutParams9.removeRule(11);
            this.f10732.f12043.setLayoutParams(layoutParams9);
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f10732.f12052.getLayoutParams();
            layoutParams10.width = iM144762;
            layoutParams10.height = iM144762;
            layoutParams10.addRule(12);
            layoutParams10.addRule(14);
            layoutParams10.removeRule(11);
            layoutParams10.bottomMargin = (int) (layoutParams2.topMargin + ((layoutParams2.width - layoutParams10.width) / 2.0f));
            this.f10732.f12052.setLayoutParams(layoutParams10);
            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.f10732.f12053.getLayoutParams();
            layoutParams11.bottomMargin = (int) (layoutParams10.bottomMargin - ((C2579.m9438(44.0f) - layoutParams10.width) / 2.0f));
            layoutParams11.width = layoutParams3.width;
            layoutParams11.height = layoutParams3.height;
            layoutParams11.addRule(12);
            layoutParams11.addRule(14);
            layoutParams11.removeRule(11);
            this.f10732.f12053.setLayoutParams(layoutParams11);
        } else {
            this.f10732.f12053.setEnabled(true);
            ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f10732.f12051.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams12).width = C2579.f9594;
            if (m10486()) {
                iM14442 = (int) C4792.m14375().m14442();
                ((ViewGroup.MarginLayoutParams) layoutParams12).topMargin = iM14442;
            } else {
                iM14442 = 0;
            }
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.clone(this.f10732.f12082);
            constraintSet2.connect(this.f10732.f12051.getId(), 3, 0, 3);
            constraintSet2.applyTo(this.f10732.f12082);
            float fM104502 = m10450();
            ((ViewGroup.MarginLayoutParams) layoutParams12).height = (int) (((this.f10786 - C2579.f9597) / 2.0f) - iM14442);
            this.f10732.f12051.setLayoutParams(layoutParams12);
            int iM144763 = (int) (C4792.m14375().m14476(70) * fM104502);
            RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.f10732.f12044.getLayoutParams();
            layoutParams13.width = iM144763;
            layoutParams13.height = iM144763;
            layoutParams13.leftMargin = (int) (C4792.m14375().m14476(this.f10749) * this.f17096);
            this.f10732.f12044.setLayoutParams(layoutParams13);
            int iM94384 = (int) ((C2579.m9438(44.0f) - layoutParams13.width) / 2.0f);
            RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) this.f10732.f12045.getLayoutParams();
            layoutParams14.leftMargin = layoutParams13.leftMargin - iM94384;
            int iM94385 = C2579.m9438(44.0f);
            layoutParams14.width = iM94385;
            layoutParams14.height = iM94385;
            this.f10732.f12045.setLayoutParams(layoutParams14);
            RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) this.f10732.f12046.getLayoutParams();
            layoutParams15.width = layoutParams13.width;
            layoutParams15.height = layoutParams13.height;
            layoutParams15.rightMargin = (int) ((C2579.m9440(getContext()) / 2.0f) + (((C2579.m9440(getContext()) - (layoutParams13.leftMargin * 2)) - (layoutParams13.width * 2)) / 6.0f));
            this.f10732.f12046.setLayoutParams(layoutParams15);
            RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.f10732.f12047.getLayoutParams();
            layoutParams16.rightMargin = layoutParams15.rightMargin - iM94384;
            layoutParams16.width = layoutParams14.width;
            layoutParams16.height = layoutParams14.height;
            this.f10732.f12047.setLayoutParams(layoutParams16);
            RelativeLayout.LayoutParams layoutParams17 = (RelativeLayout.LayoutParams) this.f10732.f12039.getLayoutParams();
            layoutParams17.width = layoutParams13.width;
            layoutParams17.height = layoutParams13.height;
            layoutParams17.leftMargin = layoutParams16.rightMargin;
            this.f10732.f12039.setLayoutParams(layoutParams17);
            RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) this.f10732.f12057.getLayoutParams();
            layoutParams18.leftMargin = layoutParams17.leftMargin - iM94384;
            layoutParams18.width = layoutParams14.width;
            layoutParams18.height = layoutParams14.height;
            this.f10732.f12057.setLayoutParams(layoutParams18);
            RelativeLayout.LayoutParams layoutParams19 = (RelativeLayout.LayoutParams) this.f10732.f12038.getLayoutParams();
            layoutParams19.width = layoutParams13.width;
            layoutParams19.height = layoutParams13.height;
            layoutParams19.rightMargin = layoutParams13.leftMargin;
            this.f10732.f12038.setLayoutParams(layoutParams19);
            RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) this.f10732.f12043.getLayoutParams();
            layoutParams20.rightMargin = layoutParams19.rightMargin - iM94384;
            layoutParams20.width = layoutParams14.width;
            layoutParams20.height = layoutParams14.height;
            this.f10732.f12043.setLayoutParams(layoutParams20);
            RelativeLayout.LayoutParams layoutParams21 = (RelativeLayout.LayoutParams) this.f10732.f12052.getLayoutParams();
            layoutParams21.width = iM144763;
            layoutParams21.height = iM144763;
            layoutParams21.rightMargin = (int) (layoutParams13.leftMargin + ((layoutParams13.width - iM144763) / 2.0f));
            this.f10732.f12052.setLayoutParams(layoutParams21);
            RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) this.f10732.f12053.getLayoutParams();
            layoutParams22.rightMargin = (int) (layoutParams21.rightMargin - ((C2579.m9438(44.0f) - layoutParams21.width) / 2.0f));
            layoutParams22.width = layoutParams14.width;
            layoutParams22.height = layoutParams14.height;
            this.f10732.f12053.setLayoutParams(layoutParams22);
        }
        AbstractC3481 abstractC3481 = this.f10732;
        abstractC3481.f12053.setOnTouchListener(new AbstractC5160.ViewOnTouchListenerC5161(abstractC3481.f12052));
        this.f10732.f12053.setOnClickListener(new ViewOnClickListenerC3040());
        this.f10732.f12045.setOnClickListener(new ViewOnClickListenerC3042());
        this.f10732.f12047.setOnClickListener(new ViewOnClickListenerC3043());
        this.f10732.f12057.setOnClickListener(new ViewOnClickListenerC3044());
    }

    /* renamed from: г, reason: contains not printable characters */
    public final void m10466(int i) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12088.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12088.setLayoutParams(layoutParams);
        this.f10732.f12088.setPadding(this.f10787);
        this.f10732.f12088.m3391();
        this.f10732.f12088.setOnExposureChange(new C3075());
        this.f10732.f12061.m3291(0, null);
    }

    /* renamed from: і, reason: contains not printable characters */
    public final void m10467(int i, int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12091.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = C2579.m9438(44.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C2579.m9438(44.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14476(165);
        this.f10761 = (int) (C4792.m14375().m14476(this.f10749) * this.f17096);
        this.f10738 = r3 + ((ViewGroup.MarginLayoutParams) layoutParams).width + this.f10779;
        this.f10732.f12091.setLayoutParams(layoutParams);
    }

    /* renamed from: ї, reason: contains not printable characters */
    public final void m10468(int i) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12098.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12098.setLayoutParams(layoutParams);
        this.f10732.f12098.setPadding(this.f10787);
        this.f10732.f12098.m2731(new C3052());
        this.f10732.f12098.m2719(0, null);
    }

    /* renamed from: ӏ, reason: contains not printable characters */
    public final void m10469() {
        this.f10732.f12055.m2562(0, C4792.m14375().m14398());
        this.f10732.f12056.m2562(0, C4792.m14375().m14398());
        this.f10732.f12055.setContentTextColor(-1);
        this.f10732.f12056.setContentTextColor(-1);
        this.f10732.f12055.setContentTypeFace(FilmApp.m403());
        this.f10732.f12056.setContentTypeFace(FilmApp.m403());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12055.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (C4792.m14375().m14476(4) * this.f17096);
        Paint.FontMetrics fontMetrics = this.f10732.f12055.getPaint().getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((fontMetrics.bottom - fontMetrics.top) + 10.0f);
        this.f10732.f12055.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12056.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) (C4792.m14375().m14476(4) * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((ViewGroup.MarginLayoutParams) layoutParams).height;
        this.f10732.f12056.setLayoutParams(layoutParams2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean mo10470() {
        AbstractC3481 abstractC3481 = this.f10732;
        return (abstractC3481 == null || abstractC3481.f12011.getVisibility() != 0 || this.f10732.f12010.getVisibility() == 0) ? false : true;
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ԩ, reason: contains not printable characters */
    public void mo10471(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3314(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo10472() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        if (!abstractC3481.f12011.m3152()) {
            C4202.m13274().m13277(1.0f, 0.5f, 300, new C3048());
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new C3046());
        valueAnimatorOfInt.addListener(new C3047());
        valueAnimatorOfInt.start();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo10473(float f, float f2) {
        this.f10732.f12024.m3257(f, f2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ԭ, reason: contains not printable characters */
    public void mo10474(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        int currentChoosePos = abstractC3481.f12027.getCurrentChoosePos();
        if (z) {
            if (currentChoosePos > 0) {
                this.f10732.f12027.m2229(currentChoosePos - 1);
                return;
            }
            return;
        }
        if (currentChoosePos < this.f10732.f12027.getFpsSize() - 1) {
            this.f10732.f12027.m2229(currentChoosePos + 1);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ԭ, reason: contains not printable characters */
    public void mo10475(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12059.m2842(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: Ԯ, reason: contains not printable characters */
    public void mo10476(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12072.setAlpha(z ? 1.0f : 0.2f);
        this.f10732.f12073.setEnabled(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ԯ, reason: contains not printable characters */
    public void mo10477(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        int currentChoosePos = abstractC3481.f12080.getCurrentChoosePos();
        if (z) {
            if (currentChoosePos > 0) {
                this.f10732.f12080.m2522(currentChoosePos - 1);
                return;
            }
            return;
        }
        if (currentChoosePos < this.f10732.f12080.getResSize() - 1) {
            this.f10732.f12080.m2522(currentChoosePos + 1);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ՠ, reason: contains not printable characters */
    public void mo10478(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12085.setEnabled(z);
    }

    /* renamed from: ւ, reason: contains not printable characters */
    public final void m10479(int i) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12080.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12080.setLayoutParams(layoutParams);
        this.f10732.f12080.setPadding(this.f10787);
        this.f10732.f12080.m2525(new C3062());
        this.f10732.f12080.m2519(0, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ֈ, reason: contains not printable characters */
    public void mo10480(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12087.m2842(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ֏, reason: contains not printable characters */
    public void mo10481(int i, int i2, int i3) {
        if (this.f10732 == null) {
            return;
        }
        String strM9060 = C2462.m9035().m9060(i2);
        String strM90602 = C2462.m9035().m9060(i3);
        this.f10732.f12056.setText(strM9060);
        this.f10732.f12055.setText(strM90602);
        TextPaint paint = this.f10732.f12056.getPaint();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12056.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(strM9060) + C4792.f16138);
        this.f10732.f12056.setLayoutParams(layoutParams);
        TextPaint paint2 = this.f10732.f12055.getPaint();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12055.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (paint2.measureText(strM90602) + C4792.f16138);
        this.f10732.f12055.setLayoutParams(layoutParams2);
        if (i != 0) {
            C4008.m12877(this.f10732.f12055, 0.0f, i, null);
            C4008.m12877(this.f10732.f12056, 1.0f, i, new C3037(strM9060, layoutParams2, paint2));
            return;
        }
        this.f10732.f12055.setText(strM9060);
        this.f10732.f12055.setAlpha(1.0f);
        this.f10732.f12056.setAlpha(0.0f);
        this.f10732.f12056.setText("");
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (paint2.measureText(strM9060) + C4792.f16138);
        this.f10732.f12055.setLayoutParams(layoutParams2);
    }

    /* renamed from: ו, reason: contains not printable characters */
    public final void m10482(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12068.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12068.setLayoutParams(layoutParams);
        this.f10732.f12068.setPadding(this.f10787);
        this.f10732.f12068.setOnLooksStyleChangeListener(new C3010());
    }

    /* renamed from: ז, reason: contains not printable characters */
    public final void m10483() {
        int i = this.f10752;
        int i2 = this.f10753;
        int i3 = this.f10790;
        this.f10736 = i + i2 + i3;
        this.f10758 = (i2 - ((i2 - i3) / 2.0f)) + 5.0f;
    }

    /* renamed from: י, reason: contains not printable characters */
    public void m10484(int i, AbstractC4012 abstractC4012) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12040.m2349(i, abstractC4012);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ׯ, reason: contains not printable characters */
    public void mo10485(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12097.m2842(z);
    }

    /* renamed from: ײ, reason: contains not printable characters */
    public final boolean m10486() {
        return C4792.m14375().m14442() > 0.0f;
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ؠ, reason: contains not printable characters */
    public int mo10487() {
        if (this.f10732.f12080.m2521()) {
            return 1;
        }
        if (this.f10732.f12027.m2228()) {
            return 2;
        }
        if (this.f10732.f12088.m3382()) {
            return 3;
        }
        if (this.f10732.f12061.m3295()) {
            return 4;
        }
        if (this.f10732.f12098.m2722()) {
            return 5;
        }
        if (this.f10732.f12066.m2452()) {
            return 6;
        }
        if (this.f10732.f12068.m3715()) {
            return 7;
        }
        if (this.f10732.f11996.m2136()) {
            return 8;
        }
        if (m10461()) {
            return 9;
        }
        if (this.f10732.f12100.m2748()) {
            return 10;
        }
        return this.f10732.f12000.m2813() ? 11 : 0;
    }

    /* renamed from: ء, reason: contains not printable characters */
    public final void m10488() {
        this.f10732.f12068.m3705(100, new C3063());
    }

    /* renamed from: آ, reason: contains not printable characters */
    public final void m10489(int i, int i2) throws JSONException {
        ViewGroup.LayoutParams layoutParams = this.f10732.f11996.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f11996.setLayoutParams(layoutParams);
        this.f10732.f11996.m2140();
        this.f10732.f11996.setPadding(this.f10787);
        this.f10732.f11996.setAudioChangeListener(new C3030());
    }

    /* renamed from: أ, reason: contains not printable characters */
    public final void m10490(int i, int i2) {
        int iM14476 = C4792.m14375().m14476(50);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10732.f11997.getLayoutParams();
        int iM144762 = (int) (C4792.m14375().m14476((C4792.m14375().m14488() * 2) + 620) * this.f17096);
        int i3 = (int) (((iM144762 + (iM144762 % 2)) * 1.2f) + 0.5f);
        layoutParams.width = i3;
        layoutParams.height = i3;
        layoutParams.leftMargin = ((int) (C4792.m14375().m14476(70) * 1.2f * this.f17096)) + iM14476;
        this.f10732.f11997.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12014.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = this.f10786;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((int) (C4792.m14375().m14476(C4792.m14375().m14488() + 262) * this.f17096 * 1.3f)) + iM14476 + i2;
        this.f10732.f12014.setLayoutParams(layoutParams2);
        this.f10813 = (int) (((ViewGroup.MarginLayoutParams) layoutParams2).width - ((C4792.m14375().m14488() * 2) * this.f17096));
        this.f10732.f11997.setOnValueChange(new C3025());
        this.f10732.f11997.setCardWidth(((ViewGroup.MarginLayoutParams) layoutParams2).width);
        this.f10732.f11997.m3222((int) ((((ViewGroup.MarginLayoutParams) layoutParams2).width - (layoutParams.leftMargin / 1.2f)) - this.f10787), 0, (int) ((C4792.m14375().m14462() + C4792.m14375().m14476(80)) * this.f17096));
        this.f10732.f11997.setNeedCheckMag(true);
        this.f10732.f11997.m3224();
        if (this.f10733.mo1270()) {
            this.f10732.f11997.m3213(0);
        } else {
            this.f10732.f11997.m3226(0);
        }
        C4008.m12884(this.f10732.f11997, 1.3f, 1.3f, 0, null);
    }

    /* renamed from: ا, reason: contains not printable characters */
    public final void m10491() {
        this.f10732.f12066.m2450(100, new C3071());
    }

    /* renamed from: ـ, reason: contains not printable characters */
    public final void m10492() {
        this.f10732.f12080.m2519(100, new C3074());
    }

    /* renamed from: ٱ, reason: contains not printable characters */
    public final void m10493() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f11998.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (C4792.m14375().m14403() * this.f17096);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (C4792.m14375().m14403() * this.f17096);
        this.f10732.f11998.setLayoutParams(layoutParams);
        m10627(this.f10733.mo1296() && this.f10733.mo1293());
        this.f10732.f11999.setOnTouchListener(new ViewOnTouchListenerC3008());
        this.f10732.f11999.setOnClickListener(new ViewOnClickListenerC3011());
    }

    /* renamed from: ٲ, reason: contains not printable characters */
    public final void m10494(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f10732.f12000.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12000.setLayoutParams(layoutParams);
        this.f10732.f12000.m2822();
        this.f10732.f12000.setPadding(this.f10787);
        this.f10732.f12000.setBeautyChangeCallBack(new C2996());
    }

    /* renamed from: ٵ, reason: contains not printable characters */
    public final void m10495() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12016.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = this.f10785;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = this.f10751;
        this.f10732.f12016.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12036.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = this.f10750;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = this.f10751;
        this.f10732.f12036.setLayoutParams(layoutParams2);
    }

    /* renamed from: ۥ, reason: contains not printable characters */
    public final void m10496() {
        this.f10732.f12027.m2226(100, new C3073());
    }

    /* renamed from: ۦ, reason: contains not printable characters */
    public final void m10497(int i, int i2) {
        int iM14476 = C4792.m14375().m14476(50);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10732.f12024.getLayoutParams();
        int iM144762 = (int) ((C4792.m14375().m14476((C4792.m14375().m14488() * 2) + 658) * this.f17096) + 0.5f);
        int i3 = iM144762 + (iM144762 % 2);
        layoutParams.width = i3;
        layoutParams.height = i3;
        layoutParams.leftMargin = iM14476;
        this.f10732.f12024.setLayoutParams(layoutParams);
        this.f10732.f12024.setHandler(this.f10733.getHandler());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12017.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = layoutParams.height + C4792.m14375().m14476(30);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((int) (C4792.m14375().m14476(C4792.m14375().m14488() + 242) * this.f17096)) + iM14476 + i2;
        this.f10732.f12017.setLayoutParams(layoutParams2);
        this.f10811 = (int) (((ViewGroup.MarginLayoutParams) layoutParams2).width - ((C4792.m14375().m14488() * 2) * this.f17096));
        m10453(layoutParams.width, layoutParams.height, i2);
        this.f10732.f12024.setOnValueChange(new C2974());
        this.f10732.f12024.setCardWidth(((ViewGroup.MarginLayoutParams) layoutParams2).width);
        this.f10794 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
        if (this.f10733.mo1270()) {
            this.f10732.f12024.m3278(0);
            this.f10732.f11993.m3192(0);
            this.f10732.f11994.m3192(0);
        } else {
            this.f10732.f12024.m3265(0);
            this.f10732.f11993.m3188(0);
            this.f10732.f11994.m3188(0);
        }
        if (C3947.m12727().m12772()) {
            this.f10732.f12013.setVisibility(0);
            this.f10732.f12012.setVisibility(8);
        } else {
            this.f10732.f12013.setVisibility(8);
            this.f10732.f12012.setVisibility(0);
        }
    }

    /* renamed from: ݳ, reason: contains not printable characters */
    public final void m10498() {
        this.f10732.f12098.m2719(100, new C3072());
    }

    /* renamed from: ݴ, reason: contains not printable characters */
    public final void m10499() {
        this.f10732.f12088.m3376(100, new C3070());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ހ, reason: contains not printable characters */
    public void mo10500() {
        this.f10732.f12024.m3256();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ށ, reason: contains not printable characters */
    public void mo10501() {
        if (this.f10732 == null) {
            return;
        }
        String strM9060 = C2462.m9035().m9060(0);
        this.f10732.f12056.setText(strM9060);
        this.f10732.f12055.setText(strM9060);
        TextPaint paint = this.f10732.f12056.getPaint();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12056.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (paint.measureText(strM9060) + C4792.f16138);
        this.f10732.f12056.setLayoutParams(layoutParams);
        TextPaint paint2 = this.f10732.f12055.getPaint();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12055.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (paint2.measureText(strM9060) + C4792.f16138);
        this.f10732.f12055.setLayoutParams(layoutParams2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ނ, reason: contains not printable characters */
    public void mo10502() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 != null && abstractC3481.f12011.isShown()) {
            this.f10732.f12011.m3149();
            mo10600();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ރ, reason: contains not printable characters */
    public void mo10503() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 != null && abstractC3481.f12068.m3715()) {
            this.f10732.f12068.m3705(0, new C3036());
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ބ, reason: contains not printable characters */
    public void mo10504(boolean z) {
        if (z) {
            this.f10732.f12060.m3334(true);
            this.f10732.f12024.m3279(false);
        } else {
            this.f10732.f12060.m3334(false);
            this.f10732.f12024.m3279(true);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޅ, reason: contains not printable characters */
    public void mo10505() {
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ކ, reason: contains not printable characters */
    public void mo10506(float f, boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11997.m3208(f, z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: އ, reason: contains not printable characters */
    public void mo10507(int i, FocusZoomWheelView.InterfaceC1175 interfaceC1175) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12024.m3260(i, new C3034(interfaceC1175));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ވ, reason: contains not printable characters */
    public void mo10508(boolean z, int i) {
        if (this.f10732 == null) {
            return;
        }
        float f = z ? -this.f10755 : 0.0f;
        if (!this.f10733.mo1261()) {
            f = this.f10821;
        }
        C4008.m12886(this.f10732.f12084, 0.0f, f, i, null);
        C4008.m12886(this.f10732.f12085, 0.0f, f, i, null);
        C4008.m12886(this.f10732.f12083, 0.0f, f, i, null);
        C4008.m12886(this.f10732.f12069, 0.0f, f, i, null);
        C4008.m12886(this.f10732.f12072, 0.0f, f, i, null);
        C4008.m12886(this.f10732.f12073, 0.0f, f, i, null);
        float f2 = z ? -this.f10758 : 0.0f;
        C4008.m12886(this.f10732.f12079, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12078, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12026, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12025, 0.0f, f2, 100, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: މ, reason: contains not printable characters */
    public void mo10509() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11997.m3205();
        this.f10732.f12024.m3255();
        if (this.f10732.f11993.getCurrentState() != 0) {
            this.f10733.getHandler().removeMessages(200);
            this.f10732.f11993.m3191();
            this.f10732.f11993.m3190();
        }
        if (this.f10732.f11994.getCurrentState() != 0) {
            this.f10733.getHandler().removeMessages(200);
            this.f10732.f11994.m3191();
            this.f10732.f11994.m3190();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ފ, reason: contains not printable characters */
    public void mo10510() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12024.m3280();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ދ, reason: contains not printable characters */
    public float mo10511(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return 0.0f;
        }
        return abstractC3481.f11997.m3212(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ތ, reason: contains not printable characters */
    public float mo10512(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return 0.0f;
        }
        return abstractC3481.f11997.m3209(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ލ, reason: contains not printable characters */
    public RectF mo10513() {
        return this.f10820;
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ގ, reason: contains not printable characters */
    public float mo10514() {
        return this.f10732.f12024.getCurrentFocusWheelDegree();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޏ, reason: contains not printable characters */
    public int mo10515() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return 0;
        }
        return abstractC3481.f12068.getCurrentStylePos();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ސ, reason: contains not printable characters */
    public float[] mo10516() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return null;
        }
        return abstractC3481.f11997.getFocalLengthAndZoomRatio();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޑ, reason: contains not printable characters */
    public float mo10517() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return 0.0f;
        }
        return abstractC3481.f12041.getTargetCameraHeight();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޒ, reason: contains not printable characters */
    public float mo10518() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return 0.0f;
        }
        return abstractC3481.f12041.getTargetCameraWidth();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޓ, reason: contains not printable characters */
    public float mo10519(float f, float f2, float f3) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return 0.0f;
        }
        return abstractC3481.f12060.m3317(f, f2, f3);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޖ, reason: contains not printable characters */
    public void mo10520(int i) {
        super.mo10520(i);
        if (this.f10781) {
            return;
        }
        if (i == 8 && Build.VERSION.SDK_INT >= 31 && !C2618.m9565("bluetooth_scan_connect_request_sp", false)) {
            C2618.m9570("bluetooth_scan_connect_request_sp", true);
            if (ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_SCAN") != 0 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                try {
                    m10443().m959();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
        this.f10781 = true;
        if (i != 0) {
            mo10525();
        }
        m10538(0);
        m10643(new RunnableC3054(i));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޗ, reason: contains not printable characters */
    public void mo10521(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
        }
        switch (i) {
            case 1:
                m10492();
                break;
            case 2:
                m10496();
                break;
            case 3:
                m10499();
                break;
            case 4:
                m10454();
                break;
            case 5:
                m10498();
                break;
            case 6:
                m10491();
                break;
            case 7:
                abstractC3481.f12068.m3727();
                m10488();
                break;
            case 8:
                m10444();
                break;
            case 9:
                m10448();
                break;
            case 10:
                m10457();
                break;
            case 11:
                m10446();
                break;
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޘ, reason: contains not printable characters */
    public void mo10522() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12028.setVisibility(8);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޙ, reason: contains not printable characters */
    public void mo10523() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12024.m3265(100);
        this.f10732.f12060.m3319(100);
        this.f10732.f11993.m3188(100);
        this.f10732.f11994.m3188(100);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޚ, reason: contains not printable characters */
    public void mo10524(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        C4008.m12876(abstractC3481.f12063, 0.0f, i, new C3060());
        C4008.m12876(this.f10732.f12076, 1.0f, i, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޛ, reason: contains not printable characters */
    public void mo10525() {
        if (this.f10732.f12080.m2521()) {
            this.f10732.f12080.m2519(100, null);
            return;
        }
        if (this.f10732.f12027.m2228()) {
            this.f10732.f12027.m2226(100, null);
            return;
        }
        if (this.f10732.f12098.m2722()) {
            this.f10732.f12098.m2719(100, null);
            return;
        }
        if (this.f10732.f12066.m2452()) {
            this.f10732.f12066.m2450(100, null);
            return;
        }
        if (this.f10732.f12088.m3382()) {
            this.f10732.f12088.m3376(100, null);
            return;
        }
        if (this.f10732.f12061.m3295()) {
            this.f10732.f12061.m3291(100, null);
            return;
        }
        if (m10461()) {
            m10484(100, null);
            return;
        }
        if (this.f10732.f12100.m2748()) {
            this.f10732.f12100.m2746(100, null);
            return;
        }
        if (this.f10732.f11996.m2136()) {
            this.f10732.f11996.m2132(100, null);
        } else if (this.f10732.f12068.m3715()) {
            this.f10732.f12068.m3705(100, null);
        } else if (this.f10732.f12000.m2813()) {
            this.f10732.f12000.m2807(100, null);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޜ, reason: contains not printable characters */
    public void mo10526(int i, int i2, int i3) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        if (i == -1) {
            i = this.f10794;
        }
        C4008.m12886(abstractC3481.f12032, i, i2, i3, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޝ, reason: contains not printable characters */
    public void mo10527(float f, int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        C4008.m12876(abstractC3481.f12034, f, i, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޞ, reason: contains not printable characters */
    public void mo10528() {
        if (this.f10732 == null) {
            return;
        }
        this.f10733.mo1232();
        C3891 c3891M13890 = C4535.m13880().m13890();
        this.f10732.f12041.m2416(this.f10733.mo1250(), this.f10733.mo1244(), false);
        this.f10732.f12041.m2418(c3891M13890.m12470() == 1);
        this.f10732.f12041.m2421((c3891M13890.m12464() * 1.0f) / 100.0f);
        this.f10732.f12041.m2419(c3891M13890.m12405() == 1);
        this.f10732.f12041.m2422(c3891M13890.m12444() ? 255 : C4792.m14375().m14413());
        HorizonCircleRectView.f2347 = true;
        this.f10732.f12042.m2441(this.f10733.mo1250(), this.f10733.mo1244(), false);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޟ, reason: contains not printable characters */
    public void mo10529(long j, int i, boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12048.m2511(j, i, z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޠ, reason: contains not printable characters */
    public boolean mo10530() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return false;
        }
        return abstractC3481.f11997.m3217();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޡ, reason: contains not printable characters */
    public boolean mo10531() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return false;
        }
        return abstractC3481.f12024.m3270();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޢ, reason: contains not printable characters */
    public void mo10532() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3335();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޣ, reason: contains not printable characters */
    public void mo10533() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3332();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޤ, reason: contains not printable characters */
    public void mo10534() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3327();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޥ, reason: contains not printable characters */
    public void mo10535(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3328(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ޱ, reason: contains not printable characters */
    public void mo10536(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3331(f);
    }

    /* renamed from: ߊ, reason: contains not printable characters */
    public final void m10537() {
        this.f10807 = this.f10812;
        this.f10809 = this.f10785;
        this.f10808 = this.f10763 + this.f10764 + this.f10790 + C2579.m9438(5.0f);
        this.f10810 = this.f10786 - ((this.f10814 + this.f10777) + C2579.m9438(5.0f));
    }

    /* renamed from: ߴ, reason: contains not printable characters */
    public void m10538(int i) {
        this.f10732.f11995.setVisibility(i);
    }

    /* renamed from: ߵ, reason: contains not printable characters */
    public void m10539(boolean z) {
    }

    /* renamed from: ߺ, reason: contains not printable characters */
    public final void m10540() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12028.getLayoutParams();
        if (this.f10733.mo1270()) {
            float f = this.f10778;
            float fM9438 = C2579.m9438(44.0f);
            float f2 = this.f10760;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (f + ((fM9438 - f2) / 2.0f) + f2 + this.f10776);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14421() + (this.f10776 * 2);
        }
        this.f10732.f12028.setLayoutParams(layoutParams);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ߾, reason: contains not printable characters */
    public void mo10541() {
        if (this.f10732 == null) {
            return;
        }
        if (this.f10733.mo1302() || this.f10733.mo1297()) {
            this.f10732.f12024.setAlpha(1.0f);
            this.f10732.f12012.setAlpha(1.0f);
            this.f10732.f12013.setAlpha(1.0f);
        } else {
            this.f10732.f12024.setAlpha(0.0f);
            this.f10732.f12012.setAlpha(0.0f);
            this.f10732.f12013.setAlpha(0.0f);
        }
        if ((this.f10733.mo1211() && this.f10733.mo1247()) || this.f10733.mo1294()) {
            this.f10732.f12060.setAlpha(1.0f);
        } else {
            this.f10732.f12060.setAlpha(0.0f);
        }
        this.f10732.f12060.setShutterWheelEnable(this.f10733.mo1247());
        this.f10732.f12060.setEtWheelEnable(this.f10733.mo1294());
        this.f10732.f12060.setIsoWheelEnable(this.f10733.mo1211());
        this.f10732.f12060.setIconEnable(this.f10733.mo1211() || this.f10733.mo1247());
        this.f10732.f12061.setIsoViewEnable(this.f10733.mo1211());
        this.f10732.f12088.setShutterViewEnable(this.f10733.mo1247());
        this.f10732.f12024.setFocusEnable(this.f10733.mo1297());
        this.f10732.f12024.setZoomEnable(this.f10733.mo1302());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ߿, reason: contains not printable characters */
    public void mo10542(int i, boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        View view = null;
        switch (i) {
            case 0:
                view = abstractC3481.f12077;
                break;
            case 1:
                view = abstractC3481.f12091;
                break;
            case 2:
                view = abstractC3481.f12074;
                break;
            case 3:
                view = abstractC3481.f12057;
                break;
            case 5:
                view = abstractC3481.f12085;
                break;
            case 6:
                view = abstractC3481.f12073;
                break;
            case 7:
                view = abstractC3481.f12026;
                break;
            case 8:
                view = abstractC3481.f12079;
                break;
            case 9:
                abstractC3481.f12060.m3324();
                return;
        }
        if (view != null) {
            if (!z || view.isEnabled()) {
                view.performClick();
            }
        }
    }

    /* renamed from: ࡅ, reason: contains not printable characters */
    public void m10543() throws JSONException {
        this.f10785 = C2579.m9443(getActivity());
        int iM9442 = C2579.m9442(getActivity());
        this.f10786 = iM9442;
        if ((iM9442 * 1.0f) / this.f10785 > 1.7777778f) {
            this.f10788 = true;
        }
        int iM9450 = C2579.m9450(getActivity());
        int iM9449 = C2579.m9449(getActivity());
        this.f17096 = C4792.m14375().m14434();
        this.f10789 = C4792.m14375().m14455(1125.0f);
        int i = this.f10785;
        if (iM9450 > i) {
            iM9449 = (((int) ((i * 16.0f) / 9.0f)) >> 1) << 1;
            iM9450 = i;
        }
        ViewGroup.LayoutParams layoutParams = this.f10732.f12037.getLayoutParams();
        layoutParams.width = iM9450;
        layoutParams.height = iM9449;
        this.f10750 = iM9450;
        this.f10751 = iM9449;
        this.f10732.f12037.setLayoutParams(layoutParams);
        this.f10779 = (this.f10785 - C2579.f9598) / 2;
        this.f10780 = (this.f10786 - C2579.f9597) / 2;
        m10495();
        m10464(this.f10780, this.f10779);
        int i2 = C2579.f9594;
        this.f10787 = (int) ((i2 - C2579.f9598) / 2.0f);
        m10438(iM9450, iM9449, i2);
        if (m10445()) {
            this.f10732.f12051.setVisibility(0);
            m10465();
            mo10576();
        } else {
            this.f10732.f12051.setVisibility(8);
        }
        m10451(iM9449, iM9450);
        m10490(iM9450, (this.f10785 - iM9450) / 2);
        m10434();
        m10435();
        m10493();
        this.f10732.f11995.setOnClickListener(new ViewOnClickListenerC2981());
        m10595();
        m10469();
        if (this.f10788) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f10732.f12023.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (C4792.m14375().m14427() * this.f17096);
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (C4792.m14375().m14425() * this.f17096);
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = (int) (C4792.m14375().m14426() * this.f17096);
            this.f10732.f12023.setLayoutParams(layoutParams2);
        }
        m10462(iM9450, iM9449);
        m10604();
        m10497(iM9450, (this.f10785 - iM9450) / 2);
        m10439((this.f10785 - iM9450) / 2);
        m10428(i2);
        m10479(i2);
        m10432(i2);
        m10429(i2);
        m10466(i2);
        m10433(i2);
        m10468(i2);
        m10594(i2);
        m10489(i2, iM9449);
        m10482(i2, iM9449);
        m10494(i2, iM9449);
        m10467(iM9450, iM9449);
        m10537();
        m10483();
        if (this.f10733.mo1270()) {
            mo10526(this.f10794, 0, 100);
            mo10508(false, 0);
        } else {
            mo10526(0, 0, 100);
            mo10508(true, 0);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡠ, reason: contains not printable characters */
    public void mo10544() throws JSONException {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11996.m2140();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡡ, reason: contains not printable characters */
    public void mo10545() throws JSONException {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11996.m2139();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡢ, reason: contains not printable characters */
    public void mo10546() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11997.m3218();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡣ, reason: contains not printable characters */
    public void mo10547() {
        if (this.f10732 == null) {
            return;
        }
        m10627(this.f10733.mo1296() && this.f10733.mo1293());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡤ, reason: contains not printable characters */
    public void mo10548(boolean z) {
        float f;
        float f2;
        if (this.f10732 == null) {
            return;
        }
        boolean zM12444 = C4535.m13880().m13890().m12444();
        float targetCameraWidth = this.f10732.f12041.getTargetCameraWidth();
        float targetCameraHeight = this.f10732.f12041.getTargetCameraHeight();
        if (zM12444) {
            f = this.f10785 - (targetCameraWidth * 2.0f);
            f2 = this.f10786 - (targetCameraHeight * 2.0f);
        } else {
            f = this.f10785 - (targetCameraWidth * 2.0f);
            f2 = -this.f10786;
        }
        if (f > 0.0f || this.f10732.f12002.getAlpha() != 0.0f) {
            boolean z2 = f > 0.0f;
            C4008.m12876(this.f10732.f12002, z2 ? 1.0f : 0.0f, 200, null);
            C4008.m12876(this.f10732.f12003, z2 ? 1.0f : 0.0f, 200, null);
            C4008.m12876(this.f10732.f12004, z2 ? 1.0f : 0.0f, 200, null);
            C4008.m12876(this.f10732.f12001, z2 ? 1.0f : 0.0f, 200, null);
            C4008.m12880(0.0f, 1.0f, z ? 200L : 0L, new C3038(f));
        } else {
            this.f10801 = 0;
            ViewGroup.LayoutParams layoutParams = this.f10732.f12002.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.height = 0;
            this.f10732.f12002.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f10732.f12003.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            this.f10732.f12003.setLayoutParams(layoutParams2);
        }
        if (f2 > 0.0f || this.f10732.f12004.getAlpha() != 0.0f) {
            boolean z3 = f2 > 0.0f;
            C4008.m12876(this.f10732.f12004, z3 ? 1.0f : 0.0f, 200, null);
            C4008.m12876(this.f10732.f12001, z3 ? 1.0f : 0.0f, 200, null);
            C4008.m12876(this.f10732.f12002, z3 ? 1.0f : 0.0f, 200, null);
            C4008.m12876(this.f10732.f12003, z3 ? 1.0f : 0.0f, 200, null);
            C4008.m12880(0.0f, 1.0f, z ? 200L : 0L, new C3039(f2));
            return;
        }
        this.f10802 = 0;
        ViewGroup.LayoutParams layoutParams3 = this.f10732.f12004.getLayoutParams();
        layoutParams3.width = 0;
        layoutParams3.height = 0;
        this.f10732.f12004.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f10732.f12001.getLayoutParams();
        layoutParams4.width = layoutParams3.width;
        layoutParams4.height = layoutParams3.height;
        this.f10732.f12001.setLayoutParams(layoutParams4);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡥ, reason: contains not printable characters */
    public void mo10549(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12021.setVisibility(8);
        if (i == 1) {
            this.f10732.f12020.setEnabled(true);
            this.f10732.f12019.setAlpha(0.2f);
            mo10567(false);
        } else {
            this.f10732.f12020.setEnabled(true);
            this.f10732.f12019.setAlpha(1.0f);
            mo10567(this.f10733.mo1286());
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡦ, reason: contains not printable characters */
    public void mo10550() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12027.m2230();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡧ, reason: contains not printable characters */
    public void mo10551() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3325();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡨ, reason: contains not printable characters */
    public void mo10552(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3326(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡩ, reason: contains not printable characters */
    public void mo10553(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        if (f >= 0.0f && f <= 1.0f) {
            abstractC3481.f11993.setVisibility(0);
            return;
        }
        abstractC3481.f11993.setVisibility(8);
        this.f10732.f11993.m3191();
        this.f10732.f11993.m3190();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࡪ, reason: contains not printable characters */
    public void mo10554() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12024.m3271();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢠ, reason: contains not printable characters */
    public void mo10555(float f) {
        if (this.f10732 == null) {
            return;
        }
        C3947.m12727().m12785(f);
        this.f10732.f12024.m3271();
        this.f10732.f11993.setDegree(this.f10732.f12024.m3262(false));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢡ, reason: contains not printable characters */
    public void mo10556(float f, float f2) {
        if (this.f10732 == null) {
            return;
        }
        C3947.m12727().m12785(f);
        this.f10732.f12024.m3272(f2);
        this.f10732.f11993.setDegree(this.f10732.f12024.m3262(false));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢢ, reason: contains not printable characters */
    public void mo10557(String str, int i, String str2) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12026.m2844();
        this.f10732.f12026.m2846(str, i, str2);
        this.f10767 = this.f10732.f12026.getFpsContentWidth();
        m10431();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢣ, reason: contains not printable characters */
    public void mo10558() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12027.m2237();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢤ, reason: contains not printable characters */
    public void mo10559(long j) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12028.post(new RunnableC3049(j));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢥ, reason: contains not printable characters */
    public void mo10560(boolean z) {
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢦ, reason: contains not printable characters */
    public void mo10561() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 != null && abstractC3481.f12061.m3295()) {
            this.f10732.f12061.m3298();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢧ, reason: contains not printable characters */
    public void mo10562() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = abstractC3481.f12059.getLayoutParams();
        layoutParams.width = C4792.m14375().m14436();
        this.f10732.f12059.setLayoutParams(layoutParams);
        this.f10769 = layoutParams.width;
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢨ, reason: contains not printable characters */
    public void mo10563() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12060.m3329();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢩ, reason: contains not printable characters */
    public void mo10564() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12061.m3299();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢪ, reason: contains not printable characters */
    public void mo10565() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12066.m2456();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢫ, reason: contains not printable characters */
    public void mo10566() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 != null) {
            m10441(abstractC3481.f12044, abstractC3481.f12045, this.f10733.mo1221());
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢬ, reason: contains not printable characters */
    public void mo10567(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12067.setVisibility(z ? 0 : 4);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢭ, reason: contains not printable characters */
    public void mo10568() throws Resources.NotFoundException {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12068.m3726();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢮ, reason: contains not printable characters */
    public void mo10569(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12055.setVisibility(z ? 0 : 8);
        this.f10732.f12056.setVisibility(z ? 0 : 8);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢯ, reason: contains not printable characters */
    public void mo10570(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 != null && i == 0) {
            abstractC3481.f12040.m2360();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢰ, reason: contains not printable characters */
    public void mo10571() {
        if (this.f10732 == null) {
            return;
        }
        if (this.f10733.mo1270()) {
            this.f10732.f12074.setImageResource(R.drawable.icon_50_mode_pro);
        } else {
            this.f10732.f12074.setImageResource(R.drawable.icon_50_mode_auto);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢱ, reason: contains not printable characters */
    public void mo10572() {
        if (this.f10732 == null) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            ((FilmPointView) this.f10732.f12075.getChildAt(i)).m2292(false);
        }
        if (this.f10733.mo1270()) {
            ((FilmPointView) this.f10732.f12075.getChildAt(1)).m2292(true);
        } else {
            ((FilmPointView) this.f10732.f12075.getChildAt(0)).m2292(true);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢲ, reason: contains not printable characters */
    public void mo10573() {
        int iMo1244;
        int iM9449;
        if (this.f10732 == null) {
            return;
        }
        C3891 c3891M13890 = C4535.m13880().m13890();
        int iM12429 = c3891M13890.m12429();
        boolean zM12444 = c3891M13890.m12444();
        int iM12460 = c3891M13890.m12460();
        int iM14489 = this.f10732.f12041.m2402() ? C4792.m14375().m14489() * 2 : 0;
        int iM144892 = this.f10732.f12041.m2403() ? C4792.m14375().m14489() * 2 : 0;
        if (zM12444) {
            if (iM12460 == 1) {
                iMo1244 = C2579.f9598;
                iM9449 = C2579.f9597;
            } else {
                iMo1244 = ((int) this.f10732.f12041.getTargetCameraWidth()) + iM144892;
                iM9449 = ((int) this.f10732.f12041.getTargetCameraHeight()) + iM14489;
            }
        } else if (iM12429 == 1 || iM12429 == 2) {
            iMo1244 = ((int) ((C2579.f9597 * 1.0f) / this.f10733.mo1244())) + iM14489;
            iM9449 = C2579.m9449(getActivity());
        } else {
            iMo1244 = C2579.m9450(getActivity());
            iM9449 = C2579.m9449(getActivity());
        }
        this.f10732.f12050.m2515(iMo1244, iM9449);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢳ, reason: contains not printable characters */
    public void mo10574(String str) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        this.f10772 = str;
        abstractC3481.f12079.m2844();
        this.f10732.f12079.setBottomTextContent(str);
        this.f10766 = (int) this.f10732.f12079.getBottomPaint().measureText(str);
        m10431();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢴ, reason: contains not printable characters */
    public void mo10575() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12080.m2524();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢶ, reason: contains not printable characters */
    public void mo10576() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        m10441(abstractC3481.f12039, abstractC3481.f12057, !this.f10733.mo1261());
        AbstractC3481 abstractC34812 = this.f10732;
        m10441(abstractC34812.f12044, abstractC34812.f12045, this.f10733.mo1221());
        AbstractC3481 abstractC34813 = this.f10732;
        m10441(abstractC34813.f12046, abstractC34813.f12047, this.f10733.mo1227());
        AbstractC3481 abstractC34814 = this.f10732;
        m10441(abstractC34814.f12052, abstractC34814.f12053, this.f10733.mo1227());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢷ, reason: contains not printable characters */
    public void mo10577() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 != null && abstractC3481.f12088.m3382()) {
            this.f10732.f12088.m3385();
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢸ, reason: contains not printable characters */
    public void mo10578() throws Resources.NotFoundException {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12068.m3723();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢹ, reason: contains not printable characters */
    public void mo10579() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12068.m3724();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢺ, reason: contains not printable characters */
    public void mo10580(float f, float f2) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12041.m2416(f, f2, true);
        HorizonCircleRectView.f2347 = true;
        this.f10732.f12042.m2441(this.f10733.mo1250(), this.f10733.mo1244(), true);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢻ, reason: contains not printable characters */
    public void mo10581() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        int childCount = abstractC3481.f12095.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((FilmPointView) this.f10732.f12095.getChildAt(i)).m2292(false);
        }
        int iMo1262 = this.f10733.mo1262();
        if (iMo1262 == 0) {
            ((FilmPointView) this.f10732.f12095.getChildAt(2)).m2292(true);
            return;
        }
        if (iMo1262 == 1) {
            ((FilmPointView) this.f10732.f12095.getChildAt(3)).m2292(true);
            return;
        }
        if (iMo1262 == 2) {
            ((FilmPointView) this.f10732.f12095.getChildAt(0)).m2292(true);
        } else if (iMo1262 == 3) {
            ((FilmPointView) this.f10732.f12095.getChildAt(1)).m2292(true);
        } else {
            if (iMo1262 != 4) {
                return;
            }
            ((FilmPointView) this.f10732.f12095.getChildAt(4)).m2292(true);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢼ, reason: contains not printable characters */
    public void mo10582(String str) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12097.m2844();
        this.f10732.f12097.setBottomTextContent(str);
        this.f10770 = (int) this.f10732.f12097.getBottomPaint().measureText(str);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢽ, reason: contains not printable characters */
    public void mo10583() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12098.m2728();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢾ, reason: contains not printable characters */
    public void mo10584() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12024.m3275();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࢿ, reason: contains not printable characters */
    public void mo10585(float f) {
        if (this.f10732 == null) {
            return;
        }
        C3947.m12727().m12789(f);
        this.f10732.f12024.m3275();
        this.f10732.f11994.setDegree(this.f10732.f12024.m3262(true));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣀ, reason: contains not printable characters */
    public void mo10586(float f, float f2) {
        if (this.f10732 == null) {
            return;
        }
        C3947.m12727().m12789(f);
        this.f10732.f12024.m3276(f2);
        this.f10732.f11994.setDegree(this.f10732.f12024.m3262(true));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣁ, reason: contains not printable characters */
    public void mo10587() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12024.m3274();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣂ, reason: contains not printable characters */
    public void mo10588() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = abstractC3481.f12002.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = 0;
        this.f10732.f12002.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f10732.f12003.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.f10732.f12003.setLayoutParams(layoutParams2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣃ, reason: contains not printable characters */
    public void mo10589(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        if (i == 1) {
            abstractC3481.f12031.setImageResource(R.drawable.icon_13_microphone_external);
            m10436(true);
        } else if (i != 2) {
            m10436(false);
        } else {
            abstractC3481.f12031.setImageResource(R.drawable.icon_13_microphone_bluetooth);
            m10436(true);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣄ, reason: contains not printable characters */
    public void mo10590() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11997.m3220();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣅ, reason: contains not printable characters */
    public void mo10591(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11997.setNeedCheckMag(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣆ, reason: contains not printable characters */
    public void mo10592() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11997.m3223();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ࣇ, reason: contains not printable characters */
    public void mo10593(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12035.setBattery(i);
    }

    /* renamed from: ॽ, reason: contains not printable characters */
    public final void m10594(int i) {
        int iM12375 = C4535.m13880().m13890().m12375();
        ArrayList<C4351> arrayListM11226 = C3444.m11226();
        Iterator<C4351> it = arrayListM11226.iterator();
        while (it.hasNext()) {
            it.next().m13507(false);
        }
        if (iM12375 >= 0 && iM12375 < arrayListM11226.size()) {
            arrayListM11226.get(iM12375).m13507(true);
        }
        this.f10733.mo1209(iM12375);
        ViewGroup.LayoutParams layoutParams = this.f10732.f12100.getLayoutParams();
        layoutParams.width = i;
        this.f10732.f12100.setLayoutParams(layoutParams);
        this.f10732.f12100.setPadding(this.f10787);
        this.f10732.f12100.m2751(new C3041());
        this.f10732.f12100.m2746(0, null);
    }

    /* renamed from: ৲, reason: contains not printable characters */
    public final void m10595() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12028.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C4792.m14375().m14421();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14424();
        this.f10732.f12028.setPadding(C4792.m14375().m14422(), 0, C4792.m14375().m14423(), 0);
        this.f10732.f12028.setLayoutParams(layoutParams);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ৼ, reason: contains not printable characters */
    public void mo10596(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        float f = z ? 1.0f : 0.3f;
        abstractC3481.f12026.setEnabled(z);
        this.f10732.f12025.setEnabled(z);
        this.f10732.f12079.setEnabled(z);
        this.f10732.f12078.setEnabled(z);
        this.f10732.f12087.setEnabled(z);
        this.f10732.f12086.setEnabled(z);
        this.f10732.f12059.setEnabled(z);
        this.f10732.f12058.setEnabled(z);
        this.f10732.f12097.setEnabled(z);
        this.f10732.f12096.setEnabled(z);
        this.f10732.f12065.setEnabled(z);
        this.f10732.f12064.setEnabled(z);
        this.f10732.f12019.setEnabled(z);
        this.f10732.f12083.setEnabled(z);
        boolean zM10019 = C2764.m10018().m10019();
        this.f10732.f11998.setEnabled(zM10019 && z);
        this.f10732.f12072.setEnabled(z);
        this.f10732.f12084.setEnabled(z);
        this.f10732.f12029.setEnabled(z);
        this.f10732.f12099.setEnabled(z);
        this.f10732.f12074.setEnabled(z);
        this.f10732.f12020.setEnabled(z);
        this.f10732.f12069.setEnabled(z);
        this.f10732.f11999.setEnabled(z);
        this.f10732.f12085.setEnabled(z);
        this.f10732.f12073.setEnabled(z);
        this.f10732.f12030.setEnabled(z);
        this.f10732.f12032.setEnabled(z);
        this.f10732.f12026.setAlpha(f);
        this.f10732.f12079.setAlpha(f);
        this.f10732.f12087.setAlpha(f);
        this.f10732.f12059.setAlpha(f);
        this.f10732.f12097.setAlpha(f);
        this.f10732.f12065.setAlpha(f);
        this.f10732.f12019.setAlpha(f);
        this.f10732.f11998.setAlpha(zM10019 ? f : 0.2f);
        this.f10732.f12072.setAlpha(f);
        this.f10732.f12084.setAlpha(f);
        this.f10732.f12029.setAlpha(f);
        this.f10732.f12099.setAlpha(f);
        this.f10732.f12074.setAlpha(f);
        this.f10732.f12074.setAlpha(f);
        this.f10732.f12075.setAlpha(f);
        this.f10732.f12032.setAlpha(f);
        if (this.f10733.mo1286()) {
            this.f10732.f12067.setAlpha(f);
        }
        if (this.f10733.mo1229()) {
            this.f10732.f12055.setAlpha(f);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ૹ, reason: contains not printable characters */
    public void mo10597(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12068.setCurrentStylePos(i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ಀ, reason: contains not printable characters */
    public void mo10598(String str) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12068.setDownloadProgress(str);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ೱ, reason: contains not printable characters */
    public void mo10599(int i) {
        if (this.f10732 == null || getActivity() == null || !this.f10788) {
            return;
        }
        getActivity().runOnUiThread(new RunnableC3035());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ೲ, reason: contains not printable characters */
    public void mo10600() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12011.setVisibility(8);
        this.f10732.f12009.setVisibility(8);
        this.f10732.f12010.setVisibility(8);
        m10540();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ഄ, reason: contains not printable characters */
    public void mo10601(boolean z, float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12024.m3277(z, f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ഩ, reason: contains not printable characters */
    public void mo10602(float f) {
        if (this.f10732 == null) {
            return;
        }
        boolean zM12444 = C4535.m13880().m13890().m12444();
        this.f10732.f12041.m2414(f, zM12444, zM12444 ? 1.0f : f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ഺ, reason: contains not printable characters */
    public void mo10603(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12041.m2422(i);
    }

    /* renamed from: ഽ, reason: contains not printable characters */
    public final void m10604() {
        this.f10732.f12049.m2562(0, C4792.m14375().m14397());
        this.f10732.f12049.setContentTextColor(-1);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12049.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) (C4792.m14375().m14476(60) * this.f17096);
        this.f10732.f12049.setLayoutParams(layoutParams);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൎ, reason: contains not printable characters */
    public void mo10605(float f, float f2) {
        this.f10732.f12041.setScaleX(f);
        this.f10732.f12041.setScaleY(f2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൔ, reason: contains not printable characters */
    public void mo10606() {
        if (this.f10732 == null) {
            return;
        }
        float fM12738 = C3947.m12727().m12738();
        if (!C3947.m12727().m12769()) {
            this.f10732.f12059.setBottomTextContent("N/A");
            return;
        }
        this.f10732.f12059.m2844();
        this.f10732.f12059.setBottomTextContent("" + ((int) fM12738));
        this.f10769 = C4792.m14375().m14436();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൕ, reason: contains not printable characters */
    public void mo10607(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12059.setTvsColor(i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൖ, reason: contains not printable characters */
    public void mo10608(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12006.setAlpha(f);
        this.f10732.f12007.setAlpha(f);
        this.f10732.f12008.setAlpha(f);
        this.f10732.f12005.setAlpha(f);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ൟ, reason: contains not printable characters */
    public void mo10609(C3828 c3828) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12065.m2844();
        this.f10732.f12065.setCameraLensName(c3828);
        this.f10771 = this.f10732.f12065.getCameraLensWidth();
        m10431();
    }

    /* renamed from: ำ, reason: contains not printable characters */
    public void m10610() {
        this.f10732 = null;
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຆ, reason: contains not printable characters */
    public void mo10611(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12076.m2504(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຉ, reason: contains not printable characters */
    public void mo10612(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12076.setState(i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຌ, reason: contains not printable characters */
    public void mo10613(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12048.setRecordMode(z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຎ, reason: contains not printable characters */
    public void mo10614() {
        if (this.f10732 == null) {
            return;
        }
        String strM9057 = C2462.m9035().m9057();
        this.f10732.f12049.setText(strM9057);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f10732.f12049.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (this.f10732.f12049.getPaint().measureText(strM9057) + C4792.f16138);
        this.f10732.f12049.setLayoutParams(layoutParams);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຏ, reason: contains not printable characters */
    public void mo10615(float f, float f2) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12050.setScaleX(f);
        this.f10732.f12050.setScaleY(f2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຐ, reason: contains not printable characters */
    public void mo10616(float f, float f2) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12050.setTranslationX(f);
        this.f10732.f12050.setTranslationY(f2);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຑ, reason: contains not printable characters */
    public void mo10617(float f, float f2, boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12030.m2770(f, f2, z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຒ, reason: contains not printable characters */
    public void mo10618() {
        String str;
        if (this.f10732 == null) {
            return;
        }
        C4792.m14375().m14500();
        this.f10732.f12087.m2844();
        int iM14475 = C4792.m14375().m14475();
        ViewGroup.LayoutParams layoutParams = this.f10732.f12087.getLayoutParams();
        if (layoutParams.width != iM14475) {
            layoutParams.width = iM14475;
            this.f10732.f12087.setLayoutParams(layoutParams);
        }
        float fM12735 = C3947.m12727().m12735();
        if (!C3947.m12727().m12767()) {
            this.f10732.f12087.setBottomTextContent("N/A");
            return;
        }
        if (C3947.m12727().m12764()) {
            float fM12739 = C3947.m12727().m12739();
            this.f10732.f12087.setBottomTextContent(new DecimalFormat("0.0").format(fM12739) + "°");
        } else {
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
            this.f10732.f12087.setBottomTextContent(str);
        }
        this.f10768 = iM14475;
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຓ, reason: contains not printable characters */
    public void mo10619(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12087.setTvsColor(i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຘ, reason: contains not printable characters */
    public void mo10620(float f) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 != null && abstractC3481.f12088.m3382()) {
            this.f10732.f12088.setPro(f);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຠ, reason: contains not printable characters */
    public void mo10621(String str, int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12035.m2773(str, i);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຨ, reason: contains not printable characters */
    public void mo10622() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f11997.m3224();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຩ, reason: contains not printable characters */
    public void mo10623(boolean z, boolean z2) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12091.setEnabled(z);
        this.f10732.f12091.setAlpha(z ? 1.0f : 0.3f);
        if (z2) {
            this.f10732.f12089.setVisibility(8);
            this.f10732.f12090.setVisibility(0);
        } else {
            this.f10732.f12089.setVisibility(0);
            this.f10732.f12090.setVisibility(8);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ຬ, reason: contains not printable characters */
    public void mo10624(float f, int i, CameraTouchView.InterfaceC1143 interfaceC1143) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12011.m3157(f, i, new C3033(interfaceC1143));
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ໞ, reason: contains not printable characters */
    public void mo10625(String str) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12068.setUpdateProgress(str);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ໟ, reason: contains not printable characters */
    public void mo10626(int i, int i2) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12098.m2730(i, i2);
    }

    /* renamed from: ར, reason: contains not printable characters */
    public final void m10627(boolean z) {
        if (this.f10733 != null) {
            if (z) {
                this.f10732.f11998.setImageResource(R.drawable.icon_60_beauty_on);
            } else {
                this.f10732.f11998.setImageResource(R.drawable.icon_60_beauty_default);
            }
            this.f10732.f11998.setAlpha(this.f10733.mo1292() ? 1.0f : 0.2f);
        }
    }

    /* renamed from: ཪ, reason: contains not printable characters */
    public final void m10628(String str, int i, int i2, int i3, int i4) {
        String str2 = "";
        int i5 = 0;
        if (i3 != 0 && str != null && !"".equalsIgnoreCase(str)) {
            str2 = String.format("(%s)", str);
        }
        if (this.f17095) {
            C4638.m14099("HomePortraitFragment", String.format("onVideoFpsChoose  timeLapseTimeMs : %s ", Integer.valueOf(i3)));
        }
        if (i2 == 2 && i == 1) {
            i5 = R.drawable.icon_13_alert;
        }
        mo10557(String.valueOf(i4), i5, str2);
    }

    /* renamed from: ཬ, reason: contains not printable characters */
    public final void m10629() {
        SensorManager sensorManager = this.f10783;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.f10784);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ྈ, reason: contains not printable characters */
    public void mo10630() {
        if (this.f10732 == null) {
            return;
        }
        int i = this.f10733.mo1261() ? 0 : this.f10821;
        C4008.m12886(this.f10732.f12032, this.f10733.mo1270() ? this.f10794 : 0.0f, this.f10733.mo1216() ? 0.0f : this.f10821, 100, null);
        float f = this.f10733.mo1261() ? this.f10733.mo1270() ? i : -this.f10755 : this.f10821;
        C4008.m12886(this.f10732.f12084, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12085, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12072, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12073, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12083, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12069, 0.0f, f, 100, null);
        float f2 = i;
        C4008.m12886(this.f10732.f12062, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12021, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12019, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12020, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12067, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12055, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12056, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f11998, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f11999, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12048, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12049, 0.0f, f2, 100, null);
        if (!this.f10733.mo1261()) {
            i = this.f10821;
        } else if (!this.f10733.mo1270()) {
            i = this.f10746;
        }
        C4008.m12886(this.f10732.f12029, 0.0f, i, 100, null);
        C4008.m12886(this.f10732.f12099, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12074, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12075, 0.0f, f2, 100, null);
        C4008.m12886(this.f10732.f12063, 0.0f, 0.0f, 100, null);
        C4008.m12886(this.f10732.f12076, 0.0f, 0.0f, 100, new C3050());
        this.f10733.getHandler().postDelayed(new RunnableC3051(), 100L);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ྉ, reason: contains not printable characters */
    public void mo10631(float f, float f2, boolean z, boolean z2) {
        if (this.f10732 == null) {
            return;
        }
        this.f10733.mo1249(false);
        this.f10732.f12011.m3148();
        this.f10732.f12011.setSlidebarAlpha(1.0f);
        this.f10732.f12011.m3154();
        this.f10732.f12011.setDrawIcon(true);
        if (z2) {
            this.f10732.f12011.setDrawIcon(false);
        }
        float fM14415 = C4792.m14375().m14415() / 2;
        ViewGroup.LayoutParams layoutParams = this.f10732.f12037.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        float f3 = i;
        float fMin = Math.min(f3, f - C2579.m9438(fM14415));
        float f4 = i2;
        float fMin2 = Math.min(f4, f2 - C2579.m9438(fM14415));
        this.f10732.f12011.setX(fMin);
        this.f10732.f12011.setY(fMin2);
        this.f10732.f12011.m3155();
        C3947.m12727().m12783(0.5f);
        float fM12734 = C3947.m12727().m12734();
        this.f10733.mo1283((int) C3947.m12727().m12744(), C3947.m12727().m12734());
        this.f10732.f12011.m3153(-1.0f, false, 1.0f - fM12734);
        if (fMin + C2579.m9438(fM14415) + C2579.m9438(40.0f) + C2579.m9438(20.0f) > f3) {
            this.f10732.f12011.m3156();
        } else {
            this.f10732.f12011.m3158();
        }
        if (this.f10820 == null) {
            this.f10820 = new RectF();
        }
        float fM9438 = (C2579.m9438(130.0f) * C4202.m13274().m13282()) / 2.0f;
        float f5 = f2 - fM9438;
        float f6 = f2 + fM9438;
        float f7 = f3 - f;
        float f8 = f7 - fM9438;
        float f9 = f7 + fM9438;
        float fMax = Math.max(0.0f, f5 / f4);
        float fMin3 = Math.min(1.0f, f6 / f4);
        float fMax2 = Math.max(0.0f, f8 / f3);
        float fMin4 = Math.min(1.0f, f9 / f3);
        if (fMin3 < 0.0f) {
            fMin3 = 0.0f;
        }
        if (fMin4 < 0.0f) {
            fMin4 = 0.0f;
        }
        if (z2) {
            float[] focalLengthAndZoomRatio = this.f10732.f11997.getFocalLengthAndZoomRatio();
            this.f10733.mo1220(focalLengthAndZoomRatio[0], focalLengthAndZoomRatio[1]);
        } else {
            float fM5922 = d9.m5921().m5922();
            if (fM5922 != 1.0f) {
                float f10 = 1.0f / fM5922;
                float f11 = (1.0f - f10) / 2.0f;
                float f12 = f11 * f4;
                float f13 = f11 * f3;
                float f14 = (f5 * f10) + f12;
                float f15 = (f8 * f10) + f13;
                float f16 = f12 + (f6 * f10);
                float f17 = f13 + (f9 * f10);
                fMax = Math.max(0.0f, f14 / f4);
                fMin3 = Math.min(1.0f, f16 / f4);
                fMax2 = Math.max(0.0f, f15 / f3);
                fMin4 = Math.min(1.0f, f17 / f3);
            }
            RectF rectF = this.f10820;
            if (rectF.left != fMax || rectF.top != fMax2 || rectF.right != fMin3 || rectF.bottom != fMin4) {
                rectF.left = fMax;
                rectF.top = fMax2;
                rectF.right = fMin3;
                rectF.bottom = fMin4;
                this.f10733.mo1276(rectF);
            }
        }
        this.f10732.f12011.setViewScale(Float.valueOf(C4202.m13274().m13280()));
        this.f10732.f12010.setVisibility(8);
        m10540();
        this.f10732.f12009.setVisibility(8);
        this.f10732.f12011.setVisibility(0);
        this.f10735 = 0;
        if (z) {
            this.f10733.mo1289(false);
            this.f10733.getHandler().removeMessages(105);
            this.f10733.getHandler().removeMessages(108);
            this.f10733.getHandler().removeMessages(107);
            this.f10733.getHandler().removeMessages(109);
            C4202.m13274().m13279(C4202.m13274().m13280(), C4202.m13274().m13282(), 100, new C3045(z2));
            return;
        }
        this.f10733.mo1289(true);
        this.f10732.f12011.setDrawIcon(false);
        this.f10733.getHandler().removeMessages(105);
        this.f10733.getHandler().removeMessages(108);
        this.f10733.getHandler().removeMessages(107);
        this.f10733.getHandler().removeMessages(109);
        C4202.m13274().m13278(this.f10733.getHandler(), false, z2);
    }

    /* renamed from: ྋ, reason: contains not printable characters */
    public final void m10632() {
        this.f10795 = new GestureDetector(getActivity(), new GestureDetectorOnGestureListenerC3031());
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ྌ, reason: contains not printable characters */
    public void mo10633(boolean z, int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        if (z) {
            abstractC3481.f11997.m3226(i);
        } else {
            abstractC3481.f11997.m3213(i);
        }
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ဢ, reason: contains not printable characters */
    public void mo10634(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        C4008.m12876(abstractC3481.f12050, z ? 1.0f : 0.0f, 100, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ဨ, reason: contains not printable characters */
    public void mo10635(boolean z) {
        if (this.f10732 == null) {
            return;
        }
        HorizonCircleRectView.f2347 = true;
        if (z) {
            Sensor defaultSensor = this.f10783.getDefaultSensor(1);
            this.f10784 = defaultSensor;
            this.f10783.registerListener(this, defaultSensor, 1);
        } else {
            m10629();
        }
        this.f10732.f12042.setVisibility(z ? 0 : 8);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၚ, reason: contains not printable characters */
    public void mo10636(boolean z) {
        if (z) {
            mo10633(false, 100);
            mo10526(-1, 0, 100);
            C4008.m12886(this.f10732.f12091, this.f10738, this.f10733.mo1270() ? 0.0f : -this.f10762, 100, null);
            if (m10445()) {
                m10539(true);
            }
        } else {
            mo10633(true, 100);
            mo10526(0, 0, 100);
            C4008.m12886(this.f10732.f12091, 0.0f, this.f10733.mo1270() ? 0.0f : -this.f10762, 100, null);
            if (m10445()) {
                m10539(false);
            }
        }
        this.f10733.mo1219(!z);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၛ, reason: contains not printable characters */
    public void mo10637(boolean z) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        if (z) {
            abstractC3481.f12060.m3319(100);
            this.f10732.f12024.m3265(100);
            this.f10732.f11993.m3188(100);
            this.f10732.f11994.m3188(100);
            C4008.m12886(this.f10732.f12091, this.f10738, this.f10733.mo1270() ? 0.0f : -this.f10762, 100, null);
            if (m10445()) {
                m10539(true);
            }
        } else {
            abstractC3481.f12060.m3333(100);
            this.f10732.f12024.m3278(100);
            this.f10732.f11993.m3192(100);
            this.f10732.f11994.m3192(100);
            C4008.m12886(this.f10732.f12091, 0.0f, this.f10733.mo1270() ? 0.0f : -this.f10762, 100, null);
            if (m10445()) {
                m10539(z || !this.f10733.mo1270());
            }
        }
        this.f10733.mo1219(!z);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e7  */
    @Override // defpackage.AbstractC5160
    /* renamed from: ၜ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo10638(boolean r9) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C2970.mo10638(boolean):void");
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၝ, reason: contains not printable characters */
    public void mo10639() {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        abstractC3481.f12024.m3278(100);
        this.f10732.f12060.m3333(100);
        this.f10732.f11993.m3192(100);
        this.f10732.f11994.m3192(100);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၡ, reason: contains not printable characters */
    public void mo10640(int i) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        C4008.m12876(abstractC3481.f12063, 1.0f, i, new C3059());
        C4008.m12876(this.f10732.f12076, 0.2f, i, null);
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၥ, reason: contains not printable characters */
    public void mo10641() {
        this.f10732.f12010.setVisibility(0);
        this.f10732.f12010.setRotation(0.0f);
        m10540();
        this.f10732.f12009.setVisibility(0);
        this.f10732.f12009.setDrawText(false);
        this.f10732.f12009.setRotation(0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(C4202.m13274().m13281(), 1.0f);
        this.f10799 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.f10799.setRepeatCount(2);
        this.f10799.setRepeatMode(2);
        this.f10799.setInterpolator(new LinearInterpolator());
        this.f10799.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ݕ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f12892.m10405(valueAnimator);
            }
        });
        this.f10799.start();
    }

    @Override // defpackage.AbstractC5160
    /* renamed from: ၦ, reason: contains not printable characters */
    public void mo10642() {
        this.f10732.f12060.m3334(false);
        this.f10732.f12024.m3279(false);
    }

    /* renamed from: ჼ, reason: contains not printable characters */
    public void m10643(Runnable runnable) {
        AbstractC3481 abstractC3481 = this.f10732;
        if (abstractC3481 == null) {
            return;
        }
        float f = this.f10821;
        C4008.m12886(abstractC3481.f12032, this.f10733.mo1270() ? this.f10794 : 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12084, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12085, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12072, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12073, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12083, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12069, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12062, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12021, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12019, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12020, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12067, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12055, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12056, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f11998, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f11999, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12048, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12049, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12029, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12099, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12074, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12075, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12063, 0.0f, f, 100, null);
        C4008.m12886(this.f10732.f12076, 0.0f, f, 100, new C3053(runnable));
    }
}
