package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.BottomBlockView;
import com.blink.academy.protake.R;

/* compiled from: LayoutImageBottomBlockBindingImpl.java */
/* renamed from: ড়, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4211 extends AbstractC4150 {

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14503 = null;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14504;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f14505;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f14506;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14504 = sparseIntArray;
        sparseIntArray.put(R.id.top, 1);
        sparseIntArray.put(R.id.bottom, 2);
    }

    public C4211(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f14503, f14504));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14506 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14506 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14506 = 1L;
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

    public C4211(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BottomBlockView) objArr[2], (ImageView) objArr[1]);
        this.f14506 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f14505 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
