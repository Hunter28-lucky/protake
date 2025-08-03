package org.dom4j.tree;

/* loaded from: classes2.dex */
public class FlyweightEntity extends AbstractEntity {
    public String name;
    public String text;

    public FlyweightEntity(String str, String str2) {
        this.name = str;
        this.text = str2;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return this.name;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }
}
