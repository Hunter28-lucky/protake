package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.BorderView;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.LooksMorePointView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.WhiteBorderView;
import com.blink.academy.film.widgets.looks.ScrollBackItem;
import com.blink.academy.protake.R;

/* compiled from: LayoutPreviewItemBindingImpl.java */
/* renamed from: ಏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4603 extends AbstractC4266 {

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15691 = null;

    /* renamed from: ވ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15692;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15693;

    /* renamed from: ކ, reason: contains not printable characters */
    public long f15694;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15692 = sparseIntArray;
        sparseIntArray.put(R.id.tv_groups, 1);
        sparseIntArray.put(R.id.root_parent, 2);
        sparseIntArray.put(R.id.strength_parent, 3);
        sparseIntArray.put(R.id.scroll_back, 4);
        sparseIntArray.put(R.id.sb_strength, 5);
        sparseIntArray.put(R.id.preview_iv_parent, 6);
        sparseIntArray.put(R.id.iv_preview, 7);
        sparseIntArray.put(R.id.iv_black_border, 8);
        sparseIntArray.put(R.id.iv_white_border, 9);
        sparseIntArray.put(R.id.iv_more, 10);
        sparseIntArray.put(R.id.cover_parent, 11);
        sparseIntArray.put(R.id.v_cover, 12);
        sparseIntArray.put(R.id.iv_preview_lock, 13);
        sparseIntArray.put(R.id.tv_preview, 14);
        sparseIntArray.put(R.id.tv_strength, 15);
    }

    public C4603(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f15691, f15692));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15694 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15694 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15694 = 1L;
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

    public C4603(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[11], (BorderView) objArr[8], (LooksMorePointView) objArr[10], (ImageView) objArr[7], (ImageView) objArr[13], (WhiteBorderView) objArr[9], (RelativeLayout) objArr[6], (RelativeLayout) objArr[2], (FilmSeekBar) objArr[5], (ScrollBackItem) objArr[4], (RelativeLayout) objArr[3], (StrokeTextView) objArr[1], (StrokeTextView) objArr[14], (StrokeTextView) objArr[15], (View) objArr[12]);
        this.f15694 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f15693 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
