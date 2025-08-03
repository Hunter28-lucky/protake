package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.iso.portrait.FadingEdgeLayout;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitWheelProgressBindingImpl.java */
/* renamed from: ਣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4260 extends AbstractC3611 {

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14611 = null;

    /* renamed from: ֏, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14612;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f14613;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f14614;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14612 = sparseIntArray;
        sparseIntArray.put(R.id.card, 1);
        sparseIntArray.put(R.id.fd, 2);
        sparseIntArray.put(R.id.ruler_parent, 3);
        sparseIntArray.put(R.id.iv_ruler, 4);
    }

    public C4260(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f14611, f14612));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14614 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14614 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14614 = 1L;
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

    public C4260(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[1], (FadingEdgeLayout) objArr[2], (ImageView) objArr[4], (LinearLayout) objArr[3]);
        this.f14614 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f14613 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
