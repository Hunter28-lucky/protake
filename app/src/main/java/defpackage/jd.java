package defpackage;

import android.content.Context;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class jd {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static hc f7748;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Object f7749 = new Object();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static long m7112(hc hcVar) {
        if (hcVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", hcVar.m6196(), hcVar.m6198(), Long.valueOf(hcVar.m6190()), hcVar.m6200(), hcVar.m6193());
        if (xf.m8613(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static hc m7113(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (f7749) {
            String strM7566 = me.m7562(context).m7566();
            if (xf.m8613(strM7566)) {
                return null;
            }
            if (strM7566.endsWith("\n")) {
                strM7566 = strM7566.substring(0, strM7566.length() - 1);
            }
            hc hcVar = new hc();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strM7201 = ke.m7201(context);
            String strM7203 = ke.m7203(context);
            hcVar.m6197(strM7201);
            hcVar.m6192(strM7201);
            hcVar.m6194(jCurrentTimeMillis);
            hcVar.m6195(strM7203);
            hcVar.m6199(strM7566);
            hcVar.m6191(m7112(hcVar));
            return hcVar;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static synchronized hc m7114(Context context) {
        hc hcVar = f7748;
        if (hcVar != null) {
            return hcVar;
        }
        if (context == null) {
            return null;
        }
        hc hcVarM7113 = m7113(context);
        f7748 = hcVarM7113;
        return hcVarM7113;
    }
}
