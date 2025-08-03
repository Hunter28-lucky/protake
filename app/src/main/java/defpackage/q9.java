package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class q9 {

    /* renamed from: q9$Ϳ, reason: contains not printable characters */
    public static final class C2247 {

        /* renamed from: q9$Ϳ$Ϳ, reason: contains not printable characters */
        public static class RunnableC2248 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ String f8440;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ Context f8441;

            public RunnableC2248(String str, Context context) {
                this.f8440 = str;
                this.f8441 = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f8440) || C2247.m8096(this.f8441, this.f8440)) {
                    for (int i = 0; i < 4; i++) {
                        String strM8101 = C2249.m8101(this.f8441);
                        if (TextUtils.isEmpty(strM8101) || !C2247.m8096(this.f8441, strM8101)) {
                            return;
                        }
                    }
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static synchronized void m8093(Context context, cc ccVar, String str, String str2) {
            if (context == null || ccVar == null || str == null) {
                return;
            }
            m8094(context, ccVar.m288(str), str2);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static synchronized void m8094(Context context, String str, String str2) {
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                C2249.m8099(context, str, str2);
            }
            new Thread(new RunnableC2248(str, context)).start();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static synchronized boolean m8096(Context context, String str) {
            hf.m6207("mspl", "stat sub " + str);
            try {
                if ((p9.m7898().m7915() ? new pe() : new rf()).mo7969(null, context, str) == null) {
                    return false;
                }
                C2249.m8097(context, str);
                return true;
            } catch (Throwable th) {
                hf.m6205(th);
                return false;
            }
        }
    }

    /* renamed from: q9$Ԩ, reason: contains not printable characters */
    public static final class C2249 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static synchronized int m8097(Context context, String str) {
            hf.m6207("RecordPref", "stat remove " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                C2250 c2250M8098 = m8098(context);
                if (c2250M8098.f8442.isEmpty()) {
                    return 0;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : c2250M8098.f8442.entrySet()) {
                        if (str.equals(entry.getValue())) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        c2250M8098.f8442.remove((String) it.next());
                    }
                    m8100(context, c2250M8098);
                    return arrayList.size();
                } catch (Throwable th) {
                    hf.m6205(th);
                    int size = c2250M8098.f8442.size();
                    m8100(context, new C2250());
                    return size;
                }
            }
            return 0;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static synchronized C2250 m8098(Context context) {
            try {
                String strM7657 = ng.m7657(null, context, "alipay_cashier_statistic_record", null);
                if (TextUtils.isEmpty(strM7657)) {
                    return new C2250();
                }
                return new C2250(strM7657);
            } catch (Throwable th) {
                hf.m6205(th);
                return new C2250();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public static synchronized String m8099(Context context, String str, String str2) {
            hf.m6207("RecordPref", "stat append " + str2 + " , " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                C2250 c2250M8098 = m8098(context);
                if (c2250M8098.f8442.size() > 20) {
                    c2250M8098.f8442.clear();
                }
                c2250M8098.f8442.put(str2, str);
                m8100(context, c2250M8098);
                return str2;
            }
            return null;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static synchronized void m8100(Context context, C2250 c2250) {
            if (c2250 == null) {
                try {
                    c2250 = new C2250();
                } catch (Throwable th) {
                    hf.m6205(th);
                }
            }
            ng.m7659(null, context, "alipay_cashier_statistic_record", c2250.m8102());
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public static synchronized String m8101(Context context) {
            hf.m6207("RecordPref", "stat peek");
            if (context == null) {
                return null;
            }
            C2250 c2250M8098 = m8098(context);
            if (c2250M8098.f8442.isEmpty()) {
                return null;
            }
            try {
                return c2250M8098.f8442.entrySet().iterator().next().getValue();
            } catch (Throwable th) {
                hf.m6205(th);
                return null;
            }
        }

        /* renamed from: q9$Ԩ$Ϳ, reason: contains not printable characters */
        public static final class C2250 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final LinkedHashMap<String, String> f8442 = new LinkedHashMap<>();

            public C2250() {
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public String m8102() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.f8442.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    hf.m6205(th);
                    return new JSONArray().toString();
                }
            }

            public C2250(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.f8442.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    hf.m6205(th);
                }
            }
        }
    }

    /* renamed from: q9$Ԫ, reason: contains not printable characters */
    public static final class C2251 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static synchronized long m8103(Context context) {
            return C2252.m8104(context, "alipay_cashier_ap_seq_v");
        }
    }

    /* renamed from: q9$Ԭ, reason: contains not printable characters */
    public static final class C2252 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static synchronized long m8104(Context context, String str) {
            long j;
            String strM7657;
            try {
                strM7657 = ng.m7657(null, context, str, null);
            } catch (Throwable unused) {
            }
            j = (!TextUtils.isEmpty(strM7657) ? Long.parseLong(strM7657) : 0L) + 1;
            try {
                ng.m7659(null, context, str, Long.toString(j));
            } catch (Throwable unused2) {
            }
            return j;
        }
    }

    /* renamed from: q9$Ԯ, reason: contains not printable characters */
    public static final class C2253 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static synchronized long m8105(Context context) {
            return C2252.m8104(context, "alipay_cashier_statistic_v");
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m8085(pa paVar, String str, String str2) {
        if (paVar == null) {
            return;
        }
        paVar.f8299.m289(str, str2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m8086(pa paVar, String str, String str2, String str3) {
        if (paVar == null) {
            return;
        }
        paVar.f8299.m290(str, str2, str3);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m8087(pa paVar, String str, String str2, Throwable th) {
        if (paVar == null) {
            return;
        }
        paVar.f8299.m291(str, str2, th);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m8088(pa paVar, String str, String str2, Throwable th, String str3) {
        if (paVar == null) {
            return;
        }
        paVar.f8299.m292(str, str2, th, str3);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m8089(pa paVar, String str, Throwable th) {
        if (paVar == null || th == null) {
            return;
        }
        paVar.f8299.m291(str, th.getClass().getSimpleName(), th);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static synchronized void m8090(Context context, pa paVar, String str, String str2) {
        if (context == null || paVar == null) {
            return;
        }
        try {
            C2249.m8099(context, paVar.f8299.m288(str), str2);
        } catch (Throwable th) {
            hf.m6205(th);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m8091(pa paVar, String str, String str2, String str3) {
        if (paVar == null) {
            return;
        }
        paVar.f8299.m293(str, str2, str3);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static synchronized void m8092(Context context, pa paVar, String str, String str2) {
        if (context == null || paVar == null) {
            return;
        }
        C2247.m8093(context, paVar.f8299, str, str2);
    }
}
