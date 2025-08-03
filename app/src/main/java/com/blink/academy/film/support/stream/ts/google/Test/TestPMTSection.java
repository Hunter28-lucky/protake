package com.blink.academy.film.support.stream.ts.google.Test;

import androidx.core.view.InputDeviceCompat;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PMT;
import com.blink.academy.film.support.stream.ts.google.API.SITableFactory;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.API.StreamType;
import com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class TestPMTSection {
    public static void main(String[] strArr) throws IOException {
        PMT pmtCreatePMT = SITableFactory.createPMT(1002, 3, 101, 2748);
        pmtCreatePMT.addStream(SITableFactory.createPMTStream(StreamType.ISO_IEC_11172_Video, InputDeviceCompat.SOURCE_DPAD));
        pmtCreatePMT.addStream(SITableFactory.createPMTStream(StreamType.ISO_IEC_11172_Audio, 514));
        for (Section section : pmtCreatePMT.toSection()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("temp", false);
                fileOutputStream.write(section.getSectionBytes());
                fileOutputStream.close();
                new BuffBitstream("temp", 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
