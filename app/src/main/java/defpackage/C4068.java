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
import com.blink.academy.film.widgets.BottomLineEditText;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.protake.R;

/* compiled from: LayoutSignInBindingImpl.java */
/* renamed from: ज, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4068 extends AbstractC4030 {

    /* renamed from: ފ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14153 = null;

    /* renamed from: ދ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14154;

    /* renamed from: މ, reason: contains not printable characters */
    public long f14155;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14154 = sparseIntArray;
        sparseIntArray.put(R.id.signin_tv_title, 1);
        sparseIntArray.put(R.id.iv_close, 2);
        sparseIntArray.put(R.id.signin_tv_content, 3);
        sparseIntArray.put(R.id.signin_tv_area, 4);
        sparseIntArray.put(R.id.signin_ll_code_area, 5);
        sparseIntArray.put(R.id.signin_tv_code, 6);
        sparseIntArray.put(R.id.signin_iv_code, 7);
        sparseIntArray.put(R.id.signin_et, 8);
        sparseIntArray.put(R.id.bottom, 9);
        sparseIntArray.put(R.id.signin_ll_back, 10);
        sparseIntArray.put(R.id.signin_tv_back, 11);
        sparseIntArray.put(R.id.signin_tv_skip, 12);
        sparseIntArray.put(R.id.signin_tv_cancel, 13);
        sparseIntArray.put(R.id.signin_ll_next, 14);
        sparseIntArray.put(R.id.signin_tv_next, 15);
        sparseIntArray.put(R.id.signin_next_pb, 16);
        sparseIntArray.put(R.id.real_bottom, 17);
        sparseIntArray.put(R.id.click_view, 18);
    }

    public C4068(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, f14153, f14154));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14155 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14155 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14155 = 1L;
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

    public C4068(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[9], (View) objArr[18], (ImageView) objArr[2], (RelativeLayout) objArr[17], (CardView) objArr[0], (BottomLineEditText) objArr[8], (ImageView) objArr[7], (LinearLayout) objArr[10], (RelativeLayout) objArr[5], (LinearLayout) objArr[14], (OneTakeProgressBar) objArr[16], (TextView) objArr[4], (TextView) objArr[11], (TextView) objArr[13], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[15], (TextView) objArr[12], (TextView) objArr[1]);
        this.f14155 = -1L;
        this.f13993.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
