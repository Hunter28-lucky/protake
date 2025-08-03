package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable;
import com.blink.academy.film.support.stream.ts.google.API.TableType;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class MGTTableDefaultImpl implements MGTTable {
    public TableType table_type;
    public int table_type_PID = 0;
    public int table_type_version_number = 0;
    public int number_bytes = 0;
    public List<Descriptor> descs = new Vector();

    public MGTTableDefaultImpl(TableType tableType) {
        this.table_type = TableType.Terrestrial_VCT_with_current_next_indicator_1;
        this.table_type = tableType;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable
    public long getNumberBytes() {
        return this.number_bytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getDescriptorsLength() + 11;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable
    public TableType getTableType() {
        return this.table_type;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable
    public int getTableTypePID() {
        return this.table_type_PID;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable
    public int getTableTypeVersionNumber() {
        return this.table_type_version_number;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable
    public void setNumberBytes(int i) {
        this.number_bytes = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable
    public void setTableType(TableType tableType) {
        this.table_type = tableType;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable
    public void setTableTypePID(int i) {
        this.table_type_PID = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable
    public void setTableTypeVersionNumber(int i) {
        this.table_type_version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(this.table_type.getValue(), 16);
        bitOutputStream.writeFromLSB(255, 3);
        bitOutputStream.writeFromLSB(this.table_type_PID, 13);
        bitOutputStream.writeFromLSB(255, 3);
        bitOutputStream.writeFromLSB(this.table_type_version_number, 5);
        bitOutputStream.writeFromLSB(this.number_bytes, 32);
        bitOutputStream.writeFromLSB(255, 4);
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
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<MGTTable>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_type>");
        sb.append(this.table_type.getValue());
        sb.append("</table_type>\n");
        String str2 = ((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<table_type_PID>" + this.table_type_PID + "</table_type_PID>\n") + MyUTIL.whiteSpaceStr(i2) + "<table_type_version_number>" + this.table_type_version_number + "</table_type_version_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<number_bytes>" + this.number_bytes + "</number_bytes>\n";
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str3 = str3 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</MGTTable>\n";
    }
}
