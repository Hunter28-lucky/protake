package com.blink.academy.film.support.stream.ts.google.Core;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.CRC32.Crc32Mpeg2;

/* loaded from: classes.dex */
public class SectionDefaultImpl implements Section {
    public SITable correspondent_table;
    public int section_syntax_indicator;
    public TableID table_id;
    public int private_indicator = 0;
    public int reserved1 = 0;
    public int table_id_extension = 0;
    public int reserved2 = 0;
    public int version_number = 0;
    public int current_next_indicator = 0;
    public int section_number = 0;
    public int last_section_number = 0;
    public byte[] private_data_bytes = null;

    public SectionDefaultImpl(SITable sITable, int i) {
        this.correspondent_table = null;
        this.table_id = TableID.FORBIDDEN;
        this.section_syntax_indicator = 0;
        sITable.getClass();
        this.correspondent_table = sITable;
        this.table_id = sITable.getTableID();
        this.section_syntax_indicator = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public long getCRC32() {
        if (getSectionSyntaxIndicator() == 0) {
            throw new UnsupportedOperationException();
        }
        BitOutputStream bitOutputStream = new BitOutputStream(getSectionSizeInByte() * 8);
        bitOutputStream.writeFromLSB(this.table_id.getValue(), 8);
        bitOutputStream.writeFromLSB(this.section_syntax_indicator, 1);
        bitOutputStream.writeFromLSB(this.private_indicator, 1);
        bitOutputStream.writeFromLSB(this.reserved1, 2);
        bitOutputStream.writeFromLSB(getPrivateSectionLength(), 12);
        bitOutputStream.writeFromLSB(this.table_id_extension, 16);
        bitOutputStream.writeFromLSB(this.reserved2, 2);
        bitOutputStream.writeFromLSB(this.version_number, 5);
        bitOutputStream.writeFromLSB(this.current_next_indicator, 1);
        bitOutputStream.writeFromLSB(this.section_number, 8);
        bitOutputStream.writeFromLSB(this.last_section_number, 8);
        bitOutputStream.write(getPrivateDataBytes());
        Crc32Mpeg2 crc32Mpeg2 = new Crc32Mpeg2();
        crc32Mpeg2.update(bitOutputStream.toByteArray(), 0, r0.length - 4);
        return crc32Mpeg2.getValue();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getCurrentNextIndicator() {
        if (getSectionSyntaxIndicator() != 0) {
            return this.current_next_indicator;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getLastSectionNumber() {
        if (getSectionSyntaxIndicator() != 0) {
            return this.last_section_number;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public byte[] getPrivateDataBytes() {
        return this.private_data_bytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getPrivateIndicator() {
        return this.private_indicator;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getPrivateSectionLength() {
        int i = this.section_syntax_indicator != 0 ? 9 : 0;
        byte[] bArr = this.private_data_bytes;
        return bArr != null ? i + bArr.length : i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getReserved1() {
        return this.reserved1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getReserved2() {
        return this.reserved2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public SITable getSITable() {
        return this.correspondent_table;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public byte[] getSectionBytes() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSectionSizeInByte() * 8);
        bitOutputStream.writeFromLSB(this.table_id.getValue(), 8);
        bitOutputStream.writeFromLSB(this.section_syntax_indicator, 1);
        bitOutputStream.writeFromLSB(this.private_indicator, 1);
        bitOutputStream.writeFromLSB(this.reserved1, 2);
        bitOutputStream.writeFromLSB(getPrivateSectionLength(), 12);
        if (getSectionSyntaxIndicator() != 0) {
            bitOutputStream.writeFromLSB(this.table_id_extension, 16);
            bitOutputStream.writeFromLSB(this.reserved2, 2);
            bitOutputStream.writeFromLSB(this.version_number, 5);
            bitOutputStream.writeFromLSB(this.current_next_indicator, 1);
            bitOutputStream.writeFromLSB(this.section_number, 8);
            bitOutputStream.writeFromLSB(this.last_section_number, 8);
        }
        bitOutputStream.write(getPrivateDataBytes());
        if (getSectionSyntaxIndicator() != 0) {
            Crc32Mpeg2 crc32Mpeg2 = new Crc32Mpeg2();
            crc32Mpeg2.update(bitOutputStream.toByteArray(), 0, r2.length - 4);
            bitOutputStream.writeFromLSB((int) (crc32Mpeg2.getValue() & (-1)), 32);
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getSectionNumber() {
        if (getSectionSyntaxIndicator() != 0) {
            return this.section_number;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getSectionSizeInByte() {
        return getPrivateSectionLength() + 3;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getSectionSyntaxIndicator() {
        return this.section_syntax_indicator;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public TableID getTableID() {
        return this.table_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getTableIdExtension() {
        if (getSectionSyntaxIndicator() != 0) {
            return this.table_id_extension;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public int getVersionNumber() {
        if (getSectionSyntaxIndicator() != 0) {
            return this.version_number;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setCurrentNextIndicator(int i) {
        if (getSectionSyntaxIndicator() == 0) {
            throw new UnsupportedOperationException();
        }
        this.current_next_indicator = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setLastSectionNumber(int i) {
        if (getSectionSyntaxIndicator() == 0) {
            throw new UnsupportedOperationException();
        }
        this.last_section_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setPrivateData(byte[] bArr) {
        this.private_data_bytes = bArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setPrivateIndicator(int i) {
        this.private_indicator = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setReserved1(int i) {
        this.reserved1 = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setReserved2(int i) {
        this.reserved2 = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setSectionNumber(int i) {
        if (getSectionSyntaxIndicator() == 0) {
            throw new UnsupportedOperationException();
        }
        this.section_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setTableIdExtension(int i) {
        if (getSectionSyntaxIndicator() == 0) {
            throw new UnsupportedOperationException();
        }
        this.table_id_extension = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Section
    public void setVersionNumber(int i) {
        if (getSectionSyntaxIndicator() == 0) {
            throw new UnsupportedOperationException();
        }
        this.version_number = i;
    }
}
