package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import java.nio.charset.Charset;
import org.jcodec.platform.Platform;

@Deprecated
/* loaded from: classes2.dex */
public abstract class AbstractTextCodec implements TextCodec {
    public static final Charset UTF8 = Charset.forName(Platform.UTF_8);
    public static final Charset US_ASCII = Charset.forName("US-ASCII");

    @Override // io.jsonwebtoken.impl.TextCodec
    public String decodeToString(String str) {
        return new String(decode(str), UTF8);
    }

    @Override // io.jsonwebtoken.impl.TextCodec
    public String encode(String str) {
        Assert.hasText(str, "String argument to encode cannot be null or empty.");
        return encode(str.getBytes(UTF8));
    }
}
