package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.protake.R;

/* compiled from: LayoutPresetSettingBinding.java */
/* renamed from: ੲ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4289 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f14691;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14692;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14693;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14694;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14695;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final View f14696;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ViewPager f14697;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final View f14698;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14699;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14700;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14701;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14702;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final TextView f14703;

    public AbstractC4289(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view2, ViewPager viewPager, View view3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView) {
        super(obj, view, i);
        this.f14691 = linearLayout;
        this.f14692 = imageView;
        this.f14693 = imageView2;
        this.f14694 = imageView3;
        this.f14695 = imageView4;
        this.f14696 = view2;
        this.f14697 = viewPager;
        this.f14698 = view3;
        this.f14699 = relativeLayout;
        this.f14700 = relativeLayout2;
        this.f14701 = relativeLayout3;
        this.f14702 = relativeLayout4;
        this.f14703 = textView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4289 m13401(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13402(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4289 m13402(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4289) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_preset_setting, viewGroup, z, obj);
    }
}
