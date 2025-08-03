package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.transmit.TransmitButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutTransmitViewBindingImpl.java */
/* renamed from: ค, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4863 extends AbstractC3516 {

    /* renamed from: މ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f16455 = null;

    /* renamed from: ފ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f16456;

    /* renamed from: އ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16457;

    /* renamed from: ވ, reason: contains not printable characters */
    public long f16458;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16456 = sparseIntArray;
        sparseIntArray.put(R.id.root_parent, 1);
        sparseIntArray.put(R.id.view_bottom, 2);
        sparseIntArray.put(R.id.root, 3);
        sparseIntArray.put(R.id.ll_top, 4);
        sparseIntArray.put(R.id.top_title, 5);
        sparseIntArray.put(R.id.close_iv, 6);
        sparseIntArray.put(R.id.close, 7);
        sparseIntArray.put(R.id.rl_indicator, 8);
        sparseIntArray.put(R.id.indicator_container, 9);
        sparseIntArray.put(R.id.pager_parent, 10);
        sparseIntArray.put(R.id.pager, 11);
        sparseIntArray.put(R.id.transmit_wifi_info, 12);
        sparseIntArray.put(R.id.transmit_button_parent, 13);
        sparseIntArray.put(R.id.transmit_button_normal, 14);
        sparseIntArray.put(R.id.transmit_button_started, 15);
        sparseIntArray.put(R.id.hint_dialog, 16);
        sparseIntArray.put(R.id.root_cover, 17);
    }

    public C4863(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, f16455, f16456));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f16458 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16458 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16458 = 1L;
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

    public C4863(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[7], (ImageView) objArr[6], (SettingHintDialog) objArr[16], (LinearLayout) objArr[9], (LinearLayout) objArr[4], (ViewPager) objArr[11], (RelativeLayout) objArr[10], (RelativeLayout) objArr[8], (LinearLayout) objArr[3], (View) objArr[17], (ConstraintLayout) objArr[1], (TextView) objArr[5], (TransmitButton) objArr[14], (ConstraintLayout) objArr[13], (TransmitButton) objArr[15], (StrokeTextView) objArr[12], (View) objArr[2]);
        this.f16458 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f16457 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
