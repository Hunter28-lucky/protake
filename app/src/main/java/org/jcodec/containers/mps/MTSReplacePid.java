package org.jcodec.containers.mps;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import org.jcodec.common.IntIntMap;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.containers.mps.MTSUtils;
import org.jcodec.containers.mps.psi.PATSection;
import org.jcodec.containers.mps.psi.PSISection;

/* loaded from: classes2.dex */
public class MTSReplacePid extends MTSUtils.TSReader {
    private Set<Integer> pmtPids;
    private IntIntMap replaceSpec;

    public MTSReplacePid(IntIntMap intIntMap) {
        super(true);
        this.pmtPids = new HashSet();
        this.replaceSpec = intIntMap;
    }

    public static void main1(String[] strArr) throws Throwable {
        MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, new MainUtils.Flag[0]);
        if (arguments.args.length < 2) {
            MainUtils.printHelpNoFlags("pid_from:pid_to,[pid_from:pid_to...]", "file");
            return;
        }
        IntIntMap replaceSpec = parseReplaceSpec(arguments.getArg(0));
        FileChannelWrapper fileChannelWrapperRwChannel = null;
        try {
            fileChannelWrapperRwChannel = NIOUtils.rwChannel(new File(arguments.getArg(1)));
            new MTSReplacePid(replaceSpec).readTsFile(fileChannelWrapperRwChannel);
        } finally {
            NIOUtils.closeQuietly(fileChannelWrapperRwChannel);
        }
    }

    private static IntIntMap parseReplaceSpec(String str) {
        IntIntMap intIntMap = new IntIntMap();
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            String[] strArrSplit = str2.split(Constants.COLON_SEPARATOR);
            intIntMap.put(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        }
        return intIntMap;
    }

    private int replacePid(IntIntMap intIntMap, int i) {
        int i2 = intIntMap.contains(i) ? intIntMap.get(i) : i;
        System.out.println("[" + i + "->" + i2 + "]");
        return i2;
    }

    private void replaceRefs(IntIntMap intIntMap, int i, ByteBuffer byteBuffer, Set<Integer> set) {
        if (i == 0) {
            for (int i2 : PATSection.parsePAT(byteBuffer).getPrograms().values()) {
                set.add(Integer.valueOf(i2));
            }
            return;
        }
        if (set.contains(Integer.valueOf(i))) {
            System.out.println(MainUtils.bold("PMT"));
            PSISection.parsePSI(byteBuffer);
            byteBuffer.getShort();
            NIOUtils.skip(byteBuffer, byteBuffer.getShort() & 4095);
            while (byteBuffer.remaining() > 4) {
                byte b = byteBuffer.get();
                Object objFromTag = MTSStreamType.fromTag(b);
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                if (objFromTag == null) {
                    objFromTag = "UNKNOWN";
                }
                sb.append(objFromTag);
                sb.append("(");
                sb.append(String.format("0x%02x", Byte.valueOf(b)));
                sb.append("):\t");
                printStream.print(sb.toString());
                int i3 = byteBuffer.getShort() & 65535;
                byteBuffer.putShort(byteBuffer.position() - 2, (short) ((i3 & (-8192)) | (replacePid(intIntMap, i3 & 8191) & 8191)));
                NIOUtils.skip(byteBuffer, byteBuffer.getShort() & 4095);
            }
        }
    }

    @Override // org.jcodec.containers.mps.MTSUtils.TSReader
    public boolean onPkt(int i, boolean z, ByteBuffer byteBuffer, long j, boolean z2, ByteBuffer byteBuffer2) {
        if (z2) {
            replaceRefs(this.replaceSpec, i, byteBuffer, this.pmtPids);
        } else {
            System.out.print("TS ");
            ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
            short s = byteBufferDuplicate.getShort(byteBufferDuplicate.position() + 1);
            byteBufferDuplicate.putShort(byteBufferDuplicate.position() + 1, (short) ((s & (-8192)) | replacePid(this.replaceSpec, s & 8191)));
        }
        return true;
    }
}
