package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.CircleStrokeView;
import com.blink.academy.protake.R;

/* compiled from: LayoutRecordBtBindingImpl.java */
/* renamed from: ಓ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4606 extends AbstractC4366 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15699 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15700;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f15701;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f15702;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15700 = sparseIntArray;
        sparseIntArray.put(R.id.iv_outer, 1);
        sparseIntArray.put(R.id.iv_inner, 2);
        sparseIntArray.put(R.id.stroke, 3);
    }

    public C4606(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f15699, f15700));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15702 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15702 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15702 = 1L;
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

    public C4606(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (ImageView) objArr[1], (CircleStrokeView) objArr[3]);
        this.f15702 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f15701 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
