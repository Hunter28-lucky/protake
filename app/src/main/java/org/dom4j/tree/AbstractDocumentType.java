package org.dom4j.tree;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.dom4j.DocumentType;
import org.dom4j.dtd.Decl;

/* loaded from: classes2.dex */
public abstract class AbstractDocumentType extends AbstractNode implements DocumentType {
    public String asXML() {
        boolean z;
        StringBuilder sb = new StringBuilder("<!DOCTYPE ");
        sb.append(getElementName());
        String publicID = getPublicID();
        if (publicID == null || publicID.length() <= 0) {
            z = false;
        } else {
            sb.append(" PUBLIC \"");
            sb.append(publicID);
            sb.append("\"");
            z = true;
        }
        String systemID = getSystemID();
        if (systemID != null && systemID.length() > 0) {
            if (!z) {
                sb.append(" SYSTEM");
            }
            sb.append(" \"");
            sb.append(systemID);
            sb.append("\"");
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 10;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        List<Decl> internalDeclarations = getInternalDeclarations();
        if (internalDeclarations == null || internalDeclarations.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Decl> it = internalDeclarations.iterator();
        if (it.hasNext()) {
            sb.append(it.next().toString());
            while (it.hasNext()) {
                Decl next = it.next();
                sb.append("\n");
                sb.append(next.toString());
            }
        }
        return sb.toString();
    }

    public String toString() {
        return super.toString() + " [DocumentType: " + asXML() + "]";
    }

    @Override // org.dom4j.Node
    public void write(Writer writer) throws IOException {
        boolean z;
        writer.write("<!DOCTYPE ");
        writer.write(getElementName());
        String publicID = getPublicID();
        if (publicID == null || publicID.length() <= 0) {
            z = false;
        } else {
            writer.write(" PUBLIC \"");
            writer.write(publicID);
            writer.write("\"");
            z = true;
        }
        String systemID = getSystemID();
        if (systemID != null && systemID.length() > 0) {
            if (!z) {
                writer.write(" SYSTEM");
            }
            writer.write(" \"");
            writer.write(systemID);
            writer.write("\"");
        }
        List<Decl> internalDeclarations = getInternalDeclarations();
        if (internalDeclarations != null && internalDeclarations.size() > 0) {
            writer.write(" [");
            for (Decl decl : internalDeclarations) {
                writer.write("\n  ");
                writer.write(decl.toString());
            }
            writer.write("\n]");
        }
        writer.write(">");
    }
}
