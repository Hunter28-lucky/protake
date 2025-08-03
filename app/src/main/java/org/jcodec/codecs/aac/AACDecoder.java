package org.jcodec.codecs.aac;

import java.io.IOException;
import java.nio.ByteBuffer;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.Decoder;
import net.sourceforge.jaad.aac.SampleBuffer;
import org.jcodec.codecs.aac.ADTSParser;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.AudioDecoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.AudioBuffer;

/* loaded from: classes2.dex */
public class AACDecoder implements AudioDecoder {
    private Decoder decoder;

    public AACDecoder(ByteBuffer byteBuffer) throws AACException {
        if (byteBuffer.remaining() >= 7) {
            ADTSParser.Header header = ADTSParser.read(byteBuffer);
            byteBuffer = header != null ? ADTSParser.adtsToStreamInfo(header) : byteBuffer;
            Logger.info("Creating AAC decoder from ADTS header.");
        }
        this.decoder = new Decoder(NIOUtils.toArray(byteBuffer));
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        return (byteBuffer.remaining() >= 7 && ADTSParser.read(byteBuffer) != null) ? 100 : 0;
    }

    private AudioFormat toAudioFormat(SampleBuffer sampleBuffer) {
        return new AudioFormat(sampleBuffer.getSampleRate(), sampleBuffer.getBitsPerSample(), sampleBuffer.getChannels(), true, sampleBuffer.isBigEndian());
    }

    @Override // org.jcodec.common.AudioDecoder
    public AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException {
        ADTSParser.read(byteBuffer);
        SampleBuffer sampleBuffer = new SampleBuffer();
        this.decoder.decodeFrame(NIOUtils.toArray(byteBuffer), sampleBuffer);
        if (sampleBuffer.isBigEndian()) {
            sampleBuffer.setBigEndian(false);
        }
        return new AudioBuffer(ByteBuffer.wrap(sampleBuffer.getData()), toAudioFormat(sampleBuffer), 0);
    }

    @Override // org.jcodec.common.AudioDecoder
    public AudioCodecMeta getCodecMeta(ByteBuffer byteBuffer) throws IOException {
        SampleBuffer sampleBuffer = new SampleBuffer();
        this.decoder.decodeFrame(NIOUtils.toArray(byteBuffer), sampleBuffer);
        sampleBuffer.setBigEndian(false);
        return AudioCodecMeta.fromAudioFormat(toAudioFormat(sampleBuffer));
    }
}
