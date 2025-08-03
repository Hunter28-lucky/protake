package com.mob.pushsdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.mob.MobSDK;
import com.mob.pushsdk.b.f;
import com.mob.pushsdk.plugins.b;
import com.mob.tools.proguard.ClassKeeper;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MobPushUtils implements ClassKeeper {
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[Catch: all -> 0x010f, TRY_ENTER, TryCatch #1 {all -> 0x010f, blocks: (B:7:0x0013, B:9:0x0039, B:10:0x0041, B:12:0x0047, B:15:0x005d, B:17:0x0064, B:19:0x006c, B:21:0x0074, B:23:0x007a, B:31:0x00cc, B:33:0x00d4, B:34:0x00e0, B:36:0x00e6, B:37:0x00ed, B:39:0x00f3, B:40:0x00fa, B:42:0x0100, B:44:0x010a, B:28:0x00a8, B:30:0x00ae), top: B:54:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray parseMainPluginPushIntent(android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.MobPushUtils.parseMainPluginPushIntent(android.content.Intent):org.json.JSONArray");
    }

    public static JSONArray parseSchemePluginPushIntent(Intent intent) {
        MiPushMessage miPushMessage;
        JSONArray jSONArray = new JSONArray();
        if (MobSDK.isForb()) {
            return jSONArray;
        }
        if (intent != null) {
            try {
                boolean booleanExtra = intent.getBooleanExtra("from_tcp", false);
                Log.d("MobPush", "parseSchemePluginPushIntent uri:" + intent.toUri(1));
                Uri data = intent.getData();
                if (!b.a().e() || booleanExtra) {
                    if (!b.a().g() || booleanExtra) {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            for (String str : extras.keySet()) {
                                if (str.equals("pushData")) {
                                    jSONArray.put(new JSONObject(extras.getString(str)));
                                }
                                if (str.equals("schemeData")) {
                                    jSONArray.put(new JSONObject(extras.getString(str)));
                                }
                                if (str.equals("id")) {
                                    putJson(jSONArray, "id", extras.getString(str));
                                }
                                if (str.equals("channel")) {
                                    putJson(jSONArray, "channel", extras.getString(str));
                                }
                                if (NotificationCompat.CATEGORY_MESSAGE.equalsIgnoreCase(str)) {
                                    Object obj = extras.get(NotificationCompat.CATEGORY_MESSAGE);
                                    if (f.b(obj)) {
                                        putToJson(jSONArray, NotificationCompat.CATEGORY_MESSAGE, obj);
                                    }
                                }
                            }
                        }
                    } else {
                        Bundle extras2 = intent.getExtras();
                        if (extras2 != null) {
                            for (String str2 : extras2.keySet()) {
                                if (str2.equals(PushMessageHelper.KEY_MESSAGE) && (miPushMessage = (MiPushMessage) extras2.getSerializable(str2)) != null && miPushMessage.getExtra() != null) {
                                    jSONArray.put(new JSONObject(miPushMessage.getExtra().get("pushData")));
                                    putJson(jSONArray, "id", miPushMessage.getExtra().get("id"));
                                    putJson(jSONArray, "channel", miPushMessage.getExtra().get("channel"));
                                }
                            }
                        }
                    }
                } else if (data != null) {
                    String queryParameter = data.getQueryParameter("pushData");
                    Log.d("MobPush", "oppo pushdata" + queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        jSONArray.put(new JSONObject(queryParameter));
                    }
                    String queryParameter2 = data.getQueryParameter("schemeData");
                    Log.d("MobPush", "oppo schemeData" + queryParameter2);
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        jSONArray.put(new JSONObject(queryParameter2));
                    }
                    String queryParameter3 = data.getQueryParameter("id");
                    Log.d("MobPush", "oppo id" + queryParameter3);
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        putJson(jSONArray, "id", queryParameter3);
                    }
                    String queryParameter4 = data.getQueryParameter("channel");
                    Log.d("MobPush", "oppo channel" + queryParameter4);
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        putJson(jSONArray, "channel", queryParameter4);
                    }
                }
                if (data != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("schemeLink", Uri.decode(data.toString()));
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
                Log.e("MobPush", "parseSchemePluginPushIntent error:" + th.getMessage());
            }
        }
        Log.d("MobPush", "parseSchemePluginPushIntent JSONArray:" + jSONArray);
        return jSONArray;
    }

    private static void putJson(JSONArray jSONArray, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, str2);
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static <PARAM_TYPE> void putToJson(JSONArray jSONArray, String str, PARAM_TYPE param_type) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, param_type);
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
