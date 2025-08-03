package com.blink.academy.film.support.stream.ts.google.API;

/* loaded from: classes.dex */
public interface Section {
    long getCRC32();

    int getCurrentNextIndicator();

    int getLastSectionNumber();

    byte[] getPrivateDataBytes();

    int getPrivateIndicator();

    int getPrivateSectionLength();

    int getReserved1();

    int getReserved2();

    SITable getSITable();

    byte[] getSectionBytes();

    int getSectionNumber();

    int getSectionSizeInByte();

    int getSectionSyntaxIndicator();

    TableID getTableID();

    int getTableIdExtension();

    int getVersionNumber();

    void setCurrentNextIndicator(int i);

    void setLastSectionNumber(int i);

    void setPrivateData(byte[] bArr);

    void setPrivateIndicator(int i);

    void setReserved1(int i);

    void setReserved2(int i);

    void setSectionNumber(int i);

    void setTableIdExtension(int i);

    void setVersionNumber(int i);
}
