package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutReceiverViewBinding.java */
/* renamed from: থ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4187 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14448;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f14449;

    public AbstractC4187(Object obj, View view, int i, StrokeTextView strokeTextView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f14448 = strokeTextView;
        this.f14449 = recyclerView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4187 m13212(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13213(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4187 m13213(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4187) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_receiver_view, viewGroup, z, obj);
    }
}
