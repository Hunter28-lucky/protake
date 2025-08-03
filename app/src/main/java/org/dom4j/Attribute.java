package org.dom4j;

/* loaded from: classes2.dex */
public interface Attribute extends Node {
    Namespace getNamespace();

    String getNamespacePrefix();

    QName getQName();

    String getQualifiedName();

    String getValue();

    void setValue(String str);
}
