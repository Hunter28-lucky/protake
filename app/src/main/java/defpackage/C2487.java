package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutHintViewBindingImpl.java */
/* renamed from: ǟ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2487 extends AbstractC4534 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9181 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9182;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f9183;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9182 = sparseIntArray;
        sparseIntArray.put(R.id.tv_hint, 1);
    }

    public C2487(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f9181, f9182));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9183 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9183 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9183 = 1L;
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

    public C2487(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[0], (StrokeTextView) objArr[1]);
        this.f9183 = -1L;
        this.f15513.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
