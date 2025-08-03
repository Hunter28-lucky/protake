package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitSettingPag2BindingImpl.java */
/* renamed from: ݍ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3698 extends AbstractC4869 {

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12823 = null;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12824;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12825;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f12826;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12824 = sparseIntArray;
        sparseIntArray.put(R.id.has_connected_title, 1);
        sparseIntArray.put(R.id.connected_device_list, 2);
    }

    public C3698(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12823, f12824));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12826 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12826 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12826 = 1L;
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

    public C3698(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (StrokeTextView) objArr[1]);
        this.f12826 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12825 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
