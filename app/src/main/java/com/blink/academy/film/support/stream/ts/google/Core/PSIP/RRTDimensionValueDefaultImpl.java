package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue;

/* loaded from: classes.dex */
public class RRTDimensionValueDefaultImpl implements RRTDimensionValue {
    public MultipleStringStructure abbrev_rating_value_text;
    public MultipleStringStructure rating_value_text;

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue
    public int getAbbrevRatingValueLength() {
        MultipleStringStructure multipleStringStructure = this.abbrev_rating_value_text;
        if (multipleStringStructure == null) {
            return 0;
        }
        return multipleStringStructure.getSizeInBytes();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue
    public MultipleStringStructure getAbbrevRatingValueText() {
        return this.abbrev_rating_value_text;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue
    public int getRatingValueLength() {
        MultipleStringStructure multipleStringStructure = this.rating_value_text;
        if (multipleStringStructure == null) {
            return 0;
        }
        return multipleStringStructure.getSizeInBytes();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue
    public MultipleStringStructure getRatingValueText() {
        return this.rating_value_text;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return this.abbrev_rating_value_text.getSizeInBytes() + 2 + this.rating_value_text.getSizeInBytes();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue
    public void setAbbrevRatingValueText(MultipleStringStructure multipleStringStructure) {
        this.abbrev_rating_value_text = multipleStringStructure;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue
    public void setRatingValueText(MultipleStringStructure multipleStringStructure) {
        this.rating_value_text = multipleStringStructure;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(getAbbrevRatingValueLength(), 8);
        bitOutputStream.write(this.abbrev_rating_value_text.toByteArray());
        bitOutputStream.writeFromLSB(getRatingValueLength(), 8);
        bitOutputStream.write(this.rating_value_text.toByteArray());
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<RRTDimensionValue>\n";
        if (this.abbrev_rating_value_text != null) {
            str = str + this.abbrev_rating_value_text.toXMLString(i + 2);
        }
        if (this.rating_value_text != null) {
            str = str + this.rating_value_text.toXMLString(i + 2);
        }
        return str + MyUTIL.whiteSpaceStr(i) + "</RRTDimensionValue>\n";
    }
}
