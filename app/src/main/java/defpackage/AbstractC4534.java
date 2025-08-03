package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutHintViewBinding.java */
/* renamed from: ఠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4534 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15513;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f15514;

    public AbstractC4534(Object obj, View view, int i, RelativeLayout relativeLayout, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f15513 = relativeLayout;
        this.f15514 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4534 m13878(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13879(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4534 m13879(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4534) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_hint_view, viewGroup, z, obj);
    }
}
