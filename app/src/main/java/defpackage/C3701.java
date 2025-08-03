package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutTagViewBindingImpl.java */
/* renamed from: ݐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3701 extends AbstractC4864 {

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12834 = null;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12835;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12836;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f12837;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12835 = sparseIntArray;
        sparseIntArray.put(R.id.iv, 1);
        sparseIntArray.put(R.id.tv, 2);
    }

    public C3701(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12834, f12835));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12837 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12837 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12837 = 1L;
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

    public C3701(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (StrokeTextView) objArr[2]);
        this.f12837 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f12836 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
