package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.exposure.SlideBarView;
import com.blink.academy.film.widgets.exposure.TouchSquareView;
import com.blink.academy.protake.R;

/* compiled from: LayoutCameraTouchBindingImpl.java */
/* renamed from: ȕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2521 extends AbstractC5215 {

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9341 = null;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9342;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f9343;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f9344;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9342 = sparseIntArray;
        sparseIntArray.put(R.id.capture_touch_focus, 1);
        sparseIntArray.put(R.id.capture_slidebar, 2);
    }

    public C2521(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f9341, f9342));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9344 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9344 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9344 = 1L;
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

    public C2521(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SlideBarView) objArr[2], (TouchSquareView) objArr[1]);
        this.f9344 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f9343 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
