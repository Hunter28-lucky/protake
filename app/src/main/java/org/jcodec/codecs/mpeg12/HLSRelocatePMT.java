package org.jcodec.codecs.mpeg12;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.containers.mps.psi.PATSection;

/* loaded from: classes2.dex */
public class HLSRelocatePMT {
    private static final int CHUNK_SIZE_PKT = 1024;
    private static final int TS_PKT_SIZE = 188;
    private static final int TS_START_CODE = 71;

    public static void main1(String[] strArr) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, new MainUtils.Flag[0]);
        if (arguments.args.length < 2) {
            MainUtils.printHelpNoFlags("file _in", "file out");
            return;
        }
        FileChannelWrapper fileChannelWrapperWritableChannel = null;
        try {
            FileChannelWrapper fileChannelWrapper2 = NIOUtils.readableChannel(new File(arguments.args[0]));
            try {
                fileChannelWrapperWritableChannel = NIOUtils.writableChannel(new File(arguments.args[1]));
                System.err.println("Processed: " + replocatePMT(fileChannelWrapper2, fileChannelWrapperWritableChannel) + " packets.");
                NIOUtils.closeQuietly(fileChannelWrapper2);
                NIOUtils.closeQuietly(fileChannelWrapperWritableChannel);
            } catch (Throwable th) {
                th = th;
                FileChannelWrapper fileChannelWrapper3 = fileChannelWrapperWritableChannel;
                fileChannelWrapperWritableChannel = fileChannelWrapper2;
                fileChannelWrapper = fileChannelWrapper3;
                NIOUtils.closeQuietly(fileChannelWrapperWritableChannel);
                NIOUtils.closeQuietly(fileChannelWrapper);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannelWrapper = null;
        }
    }

    private static int replocatePMT(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(192512);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ByteBuffer byteBuffer = null;
        ByteBuffer byteBuffer2 = null;
        int i = 0;
        while (readableByteChannel.read(byteBufferAllocate) != -1) {
            byteBufferAllocate.flip();
            byteBufferAllocate.limit((byteBufferAllocate.limit() / 188) * 188);
            while (byteBufferAllocate.hasRemaining()) {
                ByteBuffer byteBuffer3 = NIOUtils.read(byteBufferAllocate, 188);
                ByteBuffer byteBufferDuplicate = byteBuffer3.duplicate();
                Preconditions.checkState(71 == (byteBufferDuplicate.get() & ExifInterface.MARKER));
                i++;
                int i2 = ((byteBufferDuplicate.get() & ExifInterface.MARKER) << 8) | (byteBufferDuplicate.get() & ExifInterface.MARKER);
                int i3 = i2 & 8191;
                int i4 = (i2 >> 14) & 1;
                if ((byteBufferDuplicate.get() & ExifInterface.MARKER & 32) != 0) {
                    NIOUtils.skip(byteBufferDuplicate, byteBufferDuplicate.get() & ExifInterface.MARKER);
                }
                if (i3 == 0 || hashSet.contains(Integer.valueOf(i3))) {
                    if (i4 == 1) {
                        NIOUtils.skip(byteBufferDuplicate, byteBufferDuplicate.get() & ExifInterface.MARKER);
                    }
                    if (i3 == 0) {
                        int[] iArrValues = PATSection.parsePAT(byteBufferDuplicate).getPrograms().values();
                        for (int i5 : iArrValues) {
                            hashSet.add(Integer.valueOf(i5));
                        }
                        byteBuffer2 = byteBuffer3;
                    } else if (hashSet.contains(Integer.valueOf(i3))) {
                        writableByteChannel.write(byteBuffer2);
                        writableByteChannel.write(byteBuffer3);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            writableByteChannel.write((ByteBuffer) it.next());
                        }
                        arrayList.clear();
                        byteBuffer = byteBuffer3;
                    }
                } else if (byteBuffer == null) {
                    arrayList.add(byteBuffer3);
                } else {
                    writableByteChannel.write(byteBuffer3);
                }
            }
            byteBufferAllocate.clear();
        }
        return i;
    }
}
