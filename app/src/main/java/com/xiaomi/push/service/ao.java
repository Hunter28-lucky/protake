package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.cd;
import com.xiaomi.push.cg;
import com.xiaomi.push.ch;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.ej;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.fb;
import com.xiaomi.push.fy;
import com.xiaomi.push.service.ax;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class ao extends ax.a implements ch.a {
    private long a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f6413a;

    public static class a implements ch.b {
        @Override // com.xiaomi.push.ch.b
        public String a(String str) throws IOException {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            builderBuildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            builderBuildUpon.appendQueryParameter(com.umeng.analytics.pro.am.x, fy.a(com.xiaomi.push.j.e()));
            builderBuildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.s.a()));
            String string = builderBuildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + string);
            URL url = new URL(string);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = com.xiaomi.push.av.a(com.xiaomi.push.s.m5702a(), url);
                eq.a(url.getHost() + Constants.COLON_SEPARATOR + port, (int) (System.currentTimeMillis() - jCurrentTimeMillis), null);
                return strA;
            } catch (IOException e2) {
                eq.a(url.getHost() + Constants.COLON_SEPARATOR + port, -1, e2);
                throw e2;
            }
        }
    }

    public static class b extends ch {
        public b(Context context, cg cgVar, ch.b bVar, String str) {
            super(context, cgVar, bVar, str);
        }

        @Override // com.xiaomi.push.ch
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) throws IOException {
            try {
                if (ep.m5447a().m5452a()) {
                    str2 = ax.m5771a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                eq.a(0, ej.GSLB_ERR.a(), 1, null, com.xiaomi.push.av.b(ch.a) ? 1 : 0);
                throw e2;
            }
        }
    }

    public ao(XMPushService xMPushService) {
        this.f6413a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ao aoVar = new ao(xMPushService);
        ax.a().a(aoVar);
        synchronized (ch.class) {
            ch.a(aoVar);
            ch.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(dp.a aVar) {
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(dq.b bVar) throws JSONException {
        cd cdVarB;
        if (bVar.m5363b() && bVar.m5362a() && System.currentTimeMillis() - this.a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("fetch bucket :" + bVar.m5362a());
            this.a = System.currentTimeMillis();
            ch chVarA = ch.a();
            chVarA.m5296a();
            chVarA.m5299b();
            fb fbVarM5726a = this.f6413a.m5726a();
            if (fbVarM5726a == null || (cdVarB = chVarA.b(fbVarM5726a.m5478a().c())) == null) {
                return;
            }
            ArrayList<String> arrayListM5283a = cdVarB.m5283a();
            boolean z = true;
            Iterator<String> it = arrayListM5283a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(fbVarM5726a.mo5479a())) {
                    z = false;
                    break;
                }
            }
            if (!z || arrayListM5283a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("bucket changed, force reconnect");
            this.f6413a.a(0, (Exception) null);
            this.f6413a.a(false);
        }
    }

    @Override // com.xiaomi.push.ch.a
    public ch a(Context context, cg cgVar, ch.b bVar, String str) {
        return new b(context, cgVar, bVar, str);
    }
}
