package com.blink.academy.film.support.stream.ts.google.Test;

import com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT;
import com.blink.academy.film.support.stream.ts.google.API.SITableFactory;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.TableType;
import com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class TestMGTSection {
    public static void main(String[] strArr) throws IOException {
        TVCT tvctCreateTVCT = SITableFactory.createTVCT(5, 2748);
        MGT mgtCreateMGT = SITableFactory.createMGT(18);
        mgtCreateMGT.addTable(SITableFactory.createMGTTable(TableType.Terrestrial_VCT_with_current_next_indicator_1, tvctCreateTVCT.getTablePID(), tvctCreateTVCT.getTableVersion(), 0));
        Section[] section = mgtCreateMGT.toSection();
        for (Section section2 : section) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("temp", false);
                fileOutputStream.write(section2.getSectionBytes());
                fileOutputStream.close();
                new com.blink.academy.film.support.stream.ts.google.flavor.Generated.MGT().get(new BuffBitstream("temp", 0));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
