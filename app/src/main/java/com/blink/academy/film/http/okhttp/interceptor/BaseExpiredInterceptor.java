package com.blink.academy.film.http.okhttp.interceptor;

import androidx.core.app.NotificationCompat;
import com.blink.academy.film.http.okhttp.utils.HttpUtil;
import defpackage.AbstractC4809;
import defpackage.C2314;
import defpackage.C4539;
import defpackage.C4638;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes.dex */
public abstract class BaseExpiredInterceptor implements InterfaceC2818 {
    private boolean isText(C2314 c2314) {
        if (c2314 == null) {
            return false;
        }
        if (c2314.m8687() == null || !c2314.m8687().equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
            return c2314.m8686() != null && c2314.m8686().equals("json");
        }
        return true;
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        C4539 c4539Request = interfaceC2819.request();
        C4770 c4770Mo10160 = interfaceC2819.mo10160(c4539Request);
        AbstractC4809 abstractC4809M14330 = c4770Mo10160.m14330();
        BufferedSource bufferedSourceSource = abstractC4809M14330.source();
        bufferedSourceSource.request(Long.MAX_VALUE);
        Buffer buffer = bufferedSourceSource.buffer();
        Charset charsetM8684 = HttpUtil.UTF8;
        C2314 c2314ContentType = abstractC4809M14330.contentType();
        if (c2314ContentType != null) {
            charsetM8684 = c2314ContentType.m8684(charsetM8684);
        }
        String string = buffer.clone().readString(charsetM8684);
        C4638.m14103("网络拦截器:" + string + " host:" + c4539Request.m13925().toString());
        return (isText(c2314ContentType) && isResponseExpired(c4770Mo10160, string)) ? responseExpired(interfaceC2819, string) : c4770Mo10160;
    }

    public abstract boolean isResponseExpired(C4770 c4770, String str);

    public abstract C4770 responseExpired(InterfaceC2818.InterfaceC2819 interfaceC2819, String str);
}
