package com.blink.academy.film.support.stream.ts.google.Core.PSI;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PAT;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class PATDefaultImpl extends SITableAbstractImpl implements PAT {
    public int transport_stream_id;
    public int version_number;
    public List<PATProgram> programs = new Vector();
    public long interval_millis = 100;

    public PATDefaultImpl(int i, int i2) {
        this.version_number = 0;
        this.transport_stream_id = 0;
        this.version_number = i;
        this.transport_stream_id = i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public boolean addProgram(PATProgram pATProgram) {
        this.programs.add(pATProgram);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public boolean addProgramAt(int i, PATProgram pATProgram) {
        if (i < 0 || i > this.programs.size()) {
            return false;
        }
        this.programs.add(i, pATProgram);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public PATProgram getProgramAt(int i) {
        if (i < 0 || i >= this.programs.size()) {
            return null;
        }
        return this.programs.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public int getProgramSize() {
        return this.programs.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public Iterator<PATProgram> getPrograms() {
        return this.programs.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.PROGRAM_ASSOCIATION_TABLE;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return 0;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return getVersionNumber();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        int i = 0;
        int i2 = 0;
        while (i < getProgramSize()) {
            int sizeInBytes = 0;
            while (i < getProgramSize() && getProgramAt(i).getSizeInBytes() + sizeInBytes < 1012) {
                sizeInBytes += getProgramAt(i).getSizeInBytes();
                i++;
            }
            i2++;
        }
        return i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public int getTransportStreamId() {
        return this.transport_stream_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return getTotalSectionNumber() > 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public void removeAllPrograms() {
        List<PATProgram> list = this.programs;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public boolean removeProgram(PATProgram pATProgram) {
        return this.programs.remove(pATProgram);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public boolean removeProgramAt(int i) {
        if (i < 0 || i >= this.programs.size()) {
            return false;
        }
        this.programs.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public boolean setProgramAt(int i, PATProgram pATProgram) {
        if (i < 0 || i >= this.programs.size()) {
            return false;
        }
        this.programs.set(i, pATProgram);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public void setTransportStreamId(int i) {
        this.transport_stream_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSI.PAT
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        int totalSectionNumber = getTotalSectionNumber();
        Section[] sectionArr = new Section[totalSectionNumber];
        int i = 0;
        int i2 = 0;
        while (i < totalSectionNumber) {
            sectionArr[i] = SectionFactory.createPATSection(this, this.transport_stream_id, i, totalSectionNumber - 1);
            int sizeInBytes = 0;
            int i3 = i2;
            while (i3 < getProgramSize() && getProgramAt(i3).getSizeInBytes() + sizeInBytes < 1012) {
                sizeInBytes += getProgramAt(i3).getSizeInBytes();
                i3++;
            }
            BitOutputStream bitOutputStream = new BitOutputStream(sizeInBytes * 8);
            while (i2 < i3) {
                bitOutputStream.write(getProgramAt(i2).toByteArray());
                i2++;
            }
            sectionArr[i].setPrivateData(bitOutputStream.toByteArray());
            i++;
            i2 = i3;
        }
        return sectionArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<PAT_section>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(TableID.PROGRAM_ASSOCIATION_TABLE.getValue());
        sb.append("</table_id>\n");
        String str2 = (sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<transport_stream_id>" + this.transport_stream_id + "</transport_stream_id>\n") + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n";
        if (getProgramSize() > 0) {
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<ProgramLoop>\n";
            Iterator<PATProgram> programs = getPrograms();
            while (programs.hasNext()) {
                str3 = str3 + programs.next().toXMLString(i);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</ProgramLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</PAT_section>\n";
    }
}
