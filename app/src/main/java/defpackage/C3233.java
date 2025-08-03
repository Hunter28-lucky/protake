package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutSettingHintDiaBindingImpl.java */
/* renamed from: ա, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3233 extends AbstractC4261 {

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11386 = null;

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f11387;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f11388;

    /* renamed from: ׯ, reason: contains not printable characters */
    public long f11389;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11387 = sparseIntArray;
        sparseIntArray.put(R.id.rl_content, 1);
        sparseIntArray.put(R.id.tv, 2);
        sparseIntArray.put(R.id.tv_content, 3);
        sparseIntArray.put(R.id.tv_cancel, 4);
        sparseIntArray.put(R.id.tv_ok, 5);
        sparseIntArray.put(R.id.ok_click, 6);
        sparseIntArray.put(R.id.cancel_click, 7);
    }

    public C3233(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f11386, f11387));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f11389 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11389 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11389 = 1L;
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

    public C3233(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[7], (View) objArr[6], (RelativeLayout) objArr[1], (StrokeTextView) objArr[2], (StrokeTextView) objArr[4], (StrokeTextView) objArr[3], (StrokeTextView) objArr[5]);
        this.f11389 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f11388 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
