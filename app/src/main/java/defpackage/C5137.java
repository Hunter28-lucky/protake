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
import com.blink.academy.film.widgets.iso.portrait.PortraitABPointView;
import com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitFocusZoomWheelBindingImpl.java */
/* renamed from: ဥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5137 extends AbstractC4861 {

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f17056 = null;

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f17057;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f17058;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f17059;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17057 = sparseIntArray;
        sparseIntArray.put(R.id.focus_wheel, 1);
        sparseIntArray.put(R.id.zoom_wheel, 2);
        sparseIntArray.put(R.id.indicator, 3);
        sparseIntArray.put(R.id.tv_parent, 4);
        sparseIntArray.put(R.id.rl_zoom, 5);
        sparseIntArray.put(R.id.rl_focus, 6);
        sparseIntArray.put(R.id.tv_zoom, 7);
        sparseIntArray.put(R.id.tv_focus, 8);
        sparseIntArray.put(R.id.iv_top, 9);
        sparseIntArray.put(R.id.iv_bottom, 10);
        sparseIntArray.put(R.id.tv_top_focus, 11);
        sparseIntArray.put(R.id.iv_bottom_focus, 12);
        sparseIntArray.put(R.id.ab_zoom, 13);
        sparseIntArray.put(R.id.ab_focus, 14);
    }

    public C5137(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, f17056, f17057));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f17059 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17059 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17059 = 1L;
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

    public C5137(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (PortraitABPointView) objArr[14], (PortraitABPointView) objArr[13], (PortraitWheelProgressView) objArr[1], (WheelIndicatorView) objArr[3], (ImageView) objArr[10], (ImageView) objArr[12], (ImageView) objArr[9], (RelativeLayout) objArr[6], (RelativeLayout) objArr[5], (StrokeTextView) objArr[8], (LinearLayout) objArr[4], (StrokeTextView) objArr[11], (StrokeTextView) objArr[7], (PortraitWheelProgressView) objArr[2]);
        this.f17059 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f17058 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
