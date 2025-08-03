package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1840;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class q implements InterfaceC3907<InputStream, C3465> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<ImageHeaderParser> f8306;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC3907<ByteBuffer, C3465> f8307;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC4950 f8308;

    public q(List<ImageHeaderParser> list, InterfaceC3907<ByteBuffer, C3465> interfaceC3907, InterfaceC4950 interfaceC4950) {
        this.f8306 = list;
        this.f8307 = interfaceC3907;
        this.f8308 = interfaceC4950;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static byte[] m7983(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4536<C3465> mo5018(@NonNull InputStream inputStream, int i, int i2, @NonNull C3475 c3475) throws IOException {
        byte[] bArrM7983 = m7983(inputStream);
        if (bArrM7983 == null) {
            return null;
        }
        return this.f8307.mo5018(ByteBuffer.wrap(bArrM7983), i, i2, c3475);
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo5017(@NonNull InputStream inputStream, @NonNull C3475 c3475) throws IOException {
        return !((Boolean) c3475.m11329(C3605.f12534)).booleanValue() && C1840.m5022(this.f8306, inputStream, this.f8308) == ImageHeaderParser.ImageType.GIF;
    }
}
