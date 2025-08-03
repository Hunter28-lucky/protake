package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.protake.R;

/* compiled from: ItemPayProductBindingImpl.java */
/* renamed from: ٻ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3503 extends AbstractC3819 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12268 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12269;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f12270;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f12271;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12269 = sparseIntArray;
        sparseIntArray.put(R.id.tv_price, 1);
        sparseIntArray.put(R.id.tv_price2, 2);
        sparseIntArray.put(R.id.tv_pay, 3);
    }

    public C3503(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12268, f12269));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12271 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12271 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12271 = 1L;
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

    public C3503(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundButton) objArr[3], (TextView) objArr[1], (TextView) objArr[2]);
        this.f12271 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12270 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
