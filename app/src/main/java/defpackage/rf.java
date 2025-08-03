package defpackage;

import android.content.Context;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.ja;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.platform.Platform;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class rf extends pf {
    @Override // defpackage.pf
    /* renamed from: Ԩ */
    public ic mo7969(pa paVar, Context context, String str) throws Throwable {
        hf.m6209("mspl", "mdap post");
        byte[] bArrM6067 = fc.m6067(str.getBytes(Charset.forName(Platform.UTF_8)));
        HashMap map = new HashMap();
        map.put("utdId", mc.m7550().m7555());
        map.put("logHeader", "RAW");
        map.put("bizCode", "alipaysdk");
        map.put("productId", "alipaysdk_android");
        map.put(HttpHeaders.HEAD_KEY_CONTENT_ENCODING, "Gzip");
        map.put("productVersion", "15.8.11");
        ja.C2124 c2124M7106 = ja.m7106(context, new ja.C2123("https://loggw-exsdk.alipay.com/loggw/logUpload.do", map, bArrM6067));
        hf.m6209("mspl", "mdap got " + c2124M7106);
        if (c2124M7106 == null) {
            throw new RuntimeException("Response is null");
        }
        boolean zM7975 = pf.m7975(c2124M7106);
        try {
            byte[] bArrM6068 = c2124M7106.f7746;
            if (zM7975) {
                bArrM6068 = fc.m6068(bArrM6068);
            }
            return new ic("", new String(bArrM6068, Charset.forName(Platform.UTF_8)));
        } catch (Exception e2) {
            hf.m6205(e2);
            return null;
        }
    }

    @Override // defpackage.pf
    /* renamed from: ԭ */
    public String mo7971(pa paVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // defpackage.pf
    /* renamed from: ԯ */
    public Map<String, String> mo7972(boolean z, String str) {
        return new HashMap();
    }

    @Override // defpackage.pf
    /* renamed from: ՠ */
    public JSONObject mo7189() {
        return null;
    }

    @Override // defpackage.pf
    /* renamed from: ހ */
    public boolean mo7191() {
        return false;
    }
}
