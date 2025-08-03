package defpackage;

import android.os.Handler;
import android.os.Message;
import com.blink.academy.film.widgets.wheel.view.WheelView;

/* compiled from: MessageHandler.java */
/* renamed from: ჴ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class HandlerC5310 extends Handler {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final WheelView f17563;

    public HandlerC5310(WheelView wheelView) {
        this.f17563 = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f17563.invalidate();
        } else if (i == 2000) {
            this.f17563.m4730(WheelView.ACTION.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.f17563.m4726();
        }
    }
}
