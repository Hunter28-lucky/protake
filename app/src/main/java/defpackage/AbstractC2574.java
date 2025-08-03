package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutFilmStopViewBinding.java */
/* renamed from: ɕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2574 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f9578;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f9579;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final View f9580;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final View f9581;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f9582;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f9583;

    public AbstractC2574(Object obj, View view, int i, ImageView imageView, ImageView imageView2, View view2, View view3, StrokeTextView strokeTextView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f9578 = imageView;
        this.f9579 = imageView2;
        this.f9580 = view2;
        this.f9581 = view3;
        this.f9582 = strokeTextView;
        this.f9583 = relativeLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC2574 m9429(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m9430(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC2574 m9430(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC2574) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_film_stop_view, viewGroup, z, obj);
    }
}
