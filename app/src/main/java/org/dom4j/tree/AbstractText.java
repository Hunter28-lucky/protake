package org.dom4j.tree;

import org.dom4j.Text;

/* loaded from: classes2.dex */
public abstract class AbstractText extends AbstractCharacterData implements Text {
    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 3;
    }

    public String toString() {
        return super.toString() + " [Text: \"" + getText() + "\"]";
    }
}
