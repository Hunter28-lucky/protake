package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorPlayerControlBindingImpl.java */
/* renamed from: ছ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4173 extends AbstractC3675 {

    /* renamed from: ނ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14430 = null;

    /* renamed from: ރ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14431;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f14432;

    /* renamed from: ށ, reason: contains not printable characters */
    public long f14433;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14431 = sparseIntArray;
        sparseIntArray.put(R.id.iv_pre, 1);
        sparseIntArray.put(R.id.iv_rewind, 2);
        sparseIntArray.put(R.id.iv_play, 3);
        sparseIntArray.put(R.id.iv_forward, 4);
        sparseIntArray.put(R.id.iv_next, 5);
        sparseIntArray.put(R.id.iv_play_click, 6);
        sparseIntArray.put(R.id.iv_pre_click, 7);
        sparseIntArray.put(R.id.iv_rewind_click, 8);
        sparseIntArray.put(R.id.iv_forward_click, 9);
        sparseIntArray.put(R.id.iv_next_click, 10);
    }

    public C4173(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f14430, f14431));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14433 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14433 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14433 = 1L;
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

    public C4173(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (View) objArr[9], (ImageView) objArr[5], (View) objArr[10], (ImageView) objArr[3], (View) objArr[6], (ImageView) objArr[1], (View) objArr[7], (ImageView) objArr[2], (View) objArr[8]);
        this.f14433 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14432 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
