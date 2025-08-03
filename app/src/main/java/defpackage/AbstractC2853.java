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
import com.blink.academy.film.widgets.AudioScheduleView;
import com.blink.academy.film.widgets.AudioSettingView;
import com.blink.academy.film.widgets.BatteryStorageView;
import com.blink.academy.film.widgets.CenterVerticalTextView;
import com.blink.academy.film.widgets.FPSSettingView;
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
import com.blink.academy.film.widgets.beauty.BeautySettingView;
import com.blink.academy.film.widgets.camerainfo.DoubleTextLayout;
import com.blink.academy.film.widgets.exposure.CameraTouchView;
import com.blink.academy.film.widgets.exposure.HollowTextView;
import com.blink.academy.film.widgets.iso.ABPointWheelView;
import com.blink.academy.film.widgets.iso.AutoZoomWheelView;
import com.blink.academy.film.widgets.iso.FocusZoomWheelView;
import com.blink.academy.film.widgets.iso.ISOView;
import com.blink.academy.film.widgets.iso.IsoEtWheelView;
import com.blink.academy.film.widgets.iso.ShutterView;
import com.blink.academy.film.widgets.looks.LooksPreviewView;
import com.blink.academy.film.widgets.transmit.BubbleBoxView;
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.film.widgets.transmit.ChangeTintLeftImageTextView;
import com.blink.academy.protake.R;

