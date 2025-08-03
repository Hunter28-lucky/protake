package org.dom4j.tree;

import org.dom4j.Element;
import org.dom4j.QName;

/* loaded from: classes2.dex */
public class DefaultAttribute extends FlyweightAttribute {
    private Element parent;

    public DefaultAttribute(QName qName, String str) {
        super(qName, str);
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Element getParent() {
        return this.parent;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setParent(Element element) {
        this.parent = element;
    }

    @Override // org.dom4j.tree.AbstractAttribute, org.dom4j.Attribute
    public void setValue(String str) {
        this.value = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean supportsParent() {
        return true;
    }
}
