package defpackage;

import android.content.Context;

/* loaded from: classes2.dex */
public class qb implements pd {

    /* renamed from: qb$Ϳ, reason: contains not printable characters */
    public class RunnableC2255 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC5278 f8451;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Context f8452;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C2318 f8453;

        public RunnableC2255(InterfaceC5278 interfaceC5278, Context context, C2318 c2318) {
            this.f8451 = interfaceC5278;
            this.f8452 = context;
            this.f8453 = c2318;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8451.mo5110(this.f8452, this.f8453);
        }
    }

    @Override // defpackage.pd
    /* renamed from: Ϳ */
    public void mo7180(Context context, AbstractC5165 abstractC5165, InterfaceC5278 interfaceC5278) {
        if (abstractC5165 != null && abstractC5165.mo8476() == 4103) {
            C2318 c2318 = (C2318) abstractC5165;
            if (interfaceC5278 != null) {
                bg.m173(new RunnableC2255(interfaceC5278, context, c2318));
            }
        }
    }
}
