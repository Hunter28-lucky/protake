package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.looks.StyleDownloadingView;
import com.blink.academy.film.widgets.looks.StyleUpdateView;
import com.blink.academy.protake.R;

/* compiled from: LayoutLooksPortraitPreviewBindingImpl.java */
/* renamed from: ଳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4435 extends AbstractC4281 {

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15280 = null;

    /* renamed from: ނ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15281;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15282;

    /* renamed from: ހ, reason: contains not printable characters */
    public long f15283;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15281 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.bottom_options, 3);
        sparseIntArray.put(R.id.tv_groups, 4);
        sparseIntArray.put(R.id.tv_groups_move, 5);
        sparseIntArray.put(R.id.looks_preview_list, 6);
        sparseIntArray.put(R.id.looks_download, 7);
        sparseIntArray.put(R.id.looks_update, 8);
        sparseIntArray.put(R.id.v_update_area, 9);
    }

    public C4435(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f15280, f15281));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15283 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15283 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15283 = 1L;
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

    public C4435(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (RelativeLayout) objArr[3], (StrokeTextView) objArr[1], (StyleDownloadingView) objArr[7], (RecyclerView) objArr[6], (StyleUpdateView) objArr[8], (StrokeTextView) objArr[4], (StrokeTextView) objArr[5], (View) objArr[9]);
        this.f15283 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f15282 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
