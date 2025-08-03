package com.blink.academy.film.support.stream.ts.google.API.Transport;

import com.blink.academy.film.support.stream.ts.google.API.SITable;
import com.blink.academy.film.support.stream.ts.google.API.Section;

/* loaded from: classes.dex */
public class TransportPacketGenerator {
    private static TransportPacket[] allocPackets(int i, int i2) {
        int i3;
        TransportPacket transportPacketCreateMPEGStartPacket = TransportPacketFactory.createMPEGStartPacket(i2);
        int availableDataSizeInBytes = i - transportPacketCreateMPEGStartPacket.getAvailableDataSizeInBytes();
        if (availableDataSizeInBytes > 0) {
            TransportPacket transportPacketCreateMPEGPacket = TransportPacketFactory.createMPEGPacket(i2);
            i3 = 1;
            while (availableDataSizeInBytes > 0) {
                availableDataSizeInBytes -= transportPacketCreateMPEGPacket.getAvailableDataSizeInBytes();
                i3++;
            }
        } else {
            i3 = 1;
        }
        TransportPacket[] transportPacketArr = new TransportPacket[i3];
        transportPacketArr[0] = transportPacketCreateMPEGStartPacket;
        for (int i4 = 1; i4 < i3; i4++) {
            transportPacketArr[i4] = TransportPacketFactory.createMPEGPacket(i2);
        }
        return transportPacketArr;
    }

    public static TransportPacket[] generatePackets(Section section) {
        byte[] sectionBytes = section.getSectionBytes();
        int length = sectionBytes.length;
        TransportPacket[] transportPacketArrAllocPackets = allocPackets(length, section.getSITable().getTablePID());
        int i = 0;
        for (int i2 = 0; i2 < transportPacketArrAllocPackets.length && i < length; i2++) {
            int availableDataSizeInBytes = transportPacketArrAllocPackets[i2].getAvailableDataSizeInBytes();
            byte[] bArr = new byte[availableDataSizeInBytes];
            for (int i3 = 0; i3 < availableDataSizeInBytes; i3++) {
                bArr[i3] = -1;
            }
            int i4 = 0;
            while (i4 < availableDataSizeInBytes && i < length) {
                bArr[i4] = sectionBytes[i];
                i4++;
                i++;
            }
            transportPacketArrAllocPackets[i2].setDataByte(bArr);
        }
        return transportPacketArrAllocPackets;
    }

    public static TransportPacket[] generatePackets(Section[] sectionArr) {
        return null;
    }

    public static TransportPacket[] generatePackets(SITable sITable) {
        return generatePackets(sITable.toSection());
    }
}
