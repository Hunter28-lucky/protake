package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.SubscribeDialog;
import com.blink.academy.film.widgets.dialog.SettingCodeDialog;
import com.blink.academy.film.widgets.dialog.SettingGimbalDialog;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog;
import com.blink.academy.film.widgets.dialog.login.PrivacyWebView;
import com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView;
import com.blink.academy.film.widgets.setting.PortraitDataSettingView;
import com.blink.academy.film.widgets.setting.PortraitPresetSettingView;
import com.blink.academy.film.widgets.setting.PortraitRecordSettingView;
import com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView;
import com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView;
import com.blink.academy.protake.R;

/* compiled from: ActivityPortraitSettingBindingImpl.java */
/* renamed from: ࡨ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3961 extends AbstractC3960 {

    /* renamed from: ޢ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13783 = null;

    /* renamed from: ޣ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13784;

    /* renamed from: ޠ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13785;

    /* renamed from: ޡ, reason: contains not printable characters */
    public long f13786;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13784 = sparseIntArray;
        sparseIntArray.put(R.id.root_parent, 1);
        sparseIntArray.put(R.id.root, 2);
        sparseIntArray.put(R.id.rl_top, 3);
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.close_iv, 5);
        sparseIntArray.put(R.id.rl_add, 6);
        sparseIntArray.put(R.id.rl_scan, 7);
        sparseIntArray.put(R.id.iv_scan, 8);
        sparseIntArray.put(R.id.iv_add, 9);
        sparseIntArray.put(R.id.close, 10);
        sparseIntArray.put(R.id.top_line, 11);
        sparseIntArray.put(R.id.fl_content, 12);
        sparseIntArray.put(R.id.record_view, 13);
        sparseIntArray.put(R.id.data_view, 14);
        sparseIntArray.put(R.id.preset_view, 15);
        sparseIntArray.put(R.id.accessories_view, 16);
        sparseIntArray.put(R.id.protake_sign_in_view, 17);
        sparseIntArray.put(R.id.protake_pro_view, 18);
        sparseIntArray.put(R.id.ll_bottom, 19);
        sparseIntArray.put(R.id.rl_sign_in, 20);
        sparseIntArray.put(R.id.iv_sign_in, 21);
        sparseIntArray.put(R.id.rl_record, 22);
        sparseIntArray.put(R.id.iv_record, 23);
        sparseIntArray.put(R.id.fl_data, 24);
        sparseIntArray.put(R.id.iv_data, 25);
        sparseIntArray.put(R.id.iv_data_lock, 26);
        sparseIntArray.put(R.id.fl_preset, 27);
        sparseIntArray.put(R.id.iv_preset, 28);
        sparseIntArray.put(R.id.iv_preset_lock, 29);
        sparseIntArray.put(R.id.fl_accessories, 30);
        sparseIntArray.put(R.id.iv_accessories, 31);
        sparseIntArray.put(R.id.iv_access_lock, 32);
        sparseIntArray.put(R.id.rl_pro, 33);
        sparseIntArray.put(R.id.iv_pro, 34);
        sparseIntArray.put(R.id.subscribe_view, 35);
        sparseIntArray.put(R.id.code_dialog, 36);
        sparseIntArray.put(R.id.gimbal_dialog, 37);
        sparseIntArray.put(R.id.protake_focus_dialog, 38);
        sparseIntArray.put(R.id.hint_dialog, 39);
        sparseIntArray.put(R.id.click_view, 40);
        sparseIntArray.put(R.id.privacy_dialog, 41);
        sparseIntArray.put(R.id.privacy_web_view, 42);
    }

    public C3961(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 43, f13783, f13784));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13786 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13786 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13786 = 1L;
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

    public C3961(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (PortraitAccessoriesSettingView) objArr[16], (View) objArr[40], (View) objArr[10], (ImageView) objArr[5], (SettingCodeDialog) objArr[36], (PortraitDataSettingView) objArr[14], (FrameLayout) objArr[30], (FrameLayout) objArr[12], (FrameLayout) objArr[24], (FrameLayout) objArr[27], (SettingGimbalDialog) objArr[37], (SettingHintDialog) objArr[39], (ImageView) objArr[32], (ImageView) objArr[31], (ImageView) objArr[9], (ImageView) objArr[25], (ImageView) objArr[26], (ImageView) objArr[28], (ImageView) objArr[29], (ImageView) objArr[34], (ImageView) objArr[23], (ImageView) objArr[8], (ImageView) objArr[21], (LinearLayout) objArr[19], (PortraitPresetSettingView) objArr[15], (RelativeLayout) objArr[41], (PrivacyWebView) objArr[42], (SettingProtakeFocusDialog) objArr[38], (ProtakeProPortraitSettingView) objArr[18], (ProtakeSignInPortraitSettingView) objArr[17], (PortraitRecordSettingView) objArr[13], (View) objArr[6], (RelativeLayout) objArr[33], (RelativeLayout) objArr[22], (View) objArr[7], (RelativeLayout) objArr[20], (RelativeLayout) objArr[3], (LinearLayout) objArr[2], (ConstraintLayout) objArr[1], (SubscribeDialog) objArr[35], (View) objArr[11], (TextView) objArr[4]);
        this.f13786 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13785 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
