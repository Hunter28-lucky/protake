package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.transmit.BoxView;
import com.blink.academy.film.widgets.transmit.TriangleView2;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitBoxBinding.java */
/* renamed from: ผ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4898 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final BoxView f16539;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final TextView f16540;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final TriangleView2 f16541;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f16542;

    public AbstractC4898(Object obj, View view, int i, BoxView boxView, TextView textView, TriangleView2 triangleView2, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f16539 = boxView;
        this.f16540 = textView;
        this.f16541 = triangleView2;
        this.f16542 = frameLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4898 m14624(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14625(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4898 m14625(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4898) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_transmit_box, viewGroup, z, obj);
    }
}
