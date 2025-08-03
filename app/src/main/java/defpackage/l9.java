package defpackage;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.R$string;

/* loaded from: classes2.dex */
public class l9 {

    /* renamed from: l9$Ϳ, reason: contains not printable characters */
    public class RunnableC2169 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Context f7950;

        public RunnableC2169(Context context) {
            this.f7950 = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ue.m8395(this.f7950)) {
                return;
            }
            String string = this.f7950.getString(R$string.system_default_channel);
            if (TextUtils.isEmpty(string)) {
                string = "System Default Channel";
            }
            ue.m8394(this.f7950, l9.this.m7491(this.f7950, "Heytap PUSH", string, 3));
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m7490(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        bg.m172(new RunnableC2169(context));
    }

    @TargetApi(26)
    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m7491(Context context, String str, String str2, int i) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i));
        return true;
    }
}
