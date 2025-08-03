package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

/* loaded from: classes2.dex */
abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {
    public final AbstractDao<T, ?> dao;
    public final String[] initialValues;
    public final Map<Long, WeakReference<Q>> queriesForThreads = new HashMap();
    public final String sql;

    public AbstractQueryData(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.sql = str;
        this.initialValues = strArr;
    }

    public abstract Q createQuery();

    public Q forCurrentThread(Q q) {
        if (Thread.currentThread() != q.ownerThread) {
            return (Q) forCurrentThread();
        }
        String[] strArr = this.initialValues;
        System.arraycopy(strArr, 0, q.parameters, 0, strArr.length);
        return q;
    }

    public void gc() {
        synchronized (this.queriesForThreads) {
            Iterator<Map.Entry<Long, WeakReference<Q>>> it = this.queriesForThreads.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().get() == null) {
                    it.remove();
                }
            }
        }
    }

    public Q forCurrentThread() {
        Q q;
        long id = Thread.currentThread().getId();
        synchronized (this.queriesForThreads) {
            WeakReference<Q> weakReference = this.queriesForThreads.get(Long.valueOf(id));
            q = weakReference != null ? weakReference.get() : null;
            if (q == null) {
                gc();
                q = (Q) createQuery();
                this.queriesForThreads.put(Long.valueOf(id), new WeakReference<>(q));
            } else {
                String[] strArr = this.initialValues;
                System.arraycopy(strArr, 0, q.parameters, 0, strArr.length);
            }
        }
        return q;
    }
}
