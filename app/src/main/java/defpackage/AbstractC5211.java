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

/* compiled from: LayoutSettingCodeDiaBinding.java */
/* renamed from: Ⴎ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5211 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f17264;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f17265;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final View f17266;

    public AbstractC5211(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, View view2) {
        super(obj, view, i);
        this.f17264 = imageView;
        this.f17265 = relativeLayout;
        this.f17266 = view2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC5211 m15204(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m15205(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC5211 m15205(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC5211) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_setting_code_dia, viewGroup, z, obj);
    }
}
