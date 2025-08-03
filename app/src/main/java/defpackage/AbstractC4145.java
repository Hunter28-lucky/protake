package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.film.widgets.iso.WheelProgressZoomView;
import com.blink.academy.film.widgets.iso.ZoomButtonBgView;
import com.blink.academy.film.widgets.iso.ZoomButtonGroup;
import com.blink.academy.protake.R;

/* compiled from: LayoutAutoZoomBinding.java */
/* renamed from: এ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4145 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final WheelIndicatorView f14369;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ZoomButtonBgView f14370;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f14371;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ZoomButtonGroup f14372;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final WheelProgressZoomView f14373;

    public AbstractC4145(Object obj, View view, int i, WheelIndicatorView wheelIndicatorView, ZoomButtonBgView zoomButtonBgView, FrameLayout frameLayout, ZoomButtonGroup zoomButtonGroup, WheelProgressZoomView wheelProgressZoomView) {
        super(obj, view, i);
        this.f14369 = wheelIndicatorView;
        this.f14370 = zoomButtonBgView;
        this.f14371 = frameLayout;
        this.f14372 = zoomButtonGroup;
        this.f14373 = wheelProgressZoomView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4145 m13127(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13128(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4145 m13128(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4145) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_auto_zoom, viewGroup, z, obj);
    }
}
