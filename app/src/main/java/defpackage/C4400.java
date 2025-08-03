package defpackage;

import android.content.SharedPreferences;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.FilmApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PayInAppsManager.java */
/* renamed from: ଔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4400 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C4400 f15127;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final SharedPreferences f15128 = FilmApp.m402().getSharedPreferences("pay_in_apps", 0);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C4400 m13591() {
        if (f15127 == null) {
            synchronized (C4400.class) {
                if (f15127 == null) {
                    f15127 = new C4400();
                }
            }
        }
        return f15127;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<Purchase> m13592() {
        Map<String, ?> all = this.f15128.getAll();
        if (all == null || all.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            try {
                JSONObject jSONObject = new JSONObject(String.valueOf(it.next()));
                arrayList.add(new Purchase(jSONObject.getString("json"), jSONObject.getString("sign")));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m13593(String str) {
        this.f15128.edit().remove(str).apply();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m13594(Purchase purchase) throws JSONException {
        String strM8495 = "";
        try {
            strM8495 = w.m8495(purchase.getSignature());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f15128.contains(strM8495)) {
            return strM8495;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sign", purchase.getSignature());
        jSONObject.put("json", purchase.getOriginalJson());
        this.f15128.edit().putString(strM8495, jSONObject.toString()).apply();
        return strM8495;
    }
}
