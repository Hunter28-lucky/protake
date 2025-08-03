package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutStyleUpdateBinding.java */
/* renamed from: ଙ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4405 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f15178;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final TextView f15179;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15180;

    public AbstractC4405(Object obj, View view, int i, ImageView imageView, TextView textView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f15178 = imageView;
        this.f15179 = textView;
        this.f15180 = relativeLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4405 m13598(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13599(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4405 m13599(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4405) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_style_update, viewGroup, z, obj);
    }
}
