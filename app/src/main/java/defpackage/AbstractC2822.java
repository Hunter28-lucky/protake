package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.protake.R;

/* compiled from: LayoutRecordContainerBinding.java */
/* renamed from: μ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2822 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f10289;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ViewPager f10290;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f10291;

    public AbstractC2822(Object obj, View view, int i, LinearLayout linearLayout, ViewPager viewPager, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f10289 = linearLayout;
        this.f10290 = viewPager;
        this.f10291 = relativeLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC2822 m10165(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10166(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC2822 m10166(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC2822) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_record_container, viewGroup, z, obj);
    }
}
