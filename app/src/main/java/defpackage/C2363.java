package defpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DomainUtils.java */
/* renamed from: ń, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2363 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8830(String str) {
        try {
            Matcher matcher = Pattern.compile("[^\\.]+(\\.com\\.cn|\\.net\\.cn|\\.org\\.cn|\\.gov\\.cn|\\.com|\\.net|\\.cn|\\.org|\\.cc|\\.me|\\.tel|\\.mobi|\\.asia|\\.biz|\\.info|\\.name|\\.tv|\\.hk|\\.公司|\\.中国|\\.网络)").matcher(new URL(str).getHost().toLowerCase());
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
