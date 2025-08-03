package com.blink.academy.film.support.stream.ts.google.Core.PSIP;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel;
import com.blink.academy.film.support.stream.ts.google.API.ServiceType;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class CVCTChannelDefaultImpl implements CVCTChannel {
    public char[] short_name = new char[7];
    public int major_channel_number = 0;
    public int minor_channel_number = 0;
    public int modulation_mode = 0;
    public long carrier_frequency = 0;
    public int channel_TSID = 0;
    public int program_number = 0;
    public int ETM_location = 0;
    public int access_controlled = 0;
    public int hidden = 0;
    public int path_select = 0;
    public int out_of_band = 0;
    public int hide_guide = 0;
    public ServiceType service_type = ServiceType.RESERVED;
    public int source_id = 0;
    public List<Descriptor> descs = new Vector();

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean addDescriptor(Descriptor descriptor) {
        this.descs.add(descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean addDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i > this.descs.size()) {
            return false;
        }
        this.descs.add(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getAccessControlled() {
        return this.access_controlled;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public long getCarrierFrequency() {
        return this.carrier_frequency;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getChannelTSID() {
        return this.channel_TSID;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public Descriptor getDescriptorAt(int i) {
        if (i < 0 || i >= this.descs.size()) {
            return null;
        }
        return this.descs.get(i);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public int getDescriptorSize() {
        return this.descs.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public Iterator<Descriptor> getDescriptors() {
        return this.descs.iterator();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public int getDescriptorsLength() {
        Iterator<Descriptor> it = this.descs.iterator();
        int sizeInBytes = 0;
        while (it.hasNext()) {
            sizeInBytes += it.next().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getETMLocation() {
        return this.ETM_location;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getHidden() {
        return this.hidden;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getHideGuide() {
        return this.hide_guide;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getMajorChannelNumber() {
        return this.major_channel_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getMinorChannelNumber() {
        return this.minor_channel_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getModulationMode() {
        return this.modulation_mode;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getOutOfBand() {
        return this.out_of_band;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getPathSelect() {
        return this.path_select;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getProgramNumber() {
        return this.program_number;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public ServiceType getServiceType() {
        return this.service_type;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public char[] getShortName() {
        return this.short_name;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getDescriptorsLength() + 32;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public int getSourceId() {
        return this.source_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public void removeAllDescriptors() {
        List<Descriptor> list = this.descs;
        list.removeAll(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean removeDescriptor(Descriptor descriptor) {
        return this.descs.remove(descriptor);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean removeDescriptorAt(int i) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setAccessControlled(int i) {
        this.access_controlled = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setCarrierFrequency(long j) {
        this.carrier_frequency = j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setChannelTSID(int i) {
        this.channel_TSID = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean setDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.set(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setETMLocation(int i) {
        this.ETM_location = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setHidden(int i) {
        this.hidden = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setHideGuide(int i) {
        this.hide_guide = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setMajorChannelNumber(int i) {
        this.major_channel_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setMinorChannelNumber(int i) {
        this.minor_channel_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setModulationMode(int i) {
        this.modulation_mode = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setOutOfBand(int i) {
        this.out_of_band = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setPathSelect(int i) {
        this.path_select = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setProgramNumber(int i) {
        this.program_number = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setServiceType(ServiceType serviceType) {
        this.service_type = serviceType;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setShortName(char[] cArr) {
        this.short_name = cArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel
    public void setSourceId(int i) {
        this.source_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        int i = 0;
        while (true) {
            char[] cArr = this.short_name;
            if (i >= cArr.length || i >= 7) {
                break;
            }
            bitOutputStream.write(cArr[i]);
            i++;
        }
        while (i < 7) {
            bitOutputStream.write((char) 0);
            i++;
        }
        bitOutputStream.writeFromLSB(255, 4);
        bitOutputStream.writeFromLSB(this.major_channel_number, 10);
        bitOutputStream.writeFromLSB(this.minor_channel_number, 10);
        bitOutputStream.writeFromLSB(this.modulation_mode, 8);
        bitOutputStream.writeFromLSB((int) this.carrier_frequency, 32);
        bitOutputStream.writeFromLSB(this.channel_TSID, 16);
        bitOutputStream.writeFromLSB(this.program_number, 16);
        bitOutputStream.writeFromLSB(this.ETM_location, 2);
        bitOutputStream.writeFromLSB(this.access_controlled, 1);
        bitOutputStream.writeFromLSB(this.hidden, 1);
        bitOutputStream.writeFromLSB(this.path_select, 1);
        bitOutputStream.writeFromLSB(this.out_of_band, 1);
        bitOutputStream.writeFromLSB(this.hide_guide, 1);
        bitOutputStream.writeFromLSB(255, 3);
        bitOutputStream.writeFromLSB(this.service_type.getValue(), 6);
        bitOutputStream.writeFromLSB(this.source_id, 16);
        bitOutputStream.writeFromLSB(255, 6);
        bitOutputStream.writeFromLSB(getDescriptorsLength(), 10);
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            while (descriptors.hasNext()) {
                bitOutputStream.write(descriptors.next().toByteArray());
            }
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<CVCTChannel>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<short_name>");
        sb.append(new String(this.short_name));
        sb.append("</short_name>\n");
        String str2 = (((((((((((((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<major_channel_number>" + this.major_channel_number + "</major_channel_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<minor_channel_number>" + this.minor_channel_number + "</minor_channel_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<modulation_mode>" + this.modulation_mode + "</modulation_mode>\n") + MyUTIL.whiteSpaceStr(i2) + "<carrier_frequency>" + this.carrier_frequency + "</carrier_frequency>\n") + MyUTIL.whiteSpaceStr(i2) + "<channel_TSID>" + this.channel_TSID + "</channel_TSID>\n") + MyUTIL.whiteSpaceStr(i2) + "<program_number>" + this.program_number + "</program_number>\n") + MyUTIL.whiteSpaceStr(i2) + "<ETM_location>" + this.ETM_location + "</ETM_location>\n") + MyUTIL.whiteSpaceStr(i2) + "<access_controlled>" + this.access_controlled + "</access_controlled>\n") + MyUTIL.whiteSpaceStr(i2) + "<hidden>" + this.hidden + "</hidden>\n") + MyUTIL.whiteSpaceStr(i2) + "<path_select>" + this.path_select + "</path_select>\n") + MyUTIL.whiteSpaceStr(i2) + "<out_of_band>" + this.out_of_band + "</out_of_band>\n") + MyUTIL.whiteSpaceStr(i2) + "<hidden>" + this.hide_guide + "</hidden>\n") + MyUTIL.whiteSpaceStr(i2) + "<service_type>" + this.service_type.getValue() + "</service_type>\n") + MyUTIL.whiteSpaceStr(i2) + "<source_id>" + this.source_id + "</source_id>\n";
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str3 = str3 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</CVCTChannel>\n";
    }
}
