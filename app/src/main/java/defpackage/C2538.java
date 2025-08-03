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
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.iso.WheelBorderView;
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.film.widgets.iso.WheelProgressView;
import com.blink.academy.protake.R;

/* compiled from: LayoutFocusZoomBindingImpl.java */
/* renamed from: ȱ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2538 extends AbstractC4968 {

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9392 = null;

    /* renamed from: ނ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9393;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f9394;

    /* renamed from: ހ, reason: contains not printable characters */
    public long f9395;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9393 = sparseIntArray;
        sparseIntArray.put(R.id.focus_wheel, 1);
        sparseIntArray.put(R.id.zoom_wheel, 2);
        sparseIntArray.put(R.id.indicator, 3);
        sparseIntArray.put(R.id.tv_parent, 4);
        sparseIntArray.put(R.id.rl_zoom, 5);
        sparseIntArray.put(R.id.rl_focus, 6);
        sparseIntArray.put(R.id.tv_zoom, 7);
        sparseIntArray.put(R.id.tv_focus, 8);
        sparseIntArray.put(R.id.protake_focus_border, 9);
    }

    public C2538(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f9392, f9393));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9395 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9395 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9395 = 1L;
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

    public C2538(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (WheelProgressView) objArr[1], (WheelIndicatorView) objArr[3], (WheelBorderView) objArr[9], (RelativeLayout) objArr[6], (RelativeLayout) objArr[5], (StrokeTextView) objArr[8], (LinearLayout) objArr[4], (StrokeTextView) objArr[7], (WheelProgressView) objArr[2]);
        this.f9395 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9394 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
