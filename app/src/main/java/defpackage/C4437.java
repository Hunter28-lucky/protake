package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutRecordSetting2BindingImpl.java */
/* renamed from: ଶ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4437 extends AbstractC5308 {

    /* renamed from: ރ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15287 = null;

    /* renamed from: ބ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15288;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15289;

    /* renamed from: ނ, reason: contains not printable characters */
    public long f15290;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15288 = sparseIntArray;
        sparseIntArray.put(R.id.tv_hdmi_performance, 1);
        sparseIntArray.put(R.id.sb_performance, 2);
        sparseIntArray.put(R.id.iv_performance_info, 3);
        sparseIntArray.put(R.id.v_performance_area, 4);
        sparseIntArray.put(R.id.tv_vertical_video, 5);
        sparseIntArray.put(R.id.sb_vertical_video, 6);
        sparseIntArray.put(R.id.tv_flicker, 7);
        sparseIntArray.put(R.id.flicker_50, 8);
        sparseIntArray.put(R.id.flicker_60, 9);
        sparseIntArray.put(R.id.tv_mirror_selfie_record, 10);
        sparseIntArray.put(R.id.sb_mirror_slefie_record, 11);
    }

    public C4437(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f15287, f15288));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15290 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15290 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15290 = 1L;
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

    public C4437(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (StrokeTextViewWithBottomBlock) objArr[8], (StrokeTextViewWithBottomBlock) objArr[9], (ImageView) objArr[3], (SwitchButton) objArr[11], (SwitchButton) objArr[2], (SwitchButton) objArr[6], (StrokeTextView) objArr[7], (StrokeTextView) objArr[1], (StrokeTextView) objArr[10], (StrokeTextView) objArr[5], (View) objArr[4]);
        this.f15290 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f15289 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
