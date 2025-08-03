package defpackage;

import android.os.Build;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;

/* compiled from: PermissionUtil.java */
/* renamed from: ॠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4112 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m13054() {
        return ContextCompat.checkSelfPermission(FilmApp.m405(), "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m13055() {
        return ContextCompat.checkSelfPermission(FilmApp.m405(), "android.permission.RECORD_AUDIO") == 0;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m13056() {
        return ContextCompat.checkSelfPermission(FilmApp.m405(), "android.permission.CAMERA") == 0;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m13057() {
        return Build.VERSION.SDK_INT >= 33 ? ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.READ_MEDIA_IMAGES") == 0 : ContextCompat.checkSelfPermission(FilmApp.m405(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
