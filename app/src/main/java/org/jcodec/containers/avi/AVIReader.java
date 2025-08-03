package org.jcodec.containers.avi;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.api.FormatException;
import org.jcodec.common.io.DataReader;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class AVIReader {
    public static final int AUDIO_FORMAT_AC3 = 8192;
    public static final int AUDIO_FORMAT_DTS = 8193;
    public static final int AUDIO_FORMAT_EXTENSIBLE = 65534;
    public static final int AUDIO_FORMAT_MP3 = 85;
    public static final int AUDIO_FORMAT_PCM = 1;
    public static final int AUDIO_FORMAT_VORBIS = 22127;
    public static final int AVIF_COPYRIGHTED = 131072;
    public static final int AVIF_HASINDEX = 16;
    public static final int AVIF_ISINTERLEAVED = 256;
    public static final int AVIF_MUSTUSEINDEX = 32;
    public static final int AVIF_TRUSTCKTYPE = 2048;
    public static final int AVIF_WASCAPTUREFILE = 65536;
    public static final int AVIIF_FIRSTPART = 32;
    public static final int AVIIF_KEYFRAME = 16;
    public static final int AVIIF_LASTPART = 64;
    public static final int AVIIF_LIST = 1;
    public static final int AVIIF_NOTIME = 256;
    public static final int FOURCC_AUDS = 1935963489;
    public static final int FOURCC_AVI = 541677121;
    public static final int FOURCC_AVIH = 1751742049;
    public static final int FOURCC_AVIX = 1481201217;
    public static final int FOURCC_HDRL = 1819436136;
    public static final int FOURCC_IDXL = 829973609;
    public static final int FOURCC_INDX = 2019847785;
    public static final int FOURCC_JUNK = 1263424842;
    public static final int FOURCC_LIST = 1414744396;
    public static final int FOURCC_MIDS = 1935960429;
    public static final int FOURCC_MOVI = 1769369453;
    public static final int FOURCC_ODML = 1819108463;
    public static final int FOURCC_REC = 543384946;
    public static final int FOURCC_RIFF = 1179011410;
    public static final int FOURCC_SEGM = 1835492723;
    public static final int FOURCC_STRF = 1718776947;
    public static final int FOURCC_STRH = 1752331379;
    public static final int FOURCC_STRL = 1819440243;
    public static final int FOURCC_TXTS = 1937012852;
    public static final int FOURCC_VIDS = 1935960438;
    public static final int FOURCC_strd = 1685222515;
    public static final int FOURCC_strn = 1852994675;
    private static final long SIZE_MASK = 4294967295L;
    public static final int STDINDEXSIZE = 16384;
    private AVITag_AVIH aviHeader;
    private AVITag_AviDmlSuperIndex[] openDmlSuperIndex;
    private DataReader raf;
    private AVIChunk[] streamFormats;
    private AVITag_STRH[] streamHeaders;
    public final int AVI_INDEX_OF_INDEXES = 0;
    public final int AVI_INDEX_OF_CHUNKS = 1;
    public final int AVI_INDEX_OF_TIMED_CHUNKS = 2;
    public final int AVI_INDEX_OF_SUB_2FIELD = 3;
    public final int AVI_INDEX_IS_DATA = 128;
    private long fileLeft = 0;
    private PrintStream ps = null;
    private boolean skipFrames = true;
    private List<AVITag_AviIndex> aviIndexes = new ArrayList();

    public static class AVIChunk {
        public int dwChunkSize;
        public int dwFourCC;
        public String fwFourCCStr;
        public long startOfChunk;

        public int getChunkSize() {
            int i = this.dwChunkSize;
            return (i & 1) == 1 ? i + 1 : i;
        }

        public long getEndOfChunk() {
            return this.startOfChunk + 8 + getChunkSize();
        }

        public long getStartOfChunk() {
            return this.startOfChunk;
        }

        public void read(int i, DataReader dataReader) throws IOException {
            this.startOfChunk = dataReader.position() - 4;
            this.dwFourCC = i;
            this.fwFourCCStr = AVIReader.toFourCC(i);
            this.dwChunkSize = dataReader.readInt();
        }

        public void skip(DataReader dataReader) throws IOException {
            int chunkSize = getChunkSize();
            if (chunkSize >= 0) {
                dataReader.skipBytes(chunkSize);
                return;
            }
            throw new IOException("Negative chunk size for chunk [" + AVIReader.toFourCC(this.dwFourCC) + "]");
        }

        public String toString() {
            String fourCC = AVIReader.toFourCC(this.dwFourCC);
            if (fourCC.trim().length() == 0) {
                fourCC = Integer.toHexString(this.dwFourCC);
            }
            return "\tCHUNK [" + fourCC + "], Size [" + this.dwChunkSize + "], StartOfChunk [" + getStartOfChunk() + "]";
        }
    }

    public static class AVIList extends AVIChunk {
        public int dwListTypeFourCC;
        public String dwListTypeFourCCStr;

        public int getListType() {
            return this.dwListTypeFourCC;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            this.dwChunkSize -= 4;
            int i2 = dataReader.readInt();
            this.dwListTypeFourCC = i2;
            this.dwListTypeFourCCStr = AVIReader.toFourCC(i2);
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            return AVIReader.toFourCC(this.dwFourCC) + " [" + this.dwListTypeFourCCStr + "], Size [" + this.dwChunkSize + "], StartOfChunk [" + getStartOfChunk() + "]";
        }
    }

    public static class AVITag_AVIH extends AVIChunk {
        private int dwFlags;
        private int dwHeight;
        private int dwInitialFrames;
        private int dwMaxBytesPerSec;
        private int dwMicroSecPerFrame;
        private int dwPaddingGranularity;
        private int[] dwReserved = new int[4];
        private int dwStreams;
        private int dwSuggestedBufferSize;
        private int dwTotalFrames;
        private int dwWidth;

        public int getStreams() {
            return this.dwStreams;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            if (i != 1751742049) {
                throw new IOException("Unexpected AVI header : " + AVIReader.toFourCC(i));
            }
            if (getChunkSize() != 56) {
                throw new IOException("Expected dwSize=56");
            }
            this.dwMicroSecPerFrame = dataReader.readInt();
            this.dwMaxBytesPerSec = dataReader.readInt();
            this.dwPaddingGranularity = dataReader.readInt();
            this.dwFlags = dataReader.readInt();
            this.dwTotalFrames = dataReader.readInt();
            this.dwInitialFrames = dataReader.readInt();
            this.dwStreams = dataReader.readInt();
            this.dwSuggestedBufferSize = dataReader.readInt();
            this.dwWidth = dataReader.readInt();
            this.dwHeight = dataReader.readInt();
            this.dwReserved[0] = dataReader.readInt();
            this.dwReserved[1] = dataReader.readInt();
            this.dwReserved[2] = dataReader.readInt();
            this.dwReserved[3] = dataReader.readInt();
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if ((this.dwFlags & 16) != 0) {
                sb.append("HASINDEX ");
            }
            if ((this.dwFlags & 32) != 0) {
                sb.append("MUSTUSEINDEX ");
            }
            if ((this.dwFlags & 256) != 0) {
                sb.append("ISINTERLEAVED ");
            }
            if ((this.dwFlags & 65536) != 0) {
                sb.append("AVIF_WASCAPTUREFILE ");
            }
            if ((this.dwFlags & 131072) != 0) {
                sb.append("AVIF_COPYRIGHTED ");
            }
            return "AVIH Resolution [" + this.dwWidth + "x" + this.dwHeight + "], NumFrames [" + this.dwTotalFrames + "], Flags [" + Integer.toHexString(this.dwFlags) + "] - [" + sb.toString().trim() + "]";
        }
    }

    public static class AVITag_AudioChunk extends AVIChunk {
        private DataReader raf;
        public int streamNo;

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public int getChunkSize() {
            int i = this.dwChunkSize;
            return (i & 1) == 1 ? i + 1 : i;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            this.raf = dataReader;
            super.read(i, dataReader);
            this.streamNo = Integer.parseInt(AVIReader.toFourCC(i).substring(0, 2));
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            return "\tAUDIO CHUNK - Stream " + this.streamNo + ", StartOfChunk=" + getStartOfChunk() + ", ChunkSize=" + getChunkSize();
        }
    }

    public static class AVITag_AviDmlStandardIndex extends AVIChunk {
        public byte bIndexSubType;
        public byte bIndexType;
        public int dwChunkId;
        public int[] dwDuration;
        public int[] dwOffset;
        public int dwReserved2;
        public int nEntriesInUse;
        public long qwBaseOffset;
        public short wLongsPerEntry;
        public int lastOffset = -1;
        public int lastDuration = -1;

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public int getChunkSize() {
            return this.dwChunkSize;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            this.wLongsPerEntry = dataReader.readShort();
            this.bIndexSubType = dataReader.readByte();
            this.bIndexType = dataReader.readByte();
            this.nEntriesInUse = dataReader.readInt();
            this.dwChunkId = dataReader.readInt();
            this.qwBaseOffset = dataReader.readLong();
            this.dwReserved2 = dataReader.readInt();
            int i2 = this.nEntriesInUse;
            this.dwOffset = new int[i2];
            this.dwDuration = new int[i2];
            for (int i3 = 0; i3 < this.nEntriesInUse; i3++) {
                try {
                    this.dwOffset[i3] = dataReader.readInt();
                    this.dwDuration[i3] = dataReader.readInt();
                    this.lastOffset = this.dwOffset[i3];
                    this.lastDuration = this.dwDuration[i3];
                } catch (Exception unused) {
                    Logger.debug("Failed to read : " + toString());
                }
            }
            dataReader.setPosition(getEndOfChunk());
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            return String.format("\tAvi DML Standard Index List Type=%d, SubType=%d, ChunkId=%s, StartOfChunk=%d, NumIndexes=%d, LongsPerEntry=%d, ChunkSize=%d, FirstOffset=%d, FirstDuration=%d,LastOffset=%d, LastDuration=%d", Byte.valueOf(this.bIndexType), Byte.valueOf(this.bIndexSubType), AVIReader.toFourCC(this.dwChunkId), Long.valueOf(getStartOfChunk()), Integer.valueOf(this.nEntriesInUse), Short.valueOf(this.wLongsPerEntry), Integer.valueOf(getChunkSize()), Integer.valueOf(this.dwOffset[0]), Integer.valueOf(this.dwDuration[0]), Integer.valueOf(this.lastOffset), Integer.valueOf(this.lastDuration));
        }
    }

    public static class AVITag_AviDmlSuperIndex extends AVIChunk {
        public byte bIndexSubType;
        public byte bIndexType;
        public int dwChunkId;
        public int[] dwDuration;
        public int[] dwSize;
        public int nEntriesInUse;
        public long[] qwOffset;
        public short wLongsPerEntry;
        private int streamNo = 0;
        public int[] dwReserved = new int[3];
        public StringBuilder sb = new StringBuilder();

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            this.wLongsPerEntry = dataReader.readShort();
            this.bIndexSubType = dataReader.readByte();
            this.bIndexType = dataReader.readByte();
            this.nEntriesInUse = dataReader.readInt();
            this.dwChunkId = dataReader.readInt();
            this.dwReserved[0] = dataReader.readInt();
            this.dwReserved[1] = dataReader.readInt();
            this.dwReserved[2] = dataReader.readInt();
            int i2 = this.nEntriesInUse;
            this.qwOffset = new long[i2];
            this.dwSize = new int[i2];
            this.dwDuration = new int[i2];
            String fourCC = AVIReader.toFourCC(this.dwChunkId);
            this.sb.append(String.format("\tAvi DML Super Index List - ChunkSize=%d, NumIndexes = %d, longsPerEntry = %d, Stream = %s, Type = %s", Integer.valueOf(getChunkSize()), Integer.valueOf(this.nEntriesInUse), Short.valueOf(this.wLongsPerEntry), fourCC.substring(0, 2), fourCC.substring(2)));
            for (int i3 = 0; i3 < this.nEntriesInUse; i3++) {
                this.qwOffset[i3] = dataReader.readLong();
                this.dwSize[i3] = dataReader.readInt();
                this.dwDuration[i3] = dataReader.readInt();
                this.sb.append(String.format("\n\t\tStandard Index - Offset [%d], Size [%d], Duration [%d]", Long.valueOf(this.qwOffset[i3]), Integer.valueOf(this.dwSize[i3]), Integer.valueOf(this.dwDuration[i3])));
            }
            dataReader.setPosition(getEndOfChunk());
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            return this.sb.toString();
        }
    }

    public static class AVITag_AviIndex extends AVIChunk {
        public int[] ckid;
        public int[] dwChunkLength;
        public int[] dwChunkOffset;
        public int[] dwFlags;
        public int numIndexes = 0;

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            int chunkSize = getChunkSize() >> 4;
            this.numIndexes = chunkSize;
            this.ckid = new int[chunkSize];
            this.dwFlags = new int[chunkSize];
            this.dwChunkOffset = new int[chunkSize];
            this.dwChunkLength = new int[chunkSize];
            for (int i2 = 0; i2 < this.numIndexes; i2++) {
                this.ckid[i2] = dataReader.readInt();
                this.dwFlags[i2] = dataReader.readInt();
                this.dwChunkOffset[i2] = dataReader.readInt();
                this.dwChunkLength[i2] = dataReader.readInt();
            }
            dataReader.setPosition(getEndOfChunk());
            int chunkSize2 = getChunkSize() - this.dwChunkSize;
            if (chunkSize2 > 0) {
                dataReader.skipBytes(chunkSize2);
            }
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            return String.format("\tAvi Index List, StartOfChunk [%d], ChunkSize [%d], NumIndexes [%d]", Long.valueOf(getStartOfChunk()), Integer.valueOf(this.dwChunkSize), Integer.valueOf(getChunkSize() >> 4));
        }
    }

    public static class AVITag_BitmapInfoHeader extends AVIChunk {
        private byte b;
        private short biBitCount;
        private int biClrImportant;
        private int biClrUsed;
        private int biCompression;
        private int biHeight;
        private short biPlanes;
        private int biSize;
        private int biSizeImage;
        private int biWidth;
        private int biXPelsPerMeter;
        private int biYPelsPerMeter;
        private byte g;
        private byte r;
        private byte x;

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public int getChunkSize() {
            return this.biSize;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            this.biSize = dataReader.readInt();
            this.biWidth = dataReader.readInt();
            this.biHeight = dataReader.readInt();
            this.biPlanes = dataReader.readShort();
            this.biBitCount = dataReader.readShort();
            this.biCompression = dataReader.readInt();
            this.biSizeImage = dataReader.readInt();
            this.biXPelsPerMeter = dataReader.readInt();
            this.biYPelsPerMeter = dataReader.readInt();
            this.biClrUsed = dataReader.readInt();
            this.biClrImportant = dataReader.readInt();
            if (getChunkSize() == 56) {
                this.r = dataReader.readByte();
                this.g = dataReader.readByte();
                this.b = dataReader.readByte();
                this.x = dataReader.readByte();
            }
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            return "\tCHUNK [" + AVIReader.toFourCC(this.dwFourCC) + "], BitsPerPixel [" + ((int) this.biBitCount) + "], Resolution [" + (this.biWidth & AVIReader.SIZE_MASK) + " x " + (this.biHeight & AVIReader.SIZE_MASK) + "], Planes [" + ((int) this.biPlanes) + "]";
        }
    }

    public static class AVITag_STRH extends AVIChunk {
        private int fccCodecHandler;
        private int fccType;
        private int dwFlags = 0;
        private short wPriority = 0;
        private short wLanguage = 0;
        private int dwInitialFrames = 0;
        private int dwScale = 0;
        private int dwRate = 1000000;
        private int dwStart = 0;
        private int dwLength = 0;
        private int dwSuggestedBufferSize = 0;
        private int dwQuality = -1;
        private int dwSampleSize = 0;
        private short left = 0;
        private short top = 0;
        private short right = 0;
        private short bottom = 0;

        public int getType() {
            return this.fccType;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            if (i != 1752331379) {
                throw new IOException("Expected 'strh' fourcc got [" + AVIReader.toFourCC(this.dwFourCC) + "]");
            }
            this.fccType = dataReader.readInt();
            this.fccCodecHandler = dataReader.readInt();
            this.dwFlags = dataReader.readInt();
            this.wPriority = dataReader.readShort();
            this.wLanguage = dataReader.readShort();
            this.dwInitialFrames = dataReader.readInt();
            this.dwScale = dataReader.readInt();
            this.dwRate = dataReader.readInt();
            this.dwStart = dataReader.readInt();
            this.dwLength = dataReader.readInt();
            this.dwSuggestedBufferSize = dataReader.readInt();
            this.dwQuality = dataReader.readInt();
            this.dwSampleSize = dataReader.readInt();
            this.left = dataReader.readShort();
            this.top = dataReader.readShort();
            this.right = dataReader.readShort();
            this.bottom = dataReader.readShort();
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\tCHUNK [");
            sb.append(AVIReader.toFourCC(this.dwFourCC));
            sb.append("], Type[");
            int i = this.fccType;
            sb.append(i > 0 ? AVIReader.toFourCC(i) : "    ");
            sb.append("], Handler [");
            int i2 = this.fccCodecHandler;
            sb.append(i2 > 0 ? AVIReader.toFourCC(i2) : "    ");
            sb.append("]");
            return sb.toString();
        }
    }

    public static class AVITag_VideoChunk extends AVIChunk {
        public boolean compressed;
        public int frameNo = -1;
        private DataReader raf;
        public int streamNo;

        public AVITag_VideoChunk(boolean z, DataReader dataReader) {
            this.compressed = z;
            this.raf = dataReader;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public int getChunkSize() {
            int i = this.dwChunkSize;
            return (i & 1) == 1 ? i + 1 : i;
        }

        public byte[] getVideoPacket() throws IOException {
            byte[] bArr = new byte[this.dwChunkSize];
            int fully = this.raf.readFully(bArr);
            if (fully == this.dwChunkSize) {
                int chunkSize = getChunkSize() - this.dwChunkSize;
                if (chunkSize > 0) {
                    this.raf.skipBytes(chunkSize);
                }
                return bArr;
            }
            throw new IOException("Read mismatch expected chunksize [" + this.dwChunkSize + "], Actual read [" + fully + "]");
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            this.streamNo = Integer.parseInt(AVIReader.toFourCC(i).substring(0, 2));
        }

        public void setFrameNo(int i) {
            this.frameNo = i;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\tVIDEO CHUNK - Stream ");
            sb.append(this.streamNo);
            sb.append(",  chunkStart=");
            sb.append(getStartOfChunk());
            sb.append(", ");
            sb.append(this.compressed ? "compressed" : "uncompressed");
            sb.append(", ChunkSize=");
            sb.append(getChunkSize());
            sb.append(", FrameNo=");
            sb.append(this.frameNo);
            return sb.toString();
        }
    }

    public static class AVITag_WaveFormatEx extends AVIChunk {
        public short cbSize;
        public int channelMask;
        public short channels;
        public int fdwFlags;
        public int guid_data1;
        public short guid_data2;
        public short guid_data3;
        public int nAvgBytesPerSec;
        public short nBlockAlign;
        public short nBlockSize;
        public short nCodecDelay;
        public short nFramesPerBlock;
        public int nSamplesPerSec;
        public short samplesValidBitsPerSample;
        public short wBitsPerSample;
        public short wFormatTag;
        public short wID;
        public short wReserved;
        public short wValidBitsPerSample;
        public boolean mp3Flag = false;
        private String audioFormat = "?";
        public byte[] guid_data4 = new byte[8];

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
            this.wFormatTag = dataReader.readShort();
            this.channels = dataReader.readShort();
            this.nSamplesPerSec = dataReader.readInt();
            this.nAvgBytesPerSec = dataReader.readInt();
            this.nBlockAlign = dataReader.readShort();
            short s = this.wFormatTag;
            if (s == 1) {
                this.wBitsPerSample = dataReader.readShort();
                if (this.dwChunkSize == 40) {
                    short s2 = dataReader.readShort();
                    this.wReserved = s2;
                    this.samplesValidBitsPerSample = s2;
                    this.wValidBitsPerSample = s2;
                    this.cbSize = dataReader.readShort();
                    this.channelMask = dataReader.readInt();
                    this.guid_data1 = dataReader.readInt();
                    this.guid_data2 = dataReader.readShort();
                    this.guid_data3 = dataReader.readShort();
                    dataReader.readFully(this.guid_data4);
                }
                this.audioFormat = "PCM";
                return;
            }
            if (s == 85) {
                this.wBitsPerSample = dataReader.readShort();
                this.cbSize = dataReader.readShort();
                this.wID = dataReader.readShort();
                this.fdwFlags = dataReader.readInt();
                this.nBlockSize = dataReader.readShort();
                this.nFramesPerBlock = dataReader.readShort();
                this.nCodecDelay = dataReader.readShort();
                this.mp3Flag = true;
                this.audioFormat = "MP3";
                return;
            }
            if (s == 22127) {
                this.audioFormat = "VORBIS";
                return;
            }
            if (s != 65534) {
                if (s == 8192) {
                    this.audioFormat = "AC3";
                    return;
                }
                if (s == 8193) {
                    this.audioFormat = "DTS";
                    return;
                }
                this.audioFormat = "Unknown : " + Integer.toHexString(this.wFormatTag);
                return;
            }
            this.wBitsPerSample = dataReader.readShort();
            this.cbSize = dataReader.readShort();
            short s3 = dataReader.readShort();
            this.wReserved = s3;
            this.samplesValidBitsPerSample = s3;
            this.wValidBitsPerSample = s3;
            this.channelMask = dataReader.readInt();
            this.guid_data1 = dataReader.readInt();
            this.guid_data2 = dataReader.readShort();
            this.guid_data3 = dataReader.readShort();
            dataReader.readFully(this.guid_data4);
            this.audioFormat = "EXTENSIBLE";
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            return String.format("\tCHUNK [%s], ChunkSize [%d], Format [%s], Channels [%d], Channel Mask [%s], MP3 [%b], SamplesPerSec [%d], nBlockAlign [%d]", AVIReader.toFourCC(this.dwFourCC), Integer.valueOf(getChunkSize()), this.audioFormat, Short.valueOf(this.channels), Integer.toHexString(this.channelMask), Boolean.valueOf(this.mp3Flag), Integer.valueOf(this.nSamplesPerSec), Long.valueOf(getStartOfChunk()), Short.valueOf(this.nBlockAlign));
        }
    }

    public static class AVI_SEGM extends AVIChunk {
        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public int getChunkSize() {
            int i = this.dwChunkSize;
            if (i == 0) {
                return 0;
            }
            return i + 1;
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public void read(int i, DataReader dataReader) throws IOException {
            super.read(i, dataReader);
        }

        @Override // org.jcodec.containers.avi.AVIReader.AVIChunk
        public String toString() {
            return "SEGMENT Align, Size [" + this.dwChunkSize + "], StartOfChunk [" + getStartOfChunk() + "]";
        }
    }

    public AVIReader(SeekableByteChannel seekableByteChannel) {
        this.raf = null;
        this.raf = DataReader.createDataReader(seekableByteChannel, ByteOrder.LITTLE_ENDIAN);
    }

    public static int fromFourCC(String str) {
        byte[] bytes = str.getBytes();
        if (bytes.length == 4) {
            return bytes[0] | (((((bytes[3] << 8) | bytes[2]) << 8) | bytes[1]) << 8);
        }
        throw new IllegalArgumentException("Expected 4 bytes not " + bytes.length);
    }

    public static String toFourCC(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 4; i2++) {
            sb.append(Character.toString((char) (i & 255)));
            i >>= 8;
        }
        return sb.toString();
    }

    public List<AVITag_AviIndex> getAviIndexes() {
        return this.aviIndexes;
    }

    public long getFileLeft() throws IOException {
        return this.fileLeft;
    }

    public void parse() throws IOException {
        AVIChunk aVITag_BitmapInfoHeader;
        AVIChunk aVIChunk;
        long jPosition;
        AVIChunk aVIChunk2;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long size = this.raf.size();
            this.fileLeft = size;
            int i = -1;
            int i2 = this.raf.readInt();
            if (i2 != 1179011410) {
                throw new FormatException("No RIFF header found");
            }
            AVIList aVIList = new AVIList();
            aVIList.read(i2, this.raf);
            Logger.debug(aVIList.toString());
            int i3 = 1;
            int type = 0;
            int i4 = 0;
            do {
                int i5 = this.raf.readInt();
                String fourCC = toFourCC(i5);
                switch (i5) {
                    case FOURCC_IDXL /* 829973609 */:
                        AVITag_AviIndex aVITag_AviIndex = new AVITag_AviIndex();
                        aVITag_AviIndex.read(i5, this.raf);
                        this.aviIndexes.add(aVITag_AviIndex);
                        aVIChunk2 = aVITag_AviIndex;
                        aVIChunk = aVIChunk2;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    case 1179011410:
                        AVIChunk aVIList2 = new AVIList();
                        aVIList2.read(i5, this.raf);
                        aVIChunk2 = aVIList2;
                        aVIChunk = aVIChunk2;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    case FOURCC_LIST /* 1414744396 */:
                        AVIList aVIList3 = new AVIList();
                        aVIList3.read(i5, this.raf);
                        int listType = aVIList3.getListType();
                        aVIChunk2 = aVIList3;
                        if (listType == 1769369453) {
                            aVIList3.skip(this.raf);
                            aVIChunk2 = aVIList3;
                        }
                        aVIChunk = aVIChunk2;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    case FOURCC_STRF /* 1718776947 */:
                        if (type == 1935960438) {
                            AVIChunk[] aVIChunkArr = this.streamFormats;
                            aVITag_BitmapInfoHeader = new AVITag_BitmapInfoHeader();
                            aVIChunkArr[i] = aVITag_BitmapInfoHeader;
                            aVITag_BitmapInfoHeader.read(i5, this.raf);
                        } else {
                            if (type != 1935963489) {
                                throw new IOException("Expected vids or auds got [" + toFourCC(type) + "]");
                            }
                            AVIChunk[] aVIChunkArr2 = this.streamFormats;
                            aVITag_BitmapInfoHeader = new AVITag_WaveFormatEx();
                            aVIChunkArr2[i] = aVITag_BitmapInfoHeader;
                            aVITag_BitmapInfoHeader.read(i5, this.raf);
                        }
                        aVIChunk = aVITag_BitmapInfoHeader;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    case FOURCC_AVIH /* 1751742049 */:
                        AVITag_AVIH aVITag_AVIH = new AVITag_AVIH();
                        this.aviHeader = aVITag_AVIH;
                        aVITag_AVIH.read(i5, this.raf);
                        int streams = this.aviHeader.getStreams();
                        this.streamHeaders = new AVITag_STRH[streams];
                        this.streamFormats = new AVIChunk[streams];
                        this.openDmlSuperIndex = new AVITag_AviDmlSuperIndex[streams];
                        aVIChunk = aVITag_AVIH;
                        i4 = streams;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    case FOURCC_STRH /* 1752331379 */:
                        if (i >= i4) {
                            throw new IllegalStateException("Read more stream headers than expected, expected [" + i4 + "]");
                        }
                        i++;
                        AVITag_STRH[] aVITag_STRHArr = this.streamHeaders;
                        AVITag_STRH aVITag_STRH = new AVITag_STRH();
                        aVITag_STRHArr[i] = aVITag_STRH;
                        aVITag_STRH.read(i5, this.raf);
                        type = aVITag_STRH.getType();
                        aVIChunk2 = aVITag_STRH;
                        aVIChunk = aVIChunk2;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    case FOURCC_STRL /* 1819440243 */:
                        AVIChunk aVIList4 = new AVIList();
                        aVIList4.read(i5, this.raf);
                        aVIChunk2 = aVIList4;
                        aVIChunk = aVIChunk2;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    case FOURCC_SEGM /* 1835492723 */:
                        AVIChunk avi_segm = new AVI_SEGM();
                        avi_segm.read(i5, this.raf);
                        avi_segm.skip(this.raf);
                        aVIChunk2 = avi_segm;
                        aVIChunk = aVIChunk2;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    case FOURCC_INDX /* 2019847785 */:
                        this.openDmlSuperIndex[i] = new AVITag_AviDmlSuperIndex();
                        this.openDmlSuperIndex[i].read(i5, this.raf);
                        aVIChunk = this.openDmlSuperIndex[i];
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                    default:
                        if (fourCC.endsWith("db")) {
                            AVITag_VideoChunk aVITag_VideoChunk = new AVITag_VideoChunk(false, this.raf);
                            aVITag_VideoChunk.read(i5, this.raf);
                            if (this.skipFrames) {
                                aVITag_VideoChunk.skip(this.raf);
                                aVIChunk2 = aVITag_VideoChunk;
                            } else {
                                ByteBuffer.wrap(aVITag_VideoChunk.getVideoPacket());
                                aVIChunk2 = aVITag_VideoChunk;
                            }
                        } else if (fourCC.endsWith("dc")) {
                            AVITag_VideoChunk aVITag_VideoChunk2 = new AVITag_VideoChunk(true, this.raf);
                            aVITag_VideoChunk2.read(i5, this.raf);
                            aVITag_VideoChunk2.setFrameNo(i3);
                            i3++;
                            Integer.parseInt(toFourCC(i5).substring(0, 2));
                            if (this.skipFrames) {
                                aVITag_VideoChunk2.skip(this.raf);
                                aVIChunk2 = aVITag_VideoChunk2;
                            } else {
                                ByteBuffer.wrap(aVITag_VideoChunk2.getVideoPacket());
                                aVIChunk2 = aVITag_VideoChunk2;
                            }
                        } else if (fourCC.endsWith("wb")) {
                            AVIChunk aVITag_AudioChunk = new AVITag_AudioChunk();
                            aVITag_AudioChunk.read(i5, this.raf);
                            aVITag_AudioChunk.skip(this.raf);
                            aVIChunk2 = aVITag_AudioChunk;
                        } else if (fourCC.endsWith("tx")) {
                            AVIChunk aVIChunk3 = new AVIChunk();
                            aVIChunk3.read(i5, this.raf);
                            aVIChunk3.skip(this.raf);
                            aVIChunk2 = aVIChunk3;
                        } else if (fourCC.startsWith("ix")) {
                            AVIChunk aVITag_AviDmlStandardIndex = new AVITag_AviDmlStandardIndex();
                            aVITag_AviDmlStandardIndex.read(i5, this.raf);
                            aVIChunk2 = aVITag_AviDmlStandardIndex;
                        } else {
                            AVIChunk aVIChunk4 = new AVIChunk();
                            aVIChunk4.read(i5, this.raf);
                            aVIChunk4.skip(this.raf);
                            aVIChunk2 = aVIChunk4;
                        }
                        aVIChunk = aVIChunk2;
                        Logger.debug(aVIChunk.toString());
                        jPosition = size - this.raf.position();
                        this.fileLeft = jPosition;
                        break;
                }
            } while (jPosition > 0);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Logger.debug("\tFile Left [" + this.fileLeft + "]");
            Logger.debug("\tParse time : " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms");
        } finally {
            PrintStream printStream = this.ps;
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}
