package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.stream.ACWheelView;
import com.blink.academy.film.widgets.RecordButton;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.film.widgets.transmit.CloudMonitorSwitchView;
import com.blink.academy.film.widgets.transmit.CloudPlayerConnectView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorFlagView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorPlayerControlView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorSignalView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView;
import com.blink.academy.film.widgets.transmit.monitor.RecordTimeLayout;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorAnimateViewBindingImpl.java */
/* renamed from: Ⴞ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5236 extends AbstractC3491 {

    /* renamed from: ࢰ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f17352 = null;

    /* renamed from: ࢱ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f17353;

    /* renamed from: ࢮ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f17354;

    /* renamed from: ࢯ, reason: contains not printable characters */
    public long f17355;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17353 = sparseIntArray;
        sparseIntArray.put(R.id.monitor_parent, 1);
        sparseIntArray.put(R.id.monitor_root, 2);
        sparseIntArray.put(R.id.parent1, 3);
        sparseIntArray.put(R.id.texture_parent1, 4);
        sparseIntArray.put(R.id.res_parent_A, 5);
        sparseIntArray.put(R.id.video_res1, 6);
        sparseIntArray.put(R.id.video_name1, 7);
        sparseIntArray.put(R.id.iv_wifi_A, 8);
        sparseIntArray.put(R.id.monitor_unit_left, 9);
        sparseIntArray.put(R.id.record_time_frame_1, 10);
        sparseIntArray.put(R.id.player_control_view1, 11);
        sparseIntArray.put(R.id.player_flag_view1, 12);
        sparseIntArray.put(R.id.player_time_code1, 13);
        sparseIntArray.put(R.id.player_cloud_connect1, 14);
        sparseIntArray.put(R.id.player_cloud_monitor_swicth1, 15);
        sparseIntArray.put(R.id.player_cloud_monitor_close1, 16);
        sparseIntArray.put(R.id.player_cloud_monitor_close_click1, 17);
        sparseIntArray.put(R.id.parent2, 18);
        sparseIntArray.put(R.id.texture_parent2, 19);
        sparseIntArray.put(R.id.res_parent_B, 20);
        sparseIntArray.put(R.id.video_res2, 21);
        sparseIntArray.put(R.id.video_name2, 22);
        sparseIntArray.put(R.id.iv_wifi_B, 23);
        sparseIntArray.put(R.id.monitor_unit_right, 24);
        sparseIntArray.put(R.id.record_time_frame_2, 25);
        sparseIntArray.put(R.id.player_control_view2, 26);
        sparseIntArray.put(R.id.player_flag_view2, 27);
        sparseIntArray.put(R.id.player_time_code2, 28);
        sparseIntArray.put(R.id.player_cloud_connect2, 29);
        sparseIntArray.put(R.id.player_cloud_monitor_swicth2, 30);
        sparseIntArray.put(R.id.player_cloud_monitor_close2, 31);
        sparseIntArray.put(R.id.player_cloud_monitor_close_click2, 32);
        sparseIntArray.put(R.id.parent3, 33);
        sparseIntArray.put(R.id.texture_parent3, 34);
        sparseIntArray.put(R.id.res_parent_C, 35);
        sparseIntArray.put(R.id.video_res3, 36);
        sparseIntArray.put(R.id.video_name3, 37);
        sparseIntArray.put(R.id.iv_wifi_C, 38);
        sparseIntArray.put(R.id.monitor_unit_3, 39);
        sparseIntArray.put(R.id.record_time_frame_3, 40);
        sparseIntArray.put(R.id.player_control_view3, 41);
        sparseIntArray.put(R.id.player_flag_view3, 42);
        sparseIntArray.put(R.id.player_time_code3, 43);
        sparseIntArray.put(R.id.player_cloud_connect3, 44);
        sparseIntArray.put(R.id.player_cloud_monitor_swicth3, 45);
        sparseIntArray.put(R.id.player_cloud_monitor_close3, 46);
        sparseIntArray.put(R.id.player_cloud_monitor_close_click3, 47);
        sparseIntArray.put(R.id.parent4, 48);
        sparseIntArray.put(R.id.texture_parent4, 49);
        sparseIntArray.put(R.id.res_parent_D, 50);
        sparseIntArray.put(R.id.video_res4, 51);
        sparseIntArray.put(R.id.video_name4, 52);
        sparseIntArray.put(R.id.iv_wifi_D, 53);
        sparseIntArray.put(R.id.monitor_unit_4, 54);
        sparseIntArray.put(R.id.record_time_frame_4, 55);
        sparseIntArray.put(R.id.player_control_view4, 56);
        sparseIntArray.put(R.id.player_flag_view4, 57);
        sparseIntArray.put(R.id.player_time_code4, 58);
        sparseIntArray.put(R.id.player_cloud_connect4, 59);
        sparseIntArray.put(R.id.player_cloud_monitor_swicth4, 60);
        sparseIntArray.put(R.id.player_cloud_monitor_close4, 61);
        sparseIntArray.put(R.id.player_cloud_monitor_close_click4, 62);
        sparseIntArray.put(R.id.monitor_unit_title, 63);
        sparseIntArray.put(R.id.record_btn_parent, 64);
        sparseIntArray.put(R.id.record_btn, 65);
        sparseIntArray.put(R.id.add_cloud_parent, 66);
        sparseIntArray.put(R.id.iv_add_cloud, 67);
        sparseIntArray.put(R.id.tv_add_cloud, 68);
        sparseIntArray.put(R.id.monitor_device_num, 69);
        sparseIntArray.put(R.id.monitor_device_num_click, 70);
        sparseIntArray.put(R.id.monitor_unit_a, 71);
        sparseIntArray.put(R.id.monitor_unit_b, 72);
        sparseIntArray.put(R.id.monitor_unit_c, 73);
        sparseIntArray.put(R.id.monitor_unit_d, 74);
        sparseIntArray.put(R.id.ac_wheel_card, 75);
        sparseIntArray.put(R.id.ac_wheel, 76);
    }

    public C5236(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 77, f17352, f17353));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f17355 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17355 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17355 = 1L;
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

    public C5236(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ACWheelView) objArr[76], (CardView) objArr[75], (ConstraintLayout) objArr[66], (ImageView) objArr[67], (ChangeTintImageView) objArr[8], (ChangeTintImageView) objArr[23], (ChangeTintImageView) objArr[38], (ChangeTintImageView) objArr[53], (MonitorSignalView) objArr[69], (View) objArr[70], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[2], (MonitorUnitView) objArr[39], (MonitorUnitView) objArr[54], (TextView) objArr[71], (TextView) objArr[72], (TextView) objArr[73], (TextView) objArr[74], (MonitorUnitView) objArr[9], (MonitorUnitView) objArr[24], (StrokeTextView) objArr[63], (ConstraintLayout) objArr[3], (ConstraintLayout) objArr[18], (ConstraintLayout) objArr[33], (ConstraintLayout) objArr[48], (CloudPlayerConnectView) objArr[14], (CloudPlayerConnectView) objArr[29], (CloudPlayerConnectView) objArr[44], (CloudPlayerConnectView) objArr[59], (ImageView) objArr[16], (ImageView) objArr[31], (ImageView) objArr[46], (ImageView) objArr[61], (View) objArr[17], (View) objArr[32], (View) objArr[47], (View) objArr[62], (CloudMonitorSwitchView) objArr[15], (CloudMonitorSwitchView) objArr[30], (CloudMonitorSwitchView) objArr[45], (CloudMonitorSwitchView) objArr[60], (MonitorPlayerControlView) objArr[11], (MonitorPlayerControlView) objArr[26], (MonitorPlayerControlView) objArr[41], (MonitorPlayerControlView) objArr[56], (MonitorFlagView) objArr[12], (MonitorFlagView) objArr[27], (MonitorFlagView) objArr[42], (MonitorFlagView) objArr[57], (StrokeTextView) objArr[13], (StrokeTextView) objArr[28], (StrokeTextView) objArr[43], (StrokeTextView) objArr[58], (RecordButton) objArr[65], (ConstraintLayout) objArr[64], (RecordTimeLayout) objArr[10], (RecordTimeLayout) objArr[25], (RecordTimeLayout) objArr[40], (RecordTimeLayout) objArr[55], (ConstraintLayout) objArr[5], (ConstraintLayout) objArr[20], (ConstraintLayout) objArr[35], (ConstraintLayout) objArr[50], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[19], (ConstraintLayout) objArr[34], (ConstraintLayout) objArr[49], (StrokeTextView) objArr[68], (StrokeTextView) objArr[7], (StrokeTextView) objArr[22], (StrokeTextView) objArr[37], (StrokeTextView) objArr[52], (StrokeTextView) objArr[6], (StrokeTextView) objArr[21], (StrokeTextView) objArr[36], (StrokeTextView) objArr[51]);
        this.f17355 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f17354 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
