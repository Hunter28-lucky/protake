package org.dom4j.tree;

import org.dom4j.Comment;

/* loaded from: classes2.dex */
public abstract class AbstractComment extends AbstractCharacterData implements Comment {
    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 8;
    }

    public String toString() {
        return super.toString() + " [Comment: \"" + getText() + "\"]";
    }
}
