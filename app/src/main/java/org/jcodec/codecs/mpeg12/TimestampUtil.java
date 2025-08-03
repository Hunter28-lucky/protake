package org.jcodec.codecs.mpeg12;

import com.umeng.analytics.pro.am;
import java.io.File;
import java.util.Arrays;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.model.RationalLarge;
import org.jcodec.common.tools.MainUtils;

/* loaded from: classes2.dex */
public class TimestampUtil {
    private static final MainUtils.Flag[] ALL_FLAGS;
    private static final String COMMAND_ROUND = "round";
    private static final String COMMAND_SCALE = "scale";
    private static final String COMMAND_SHIFT = "shift";
    private static final MainUtils.Flag FLAG_STREAM;
    private static final String STRAM_VIDEO = "video";
    private static final String STREAM_ALL = "all";
    private static final String STREAM_AUDIO = "audio";

    public static abstract class BaseCommand extends FixTimestamp {
        private String streamSelector;

        public BaseCommand(String str) {
            this.streamSelector = str;
        }

        @Override // org.jcodec.codecs.mpeg12.FixTimestamp
        public long doWithTimestamp(int i, long j, boolean z) {
            return (TimestampUtil.STREAM_ALL.equals(this.streamSelector) || (TimestampUtil.STRAM_VIDEO.equals(this.streamSelector) && isVideo(i)) || (TimestampUtil.STREAM_AUDIO.equals(this.streamSelector) && isAudio(i))) ? withTimestamp(j, z) : j;
        }

        public abstract long withTimestamp(long j, boolean z);
    }

    static {
        MainUtils.Flag flag = MainUtils.Flag.flag("stream", am.aB, "A stream to shift, i.e. 'video' or 'audio' or 'all' [default]");
        FLAG_STREAM = flag;
        ALL_FLAGS = new MainUtils.Flag[]{flag};
    }

    public static void main1(String[] strArr) throws Throwable {
        MainUtils.Flag[] flagArr = ALL_FLAGS;
        MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, flagArr);
        if (arguments.args.length < 3) {
            System.out.println("A utility to tweak MPEG TS timestamps.");
            MainUtils.printHelp(flagArr, Arrays.asList("command", "arg", "in name", "?out file"));
            System.out.println("Where command is:\n\tshift\tShift timestamps of selected stream by arg.\n\tscale\tScale timestams of selected stream by arg [num:den].\n\tround\tRound timestamps of selected stream to multiples of arg.");
            return;
        }
        File file = new File(arguments.getArg(2));
        if (arguments.argsLength() > 3) {
            File file2 = new File(arguments.getArg(3));
            IOUtils.copyFile(file, file2);
            file = file2;
        }
        String arg = arguments.getArg(0);
        String stringFlagD = arguments.getStringFlagD(FLAG_STREAM, STREAM_ALL);
        if (COMMAND_SHIFT.equalsIgnoreCase(arg)) {
            final long j = Long.parseLong(arguments.getArg(1));
            new BaseCommand(stringFlagD) { // from class: org.jcodec.codecs.mpeg12.TimestampUtil.1
                @Override // org.jcodec.codecs.mpeg12.TimestampUtil.BaseCommand
                public long withTimestamp(long j2, boolean z) {
                    return Math.max(j2 + j, 0L);
                }
            }.fix(file);
        } else if (COMMAND_SCALE.equalsIgnoreCase(arg)) {
            final RationalLarge rationalLarge = RationalLarge.parse(arguments.getArg(1));
            new BaseCommand(stringFlagD) { // from class: org.jcodec.codecs.mpeg12.TimestampUtil.2
                @Override // org.jcodec.codecs.mpeg12.TimestampUtil.BaseCommand
                public long withTimestamp(long j2, boolean z) {
                    return rationalLarge.multiplyS(j2);
                }
            }.fix(file);
        } else if (COMMAND_ROUND.equalsIgnoreCase(arg)) {
            final int i = Integer.parseInt(arguments.getArg(1));
            new BaseCommand(stringFlagD) { // from class: org.jcodec.codecs.mpeg12.TimestampUtil.3
                @Override // org.jcodec.codecs.mpeg12.TimestampUtil.BaseCommand
                public long withTimestamp(long j2, boolean z) {
                    return Math.round(j2 / i) * i;
                }
            }.fix(file);
        }
    }
}
