package defpackage;

import android.content.Context;
import android.location.Location;
import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.umeng.analytics.pro.d;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GeoapifyProvider.java */
/* renamed from: σ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2826 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f10294 = C4122.f14279;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean f10295 = C4122.f14280;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String f10296 = "https://api.geoapify.com/v1/geocode/reverse";

    /* compiled from: GeoapifyProvider.java */
    /* renamed from: σ$Ϳ, reason: contains not printable characters */
    public class C2827 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4515 f10297;

        public C2827(InterfaceC4515 interfaceC4515) {
            this.f10297 = interfaceC4515;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            InterfaceC4515 interfaceC4515 = this.f10297;
            if (interfaceC4515 != null) {
                interfaceC4515.mo12338();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) throws JSONException {
            if (C2826.f10295) {
                C4638.m14099(C2826.f10294, String.format("result : %s ", str));
            }
            try {
                String string = new JSONObject(str).getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("city");
                InterfaceC4515 interfaceC4515 = this.f10297;
                if (interfaceC4515 != null) {
                    interfaceC4515.mo12339(string);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                InterfaceC4515 interfaceC45152 = this.f10297;
                if (interfaceC45152 != null) {
                    interfaceC45152.mo12338();
                }
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m10173(Context context, Locale locale, Location location, InterfaceC4515 interfaceC4515) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        if (f10295) {
            C4638.m14099(f10294, String.format("reverseGeocodingWithPoint lat : %s , long : %s ", Double.valueOf(latitude), Double.valueOf(longitude)));
        }
        OkHttpUtils.get(f10296).params(d.C, String.valueOf(latitude)).params("lon", String.valueOf(longitude)).params("apiKey", "a40f2d7e02414960a63d8ef1f33a57d5").execute(new C2827(interfaceC4515));
    }
}
