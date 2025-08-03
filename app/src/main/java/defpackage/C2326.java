package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutSettingProSignBindingImpl.java */
/* renamed from: Ę, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2326 extends AbstractC4442 {

    /* renamed from: މ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8837 = null;

    /* renamed from: ފ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f8838;

    /* renamed from: އ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f8839;

    /* renamed from: ވ, reason: contains not printable characters */
    public long f8840;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8838 = sparseIntArray;
        sparseIntArray.put(R.id.root, 1);
        sparseIntArray.put(R.id.iv_protake_logo, 2);
        sparseIntArray.put(R.id.rel_phone, 3);
        sparseIntArray.put(R.id.tv_phone_name, 4);
        sparseIntArray.put(R.id.tv_phone_value, 5);
        sparseIntArray.put(R.id.tv_exp_date_name, 6);
        sparseIntArray.put(R.id.tv_exp_date_value, 7);
        sparseIntArray.put(R.id.tv_change_phone, 8);
        sparseIntArray.put(R.id.change_phone_area, 9);
        sparseIntArray.put(R.id.btn_sign_out, 10);
        sparseIntArray.put(R.id.tv_service, 11);
        sparseIntArray.put(R.id.tv_policies, 12);
        sparseIntArray.put(R.id.mail_support, 13);
        sparseIntArray.put(R.id.tv_write_off_account, 14);
        sparseIntArray.put(R.id.icp_cl, 15);
        sparseIntArray.put(R.id.tv_icp_filing, 16);
        sparseIntArray.put(R.id.icp_arrow, 17);
    }

    public C2326(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, f8837, f8838));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8840 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8840 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8840 = 1L;
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

    public C2326(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundButton) objArr[10], (View) objArr[9], (ImageView) objArr[17], (ConstraintLayout) objArr[15], (ImageView) objArr[2], (TextView) objArr[13], (ConstraintLayout) objArr[3], (ConstraintLayout) objArr[1], (TextView) objArr[8], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[16], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[12], (TextView) objArr[11], (TextView) objArr[14]);
        this.f8840 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8839 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
