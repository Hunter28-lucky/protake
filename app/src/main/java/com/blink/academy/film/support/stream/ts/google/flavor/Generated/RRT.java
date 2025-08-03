package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import com.blink.academy.film.support.stream.ts.google.flavor.XML;
import com.google.mlkit.common.MlKitException;
import java.io.IOException;

/* loaded from: classes.dex */
public class RRT {
    public int CRC_32;
    public int current_next_indicator;
    public Descriptor descriptor;
    public int descriptors_length;
    public RRTDimension dimension;
    public int dimensions_defined;
    public int last_section_number;
    public int ndim;
    public int private_indicator;
    public int protocol_version;
    public int rating_region;
    public int rating_region_name_length;
    public MultiString rating_region_name_text;
    public int remain_desc_bytes;
    public int reserved1;
    public int reserved2;
    public int reserved3;
    public int reserved4;
    public int section_length;
    public int section_number;
    public int section_syntax_indicator;
    public int table_id;
    public int version_number;

    public int get(IBitstream iBitstream) throws IOException {
        int i;
        Util.trace(iBitstream.getpos(), 0, 0, "begin RRT");
        int i2 = iBitstream.getbits(8);
        this.table_id = i2;
        if (i2 != 202) {
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
        int i6 = iBitstream.getbits(8);
        this.reserved2 = i6;
        if (i6 != 255) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
            Util.trace(iBitstream.getpos() - 8, 8, this.reserved2, "reserved2 (" + this.reserved2 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 8, 8, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.rating_region = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.rating_region, "rating_region (" + this.rating_region + ")");
        int i7 = iBitstream.getbits(2);
        this.reserved3 = i7;
        if (i7 != 3) {
            Util.flerror("Const value mismatch for 'reserved3'");
            i++;
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved3, "reserved3 (" + this.reserved3 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved3, "reserved3 (" + this.reserved3 + ")");
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
        this.section_number = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.section_number, "section_number (" + this.section_number + ")");
        this.last_section_number = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.last_section_number, "last_section_number (" + this.last_section_number + ")");
        this.protocol_version = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.protocol_version, "protocol_version (" + this.protocol_version + ")");
        this.rating_region_name_length = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.rating_region_name_length, "rating_region_name_length (" + this.rating_region_name_length + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure rating_region_name_text");
        MultiString multiString = new MultiString();
        this.rating_region_name_text = multiString;
        int i9 = i + multiString.get(iBitstream);
        this.dimensions_defined = iBitstream.getbits(8);
        Util.trace(iBitstream.getpos() - 8, 8, this.dimensions_defined, "dimensions_defined (" + this.dimensions_defined + ")");
        this.ndim = 0;
        while (this.ndim < this.dimensions_defined) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing RRTDimension dimension");
            RRTDimension rRTDimension = new RRTDimension();
            this.dimension = rRTDimension;
            i9 += rRTDimension.get(iBitstream);
            this.ndim++;
        }
        int i10 = iBitstream.getbits(6);
        this.reserved4 = i10;
        if (i10 != 63) {
            Util.flerror("Const value mismatch for 'reserved4'");
            i9++;
            Util.trace(iBitstream.getpos() - 6, 6, this.reserved4, "reserved4 (" + this.reserved4 + ") [ERROR]");
        } else {
            Util.trace(iBitstream.getpos() - 6, 6, this.reserved4, "reserved4 (" + this.reserved4 + ")");
        }
        this.descriptors_length = iBitstream.getbits(10);
        Util.trace(iBitstream.getpos() - 10, 10, this.descriptors_length, "descriptors_length (" + this.descriptors_length + ")");
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            Descriptor descriptor = new Descriptor();
            this.descriptor = descriptor;
            i9 += descriptor.get(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        this.CRC_32 = iBitstream.getbits(32);
        Util.trace(iBitstream.getpos() - 32, 32, this.CRC_32, "CRC_32 (" + this.CRC_32 + ")");
        Util.trace(iBitstream.getpos(), 0, 0, "end RRT");
        return i9;
    }

    public int put(IBitstream iBitstream) throws IOException {
        this.table_id = MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED;
        iBitstream.putbits(MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 8);
        this.section_syntax_indicator = 1;
        iBitstream.putbits(1, 1);
        this.private_indicator = 1;
        iBitstream.putbits(1, 1);
        this.reserved1 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.section_length, 12);
        this.reserved2 = 255;
        iBitstream.putbits(255, 8);
        iBitstream.putbits(this.rating_region, 8);
        this.reserved3 = 3;
        iBitstream.putbits(3, 2);
        iBitstream.putbits(this.version_number, 5);
        this.current_next_indicator = 1;
        iBitstream.putbits(1, 1);
        iBitstream.putbits(this.section_number, 8);
        iBitstream.putbits(this.last_section_number, 8);
        iBitstream.putbits(this.protocol_version, 8);
        iBitstream.putbits(this.rating_region_name_length, 8);
        int i = 0;
        int iPut = this.rating_region_name_text.put(iBitstream) + 0;
        iBitstream.putbits(this.dimensions_defined, 8);
        while (true) {
            this.ndim = i;
            if (this.ndim >= this.dimensions_defined) {
                break;
            }
            iPut += this.dimension.put(iBitstream);
            i = this.ndim + 1;
        }
        this.reserved4 = 63;
        iBitstream.putbits(63, 6);
        iBitstream.putbits(this.descriptors_length, 10);
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            iPut += this.descriptor.put(iBitstream);
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
        }
        iBitstream.putbits(this.CRC_32, 32);
        return iPut;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        int i;
        int i2 = iBitstream.getbits(8);
        this.table_id = i2;
        if (i2 != 202) {
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
        int i6 = iBitstream.getbits(8);
        this.reserved2 = i6;
        if (i6 != 255) {
            Util.flerror("Const value mismatch for 'reserved2'");
            i++;
            if (z) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"8\">" + this.reserved2 + "</reserved2>");
            } else {
                XML.WriteXmlElement("<reserved2 bitLen=\"8\">" + this.reserved2 + "</reserved2>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"8\">" + this.reserved2 + "</reserved2>");
            } else {
                XML.WriteXmlElement("<reserved2 bitLen=\"8\">" + this.reserved2 + "</reserved2>");
            }
            Util.trace(iBitstream.getpos() - 8, 8, this.reserved2, "reserved2 (" + this.reserved2 + ")");
        }
        this.rating_region = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<rating_region type=\"flUInt\" bitLen=\"8\">" + this.rating_region + "</rating_region>");
        } else {
            XML.WriteXmlElement("<rating_region bitLen=\"8\">" + this.rating_region + "</rating_region>");
        }
        int i7 = iBitstream.getbits(2);
        this.reserved3 = i7;
        if (i7 != 3) {
            Util.flerror("Const value mismatch for 'reserved3'");
            i++;
            if (z) {
                XML.WriteXmlElement("<reserved3 type=\"flUInt\" bitLen=\"2\">" + this.reserved3 + "</reserved3>");
            } else {
                XML.WriteXmlElement("<reserved3 bitLen=\"2\">" + this.reserved3 + "</reserved3>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved3 type=\"flUInt\" bitLen=\"2\">" + this.reserved3 + "</reserved3>");
            } else {
                XML.WriteXmlElement("<reserved3 bitLen=\"2\">" + this.reserved3 + "</reserved3>");
            }
            Util.trace(iBitstream.getpos() - 2, 2, this.reserved3, "reserved3 (" + this.reserved3 + ")");
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
        this.rating_region_name_length = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<rating_region_name_length type=\"flUInt\" bitLen=\"8\">" + this.rating_region_name_length + "</rating_region_name_length>");
        } else {
            XML.WriteXmlElement("<rating_region_name_length bitLen=\"8\">" + this.rating_region_name_length + "</rating_region_name_length>");
        }
        Util.trace(iBitstream.getpos(), 0, 0, "processing MultipleStringStructure rating_region_name_text");
        this.rating_region_name_text = new MultiString();
        XML.IntoAClass("rating_region_name_text", 0);
        int iPutxml = i + this.rating_region_name_text.putxml(iBitstream, z);
        XML.OutOfClass("</rating_region_name_text>");
        this.dimensions_defined = iBitstream.getbits(8);
        if (z) {
            XML.WriteXmlElement("<dimensions_defined type=\"flUInt\" bitLen=\"8\">" + this.dimensions_defined + "</dimensions_defined>");
        } else {
            XML.WriteXmlElement("<dimensions_defined bitLen=\"8\">" + this.dimensions_defined + "</dimensions_defined>");
        }
        this.ndim = 0;
        while (this.ndim < this.dimensions_defined) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing RRTDimension dimension");
            this.dimension = new RRTDimension();
            XML.IntoAClass(TypedValues.Custom.S_DIMENSION, 0);
            iPutxml += this.dimension.putxml(iBitstream, z);
            XML.OutOfClass("</dimension>");
            this.ndim++;
        }
        int i9 = iBitstream.getbits(6);
        this.reserved4 = i9;
        if (i9 != 63) {
            Util.flerror("Const value mismatch for 'reserved4'");
            iPutxml++;
            if (z) {
                XML.WriteXmlElement("<reserved4 type=\"flUInt\" bitLen=\"6\">" + this.reserved4 + "</reserved4>");
            } else {
                XML.WriteXmlElement("<reserved4 bitLen=\"6\">" + this.reserved4 + "</reserved4>");
            }
        } else {
            if (z) {
                XML.WriteXmlElement("<reserved4 type=\"flUInt\" bitLen=\"6\">" + this.reserved4 + "</reserved4>");
            } else {
                XML.WriteXmlElement("<reserved4 bitLen=\"6\">" + this.reserved4 + "</reserved4>");
            }
            Util.trace(iBitstream.getpos() - 6, 6, this.reserved4, "reserved4 (" + this.reserved4 + ")");
        }
        this.descriptors_length = iBitstream.getbits(10);
        if (z) {
            XML.WriteXmlElement("<descriptors_length type=\"flUInt\" bitLen=\"10\">" + this.descriptors_length + "</descriptors_length>");
        } else {
            XML.WriteXmlElement("<descriptors_length bitLen=\"10\">" + this.descriptors_length + "</descriptors_length>");
        }
        this.remain_desc_bytes = this.descriptors_length;
        while (this.remain_desc_bytes > 0) {
            Util.trace(iBitstream.getpos(), 0, 0, "processing Descriptor descriptor");
            this.descriptor = new Descriptor();
            XML.IntoAClass("descriptor", 0);
            iPutxml += this.descriptor.putxml(iBitstream, z);
            XML.OutOfClass("</descriptor>");
            this.remain_desc_bytes -= this.descriptor._F_lengthof / 8;
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
