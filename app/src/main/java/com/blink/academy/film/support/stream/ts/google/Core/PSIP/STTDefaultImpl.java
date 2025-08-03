package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.STT;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class STTDefaultImpl extends SITableAbstractImpl implements STT {
    public int version_number = 0;
    public long system_time = 0;
    public int GPS_UTC_offset = 0;
    public int daylight_savings = 0;
    public List<Descriptor> descs = new Vector();
    public long interval_millis = 1000;

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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.STT
    public int getDatlightSavings() {
        return this.daylight_savings;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.STT
    public int getGPS_UTC_Offset() {
        return this.GPS_UTC_offset;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.STT
    public long getSystemTime() {
        return this.system_time;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.SYSTEM_TIME_TABLE;
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
        return 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.STT
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.STT
    public void setDatlightSavings(int i) {
        this.daylight_savings = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean setDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.set(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.STT
    public void setGPS_UTC_Offset(int i) {
        this.GPS_UTC_offset = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.STT
    public void setSystemTime(long j) {
        this.system_time = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.STT
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        int totalSectionNumber = getTotalSectionNumber();
        Section[] sectionArr = new Section[totalSectionNumber];
        for (int i = 0; i < totalSectionNumber; i++) {
            sectionArr[i] = SectionFactory.createSTTSection(this);
            BitOutputStream bitOutputStream = new BitOutputStream((getDescriptorsLength() + 8) * 8);
            bitOutputStream.writeFromLSB(0, 8);
            bitOutputStream.writeFromLSB((int) this.system_time, 32);
            bitOutputStream.writeFromLSB(this.GPS_UTC_offset, 8);
            bitOutputStream.writeFromLSB(this.daylight_savings, 16);
            if (getDescriptorSize() > 0) {
                Iterator<Descriptor> descriptors = getDescriptors();
                while (descriptors.hasNext()) {
                    bitOutputStream.write(descriptors.next().toByteArray());
                }
            }
            sectionArr[i].setPrivateData(bitOutputStream.toByteArray());
        }
        return sectionArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<STT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(TableID.SYSTEM_TIME_TABLE.getValue());
        sb.append("</table_id>\n");
        String str2 = (((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<system_time>" + this.system_time + "</system_time>\n") + MyUTIL.whiteSpaceStr(i2) + "<GPS_UTC_offset>" + this.GPS_UTC_offset + "</GPS_UTC_offset>\n") + MyUTIL.whiteSpaceStr(i2) + "<daylight_savings>" + this.daylight_savings + "</daylight_savings>\n";
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str3 = str3 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</STT>\n";
    }
}
