package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.looks.FilmStopRecycleView;
import com.blink.academy.protake.R;

/* compiled from: LayoutGridsSettingBindingImpl.java */
/* renamed from: ܒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3654 extends AbstractC5311 {

    /* renamed from: ބ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12670 = null;

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f12671;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f12672;

    /* renamed from: ރ, reason: contains not printable characters */
    public long f12673;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12671 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.grids_type_list, 3);
        sparseIntArray.put(R.id.bottom_options, 4);
        sparseIntArray.put(R.id.grids_frame_list, 5);
        sparseIntArray.put(R.id.grids_options_list, 6);
        sparseIntArray.put(R.id.bottom_crop, 7);
        sparseIntArray.put(R.id.bottom_crop_tv, 8);
        sparseIntArray.put(R.id.grids_crop_switch, 9);
        sparseIntArray.put(R.id.bottom_safe, 10);
        sparseIntArray.put(R.id.bottom_safe_tv, 11);
        sparseIntArray.put(R.id.grids_safe_switch, 12);
    }

    public C3654(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f12670, f12671));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12673 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12673 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12673 = 1L;
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

    public C3654(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (LinearLayout) objArr[7], (StrokeTextView) objArr[8], (RelativeLayout) objArr[4], (LinearLayout) objArr[10], (StrokeTextView) objArr[11], (StrokeTextView) objArr[1], (SwitchButton) objArr[9], (FilmStopRecycleView) objArr[5], (RecyclerView) objArr[6], (SwitchButton) objArr[12], (RecyclerView) objArr[3]);
        this.f12673 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12672 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
