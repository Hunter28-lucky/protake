package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorSignalViewBindingImpl.java */
/* renamed from: ভ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4195 extends AbstractC3772 {

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14450 = null;

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14451;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f14452;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f14453;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14451 = sparseIntArray;
        sparseIntArray.put(R.id.tv_time, 1);
        sparseIntArray.put(R.id.iv_signal, 2);
        sparseIntArray.put(R.id.fl_cloud, 3);
        sparseIntArray.put(R.id.iv_cloud_border, 4);
        sparseIntArray.put(R.id.iv_cloud, 5);
        sparseIntArray.put(R.id.tv_device_no, 6);
    }

    public C4195(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f14450, f14451));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14453 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14453 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14453 = 1L;
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

    public C4195(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[3], (AppCompatImageView) objArr[5], (AppCompatImageView) objArr[4], (ChangeTintImageView) objArr[2], (StrokeTextView) objArr[6], (StrokeTextView) objArr[1]);
        this.f14453 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14452 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
