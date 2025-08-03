package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.AudioScheduleView;
import com.blink.academy.film.widgets.BatteryStorageView;
import com.blink.academy.film.widgets.GuideView;
import com.blink.academy.film.widgets.RecordButton;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.camerainfo.DoubleTextLayout;
import com.blink.academy.film.widgets.cover.ModeHintDialog;
import com.blink.academy.film.widgets.iso.AutoZoomWheelView;
import com.blink.academy.film.widgets.transmit.BubbleBoxView;
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.protake.R;

/* compiled from: ActivitySplashBindingImpl.java */
/* renamed from: ࢣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3967 extends AbstractC3966 {

    /* renamed from: ޞ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13867 = null;

    /* renamed from: ޟ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13868;

    /* renamed from: ޝ, reason: contains not printable characters */
    public long f13869;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13868 = sparseIntArray;
        sparseIntArray.put(R.id.card_center, 1);
        sparseIntArray.put(R.id.root, 2);
        sparseIntArray.put(R.id.home_cameraview_pos, 3);
        sparseIntArray.put(R.id.home_guide, 4);
        sparseIntArray.put(R.id.home_audio_schedule, 5);
        sparseIntArray.put(R.id.home_battery_storage, 6);
        sparseIntArray.put(R.id.home_iv_transmit, 7);
        sparseIntArray.put(R.id.transmit_bubble_view, 8);
        sparseIntArray.put(R.id.home_record_frame, 9);
        sparseIntArray.put(R.id.home_record_frame_view, 10);
        sparseIntArray.put(R.id.pro_btn, 11);
        sparseIntArray.put(R.id.grid_btn, 12);
        sparseIntArray.put(R.id.record_btn, 13);
        sparseIntArray.put(R.id.torch_parent, 14);
        sparseIntArray.put(R.id.torch_on_btn, 15);
        sparseIntArray.put(R.id.torch_off_btn, 16);
        sparseIntArray.put(R.id.home_right_parent, 17);
        sparseIntArray.put(R.id.home_light, 18);
        sparseIntArray.put(R.id.home_light_click, 19);
        sparseIntArray.put(R.id.home_orientation, 20);
        sparseIntArray.put(R.id.home_orientation_click, 21);
        sparseIntArray.put(R.id.home_clear_vertical, 22);
        sparseIntArray.put(R.id.home_vertical_click, 23);
        sparseIntArray.put(R.id.home_clear_horizon, 24);
        sparseIntArray.put(R.id.home_horizon_click, 25);
        sparseIntArray.put(R.id.home_screen_orientation, 26);
        sparseIntArray.put(R.id.home_screen_orientation_click, 27);
        sparseIntArray.put(R.id.res_double_text_layout, 28);
        sparseIntArray.put(R.id.fps_double_text_layout, 29);
        sparseIntArray.put(R.id.home_auto_switch_camera, 30);
        sparseIntArray.put(R.id.home_auto_switch_iv, 31);
        sparseIntArray.put(R.id.setting_btn, 32);
        sparseIntArray.put(R.id.play_btn, 33);
        sparseIntArray.put(R.id.color_btn, 34);
        sparseIntArray.put(R.id.beauty_btn, 35);
        sparseIntArray.put(R.id.card_auto_zoom, 36);
        sparseIntArray.put(R.id.auto_zoom_wheel, 37);
        sparseIntArray.put(R.id.mode_hint_dialog, 38);
    }

    public C3967(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 39, f13867, f13868));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13869 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13869 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13869 = 1L;
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

    public C3967(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AutoZoomWheelView) objArr[37], (ImageView) objArr[35], (CardView) objArr[36], (CardView) objArr[1], (ImageView) objArr[34], (DoubleTextLayout) objArr[29], (ImageView) objArr[12], (AudioScheduleView) objArr[5], (FrameLayout) objArr[30], (ImageView) objArr[31], (BatteryStorageView) objArr[6], (View) objArr[3], (ImageView) objArr[24], (ImageView) objArr[22], (GuideView) objArr[4], (View) objArr[25], (ChangeTintImageView) objArr[7], (ImageView) objArr[18], (View) objArr[19], (ImageView) objArr[20], (View) objArr[21], (StrokeTextView) objArr[9], (View) objArr[10], (RelativeLayout) objArr[17], (ImageView) objArr[26], (View) objArr[27], (View) objArr[23], (ModeHintDialog) objArr[38], (ImageView) objArr[33], (ImageView) objArr[11], (RecordButton) objArr[13], (DoubleTextLayout) objArr[28], (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[0], (ImageView) objArr[32], (ImageView) objArr[16], (ImageView) objArr[15], (FrameLayout) objArr[14], (BubbleBoxView) objArr[8]);
        this.f13869 = -1L;
        this.f13861.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
