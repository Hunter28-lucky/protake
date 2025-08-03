package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitAbViewBindingImpl.java */
/* renamed from: Ƃ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2406 extends AbstractC3140 {

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8981 = null;

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f8982;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f8983;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f8984;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8982 = sparseIntArray;
        sparseIntArray.put(R.id.zoom_b_parent, 1);
        sparseIntArray.put(R.id.iv_b, 2);
        sparseIntArray.put(R.id.zoom_ab_parent, 3);
        sparseIntArray.put(R.id.iv_ab, 4);
    }

    public C2406(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8981, f8982));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8984 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8984 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8984 = 1L;
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

    public C2406(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (ImageView) objArr[2], (LinearLayout) objArr[3], (LinearLayout) objArr[1]);
        this.f8984 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f8983 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
