package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutInputPwdBindingImpl.java */
/* renamed from: Ⴆ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5200 extends AbstractC3097 {

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f17253 = null;

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f17254;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f17255;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17254 = sparseIntArray;
        sparseIntArray.put(R.id.et, 1);
        sparseIntArray.put(R.id.input_area, 2);
        sparseIntArray.put(R.id.tv1_parent, 3);
        sparseIntArray.put(R.id.tv_1, 4);
        sparseIntArray.put(R.id.tv2_parent, 5);
        sparseIntArray.put(R.id.tv_2, 6);
        sparseIntArray.put(R.id.tv3_parent, 7);
        sparseIntArray.put(R.id.tv_3, 8);
        sparseIntArray.put(R.id.tv4_parent, 9);
        sparseIntArray.put(R.id.tv_4, 10);
        sparseIntArray.put(R.id.tv5_parent, 11);
        sparseIntArray.put(R.id.tv_5, 12);
        sparseIntArray.put(R.id.tv6_parent, 13);
        sparseIntArray.put(R.id.tv_6, 14);
    }

    public C5200(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, f17253, f17254));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f17255 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17255 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17255 = 1L;
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

    public C5200(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (EditText) objArr[1], (LinearLayout) objArr[2], (TextView) objArr[4], (CardView) objArr[3], (TextView) objArr[6], (CardView) objArr[5], (TextView) objArr[8], (CardView) objArr[7], (TextView) objArr[10], (CardView) objArr[9], (TextView) objArr[12], (CardView) objArr[11], (TextView) objArr[14], (CardView) objArr[13]);
        this.f17255 = -1L;
        this.f11023.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
