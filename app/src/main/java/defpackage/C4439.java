package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutAbWheelBindingImpl.java */
/* renamed from: ସ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4439 extends AbstractC3824 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15294 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15295;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15296;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f15297;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15295 = sparseIntArray;
        sparseIntArray.put(R.id.iv_ab, 1);
        sparseIntArray.put(R.id.rl_anim, 2);
        sparseIntArray.put(R.id.iv_b, 3);
    }

    public C4439(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f15294, f15295));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15297 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15297 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15297 = 1L;
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

    public C4439(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[3], (RelativeLayout) objArr[2]);
        this.f15297 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f15296 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
