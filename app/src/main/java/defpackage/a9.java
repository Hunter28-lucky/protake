package defpackage;

import android.util.Log;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/* compiled from: XmlLog.java */
/* loaded from: classes2.dex */
public class a9 extends C5164 {
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m16(String str) throws Throwable {
        XMLWriter xMLWriter;
        Throwable th;
        Document document;
        StringWriter stringWriter;
        XMLWriter xMLWriter2 = null;
        try {
            document = new SAXReader().read(new StringReader(str));
            stringWriter = new StringWriter();
            xMLWriter = new XMLWriter(stringWriter, new OutputFormat(MyUTIL.white_space, true));
        } catch (IOException unused) {
        } catch (DocumentException unused2) {
        } catch (Throwable th2) {
            xMLWriter = null;
            th = th2;
        }
        try {
            xMLWriter.write(document);
            xMLWriter.flush();
            String string = stringWriter.getBuffer().toString();
            try {
                xMLWriter.close();
                return string;
            } catch (IOException unused3) {
                return str;
            }
        } catch (IOException unused4) {
            xMLWriter2 = xMLWriter;
            if (xMLWriter2 != null) {
                try {
                    xMLWriter2.close();
                } catch (IOException unused5) {
                }
            }
            return str;
        } catch (DocumentException unused6) {
            xMLWriter2 = xMLWriter;
            if (xMLWriter2 != null) {
                try {
                    xMLWriter2.close();
                } catch (IOException unused7) {
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            if (xMLWriter != null) {
                try {
                    xMLWriter.close();
                } catch (IOException unused8) {
                    return str;
                }
            }
            throw th;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m17(String str, String str2, String str3) {
        String str4 = str2 != null ? str3 + "\n" + m16(str2) : str3 + "Log with null object";
        C5164.m15092(str, true);
        for (String str5 : str4.split(InterfaceC2469.f9168)) {
            if (!C5164.m15090(str5)) {
                Log.d(str, "║ " + str5);
            }
        }
        C5164.m15092(str, false);
    }
}
