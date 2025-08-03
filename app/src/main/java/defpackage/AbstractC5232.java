package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitPresetSettingBinding.java */
/* renamed from: Ⴚ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5232 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f17346;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f17347;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final TextView f17348;

    public AbstractC5232(Object obj, View view, int i, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.f17346 = relativeLayout;
        this.f17347 = recyclerView;
        this.f17348 = textView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC5232 m15249(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m15250(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC5232 m15250(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC5232) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_portrait_preset_setting, viewGroup, z, obj);
    }
}
