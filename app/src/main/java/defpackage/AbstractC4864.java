package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutTagViewBinding.java */
/* renamed from: ฅ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4864 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16459;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16460;

    public AbstractC4864(Object obj, View view, int i, ImageView imageView, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f16459 = imageView;
        this.f16460 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4864 m14587(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14588(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4864 m14588(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4864) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_tag_view, viewGroup, z, obj);
    }
}
