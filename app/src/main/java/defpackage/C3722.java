package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutGridsChooseBindingImpl.java */
/* renamed from: ݔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3722 extends AbstractC2522 {

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12888 = null;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12889;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12890;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f12891;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12889 = sparseIntArray;
        sparseIntArray.put(R.id.grids_un_choose_view, 1);
        sparseIntArray.put(R.id.grids_choose_view, 2);
    }

    public C3722(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12888, f12889));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12891 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12891 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12891 = 1L;
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

    public C3722(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (StrokeTextView) objArr[1]);
        this.f12891 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f12890 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
