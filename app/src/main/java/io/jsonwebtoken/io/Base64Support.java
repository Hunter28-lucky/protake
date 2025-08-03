package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes2.dex */
class Base64Support {
    public final Base64 base64;

    public Base64Support(Base64 base64) {
        Assert.notNull(base64, "Base64 argument cannot be null");
        this.base64 = base64;
    }
}
