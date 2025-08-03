package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.transmit.InputPwdView;
import com.blink.academy.protake.R;

/* compiled from: LayoutCloudConnectBindingImpl.java */
/* renamed from: ଵ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4436 extends AbstractC2802 {

    /* renamed from: ލ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15284 = null;

    /* renamed from: ގ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15285;

    /* renamed from: ތ, reason: contains not printable characters */
    public long f15286;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15285 = sparseIntArray;
        sparseIntArray.put(R.id.content_view, 1);
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.input_pwd_view, 3);
        sparseIntArray.put(R.id.tv_unit_title, 4);
        sparseIntArray.put(R.id.unit_parent, 5);
        sparseIntArray.put(R.id.camera_unit_a, 6);
        sparseIntArray.put(R.id.camera_unit_b, 7);
        sparseIntArray.put(R.id.camera_unit_c, 8);
        sparseIntArray.put(R.id.camera_unit_d, 9);
        sparseIntArray.put(R.id.connect_parent, 10);
        sparseIntArray.put(R.id.tv_num, 11);
        sparseIntArray.put(R.id.con_dis, 12);
        sparseIntArray.put(R.id.loading_progress, 13);
        sparseIntArray.put(R.id.msg_tv, 14);
        sparseIntArray.put(R.id.msg, 15);
        sparseIntArray.put(R.id.iv_close, 16);
        sparseIntArray.put(R.id.close_iv, 17);
        sparseIntArray.put(R.id.expend_parent, 18);
        sparseIntArray.put(R.id.tv_time, 19);
        sparseIntArray.put(R.id.fl_extend, 20);
        sparseIntArray.put(R.id.tv_extend, 21);
    }

    public C4436(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 22, f15284, f15285));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15286 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15286 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15286 = 1L;
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

    public C4436(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (StrokeTextViewWithBottomBlock) objArr[6], (StrokeTextViewWithBottomBlock) objArr[7], (StrokeTextViewWithBottomBlock) objArr[8], (StrokeTextViewWithBottomBlock) objArr[9], (ImageView) objArr[17], (View) objArr[12], (RelativeLayout) objArr[10], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[18], (FrameLayout) objArr[20], (InputPwdView) objArr[3], (RelativeLayout) objArr[16], (OneTakeProgressBar) objArr[13], (TextView) objArr[15], (CardView) objArr[14], (ConstraintLayout) objArr[0], (TextView) objArr[21], (TextView) objArr[11], (StrokeTextView) objArr[19], (StrokeTextView) objArr[2], (StrokeTextView) objArr[4], (ConstraintLayout) objArr[5]);
        this.f15286 = -1L;
        this.f10226.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
