package androidx.core.splashscreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.widget.ImageView;
import android.window.SplashScreen;
import android.window.SplashScreenView;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.splashscreen.ThemeUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import defpackage.C3921;
import defpackage.C4184;

/* compiled from: SplashScreen.kt */
@SuppressLint({"CustomSplashScreen"})
/* loaded from: classes.dex */
public final class SplashScreen {
    public static final Companion Companion = new Companion(null);
    private static final float MASK_FACTOR = 0.6666667f;
    private final Impl impl;

    /* compiled from: SplashScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C4184 c4184) {
            this();
        }

        public final SplashScreen installSplashScreen(Activity activity) {
            C3921.m12666(activity, "<this>");
            SplashScreen splashScreen = new SplashScreen(activity, null);
            splashScreen.install();
            return splashScreen;
        }
    }

    /* compiled from: SplashScreen.kt */
    public static class Impl {
        private final Activity activity;
        private OnExitAnimationListener animationListener;
        private Integer backgroundColor;
        private Integer backgroundResId;
        private int finalThemeId;
        private boolean hasBackground;
        private Drawable icon;
        private SplashScreenViewProvider mSplashScreenViewProvider;
        private KeepOnScreenCondition splashScreenWaitPredicate;

        public Impl(Activity activity) {
            C3921.m12666(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.activity = activity;
            this.splashScreenWaitPredicate = new KeepOnScreenCondition() { // from class: androidx.core.splashscreen.Ԩ
                @Override // androidx.core.splashscreen.SplashScreen.KeepOnScreenCondition
                public final boolean shouldKeepOnScreen() {
                    return SplashScreen.Impl.m86splashScreenWaitPredicate$lambda0();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: dispatchOnExitAnimation$lambda-3, reason: not valid java name */
        public static final void m85dispatchOnExitAnimation$lambda3(SplashScreenViewProvider splashScreenViewProvider, OnExitAnimationListener onExitAnimationListener) {
            C3921.m12666(splashScreenViewProvider, "$splashScreenViewProvider");
            C3921.m12666(onExitAnimationListener, "$finalListener");
            splashScreenViewProvider.getView().bringToFront();
            onExitAnimationListener.onSplashScreenExit(splashScreenViewProvider);
        }

        private final void displaySplashScreenIcon(View view, Drawable drawable) {
            float dimension;
            ImageView imageView = (ImageView) view.findViewById(R.id.splashscreen_icon_view);
            if (getHasBackground()) {
                Drawable drawable2 = imageView.getContext().getDrawable(R.drawable.icon_background);
                dimension = imageView.getResources().getDimension(R.dimen.splashscreen_icon_size_with_background) * SplashScreen.MASK_FACTOR;
                if (drawable2 != null) {
                    imageView.setBackground(new MaskedDrawable(drawable2, dimension));
                }
            } else {
                dimension = imageView.getResources().getDimension(R.dimen.splashscreen_icon_size_no_background) * SplashScreen.MASK_FACTOR;
            }
            imageView.setImageDrawable(new MaskedDrawable(drawable, dimension));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: splashScreenWaitPredicate$lambda-0, reason: not valid java name */
        public static final boolean m86splashScreenWaitPredicate$lambda0() {
            return false;
        }

        public final void dispatchOnExitAnimation(final SplashScreenViewProvider splashScreenViewProvider) {
            C3921.m12666(splashScreenViewProvider, "splashScreenViewProvider");
            final OnExitAnimationListener onExitAnimationListener = this.animationListener;
            if (onExitAnimationListener == null) {
                return;
            }
            this.animationListener = null;
            splashScreenViewProvider.getView().postOnAnimation(new Runnable() { // from class: androidx.core.splashscreen.Ϳ
                @Override // java.lang.Runnable
                public final void run() {
                    SplashScreen.Impl.m85dispatchOnExitAnimation$lambda3(splashScreenViewProvider, onExitAnimationListener);
                }
            });
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Integer getBackgroundColor() {
            return this.backgroundColor;
        }

        public final Integer getBackgroundResId() {
            return this.backgroundResId;
        }

        public final int getFinalThemeId() {
            return this.finalThemeId;
        }

        public final boolean getHasBackground() {
            return this.hasBackground;
        }

        public final Drawable getIcon() {
            return this.icon;
        }

        public final KeepOnScreenCondition getSplashScreenWaitPredicate() {
            return this.splashScreenWaitPredicate;
        }

        public void install() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.activity.getTheme();
            if (theme.resolveAttribute(R.attr.windowSplashScreenBackground, typedValue, true)) {
                this.backgroundResId = Integer.valueOf(typedValue.resourceId);
                this.backgroundColor = Integer.valueOf(typedValue.data);
            }
            if (theme.resolveAttribute(R.attr.windowSplashScreenAnimatedIcon, typedValue, true)) {
                this.icon = theme.getDrawable(typedValue.resourceId);
            }
            if (theme.resolveAttribute(R.attr.splashScreenIconSize, typedValue, true)) {
                this.hasBackground = typedValue.resourceId == R.dimen.splashscreen_icon_size_with_background;
            }
            C3921.m12665(theme, "currentTheme");
            setPostSplashScreenTheme(theme, typedValue);
        }

        public final void setBackgroundColor(Integer num) {
            this.backgroundColor = num;
        }

        public final void setBackgroundResId(Integer num) {
            this.backgroundResId = num;
        }

        public final void setFinalThemeId(int i) {
            this.finalThemeId = i;
        }

        public final void setHasBackground(boolean z) {
            this.hasBackground = z;
        }

        public final void setIcon(Drawable drawable) {
            this.icon = drawable;
        }

        public void setKeepOnScreenCondition(KeepOnScreenCondition keepOnScreenCondition) {
            C3921.m12666(keepOnScreenCondition, "keepOnScreenCondition");
            this.splashScreenWaitPredicate = keepOnScreenCondition;
            final View viewFindViewById = this.activity.findViewById(android.R.id.content);
            viewFindViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.core.splashscreen.SplashScreen$Impl$setKeepOnScreenCondition$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (this.this$0.getSplashScreenWaitPredicate().shouldKeepOnScreen()) {
                        return false;
                    }
                    viewFindViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                    SplashScreenViewProvider splashScreenViewProvider = this.this$0.mSplashScreenViewProvider;
                    if (splashScreenViewProvider == null) {
                        return true;
                    }
                    this.this$0.dispatchOnExitAnimation(splashScreenViewProvider);
                    return true;
                }
            });
        }

        public void setOnExitAnimationListener(OnExitAnimationListener onExitAnimationListener) {
            C3921.m12666(onExitAnimationListener, "exitAnimationListener");
            this.animationListener = onExitAnimationListener;
            final SplashScreenViewProvider splashScreenViewProvider = new SplashScreenViewProvider(this.activity);
            Integer num = this.backgroundResId;
            Integer num2 = this.backgroundColor;
            View view = splashScreenViewProvider.getView();
            if (num != null && num.intValue() != 0) {
                view.setBackgroundResource(num.intValue());
            } else if (num2 != null) {
                view.setBackgroundColor(num2.intValue());
            } else {
                view.setBackground(this.activity.getWindow().getDecorView().getBackground());
            }
            Drawable drawable = this.icon;
            if (drawable != null) {
                displaySplashScreenIcon(view, drawable);
            }
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.splashscreen.SplashScreen$Impl$setOnExitAnimationListener$2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    C3921.m12666(view2, "view");
                    if (view2.isAttachedToWindow()) {
                        view2.removeOnLayoutChangeListener(this);
                        if (!this.this$0.getSplashScreenWaitPredicate().shouldKeepOnScreen()) {
                            this.this$0.dispatchOnExitAnimation(splashScreenViewProvider);
                        } else {
                            this.this$0.mSplashScreenViewProvider = splashScreenViewProvider;
                        }
                    }
                }
            });
        }

