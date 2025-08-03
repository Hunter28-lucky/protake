package com.mob.pushsdk.plugins.fcm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.RemoteMessage;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.b.k;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.BitmapHelper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class a extends com.mob.pushsdk.plugins.a.a {
    private static final a a = new a();

    private a() {
    }

    @Override // com.mob.pushsdk.plugins.a.a
    public void doPluginRecevier(Context context, final int i, final Object obj) {
        if (i == 1) {
            k.a(new k.a() { // from class: com.mob.pushsdk.plugins.fcm.a.1
                @Override // com.mob.pushsdk.b.k.a
                public void a() {
                    if (MobSDK.isForb()) {
                        return;
                    }
                    RemoteMessage remoteMessage = (RemoteMessage) obj;
                    MobPushNotifyMessage mobPushNotifyMessage = new MobPushNotifyMessage();
                    mobPushNotifyMessage.setChannel(4);
                    mobPushNotifyMessage.setTitle(remoteMessage.getNotification().getTitle());
                    mobPushNotifyMessage.setContent(remoteMessage.getNotification().getBody());
                    Map<? extends String, ? extends String> data = remoteMessage.getData();
                    HashMap<String, String> map = new HashMap<>();
                    if (data != null && !data.isEmpty()) {
                        map.putAll(data);
                    }
                    mobPushNotifyMessage.setExtrasMap(map);
                    mobPushNotifyMessage.setMessageId(remoteMessage.getMessageId());
                    mobPushNotifyMessage.setInboxStyleContent(null);
                    mobPushNotifyMessage.setStyle(0);
                    mobPushNotifyMessage.setStyleContent(null);
                    mobPushNotifyMessage.setTimestamp(remoteMessage.getSentTime());
                    mobPushNotifyMessage.setLight(false);
                    if (TextUtils.isEmpty(remoteMessage.getNotification().getSound())) {
                        mobPushNotifyMessage.setShake(false);
                        mobPushNotifyMessage.setVoice(false);
                    }
                    try {
                        String channelId = remoteMessage.getNotification().getChannelId();
                        if (!TextUtils.isEmpty(channelId)) {
                            mobPushNotifyMessage.setAndroidChannelId(channelId);
                        }
                    } catch (Throwable th) {
                        PLog.getInstance().d(th);
                    }
                    try {
                        String color = remoteMessage.getNotification().getColor();
                        if (!TextUtils.isEmpty(color)) {
                            mobPushNotifyMessage.setIconColor(color);
                        }
                    } catch (Throwable th2) {
                        PLog.getInstance().d(th2);
                    }
                    try {
                        String icon = remoteMessage.getNotification().getIcon();
                        if (!TextUtils.isEmpty(icon)) {
                            mobPushNotifyMessage.setIcon(icon);
                        }
                    } catch (Throwable th3) {
                        PLog.getInstance().d(th3);
                    }
                    try {
                        Uri imageUrl = remoteMessage.getNotification().getImageUrl();
                        if (imageUrl != null && !TextUtils.isEmpty(imageUrl.toString())) {
                            mobPushNotifyMessage.setStyle(2);
                            String string = imageUrl.toString();
                            mobPushNotifyMessage.setImage(string);
                            mobPushNotifyMessage.setStyleContent(string);
                            if (!TextUtils.isEmpty(string) && (string.startsWith("http://") || string.startsWith("https://"))) {
                                try {
                                    mobPushNotifyMessage.setImagePath(BitmapHelper.downloadBitmap(MobSDK.getContext(), mobPushNotifyMessage.getImage()));
                                } catch (Throwable th4) {
                                    PLog.getInstance().e(th4);
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        PLog.getInstance().d(th5);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", i);
                    bundle.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushNotifyMessage);
                    a.this.pushSDKImpl.c(bundle);
                }
            });
            return;
        }
        if (i != 2) {
            return;
        }
        String str = (String) obj;
        d.a().a("[FCM] channel regId: " + str);
        bindPlugin("FCM", str);
    }

    public static a a() {
        return a;
    }
}
