package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.CircleStrokeView;
import com.blink.academy.protake.R;

/* compiled from: LayoutRecordBtBinding.java */
/* renamed from: શ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4366 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f15023;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f15024;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final CircleStrokeView f15025;

    public AbstractC4366(Object obj, View view, int i, ImageView imageView, ImageView imageView2, CircleStrokeView circleStrokeView) {
        super(obj, view, i);
        this.f15023 = imageView;
        this.f15024 = imageView2;
        this.f15025 = circleStrokeView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4366 m13527(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13528(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4366 m13528(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4366) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_record_bt, viewGroup, z, obj);
    }
}
