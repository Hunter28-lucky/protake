package org.dom4j.tree;

import org.dom4j.QName;

/* loaded from: classes2.dex */
public class FlyweightAttribute extends AbstractAttribute {
    private QName qname;
    public String value;

    public FlyweightAttribute(QName qName, String str) {
        this.qname = qName;
        this.value = str;
    }

    @Override // org.dom4j.Attribute
    public QName getQName() {
        return this.qname;
    }

    @Override // org.dom4j.Attribute
    public String getValue() {
        return this.value;
    }
}
