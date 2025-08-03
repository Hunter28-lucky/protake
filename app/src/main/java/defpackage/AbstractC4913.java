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
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutStyleDownloadingBinding.java */
/* renamed from: ส, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4913 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16566;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16567;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16568;

    public AbstractC4913(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f16566 = imageView;
        this.f16567 = relativeLayout;
        this.f16568 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4913 m14638(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14639(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4913 m14639(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4913) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_style_downloading, viewGroup, z, obj);
    }
}
