package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokePointView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutLooksChooseBindingImpl.java */
/* renamed from: ਸ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4280 extends AbstractC2472 {

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14665 = null;

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14666;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f14667;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14666 = sparseIntArray;
        sparseIntArray.put(R.id.grids_un_choose_view, 1);
        sparseIntArray.put(R.id.grids_choose_view, 2);
        sparseIntArray.put(R.id.point_parent, 3);
        sparseIntArray.put(R.id.point_white, 4);
        sparseIntArray.put(R.id.point_black, 5);
    }

    public C4280(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f14665, f14666));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14667 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14667 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14667 = 1L;
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

    public C4280(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (StrokeTextView) objArr[1], (StrokePointView) objArr[5], (RelativeLayout) objArr[3], (StrokePointView) objArr[4], (RelativeLayout) objArr[0]);
        this.f14667 = -1L;
        this.f9176.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
