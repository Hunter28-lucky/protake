package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes2.dex */
class ExceptionPropagatingDecoder<T, R> implements Decoder<T, R> {
    private final Decoder<T, R> decoder;

    public ExceptionPropagatingDecoder(Decoder<T, R> decoder) {
        Assert.notNull(decoder, "Decoder cannot be null.");
        this.decoder = decoder;
    }

    @Override // io.jsonwebtoken.io.Decoder
    public R decode(T t) throws DecodingException {
        Assert.notNull(t, "Decode argument cannot be null.");
        try {
            return this.decoder.decode(t);
        } catch (DecodingException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new DecodingException("Unable to decode input: " + e3.getMessage(), e3);
        }
    }
}
