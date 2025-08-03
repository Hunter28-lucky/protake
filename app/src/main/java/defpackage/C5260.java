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
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutStrokeBottomBindingImpl.java */
/* renamed from: ე, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5260 extends AbstractC4251 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f17413 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f17414;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f17415;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f17416;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17414 = sparseIntArray;
        sparseIntArray.put(R.id.tv, 1);
        sparseIntArray.put(R.id.iv, 2);
        sparseIntArray.put(R.id.bottom, 3);
    }

    public C5260(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f17413, f17414));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f17416 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17416 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17416 = 1L;
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

    public C5260(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BottomBlockView) objArr[3], (ImageView) objArr[2], (StrokeTextView) objArr[1]);
        this.f17416 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f17415 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
