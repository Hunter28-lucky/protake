package io.jsonwebtoken;

/* loaded from: classes2.dex */
public interface CompressionCodecResolver {
    CompressionCodec resolveCompressionCodec(Header header) throws CompressionException;
}
