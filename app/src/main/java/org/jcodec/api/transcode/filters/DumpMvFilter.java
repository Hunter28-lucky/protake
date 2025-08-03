package org.jcodec.api.transcode.filters;

import java.io.PrintStream;
import org.jcodec.api.transcode.Filter;
import org.jcodec.api.transcode.PixelStore;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class DumpMvFilter implements Filter {
    private boolean js;

    public DumpMvFilter(boolean z) {
        this.js = z;
    }

    private void dumpMvJs(Frame frame) {
        System.err.println("{");
        if (frame.getFrameType() == SliceType.I) {
            return;
        }
        H264Utils.MvList2D mvs = frame.getMvs();
        int i = 0;
        while (i < 2) {
            PrintStream printStream = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append(i == 0 ? "backRef" : "forwardRef");
            sb.append(": [");
            printStream.println(sb.toString());
            for (int i2 = 0; i2 < mvs.getHeight(); i2++) {
                for (int i3 = 0; i3 < mvs.getWidth(); i3++) {
                    System.err.println("{x: " + i3 + ", y: " + i2 + ", mx: " + H264Utils.Mv.mvX(mvs.getMv(i3, i2, i)) + ", my: " + H264Utils.Mv.mvY(mvs.getMv(i3, i2, i)) + ", ridx:" + H264Utils.Mv.mvRef(mvs.getMv(i3, i2, i)) + "},");
                }
            }
            System.err.println("],");
            if (frame.getFrameType() != SliceType.B) {
                break;
            } else {
                i++;
            }
        }
        System.err.println("}");
    }

    private void dumpMvTxt(Frame frame) {
        System.err.println("FRAME ================================================================");
        if (frame.getFrameType() == SliceType.I) {
            return;
        }
        H264Utils.MvList2D mvs = frame.getMvs();
        int i = 0;
        while (i < 2) {
            PrintStream printStream = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append(i == 0 ? "BCK" : "FWD");
            sb.append(" ===========================================================================");
            printStream.println(sb.toString());
            for (int i2 = 0; i2 < mvs.getHeight(); i2++) {
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                StringBuilder sb4 = new StringBuilder();
                StringBuilder sb5 = new StringBuilder();
                sb2.append("+");
                sb3.append("|");
                sb4.append("|");
                sb5.append("|");
                for (int i3 = 0; i3 < mvs.getWidth(); i3++) {
                    sb2.append("------+");
                    sb3.append(String.format("%6d|", Integer.valueOf(H264Utils.Mv.mvX(mvs.getMv(i3, i2, i)))));
                    sb4.append(String.format("%6d|", Integer.valueOf(H264Utils.Mv.mvY(mvs.getMv(i3, i2, i)))));
                    sb5.append(String.format("    %2d|", Integer.valueOf(H264Utils.Mv.mvRef(mvs.getMv(i3, i2, i)))));
                }
                System.err.println(sb2.toString());
                System.err.println(sb3.toString());
                System.err.println(sb4.toString());
                System.err.println(sb5.toString());
            }
            if (frame.getFrameType() != SliceType.B) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // org.jcodec.api.transcode.Filter
    public PixelStore.LoanerPicture filter(Picture picture, PixelStore pixelStore) {
        Frame frame = (Frame) picture;
        if (this.js) {
            dumpMvJs(frame);
            return null;
        }
        dumpMvTxt(frame);
        return null;
    }

    @Override // org.jcodec.api.transcode.Filter
    public ColorSpace getInputColor() {
        return null;
    }

    @Override // org.jcodec.api.transcode.Filter
    public ColorSpace getOutputColor() {
        return null;
    }
}
