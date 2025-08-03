package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
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
import com.blink.academy.film.widgets.StrokeRoundView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutBeautySettingBindingImpl.java */
/* renamed from: ಕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4608 extends AbstractC2963 {

    /* renamed from: ލ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15704 = null;

    /* renamed from: ގ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15705;

    /* renamed from: ދ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15706;

    /* renamed from: ތ, reason: contains not printable characters */
    public long f15707;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15705 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.fl_reset, 2);
        sparseIntArray.put(R.id.stroke_round, 3);
        sparseIntArray.put(R.id.tv_reset, 4);
        sparseIntArray.put(R.id.looks_reset_view, 5);
        sparseIntArray.put(R.id.fl_reset_current, 6);
        sparseIntArray.put(R.id.stroke_round_current, 7);
        sparseIntArray.put(R.id.tv_reset_current, 8);
        sparseIntArray.put(R.id.beauty_reset_view, 9);
        sparseIntArray.put(R.id.bottom_container, 10);
        sparseIntArray.put(R.id.bottom_scroll_parent, 11);
        sparseIntArray.put(R.id.bottom_list_parent, 12);
        sparseIntArray.put(R.id.switch_beauty, 13);
        sparseIntArray.put(R.id.beauty_setting_list, 14);
        sparseIntArray.put(R.id.area_view, 15);
        sparseIntArray.put(R.id.bottom_sb_parent, 16);
        sparseIntArray.put(R.id.sb_beauty, 17);
        sparseIntArray.put(R.id.tv_cancel, 18);
        sparseIntArray.put(R.id.tv_confirm, 19);
        sparseIntArray.put(R.id.cancel_click_area, 20);
        sparseIntArray.put(R.id.confirm_click_area, 21);
    }

    public C4608(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 22, f15704, f15705));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15707 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15707 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15707 = 1L;
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

    public C4608(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[15], (View) objArr[9], (RecyclerView) objArr[14], (LinearLayout) objArr[10], (RelativeLayout) objArr[12], (ConstraintLayout) objArr[16], (HorizontalScrollView) objArr[11], (StrokeTextView) objArr[1], (View) objArr[20], (View) objArr[21], (RelativeLayout) objArr[2], (RelativeLayout) objArr[6], (View) objArr[5], (FilmSeekBar) objArr[17], (StrokeRoundView) objArr[3], (StrokeRoundView) objArr[7], (SwitchButton) objArr[13], (StrokeTextView) objArr[18], (StrokeTextView) objArr[19], (TextView) objArr[4], (TextView) objArr[8]);
        this.f15707 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f15706 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
