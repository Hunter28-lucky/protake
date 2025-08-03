package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

/* compiled from: LayoutIsoEtWheelBindingImpl.java */
/* renamed from: ȫ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2535 extends AbstractC3089 {

    /* renamed from: ބ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9363 = null;

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9364;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f9365;

    /* renamed from: ރ, reason: contains not printable characters */
    public long f9366;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9364 = sparseIntArray;
        sparseIntArray.put(R.id.et_wheel, 1);
        sparseIntArray.put(R.id.iso_wheel, 2);
        sparseIntArray.put(R.id.shutter_wheel, 3);
        sparseIntArray.put(R.id.indicator, 4);
        sparseIntArray.put(R.id.tv_exposure, 5);
        sparseIntArray.put(R.id.tv_iso, 6);
        sparseIntArray.put(R.id.tv_shutter, 7);
        sparseIntArray.put(R.id.tv_parent, 8);
        sparseIntArray.put(R.id.rl_shutter, 9);
        sparseIntArray.put(R.id.rl_iso, 10);
        sparseIntArray.put(R.id.iv_wheel_auto, 11);
        sparseIntArray.put(R.id.protake_focus_border, 12);
    }

    public C2535(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f9363, f9364));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9366 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9366 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9366 = 1L;
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

    public C2535(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (WheelProgressView) objArr[1], (WheelIndicatorView) objArr[4], (WheelProgressView) objArr[2], (ImageView) objArr[11], (WheelBorderView) objArr[12], (RelativeLayout) objArr[10], (RelativeLayout) objArr[9], (WheelProgressView) objArr[3], (StrokeTextView) objArr[5], (StrokeTextView) objArr[6], (LinearLayout) objArr[8], (StrokeTextView) objArr[7]);
        this.f9366 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9365 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
