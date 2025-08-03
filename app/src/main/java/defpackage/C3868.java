package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutSocketAddressItemBindingImpl.java */
/* renamed from: ߨ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3868 extends AbstractC3134 {

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13307 = null;

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13308;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f13309;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f13310;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13308 = sparseIntArray;
        sparseIntArray.put(R.id.text_msg, 1);
        sparseIntArray.put(R.id.btn_connect, 2);
    }

    public C3868(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13307, f13308));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13310 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13310 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13310 = 1L;
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

    public C3868(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (TextView) objArr[1]);
        this.f13310 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13309 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
