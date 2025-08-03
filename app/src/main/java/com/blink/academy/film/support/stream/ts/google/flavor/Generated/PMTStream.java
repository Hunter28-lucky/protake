package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class PMTStream {
    public int ES_info_length;
    public int _F_lengthof;
    public Descriptor descriptor;
    public int elementary_PID;
    public int remain_desc_bytes;
    public int stream_type;

    public int get(IBitstream iBitstream) throws IOException {
        Util.trace(iBitstream.getpos(), 0, 0, "begin PMTStream");
        this._F_lengthof = iBitstream.getpos();
        this.stream_type = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.stream_type, "stream_type (" + this.stream_type + ")");
        iBitstream.skipbits(3);
        this.elementary_PID = iBitstream.getbits(13);
        Util.trace(iBitstream.getpos() - 13, 13, this.elementary_PID, "elementary_PID (" + this.elementary_PID + ")");
        iBitstream.skipbits(4);
        this.ES_info_length = iBitstream.getbits(12);
        Util.trace(iBitstream.getpos() - 12, 12, this.ES_info_length, "ES_info_length (" + this.ES_info_length + ")");
        this.remain_desc_bytes = this.ES_info_length;
        int i = 0;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            Descriptor descriptor = new Descriptor();
            this.descriptor = descriptor;
            i += descriptor.get(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof;
        }
        this._F_lengthof = iBitstream.getpos() - this._F_lengthof;
        Util.trace(iBitstream.getpos(), 0, 0, "end PMTStream");
        return i;
    }

    public int put(IBitstream iBitstream) throws IOException {
        this._F_lengthof = iBitstream.getpos();
        iBitstream.putbits(this.stream_type, 8);
        iBitstream.skipbits(3);
        iBitstream.putbits(this.elementary_PID, 13);
        iBitstream.skipbits(4);
        iBitstream.putbits(this.ES_info_length, 12);
        this.remain_desc_bytes = this.ES_info_length;
        int iPut = 0;
        while (this.remain_desc_bytes > 0) {
            iPut += this.descriptor.put(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof;
        }
        this._F_lengthof = iBitstream.getpos() - this._F_lengthof;
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        this._F_lengthof = iBitstream.getpos();
        this.stream_type = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<stream_type type=\"flUInt\" bitLen=\"8\">" + this.stream_type + "</stream_type>");
        } else {
            XML.WriteXmlElement("<stream_type bitLen=\"8\">" + this.stream_type + "</stream_type>");
        }
        iBitstream.skipbits(3);
        this.elementary_PID = iBitstream.getbits(13);
        if (z) {
            XML.WriteXmlElement("<elementary_PID type=\"flUInt\" bitLen=\"13\">" + this.elementary_PID + "</elementary_PID>");
        } else {
            XML.WriteXmlElement("<elementary_PID bitLen=\"13\">" + this.elementary_PID + "</elementary_PID>");
        }
        iBitstream.skipbits(4);
        this.ES_info_length = iBitstream.getbits(12);
        if (z) {
            XML.WriteXmlElement("<ES_info_length type=\"flUInt\" bitLen=\"12\">" + this.ES_info_length + "</ES_info_length>");
        } else {
            XML.WriteXmlElement("<ES_info_length bitLen=\"12\">" + this.ES_info_length + "</ES_info_length>");
        }
        this.remain_desc_bytes = this.ES_info_length;
        int iPutxml = 0;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            this.descriptor = new Descriptor();
            XML.IntoAClass("descriptor", 0);
            iPutxml += this.descriptor.putxml(iBitstream, z);
            XML.OutOfClass("</descriptor>");
            this.remain_desc_bytes -= this.descriptor._F_lengthof;
        }
        this._F_lengthof = iBitstream.getpos() - this._F_lengthof;
        return iPutxml;
    }
}
