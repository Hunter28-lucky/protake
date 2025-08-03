package org.jcodec.containers.flv;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.flv.FLVTag;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class FLVReader {
    private static final int READ_BUFFER_SIZE = 1024;
    private static final int REPOSITION_BUFFER_READS = 10;
    private static final int TAG_HEADER_SIZE = 15;
    public static Codec[] audioCodecMapping;
    private static boolean platformBigEndian;
    public static int[] sampleRates;
    public static Codec[] videoCodecMapping;
    private SeekableByteChannel ch;
    private boolean eof;
    private int frameNo;
    private ByteBuffer readBuf;

    static {
        platformBigEndian = ByteBuffer.allocate(0).order() == ByteOrder.BIG_ENDIAN;
        Codec codec = Codec.PCM;
        Codec codec2 = Codec.MP3;
        Codec codec3 = Codec.NELLYMOSER;
        Codec codec4 = Codec.G711;
        audioCodecMapping = new Codec[]{codec, Codec.ADPCM, codec2, codec, codec3, codec3, codec3, codec4, codec4, null, Codec.AAC, Codec.SPEEX, codec2, null};
        Codec codec5 = Codec.VP6;
        videoCodecMapping = new Codec[]{null, null, Codec.SORENSON, Codec.FLASH_SCREEN_VIDEO, codec5, codec5, Codec.FLASH_SCREEN_V2, Codec.H264};
        sampleRates = new int[]{5500, 11000, 22000, 44100};
    }

    public FLVReader(SeekableByteChannel seekableByteChannel) throws IOException {
        this.ch = seekableByteChannel;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        this.readBuf = byteBufferAllocate;
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        initialRead(seekableByteChannel);
        if (readHeader(this.readBuf)) {
            return;
        }
        this.readBuf.position(0);
        if (!repositionFile()) {
            throw new RuntimeException("Invalid FLV file");
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.readBuf.position());
        objArr[1] = this.readBuf.position() == 0 ? "Did you forget the FLV 9-byte header?" : "";
        Logger.warn(String.format("Parsing a corrupt FLV file, first tag found at %d. %s", objArr));
    }

    private void initialRead(ReadableByteChannel readableByteChannel) throws IOException {
        this.readBuf.clear();
        if (readableByteChannel.read(this.readBuf) == -1) {
            this.eof = true;
        }
        this.readBuf.flip();
    }

    private static void moveRemainderToTheStart(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        for (int i = 0; i < iRemaining; i++) {
            byteBuffer.put(i, byteBuffer.get());
        }
        byteBuffer.clear();
        byteBuffer.position(iRemaining);
    }

    public static FLVTag.TagHeader parseAudioTagHeader(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        int i = (b & ExifInterface.MARKER) >> 4;
        int i2 = sampleRates[(b >> 2) & 3];
        if (i == 4 || i == 11) {
            i2 = 16000;
        }
        if (i == 5 || i == 14) {
            i2 = 8000;
        }
        int i3 = i2;
        int i4 = (b & 2) == 0 ? 8 : 16;
        AudioFormat audioFormat = new AudioFormat(i3, i4, i == 11 ? 1 : (b & 1) + 1, !(i == 3 || i == 0) || i4 == 16, i != 3 ? platformBigEndian : false);
        Codec codec = audioCodecMapping[i];
        return i == 10 ? new FLVTag.AacAudioTagHeader(codec, audioFormat, byteBuffer.get()) : new FLVTag.AudioTagHeader(codec, audioFormat);
    }

    public static FLVMetadata parseMetadata(ByteBuffer byteBuffer) {
        if ("onMetaData".equals(readAMFData(byteBuffer, -1))) {
            return new FLVMetadata((Map) readAMFData(byteBuffer, -1));
        }
        return null;
    }

    public static FLVTag.VideoTagHeader parseVideoTagHeader(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        int i = (b & ExifInterface.MARKER) >> 4;
        int i2 = b & cb.m;
        Codec codec = videoCodecMapping[i2];
        if (i2 != 7) {
            return new FLVTag.VideoTagHeader(codec, i);
        }
        return new FLVTag.AvcVideoTagHeader(codec, i, byteBuffer.get(), (byteBuffer.get() & ExifInterface.MARKER) | (byteBuffer.getShort() << 8));
    }

    public static boolean positionAtPacket(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBufferDuplicate, 5);
        int i = 0;
        while (byteBufferDuplicate.hasRemaining()) {
            i = ((i & 65535) << 8) | (byteBufferDuplicate.get() & ExifInterface.MARKER);
            int iPosition = byteBufferDuplicate.position() + 7 + i;
            if (byteBufferDuplicate.position() >= 8 && iPosition < byteBufferDuplicate.limit() - 4 && byteBufferDuplicate.getInt(iPosition) - i == 11) {
                byteBuffer.position(byteBufferDuplicate.position() - 8);
                return true;
            }
        }
        return false;
    }

    public static int probe(ByteBuffer byteBuffer) {
        try {
            readHeader(byteBuffer);
            return 100;
        } catch (RuntimeException unused) {
            return 0;
        }
    }

    private static Object readAMFData(ByteBuffer byteBuffer, int i) {
        if (i == -1) {
            i = byteBuffer.get() & ExifInterface.MARKER;
        }
        if (i == 0) {
            return Double.valueOf(byteBuffer.getDouble());
        }
        if (i == 1) {
            return Boolean.valueOf(byteBuffer.get() == 1);
        }
        if (i == 2) {
            return readAMFString(byteBuffer);
        }
        if (i == 3) {
            return readAMFObject(byteBuffer);
        }
        if (i == 8) {
            return readAMFEcmaArray(byteBuffer);
        }
        if (i == 13) {
            return "UNDEFINED";
        }
        if (i == 10) {
            return readAMFStrictArray(byteBuffer);
        }
        if (i != 11) {
            return null;
        }
        Date date = new Date((long) byteBuffer.getDouble());
        byteBuffer.getShort();
        return date;
    }

    private static Object readAMFEcmaArray(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        HashMap map = new HashMap();
        for (int i = 0; i < j; i++) {
            map.put(readAMFString(byteBuffer), readAMFData(byteBuffer, byteBuffer.get() & ExifInterface.MARKER));
        }
        return map;
    }

    private static Object readAMFObject(ByteBuffer byteBuffer) {
        HashMap map = new HashMap();
        while (true) {
            String aMFString = readAMFString(byteBuffer);
            int i = byteBuffer.get() & ExifInterface.MARKER;
            if (i == 9) {
                return map;
            }
            map.put(aMFString, readAMFData(byteBuffer, i));
        }
    }

    private static Object readAMFStrictArray(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = readAMFData(byteBuffer, -1);
        }
        return objArr;
    }

    private static String readAMFString(ByteBuffer byteBuffer) {
        return Platform.stringFromCharset(NIOUtils.toArray(NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535)), Platform.UTF_8);
    }

    public static boolean readHeader(ByteBuffer byteBuffer) {
        return byteBuffer.remaining() >= 9 && byteBuffer.get() == 70 && byteBuffer.get() == 76 && byteBuffer.get() == 86 && byteBuffer.get() == 1 && (byteBuffer.get() & 5) != 0 && byteBuffer.getInt() == 9;
    }

    public FLVTag parsePacket(ByteBuffer byteBuffer) throws IOException {
        FLVTag.TagHeader audioTagHeader;
        long jPosition;
        int i;
        int i2;
        int i3;
        int i4;
        ByteBuffer byteBufferClone;
        FLVTag.Type type;
        boolean z;
        while (true) {
            audioTagHeader = null;
            if (byteBuffer.remaining() < 15) {
                return null;
            }
            int iPosition = byteBuffer.position();
            jPosition = this.ch.position() - byteBuffer.remaining();
            i = byteBuffer.getInt();
            i2 = byteBuffer.get() & ExifInterface.MARKER;
            int i5 = ((byteBuffer.getShort() & 65535) << 8) | (byteBuffer.get() & ExifInterface.MARKER);
            i3 = ((byteBuffer.getShort() & 65535) << 8) | (byteBuffer.get() & ExifInterface.MARKER) | ((byteBuffer.get() & ExifInterface.MARKER) << 24);
            i4 = ((65535 & byteBuffer.getShort()) << 8) | (byteBuffer.get() & ExifInterface.MARKER);
            if (byteBuffer.remaining() >= i5 + 4 && byteBuffer.getInt(byteBuffer.position() + i5) != i5 + 11) {
                byteBuffer.position(byteBuffer.position() - 15);
                if (!repositionFile()) {
                    Logger.error(String.format("Corrupt FLV stream at %d, failed to reposition!", Long.valueOf(jPosition)));
                    SeekableByteChannel seekableByteChannel = this.ch;
                    seekableByteChannel.setPosition(seekableByteChannel.size());
                    this.eof = true;
                    return null;
                }
                Logger.warn(String.format("Corrupt FLV stream at %d, repositioned to %d.", Long.valueOf(jPosition), Long.valueOf(this.ch.position() - byteBuffer.remaining())));
            } else {
                if (byteBuffer.remaining() < i5) {
                    byteBuffer.position(iPosition);
                    return null;
                }
                if (i2 == 8 || i2 == 9 || i2 == 18) {
                    byteBufferClone = NIOUtils.clone(NIOUtils.read(byteBuffer, i5));
                    if (i2 == 8) {
                        type = FLVTag.Type.AUDIO;
                        audioTagHeader = parseAudioTagHeader(byteBufferClone.duplicate());
                        break;
                    }
                    if (i2 == 9) {
                        type = FLVTag.Type.VIDEO;
                        audioTagHeader = parseVideoTagHeader(byteBufferClone.duplicate());
                        break;
                    }
                    if (i2 == 18) {
                        type = FLVTag.Type.SCRIPT;
                        break;
                    }
                    System.out.println("NON AV packet");
                } else {
                    NIOUtils.skip(byteBuffer, i5);
                }
            }
        }
        if (audioTagHeader == null || !(audioTagHeader instanceof FLVTag.VideoTagHeader)) {
            z = false;
        } else {
            z = (((FLVTag.VideoTagHeader) audioTagHeader).getFrameType() == 1) & false;
        }
        boolean z2 = i2 == 8 || i2 == 9;
        int i6 = this.frameNo;
        this.frameNo = i6 + 1;
        return new FLVTag(type, jPosition, audioTagHeader, i3, byteBufferClone, z & z2, i6, i4, i);
    }

    public FLVTag readNextPacket() throws IOException {
        if (this.eof) {
            return null;
        }
        FLVTag packet = parsePacket(this.readBuf);
        if (packet == null && !this.eof) {
            moveRemainderToTheStart(this.readBuf);
            if (this.ch.read(this.readBuf) == -1) {
                this.eof = true;
                return null;
            }
            while (MathUtil.log2(this.readBuf.capacity()) <= 22) {
                this.readBuf.flip();
                packet = parsePacket(this.readBuf);
                if (packet != null || this.readBuf.position() > 0) {
                    break;
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.readBuf.capacity() << 2);
                byteBufferAllocate.put(this.readBuf);
                this.readBuf = byteBufferAllocate;
                if (this.ch.read(byteBufferAllocate) == -1) {
                    this.eof = true;
                    return null;
                }
            }
        }
        return packet;
    }

    public FLVTag readPrevPacket() throws IOException {
        int i = this.readBuf.getInt();
        this.readBuf.position(r1.position() - 4);
        if (this.readBuf.position() > i) {
            ByteBuffer byteBuffer = this.readBuf;
            byteBuffer.position(byteBuffer.position() - i);
            return parsePacket(this.readBuf);
        }
        long jPosition = this.ch.position() - this.readBuf.remaining();
        if (jPosition <= 9) {
            return null;
        }
        long jMax = Math.max(0L, jPosition - (this.readBuf.capacity() / 2));
        this.ch.setPosition(jMax);
        this.readBuf.clear();
        this.ch.read(this.readBuf);
        this.readBuf.flip();
        this.readBuf.position((int) (jPosition - jMax));
        return readPrevPacket();
    }

    public void reposition() throws IOException {
        reset();
        if (!positionAtPacket(this.readBuf)) {
            throw new RuntimeException("Could not find at FLV tag start");
        }
    }

    public boolean repositionFile() throws IOException {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            while (this.readBuf.hasRemaining()) {
                i = ((i & 65535) << 8) | (this.readBuf.get() & ExifInterface.MARKER);
                int iPosition = this.readBuf.position() + 7 + i;
                if (this.readBuf.position() >= 8 && iPosition < this.readBuf.limit() - 4 && this.readBuf.getInt(iPosition) - i == 11) {
                    ByteBuffer byteBuffer = this.readBuf;
                    byteBuffer.position(byteBuffer.position() - 8);
                    return true;
                }
            }
            initialRead(this.ch);
            if (!this.readBuf.hasRemaining()) {
                break;
            }
        }
        return false;
    }

    public void reset() throws IOException {
        initialRead(this.ch);
    }
}
