package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.blink.academy.film.widgets.FilmTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPayProductViewBindingImpl.java */
/* renamed from: ц, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2899 extends AbstractC3861 {

    /* renamed from: ނ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10575;

    /* renamed from: ރ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f10576;

    /* renamed from: ށ, reason: contains not printable characters */
    public long f10577;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f10575 = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_pay_product", "item_pay_product", "item_pay_product"}, new int[]{1, 2, 3}, new int[]{R.layout.item_pay_product, R.layout.item_pay_product, R.layout.item_pay_product});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10576 = sparseIntArray;
        sparseIntArray.put(R.id.iv_logo, 4);
        sparseIntArray.put(R.id.tv_info, 5);
        sparseIntArray.put(R.id.line1, 6);
        sparseIntArray.put(R.id.line2, 7);
        sparseIntArray.put(R.id.rel_sign, 8);
        sparseIntArray.put(R.id.iv_sign, 9);
        sparseIntArray.put(R.id.tv_sign_in, 10);
    }

    public C2899(@Nullable DataBindingComponent dataBindingComponent, @NonNull View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 11, f10575, f10576));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f10577 = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f13271);
        ViewDataBinding.executeBindingsOn(this.f13272);
        ViewDataBinding.executeBindingsOn(this.f13273);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10577 != 0) {
                return true;
            }
            return this.f13271.hasPendingBindings() || this.f13272.hasPendingBindings() || this.f13273.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10577 = 8L;
        }
        this.f13271.invalidateAll();
        this.f13272.invalidateAll();
        this.f13273.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m10267((AbstractC3819) obj, i2);
        }
        if (i == 1) {
            return m10266((AbstractC3819) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m10265((AbstractC3819) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13271.setLifecycleOwner(lifecycleOwner);
        this.f13272.setLifecycleOwner(lifecycleOwner);
        this.f13273.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    /* renamed from: ຒ, reason: contains not printable characters */
    public final boolean m10265(AbstractC3819 abstractC3819, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f10577 |= 4;
        }
        return true;
    }

    /* renamed from: ຓ, reason: contains not printable characters */
    public final boolean m10266(AbstractC3819 abstractC3819, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f10577 |= 2;
        }
        return true;
    }

    /* renamed from: ຘ, reason: contains not printable characters */
    public final boolean m10267(AbstractC3819 abstractC3819, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f10577 |= 1;
        }
        return true;
    }

    public C2899(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        super(dataBindingComponent, viewArr[0], 3, (ImageView) objArr[4], (ImageView) objArr[9], (View) objArr[6], (View) objArr[7], (AbstractC3819) objArr[1], (AbstractC3819) objArr[2], (AbstractC3819) objArr[3], (LinearLayout) objArr[8], (ConstraintLayout) objArr[0], (FilmTextView) objArr[5], (TextView) objArr[10]);
        this.f10577 = -1L;
        setContainedBinding(this.f13271);
        setContainedBinding(this.f13272);
        setContainedBinding(this.f13273);
        this.f13275.setTag(null);
        setRootTag(viewArr);
        invalidateAll();
    }
}
