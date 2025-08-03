package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.SwitchButton2;
import com.blink.academy.protake.R;

/* compiled from: LayoutAccessoriesViewBindingImpl.java */
/* renamed from: ഗ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4700 extends AbstractC3702 {

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15954 = null;

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15955;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15956;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f15957;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15955 = sparseIntArray;
        sparseIntArray.put(R.id.rl_zhiyun, 1);
        sparseIntArray.put(R.id.tv_zhiyun, 2);
        sparseIntArray.put(R.id.sb_zhiyun, 3);
        sparseIntArray.put(R.id.pb_zhiyun, 4);
        sparseIntArray.put(R.id.v_line_0, 5);
        sparseIntArray.put(R.id.rl_anamo, 6);
        sparseIntArray.put(R.id.tv_anamo, 7);
        sparseIntArray.put(R.id.sb_anamo, 8);
        sparseIntArray.put(R.id.v_line_1, 9);
        sparseIntArray.put(R.id.rl_1_55, 10);
        sparseIntArray.put(R.id.tv_1_55, 11);
        sparseIntArray.put(R.id.sb_1_55, 12);
        sparseIntArray.put(R.id.v_line_2, 13);
    }

    public C4700(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f15954, f15955));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15957 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15957 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15957 = 1L;
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

    public C4700(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (OneTakeProgressBar) objArr[4], (RelativeLayout) objArr[10], (RelativeLayout) objArr[6], (RelativeLayout) objArr[1], (SwitchButton) objArr[12], (SwitchButton) objArr[8], (SwitchButton2) objArr[3], (TextView) objArr[11], (TextView) objArr[7], (TextView) objArr[2], (View) objArr[5], (View) objArr[9], (View) objArr[13]);
        this.f15957 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f15956 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