        public final void setPostSplashScreenTheme(Resources.Theme theme, TypedValue typedValue) {
            C3921.m12666(theme, "currentTheme");
            C3921.m12666(typedValue, "typedValue");
            if (theme.resolveAttribute(R.attr.postSplashScreenTheme, typedValue, true)) {
                int i = typedValue.resourceId;
                this.finalThemeId = i;
                if (i != 0) {
                    this.activity.setTheme(i);
                }
            }
        }

        public final void setSplashScreenWaitPredicate(KeepOnScreenCondition keepOnScreenCondition) {
            C3921.m12666(keepOnScreenCondition, "<set-?>");
            this.splashScreenWaitPredicate = keepOnScreenCondition;
        }
    }

    /* compiled from: SplashScreen.kt */
    @RequiresApi(31)
    public static final class Impl31 extends Impl {
        private final ViewGroup.OnHierarchyChangeListener hierarchyListener;
        private boolean mDecorFitWindowInsets;
        private ViewTreeObserver.OnPreDrawListener preDrawListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl31(final Activity activity) {
            super(activity);
            C3921.m12666(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.mDecorFitWindowInsets = true;
            this.hierarchyListener = new ViewGroup.OnHierarchyChangeListener() { // from class: androidx.core.splashscreen.SplashScreen$Impl31$hierarchyListener$1
                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewAdded(View view, View view2) {
                    if (view2 instanceof SplashScreenView) {
                        SplashScreen.Impl31 impl31 = this.this$0;
                        impl31.setMDecorFitWindowInsets(impl31.computeDecorFitsWindow((SplashScreenView) view2));
                        ((ViewGroup) activity.getWindow().getDecorView()).setOnHierarchyChangeListener(null);
                    }
                }

                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewRemoved(View view, View view2) {
                }
            };
        }

        private final void applyAppSystemUiTheme() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = getActivity().getTheme();
            Window window = getActivity().getWindow();
            if (theme.resolveAttribute(android.R.attr.statusBarColor, typedValue, true)) {
                window.setStatusBarColor(typedValue.data);
            }
            if (theme.resolveAttribute(android.R.attr.navigationBarColor, typedValue, true)) {
                window.setNavigationBarColor(typedValue.data);
            }
            if (theme.resolveAttribute(android.R.attr.windowDrawsSystemBarBackgrounds, typedValue, true)) {
                if (typedValue.data != 0) {
                    window.addFlags(Integer.MIN_VALUE);
                } else {
                    window.clearFlags(Integer.MIN_VALUE);
                }
            }
            if (theme.resolveAttribute(android.R.attr.enforceNavigationBarContrast, typedValue, true)) {
                window.setNavigationBarContrastEnforced(typedValue.data != 0);
            }
            if (theme.resolveAttribute(android.R.attr.enforceStatusBarContrast, typedValue, true)) {
                window.setStatusBarContrastEnforced(typedValue.data != 0);
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            C3921.m12665(theme, "theme");
            ThemeUtils.Api31.applyThemesSystemBarAppearance(theme, viewGroup, typedValue);
            viewGroup.setOnHierarchyChangeListener(null);
            window.setDecorFitsSystemWindows(this.mDecorFitWindowInsets);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: setOnExitAnimationListener$lambda-0, reason: not valid java name */
        public static final void m89setOnExitAnimationListener$lambda0(Impl31 impl31, OnExitAnimationListener onExitAnimationListener, SplashScreenView splashScreenView) {
            C3921.m12666(impl31, "this$0");
            C3921.m12666(onExitAnimationListener, "$exitAnimationListener");
            C3921.m12666(splashScreenView, "splashScreenView");
            impl31.applyAppSystemUiTheme();
            onExitAnimationListener.onSplashScreenExit(new SplashScreenViewProvider(splashScreenView, impl31.getActivity()));
        }

        public final boolean computeDecorFitsWindow(SplashScreenView splashScreenView) {
            C3921.m12666(splashScreenView, "child");
            WindowInsets windowInsetsBuild = new WindowInsets$Builder().build();
            C3921.m12665(windowInsetsBuild, "Builder().build()");
            Rect rect = new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
            return (windowInsetsBuild == splashScreenView.getRootView().computeSystemWindowInsets(windowInsetsBuild, rect) && rect.isEmpty()) ? false : true;
        }

        public final ViewGroup.OnHierarchyChangeListener getHierarchyListener() {
            return this.hierarchyListener;
        }

        public final boolean getMDecorFitWindowInsets() {
            return this.mDecorFitWindowInsets;
        }

        public final ViewTreeObserver.OnPreDrawListener getPreDrawListener() {
            return this.preDrawListener;
        }

        @Override // androidx.core.splashscreen.SplashScreen.Impl
        public void install() {
            Resources.Theme theme = getActivity().getTheme();
            C3921.m12665(theme, "activity.theme");
            setPostSplashScreenTheme(theme, new TypedValue());
            ((ViewGroup) getActivity().getWindow().getDecorView()).setOnHierarchyChangeListener(this.hierarchyListener);
        }

        @Override // androidx.core.splashscreen.SplashScreen.Impl
        public void setKeepOnScreenCondition(KeepOnScreenCondition keepOnScreenCondition) {
            C3921.m12666(keepOnScreenCondition, "keepOnScreenCondition");
            setSplashScreenWaitPredicate(keepOnScreenCondition);
            final View viewFindViewById = getActivity().findViewById(android.R.id.content);
            ViewTreeObserver viewTreeObserver = viewFindViewById.getViewTreeObserver();
            if (this.preDrawListener != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
            }
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.core.splashscreen.SplashScreen$Impl31$setKeepOnScreenCondition$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (this.this$0.getSplashScreenWaitPredicate().shouldKeepOnScreen()) {
                        return false;
                    }
                    viewFindViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            };
            this.preDrawListener = onPreDrawListener;
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
        }

        public final void setMDecorFitWindowInsets(boolean z) {
            this.mDecorFitWindowInsets = z;
        }

        @Override // androidx.core.splashscreen.SplashScreen.Impl
        public void setOnExitAnimationListener(final OnExitAnimationListener onExitAnimationListener) {
            C3921.m12666(onExitAnimationListener, "exitAnimationListener");
            getActivity().getSplashScreen().setOnExitAnimationListener(new SplashScreen.OnExitAnimationListener() { // from class: androidx.core.splashscreen.Ԫ
                public final void onSplashScreenExit(SplashScreenView splashScreenView) {
                    SplashScreen.Impl31.m89setOnExitAnimationListener$lambda0(this.f77, onExitAnimationListener, splashScreenView);
                }
            });
        }

        public final void setPreDrawListener(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            this.preDrawListener = onPreDrawListener;
        }
    }

    /* compiled from: SplashScreen.kt */
    public interface KeepOnScreenCondition {
        @MainThread
        boolean shouldKeepOnScreen();
    }

    /* compiled from: SplashScreen.kt */
    public interface OnExitAnimationListener {
        @MainThread
        void onSplashScreenExit(SplashScreenViewProvider splashScreenViewProvider);
    }

    private SplashScreen(Activity activity) {
        this.impl = Build.VERSION.SDK_INT >= 31 ? new Impl31(activity) : new Impl(activity);
    }

    public /* synthetic */ SplashScreen(Activity activity, C4184 c4184) {
        this(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void install() {
        this.impl.install();
    }

    public static final SplashScreen installSplashScreen(Activity activity) {
        return Companion.installSplashScreen(activity);
    }

    public final void setKeepOnScreenCondition(KeepOnScreenCondition keepOnScreenCondition) {
        C3921.m12666(keepOnScreenCondition, "condition");
        this.impl.setKeepOnScreenCondition(keepOnScreenCondition);
    }

    public final void setOnExitAnimationListener(OnExitAnimationListener onExitAnimationListener) {
        C3921.m12666(onExitAnimationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.impl.setOnExitAnimationListener(onExitAnimationListener);
    }
}
