package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.transmit.monitor.MonitorNormalCoverView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorRedRecordingView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorParentViewBindingImpl.java */
/* renamed from: ক, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4149 extends AbstractC4201 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14378 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14379;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f14380;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14379 = sparseIntArray;
        sparseIntArray.put(R.id.normal_cover, 1);
        sparseIntArray.put(R.id.record_red_cover, 2);
        sparseIntArray.put(R.id.player_progress, 3);
    }

    public C4149(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f14378, f14379));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14380 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14380 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14380 = 1L;
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

    public C4149(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MonitorNormalCoverView) objArr[1], (ProgressBar) objArr[3], (MonitorRedRecordingView) objArr[2], (ConstraintLayout) objArr[0]);
        this.f14380 = -1L;
        this.f14488.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
