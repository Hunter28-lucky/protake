package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes2.dex */
class ExceptionPropagatingEncoder<T, R> implements Encoder<T, R> {
    private final Encoder<T, R> encoder;

    public ExceptionPropagatingEncoder(Encoder<T, R> encoder) {
        Assert.notNull(encoder, "Encoder cannot be null.");
        this.encoder = encoder;
    }

    @Override // io.jsonwebtoken.io.Encoder
    public R encode(T t) throws EncodingException {
        Assert.notNull(t, "Encode argument cannot be null.");
        try {
            return this.encoder.encode(t);
        } catch (EncodingException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new EncodingException("Unable to encode input: " + e3.getMessage(), e3);
        }
    }
}
