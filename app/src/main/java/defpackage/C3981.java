package defpackage;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alipay.sdk.app.PayTask;
import com.blink.academy.film.custom.WeakHandler;
import java.util.Map;

/* compiled from: Alipay.java */
/* renamed from: ࢭ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3981 implements Handler.Callback {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public PayTask f13924;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC3983 f13925;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String f13923 = getClass().getSimpleName();

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final WeakHandler f13926 = new WeakHandler(this);

    /* compiled from: Alipay.java */
    /* renamed from: ࢭ$Ϳ, reason: contains not printable characters */
    public class RunnableC3982 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f13927;

        public RunnableC3982(String str) {
            this.f13927 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> mapPayV2 = C3981.this.f13924.payV2(this.f13927, false);
            Message message = new Message();
            message.what = 1;
            message.obj = mapPayV2;
            C3981.this.f13926.sendMessage(message);
        }
    }

    /* compiled from: Alipay.java */
    /* renamed from: ࢭ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC3983 {
        void onSuccess(String str);

        /* renamed from: Ϳ */
        void mo12837(String str);

        /* renamed from: Ԩ */
        void mo12838(@Nullable String str, int i);

        /* renamed from: ԩ */
        void mo12839(String str);
    }

    public C3981(Activity activity, InterfaceC3983 interfaceC3983) {
        this.f13925 = interfaceC3983;
        this.f13924 = new PayTask(activity);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterfaceC3983 interfaceC3983;
        if (message.what != 1 || (interfaceC3983 = this.f13925) == null) {
            return true;
        }
        Object obj = message.obj;
        if (obj == null) {
            interfaceC3983.mo12838(null, 1);
            return true;
        }
        C3984 c3984 = new C3984((Map) obj);
        String strM12845 = c3984.m12845();
        String strM12846 = c3984.m12846();
        c3984.m12844();
        C4638.m14099(this.f13923, "resultStatus : " + strM12846);
        if (TextUtils.equals(strM12846, "9000")) {
            this.f13925.onSuccess(strM12845);
        } else if (TextUtils.equals(strM12846, "8000")) {
            this.f13925.mo12839(strM12845);
        } else if (TextUtils.equals(strM12846, "6001")) {
            this.f13925.mo12837(strM12845);
        } else if (TextUtils.equals(strM12846, "6002")) {
            this.f13925.mo12838(strM12845, 3);
        } else if (TextUtils.equals(strM12846, "4000")) {
            this.f13925.mo12838(strM12845, 2);
        }
        return true;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m12842() {
        this.f13924 = null;
        this.f13926.removeMessages(1);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m12843(String str) {
        new Thread(new RunnableC3982(str)).start();
    }
}
