package defpackage;

import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StyleHintView;
import com.blink.academy.film.widgets.WaveformBottomLineView;
import com.blink.academy.film.widgets.transmit.CloudConnectView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorAnimateView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorViewBindingImpl.java */
/* renamed from: ಠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4623 extends AbstractC2536 {

    /* renamed from: ސ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15747 = null;

    /* renamed from: ޑ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15748;

    /* renamed from: ޏ, reason: contains not printable characters */
    public long f15749;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15748 = sparseIntArray;
        sparseIntArray.put(R.id.root_parent, 1);
        sparseIntArray.put(R.id.monitor_parent, 2);
        sparseIntArray.put(R.id.monitor_animate_view, 3);
        sparseIntArray.put(R.id.monitor_right_parent, 4);
        sparseIntArray.put(R.id.iv_add_cloud_right, 5);
        sparseIntArray.put(R.id.iv_add_cloud_right_click, 6);
        sparseIntArray.put(R.id.monitor_light, 7);
        sparseIntArray.put(R.id.monitor_light_click, 8);
        sparseIntArray.put(R.id.monitor_four, 9);
        sparseIntArray.put(R.id.monitor_four_click, 10);
        sparseIntArray.put(R.id.monitor_two, 11);
        sparseIntArray.put(R.id.monitor_two_click, 12);
        sparseIntArray.put(R.id.monitor_one, 13);
        sparseIntArray.put(R.id.monitor_one_click, 14);
        sparseIntArray.put(R.id.add_cloud_parent, 15);
        sparseIntArray.put(R.id.iv_add_cloud, 16);
        sparseIntArray.put(R.id.tv_add_cloud, 17);
        sparseIntArray.put(R.id.wave_parent, 18);
        sparseIntArray.put(R.id.wave_bottom_line, 19);
        sparseIntArray.put(R.id.wave_textureview, 20);
        sparseIntArray.put(R.id.waveform_indicator_parent, 21);
        sparseIntArray.put(R.id.cloud_connect_view, 22);
        sparseIntArray.put(R.id.monitor_light_hint, 23);
        sparseIntArray.put(R.id.cover_parent, 24);
    }

    public C4623(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 25, f15747, f15748));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15749 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15749 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15749 = 1L;
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

    public C4623(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[15], (CloudConnectView) objArr[22], (View) objArr[24], (ImageView) objArr[16], (ImageView) objArr[5], (View) objArr[6], (MonitorAnimateView) objArr[3], (ImageView) objArr[9], (View) objArr[10], (ImageView) objArr[7], (View) objArr[8], (StyleHintView) objArr[23], (ImageView) objArr[13], (View) objArr[14], (RelativeLayout) objArr[2], (ConstraintLayout) objArr[4], (ImageView) objArr[11], (View) objArr[12], (ConstraintLayout) objArr[0], (ConstraintLayout) objArr[1], (StrokeTextView) objArr[17], (WaveformBottomLineView) objArr[19], (FrameLayout) objArr[18], (TextureView) objArr[20], (LinearLayout) objArr[21]);
        this.f15749 = -1L;
        this.f9385.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
