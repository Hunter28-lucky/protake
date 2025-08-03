package defpackage;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.AudioSettingPortraitView;
import com.blink.academy.film.widgets.CenterVerticalTextView;
import com.blink.academy.film.widgets.FPSPortraitSettingView;
import com.blink.academy.film.widgets.GridsSettingView;
import com.blink.academy.film.widgets.GuideView;
import com.blink.academy.film.widgets.HorizonCircleRectView;
import com.blink.academy.film.widgets.LensSettingView;
import com.blink.academy.film.widgets.RecordButton;
import com.blink.academy.film.widgets.RecordTimeFrameView;
import com.blink.academy.film.widgets.RecordingRedCoverVIew;
import com.blink.academy.film.widgets.ResolutionSettingView;
import com.blink.academy.film.widgets.StrokePointView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.WaveformBottomLineView;
import com.blink.academy.film.widgets.WbSettingView;
import com.blink.academy.film.widgets.ZebraSettingView;
import com.blink.academy.film.widgets.audio.AudioSchedulePortraitView;
import com.blink.academy.film.widgets.battery.BatteryStoragePortraitView;
import com.blink.academy.film.widgets.beauty.BeautySettingView;
import com.blink.academy.film.widgets.camerainfo.DoubleTextLayout;
import com.blink.academy.film.widgets.exposure.CameraTouchView;
import com.blink.academy.film.widgets.exposure.HollowTextView;
import com.blink.academy.film.widgets.iso.ABPointWheelView;
import com.blink.academy.film.widgets.iso.AutoZoomWheelView;
import com.blink.academy.film.widgets.iso.FocusZoomWheelView;
import com.blink.academy.film.widgets.iso.ISOView;
import com.blink.academy.film.widgets.iso.IsoEtWheelView;
import com.blink.academy.film.widgets.iso.ShutterPortraitView;
import com.blink.academy.film.widgets.looks.LooksPreviewPortraitView;
import com.blink.academy.protake.R;