/* compiled from: FragmentHomeLandscapeBinding.java */
/* renamed from: ϭ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2853 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ABPointWheelView f10337;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ABPointWheelView f10338;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final View f10339;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final AudioSettingView f10340;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final AutoZoomWheelView f10341;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10342;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final View f10343;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final BeautySettingView f10344;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final View f10345;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final View f10346;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final View f10347;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final View f10348;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final View f10349;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final View f10350;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final View f10351;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final View f10352;

    /* renamed from: ކ, reason: contains not printable characters */
    @NonNull
    public final HollowTextView f10353;

    /* renamed from: އ, reason: contains not printable characters */
    @NonNull
    public final HollowTextView f10354;

    /* renamed from: ވ, reason: contains not printable characters */
    @NonNull
    public final CameraTouchView f10355;

    /* renamed from: މ, reason: contains not printable characters */
    @NonNull
    public final CardView f10356;

    /* renamed from: ފ, reason: contains not printable characters */
    @NonNull
    public final CardView f10357;

    /* renamed from: ދ, reason: contains not printable characters */
    @NonNull
    public final CardView f10358;

    /* renamed from: ތ, reason: contains not printable characters */
    @NonNull
    public final CardView f10359;

    /* renamed from: ލ, reason: contains not printable characters */
    @NonNull
    public final CardView f10360;

    /* renamed from: ގ, reason: contains not printable characters */
    @NonNull
    public final CardView f10361;

    /* renamed from: ޏ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10362;

    /* renamed from: ސ, reason: contains not printable characters */
    @NonNull
    public final View f10363;

    /* renamed from: ޑ, reason: contains not printable characters */
    @NonNull
    public final View f10364;

    /* renamed from: ޒ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10365;

    /* renamed from: ޓ, reason: contains not printable characters */
    @NonNull
    public final FocusZoomWheelView f10366;

    /* renamed from: ޔ, reason: contains not printable characters */
    @NonNull
    public final View f10367;

    /* renamed from: ޕ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f10368;

    /* renamed from: ޖ, reason: contains not printable characters */
    @NonNull
    public final FPSSettingView f10369;

    /* renamed from: ޗ, reason: contains not printable characters */
    @NonNull
    public final View f10370;

    /* renamed from: ޘ, reason: contains not printable characters */
    @NonNull
    public final CenterVerticalTextView f10371;

    /* renamed from: ޙ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10372;

    /* renamed from: ޚ, reason: contains not printable characters */
    @NonNull
    public final AudioScheduleView f10373;

    /* renamed from: ޛ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10374;

    /* renamed from: ޜ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f10375;

    /* renamed from: ޝ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10376;

    /* renamed from: ޞ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10377;

    /* renamed from: ޟ, reason: contains not printable characters */
    @NonNull
    public final BatteryStorageView f10378;

    /* renamed from: ޠ, reason: contains not printable characters */
    @NonNull
    public final View f10379;

    /* renamed from: ޡ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10380;

    /* renamed from: ޢ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10381;

    /* renamed from: ޣ, reason: contains not printable characters */
    @NonNull
    public final GridsSettingView f10382;

    /* renamed from: ޤ, reason: contains not printable characters */
    @NonNull
    public final GuideView f10383;

    /* renamed from: ޥ, reason: contains not printable characters */
    @NonNull
    public final HorizonCircleRectView f10384;

    /* renamed from: ޱ, reason: contains not printable characters */
    @NonNull
    public final View f10385;

    /* renamed from: ߾, reason: contains not printable characters */
    @NonNull
    public final ChangeTintImageView f10386;

    /* renamed from: ߿, reason: contains not printable characters */
    @NonNull
    public final View f10387;

    /* renamed from: ࡠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10388;

    /* renamed from: ࡡ, reason: contains not printable characters */
    @NonNull
    public final View f10389;

    /* renamed from: ࡢ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10390;

    /* renamed from: ࡣ, reason: contains not printable characters */
    @NonNull
    public final View f10391;

    /* renamed from: ࡤ, reason: contains not printable characters */
    @NonNull
    public final RecordTimeFrameView f10392;

    /* renamed from: ࡥ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f10393;

    /* renamed from: ࡦ, reason: contains not printable characters */
    @NonNull
    public final RecordingRedCoverVIew f10394;

    /* renamed from: ࡧ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f10395;

    /* renamed from: ࡨ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10396;

    /* renamed from: ࡩ, reason: contains not printable characters */
    @NonNull
    public final View f10397;

    /* renamed from: ࡪ, reason: contains not printable characters */
    @NonNull
    public final View f10398;

    /* renamed from: ࢠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f10399;

    /* renamed from: ࢡ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f10400;

    /* renamed from: ࢢ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f10401;

    /* renamed from: ࢣ, reason: contains not printable characters */
    @NonNull
    public final ChangeTintLeftImageTextView f10402;

    /* renamed from: ࢤ, reason: contains not printable characters */
    @NonNull
    public final View f10403;

    /* renamed from: ࢥ, reason: contains not printable characters */
    @NonNull
    public final View f10404;

    /* renamed from: ࢦ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f10405;

    /* renamed from: ࢧ, reason: contains not printable characters */
    @NonNull
    public final IsoEtWheelView f10406;

    /* renamed from: ࢨ, reason: contains not printable characters */
    @NonNull
    public final ISOView f10407;

    /* renamed from: ࢩ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10408;

    /* renamed from: ࢪ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10409;

    /* renamed from: ࢫ, reason: contains not printable characters */
    @NonNull
    public final View f10410;

    /* renamed from: ࢬ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f10411;

    /* renamed from: ࢭ, reason: contains not printable characters */
    @NonNull
    public final LensSettingView f10412;

    /* renamed from: ࢮ, reason: contains not printable characters */
    @NonNull
    public final StrokePointView f10413;

    /* renamed from: ࢯ, reason: contains not printable characters */
    @NonNull
    public final LooksPreviewView f10414;

    /* renamed from: ࢰ, reason: contains not printable characters */
    @NonNull
    public final View f10415;

    /* renamed from: ࢱ, reason: contains not printable characters */
    @NonNull
    public final CardView f10416;

    /* renamed from: ࢲ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10417;

    /* renamed from: ࢳ, reason: contains not printable characters */
    @NonNull
    public final View f10418;

    /* renamed from: ࢴ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10419;

    /* renamed from: ࢶ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f10420;

    /* renamed from: ࢷ, reason: contains not printable characters */
    @NonNull
    public final RecordButton f10421;

    /* renamed from: ࢸ, reason: contains not printable characters */
    @NonNull
    public final View f10422;

    /* renamed from: ࢹ, reason: contains not printable characters */
    @NonNull
    public final View f10423;

    /* renamed from: ࢺ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f10424;

    /* renamed from: ࢻ, reason: contains not printable characters */
    @NonNull
    public final ResolutionSettingView f10425;

    /* renamed from: ࢼ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f10426;

    /* renamed from: ࢽ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10427;

    /* renamed from: ࢾ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10428;

    /* renamed from: ࢿ, reason: contains not printable characters */
    @NonNull
    public final View f10429;

    /* renamed from: ࣀ, reason: contains not printable characters */
    @NonNull
    public final View f10430;

    /* renamed from: ࣁ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f10431;

    /* renamed from: ࣂ, reason: contains not printable characters */
    @NonNull
    public final ShutterView f10432;

    /* renamed from: ࣃ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10433;

    /* renamed from: ࣄ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10434;

    /* renamed from: ࣅ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f10435;

    /* renamed from: ࣆ, reason: contains not printable characters */
    @NonNull
    public final View f10436;

    /* renamed from: ࣇ, reason: contains not printable characters */
    @NonNull
    public final BubbleBoxView f10437;

    /* renamed from: ৼ, reason: contains not printable characters */
    @NonNull
    public final WaveformBottomLineView f10438;

    /* renamed from: ૹ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f10439;

    /* renamed from: ಀ, reason: contains not printable characters */
    @NonNull
    public final TextureView f10440;

    /* renamed from: ೱ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f10441;

    /* renamed from: ೲ, reason: contains not printable characters */
    @NonNull
    public final View f10442;

    /* renamed from: ഄ, reason: contains not printable characters */
    @NonNull
    public final DoubleTextLayout f10443;

    /* renamed from: ഩ, reason: contains not printable characters */
    @NonNull
    public final WbSettingView f10444;

    /* renamed from: ഺ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10445;

    /* renamed from: ൎ, reason: contains not printable characters */
    @NonNull
    public final ZebraSettingView f10446;

    public AbstractC2853(Object obj, View view, int i, ABPointWheelView aBPointWheelView, ABPointWheelView aBPointWheelView2, View view2, AudioSettingView audioSettingView, AutoZoomWheelView autoZoomWheelView, ImageView imageView, View view3, BeautySettingView beautySettingView, View view4, View view5, View view6, View view7, View view8, View view9, View view10, View view11, HollowTextView hollowTextView, HollowTextView hollowTextView2, CameraTouchView cameraTouchView, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, CardView cardView5, CardView cardView6, ImageView imageView2, View view12, View view13, ImageView imageView3, FocusZoomWheelView focusZoomWheelView, View view14, DoubleTextLayout doubleTextLayout, FPSSettingView fPSSettingView, View view15, CenterVerticalTextView centerVerticalTextView, ImageView imageView4, AudioScheduleView audioScheduleView, ImageView imageView5, FrameLayout frameLayout, ImageView imageView6, ImageView imageView7, BatteryStorageView batteryStorageView, View view16, ImageView imageView8, ImageView imageView9, GridsSettingView gridsSettingView, GuideView guideView, HorizonCircleRectView horizonCircleRectView, View view17, ChangeTintImageView changeTintImageView, View view18, ImageView imageView10, View view19, ImageView imageView11, View view20, RecordTimeFrameView recordTimeFrameView, StrokeTextView strokeTextView, RecordingRedCoverVIew recordingRedCoverVIew, RelativeLayout relativeLayout, ImageView imageView12, View view21, View view22, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3, StrokeTextView strokeTextView4, ChangeTintLeftImageTextView changeTintLeftImageTextView, View view23, View view24, DoubleTextLayout doubleTextLayout2, IsoEtWheelView isoEtWheelView, ISOView iSOView, ImageView imageView13, ImageView imageView14, View view25, DoubleTextLayout doubleTextLayout3, LensSettingView lensSettingView, StrokePointView strokePointView, LooksPreviewView looksPreviewView, View view26, CardView cardView7, ImageView imageView15, View view27, ImageView imageView16, LinearLayout linearLayout, RecordButton recordButton, View view28, View view29, DoubleTextLayout doubleTextLayout4, ResolutionSettingView resolutionSettingView, ConstraintLayout constraintLayout, ImageView imageView17, ImageView imageView18, View view30, View view31, DoubleTextLayout doubleTextLayout5, ShutterView shutterView, ImageView imageView19, ImageView imageView20, FrameLayout frameLayout2, View view32, BubbleBoxView bubbleBoxView, WaveformBottomLineView waveformBottomLineView, FrameLayout frameLayout3, TextureView textureView, LinearLayout linearLayout2, View view33, DoubleTextLayout doubleTextLayout6, WbSettingView wbSettingView, ImageView imageView21, ZebraSettingView zebraSettingView) {
        super(obj, view, i);
        this.f10337 = aBPointWheelView;
        this.f10338 = aBPointWheelView2;
        this.f10339 = view2;
        this.f10340 = audioSettingView;
        this.f10341 = autoZoomWheelView;
        this.f10342 = imageView;
        this.f10343 = view3;
        this.f10344 = beautySettingView;
        this.f10345 = view4;
        this.f10346 = view5;
        this.f10347 = view6;
        this.f10348 = view7;
        this.f10349 = view8;
        this.f10350 = view9;
        this.f10351 = view10;
        this.f10352 = view11;
        this.f10353 = hollowTextView;
        this.f10354 = hollowTextView2;
        this.f10355 = cameraTouchView;
        this.f10356 = cardView;
        this.f10357 = cardView2;
        this.f10358 = cardView3;
        this.f10359 = cardView4;
        this.f10360 = cardView5;
        this.f10361 = cardView6;
        this.f10362 = imageView2;
        this.f10363 = view12;
        this.f10364 = view13;
        this.f10365 = imageView3;
        this.f10366 = focusZoomWheelView;
        this.f10367 = view14;
        this.f10368 = doubleTextLayout;
        this.f10369 = fPSSettingView;
        this.f10370 = view15;
        this.f10371 = centerVerticalTextView;
        this.f10372 = imageView4;
        this.f10373 = audioScheduleView;
        this.f10374 = imageView5;
        this.f10375 = frameLayout;
        this.f10376 = imageView6;
        this.f10377 = imageView7;
        this.f10378 = batteryStorageView;
        this.f10379 = view16;
        this.f10380 = imageView8;
        this.f10381 = imageView9;
        this.f10382 = gridsSettingView;
        this.f10383 = guideView;
        this.f10384 = horizonCircleRectView;
        this.f10385 = view17;
        this.f10386 = changeTintImageView;
        this.f10387 = view18;
        this.f10388 = imageView10;
        this.f10389 = view19;
        this.f10390 = imageView11;
        this.f10391 = view20;
        this.f10392 = recordTimeFrameView;
        this.f10393 = strokeTextView;
        this.f10394 = recordingRedCoverVIew;
        this.f10395 = relativeLayout;
        this.f10396 = imageView12;
        this.f10397 = view21;
        this.f10398 = view22;
        this.f10399 = strokeTextView2;
        this.f10400 = strokeTextView3;
        this.f10401 = strokeTextView4;
        this.f10402 = changeTintLeftImageTextView;
        this.f10403 = view23;
        this.f10404 = view24;
        this.f10405 = doubleTextLayout2;
        this.f10406 = isoEtWheelView;
        this.f10407 = iSOView;
        this.f10408 = imageView13;
        this.f10409 = imageView14;
        this.f10410 = view25;
        this.f10411 = doubleTextLayout3;
        this.f10412 = lensSettingView;
        this.f10413 = strokePointView;
        this.f10414 = looksPreviewView;
        this.f10415 = view26;
        this.f10416 = cardView7;
        this.f10417 = imageView15;
        this.f10418 = view27;
        this.f10419 = imageView16;
        this.f10420 = linearLayout;
        this.f10421 = recordButton;
        this.f10422 = view28;
        this.f10423 = view29;
        this.f10424 = doubleTextLayout4;
        this.f10425 = resolutionSettingView;
        this.f10426 = constraintLayout;
        this.f10427 = imageView17;
        this.f10428 = imageView18;
        this.f10429 = view30;
        this.f10430 = view31;
        this.f10431 = doubleTextLayout5;
        this.f10432 = shutterView;
        this.f10433 = imageView19;
        this.f10434 = imageView20;
        this.f10435 = frameLayout2;
        this.f10436 = view32;
        this.f10437 = bubbleBoxView;
        this.f10438 = waveformBottomLineView;
        this.f10439 = frameLayout3;
        this.f10440 = textureView;
        this.f10441 = linearLayout2;
        this.f10442 = view33;
        this.f10443 = doubleTextLayout6;
        this.f10444 = wbSettingView;
        this.f10445 = imageView21;
        this.f10446 = zebraSettingView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC2853 m10192(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10193(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC2853 m10193(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC2853) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_landscape, viewGroup, z, obj);
    }
}
