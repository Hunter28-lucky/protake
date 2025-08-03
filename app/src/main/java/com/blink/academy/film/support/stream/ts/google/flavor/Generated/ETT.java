package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import com.google.mlkit.common.MlKitException;
import java.io.IOException;

/* loaded from: classes.dex */
public class ETT {
    public int CRC_32;
    public int ETM_id;
    public int ETT_table_id_extension;
    public int current_next_indicator;
    public MultiString extended_text_message;
    public int last_section_number;
    public int private_indicator;
    public int protocol_version;
    public int reserved1;
    public int reserved2;
    public int section_length;
    public int section_number;
    public int section_syntax_indicator;
    public int table_id;
    public int version_number;

    public int get(IBitstream iBitstream) throws IOException {
        int i;
        Util.trace(iBitstream.getpos(), 0, 0, "begin ETT");
        int i2 = iBitstream.getbits(8);
        this.table_id = i2;
        if (i2 != 204) {
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
        int i6 = iBitstream.getbits(16);
        this.ETT_table_id_extension = i6;
        if (i6 != 0) {
            Util.flerror("Const value mismatch for 'ETT_table_id_extension'");
            i++;
            Util.trace(iBitstream.getpos() - 16, 16, this.ETT_table_id_extension, "ETT_table_id_extension (" + this.ETT_table_id_extension + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 16, 16, this.ETT_table_id_extension, "ETT_table_id_extension (" + this.ETT_table_id_extension + ")");
        }
        int i7 = iBitstream.getbits(2);
        this.reserved2 = i7;
        if (i7 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.version_number = iBitstream.getbits(5);
        Util.trace(iBitstream.getpos() - 5, 5, this.version_number, "version_number (" + this.version_number + ")");
        int i8 = iBitstream.getbits(1);
        this.current_next_indicator = i8;
        if (i8 != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            i++;
            Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 1, 1, this.current_next_indicator, "current_next_indicator (" + this.current_next_indicator + ")");
        }
        int i9 = iBitstream.getbits(8);
        this.section_number = i9;
        if (i9 != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            i++;
            Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ")");
        }
        int i10 = iBitstream.getbits(8);
        this.last_section_number = i10;
        if (i10 != 0) {
            Util.flerror("Const value mismatch for 'last_section_number'");
            i++;
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_number, "last_section_number (" + this.last_section_number + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_number, "last_section_number (" + this.last_section_number + ")");
        }
        this.protocol_version = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.protocol_version, "protocol_version (" + this.protocol_version + ")");
        this.ETM_id = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.ETM_id, "ETM_id (" + this.ETM_id + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure extended_text_message");
        MultiString multiString = new MultiString();
        this.extended_text_message = multiString;
        int i11 = i + multiString.get(iBitstream);
        this.CRC_32 = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.CRC_32, "CRC_32 (" + this.CRC_32 + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "end ETT");
        return i11;
    }

    public int put(IBitstream iBitstream) throws IOException {
        this.table_id = MlKitException.CODE_SCANNER_TASK_IN_PROGRESS;
        iBitstream.putbits(MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 8);
        this.section_syntax_indicator = 1;
        iBitstream.putbits(1, 1);
        this.private_indicator = 1;
        iBitstream.putbits(1, 1);
        this.reserved1 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.section_length, 12);
        this.ETT_table_id_extension = 0;
        iBitstream.putbits(0, 16);
        this.reserved2 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.version_number, 5);
        this.current_next_indicator = 1;
        iBitstream.putbits(1, 1);
        this.section_number = 0;
        iBitstream.putbits(0, 8);
        this.last_section_number = 0;
        iBitstream.putbits(0, 8);
        iBitstream.putbits(this.protocol_version, 8);
        iBitstream.putbits(this.ETM_id, 32);
        int iPut = this.extended_text_message.put(iBitstream) + 0;
        iBitstream.putbits(this.CRC_32, 32);
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        int i;
        int i2 = iBitstream.getbits(8);
        this.table_id = i2;
        if (i2 != 204) {
            Util.flerror("Const value mismatch for 'table_id'");
            if (z) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"8\">" + this.table_id + "</table_id>");
            } else {
                XML.WriteXmlElement("<table_id bitLen=\"8\">" + this.table_id + "</table_id>");
            }
            i = 1;
        } else {
            if (z) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"8\">" + this.table_id + "</table_id>");
            } else {
                XML.WriteXmlElement("<table_id bitLen=\"8\">" + this.table_id + "</table_id>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.table_id, "table_id (" + this.table_id + ")");
            i = 0;
        }
        int i3 = iBitstream.getbits(1);
        this.section_syntax_indicator = i3;
        if (i3 != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            i++;
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
        int i4 = iBitstream.getbits(1);
        this.private_indicator = i4;
        if (i4 != 1) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            i++;
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
        int i5 = iBitstream.getbits(2);
        this.reserved1 = i5;
        if (i5 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            i++;
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
        int i6 = iBitstream.getbits(16);
        this.ETT_table_id_extension = i6;
        if (i6 != 0) {
            Util.flerror("Const value mismatch for 'ETT_table_id_extension'");
            i++;
            if (z) {
                XML.WriteXmlElement("<ETT_table_id_extension type=\"flUInt\" bitLen=\"16\">" + this.ETT_table_id_extension + "</ETT_table_id_extension>");
            } else {
                XML.WriteXmlElement("<ETT_table_id_extension bitLen=\"16\">" + this.ETT_table_id_extension + "</ETT_table_id_extension>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<ETT_table_id_extension type=\"flUInt\" bitLen=\"16\">" + this.ETT_table_id_extension + "</ETT_table_id_extension>");
            } else {
                XML.WriteXmlElement("<ETT_table_id_extension bitLen=\"16\">" + this.ETT_table_id_extension + "</ETT_table_id_extension>");
            }
            Util.trace(iBitstream.getpos() - 16, 16, this.ETT_table_id_extension, "ETT_table_id_extension (" + this.ETT_table_id_extension + ")");
        }
        int i7 = iBitstream.getbits(2);
        this.reserved2 = i7;
        if (i7 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
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
        int i8 = iBitstream.getbits(1);
        this.current_next_indicator = i8;
        if (i8 != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            i++;
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
        int i9 = iBitstream.getbits(8);
        this.section_number = i9;
        if (i9 != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            i++;
            if (z) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"8\">" + this.section_number + "</section_number>");
            } else {
                XML.WriteXmlElement("<section_number bitLen=\"8\">" + this.section_number + "</section_number>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"8\">" + this.section_number + "</section_number>");
            } else {
                XML.WriteXmlElement("<section_number bitLen=\"8\">" + this.section_number + "</section_number>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ")");
        }
        int i10 = iBitstream.getbits(8);
        this.last_section_number = i10;
        if (i10 != 0) {
            Util.flerror("Const value mismatch for 'last_section_number'");
            i++;
            if (z) {
                XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
            } else {
                XML.WriteXmlElement("<last_section_number bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
            } else {
                XML.WriteXmlElement("<last_section_number bitLen=\"8\">" + this.last_section_number + "</last_section_number>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.last_section_number, "last_section_number (" + this.last_section_number + ")");
        }
        this.protocol_version = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<protocol_version type=\"flUInt\" bitLen=\"8\">" + this.protocol_version + "</protocol_version>");
        } else {
            XML.WriteXmlElement("<protocol_version bitLen=\"8\">" + this.protocol_version + "</protocol_version>");
        }
        this.ETM_id = iBitstream.getbits(32);
        if (z) {
            XML.WriteXmlElement("<ETM_id type=\"flUInt\" bitLen=\"32\">" + this.ETM_id + "</ETM_id>");
        } else {
            XML.WriteXmlElement("<ETM_id bitLen=\"32\">" + this.ETM_id + "</ETM_id>");
        }
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure extended_text_message");
        this.extended_text_message = new MultiString();
        XML.IntoAClass("extended_text_message", 0);
        int iPutxml = i + this.extended_text_message.putxml(iBitstream, z);
        XML.OutOfClass("</extended_text_message>");
        this.CRC_32 = iBitstream.getbits(32);
        if (z) {
            XML.WriteXmlElement("<CRC_32 type=\"flUInt\" bitLen=\"32\">" + this.CRC_32 + "</CRC_32>");
        } else {
            XML.WriteXmlElement("<CRC_32 bitLen=\"32\">" + this.CRC_32 + "</CRC_32>");
        }
        return iPutxml;
    }
}
