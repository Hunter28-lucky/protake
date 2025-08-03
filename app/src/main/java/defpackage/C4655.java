package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutShutterViewBindingImpl.java */
/* renamed from: ಶ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4655 extends AbstractC3640 {

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15846 = null;

    /* renamed from: ވ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15847;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15848;

    /* renamed from: ކ, reason: contains not printable characters */
    public long f15849;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15847 = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 1);
        sparseIntArray.put(R.id.cl_content, 2);
        sparseIntArray.put(R.id.tv_auto_exposure, 3);
        sparseIntArray.put(R.id.sb_auto_exposure, 4);
        sparseIntArray.put(R.id.stop_view, 5);
        sparseIntArray.put(R.id.stop_opener, 6);
        sparseIntArray.put(R.id.stop_speed, 7);
        sparseIntArray.put(R.id.sb_parent, 8);
        sparseIntArray.put(R.id.sb_angel, 9);
        sparseIntArray.put(R.id.sb_speed, 10);
        sparseIntArray.put(R.id.rv_parent, 11);
        sparseIntArray.put(R.id.rv_angel, 12);
        sparseIntArray.put(R.id.rv_speed, 13);
        sparseIntArray.put(R.id.tv_angel, 14);
        sparseIntArray.put(R.id.tv_speed, 15);
    }

    public C4655(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f15846, f15847));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15849 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15849 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15849 = 1L;
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

    public C4655(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[2], (RecyclerView) objArr[12], (FrameLayout) objArr[11], (RecyclerView) objArr[13], (FilmSeekBar) objArr[9], (SwitchButton) objArr[4], (FrameLayout) objArr[8], (FilmSeekBar) objArr[10], (FilmStopView) objArr[6], (FilmStopView) objArr[7], (FrameLayout) objArr[5], (StrokeTextViewWithBottomBlock) objArr[14], (StrokeTextView) objArr[3], (StrokeTextViewWithBottomBlock) objArr[15], (StrokeTextView) objArr[1]);
        this.f15849 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f15848 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
