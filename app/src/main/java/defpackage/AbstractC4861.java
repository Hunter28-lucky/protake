package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.film.widgets.iso.portrait.PortraitABPointView;
import com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitFocusZoomWheelBinding.java */
/* renamed from: ข, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4861 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final PortraitABPointView f16383;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final PortraitABPointView f16384;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final PortraitWheelProgressView f16385;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final WheelIndicatorView f16386;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16387;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16388;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16389;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16390;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16391;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16392;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f16393;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16394;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16395;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final PortraitWheelProgressView f16396;

    public AbstractC4861(Object obj, View view, int i, PortraitABPointView portraitABPointView, PortraitABPointView portraitABPointView2, PortraitWheelProgressView portraitWheelProgressView, WheelIndicatorView wheelIndicatorView, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, StrokeTextView strokeTextView, LinearLayout linearLayout, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3, PortraitWheelProgressView portraitWheelProgressView2) {
        super(obj, view, i);
        this.f16383 = portraitABPointView;
        this.f16384 = portraitABPointView2;
        this.f16385 = portraitWheelProgressView;
        this.f16386 = wheelIndicatorView;
        this.f16387 = imageView;
        this.f16388 = imageView2;
        this.f16389 = imageView3;
        this.f16390 = relativeLayout;
        this.f16391 = relativeLayout2;
        this.f16392 = strokeTextView;
        this.f16393 = linearLayout;
        this.f16394 = strokeTextView2;
        this.f16395 = strokeTextView3;
        this.f16396 = portraitWheelProgressView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4861 m14583(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14584(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4861 m14584(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4861) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_portrait_focus_zoom_wheel, viewGroup, z, obj);
    }
}
