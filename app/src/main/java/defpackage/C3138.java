package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutImageClickViewBindingImpl.java */
/* renamed from: Ԁ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3138 extends AbstractC4728 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11144 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f11145;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f11146;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f11147;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11145 = sparseIntArray;
        sparseIntArray.put(R.id.image, 1);
    }

    public C3138(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f11144, f11145));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f11147 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11147 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11147 = 1L;
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

    public C3138(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1]);
        this.f11147 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f11146 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
