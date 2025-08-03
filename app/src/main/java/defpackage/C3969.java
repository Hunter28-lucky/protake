package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.protake.R;

/* compiled from: ActivityTestSrtBindingImpl.java */
/* renamed from: ࢥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3969 extends AbstractC3968 {

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13876 = null;

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13877;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13878;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f13879;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13877 = sparseIntArray;
        sparseIntArray.put(R.id.btn_server, 1);
        sparseIntArray.put(R.id.tv_server, 2);
        sparseIntArray.put(R.id.btn_client, 3);
        sparseIntArray.put(R.id.tv_client, 4);
        sparseIntArray.put(R.id.tv_local_ip, 5);
        sparseIntArray.put(R.id.ip_list, 6);
    }

    public C3969(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13876, f13877));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13879 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13879 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13879 = 1L;
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

    public C3969(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[3], (Button) objArr[1], (RecyclerView) objArr[6], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2]);
        this.f13879 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13878 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
