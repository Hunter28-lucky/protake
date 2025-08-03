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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.AudioSettingView;
import com.blink.academy.film.widgets.CenterVerticalTextView;
import com.blink.academy.film.widgets.FPSSettingView;
import com.blink.academy.film.widgets.GridsSettingView;
import com.blink.academy.film.widgets.LensSettingView;
import com.blink.academy.film.widgets.RecordButton;
import com.blink.academy.film.widgets.RecordTimeFrameView;
import com.blink.academy.film.widgets.ResolutionSettingView;
import com.blink.academy.film.widgets.StrokePointView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StyleHintView;
import com.blink.academy.film.widgets.SubscribeDialog;
import com.blink.academy.film.widgets.WaveformBottomLineView;
import com.blink.academy.film.widgets.WbSettingView;
import com.blink.academy.film.widgets.ZebraSettingView;
import com.blink.academy.film.widgets.audio.AudioSchedulePortraitView;
import com.blink.academy.film.widgets.battery.BatteryStoragePortraitView;
import com.blink.academy.film.widgets.camerainfo.DoubleTextLayout;
import com.blink.academy.film.widgets.cover.ModeHintDialog;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.exposure.CameraTouchView;
import com.blink.academy.film.widgets.exposure.HollowTextView;
import com.blink.academy.film.widgets.iso.ISOView;
import com.blink.academy.film.widgets.iso.ShutterView;
import com.blink.academy.film.widgets.looks.LooksPreviewView;
import com.blink.academy.protake.R;

