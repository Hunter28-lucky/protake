package defpackage;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: TimeUtils.java */
/* loaded from: classes.dex */
public class n2 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m7622(long j) {
        Date date = new Date(j);
        Calendar.getInstance().setTime(date);
        return String.format("%s", DateFormat.getDateInstance(1, C5213.m15210() ? Locale.CHINESE : Locale.ENGLISH).format(date));
    }
}
