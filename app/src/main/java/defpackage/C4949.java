package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.protake.R;

/* compiled from: FragmentPrivacyBindingImpl.java */
/* renamed from: ຍ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4949 extends AbstractC4395 {

    /* renamed from: ނ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16665 = null;

    /* renamed from: ރ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16666;

    /* renamed from: ށ, reason: contains not printable characters */
    public long f16667;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16666 = sparseIntArray;
        sparseIntArray.put(R.id.signin_tv_title, 1);
        sparseIntArray.put(R.id.signin_tv_content, 2);
        sparseIntArray.put(R.id.bottom, 3);
        sparseIntArray.put(R.id.signin_ll_back, 4);
        sparseIntArray.put(R.id.signin_tv_back, 5);
        sparseIntArray.put(R.id.signin_tv_skip, 6);
        sparseIntArray.put(R.id.signin_ll_next, 7);
        sparseIntArray.put(R.id.signin_tv_next, 8);
        sparseIntArray.put(R.id.signin_next_pb, 9);
        sparseIntArray.put(R.id.click_view, 10);
    }

    public C4949(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f16665, f16666));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16667 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16667 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16667 = 1L;
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

    public C4949(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[3], (View) objArr[10], (CardView) objArr[0], (LinearLayout) objArr[4], (LinearLayout) objArr[7], (OneTakeProgressBar) objArr[9], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[6], (TextView) objArr[1]);
        this.f16667 = -1L;
        this.f15116.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
