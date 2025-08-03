package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class RRTDimensionDefaultImpl implements RRTDimension {
    public MultipleStringStructure dimension_name_text;
    public int graduated_scale = 0;
    public List<RRTDimensionValue> values = new Vector();

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public boolean addValue(RRTDimensionValue rRTDimensionValue) {
        this.values.add(rRTDimensionValue);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public boolean addValueAt(int i, RRTDimensionValue rRTDimensionValue) {
        if (i < 0 || i > this.values.size()) {
            return false;
        }
        this.values.add(i, rRTDimensionValue);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public int getDimensionNameLength() {
        MultipleStringStructure multipleStringStructure = this.dimension_name_text;
        if (multipleStringStructure == null) {
            return 0;
        }
        return multipleStringStructure.getSizeInBytes();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public MultipleStringStructure getDimensionNameText() {
        return this.dimension_name_text;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public int getGraduatedScale() {
        return this.graduated_scale;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return this.dimension_name_text.getSizeInBytes() + 1 + 1 + getValuesLength();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public RRTDimensionValue getValueAt(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public Iterator<RRTDimensionValue> getValues() {
        return this.values.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public int getValuesDefined() {
        return this.values.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public int getValuesLength() {
        Iterator<RRTDimensionValue> it = this.values.iterator();
        int sizeInBytes = 0;
        while (it.hasNext()) {
            sizeInBytes += it.next().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public void removeAllValues() {
        List<RRTDimensionValue> list = this.values;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public boolean removeValue(RRTDimensionValue rRTDimensionValue) {
        return this.values.remove(rRTDimensionValue);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public boolean removeValueAt(int i, RRTDimensionValue rRTDimensionValue) {
        if (i < 0 || i >= this.values.size()) {
            return false;
        }
        this.values.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public void setDimensionNameText(MultipleStringStructure multipleStringStructure) {
        this.dimension_name_text = multipleStringStructure;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public void setGraduatedScale(int i) {
        this.graduated_scale = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension
    public boolean setValueAt(int i, RRTDimensionValue rRTDimensionValue) {
        if (i < 0 || i >= this.values.size()) {
            return false;
        }
        this.values.set(i, rRTDimensionValue);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(getDimensionNameLength(), 8);
        bitOutputStream.write(this.dimension_name_text.toByteArray());
        bitOutputStream.writeFromLSB(255, 3);
        bitOutputStream.writeFromLSB(this.graduated_scale, 1);
        if (getValuesDefined() > 0) {
            Iterator<RRTDimensionValue> values = getValues();
            while (values.hasNext()) {
                bitOutputStream.write(values.next().toByteArray());
            }
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<RRTDimension>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(this.dimension_name_text.toXMLString(i2));
        String str2 = sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<graduated_scale>" + this.graduated_scale + "</graduated_scale>\n";
        if (getValuesDefined() > 0) {
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<RRTDimensionValueLoop>\n";
            Iterator<RRTDimensionValue> values = getValues();
            while (values.hasNext()) {
                str3 = str3 + values.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</RRTDimensionValueLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</RRTDimension>\n";
    }
}
