package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutCloudPlayerConnnectBindingImpl.java */
/* renamed from: ಒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4605 extends AbstractC4960 {

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15695 = null;

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15696;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15697;

    /* renamed from: ׯ, reason: contains not printable characters */
    public long f15698;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15696 = sparseIntArray;
        sparseIntArray.put(R.id.tv_connect_time, 1);
        sparseIntArray.put(R.id.disconnect_parent, 2);
        sparseIntArray.put(R.id.tv_disconnect, 3);
        sparseIntArray.put(R.id.extend_parent, 4);
        sparseIntArray.put(R.id.tv_time, 5);
        sparseIntArray.put(R.id.fl_extend, 6);
        sparseIntArray.put(R.id.tv_extend, 7);
    }

    public C4605(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f15695, f15696));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15698 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15698 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15698 = 1L;
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

    public C4605(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[2], (ConstraintLayout) objArr[4], (FrameLayout) objArr[6], (StrokeTextView) objArr[1], (TextView) objArr[3], (TextView) objArr[7], (StrokeTextView) objArr[5]);
        this.f15698 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f15697 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
