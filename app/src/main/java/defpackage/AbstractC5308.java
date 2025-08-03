package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutRecordSetting2Binding.java */
/* renamed from: ჲ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5308 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f17552;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f17553;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f17554;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f17555;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f17556;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f17557;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f17558;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f17559;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f17560;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f17561;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final View f17562;

    public AbstractC5308(Object obj, View view, int i, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2, ImageView imageView, SwitchButton switchButton, SwitchButton switchButton2, SwitchButton switchButton3, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3, StrokeTextView strokeTextView4, View view2) {
        super(obj, view, i);
        this.f17552 = strokeTextViewWithBottomBlock;
        this.f17553 = strokeTextViewWithBottomBlock2;
        this.f17554 = imageView;
        this.f17555 = switchButton;
        this.f17556 = switchButton2;
        this.f17557 = switchButton3;
        this.f17558 = strokeTextView;
        this.f17559 = strokeTextView2;
        this.f17560 = strokeTextView3;
        this.f17561 = strokeTextView4;
        this.f17562 = view2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC5308 m15362(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m15363(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC5308 m15363(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC5308) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_record_setting2, viewGroup, z, obj);
    }
}
