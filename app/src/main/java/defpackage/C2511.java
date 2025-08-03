package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutCloudMonitorSwitchBindingImpl.java */
/* renamed from: ȃ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2511 extends AbstractC4961 {

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9311 = null;

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9312;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f9313;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f9314;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9312 = sparseIntArray;
        sparseIntArray.put(R.id.iv, 1);
        sparseIntArray.put(R.id.iv_white, 2);
        sparseIntArray.put(R.id.tv_type, 3);
        sparseIntArray.put(R.id.tv_name, 4);
        sparseIntArray.put(R.id.tv_time, 5);
    }

    public C2511(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9311, f9312));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9314 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9314 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9314 = 1L;
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

    public C2511(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[2], (StrokeTextView) objArr[4], (StrokeTextView) objArr[5], (StrokeTextView) objArr[3]);
        this.f9314 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9313 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
