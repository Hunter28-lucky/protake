package org.jcodec.containers.mps;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.http.okhttp.OkHttpUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Rational;

/* loaded from: classes2.dex */
public class MPSUtils {
    public static final int AUDIO_MAX = 479;
    public static final int AUDIO_MIN = 448;
    public static final int PACK = 442;
    public static final int PRIVATE_1 = 445;
    public static final int PRIVATE_2 = 447;
    public static final int PSM = 444;
    public static final int SYSTEM = 443;
    public static final int VIDEO_MAX = 495;
    public static final int VIDEO_MIN = 480;
    public static Class<? extends MPEGMediaDescriptor>[] dMapping;

    public static class AACAudioDescriptor extends MPEGMediaDescriptor {
        private int channel;
        private int flags;
        private int profile;

        public int getChannel() {
            return this.channel;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getProfile() {
            return this.profile;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.profile = byteBuffer.get() & ExifInterface.MARKER;
            this.channel = byteBuffer.get() & ExifInterface.MARKER;
            this.flags = byteBuffer.get() & ExifInterface.MARKER;
        }
    }

    public static class AVCVideoDescriptor extends MPEGMediaDescriptor {
        private int flags;
        private int level;
        private int profileIdc;

        public int getFlags() {
            return this.flags;
        }

        public int getLevel() {
            return this.level;
        }

        public int getProfileIdc() {
            return this.profileIdc;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.profileIdc = byteBuffer.get() & ExifInterface.MARKER;
            this.flags = byteBuffer.get() & ExifInterface.MARKER;
            this.level = byteBuffer.get() & ExifInterface.MARKER;
        }
    }

    public static class AudioStreamDescriptor extends MPEGMediaDescriptor {
        private int freeFormatFlag;
        private int id;
        private int layer;
        private int variableRateAudioIndicator;

        public int getFreeFormatFlag() {
            return this.freeFormatFlag;
        }

        public int getId() {
            return this.id;
        }

        public int getLayer() {
            return this.layer;
        }

        public int getVariableRateAudioIndicator() {
            return this.variableRateAudioIndicator;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            int i = byteBuffer.get() & ExifInterface.MARKER;
            this.freeFormatFlag = (i >> 7) & 1;
            this.id = (i >> 6) & 1;
            this.layer = (i >> 5) & 3;
            this.variableRateAudioIndicator = (i >> 3) & 1;
        }
    }

    public static class DataStreamAlignmentDescriptor extends MPEGMediaDescriptor {
        private int alignmentType;

        public int getAlignmentType() {
            return this.alignmentType;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.alignmentType = byteBuffer.get() & ExifInterface.MARKER;
        }
    }

    public static class ISO639LanguageDescriptor extends MPEGMediaDescriptor {
        private IntArrayList languageCodes = IntArrayList.createIntArrayList();

        public IntArrayList getLanguageCodes() {
            return this.languageCodes;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            while (byteBuffer.remaining() >= 4) {
                this.languageCodes.add(byteBuffer.getInt());
            }
        }
    }

    public static class MPEGMediaDescriptor {
        private int len;
        private int tag;

        public int getLen() {
            return this.len;
        }

        public int getTag() {
            return this.tag;
        }

        public void parse(ByteBuffer byteBuffer) {
            this.tag = byteBuffer.get() & ExifInterface.MARKER;
            this.len = byteBuffer.get() & ExifInterface.MARKER;
        }
    }

    public static class Mpeg4AudioDescriptor extends MPEGMediaDescriptor {
        private int profileLevel;

        public int getProfileLevel() {
            return this.profileLevel;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.profileLevel = byteBuffer.get() & ExifInterface.MARKER;
        }
    }

    public static class Mpeg4VideoDescriptor extends MPEGMediaDescriptor {
        private int profileLevel;

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.profileLevel = byteBuffer.get() & ExifInterface.MARKER;
        }
    }

    public static abstract class PESReader {
        private boolean _pes;
        private int lenFieldLeft;
        private int pesLeft;
        private int pesLen;
        private int stream;
        private int marker = -1;
        private long pesFileStart = -1;
        private ByteBuffer pesBuffer = ByteBuffer.allocate(2097152);

