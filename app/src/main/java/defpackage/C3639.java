package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.protake.R;

/* compiled from: LayoutAccessoriesContainerBindingImpl.java */
/* renamed from: ے, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3639 extends AbstractC3107 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12629 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12630;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12631;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f12632;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12630 = sparseIntArray;
        sparseIntArray.put(R.id.pager, 1);
        sparseIntArray.put(R.id.rl_indicator, 2);
        sparseIntArray.put(R.id.indicator_container, 3);
    }

    public C3639(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12629, f12630));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12632 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12632 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12632 = 1L;
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

    public C3639(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (ViewPager) objArr[1], (RelativeLayout) objArr[2]);
        this.f12632 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f12631 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
