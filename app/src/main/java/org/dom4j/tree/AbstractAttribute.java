package org.dom4j.tree;

import org.dom4j.Attribute;
import org.dom4j.Namespace;

/* loaded from: classes2.dex */
public abstract class AbstractAttribute extends AbstractNode implements Attribute {
    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return getQName().getName();
    }

    @Override // org.dom4j.Attribute
    public Namespace getNamespace() {
        return getQName().getNamespace();
    }

    @Override // org.dom4j.Attribute
    public String getNamespacePrefix() {
        return getQName().getNamespacePrefix();
    }

    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 2;
    }

    @Override // org.dom4j.Attribute
    public String getQualifiedName() {
        return getQName().getQualifiedName();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return getValue();
    }

    @Override // org.dom4j.Attribute
    public void setValue(String str) {
        throw new UnsupportedOperationException("This Attribute is read only and cannot be changed");
    }

    public String toString() {
        return super.toString() + " [Attribute: name " + getQualifiedName() + " value \"" + getValue() + "\"]";
    }
}
