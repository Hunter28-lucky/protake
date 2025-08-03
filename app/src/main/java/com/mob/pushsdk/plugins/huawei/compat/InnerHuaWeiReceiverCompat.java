package com.mob.pushsdk.plugins.huawei.compat;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.plugins.a.a;
import com.mob.tools.proguard.ClassKeeper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class InnerHuaWeiReceiverCompat extends a implements ClassKeeper {
    private static final InnerHuaWeiReceiverCompat HUA_WEI_RECEIVER_COMPAT = new InnerHuaWeiReceiverCompat();

    private InnerHuaWeiReceiverCompat() {
    }

    public static InnerHuaWeiReceiverCompat getInstance() {
        return HUA_WEI_RECEIVER_COMPAT;
    }

    @Override // com.mob.pushsdk.plugins.a.a
    public void doPluginRecevier(Context context, int i, Object obj) {
        if (i != 0) {
            if (i != 2) {
                return;
            }
            String str = (String) obj;
            d.a().b("[HUAWEI] channel regId: " + str);
            bindPlugin(PushHuaWeiCompat.NAME, str);
            return;
        }
        Bundle bundle = (Bundle) obj;
        try {
            ArrayList arrayList = (ArrayList) a.HASHON.fromJson((String) bundle.get("pushMsg"), ArrayList.class);
            if (arrayList != null && arrayList.size() > 0) {
                MobPushNotifyMessage mobPushNotifyMessage = new MobPushNotifyMessage();
                final String str2 = "";
                if (arrayList.get(0) != null) {
                    HashMap map = (HashMap) arrayList.get(0);
                    String str3 = (String) ResHelper.forceCast(map.get("batchId"), "");
                    String str4 = (String) ResHelper.forceCast(map.get("title"), "");
                    mobPushNotifyMessage.setContent((String) ResHelper.forceCast(map.get("content"), ""));
                    mobPushNotifyMessage.setTitle(str4);
                    mobPushNotifyMessage.setMessageId(str3);
                    str2 = str3;
                }
                if (arrayList.size() >= 2 && arrayList.get(1) != null) {
                    mobPushNotifyMessage.setExtrasMap((HashMap) arrayList.get(1));
                }
                mobPushNotifyMessage.setChannel(1);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("action", i);
                bundle2.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushNotifyMessage);
                this.pushSDKImpl.a(bundle2);
                this.pushSDKImpl.c(new MobPushCallback<String>() { // from class: com.mob.pushsdk.plugins.huawei.compat.InnerHuaWeiReceiverCompat.1
                    @Override // com.mob.pushsdk.MobPushCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(String str5) {
                        if (TextUtils.isEmpty(str5)) {
                            return;
                        }
                        PLog.getInstance().d("MobPush-HUAWEI batchId:" + str2, new Object[0]);
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("mobRegId", str5);
                        bundle3.putStringArray("hwId", new String[]{str2});
                        InnerHuaWeiReceiverCompat.this.pushSDKImpl.d(bundle3);
                    }
                });
            }
            int i2 = bundle.getInt("pushNotifyId", 0);
            if (i2 != 0) {
                ((NotificationManager) context.getSystemService("notification")).cancel(i2);
            }
        } catch (Throwable th) {
            PLog.getInstance().d(th);
        }
    }
}
