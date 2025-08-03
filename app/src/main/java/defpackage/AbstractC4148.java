package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutExtendBinding.java */
/* renamed from: ঔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4148 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f14374;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f14375;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final TextView f14376;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14377;

    public AbstractC4148(Object obj, View view, int i, ConstraintLayout constraintLayout, FrameLayout frameLayout, TextView textView, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f14374 = constraintLayout;
        this.f14375 = frameLayout;
        this.f14376 = textView;
        this.f14377 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4148 m13131(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13132(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4148 m13132(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4148) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_extend, viewGroup, z, obj);
    }
}
