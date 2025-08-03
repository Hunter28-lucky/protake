package org.dom4j;

import org.xml.sax.EntityResolver;

/* loaded from: classes2.dex */
public interface Document extends Branch {
    Document addComment(String str);

    Document addDocType(String str, String str2, String str3);

    Document addProcessingInstruction(String str, String str2);

    DocumentType getDocType();

    Element getRootElement();

    void setEntityResolver(EntityResolver entityResolver);

    void setXMLEncoding(String str);
}
