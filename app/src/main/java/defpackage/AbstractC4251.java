package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.BottomBlockView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutStrokeBottomBinding.java */
/* renamed from: ਜ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4251 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final BottomBlockView f14581;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14582;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14583;

    public AbstractC4251(Object obj, View view, int i, BottomBlockView bottomBlockView, ImageView imageView, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f14581 = bottomBlockView;
        this.f14582 = imageView;
        this.f14583 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4251 m13363(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13364(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4251 m13364(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4251) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_stroke_bottom, viewGroup, z, obj);
    }
}
