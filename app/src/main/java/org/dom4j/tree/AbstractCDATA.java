package org.dom4j.tree;

import org.dom4j.CDATA;

/* loaded from: classes2.dex */
public abstract class AbstractCDATA extends AbstractCharacterData implements CDATA {
    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 4;
    }

    public String toString() {
        return super.toString() + " [CDATA: \"" + getText() + "\"]";
    }
}
