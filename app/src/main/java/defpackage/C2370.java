package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.BottomBlockView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutFpsAutoItemBindingImpl.java */
/* renamed from: ő, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2370 extends AbstractC4686 {

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8917 = null;

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f8918;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f8919;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f8920;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8918 = sparseIntArray;
        sparseIntArray.put(R.id.top_parent, 1);
        sparseIntArray.put(R.id.tv_top, 2);
        sparseIntArray.put(R.id.iv_top, 3);
        sparseIntArray.put(R.id.tv, 4);
        sparseIntArray.put(R.id.bottom, 5);
    }

    public C2370(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f8917, f8918));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8920 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8920 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8920 = 1L;
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

    public C2370(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BottomBlockView) objArr[5], (ImageView) objArr[3], (RelativeLayout) objArr[1], (StrokeTextView) objArr[4], (StrokeTextView) objArr[2]);
        this.f8920 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f8919 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
