package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.iso.portrait.FadingEdgeLayout;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitWheelProgressBinding.java */
/* renamed from: ڹ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3611 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final CardView f12549;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final FadingEdgeLayout f12550;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12551;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f12552;

    public AbstractC3611(Object obj, View view, int i, CardView cardView, FadingEdgeLayout fadingEdgeLayout, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f12549 = cardView;
        this.f12550 = fadingEdgeLayout;
        this.f12551 = imageView;
        this.f12552 = linearLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3611 m11667(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11668(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3611 m11668(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3611) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_portrait_wheel_progress, viewGroup, z, obj);
    }
}
