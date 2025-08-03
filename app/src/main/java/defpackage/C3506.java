package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutStorkeCornerBindingImpl.java */
/* renamed from: پ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3506 extends AbstractC4652 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12272 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12273;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f12274;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12273 = sparseIntArray;
        sparseIntArray.put(R.id.tv_num, 1);
    }

    public C3506(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12272, f12273));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12274 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12274 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12274 = 1L;
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

    public C3506(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[0], (TextView) objArr[1]);
        this.f12274 = -1L;
        this.f15824.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
