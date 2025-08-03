package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: FragmentLocalPrivacyBindingImpl.java */
/* renamed from: ཌྷ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5032 extends AbstractC4304 {

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16806 = null;

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16807;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f16808;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16807 = sparseIntArray;
        sparseIntArray.put(R.id.top, 1);
        sparseIntArray.put(R.id.signin_tv_title, 2);
        sparseIntArray.put(R.id.tv_view, 3);
        sparseIntArray.put(R.id.tv_view2, 4);
        sparseIntArray.put(R.id.bottom, 5);
        sparseIntArray.put(R.id.signin_ll_pre, 6);
        sparseIntArray.put(R.id.pre_iv, 7);
        sparseIntArray.put(R.id.signin_tv_skip, 8);
        sparseIntArray.put(R.id.stroke_view_2, 9);
        sparseIntArray.put(R.id.signin_ll_next, 10);
        sparseIntArray.put(R.id.signin_tv_next, 11);
        sparseIntArray.put(R.id.next_iv, 12);
        sparseIntArray.put(R.id.stroke_view, 13);
    }

    public C5032(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f16806, f16807));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16808 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16808 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16808 = 1L;
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

    public C5032(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[5], (ImageView) objArr[12], (ImageView) objArr[7], (CardView) objArr[0], (ConstraintLayout) objArr[10], (ConstraintLayout) objArr[6], (TextView) objArr[11], (TextView) objArr[8], (TextView) objArr[2], (View) objArr[13], (View) objArr[9], (LinearLayoutCompat) objArr[1], (TextView) objArr[3], (TextView) objArr[4]);
        this.f16808 = -1L;
        this.f14744.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
