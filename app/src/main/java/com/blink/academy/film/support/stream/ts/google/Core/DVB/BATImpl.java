package com.blink.academy.film.support.stream.ts.google.Core.DVB;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.DVB.BAT;
import com.blink.academy.film.support.stream.ts.google.API.DVB.BATTransportStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class BATImpl extends SITableAbstractImpl implements BAT {
    public int bouquet_id;
    public int version_number;
    public List<Descriptor> descs = new Vector();
    public List<BATTransportStream> transport_streams = new Vector();
    public long interval_millis = 500;

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

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public boolean addTransportStream(BATTransportStream bATTransportStream) {
        return this.transport_streams.add(bATTransportStream);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public int getBouquetId() {
        return this.bouquet_id;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.BOUQUET_ASSOCIATION_TABLE;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return 17;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        int descriptorsLength = 1021 - (getDescriptorsLength() + 13);
        int i = 0;
        int i2 = 0;
        while (i < numTransportStreams()) {
            int sizeInBytes = 0;
            while (i < numTransportStreams() && getTransportStreamAt(i).getSizeInBytes() + sizeInBytes < descriptorsLength) {
                sizeInBytes += getTransportStreamAt(i).getSizeInBytes();
                i++;
            }
            i2++;
        }
        return i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public BATTransportStream getTransportStreamAt(int i) {
        return this.transport_streams.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public Iterator<BATTransportStream> getTransportStreams() {
        return this.transport_streams.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return getTotalSectionNumber() > 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public int numTransportStreams() {
        return this.transport_streams.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public void removeAllDescriptors() {
        List<Descriptor> list = this.descs;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public void removeAllTransportStreams() {
        List<BATTransportStream> list = this.transport_streams;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public boolean removeTransportStream(BATTransportStream bATTransportStream) {
        return this.transport_streams.remove(bATTransportStream);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public void setBouquetId(int i) {
        this.bouquet_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean setDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.set(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.BAT
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        int descriptorsLength = 1021 - (getDescriptorsLength() + 13);
        int totalSectionNumber = getTotalSectionNumber();
        Section[] sectionArr = new Section[totalSectionNumber];
        int i = 0;
        int i2 = 0;
        while (i < totalSectionNumber) {
            sectionArr[i] = SectionFactory.createBATSection(this, this.bouquet_id, i, totalSectionNumber - 1);
            int sizeInBytes = 0;
            int i3 = i2;
            while (i3 < numTransportStreams() && getTransportStreamAt(i3).getSizeInBytes() + sizeInBytes < descriptorsLength) {
                sizeInBytes += getTransportStreamAt(i3).getSizeInBytes();
                i3++;
            }
            BitOutputStream bitOutputStream = new BitOutputStream((getDescriptorsLength() + 2 + 2 + sizeInBytes) * 8);
            bitOutputStream.writeFromLSB(0, 4);
            bitOutputStream.writeFromLSB(getDescriptorsLength(), 12);
            if (getDescriptorSize() > 0) {
                Iterator<Descriptor> descriptors = getDescriptors();
                while (descriptors.hasNext()) {
                    bitOutputStream.write(descriptors.next().toByteArray());
                }
            }
            bitOutputStream.writeFromLSB(0, 4);
            bitOutputStream.writeFromLSB(sizeInBytes, 12);
            while (i2 < i3) {
                bitOutputStream.write(getTransportStreamAt(i2).toByteArray());
                i2++;
            }
            sectionArr[i].setPrivateData(bitOutputStream.toByteArray());
            i++;
            i2 = i3;
        }
        return sectionArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<BAT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(getTableID());
        sb.append("</table_id>\n");
        String str2 = (sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<bouquet_id>" + getBouquetId() + "</bouquet_id>\n") + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n";
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str3 = str3 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        if (numTransportStreams() > 0) {
            String str4 = str2 + MyUTIL.whiteSpaceStr(i2) + "<BATTransportStreamLoop>\n";
            Iterator<BATTransportStream> transportStreams = getTransportStreams();
            while (transportStreams.hasNext()) {
                str4 = str4 + transportStreams.next().toXMLString(i + 4);
            }
            str2 = str4 + MyUTIL.whiteSpaceStr(i2) + "</BATTransportStreamLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</BAT>\n";
    }
}
