package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutChangeTintLeftImageTextBindingImpl.java */
/* renamed from: ർ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4755 extends AbstractC4890 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16025 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16026;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16027;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f16028;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16026 = sparseIntArray;
        sparseIntArray.put(R.id.border_iv, 1);
        sparseIntArray.put(R.id.iv, 2);
        sparseIntArray.put(R.id.tv, 3);
    }

    public C4755(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f16025, f16026));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16028 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16028 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16028 = 1L;
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

    public C4755(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatImageView) objArr[1], (AppCompatImageView) objArr[2], (StrokeTextView) objArr[3]);
        this.f16028 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f16027 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
