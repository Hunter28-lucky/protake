package android.view;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.graphics.Insets;

/* loaded from: classes.dex */
public /* synthetic */ interface WindowInsetsAnimationController {
    static {
        throw new NoClassDefFoundError();
    }

    /* synthetic */ void finish(boolean z);

    /* synthetic */ float getCurrentAlpha();

    /* synthetic */ float getCurrentFraction();

    @NonNull
    /* synthetic */ Insets getCurrentInsets();

    @NonNull
    /* synthetic */ Insets getHiddenStateInsets();

    @NonNull
    /* synthetic */ Insets getShownStateInsets();

    /* synthetic */ int getTypes();

    /* synthetic */ boolean isCancelled();

    /* synthetic */ boolean isFinished();

    /* synthetic */ boolean isReady();

    /* synthetic */ void setInsetsAndAlpha(@Nullable Insets insets, float f, float f2);
}
