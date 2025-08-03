package org.jcodec.containers.mps;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.common.IntIntMap;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.containers.mps.psi.PATSection;
import org.jcodec.containers.mps.psi.PMTSection;

/* loaded from: classes2.dex */
public class MTSPktDump {
    private static void dumpTSPackets(ReadableByteChannel readableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(192512);
        while (true) {
            int i = -1;
            if (readableByteChannel.read(byteBufferAllocate) == -1) {
                return;
            }
            byteBufferAllocate.flip();
            byteBufferAllocate.limit((byteBufferAllocate.limit() / TsConstants.TS_PACKET_SIZE) * TsConstants.TS_PACKET_SIZE);
            int i2 = 0;
            while (byteBufferAllocate.hasRemaining()) {
                ByteBuffer byteBuffer = NIOUtils.read(byteBufferAllocate, TsConstants.TS_PACKET_SIZE);
                Preconditions.checkState(71 == (byteBuffer.get() & ExifInterface.MARKER));
                int i3 = ((byteBuffer.get() & ExifInterface.MARKER) << 8) | (byteBuffer.get() & ExifInterface.MARKER);
                int i4 = i3 & 8191;
                int i5 = (i3 >> 14) & 1;
                int i6 = byteBuffer.get() & ExifInterface.MARKER;
                int i7 = i6 & 15;
                if ((i6 & 32) != 0) {
                    NIOUtils.skip(byteBuffer, byteBuffer.get() & ExifInterface.MARKER);
                }
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("#");
                sb.append(i2);
                sb.append("[guid: ");
                sb.append(i4);
                sb.append(", cnt: ");
                sb.append(i7);
                sb.append(", start: ");
                sb.append(i5 == 1 ? "y" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                printStream.print(sb.toString());
                if (i4 == 0 || i4 == i) {
                    System.out.print(", PSI]: ");
                    if (i5 == 1) {
                        NIOUtils.skip(byteBuffer, byteBuffer.get() & ExifInterface.MARKER);
                    }
                    if (i4 == 0) {
                        PATSection pat = PATSection.parsePAT(byteBuffer);
                        int i8 = pat.getPrograms().values()[0];
                        printPat(pat);
                        i = i8;
                    } else if (i4 == i) {
                        printPmt(PMTSection.parsePMT(byteBuffer));
                    }
                } else {
                    System.out.print("]: " + byteBuffer.remaining());
                }
                System.out.println();
                i2++;
            }
            byteBufferAllocate.clear();
        }
    }

    public static void main1(String[] strArr) throws Throwable {
        MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, new MainUtils.Flag[0]);
        if (arguments.args.length < 1) {
            MainUtils.printHelpNoFlags("file name");
            return;
        }
        FileChannelWrapper fileChannelWrapper = null;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(new File(arguments.args[0]));
            dumpTSPackets(fileChannelWrapper);
        } finally {
            NIOUtils.closeQuietly(fileChannelWrapper);
        }
    }

    private static void printPat(PATSection pATSection) {
        IntIntMap programs = pATSection.getPrograms();
        System.out.print("PAT: ");
        for (int i : programs.keys()) {
            System.out.print(i + Constants.COLON_SEPARATOR + programs.get(i) + ", ");
        }
    }

    private static void printPmt(PMTSection pMTSection) {
        System.out.print("PMT: ");
        for (PMTSection.PMTStream pMTStream : pMTSection.getStreams()) {
            System.out.print(pMTStream.getPid() + Constants.COLON_SEPARATOR + pMTStream.getStreamTypeTag() + ", ");
        }
    }
}
