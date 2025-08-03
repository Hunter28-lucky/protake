package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import java.io.IOException;

/* loaded from: classes.dex */
public class PATProgram {
    public int network_PID;
    public int program_map_PID;
    public int program_number;

    public int get(IBitstream iBitstream) throws IOException {
        Util.trace(iBitstream.getpos(), 0, 0, "begin PATProgram");
        this.program_number = iBitstream.getbits(16);
        Util.trace(iBitstream.getpos() - 16, 16, this.program_number, "program_number (" + this.program_number + ")");
        iBitstream.skipbits(3);
        if (this.program_number == 0) {
            this.network_PID = iBitstream.getbits(13);
            Util.trace(iBitstream.getpos() - 13, 13, this.network_PID, "network_PID (" + this.network_PID + ")");
        } else {
            this.program_map_PID = iBitstream.getbits(13);
            Util.trace(iBitstream.getpos() - 13, 13, this.program_map_PID, "program_map_PID (" + this.program_map_PID + ")");
        }
        Util.trace(iBitstream.getpos(), 0, 0, "end PATProgram");
        return 0;
    }

    public int put(IBitstream iBitstream) throws IOException {
        iBitstream.putbits(this.program_number, 16);
        iBitstream.skipbits(3);
        if (this.program_number == 0) {
            iBitstream.putbits(this.network_PID, 13);
            return 0;
        }
        iBitstream.putbits(this.program_map_PID, 13);
        return 0;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        this.program_number = iBitstream.getbits(16);
        if (z) {
            XML.WriteXmlElement("<program_number type=\"flUInt\" bitLen=\"16\">" + this.program_number + "</program_number>");
        } else {
            XML.WriteXmlElement("<program_number bitLen=\"16\">" + this.program_number + "</program_number>");
        }
        iBitstream.skipbits(3);
        if (this.program_number == 0) {
            this.network_PID = iBitstream.getbits(13);
            if (z) {
                XML.WriteXmlElement("<network_PID type=\"flUInt\" bitLen=\"13\">" + this.network_PID + "</network_PID>");
                return 0;
            }
            XML.WriteXmlElement("<network_PID bitLen=\"13\">" + this.network_PID + "</network_PID>");
            return 0;
        }
        this.program_map_PID = iBitstream.getbits(13);
        if (z) {
            XML.WriteXmlElement("<program_map_PID type=\"flUInt\" bitLen=\"13\">" + this.program_map_PID + "</program_map_PID>");
            return 0;
        }
        XML.WriteXmlElement("<program_map_PID bitLen=\"13\">" + this.program_map_PID + "</program_map_PID>");
        return 0;
    }
}
