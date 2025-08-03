package com.blink.academy.film.support.stream.ts.google.API;

import com.blink.academy.film.support.stream.ts.google.Core.SectionDefaultImpl;

/* loaded from: classes.dex */
public class SectionFactory {
    public static Section createBATSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }

    public static Section createCVCTSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }

    public static Section createDVBEITSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }

    public static Section createEITSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }

    public static Section createETTSection(SITable sITable, int i) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        return sectionDefaultImpl;
    }

    public static Section createMGTSection(SITable sITable) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(0);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(0);
        sectionDefaultImpl.setLastSectionNumber(0);
        return sectionDefaultImpl;
    }

    public static Section createNITSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }

    public static Section createPATSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(0);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }

    public static Section createPMTSection(SITable sITable, int i) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(0);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(0);
        sectionDefaultImpl.setLastSectionNumber(0);
        return sectionDefaultImpl;
    }

    public static Section createRRTSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i | 65280);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }

    public static Section createSDTSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }

    public static Section createSTTSection(SITable sITable) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(0);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(0);
        sectionDefaultImpl.setLastSectionNumber(0);
        return sectionDefaultImpl;
    }

    public static Section createTVCTSection(SITable sITable, int i, int i2, int i3) {
        SectionDefaultImpl sectionDefaultImpl = new SectionDefaultImpl(sITable, 1);
        sectionDefaultImpl.setPrivateIndicator(1);
        sectionDefaultImpl.setReserved1(3);
        sectionDefaultImpl.setTableIdExtension(i);
        sectionDefaultImpl.setReserved2(3);
        sectionDefaultImpl.setVersionNumber(sITable.getTableVersion());
        sectionDefaultImpl.setCurrentNextIndicator(1);
        sectionDefaultImpl.setSectionNumber(i2);
        sectionDefaultImpl.setLastSectionNumber(i3);
        return sectionDefaultImpl;
    }
}
