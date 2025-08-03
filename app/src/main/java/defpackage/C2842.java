package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.protake.R;

/* compiled from: LayoutPresetSettingBindingImpl.java */
/* renamed from: ϛ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2842 extends AbstractC4289 {

    /* renamed from: ޅ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10321 = null;

    /* renamed from: ކ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f10322;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f10323;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f10324;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10322 = sparseIntArray;
        sparseIntArray.put(R.id.pager, 1);
        sparseIntArray.put(R.id.rl_indicator, 2);
        sparseIntArray.put(R.id.indicator_container, 3);
        sparseIntArray.put(R.id.rl_empty_parent, 4);
        sparseIntArray.put(R.id.tv_empty, 5);
        sparseIntArray.put(R.id.iv_pre, 6);
        sparseIntArray.put(R.id.iv_next, 7);
        sparseIntArray.put(R.id.next_click, 8);
        sparseIntArray.put(R.id.pre_click, 9);
        sparseIntArray.put(R.id.rl_add, 10);
        sparseIntArray.put(R.id.rl_scan, 11);
        sparseIntArray.put(R.id.iv_scan, 12);
        sparseIntArray.put(R.id.iv_add, 13);
    }

    public C2842(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f10321, f10322));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f10324 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10324 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10324 = 1L;
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

    public C2842(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (ImageView) objArr[13], (ImageView) objArr[7], (ImageView) objArr[6], (ImageView) objArr[12], (View) objArr[8], (ViewPager) objArr[1], (View) objArr[9], (RelativeLayout) objArr[10], (RelativeLayout) objArr[4], (RelativeLayout) objArr[2], (RelativeLayout) objArr[11], (TextView) objArr[5]);
        this.f10324 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f10323 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
