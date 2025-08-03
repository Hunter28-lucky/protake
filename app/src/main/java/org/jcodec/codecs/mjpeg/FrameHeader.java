package org.jcodec.codecs.mjpeg;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class FrameHeader {
    public int bitsPerSample;
    public Component[] components;
    public int headerLength;
    public int height;
    public int nComp;
    public int width;

    public static class Component {
        public int index;
        public int quantTable;
        public int subH;
        public int subV;
    }

    public static FrameHeader read(ByteBuffer byteBuffer) {
        FrameHeader frameHeader = new FrameHeader();
        frameHeader.headerLength = byteBuffer.getShort() & 65535;
        frameHeader.bitsPerSample = byteBuffer.get() & ExifInterface.MARKER;
        frameHeader.height = byteBuffer.getShort() & 65535;
        frameHeader.width = byteBuffer.getShort() & 65535;
        int i = byteBuffer.get() & ExifInterface.MARKER;
        frameHeader.nComp = i;
        frameHeader.components = new Component[i];
        int i2 = 0;
        while (true) {
            Component[] componentArr = frameHeader.components;
            if (i2 >= componentArr.length) {
                return frameHeader;
            }
            Component component = new Component();
            componentArr[i2] = component;
            component.index = byteBuffer.get() & ExifInterface.MARKER;
            int i3 = byteBuffer.get() & ExifInterface.MARKER;
            component.subH = (i3 & 240) >>> 4;
            component.subV = i3 & 15;
            component.quantTable = byteBuffer.get() & ExifInterface.MARKER;
            i2++;
        }
    }

    public int getHmax() {
        int i = 0;
        int iMax = 0;
        while (true) {
            Component[] componentArr = this.components;
            if (i >= componentArr.length) {
                return iMax;
            }
            iMax = Math.max(iMax, componentArr[i].subH);
            i++;
        }
    }

    public int getVmax() {
        int i = 0;
        int iMax = 0;
        while (true) {
            Component[] componentArr = this.components;
            if (i >= componentArr.length) {
                return iMax;
            }
            iMax = Math.max(iMax, componentArr[i].subV);
            i++;
        }
    }
}
