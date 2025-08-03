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

/* compiled from: LayoutSettingProtakeFocusBindingImpl.java */
/* renamed from: ҕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2959 extends AbstractC4140 {

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10690 = null;

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f10691;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f10692;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f10693;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10691 = sparseIntArray;
        sparseIntArray.put(R.id.rl_content, 1);
        sparseIntArray.put(R.id.rv, 2);
        sparseIntArray.put(R.id.tv_cancel, 3);
        sparseIntArray.put(R.id.tv_ok, 4);
        sparseIntArray.put(R.id.ok_click, 5);
        sparseIntArray.put(R.id.cancel_click, 6);
    }

    public C2959(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10690, f10691));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f10693 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10693 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10693 = 1L;
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

    public C2959(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[6], (View) objArr[5], (RelativeLayout) objArr[1], (RecyclerView) objArr[2], (StrokeTextView) objArr[3], (StrokeTextView) objArr[4]);
        this.f10693 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f10692 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
