package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.stream.ACGLTextureView;
import com.blink.academy.film.support.face.ui.GraphicOverlay;
import com.blink.academy.protake.R;

/* compiled from: LayoutAcUnitViewBindingImpl.java */
/* renamed from: ۼ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3651 extends AbstractC4418 {

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12665 = null;

    /* renamed from: ނ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12666;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12667;

    /* renamed from: ހ, reason: contains not printable characters */
    public long f12668;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12666 = sparseIntArray;
        sparseIntArray.put(R.id.texture, 1);
        sparseIntArray.put(R.id.graphic_overlay, 2);
        sparseIntArray.put(R.id.bt_parent, 3);
        sparseIntArray.put(R.id.bt_a, 4);
        sparseIntArray.put(R.id.bt_b, 5);
        sparseIntArray.put(R.id.bt_c, 6);
        sparseIntArray.put(R.id.bt_d, 7);
        sparseIntArray.put(R.id.bt_clear, 8);
        sparseIntArray.put(R.id.tv_status, 9);
    }

    public C3651(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f12665, f12666));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12668 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12668 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12668 = 1L;
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

    public C3651(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[4], (Button) objArr[5], (Button) objArr[6], (Button) objArr[8], (Button) objArr[7], (LinearLayout) objArr[3], (GraphicOverlay) objArr[2], (ACGLTextureView) objArr[1], (TextView) objArr[9]);
        this.f12668 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f12667 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
