package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.CheckView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitDataSettingBindingImpl.java */
/* renamed from: ຜ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4967 extends AbstractC4324 {

    /* renamed from: ޝ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16694 = null;

    /* renamed from: ޞ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16695;

    /* renamed from: ޜ, reason: contains not printable characters */
    public long f16696;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16695 = sparseIntArray;
        sparseIntArray.put(R.id.rl_unit, 1);
        sparseIntArray.put(R.id.line_unit_top, 2);
        sparseIntArray.put(R.id.tv_camera_unit, 3);
        sparseIntArray.put(R.id.tv_unit, 4);
        sparseIntArray.put(R.id.iv_unit, 5);
        sparseIntArray.put(R.id.line_unit_bottom, 6);
        sparseIntArray.put(R.id.rl_reel, 7);
        sparseIntArray.put(R.id.tv_camera_reel, 8);
        sparseIntArray.put(R.id.tv_reel, 9);
        sparseIntArray.put(R.id.iv_reel, 10);
        sparseIntArray.put(R.id.line_reel_bottom, 11);
        sparseIntArray.put(R.id.rl_clip, 12);
        sparseIntArray.put(R.id.tv_camera_clip, 13);
        sparseIntArray.put(R.id.tv_clip, 14);
        sparseIntArray.put(R.id.line_clip_bottom, 15);
        sparseIntArray.put(R.id.rl_suffix, 16);
        sparseIntArray.put(R.id.tv_camera_suffix, 17);
        sparseIntArray.put(R.id.tv_suffix, 18);
        sparseIntArray.put(R.id.line_suffix_bottom, 19);
        sparseIntArray.put(R.id.rl_reset, 20);
        sparseIntArray.put(R.id.tv_camera_reset, 21);
        sparseIntArray.put(R.id.tv_format, 22);
        sparseIntArray.put(R.id.rl_264, 23);
        sparseIntArray.put(R.id.line_264_top, 24);
        sparseIntArray.put(R.id.tv_264, 25);
        sparseIntArray.put(R.id.v_264_check, 26);
        sparseIntArray.put(R.id.line_264_bottom, 27);
        sparseIntArray.put(R.id.rl_265, 28);
        sparseIntArray.put(R.id.tv_265, 29);
        sparseIntArray.put(R.id.v_265_check, 30);
        sparseIntArray.put(R.id.line_265_bottom, 31);
        sparseIntArray.put(R.id.rl_location, 32);
        sparseIntArray.put(R.id.line_location_top, 33);
        sparseIntArray.put(R.id.tv_location, 34);
        sparseIntArray.put(R.id.location_switch, 35);
        sparseIntArray.put(R.id.location_switch_top, 36);
        sparseIntArray.put(R.id.line_location_bottom, 37);
    }

    public C4967(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 38, f16694, f16695));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16696 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16696 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16696 = 1L;
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

    public C4967(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[10], (ImageView) objArr[5], (View) objArr[27], (View) objArr[24], (View) objArr[31], (View) objArr[15], (View) objArr[37], (View) objArr[33], (View) objArr[11], (View) objArr[19], (View) objArr[6], (View) objArr[2], (Switch) objArr[35], (View) objArr[36], (RelativeLayout) objArr[23], (RelativeLayout) objArr[28], (RelativeLayout) objArr[12], (RelativeLayout) objArr[32], (RelativeLayout) objArr[7], (RelativeLayout) objArr[20], (RelativeLayout) objArr[16], (RelativeLayout) objArr[1], (FrameLayout) objArr[0], (TextView) objArr[25], (TextView) objArr[29], (TextView) objArr[13], (TextView) objArr[8], (TextView) objArr[21], (TextView) objArr[17], (TextView) objArr[3], (TextView) objArr[14], (TextView) objArr[22], (TextView) objArr[34], (TextView) objArr[9], (TextView) objArr[18], (TextView) objArr[4], (CheckView) objArr[26], (CheckView) objArr[30]);
        this.f16696 = -1L;
        this.f14830.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
