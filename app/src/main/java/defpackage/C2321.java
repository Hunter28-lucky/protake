package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.protake.R;

/* compiled from: LayoutItemDeviceConnectedBindingImpl.java */
/* renamed from: đ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2321 extends AbstractC3413 {

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8825 = null;

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f8826;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f8827;

    /* renamed from: ׯ, reason: contains not printable characters */
    public long f8828;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8826 = sparseIntArray;
        sparseIntArray.put(R.id.tv_wifi_device_no, 1);
        sparseIntArray.put(R.id.iv_wifi_strength_parent, 2);
        sparseIntArray.put(R.id.iv_wifi_strength, 3);
        sparseIntArray.put(R.id.iv_wifi_click, 4);
        sparseIntArray.put(R.id.iv_control_state_parent, 5);
        sparseIntArray.put(R.id.iv_control_state, 6);
        sparseIntArray.put(R.id.iv_control_click, 7);
    }

    public C2321(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f8825, f8826));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8828 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8828 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8828 = 1L;
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

    public C2321(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[7], (ChangeTintImageView) objArr[6], (ConstraintLayout) objArr[5], (View) objArr[4], (ChangeTintImageView) objArr[3], (ConstraintLayout) objArr[2], (StrokeTextView) objArr[1]);
        this.f8828 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8827 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
