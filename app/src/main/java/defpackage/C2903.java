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
import com.blink.academy.film.widgets.AudioScheduleView;
import com.blink.academy.film.widgets.AudioSettingView;
import com.blink.academy.film.widgets.BatteryStorageView;
import com.blink.academy.film.widgets.CenterVerticalTextView;
import com.blink.academy.film.widgets.FPSSettingView;
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
import com.blink.academy.film.widgets.beauty.BeautySettingView;
import com.blink.academy.film.widgets.camerainfo.DoubleTextLayout;
import com.blink.academy.film.widgets.exposure.CameraTouchView;
import com.blink.academy.film.widgets.exposure.HollowTextView;
import com.blink.academy.film.widgets.iso.ABPointWheelView;
import com.blink.academy.film.widgets.iso.AutoZoomWheelView;
import com.blink.academy.film.widgets.iso.FocusZoomWheelView;
import com.blink.academy.film.widgets.iso.ISOView;
import com.blink.academy.film.widgets.iso.IsoEtWheelView;
import com.blink.academy.film.widgets.iso.ShutterView;
import com.blink.academy.film.widgets.looks.LooksPreviewView;
import com.blink.academy.film.widgets.transmit.BubbleBoxView;
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.film.widgets.transmit.ChangeTintLeftImageTextView;
import com.blink.academy.protake.R;

