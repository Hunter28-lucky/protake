package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class GzipCompressionCodec extends AbstractCompressionCodec {
    private static final String GZIP = "GZIP";

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    public byte[] doCompress(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream((OutputStream) byteArrayOutputStream, true);
        try {
            gZIPOutputStream.write(bArr, 0, bArr.length);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Objects.nullSafeClose(gZIPOutputStream, byteArrayOutputStream);
            return byteArray;
        } catch (Throwable th) {
            Objects.nullSafeClose(gZIPOutputStream, byteArrayOutputStream);
            throw th;
        }
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    public byte[] doDecompress(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2 = new byte[512];
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = null;
                byteArrayOutputStream = null;
            }
            try {
                for (int i = gZIPInputStream.read(bArr2); i != -1; i = gZIPInputStream.read(bArr2)) {
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Objects.nullSafeClose(byteArrayInputStream2, gZIPInputStream, byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = byteArrayInputStream2;
                Objects.nullSafeClose(byteArrayInputStream, gZIPInputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    @Override // io.jsonwebtoken.CompressionCodec
    public String getAlgorithmName() {
        return GZIP;
    }
}
