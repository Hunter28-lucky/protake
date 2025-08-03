package defpackage;

import android.content.Context;
import android.content.Intent;
import java.util.List;

/* loaded from: classes2.dex */
public class dd {

    /* renamed from: dd$Ϳ, reason: contains not printable characters */
    public static class RunnableC1952 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Context f6564;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Intent f6565;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC5278 f6566;

        public RunnableC1952(Context context, Intent intent, InterfaceC5278 interfaceC5278) {
            this.f6564 = context;
            this.f6565 = intent;
            this.f6566 = interfaceC5278;
        }

        @Override // java.lang.Runnable
        public void run() throws NumberFormatException {
            List<AbstractC5165> listM7707 = od.m7707(this.f6564, this.f6565);
            if (listM7707 == null) {
                return;
            }
            for (AbstractC5165 abstractC5165 : listM7707) {
                if (abstractC5165 != null) {
                    for (pd pdVar : re.m8171().m8190()) {
                        if (pdVar != null) {
                            pdVar.mo7180(this.f6564, abstractC5165, this.f6566);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m5943(Context context, Intent intent, InterfaceC5278 interfaceC5278) {
        if (context == null) {
            qd.m8125("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            qd.m8125("intent is null , please check param of parseIntent()");
        } else if (interfaceC5278 == null) {
            qd.m8125("callback is null , please check param of parseIntent()");
        } else {
            bg.m172(new RunnableC1952(context, intent, interfaceC5278));
        }
    }
}
