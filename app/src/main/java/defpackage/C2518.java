package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.protake.R;

/* compiled from: LayoutFootagePanelBindingImpl.java */
/* renamed from: ȏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2518 extends AbstractC3106 {

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9336 = null;

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9337;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f9338;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9337 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.tv_origin, 3);
        sparseIntArray.put(R.id.tv_24, 4);
        sparseIntArray.put(R.id.tv_25, 5);
        sparseIntArray.put(R.id.tv_30, 6);
    }

    public C2518(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f9336, f9337));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9338 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9338 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9338 = 1L;
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

    public C2518(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (StrokeTextView) objArr[1], (ConstraintLayout) objArr[0], (StrokeTextViewWithBottomBlock) objArr[4], (StrokeTextViewWithBottomBlock) objArr[5], (StrokeTextViewWithBottomBlock) objArr[6], (StrokeTextViewWithBottomBlock) objArr[3]);
        this.f9338 = -1L;
        this.f11052.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
