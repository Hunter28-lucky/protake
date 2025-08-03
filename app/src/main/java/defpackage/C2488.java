package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutDataSettingBindingImpl.java */
/* renamed from: ǡ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2488 extends AbstractC4141 {

    /* renamed from: ފ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9184 = null;

    /* renamed from: ދ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f9185;

    /* renamed from: ވ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f9186;

    /* renamed from: މ, reason: contains not printable characters */
    public long f9187;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9185 = sparseIntArray;
        sparseIntArray.put(R.id.tv_camera_unit, 1);
        sparseIntArray.put(R.id.stop_camera_unit, 2);
        sparseIntArray.put(R.id.tv_reel_number, 3);
        sparseIntArray.put(R.id.stop_reel_number, 4);
        sparseIntArray.put(R.id.tv_clip_count, 5);
        sparseIntArray.put(R.id.tv_clicp_number, 6);
        sparseIntArray.put(R.id.tv_suffix, 7);
        sparseIntArray.put(R.id.tv_suffix_name, 8);
        sparseIntArray.put(R.id.fl_reset, 9);
        sparseIntArray.put(R.id.tv_reset, 10);
        sparseIntArray.put(R.id.reset_click, 11);
        sparseIntArray.put(R.id.format_cl, 12);
        sparseIntArray.put(R.id.tv_format, 13);
        sparseIntArray.put(R.id.format_264, 14);
        sparseIntArray.put(R.id.format_265, 15);
        sparseIntArray.put(R.id.ll_location, 16);
        sparseIntArray.put(R.id.tv_location, 17);
        sparseIntArray.put(R.id.sb_location, 18);
    }

    public C2488(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, f9184, f9185));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9187 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9187 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9187 = 1L;
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

    public C2488(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[9], (StrokeTextViewWithBottomBlock) objArr[14], (StrokeTextViewWithBottomBlock) objArr[15], (ConstraintLayout) objArr[12], (LinearLayout) objArr[16], (View) objArr[11], (SwitchButton) objArr[18], (FilmStopView) objArr[2], (FilmStopView) objArr[4], (StrokeTextView) objArr[1], (StrokeTextView) objArr[6], (StrokeTextView) objArr[5], (StrokeTextView) objArr[13], (StrokeTextView) objArr[17], (StrokeTextView) objArr[3], (TextView) objArr[10], (StrokeTextView) objArr[7], (StrokeTextView) objArr[8]);
        this.f9187 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f9186 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
