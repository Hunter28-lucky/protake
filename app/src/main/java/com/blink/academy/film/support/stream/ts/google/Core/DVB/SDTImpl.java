package com.blink.academy.film.support.stream.ts.google.Core.DVB;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.DVB.SDT;
import com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.SectionFactory;
import com.blink.academy.film.support.stream.ts.google.API.TableID;
import com.blink.academy.film.support.stream.ts.google.Core.SITableAbstractImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class SDTImpl extends SITableAbstractImpl implements SDT {
    public boolean b_actual;
    public int original_network_id;
    public int transport_stream_id;
    public int version_number;
    public List<SDTService> services = new Vector();
    public List<Descriptor> descs = new Vector();
    public long interval_millis = 500;

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public boolean addService(SDTService sDTService) {
        return this.services.add(sDTService);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public long getIntervalMillis() {
        return this.interval_millis;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public int getOrgNetworkId() {
        return this.original_network_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public SDTService getServiceAt(int i) {
        return this.services.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public Iterator<SDTService> getServices() {
        return this.services.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public TableID getTableID() {
        return this.b_actual ? TableID.SERVICE_DESCRIPTION_TABLE_ACTUAL : TableID.SERVICE_DESCRIPTION_TABLE_OTHER;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTablePID() {
        return 17;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public int getTableVersion() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public int getTotalSectionNumber() {
        int i = 0;
        int i2 = 0;
        while (i < numServices()) {
            int sizeInBytes = 0;
            while (i < numServices() && getServiceAt(i).getSizeInBytes() + sizeInBytes < 1009) {
                sizeInBytes += getServiceAt(i).getSizeInBytes();
                i++;
            }
            i2++;
        }
        return i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public int getTransportStreamId() {
        return this.transport_stream_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public int getVersionNumber() {
        return this.version_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public boolean isActual() {
        return this.b_actual;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.SectionRepresentation
    public boolean isMultiSection() {
        return getTotalSectionNumber() > 1;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public int numServices() {
        return this.services.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public boolean removeAllServices() {
        List<SDTService> list = this.services;
        return list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public boolean removeService(SDTService sDTService) {
        return this.services.remove(sDTService);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.SITable
    public void setIntervalMillis(long j) {
        this.interval_millis = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public void setIsActual(boolean z) {
        this.b_actual = z;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public void setOrgNetworkId(int i) {
        this.original_network_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
    public void setTransportStreamId(int i) {
        this.transport_stream_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDT
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
            sectionArr[i] = SectionFactory.createSDTSection(this, this.transport_stream_id, i, totalSectionNumber - 1);
            int sizeInBytes = 0;
            int i3 = i2;
            while (i3 < numServices() && getServiceAt(i3).getSizeInBytes() + sizeInBytes < 1009) {
                sizeInBytes += getServiceAt(i3).getSizeInBytes();
                i3++;
            }
            BitOutputStream bitOutputStream = new BitOutputStream((sizeInBytes + 3) * 8);
            bitOutputStream.writeFromLSB(this.original_network_id, 16);
            bitOutputStream.writeFromLSB(0, 8);
            while (i2 < i3) {
                bitOutputStream.write(getServiceAt(i2).toByteArray());
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
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<SDT>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<table_id>");
        sb.append(getTableID());
        sb.append("</table_id>\n");
        String str2 = ((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<version_number>" + this.version_number + "</version_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<transport_stream_id>" + this.transport_stream_id + "</transport_stream_id>\n") + MyUTIL.whiteSpaceStr(i2) + "<original_network_id>" + this.original_network_id + "</original_network_id>\n";
        if (numServices() > 0) {
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<SDTServiceLoop>\n";
            Iterator<SDTService> services = getServices();
            while (services.hasNext()) {
                str3 = str3 + services.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</SDTServiceLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</SDT>\n";
    }
}
