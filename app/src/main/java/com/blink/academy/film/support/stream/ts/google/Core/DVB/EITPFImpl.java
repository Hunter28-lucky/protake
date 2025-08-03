package com.blink.academy.film.support.stream.ts.google.Core.DVB;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent;
import com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;

/* loaded from: classes.dex */
public class EITPFImpl extends SITableAbstractImpl implements EITPF {
    public boolean b_actual;
    public int original_network_id;
    public int service_id;
    public int transport_stream_id;
    public int version_number;
    public DVBEITEvent present_event = null;
    public DVBEITEvent following_event = null;
    public long interval_millis = 500;

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public DVBEITEvent getFollowingEvent() {
        return this.following_event;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public int getOrgNetworkId() {
        return this.original_network_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public DVBEITEvent getPresentEvent() {
        return this.present_event;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public int getServiceId() {
        return this.service_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return this.b_actual ? TableID.EVENT_INFORMATION_ACTUAL_PF : TableID.EVENT_INFORMATION_OTHER_PF;
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
        return (this.present_event == null || this.following_event == null) ? 1 : 2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public int getTransportStreamId() {
        return this.transport_stream_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public boolean isActual() {
        return this.b_actual;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return getTotalSectionNumber() > 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public void setFollowingEvent(DVBEITEvent dVBEITEvent) {
        this.following_event = dVBEITEvent;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public void setIsActual(boolean z) {
        this.b_actual = z;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public void setOrgNetworkId(int i) {
        this.original_network_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public void setPresentEvent(DVBEITEvent dVBEITEvent) {
        this.present_event = dVBEITEvent;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public void setServiceId(int i) {
        this.service_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public void setTransportStreamId(int i) {
        this.transport_stream_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF
    public void setVersionNumber(int i) {
        this.version_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public Section[] toSection() {
        BitOutputStream bitOutputStream;
        int totalSectionNumber = getTotalSectionNumber();
        Section[] sectionArr = new Section[totalSectionNumber];
        for (int i = 0; i < totalSectionNumber; i++) {
            int i2 = totalSectionNumber - 1;
            sectionArr[i] = SectionFactory.createDVBEITSection(this, this.service_id, i, i2);
            if (i == 0) {
                bitOutputStream = new BitOutputStream((this.present_event.getSizeInBytes() + 6) * 8);
                bitOutputStream.writeFromLSB(this.transport_stream_id, 16);
                bitOutputStream.writeFromLSB(this.original_network_id, 16);
                bitOutputStream.writeFromLSB(i2, 8);
                bitOutputStream.write(this.present_event.toByteArray());
            } else {
                bitOutputStream = new BitOutputStream((this.following_event.getSizeInBytes() + 6) * 8);
                bitOutputStream.writeFromLSB(this.transport_stream_id, 16);
                bitOutputStream.writeFromLSB(this.original_network_id, 16);
                bitOutputStream.writeFromLSB(i2, 8);
                bitOutputStream.write(this.following_event.toByteArray());
            }
            sectionArr[i].setPrivateData(bitOutputStream.toByteArray());
        }
        return sectionArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<EIT_PF>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(getTableID());
        sb.append("</table_id>\n");
        String str2 = (((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<service_id>" + this.service_id + "</service_id>\n") + MyUTIL.whiteSpaceStr(i2) + "<transport_stream_id>" + this.transport_stream_id + "</transport_stream_id>\n") + MyUTIL.whiteSpaceStr(i2) + "<original_network_id>" + this.original_network_id + "</original_network_id>\n";
        if (this.present_event != null) {
            str2 = ((str2 + MyUTIL.whiteSpaceStr(i2) + "<PresentEvent>\n") + this.present_event.toXMLString(i + 4)) + MyUTIL.whiteSpaceStr(i2) + "</PresentEvent>\n";
        }
        if (this.following_event != null) {
            str2 = ((str2 + MyUTIL.whiteSpaceStr(i2) + "<FollowingEvent>\n") + this.following_event.toXMLString(i + 4)) + MyUTIL.whiteSpaceStr(i2) + "</FollowingEvent>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</EIT_PF>\n";
    }
}
