package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.File;

/* compiled from: ResourceHelper.java */
/* renamed from: அ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4450 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m13711(@NonNull Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(m13712(context));
        String str = File.separator;
        sb.append(str);
        sb.append("ComposeMakeup.bundle");
        sb.append(str);
        sb.append("ComposeMakeup/");
        return sb.toString();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m13712(Context context) {
        return context.getExternalFilesDir("assets").getAbsolutePath() + File.separator + "resource";
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m13713(@NonNull Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("user", 0);
        return sharedPreferences.getBoolean("resource", false) && i == sharedPreferences.getInt("versionCode", 0);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m13714(@NonNull Context context, boolean z, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("user", 0).edit();
        editorEdit.putBoolean("resource", z);
        editorEdit.putInt("versionCode", i);
        editorEdit.apply();
    }
}
