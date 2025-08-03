package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.SwitchButton2;
import com.blink.academy.protake.R;

/* compiled from: LayoutAccessories2BindingImpl.java */
/* renamed from: ण, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4078 extends AbstractC4903 {

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14193 = null;

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14194;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14195;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f14196;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14194 = sparseIntArray;
        sparseIntArray.put(R.id.rl_dof, 1);
        sparseIntArray.put(R.id.tv_dof, 2);
        sparseIntArray.put(R.id.sb_dof, 3);
        sparseIntArray.put(R.id.v_line_0, 4);
        sparseIntArray.put(R.id.rl_protake_focus, 5);
        sparseIntArray.put(R.id.tv_protake_focus, 6);
        sparseIntArray.put(R.id.sb_protake_focus, 7);
        sparseIntArray.put(R.id.pb_protake_focus, 8);
        sparseIntArray.put(R.id.v_line_2, 9);
        sparseIntArray.put(R.id.rl_reverse_focus_wheel, 10);
        sparseIntArray.put(R.id.tv_reverse_focus_wheel, 11);
        sparseIntArray.put(R.id.sb_reverse_focus_wheel, 12);
        sparseIntArray.put(R.id.v_line_1, 13);
    }

    public C4078(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f14193, f14194));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14196 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14196 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14196 = 1L;
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

    public C4078(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (OneTakeProgressBar) objArr[8], (RelativeLayout) objArr[1], (RelativeLayout) objArr[5], (RelativeLayout) objArr[10], (SwitchButton) objArr[3], (SwitchButton2) objArr[7], (SwitchButton2) objArr[12], (TextView) objArr[2], (TextView) objArr[6], (TextView) objArr[11], (View) objArr[4], (View) objArr[13], (View) objArr[9]);
        this.f14196 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f14195 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
