package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutZebraSettingBindingImpl.java */
/* renamed from: अ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4023 extends AbstractC3480 {

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13971 = null;

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13972;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13973;

    /* renamed from: ׯ, reason: contains not printable characters */
    public long f13974;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13972 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.zebra_setting_list, 3);
        sparseIntArray.put(R.id.bottom_auto, 4);
        sparseIntArray.put(R.id.bottom_auto_tv, 5);
        sparseIntArray.put(R.id.zebra_auto_switch, 6);
        sparseIntArray.put(R.id.zebra_view, 7);
    }

    public C4023(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13971, f13972));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13974 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13974 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13974 = 1L;
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

    public C4023(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[4], (StrokeTextView) objArr[5], (LinearLayout) objArr[2], (StrokeTextView) objArr[1], (SwitchButton) objArr[6], (RecyclerView) objArr[3], (View) objArr[7]);
        this.f13974 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13973 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
