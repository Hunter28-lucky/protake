package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutSettingGimbalBindingImpl.java */
/* renamed from: ȼ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2549 extends AbstractC5237 {

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9424 = null;

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9425;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f9426;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f9427;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9425 = sparseIntArray;
        sparseIntArray.put(R.id.rl_content, 1);
        sparseIntArray.put(R.id.rv, 2);
        sparseIntArray.put(R.id.tv_cancel, 3);
        sparseIntArray.put(R.id.tv_ok, 4);
        sparseIntArray.put(R.id.ok_click, 5);
        sparseIntArray.put(R.id.cancel_click, 6);
    }

    public C2549(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f9424, f9425));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9427 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9427 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9427 = 1L;
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

    public C2549(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[6], (View) objArr[5], (RelativeLayout) objArr[1], (RecyclerView) objArr[2], (StrokeTextView) objArr[3], (StrokeTextView) objArr[4]);
        this.f9427 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f9426 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
