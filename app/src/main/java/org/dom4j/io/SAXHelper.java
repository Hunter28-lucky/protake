package org.dom4j.io;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes2.dex */
class SAXHelper {
    private static boolean loggedWarning = true;

    public static XMLReader createXMLReader(boolean z) throws SAXException {
        XMLReader xMLReaderCreateXMLReaderViaJAXP = createXMLReaderViaJAXP(z, true);
        if (xMLReaderCreateXMLReaderViaJAXP == null) {
            try {
                xMLReaderCreateXMLReaderViaJAXP = XMLReaderFactory.createXMLReader();
            } catch (Exception e2) {
                if (isVerboseErrorReporting()) {
                    System.out.println("Warning: Caught exception attempting to use SAX to load a SAX XMLReader ");
                    System.out.println("Warning: Exception was: " + e2);
                    System.out.println("Warning: I will print the stack trace then carry on using the default SAX parser");
                    e2.printStackTrace();
                }
                throw new SAXException(e2);
            }
        }
        if (xMLReaderCreateXMLReaderViaJAXP != null) {
            return xMLReaderCreateXMLReaderViaJAXP;
        }
        throw new SAXException("Couldn't create SAX reader");
    }

    public static XMLReader createXMLReaderViaJAXP(boolean z, boolean z2) {
        try {
            return JAXPHelper.createXMLReader(z, z2);
        } catch (Throwable th) {
            if (loggedWarning) {
                return null;
            }
            loggedWarning = true;
            if (!isVerboseErrorReporting()) {
                return null;
            }
            System.out.println("Warning: Caught exception attempting to use JAXP to load a SAX XMLReader");
            System.out.println("Warning: Exception was: " + th);
            th.printStackTrace();
            return null;
        }
    }

    public static boolean isVerboseErrorReporting() {
        try {
            String property = System.getProperty("org.dom4j.verbose");
            if (property != null) {
                property.equalsIgnoreCase("true");
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static boolean setParserFeature(XMLReader xMLReader, String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        try {
            xMLReader.setFeature(str, z);
            return true;
        } catch (SAXNotRecognizedException | SAXNotSupportedException unused) {
            return false;
        }
    }

    public static boolean setParserProperty(XMLReader xMLReader, String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        try {
            xMLReader.setProperty(str, obj);
            return true;
        } catch (SAXNotRecognizedException | SAXNotSupportedException unused) {
            return false;
        }
    }
}
