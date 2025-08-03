package org.dom4j.tree;

import java.util.Map;

/* loaded from: classes2.dex */
public class FlyweightProcessingInstruction extends AbstractProcessingInstruction {
    public String target;
    public String text;
    public Map<String, String> values;

    public FlyweightProcessingInstruction(String str, String str2) {
        this.target = str;
        this.text = str2;
        this.values = parseValues(str2);
    }

    @Override // org.dom4j.ProcessingInstruction
    public String getTarget() {
        return this.target;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }
}
