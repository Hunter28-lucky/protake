package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.FilmTextView;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutSubscribeViewBindingImpl.java */
/* renamed from: ঊ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4142 extends AbstractC3120 {

    /* renamed from: ގ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14359 = null;

    /* renamed from: ޏ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14360;

    /* renamed from: ލ, reason: contains not printable characters */
    public long f14361;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14360 = sparseIntArray;
        sparseIntArray.put(R.id.root, 1);
        sparseIntArray.put(R.id.iv_logo, 2);
        sparseIntArray.put(R.id.iv_close, 3);
        sparseIntArray.put(R.id.tv_price, 4);
        sparseIntArray.put(R.id.btn_subscribe, 5);
        sparseIntArray.put(R.id.rel_sign_parent, 6);
        sparseIntArray.put(R.id.rel_restore_purchases, 7);
        sparseIntArray.put(R.id.iv_restore_purchases, 8);
        sparseIntArray.put(R.id.tv_restore_purchases, 9);
        sparseIntArray.put(R.id.restore_progress, 10);
        sparseIntArray.put(R.id.rel_sign, 11);
        sparseIntArray.put(R.id.iv_sign, 12);
        sparseIntArray.put(R.id.tv_sign_in, 13);
        sparseIntArray.put(R.id.v_line, 14);
        sparseIntArray.put(R.id.tv_service, 15);
        sparseIntArray.put(R.id.tv_policies, 16);
        sparseIntArray.put(R.id.tv_support_email, 17);
        sparseIntArray.put(R.id.tv_info, 18);
        sparseIntArray.put(R.id.v_service, 19);
        sparseIntArray.put(R.id.v_policies, 20);
        sparseIntArray.put(R.id.v_support_email, 21);
        sparseIntArray.put(R.id.v_close_area, 22);
    }

    public C4142(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, f14359, f14360));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14361 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14361 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14361 = 1L;
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

    public C4142(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundButton) objArr[5], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[8], (ImageView) objArr[12], (LinearLayout) objArr[7], (LinearLayout) objArr[11], (ConstraintLayout) objArr[6], (OneTakeProgressBar) objArr[10], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[0], (TextView) objArr[18], (TextView) objArr[16], (FilmTextView) objArr[4], (TextView) objArr[9], (TextView) objArr[15], (TextView) objArr[13], (TextView) objArr[17], (View) objArr[22], (View) objArr[14], (View) objArr[20], (View) objArr[19], (View) objArr[21]);
        this.f14361 = -1L;
        this.f11095.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
