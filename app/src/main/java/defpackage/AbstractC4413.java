package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.protake.R;

/* compiled from: FragmentWebPrivacyBinding.java */
/* renamed from: ଠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4413 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15200;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final OneTakeProgressBar f15201;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f15202;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f15203;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final CardView f15204;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15205;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f15206;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final TextView f15207;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final TextView f15208;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final View f15209;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final View f15210;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final WebView f15211;

    public AbstractC4413(Object obj, View view, int i, RelativeLayout relativeLayout, OneTakeProgressBar oneTakeProgressBar, ImageView imageView, ImageView imageView2, CardView cardView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, View view2, View view3, WebView webView) {
        super(obj, view, i);
        this.f15200 = relativeLayout;
        this.f15201 = oneTakeProgressBar;
        this.f15202 = imageView;
        this.f15203 = imageView2;
        this.f15204 = cardView;
        this.f15205 = constraintLayout;
        this.f15206 = constraintLayout2;
        this.f15207 = textView;
        this.f15208 = textView2;
        this.f15209 = view2;
        this.f15210 = view3;
        this.f15211 = webView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4413 m13610(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13611(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4413 m13611(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4413) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_web_privacy, viewGroup, z, obj);
    }
}
