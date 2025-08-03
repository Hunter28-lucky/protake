package org.dom4j.tree;

/* loaded from: classes2.dex */
public class FlyweightText extends AbstractText {
    public String text;

    public FlyweightText(String str) {
        this.text = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }
}
