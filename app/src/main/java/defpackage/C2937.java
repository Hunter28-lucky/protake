package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeLineView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutBatteryBindingImpl.java */
/* renamed from: ѧ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2937 extends AbstractC4928 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10648 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f10649;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f10650;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f10651;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10649 = sparseIntArray;
        sparseIntArray.put(R.id.tv_battery, 1);
        sparseIntArray.put(R.id.view_line, 2);
        sparseIntArray.put(R.id.tv_storage, 3);
    }

    public C2937(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10648, f10649));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f10651 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10651 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10651 = 1L;
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

    public C2937(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (StrokeTextView) objArr[1], (StrokeTextView) objArr[3], (StrokeLineView) objArr[2]);
        this.f10651 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10650 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
