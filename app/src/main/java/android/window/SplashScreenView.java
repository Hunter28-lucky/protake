package android.window;

import android.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import java.time.Duration;
import java.time.Instant;

/* loaded from: classes.dex */
public final /* synthetic */ class SplashScreenView extends FrameLayout {
    static {
        throw new NoClassDefFoundError();
    }

    @Nullable
    public native /* synthetic */ Duration getIconAnimationDuration();

    @Nullable
    public native /* synthetic */ Instant getIconAnimationStart();

    @Nullable
    public native /* synthetic */ View getIconView();

    public native /* synthetic */ void remove();
}
