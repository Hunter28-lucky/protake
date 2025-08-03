package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.protake.R;

/* compiled from: FragmentWebPrivacyBindingImpl.java */
/* renamed from: ઞ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4342 extends AbstractC4413 {

    /* renamed from: ރ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14890 = null;

    /* renamed from: ބ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14891;

    /* renamed from: ނ, reason: contains not printable characters */
    public long f14892;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14891 = sparseIntArray;
        sparseIntArray.put(R.id.web_view, 1);
        sparseIntArray.put(R.id.loading, 2);
        sparseIntArray.put(R.id.bottom, 3);
        sparseIntArray.put(R.id.signin_ll_pre, 4);
        sparseIntArray.put(R.id.pre_iv, 5);
        sparseIntArray.put(R.id.signin_tv_skip, 6);
        sparseIntArray.put(R.id.stroke_view_2, 7);
        sparseIntArray.put(R.id.signin_ll_next, 8);
        sparseIntArray.put(R.id.signin_tv_next, 9);
        sparseIntArray.put(R.id.next_iv, 10);
        sparseIntArray.put(R.id.stroke_view, 11);
    }

    public C4342(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f14890, f14891));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14892 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14892 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14892 = 1L;
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

    public C4342(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[3], (OneTakeProgressBar) objArr[2], (ImageView) objArr[10], (ImageView) objArr[5], (CardView) objArr[0], (ConstraintLayout) objArr[8], (ConstraintLayout) objArr[4], (TextView) objArr[9], (TextView) objArr[6], (View) objArr[11], (View) objArr[7], (WebView) objArr[1]);
        this.f14892 = -1L;
        this.f15204.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
