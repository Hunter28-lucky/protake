package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorUnitBindingImpl.java */
/* renamed from: ஏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4459 extends AbstractC3117 {

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15340 = null;

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15341;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15342;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f15343;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15341 = sparseIntArray;
        sparseIntArray.put(R.id.monitor_unit_a, 1);
        sparseIntArray.put(R.id.monitor_unit_b, 2);
        sparseIntArray.put(R.id.monitor_unit_c, 3);
        sparseIntArray.put(R.id.monitor_unit_d, 4);
        sparseIntArray.put(R.id.monitor_unit_close, 5);
    }

    public C4459(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f15340, f15341));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15343 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15343 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15343 = 1L;
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

    public C4459(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (StrokeTextViewWithBottomBlock) objArr[1], (StrokeTextViewWithBottomBlock) objArr[2], (StrokeTextViewWithBottomBlock) objArr[3], (StrokeTextViewWithBottomBlock) objArr[5], (StrokeTextViewWithBottomBlock) objArr[4]);
        this.f15343 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f15342 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
