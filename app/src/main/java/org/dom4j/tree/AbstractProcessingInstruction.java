package org.dom4j.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.dom4j.ProcessingInstruction;

/* loaded from: classes2.dex */
public abstract class AbstractProcessingInstruction extends AbstractNode implements ProcessingInstruction {
    private String getValue(StringTokenizer stringTokenizer) {
        String strNextToken = stringTokenizer.nextToken();
        StringBuilder sb = new StringBuilder();
        while (stringTokenizer.hasMoreTokens() && !strNextToken.equals("'") && !strNextToken.equals("\"")) {
            strNextToken = stringTokenizer.nextToken();
        }
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken2 = stringTokenizer.nextToken();
            if (strNextToken.equals(strNextToken2)) {
                break;
            }
            sb.append(strNextToken2);
        }
        return sb.toString();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return getTarget();
    }

    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 7;
    }

    public Map<String, String> parseValues(String str) {
        HashMap map = new HashMap();
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ='\"", true);
        while (stringTokenizer.hasMoreTokens()) {
            String name = getName(stringTokenizer);
            if (stringTokenizer.hasMoreTokens()) {
                map.put(name, getValue(stringTokenizer));
            }
        }
        return map;
    }

    public String toString() {
        return super.toString() + " [ProcessingInstruction: &" + getName() + ";]";
    }

    private String getName(StringTokenizer stringTokenizer) {
        StringBuilder sb = new StringBuilder(stringTokenizer.nextToken());
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.equals("=")) {
                break;
            }
            sb.append(strNextToken);
        }
        return sb.toString().trim();
    }
}
