package defpackage;

import android.graphics.Bitmap;
import android.os.Environment;
import com.blink.academy.film.FilmApp;
import java.io.File;

/* compiled from: Config.java */
/* renamed from: ग, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4062 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int f14090 = 25;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int f14091 = 300;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static Bitmap f14100;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String f14092 = Environment.getExternalStorageDirectory().getAbsolutePath();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String f14093 = FilmApp.m405().getFilesDir().getAbsolutePath() + "/";

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String f14094 = f14093 + "/filters/";

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String f14095 = f14093 + "/longvideo/";

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String f14096 = f14093 + "/thumb/";

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String f14097 = f14093 + "/sthumb/";

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String f14098 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String f14099 = "1";

    /* renamed from: ֏, reason: contains not printable characters */
    public static String f14101 = "FILMCN";

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String f14102 = "FILMEN";

    /* renamed from: ؠ, reason: contains not printable characters */
    public static String f14103 = "Protake";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m12991() {
        if (m.m7511().m7514() == 0) {
            return f14098 + "/" + f14103 + "/";
        }
        File[] externalFilesDirs = FilmApp.m402().getExternalFilesDirs(Environment.DIRECTORY_MOVIES);
        if (externalFilesDirs == null || externalFilesDirs.length <= 1) {
            return f14098 + "/" + f14103 + "/";
        }
        return externalFilesDirs[1].getPath() + "/" + f14103 + "/";
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m12992() {
        String str = f14093 + "previews/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m12993() {
        String str = f14093 + "filters/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m12994() {
        File file = new File(f14097);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m12995() {
        File file = new File(f14096);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