        private void flushMarker() {
            this.pesBuffer.put((byte) (this.marker >>> 24));
            this.pesBuffer.put((byte) ((this.marker >>> 16) & 255));
            this.pesBuffer.put((byte) ((this.marker >>> 8) & 255));
            this.pesBuffer.put((byte) (this.marker & 255));
        }

        private void pes1(ByteBuffer byteBuffer, long j, int i, int i2) {
            byteBuffer.flip();
            pes(byteBuffer, j, i, i2);
            byteBuffer.clear();
        }

        public void analyseBuffer(ByteBuffer byteBuffer, long j) {
            int iPosition = byteBuffer.position();
            while (byteBuffer.hasRemaining()) {
                if (this.pesLeft > 0) {
                    int iMin = Math.min(byteBuffer.remaining(), this.pesLeft);
                    this.pesBuffer.put(NIOUtils.read(byteBuffer, iMin));
                    int i = this.pesLeft - iMin;
                    this.pesLeft = i;
                    if (i == 0) {
                        ByteBuffer byteBuffer2 = this.pesBuffer;
                        long j2 = this.pesFileStart;
                        pes1(byteBuffer2, j2, (int) (((j + byteBuffer.position()) - iPosition) - j2), this.stream);
                        this.pesFileStart = -1L;
                        this._pes = false;
                        this.stream = -1;
                    }
                } else {
                    int i2 = byteBuffer.get() & ExifInterface.MARKER;
                    if (this._pes) {
                        this.pesBuffer.put((byte) (this.marker >>> 24));
                    }
                    int i3 = (this.marker << 8) | i2;
                    this.marker = i3;
                    if (i3 >= 443 && i3 <= 495) {
                        long jPosition = ((j + byteBuffer.position()) - iPosition) - 4;
                        if (this._pes) {
                            ByteBuffer byteBuffer3 = this.pesBuffer;
                            long j3 = this.pesFileStart;
                            pes1(byteBuffer3, j3, (int) (jPosition - j3), this.stream);
                        }
                        this.pesFileStart = jPosition;
                        this._pes = true;
                        this.stream = this.marker & 255;
                        this.lenFieldLeft = 2;
                        this.pesLen = 0;
                    } else if (i3 < 441 || i3 > 511) {
                        int i4 = this.lenFieldLeft;
                        if (i4 > 0) {
                            int i5 = i2 | (this.pesLen << 8);
                            this.pesLen = i5;
                            int i6 = i4 - 1;
                            this.lenFieldLeft = i6;
                            if (i6 == 0) {
                                this.pesLeft = i5;
                                if (i5 != 0) {
                                    flushMarker();
                                    this.marker = -1;
                                }
                            }
                        }
                    } else {
                        if (this._pes) {
                            ByteBuffer byteBuffer4 = this.pesBuffer;
                            long j4 = this.pesFileStart;
                            pes1(byteBuffer4, j4, (int) ((((j + byteBuffer.position()) - iPosition) - 4) - j4), this.stream);
                        }
                        this.pesFileStart = -1L;
                        this._pes = false;
                        this.stream = -1;
                    }
                }
            }
        }

        public void finishRead() {
            if (this.pesLeft <= 4) {
                flushMarker();
                ByteBuffer byteBuffer = this.pesBuffer;
                pes1(byteBuffer, this.pesFileStart, byteBuffer.position(), this.stream);
            }
        }

        public abstract void pes(ByteBuffer byteBuffer, long j, int i, int i2);
    }

    public static class RegistrationDescriptor extends MPEGMediaDescriptor {
        private IntArrayList additionalFormatIdentifiers = IntArrayList.createIntArrayList();
        private int formatIdentifier;

        public IntArrayList getAdditionalFormatIdentifiers() {
            return this.additionalFormatIdentifiers;
        }

        public int getFormatIdentifier() {
            return this.formatIdentifier;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.formatIdentifier = byteBuffer.getInt();
            while (byteBuffer.hasRemaining()) {
                this.additionalFormatIdentifiers.add(byteBuffer.get() & ExifInterface.MARKER);
            }
        }
    }

