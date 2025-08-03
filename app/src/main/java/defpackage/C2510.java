package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.film.widgets.iso.WheelProgressZoomView;
import com.blink.academy.film.widgets.iso.ZoomButtonBgView;
import com.blink.academy.film.widgets.iso.ZoomButtonGroup;
import com.blink.academy.protake.R;

/* compiled from: LayoutAutoZoomBindingImpl.java */
/* renamed from: ȁ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2510 extends AbstractC4145 {

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9307 = null;

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9308;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f9309;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f9310;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9308 = sparseIntArray;
        sparseIntArray.put(R.id.zoom_wheel, 1);
        sparseIntArray.put(R.id.indicator, 2);
        sparseIntArray.put(R.id.zoom_bg_parent, 3);
        sparseIntArray.put(R.id.zoom_bg, 4);
        sparseIntArray.put(R.id.zoom_button_group, 5);
    }

    public C2510(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9307, f9308));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9310 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9310 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9310 = 1L;
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

    public C2510(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (WheelIndicatorView) objArr[2], (ZoomButtonBgView) objArr[4], (FrameLayout) objArr[3], (ZoomButtonGroup) objArr[5], (WheelProgressZoomView) objArr[1]);
        this.f9310 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9309 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
