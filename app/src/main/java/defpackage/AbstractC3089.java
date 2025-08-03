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
import com.blink.academy.film.widgets.iso.WheelBorderView;
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.film.widgets.iso.WheelProgressView;
import com.blink.academy.protake.R;

/* compiled from: LayoutIsoEtWheelBinding.java */
/* renamed from: ҽ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3089 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final WheelProgressView f10975;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final WheelIndicatorView f10976;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final WheelProgressView f10977;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10978;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final WheelBorderView f10979;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f10980;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f10981;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final WheelProgressView f10982;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f10983;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f10984;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f10985;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f10986;

    public AbstractC3089(Object obj, View view, int i, WheelProgressView wheelProgressView, WheelIndicatorView wheelIndicatorView, WheelProgressView wheelProgressView2, ImageView imageView, WheelBorderView wheelBorderView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, WheelProgressView wheelProgressView3, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, LinearLayout linearLayout, StrokeTextView strokeTextView3) {
        super(obj, view, i);
        this.f10975 = wheelProgressView;
        this.f10976 = wheelIndicatorView;
        this.f10977 = wheelProgressView2;
        this.f10978 = imageView;
        this.f10979 = wheelBorderView;
        this.f10980 = relativeLayout;
        this.f10981 = relativeLayout2;
        this.f10982 = wheelProgressView3;
        this.f10983 = strokeTextView;
        this.f10984 = strokeTextView2;
        this.f10985 = linearLayout;
        this.f10986 = strokeTextView3;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3089 m10681(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10682(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3089 m10682(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3089) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_iso_et_wheel, viewGroup, z, obj);
    }
}
