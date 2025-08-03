package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class EITEventDefaultImpl implements EITEvent {
    public int ETM_location;
    public List<Descriptor> descs = new Vector();
    public int event_id;
    public int length_in_seconds;
    public long start_time;
    public MultipleStringStructure title_text;

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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public int getETMLocation() {
        return this.ETM_location;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public int getEventId() {
        return this.event_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public int getLengthInSeconds() {
        return this.length_in_seconds;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getTitleLength() + 12 + getDescriptorsLength();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public long getStartTime() {
        return this.start_time;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public int getTitleLength() {
        MultipleStringStructure multipleStringStructure = this.title_text;
        if (multipleStringStructure == null) {
            return 0;
        }
        return multipleStringStructure.getSizeInBytes();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public MultipleStringStructure getTitleText() {
        return this.title_text;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public void setETMLocation(int i) {
        this.ETM_location = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public void setEventId(int i) {
        this.event_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public void setLengthInSeconds(int i) {
        this.length_in_seconds = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public void setStartTime(long j) {
        this.start_time = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent
    public void setTitleText(MultipleStringStructure multipleStringStructure) {
        this.title_text = multipleStringStructure;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(17, 2);
        bitOutputStream.writeFromLSB(this.event_id, 14);
        bitOutputStream.writeFromLSB((int) this.start_time, 32);
        bitOutputStream.writeFromLSB(255, 2);
        bitOutputStream.writeFromLSB(this.ETM_location, 2);
        bitOutputStream.writeFromLSB(this.length_in_seconds, 20);
        bitOutputStream.writeFromLSB(getTitleLength(), 8);
        MultipleStringStructure multipleStringStructure = this.title_text;
        if (multipleStringStructure != null) {
            bitOutputStream.write(multipleStringStructure.toByteArray());
        }
        bitOutputStream.writeFromLSB(255, 4);
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
        sb.append("<event_id>");
        sb.append(this.event_id);
        sb.append("</event_id>\n");
        String str2 = (sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<start_time>" + this.start_time + "</start_time>\n") + MyUTIL.whiteSpaceStr(i2) + "<ETM_location>" + this.ETM_location + "</ETM_location>\n";
        if (this.title_text != null) {
            str2 = str2 + this.title_text.toXMLString(i2);
        }
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
}
