package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class SegmentIndexBox extends FullBox {
    public long earliest_presentation_time;
    public long first_offset;
    public long reference_ID;
    public int reference_count;
    public Reference[] references;
    public int reserved;
    public long timescale;

    public static class Reference {
        public long SAP_delta_time;
        public int SAP_type;
        public boolean reference_type;
        public long referenced_size;
        public boolean starts_with_SAP;
        public long subsegment_duration;

        public String toString() {
            return "Reference [reference_type=" + this.reference_type + ", referenced_size=" + this.referenced_size + ", subsegment_duration=" + this.subsegment_duration + ", starts_with_SAP=" + this.starts_with_SAP + ", SAP_type=" + this.SAP_type + ", SAP_delta_time=" + this.SAP_delta_time + "]";
        }
    }

    public SegmentIndexBox(Header header) {
        super(header);
    }

    public static SegmentIndexBox createSegmentIndexBox() {
        return new SegmentIndexBox(new Header(fourcc()));
    }

    public static String fourcc() {
        return "sidx";
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt((int) this.reference_ID);
        byteBuffer.putInt((int) this.timescale);
        if (this.version == 0) {
            byteBuffer.putInt((int) this.earliest_presentation_time);
            byteBuffer.putInt((int) this.first_offset);
        } else {
            byteBuffer.putLong(this.earliest_presentation_time);
            byteBuffer.putLong(this.first_offset);
        }
        byteBuffer.putShort((short) this.reserved);
        byteBuffer.putShort((short) this.reference_count);
        for (int i = 0; i < this.reference_count; i++) {
            Reference reference = this.references[i];
            int i2 = (int) (((reference.reference_type ? 1 : 0) << 31) | reference.referenced_size);
            int i3 = (int) reference.subsegment_duration;
            int i4 = (int) ((reference.starts_with_SAP ? Integer.MIN_VALUE : 0) | ((reference.SAP_type & 7) << 28) | (reference.SAP_delta_time & 268435455));
            byteBuffer.putInt(i2);
            byteBuffer.putInt(i3);
            byteBuffer.putInt(i4);
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        return (this.reference_count * 12) + 40;
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        this.reference_ID = Platform.unsignedInt(byteBuffer.getInt());
        this.timescale = Platform.unsignedInt(byteBuffer.getInt());
        if (this.version == 0) {
            this.earliest_presentation_time = Platform.unsignedInt(byteBuffer.getInt());
            this.first_offset = Platform.unsignedInt(byteBuffer.getInt());
        } else {
            this.earliest_presentation_time = byteBuffer.getLong();
            this.first_offset = byteBuffer.getLong();
        }
        this.reserved = byteBuffer.getShort();
        int i = byteBuffer.getShort() & 65535;
        this.reference_count = i;
        this.references = new Reference[i];
        for (int i2 = 0; i2 < this.reference_count; i2++) {
            long jUnsignedInt = Platform.unsignedInt(byteBuffer.getInt());
            long jUnsignedInt2 = Platform.unsignedInt(byteBuffer.getInt());
            long jUnsignedInt3 = Platform.unsignedInt(byteBuffer.getInt());
            Reference reference = new Reference();
            boolean z = true;
            reference.reference_type = ((jUnsignedInt >>> 31) & 1) == 1;
            reference.referenced_size = jUnsignedInt & 2147483647L;
            reference.subsegment_duration = jUnsignedInt2;
            if (((jUnsignedInt3 >>> 31) & 1) != 1) {
                z = false;
            }
            reference.starts_with_SAP = z;
            reference.SAP_type = (int) ((jUnsignedInt3 >>> 28) & 7);
            reference.SAP_delta_time = 268435455 & jUnsignedInt3;
            this.references[i2] = reference;
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public String toString() {
        return "SegmentIndexBox [reference_ID=" + this.reference_ID + ", timescale=" + this.timescale + ", earliest_presentation_time=" + this.earliest_presentation_time + ", first_offset=" + this.first_offset + ", reserved=" + this.reserved + ", reference_count=" + this.reference_count + ", references=" + Platform.arrayToString(this.references) + ", version=" + ((int) this.version) + ", flags=" + this.flags + ", header=" + this.header + "]";
    }
}
