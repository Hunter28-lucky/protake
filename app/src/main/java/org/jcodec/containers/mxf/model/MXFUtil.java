package org.jcodec.containers.mxf.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MXFUtil {
    public static <T> List<T> findAllMeta(Collection<MXFMetadata> collection, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (MXFMetadata mXFMetadata : collection) {
            if (Platform.isAssignableFrom(cls, mXFMetadata.getClass())) {
                arrayList.add(mXFMetadata);
            }
        }
        return arrayList;
    }

    public static <T> T findMeta(Collection<MXFMetadata> collection, Class<T> cls) {
        Iterator<MXFMetadata> it = collection.iterator();
        while (it.hasNext()) {
            T t = (T) ((MXFMetadata) it.next());
            if (Platform.isAssignableFrom(t.getClass(), cls)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T resolveRef(List<MXFMetadata> list, UL ul, Class<T> cls) {
        List listResolveRefs = resolveRefs(list, new UL[]{ul}, cls);
        if (listResolveRefs.size() > 0) {
            return (T) listResolveRefs.get(0);
        }
        return null;
    }

    public static <T> List<T> resolveRefs(List<MXFMetadata> list, UL[] ulArr, Class<T> cls) {
        ArrayList<MXFMetadata> arrayList = new ArrayList(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MXFMetadata mXFMetadata = (MXFMetadata) it.next();
            if (mXFMetadata.getUid() == null || !Platform.isAssignableFrom(cls, mXFMetadata.getClass())) {
                it.remove();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (UL ul : ulArr) {
            for (MXFMetadata mXFMetadata2 : arrayList) {
                if (mXFMetadata2.getUid().equals(ul)) {
                    arrayList2.add(mXFMetadata2);
                }
            }
        }
        return arrayList2;
    }
}
