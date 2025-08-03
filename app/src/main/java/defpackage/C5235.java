package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.VerificationCodeEditText;
import com.blink.academy.protake.R;

/* compiled from: LayoutVerifyViewBindingImpl.java */
/* renamed from: Ⴝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5235 extends AbstractC2689 {

    /* renamed from: ވ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f17349 = null;

    /* renamed from: މ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f17350;

    /* renamed from: އ, reason: contains not printable characters */
    public long f17351;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17350 = sparseIntArray;
        sparseIntArray.put(R.id.verify_tv_title, 1);
        sparseIntArray.put(R.id.iv_close, 2);
        sparseIntArray.put(R.id.right_view, 3);
        sparseIntArray.put(R.id.verify_tv_content, 4);
        sparseIntArray.put(R.id.verify_et, 5);
        sparseIntArray.put(R.id.bottom, 6);
        sparseIntArray.put(R.id.verify_back, 7);
        sparseIntArray.put(R.id.call_pb, 8);
        sparseIntArray.put(R.id.verify_iv_back, 9);
        sparseIntArray.put(R.id.verify_tv_back, 10);
        sparseIntArray.put(R.id.verify_ll_resend, 11);
        sparseIntArray.put(R.id.verify_resend_iv, 12);
        sparseIntArray.put(R.id.verify_tv_resend, 13);
        sparseIntArray.put(R.id.resend_pb, 14);
        sparseIntArray.put(R.id.real_bottom, 15);
        sparseIntArray.put(R.id.click_view, 16);
    }

    public C5235(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f17349, f17350));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f17351 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17351 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17351 = 1L;
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

    public C5235(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[6], (OneTakeProgressBar) objArr[8], (View) objArr[16], (ImageView) objArr[2], (RelativeLayout) objArr[15], (OneTakeProgressBar) objArr[14], (View) objArr[3], (CardView) objArr[0], (LinearLayout) objArr[7], (VerificationCodeEditText) objArr[5], (ImageView) objArr[9], (LinearLayout) objArr[11], (ImageView) objArr[12], (TextView) objArr[10], (TextView) objArr[4], (TextView) objArr[13], (TextView) objArr[1]);
        this.f17351 = -1L;
        this.f9972.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
