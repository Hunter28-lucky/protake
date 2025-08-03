package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutFilmStopViewBindingImpl.java */
/* renamed from: ŋ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2367 extends AbstractC2574 {

    /* renamed from: ׯ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8909 = null;

    /* renamed from: ؠ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f8910;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f8911;

    /* renamed from: ֏, reason: contains not printable characters */
    public long f8912;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8910 = sparseIntArray;
        sparseIntArray.put(R.id.iv_stop_pre, 1);
        sparseIntArray.put(R.id.tv_stop_parent, 2);
        sparseIntArray.put(R.id.tv_stop, 3);
        sparseIntArray.put(R.id.iv_stop_next, 4);
        sparseIntArray.put(R.id.pre_click, 5);
        sparseIntArray.put(R.id.next_click, 6);
    }

    public C2367(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f8909, f8910));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8912 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8912 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8912 = 1L;
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

    public C2367(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (ImageView) objArr[1], (View) objArr[6], (View) objArr[5], (StrokeTextView) objArr[3], (RelativeLayout) objArr[2]);
        this.f8912 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8911 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
