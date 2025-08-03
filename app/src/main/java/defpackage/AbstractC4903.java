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
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.SwitchButton2;
import com.blink.academy.protake.R;

/* compiled from: LayoutAccessories2Binding.java */
/* renamed from: ภ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4903 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final OneTakeProgressBar f16546;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16547;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16548;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16549;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f16550;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton2 f16551;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton2 f16552;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final TextView f16553;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final TextView f16554;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final TextView f16555;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final View f16556;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final View f16557;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final View f16558;

    public AbstractC4903(Object obj, View view, int i, OneTakeProgressBar oneTakeProgressBar, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, SwitchButton switchButton, SwitchButton2 switchButton2, SwitchButton2 switchButton22, TextView textView, TextView textView2, TextView textView3, View view2, View view3, View view4) {
        super(obj, view, i);
        this.f16546 = oneTakeProgressBar;
        this.f16547 = relativeLayout;
        this.f16548 = relativeLayout2;
        this.f16549 = relativeLayout3;
        this.f16550 = switchButton;
        this.f16551 = switchButton2;
        this.f16552 = switchButton22;
        this.f16553 = textView;
        this.f16554 = textView2;
        this.f16555 = textView3;
        this.f16556 = view2;
        this.f16557 = view3;
        this.f16558 = view4;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4903 m14627(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14628(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4903 m14628(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4903) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_accessories_2, viewGroup, z, obj);
    }
}
