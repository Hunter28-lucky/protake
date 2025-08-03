package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import androidx.core.app.NotificationCompat;
import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import com.google.mlkit.common.MlKitException;
import java.io.IOException;

/* loaded from: classes.dex */
public class EIT {
    public int CRC_32;
    public int current_next_indicator;
    public int en;
    public EITEvent event;
    public int last_section_number;
    public int num_events_in_section;
    public int private_indicator;
    public int protocol_version;
    public int reserved1;
    public int reserved2;
    public int section_length;
    public int section_number;
    public int section_syntax_indicator;
    public int source_id;
    public int table_id;
    public int version_number;

    public int get(IBitstream iBitstream) throws IOException {
        int i;
        Util.trace(iBitstream.getpos(), 0, 0, "begin EIT");
        int i2 = iBitstream.getbits(8);
        this.table_id = i2;
        if (i2 != 203) {
            Util.flerror("Const value mismatch for 'table_id'");
            Util.trace(iBitstream.getpos() - 8, 8, this.table_id, "table_id (" + this.table_id + ") [ERROR]");
            i = 1;
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.table_id, "table_id (" + this.table_id + ")");
            i = 0;
        }
        int i3 = iBitstream.getbits(1);
        this.section_syntax_indicator = i3;
        if (i3 != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            i++;
            Util.trace(iBitstream.getpos() - 1, 1, this.section_syntax_indicator, "section_syntax_indicator (" + this.section_syntax_indicator + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 1, 1, this.section_syntax_indicator, "section_syntax_indicator (" + this.section_syntax_indicator + ")");
        }
        int i4 = iBitstream.getbits(1);
        this.private_indicator = i4;
        if (i4 != 1) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            i++;
            Util.trace(iBitstream.getpos() - 1, 1, this.private_indicator, "private_indicator (" + this.private_indicator + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 1, 1, this.private_indicator, "private_indicator (" + this.private_indicator + ")");
        }
        int i5 = iBitstream.getbits(2);
        this.reserved1 = i5;
        if (i5 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            i++;
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ")");
        }
        this.section_length = iBitstream.getbits(12);
        Util.trace(iBitstream.getpos() - 12, 12, this.section_length, "section_length (" + this.section_length + ")");
        this.source_id = iBitstream.getbits(16);
        Util.trace(iBitstream.getpos() - 16, 16, this.source_id, "source_id (" + this.source_id + ")");
        int i6 = iBitstream.getbits(2);
        this.reserved2 = i6;
        if (i6 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.version_number = iBitstream.getbits(5);
        Util.trace(iBitstream.getpos() - 5, 5, this.version_number, "version_number (" + this.version_number + ")");
        int i7 = iBitstream.getbits(1);
        this.current_next_indicator = i7;
        if (i7 != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            i++;
            Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ")");
        }
        this.section_number = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ")");
        this.last_section_number = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.last_section_number, "last_section_number (" + this.last_section_number + ")");
        this.protocol_version = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.protocol_version, "protocol_version (" + this.protocol_version + ")");
        this.num_events_in_section = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.num_events_in_section, "num_events_in_section (" + this.num_events_in_section + ")");
        this.en = 0;
        while (this.en < this.num_events_in_section) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing EITEvent event");
            EITEvent eITEvent = new EITEvent();
            this.event = eITEvent;
            i += eITEvent.get(iBitstream);
            this.en++;
        }
        this.CRC_32 = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.CRC_32, "CRC_32 (" + this.CRC_32 + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "end EIT");
        return i;
    }

    public int put(IBitstream iBitstream) throws IOException {
        this.table_id = MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE;
        iBitstream.putbits(MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 8);
        this.section_syntax_indicator = 1;
        iBitstream.putbits(1, 1);
        this.private_indicator = 1;
        iBitstream.putbits(1, 1);
        this.reserved1 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.section_length, 12);
        iBitstream.putbits(this.source_id, 16);
        this.reserved2 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.version_number, 5);
        this.current_next_indicator = 1;
        iBitstream.putbits(1, 1);
        iBitstream.putbits(this.section_number, 8);
        iBitstream.putbits(this.last_section_number, 8);
        iBitstream.putbits(this.protocol_version, 8);
        iBitstream.putbits(this.num_events_in_section, 8);
        int iPut = 0;
        this.en = 0;
        while (this.en < this.num_events_in_section) {
            iPut += this.event.put(iBitstream);
            this.en++;
        }
        iBitstream.putbits(this.CRC_32, 32);
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        int iPutxml;
        int i = iBitstream.getbits(8);
        this.table_id = i;
        if (i != 203) {
            Util.flerror("Const value mismatch for 'table_id'");
            if (z) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"8\">" + this.table_id + "</table_id>");
            } else {
                XML.WriteXmlElement("<table_id bitLen=\"8\">" + this.table_id + "</table_id>");
            }
            iPutxml = 1;
        } else {
            if (z) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"8\">" + this.table_id + "</table_id>");
            } else {
                XML.WriteXmlElement("<table_id bitLen=\"8\">" + this.table_id + "</table_id>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.table_id, "table_id (" + this.table_id + ")");
            iPutxml = 0;
        }
        int i2 = iBitstream.getbits(1);
        this.section_syntax_indicator = i2;
        if (i2 != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"1\">" + this.section_syntax_indicator + "</section_syntax_indicator>");
            } else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"1\">" + this.section_syntax_indicator + "</section_syntax_indicator>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"1\">" + this.section_syntax_indicator + "</section_syntax_indicator>");
            } else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"1\">" + this.section_syntax_indicator + "</section_syntax_indicator>");
            }
            Util.trace(iBitstream.getpos() - 1, 1, this.section_syntax_indicator, "section_syntax_indicator (" + this.section_syntax_indicator + ")");
        }
        int i3 = iBitstream.getbits(1);
        this.private_indicator = i3;
        if (i3 != 1) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"1\">" + this.private_indicator + "</private_indicator>");
            } else {
                XML.WriteXmlElement("<private_indicator bitLen=\"1\">" + this.private_indicator + "</private_indicator>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"1\">" + this.private_indicator + "</private_indicator>");
            } else {
                XML.WriteXmlElement("<private_indicator bitLen=\"1\">" + this.private_indicator + "</private_indicator>");
            }
            Util.trace(iBitstream.getpos() - 1, 1, this.private_indicator, "private_indicator (" + this.private_indicator + ")");
        }
        int i4 = iBitstream.getbits(2);
        this.reserved1 = i4;
        if (i4 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            } else {
                XML.WriteXmlElement("<reserved1 bitLen=\"2\">" + this.reserved1 + "</reserved1>");
            }
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved1, "reserved1 (" + this.reserved1 + ")");
        }
        this.section_length = iBitstream.getbits(12);
        if (z) {
            XML.WriteXmlElement("<section_length type=\"flUInt\" bitLen=\"12\">" + this.section_length + "</section_length>");
        } else {
            XML.WriteXmlElement("<section_length bitLen=\"12\">" + this.section_length + "</section_length>");
        }
        this.source_id = iBitstream.getbits(16);
        if (z) {
            XML.WriteXmlElement("<source_id type=\"flUInt\" bitLen=\"16\">" + this.source_id + "</source_id>");
        } else {
            XML.WriteXmlElement("<source_id bitLen=\"16\">" + this.source_id + "</source_id>");
        }
        int i5 = iBitstream.getbits(2);
        this.reserved2 = i5;
        if (i5 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"2\">" + this.reserved2 + "</reserved2>");
            } else {
                XML.WriteXmlElement("<reserved2 bitLen=\"2\">" + this.reserved2 + "</reserved2>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"2\">" + this.reserved2 + "</reserved2>");
            } else {
                XML.WriteXmlElement("<reserved2 bitLen=\"2\">" + this.reserved2 + "</reserved2>");
            }
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.version_number = iBitstream.getbits(5);
        if (z) {
            XML.WriteXmlElement("<version_number type=\"flUInt\" bitLen=\"5\">" + this.version_number + "</version_number>");
        } else {
            XML.WriteXmlElement("<version_number bitLen=\"5\">" + this.version_number + "</version_number>");
        }
        int i6 = iBitstream.getbits(1);
        this.current_next_indicator = i6;
        if (i6 != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
            } else {
                XML.WriteXmlElement("<current_next_indicator bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
            } else {
                XML.WriteXmlElement("<current_next_indicator bitLen=\"1\">" + this.current_next_indicator + "</current_next_indicator>");
            }
            Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ")");
        }
        this.section_number = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"8\">" + this.section_number + "</section_number>");
        } else {
            XML.WriteXmlElement("<section_number bitLen=\"8\">" + this.section_number + "</section_number>");
        }
        this.last_section_number = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
        } else {
            XML.WriteXmlElement("<last_section_number bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
        }
        this.protocol_version = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<protocol_version type=\"flUInt\" bitLen=\"8\">" + this.protocol_version + "</protocol_version>");
        } else {
            XML.WriteXmlElement("<protocol_version bitLen=\"8\">" + this.protocol_version + "</protocol_version>");
        }
        this.num_events_in_section = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<num_events_in_section type=\"flUInt\" bitLen=\"8\">" + this.num_events_in_section + "</num_events_in_section>");
        } else {
            XML.WriteXmlElement("<num_events_in_section bitLen=\"8\">" + this.num_events_in_section + "</num_events_in_section>");
        }
        this.en = 0;
        while (this.en < this.num_events_in_section) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing EITEvent event");
            this.event = new EITEvent();
            XML.IntoAClass(NotificationCompat.CATEGORY_EVENT, 0);
            iPutxml += this.event.putxml(iBitstream, z);
            XML.OutOfClass("</event>");
            this.en++;
        }
        this.CRC_32 = iBitstream.getbits(32);
        if (z) {
            XML.WriteXmlElement("<CRC_32 type=\"flUInt\" bitLen=\"32\">" + this.CRC_32 + "</CRC_32>");
        } else {
            XML.WriteXmlElement("<CRC_32 bitLen=\"32\">" + this.CRC_32 + "</CRC_32>");
        }
        return iPutxml;
    }
}
