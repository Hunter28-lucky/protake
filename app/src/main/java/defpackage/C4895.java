package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeRoundView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.looks.FilmStopRecycleView;
import com.blink.academy.film.widgets.looks.StyleDownloadingView;
import com.blink.academy.film.widgets.looks.StyleUpdateView;
import com.blink.academy.protake.R;

/* compiled from: LayoutLooksSettingBindingImpl.java */
/* renamed from: น, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4895 extends AbstractC3153 {

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16531 = null;

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16532;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16533;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f16534;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16532 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.fl_reset, 2);
        sparseIntArray.put(R.id.stroke_round, 3);
        sparseIntArray.put(R.id.tv_reset, 4);
        sparseIntArray.put(R.id.looks_reset_view, 5);
        sparseIntArray.put(R.id.bottom_container, 6);
        sparseIntArray.put(R.id.looks_type_list, 7);
        sparseIntArray.put(R.id.bottom_options, 8);
        sparseIntArray.put(R.id.looks_update, 9);
        sparseIntArray.put(R.id.looks_stop_list, 10);
        sparseIntArray.put(R.id.looks_download, 11);
        sparseIntArray.put(R.id.looks_stop_view, 12);
        sparseIntArray.put(R.id.seek_bar_parent, 13);
        sparseIntArray.put(R.id.sb_looks, 14);
    }

    public C4895(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, f16531, f16532));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16534 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16534 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16534 = 1L;
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

    public C4895(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[6], (RelativeLayout) objArr[8], (StrokeTextView) objArr[1], (RelativeLayout) objArr[2], (StyleDownloadingView) objArr[11], (View) objArr[5], (FilmStopRecycleView) objArr[10], (FilmStopView) objArr[12], (RecyclerView) objArr[7], (StyleUpdateView) objArr[9], (FilmSeekBar) objArr[14], (RelativeLayout) objArr[13], (StrokeRoundView) objArr[3], (TextView) objArr[4]);
        this.f16534 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f16533 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
