package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorPlayerControlBinding.java */
/* renamed from: ܠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3675 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12751;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final View f12752;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12753;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final View f12754;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12755;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final View f12756;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12757;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final View f12758;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f12759;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final View f12760;

    public AbstractC3675(Object obj, View view, int i, ImageView imageView, View view2, ImageView imageView2, View view3, ImageView imageView3, View view4, ImageView imageView4, View view5, ImageView imageView5, View view6) {
        super(obj, view, i);
        this.f12751 = imageView;
        this.f12752 = view2;
        this.f12753 = imageView2;
        this.f12754 = view3;
        this.f12755 = imageView3;
        this.f12756 = view4;
        this.f12757 = imageView4;
        this.f12758 = view5;
        this.f12759 = imageView5;
        this.f12760 = view6;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3675 m11820(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11821(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3675 m11821(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3675) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_monitor_player_control, viewGroup, z, obj);
    }
}
