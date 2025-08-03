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
import com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitIsoEtWheelBinding.java */
/* renamed from: ڟ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3552 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final PortraitWheelProgressView f12346;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final WheelIndicatorView f12347;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final PortraitWheelProgressView f12348;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12349;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12350;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12351;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12352;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12353;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final PortraitWheelProgressView f12354;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12355;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12356;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f12357;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12358;

    public AbstractC3552(Object obj, View view, int i, PortraitWheelProgressView portraitWheelProgressView, WheelIndicatorView wheelIndicatorView, PortraitWheelProgressView portraitWheelProgressView2, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, PortraitWheelProgressView portraitWheelProgressView3, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, LinearLayout linearLayout, StrokeTextView strokeTextView3) {
        super(obj, view, i);
        this.f12346 = portraitWheelProgressView;
        this.f12347 = wheelIndicatorView;
        this.f12348 = portraitWheelProgressView2;
        this.f12349 = imageView;
        this.f12350 = imageView2;
        this.f12351 = imageView3;
        this.f12352 = relativeLayout;
        this.f12353 = relativeLayout2;
        this.f12354 = portraitWheelProgressView3;
        this.f12355 = strokeTextView;
        this.f12356 = strokeTextView2;
        this.f12357 = linearLayout;
        this.f12358 = strokeTextView3;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3552 m11493(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11494(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3552 m11494(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3552) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_portrait_iso_et_wheel, viewGroup, z, obj);
    }
}
