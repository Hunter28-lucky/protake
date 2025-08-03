package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutChangeTintLeftImageTextBinding.java */
/* renamed from: ท, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4890 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final AppCompatImageView f16521;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final AppCompatImageView f16522;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16523;

    public AbstractC4890(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f16521 = appCompatImageView;
        this.f16522 = appCompatImageView2;
        this.f16523 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4890 m14613(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14614(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4890 m14614(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4890) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_change_tint_left_image_text, viewGroup, z, obj);
    }
}
