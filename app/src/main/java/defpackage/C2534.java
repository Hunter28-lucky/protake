package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.StrokeRoundView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.SwitchButton2;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitSettingPage1BindingImpl.java */
/* renamed from: ȩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2534 extends AbstractC4403 {

    /* renamed from: ޱ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9359 = null;

    /* renamed from: ߾, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9360;

    /* renamed from: ޤ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f9361;

    /* renamed from: ޥ, reason: contains not printable characters */
    public long f9362;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9360 = sparseIntArray;
        sparseIntArray.put(R.id.equipment_title, 1);
        sparseIntArray.put(R.id.equipment_camera, 2);
        sparseIntArray.put(R.id.equipment_monitor, 3);
        sparseIntArray.put(R.id.quality_parent, 4);
        sparseIntArray.put(R.id.quality_title, 5);
        sparseIntArray.put(R.id.quality_high, 6);
        sparseIntArray.put(R.id.quality_quick, 7);
        sparseIntArray.put(R.id.quality_latency, 8);
        sparseIntArray.put(R.id.job_parent, 9);
        sparseIntArray.put(R.id.job_title, 10);
        sparseIntArray.put(R.id.job_director, 11);
        sparseIntArray.put(R.id.job_camera, 12);
        sparseIntArray.put(R.id.job_customer, 13);
        sparseIntArray.put(R.id.job_other, 14);
        sparseIntArray.put(R.id.camera_unit_parent, 15);
        sparseIntArray.put(R.id.camera_unit_title, 16);
        sparseIntArray.put(R.id.camera_unit_a, 17);
        sparseIntArray.put(R.id.camera_unit_b, 18);
        sparseIntArray.put(R.id.camera_unit_c, 19);
        sparseIntArray.put(R.id.camera_unit_d, 20);
        sparseIntArray.put(R.id.camera_device_parent, 21);
        sparseIntArray.put(R.id.camera_device_title, 22);
        sparseIntArray.put(R.id.camera_device_number, 23);
        sparseIntArray.put(R.id.fl_reset, 24);
        sparseIntArray.put(R.id.tv_reset, 25);
        sparseIntArray.put(R.id.reset_click, 26);
        sparseIntArray.put(R.id.camera_control_parent, 27);
        sparseIntArray.put(R.id.camera_control_title, 28);
        sparseIntArray.put(R.id.sb_control_camera, 29);
        sparseIntArray.put(R.id.monitor_control_parent, 30);
        sparseIntArray.put(R.id.monitor_control_title, 31);
        sparseIntArray.put(R.id.sb_control_monitor, 32);
        sparseIntArray.put(R.id.cloud_camera_parent, 33);
        sparseIntArray.put(R.id.cloud_title_tv, 34);
        sparseIntArray.put(R.id.cloud_number_tv, 35);
        sparseIntArray.put(R.id.pb_cloud, 36);
        sparseIntArray.put(R.id.fl_reset_room_id, 37);
        sparseIntArray.put(R.id.srv_reset, 38);
        sparseIntArray.put(R.id.tv_reset_room_id, 39);
        sparseIntArray.put(R.id.sb_cloud_camera, 40);
        sparseIntArray.put(R.id.monitor_time_parent, 41);
        sparseIntArray.put(R.id.extend_title_tv, 42);
        sparseIntArray.put(R.id.time_left_tv, 43);
        sparseIntArray.put(R.id.fl_extend, 44);
        sparseIntArray.put(R.id.srv_extend, 45);
        sparseIntArray.put(R.id.tv_extend, 46);
    }

    public C2534(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 47, f9359, f9360));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9362 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9362 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9362 = 1L;
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

    public C2534(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[27], (StrokeTextView) objArr[28], (StrokeTextView) objArr[23], (ConstraintLayout) objArr[21], (StrokeTextView) objArr[22], (StrokeTextViewWithBottomBlock) objArr[17], (StrokeTextViewWithBottomBlock) objArr[18], (StrokeTextViewWithBottomBlock) objArr[19], (StrokeTextViewWithBottomBlock) objArr[20], (ConstraintLayout) objArr[15], (StrokeTextView) objArr[16], (ConstraintLayout) objArr[33], (StrokeTextView) objArr[35], (StrokeTextView) objArr[34], (StrokeTextViewWithBottomBlock) objArr[2], (StrokeTextViewWithBottomBlock) objArr[3], (StrokeTextView) objArr[1], (StrokeTextView) objArr[42], (FrameLayout) objArr[44], (FrameLayout) objArr[24], (FrameLayout) objArr[37], (StrokeTextViewWithBottomBlock) objArr[12], (StrokeTextViewWithBottomBlock) objArr[13], (StrokeTextViewWithBottomBlock) objArr[11], (StrokeTextViewWithBottomBlock) objArr[14], (ConstraintLayout) objArr[9], (StrokeTextView) objArr[10], (ConstraintLayout) objArr[30], (StrokeTextView) objArr[31], (ConstraintLayout) objArr[41], (OneTakeProgressBar) objArr[36], (StrokeTextViewWithBottomBlock) objArr[6], (StrokeTextViewWithBottomBlock) objArr[8], (ConstraintLayout) objArr[4], (StrokeTextViewWithBottomBlock) objArr[7], (StrokeTextView) objArr[5], (View) objArr[26], (SwitchButton2) objArr[40], (SwitchButton) objArr[29], (SwitchButton) objArr[32], (StrokeRoundView) objArr[45], (StrokeRoundView) objArr[38], (StrokeTextView) objArr[43], (TextView) objArr[46], (TextView) objArr[25], (TextView) objArr[39]);
        this.f9362 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9361 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
