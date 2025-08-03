package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class RRTDimensionValue {
    public int abbrev_rating_value_length;
    public MultiString abbrev_rating_value_text;
    public int rating_value_length;
    public MultiString rating_value_text;

    public int get(IBitstream iBitstream) throws IOException {
        Util.trace(iBitstream.getpos(), 0, 0, "begin RRTDimensionValue");
        this.abbrev_rating_value_length = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.abbrev_rating_value_length, "abbrev_rating_value_length (" + this.abbrev_rating_value_length + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure abbrev_rating_value_text");
        MultiString multiString = new MultiString();
        this.abbrev_rating_value_text = multiString;
        int i = multiString.get(iBitstream) + 0;
        this.rating_value_length = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.rating_value_length, "rating_value_length (" + this.rating_value_length + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure rating_value_text");
        MultiString multiString2 = new MultiString();
        this.rating_value_text = multiString2;
        int i2 = i + multiString2.get(iBitstream);
        Util.trace(iBitstream.getpos(), 0, 0, "end RRTDimensionValue");
        return i2;
    }

    public int put(IBitstream iBitstream) throws IOException {
        iBitstream.putbits(this.abbrev_rating_value_length, 8);
        int iPut = this.abbrev_rating_value_text.put(iBitstream) + 0;
        iBitstream.putbits(this.rating_value_length, 8);
        return iPut + this.rating_value_text.put(iBitstream);
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        this.abbrev_rating_value_length = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<abbrev_rating_value_length type=\"flUInt\" bitLen=\"8\">" + this.abbrev_rating_value_length + "</abbrev_rating_value_length>");
        } else {
            XML.WriteXmlElement("<abbrev_rating_value_length bitLen=\"8\">" + this.abbrev_rating_value_length + "</abbrev_rating_value_length>");
        }
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure abbrev_rating_value_text");
        this.abbrev_rating_value_text = new MultiString();
        XML.IntoAClass("abbrev_rating_value_text", 0);
        int iPutxml = this.abbrev_rating_value_text.putxml(iBitstream, z) + 0;
        XML.OutOfClass("</abbrev_rating_value_text>");
        this.rating_value_length = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<rating_value_length type=\"flUInt\" bitLen=\"8\">" + this.rating_value_length + "</rating_value_length>");
        } else {
            XML.WriteXmlElement("<rating_value_length bitLen=\"8\">" + this.rating_value_length + "</rating_value_length>");
        }
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure rating_value_text");
        this.rating_value_text = new MultiString();
        XML.IntoAClass("rating_value_text", 0);
        int iPutxml2 = iPutxml + this.rating_value_text.putxml(iBitstream, z);
        XML.OutOfClass("</rating_value_text>");
        return iPutxml2;
    }
}
