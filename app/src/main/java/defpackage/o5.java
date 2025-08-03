package defpackage;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

/* compiled from: VideoAudioMux.java */
/* loaded from: classes.dex */
public class o5 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f8080;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ByteBuffer f8081;

    /* renamed from: ԩ, reason: contains not printable characters */
    public MediaCodec.BufferInfo f8082;

    public o5(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.f8080 = i;
        this.f8081 = byteBuffer;
        this.f8082 = bufferInfo;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m7691(MediaCodec.BufferInfo bufferInfo) {
        return String.format("[presentationTimeUs=%s,flags=%s,offset=%s,size=%s]", Long.valueOf(bufferInfo.presentationTimeUs), Integer.valueOf(bufferInfo.flags), Integer.valueOf(bufferInfo.offset), Integer.valueOf(bufferInfo.size));
    }

    public String toString() {
        return "MuxData{trackIndex=" + this.f8080 + ", byteBuf=" + this.f8081 + ", bufferInfo=" + m7691(this.f8082) + '}';
    }
}
