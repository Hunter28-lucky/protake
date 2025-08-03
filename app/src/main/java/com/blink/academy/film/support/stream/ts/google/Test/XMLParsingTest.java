package com.blink.academy.film.support.stream.ts.google.Test;

import com.blink.academy.film.support.stream.ts.google.API.PSI.PAT;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram;
import com.blink.academy.film.support.stream.ts.google.API.SITableFactory;
import java.io.IOException;
import java.io.StringReader;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes.dex */
public class XMLParsingTest {
    public static void main(String[] strArr) throws SAXException, IOException {
        PAT patCreatePAT = SITableFactory.createPAT(15, 2748);
        PATProgram pATProgramCreatePATProgram = SITableFactory.createPATProgram(192, JpegConst.RST0);
        PATProgram pATProgramCreatePATProgram2 = SITableFactory.createPATProgram(224, 240);
        patCreatePAT.addProgram(pATProgramCreatePATProgram);
        patCreatePAT.addProgram(pATProgramCreatePATProgram2);
        patCreatePAT.toXMLString(0);
        try {
            XMLReader xMLReaderCreateXMLReader = XMLReaderFactory.createXMLReader();
            xMLReaderCreateXMLReader.setContentHandler(new TestHandler());
            xMLReaderCreateXMLReader.parse(new InputSource(new StringReader(patCreatePAT.toXMLString(0))));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
