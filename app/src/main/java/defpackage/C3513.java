package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.BottomBlockView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutGridsItemBindingImpl.java */
/* renamed from: ڄ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3513 extends AbstractC2502 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12285 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12286;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f12287;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12286 = sparseIntArray;
        sparseIntArray.put(R.id.tv_grids_des, 1);
        sparseIntArray.put(R.id.tv_content, 2);
        sparseIntArray.put(R.id.bottom, 3);
    }

    public C3513(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12285, f12286));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12287 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12287 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12287 = 1L;
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

    public C3513(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BottomBlockView) objArr[3], (RelativeLayout) objArr[0], (StrokeTextView) objArr[2], (StrokeTextView) objArr[1]);
        this.f12287 = -1L;
        this.f9277.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