/* compiled from: FragmentHomePortraitBinding.java */
/* renamed from: ك, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3481 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ABPointWheelView f11993;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ABPointWheelView f11994;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final View f11995;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final AudioSettingPortraitView f11996;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final AutoZoomWheelView f11997;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f11998;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final View f11999;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final BeautySettingView f12000;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final View f12001;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final View f12002;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final View f12003;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final View f12004;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final View f12005;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final View f12006;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final View f12007;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final View f12008;

    /* renamed from: ކ, reason: contains not printable characters */
    @NonNull
    public final HollowTextView f12009;

    /* renamed from: އ, reason: contains not printable characters */
    @NonNull
    public final HollowTextView f12010;

    /* renamed from: ވ, reason: contains not printable characters */
    @NonNull
    public final CameraTouchView f12011;

    /* renamed from: މ, reason: contains not printable characters */
    @NonNull
    public final CardView f12012;

    /* renamed from: ފ, reason: contains not printable characters */
    @NonNull
    public final CardView f12013;

    /* renamed from: ދ, reason: contains not printable characters */
    @NonNull
    public final CardView f12014;

    /* renamed from: ތ, reason: contains not printable characters */
    @NonNull
    public final CardView f12015;

    /* renamed from: ލ, reason: contains not printable characters */
    @NonNull
    public final CardView f12016;

    /* renamed from: ގ, reason: contains not printable characters */
    @NonNull
    public final CardView f12017;

    /* renamed from: ޏ, reason: contains not printable characters */
    @NonNull
    public final CardView f12018;

    /* renamed from: ސ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12019;

    /* renamed from: ޑ, reason: contains not printable characters */
    @NonNull
    public final View f12020;

    /* renamed from: ޒ, reason: contains not printable characters */
    @NonNull
    public final View f12021;

    /* renamed from: ޓ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12022;

    /* renamed from: ޔ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12023;

    /* renamed from: ޕ, reason: contains not printable characters */
    @NonNull
    public final FocusZoomWheelView f12024;

    /* renamed from: ޖ, reason: contains not printable characters */
    @NonNull
    public final View f12025;

    /* renamed from: ޗ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f12026;

    /* renamed from: ޘ, reason: contains not printable characters */
    @NonNull
    public final FPSPortraitSettingView f12027;

    /* renamed from: ޙ, reason: contains not printable characters */
    @NonNull
    public final CenterVerticalTextView f12028;

    /* renamed from: ޚ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12029;

    /* renamed from: ޛ, reason: contains not printable characters */
    @NonNull
    public final AudioSchedulePortraitView f12030;

    /* renamed from: ޜ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12031;

    /* renamed from: ޝ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f12032;

    /* renamed from: ޞ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12033;

    /* renamed from: ޟ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12034;

    /* renamed from: ޠ, reason: contains not printable characters */
    @NonNull
    public final BatteryStoragePortraitView f12035;

    /* renamed from: ޡ, reason: contains not printable characters */
    @NonNull
    public final View f12036;

    /* renamed from: ޢ, reason: contains not printable characters */
    @NonNull
    public final View f12037;

    /* renamed from: ޣ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12038;

    /* renamed from: ޤ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12039;

    /* renamed from: ޥ, reason: contains not printable characters */
    @NonNull
    public final GridsSettingView f12040;

    /* renamed from: ޱ, reason: contains not printable characters */
    @NonNull
    public final GuideView f12041;

    /* renamed from: ߾, reason: contains not printable characters */
    @NonNull
    public final HorizonCircleRectView f12042;

    /* renamed from: ߿, reason: contains not printable characters */
    @NonNull
    public final View f12043;

    /* renamed from: ࡠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12044;

    /* renamed from: ࡡ, reason: contains not printable characters */
    @NonNull
    public final View f12045;

    /* renamed from: ࡢ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12046;

    /* renamed from: ࡣ, reason: contains not printable characters */
    @NonNull
    public final View f12047;

    /* renamed from: ࡤ, reason: contains not printable characters */
    @NonNull
    public final RecordTimeFrameView f12048;

    /* renamed from: ࡥ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12049;

    /* renamed from: ࡦ, reason: contains not printable characters */
    @NonNull
    public final RecordingRedCoverVIew f12050;

    /* renamed from: ࡧ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12051;

    /* renamed from: ࡨ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12052;

    /* renamed from: ࡩ, reason: contains not printable characters */
    @NonNull
    public final View f12053;

    /* renamed from: ࡪ, reason: contains not printable characters */
    @NonNull
    public final View f12054;

    /* renamed from: ࢠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12055;

    /* renamed from: ࢡ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12056;

    /* renamed from: ࢢ, reason: contains not printable characters */
    @NonNull
    public final View f12057;

    /* renamed from: ࢣ, reason: contains not printable characters */
    @NonNull
    public final View f12058;

    /* renamed from: ࢤ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f12059;

    /* renamed from: ࢥ, reason: contains not printable characters */
    @NonNull
    public final IsoEtWheelView f12060;

    /* renamed from: ࢦ, reason: contains not printable characters */
    @NonNull
    public final ISOView f12061;

    /* renamed from: ࢧ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12062;

    /* renamed from: ࢨ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12063;

    /* renamed from: ࢩ, reason: contains not printable characters */
    @NonNull
    public final View f12064;

    /* renamed from: ࢪ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f12065;

    /* renamed from: ࢫ, reason: contains not printable characters */
    @NonNull
    public final LensSettingView f12066;

    /* renamed from: ࢬ, reason: contains not printable characters */
    @NonNull
    public final StrokePointView f12067;

    /* renamed from: ࢭ, reason: contains not printable characters */
    @NonNull
    public final LooksPreviewPortraitView f12068;

    /* renamed from: ࢮ, reason: contains not printable characters */
    @NonNull
    public final View f12069;

    /* renamed from: ࢯ, reason: contains not printable characters */
    @NonNull
    public final CardView f12070;

    /* renamed from: ࢰ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12071;

    /* renamed from: ࢱ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12072;

    /* renamed from: ࢲ, reason: contains not printable characters */
    @NonNull
    public final View f12073;

    /* renamed from: ࢳ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12074;

    /* renamed from: ࢴ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f12075;

    /* renamed from: ࢶ, reason: contains not printable characters */
    @NonNull
    public final RecordButton f12076;

    /* renamed from: ࢷ, reason: contains not printable characters */
    @NonNull
    public final View f12077;

    /* renamed from: ࢸ, reason: contains not printable characters */
    @NonNull
    public final View f12078;

    /* renamed from: ࢹ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f12079;

    /* renamed from: ࢺ, reason: contains not printable characters */
    @NonNull
    public final ResolutionSettingView f12080;

    /* renamed from: ࢻ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12081;

    /* renamed from: ࢼ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12082;

    /* renamed from: ࢽ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12083;

    /* renamed from: ࢾ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12084;

    /* renamed from: ࢿ, reason: contains not printable characters */
    @NonNull
    public final View f12085;

    /* renamed from: ࣀ, reason: contains not printable characters */
    @NonNull
    public final View f12086;

    /* renamed from: ࣁ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f12087;

    /* renamed from: ࣂ, reason: contains not printable characters */
    @NonNull
    public final ShutterPortraitView f12088;

    /* renamed from: ࣃ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12089;

    /* renamed from: ࣄ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12090;

    /* renamed from: ࣅ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f12091;

    /* renamed from: ࣆ, reason: contains not printable characters */
    @NonNull
    public final WaveformBottomLineView f12092;

    /* renamed from: ࣇ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f12093;

    /* renamed from: ৼ, reason: contains not printable characters */
    @NonNull
    public final TextureView f12094;

    /* renamed from: ૹ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f12095;

    /* renamed from: ಀ, reason: contains not printable characters */
    @NonNull
    public final View f12096;

    /* renamed from: ೱ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f12097;

    /* renamed from: ೲ, reason: contains not printable characters */
    @NonNull
    public final WbSettingView f12098;

    /* renamed from: ഄ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12099;

    /* renamed from: ഩ, reason: contains not printable characters */
    @NonNull
    public final ZebraSettingView f12100;

    public AbstractC3481(Object obj, View view, int i, ABPointWheelView aBPointWheelView, ABPointWheelView aBPointWheelView2, View view2, AudioSettingPortraitView audioSettingPortraitView, AutoZoomWheelView autoZoomWheelView, ImageView imageView, View view3, BeautySettingView beautySettingView, View view4, View view5, View view6, View view7, View view8, View view9, View view10, View view11, HollowTextView hollowTextView, HollowTextView hollowTextView2, CameraTouchView cameraTouchView, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, CardView cardView5, CardView cardView6, CardView cardView7, ImageView imageView2, View view12, View view13, ConstraintLayout constraintLayout, ImageView imageView3, FocusZoomWheelView focusZoomWheelView, View view14, DoubleTextLayout doubleTextLayout, FPSPortraitSettingView fPSPortraitSettingView, CenterVerticalTextView centerVerticalTextView, ImageView imageView4, AudioSchedulePortraitView audioSchedulePortraitView, ImageView imageView5, FrameLayout frameLayout, ImageView imageView6, ImageView imageView7, BatteryStoragePortraitView batteryStoragePortraitView, View view15, View view16, ImageView imageView8, ImageView imageView9, GridsSettingView gridsSettingView, GuideView guideView, HorizonCircleRectView horizonCircleRectView, View view17, ImageView imageView10, View view18, ImageView imageView11, View view19, RecordTimeFrameView recordTimeFrameView, StrokeTextView strokeTextView, RecordingRedCoverVIew recordingRedCoverVIew, RelativeLayout relativeLayout, ImageView imageView12, View view20, View view21, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3, View view22, View view23, DoubleTextLayout doubleTextLayout2, IsoEtWheelView isoEtWheelView, ISOView iSOView, ImageView imageView13, ImageView imageView14, View view24, DoubleTextLayout doubleTextLayout3, LensSettingView lensSettingView, StrokePointView strokePointView, LooksPreviewPortraitView looksPreviewPortraitView, View view25, CardView cardView8, ConstraintLayout constraintLayout2, ImageView imageView15, View view26, ImageView imageView16, LinearLayout linearLayout, RecordButton recordButton, View view27, View view28, DoubleTextLayout doubleTextLayout4, ResolutionSettingView resolutionSettingView, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView17, ImageView imageView18, View view29, View view30, DoubleTextLayout doubleTextLayout5, ShutterPortraitView shutterPortraitView, ImageView imageView19, ImageView imageView20, FrameLayout frameLayout2, WaveformBottomLineView waveformBottomLineView, FrameLayout frameLayout3, TextureView textureView, LinearLayout linearLayout2, View view31, DoubleTextLayout doubleTextLayout6, WbSettingView wbSettingView, ImageView imageView21, ZebraSettingView zebraSettingView) {
        super(obj, view, i);
        this.f11993 = aBPointWheelView;
        this.f11994 = aBPointWheelView2;
        this.f11995 = view2;
        this.f11996 = audioSettingPortraitView;
        this.f11997 = autoZoomWheelView;
        this.f11998 = imageView;
        this.f11999 = view3;
        this.f12000 = beautySettingView;
        this.f12001 = view4;
        this.f12002 = view5;
        this.f12003 = view6;
        this.f12004 = view7;
        this.f12005 = view8;
        this.f12006 = view9;
        this.f12007 = view10;
        this.f12008 = view11;
        this.f12009 = hollowTextView;
        this.f12010 = hollowTextView2;
        this.f12011 = cameraTouchView;
        this.f12012 = cardView;
        this.f12013 = cardView2;
        this.f12014 = cardView3;
        this.f12015 = cardView4;
        this.f12016 = cardView5;
        this.f12017 = cardView6;
        this.f12018 = cardView7;
        this.f12019 = imageView2;
        this.f12020 = view12;
        this.f12021 = view13;
        this.f12022 = constraintLayout;
        this.f12023 = imageView3;
        this.f12024 = focusZoomWheelView;
        this.f12025 = view14;
        this.f12026 = doubleTextLayout;
        this.f12027 = fPSPortraitSettingView;
        this.f12028 = centerVerticalTextView;
        this.f12029 = imageView4;
        this.f12030 = audioSchedulePortraitView;
        this.f12031 = imageView5;
        this.f12032 = frameLayout;
        this.f12033 = imageView6;
        this.f12034 = imageView7;
        this.f12035 = batteryStoragePortraitView;
        this.f12036 = view15;
        this.f12037 = view16;
        this.f12038 = imageView8;
        this.f12039 = imageView9;
        this.f12040 = gridsSettingView;
        this.f12041 = guideView;
        this.f12042 = horizonCircleRectView;
        this.f12043 = view17;
        this.f12044 = imageView10;
        this.f12045 = view18;
        this.f12046 = imageView11;
        this.f12047 = view19;
        this.f12048 = recordTimeFrameView;
        this.f12049 = strokeTextView;
        this.f12050 = recordingRedCoverVIew;
        this.f12051 = relativeLayout;
        this.f12052 = imageView12;
        this.f12053 = view20;
        this.f12054 = view21;
        this.f12055 = strokeTextView2;
        this.f12056 = strokeTextView3;
        this.f12057 = view22;
        this.f12058 = view23;
        this.f12059 = doubleTextLayout2;
        this.f12060 = isoEtWheelView;
        this.f12061 = iSOView;
        this.f12062 = imageView13;
        this.f12063 = imageView14;
        this.f12064 = view24;
        this.f12065 = doubleTextLayout3;
        this.f12066 = lensSettingView;
        this.f12067 = strokePointView;
        this.f12068 = looksPreviewPortraitView;
        this.f12069 = view25;
        this.f12070 = cardView8;
        this.f12071 = constraintLayout2;
        this.f12072 = imageView15;
        this.f12073 = view26;
        this.f12074 = imageView16;
        this.f12075 = linearLayout;
        this.f12076 = recordButton;
        this.f12077 = view27;
        this.f12078 = view28;
        this.f12079 = doubleTextLayout4;
        this.f12080 = resolutionSettingView;
        this.f12081 = constraintLayout3;
        this.f12082 = constraintLayout4;
        this.f12083 = imageView17;
        this.f12084 = imageView18;
        this.f12085 = view29;
        this.f12086 = view30;
        this.f12087 = doubleTextLayout5;
        this.f12088 = shutterPortraitView;
        this.f12089 = imageView19;
        this.f12090 = imageView20;
        this.f12091 = frameLayout2;
        this.f12092 = waveformBottomLineView;
        this.f12093 = frameLayout3;
        this.f12094 = textureView;
        this.f12095 = linearLayout2;
        this.f12096 = view31;
        this.f12097 = doubleTextLayout6;
        this.f12098 = wbSettingView;
        this.f12099 = imageView21;
        this.f12100 = zebraSettingView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3481 m11334(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11335(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3481 m11335(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3481) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_portrait, viewGroup, z, obj);
    }
}
