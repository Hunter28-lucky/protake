package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.PayProductDialog;
import com.blink.academy.film.widgets.transmit.TransmitSettingView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorView;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitFragmentBindingImpl.java */
/* renamed from: ਕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4241 extends AbstractC3230 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14571 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14572;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f14573;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14572 = sparseIntArray;
        sparseIntArray.put(R.id.home_transmit_setting_view, 1);
        sparseIntArray.put(R.id.monitor_view, 2);
        sparseIntArray.put(R.id.pay_product_dialog, 3);
    }

    public C4241(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f14571, f14572));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14573 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14573 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14573 = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public C4241(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TransmitSettingView) objArr[1], (MonitorView) objArr[2], (PayProductDialog) objArr[3], (ConstraintLayout) objArr[0]);
        this.f14573 = -1L;
        this.f11384.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
