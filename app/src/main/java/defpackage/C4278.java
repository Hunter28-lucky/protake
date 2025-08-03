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
import com.blink.academy.film.widgets.iso.WheelIndicatorView;
import com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitIsoEtWheelBindingImpl.java */
/* renamed from: ਵ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4278 extends AbstractC3552 {

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14658 = null;

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14659;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f14660;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f14661;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14659 = sparseIntArray;
        sparseIntArray.put(R.id.iv_top, 1);
        sparseIntArray.put(R.id.iv_bottom, 2);
        sparseIntArray.put(R.id.et_wheel, 3);
        sparseIntArray.put(R.id.iso_wheel, 4);
        sparseIntArray.put(R.id.shutter_wheel, 5);
        sparseIntArray.put(R.id.indicator, 6);
        sparseIntArray.put(R.id.tv_exposure, 7);
        sparseIntArray.put(R.id.tv_iso, 8);
        sparseIntArray.put(R.id.tv_shutter, 9);
        sparseIntArray.put(R.id.tv_parent, 10);
        sparseIntArray.put(R.id.rl_shutter, 11);
        sparseIntArray.put(R.id.rl_iso, 12);
        sparseIntArray.put(R.id.iv_wheel_auto, 13);
    }

    public C4278(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f14658, f14659));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14661 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14661 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14661 = 1L;
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

    public C4278(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (PortraitWheelProgressView) objArr[3], (WheelIndicatorView) objArr[6], (PortraitWheelProgressView) objArr[4], (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[13], (RelativeLayout) objArr[12], (RelativeLayout) objArr[11], (PortraitWheelProgressView) objArr[5], (StrokeTextView) objArr[7], (StrokeTextView) objArr[8], (LinearLayout) objArr[10], (StrokeTextView) objArr[9]);
        this.f14661 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f14660 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
