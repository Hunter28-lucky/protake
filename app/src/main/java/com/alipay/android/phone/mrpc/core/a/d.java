package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.kf;
import java.lang.reflect.Type;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() throws JSONException {
        try {
            String str = new String(this.b);
            Thread.currentThread().getId();
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("resultStatus");
            if (i == 1000) {
                return this.a == String.class ? jSONObject.optString("result") : kf.m7206(jSONObject.optString("result"), this.a);
            }
            throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("response  =");
            sb.append(new String(this.b));
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(e2);
            throw new RpcException((Integer) 10, sb.toString() == null ? "" : e2.getMessage());
        }
    }
}
