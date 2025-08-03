package com.blink.academy.film.support.stream.ts.google.Test;

import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCTChannel;
import com.blink.academy.film.support.stream.ts.google.API.SITableFactory;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.ServiceType;
import com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream;
import com.umeng.analytics.pro.o;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class TestTVCTSection {
    public static void main(String[] strArr) throws IOException {
        TVCT tvctCreateTVCT = SITableFactory.createTVCT(5, 2748);
        char[] charArray = new String("prog1").toCharArray();
        ServiceType serviceType = ServiceType.ATSC_DIGITAL_TELEVISION;
        TVCTChannel tVCTChannelCreateTVCTChannel = SITableFactory.createTVCTChannel(charArray, 11, 1, 1, o.a.l, 53, serviceType, 1281);
        TVCTChannel tVCTChannelCreateTVCTChannel2 = SITableFactory.createTVCTChannel(new String("prog2").toCharArray(), 9, 1, 1, 2305, 101, serviceType, 1282);
        tvctCreateTVCT.addChannel(tVCTChannelCreateTVCTChannel);
        tvctCreateTVCT.addChannel(tVCTChannelCreateTVCTChannel2);
        for (Section section : tvctCreateTVCT.toSection()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("temp", false);
                fileOutputStream.write(section.getSectionBytes());
                fileOutputStream.close();
                new com.blink.academy.film.support.stream.ts.google.flavor.Generated.TVCT().get(new BuffBitstream("temp", 0));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
