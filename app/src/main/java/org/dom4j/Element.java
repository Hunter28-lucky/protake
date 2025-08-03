package org.dom4j;

/* loaded from: classes2.dex */
public interface Element extends Branch {
    void add(Namespace namespace);

    Element addAttribute(QName qName, String str);

    Element addCDATA(String str);

    Element addComment(String str);

    Element addEntity(String str, String str2);

    Element addProcessingInstruction(String str, String str2);

    Element addText(String str);

    Attribute attribute(int i);

    Attribute attribute(String str);

    int attributeCount();

    Namespace getNamespace();

    QName getQName();

    String getQualifiedName();
}
