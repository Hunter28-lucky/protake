package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* compiled from: DrawableDecoderCompat.java */
/* renamed from: ཉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C5026 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static volatile boolean f16790 = true;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Drawable m14815(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return m14817(context, context, i, theme);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Drawable m14816(Context context, Context context2, @DrawableRes int i) {
        return m14817(context, context2, i, null);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Drawable m14817(Context context, Context context2, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            if (f16790) {
                return m14819(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e2;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            f16790 = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return m14818(context2, i, theme);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static Drawable m14818(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static Drawable m14819(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i);
    }
}
