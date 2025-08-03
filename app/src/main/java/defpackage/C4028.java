package defpackage;

import android.util.SparseIntArray;
import android.view.View;
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

/* compiled from: LayoutFpsPortraitSettingBindingImpl.java */
/* renamed from: ई, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4028 extends AbstractC4917 {

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13984 = null;

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13985;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13986;

    /* renamed from: ؠ, reason: contains not printable characters */
    public long f13987;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13985 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.fps_setting_auto_list, 3);
        sparseIntArray.put(R.id.fps_bottom_parent, 4);
        sparseIntArray.put(R.id.fps_setting_auto_switch_tv, 5);
        sparseIntArray.put(R.id.fps_setting_auto_switch, 6);
        sparseIntArray.put(R.id.fps_setting_auto_timelapse_title, 7);
        sparseIntArray.put(R.id.fps_setting_auto_timelapse, 8);
    }

    public C4028(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f13984, f13985));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13987 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13987 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13987 = 1L;
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

    public C4028(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[2], (StrokeTextView) objArr[1], (ConstraintLayout) objArr[4], (RecyclerView) objArr[3], (SwitchButton) objArr[6], (StrokeTextView) objArr[5], (FilmStopView) objArr[8], (StrokeTextView) objArr[7]);
        this.f13987 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13986 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
