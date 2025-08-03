package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitPresetSettingBindingImpl.java */
/* renamed from: บ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4896 extends AbstractC5232 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16535 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16536;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f16537;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f16538;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16536 = sparseIntArray;
        sparseIntArray.put(R.id.rv, 1);
        sparseIntArray.put(R.id.rl_empty_parent, 2);
        sparseIntArray.put(R.id.tv_empty, 3);
    }

    public C4896(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f16535, f16536));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16538 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16538 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16538 = 1L;
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

    public C4896(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[2], (RecyclerView) objArr[1], (TextView) objArr[3]);
        this.f16538 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f16537 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