/* compiled from: FragmentHomeLandscapeBindingImpl.java */
/* renamed from: ъ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2903 extends AbstractC2853 {

    /* renamed from: ൕ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10578 = null;

    /* renamed from: ൖ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f10579;

    /* renamed from: ൔ, reason: contains not printable characters */
    public long f10580;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10579 = sparseIntArray;
        sparseIntArray.put(R.id.home_cameraview_pos, 1);
        sparseIntArray.put(R.id.camera_big_left_cover, 2);
        sparseIntArray.put(R.id.camera_big_right_cover, 3);
        sparseIntArray.put(R.id.camera_big_top_cover, 4);
        sparseIntArray.put(R.id.camera_big_bottom_cover, 5);
        sparseIntArray.put(R.id.home_guide, 6);
        sparseIntArray.put(R.id.home_red_cover_view, 7);
        sparseIntArray.put(R.id.card_camera_touch, 8);
        sparseIntArray.put(R.id.capture_touch_view, 9);
        sparseIntArray.put(R.id.home_touch_area, 10);
        sparseIntArray.put(R.id.home_horizon_circle_rect, 11);
        sparseIntArray.put(R.id.card_auto_zoom, 12);
        sparseIntArray.put(R.id.auto_zoom_wheel, 13);
        sparseIntArray.put(R.id.all_click_area, 14);
        sparseIntArray.put(R.id.res_double_text_layout, 15);
        sparseIntArray.put(R.id.fps_double_text_layout, 16);
        sparseIntArray.put(R.id.shutter_double_text_layout, 17);
        sparseIntArray.put(R.id.iso_double_text_layout, 18);
        sparseIntArray.put(R.id.wb_double_text_layout, 19);
        sparseIntArray.put(R.id.lens_double_text_layout, 20);
        sparseIntArray.put(R.id.res_click_area, 21);
        sparseIntArray.put(R.id.fps_click_area, 22);
        sparseIntArray.put(R.id.shutter_click_area, 23);
        sparseIntArray.put(R.id.iso_click_area, 24);
        sparseIntArray.put(R.id.wb_click_area, 25);
        sparseIntArray.put(R.id.lens_click_area, 26);
        sparseIntArray.put(R.id.frame_drop_tv, 27);
        sparseIntArray.put(R.id.home_auto_switch_camera, 28);
        sparseIntArray.put(R.id.home_auto_switch_iv, 29);
        sparseIntArray.put(R.id.setting_btn, 30);
        sparseIntArray.put(R.id.color_btn, 31);
        sparseIntArray.put(R.id.screen_orientation_btn, 32);
        sparseIntArray.put(R.id.looks_point, 33);
        sparseIntArray.put(R.id.home_tv_style, 34);
        sparseIntArray.put(R.id.home_tv_style_top, 35);
        sparseIntArray.put(R.id.iv_color_lock, 36);
        sparseIntArray.put(R.id.play_btn, 37);
        sparseIntArray.put(R.id.beauty_btn, 38);
        sparseIntArray.put(R.id.beauty_click_area, 39);
        sparseIntArray.put(R.id.color_click_area, 40);
        sparseIntArray.put(R.id.color_lock_area, 41);
        sparseIntArray.put(R.id.setting_click_area, 42);
        sparseIntArray.put(R.id.play_click_area, 43);
        sparseIntArray.put(R.id.orientation_click_area, 44);
        sparseIntArray.put(R.id.capture_exposure_bg, 45);
        sparseIntArray.put(R.id.capture_exposure_lock_htv, 46);
        sparseIntArray.put(R.id.grid_btn, 47);
        sparseIntArray.put(R.id.zebra_btn, 48);
        sparseIntArray.put(R.id.pro_indicator_parent, 49);
        sparseIntArray.put(R.id.pro_btn, 50);
        sparseIntArray.put(R.id.record_btn, 51);
        sparseIntArray.put(R.id.iv_record_btn_lock, 52);
        sparseIntArray.put(R.id.record_btn_top, 53);
        sparseIntArray.put(R.id.card_focus_zoom, 54);
        sparseIntArray.put(R.id.focus_zoom_wheel, 55);
        sparseIntArray.put(R.id.card_ab_zoom, 56);
        sparseIntArray.put(R.id.ab_zoom_wheel, 57);
        sparseIntArray.put(R.id.card_ab_focus, 58);
        sparseIntArray.put(R.id.ab_focus_wheel, 59);
        sparseIntArray.put(R.id.card_iso_et, 60);
        sparseIntArray.put(R.id.iso_et_wheel, 61);
        sparseIntArray.put(R.id.waveform_indicator_parent, 62);
        sparseIntArray.put(R.id.wave_parent, 63);
        sparseIntArray.put(R.id.wave_bottom_line, 64);
        sparseIntArray.put(R.id.wave_textureview, 65);
        sparseIntArray.put(R.id.home_audio_type, 66);
        sparseIntArray.put(R.id.home_audio_schedule, 67);
        sparseIntArray.put(R.id.home_battery_recharge, 68);
        sparseIntArray.put(R.id.home_battery_storage, 69);
        sparseIntArray.put(R.id.home_iv_transmit, 70);
        sparseIntArray.put(R.id.home_tv_transmit, 71);
        sparseIntArray.put(R.id.home_tv_connected_num, 72);
        sparseIntArray.put(R.id.home_iv_transmit_click, 73);
        sparseIntArray.put(R.id.transmit_bubble_view, 74);
        sparseIntArray.put(R.id.home_record_frame, 75);
        sparseIntArray.put(R.id.home_record_num, 76);
        sparseIntArray.put(R.id.camera_left_cover, 77);
        sparseIntArray.put(R.id.camera_right_cover, 78);
        sparseIntArray.put(R.id.camera_top_cover, 79);
        sparseIntArray.put(R.id.camera_bottom_cover, 80);
        sparseIntArray.put(R.id.false_color_indicator, 81);
        sparseIntArray.put(R.id.torch_parent, 82);
        sparseIntArray.put(R.id.torch_on_btn, 83);
        sparseIntArray.put(R.id.torch_off_btn, 84);
        sparseIntArray.put(R.id.torch_parent_click, 85);
        sparseIntArray.put(R.id.home_right_parent, 86);
        sparseIntArray.put(R.id.home_light, 87);
        sparseIntArray.put(R.id.home_light_click, 88);
        sparseIntArray.put(R.id.home_orientation, 89);
        sparseIntArray.put(R.id.home_orientation_click, 90);
        sparseIntArray.put(R.id.home_clear_vertical, 91);
        sparseIntArray.put(R.id.home_vertical_click, 92);
        sparseIntArray.put(R.id.home_clear_horizon, 93);
        sparseIntArray.put(R.id.home_horizon_click, 94);
        sparseIntArray.put(R.id.home_screen_orientation, 95);
        sparseIntArray.put(R.id.home_screen_orientation_click, 96);
        sparseIntArray.put(R.id.panel_card, 97);
        sparseIntArray.put(R.id.resolution_setting_view, 98);
        sparseIntArray.put(R.id.fps_setting_view, 99);
        sparseIntArray.put(R.id.iso_view, 100);
        sparseIntArray.put(R.id.shutter_view, 101);
        sparseIntArray.put(R.id.lens_setting_view, 102);
        sparseIntArray.put(R.id.wb_setting_view, 103);
        sparseIntArray.put(R.id.home_grids_setting_view, 104);
        sparseIntArray.put(R.id.zebra_Setting_view, 105);
        sparseIntArray.put(R.id.audio_Setting_view, 106);
        sparseIntArray.put(R.id.looks_Setting_view, 107);
        sparseIntArray.put(R.id.beauty_Setting_view, 108);
        sparseIntArray.put(R.id.fragemnt_cover_view, 109);
    }

    public C2903(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 110, f10578, f10579));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f10580 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10580 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10580 = 1L;
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

    public C2903(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ABPointWheelView) objArr[59], (ABPointWheelView) objArr[57], (View) objArr[14], (AudioSettingView) objArr[106], (AutoZoomWheelView) objArr[13], (ImageView) objArr[38], (View) objArr[39], (BeautySettingView) objArr[108], (View) objArr[5], (View) objArr[2], (View) objArr[3], (View) objArr[4], (View) objArr[80], (View) objArr[77], (View) objArr[78], (View) objArr[79], (HollowTextView) objArr[45], (HollowTextView) objArr[46], (CameraTouchView) objArr[9], (CardView) objArr[58], (CardView) objArr[56], (CardView) objArr[12], (CardView) objArr[8], (CardView) objArr[54], (CardView) objArr[60], (ImageView) objArr[31], (View) objArr[40], (View) objArr[41], (ImageView) objArr[81], (FocusZoomWheelView) objArr[55], (View) objArr[22], (DoubleTextLayout) objArr[16], (FPSSettingView) objArr[99], (View) objArr[109], (CenterVerticalTextView) objArr[27], (ImageView) objArr[47], (AudioScheduleView) objArr[67], (ImageView) objArr[66], (FrameLayout) objArr[28], (ImageView) objArr[29], (ImageView) objArr[68], (BatteryStorageView) objArr[69], (View) objArr[1], (ImageView) objArr[93], (ImageView) objArr[91], (GridsSettingView) objArr[104], (GuideView) objArr[6], (HorizonCircleRectView) objArr[11], (View) objArr[94], (ChangeTintImageView) objArr[70], (View) objArr[73], (ImageView) objArr[87], (View) objArr[88], (ImageView) objArr[89], (View) objArr[90], (RecordTimeFrameView) objArr[75], (StrokeTextView) objArr[76], (RecordingRedCoverVIew) objArr[7], (RelativeLayout) objArr[86], (ImageView) objArr[95], (View) objArr[96], (View) objArr[10], (StrokeTextView) objArr[72], (StrokeTextView) objArr[34], (StrokeTextView) objArr[35], (ChangeTintLeftImageTextView) objArr[71], (View) objArr[92], (View) objArr[24], (DoubleTextLayout) objArr[18], (IsoEtWheelView) objArr[61], (ISOView) objArr[100], (ImageView) objArr[36], (ImageView) objArr[52], (View) objArr[26], (DoubleTextLayout) objArr[20], (LensSettingView) objArr[102], (StrokePointView) objArr[33], (LooksPreviewView) objArr[107], (View) objArr[44], (CardView) objArr[97], (ImageView) objArr[37], (View) objArr[43], (ImageView) objArr[50], (LinearLayout) objArr[49], (RecordButton) objArr[51], (View) objArr[53], (View) objArr[21], (DoubleTextLayout) objArr[15], (ResolutionSettingView) objArr[98], (ConstraintLayout) objArr[0], (ImageView) objArr[32], (ImageView) objArr[30], (View) objArr[42], (View) objArr[23], (DoubleTextLayout) objArr[17], (ShutterView) objArr[101], (ImageView) objArr[84], (ImageView) objArr[83], (FrameLayout) objArr[82], (View) objArr[85], (BubbleBoxView) objArr[74], (WaveformBottomLineView) objArr[64], (FrameLayout) objArr[63], (TextureView) objArr[65], (LinearLayout) objArr[62], (View) objArr[25], (DoubleTextLayout) objArr[19], (WbSettingView) objArr[103], (ImageView) objArr[48], (ZebraSettingView) objArr[105]);
        this.f10580 = -1L;
        this.f10426.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
