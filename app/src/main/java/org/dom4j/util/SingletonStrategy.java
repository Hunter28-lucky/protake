package org.dom4j.util;

/* loaded from: classes2.dex */
public interface SingletonStrategy<T> {
    T instance();

    void setSingletonClassName(String str);
}
