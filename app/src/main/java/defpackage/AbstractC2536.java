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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StyleHintView;
import com.blink.academy.film.widgets.WaveformBottomLineView;
import com.blink.academy.film.widgets.transmit.CloudConnectView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorViewBinding.java */
/* renamed from: ȭ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2536 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f9367;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final CloudConnectView f9368;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final View f9369;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f9370;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f9371;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final View f9372;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final MonitorAnimateView f9373;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final ImageView f9374;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final View f9375;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f9376;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final View f9377;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final StyleHintView f9378;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final ImageView f9379;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final View f9380;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f9381;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f9382;

    /* renamed from: ކ, reason: contains not printable characters */
    @NonNull
    public final ImageView f9383;

    /* renamed from: އ, reason: contains not printable characters */
    @NonNull
    public final View f9384;

    /* renamed from: ވ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f9385;

    /* renamed from: މ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f9386;

    /* renamed from: ފ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f9387;

    /* renamed from: ދ, reason: contains not printable characters */
    @NonNull
    public final WaveformBottomLineView f9388;

    /* renamed from: ތ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f9389;

    /* renamed from: ލ, reason: contains not printable characters */
    @NonNull
    public final TextureView f9390;

    /* renamed from: ގ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f9391;

    public AbstractC2536(Object obj, View view, int i, ConstraintLayout constraintLayout, CloudConnectView cloudConnectView, View view2, ImageView imageView, ImageView imageView2, View view3, MonitorAnimateView monitorAnimateView, ImageView imageView3, View view4, ImageView imageView4, View view5, StyleHintView styleHintView, ImageView imageView5, View view6, RelativeLayout relativeLayout, ConstraintLayout constraintLayout2, ImageView imageView6, View view7, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, StrokeTextView strokeTextView, WaveformBottomLineView waveformBottomLineView, FrameLayout frameLayout, TextureView textureView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f9367 = constraintLayout;
        this.f9368 = cloudConnectView;
        this.f9369 = view2;
        this.f9370 = imageView;
        this.f9371 = imageView2;
        this.f9372 = view3;
        this.f9373 = monitorAnimateView;
        this.f9374 = imageView3;
        this.f9375 = view4;
        this.f9376 = imageView4;
        this.f9377 = view5;
        this.f9378 = styleHintView;
        this.f9379 = imageView5;
        this.f9380 = view6;
        this.f9381 = relativeLayout;
        this.f9382 = constraintLayout2;
        this.f9383 = imageView6;
        this.f9384 = view7;
        this.f9385 = constraintLayout3;
        this.f9386 = constraintLayout4;
        this.f9387 = strokeTextView;
        this.f9388 = waveformBottomLineView;
        this.f9389 = frameLayout;
        this.f9390 = textureView;
        this.f9391 = linearLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC2536 m9358(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m9359(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC2536 m9359(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC2536) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_monitor_view, viewGroup, z, obj);
    }
}
