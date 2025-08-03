package defpackage;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StatisticsUtils.java */
/* loaded from: classes.dex */
public class j {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m7050(Map<String, Object> map) {
        map.put("CameraModel", Build.MODEL);
        map.put("CameraMaker", Build.MANUFACTURER);
        map.put("Channel", "google");
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Map<String, Object> m7051(C2628 c2628, C3621 c3621) {
        HashMap map = new HashMap();
        C3891 c3891M13890 = C4535.m13880().m13890();
        map.put("Duration", Integer.valueOf(Math.round((c2628.m9591() * 1.0f) / 1000.0f)));
        map.put("Res_Width", String.valueOf(Math.max(c3621.m11682(), c3621.m11681())));
        map.put("Res_Height", String.valueOf(Math.min(c3621.m11682(), c3621.m11681())));
        map.put("Birtate", String.valueOf((C2811.m10145(c3891M13890.m12463(), c3891M13890.m12462(), c3891M13890.m12482(), c3891M13890.m12484(), c3891M13890.m12478()) * 1.0f) / 1000000.0f));
        map.put(HttpHeaders.HEAD_KEY_LOCATION, String.valueOf((c3891M13890.m12437() == 1 && C4112.m13054()) ? 1 : 0));
        map.put("VolumekeyRec", String.valueOf(c3891M13890.m12486()));
        map.put("Encode", c3891M13890.m12478() == 0 ? "H264" : "H265");
        map.put("Beeper", String.valueOf(c3891M13890.m12458()));
        map.put(ExifInterface.TAG_FLASH, String.valueOf(c3891M13890.m12459()));
        map.put("Torch", String.valueOf(c3621.m11683()));
        map.put("WaveType", String.valueOf(c3891M13890.m12487()));
        map.put("AssistantsAuto", String.valueOf(c3891M13890.m12379()));
        map.put("R-Light", String.valueOf(c3621.m11677()));
        map.put("R-Zoom", String.valueOf(c3621.m11680()));
        map.put("R-V", String.valueOf(c3621.m11679()));
        map.put("R-H", String.valueOf(c3621.m11678()));
        int iM12427 = c3891M13890.m12427();
        int iM12405 = c3891M13890.m12405();
        int i = c3891M13890.m12470() == 1 ? 1 : 0;
        if (iM12405 == 1) {
            i += 2;
        }
        if (iM12427 == 1) {
            i += 4;
        }
        map.put("Grid", String.valueOf(i));
        map.put("Assistants", String.valueOf(c3891M13890.m12375()));
        map.put("SafeArea", String.valueOf(c3891M13890.m12464()));
        m7050(map);
        map.put("SystemVersion", "Android " + Build.VERSION.RELEASE);
        map.put("VFR", String.valueOf(c2628.m9626()));
        map.put("AutoExposure", String.valueOf(c3891M13890.m12381() ? 1 : 0));
        map.put("Lens", String.valueOf(c2628.m9614()));
        map.put("Mic", String.valueOf(c2628.m9617()));
        map.put("AudioAutoGain", String.valueOf(c3891M13890.m12430() ? 1 : 0));
        map.put("Mode", String.valueOf(c2628.m9618()));
        map.put("Style", String.valueOf(c2628.m9616()));
        map.put("Stabilization", String.valueOf(c3891M13890.m12466()));
        map.put("Flicker", String.valueOf(c2628.m9609()));
        map.put("Framework", String.valueOf(c2628.m9611()));
        map.put("Battery", String.valueOf(c2628.m9601()));
        map.put("Accessories", String.valueOf(c2628.m9597()));
        map.put("FPS", String.valueOf(c2628.m9620()));
        return map;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m7052(int i) {
        HashMap map = new HashMap();
        m7050(map);
        map.put("Type", i + "");
        m7054(FilmApp.m402(), "AbFocus", map);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m7053(int i) {
        HashMap map = new HashMap();
        m7050(map);
        map.put("Type", i + "");
        m7054(FilmApp.m402(), "AbZoom", map);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m7054(Context context, String str, Map<String, Object> map) {
        MobclickAgent.onEventObject(context, str, map);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m7055(Map<String, Object> map) {
        m7054(FilmApp.m402(), "VideoInfos", map);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m7056(String str) {
        HashMap map = new HashMap();
        m7050(map);
        map.put("Style", str);
        m7054(FilmApp.m402(), "Style", map);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static void m7057(int i) {
        HashMap map = new HashMap();
        m7050(map);
        map.put("Type", i + "");
        m7054(FilmApp.m402(), "Payment", map);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m7058() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PlaybackDelete", map);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m7059() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PlaybackPlay", map);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static void m7060() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PlaybackShare", map);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static void m7061(int i) {
        HashMap map = new HashMap();
        m7050(map);
        map.put("State", i + "");
        m7054(FilmApp.m402(), "PlaybackTag", map);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static void m7062() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PresetAdd", map);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static void m7063() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PresetDelete", map);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static void m7064() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PresetLoad", map);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static void m7065() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PresetReLoad", map);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static void m7066() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PresetScan", map);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static void m7067() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "PresetShare", map);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static void m7068() {
        HashMap map = new HashMap();
        m7050(map);
        m7054(FilmApp.m402(), "StartRec", map);
    }
}
