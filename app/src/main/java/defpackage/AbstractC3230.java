package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.PayProductDialog;
import com.blink.academy.film.widgets.transmit.TransmitSettingView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorView;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitFragmentBinding.java */
/* renamed from: Ֆ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3230 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final TransmitSettingView f11381;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final MonitorView f11382;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final PayProductDialog f11383;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f11384;

    public AbstractC3230(Object obj, View view, int i, TransmitSettingView transmitSettingView, MonitorView monitorView, PayProductDialog payProductDialog, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.f11381 = transmitSettingView;
        this.f11382 = monitorView;
        this.f11383 = payProductDialog;
        this.f11384 = constraintLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3230 m10892(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10893(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3230 m10893(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3230) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_transmit_fragment, viewGroup, z, obj);
    }
}
