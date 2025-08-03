package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.stream.ACUnitView;
import com.blink.academy.film.widgets.GuideView;

/* compiled from: LayoutMonitorTextureGroupBindingImpl.java */
/* renamed from: କ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4401 extends AbstractC3080 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15129 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15130 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f15131;

    public C4401(@Nullable DataBindingComponent dataBindingComponent, @NonNull View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 4, f15129, f15130));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15131 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15131 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15131 = 1L;
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

    public C4401(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        super(dataBindingComponent, viewArr[0], 0, (GuideView) objArr[3], (View) objArr[0], (View) objArr[2], (ACUnitView) objArr[1]);
        this.f15131 = -1L;
        this.f10949.setTag(null);
        this.f10950.setTag(null);
        this.f10951.setTag(null);
        this.f10952.setTag(null);
        setRootTag(viewArr);
        invalidateAll();
    }
}
