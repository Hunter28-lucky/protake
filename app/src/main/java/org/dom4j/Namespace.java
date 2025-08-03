package org.dom4j;

import org.dom4j.tree.AbstractNode;
import org.dom4j.tree.NamespaceCache;

/* loaded from: classes2.dex */
public class Namespace extends AbstractNode {
    public static final NamespaceCache CACHE;
    public static final Namespace NO_NAMESPACE;
    public static final Namespace XML_NAMESPACE;
    private int hashCode;
    private String prefix;
    private String uri;

    static {
        NamespaceCache namespaceCache = new NamespaceCache();
        CACHE = namespaceCache;
        XML_NAMESPACE = namespaceCache.get("xml", "http://www.w3.org/XML/1998/namespace");
        NO_NAMESPACE = namespaceCache.get("", "");
    }

    public Namespace(String str, String str2) {
        this.prefix = str == null ? "" : str;
        this.uri = str2 == null ? "" : str2;
    }

    public static Namespace get(String str, String str2) {
        return CACHE.get(str, str2);
    }

    public int createHashCode() {
        int iHashCode = this.uri.hashCode() ^ this.prefix.hashCode();
        if (iHashCode == 0) {
            return 47806;
        }
        return iHashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Namespace) {
            Namespace namespace = (Namespace) obj;
            if (hashCode() == namespace.hashCode()) {
                return this.uri.equals(namespace.getURI()) && this.prefix.equals(namespace.getPrefix());
            }
        }
        return false;
    }

    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 13;
    }

    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.uri;
    }

    public String getURI() {
        return this.uri;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = createHashCode();
        }
        return this.hashCode;
    }

    public String toString() {
        return super.toString() + " [Namespace: prefix " + getPrefix() + " mapped to URI \"" + getURI() + "\"]";
    }
}
