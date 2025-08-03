package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
class am implements aj {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private Class<?> f5587a;

    /* renamed from: a, reason: collision with other field name */
    private Object f5588a;

    /* renamed from: a, reason: collision with other field name */
    private Method f5589a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public am(Context context) {
        this.a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            Class<?> clsA = s.a(context, "com.android.id.impl.IdProviderImpl");
            this.f5587a = clsA;
            this.f5588a = clsA.newInstance();
            this.b = this.f5587a.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e2);
        }
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public boolean mo5202a() {
        return (this.f5587a == null || this.f5588a == null) ? false : true;
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public String mo5201a() {
        return a(this.a, this.b);
    }

    private String a(Context context, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = this.f5588a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e2);
            return null;
        }
    }
}
