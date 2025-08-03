package com.blink.academy.film.support.stream.ts.google.Core.MultiString;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;

/* loaded from: classes.dex */
public class StringSegmentImpl implements StringSegment {
    public byte[] compressed_string_byte = null;
    public int compression_type;
    public int mode;

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment
    public byte[] getCompressedStringByte() {
        return this.compressed_string_byte;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment
    public int getCompressedStringNumberBytes() {
        byte[] bArr = this.compressed_string_byte;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment
    public int getCompressionType() {
        return this.compression_type;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment
    public int getMode() {
        return this.mode;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getCompressedStringNumberBytes() + 3;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment
    public void setCompressedStringByte(byte[] bArr) {
        this.compressed_string_byte = bArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment
    public void setCompressionType(int i) {
        this.compression_type = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.MultiString.StringSegment
    public void setMode(int i) {
        this.mode = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(this.compression_type, 8);
        bitOutputStream.writeFromLSB(this.mode, 8);
        bitOutputStream.writeFromLSB(getCompressedStringNumberBytes(), 8);
        if (getCompressedStringNumberBytes() > 0) {
            bitOutputStream.write(getCompressedStringByte());
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<StringSegment>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<compression_type>");
        sb.append(this.compression_type);
        sb.append("</compression_type>\n");
        String str2 = sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<mode>" + this.mode + "</mode>\n";
        if (getCompressedStringNumberBytes() > 0) {
            str2 = str2 + MyUTIL.whiteSpaceStr(i2) + "TODO: print compressed string to a readable character type\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</StringSegment>\n";
    }
}
