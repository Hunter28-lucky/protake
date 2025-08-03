package defpackage;

import com.umeng.analytics.pro.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ad {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public File f27;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public x9 f28;

    public ad(String str, x9 x9Var) {
        this.f27 = null;
        this.f28 = null;
        this.f27 = new File(str);
        this.f28 = x9Var;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m31(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put(d.O, str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m33() {
        new Thread(new yd(this)).start();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final synchronized void m34() {
        File file = this.f27;
        if (file == null) {
            return;
        }
        if (file.exists() && this.f27.isDirectory() && this.f27.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f27.list()) {
                arrayList.add(str);
            }
            Collections.sort(arrayList);
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.f28.logCollect(m31(qc.m8123(this.f27.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i = 0; i < size; i++) {
                new File(this.f27, (String) arrayList.get(i)).delete();
            }
        }
    }
}
