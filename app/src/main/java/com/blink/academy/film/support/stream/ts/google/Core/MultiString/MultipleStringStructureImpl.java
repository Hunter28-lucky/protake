package com.blink.academy.film.support.stream.ts.google.Core.MultiString;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class MultipleStringStructureImpl implements MultipleStringStructure {
    public List<MultipleStringData> strings = new Vector();

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public boolean addStringData(MultipleStringData multipleStringData) {
        return this.strings.add(multipleStringData);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public boolean addStringDataAt(int i, MultipleStringData multipleStringData) {
        if (i < 0 || i > this.strings.size()) {
            return false;
        }
        this.strings.add(i, multipleStringData);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public Iterator<MultipleStringData> getAllStringData() {
        return this.strings.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public int getAllStringDataLength() {
        int sizeInBytes = 0;
        if (getNumberStrings() > 0) {
            Iterator<MultipleStringData> allStringData = getAllStringData();
            while (allStringData.hasNext()) {
                sizeInBytes += allStringData.next().getSizeInBytes();
            }
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public int getNumberStrings() {
        return this.strings.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getAllStringDataLength() + 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public MultipleStringData getStringDataAt(int i) {
        if (i < 0 || i >= this.strings.size()) {
            return null;
        }
        return this.strings.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public void removeAllStringData() {
        List<MultipleStringData> list = this.strings;
        list.remove(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public boolean removeStringData(MultipleStringData multipleStringData) {
        return this.strings.remove(multipleStringData);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public boolean removeStringDataAt(int i) {
        if (i < 0 || i >= this.strings.size()) {
            return false;
        }
        this.strings.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure
    public boolean setStringDataAt(int i, MultipleStringData multipleStringData) {
        if (i < 0 || i >= this.strings.size()) {
            return false;
        }
        this.strings.set(i, multipleStringData);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(getNumberStrings(), 8);
        if (getNumberStrings() > 0) {
            Iterator<MultipleStringData> allStringData = getAllStringData();
            while (allStringData.hasNext()) {
                bitOutputStream.write(allStringData.next().toByteArray());
            }
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<MultipleStringStructure>\n";
        if (getNumberStrings() > 0) {
            Iterator<MultipleStringData> allStringData = getAllStringData();
            while (allStringData.hasNext()) {
                str = str + allStringData.next().toXMLString(i + 2);
            }
        }
        return str + MyUTIL.whiteSpaceStr(i) + "</MultipleStringStructure>\n";
    }
}
