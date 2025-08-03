package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.blink.academy.film.widgets.wheel.view.WheelView;

/* compiled from: LoopViewGestureListener.java */
/* renamed from: ਜ਼, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4285 extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final WheelView f14683;

    public C4285(WheelView wheelView) {
        this.f14683 = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f14683.m4729(f2);
        return true;
    }
}
