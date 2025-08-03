package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutDeviceNumImageBindingImpl.java */
/* renamed from: ק, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3408 extends AbstractC4254 {

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11752 = null;

    /* renamed from: ވ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f11753;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f11754;

    /* renamed from: ކ, reason: contains not printable characters */
    public long f11755;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11753 = sparseIntArray;
        sparseIntArray.put(R.id.iv_parent, 1);
        sparseIntArray.put(R.id.iv_wifi_state_1, 2);
        sparseIntArray.put(R.id.iv_wifi_state_2, 3);
        sparseIntArray.put(R.id.iv_wifi_state_3, 4);
        sparseIntArray.put(R.id.iv_wifi_state_4, 5);
        sparseIntArray.put(R.id.iv_wifi_state_5, 6);
        sparseIntArray.put(R.id.iv_wifi_state_6, 7);
        sparseIntArray.put(R.id.iv_wifi_state_7, 8);
        sparseIntArray.put(R.id.iv_wifi_state_8, 9);
        sparseIntArray.put(R.id.iv_wifi_state_9, 10);
        sparseIntArray.put(R.id.iv_wifi_state_10, 11);
        sparseIntArray.put(R.id.iv_wifi_state_11, 12);
        sparseIntArray.put(R.id.iv_wifi_state_12, 13);
        sparseIntArray.put(R.id.tv_signal_type, 14);
        sparseIntArray.put(R.id.tv_device_unit, 15);
    }

    public C3408(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f11752, f11753));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f11755 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11755 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11755 = 1L;
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

    public C3408(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[1], (AppCompatImageView) objArr[2], (AppCompatImageView) objArr[11], (AppCompatImageView) objArr[12], (AppCompatImageView) objArr[13], (AppCompatImageView) objArr[3], (AppCompatImageView) objArr[4], (AppCompatImageView) objArr[5], (AppCompatImageView) objArr[6], (AppCompatImageView) objArr[7], (AppCompatImageView) objArr[8], (AppCompatImageView) objArr[9], (AppCompatImageView) objArr[10], (StrokeTextView) objArr[15], (StrokeTextView) objArr[14]);
        this.f11755 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f11754 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
