package androidx.core.splashscreen;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.C3921;

/* compiled from: ThemeUtils.kt */
@RequiresApi(31)
/* loaded from: classes.dex */
public final class ThemeUtils {
    public static final ThemeUtils INSTANCE = new ThemeUtils();

    /* compiled from: ThemeUtils.kt */
    public static final class Api31 {
        public static final Api31 INSTANCE = new Api31();

        private Api31() {
        }

        @DoNotInline
        public static final void applyThemesSystemBarAppearance(Resources.Theme theme, View view) {
            C3921.m12666(theme, "theme");
            C3921.m12666(view, "decor");
            applyThemesSystemBarAppearance$default(theme, view, null, 4, null);
        }

        @DoNotInline
        public static final void applyThemesSystemBarAppearance(Resources.Theme theme, View view, TypedValue typedValue) {
            C3921.m12666(theme, "theme");
            C3921.m12666(view, "decor");
            C3921.m12666(typedValue, "tv");
            int i = (!theme.resolveAttribute(android.R.attr.windowLightStatusBar, typedValue, true) || typedValue.data == 0) ? 0 : 8;
            if (theme.resolveAttribute(android.R.attr.windowLightNavigationBar, typedValue, true) && typedValue.data != 0) {
                i |= 16;
            }
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            C3921.m12664(windowInsetsController);
            windowInsetsController.setSystemBarsAppearance(i, 24);
        }

        public static /* synthetic */ void applyThemesSystemBarAppearance$default(Resources.Theme theme, View view, TypedValue typedValue, int i, Object obj) {
            if ((i & 4) != 0) {
                typedValue = new TypedValue();
            }
            applyThemesSystemBarAppearance(theme, view, typedValue);
        }
    }

    private ThemeUtils() {
    }
}
