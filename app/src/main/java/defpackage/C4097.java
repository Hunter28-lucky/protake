package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutIsoViewBindingImpl.java */
/* renamed from: श, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4097 extends AbstractC3669 {

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14234 = null;

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14235;

    /* renamed from: ؠ, reason: contains not printable characters */
    public long f14236;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14235 = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 1);
        sparseIntArray.put(R.id.cl_content, 2);
        sparseIntArray.put(R.id.top_parent, 3);
        sparseIntArray.put(R.id.tv_auto_exposure, 4);
        sparseIntArray.put(R.id.sb_auto_exposure, 5);
        sparseIntArray.put(R.id.film_stop_view, 6);
        sparseIntArray.put(R.id.sb_parent, 7);
        sparseIntArray.put(R.id.sb_iso, 8);
    }

    public C4097(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f14234, f14235));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14236 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14236 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14236 = 1L;
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

    public C4097(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[2], (FilmStopView) objArr[6], (ConstraintLayout) objArr[0], (SwitchButton) objArr[5], (FilmSeekBar) objArr[8], (ConstraintLayout) objArr[7], (ConstraintLayout) objArr[3], (StrokeTextView) objArr[4], (StrokeTextView) objArr[1]);
        this.f14236 = -1L;
        this.f12714.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
