package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.FilmTextView;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.film.widgets.score.ScaleRatingBar;
import com.blink.academy.protake.R;

/* compiled from: LayoutMarketScoreBinding.java */
/* renamed from: ݺ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3771 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RoundButton f13012;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final FilmTextView f13013;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final FilmTextView f13014;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final FilmTextView f13015;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final View f13016;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ScaleRatingBar f13017;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final FilmTextView f13018;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13019;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f13020;

    public AbstractC3771(Object obj, View view, int i, RoundButton roundButton, FilmTextView filmTextView, FilmTextView filmTextView2, FilmTextView filmTextView3, View view2, ScaleRatingBar scaleRatingBar, FilmTextView filmTextView4, ConstraintLayout constraintLayout, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f13012 = roundButton;
        this.f13013 = filmTextView;
        this.f13014 = filmTextView2;
        this.f13015 = filmTextView3;
        this.f13016 = view2;
        this.f13017 = scaleRatingBar;
        this.f13018 = filmTextView4;
        this.f13019 = constraintLayout;
        this.f13020 = linearLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3771 m12074(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m12075(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3771 m12075(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3771) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_market_score, viewGroup, z, obj);
    }
}
