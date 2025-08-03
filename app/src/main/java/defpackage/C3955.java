package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.videotools.CameraView;
import com.blink.academy.film.widgets.StyleHintView;
import com.blink.academy.film.widgets.SubscribeDialog;
import com.blink.academy.film.widgets.cover.ModeHintDialog;
import com.blink.academy.film.widgets.dialog.ScoreDialog;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.dialog.login.PrivacyWebView;
import com.blink.academy.protake.R;

/* compiled from: ActivityHomeBindingImpl.java */
/* renamed from: ࡢ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3955 extends AbstractC3954 {

    /* renamed from: ތ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13677 = null;

    /* renamed from: ލ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13678;

    /* renamed from: ދ, reason: contains not printable characters */
    public long f13679;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13678 = sparseIntArray;
        sparseIntArray.put(R.id.card_center, 1);
        sparseIntArray.put(R.id.root, 2);
        sparseIntArray.put(R.id.home_cameraview, 3);
        sparseIntArray.put(R.id.camera_cover, 4);
        sparseIntArray.put(R.id.fragment_container, 5);
        sparseIntArray.put(R.id.home_style_hint, 6);
        sparseIntArray.put(R.id.subscribe_view, 7);
        sparseIntArray.put(R.id.mode_hint_dialog, 8);
        sparseIntArray.put(R.id.hint_dialog, 9);
        sparseIntArray.put(R.id.permission_dialog, 10);
        sparseIntArray.put(R.id.fps_info_dialog, 11);
        sparseIntArray.put(R.id.sign_out_dialog, 12);
        sparseIntArray.put(R.id.device_limit_dialog, 13);
        sparseIntArray.put(R.id.login_pre_dialog, 14);
        sparseIntArray.put(R.id.alert_dialog, 15);
        sparseIntArray.put(R.id.info_dialog, 16);
        sparseIntArray.put(R.id.market_score_dialog, 17);
        sparseIntArray.put(R.id.click_view, 18);
        sparseIntArray.put(R.id.privacy_dialog, 19);
        sparseIntArray.put(R.id.privacy_web_view, 20);
    }

    public C3955(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 21, f13677, f13678));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13679 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13679 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13679 = 1L;
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

    public C3955(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SettingHintDialog) objArr[15], (View) objArr[4], (CardView) objArr[1], (View) objArr[18], (SettingHintDialog) objArr[13], (SettingHintDialog) objArr[11], (FrameLayout) objArr[5], (SettingHintDialog) objArr[9], (CameraView) objArr[3], (StyleHintView) objArr[6], (SettingHintDialog) objArr[16], (SettingHintDialog) objArr[14], (ScoreDialog) objArr[17], (ModeHintDialog) objArr[8], (SettingHintDialog) objArr[10], (RelativeLayout) objArr[19], (PrivacyWebView) objArr[20], (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[0], (SettingHintDialog) objArr[12], (SubscribeDialog) objArr[7]);
        this.f13679 = -1L;
        this.f13674.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
