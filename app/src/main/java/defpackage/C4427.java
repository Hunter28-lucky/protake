package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitButtonBindingImpl.java */
/* renamed from: ଫ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4427 extends AbstractC3926 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15270 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15271;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f15272;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15271 = sparseIntArray;
        sparseIntArray.put(R.id.button_text, 1);
    }

    public C4427(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f15270, f15271));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15272 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15272 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15272 = 1L;
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

    public C4427(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (StrokeTextView) objArr[1]);
        this.f15272 = -1L;
        this.f13552.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
