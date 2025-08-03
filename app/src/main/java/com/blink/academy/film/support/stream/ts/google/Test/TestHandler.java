package com.blink.academy.film.support.stream.ts.google.Test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: XMLParsingTest.java */
/* loaded from: classes.dex */
class TestHandler extends DefaultHandler {
    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        System.out.println("characters: " + ((Object) cArr) + ", " + i + ", " + i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        System.out.println("endElement: " + str + ", " + str2 + ", " + str3);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        System.out.println("startElement: " + str + ", " + str2 + ", " + str3 + ", " + attributes);
    }
}
