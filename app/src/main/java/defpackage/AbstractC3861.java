package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.FilmTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPayProductViewBinding.java */
/* renamed from: ߡ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3861 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f13267;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f13268;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final View f13269;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final View f13270;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final AbstractC3819 f13271;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final AbstractC3819 f13272;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final AbstractC3819 f13273;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f13274;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13275;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final FilmTextView f13276;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final TextView f13277;

    public AbstractC3861(Object obj, View view, int i, ImageView imageView, ImageView imageView2, View view2, View view3, AbstractC3819 abstractC3819, AbstractC3819 abstractC38192, AbstractC3819 abstractC38193, LinearLayout linearLayout, ConstraintLayout constraintLayout, FilmTextView filmTextView, TextView textView) {
        super(obj, view, i);
        this.f13267 = imageView;
        this.f13268 = imageView2;
        this.f13269 = view2;
        this.f13270 = view3;
        this.f13271 = abstractC3819;
        this.f13272 = abstractC38192;
        this.f13273 = abstractC38193;
        this.f13274 = linearLayout;
        this.f13275 = constraintLayout;
        this.f13276 = filmTextView;
        this.f13277 = textView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3861 m12297(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m12298(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3861 m12298(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3861) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_pay_product_view, viewGroup, z, obj);
    }
}