/* compiled from: LayoutHomePortraitBindingImpl.java */
/* renamed from: ઉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4308 extends AbstractC4358 {

    /* renamed from: ࢻ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14776 = null;

    /* renamed from: ࢼ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14777;

    /* renamed from: ࢹ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f14778;

    /* renamed from: ࢺ, reason: contains not printable characters */
    public long f14779;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14777 = sparseIntArray;
        sparseIntArray.put(R.id.card_center, 1);
        sparseIntArray.put(R.id.camera_area, 2);
        sparseIntArray.put(R.id.camera_cover, 3);
        sparseIntArray.put(R.id.camera_big_left_cover, 4);
        sparseIntArray.put(R.id.camera_big_right_cover, 5);
        sparseIntArray.put(R.id.camera_big_top_cover, 6);
        sparseIntArray.put(R.id.camera_big_bottom_cover, 7);
        sparseIntArray.put(R.id.card_camera_touch, 8);
        sparseIntArray.put(R.id.capture_touch_view, 9);
        sparseIntArray.put(R.id.home_touch_area, 10);
        sparseIntArray.put(R.id.all_click_area, 11);
        sparseIntArray.put(R.id.wave_parent, 12);
        sparseIntArray.put(R.id.wave_bottom_line, 13);
        sparseIntArray.put(R.id.wave_textureview, 14);
        sparseIntArray.put(R.id.home_battery_storage, 15);
        sparseIntArray.put(R.id.home_audio_schedule, 16);
        sparseIntArray.put(R.id.res_double_text_layout, 17);
        sparseIntArray.put(R.id.fps_double_text_layout, 18);
        sparseIntArray.put(R.id.shutter_double_text_layout, 19);
        sparseIntArray.put(R.id.iso_double_text_layout, 20);
        sparseIntArray.put(R.id.wb_double_text_layout, 21);
        sparseIntArray.put(R.id.lens_double_text_layout, 22);
        sparseIntArray.put(R.id.res_click_area, 23);
        sparseIntArray.put(R.id.fps_click_area, 24);
        sparseIntArray.put(R.id.shutter_click_area, 25);
        sparseIntArray.put(R.id.iso_click_area, 26);
        sparseIntArray.put(R.id.wb_click_area, 27);
        sparseIntArray.put(R.id.lens_click_area, 28);
        sparseIntArray.put(R.id.frame_drop_tv, 29);
        sparseIntArray.put(R.id.color_click_area, 30);
        sparseIntArray.put(R.id.color_lock_area, 31);
        sparseIntArray.put(R.id.setting_click_area, 32);
        sparseIntArray.put(R.id.play_click_area, 33);
        sparseIntArray.put(R.id.orientation_click_area, 34);
        sparseIntArray.put(R.id.capture_exposure_bg, 35);
        sparseIntArray.put(R.id.capture_exposure_lock_htv, 36);
        sparseIntArray.put(R.id.record_btn, 37);
        sparseIntArray.put(R.id.iv_record_btn_lock, 38);
        sparseIntArray.put(R.id.record_btn_top, 39);
        sparseIntArray.put(R.id.home_record_frame, 40);
        sparseIntArray.put(R.id.home_record_num, 41);
        sparseIntArray.put(R.id.pro_indicator_parent, 42);
        sparseIntArray.put(R.id.pro_btn, 43);
        sparseIntArray.put(R.id.zebra_btn, 44);
        sparseIntArray.put(R.id.grid_btn, 45);
        sparseIntArray.put(R.id.home_auto_switch_camera, 46);
        sparseIntArray.put(R.id.home_auto_switch_iv, 47);
        sparseIntArray.put(R.id.setting_btn, 48);
        sparseIntArray.put(R.id.color_btn, 49);
        sparseIntArray.put(R.id.looks_point, 50);
        sparseIntArray.put(R.id.home_tv_style, 51);
        sparseIntArray.put(R.id.home_tv_style_top, 52);
        sparseIntArray.put(R.id.play_btn, 53);
        sparseIntArray.put(R.id.screen_orientation_btn, 54);
        sparseIntArray.put(R.id.torch_parent, 55);
        sparseIntArray.put(R.id.torch_on_btn, 56);
        sparseIntArray.put(R.id.torch_off_btn, 57);
        sparseIntArray.put(R.id.camera_top_cover, 58);
        sparseIntArray.put(R.id.camera_bottom_cover, 59);
        sparseIntArray.put(R.id.false_color_indicator, 60);
        sparseIntArray.put(R.id.home_right_parent, 61);
        sparseIntArray.put(R.id.home_light, 62);
        sparseIntArray.put(R.id.home_light_click, 63);
        sparseIntArray.put(R.id.home_orientation, 64);
        sparseIntArray.put(R.id.home_orientation_click, 65);
        sparseIntArray.put(R.id.home_clear_vertical, 66);
        sparseIntArray.put(R.id.home_vertical_click, 67);
        sparseIntArray.put(R.id.home_clear_horizon, 68);
        sparseIntArray.put(R.id.home_horizon_click, 69);
        sparseIntArray.put(R.id.resolution_setting_view, 70);
        sparseIntArray.put(R.id.fps_setting_view, 71);
        sparseIntArray.put(R.id.iso_view, 72);
        sparseIntArray.put(R.id.shutter_view, 73);
        sparseIntArray.put(R.id.lens_setting_view, 74);
        sparseIntArray.put(R.id.wb_setting_view, 75);
        sparseIntArray.put(R.id.home_grids_setting_view, 76);
        sparseIntArray.put(R.id.zebra_Setting_view, 77);
        sparseIntArray.put(R.id.audio_Setting_view, 78);
        sparseIntArray.put(R.id.looks_Setting_view, 79);
        sparseIntArray.put(R.id.home_style_hint, 80);
        sparseIntArray.put(R.id.subscribe_view, 81);
        sparseIntArray.put(R.id.mode_hint_dialog, 82);
        sparseIntArray.put(R.id.hint_dialog, 83);
        sparseIntArray.put(R.id.permission_dialog, 84);
        sparseIntArray.put(R.id.fps_info_dialog, 85);
        sparseIntArray.put(R.id.sign_out_dialog, 86);
    }

    public C4308(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 87, f14776, f14777));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14779 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14779 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14779 = 1L;
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

    public C4308(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[11], (AudioSettingView) objArr[78], (View) objArr[2], (View) objArr[7], (View) objArr[4], (View) objArr[5], (View) objArr[6], (View) objArr[59], (View) objArr[3], (View) objArr[58], (HollowTextView) objArr[35], (HollowTextView) objArr[36], (CameraTouchView) objArr[9], (CardView) objArr[8], (CardView) objArr[1], (ImageView) objArr[49], (View) objArr[30], (View) objArr[31], (ImageView) objArr[60], (View) objArr[24], (DoubleTextLayout) objArr[18], (SettingHintDialog) objArr[85], (FPSSettingView) objArr[71], (CenterVerticalTextView) objArr[29], (ImageView) objArr[45], (SettingHintDialog) objArr[83], (AudioSchedulePortraitView) objArr[16], (FrameLayout) objArr[46], (ImageView) objArr[47], (BatteryStoragePortraitView) objArr[15], (ImageView) objArr[68], (ImageView) objArr[66], (GridsSettingView) objArr[76], (View) objArr[69], (ImageView) objArr[62], (View) objArr[63], (ImageView) objArr[64], (View) objArr[65], (RecordTimeFrameView) objArr[40], (StrokeTextView) objArr[41], (RelativeLayout) objArr[61], (StyleHintView) objArr[80], (View) objArr[10], (StrokeTextView) objArr[51], (StrokeTextView) objArr[52], (View) objArr[67], (View) objArr[26], (DoubleTextLayout) objArr[20], (ISOView) objArr[72], (ImageView) objArr[38], (View) objArr[28], (DoubleTextLayout) objArr[22], (LensSettingView) objArr[74], (StrokePointView) objArr[50], (LooksPreviewView) objArr[79], (ModeHintDialog) objArr[82], (View) objArr[34], (SettingHintDialog) objArr[84], (ImageView) objArr[53], (View) objArr[33], (ImageView) objArr[43], (LinearLayout) objArr[42], (RecordButton) objArr[37], (View) objArr[39], (View) objArr[23], (DoubleTextLayout) objArr[17], (ResolutionSettingView) objArr[70], (ImageView) objArr[54], (ImageView) objArr[48], (View) objArr[32], (View) objArr[25], (DoubleTextLayout) objArr[19], (ShutterView) objArr[73], (SettingHintDialog) objArr[86], (SubscribeDialog) objArr[81], (ImageView) objArr[57], (ImageView) objArr[56], (FrameLayout) objArr[55], (WaveformBottomLineView) objArr[13], (FrameLayout) objArr[12], (TextureView) objArr[14], (View) objArr[27], (DoubleTextLayout) objArr[21], (WbSettingView) objArr[75], (ImageView) objArr[44], (ZebraSettingView) objArr[77]);
        this.f14779 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14778 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
