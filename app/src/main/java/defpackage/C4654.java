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
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutWbSettingBindingImpl.java */
/* renamed from: ವ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4654 extends AbstractC4134 {

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15842 = null;

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15843;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15844;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f15845;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15843 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.wb_setting_list, 3);
        sparseIntArray.put(R.id.bottom_options, 4);
        sparseIntArray.put(R.id.seek_bar_parent, 5);
        sparseIntArray.put(R.id.wb_setting_sb, 6);
        sparseIntArray.put(R.id.center_parent, 7);
        sparseIntArray.put(R.id.rv_mode_area, 8);
        sparseIntArray.put(R.id.tv_wb_mode, 9);
        sparseIntArray.put(R.id.wb_setting_stop, 10);
        sparseIntArray.put(R.id.wb_setting_tv_tint, 11);
        sparseIntArray.put(R.id.wb_setting_tint, 12);
        sparseIntArray.put(R.id.bottom_area, 13);
    }

    public C4654(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f15842, f15843));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15845 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15845 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15845 = 1L;
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

    public C4654(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[13], (LinearLayout) objArr[2], (RelativeLayout) objArr[4], (StrokeTextView) objArr[1], (RelativeLayout) objArr[7], (RelativeLayout) objArr[8], (RelativeLayout) objArr[5], (StrokeTextView) objArr[9], (RecyclerView) objArr[3], (FilmSeekBar) objArr[6], (FilmStopView) objArr[10], (FilmStopView) objArr[12], (StrokeTextView) objArr[11]);
        this.f15845 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f15844 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
