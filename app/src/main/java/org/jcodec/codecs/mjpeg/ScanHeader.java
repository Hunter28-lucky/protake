package org.jcodec.codecs.mjpeg;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ScanHeader {
    public int ah;
    public int al;
    public Component[] components;
    public int ls;
    public int ns;
    public int se;
    public int ss;

    public static class Component {
        public int cs;
        public int ta;
        public int td;
    }

    public static ScanHeader read(ByteBuffer byteBuffer) {
        ScanHeader scanHeader = new ScanHeader();
        scanHeader.ls = byteBuffer.getShort() & 65535;
        int i = byteBuffer.get() & ExifInterface.MARKER;
        scanHeader.ns = i;
        scanHeader.components = new Component[i];
        int i2 = 0;
        while (true) {
            Component[] componentArr = scanHeader.components;
            if (i2 >= componentArr.length) {
                scanHeader.ss = byteBuffer.get() & ExifInterface.MARKER;
                scanHeader.se = byteBuffer.get() & ExifInterface.MARKER;
                int i3 = byteBuffer.get() & ExifInterface.MARKER;
                scanHeader.ah = (i3 & 240) >>> 4;
                scanHeader.al = i3 & 15;
                return scanHeader;
            }
            Component component = new Component();
            componentArr[i2] = component;
            component.cs = byteBuffer.get() & ExifInterface.MARKER;
            int i4 = byteBuffer.get() & ExifInterface.MARKER;
            component.td = (i4 & 240) >>> 4;
            component.ta = i4 & 15;
            i2++;
        }
    }

    public boolean isInterleaved() {
        return this.ns > 1;
    }
}
