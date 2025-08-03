package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: FragmentLocalPrivacyBinding.java */
/* renamed from: ઇ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4304 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14741;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14742;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14743;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final CardView f14744;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f14745;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f14746;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final TextView f14747;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final TextView f14748;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final TextView f14749;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final View f14750;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final View f14751;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final LinearLayoutCompat f14752;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final TextView f14753;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final TextView f14754;

    public AbstractC4304(Object obj, View view, int i, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, CardView cardView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, View view2, View view3, LinearLayoutCompat linearLayoutCompat, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.f14741 = relativeLayout;
        this.f14742 = imageView;
        this.f14743 = imageView2;
        this.f14744 = cardView;
        this.f14745 = constraintLayout;
        this.f14746 = constraintLayout2;
        this.f14747 = textView;
        this.f14748 = textView2;
        this.f14749 = textView3;
        this.f14750 = view2;
        this.f14751 = view3;
        this.f14752 = linearLayoutCompat;
        this.f14753 = textView4;
        this.f14754 = textView5;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4304 m13423(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13424(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4304 m13424(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4304) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_local_privacy, viewGroup, z, obj);
    }
}
