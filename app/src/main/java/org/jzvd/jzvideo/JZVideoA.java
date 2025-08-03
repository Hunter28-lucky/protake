package org.jzvd.jzvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import defpackage.C3921;
import defpackage.C4184;

/* compiled from: JZVideoA.kt */
/* loaded from: classes2.dex */
public class JZVideoA extends RelativeLayout {
    public static final Companion Companion = new Companion(null);
    public State state;

    /* compiled from: JZVideoA.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C4184 c4184) {
            this();
        }
    }

    /* compiled from: JZVideoA.kt */
    public enum State {
        IDLE,
        NORMAL,
        PREPARING,
        PREPARING_CHANGE_URL,
        PREPARING_PLAYING,
        PREPARED,
        PLAYING,
        PAUSE,
        COMPLETE,
        ERROR
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JZVideoA(Context context) {
        super(context);
        C3921.m12666(context, "ctx");
    }

    public final State getState() {
        State state = this.state;
        if (state != null) {
            return state;
        }
        C3921.m12681("state");
        return null;
    }

    public final void setState(State state) {
        C3921.m12666(state, "<set-?>");
        this.state = state;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JZVideoA(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C3921.m12666(context, "ctx");
        C3921.m12666(attributeSet, "attrs");
    }
}
