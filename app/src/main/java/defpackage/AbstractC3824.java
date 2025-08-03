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
import com.blink.academy.protake.R;

/* compiled from: LayoutAbWheelBinding.java */
/* renamed from: ߐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3824 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f13097;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f13098;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f13099;

    public AbstractC3824(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f13097 = imageView;
        this.f13098 = imageView2;
        this.f13099 = relativeLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3824 m12135(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m12136(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3824 m12136(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3824) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_ab_wheel, viewGroup, z, obj);
    }
}
