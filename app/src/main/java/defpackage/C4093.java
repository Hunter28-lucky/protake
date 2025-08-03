package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
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

/* compiled from: LayoutShutterPortraitViewBindingImpl.java */
/* renamed from: ल, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4093 extends AbstractC5095 {

    /* renamed from: މ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14230 = null;

    /* renamed from: ފ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14231;

    /* renamed from: އ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f14232;

    /* renamed from: ވ, reason: contains not printable characters */
    public long f14233;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14231 = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 1);
        sparseIntArray.put(R.id.cl_content, 2);
        sparseIntArray.put(R.id.top_parent, 3);
        sparseIntArray.put(R.id.tv_auto_exposure, 4);
        sparseIntArray.put(R.id.sb_auto_exposure, 5);
        sparseIntArray.put(R.id.tv_angel, 6);
        sparseIntArray.put(R.id.tv_speed, 7);
        sparseIntArray.put(R.id.center_scroll, 8);
        sparseIntArray.put(R.id.stop_view, 9);
        sparseIntArray.put(R.id.stop_opener, 10);
        sparseIntArray.put(R.id.stop_speed, 11);
        sparseIntArray.put(R.id.rv_parent, 12);
        sparseIntArray.put(R.id.rv_angel, 13);
        sparseIntArray.put(R.id.rv_speed, 14);
        sparseIntArray.put(R.id.sb_parent, 15);
        sparseIntArray.put(R.id.sb_angel, 16);
        sparseIntArray.put(R.id.sb_speed, 17);
    }

    public C4093(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, f14230, f14231));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14233 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14233 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14233 = 1L;
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

    public C4093(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (HorizontalScrollView) objArr[8], (ConstraintLayout) objArr[2], (RecyclerView) objArr[13], (FrameLayout) objArr[12], (RecyclerView) objArr[14], (FilmSeekBar) objArr[16], (SwitchButton) objArr[5], (FrameLayout) objArr[15], (FilmSeekBar) objArr[17], (FilmStopView) objArr[10], (FilmStopView) objArr[11], (FrameLayout) objArr[9], (ConstraintLayout) objArr[3], (StrokeTextViewWithBottomBlock) objArr[6], (StrokeTextView) objArr[4], (StrokeTextViewWithBottomBlock) objArr[7], (StrokeTextView) objArr[1]);
        this.f14233 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14232 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
