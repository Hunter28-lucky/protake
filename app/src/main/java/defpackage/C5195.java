package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeCornerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutBeautyItemBindingImpl.java */
/* renamed from: Ⴂ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5195 extends AbstractC2517 {

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f17240 = null;

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f17241;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f17242;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f17243;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17241 = sparseIntArray;
        sparseIntArray.put(R.id.root_parent, 1);
        sparseIntArray.put(R.id.iv_beauty, 2);
        sparseIntArray.put(R.id.tv_beauty, 3);
        sparseIntArray.put(R.id.level_parent, 4);
        sparseIntArray.put(R.id.tv_level, 5);
    }

    public C5195(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f17240, f17241));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f17243 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17243 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17243 = 1L;
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

    public C5195(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (RelativeLayout) objArr[4], (RelativeLayout) objArr[1], (StrokeTextView) objArr[3], (StrokeCornerView) objArr[5]);
        this.f17243 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f17242 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
