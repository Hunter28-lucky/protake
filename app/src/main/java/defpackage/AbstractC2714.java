package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.dialog.login.SignInView;
import com.blink.academy.film.widgets.dialog.login.VerifyView;
import com.blink.academy.protake.R;

/* compiled from: LayoutLoginDialogBinding.java */
/* renamed from: ʬ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2714 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final View f10034;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f10035;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f10036;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final View f10037;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10038;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f10039;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final TextView f10040;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final SignInView f10041;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final VerifyView f10042;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f10043;

    public AbstractC2714(Object obj, View view, int i, View view2, RelativeLayout relativeLayout, LinearLayout linearLayout, View view3, ImageView imageView, ImageView imageView2, TextView textView, SignInView signInView, VerifyView verifyView, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.f10034 = view2;
        this.f10035 = relativeLayout;
        this.f10036 = linearLayout;
        this.f10037 = view3;
        this.f10038 = imageView;
        this.f10039 = imageView2;
        this.f10040 = textView;
        this.f10041 = signInView;
        this.f10042 = verifyView;
        this.f10043 = linearLayout2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC2714 m9970(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m9971(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC2714 m9971(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC2714) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_login_dialog, viewGroup, z, obj);
    }
}
