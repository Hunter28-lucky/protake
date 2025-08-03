package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.xiaomi.push.C5341r;
import com.xiaomi.push.gt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class ac {
    private static final boolean a = Log.isLoggable("NCHelper", 3);

    @TargetApi(26)
    private static void a(af afVar, NotificationChannel notificationChannel, String str) {
        int i;
        char c;
        int iA;
        Context contextM5748a = afVar.m5748a();
        String id = notificationChannel.getId();
        String strA = af.a(id, afVar.m5749a());
        boolean z = a;
        if (z) {
            a("appChannelId:" + id + " oldChannelId:" + strA);
        }
        if (!com.xiaomi.push.j.m5690a(contextM5748a) || TextUtils.equals(id, strA)) {
            NotificationChannel notificationChannelM5747a = afVar.m5747a(id);
            if (z) {
                a("elseLogic getNotificationChannel:" + notificationChannelM5747a);
            }
            if (notificationChannelM5747a == null) {
                afVar.a(notificationChannel);
            }
            i = 0;
            c = 0;
        } else {
            NotificationManager notificationManager = (NotificationManager) contextM5748a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(strA);
            NotificationChannel notificationChannelM5747a2 = afVar.m5747a(id);
            if (z) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + notificationChannelM5747a2);
            }
            if (notificationChannel2 != null) {
                NotificationChannel notificationChannelA = a(id, notificationChannel2);
                if (z) {
                    a("copyXmsf copyXmsfChannel:" + notificationChannelA);
                }
                if (notificationChannelM5747a2 != null) {
                    iA = a(notificationChannelM5747a2);
                    afVar.a(notificationChannelA, iA == 0);
                    c = 3;
                } else {
                    iA = a(notificationChannel2);
                    a(contextM5748a, afVar, notificationChannelA, iA, notificationChannel2.getId());
                    c = 4;
                }
                b(contextM5748a, id);
                notificationManager.deleteNotificationChannel(strA);
            } else if (notificationChannelM5747a2 == null) {
                if (z) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                afVar.a(notificationChannel);
                c = 1;
                iA = 0;
            } else if (m5737a(contextM5748a, id) || !a(notificationChannel, notificationChannelM5747a2)) {
                iA = 0;
                c = 0;
            } else {
                if (z) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                iA = a(notificationChannelM5747a2);
                afVar.a(notificationChannel, iA == 0);
                c = 2;
            }
            i = iA;
        }
        f.a(afVar.m5748a(), afVar.m5749a(), id, notificationChannel.getImportance(), str, c == 1 || c == 4 || c == 3, i);
    }

    private static void b(Context context, String str) {
        if (a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static void c(Context context, String str) {
        try {
            af afVarA = af.a(context, str);
            Set<String> setKeySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : setKeySet) {
                if (afVarA.m5752a(str2)) {
                    arrayList.add(str2);
                    if (a) {
                        a("delete channel copy record:" + str2);
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception unused) {
        }
    }

    @TargetApi(26)
    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z2 = true;
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + MyUTIL.white_space + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z2 = z;
        }
        if (a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z2);
        }
        return z2;
    }

    private static int a(NotificationChannel notificationChannel) {
        int iIntValue = 0;
        try {
            iIntValue = ((Integer) com.xiaomi.push.ax.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (a) {
                a("isUserLockedChannel:" + iIntValue + MyUTIL.white_space + notificationChannel);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5114a("NCHelper", "is user locked error" + e2);
        }
        return iIntValue;
    }

    @TargetApi(26)
    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5737a(Context context, String str) {
        if (a) {
            a("checkCopeidChannel:newFullChannelId:" + str + "  " + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void a(Context context, List<String> list) {
        if (a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (list.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editorEdit = a(context).edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.apply();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(af afVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        String strM5750a = afVar.m5750a(str);
        boolean z = a;
        if (z) {
            a("createChannel: appChannelId:" + strM5750a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(strM5750a, charSequence, i2);
        notificationChannel.setDescription(str2);
        notificationChannel.enableVibration((i & 2) != 0);
        notificationChannel.enableLights((i & 4) != 0);
        if ((i & 1) != 0) {
            if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("android.resource://" + afVar.m5749a())) {
                    notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
        } else {
            notificationChannel.setSound(null, null);
        }
        if (z) {
            a("create channel:" + notificationChannel);
        }
        a(afVar, notificationChannel, str4);
        return strM5750a;
    }

    private static void a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m5114a("NCHelper", str);
    }

    public static void a(Context context, String str) {
        if (!com.xiaomi.push.j.m5690a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        f.a(context, str);
    }

    public static void a(gt gtVar) {
        Map<String, String> map;
        if (gtVar == null || (map = gtVar.f6038a) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        gtVar.f6034a = 0;
        gtVar.f6038a.remove("channel_id");
        gtVar.f6038a.remove("channel_importance");
        gtVar.f6038a.remove("channel_name");
        gtVar.f6038a.remove("channel_description");
        gtVar.f6038a.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.m5113a("delete channel info by:" + gtVar.f6038a.get("REMOVE_CHANNEL_MARK"));
        gtVar.f6038a.remove("REMOVE_CHANNEL_MARK");
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    public static void a(Context context, af afVar, NotificationChannel notificationChannel, int i, String str) {
        if (i > 0) {
            int iA = C5341r.m5701a(context) ? f.a(context.getPackageName(), str) : 0;
            NotificationChannel notificationChannelA = a(notificationChannel.getId(), notificationChannel);
            if ((i & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    notificationChannelA.setSound(null, null);
                } else {
                    notificationChannelA.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    notificationChannelA.enableVibration(false);
                } else {
                    notificationChannelA.enableVibration(true);
                }
            }
            if ((i & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    notificationChannelA.enableLights(false);
                } else {
                    notificationChannelA.enableLights(true);
                }
            }
            if ((i & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                notificationChannelA.setImportance(importance);
            }
            if ((i & 2) != 0) {
                notificationChannelA.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            afVar.a(notificationChannelA);
            afVar.a(notificationChannel, true);
            f.a(afVar.m5749a(), notificationChannel.getId(), iA, 0);
            return;
        }
        afVar.a(notificationChannel);
    }
}
