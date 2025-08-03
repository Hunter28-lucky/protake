package defpackage;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: FilmOnTouchListener.java */
/* renamed from: ؤ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC3426 implements View.OnTouchListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public View f11781;

    /* compiled from: FilmOnTouchListener.java */
    /* renamed from: ؤ$Ϳ, reason: contains not printable characters */
    public class RunnableC3427 implements Runnable {
        public RunnableC3427() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewOnTouchListenerC3426.this.f11781.setAlpha(1.0f);
        }
    }

    public ViewOnTouchListenerC3426(View view) {
        this.f11781 = view;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11781.setAlpha(0.3f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        new Handler().postDelayed(new RunnableC3427(), 100L);
        return false;
    }
}
