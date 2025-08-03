package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.VerificationCodeEditText;
import com.blink.academy.film.widgets.dialog.login.VerificationTextView;
import com.blink.academy.protake.R;

/* compiled from: FragmentCheckphoneBinding.java */
/* renamed from: ॻ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4129 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14294;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f14295;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final VerificationTextView f14296;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final VerificationTextView f14297;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final View f14298;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14299;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14300;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f14301;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final LinearLayout f14302;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final OneTakeProgressBar f14303;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final TextView f14304;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final TextView f14305;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final VerificationCodeEditText f14306;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final TextView f14307;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final TextView f14308;

    public AbstractC4129(Object obj, View view, int i, RelativeLayout relativeLayout, LinearLayout linearLayout, VerificationTextView verificationTextView, VerificationTextView verificationTextView2, View view2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout2, LinearLayout linearLayout3, OneTakeProgressBar oneTakeProgressBar, TextView textView, TextView textView2, VerificationCodeEditText verificationCodeEditText, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f14294 = relativeLayout;
        this.f14295 = linearLayout;
        this.f14296 = verificationTextView;
        this.f14297 = verificationTextView2;
        this.f14298 = view2;
        this.f14299 = relativeLayout2;
        this.f14300 = relativeLayout3;
        this.f14301 = linearLayout2;
        this.f14302 = linearLayout3;
        this.f14303 = oneTakeProgressBar;
        this.f14304 = textView;
        this.f14305 = textView2;
        this.f14306 = verificationCodeEditText;
        this.f14307 = textView3;
        this.f14308 = textView4;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4129 m13101(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13102(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4129 m13102(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4129) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_checkphone, viewGroup, z, obj);
    }
}
