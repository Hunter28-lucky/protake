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
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.protake.R;

/* compiled from: LayoutItemDeviceConnectedBinding.java */
/* renamed from: ת, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3413 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final View f11771;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ChangeTintImageView f11772;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f11773;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final View f11774;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ChangeTintImageView f11775;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f11776;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f11777;

    public AbstractC3413(Object obj, View view, int i, View view2, ChangeTintImageView changeTintImageView, ConstraintLayout constraintLayout, View view3, ChangeTintImageView changeTintImageView2, ConstraintLayout constraintLayout2, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f11771 = view2;
        this.f11772 = changeTintImageView;
        this.f11773 = constraintLayout;
        this.f11774 = view3;
        this.f11775 = changeTintImageView2;
        this.f11776 = constraintLayout2;
        this.f11777 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3413 m11195(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11196(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3413 m11196(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3413) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_item_device_connected, viewGroup, z, obj);
    }
}
