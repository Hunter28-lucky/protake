package com.blink.academy.film.support.stream.ts.google.Core.PSI;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PMT;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PMTStream;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class PMTDefaultImpl extends SITableAbstractImpl implements PMT {
    public int PCR_PID;
    public int program_number;
    public int table_pid;
    public int version_number;
    public List<Descriptor> descs = new Vector();
    public List<PMTStream> streams = new Vector();
    public long interval_millis = 400;

    public PMTDefaultImpl(int i, int i2, int i3, int i4) {
        this.table_pid = 0;
        this.version_number = 0;
        this.program_number = 0;
        this.PCR_PID = 0;
        this.version_number = i2;
        this.program_number = i3;
        this.PCR_PID = i4;
        this.table_pid = i;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public boolean addStream(PMTStream pMTStream) {
        this.streams.add(pMTStream);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public boolean addStreamAt(int i, PMTStream pMTStream) {
        if (i < 0 || i > this.streams.size()) {
            return false;
        }
        this.streams.add(i, pMTStream);
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public int getPCR_PID() {
        return this.PCR_PID;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public int getProgramNumber() {
        return this.program_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public PMTStream getStreamAt(int i) {
        if (i < 0 || i >= this.streams.size()) {
            return null;
        }
        return this.streams.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public int getStreamSize() {
        return this.streams.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public Iterator<PMTStream> getStreams() {
        return this.streams.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public int getStreamsLength() {
        Iterator<PMTStream> it = this.streams.iterator();
        int sizeInBytes = 0;
        while (it.hasNext()) {
            sizeInBytes += it.next().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.PROGRAM_MAP_TABLE;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return this.table_pid;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return getVersionNumber();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        return 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return false;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public void removeAllDescriptors() {
        List<Descriptor> list = this.descs;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public void removeAllStreams() {
        List<PMTStream> list = this.streams;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public boolean removeStream(PMTStream pMTStream) {
        return this.streams.remove(pMTStream);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public boolean removeStreamAt(int i, PMTStream pMTStream) {
        if (i < 0 || i >= this.streams.size()) {
            return false;
        }
        this.streams.remove(i);
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public void setPCR_PID(int i) {
        this.PCR_PID = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public void setProgramNumber(int i) {
        this.program_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public boolean setStreamAt(int i, PMTStream pMTStream) {
        if (i < 0 || i >= this.streams.size()) {
            return false;
        }
        this.streams.set(i, pMTStream);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PMT
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        int descriptorsLength = 1008 - getDescriptorsLength();
        int totalSectionNumber = getTotalSectionNumber();
        Section[] sectionArr = new Section[totalSectionNumber];
        int i = 0;
        int i2 = 0;
        while (i < totalSectionNumber) {
            sectionArr[i] = SectionFactory.createPMTSection(this, this.program_number);
            int sizeInBytes = 0;
            int i3 = i2;
            while (i3 < getStreamSize() && getStreamAt(i3).getSizeInBytes() + sizeInBytes < descriptorsLength) {
                sizeInBytes += getStreamAt(i3).getSizeInBytes();
                i3++;
            }
            BitOutputStream bitOutputStream = new BitOutputStream((getDescriptorsLength() + 4 + sizeInBytes) * 8);
            bitOutputStream.writeFromLSB(0, 3);
            bitOutputStream.writeFromLSB(this.PCR_PID, 13);
            bitOutputStream.writeFromLSB(0, 4);
            bitOutputStream.writeFromLSB(getDescriptorsLength(), 12);
            if (getDescriptorSize() > 0) {
                Iterator<Descriptor> descriptors = getDescriptors();
                while (descriptors.hasNext()) {
                    bitOutputStream.write(descriptors.next().toByteArray());
                }
            }
            while (i2 < i3) {
                bitOutputStream.write(getStreamAt(i2).toByteArray());
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
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<PMT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(TableID.PROGRAM_MAP_TABLE.getValue());
        sb.append("</table_id>\n");
        String str2 = ((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<program_number>" + this.program_number + "</program_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<PCR_PID>" + this.PCR_PID + "</PCR_PID>\n";
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str3 = str3 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        if (getStreamSize() > 0) {
            String str4 = str2 + MyUTIL.whiteSpaceStr(i2) + "<PMTStreamLoop>\n";
            Iterator<PMTStream> streams = getStreams();
            while (streams.hasNext()) {
                str4 = str4 + streams.next().toXMLString(i + 4);
            }
            str2 = str4 + MyUTIL.whiteSpaceStr(i2) + "</PMTStreamLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</PMT>\n";
    }
}
