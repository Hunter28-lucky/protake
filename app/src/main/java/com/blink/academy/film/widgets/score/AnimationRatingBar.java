package com.blink.academy.film.widgets.score;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import java.util.UUID;

/* loaded from: classes.dex */
public class AnimationRatingBar extends BaseRatingBar {

    /* renamed from: މ, reason: contains not printable characters */
    public Handler f3876;

    /* renamed from: ފ, reason: contains not printable characters */
    public Runnable f3877;

    /* renamed from: ދ, reason: contains not printable characters */
    public String f3878;

    public AnimationRatingBar(Context context) {
        super(context);
        this.f3878 = UUID.randomUUID().toString();
        m3879();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m3879() {
        this.f3876 = new Handler();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m3880(Runnable runnable, long j) {
        if (this.f3876 == null) {
            this.f3876 = new Handler();
        }
        this.f3876.postAtTime(runnable, this.f3878, SystemClock.uptimeMillis() + j);
    }

    public AnimationRatingBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3878 = UUID.randomUUID().toString();
        m3879();
    }

    public AnimationRatingBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3878 = UUID.randomUUID().toString();
        m3879();
    }
}
