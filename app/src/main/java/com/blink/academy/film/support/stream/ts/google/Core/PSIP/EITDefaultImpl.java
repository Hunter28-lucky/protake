package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class EITDefaultImpl extends SITableAbstractImpl implements EIT {
    public int source_id;
    public int table_pid;
    public int version_number = 0;
    public List<EITEvent> events = new Vector();
    public long interval_millis = 500;

    public EITDefaultImpl(int i) {
        this.table_pid = 0;
        this.table_pid = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public boolean addEvent(EITEvent eITEvent) {
        this.events.add(eITEvent);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public boolean addEventAt(int i, EITEvent eITEvent) {
        if (i < 0 || i > this.events.size()) {
            return false;
        }
        this.events.add(i, eITEvent);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public EITEvent getEventAt(int i) {
        if (i < 0 || i >= this.events.size()) {
            return null;
        }
        return this.events.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public Iterator<EITEvent> getEvents() {
        return this.events.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public int getEventsLength() {
        Iterator<EITEvent> it = this.events.iterator();
        int sizeInBytes = 0;
        while (it.hasNext()) {
            sizeInBytes += it.next().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public int getNumEventsInSection() {
        return this.events.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public int getSourceId() {
        return this.source_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return TableID.EVENT_INFORMATION_TABLE;
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
        int i = 0;
        int i2 = 0;
        while (i < getNumEventsInSection()) {
            int sizeInBytes = 0;
            while (i < getNumEventsInSection() && getEventAt(i).getSizeInBytes() + sizeInBytes < 1010) {
                sizeInBytes += getEventAt(i).getSizeInBytes();
                i++;
            }
            i2++;
        }
        return i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return getTotalSectionNumber() > 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public void removeAllEvents() {
        List<EITEvent> list = this.events;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public boolean removeEvent(EITEvent eITEvent) {
        return this.events.remove(eITEvent);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public boolean removeEventAt(int i) {
        if (i < 0 || i >= this.events.size()) {
            return false;
        }
        this.events.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public boolean setEventAt(int i, EITEvent eITEvent) {
        if (i < 0 || i >= this.events.size()) {
            return false;
        }
        this.events.set(i, eITEvent);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
    public void setSourceId(int i) {
        this.source_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT
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
            sectionArr[i] = SectionFactory.createEITSection(this, this.source_id, i, totalSectionNumber - 1);
            int sizeInBytes = 0;
            int i3 = i2;
            while (i3 < getNumEventsInSection() && getEventAt(i3).getSizeInBytes() + sizeInBytes < 1010) {
                sizeInBytes += getEventAt(i3).getSizeInBytes();
                i3++;
            }
            BitOutputStream bitOutputStream = new BitOutputStream((sizeInBytes + 2) * 8);
            bitOutputStream.writeFromLSB(0, 8);
            bitOutputStream.writeFromLSB(getNumEventsInSection(), 8);
            while (i2 < i3) {
                bitOutputStream.write(getEventAt(i2).toByteArray());
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
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<EIT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(TableID.EVENT_INFORMATION_TABLE.getValue());
        sb.append("</table_id>\n");
        String str2 = (sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<source_id>" + this.source_id + "</source_id>\n";
        if (getNumEventsInSection() > 0) {
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<EITEventLoop>\n";
            Iterator<EITEvent> events = getEvents();
            while (events.hasNext()) {
                str3 = str3 + events.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</EITEventLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</EIT>\n";
    }
}
