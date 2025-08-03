package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutFpsSettingBindingImpl.java */
/* renamed from: ӥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3118 extends AbstractC4653 {

    /* renamed from: ވ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11077 = null;

    /* renamed from: މ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f11078;

    /* renamed from: ކ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f11079;

    /* renamed from: އ, reason: contains not printable characters */
    public long f11080;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11078 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.fps_setting_list, 3);
        sparseIntArray.put(R.id.fps_list_scroll, 4);
        sparseIntArray.put(R.id.fps_setting_auto_list, 5);
        sparseIntArray.put(R.id.fps_setting_info, 6);
        sparseIntArray.put(R.id.fps_setting_info_click, 7);
        sparseIntArray.put(R.id.list_area_view, 8);
        sparseIntArray.put(R.id.fps_switch_timelapse_tv, 9);
        sparseIntArray.put(R.id.fps_setting_switch, 10);
        sparseIntArray.put(R.id.fps_setting_timelapse, 11);
        sparseIntArray.put(R.id.fps_bottom_parent, 12);
        sparseIntArray.put(R.id.fps_setting_auto_switch_tv, 13);
        sparseIntArray.put(R.id.fps_setting_auto_switch, 14);
        sparseIntArray.put(R.id.fps_setting_auto_timelapse_title, 15);
        sparseIntArray.put(R.id.fps_setting_auto_timelapse, 16);
    }

    public C3118(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f11077, f11078));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f11080 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11080 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11080 = 1L;
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

    public C3118(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[2], (StrokeTextView) objArr[1], (ConstraintLayout) objArr[12], (HorizontalScrollView) objArr[4], (RecyclerView) objArr[5], (SwitchButton) objArr[14], (StrokeTextView) objArr[13], (FilmStopView) objArr[16], (StrokeTextView) objArr[15], (ImageView) objArr[6], (View) objArr[7], (RecyclerView) objArr[3], (SwitchButton) objArr[10], (FilmStopView) objArr[11], (StrokeTextView) objArr[9], (View) objArr[8]);
        this.f11080 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f11079 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
