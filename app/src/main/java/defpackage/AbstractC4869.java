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

/* compiled from: LayoutTransmitSettingPag2Binding.java */
/* renamed from: ช, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4869 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f16466;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16467;

    public AbstractC4869(Object obj, View view, int i, RecyclerView recyclerView, StrokeTextView strokeTextView) {
        super(obj, view, i);
        this.f16466 = recyclerView;
        this.f16467 = strokeTextView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4869 m14591(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14592(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4869 m14592(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4869) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_transmit_setting_pag2, viewGroup, z, obj);
    }
}
