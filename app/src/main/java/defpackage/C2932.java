package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutExtendBindingImpl.java */
/* renamed from: ѝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2932 extends AbstractC4148 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10641 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f10642;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f10643;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10642 = sparseIntArray;
        sparseIntArray.put(R.id.tv_time, 1);
        sparseIntArray.put(R.id.fl_extend, 2);
        sparseIntArray.put(R.id.tv_extend, 3);
    }

    public C2932(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10641, f10642));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f10643 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10643 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10643 = 1L;
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

    public C2932(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (FrameLayout) objArr[2], (TextView) objArr[3], (StrokeTextView) objArr[1]);
        this.f10643 = -1L;
        this.f14374.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
