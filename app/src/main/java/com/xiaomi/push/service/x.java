package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blink.academy.film.stream.FinderManager;
import com.polidea.rxandroidble2.ClientComponent;
import com.xiaomi.push.af;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.g;
import com.xiaomi.push.gg;
import com.xiaomi.push.gt;
import com.xiaomi.push.hc;
import com.xiaomi.push.service.ae;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class x {
    public static long a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile ab f6493a;

    /* renamed from: a, reason: collision with other field name */
    private static final LinkedList<Pair<Integer, hc>> f6494a = new LinkedList<>();

    /* renamed from: a, reason: collision with other field name */
    private static ExecutorService f6495a = Executors.newCachedThreadPool();

    public static class a implements Callable<Bitmap> {
        private Context a;

        /* renamed from: a, reason: collision with other field name */
        private String f6498a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f6499a;

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f6498a = str;
            this.f6499a = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() throws Throwable {
            if (TextUtils.isEmpty(this.f6498a)) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f6498a.startsWith("http")) {
                ae.b bVarA = ae.a(this.a, this.f6498a, this.f6499a);
                if (bVarA != null) {
                    return bVarA.f6383a;
                }
                com.xiaomi.channel.commonutils.logger.b.m5113a("Failed get online picture/icon resource");
                return null;
            }
            Bitmap bitmapA = ae.a(this.a, this.f6498a);
            if (bitmapA != null) {
                return bitmapA;
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("Failed get online picture/icon resource");
            return bitmapA;
        }
    }

    public static class b {
        public long a = 0;

        /* renamed from: a, reason: collision with other field name */
        public Notification f6500a;
    }

    public static class c {

        /* renamed from: a, reason: collision with other field name */
        public String f6501a;
        public long a = 0;

        /* renamed from: a, reason: collision with other field name */
        public boolean f6502a = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5821a(Context context, String str) {
        return com.xiaomi.push.g.m5515b(context, str);
    }

    /* renamed from: b, reason: collision with other method in class */
    private static boolean m5828b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("meta extra is null");
        return false;
    }

    public static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean d(hc hcVar) {
        return hcVar.a() == gg.Registration;
    }

    public static boolean e(hc hcVar) {
        return m5823a(hcVar) || c(hcVar) || m5827b(hcVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5822a(Context context, String str, boolean z) {
        return com.xiaomi.push.j.m5689a() && !z && m5821a(context, str);
    }

    public static boolean c(hc hcVar) {
        gt gtVarM5593a = hcVar.m5593a();
        return a(gtVarM5593a) && gtVarM5593a.f6040b == 0 && !m5823a(hcVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static c m5819a(Context context, hc hcVar, byte[] bArr) {
        int iC;
        Map<String, String> mapM5560a;
        Bundle bundle;
        c cVar = new c();
        g.b bVarA = com.xiaomi.push.g.a(context, a(hcVar), true);
        gt gtVarM5593a = hcVar.m5593a();
        if (gtVarM5593a != null) {
            iC = gtVarM5593a.c();
            mapM5560a = gtVarM5593a.m5560a();
        } else {
            iC = 0;
            mapM5560a = null;
        }
        final int iB = com.xiaomi.push.t.b(a(hcVar), iC);
        if (com.xiaomi.push.j.m5690a(context) && bVarA == g.b.NOT_ALLOWED) {
            if (gtVarM5593a != null) {
                du.a(context.getApplicationContext()).a(hcVar.b(), b(hcVar), gtVarM5593a.m5559a(), "10:" + a(hcVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("Do not notify because user block " + a(hcVar) + "‘s notification");
            return cVar;
        }
        if (com.xiaomi.push.j.m5690a(context) && f6493a != null && f6493a.m5736a(context, iB, a(hcVar), mapM5560a)) {
            if (gtVarM5593a != null) {
                du.a(context.getApplicationContext()).a(hcVar.b(), b(hcVar), gtVarM5593a.m5559a(), "14:" + a(hcVar));
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("Do not notify because card notification is canceled or sequence incorrect");
            return cVar;
        }
        RemoteViews remoteViewsA = a(context, hcVar, bArr);
        Bundle bundle2 = new Bundle();
        PendingIntent pendingIntentA = a(context, hcVar, hcVar.b(), bArr, iB, bundle2);
        if (pendingIntentA == null) {
            if (gtVarM5593a != null) {
                du.a(context.getApplicationContext()).a(hcVar.b(), b(hcVar), gtVarM5593a.m5559a(), "11");
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("The click PendingIntent is null. ");
            return cVar;
        }
        b bVarA2 = a(context, hcVar, bArr, remoteViewsA, pendingIntentA, iB);
        cVar.a = bVarA2.a;
        cVar.f6501a = a(hcVar);
        Notification notification = bVarA2.f6500a;
        if (com.xiaomi.push.j.m5690a(context) && notification != null && (bundle = notification.extras) != null && mapM5560a != null) {
            bundle.putAll(bundle2);
            ag.a(mapM5560a, notification.extras, "use_clicked_activity", "xmsf.stat.useNCA", false);
        }
        if (com.xiaomi.push.j.m5689a()) {
            if (!TextUtils.isEmpty(gtVarM5593a.m5559a())) {
                notification.extras.putString("message_id", gtVarM5593a.m5559a());
            }
            notification.extras.putString("local_paid", hcVar.m5594a());
            ag.a(mapM5560a, notification.extras, "msg_busi_type");
            ag.a(mapM5560a, notification.extras, "disable_notification_flags");
            String str = gtVarM5593a.m5565b() == null ? null : gtVarM5593a.m5565b().get("score_info");
            if (!TextUtils.isEmpty(str)) {
                notification.extras.putString("score_info", str);
            }
            notification.extras.putString("pushUid", a(gtVarM5593a.f6038a, "n_stats_expose"));
            int i = -1;
            if (c(hcVar)) {
                i = 1000;
            } else if (m5823a(hcVar)) {
                i = 3000;
            }
            notification.extras.putString("eventMessageType", String.valueOf(i));
            notification.extras.putString("target_package", a(hcVar));
        }
        String str2 = gtVarM5593a.m5560a() != null ? gtVarM5593a.m5560a().get("message_count") : null;
        if (com.xiaomi.push.j.m5689a() && str2 != null) {
            try {
                ag.a(notification, Integer.parseInt(str2));
            } catch (NumberFormatException e2) {
                du.a(context.getApplicationContext()).b(hcVar.b(), b(hcVar), gtVarM5593a.m5559a(), FinderManager.MACHINE_D);
                com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e2);
            }
        }
        String strA = a(hcVar);
        ag.m5754a(notification, strA);
        final af afVarA = af.a(context, strA);
        if (com.xiaomi.push.j.m5690a(context) && f6493a != null) {
            f6493a.a(hcVar, gtVarM5593a.m5560a(), iB, notification);
        }
        if (com.xiaomi.push.j.m5690a(context) && f6493a != null && f6493a.a(gtVarM5593a.m5560a(), iB, notification)) {
            com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
        } else {
            afVarA.a(iB, notification);
            cVar.f6502a = true;
            com.xiaomi.channel.commonutils.logger.b.m5113a("notification: " + gtVarM5593a.m5559a() + " is notifyied");
        }
        if (com.xiaomi.push.j.m5689a() && com.xiaomi.push.j.m5690a(context)) {
            ad.a().a(context, iB, notification);
            bb.m5779a(context, strA, iB, gtVarM5593a.m5559a(), notification);
        }
        if (m5823a(hcVar)) {
            du.a(context.getApplicationContext()).a(hcVar.b(), b(hcVar), gtVarM5593a.m5559a(), 3002, null);
        }
        if (c(hcVar)) {
            du.a(context.getApplicationContext()).a(hcVar.b(), b(hcVar), gtVarM5593a.m5559a(), 1002, null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            String strM5559a = gtVarM5593a.m5559a();
            com.xiaomi.push.af afVarA2 = com.xiaomi.push.af.a(context);
            int iA = a(gtVarM5593a.m5560a());
            if (iA > 0 && !TextUtils.isEmpty(strM5559a)) {
                final String str3 = "n_timeout_" + strM5559a;
                afVarA2.m5196a(str3);
                afVarA2.b(new af.a() { // from class: com.xiaomi.push.service.x.1
                    @Override // com.xiaomi.push.af.a
                    /* renamed from: a */
                    public String mo5248a() {
                        return str3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        afVarA.a(iB);
                    }
                }, iA);
            }
        }
        Pair<Integer, hc> pair = new Pair<>(Integer.valueOf(iB), hcVar);
        LinkedList<Pair<Integer, hc>> linkedList = f6494a;
        synchronized (linkedList) {
            linkedList.add(pair);
            if (linkedList.size() > 100) {
                linkedList.remove();
            }
        }
        return cVar;
    }

    private static int b(Context context, String str) {
        int iA = a(context, str, "mipush_notification");
        int iA2 = a(context, str, "mipush_small_notification");
        if (iA <= 0) {
            iA = iA2 > 0 ? iA2 : context.getApplicationInfo().icon;
        }
        return iA == 0 ? context.getApplicationInfo().logo : iA;
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e2);
            return 0;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static void m5825b(Context context, String str) {
        if (!com.xiaomi.push.j.m5690a(context) || f6493a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f6493a.a(str);
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m5826b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m5827b(hc hcVar) {
        gt gtVarM5593a = hcVar.m5593a();
        return a(gtVarM5593a) && gtVarM5593a.f6040b == 1 && !m5823a(hcVar);
    }

    public static String b(hc hcVar) {
        return m5823a(hcVar) ? "E100002" : c(hcVar) ? "E100000" : m5827b(hcVar) ? "E100001" : d(hcVar) ? "E100003" : "";
    }

    private static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e2);
            return 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0196 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent b(android.content.Context r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, int r11, android.os.Bundle r12) throws java.net.URISyntaxException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.b(android.content.Context, java.lang.String, java.util.Map, int, android.os.Bundle):android.content.Intent");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(android.content.Context r2, java.lang.String r3, com.xiaomi.push.dw r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            boolean r0 = com.xiaomi.push.j.m5690a(r2)
            if (r0 != 0) goto L2c
            java.lang.String r0 = "fcm_icon_uri"
            java.lang.String r0 = a(r5, r0)
            java.lang.String r1 = "fcm_icon_color"
            java.lang.String r5 = a(r5, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L2c
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L2c
            int r0 = a(r2, r3, r0)
            if (r0 <= 0) goto L2c
            r1 = 1
            r4.setSmallIcon(r0)
            r4.mo5427a(r5)
            goto L2d
        L2c:
            r1 = 0
        L2d:
            if (r1 != 0) goto L3a
            int r2 = com.xiaomi.push.service.ag.a(r2, r3)
            android.graphics.drawable.Icon r2 = android.graphics.drawable.Icon.createWithResource(r3, r2)
            r4.setSmallIcon(r2)
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.b(android.content.Context, java.lang.String, com.xiaomi.push.dw, java.util.Map):void");
    }

    private static PendingIntent a(Context context, hc hcVar, String str, byte[] bArr, int i, Bundle bundle) {
        return a(context, hcVar, str, bArr, i, 0, a(context, hcVar, str), bundle);
    }

    private static PendingIntent a(Context context, hc hcVar, String str, byte[] bArr, int i, int i2, boolean z, Bundle bundle) {
        int i3;
        Intent intent;
        if (c(hcVar)) {
            i3 = 1000;
        } else {
            i3 = m5823a(hcVar) ? 3000 : -1;
        }
        gt gtVarM5593a = hcVar.m5593a();
        String strM5559a = gtVarM5593a != null ? gtVarM5593a.m5559a() : "";
        boolean zM5823a = m5823a(hcVar);
        if (gtVarM5593a != null && !TextUtils.isEmpty(gtVarM5593a.f6047e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(gtVarM5593a.f6047e));
            try {
                String protocol = new URL(gtVarM5593a.f6047e).getProtocol();
                if (!"http".equals(protocol) && !"https".equals(protocol)) {
                    intent2.setPackage(str);
                } else {
                    ag.a(context, str, intent2);
                }
            } catch (MalformedURLException unused) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("meet URL exception : " + gtVarM5593a.f6047e);
                intent2.setPackage(str);
            }
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", strM5559a);
            intent2.putExtra("eventMessageType", i3);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getActivity(context, 0, intent2, 167772160);
            }
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        if (zM5823a) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(strM5559a));
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(strM5559a));
        }
        intent.putExtra("notification_click_button", i2);
        intent.putExtra("messageId", strM5559a);
        intent.putExtra("eventMessageType", i3);
        if (!zM5823a && z) {
            Intent intent3 = new Intent();
            intent3.setComponent(a(str));
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.putExtra("messageId", strM5559a);
            intent3.putExtra("mipush_notified", true);
            intent3.addCategory(String.valueOf(i));
            intent3.addCategory(String.valueOf(strM5559a));
            intent3.addCategory(String.valueOf(i2));
            a(context, intent3, hcVar, gtVarM5593a, strM5559a, i2, bundle);
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getActivity(context, 0, intent3, 167772160);
            }
            return PendingIntent.getActivity(context, 0, intent3, 134217728);
        }
        a(context, intent, hcVar, gtVarM5593a, strM5559a, i2, bundle);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getService(context, 0, intent, 167772160);
        }
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    private static void a(Context context, Intent intent, hc hcVar, gt gtVar, String str, int i, Bundle bundle) {
        ComponentName component;
        if (hcVar == null || gtVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a(gtVar.m5560a(), i);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        if (an.a.equals(strA) || an.b.equals(strA) || an.c.equals(strA)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", hcVar.f6126a);
            if (!TextUtils.isEmpty(hcVar.f6130b)) {
                intent.putExtra("target_package", hcVar.f6130b);
            }
            intent.putExtra("job_key", a(gtVar.m5560a(), "jobkey"));
            intent.putExtra(i + "_target_component", a(context, hcVar.f6130b, gtVar.m5560a(), i, bundle));
            if (!com.xiaomi.push.j.m5690a(context) || bundle == null || (component = intent.getComponent()) == null) {
                return;
            }
            bundle.putString(a("xmsf.stat.transfCompo", i), component.flattenToString());
        }
    }

    private static boolean a(Context context, hc hcVar, String str) {
        if (hcVar != null && hcVar.m5593a() != null && hcVar.m5593a().m5560a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(hcVar.m5593a().m5560a().get("use_clicked_activity")) && j.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("should clicked activity params are null.");
        return false;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[PHI: r0 r3
      0x0072: PHI (r0v4 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:18:0x0070, B:10:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r3v15 java.lang.String) = (r3v14 java.lang.String), (r3v21 java.lang.String) binds: [B:18:0x0070, B:10:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] a(android.content.Context r3, com.xiaomi.push.gt r4) {
        /*
            java.lang.String r0 = r4.m5567c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.m5560a()
            if (r4 == 0) goto L73
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L51
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L42
            r0 = r3
        L42:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
            goto L72
        L51:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L73
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L64
            r0 = r3
        L64:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
        L72:
            r1 = r3
        L73:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.gt):java.lang.String[]");
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static int a(Context context, String str, Map<String, String> map, int i, Bundle bundle) throws URISyntaxException, NumberFormatException {
        ComponentName componentNameA;
        Intent intentB = b(context, str, map, i, bundle);
        if (intentB == null || (componentNameA = j.a(context, intentB)) == null) {
            return 0;
        }
        if (com.xiaomi.push.j.m5690a(context) && bundle != null) {
            bundle.putString(a("xmsf.stat.tgtCompo", i), componentNameA.flattenToString());
        }
        return componentNameA.hashCode();
    }

    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + "_" + i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0415 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x029d  */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v4 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.x.b a(android.content.Context r26, com.xiaomi.push.hc r27, byte[] r28, android.widget.RemoteViews r29, android.app.PendingIntent r30, int r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, com.xiaomi.push.hc, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.x$b");
    }

    @TargetApi(16)
    private static void a(dw dwVar, Context context, String str, hc hcVar, byte[] bArr, int i) {
        PendingIntent pendingIntentA;
        PendingIntent pendingIntentA2;
        PendingIntent pendingIntentA3;
        PendingIntent pendingIntentA4;
        Map<String, String> mapM5560a = hcVar.m5593a().m5560a();
        if (TextUtils.equals("3", mapM5560a.get("notification_style_type")) || TextUtils.equals(FinderManager.MACHINE_C, mapM5560a.get("notification_style_type"))) {
            return;
        }
        Bundle bundle = new Bundle();
        if (m5828b(mapM5560a)) {
            for (int i2 = 1; i2 <= 3; i2++) {
                String str2 = mapM5560a.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                if (!TextUtils.isEmpty(str2) && (pendingIntentA4 = a(context, str, hcVar, bArr, i, i2, bundle)) != null) {
                    dwVar.addAction(0, str2, pendingIntentA4);
                }
            }
            dwVar.addExtras(bundle);
            return;
        }
        if (!TextUtils.isEmpty(mapM5560a.get("notification_style_button_left_name")) && (pendingIntentA3 = a(context, str, hcVar, bArr, i, 1, bundle)) != null) {
            dwVar.addAction(0, mapM5560a.get("notification_style_button_left_name"), pendingIntentA3);
        }
        if (!TextUtils.isEmpty(mapM5560a.get("notification_style_button_mid_name")) && (pendingIntentA2 = a(context, str, hcVar, bArr, i, 2, bundle)) != null) {
            dwVar.addAction(0, mapM5560a.get("notification_style_button_mid_name"), pendingIntentA2);
        }
        if (!TextUtils.isEmpty(mapM5560a.get("notification_style_button_right_name")) && (pendingIntentA = a(context, str, hcVar, bArr, i, 3, bundle)) != null) {
            dwVar.addAction(0, mapM5560a.get("notification_style_button_right_name"), pendingIntentA);
        }
        dwVar.addExtras(bundle);
    }

    private static PendingIntent a(Context context, String str, hc hcVar, byte[] bArr, int i, int i2, Bundle bundle) {
        Map<String, String> mapM5560a = hcVar.m5593a().m5560a();
        if (mapM5560a == null) {
            return null;
        }
        boolean zA = a(context, hcVar, str);
        if (zA) {
            return a(context, hcVar, str, bArr, i, i2, zA, bundle);
        }
        Intent intentM5818a = m5818a(context, str, mapM5560a, i2, bundle);
        if (intentM5818a == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, intentM5818a, 167772160);
        }
        return PendingIntent.getActivity(context, 0, intentM5818a, 134217728);
    }

    public static String a(Map<String, String> map, int i) {
        String str;
        if (i == 0) {
            str = "notify_effect";
        } else {
            str = m5828b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        }
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Intent m5818a(Context context, String str, Map<String, String> map, int i, Bundle bundle) {
        if (m5828b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)), i, bundle);
        }
        if (i == 1) {
            return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri", i, bundle);
        }
        if (i == 2) {
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri", i, bundle);
        }
        if (i == 3) {
            return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri", i, bundle);
        }
        if (i != 4) {
            return null;
        }
        return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri", i, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x015c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent a(android.content.Context r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, android.os.Bundle r12) throws java.net.URISyntaxException {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, android.os.Bundle):android.content.Intent");
    }

    @TargetApi(16)
    private static dw a(Context context, hc hcVar, byte[] bArr, String str, int i) {
        String strA = a(hcVar);
        Map<String, String> mapM5560a = hcVar.m5593a().m5560a();
        String str2 = mapM5560a.get("notification_style_type");
        dw dwVarA = (!com.xiaomi.push.j.m5690a(context) || f6493a == null) ? null : f6493a.a(context, i, strA, mapM5560a);
        if (dwVarA != null) {
            dwVarA.a(mapM5560a);
            return dwVarA;
        }
        if ("2".equals(str2)) {
            dw dwVar = new dw(context);
            Bitmap bitmapA = TextUtils.isEmpty(mapM5560a.get("notification_bigPic_uri")) ? null : a(context, mapM5560a.get("notification_bigPic_uri"), false);
            if (bitmapA == null) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("can not get big picture.");
                return dwVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(dwVar);
            bigPictureStyle.bigPicture(bitmapA);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            dwVar.setStyle(bigPictureStyle);
            return dwVar;
        }
        if ("1".equals(str2)) {
            dw dwVar2 = new dw(context);
            dwVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return dwVar2;
        }
        if (FinderManager.MACHINE_C.equals(str2) && com.xiaomi.push.j.m5689a()) {
            dv dvVar = new dv(context, strA);
            if (!TextUtils.isEmpty(mapM5560a.get("notification_banner_image_uri"))) {
                dvVar.setLargeIcon(a(context, mapM5560a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(mapM5560a.get("notification_banner_icon_uri"))) {
                dvVar.b(a(context, mapM5560a.get("notification_banner_icon_uri"), false));
            }
            dvVar.a(mapM5560a);
            return dvVar;
        }
        if ("3".equals(str2) && com.xiaomi.push.j.m5689a()) {
            dx dxVar = new dx(context, i, strA);
            if (!TextUtils.isEmpty(mapM5560a.get("notification_colorful_button_text"))) {
                Bundle bundle = new Bundle();
                PendingIntent pendingIntentA = a(context, strA, hcVar, bArr, i, 4, bundle);
                if (pendingIntentA != null) {
                    dxVar.a(mapM5560a.get("notification_colorful_button_text"), pendingIntentA).mo5427a(mapM5560a.get("notification_colorful_button_bg_color"));
                }
                dxVar.addExtras(bundle);
            }
            if (!TextUtils.isEmpty(mapM5560a.get("notification_colorful_bg_color"))) {
                dxVar.b(mapM5560a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(mapM5560a.get("notification_colorful_bg_image_uri"))) {
                dxVar.setLargeIcon(a(context, mapM5560a.get("notification_colorful_bg_image_uri"), false));
            }
            dxVar.a(mapM5560a);
            return dxVar;
        }
        return new dw(context);
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get(ClientComponent.NamedSchedulers.TIMEOUT);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static RemoteViews a(Context context, hc hcVar, byte[] bArr) throws JSONException, PackageManager.NameNotFoundException {
        gt gtVarM5593a = hcVar.m5593a();
        String strA = a(hcVar);
        if (gtVarM5593a != null && gtVarM5593a.m5560a() != null) {
            Map<String, String> mapM5560a = gtVarM5593a.m5560a();
            String str = mapM5560a.get("layout_name");
            String str2 = mapM5560a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(strA);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", strA);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(strA, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", strA);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> itKeys2 = jSONObject3.keys();
                            while (itKeys2.hasNext()) {
                                String next2 = itKeys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", strA);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", strA);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> itKeys3 = jSONObject4.keys();
                            while (itKeys3.hasNext()) {
                                String next3 = itKeys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", strA);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                }
            }
        }
        return null;
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private static Notification a(Notification notification) {
        Object objA = com.xiaomi.push.ax.a(notification, "extraNotification");
        if (objA != null) {
            com.xiaomi.push.ax.a(objA, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    public static String a(hc hcVar) {
        gt gtVarM5593a;
        if ("com.xiaomi.xmsf".equals(hcVar.f6130b) && (gtVarM5593a = hcVar.m5593a()) != null && gtVarM5593a.m5560a() != null) {
            String str = gtVarM5593a.m5560a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hcVar.f6130b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5820a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int iHashCode;
        if (context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        af afVarA = af.a(context, str);
        List<StatusBarNotification> listM5753b = afVarA.m5753b();
        if (com.xiaomi.push.t.a(listM5753b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        if (i == -1) {
            z = true;
            iHashCode = 0;
        } else {
            iHashCode = ((str.hashCode() / 10) * 10) + i;
        }
        Iterator<StatusBarNotification> it = listM5753b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    afVarA.a(id);
                } else if (iHashCode == id) {
                    d.a(context, next, i2);
                    linkedList.add(next);
                    afVarA.a(id);
                    break;
                }
            }
        }
        a(context, (LinkedList<? extends Object>) linkedList);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        af afVarA = af.a(context, str);
        List<StatusBarNotification> listM5753b = afVarA.m5753b();
        if (com.xiaomi.push.t.a(listM5753b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : listM5753b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String strA = ag.a(notification);
                String strB = ag.b(notification);
                if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB) && a(strA, str2) && a(strB, str3)) {
                    linkedList.add(statusBarNotification);
                    afVarA.a(id);
                }
            }
        }
        a(context, (LinkedList<? extends Object>) linkedList);
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        az.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5824a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static boolean a(gt gtVar) {
        if (gtVar == null) {
            return false;
        }
        String strM5559a = gtVar.m5559a();
        return !TextUtils.isEmpty(strM5559a) && strM5559a.length() == 22 && "satuigmo".indexOf(strM5559a.charAt(0)) >= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5823a(hc hcVar) {
        gt gtVarM5593a = hcVar.m5593a();
        return a(gtVarM5593a) && gtVarM5593a.l();
    }

    private static Bitmap a(Context context, String str, boolean z) {
        Future futureSubmit = f6495a.submit(new a(str, context, z));
        try {
            try {
                try {
                    Bitmap bitmap = (Bitmap) futureSubmit.get(180L, TimeUnit.SECONDS);
                    return bitmap == null ? bitmap : bitmap;
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    futureSubmit.cancel(true);
                    return null;
                } catch (TimeoutException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                    futureSubmit.cancel(true);
                    return null;
                }
            } catch (ExecutionException e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                futureSubmit.cancel(true);
                return null;
            }
        } finally {
            futureSubmit.cancel(true);
        }
    }

    private static String a(Context context, String str, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_name"))) {
            return map.get("channel_name");
        }
        return com.xiaomi.push.g.m5514b(context, str);
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return b(context, str, map, i, null);
    }

    private static void a(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.setFlags(intent.getFlags() & (-2) & (-3) & (-65) & (-129));
    }

    private static void a(Context context, String str, dw dwVar, Map<String, String> map) {
        int iA = a(context, str, "mipush_small_notification");
        int iA2 = a(context, str, "mipush_notification");
        if (com.xiaomi.push.j.m5690a(context)) {
            if (iA > 0 && iA2 > 0) {
                dwVar.setSmallIcon(iA);
                dwVar.setLargeIcon(a(context, iA2));
                return;
            } else {
                b(context, str, dwVar, map);
                return;
            }
        }
        if (iA > 0) {
            dwVar.setSmallIcon(iA);
        } else {
            b(context, str, dwVar, map);
        }
        if (iA2 > 0) {
            dwVar.setLargeIcon(a(context, iA2));
        }
    }
}