    public static class VideoStreamDescriptor extends MPEGMediaDescriptor {
        private int chromaFormat;
        private int constrainedParameter;
        private int frameRateCode;
        private int frameRateExtension;
        public Rational[] frameRates = {null, new Rational(24000, 1001), new Rational(24, 1), new Rational(25, 1), new Rational(30000, 1001), new Rational(30, 1), new Rational(50, 1), new Rational(OkHttpUtils.DEFAULT_MILLISECONDS, 1001), new Rational(60, 1), null, null, null, null, null, null, null};
        private boolean mpeg1Only;
        private int multipleFrameRate;
        private int profileAndLevel;
        private int stillPicture;

        public int getChromaFormat() {
            return this.chromaFormat;
        }

        public int getConstrainedParameter() {
            return this.constrainedParameter;
        }

        public Rational getFrameRate() {
            return this.frameRates[this.frameRateCode];
        }

        public int getFrameRateCode() {
            return this.frameRateCode;
        }

        public int getFrameRateExtension() {
            return this.frameRateExtension;
        }

        public int getMultipleFrameRate() {
            return this.multipleFrameRate;
        }

        public int getProfileAndLevel() {
            return this.profileAndLevel;
        }

        public int getStillPicture() {
            return this.stillPicture;
        }

        public boolean isMpeg1Only() {
            return this.mpeg1Only;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            int i = byteBuffer.get() & ExifInterface.MARKER;
            this.multipleFrameRate = (i >> 7) & 1;
            this.frameRateCode = (i >> 3) & 15;
            boolean z = ((i >> 2) & 1) == 0;
            this.mpeg1Only = z;
            this.constrainedParameter = (i >> 1) & 1;
            this.stillPicture = i & 1;
            if (z) {
                return;
            }
            this.profileAndLevel = byteBuffer.get() & ExifInterface.MARKER;
            int i2 = byteBuffer.get() & ExifInterface.MARKER;
            this.chromaFormat = i2 >> 6;
            this.frameRateExtension = (i2 >> 5) & 1;
        }
    }

    public static int $(int i) {
        return i & 255;
    }

    static {
        Class<? extends MPEGMediaDescriptor>[] clsArr = new Class[256];
        dMapping = clsArr;
        clsArr[2] = VideoStreamDescriptor.class;
        clsArr[3] = AudioStreamDescriptor.class;
        clsArr[6] = DataStreamAlignmentDescriptor.class;
        clsArr[5] = RegistrationDescriptor.class;
        clsArr[10] = ISO639LanguageDescriptor.class;
        clsArr[27] = Mpeg4VideoDescriptor.class;
        clsArr[28] = Mpeg4AudioDescriptor.class;
        clsArr[40] = AVCVideoDescriptor.class;
        clsArr[43] = AACAudioDescriptor.class;
    }

    public static long _readTs(ByteBuffer byteBuffer, int i) {
        return ((byteBuffer.get() & ExifInterface.MARKER) >> 1) | ((i & 14) << 29) | ((byteBuffer.get() & ExifInterface.MARKER) << 22) | (((byteBuffer.get() & ExifInterface.MARKER) >> 1) << 15) | ((byteBuffer.get() & ExifInterface.MARKER) << 7);
    }

    public static boolean audioStream(int i) {
        return (i >= $(AUDIO_MIN) && i <= $(AUDIO_MAX)) || i == $(PRIVATE_1) || i == $(PRIVATE_2);
    }

    public static final boolean mediaMarker(int i) {
        return (i >= 448 && i <= 495) || i == 445 || i == 447;
    }

    public static final boolean mediaStream(int i) {
        return (i >= $(AUDIO_MIN) && i <= $(VIDEO_MAX)) || i == $(PRIVATE_1) || i == $(PRIVATE_2);
    }

