package org.dom4j.tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.dom4j.DocumentFactory;
import org.dom4j.Namespace;
import org.dom4j.QName;

/* loaded from: classes2.dex */
public class QNameCache {
    private DocumentFactory documentFactory;
    public Map<String, QName> noNamespaceCache = Collections.synchronizedMap(new WeakHashMap());
    public Map<Namespace, Map<String, QName>> namespaceCache = Collections.synchronizedMap(new WeakHashMap());

    public QNameCache() {
    }

    public Map<String, QName> createMap() {
        return Collections.synchronizedMap(new HashMap());
    }

    public QName createQName(String str, Namespace namespace) {
        return new QName(str, namespace);
    }

    public QName get(String str, Namespace namespace) {
        QName qName;
        Map<String, QName> namespaceCache = getNamespaceCache(namespace);
        if (str != null) {
            qName = namespaceCache.get(str);
        } else {
            qName = null;
            str = "";
        }
        if (qName != null) {
            return qName;
        }
        QName qNameCreateQName = createQName(str, namespace);
        qNameCreateQName.setDocumentFactory(this.documentFactory);
        namespaceCache.put(str, qNameCreateQName);
        return qNameCreateQName;
    }

    public Map<String, QName> getNamespaceCache(Namespace namespace) {
        if (namespace == Namespace.NO_NAMESPACE) {
            return this.noNamespaceCache;
        }
        Map<String, QName> map = namespace != null ? this.namespaceCache.get(namespace) : null;
        if (map != null) {
            return map;
        }
        Map<String, QName> mapCreateMap = createMap();
        this.namespaceCache.put(namespace, mapCreateMap);
        return mapCreateMap;
    }

    public QNameCache(DocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }
}
