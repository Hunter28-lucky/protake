package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.stream.ACWheelProgressView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.protake.R;

/* compiled from: LayoutAcWheelBindingImpl.java */
/* renamed from: ɞ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2582 extends AbstractC4410 {

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9615 = null;

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9616;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f9617;

    /* renamed from: ؠ, reason: contains not printable characters */
    public long f9618;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9616 = sparseIntArray;
        sparseIntArray.put(R.id.focus_wheel, 1);
        sparseIntArray.put(R.id.zoom_wheel, 2);
        sparseIntArray.put(R.id.indicator, 3);
        sparseIntArray.put(R.id.tv_parent, 4);
        sparseIntArray.put(R.id.rl_zoom, 5);
        sparseIntArray.put(R.id.rl_focus, 6);
        sparseIntArray.put(R.id.tv_zoom, 7);
        sparseIntArray.put(R.id.tv_focus, 8);
    }

    public C2582(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f9615, f9616));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9618 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9618 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9618 = 1L;
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

    public C2582(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ACWheelProgressView) objArr[1], (WheelIndicatorView) objArr[3], (RelativeLayout) objArr[6], (RelativeLayout) objArr[5], (StrokeTextView) objArr[8], (LinearLayout) objArr[4], (StrokeTextView) objArr[7], (ACWheelProgressView) objArr[2]);
        this.f9618 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9617 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
