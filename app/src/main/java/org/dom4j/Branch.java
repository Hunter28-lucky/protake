package org.dom4j;

import java.util.List;

/* loaded from: classes2.dex */
public interface Branch extends Node {
    Element addElement(QName qName);

    List<Node> content();

    Node node(int i) throws IndexOutOfBoundsException;

    int nodeCount();
}
