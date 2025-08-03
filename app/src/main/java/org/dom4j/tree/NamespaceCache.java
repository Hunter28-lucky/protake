package org.dom4j.tree;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.dom4j.Namespace;

/* loaded from: classes2.dex */
public class NamespaceCache {
    public static Map<String, Map<String, WeakReference<Namespace>>> cache = new ConcurrentHashMap();
    public static Map<String, WeakReference<Namespace>> noPrefixCache = new ConcurrentHashMap();

    public Namespace createNamespace(String str, String str2) {
        return new Namespace(str, str2);
    }

    public Namespace get(String str, String str2) {
        Map<String, WeakReference<Namespace>> uRICache = getURICache(str2);
        WeakReference<Namespace> weakReference = uRICache.get(str);
        Namespace namespace = weakReference != null ? weakReference.get() : null;
        if (namespace == null) {
            synchronized (uRICache) {
                WeakReference<Namespace> weakReference2 = uRICache.get(str);
                if (weakReference2 != null) {
                    namespace = weakReference2.get();
                }
                if (namespace == null) {
                    Namespace namespaceCreateNamespace = createNamespace(str, str2);
                    uRICache.put(str, new WeakReference<>(namespaceCreateNamespace));
                    namespace = namespaceCreateNamespace;
                }
            }
        }
        return namespace;
    }

    public Map<String, WeakReference<Namespace>> getURICache(String str) {
        Map<String, WeakReference<Namespace>> concurrentHashMap = cache.get(str);
        if (concurrentHashMap == null) {
            synchronized (cache) {
                concurrentHashMap = cache.get(str);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    cache.put(str, concurrentHashMap);
                }
            }
        }
        return concurrentHashMap;
    }
}
