package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.CircleBgView;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.StrokePointView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorFlagViewBindingImpl.java */
/* renamed from: ล, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4908 extends AbstractC4914 {

    /* renamed from: ވ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16562 = null;

    /* renamed from: މ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16563;

    /* renamed from: ކ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16564;

    /* renamed from: އ, reason: contains not printable characters */
    public long f16565;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16563 = sparseIntArray;
        sparseIntArray.put(R.id.record_parent, 1);
        sparseIntArray.put(R.id.back_button, 2);
        sparseIntArray.put(R.id.back_circle_bg, 3);
        sparseIntArray.put(R.id.iv_back, 4);
        sparseIntArray.put(R.id.iv_record_btn, 5);
        sparseIntArray.put(R.id.flag_parent, 6);
        sparseIntArray.put(R.id.iv_filter_good_parent, 7);
        sparseIntArray.put(R.id.iv_filter_good, 8);
        sparseIntArray.put(R.id.iv_filter_keep_parent, 9);
        sparseIntArray.put(R.id.iv_filter_keep, 10);
        sparseIntArray.put(R.id.iv_filter_ng_parent, 11);
        sparseIntArray.put(R.id.iv_filter_ng, 12);
        sparseIntArray.put(R.id.loading_progress, 13);
        sparseIntArray.put(R.id.beauty_patent, 14);
        sparseIntArray.put(R.id.iv_beauty_btn, 15);
        sparseIntArray.put(R.id.beauty_point, 16);
    }

    public C4908(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f16562, f16563));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16565 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16565 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16565 = 1L;
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

    public C4908(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[2], (CircleBgView) objArr[3], (ConstraintLayout) objArr[14], (StrokePointView) objArr[16], (ConstraintLayout) objArr[6], (ImageView) objArr[4], (ImageView) objArr[15], (ImageView) objArr[8], (ConstraintLayout) objArr[7], (ImageView) objArr[10], (ConstraintLayout) objArr[9], (ImageView) objArr[12], (ConstraintLayout) objArr[11], (ImageView) objArr[5], (OneTakeProgressBar) objArr[13], (ConstraintLayout) objArr[1]);
        this.f16565 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f16564 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
