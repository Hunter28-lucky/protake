package org.jcodec.containers.mps.psi;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class PSISection {
    public int currentNextIndicator;
    public int lastSectionNumber;
    public int sectionNumber;
    public int specificId;
    public int tableId;
    public int versionNumber;

    public PSISection(int i, int i2, int i3, int i4, int i5, int i6) {
        this.tableId = i;
        this.specificId = i2;
        this.versionNumber = i3;
        this.currentNextIndicator = i4;
        this.sectionNumber = i5;
        this.lastSectionNumber = i6;
    }

    public static PSISection parsePSI(ByteBuffer byteBuffer) {
        int i = byteBuffer.get() & ExifInterface.MARKER;
        int i2 = byteBuffer.getShort() & 65535;
        if ((49152 & i2) != 32768) {
            throw new RuntimeException("Invalid section data");
        }
        byteBuffer.limit(byteBuffer.position() + (i2 & 4095));
        int i3 = byteBuffer.getShort() & 65535;
        int i4 = byteBuffer.get() & ExifInterface.MARKER;
        return new PSISection(i, i3, (i4 >> 1) & 31, i4 & 1, byteBuffer.get() & ExifInterface.MARKER, byteBuffer.get() & ExifInterface.MARKER);
    }

    public int getCurrentNextIndicator() {
        return this.currentNextIndicator;
    }

    public int getLastSectionNumber() {
        return this.lastSectionNumber;
    }

    public int getSectionNumber() {
        return this.sectionNumber;
    }

    public int getSpecificId() {
        return this.specificId;
    }

    public int getTableId() {
        return this.tableId;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }
}
