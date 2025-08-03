package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class MGTDefaultImpl extends SITableAbstractImpl implements MGT {
    public int version_number = 0;
    public List<Descriptor> descs = new Vector();
    public List<MGTTable> tables = new Vector();
    public long interval_millis = 150;

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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public boolean addTable(MGTTable mGTTable) {
        this.tables.add(mGTTable);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public boolean addTableAt(int i, MGTTable mGTTable) {
        if (i < 0 || i > this.tables.size()) {
            return false;
        }
        this.tables.add(i, mGTTable);
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public MGTTable getTableAt(int i) {
        if (i < 0 || i >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.MASTER_GUIDE_TABLE;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return 8187;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public Iterator<MGTTable> getTables() {
        return this.tables.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public int getTablesDefined() {
        return this.tables.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        return 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public void removeAllTables() {
        List<MGTTable> list = this.tables;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public boolean removeTable(MGTTable mGTTable) {
        return this.tables.remove(mGTTable);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public boolean removeTableAt(int i) {
        if (i < 0 || i >= this.tables.size()) {
            return false;
        }
        this.tables.remove(i);
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public boolean setTableAt(int i, MGTTable mGTTable) {
        if (i < 0 || i >= this.tables.size()) {
            return false;
        }
        this.tables.set(i, mGTTable);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        int descriptorsLength = 1021 - (getDescriptorsLength() + 14);
        int totalSectionNumber = getTotalSectionNumber();
        Section[] sectionArr = new Section[totalSectionNumber];
        int i = 0;
        int i2 = 0;
        while (i < totalSectionNumber) {
            sectionArr[i] = SectionFactory.createMGTSection(this);
            int sizeInBytes = 0;
            int i3 = i2;
            while (i3 < getTablesDefined() && getTableAt(i3).getSizeInBytes() + sizeInBytes < descriptorsLength) {
                sizeInBytes += getTableAt(i3).getSizeInBytes();
                i3++;
            }
            BitOutputStream bitOutputStream = new BitOutputStream((sizeInBytes + 3 + 2 + getDescriptorsLength()) * 8);
            bitOutputStream.writeFromLSB(0, 8);
            bitOutputStream.writeFromLSB(getTablesDefined(), 16);
            while (i2 < i3) {
                bitOutputStream.write(getTableAt(i2).toByteArray());
                i2++;
            }
            bitOutputStream.writeFromLSB(255, 4);
            bitOutputStream.writeFromLSB(getDescriptorsLength(), 12);
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
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<MGT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(TableID.MASTER_GUIDE_TABLE.getValue());
        sb.append("</table_id>\n");
        String str2 = sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n";
        if (getTablesDefined() > 0) {
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<MGTTableLoop>\n";
            Iterator<MGTTable> tables = getTables();
            while (tables.hasNext()) {
                str3 = str3 + tables.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</MGTTableLoop>\n";
        }
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str4 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str4 = str4 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str4 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</MGT>\n";
    }
}
