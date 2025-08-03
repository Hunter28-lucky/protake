package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.protake.R;

/* compiled from: ItemPresetPagerBinding.java */
/* renamed from: ߥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3865 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f13302;

    public AbstractC3865(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f13302 = recyclerView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3865 m12313(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m12314(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3865 m12314(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3865) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_preset_pager, viewGroup, z, obj);
    }
}
