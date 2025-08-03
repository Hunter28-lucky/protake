package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCTChannel;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class TVCTDefaultImpl extends SITableAbstractImpl implements TVCT {
    public int version_number = 0;
    public int transport_stream_id = 0;
    public List<TVCTChannel> channels = new Vector();
    public List<Descriptor> descs = new Vector();
    public long interval_millis = 400;

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public boolean addChannel(TVCTChannel tVCTChannel) {
        this.channels.add(tVCTChannel);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public boolean addChannelAt(int i, TVCTChannel tVCTChannel) {
        if (i < 0 || i > this.channels.size()) {
            return false;
        }
        this.channels.add(i, tVCTChannel);
        return true;
    }

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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public TVCTChannel getChannelAt(int i) {
        if (i < 0 || i >= this.channels.size()) {
            return null;
        }
        return this.channels.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public Iterator<TVCTChannel> getChannels() {
        return this.channels.iterator();
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public int getNumChannels() {
        return this.channels.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.TERRESTRIAL_VIRTUAL_CHANNEL_TABLE;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return 8187;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return getVersionNumber();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        int descriptorsLength = 1021 - (getDescriptorsLength() + 13);
        int i = 0;
        int i2 = 0;
        while (i < getNumChannels()) {
            int sizeInBytes = 0;
            while (i < getNumChannels() && getChannelAt(i).getSizeInBytes() + sizeInBytes < descriptorsLength) {
                sizeInBytes += getChannelAt(i).getSizeInBytes();
                i++;
            }
            i2++;
        }
        return i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public int getTransportStreamId() {
        return this.transport_stream_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return getTotalSectionNumber() > 1;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public boolean setChannelAt(int i, TVCTChannel tVCTChannel) {
        if (i < 0 || i >= this.channels.size()) {
            return false;
        }
        this.channels.set(i, tVCTChannel);
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
    public void setTransportStreamId(int i) {
        this.transport_stream_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT
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
            sectionArr[i] = SectionFactory.createTVCTSection(this, this.transport_stream_id, i, totalSectionNumber - 1);
            int sizeInBytes = 0;
            int i3 = i2;
            while (i3 < getNumChannels() && getChannelAt(i3).getSizeInBytes() + sizeInBytes < descriptorsLength) {
                sizeInBytes += getChannelAt(i3).getSizeInBytes();
                i3++;
            }
            BitOutputStream bitOutputStream = new BitOutputStream((sizeInBytes + 2 + 2 + getDescriptorsLength()) * 8);
            bitOutputStream.writeFromLSB(0, 8);
            bitOutputStream.writeFromLSB(getNumChannels(), 8);
            while (i2 < i3) {
                bitOutputStream.write(getChannelAt(i2).toByteArray());
                i2++;
            }
            bitOutputStream.writeFromLSB(255, 6);
            bitOutputStream.writeFromLSB(getDescriptorsLength(), 10);
            if (getDescriptorSize() > 0) {
                Iterator<Descriptor> descriptors = getDescriptors();
                while (descriptors.hasNext()) {
                    bitOutputStream.write(descriptors.next().toByteArray());
                }
            }
            sectionArr[i].setPrivateData(bitOutputStream.toByteArray());
            i++;
            i2 = i3;
        }
        return sectionArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<TVCT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(TableID.TERRESTRIAL_VIRTUAL_CHANNEL_TABLE.getValue());
        sb.append("</table_id>\n");
        String str2 = (sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<transport_stream_id>" + this.transport_stream_id + "</transport_stream_id>\n") + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n";
        if (getNumChannels() > 0) {
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<TVCTChannelLoop>\n";
            Iterator<TVCTChannel> channels = getChannels();
            while (channels.hasNext()) {
                str3 = str3 + channels.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</TVCTChannelLoop>\n";
        }
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str4 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str4 = str4 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str4 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</TVCT>\n";
    }
}
