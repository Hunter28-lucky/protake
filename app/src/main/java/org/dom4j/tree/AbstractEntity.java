package org.dom4j.tree;

import org.dom4j.Entity;

/* loaded from: classes2.dex */
public abstract class AbstractEntity extends AbstractNode implements Entity {
    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 5;
    }

    public String toString() {
        return super.toString() + " [Entity: &" + getName() + ";]";
    }
}
