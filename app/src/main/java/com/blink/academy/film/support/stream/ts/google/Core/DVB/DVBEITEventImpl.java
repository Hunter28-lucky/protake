package com.blink.academy.film.support.stream.ts.google.Core.DVB;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class DVBEITEventImpl implements DVBEITEvent {
    public List<Descriptor> descs = new Vector();
    public int duration;
    public int event_id;
    public int free_CA_mode;
    public int running_status;
    public long start_time;

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean addDescriptor(Descriptor descriptor) {
        this.descs.add(descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean addDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i > this.descs.size()) {
            return false;
        }
        this.descs.add(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public Descriptor getDescriptorAt(int i) {
        if (i < 0 || i >= this.descs.size()) {
            return null;
        }
        return this.descs.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public int getDescriptorSize() {
        return this.descs.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public Iterator<Descriptor> getDescriptors() {
        return this.descs.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public int getDescriptorsLength() {
        Iterator<Descriptor> it = this.descs.iterator();
        int sizeInBytes = 0;
        while (it.hasNext()) {
            sizeInBytes += it.next().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public int getDuration() {
        return this.duration;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public int getEventId() {
        return this.event_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public int getFreeCaMode() {
        return this.free_CA_mode;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public int getRunningStatus() {
        return this.running_status;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getDescriptorsLength() + 12;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public long getStartTime() {
        return this.start_time;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public void removeAllDescriptors() {
        List<Descriptor> list = this.descs;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean removeDescriptor(Descriptor descriptor) {
        return this.descs.remove(descriptor);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean removeDescriptorAt(int i) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean setDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.set(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public void setDuration(int i) {
        this.duration = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public void setEventId(int i) {
        this.event_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public void setFreeCaMode(int i) {
        this.free_CA_mode = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public void setRunningStatus(int i) {
        this.running_status = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public void setStartTime(long j) {
        this.start_time = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(this.event_id, 16);
        bitOutputStream.writeFromLSB((int) (this.start_time >> 8), 32);
        bitOutputStream.writeFromLSB((int) (this.start_time & 255), 8);
        bitOutputStream.writeFromLSB(this.duration, 24);
        bitOutputStream.writeFromLSB(this.running_status, 3);
        bitOutputStream.writeFromLSB(this.free_CA_mode, 1);
        bitOutputStream.writeFromLSB(getDescriptorsLength(), 12);
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            while (descriptors.hasNext()) {
                bitOutputStream.write(descriptors.next().toByteArray());
            }
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<EITEvent>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<start_time>");
        sb.append(this.start_time);
        sb.append("</start_time>\n");
        String str2 = ((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<duration>" + this.duration + "</duration>\n") + MyUTIL.whiteSpaceStr(i2) + "<running_status>" + this.running_status + "</running_status>\n") + MyUTIL.whiteSpaceStr(i2) + "<free_CA_mode>" + this.free_CA_mode + "</free_CA_mode>\n";
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str3 = str3 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</EITEvent>\n";
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public void setDuration(int i, int i2, int i3) {
        this.duration = 0;
        int i4 = 0 | ((i / 10) << 20);
        this.duration = i4;
        int i5 = ((i % 10) << 16) | i4;
        this.duration = i5;
        int i6 = i5 | ((i2 / 10) << 12);
        this.duration = i6;
        int i7 = i6 | ((i2 % 10) << 8);
        this.duration = i7;
        int i8 = i7 | ((i3 / 10) << 4);
        this.duration = i8;
        this.duration = i8 | (i3 % 10);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent
    public void setStartTime(int i, int i2, int i3, int i4, int i5, int i6) {
        this.start_time = 0L;
        long j = ((i4 / 10) << 20) | 0;
        this.start_time = j;
        long j2 = j | ((i4 % 10) << 16);
        this.start_time = j2;
        long j3 = j2 | ((i5 / 10) << 12);
        this.start_time = j3;
        long j4 = j3 | ((i5 % 10) << 8);
        this.start_time = j4;
        long j5 = j4 | ((i6 / 10) << 4);
        this.start_time = j5;
        long j6 = j5 | (i6 % 10);
        this.start_time = j6;
        long j7 = i;
        long j8 = i2;
        long j9 = i3;
        long j10 = (j8 == 1 || j8 == 2) ? 1L : 0L;
        this.start_time = ((((j9 + 14956) + ((int) ((j7 - j10) * 365.25d))) + ((int) (((j8 + 1) + (j10 * 12)) * 30.6001d))) << 24) | j6;
    }
}
