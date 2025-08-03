package org.dom4j.io;

import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.XMLReader;

/* loaded from: classes2.dex */
class JAXPHelper {
    public static XMLReader createXMLReader(boolean z, boolean z2) throws Exception {
        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
        sAXParserFactoryNewInstance.setValidating(z);
        sAXParserFactoryNewInstance.setNamespaceAware(z2);
        return sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
    }
}
