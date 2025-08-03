package org.greenrobot.greendao.async;

import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.async.AsyncOperation;

/* loaded from: classes2.dex */
public class AsyncSession {
    private final AbstractDaoSession daoSession;
    private final AsyncOperationExecutor executor = new AsyncOperationExecutor();
    private int sessionFlags;

    public AsyncSession(AbstractDaoSession abstractDaoSession) {
        this.daoSession = abstractDaoSession;
    }

    private AsyncOperation enqueueDatabaseOperation(AsyncOperation.OperationType operationType, Object obj, int i) {
        AsyncOperation asyncOperation = new AsyncOperation(operationType, null, this.daoSession.getDatabase(), obj, i | this.sessionFlags);
        this.executor.enqueue(asyncOperation);
        return asyncOperation;
    }

    public AsyncOperation runInTx(Runnable runnable) {
        return runInTx(runnable, 0);
    }

    public AsyncOperation runInTx(Runnable runnable, int i) {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionRunnable, runnable, i);
    }
}
