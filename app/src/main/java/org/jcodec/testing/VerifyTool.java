package org.jcodec.testing;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.BufferH264ES;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.JCodecUtil2;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.dpx.DPXReader;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class VerifyTool {
    private void doIt(String str) {
        for (File file : new File(str).listFiles(new FilenameFilter() { // from class: org.jcodec.testing.VerifyTool.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.endsWith(".264");
            }
        })) {
            File file2 = new File(file.getParentFile(), file.getName().replaceAll(".264$", "_dec.yuv"));
            if (file.exists() && file2.exists()) {
                try {
                    if (test(file, file2)) {
                        System.out.println(file.getAbsolutePath() + " -- FIXED");
                        Platform.deleteFile(file);
                        Platform.deleteFile(file2);
                    } else {
                        System.out.println(file.getAbsolutePath() + " -- NOT FIXED!!!!");
                    }
                } catch (Throwable th) {
                    System.out.println(file.getAbsolutePath() + " -- ERROR: " + th.getMessage());
                }
            }
        }
    }

    public static void main1(String[] strArr) throws IOException {
        if (strArr.length != 1) {
            System.out.println("Syntax: <error folder location>");
        } else {
            new VerifyTool().doIt(strArr[0]);
        }
    }

    private boolean test(File file, File file2) throws IOException {
        Picture pictureCreateCompatible;
        int i;
        ByteBuffer byteBuffer;
        BufferH264ES bufferH264ES = new BufferH264ES(NIOUtils.fetchFromFile(file));
        Picture pictureCreate = Picture.create(DPXReader.TVINFO_OFFSET, 1088, ColorSpace.YUV420);
        H264Decoder h264Decoder = new H264Decoder();
        ByteBuffer byteBufferFetchFromFile = NIOUtils.fetchFromFile(file2);
        do {
            Packet packetNextFrame = bufferH264ES.nextFrame();
            if (packetNextFrame == null) {
                return true;
            }
            Frame frameCropped = h264Decoder.decodeFrame(packetNextFrame.getData(), pictureCreate.getData()).cropped();
            pictureCreateCompatible = frameCropped.createCompatible();
            pictureCreateCompatible.copyFrom(frameCropped);
            int width = pictureCreateCompatible.getWidth() * pictureCreateCompatible.getHeight();
            i = width >> 2;
            byteBuffer = NIOUtils.read(byteBufferFetchFromFile, width + i + i);
            if (!Platform.arrayEqualsByte(ArrayUtil.toByteArrayShifted(JCodecUtil2.getAsIntArray(byteBuffer, width)), pictureCreateCompatible.getPlaneData(0)) || !Platform.arrayEqualsByte(ArrayUtil.toByteArrayShifted(JCodecUtil2.getAsIntArray(byteBuffer, i)), pictureCreateCompatible.getPlaneData(1))) {
                return false;
            }
        } while (Platform.arrayEqualsByte(ArrayUtil.toByteArrayShifted(JCodecUtil2.getAsIntArray(byteBuffer, i)), pictureCreateCompatible.getPlaneData(2)));
        return false;
    }
}
