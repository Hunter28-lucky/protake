package defpackage;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class af {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String f29 = "";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String f30 = "";

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String f31 = "";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized void m37(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        m40(arrayList);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static synchronized void m38(String str, String str2, String str3) {
        f29 = str;
        f30 = str2;
        f31 = str3;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static synchronized void m39(Throwable th) {
        String string;
        ArrayList arrayList = new ArrayList();
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        } else {
            string = "";
        }
        arrayList.add(string);
        m40(arrayList);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static synchronized void m40(List<String> list) {
        if (!ua.m8370(f30) && !ua.m8370(f31)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f31);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(", " + it.next());
            }
            stringBuffer.append("\n");
            try {
                File file = new File(f29);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(f29, f30);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                fileWriter.write(stringBuffer.toString());
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception unused) {
            }
        }
    }
}
