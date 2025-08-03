package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitAbViewBinding.java */
/* renamed from: ԅ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3140 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f11148;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f11149;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f11150;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f11151;

    public AbstractC3140(Object obj, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.f11148 = imageView;
        this.f11149 = imageView2;
        this.f11150 = linearLayout;
        this.f11151 = linearLayout2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3140 m10734(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10735(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3140 m10735(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3140) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_portrait_ab_view, viewGroup, z, obj);
    }
}
