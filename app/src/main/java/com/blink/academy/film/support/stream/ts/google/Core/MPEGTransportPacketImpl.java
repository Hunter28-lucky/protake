package com.blink.academy.film.support.stream.ts.google.Core;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket;

/* loaded from: classes.dex */
public class MPEGTransportPacketImpl implements TransportPacket {
    public int sync_byte = 0;
    public int transport_error_indicator = 0;
    public int payload_unit_start_indicator = 0;
    public int transport_priority = 0;
    public int PID = 0;
    public int transport_scrambling_control = 0;
    public int adaptation_field_control = 0;
    public int continuity_counter = 0;
    public int pointer_field = 0;
    public byte[] adaptation_field_byte = null;
    public byte[] data_byte = null;

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public byte[] getAdaptationFieldByte() {
        return this.adaptation_field_byte;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getAdaptationFieldControl() {
        return this.adaptation_field_control;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getAvailableDataSizeInBytes() {
        if (this.adaptation_field_control == 1) {
            return this.payload_unit_start_indicator == 1 ? (getSizeInBytes() - 4) - 1 : getSizeInBytes() - 4;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getContinuityCounter() {
        return this.continuity_counter;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public byte[] getDataByte() {
        return this.data_byte;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getPID() {
        return this.PID;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getPayloadUnitStartIndicator() {
        return this.payload_unit_start_indicator;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public int getSizeInBytes() {
        return TsConstants.TS_PACKET_SIZE;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getSyncByte() {
        return this.sync_byte;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getTransportErrorIndicator() {
        return this.transport_error_indicator;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getTransportPriority() {
        return this.transport_priority;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public int getTransportScramblingControl() {
        return this.transport_scrambling_control;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setAdaptationFieldByte(byte[] bArr) {
        this.adaptation_field_byte = bArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setAdaptationFieldControl(int i) {
        this.adaptation_field_control = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setContinuityCounter(int i) {
        this.continuity_counter = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setDataByte(byte[] bArr) {
        this.data_byte = bArr;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setPID(int i) {
        this.PID = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setPayloadUnitStartIndicator(int i) {
        this.payload_unit_start_indicator = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setSyncByte(int i) {
        this.sync_byte = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setTransportErrorIndicator(int i) {
        this.transport_error_indicator = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setTransportPriority(int i) {
        this.transport_priority = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.API.Transport.TransportPacket
    public void setTransportScramblingControl(int i) {
        this.transport_scrambling_control = i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation
    public byte[] toByteArray() {
        BitOutputStream bitOutputStream = new BitOutputStream(getSizeInBytes() * 8);
        bitOutputStream.writeFromLSB(this.sync_byte, 8);
        bitOutputStream.writeFromLSB(this.transport_error_indicator, 1);
        bitOutputStream.writeFromLSB(this.payload_unit_start_indicator, 1);
        bitOutputStream.writeFromLSB(this.transport_priority, 1);
        bitOutputStream.writeFromLSB(this.PID, 13);
        bitOutputStream.writeFromLSB(this.transport_scrambling_control, 2);
        bitOutputStream.writeFromLSB(this.adaptation_field_control, 2);
        bitOutputStream.writeFromLSB(this.continuity_counter, 4);
        if ((this.adaptation_field_control & 2) != 0) {
            byte[] bArr = this.adaptation_field_byte;
            if (bArr == null) {
                bitOutputStream.writeFromLSB(0, 8);
            } else {
                bitOutputStream.write(bArr);
            }
        }
        if ((this.adaptation_field_control & 1) != 0) {
            if (this.payload_unit_start_indicator == 1) {
                bitOutputStream.writeFromLSB(this.pointer_field, 8);
            }
            byte[] bArr2 = this.data_byte;
            if (bArr2 != null) {
                bitOutputStream.write(bArr2);
            }
        }
        return bitOutputStream.toByteArray();
    }
}
