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

/* compiled from: LayoutSettingProPortraitSignBindingImpl.java */
/* renamed from: ၕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5151 extends AbstractC2395 {

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f17082 = null;

    /* renamed from: ވ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f17083;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f17084;

    /* renamed from: ކ, reason: contains not printable characters */
    public long f17085;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17083 = sparseIntArray;
        sparseIntArray.put(R.id.root, 1);
        sparseIntArray.put(R.id.iv_protake_logo, 2);
        sparseIntArray.put(R.id.rel_phone, 3);
        sparseIntArray.put(R.id.tv_phone_name, 4);
        sparseIntArray.put(R.id.tv_phone_value, 5);
        sparseIntArray.put(R.id.tv_change_phone, 6);
        sparseIntArray.put(R.id.change_phone_area, 7);
        sparseIntArray.put(R.id.tv_exp_date_name, 8);
        sparseIntArray.put(R.id.tv_exp_date_value, 9);
        sparseIntArray.put(R.id.btn_sign_out, 10);
        sparseIntArray.put(R.id.service_parent, 11);
        sparseIntArray.put(R.id.tv_service, 12);
        sparseIntArray.put(R.id.tv_policies, 13);
        sparseIntArray.put(R.id.mail_support, 14);
        sparseIntArray.put(R.id.tv_write_off_account, 15);
    }

    public C5151(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f17082, f17083));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f17085 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17085 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17085 = 1L;
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

    public C5151(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundButton) objArr[10], (View) objArr[7], (ImageView) objArr[2], (TextView) objArr[14], (ConstraintLayout) objArr[3], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[11], (TextView) objArr[6], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[13], (TextView) objArr[12], (TextView) objArr[15]);
        this.f17085 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f17084 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
