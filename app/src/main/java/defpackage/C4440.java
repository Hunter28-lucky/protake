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
import com.blink.academy.film.widgets.SolidPointView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitSettingViewBindingImpl.java */
/* renamed from: ହ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4440 extends AbstractC4862 {

    /* renamed from: ࡩ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15298 = null;

    /* renamed from: ࡪ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15299;

    /* renamed from: ࡧ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f15300;

    /* renamed from: ࡨ, reason: contains not printable characters */
    public long f15301;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15299 = sparseIntArray;
        sparseIntArray.put(R.id.rl_beeper, 1);
        sparseIntArray.put(R.id.line_beeper_top, 2);
        sparseIntArray.put(R.id.tv_beeper, 3);
        sparseIntArray.put(R.id.beeper_switch, 4);
        sparseIntArray.put(R.id.line_beeper_bottom, 5);
        sparseIntArray.put(R.id.rl_flash, 6);
        sparseIntArray.put(R.id.tv_flash, 7);
        sparseIntArray.put(R.id.flash_switch, 8);
        sparseIntArray.put(R.id.line_flash_bottom, 9);
        sparseIntArray.put(R.id.rl_volume_rec, 10);
        sparseIntArray.put(R.id.tv_volume_rec, 11);
        sparseIntArray.put(R.id.volume_rec_switch, 12);
        sparseIntArray.put(R.id.volume_rec_bottom, 13);
        sparseIntArray.put(R.id.rl_frame_drop, 14);
        sparseIntArray.put(R.id.tv_frame_drop, 15);
        sparseIntArray.put(R.id.frame_drop_switch, 16);
        sparseIntArray.put(R.id.frame_drop_bottom, 17);
        sparseIntArray.put(R.id.rl_stabilization, 18);
        sparseIntArray.put(R.id.tv_stabilization, 19);
        sparseIntArray.put(R.id.iv_hint_stabilization, 20);
        sparseIntArray.put(R.id.stabilization_hint_click, 21);
        sparseIntArray.put(R.id.stabilization_switch, 22);
        sparseIntArray.put(R.id.stabilization_bottom, 23);
        sparseIntArray.put(R.id.rl_noise_reduction, 24);
        sparseIntArray.put(R.id.tv_noise_reduction, 25);
        sparseIntArray.put(R.id.noise_reduction_switch, 26);
        sparseIntArray.put(R.id.noise_reduction_bottom, 27);
        sparseIntArray.put(R.id.rl_sharp, 28);
        sparseIntArray.put(R.id.tv_sharp, 29);
        sparseIntArray.put(R.id.sharp_switch, 30);
        sparseIntArray.put(R.id.sharp_bottom, 31);
        sparseIntArray.put(R.id.rl_screen, 32);
        sparseIntArray.put(R.id.line_screen_top, 33);
        sparseIntArray.put(R.id.tv_screen, 34);
        sparseIntArray.put(R.id.point_vertical_video, 35);
        sparseIntArray.put(R.id.screen_switch, 36);
        sparseIntArray.put(R.id.line_screen_bottom, 37);
        sparseIntArray.put(R.id.tv_hz, 38);
        sparseIntArray.put(R.id.rl_hz_50, 39);
        sparseIntArray.put(R.id.line_hz50_top, 40);
        sparseIntArray.put(R.id.tv_hz50, 41);
        sparseIntArray.put(R.id.v_hz50_check, 42);
        sparseIntArray.put(R.id.line_hz50_bottom, 43);
        sparseIntArray.put(R.id.rl_hz_60, 44);
        sparseIntArray.put(R.id.tv_hz60, 45);
        sparseIntArray.put(R.id.v_hz60_check, 46);
        sparseIntArray.put(R.id.line_hz60_bottom, 47);
        sparseIntArray.put(R.id.rl_mirror, 48);
        sparseIntArray.put(R.id.line_mirror_top, 49);
        sparseIntArray.put(R.id.tv_mirror, 50);
        sparseIntArray.put(R.id.mirror_switch, 51);
        sparseIntArray.put(R.id.line_mirror_bottom, 52);
        sparseIntArray.put(R.id.rl_hdmi_performance, 53);
        sparseIntArray.put(R.id.tv_hdmi_performance, 54);
        sparseIntArray.put(R.id.iv_hint_hdmi_performance, 55);
        sparseIntArray.put(R.id.hdmi_performance_hint_click, 56);
        sparseIntArray.put(R.id.hdmi_performance_switch, 57);
        sparseIntArray.put(R.id.hdmi_performance_bottom, 58);
    }

    public C4440(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 59, f15298, f15299));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15301 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15301 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15301 = 1L;
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

    public C4440(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Switch) objArr[4], (Switch) objArr[8], (View) objArr[17], (Switch) objArr[16], (View) objArr[58], (View) objArr[56], (Switch) objArr[57], (ImageView) objArr[55], (ImageView) objArr[20], (View) objArr[5], (View) objArr[2], (View) objArr[9], (View) objArr[43], (View) objArr[40], (View) objArr[47], (View) objArr[52], (View) objArr[49], (View) objArr[37], (View) objArr[33], (Switch) objArr[51], (View) objArr[27], (Switch) objArr[26], (SolidPointView) objArr[35], (RelativeLayout) objArr[1], (RelativeLayout) objArr[6], (RelativeLayout) objArr[14], (RelativeLayout) objArr[53], (RelativeLayout) objArr[39], (RelativeLayout) objArr[44], (RelativeLayout) objArr[48], (RelativeLayout) objArr[24], (RelativeLayout) objArr[32], (RelativeLayout) objArr[28], (RelativeLayout) objArr[18], (RelativeLayout) objArr[10], (Switch) objArr[36], (View) objArr[31], (Switch) objArr[30], (View) objArr[23], (View) objArr[21], (Switch) objArr[22], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[15], (TextView) objArr[54], (TextView) objArr[38], (TextView) objArr[41], (TextView) objArr[45], (TextView) objArr[50], (TextView) objArr[25], (TextView) objArr[34], (TextView) objArr[29], (TextView) objArr[19], (TextView) objArr[11], (CheckView) objArr[42], (CheckView) objArr[46], (View) objArr[13], (Switch) objArr[12]);
        this.f15301 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f15300 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
