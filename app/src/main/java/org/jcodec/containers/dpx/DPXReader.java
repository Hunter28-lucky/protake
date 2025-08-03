package org.jcodec.containers.dpx;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.jcodec.common.StringUtils;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;

/* loaded from: classes2.dex */
public class DPXReader {
    public static final int FILM_OFFSET = 1664;
    public static final int IMAGEINFO_OFFSET = 768;
    public static final int IMAGESOURCE_OFFSET = 1408;
    private static final int READ_BUFFER_SIZE = 3072;
    public static final int SDPX = 1396985944;
    public static final int TVINFO_OFFSET = 1920;
    private boolean eof;
    private final int magic;
    private final ByteBuffer readBuf;

    public DPXReader(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(READ_BUFFER_SIZE);
        this.readBuf = byteBufferAllocate;
        initialRead(seekableByteChannel);
        int i = byteBufferAllocate.getInt();
        this.magic = i;
        if (i == 1396985944) {
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        } else {
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    private static Date date(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.US).parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    private void initialRead(ReadableByteChannel readableByteChannel) throws IOException {
        this.readBuf.clear();
        if (readableByteChannel.read(this.readBuf) == -1) {
            this.eof = true;
        }
        this.readBuf.flip();
    }

    public static DPXReader readFile(File file) throws IOException {
        FileChannelWrapper fileChannelWrapper = NIOUtils.readableChannel(file);
        try {
            return new DPXReader(fileChannelWrapper);
        } finally {
            IOUtils.closeQuietly(fileChannelWrapper);
        }
    }

    private static FileHeader readFileInfo(ByteBuffer byteBuffer) {
        FileHeader fileHeader = new FileHeader();
        fileHeader.imageOffset = byteBuffer.getInt();
        fileHeader.version = readNullTermString(byteBuffer, 8);
        fileHeader.filesize = byteBuffer.getInt();
        fileHeader.ditto = byteBuffer.getInt();
        fileHeader.genericHeaderLength = byteBuffer.getInt();
        fileHeader.industryHeaderLength = byteBuffer.getInt();
        fileHeader.userHeaderLength = byteBuffer.getInt();
        fileHeader.filename = readNullTermString(byteBuffer, 100);
        fileHeader.created = tryParseISO8601Date(readNullTermString(byteBuffer, 24));
        fileHeader.creator = readNullTermString(byteBuffer, 100);
        fileHeader.projectName = readNullTermString(byteBuffer, 200);
        fileHeader.copyright = readNullTermString(byteBuffer, 200);
        fileHeader.encKey = byteBuffer.getInt();
        return fileHeader;
    }

    private static FilmHeader readFilmInformationHeader(ByteBuffer byteBuffer) {
        FilmHeader filmHeader = new FilmHeader();
        filmHeader.idCode = readNullTermString(byteBuffer, 2);
        filmHeader.type = readNullTermString(byteBuffer, 2);
        filmHeader.offset = readNullTermString(byteBuffer, 2);
        filmHeader.prefix = readNullTermString(byteBuffer, 6);
        filmHeader.count = readNullTermString(byteBuffer, 4);
        filmHeader.format = readNullTermString(byteBuffer, 32);
        return filmHeader;
    }

    private static ImageHeader readImageInfoHeader(ByteBuffer byteBuffer) {
        ImageHeader imageHeader = new ImageHeader();
        imageHeader.orientation = byteBuffer.getShort();
        imageHeader.numberOfImageElements = byteBuffer.getShort();
        imageHeader.pixelsPerLine = byteBuffer.getInt();
        imageHeader.linesPerImageElement = byteBuffer.getInt();
        ImageElement imageElement = new ImageElement();
        imageHeader.imageElement1 = imageElement;
        imageElement.dataSign = byteBuffer.getInt();
        return imageHeader;
    }

    private static ImageSourceHeader readImageSourceHeader(ByteBuffer byteBuffer) {
        ImageSourceHeader imageSourceHeader = new ImageSourceHeader();
        imageSourceHeader.xOffset = byteBuffer.getInt();
        imageSourceHeader.yOffset = byteBuffer.getInt();
        imageSourceHeader.xCenter = byteBuffer.getFloat();
        imageSourceHeader.yCenter = byteBuffer.getFloat();
        imageSourceHeader.xOriginal = byteBuffer.getInt();
        imageSourceHeader.yOriginal = byteBuffer.getInt();
        imageSourceHeader.sourceImageFilename = readNullTermString(byteBuffer, 100);
        imageSourceHeader.sourceImageDate = tryParseISO8601Date(readNullTermString(byteBuffer, 24));
        imageSourceHeader.deviceName = readNullTermString(byteBuffer, 32);
        imageSourceHeader.deviceSerial = readNullTermString(byteBuffer, 32);
        imageSourceHeader.borderValidity = new short[]{byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort()};
        imageSourceHeader.aspectRatio = new int[]{byteBuffer.getInt(), byteBuffer.getInt()};
        return imageSourceHeader;
    }

    private static String readNullTermString(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBuffer.get(byteBufferAllocate.array(), 0, i);
        return NIOUtils.readNullTermString(byteBufferAllocate);
    }

    private static TelevisionHeader readTelevisionInfoHeader(ByteBuffer byteBuffer) {
        TelevisionHeader televisionHeader = new TelevisionHeader();
        televisionHeader.timecode = byteBuffer.getInt();
        televisionHeader.userBits = byteBuffer.getInt();
        televisionHeader.interlace = byteBuffer.get();
        televisionHeader.filedNumber = byteBuffer.get();
        televisionHeader.videoSignalStarted = byteBuffer.get();
        televisionHeader.zero = byteBuffer.get();
        televisionHeader.horSamplingRateHz = byteBuffer.getInt();
        televisionHeader.vertSampleRateHz = byteBuffer.getInt();
        televisionHeader.frameRate = byteBuffer.getInt();
        televisionHeader.timeOffset = byteBuffer.getInt();
        televisionHeader.gamma = byteBuffer.getInt();
        televisionHeader.blackLevel = byteBuffer.getInt();
        televisionHeader.blackGain = byteBuffer.getInt();
        televisionHeader.breakpoint = byteBuffer.getInt();
        televisionHeader.referenceWhiteLevel = byteBuffer.getInt();
        televisionHeader.integrationTime = byteBuffer.getInt();
        return televisionHeader;
    }

    public static Date tryParseISO8601Date(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() == 19) {
            return date(str, "yyyy:MM:dd:HH:mm:ss");
        }
        if (str.length() == 23) {
            str = str + "00";
        }
        return date(str, "yyyy:MM:dd:HH:mm:ss:Z");
    }

    public DPXMetadata parseMetadata() {
        DPXMetadata dPXMetadata = new DPXMetadata();
        FileHeader fileInfo = readFileInfo(this.readBuf);
        dPXMetadata.file = fileInfo;
        fileInfo.magic = this.magic;
        this.readBuf.position(768);
        dPXMetadata.image = readImageInfoHeader(this.readBuf);
        this.readBuf.position(IMAGESOURCE_OFFSET);
        dPXMetadata.imageSource = readImageSourceHeader(this.readBuf);
        this.readBuf.position(FILM_OFFSET);
        dPXMetadata.film = readFilmInformationHeader(this.readBuf);
        this.readBuf.position(TVINFO_OFFSET);
        dPXMetadata.television = readTelevisionInfoHeader(this.readBuf);
        dPXMetadata.userId = readNullTermString(this.readBuf, 32);
        return dPXMetadata;
    }
}
