package com.blink.academy.film.support.stream.ts.google.Core.MultiString;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class MultipleStringDataImpl implements MultipleStringData {
    public int ISO_639_language_code;
    public List<StringSegment> segments = new Vector();

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public boolean addStringSegment(StringSegment stringSegment) {
        return this.segments.add(stringSegment);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public boolean addStringSegmentAt(int i, StringSegment stringSegment) {
        if (i < 0 || i > this.segments.size()) {
            return false;
        }
        this.segments.add(i, stringSegment);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public int getLanguageCode() {
        return this.ISO_639_language_code;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public int getNumberSegments() {
        return this.segments.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getStringSegmentsLength() + 4;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public StringSegment getStringSegmentAt(int i) {
        if (i < 0 || i >= this.segments.size()) {
            return null;
        }
        return this.segments.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public Iterator<StringSegment> getStringSegments() {
        return this.segments.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public int getStringSegmentsLength() {
        int sizeInBytes = 0;
        if (getNumberSegments() > 0) {
            Iterator<StringSegment> stringSegments = getStringSegments();
            while (stringSegments.hasNext()) {
                sizeInBytes += stringSegments.next().getSizeInBytes();
            }
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public void removeAllStringSegments() {
        List<StringSegment> list = this.segments;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public boolean removeStringSegment(StringSegment stringSegment) {
        return this.segments.remove(stringSegment);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public boolean removeStringSegmentAt(int i, StringSegment stringSegment) {
        if (i < 0 || i >= this.segments.size()) {
            return false;
        }
        this.segments.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public void setLanguageCode(int i) {
        this.ISO_639_language_code = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringData
    public boolean setStringSegmentAt(int i, StringSegment stringSegment) {
        if (i < 0 || i >= this.segments.size()) {
            return false;
        }
        this.segments.set(i, stringSegment);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(this.ISO_639_language_code, 24);
        bitOutputStream.writeFromLSB(getNumberSegments(), 8);
        if (getNumberSegments() > 0) {
            Iterator<StringSegment> stringSegments = getStringSegments();
            while (stringSegments.hasNext()) {
                bitOutputStream.write(stringSegments.next().toByteArray());
            }
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<StringData>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<ISO_639_language_code>");
        sb.append(this.ISO_639_language_code);
        sb.append("</ISO_639_language_code>\n");
        String string = sb.toString();
        if (getNumberSegments() > 0) {
            Iterator<StringSegment> stringSegments = getStringSegments();
            while (stringSegments.hasNext()) {
                string = string + stringSegments.next().toXMLString(i2);
            }
        }
        return string + MyUTIL.whiteSpaceStr(i) + "</StringData>\n";
    }
}
