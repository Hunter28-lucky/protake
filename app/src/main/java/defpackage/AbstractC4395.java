package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.protake.R;

/* compiled from: FragmentPrivacyBinding.java */
/* renamed from: ଌ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4395 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15114;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final View f15115;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final CardView f15116;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f15117;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f15118;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final OneTakeProgressBar f15119;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final TextView f15120;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final TextView f15121;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final TextView f15122;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final TextView f15123;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final TextView f15124;

    public AbstractC4395(Object obj, View view, int i, RelativeLayout relativeLayout, View view2, CardView cardView, LinearLayout linearLayout, LinearLayout linearLayout2, OneTakeProgressBar oneTakeProgressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.f15114 = relativeLayout;
        this.f15115 = view2;
        this.f15116 = cardView;
        this.f15117 = linearLayout;
        this.f15118 = linearLayout2;
        this.f15119 = oneTakeProgressBar;
        this.f15120 = textView;
        this.f15121 = textView2;
        this.f15122 = textView3;
        this.f15123 = textView4;
        this.f15124 = textView5;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4395 m13587(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13588(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4395 m13588(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4395) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_privacy, viewGroup, z, obj);
    }
}
