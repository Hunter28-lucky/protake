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

/* compiled from: LayoutAccessoriesViewBinding.java */
/* renamed from: ݑ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3702 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final OneTakeProgressBar f12838;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12839;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12840;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f12841;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f12842;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f12843;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton2 f12844;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final TextView f12845;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final TextView f12846;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final TextView f12847;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final View f12848;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final View f12849;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final View f12850;

    public AbstractC3702(Object obj, View view, int i, OneTakeProgressBar oneTakeProgressBar, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, SwitchButton switchButton, SwitchButton switchButton2, SwitchButton2 switchButton22, TextView textView, TextView textView2, TextView textView3, View view2, View view3, View view4) {
        super(obj, view, i);
        this.f12838 = oneTakeProgressBar;
        this.f12839 = relativeLayout;
        this.f12840 = relativeLayout2;
        this.f12841 = relativeLayout3;
        this.f12842 = switchButton;
        this.f12843 = switchButton2;
        this.f12844 = switchButton22;
        this.f12845 = textView;
        this.f12846 = textView2;
        this.f12847 = textView3;
        this.f12848 = view2;
        this.f12849 = view3;
        this.f12850 = view4;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3702 m11852(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11853(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3702 m11853(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3702) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_accessories_view, viewGroup, z, obj);
    }
}
