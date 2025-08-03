package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.dialog.login.SignInView;
import com.blink.academy.film.widgets.dialog.login.VerifyView;
import com.blink.academy.protake.R;

/* compiled from: LayoutLoginDialogBindingImpl.java */
/* renamed from: ȴ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2540 extends AbstractC2714 {

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9396 = null;

    /* renamed from: ނ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9397;

    /* renamed from: ހ, reason: contains not printable characters */
    public long f9398;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9397 = sparseIntArray;
        sparseIntArray.put(R.id.login_dialog_vp, 1);
        sparseIntArray.put(R.id.login_dialog_signin, 2);
        sparseIntArray.put(R.id.login_dialog_verify, 3);
        sparseIntArray.put(R.id.indicator_parent, 4);
        sparseIntArray.put(R.id.login_dialog_indicator1, 5);
        sparseIntArray.put(R.id.login_dialog_indicator2, 6);
        sparseIntArray.put(R.id.login_dialog_msg_tv, 7);
        sparseIntArray.put(R.id.login_dialog_bottom_view, 8);
        sparseIntArray.put(R.id.center_view, 9);
    }

    public C2540(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f9396, f9397));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9398 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9398 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9398 = 1L;
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

    public C2540(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[9], (RelativeLayout) objArr[0], (LinearLayout) objArr[4], (View) objArr[8], (ImageView) objArr[5], (ImageView) objArr[6], (TextView) objArr[7], (SignInView) objArr[2], (VerifyView) objArr[3], (LinearLayout) objArr[1]);
        this.f9398 = -1L;
        this.f10035.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
