package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.VerificationCodeEditText;
import com.blink.academy.film.widgets.dialog.login.VerificationTextView;
import com.blink.academy.protake.R;

/* compiled from: FragmentCheckphoneBindingImpl.java */
/* renamed from: Ύ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2771 extends AbstractC4129 {

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10128 = null;

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f10129;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f10130;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10129 = sparseIntArray;
        sparseIntArray.put(R.id.verify_tv_title, 1);
        sparseIntArray.put(R.id.verify_tv_content, 2);
        sparseIntArray.put(R.id.checkPhone_tv_ll, 3);
        sparseIntArray.put(R.id.checkphone_start_tv, 4);
        sparseIntArray.put(R.id.verify_et, 5);
        sparseIntArray.put(R.id.checkphone_end_tv, 6);
        sparseIntArray.put(R.id.bottom, 7);
        sparseIntArray.put(R.id.signin_ll_back, 8);
        sparseIntArray.put(R.id.signin_tv_skip, 9);
        sparseIntArray.put(R.id.signin_ll_next, 10);
        sparseIntArray.put(R.id.signin_tv_next, 11);
        sparseIntArray.put(R.id.signin_next_pb, 12);
        sparseIntArray.put(R.id.real_bottom, 13);
        sparseIntArray.put(R.id.click_view, 14);
    }

    public C2771(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, f10128, f10129));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f10130 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10130 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10130 = 1L;
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

    public C2771(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[7], (LinearLayout) objArr[3], (VerificationTextView) objArr[6], (VerificationTextView) objArr[4], (View) objArr[14], (RelativeLayout) objArr[13], (RelativeLayout) objArr[0], (LinearLayout) objArr[8], (LinearLayout) objArr[10], (OneTakeProgressBar) objArr[12], (TextView) objArr[11], (TextView) objArr[9], (VerificationCodeEditText) objArr[5], (TextView) objArr[2], (TextView) objArr[1]);
        this.f10130 = -1L;
        this.f14300.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
