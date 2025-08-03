package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.SwitchButton2;
import com.blink.academy.protake.R;

/* compiled from: LayoutAccessories3BindingImpl.java */
/* renamed from: ӧ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3119 extends AbstractC3149 {

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11081 = null;

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f11082;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f11083;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f11084;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11082 = sparseIntArray;
        sparseIntArray.put(R.id.rl_hdmi, 1);
        sparseIntArray.put(R.id.tv_hdmi, 2);
        sparseIntArray.put(R.id.sb_hdmi, 3);
        sparseIntArray.put(R.id.v_line_0, 4);
    }

    public C3119(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f11081, f11082));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f11084 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11084 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11084 = 1L;
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

    public C3119(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[1], (SwitchButton2) objArr[3], (TextView) objArr[2], (View) objArr[4]);
        this.f11084 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f11083 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
