package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dz;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fr;
import com.xiaomi.push.fy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

/* loaded from: classes2.dex */
public class ServiceClient {

    /* renamed from: a, reason: collision with other field name */
    private static ServiceClient f6327a;

    /* renamed from: a, reason: collision with other field name */
    private static String f6328a;

    /* renamed from: a, reason: collision with other field name */
    private Context f6330a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f6333a;

    /* renamed from: b, reason: collision with other field name */
    private Messenger f6334b;
    private static String b = fy.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a, reason: collision with other field name */
    private Messenger f6331a = null;

    /* renamed from: a, reason: collision with other field name */
    private final BroadcastReceiver f6329a = new BroadcastReceiver() { // from class: com.xiaomi.push.service.ServiceClient.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.av.m5215a();
        }
    };

    /* renamed from: a, reason: collision with other field name */
    private List<Message> f6332a = new ArrayList();

    /* renamed from: b, reason: collision with other field name */
    private boolean f6335b = false;

    private ServiceClient(Context context) {
        this.f6333a = false;
        Context applicationContext = context.getApplicationContext();
        this.f6330a = applicationContext;
        com.xiaomi.push.s.a(applicationContext);
        a(this.f6330a);
        if (m5711a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f6333a = true;
        }
    }

    private void b() {
        this.f6330a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f6330a, (Class<?>) XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f6327a == null) {
            f6327a = new ServiceClient(context);
        }
        return f6327a;
    }

    public static String getSession() {
        return f6328a;
    }

    public static void setSession(String str) {
        f6328a = str;
    }

    public boolean batchSendMessage(fo[] foVarArr, boolean z) {
        if (!com.xiaomi.push.av.m5216a(this.f6330a)) {
            return false;
        }
        Intent intentA = a();
        int length = foVarArr.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i = 0; i < foVarArr.length; i++) {
            String strA = dz.a();
            if (!TextUtils.isEmpty(strA)) {
                fm fmVar = new fm("pf", null, null, null);
                fm fmVar2 = new fm("sent", null, null, null);
                fmVar2.m5494a(strA);
                fmVar.a(fmVar2);
                foVarArr[i].a(fmVar);
            }
            com.xiaomi.channel.commonutils.logger.b.c("SEND:" + foVarArr[i].mo5496a());
            bundleArr[i] = foVarArr[i].a();
        }
        if (length <= 0) {
            return false;
        }
        intentA.setAction(an.g);
        intentA.putExtra(an.K, f6328a);
        intentA.putExtra("ext_packets", bundleArr);
        intentA.putExtra("ext_encrypt", z);
        return startServiceSafely(intentA);
    }

    public void checkAlive() {
        Intent intentA = a();
        intentA.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(intentA);
    }

    public boolean closeChannel() {
        Intent intentA = a();
        intentA.setAction(an.i);
        return startServiceSafely(intentA);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f6333a;
    }

    public boolean notifyMessage(Bundle bundle, String str, String str2) {
        if (bundle == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Failed to notify message: bundle|userId|chid may be empty");
            return false;
        }
        Intent intentA = a();
        intentA.setAction(an.o);
        intentA.putExtras(bundle);
        com.xiaomi.channel.commonutils.logger.b.e("notify: chid=" + str2 + " bundle:" + bundle);
        return startServiceSafely(intentA);
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean sendIQ(fn fnVar) {
        if (!com.xiaomi.push.av.m5216a(this.f6330a)) {
            return false;
        }
        Intent intentA = a();
        Bundle bundleA = fnVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fnVar.mo5496a());
        intentA.setAction(an.f);
        intentA.putExtra(an.K, f6328a);
        intentA.putExtra("ext_packet", bundleA);
        return startServiceSafely(intentA);
    }

    public boolean sendMessage(fo foVar, boolean z) {
        if (!com.xiaomi.push.av.m5216a(this.f6330a)) {
            return false;
        }
        Intent intentA = a();
        String strA = dz.a();
        if (!TextUtils.isEmpty(strA)) {
            fm fmVar = new fm("pf", null, null, null);
            fm fmVar2 = new fm("sent", null, null, null);
            fmVar2.m5494a(strA);
            fmVar.a(fmVar2);
            foVar.a(fmVar);
        }
        Bundle bundleA = foVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + foVar.mo5496a());
        intentA.setAction(an.f17901e);
        intentA.putExtra(an.K, f6328a);
        intentA.putExtra("ext_packet", bundleA);
        intentA.putExtra("ext_encrypt", z);
        return startServiceSafely(intentA);
    }

    public boolean sendPresence(fr frVar) {
        if (!com.xiaomi.push.av.m5216a(this.f6330a)) {
            return false;
        }
        Intent intentA = a();
        Bundle bundleA = frVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + frVar.mo5496a());
        intentA.setAction(an.h);
        intentA.putExtra(an.K, f6328a);
        intentA.putExtra("ext_packet", bundleA);
        return startServiceSafely(intentA);
    }

    public void setMessenger(Messenger messenger) {
        this.f6331a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (com.xiaomi.push.j.m5689a() || Build.VERSION.SDK_INT < 26) {
                this.f6330a.startService(intent);
                return true;
            }
            m5710a(intent);
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.j);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(intentA);
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent intentA = a();
        intentA.setAction(an.d);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(intentA);
        return 0;
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.k);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(intentA);
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.l);
        if (map != null) {
            String strA = a(map);
            if (!TextUtils.isEmpty(strA)) {
                intentA.putExtra(an.E, strA);
            }
        }
        if (map2 != null) {
            String strA2 = a(map2);
            if (!TextUtils.isEmpty(strA2)) {
                intentA.putExtra(an.F, strA2);
            }
        }
        intentA.putExtra(an.w, str);
        startServiceSafely(intentA);
    }

    public boolean closeChannel(String str) {
        Intent intentA = a();
        intentA.setAction(an.i);
        intentA.putExtra(an.w, str);
        return startServiceSafely(intentA);
    }

    private void a(Context context) {
        try {
            com.xiaomi.push.av.m5211a(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("add network status listener failed:" + th);
        }
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap map = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    map.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return map;
    }

    public boolean closeChannel(String str, String str2) {
        Intent intentA = a();
        intentA.setAction(an.i);
        intentA.putExtra(an.w, str);
        intentA.putExtra(an.t, str2);
        return startServiceSafely(intentA);
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(an.t, str);
        intent.putExtra(an.w, str2);
        intent.putExtra(an.A, str3);
        intent.putExtra(an.C, str5);
        intent.putExtra(an.B, str4);
        intent.putExtra(an.D, z);
        intent.putExtra(an.K, f6328a);
        intent.putExtra(an.O, this.f6331a);
        if (map != null && map.size() > 0) {
            String strA = a(map);
            if (!TextUtils.isEmpty(strA)) {
                intent.putExtra(an.E, strA);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String strA2 = a(map2);
        if (TextUtils.isEmpty(strA2)) {
            return;
        }
        intent.putExtra(an.F, strA2);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String strSubstring;
        if (com.xiaomi.push.av.m5216a(this.f6330a) && bArr != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intentA = a();
            intentA.setAction(an.f17901e);
            intentA.putExtra(an.K, f6328a);
            intentA.putExtra("ext_raw_packet", bArr);
            int iIndexOf = str.indexOf("@");
            String strSubstring2 = null;
            String strSubstring3 = iIndexOf != -1 ? str.substring(0, iIndexOf) : null;
            int iLastIndexOf = str.lastIndexOf("/");
            if (iLastIndexOf != -1) {
                strSubstring2 = str.substring(iIndexOf + 1, iLastIndexOf);
                strSubstring = str.substring(iLastIndexOf + 1);
            } else {
                strSubstring = null;
            }
            intentA.putExtra(an.t, strSubstring3);
            intentA.putExtra(an.u, strSubstring2);
            intentA.putExtra(an.v, strSubstring);
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            long j = a;
            a = 1 + j;
            sb.append(j);
            String string = sb.toString();
            intentA.putExtra("ext_pkt_id", string);
            intentA.putExtra("ext_chid", str2);
            com.xiaomi.channel.commonutils.logger.b.e("SEND: chid=" + str2 + ", packetId=" + string);
            return startServiceSafely(intentA);
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
        return false;
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(entry.getValue());
            if (i < map.size()) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i++;
        }
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m5711a() throws PackageManager.NameNotFoundException {
        if (com.xiaomi.push.y.f6515a) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f6330a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private String m5707a() {
        try {
            return this.f6330a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m5707a());
            intent.putExtra(an.G, this.f6330a.getPackageName());
            m5709a();
            return intent;
        }
        Intent intent2 = new Intent(this.f6330a, (Class<?>) XMPushService.class);
        intent2.putExtra(an.G, this.f6330a.getPackageName());
        b();
        return intent2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m5709a() {
        this.f6330a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f6330a, (Class<?>) XMPushService.class), 2, 1);
    }

    /* renamed from: a, reason: collision with other method in class */
    private synchronized void m5710a(Intent intent) {
        if (this.f6335b) {
            Message messageA = a(intent);
            if (this.f6332a.size() >= 50) {
                this.f6332a.remove(0);
            }
            this.f6332a.add(messageA);
            return;
        }
        if (this.f6334b == null) {
            this.f6330a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.push.service.ServiceClient.2
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (ServiceClient.this) {
                        ServiceClient.this.f6334b = new Messenger(iBinder);
                        ServiceClient.this.f6335b = false;
                        Iterator it = ServiceClient.this.f6332a.iterator();
                        while (it.hasNext()) {
                            try {
                                ServiceClient.this.f6334b.send((Message) it.next());
                            } catch (RemoteException e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                        ServiceClient.this.f6332a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ServiceClient.this.f6334b = null;
                    ServiceClient.this.f6335b = false;
                }
            }, 1);
            this.f6335b = true;
            this.f6332a.clear();
            this.f6332a.add(a(intent));
        } else {
            try {
                this.f6334b.send(a(intent));
            } catch (RemoteException unused) {
                this.f6334b = null;
                this.f6335b = false;
            }
        }
    }

    private Message a(Intent intent) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 17;
        messageObtain.obj = intent;
        return messageObtain;
    }
}
