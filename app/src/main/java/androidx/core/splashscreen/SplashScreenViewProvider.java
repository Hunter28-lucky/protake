package androidx.core.splashscreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.window.SplashScreenView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.splashscreen.ThemeUtils;
import defpackage.C3921;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4870;
import java.time.Duration;
import java.time.Instant;
import kotlin.C2146;

/* compiled from: SplashScreenViewProvider.kt */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class SplashScreenViewProvider {
    private final ViewImpl impl;

    /* compiled from: SplashScreenViewProvider.kt */
    public static class ViewImpl {
        private final InterfaceC4870 _splashScreenView$delegate;
        private final Activity activity;

        public ViewImpl(Activity activity) {
            C3921.m12666(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.activity = activity;
            this._splashScreenView$delegate = C2146.m7323(new InterfaceC4090<ViewGroup>() { // from class: androidx.core.splashscreen.SplashScreenViewProvider$ViewImpl$_splashScreenView$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // defpackage.InterfaceC4090
                public final ViewGroup invoke() {
                    View viewInflate = View.inflate(this.this$0.getActivity(), R.layout.splash_screen_view, null);
                    if (viewInflate != null) {
                        return (ViewGroup) viewInflate;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            });
        }

        private final ViewGroup get_splashScreenView() {
            return (ViewGroup) this._splashScreenView$delegate.getValue();
        }

        public void createSplashScreenView() {
            View rootView = ((ViewGroup) this.activity.findViewById(android.R.id.content)).getRootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup == null) {
                return;
            }
            viewGroup.addView(get_splashScreenView());
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public long getIconAnimationDurationMillis() {
            return 0L;
        }

        public long getIconAnimationStartMillis() {
            return 0L;
        }

        public View getIconView() {
            View viewFindViewById = getSplashScreenView().findViewById(R.id.splashscreen_icon_view);
            C3921.m12665(viewFindViewById, "splashScreenView.findVie…d.splashscreen_icon_view)");
            return viewFindViewById;
        }

        public ViewGroup getSplashScreenView() {
            return get_splashScreenView();
        }

        public void remove() {
            ViewParent parent = getSplashScreenView().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup == null) {
                return;
            }
            viewGroup.removeView(getSplashScreenView());
        }
    }

    /* compiled from: SplashScreenViewProvider.kt */
    @RequiresApi(31)
    public static final class ViewImpl31 extends ViewImpl {
        public SplashScreenView platformView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewImpl31(Activity activity) {
            super(activity);
            C3921.m12666(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        @Override // androidx.core.splashscreen.SplashScreenViewProvider.ViewImpl
        public void createSplashScreenView() {
        }

        @Override // androidx.core.splashscreen.SplashScreenViewProvider.ViewImpl
        public long getIconAnimationDurationMillis() {
            Duration iconAnimationDuration = getPlatformView().getIconAnimationDuration();
            if (iconAnimationDuration == null) {
                return 0L;
            }
            return iconAnimationDuration.toMillis();
        }

        @Override // androidx.core.splashscreen.SplashScreenViewProvider.ViewImpl
        public long getIconAnimationStartMillis() {
            Instant iconAnimationStart = getPlatformView().getIconAnimationStart();
            if (iconAnimationStart == null) {
                return 0L;
            }
            return iconAnimationStart.toEpochMilli();
        }

        @Override // androidx.core.splashscreen.SplashScreenViewProvider.ViewImpl
        public View getIconView() {
            View iconView = getPlatformView().getIconView();
            C3921.m12664(iconView);
            C3921.m12665(iconView, "platformView.iconView!!");
            return iconView;
        }

        public final SplashScreenView getPlatformView() {
            SplashScreenView splashScreenView = this.platformView;
            if (splashScreenView != null) {
                return splashScreenView;
            }
            C3921.m12681("platformView");
            return null;
        }

        @Override // androidx.core.splashscreen.SplashScreenViewProvider.ViewImpl
        public void remove() {
            getPlatformView().remove();
            Resources.Theme theme = getActivity().getTheme();
            C3921.m12665(theme, "activity.theme");
            View decorView = getActivity().getWindow().getDecorView();
            C3921.m12665(decorView, "activity.window.decorView");
            ThemeUtils.Api31.applyThemesSystemBarAppearance$default(theme, decorView, null, 4, null);
        }

        public final void setPlatformView(SplashScreenView splashScreenView) {
            C3921.m12666(splashScreenView, "<set-?>");
            this.platformView = splashScreenView;
        }

        @Override // androidx.core.splashscreen.SplashScreenViewProvider.ViewImpl
        public SplashScreenView getSplashScreenView() {
            return getPlatformView();
        }
    }

    public SplashScreenViewProvider(Activity activity) {
        C3921.m12666(activity, "ctx");
        ViewImpl viewImpl31 = Build.VERSION.SDK_INT >= 31 ? new ViewImpl31(activity) : new ViewImpl(activity);
        viewImpl31.createSplashScreenView();
        this.impl = viewImpl31;
    }

    public final long getIconAnimationDurationMillis() {
        return this.impl.getIconAnimationDurationMillis();
    }

    public final long getIconAnimationStartMillis() {
        return this.impl.getIconAnimationStartMillis();
    }

    public final View getIconView() {
        return this.impl.getIconView();
    }

    public final View getView() {
        return this.impl.getSplashScreenView();
    }

    public final void remove() {
        this.impl.remove();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(31)
    public SplashScreenViewProvider(SplashScreenView splashScreenView, Activity activity) {
        this(activity);
        C3921.m12666(splashScreenView, "platformView");
        C3921.m12666(activity, "ctx");
        ((ViewImpl31) this.impl).setPlatformView(splashScreenView);
    }
}
