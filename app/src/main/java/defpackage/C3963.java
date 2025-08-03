package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.stream.secondscreen.SecondScreenTextureView;
import com.blink.academy.film.widgets.GuideView;
import com.blink.academy.protake.R;

/* compiled from: ActivitySecondDisplayBindingImpl.java */
/* renamed from: ࡪ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3963 extends AbstractC3962 {

    /* renamed from: ՠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13790 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13791;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13792;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f13793;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13791 = sparseIntArray;
        sparseIntArray.put(R.id.content_container, 1);
        sparseIntArray.put(R.id.draw_view, 2);
        sparseIntArray.put(R.id.home_guide, 3);
    }

    public C3963(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13790, f13791));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13793 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13793 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13793 = 1L;
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

    public C3963(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[1], (SecondScreenTextureView) objArr[2], (GuideView) objArr[3]);
        this.f13793 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13792 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
