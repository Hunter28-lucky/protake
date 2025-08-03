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
import com.blink.academy.film.widgets.transmit.BoxView;
import com.blink.academy.film.widgets.transmit.TriangleView2;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitBoxBindingImpl.java */
/* renamed from: ܭ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3695 extends AbstractC4898 {

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12819 = null;

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12820;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12821;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f12822;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12820 = sparseIntArray;
        sparseIntArray.put(R.id.tv_parent, 1);
        sparseIntArray.put(R.id.box_view, 2);
        sparseIntArray.put(R.id.text_view, 3);
        sparseIntArray.put(R.id.triangle_view, 4);
    }

    public C3695(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12819, f12820));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12822 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12822 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12822 = 1L;
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

    public C3695(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BoxView) objArr[2], (TextView) objArr[3], (TriangleView2) objArr[4], (FrameLayout) objArr[1]);
        this.f12822 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12821 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
