package com.blink.academy.film.support.stream.ts.google.Test;

import com.blink.academy.film.support.stream.ts.google.API.PSI.PAT;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram;
import com.blink.academy.film.support.stream.ts.google.API.SITableFactory;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jcodec.codecs.mjpeg.JpegConst;

/* loaded from: classes.dex */
public class TestPatSection {
    public static void main(String[] strArr) throws IOException {
        PAT patCreatePAT = SITableFactory.createPAT(15, 2748);
        PATProgram pATProgramCreatePATProgram = SITableFactory.createPATProgram(192, JpegConst.RST0);
        PATProgram pATProgramCreatePATProgram2 = SITableFactory.createPATProgram(224, 240);
        patCreatePAT.addProgram(pATProgramCreatePATProgram);
        patCreatePAT.addProgram(pATProgramCreatePATProgram2);
        for (Section section : patCreatePAT.toSection()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("temp", false);
                fileOutputStream.write(section.getSectionBytes());
                fileOutputStream.close();
                new com.blink.academy.film.support.stream.ts.google.flavor.Generated.PAT().get(new BuffBitstream("temp", 0));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
