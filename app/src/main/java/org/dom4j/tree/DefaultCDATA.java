package org.dom4j.tree;

import org.dom4j.Element;

/* loaded from: classes2.dex */
public class DefaultCDATA extends FlyweightCDATA {
    private Element parent;

    public DefaultCDATA(String str) {
        super(str);
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
}
