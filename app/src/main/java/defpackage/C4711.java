package defpackage;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: dates.kt */
/* renamed from: ട, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4711 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C4712 f15977 = new C4712();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String[] f15978;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final DateFormat[] f15979;

    /* compiled from: dates.kt */
    /* renamed from: ട$Ϳ, reason: contains not printable characters */
    public static final class C4712 extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(i5.f6768);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f15978 = strArr;
        f15979 = new DateFormat[strArr.length];
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Date m14249(String str) {
        C3921.m12667(str, "$this$toHttpDateOrNull");
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = f15977.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        String[] strArr = f15978;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                DateFormat[] dateFormatArr = f15979;
                DateFormat simpleDateFormat = dateFormatArr[i];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(f15978[i], Locale.US);
                    simpleDateFormat.setTimeZone(i5.f6768);
                    dateFormatArr[i] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            i4 i4Var = i4.f6762;
            return null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String m14250(Date date) {
        C3921.m12667(date, "$this$toHttpDateString");
        String str = f15977.get().format(date);
        C3921.m12663(str, "STANDARD_DATE_FORMAT.get().format(this)");
        return str;
    }
}
