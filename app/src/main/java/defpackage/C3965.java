package defpackage;

import android.util.SparseIntArray;
import android.view.View;
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
import com.blink.academy.film.widgets.setting.DataSettingView;
import com.blink.academy.film.widgets.setting.PresetSettingView;
import com.blink.academy.film.widgets.setting.ProtakeProSettingView;
import com.blink.academy.film.widgets.setting.ProtakeSignInSettingView;
import com.blink.academy.film.widgets.setting.RecordContainerView;
import com.blink.academy.film.widgets.setting.accessories.AccessoriesContainerView;
import com.blink.academy.protake.R;

/* compiled from: ActivitySettingBindingImpl.java */
/* renamed from: ࢡ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3965 extends AbstractC3964 {

    /* renamed from: ޖ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13824 = null;

    /* renamed from: ޗ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13825;

    /* renamed from: ޔ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13826;

    /* renamed from: ޕ, reason: contains not printable characters */
    public long f13827;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13825 = sparseIntArray;
        sparseIntArray.put(R.id.root_parent, 1);
        sparseIntArray.put(R.id.view_bottom, 2);
        sparseIntArray.put(R.id.root, 3);
        sparseIntArray.put(R.id.view_top, 4);
        sparseIntArray.put(R.id.ll_top, 5);
        sparseIntArray.put(R.id.tv_sign_in, 6);
        sparseIntArray.put(R.id.tv_record, 7);
        sparseIntArray.put(R.id.tv_data, 8);
        sparseIntArray.put(R.id.iv_data_lock, 9);
        sparseIntArray.put(R.id.tv_preset, 10);
        sparseIntArray.put(R.id.iv_preset_lock, 11);
        sparseIntArray.put(R.id.tv_accessories, 12);
        sparseIntArray.put(R.id.iv_access_lock, 13);
        sparseIntArray.put(R.id.tv_pro, 14);
        sparseIntArray.put(R.id.close_iv, 15);
        sparseIntArray.put(R.id.close, 16);
        sparseIntArray.put(R.id.record_view, 17);
        sparseIntArray.put(R.id.data_view, 18);
        sparseIntArray.put(R.id.preset_view, 19);
        sparseIntArray.put(R.id.accessories_view, 20);
        sparseIntArray.put(R.id.protake_sign_in_view, 21);
        sparseIntArray.put(R.id.protake_pro_view, 22);
        sparseIntArray.put(R.id.subscribe_view, 23);
        sparseIntArray.put(R.id.code_dialog, 24);
        sparseIntArray.put(R.id.gimbal_dialog, 25);
        sparseIntArray.put(R.id.protake_focus_dialog, 26);
        sparseIntArray.put(R.id.hint_dialog, 27);
        sparseIntArray.put(R.id.click_view, 28);
        sparseIntArray.put(R.id.privacy_dialog, 29);
        sparseIntArray.put(R.id.privacy_web_view, 30);
    }

    public C3965(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 31, f13824, f13825));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13827 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13827 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13827 = 1L;
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

    public C3965(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AccessoriesContainerView) objArr[20], (View) objArr[28], (View) objArr[16], (ImageView) objArr[15], (SettingCodeDialog) objArr[24], (DataSettingView) objArr[18], (SettingGimbalDialog) objArr[25], (SettingHintDialog) objArr[27], (ImageView) objArr[13], (ImageView) objArr[9], (ImageView) objArr[11], (LinearLayout) objArr[5], (PresetSettingView) objArr[19], (RelativeLayout) objArr[29], (PrivacyWebView) objArr[30], (SettingProtakeFocusDialog) objArr[26], (ProtakeProSettingView) objArr[22], (ProtakeSignInSettingView) objArr[21], (RecordContainerView) objArr[17], (LinearLayout) objArr[3], (ConstraintLayout) objArr[1], (SubscribeDialog) objArr[23], (TextView) objArr[12], (TextView) objArr[8], (TextView) objArr[10], (TextView) objArr[14], (TextView) objArr[7], (TextView) objArr[6], (View) objArr[2], (View) objArr[4]);
        this.f13827 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13826 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
