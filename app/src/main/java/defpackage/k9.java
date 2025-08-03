package defpackage;

import android.content.Context;

/* loaded from: classes2.dex */
public class k9 implements pd {

    /* renamed from: k9$Ϳ, reason: contains not printable characters */
    public class RunnableC2136 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ va f7823;

        public RunnableC2136(va vaVar) {
            this.f7823 = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            k9.this.m7181(this.f7823, re.m8171());
        }
    }

    @Override // defpackage.pd
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo7180(Context context, AbstractC5165 abstractC5165, InterfaceC5278 interfaceC5278) {
        if (abstractC5165 != null && abstractC5165.mo8476() == 4105) {
            va vaVar = (va) abstractC5165;
            qd.m8124("mcssdk-CallBackResultProcessor:" + vaVar.toString());
            bg.m173(new RunnableC2136(vaVar));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m7181(va vaVar, re reVar) {
        String str;
        if (vaVar == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (reVar == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else {
            if (reVar.m8191() != null) {
                int iM8481 = vaVar.m8481();
                if (iM8481 == 12289) {
                    if (vaVar.m8485() == 0) {
                        reVar.m8181(vaVar.m8483());
                    }
                    reVar.m8191().onRegister(vaVar.m8485(), vaVar.m8483());
                    return;
                } else {
                    if (iM8481 == 12290) {
                        reVar.m8191().onUnRegister(vaVar.m8485());
                        return;
                    }
                    if (iM8481 == 12298) {
                        reVar.m8191().onSetPushTime(vaVar.m8485(), vaVar.m8483());
                        return;
                    } else if (iM8481 == 12306) {
                        reVar.m8191().onGetPushStatus(vaVar.m8485(), gg.m6100(vaVar.m8483()));
                        return;
                    } else {
                        if (iM8481 != 12309) {
                            return;
                        }
                        reVar.m8191().onGetNotificationStatus(vaVar.m8485(), gg.m6100(vaVar.m8483()));
                        return;
                    }
                }
            }
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        qd.m8125(str);
    }
}
