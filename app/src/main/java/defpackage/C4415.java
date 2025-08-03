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

/* compiled from: LayoutSettingProtakePortraitBindingImpl.java */
/* renamed from: ଢ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4415 extends AbstractC3567 {

    /* renamed from: ޡ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15222 = null;

    /* renamed from: ޢ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15223;

    /* renamed from: ޠ, reason: contains not printable characters */
    public long f15224;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15223 = sparseIntArray;
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
        sparseIntArray.put(R.id.lin_bottom_parent, 12);
        sparseIntArray.put(R.id.lin_preset, 13);
        sparseIntArray.put(R.id.iv_preset, 14);
        sparseIntArray.put(R.id.tv_preset, 15);
        sparseIntArray.put(R.id.lin_access, 16);
        sparseIntArray.put(R.id.iv_access, 17);
        sparseIntArray.put(R.id.tv_access, 18);
        sparseIntArray.put(R.id.bottom_parent, 19);
        sparseIntArray.put(R.id.tv_price, 20);
        sparseIntArray.put(R.id.btn_subscribe, 21);
        sparseIntArray.put(R.id.rel_sign_parent, 22);
        sparseIntArray.put(R.id.sign_top_parent, 23);
        sparseIntArray.put(R.id.rel_restore_purchases, 24);
        sparseIntArray.put(R.id.iv_restore_purchases, 25);
        sparseIntArray.put(R.id.tv_restore_purchases, 26);
        sparseIntArray.put(R.id.restore_progress, 27);
        sparseIntArray.put(R.id.rel_sign, 28);
        sparseIntArray.put(R.id.iv_sign, 29);
        sparseIntArray.put(R.id.tv_sign_in, 30);
        sparseIntArray.put(R.id.rel_write_off, 31);
        sparseIntArray.put(R.id.iv_write_off_account, 32);
        sparseIntArray.put(R.id.tv_write_off_account, 33);
        sparseIntArray.put(R.id.v_line, 34);
        sparseIntArray.put(R.id.tv_service, 35);
        sparseIntArray.put(R.id.tv_policies, 36);
        sparseIntArray.put(R.id.tv_support_email, 37);
        sparseIntArray.put(R.id.tv_info, 38);
        sparseIntArray.put(R.id.v_service, 39);
        sparseIntArray.put(R.id.v_policies, 40);
        sparseIntArray.put(R.id.v_support_email, 41);
    }

    public C4415(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 42, f15222, f15223));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15224 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15224 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15224 = 1L;
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

    public C4415(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[19], (RoundButton) objArr[21], (ImageView) objArr[17], (ImageView) objArr[10], (ImageView) objArr[7], (ImageView) objArr[14], (ImageView) objArr[4], (ImageView) objArr[25], (ImageView) objArr[29], (ImageView) objArr[32], (LinearLayout) objArr[16], (LinearLayout) objArr[12], (LinearLayout) objArr[9], (LinearLayout) objArr[6], (LinearLayout) objArr[2], (LinearLayout) objArr[13], (LinearLayout) objArr[3], (LinearLayout) objArr[24], (LinearLayout) objArr[28], (ConstraintLayout) objArr[22], (ConstraintLayout) objArr[31], (OneTakeProgressBar) objArr[27], (LinearLayout) objArr[1], (RelativeLayout) objArr[0], (ConstraintLayout) objArr[23], (TextView) objArr[18], (TextView) objArr[11], (TextView) objArr[38], (TextView) objArr[8], (TextView) objArr[36], (TextView) objArr[15], (TextView) objArr[20], (TextView) objArr[5], (TextView) objArr[26], (TextView) objArr[35], (TextView) objArr[30], (TextView) objArr[37], (TextView) objArr[33], (View) objArr[34], (View) objArr[40], (View) objArr[39], (View) objArr[41]);
        this.f15224 = -1L;
        this.f12420.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
