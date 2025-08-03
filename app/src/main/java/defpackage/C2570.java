package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutLensSettingBindingImpl.java */
/* renamed from: ɒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2570 extends AbstractC2962 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9573 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9574;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f9575;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f9576;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9574 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.lens_setting_list, 3);
    }

    public C2570(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9573, f9574));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9576 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9576 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9576 = 1L;
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

    public C2570(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (StrokeTextView) objArr[1], (RecyclerView) objArr[3]);
        this.f9576 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9575 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
