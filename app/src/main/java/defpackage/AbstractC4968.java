package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.iso.WheelBorderView;
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.film.widgets.iso.WheelProgressView;
import com.blink.academy.protake.R;

/* compiled from: LayoutFocusZoomBinding.java */
/* renamed from: ຝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4968 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final WheelProgressView f16697;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final WheelIndicatorView f16698;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final WheelBorderView f16699;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16700;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16701;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16702;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f16703;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16704;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final WheelProgressView f16705;

    public AbstractC4968(Object obj, View view, int i, WheelProgressView wheelProgressView, WheelIndicatorView wheelIndicatorView, WheelBorderView wheelBorderView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, StrokeTextView strokeTextView, LinearLayout linearLayout, StrokeTextView strokeTextView2, WheelProgressView wheelProgressView2) {
        super(obj, view, i);
        this.f16697 = wheelProgressView;
        this.f16698 = wheelIndicatorView;
        this.f16699 = wheelBorderView;
        this.f16700 = relativeLayout;
        this.f16701 = relativeLayout2;
        this.f16702 = strokeTextView;
        this.f16703 = linearLayout;
        this.f16704 = strokeTextView2;
        this.f16705 = wheelProgressView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4968 m14748(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14749(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4968 m14749(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4968) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_focus_zoom, viewGroup, z, obj);
    }
}
