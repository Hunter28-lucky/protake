package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.support.controller.StoreController;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* compiled from: PayUtils.java */
/* renamed from: ಥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4628 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C4628 f15751;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public HandlerThread f15752;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Handler f15753;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f15754 = false;

    /* compiled from: PayUtils.java */
    /* renamed from: ಥ$Ϳ, reason: contains not printable characters */
    public class RunnableC4629 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Context f15755;

        public RunnableC4629(Context context) {
            this.f15755 = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this.f15755, StoreController.WECHAT_APP_ID);
            C4628.this.f15754 = iwxapiCreateWXAPI.getWXAppSupportAPI() >= 570425345;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C4628 m14086() {
        if (f15751 == null) {
            synchronized (C4628.class) {
                if (f15751 == null) {
                    f15751 = new C4628();
                }
            }
        }
        return f15751;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m14087(Context context) {
        return WXAPIFactory.createWXAPI(context, StoreController.WECHAT_APP_ID).isWXAppInstalled() && this.f15754;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m14088() {
        HandlerThread handlerThread = new HandlerThread("WXBack");
        this.f15752 = handlerThread;
        handlerThread.setPriority(1);
        this.f15752.start();
        this.f15753 = new Handler(this.f15752.getLooper());
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m14089(Context context) {
        Handler handler = this.f15753;
        if (handler != null) {
            handler.post(new RunnableC4629(context));
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m14090() {
        if (this.f15753 != null) {
            this.f15753 = null;
        }
        HandlerThread handlerThread = this.f15752;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f15752 = null;
        }
    }
}
