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
import com.blink.academy.film.stream.ACWheelProgressView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.protake.R;

/* compiled from: LayoutAcWheelBinding.java */
/* renamed from: ଝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4410 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ACWheelProgressView f15192;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final WheelIndicatorView f15193;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15194;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15195;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f15196;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f15197;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f15198;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final ACWheelProgressView f15199;

    public AbstractC4410(Object obj, View view, int i, ACWheelProgressView aCWheelProgressView, WheelIndicatorView wheelIndicatorView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, StrokeTextView strokeTextView, LinearLayout linearLayout, StrokeTextView strokeTextView2, ACWheelProgressView aCWheelProgressView2) {
        super(obj, view, i);
        this.f15192 = aCWheelProgressView;
        this.f15193 = wheelIndicatorView;
        this.f15194 = relativeLayout;
        this.f15195 = relativeLayout2;
        this.f15196 = strokeTextView;
        this.f15197 = linearLayout;
        this.f15198 = strokeTextView2;
        this.f15199 = aCWheelProgressView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4410 m13607(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13608(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4410 m13608(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4410) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_ac_wheel, viewGroup, z, obj);
    }
}
