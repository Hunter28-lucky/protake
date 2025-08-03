package org.dom4j.tree;

import org.dom4j.Element;

/* loaded from: classes2.dex */
public class DefaultComment extends FlyweightComment {
    private Element parent;

    public DefaultComment(String str) {
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
