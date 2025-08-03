package com.blink.academy.film.support.stream.ts.google.Core.DVB;

import com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent;
import com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class EITScheduleImpl extends SITableAbstractImpl implements EITSchedule {
    public boolean b_actual;
    public List<DVBEITEvent> events = new Vector();
    public long interval_millis = 500;
    public int original_network_id;
    public int service_id;
    public int transport_stream_id;
    public int version_number;

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public boolean addEvent(DVBEITEvent dVBEITEvent) {
        return this.events.add(dVBEITEvent);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public DVBEITEvent getEventAt(int i) {
        return this.events.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public Iterator<DVBEITEvent> getEvents() {
        return this.events.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public int getOrgNetworkId() {
        return this.original_network_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public int getServiceId() {
        return this.service_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return this.b_actual ? TableID.EVENT_INFORMATION_ACTUAL_SCHEDULE_0 : TableID.EVENT_INFORMATION_OTHER_SCHEDULE_0;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return 18;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        return 0;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public int getTransportStreamId() {
        return this.transport_stream_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public boolean isActual() {
        return this.b_actual;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return false;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public int numEvents() {
        return this.events.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public boolean removeEvent(DVBEITEvent dVBEITEvent) {
        return this.events.remove(dVBEITEvent);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public void setIsActual(boolean z) {
        this.b_actual = z;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public void setOrgNetworkId(int i) {
        this.original_network_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public void setServiceId(int i) {
        this.service_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public void setTransportStreamId(int i) {
        this.transport_stream_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        return null;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<EIT_Schedule>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(getTableID());
        sb.append("</table_id>\n");
        String str2 = (((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<service_id>" + this.service_id + "</service_id>\n") + MyUTIL.whiteSpaceStr(i2) + "<transport_stream_id>" + this.transport_stream_id + "</transport_stream_id>\n") + MyUTIL.whiteSpaceStr(i2) + "<original_network_id>" + this.original_network_id + "</original_network_id>\n";
        if (numEvents() > 0) {
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<EventScheduleLoop>\n";
            Iterator<DVBEITEvent> events = getEvents();
            while (events.hasNext()) {
                str3 = str3 + events.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</EventScheduleLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</EIT_Schedule>\n";
    }
}
