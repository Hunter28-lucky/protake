package org.greenrobot.greendao;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;

/* loaded from: classes2.dex */
public class AbstractDaoSession {
    private final Database db;
    private final Map<Class<?>, AbstractDao<?, ?>> entityToDao = new HashMap();

    public AbstractDaoSession(Database database) {
        this.db = database;
    }

    public Database getDatabase() {
        return this.db;
    }

    public <T> void registerDao(Class<T> cls, AbstractDao<T, ?> abstractDao) {
        this.entityToDao.put(cls, abstractDao);
    }

    public void runInTx(Runnable runnable) {
        this.db.beginTransaction();
        try {
            runnable.run();
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    public AsyncSession startAsyncSession() {
        return new AsyncSession(this);
    }
}
