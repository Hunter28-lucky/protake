package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeCornerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutBeautyItemBinding.java */
/* renamed from: ȍ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2517 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f9331;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f9332;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f9333;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f9334;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeCornerView f9335;

    public AbstractC2517(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, StrokeTextView strokeTextView, StrokeCornerView strokeCornerView) {
        super(obj, view, i);
        this.f9331 = imageView;
        this.f9332 = relativeLayout;
        this.f9333 = relativeLayout2;
        this.f9334 = strokeTextView;
        this.f9335 = strokeCornerView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC2517 m9306(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m9307(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC2517 m9307(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC2517) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_beauty_item, viewGroup, z, obj);
    }
}
