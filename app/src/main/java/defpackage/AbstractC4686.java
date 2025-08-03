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
import com.blink.academy.film.widgets.BottomBlockView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutFpsAutoItemBinding.java */
/* renamed from: ഒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4686 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final BottomBlockView f15902;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f15903;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15904;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f15905;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f15906;

    public AbstractC4686(Object obj, View view, int i, BottomBlockView bottomBlockView, ImageView imageView, RelativeLayout relativeLayout, StrokeTextView strokeTextView, StrokeTextView strokeTextView2) {
        super(obj, view, i);
        this.f15902 = bottomBlockView;
        this.f15903 = imageView;
        this.f15904 = relativeLayout;
        this.f15905 = strokeTextView;
        this.f15906 = strokeTextView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4686 m14197(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14198(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4686 m14198(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4686) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_fps_auto_item, viewGroup, z, obj);
    }
}
