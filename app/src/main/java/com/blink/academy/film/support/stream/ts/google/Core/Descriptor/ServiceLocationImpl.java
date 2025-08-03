package com.blink.academy.film.support.stream.ts.google.Core.Descriptor;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.StreamType;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class ServiceLocationImpl implements DC_ServiceLocation {
    public int PCR_PID;
    public List<ServiceElement> elements = new Vector();

    public class ServiceElement {
        public int ISO_639_language_code;
        public int elementary_PID;
        public StreamType stream_type;

        public ServiceElement(StreamType streamType, int i, int i2) {
            this.stream_type = streamType;
            this.elementary_PID = i;
            this.ISO_639_language_code = i2;
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public boolean addElement(StreamType streamType, int i, int i2) {
        return this.elements.add(new ServiceElement(streamType, i, i2));
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public boolean addElementAt(int i, StreamType streamType, int i2, int i3) {
        if (i < 0 || i > this.elements.size()) {
            return false;
        }
        this.elements.add(i, new ServiceElement(streamType, i2, i3));
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public int getElementaryPidAt(int i) {
        if (i < 0 || i >= this.elements.size()) {
            return -1;
        }
        return this.elements.get(i).elementary_PID;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public int getElementsLength() {
        return getNumberElements() * 6;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public int getLanguageCodeAt(int i) {
        if (i < 0 || i >= this.elements.size()) {
            return -1;
        }
        return this.elements.get(i).ISO_639_language_code;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorContent
    public String getNameString() {
        return "Service_Location";
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public int getNumberElements() {
        return this.elements.size();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public int getPCR_PID() {
        return this.PCR_PID;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return getElementsLength() + 3;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public StreamType getStreamTypeAt(int i) {
        return (i < 0 || i >= this.elements.size()) ? StreamType.ISO_IEC_Reserved : this.elements.get(i).stream_type;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public void removeAllElements() {
        List<ServiceElement> list = this.elements;
        list.remove(list);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public boolean removeElementAt(int i) {
        if (i < 0 || i >= this.elements.size()) {
            return false;
        }
        this.elements.remove(i);
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation
    public boolean setElementAt(int i, StreamType streamType, int i2, int i3) {
        if (i < 0 || i >= this.elements.size()) {
            return false;
        }
        this.elements.set(i, new ServiceElement(streamType, i2, i3));
        return true;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(255, 3);
        bitOutputStream.writeFromLSB(this.PCR_PID, 13);
        bitOutputStream.writeFromLSB(getNumberElements(), 8);
        if (getNumberElements() > 0) {
            for (ServiceElement serviceElement : this.elements) {
                bitOutputStream.writeFromLSB(serviceElement.stream_type.getValue(), 8);
                bitOutputStream.writeFromLSB(255, 3);
                bitOutputStream.writeFromLSB(serviceElement.elementary_PID, 13);
                bitOutputStream.writeFromLSB(serviceElement.ISO_639_language_code, 24);
            }
        }
        return bitOutputStream.toByteArray();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation
    public String toXMLString(int i) {
        String str = new String() + MyUTIL.whiteSpaceStr(i) + "<PCR_PID>" + this.PCR_PID + "</PCR_PID>\n";
        if (getNumberElements() > 0) {
            for (ServiceElement serviceElement : this.elements) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                int i2 = i + 2;
                sb.append(MyUTIL.whiteSpaceStr(i2));
                sb.append("<stream_type>");
                sb.append(serviceElement.stream_type);
                sb.append("</stream_type>\n");
                str = (sb.toString() + MyUTIL.whiteSpaceStr(i2) + "<elementary_PID>" + serviceElement.elementary_PID + "</elementary_PID>\n") + MyUTIL.whiteSpaceStr(i2) + "<ISO_639_language_code>" + serviceElement.ISO_639_language_code + "</ISO_639_language_code>\n";
            }
        }
        return str;
    }
}
