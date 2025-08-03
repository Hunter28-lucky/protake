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

/* compiled from: LayoutAccessoriesContainerBinding.java */
/* renamed from: ӓ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3107 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f11057;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ViewPager f11058;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f11059;

    public AbstractC3107(Object obj, View view, int i, LinearLayout linearLayout, ViewPager viewPager, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f11057 = linearLayout;
        this.f11058 = viewPager;
        this.f11059 = relativeLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3107 m10695(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10696(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3107 m10696(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3107) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_accessories_container, viewGroup, z, obj);
    }
}
