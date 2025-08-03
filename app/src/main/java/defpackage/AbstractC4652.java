package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutStorkeCornerBinding.java */
/* renamed from: ಲ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4652 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15824;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final TextView f15825;

    public AbstractC4652(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i);
        this.f15824 = relativeLayout;
        this.f15825 = textView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4652 m14133(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14134(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4652 m14134(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4652) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_storke_corner, viewGroup, z, obj);
    }
}
