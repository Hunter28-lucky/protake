package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.iso.ZoomButtonView;
import com.blink.academy.protake.R;

/* compiled from: LayoutZoomButtonBindingImpl.java */
/* renamed from: Ⴏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5212 extends AbstractC5218 {

    /* renamed from: ބ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f17267 = null;

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f17268;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f17269;

    /* renamed from: ރ, reason: contains not printable characters */
    public long f17270;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17268 = sparseIntArray;
        sparseIntArray.put(R.id.rl_s2x, 1);
        sparseIntArray.put(R.id.bt_s2x_un, 2);
        sparseIntArray.put(R.id.bt_s2x_sel, 3);
        sparseIntArray.put(R.id.rl_2x, 4);
        sparseIntArray.put(R.id.bt_2x_un, 5);
        sparseIntArray.put(R.id.bt_2x_sel, 6);
        sparseIntArray.put(R.id.rl_1x, 7);
        sparseIntArray.put(R.id.bt_1x_un, 8);
        sparseIntArray.put(R.id.bt_1x_sel, 9);
        sparseIntArray.put(R.id.rl_halfx, 10);
        sparseIntArray.put(R.id.bt_half_un, 11);
        sparseIntArray.put(R.id.bt_half_sel, 12);
    }

    public C5212(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f17267, f17268));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f17270 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17270 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17270 = 1L;
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

    public C5212(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ZoomButtonView) objArr[9], (ZoomButtonView) objArr[8], (ZoomButtonView) objArr[6], (ZoomButtonView) objArr[5], (ZoomButtonView) objArr[12], (ZoomButtonView) objArr[11], (ZoomButtonView) objArr[3], (ZoomButtonView) objArr[2], (RelativeLayout) objArr[7], (RelativeLayout) objArr[4], (RelativeLayout) objArr[10], (RelativeLayout) objArr[1]);
        this.f17270 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f17269 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
