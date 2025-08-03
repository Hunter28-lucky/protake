package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class re {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final int[] f8483 = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final int[] f8484 = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};

    /* renamed from: ֈ, reason: contains not printable characters */
    public static int f8485 = 0;

    /* renamed from: ֏, reason: contains not printable characters */
    public static String f8486;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static boolean f8487;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Object f8488;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Context f8489;

    /* renamed from: ԩ, reason: contains not printable characters */
    public List<pd> f8490;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public List<se> f8491;

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f8492;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f8493;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f8494;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC2917 f8495;

    /* renamed from: re$Ϳ, reason: contains not printable characters */
    public static class C2258 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final re f8496 = new re(null);
    }

    public re() {
        this.f8488 = new Object();
        this.f8490 = new ArrayList();
        this.f8491 = new ArrayList();
        this.f8494 = null;
        synchronized (re.class) {
            int i = f8485;
            if (i > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            f8485 = i + 1;
        }
        m8180(new rc());
        m8180(new wa());
        m8179(new qb());
        m8179(new k9());
    }

    public /* synthetic */ re(ie ieVar) {
        this();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m8170(Context context, C2328 c2328) {
        Cif.m6291(context, c2328);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static re m8171() {
        return C2258.f8496;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static String m8172() {
        return "2.1.0";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public re m8173(Context context, boolean z) {
        this.f8489 = context.getApplicationContext();
        new l9().m7490(this.f8489);
        qd.m8127(z);
        return this;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m8174() {
        return this.f8494;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m8175(Context context) {
        boolean z;
        boolean z2;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.mcs.action.RECEIVE_SDK_MESSAGE"), 8192);
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            String str = it.next().serviceInfo.packageName;
            try {
                z = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                z2 = context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid("android", 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (z || z2) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m8176(int i, String str, JSONObject jSONObject) {
        synchronized (this.f8488) {
            this.f8489.startService(m8182(i, str, jSONObject));
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m8177(C2318 c2318, String str, int i) {
        try {
            Intent intent = new Intent();
            intent.setAction(m8187());
            intent.setPackage(m8186());
            intent.putExtra("type", 12291);
            intent.putExtra("taskID", c2318.m8705());
            intent.putExtra("appPackage", c2318.m8703());
            intent.putExtra("messageID", c2318.m8704());
            intent.putExtra("messageType", i);
            intent.putExtra("eventID", str);
            this.f8489.startService(intent);
        } catch (Exception e2) {
            qd.m8125("statisticMessage--Exception" + e2.getMessage());
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m8178(Context context, String str, String str2, JSONObject jSONObject, InterfaceC2917 interfaceC2917) {
        if (context == null) {
            if (interfaceC2917 != null) {
                interfaceC2917.onRegister(-2, null);
                return;
            }
            return;
        }
        m8170(context, new C2328(context.getPackageName(), "push_register", null));
        if (!m8188()) {
            if (interfaceC2917 != null) {
                interfaceC2917.onRegister(-2, null);
            }
        } else {
            this.f8492 = str;
            this.f8493 = str2;
            this.f8489 = context.getApplicationContext();
            this.f8495 = interfaceC2917;
            m8183(12289, jSONObject);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final synchronized void m8179(pd pdVar) {
        if (pdVar != null) {
            this.f8490.add(pdVar);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final synchronized void m8180(se seVar) {
        if (seVar != null) {
            this.f8491.add(seVar);
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m8181(String str) {
        this.f8494 = str;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final Intent m8182(int i, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(m8187());
        intent.setPackage(m8186());
        intent.putExtra("type", i);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.f8489;
            jSONObject2.putOpt("versionName", gg.m6105(context, context.getPackageName()));
            Context context2 = this.f8489;
            jSONObject2.putOpt("versionCode", Integer.valueOf(gg.m6104(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.f8489.getPackageName());
        intent.putExtra("appKey", this.f8492);
        intent.putExtra("appSecret", this.f8493);
        intent.putExtra("registerID", this.f8494);
        intent.putExtra("sdkVersion", m8172());
        return intent;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m8183(int i, JSONObject jSONObject) {
        m8176(i, "", jSONObject);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m8184(JSONObject jSONObject) {
        if (m8194()) {
            m8183(12299, jSONObject);
        } else {
            qd.m8126("mcssdk---", "please call the register first!");
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m8185(JSONObject jSONObject) {
        if (m8194()) {
            m8183(12300, jSONObject);
        } else {
            qd.m8126("mcssdk---", "please call the register first!");
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public String m8186() {
        boolean z;
        if (f8486 == null) {
            String strM8175 = m8175(this.f8489);
            if (strM8175 == null) {
                f8486 = gg.m6101(f8483);
                z = false;
            } else {
                f8486 = strM8175;
                z = true;
            }
            f8487 = z;
        }
        return f8486;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public String m8187() {
        if (f8486 == null) {
            m8175(this.f8489);
        }
        return f8487 ? "com.mcs.action.RECEIVE_SDK_MESSAGE" : gg.m6101(f8484);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean m8188() {
        String strM8186 = m8186();
        return gg.m6102(this.f8489, strM8186) && gg.m6104(this.f8489, strM8186) >= 1019 && gg.m6103(this.f8489, strM8186, "supportOpenPush");
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public List<se> m8189() {
        return this.f8491;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public List<pd> m8190() {
        return this.f8490;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public InterfaceC2917 m8191() {
        return this.f8495;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final boolean m8192() {
        return this.f8489 != null;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final boolean m8193() {
        return this.f8494 != null;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final boolean m8194() {
        return m8192() && m8193();
    }
}
