package io.jsonwebtoken;

/* loaded from: classes2.dex */
public interface Jws<B> extends Jwt<JwsHeader, B> {
    String getSignature();
}
