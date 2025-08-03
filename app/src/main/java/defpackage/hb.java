package defpackage;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class hb {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f6725;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f6726;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f6727;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f6728;

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f6729;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f6730;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f6731;

    public hb(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f6725 = str;
        this.f6726 = str2;
        this.f6727 = str3;
        this.f6728 = str4;
        this.f6729 = str5;
        this.f6730 = str6;
        this.f6731 = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String strSubstring;
        StringBuilder sb2;
        String strSubstring2;
        StringBuilder sb3;
        String strSubstring3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP + this.f6725);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP + this.f6726);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP + this.f6727);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP + this.f6728);
        if (ua.m8370(this.f6729) || this.f6729.length() < 20) {
            sb = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
            strSubstring = this.f6729;
        } else {
            sb = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
            strSubstring = this.f6729.substring(0, 20);
        }
        sb.append(strSubstring);
        stringBuffer.append(sb.toString());
        if (ua.m8370(this.f6730) || this.f6730.length() < 20) {
            sb2 = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
            strSubstring2 = this.f6730;
        } else {
            sb2 = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
            strSubstring2 = this.f6730.substring(0, 20);
        }
        sb2.append(strSubstring2);
        stringBuffer.append(sb2.toString());
        if (ua.m8370(this.f6731) || this.f6731.length() < 20) {
            sb3 = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
            strSubstring3 = this.f6731;
        } else {
            sb3 = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
            strSubstring3 = this.f6731.substring(0, 20);
        }
        sb3.append(strSubstring3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
