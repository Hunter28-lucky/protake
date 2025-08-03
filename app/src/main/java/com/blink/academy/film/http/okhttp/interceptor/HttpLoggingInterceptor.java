package com.blink.academy.film.http.okhttp.interceptor;

import androidx.core.app.NotificationCompat;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import defpackage.AbstractC2613;
import defpackage.AbstractC4809;
import defpackage.C2314;
import defpackage.C4186;
import defpackage.C4539;
import defpackage.C4770;
import defpackage.C5207;
import defpackage.InterfaceC2818;
import defpackage.InterfaceC5051;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.Protocol;
import okio.Buffer;
import org.jcodec.platform.Platform;

/* loaded from: classes.dex */
public class HttpLoggingInterceptor implements InterfaceC2818 {
    private static final Charset UTF8 = Charset.forName(Platform.UTF_8);
    private boolean isLogEnable;
    private volatile Level level;
    private Logger logger;
    private String tag;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public HttpLoggingInterceptor(String str) {
        this.level = Level.NONE;
        this.isLogEnable = false;
        this.tag = str;
        this.logger = Logger.getLogger(str);
    }

    private void bodyToString(C4539 c4539) {
        try {
            C4539 c4539M13927 = c4539.m13924().m13927();
            Buffer buffer = new Buffer();
            c4539M13927.m13916().writeTo(buffer);
            Charset charset = UTF8;
            C2314 c2314ContentType = c4539M13927.m13916().contentType();
            log("\tbody:" + URLDecoder.decode(buffer.readString(c2314ContentType != null ? c2314ContentType.m8684(charset) : charset), charset.name()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean isPlaintext(C2314 c2314) {
        if (c2314 == null) {
            return false;
        }
        if (c2314.m8687() != null && c2314.m8687().equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
            return true;
        }
        String strM8686 = c2314.m8686();
        if (strM8686 != null) {
            String lowerCase = strM8686.toLowerCase();
            if (lowerCase.contains("x-www-form-urlencoded") || lowerCase.contains("json") || lowerCase.contains("xml") || lowerCase.contains("html")) {
                return true;
            }
        }
        return false;
    }

    private void logForRequest(C4539 c4539, InterfaceC5051 interfaceC5051) throws IOException {
        StringBuilder sb;
        log("-------------------------------request-------------------------------");
        Level level = this.level;
        Level level2 = Level.BODY;
        boolean z = level == level2;
        boolean z2 = this.level == level2 || this.level == Level.HEADERS;
        AbstractC2613 abstractC2613M13916 = c4539.m13916();
        boolean z3 = abstractC2613M13916 != null;
        try {
            try {
                log("--> " + c4539.m13923() + ' ' + URLDecoder.decode(c4539.m13925().m11545().toString(), UTF8.name()) + ' ' + (interfaceC5051 != null ? interfaceC5051.mo7798() : Protocol.HTTP_1_1));
                if (z2) {
                    C5207 c5207M13920 = c4539.m13920();
                    int size = c5207M13920.size();
                    for (int i = 0; i < size; i++) {
                        log("\t" + c5207M13920.m15183(i) + ": " + c5207M13920.m15185(i));
                    }
                    if (z && z3) {
                        if (isPlaintext(abstractC2613M13916.contentType())) {
                            bodyToString(c4539);
                        } else {
                            log("\tbody: maybe [file part] , too large too print , ignored!");
                        }
                    }
                }
                sb = new StringBuilder();
            } catch (Exception e2) {
                e(e2);
                sb = new StringBuilder();
            }
            sb.append("--> END ");
            sb.append(c4539.m13923());
            log(sb.toString());
        } catch (Throwable th) {
            log("--> END " + c4539.m13923());
            throw th;
        }
    }

    private C4770 logForResponse(C4770 c4770, long j) {
        log("-------------------------------response-------------------------------");
        C4770 c4770M14351 = c4770.m14343().m14351();
        AbstractC4809 abstractC4809M14330 = c4770M14351.m14330();
        Level level = this.level;
        Level level2 = Level.BODY;
        boolean z = true;
        boolean z2 = level == level2;
        if (this.level != level2 && this.level != Level.HEADERS) {
            z = false;
        }
        try {
            try {
                log("<-- " + c4770M14351.m14334() + ' ' + c4770M14351.m14341() + ' ' + URLDecoder.decode(c4770M14351.m14347().m13925().m11545().toString(), UTF8.name()) + " (" + j + "ms）");
                if (z) {
                    log(MyUTIL.white_space);
                    C5207 c5207M14339 = c4770M14351.m14339();
                    int size = c5207M14339.size();
                    for (int i = 0; i < size; i++) {
                        log("\t" + c5207M14339.m15183(i) + ": " + c5207M14339.m15185(i));
                    }
                    log(MyUTIL.white_space);
                    if (z2 && C4186.m13203(c4770M14351)) {
                        if (isPlaintext(abstractC4809M14330.contentType())) {
                            String strString = abstractC4809M14330.string();
                            log("\tbody:" + strString);
                            return c4770.m14343().m14350(AbstractC4809.create(abstractC4809M14330.contentType(), strString)).m14351();
                        }
                        log("\tbody: maybe [file part] , too large too print , ignored!");
                    }
                    log(MyUTIL.white_space);
                }
            } catch (Exception e2) {
                e(e2);
            }
            return c4770;
        } finally {
            log("<-- END HTTP");
        }
    }

    public void e(Throwable th) {
        if (this.isLogEnable) {
            th.printStackTrace();
        }
    }

    public Level getLevel() {
        return this.level;
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws Exception {
        C4539 c4539Request = interfaceC2819.request();
        if (this.level == Level.NONE) {
            return interfaceC2819.mo10160(c4539Request);
        }
        logForRequest(c4539Request, interfaceC2819.mo10161());
        try {
            return logForResponse(interfaceC2819.mo10160(c4539Request), TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - System.nanoTime()));
        } catch (Exception e2) {
            log("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    public void log(String str) {
        this.logger.log(java.util.logging.Level.INFO, str);
    }

    public void log2(String str) {
        String strTrim = str.trim();
        int i = 0;
        while (i < strTrim.length()) {
            int i2 = i + 4000;
            this.logger.log(java.util.logging.Level.INFO, (strTrim.length() <= i2 ? strTrim.substring(i) : strTrim.substring(i, 4000)).trim());
            i = i2;
        }
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public HttpLoggingInterceptor(String str, boolean z) {
        this.level = Level.NONE;
        this.tag = str;
        this.isLogEnable = z;
        this.logger = Logger.getLogger(str);
    }
}
