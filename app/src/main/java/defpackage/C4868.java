package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextView2;
import com.blink.academy.film.widgets.cover.ModeScaleView;
import com.blink.academy.protake.R;

/* compiled from: LayoutModeHintDialogBindingImpl.java */
/* renamed from: ฉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4868 extends AbstractC4364 {

    /* renamed from: އ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16462 = null;

    /* renamed from: ވ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16463;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16464;

    /* renamed from: ކ, reason: contains not printable characters */
    public long f16465;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16463 = sparseIntArray;
        sparseIntArray.put(R.id.hint_dialog_area, 1);
        sparseIntArray.put(R.id.tv_parent, 2);
        sparseIntArray.put(R.id.rv_close, 3);
        sparseIntArray.put(R.id.hint_dialog_close, 4);
        sparseIntArray.put(R.id.hint_dialog_close_iv, 5);
        sparseIntArray.put(R.id.hint_dialog_title, 6);
        sparseIntArray.put(R.id.hint_dialog_content, 7);
        sparseIntArray.put(R.id.circle_parent, 8);
        sparseIntArray.put(R.id.hint_circle_parent, 9);
        sparseIntArray.put(R.id.hint_scale_view, 10);
        sparseIntArray.put(R.id.hint_bg_view, 11);
        sparseIntArray.put(R.id.pro_parent, 12);
        sparseIntArray.put(R.id.pro_indicator_parent, 13);
        sparseIntArray.put(R.id.hint_dialog_pro, 14);
        sparseIntArray.put(R.id.close_area, 15);
    }

    public C4868(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f16462, f16463));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16465 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16465 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16465 = 1L;
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

    public C4868(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[8], (View) objArr[15], (ModeScaleView) objArr[11], (RelativeLayout) objArr[9], (View) objArr[1], (StrokeTextView) objArr[4], (ImageView) objArr[5], (StrokeTextView2) objArr[7], (ImageView) objArr[14], (StrokeTextView) objArr[6], (ModeScaleView) objArr[10], (LinearLayout) objArr[13], (LinearLayout) objArr[12], (RelativeLayout) objArr[3], (RelativeLayout) objArr[2]);
        this.f16465 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f16464 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
