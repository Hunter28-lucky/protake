package org.jcodec.common.tools;

import com.umeng.analytics.pro.am;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import org.jcodec.codecs.wav.WavHeader;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.AudioUtil;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.tools.MainUtils;

/* loaded from: classes2.dex */
public class WavSplit {
    private static final MainUtils.Flag[] ALL_FLAGS;
    public static final MainUtils.Flag FLAG_PATTERN;

    static {
        MainUtils.Flag flag = MainUtils.Flag.flag("pattern", am.ax, "Output file name pattern, i.e. out%02d.wav");
        FLAG_PATTERN = flag;
        ALL_FLAGS = new MainUtils.Flag[]{flag};
    }

    private static void copy(AudioFormat audioFormat, ReadableByteChannel readableByteChannel, SeekableByteChannel[] seekableByteChannelArr) throws IOException {
        ByteBuffer[] byteBufferArr = new ByteBuffer[seekableByteChannelArr.length];
        for (int i = 0; i < seekableByteChannelArr.length; i++) {
            byteBufferArr[i] = ByteBuffer.allocate(audioFormat.framesToBytes(4096));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(audioFormat.framesToBytes(4096) * seekableByteChannelArr.length);
        while (readableByteChannel.read(byteBufferAllocate) != -1) {
            byteBufferAllocate.flip();
            AudioUtil.deinterleave(audioFormat, byteBufferAllocate, byteBufferArr);
            byteBufferAllocate.clear();
            for (int i2 = 0; i2 < seekableByteChannelArr.length; i2++) {
                byteBufferArr[i2].flip();
                seekableByteChannelArr[i2].write(byteBufferArr[i2]);
                byteBufferArr[i2].clear();
            }
        }
    }

    public static void main1(String[] strArr) throws Exception {
        MainUtils.Flag[] flagArr = ALL_FLAGS;
        MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, flagArr);
        if (arguments.argsLength() < 1) {
            MainUtils.printHelp(flagArr, Arrays.asList("filename.wav"));
            System.exit(-1);
        }
        File file = new File(strArr[0]);
        String stringFlagD = arguments.getStringFlagD(FLAG_PATTERN, "c%02d.wav");
        WavHeader wavHeader = WavHeader.read(file);
        System.out.println("WAV: " + wavHeader.getFormat());
        Preconditions.checkState(2 == wavHeader.fmt.numChannels);
        int i = wavHeader.dataOffset;
        FileChannelWrapper fileChannelWrapper = NIOUtils.readableChannel(file);
        fileChannelWrapper.setPosition(i);
        int channels = wavHeader.getFormat().getChannels();
        SeekableByteChannel[] seekableByteChannelArr = new SeekableByteChannel[channels];
        for (int i2 = 0; i2 < channels; i2++) {
            seekableByteChannelArr[i2] = NIOUtils.writableChannel(new File(file.getParentFile(), String.format(stringFlagD, Integer.valueOf(i2))));
            WavHeader.copyWithChannels(wavHeader, 1).write(seekableByteChannelArr[i2]);
        }
        copy(wavHeader.getFormat(), fileChannelWrapper, seekableByteChannelArr);
        for (int i3 = 0; i3 < channels; i3++) {
            seekableByteChannelArr[i3].close();
        }
    }
}
