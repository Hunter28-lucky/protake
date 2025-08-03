package org.jcodec.containers.mps;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import org.jcodec.codecs.mpeg12.MPEGUtil;
import org.jcodec.codecs.mpeg12.bitstream.CopyrightExtension;
import org.jcodec.codecs.mpeg12.bitstream.GOPHeader;
import org.jcodec.codecs.mpeg12.bitstream.PictureCodingExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureDisplayExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.codecs.mpeg12.bitstream.PictureSpatialScalableExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureTemporalScalableExtension;
import org.jcodec.codecs.mpeg12.bitstream.QuantMatrixExtension;
import org.jcodec.codecs.mpeg12.bitstream.SequenceDisplayExtension;
import org.jcodec.codecs.mpeg12.bitstream.SequenceExtension;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceScalableExtension;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MPSDump {
    private static final MainUtils.Flag[] ALL_FLAGS;
    private static final MainUtils.Flag DUMP_FROM;
    private static final MainUtils.Flag STOP_AT;
    public ReadableByteChannel ch;

    public static class MPEGVideoAnalyzer {
        private int bselBufInd;
        private int bselOffset;
        private int bselStartCode;
        private int curBufInd;
        private PictureHeader picHeader;
        private PictureCodingExtension pictureCodingExtension;
        private int prevBufSize;
        private SequenceExtension sequenceExtension;
        private SequenceHeader sequenceHeader;
        private int nextStartCode = -1;
        private ByteBuffer bselPayload = ByteBuffer.allocate(1048576);

        /* JADX INFO: Access modifiers changed from: private */
        public void analyzeMpegVideoPacket(ByteBuffer byteBuffer) {
            int iPosition = byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (byteBuffer.hasRemaining()) {
                this.bselPayload.put((byte) (this.nextStartCode >> 24));
                int i = (this.nextStartCode << 8) | (byteBuffer.get() & ExifInterface.MARKER);
                this.nextStartCode = i;
                if (i >= 256 && i <= 440) {
                    this.bselPayload.flip();
                    this.bselPayload.getInt();
                    int i2 = this.bselStartCode;
                    if (i2 != 0) {
                        if (this.bselBufInd != this.curBufInd) {
                            this.bselOffset -= this.prevBufSize;
                        }
                        dumpBSEl(i2, this.bselOffset, this.bselPayload);
                    }
                    this.bselPayload.clear();
                    this.bselStartCode = this.nextStartCode;
                    this.bselOffset = (byteBuffer.position() - 4) - iPosition;
                    this.bselBufInd = this.curBufInd;
                }
            }
            this.curBufInd++;
            this.prevBufSize = iRemaining;
        }

        private String convertName(String str) {
            return str.replaceAll("([A-Z])", " $1").replaceFirst("^ ", "").toLowerCase();
        }

        private void dumpBSEl(int i, int i2, ByteBuffer byteBuffer) {
            System.out.print(String.format("marker: 0x%02x [@%d] ( ", Integer.valueOf(i), Integer.valueOf(i2)));
            if (i == 256) {
                dumpPictureHeader(byteBuffer);
            } else if (i <= 431) {
                System.out.print(MainUtils.colorBright(String.format("slice @0x%02x", Integer.valueOf(i - 257)), MainUtils.ANSIColor.BLACK, true));
            } else if (i == 435) {
                dumpSequenceHeader(byteBuffer);
            } else if (i == 437) {
                dumpExtension(byteBuffer);
            } else if (i == 440) {
                dumpGroupHeader(byteBuffer);
            } else {
                System.out.print("--");
            }
            System.out.println(" )");
        }

        private String dumpBin(Object obj) throws IllegalAccessException, IllegalArgumentException {
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            Field[] fields = Platform.getFields(obj.getClass());
            for (int i = 0; i < fields.length; i++) {
                if (Modifier.isPublic(fields[i].getModifiers()) && !Modifier.isStatic(fields[i].getModifiers())) {
                    sb.append(convertName(fields[i].getName()) + ": ");
                    if (fields[i].getType().isPrimitive()) {
                        try {
                            sb.append(fields[i].get(obj));
                        } catch (Exception unused) {
                        }
                    } else {
                        Object obj2 = fields[i].get(obj);
                        if (obj2 != null) {
                            sb.append(dumpBin(obj2));
                        } else {
                            sb.append("N/A");
                        }
                    }
                    if (i < fields.length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
            }
            sb.append(">");
            return sb.toString();
        }

        private void dumpCopyrightExtension(CopyrightExtension copyrightExtension) {
            System.out.print(MainUtils.colorBright("copyright extension " + dumpBin(copyrightExtension), MainUtils.ANSIColor.GREEN, true));
        }

        private void dumpExtension(ByteBuffer byteBuffer) {
            PictureCodingExtension pictureCodingExtension;
            BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
            int nBit = bitReaderCreateBitReader.readNBit(4);
            if (this.picHeader == null) {
                if (this.sequenceHeader == null) {
                    System.out.print(MainUtils.colorBright("dangling extension " + nBit, MainUtils.ANSIColor.GREEN, true));
                    return;
                }
                if (nBit == 1) {
                    SequenceExtension sequenceExtension = SequenceExtension.read(bitReaderCreateBitReader);
                    this.sequenceExtension = sequenceExtension;
                    dumpSequenceExtension(sequenceExtension);
                    return;
                } else {
                    if (nBit == 2) {
                        dumpSequenceDisplayExtension(SequenceDisplayExtension.read(bitReaderCreateBitReader));
                        return;
                    }
                    if (nBit == 5) {
                        dumpSequenceScalableExtension(SequenceScalableExtension.read(bitReaderCreateBitReader));
                        return;
                    }
                    System.out.print(MainUtils.colorBright("extension " + nBit, MainUtils.ANSIColor.GREEN, true));
                    return;
                }
            }
            if (nBit == 3) {
                dumpQuantMatrixExtension(QuantMatrixExtension.read(bitReaderCreateBitReader));
                return;
            }
            if (nBit == 4) {
                dumpCopyrightExtension(CopyrightExtension.read(bitReaderCreateBitReader));
                return;
            }
            if (nBit == 7) {
                if (this.sequenceHeader == null || (pictureCodingExtension = this.pictureCodingExtension) == null) {
                    return;
                }
                dumpPictureDisplayExtension(PictureDisplayExtension.read(bitReaderCreateBitReader, this.sequenceExtension, pictureCodingExtension));
                return;
            }
            if (nBit == 8) {
                PictureCodingExtension pictureCodingExtension2 = PictureCodingExtension.read(bitReaderCreateBitReader);
                this.pictureCodingExtension = pictureCodingExtension2;
                dumpPictureCodingExtension(pictureCodingExtension2);
            } else {
                if (nBit == 9) {
                    dumpPictureSpatialScalableExtension(PictureSpatialScalableExtension.read(bitReaderCreateBitReader));
                    return;
                }
                if (nBit == 16) {
                    dumpPictureTemporalScalableExtension(PictureTemporalScalableExtension.read(bitReaderCreateBitReader));
                    return;
                }
                System.out.print(MainUtils.colorBright("extension " + nBit, MainUtils.ANSIColor.GREEN, true));
            }
        }

        private void dumpGroupHeader(ByteBuffer byteBuffer) {
            String str;
            GOPHeader gOPHeader = GOPHeader.read(byteBuffer);
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("group header <closed:");
            sb.append(gOPHeader.isClosedGop());
            sb.append(",broken link:");
            sb.append(gOPHeader.isBrokenLink());
            if (gOPHeader.getTimeCode() != null) {
                str = ",timecode:" + gOPHeader.getTimeCode().toString();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(">");
            printStream.print(MainUtils.colorBright(sb.toString(), MainUtils.ANSIColor.MAGENTA, true));
        }

        private void dumpPictureCodingExtension(PictureCodingExtension pictureCodingExtension) {
            System.out.print(MainUtils.colorBright("picture coding extension " + dumpBin(pictureCodingExtension), MainUtils.ANSIColor.GREEN, true));
        }

        private void dumpPictureDisplayExtension(PictureDisplayExtension pictureDisplayExtension) {
            System.out.print(MainUtils.colorBright("picture display extension " + dumpBin(pictureDisplayExtension), MainUtils.ANSIColor.GREEN, true));
        }

        private void dumpPictureHeader(ByteBuffer byteBuffer) {
            this.picHeader = PictureHeader.read(byteBuffer);
            this.pictureCodingExtension = null;
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("picture header <type:");
            int i = this.picHeader.picture_coding_type;
            sb.append(i == 1 ? "I" : i == 2 ? "P" : TransmitHelper.CAMERA_UNIT_B_CONTENT);
            sb.append(", temp_ref:");
            sb.append(this.picHeader.temporal_reference);
            sb.append(">");
            printStream.print(MainUtils.colorBright(sb.toString(), MainUtils.ANSIColor.BROWN, true));
        }

        private void dumpPictureSpatialScalableExtension(PictureSpatialScalableExtension pictureSpatialScalableExtension) {
            System.out.print(MainUtils.colorBright("picture spatial scalable extension " + dumpBin(pictureSpatialScalableExtension), MainUtils.ANSIColor.GREEN, true));
        }

        private void dumpPictureTemporalScalableExtension(PictureTemporalScalableExtension pictureTemporalScalableExtension) {
            System.out.print(MainUtils.colorBright("picture temporal scalable extension " + dumpBin(pictureTemporalScalableExtension), MainUtils.ANSIColor.GREEN, true));
        }

        private void dumpQuantMatrixExtension(QuantMatrixExtension quantMatrixExtension) {
            System.out.print(MainUtils.colorBright("quant matrix extension " + dumpBin(quantMatrixExtension), MainUtils.ANSIColor.GREEN, true));
        }

        private void dumpSequenceDisplayExtension(SequenceDisplayExtension sequenceDisplayExtension) {
            System.out.print(MainUtils.colorBright("sequence display extension " + dumpBin(sequenceDisplayExtension), MainUtils.ANSIColor.GREEN, true));
        }

        private void dumpSequenceExtension(SequenceExtension sequenceExtension) {
            System.out.print(MainUtils.colorBright("sequence extension " + dumpBin(sequenceExtension), MainUtils.ANSIColor.GREEN, true));
        }

        private void dumpSequenceHeader(ByteBuffer byteBuffer) {
            this.picHeader = null;
            this.pictureCodingExtension = null;
            this.sequenceExtension = null;
            this.sequenceHeader = SequenceHeader.read(byteBuffer);
            System.out.print(MainUtils.colorBright("sequence header", MainUtils.ANSIColor.BLUE, true));
        }

        private void dumpSequenceScalableExtension(SequenceScalableExtension sequenceScalableExtension) {
            System.out.print(MainUtils.colorBright("sequence scalable extension " + dumpBin(sequenceScalableExtension), MainUtils.ANSIColor.GREEN, true));
        }
    }

    static {
        MainUtils.Flag flag = MainUtils.Flag.flag("dump-from", null, "Stop reading at timestamp");
        DUMP_FROM = flag;
        MainUtils.Flag flag2 = MainUtils.Flag.flag("stop-at", null, "Start dumping from timestamp");
        STOP_AT = flag2;
        ALL_FLAGS = new MainUtils.Flag[]{flag, flag2};
    }

    public MPSDump(ReadableByteChannel readableByteChannel) {
        this.ch = readableByteChannel;
    }

    private static ByteBuffer getPesPayload(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
        while (byteBufferDuplicate.hasRemaining()) {
            if (byteBufferDuplicate.duplicate().getInt() >= 441) {
                byteBufferDuplicate2.limit(byteBufferDuplicate.position());
                byteBuffer.position(byteBufferDuplicate.position());
                return byteBufferDuplicate2;
            }
            byteBufferDuplicate.getInt();
            MPEGUtil.gotoNextMarker(byteBufferDuplicate);
        }
        return null;
    }

    public static void main1(String[] strArr) throws IOException {
        try {
            MainUtils.Flag[] flagArr = ALL_FLAGS;
            MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, flagArr);
            if (arguments.args.length < 1) {
                MainUtils.printHelp(flagArr, Arrays.asList("file name"));
                return;
            }
            FileChannelWrapper fileChannelWrapper = NIOUtils.readableChannel(new File(arguments.args[0]));
            new MPSDump(fileChannelWrapper).dump(arguments.getLongFlag(DUMP_FROM), arguments.getLongFlag(STOP_AT));
            NIOUtils.closeQuietly(fileChannelWrapper);
        } finally {
            NIOUtils.closeQuietly(null);
        }
    }

    private static void skipToNextPES(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            int i = byteBuffer.duplicate().getInt();
            if (i >= 445 && i <= 511 && i != 446) {
                return;
            }
            byteBuffer.getInt();
            MPEGUtil.gotoNextMarker(byteBuffer);
        }
    }

    private ByteBuffer transferRemainder(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.clear();
        while (byteBuffer.hasRemaining()) {
            byteBufferDuplicate.put(byteBuffer.get());
        }
        return byteBufferDuplicate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dump(java.lang.Long r12, java.lang.Long r13) throws java.io.IOException {
        /*
            r11 = this;
            r0 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
            r1 = 0
            r2 = 0
            r3 = 0
            r5 = r1
            r6 = r5
        Lc:
            int r7 = r0.position()
            long r7 = (long) r7
            long r3 = r3 - r7
            int r7 = r11.fillBuffer(r0)
            r8 = -1
            if (r7 != r8) goto L1a
            goto L24
        L1a:
            r0.flip()
            int r7 = r0.remaining()
            r8 = 4
            if (r7 >= r8) goto L25
        L24:
            return
        L25:
            int r7 = r0.remaining()
            long r7 = (long) r7
            long r3 = r3 + r7
        L2b:
            if (r6 == 0) goto L41
            int r7 = r6.length
            if (r7 <= 0) goto L41
            int r7 = r7 - r2
            int r7 = r7 + 6
            int r8 = r0.remaining()
            if (r7 > r8) goto L3f
            java.nio.ByteBuffer r7 = org.jcodec.common.io.NIOUtils.read(r0, r7)
            goto L45
        L3f:
            r7 = r1
            goto L45
        L41:
            java.nio.ByteBuffer r7 = getPesPayload(r0)
        L45:
            if (r7 != 0) goto L48
            goto L72
        L48:
            if (r6 == 0) goto L4d
            r11.logPes(r6, r2, r7)
        L4d:
            if (r5 == 0) goto L5e
            if (r6 == 0) goto L5e
            int r6 = r6.streamId
            r8 = 224(0xe0, float:3.14E-43)
            if (r6 < r8) goto L5e
            r8 = 239(0xef, float:3.35E-43)
            if (r6 > r8) goto L5e
            org.jcodec.containers.mps.MPSDump.MPEGVideoAnalyzer.access$000(r5, r7)
        L5e:
            int r6 = r0.remaining()
            r7 = 32
            if (r6 >= r7) goto L68
        L66:
            r6 = r1
            goto L72
        L68:
            skipToNextPES(r0)
            int r6 = r0.remaining()
            if (r6 >= r7) goto L77
            goto L66
        L72:
            java.nio.ByteBuffer r0 = r11.transferRemainder(r0)
            goto Lc
        L77:
            int r2 = r0.position()
            int r6 = r0.remaining()
            long r6 = (long) r6
            long r6 = r3 - r6
            org.jcodec.containers.mps.PESPacket r6 = org.jcodec.containers.mps.MPSUtils.readPESHeader(r0, r6)
            int r7 = r0.position()
            int r2 = r7 - r2
            if (r12 == 0) goto L9d
            long r7 = r6.pts
            long r9 = r12.longValue()
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L9d
            org.jcodec.containers.mps.MPSDump$MPEGVideoAnalyzer r5 = new org.jcodec.containers.mps.MPSDump$MPEGVideoAnalyzer
            r5.<init>()
        L9d:
            if (r13 == 0) goto L2b
            long r7 = r6.pts
            long r9 = r13.longValue()
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L2b
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mps.MPSDump.dump(java.lang.Long, java.lang.Long):void");
    }

    public int fillBuffer(ByteBuffer byteBuffer) throws IOException {
        return this.ch.read(byteBuffer);
    }

    public void logPes(PESPacket pESPacket, int i, ByteBuffer byteBuffer) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(pESPacket.streamId);
        sb.append("(");
        sb.append(pESPacket.streamId >= 224 ? "video" : "audio");
        sb.append(") [");
        sb.append(pESPacket.pos);
        sb.append(", ");
        sb.append(byteBuffer.remaining() + i);
        sb.append("], pts: ");
        sb.append(pESPacket.pts);
        sb.append(", dts: ");
        sb.append(pESPacket.dts);
        printStream.println(sb.toString());
    }
}
