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
import com.blink.academy.film.widgets.SwitchButton2;
import com.blink.academy.protake.R;

/* compiled from: LayoutAccessories3Binding.java */
/* renamed from: ԏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3149 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f11179;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton2 f11180;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final TextView f11181;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final View f11182;

    public AbstractC3149(Object obj, View view, int i, RelativeLayout relativeLayout, SwitchButton2 switchButton2, TextView textView, View view2) {
        super(obj, view, i);
        this.f11179 = relativeLayout;
        this.f11180 = switchButton2;
        this.f11181 = textView;
        this.f11182 = view2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3149 m10753(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10754(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3149 m10754(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3149) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_accessories_3, viewGroup, z, obj);
    }
}
