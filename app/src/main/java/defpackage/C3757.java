package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.RecordTimeFrameView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorRecordTimeBindingImpl.java */
/* renamed from: ݮ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3757 extends AbstractC3512 {

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12983 = null;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12984;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12985;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f12986;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12984 = sparseIntArray;
        sparseIntArray.put(R.id.record_time_frame, 1);
        sparseIntArray.put(R.id.record_device_num, 2);
    }

    public C3757(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12983, f12984));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12986 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12986 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12986 = 1L;
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

    public C3757(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (StrokeTextView) objArr[2], (RecordTimeFrameView) objArr[1]);
        this.f12986 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12985 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
