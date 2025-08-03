package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.protake.R;

/* compiled from: ItemPresetPagerBindingImpl.java */
/* renamed from: થ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4352 extends AbstractC3865 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14906 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14907;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f14908;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f14909;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14907 = sparseIntArray;
        sparseIntArray.put(R.id.rv, 1);
    }

    public C4352(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f14906, f14907));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14909 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14909 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14909 = 1L;
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

    public C4352(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[1]);
        this.f14909 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f14908 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
