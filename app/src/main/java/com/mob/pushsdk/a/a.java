package com.mob.pushsdk.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPush;
import com.mob.pushsdk.MobPushCustomMessage;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.R;
import com.mob.pushsdk.a.c;
import com.mob.pushsdk.b.e;
import com.mob.pushsdk.b.g;
import com.mob.pushsdk.b.h;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.biz.d;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class a {
    private static a a = null;
    private static boolean b = false;
    private NotificationManager c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private NotificationChannel f17690e;
    private String f = "通知";
    private Hashon g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private h m;
    private int n;
    private String o;

    private a() {
        this.f17690e = null;
        try {
            this.g = new Hashon();
            this.m = h.a();
            Context context = MobSDK.getContext();
            this.c = (NotificationManager) context.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                String str = this.f;
                NotificationChannel notificationChannel = new NotificationChannel(str, str, 2);
                this.f17690e = notificationChannel;
                notificationChannel.enableLights(true);
                this.f17690e.setLightColor(-65536);
                this.f17690e.enableVibration(true);
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
                if (d.n() < 1) {
                    this.h = applicationInfo.icon;
                } else {
                    this.h = d.n();
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.h = 0;
            }
            int[] iArrI = d.i();
            if (iArrI != null && iArrI.length == 4) {
                this.i = iArrI[0];
                this.j = iArrI[1];
                this.k = iArrI[2];
                this.l = iArrI[3];
            }
            try {
                b = e.a();
            } catch (Throwable unused2) {
                b = false;
            }
            String strB = h.b();
            this.o = h.a().c();
            strB = strB.contains(".") ? strB.substring(0, strB.indexOf(".")) : strB;
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            try {
                this.n = Integer.parseInt(strB);
            } catch (Throwable unused3) {
                this.n = 0;
            }
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Notification.Builder b() {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = this.f17690e) == null) {
            return new Notification.Builder(MobSDK.getContext());
        }
        this.c.createNotificationChannel(notificationChannel);
        return new Notification.Builder(MobSDK.getContext(), this.f);
    }

    public static synchronized a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public void a(final MobPushCustomMessage mobPushCustomMessage, final int i) {
        new Thread() { // from class: com.mob.pushsdk.a.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                final Notification.Builder builderB;
                float f;
                RemoteViews remoteViewsA;
                RemoteViews remoteViewsA2;
                super.run();
                if (mobPushCustomMessage == null || (builderB = a.this.b()) == null) {
                    return;
                }
                builderB.setDefaults(7);
                HashMap mapFromJson = a.this.g.fromJson(mobPushCustomMessage.getContent());
                if (mapFromJson == null) {
                    return;
                }
                String str = mapFromJson.containsKey("title") ? (String) mapFromJson.get("title") : null;
                String str2 = mapFromJson.containsKey("content") ? (String) mapFromJson.get("content") : null;
                String str3 = mapFromJson.containsKey("iconUrl") ? (String) mapFromJson.get("iconUrl") : null;
                String str4 = mapFromJson.containsKey("banner") ? (String) mapFromJson.get("banner") : null;
                long timestamp = mobPushCustomMessage.getTimestamp();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = (ArrayList) mapFromJson.get("imgs");
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        arrayList.add(((HashMap) arrayList2.get(i2)).get("imgUrl"));
                    }
                }
                if (mapFromJson.containsKey("speed")) {
                    try {
                        f = Float.parseFloat((String) mapFromJson.get("speed"));
                    } catch (Throwable unused) {
                        PLog.getInstance().d("ad push speed:0.0", new Object[0]);
                    }
                } else {
                    f = 0.0f;
                }
                builderB.setTicker(str2);
                builderB.setSmallIcon(a.this.h);
                builderB.setAutoCancel(true);
                builderB.setWhen(timestamp);
                builderB.setColor(0);
                final MobPushNotifyMessage mobPushNotifyMessage = new MobPushNotifyMessage();
                mobPushNotifyMessage.setTitle(str);
                mobPushNotifyMessage.setContent(str2);
                mobPushNotifyMessage.setChannel(0);
                mobPushNotifyMessage.setExtrasMap(mobPushCustomMessage.getExtrasMap());
                mobPushNotifyMessage.setMessageId(mobPushCustomMessage.getMessageId());
                mobPushNotifyMessage.setStyle(0);
                mobPushNotifyMessage.setTimestamp(mobPushCustomMessage.getTimestamp());
                final Context context = MobSDK.getContext();
                int i3 = i;
                if (2 == i3) {
                    remoteViewsA = a.this.a(str, str2);
                    builderB.setGroup("txt");
                } else if (1 == i3) {
                    if (TextUtils.isEmpty(str3)) {
                        remoteViewsA2 = null;
                        builderB.setGroup("iconContent");
                        remoteViewsA = remoteViewsA2;
                    } else {
                        try {
                            remoteViewsA2 = a.this.a(str, str2, BitmapHelper.getBitmap(context, str3));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        builderB.setGroup("iconContent");
                        remoteViewsA = remoteViewsA2;
                    }
                } else if (3 == i3) {
                    try {
                        remoteViewsA = a.this.a(BitmapHelper.getBitmap(context, str4));
                        builderB.setGroup("banner");
                    } catch (Throwable unused2) {
                        PLog.getInstance().d("tcp banner bitmap:" + ((Object) null) + ",banner:" + str4, new Object[0]);
                        return;
                    }
                } else {
                    if (4 == i3) {
                        if (arrayList.size() > 0) {
                            final float f2 = f;
                            new c().a(arrayList, new c.a() { // from class: com.mob.pushsdk.a.a.1.1
                                @Override // com.mob.pushsdk.a.c.a
                                public void a(Bitmap[] bitmapArr) {
                                    if (bitmapArr == null) {
                                        return;
                                    }
                                    RemoteViews remoteViewsA3 = a.this.a(bitmapArr, f2);
                                    builderB.setGroup("gifBanner");
                                    a.this.a(context, builderB, remoteViewsA3, mobPushNotifyMessage);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    remoteViewsA = null;
                }
                a.this.a(context, builderB, remoteViewsA, mobPushNotifyMessage);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Notification.Builder builder, RemoteViews remoteViews, MobPushNotifyMessage mobPushNotifyMessage) {
        if (remoteViews != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setCustomContentView(remoteViews);
            } else {
                builder.setContent(remoteViews);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushNotifyMessage);
        bundle.putInt("type", 2);
        Intent intent = new Intent("com.mob.push.intent.NOTIFICATION_OPENED");
        intent.putExtras(bundle);
        intent.setPackage(MobSDK.getContext().getPackageName());
        builder.setContentIntent(g.b(context, 2, intent, 134217728));
        Notification notificationA = a(builder);
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        int i3 = this.i;
        int i4 = this.k;
        if (i3 <= i4 ? !(i3 != i4 ? (i != i3 || i2 < this.j) && ((i <= i3 || i >= i4) && (i != i4 || i2 > this.l)) : i != i3 || i2 < this.j || i2 > this.l) : !((i != i3 || i2 < this.j) && i <= i3 && i >= i4 && (i != i4 || i2 > this.l))) {
            notificationA.defaults = 0;
            notificationA.sound = null;
            notificationA.vibrate = null;
            notificationA.ledOffMS = 0;
            notificationA.ledOnMS = 0;
            notificationA.ledARGB = 0;
        }
        NotificationManager notificationManager = this.c;
        int i5 = this.d + 1;
        this.d = i5;
        notificationManager.notify(i5, notificationA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteViews a(String str, String str2) {
        int layoutRes;
        Context context = MobSDK.getContext();
        if (MobPush.Channels.XIAOMI.equalsIgnoreCase(this.o)) {
            if (this.n >= 10) {
                layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_ui10_xiaomi");
            } else {
                layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_xiaomi");
            }
        } else if (MobPush.Channels.OPPO.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_oppo");
        } else if (MobPush.Channels.VIVO.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_vivo");
        } else if (MobPush.Channels.HUAWEI.equalsIgnoreCase(this.o)) {
            int layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_huawei");
            int i = this.n;
            if (i == 3) {
                layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_ui3_huawei");
            } else {
                layoutRes = i > 3 ? ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_huawei") : layoutRes2;
            }
        } else if (!MobPush.Channels.MEIZU.equalsIgnoreCase(this.o)) {
            layoutRes = 0;
        } else if (this.n >= 7) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_n_meizu");
        } else {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent_meizu");
        }
        if (layoutRes <= 0) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_titlecontent");
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), layoutRes);
        int i2 = R.id.tvTitle;
        remoteViews.setTextViewText(i2, str);
        int i3 = R.id.tvContent;
        remoteViews.setTextViewText(i3, str2);
        if (b) {
            remoteViews.setTextColor(i2, -1);
            remoteViews.setTextColor(i3, -7829368);
        }
        return remoteViews;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteViews a(String str, String str2, Bitmap bitmap) {
        int layoutRes;
        Context context = MobSDK.getContext();
        if (MobPush.Channels.XIAOMI.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_icon_content_xiaomi");
        } else if (MobPush.Channels.OPPO.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_icon_content_oppo");
        } else if (MobPush.Channels.VIVO.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_icon_content_vivo");
        } else if (MobPush.Channels.HUAWEI.equalsIgnoreCase(this.o)) {
            int layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_icon_content_huawei");
            int i = this.n;
            if (i == 3) {
                layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_icon_content_ui3_huawei");
            } else {
                layoutRes = i > 3 ? ResHelper.getLayoutRes(context, "mobpush_ad_icon_content_huawei") : layoutRes2;
            }
        } else {
            layoutRes = MobPush.Channels.MEIZU.equalsIgnoreCase(this.o) ? ResHelper.getLayoutRes(context, "mobpush_ad_icon_content_meizu") : 0;
        }
        if (layoutRes <= 0) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_icon_content");
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), layoutRes);
        int i2 = R.id.tvTitle;
        remoteViews.setTextViewText(i2, str);
        int i3 = R.id.tvContent;
        remoteViews.setTextViewText(i3, str2);
        if (b) {
            remoteViews.setTextColor(i2, -1);
            remoteViews.setTextColor(i3, -7829368);
        }
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.ivIcon, bitmap);
        }
        return remoteViews;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.RemoteViews a(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            android.content.Context r0 = com.mob.MobSDK.getContext()
            java.lang.String r1 = r4.o
            java.lang.String r2 = "xiaomi"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L24
            int r1 = r4.n
            r2 = 10
            if (r1 < r2) goto L1c
            java.lang.String r1 = "mobpush_ad_banner_ui10_xiaomi"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
            goto L99
        L1c:
            java.lang.String r1 = "mobpush_ad_banner_xiaomi"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
            goto L99
        L24:
            java.lang.String r1 = r4.o
            java.lang.String r2 = "oppo"
            boolean r1 = r2.equalsIgnoreCase(r1)
            r2 = 3
            if (r1 == 0) goto L4c
            int r1 = r4.n
            java.lang.String r3 = "mobpush_ad_banner_ui3_oppo"
            if (r1 > r2) goto L3a
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r3)
            goto L99
        L3a:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L47
            java.lang.String r1 = "mobpush_ad_banner_oppo"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
            goto L99
        L47:
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r3)
            goto L99
        L4c:
            java.lang.String r1 = r4.o
            java.lang.String r3 = "vivo"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L5d
            java.lang.String r1 = "mobpush_ad_banner_vivo"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
            goto L99
        L5d:
            java.lang.String r1 = r4.o
            java.lang.String r3 = "huawei"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L7b
            int r1 = r4.n
            if (r1 != r2) goto L72
            java.lang.String r1 = "mobpush_ad_banner_ui3_huawei"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
            goto L99
        L72:
            if (r1 <= r2) goto L98
            java.lang.String r1 = "mobpush_ad_banner_huawei"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
            goto L99
        L7b:
            java.lang.String r1 = r4.o
            java.lang.String r2 = "meizu"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L98
            int r1 = r4.n
            r2 = 7
            if (r1 < r2) goto L91
            java.lang.String r1 = "mobpush_ad_banner_ui7_meizu"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
            goto L99
        L91:
            java.lang.String r1 = "mobpush_ad_banner_meizu"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
            goto L99
        L98:
            r1 = 0
        L99:
            if (r1 > 0) goto La1
            java.lang.String r1 = "mobpush_ad_banner"
            int r1 = com.mob.tools.utils.ResHelper.getLayoutRes(r0, r1)
        La1:
            android.widget.RemoteViews r2 = new android.widget.RemoteViews
            java.lang.String r0 = r0.getPackageName()
            r2.<init>(r0, r1)
            int r0 = com.mob.pushsdk.R.id.ivBanner
            r2.setImageViewBitmap(r0, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.a.a.a(android.graphics.Bitmap):android.widget.RemoteViews");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteViews a(Bitmap[] bitmapArr, float f) {
        int layoutRes;
        int layoutRes2;
        Context context = MobSDK.getContext();
        if (MobPush.Channels.XIAOMI.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_gif_banner_xiaomi");
            if (this.n >= 10) {
                layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_banner_ui10_xiaomi");
            } else {
                layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_banner_xiaomi");
            }
        } else if (MobPush.Channels.OPPO.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_gif_banner_oppo");
            if (this.n > 3 && Build.VERSION.SDK_INT >= 26) {
                layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_banner_oppo");
            } else {
                layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_banner_ui3_oppo");
            }
        } else if (MobPush.Channels.VIVO.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_gif_banner_vivo");
            layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_banner_item_vivo");
        } else if (MobPush.Channels.HUAWEI.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_gif_banner_huawei");
            int i = this.n;
            if (i == 3) {
                layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_banner_ui3_huawei");
            } else {
                layoutRes2 = i > 3 ? ResHelper.getLayoutRes(context, "mobpush_ad_banner_huawei") : 0;
            }
        } else if (MobPush.Channels.MEIZU.equalsIgnoreCase(this.o)) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_gif_banner_meizu");
            layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_banner_ui7_meizu");
        } else {
            layoutRes = 0;
            layoutRes2 = 0;
        }
        if (layoutRes <= 0) {
            layoutRes = ResHelper.getLayoutRes(context, "mobpush_ad_gif_banner");
        }
        if (layoutRes2 <= 0) {
            layoutRes2 = ResHelper.getLayoutRes(context, "mobpush_ad_banner");
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), layoutRes);
        if (bitmapArr != null && bitmapArr.length > 0) {
            for (Bitmap bitmap : bitmapArr) {
                RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), layoutRes2);
                remoteViews2.setImageViewBitmap(R.id.ivBanner, bitmap);
                remoteViews.addView(R.id.flipper, remoteViews2);
            }
        }
        int i2 = (int) (f * 1000.0f);
        if (i2 != 0) {
            remoteViews.setInt(R.id.flipper, "setFlipInterval", i2);
        }
        return remoteViews;
    }

    private Notification a(Notification.Builder builder) {
        return builder.build();
    }

    public void a(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    public void a(int i) {
        this.h = i;
    }
}
