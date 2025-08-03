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
import com.blink.academy.film.widgets.AudioSettingPortraitView;
import com.blink.academy.film.widgets.CenterVerticalTextView;
import com.blink.academy.film.widgets.FPSPortraitSettingView;
import com.blink.academy.film.widgets.GridsSettingView;
import com.blink.academy.film.widgets.GuideView;
import com.blink.academy.film.widgets.HorizonCircleRectView;
import com.blink.academy.film.widgets.LensSettingView;
import com.blink.academy.film.widgets.RecordButton;
import com.blink.academy.film.widgets.RecordTimeFrameView;
import com.blink.academy.film.widgets.RecordingRedCoverVIew;
import com.blink.academy.film.widgets.ResolutionSettingView;
import com.blink.academy.film.widgets.StrokePointView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.WaveformBottomLineView;
import com.blink.academy.film.widgets.WbSettingView;
import com.blink.academy.film.widgets.ZebraSettingView;
import com.blink.academy.film.widgets.audio.AudioSchedulePortraitView;
import com.blink.academy.film.widgets.battery.BatteryStoragePortraitView;
import com.blink.academy.film.widgets.beauty.BeautySettingView;
import com.blink.academy.film.widgets.camerainfo.DoubleTextLayout;
import com.blink.academy.film.widgets.exposure.CameraTouchView;
import com.blink.academy.film.widgets.exposure.HollowTextView;
import com.blink.academy.film.widgets.iso.ABPointWheelView;
import com.blink.academy.film.widgets.iso.AutoZoomWheelView;
import com.blink.academy.film.widgets.iso.FocusZoomWheelView;
import com.blink.academy.film.widgets.iso.ISOView;
import com.blink.academy.film.widgets.iso.IsoEtWheelView;
import com.blink.academy.film.widgets.iso.ShutterPortraitView;
import com.blink.academy.film.widgets.looks.LooksPreviewPortraitView;
import com.blink.academy.protake.R;

