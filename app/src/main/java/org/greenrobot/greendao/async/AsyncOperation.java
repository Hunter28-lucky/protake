package org.greenrobot.greendao.async;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

/* loaded from: classes2.dex */
public class AsyncOperation {
    private volatile boolean completed;
    public final Exception creatorStacktrace;
    public final AbstractDao<Object, Object> dao;
    private final Database database;
    public final int flags;
    public volatile int mergedOperationsCount;
    public final Object parameter;
    public volatile Object result;
    public int sequenceNumber;
    public volatile Throwable throwable;
    public volatile long timeCompleted;
    public volatile long timeStarted;
    public final OperationType type;

    public enum OperationType {
        Insert,
        InsertInTxIterable,
        InsertInTxArray,
        InsertOrReplace,
        InsertOrReplaceInTxIterable,
        InsertOrReplaceInTxArray,
        Update,
        UpdateInTxIterable,
        UpdateInTxArray,
        Delete,
        DeleteInTxIterable,
        DeleteInTxArray,
        DeleteByKey,
        DeleteAll,
        TransactionRunnable,
        TransactionCallable,
        QueryList,
        QueryUnique,
        Load,
        LoadAll,
        Count,
        Refresh
    }

    public AsyncOperation(OperationType operationType, AbstractDao<?, ?> abstractDao, Database database, Object obj, int i) {
        this.type = operationType;
        this.flags = i;
        this.dao = abstractDao;
        this.database = database;
        this.parameter = obj;
        this.creatorStacktrace = (i & 4) != 0 ? new Exception("AsyncOperation was created here") : null;
    }

    public Database getDatabase() {
        Database database = this.database;
        return database != null ? database : this.dao.getDatabase();
    }

    public boolean isFailed() {
        return this.throwable != null;
    }

    public boolean isMergeTx() {
        return (this.flags & 1) != 0;
    }

    public boolean isMergeableWith(AsyncOperation asyncOperation) {
        return asyncOperation != null && isMergeTx() && asyncOperation.isMergeTx() && getDatabase() == asyncOperation.getDatabase();
    }

    public void reset() {
        this.timeStarted = 0L;
        this.timeCompleted = 0L;
        this.completed = false;
        this.throwable = null;
        this.result = null;
        this.mergedOperationsCount = 0;
    }

    public synchronized void setCompleted() {
        this.completed = true;
        notifyAll();
    }
}
