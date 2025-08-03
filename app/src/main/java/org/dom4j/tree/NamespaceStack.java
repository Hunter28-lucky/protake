package org.dom4j.tree;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.dom4j.DocumentFactory;
import org.dom4j.Namespace;
import org.dom4j.QName;

/* loaded from: classes2.dex */
public class NamespaceStack {
    private Map<String, QName> currentNamespaceCache;
    private Namespace defaultNamespace;
    private DocumentFactory documentFactory;
    private ArrayList<Map<String, QName>> namespaceCacheList;
    private ArrayList<Namespace> namespaceStack;
    private Map<String, QName> rootNamespaceCache;

    public NamespaceStack() {
        this.namespaceStack = new ArrayList<>();
        this.namespaceCacheList = new ArrayList<>();
        this.rootNamespaceCache = new HashMap();
        this.documentFactory = DocumentFactory.getInstance();
    }

    public void clear() {
        this.namespaceStack.clear();
        this.namespaceCacheList.clear();
        this.rootNamespaceCache.clear();
        this.currentNamespaceCache = null;
    }

    public boolean contains(Namespace namespace) {
        String prefix = namespace.getPrefix();
        Namespace defaultNamespace = (prefix == null || prefix.length() == 0) ? getDefaultNamespace() : getNamespaceForPrefix(prefix);
        if (defaultNamespace == null) {
            return false;
        }
        if (defaultNamespace == namespace) {
            return true;
        }
        return namespace.getURI().equals(defaultNamespace.getURI());
    }

    public Namespace createNamespace(String str, String str2) {
        return this.documentFactory.createNamespace(str, str2);
    }

    public QName createQName(String str, String str2, Namespace namespace) {
        return this.documentFactory.createQName(str, namespace);
    }

    public Namespace findDefaultNamespace() {
        for (int size = this.namespaceStack.size() - 1; size >= 0; size--) {
            Namespace namespace = this.namespaceStack.get(size);
            if (namespace != null && (namespace.getPrefix() == null || namespace.getPrefix().length() == 0)) {
                return namespace;
            }
        }
        return null;
    }

    public QName getAttributeQName(String str, String str2, String str3) {
        Namespace namespaceCreateNamespace;
        if (str3 == null) {
            str3 = str2;
        }
        Map<String, QName> namespaceCache = getNamespaceCache();
        QName qName = namespaceCache.get(str3);
        if (qName != null) {
            return qName;
        }
        if (str2 == null) {
            str2 = str3;
        }
        String strSubstring = "";
        if (str == null) {
            str = "";
        }
        int iIndexOf = str3.indexOf(Constants.COLON_SEPARATOR);
        if (iIndexOf > 0) {
            strSubstring = str3.substring(0, iIndexOf);
            namespaceCreateNamespace = createNamespace(strSubstring, str);
            if (str2.trim().length() == 0) {
                str2 = str3.substring(iIndexOf + 1);
            }
        } else {
            namespaceCreateNamespace = Namespace.NO_NAMESPACE;
            if (str2.trim().length() == 0) {
                str2 = str3;
            }
        }
        QName qNamePushQName = pushQName(str2, str3, namespaceCreateNamespace, strSubstring);
        namespaceCache.put(str3, qNamePushQName);
        return qNamePushQName;
    }

    public Namespace getDefaultNamespace() {
        if (this.defaultNamespace == null) {
            this.defaultNamespace = findDefaultNamespace();
        }
        return this.defaultNamespace;
    }

    public Namespace getNamespace(int i) {
        return this.namespaceStack.get(i);
    }

    public Map<String, QName> getNamespaceCache() {
        if (this.currentNamespaceCache == null) {
            int size = this.namespaceStack.size() - 1;
            if (size < 0) {
                this.currentNamespaceCache = this.rootNamespaceCache;
            } else {
                Map<String, QName> map = this.namespaceCacheList.get(size);
                this.currentNamespaceCache = map;
                if (map == null) {
                    HashMap map2 = new HashMap();
                    this.currentNamespaceCache = map2;
                    this.namespaceCacheList.set(size, map2);
                }
            }
        }
        return this.currentNamespaceCache;
    }

    public Namespace getNamespaceForPrefix(String str) {
        if (str == null) {
            str = "";
        }
        for (int size = this.namespaceStack.size() - 1; size >= 0; size--) {
            Namespace namespace = this.namespaceStack.get(size);
            if (str.equals(namespace.getPrefix())) {
                return namespace;
            }
        }
        return null;
    }

    public QName getQName(String str, String str2, String str3) {
        if (str2 == null) {
            str2 = str3;
        } else if (str3 == null) {
            str3 = str2;
        } else {
            str3 = str2;
            str2 = str3;
        }
        String strSubstring = "";
        if (str == null) {
            str = "";
        }
        int iIndexOf = str2.indexOf(Constants.COLON_SEPARATOR);
        if (iIndexOf > 0) {
            strSubstring = str2.substring(0, iIndexOf);
            if (str3.trim().length() == 0) {
                str3 = str2.substring(iIndexOf + 1);
            }
        } else if (str3.trim().length() == 0) {
            str3 = str2;
        }
        return pushQName(str3, str2, createNamespace(strSubstring, str), strSubstring);
    }

    public String getURI(String str) {
        Namespace namespaceForPrefix = getNamespaceForPrefix(str);
        if (namespaceForPrefix != null) {
            return namespaceForPrefix.getURI();
        }
        return null;
    }

    public Namespace pop() {
        return remove(this.namespaceStack.size() - 1);
    }

    public void push(Namespace namespace) {
        this.namespaceStack.add(namespace);
        this.namespaceCacheList.add(null);
        this.currentNamespaceCache = null;
        String prefix = namespace.getPrefix();
        if (prefix == null || prefix.length() == 0) {
            this.defaultNamespace = namespace;
        }
    }

    public QName pushQName(String str, String str2, Namespace namespace, String str3) {
        if (str3 == null || str3.length() == 0) {
            this.defaultNamespace = null;
        }
        return createQName(str, str2, namespace);
    }

    public Namespace remove(int i) {
        Namespace namespaceRemove = this.namespaceStack.remove(i);
        this.namespaceCacheList.remove(i);
        this.defaultNamespace = null;
        this.currentNamespaceCache = null;
        return namespaceRemove;
    }

    public int size() {
        return this.namespaceStack.size();
    }

    public String toString() {
        return super.toString() + " Stack: " + this.namespaceStack.toString();
    }

    public Namespace pop(String str) {
        if (str == null) {
            str = "";
        }
        Namespace namespace = null;
        int size = this.namespaceStack.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            Namespace namespace2 = this.namespaceStack.get(size);
            if (str.equals(namespace2.getPrefix())) {
                remove(size);
                namespace = namespace2;
                break;
            }
            size--;
        }
        if (namespace == null) {
            System.out.println("Warning: missing namespace prefix ignored: " + str);
        }
        return namespace;
    }

    public NamespaceStack(DocumentFactory documentFactory) {
        this.namespaceStack = new ArrayList<>();
        this.namespaceCacheList = new ArrayList<>();
        this.rootNamespaceCache = new HashMap();
        this.documentFactory = documentFactory;
    }

    public void push(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        push(createNamespace(str, str2));
    }
}
