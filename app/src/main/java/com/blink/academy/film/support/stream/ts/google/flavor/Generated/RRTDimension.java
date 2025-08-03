package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class RRTDimension {
    public int dimension_name_length;
    public MultiString dimension_name_text;
    public int graduated_scale;
    public int nval;
    public int reserved;
    public RRTDimensionValue value;
    public int values_defined;

    public int get(IBitstream iBitstream) throws IOException {
        Util.trace(iBitstream.getpos(), 0, 0, "begin RRTDimension");
        this.dimension_name_length = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.dimension_name_length, "dimension_name_length (" + this.dimension_name_length + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure dimension_name_text");
        MultiString multiString = new MultiString();
        this.dimension_name_text = multiString;
        int i = multiString.get(iBitstream) + 0;
        int i2 = iBitstream.getbits(3);
        this.reserved = i2;
        if (i2 != 7) {
            Util.flerror("Const value mismatch for 'reserved'");
            i++;
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved, "reserved (" + this.reserved + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved, "reserved (" + this.reserved + ")");
        }
        this.graduated_scale = iBitstream.getbits(1);
        Util.trace(iBitstream.getpos() - 1, 1, this.graduated_scale, "graduated_scale (" + this.graduated_scale + ")");
        this.values_defined = iBitstream.getbits(4);
        Util.trace(iBitstream.getpos() - 4, 4, this.values_defined, "values_defined (" + this.values_defined + ")");
        this.nval = 0;
        while (this.nval < this.values_defined) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing RRTDimensionValue value");
            RRTDimensionValue rRTDimensionValue = new RRTDimensionValue();
            this.value = rRTDimensionValue;
            i += rRTDimensionValue.get(iBitstream);
            this.nval++;
        }
        Util.trace(iBitstream.getpos(), 0, 0, "end RRTDimension");
        return i;
    }

    public int put(IBitstream iBitstream) throws IOException {
        iBitstream.putbits(this.dimension_name_length, 8);
        int i = 0;
        int iPut = this.dimension_name_text.put(iBitstream) + 0;
        this.reserved = 7;
        iBitstream.putbits(7, 3);
        iBitstream.putbits(this.graduated_scale, 1);
        iBitstream.putbits(this.values_defined, 4);
        while (true) {
            this.nval = i;
            if (this.nval >= this.values_defined) {
                return iPut;
            }
            iPut += this.value.put(iBitstream);
            i = this.nval + 1;
        }
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        this.dimension_name_length = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<dimension_name_length type=\"flUInt\" bitLen=\"8\">" + this.dimension_name_length + "</dimension_name_length>");
        } else {
            XML.WriteXmlElement("<dimension_name_length bitLen=\"8\">" + this.dimension_name_length + "</dimension_name_length>");
        }
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure dimension_name_text");
        this.dimension_name_text = new MultiString();
        XML.IntoAClass("dimension_name_text", 0);
        int iPutxml = this.dimension_name_text.putxml(iBitstream, z) + 0;
        XML.OutOfClass("</dimension_name_text>");
        int i = iBitstream.getbits(3);
        this.reserved = i;
        if (i != 7) {
            Util.flerror("Const value mismatch for 'reserved'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved type=\"flUInt\" bitLen=\"3\">" + this.reserved + "</reserved>");
            } else {
                XML.WriteXmlElement("<reserved bitLen=\"3\">" + this.reserved + "</reserved>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved type=\"flUInt\" bitLen=\"3\">" + this.reserved + "</reserved>");
            } else {
                XML.WriteXmlElement("<reserved bitLen=\"3\">" + this.reserved + "</reserved>");
            }
            Util.trace(iBitstream.getpos() - 3, 3, this.reserved, "reserved (" + this.reserved + ")");
        }
        this.graduated_scale = iBitstream.getbits(1);
        if (z) {
            XML.WriteXmlElement("<graduated_scale type=\"flUInt\" bitLen=\"1\">" + this.graduated_scale + "</graduated_scale>");
        } else {
            XML.WriteXmlElement("<graduated_scale bitLen=\"1\">" + this.graduated_scale + "</graduated_scale>");
        }
        this.values_defined = iBitstream.getbits(4);
        if (z) {
            XML.WriteXmlElement("<values_defined type=\"flUInt\" bitLen=\"4\">" + this.values_defined + "</values_defined>");
        } else {
            XML.WriteXmlElement("<values_defined bitLen=\"4\">" + this.values_defined + "</values_defined>");
        }
        this.nval = 0;
        while (this.nval < this.values_defined) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing RRTDimensionValue value");
            this.value = new RRTDimensionValue();
            XML.IntoAClass("value", 0);
            iPutxml += this.value.putxml(iBitstream, z);
            XML.OutOfClass("</value>");
            this.nval++;
        }
        return iPutxml;
    }
}
