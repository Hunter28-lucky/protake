package org.dom4j;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public interface Node extends Cloneable {
    Object clone();

    Document getDocument();

    String getName();

    short getNodeType();

    Element getParent();

    String getText();

    boolean isReadOnly();

    void setDocument(Document document);

    void setName(String str);

    void setParent(Element element);

    boolean supportsParent();

    void write(Writer writer) throws IOException;
}
