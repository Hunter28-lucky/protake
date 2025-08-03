package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import androidx.core.net.MailTo;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import com.umeng.analytics.pro.aq;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ShareUtils.java */
/* renamed from: ઑ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4320 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m13455(String str) {
        return C5213.m15210() ? "https://terms.alicdn.com/legal-agreement/terms/suit_bu1_taobao/suit_bu1_taobao202204181941_68444.html" : "https://terms.alicdn.com/legal-agreement/terms/platform_service/20220621172324148/20220621172324148.html";
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m13456(String str) {
        C5213.m15210();
        return "https://beian.miit.gov.cn";
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m13457(String str) {
        return C5213.m15210() ? "https://terms.alicdn.com/legal-agreement/terms/suit_bu1_taobao/suit_bu1_taobao202204202141_98092.html" : "https://terms.alicdn.com/legal-agreement/terms/privacy/20220704104156634/20220704104156634.html";
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static Uri m13458(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{aq.d}, "_data=?", new String[]{absolutePath}, null);
        Uri uriInsert = null;
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex(aq.d));
                uriInsert = Uri.withAppendedPath(Uri.parse("content://media/external/video/media"), "" + i);
            }
            cursorQuery.close();
        }
        if (uriInsert == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            uriInsert = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        if (uriInsert != null) {
            return uriInsert;
        }
        return FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".fileProvider", file);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m13459(Context context) {
        m13464(context, m13456(FilmApp.m405().m410()));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m13460(Context context) {
        m13464(context, m13457(FilmApp.m405().m410()));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m13461(Context context) {
        m13464(context, m13455(FilmApp.m405().m410()));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static void m13462(Context context) throws Resources.NotFoundException {
        if (context == null) {
            return;
        }
        m13463(context, context.getResources().getString(R.string.CONTACT_SUPPORT), context.getResources().getString(R.string.CONTACT_SUPPORT_CONTENT1) + "\n\n" + context.getResources().getString(R.string.CONTACT_SUPPORT_CONTENT2), "support-android@nomo.vip");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m13463(Context context, String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME + str3));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str3});
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        context.startActivity(Intent.createChooser(intent, "support"));
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m13464(Context context, String str) {
        if (context == null) {
            return;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        context.startActivity(intent);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static void m13465(Context context, String str) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        File file = new File(str);
        Uri uriM13458 = Build.VERSION.SDK_INT >= 24 ? m13458(context, file) : Uri.fromFile(file);
        intent.addFlags(1);
        intent.putExtra("android.intent.extra.STREAM", uriM13458);
        context.startActivity(Intent.createChooser(intent, "Share to"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static void m13466(Context context, List<String> list) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("video/*");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            arrayList.add(Build.VERSION.SDK_INT >= 24 ? m13458(context, file) : Uri.fromFile(file));
        }
        intent.addFlags(3);
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        context.startActivity(Intent.createChooser(intent, "Share to"));
    }
}