/* compiled from: FragmentHomePortraitBindingImpl.java */
/* renamed from: ࠓ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3909 extends AbstractC3481 {

    /* renamed from: ൎ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13527 = null;

    /* renamed from: ൔ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13528;

    /* renamed from: ഺ, reason: contains not printable characters */
    public long f13529;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13528 = sparseIntArray;
        sparseIntArray.put(R.id.home_cameraview_pos, 1);
        sparseIntArray.put(R.id.camera_big_left_cover, 2);
        sparseIntArray.put(R.id.camera_big_right_cover, 3);
        sparseIntArray.put(R.id.camera_big_top_cover, 4);
        sparseIntArray.put(R.id.camera_big_bottom_cover, 5);
        sparseIntArray.put(R.id.home_guide, 6);
        sparseIntArray.put(R.id.home_red_cover_view, 7);
        sparseIntArray.put(R.id.card_center, 8);
        sparseIntArray.put(R.id.root, 9);
        sparseIntArray.put(R.id.home_cameraview, 10);
        sparseIntArray.put(R.id.card_camera_touch, 11);
        sparseIntArray.put(R.id.capture_touch_view, 12);
        sparseIntArray.put(R.id.home_touch_area, 13);
        sparseIntArray.put(R.id.home_horizon_circle_rect, 14);
        sparseIntArray.put(R.id.wave_parent, 15);
        sparseIntArray.put(R.id.wave_bottom_line, 16);
        sparseIntArray.put(R.id.wave_textureview, 17);
        sparseIntArray.put(R.id.all_click_area, 18);
        sparseIntArray.put(R.id.double_parent, 19);
        sparseIntArray.put(R.id.res_double_text_layout, 20);
        sparseIntArray.put(R.id.fps_double_text_layout, 21);
        sparseIntArray.put(R.id.shutter_double_text_layout, 22);
        sparseIntArray.put(R.id.iso_double_text_layout, 23);
        sparseIntArray.put(R.id.wb_double_text_layout, 24);
        sparseIntArray.put(R.id.lens_double_text_layout, 25);
        sparseIntArray.put(R.id.res_click_area, 26);
        sparseIntArray.put(R.id.fps_click_area, 27);
        sparseIntArray.put(R.id.shutter_click_area, 28);
        sparseIntArray.put(R.id.iso_click_area, 29);
        sparseIntArray.put(R.id.wb_click_area, 30);
        sparseIntArray.put(R.id.lens_click_area, 31);
        sparseIntArray.put(R.id.frame_drop_tv, 32);
        sparseIntArray.put(R.id.home_audio_type, 33);
        sparseIntArray.put(R.id.home_audio_schedule, 34);
        sparseIntArray.put(R.id.home_battery_recharge, 35);
        sparseIntArray.put(R.id.home_battery_storage, 36);
        sparseIntArray.put(R.id.home_auto_switch_camera, 37);
        sparseIntArray.put(R.id.home_auto_switch_iv, 38);
        sparseIntArray.put(R.id.setting_btn, 39);
        sparseIntArray.put(R.id.color_btn, 40);
        sparseIntArray.put(R.id.beauty_btn, 41);
        sparseIntArray.put(R.id.looks_point, 42);
        sparseIntArray.put(R.id.home_tv_style, 43);
        sparseIntArray.put(R.id.home_tv_style_top, 44);
        sparseIntArray.put(R.id.iv_color_lock, 45);
        sparseIntArray.put(R.id.play_btn, 46);
        sparseIntArray.put(R.id.screen_orientation_btn, 47);
        sparseIntArray.put(R.id.torch_parent, 48);
        sparseIntArray.put(R.id.torch_on_btn, 49);
        sparseIntArray.put(R.id.torch_off_btn, 50);
        sparseIntArray.put(R.id.color_click_area, 51);
        sparseIntArray.put(R.id.color_lock_area, 52);
        sparseIntArray.put(R.id.setting_click_area, 53);
        sparseIntArray.put(R.id.play_click_area, 54);
        sparseIntArray.put(R.id.orientation_click_area, 55);
        sparseIntArray.put(R.id.beauty_click_area, 56);
        sparseIntArray.put(R.id.capture_exposure_bg, 57);
        sparseIntArray.put(R.id.capture_exposure_lock_htv, 58);
        sparseIntArray.put(R.id.grid_btn, 59);
        sparseIntArray.put(R.id.zebra_btn, 60);
        sparseIntArray.put(R.id.pro_indicator_parent, 61);
        sparseIntArray.put(R.id.pro_btn, 62);
        sparseIntArray.put(R.id.waveform_indicator_parent, 63);
        sparseIntArray.put(R.id.false_color_indicator, 64);
        sparseIntArray.put(R.id.home_record_frame, 65);
        sparseIntArray.put(R.id.home_record_num, 66);
        sparseIntArray.put(R.id.record_btn, 67);
        sparseIntArray.put(R.id.iv_record_btn_lock, 68);
        sparseIntArray.put(R.id.record_btn_top, 69);
        sparseIntArray.put(R.id.card_focus_zoom, 70);
        sparseIntArray.put(R.id.focus_zoom_wheel, 71);
        sparseIntArray.put(R.id.card_ab_zoom, 72);
        sparseIntArray.put(R.id.ab_zoom_wheel, 73);
        sparseIntArray.put(R.id.card_ab_focus, 74);
        sparseIntArray.put(R.id.ab_focus_wheel, 75);
        sparseIntArray.put(R.id.card_iso_et, 76);
        sparseIntArray.put(R.id.iso_et_wheel, 77);
        sparseIntArray.put(R.id.card_auto_zoom, 78);
        sparseIntArray.put(R.id.auto_zoom_wheel, 79);
        sparseIntArray.put(R.id.camera_left_cover, 80);
        sparseIntArray.put(R.id.camera_right_cover, 81);
        sparseIntArray.put(R.id.camera_top_cover, 82);
        sparseIntArray.put(R.id.camera_bottom_cover, 83);
        sparseIntArray.put(R.id.home_right_parent, 84);
        sparseIntArray.put(R.id.home_light, 85);
        sparseIntArray.put(R.id.home_light_click, 86);
        sparseIntArray.put(R.id.home_orientation, 87);
        sparseIntArray.put(R.id.home_orientation_click, 88);
        sparseIntArray.put(R.id.home_clear_vertical, 89);
        sparseIntArray.put(R.id.home_vertical_click, 90);
        sparseIntArray.put(R.id.home_clear_horizon, 91);
        sparseIntArray.put(R.id.home_horizon_click, 92);
        sparseIntArray.put(R.id.home_screen_orientation, 93);
        sparseIntArray.put(R.id.home_screen_orientation_click, 94);
        sparseIntArray.put(R.id.panel_card, 95);
        sparseIntArray.put(R.id.panel_parent, 96);
        sparseIntArray.put(R.id.resolution_setting_view, 97);
        sparseIntArray.put(R.id.fps_setting_view, 98);
        sparseIntArray.put(R.id.iso_view, 99);
        sparseIntArray.put(R.id.shutter_view, 100);
        sparseIntArray.put(R.id.lens_setting_view, 101);
        sparseIntArray.put(R.id.wb_setting_view, 102);
        sparseIntArray.put(R.id.home_grids_setting_view, 103);
        sparseIntArray.put(R.id.zebra_Setting_view, 104);
        sparseIntArray.put(R.id.audio_Setting_view, 105);
        sparseIntArray.put(R.id.looks_Setting_view, 106);
        sparseIntArray.put(R.id.beauty_Setting_view, 107);
    }

    public C3909(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 108, f13527, f13528));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13529 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13529 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13529 = 1L;
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

    public C3909(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ABPointWheelView) objArr[75], (ABPointWheelView) objArr[73], (View) objArr[18], (AudioSettingPortraitView) objArr[105], (AutoZoomWheelView) objArr[79], (ImageView) objArr[41], (View) objArr[56], (BeautySettingView) objArr[107], (View) objArr[5], (View) objArr[2], (View) objArr[3], (View) objArr[4], (View) objArr[83], (View) objArr[80], (View) objArr[81], (View) objArr[82], (HollowTextView) objArr[57], (HollowTextView) objArr[58], (CameraTouchView) objArr[12], (CardView) objArr[74], (CardView) objArr[72], (CardView) objArr[78], (CardView) objArr[11], (CardView) objArr[8], (CardView) objArr[70], (CardView) objArr[76], (ImageView) objArr[40], (View) objArr[51], (View) objArr[52], (ConstraintLayout) objArr[19], (ImageView) objArr[64], (FocusZoomWheelView) objArr[71], (View) objArr[27], (DoubleTextLayout) objArr[21], (FPSPortraitSettingView) objArr[98], (CenterVerticalTextView) objArr[32], (ImageView) objArr[59], (AudioSchedulePortraitView) objArr[34], (ImageView) objArr[33], (FrameLayout) objArr[37], (ImageView) objArr[38], (ImageView) objArr[35], (BatteryStoragePortraitView) objArr[36], (View) objArr[10], (View) objArr[1], (ImageView) objArr[91], (ImageView) objArr[89], (GridsSettingView) objArr[103], (GuideView) objArr[6], (HorizonCircleRectView) objArr[14], (View) objArr[92], (ImageView) objArr[85], (View) objArr[86], (ImageView) objArr[87], (View) objArr[88], (RecordTimeFrameView) objArr[65], (StrokeTextView) objArr[66], (RecordingRedCoverVIew) objArr[7], (RelativeLayout) objArr[84], (ImageView) objArr[93], (View) objArr[94], (View) objArr[13], (StrokeTextView) objArr[43], (StrokeTextView) objArr[44], (View) objArr[90], (View) objArr[29], (DoubleTextLayout) objArr[23], (IsoEtWheelView) objArr[77], (ISOView) objArr[99], (ImageView) objArr[45], (ImageView) objArr[68], (View) objArr[31], (DoubleTextLayout) objArr[25], (LensSettingView) objArr[101], (StrokePointView) objArr[42], (LooksPreviewPortraitView) objArr[106], (View) objArr[55], (CardView) objArr[95], (ConstraintLayout) objArr[96], (ImageView) objArr[46], (View) objArr[54], (ImageView) objArr[62], (LinearLayout) objArr[61], (RecordButton) objArr[67], (View) objArr[69], (View) objArr[26], (DoubleTextLayout) objArr[20], (ResolutionSettingView) objArr[97], (ConstraintLayout) objArr[9], (ConstraintLayout) objArr[0], (ImageView) objArr[47], (ImageView) objArr[39], (View) objArr[53], (View) objArr[28], (DoubleTextLayout) objArr[22], (ShutterPortraitView) objArr[100], (ImageView) objArr[50], (ImageView) objArr[49], (FrameLayout) objArr[48], (WaveformBottomLineView) objArr[16], (FrameLayout) objArr[15], (TextureView) objArr[17], (LinearLayout) objArr[63], (View) objArr[30], (DoubleTextLayout) objArr[24], (WbSettingView) objArr[102], (ImageView) objArr[60], (ZebraSettingView) objArr[104]);
        this.f13529 = -1L;
        this.f12082.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
