package cn.smssdk.net;

import androidx.core.app.NotificationCompat;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.utils.Hashon;
import io.jsonwebtoken.Header;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class HttpResponseCallbackImp implements HttpResponseCallback {
    private HashMap<String, Object> a;

    public HttpResponseCallbackImp(HashMap<String, Object> map) {
        this.a = map;
    }

    public void handleInput(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65536];
        int i = inputStream.read(bArr);
        while (i > 0) {
            byteArrayOutputStream.write(bArr, 0, i);
            i = inputStream.read(bArr);
        }
        byteArrayOutputStream.flush();
        this.a.put("bResp", byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
    }

    @Override // com.mob.tools.network.HttpResponseCallback
    public void onResponse(HttpConnection httpConnection) throws Throwable {
        int responseCode = httpConnection.getResponseCode();
        this.a.put("httpStatus", Integer.valueOf(responseCode));
        List<String> list = httpConnection.getHeaderFields().get("sign");
        if (list != null && list.size() > 0) {
            this.a.put("sign", list.get(0));
        }
        List<String> list2 = httpConnection.getHeaderFields().get(HttpHeaders.HEAD_KEY_CONTENT_LENGTH);
        if (list2 != null && list2.size() > 0) {
            this.a.put(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, list2.get(0));
        }
        List<String> list3 = httpConnection.getHeaderFields().get(Header.COMPRESSION_ALGORITHM);
        if (list3 != null && list3.size() > 0) {
            this.a.put(Header.COMPRESSION_ALGORITHM, Boolean.valueOf("1".equals(list3.get(0))));
        }
        if (responseCode != 200) {
            List<String> list4 = httpConnection.getHeaderFields().get(NotificationCompat.CATEGORY_MESSAGE);
            String str = null;
            if (list4 != null && list4.size() > 0) {
                str = list4.get(0);
            }
            HashMap map = new HashMap();
            map.put(com.umeng.analytics.pro.d.O, str);
            map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
            throw new Throwable(new Hashon().fromHashMap(map));
        }
        InputStream inputStream = httpConnection.getInputStream();
        try {
            handleInput(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
    }
}