    public static PESPacket mpeg1Pes(int i, int i2, int i3, ByteBuffer byteBuffer, long j) {
        long j_readTs;
        long ts;
        int i4 = i;
        while (i4 == 255) {
            i4 = byteBuffer.get() & ExifInterface.MARKER;
        }
        if ((i4 & 192) == 64) {
            byteBuffer.get();
            i4 = byteBuffer.get() & ExifInterface.MARKER;
        }
        int i5 = i4 & 240;
        if (i5 == 32) {
            j_readTs = _readTs(byteBuffer, i4);
            ts = -1;
        } else if (i5 == 48) {
            long j_readTs2 = _readTs(byteBuffer, i4);
            ts = readTs(byteBuffer);
            j_readTs = j_readTs2;
        } else {
            if (i4 != 15) {
                throw new RuntimeException("Invalid data");
            }
            j_readTs = -1;
            ts = -1;
        }
        return new PESPacket(null, j_readTs, i3, i2, j, ts);
    }

    public static PESPacket mpeg2Pes(int i, int i2, int i3, ByteBuffer byteBuffer, long j) {
        long j2;
        long j3;
        int i4 = byteBuffer.get() & ExifInterface.MARKER;
        int i5 = byteBuffer.get() & ExifInterface.MARKER;
        int i6 = i4 & 192;
        if (i6 == 128) {
            long ts = readTs(byteBuffer);
            NIOUtils.skip(byteBuffer, i5 - 5);
            j3 = -1;
            j2 = ts;
        } else if (i6 == 192) {
            long ts2 = readTs(byteBuffer);
            long ts3 = readTs(byteBuffer);
            NIOUtils.skip(byteBuffer, i5 - 10);
            j2 = ts2;
            j3 = ts3;
        } else {
            NIOUtils.skip(byteBuffer, i5);
            j2 = -1;
            j3 = -1;
        }
        return new PESPacket(null, j2, i3, i2, j, j3);
    }

    public static List<MPEGMediaDescriptor> parseDescriptors(ByteBuffer byteBuffer) throws IllegalAccessException, InstantiationException {
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.remaining() >= 2) {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            int i = byteBufferDuplicate.get() & ExifInterface.MARKER;
            ByteBuffer byteBuffer2 = NIOUtils.read(byteBuffer, (byteBufferDuplicate.get() & ExifInterface.MARKER) + 2);
            Class<? extends MPEGMediaDescriptor> cls = dMapping[i];
            if (cls != null) {
                try {
                    MPEGMediaDescriptor mPEGMediaDescriptorNewInstance = cls.newInstance();
                    mPEGMediaDescriptorNewInstance.parse(byteBuffer2);
                    arrayList.add(mPEGMediaDescriptorNewInstance);
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return arrayList;
    }

    public static final boolean psMarker(int i) {
        return i >= 445 && i <= 495;
    }

    public static PESPacket readPESHeader(ByteBuffer byteBuffer, long j) {
        int i = byteBuffer.getInt() & 255;
        int i2 = byteBuffer.getShort() & 65535;
        if (i == 191) {
            return new PESPacket(null, -1L, i, i2, j, -1L);
        }
        int i3 = byteBuffer.get() & ExifInterface.MARKER;
        return (i3 & 192) == 128 ? mpeg2Pes(i3, i2, i, byteBuffer, j) : mpeg1Pes(i3, i2, i, byteBuffer, j);
    }

    public static long readTs(ByteBuffer byteBuffer) {
        return ((byteBuffer.get() & 14) << 29) | ((byteBuffer.get() & ExifInterface.MARKER) << 22) | (((byteBuffer.get() & ExifInterface.MARKER) >> 1) << 15) | ((byteBuffer.get() & ExifInterface.MARKER) << 7) | ((byteBuffer.get() & ExifInterface.MARKER) >> 1);
    }

    public static boolean videoMarker(int i) {
        return i >= 480 && i <= 495;
    }

    public static final boolean videoStream(int i) {
        return i >= $(VIDEO_MIN) && i <= $(VIDEO_MAX);
    }

    public static void writeTs(ByteBuffer byteBuffer, long j) {
        byteBuffer.put((byte) ((j >> 29) << 1));
        byteBuffer.put((byte) (j >> 22));
        byteBuffer.put((byte) ((j >> 15) << 1));
        byteBuffer.put((byte) (j >> 7));
        byteBuffer.put((byte) (j >> 1));
    }
}
