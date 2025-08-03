package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitButtonBinding.java */
/* renamed from: ࡇ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3926 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13552;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f13553;

    public AbstractC3926(Object obj, View view, int i, ConstraintLayout constraintLayout, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f13552 = constraintLayout;
        this.f13553 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3926 m12684(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m12685(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3926 m12685(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3926) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_transmit_button, viewGroup, z, obj);
    }
}
