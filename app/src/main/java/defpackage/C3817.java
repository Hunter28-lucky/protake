package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.stream.ACUnitView;
import com.blink.academy.film.videotools.CameraView;
import com.blink.academy.protake.R;

/* compiled from: ActivityDemoBindingImpl.java */
/* renamed from: ޱ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3817 extends AbstractC3816 {

    /* renamed from: ޗ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13086 = null;

    /* renamed from: ޘ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13087;

    /* renamed from: ޕ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f13088;

    /* renamed from: ޖ, reason: contains not printable characters */
    public long f13089;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13087 = sparseIntArray;
        sparseIntArray.put(R.id.camera, 1);
        sparseIntArray.put(R.id.top_ll, 2);
        sparseIntArray.put(R.id.bt_camera, 3);
        sparseIntArray.put(R.id.bt_watcher, 4);
        sparseIntArray.put(R.id.fl_setting, 5);
        sparseIntArray.put(R.id.camera_setting_content, 6);
        sparseIntArray.put(R.id.bt_push_a, 7);
        sparseIntArray.put(R.id.bt_push_b, 8);
        sparseIntArray.put(R.id.bt_push_c, 9);
        sparseIntArray.put(R.id.bt_push_d, 10);
        sparseIntArray.put(R.id.bt_config_speed, 11);
        sparseIntArray.put(R.id.bt_config_quality, 12);
        sparseIntArray.put(R.id.watcher_setting_content, 13);
        sparseIntArray.put(R.id.bt_device_a, 14);
        sparseIntArray.put(R.id.bt_device_b, 15);
        sparseIntArray.put(R.id.bt_device_c, 16);
        sparseIntArray.put(R.id.bt_device_d, 17);
        sparseIntArray.put(R.id.ll_controller, 18);
        sparseIntArray.put(R.id.tv_info, 19);
        sparseIntArray.put(R.id.bt_start_push, 20);
        sparseIntArray.put(R.id.receive_parent, 21);
        sparseIntArray.put(R.id.unit_0, 22);
        sparseIntArray.put(R.id.unit_1, 23);
        sparseIntArray.put(R.id.unit_2, 24);
        sparseIntArray.put(R.id.unit_3, 25);
        sparseIntArray.put(R.id.tv_client_infos, 26);
        sparseIntArray.put(R.id.ll_test_ban, 27);
        sparseIntArray.put(R.id.bt_ban_switch1, 28);
        sparseIntArray.put(R.id.bt_ban_switch2, 29);
        sparseIntArray.put(R.id.bt_ban_switch3, 30);
        sparseIntArray.put(R.id.bt_ban_switch4, 31);
    }

    public C3817(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 32, f13086, f13087));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13089 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13089 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13089 = 1L;
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

    public C3817(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[28], (Button) objArr[29], (Button) objArr[30], (Button) objArr[31], (Button) objArr[3], (Button) objArr[12], (Button) objArr[11], (Button) objArr[14], (Button) objArr[15], (Button) objArr[16], (Button) objArr[17], (Button) objArr[7], (Button) objArr[8], (Button) objArr[9], (Button) objArr[10], (Button) objArr[20], (Button) objArr[4], (CameraView) objArr[1], (LinearLayout) objArr[6], (FrameLayout) objArr[5], (LinearLayout) objArr[18], (LinearLayout) objArr[27], (LinearLayout) objArr[21], (LinearLayout) objArr[2], (TextView) objArr[26], (TextView) objArr[19], (ACUnitView) objArr[22], (ACUnitView) objArr[23], (ACUnitView) objArr[24], (ACUnitView) objArr[25], (LinearLayout) objArr[13]);
        this.f13089 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f13088 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
