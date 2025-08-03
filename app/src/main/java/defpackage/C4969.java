package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.SolidPointView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutRecordSettingBindingImpl.java */
/* renamed from: ພ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4969 extends AbstractC4876 {

    /* renamed from: ޜ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16706 = null;

    /* renamed from: ޝ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16707;

    /* renamed from: ޚ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16708;

    /* renamed from: ޛ, reason: contains not printable characters */
    public long f16709;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16707 = sparseIntArray;
        sparseIntArray.put(R.id.tv_frame_drop, 1);
        sparseIntArray.put(R.id.sb_frame_drop, 2);
        sparseIntArray.put(R.id.tv_vertical_video, 3);
        sparseIntArray.put(R.id.point_vertical_video, 4);
        sparseIntArray.put(R.id.sb_vertical_video, 5);
        sparseIntArray.put(R.id.tv_flicker, 6);
        sparseIntArray.put(R.id.flicker_50, 7);
        sparseIntArray.put(R.id.flicker_60, 8);
        sparseIntArray.put(R.id.tv_stabilization, 9);
        sparseIntArray.put(R.id.sb_stabilization, 10);
        sparseIntArray.put(R.id.iv_stabilization_info, 11);
        sparseIntArray.put(R.id.v_stabilization_area, 12);
        sparseIntArray.put(R.id.tv_noise_reduction, 13);
        sparseIntArray.put(R.id.sb_noise_reduction, 14);
        sparseIntArray.put(R.id.tv_framework, 15);
        sparseIntArray.put(R.id.framework_auto, 16);
        sparseIntArray.put(R.id.framework_taker, 17);
        sparseIntArray.put(R.id.framework_sys, 18);
        sparseIntArray.put(R.id.iv_framework_info, 19);
        sparseIntArray.put(R.id.tv_edge, 20);
        sparseIntArray.put(R.id.sb_edge, 21);
        sparseIntArray.put(R.id.tv_rec_beeper, 22);
        sparseIntArray.put(R.id.sb_rec_beeper, 23);
        sparseIntArray.put(R.id.tv_rec_flash, 24);
        sparseIntArray.put(R.id.sb_rec_flash, 25);
        sparseIntArray.put(R.id.tv_auto_assistant, 26);
        sparseIntArray.put(R.id.sb_auto_assistant, 27);
        sparseIntArray.put(R.id.tv_volume_key_record, 28);
        sparseIntArray.put(R.id.sb_volume_key_record, 29);
        sparseIntArray.put(R.id.tv_leica_mode, 30);
        sparseIntArray.put(R.id.leica_off, 31);
        sparseIntArray.put(R.id.leica_standard, 32);
        sparseIntArray.put(R.id.leica_vivid, 33);
        sparseIntArray.put(R.id.leica_smooth, 34);
        sparseIntArray.put(R.id.tv_mirror_selfie_record, 35);
        sparseIntArray.put(R.id.sb_mirror_slefie_record, 36);
    }

    public C4969(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 37, f16706, f16707));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16709 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16709 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16709 = 1L;
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

    public C4969(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (StrokeTextViewWithBottomBlock) objArr[7], (StrokeTextViewWithBottomBlock) objArr[8], (StrokeTextViewWithBottomBlock) objArr[16], (StrokeTextViewWithBottomBlock) objArr[18], (StrokeTextViewWithBottomBlock) objArr[17], (ImageView) objArr[19], (ImageView) objArr[11], (StrokeTextViewWithBottomBlock) objArr[31], (StrokeTextViewWithBottomBlock) objArr[34], (StrokeTextViewWithBottomBlock) objArr[32], (StrokeTextViewWithBottomBlock) objArr[33], (SolidPointView) objArr[4], (SwitchButton) objArr[27], (SwitchButton) objArr[21], (SwitchButton) objArr[2], (SwitchButton) objArr[36], (SwitchButton) objArr[14], (SwitchButton) objArr[23], (SwitchButton) objArr[25], (SwitchButton) objArr[10], (SwitchButton) objArr[5], (SwitchButton) objArr[29], (StrokeTextView) objArr[26], (StrokeTextView) objArr[20], (StrokeTextView) objArr[6], (StrokeTextView) objArr[1], (StrokeTextView) objArr[15], (StrokeTextView) objArr[30], (StrokeTextView) objArr[35], (StrokeTextView) objArr[13], (StrokeTextView) objArr[22], (StrokeTextView) objArr[24], (StrokeTextView) objArr[9], (StrokeTextView) objArr[3], (StrokeTextView) objArr[28], (View) objArr[12]);
        this.f16709 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f16708 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
