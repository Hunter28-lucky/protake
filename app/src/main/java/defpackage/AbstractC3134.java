package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutSocketAddressItemBinding.java */
/* renamed from: ӽ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3134 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final Button f11135;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final TextView f11136;

    public AbstractC3134(Object obj, View view, int i, Button button, TextView textView) {
        super(obj, view, i);
        this.f11135 = button;
        this.f11136 = textView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3134 m10724(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10725(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3134 m10725(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3134) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_socket_address_item, viewGroup, z, obj);
    }
}
