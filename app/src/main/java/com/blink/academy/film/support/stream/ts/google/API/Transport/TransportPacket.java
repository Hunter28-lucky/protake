package com.blink.academy.film.support.stream.ts.google.API.Transport;

import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;

/* loaded from: classes.dex */
public interface TransportPacket extends ByteRepresentation {
    byte[] getAdaptationFieldByte();

    int getAdaptationFieldControl();

    int getAvailableDataSizeInBytes();

    int getContinuityCounter();

    byte[] getDataByte();

    int getPID();

    int getPayloadUnitStartIndicator();

    int getSyncByte();

    int getTransportErrorIndicator();

    int getTransportPriority();

    int getTransportScramblingControl();

    void setAdaptationFieldByte(byte[] bArr);

    void setAdaptationFieldControl(int i);

    void setContinuityCounter(int i);

    void setDataByte(byte[] bArr);

    void setPID(int i);

    void setPayloadUnitStartIndicator(int i);

    void setSyncByte(int i);

    void setTransportErrorIndicator(int i);

    void setTransportPriority(int i);

    void setTransportScramblingControl(int i);
}
