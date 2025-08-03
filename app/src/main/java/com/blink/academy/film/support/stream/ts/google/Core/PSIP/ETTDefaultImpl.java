package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MultiString.MultipleStringStructure;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;

/* loaded from: classes.dex */
public class ETTDefaultImpl extends SITableAbstractImpl implements ETT {
    public long ETM_id;
    public int ETT_table_id_extension;
    public MultipleStringStructure extended_text_message;
    public int table_pid;
    public int version_number = 0;
    public long interval_millis = 3000;

    public ETTDefaultImpl(int i) {
        this.table_pid = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public long getETMId() {
        return this.ETM_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public int getETTTableIdExtension() {
        return this.ETT_table_id_extension;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public MultipleStringStructure getExtendedTextMessage() {
        return this.extended_text_message;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public int getExtendedTextMessageSize() {
        MultipleStringStructure multipleStringStructure = this.extended_text_message;
        if (multipleStringStructure == null) {
            return 0;
        }
        return multipleStringStructure.getSizeInBytes();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.EVENT_TEXT_TABLE;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return this.table_pid;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return getVersionNumber();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        return 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return false;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public void setETMId(long j) {
        this.ETM_id = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public void setETTTableIdExtension(int i) {
        this.ETT_table_id_extension = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public void setExtendedTextMessage(MultipleStringStructure multipleStringStructure) {
        this.extended_text_message = multipleStringStructure;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        int totalSectionNumber = getTotalSectionNumber();
        Section[] sectionArr = new Section[totalSectionNumber];
        for (int i = 0; i < totalSectionNumber; i++) {
            sectionArr[i] = SectionFactory.createETTSection(this, this.ETT_table_id_extension);
            BitOutputStream bitOutputStream = new BitOutputStream((getExtendedTextMessageSize() + 5) * 8);
            bitOutputStream.writeFromLSB(0, 8);
            bitOutputStream.writeFromLSB((int) this.ETM_id, 32);
            MultipleStringStructure multipleStringStructure = this.extended_text_message;
            if (multipleStringStructure != null) {
                bitOutputStream.write(multipleStringStructure.toByteArray());
            }
            sectionArr[i].setPrivateData(bitOutputStream.toByteArray());
        }
        return sectionArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<ETT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(TableID.EVENT_INFORMATION_TABLE.getValue());
        sb.append("</table_id>\n");
        String str2 = ((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<ETT_table_id_extension>" + this.ETT_table_id_extension + "</ETT_table_id_extension>\n") + MyUTIL.whiteSpaceStr(i2) + "<ETM_id>" + this.ETM_id + "</ETM_id>\n";
        if (this.extended_text_message != null) {
            str2 = str2 + this.extended_text_message.toXMLString(i2);
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</ETT>\n";
    }
}
