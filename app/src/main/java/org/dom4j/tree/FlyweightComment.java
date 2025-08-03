package org.dom4j.tree;

/* loaded from: classes2.dex */
public class FlyweightComment extends AbstractComment {
    public String text;

    public FlyweightComment(String str) {
        this.text = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }
}
