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
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutSettingProtakeBindingImpl.java */
/* renamed from: ଷ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4438 extends AbstractC2860 {

    /* renamed from: ޡ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15291 = null;

    /* renamed from: ޢ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15292;

    /* renamed from: ޠ, reason: contains not printable characters */
    public long f15293;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15292 = sparseIntArray;
        sparseIntArray.put(R.id.root, 1);
        sparseIntArray.put(R.id.lin_parent, 2);
        sparseIntArray.put(R.id.lin_pro, 3);
        sparseIntArray.put(R.id.iv_pro, 4);
        sparseIntArray.put(R.id.tv_pro, 5);
        sparseIntArray.put(R.id.lin_looks, 6);
        sparseIntArray.put(R.id.iv_looks, 7);
        sparseIntArray.put(R.id.tv_looks, 8);
        sparseIntArray.put(R.id.lin_data, 9);
        sparseIntArray.put(R.id.iv_data, 10);
        sparseIntArray.put(R.id.tv_data, 11);
        sparseIntArray.put(R.id.lin_preset, 12);
        sparseIntArray.put(R.id.iv_preset, 13);
        sparseIntArray.put(R.id.tv_preset, 14);
        sparseIntArray.put(R.id.lin_access, 15);
        sparseIntArray.put(R.id.iv_access, 16);
        sparseIntArray.put(R.id.tv_access, 17);
        sparseIntArray.put(R.id.tv_price, 18);
        sparseIntArray.put(R.id.btn_subscribe, 19);
        sparseIntArray.put(R.id.rel_sign_parent, 20);
        sparseIntArray.put(R.id.rel_restore_purchases, 21);
        sparseIntArray.put(R.id.iv_restore_purchases, 22);
        sparseIntArray.put(R.id.tv_restore_purchases, 23);
        sparseIntArray.put(R.id.restore_progress, 24);
        sparseIntArray.put(R.id.rel_sign, 25);
        sparseIntArray.put(R.id.iv_sign, 26);
        sparseIntArray.put(R.id.tv_sign_in, 27);
        sparseIntArray.put(R.id.rel_write_off, 28);
        sparseIntArray.put(R.id.iv_write_off_account, 29);
        sparseIntArray.put(R.id.tv_write_off_account, 30);
        sparseIntArray.put(R.id.v_line, 31);
        sparseIntArray.put(R.id.tv_service, 32);
        sparseIntArray.put(R.id.tv_policies, 33);
        sparseIntArray.put(R.id.tv_support_email, 34);
        sparseIntArray.put(R.id.tv_info, 35);
        sparseIntArray.put(R.id.v_service, 36);
        sparseIntArray.put(R.id.v_policies, 37);
        sparseIntArray.put(R.id.v_support_email, 38);
        sparseIntArray.put(R.id.icp_cl, 39);
        sparseIntArray.put(R.id.tv_icp_filing, 40);
        sparseIntArray.put(R.id.icp_arrow, 41);
    }

    public C4438(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 42, f15291, f15292));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15293 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15293 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15293 = 1L;
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

    public C4438(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundButton) objArr[19], (ImageView) objArr[41], (ConstraintLayout) objArr[39], (ImageView) objArr[16], (ImageView) objArr[10], (ImageView) objArr[7], (ImageView) objArr[13], (ImageView) objArr[4], (ImageView) objArr[22], (ImageView) objArr[26], (ImageView) objArr[29], (LinearLayout) objArr[15], (LinearLayout) objArr[9], (LinearLayout) objArr[6], (LinearLayout) objArr[2], (LinearLayout) objArr[12], (LinearLayout) objArr[3], (LinearLayout) objArr[21], (LinearLayout) objArr[25], (ConstraintLayout) objArr[20], (ConstraintLayout) objArr[28], (OneTakeProgressBar) objArr[24], (ConstraintLayout) objArr[1], (RelativeLayout) objArr[0], (TextView) objArr[17], (TextView) objArr[11], (TextView) objArr[40], (TextView) objArr[35], (TextView) objArr[8], (TextView) objArr[33], (TextView) objArr[14], (TextView) objArr[18], (TextView) objArr[5], (TextView) objArr[23], (TextView) objArr[32], (TextView) objArr[27], (TextView) objArr[34], (TextView) objArr[30], (View) objArr[31], (View) objArr[37], (View) objArr[36], (View) objArr[38]);
        this.f15293 = -1L;
        this.f10470.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
