package cn.smssdk.net.login;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.wrapper.TokenVerifyResult;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.mob.MobSDK;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Hashon;
import com.umeng.umcrash.UMCrash;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LoginCore {
    public void a(final String str, final TokenVerifyResult tokenVerifyResult, final d dVar) {
        if (tokenVerifyResult != null && !TextUtils.isEmpty(str)) {
            final Hashon hashon = new Hashon();
            new cn.smssdk.utils.d(this, "login") { // from class: cn.smssdk.net.login.LoginCore.1
                @Override // cn.smssdk.utils.d
                public void a() {
                    try {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("appkey", MobSDK.getAppkey());
                        map.put("opToken", tokenVerifyResult.getOpToken());
                        map.put("token", tokenVerifyResult.getToken());
                        map.put("operator", tokenVerifyResult.getOperator());
                        map.put("phone", str);
                        map.put(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                        map.put("sign", f.a(map, MobSDK.getAppSecret()));
                        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                        arrayList.add(new KVPair<>(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/json"));
                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                        networkTimeOut.readTimout = 5000;
                        networkTimeOut.connectionTimeout = 5000;
                        SMSLog.getInstance().d("Request: http://identify.verify.mob.com/auth/verify/mobile\nparams: " + hashon.fromHashMap(map), new Object[0]);
                        new NetworkHelper().jsonPost("http://identify.verify.mob.com/auth/verify/mobile", map, arrayList, networkTimeOut, new HttpResponseCallback() { // from class: cn.smssdk.net.login.LoginCore.1.1
                            @Override // com.mob.tools.network.HttpResponseCallback
                            public void onResponse(HttpConnection httpConnection) throws Throwable {
                                StringBuilder sb = new StringBuilder();
                                int responseCode = httpConnection.getResponseCode();
                                if (200 == responseCode) {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        } else {
                                            sb.append(line);
                                        }
                                    }
                                    bufferedReader.close();
                                    String string = sb.toString();
                                    SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "Response: " + string);
                                    JSONObject jSONObject = new JSONObject(string);
                                    int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                                    String string2 = jSONObject.getString("res");
                                    String string3 = jSONObject.getString(com.umeng.analytics.pro.d.O);
                                    if (200 != iOptInt) {
                                        HashMap map2 = new HashMap();
                                        map2.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(iOptInt));
                                        map2.put("detail", string3);
                                        dVar.a(new Throwable(hashon.fromHashMap(map2)));
                                        return;
                                    }
                                    String str2 = new String(c.b(a.a(string2.getBytes()), MobSDK.getAppSecret().getBytes()));
                                    if (new JSONObject(str2).optInt("isValid") == 1) {
                                        dVar.a();
                                        return;
                                    }
                                    HashMap map3 = new HashMap();
                                    map3.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(iOptInt));
                                    map3.put("detail", str2);
                                    dVar.a(new Throwable(hashon.fromHashMap(map3)));
                                    return;
                                }
                                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
                                while (true) {
                                    String line2 = bufferedReader2.readLine();
                                    if (line2 == null) {
                                        bufferedReader2.close();
                                        SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "Response: " + sb.toString());
                                        HashMap map4 = new HashMap();
                                        map4.put(com.umeng.analytics.pro.d.O, sb.toString());
                                        map4.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                                        throw new Throwable(new Hashon().fromHashMap(map4));
                                    }
                                    sb.append(line2);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "login exception: " + th);
                        HashMap map2 = new HashMap();
                        map2.put(NotificationCompat.CATEGORY_STATUS, 615);
                        dVar.a(new Throwable(hashon.fromHashMap(map2)));
                    }
                }
            }.start();
        } else {
            HashMap map = new HashMap();
            map.put(NotificationCompat.CATEGORY_STATUS, 618);
            dVar.a(new Throwable(new Hashon().fromHashMap(map)));
        }
    }
}
