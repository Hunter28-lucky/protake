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

/* compiled from: LayoutDoubleTextBindingImpl.java */
/* renamed from: ŏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2369 extends AbstractC3615 {

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8913 = null;

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f8914;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f8915;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f8916;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8914 = sparseIntArray;
        sparseIntArray.put(R.id.top_name_tv, 1);
        sparseIntArray.put(R.id.top_right_iv, 2);
        sparseIntArray.put(R.id.bottom_value_tv, 3);
        sparseIntArray.put(R.id.bottom_value_right_iv, 4);
        sparseIntArray.put(R.id.bottom_value_right_tv, 5);
        sparseIntArray.put(R.id.bottom_value_iv, 6);
    }

    public C2369(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f8913, f8914));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8916 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8916 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8916 = 1L;
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

    public C2369(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (ImageView) objArr[4], (StrokeTextView) objArr[5], (StrokeTextView) objArr[3], (StrokeTextView) objArr[1], (ImageView) objArr[2]);
        this.f8916 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8915 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
