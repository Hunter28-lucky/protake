package com.blink.academy.film.support.stream.ts.google.Core.DVB;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class SDTServiceImpl implements SDTService {
    public int EIT_present_following_flag;
    public int EIT_schedule_flag;
    public int free_CA_mode;
    public int running_status;
    public int service_id;
    public List<Descriptor> descs = new Vector();
    public long interval_millis = 500;

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

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public int getEitPfFlag() {
        return this.EIT_present_following_flag;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public int getEitSchedFlag() {
        return this.EIT_schedule_flag;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public int getFreeCaMode() {
        return this.free_CA_mode;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public int getRunningStatus() {
        return this.running_status;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public int getServiceId() {
        return this.service_id;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getDescriptorsLength() + 5;
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

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorMethod
    public boolean setDescriptorAt(int i, Descriptor descriptor) {
        if (i < 0 || i >= this.descs.size()) {
            return false;
        }
        this.descs.set(i, descriptor);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public void setEitPfFlag(int i) {
        this.EIT_present_following_flag = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public void setEitSchedFlag(int i) {
        this.EIT_schedule_flag = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public void setFreeCaMode(int i) {
        this.free_CA_mode = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public void setRunningStatus(int i) {
        this.running_status = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService
    public void setServiceId(int i) {
        this.service_id = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(this.service_id, 16);
        bitOutputStream.writeFromLSB(0, 6);
        bitOutputStream.writeFromLSB(this.EIT_schedule_flag, 1);
        bitOutputStream.writeFromLSB(this.EIT_present_following_flag, 1);
        bitOutputStream.writeFromLSB(this.running_status, 3);
        bitOutputStream.writeFromLSB(this.free_CA_mode, 1);
        bitOutputStream.writeFromLSB(getDescriptorsLength(), 12);
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
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<SDTService>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i2 = i + 2;
        sb.append(MyUTIL.whiteSpaceStr(i2));
        sb.append("<service_id>");
        sb.append(this.service_id);
        sb.append("</service_id>\n");
        String str2 = (((sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<EIT_schedule_flag>" + this.EIT_schedule_flag + "</EIT_schedule_flag>\n") + MyUTIL.whiteSpaceStr(i2) + "<EIT_pf_flag>" + this.EIT_present_following_flag + "</EIT_pf_flag>\n") + MyUTIL.whiteSpaceStr(i2) + "<running_status>" + this.running_status + "</running_status>\n") + MyUTIL.whiteSpaceStr(i2) + "<free_CA_mode>" + this.free_CA_mode + "</free_CA_mode>\n";
        if (getDescriptorSize() > 0) {
            Iterator<Descriptor> descriptors = getDescriptors();
            String str3 = str2 + MyUTIL.whiteSpaceStr(i2) + "<DescriptorLoop>\n";
            while (descriptors.hasNext()) {
                str3 = str3 + descriptors.next().toXMLString(i + 4);
            }
            str2 = str3 + MyUTIL.whiteSpaceStr(i2) + "</DescriptorLoop>\n";
        }
        return str2 + MyUTIL.whiteSpaceStr(i) + "</SDTService>\n";
    }
}
