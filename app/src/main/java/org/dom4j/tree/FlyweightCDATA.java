package org.dom4j.tree;

/* loaded from: classes2.dex */
public class FlyweightCDATA extends AbstractCDATA {
    public String text;

    public FlyweightCDATA(String str) {
        this.text = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }
}
