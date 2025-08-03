package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.QueryBuilder;

/* loaded from: classes2.dex */
public abstract class AbstractDao<T, K> {
    public final DaoConfig config;
    public final Database db;
    public final IdentityScope<K, T> identityScope;
    public final IdentityScopeLong<T> identityScopeLong;
    public final boolean isStandardSQLite;
    public final int pkOrdinal;
    public final AbstractDaoSession session;
    public final TableStatements statements;

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        Database database = daoConfig.db;
        this.db = database;
        this.isStandardSQLite = database.getRawDatabase() instanceof SQLiteDatabase;
        IdentityScopeLong<T> identityScopeLong = (IdentityScope<K, T>) daoConfig.getIdentityScope();
        this.identityScope = identityScopeLong;
        if (identityScopeLong instanceof IdentityScopeLong) {
            this.identityScopeLong = identityScopeLong;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = daoConfig.statements;
        Property property = daoConfig.pkProperty;
        this.pkOrdinal = property != null ? property.ordinal : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void deleteByKeyInsideSynchronized(K k, DatabaseStatement databaseStatement) {
        if (k instanceof Long) {
            databaseStatement.bindLong(1, ((Long) k).longValue());
        } else {
            if (k == 0) {
                throw new DaoException("Cannot delete entity, key is null");
            }
            databaseStatement.bindString(1, k.toString());
        }
        databaseStatement.execute();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e A[Catch: all -> 0x003a, TryCatch #1 {all -> 0x003a, blocks: (B:10:0x001f, B:11:0x0023, B:13:0x0029, B:15:0x0036, B:19:0x003e, B:20:0x0042, B:22:0x0048, B:24:0x0051), top: B:48:0x001f, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061 A[Catch: all -> 0x0079, Merged into TryCatch #2 {all -> 0x007c, blocks: (B:3:0x000e, B:34:0x0065, B:36:0x006c, B:38:0x0070, B:43:0x007b, B:4:0x000f, B:6:0x0013, B:30:0x005d, B:32:0x0061, B:33:0x0064, B:26:0x0055, B:28:0x0059, B:29:0x005c, B:10:0x001f, B:11:0x0023, B:13:0x0029, B:15:0x0036, B:19:0x003e, B:20:0x0042, B:22:0x0048, B:24:0x0051), top: B:50:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void deleteInTxInternal(java.lang.Iterable<T> r4, java.lang.Iterable<K> r5) {
        /*
            r3 = this;
            r3.assertSinglePk()
            org.greenrobot.greendao.internal.TableStatements r0 = r3.statements
            org.greenrobot.greendao.database.DatabaseStatement r0 = r0.getDeleteStatement()
            org.greenrobot.greendao.database.Database r1 = r3.db
            r1.beginTransaction()
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L7c
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r1 = r3.identityScope     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L1c
            r1.lock()     // Catch: java.lang.Throwable -> L79
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L79
            r1.<init>()     // Catch: java.lang.Throwable -> L79
            goto L1d
        L1c:
            r1 = 0
        L1d:
            if (r4 == 0) goto L3c
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L3a
        L23:
            boolean r2 = r4.hasNext()     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r2 = r3.getKeyVerified(r2)     // Catch: java.lang.Throwable -> L3a
            r3.deleteByKeyInsideSynchronized(r2, r0)     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L23
            r1.add(r2)     // Catch: java.lang.Throwable -> L3a
            goto L23
        L3a:
            r4 = move-exception
            goto L55
        L3c:
            if (r5 == 0) goto L5d
            java.util.Iterator r4 = r5.iterator()     // Catch: java.lang.Throwable -> L3a
        L42:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L5d
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L3a
            r3.deleteByKeyInsideSynchronized(r5, r0)     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L42
            r1.add(r5)     // Catch: java.lang.Throwable -> L3a
            goto L42
        L55:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r3.identityScope     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L5c
            r5.unlock()     // Catch: java.lang.Throwable -> L79
        L5c:
            throw r4     // Catch: java.lang.Throwable -> L79
        L5d:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r4 = r3.identityScope     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L64
            r4.unlock()     // Catch: java.lang.Throwable -> L79
        L64:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
            org.greenrobot.greendao.database.Database r4 = r3.db     // Catch: java.lang.Throwable -> L7c
            r4.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L73
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r4 = r3.identityScope     // Catch: java.lang.Throwable -> L7c
            if (r4 == 0) goto L73
            r4.remove(r1)     // Catch: java.lang.Throwable -> L7c
        L73:
            org.greenrobot.greendao.database.Database r4 = r3.db
            r4.endTransaction()
            return
        L79:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
            throw r4     // Catch: java.lang.Throwable -> L7c
        L7c:
            r4 = move-exception
            org.greenrobot.greendao.database.Database r5 = r3.db
            r5.endTransaction()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.AbstractDao.deleteInTxInternal(java.lang.Iterable, java.lang.Iterable):void");
    }

    private long executeInsert(T t, DatabaseStatement databaseStatement, boolean z) {
        long jInsertInsideTx;
        if (this.db.isDbLockedByCurrentThread()) {
            jInsertInsideTx = insertInsideTx(t, databaseStatement);
        } else {
            this.db.beginTransaction();
            try {
                jInsertInsideTx = insertInsideTx(t, databaseStatement);
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
        if (z) {
            updateKeyAfterInsertAndAttach(t, jInsertInsideTx, true);
        }
        return jInsertInsideTx;
    }

    private void executeInsertInTx(DatabaseStatement databaseStatement, Iterable<T> iterable, boolean z) {
        this.db.beginTransaction();
        try {
            synchronized (databaseStatement) {
                IdentityScope<K, T> identityScope = this.identityScope;
                if (identityScope != null) {
                    identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                        for (T t : iterable) {
                            bindValues(sQLiteStatement, (SQLiteStatement) t);
                            if (z) {
                                updateKeyAfterInsertAndAttach(t, sQLiteStatement.executeInsert(), false);
                            } else {
                                sQLiteStatement.execute();
                            }
                        }
                    } else {
                        for (T t2 : iterable) {
                            bindValues(databaseStatement, (DatabaseStatement) t2);
                            if (z) {
                                updateKeyAfterInsertAndAttach(t2, databaseStatement.executeInsert(), false);
                            } else {
                                databaseStatement.execute();
                            }
                        }
                    }
                } finally {
                    IdentityScope<K, T> identityScope2 = this.identityScope;
                    if (identityScope2 != null) {
                        identityScope2.unlock();
                    }
                }
            }
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    private long insertInsideTx(T t, DatabaseStatement databaseStatement) {
        synchronized (databaseStatement) {
            if (!this.isStandardSQLite) {
                bindValues(databaseStatement, (DatabaseStatement) t);
                return databaseStatement.executeInsert();
            }
            SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
            bindValues(sQLiteStatement, (SQLiteStatement) t);
            return sQLiteStatement.executeInsert();
        }
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int startPosition = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int i = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            int i2 = i + 1;
            if (i2 >= startPosition) {
                CursorWindow cursorWindowMoveToNextUnlocked = moveToNextUnlocked(cursor);
                if (cursorWindowMoveToNextUnlocked == null) {
                    return;
                } else {
                    startPosition = cursorWindowMoveToNextUnlocked.getStartPosition() + cursorWindowMoveToNextUnlocked.getNumRows();
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i = i2 + 1;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor cursor) {
        this.identityScope.unlock();
        try {
            return cursor.moveToNext() ? ((CrossProcessCursor) cursor).getWindow() : null;
        } finally {
            this.identityScope.lock();
        }
    }

    public void assertSinglePk() {
        if (this.config.pkColumns.length == 1) {
            return;
        }
        throw new DaoException(this + " (" + this.config.tablename + ") does not have a single-column primary key");
    }

    public void attachEntity(T t) {
    }

    public final void attachEntity(K k, T t, boolean z) {
        attachEntity(t);
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope == null || k == null) {
            return;
        }
        if (z) {
            identityScope.put(k, t);
        } else {
            identityScope.putNoLock(k, t);
        }
    }

    public abstract void bindValues(SQLiteStatement sQLiteStatement, T t);

    public abstract void bindValues(DatabaseStatement databaseStatement, T t);

    public long count() {
        return this.statements.getCountStatement().simpleQueryForLong();
    }

    public void delete(T t) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t));
    }

    public void deleteAll() throws SQLException {
        this.db.execSQL("DELETE FROM '" + this.config.tablename + "'");
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public void deleteByKey(K k) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k, deleteStatement);
            }
        } else {
            this.db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k, deleteStatement);
                }
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.remove((IdentityScope<K, T>) k);
        }
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public Database getDatabase() {
        return this.db;
    }

    public abstract K getKey(T t);

    public K getKeyVerified(T t) {
        K key = getKey(t);
        if (key != null) {
            return key;
        }
        if (t == null) {
            throw new NullPointerException("Entity may not be null");
        }
        throw new DaoException("Entity has no key");
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public long insert(T t) {
        return executeInsert(t, this.statements.getInsertStatement(), true);
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public long insertOrReplace(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement(), true);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z);
    }

    public abstract boolean isEntityUpdateable();

    public T load(K k) {
        T t;
        assertSinglePk();
        if (k == null) {
            return null;
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        return (identityScope == null || (t = identityScope.get(k)) == null) ? loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByKey(), new String[]{k.toString()})) : t;
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll(), null));
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<T> loadAllFromCursor(android.database.Cursor r7) {
        /*
            r6 = this;
            int r0 = r7.getCount()
            if (r0 != 0) goto Lc
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        Lc:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
            boolean r3 = r7 instanceof android.database.CrossProcessCursor
            r4 = 0
            if (r3 == 0) goto L4d
            r2 = r7
            android.database.CrossProcessCursor r2 = (android.database.CrossProcessCursor) r2
            android.database.CursorWindow r2 = r2.getWindow()
            if (r2 == 0) goto L4d
            int r3 = r2.getNumRows()
            if (r3 != r0) goto L2d
            org.greenrobot.greendao.internal.FastCursor r7 = new org.greenrobot.greendao.internal.FastCursor
            r7.<init>(r2)
            r3 = 1
            goto L4e
        L2d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Window vs. result size: "
            r3.append(r5)
            int r5 = r2.getNumRows()
            r3.append(r5)
            java.lang.String r5 = "/"
            r3.append(r5)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            org.greenrobot.greendao.DaoLog.d(r3)
        L4d:
            r3 = r4
        L4e:
            boolean r5 = r7.moveToFirst()
            if (r5 == 0) goto L8a
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            if (r5 == 0) goto L60
            r5.lock()
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            r5.reserveRoom(r0)
        L60:
            if (r3 != 0) goto L6c
            if (r2 == 0) goto L6c
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L6c
            r6.loadAllUnlockOnWindowBounds(r7, r2, r1)     // Catch: java.lang.Throwable -> L81
            goto L79
        L6c:
            java.lang.Object r0 = r6.loadCurrent(r7, r4, r4)     // Catch: java.lang.Throwable -> L81
            r1.add(r0)     // Catch: java.lang.Throwable -> L81
            boolean r0 = r7.moveToNext()     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L6c
        L79:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r7 = r6.identityScope
            if (r7 == 0) goto L8a
            r7.unlock()
            goto L8a
        L81:
            r7 = move-exception
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope
            if (r0 == 0) goto L89
            r0.unlock()
        L89:
            throw r7
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.AbstractDao.loadAllFromCursor(android.database.Cursor):java.util.List");
    }

    public final T loadCurrent(Cursor cursor, int i, boolean z) {
        if (this.identityScopeLong != null) {
            if (i != 0 && cursor.isNull(this.pkOrdinal + i)) {
                return null;
            }
            long j = cursor.getLong(this.pkOrdinal + i);
            IdentityScopeLong<T> identityScopeLong = this.identityScopeLong;
            T t = z ? identityScopeLong.get2(j) : identityScopeLong.get2NoLock(j);
            if (t != null) {
                return t;
            }
            T entity = readEntity(cursor, i);
            attachEntity(entity);
            if (z) {
                this.identityScopeLong.put2(j, entity);
            } else {
                this.identityScopeLong.put2NoLock(j, entity);
            }
            return entity;
        }
        if (this.identityScope == null) {
            if (i != 0 && readKey(cursor, i) == null) {
                return null;
            }
            T entity2 = readEntity(cursor, i);
            attachEntity(entity2);
            return entity2;
        }
        K key = readKey(cursor, i);
        if (i != 0 && key == null) {
            return null;
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        T noLock = z ? identityScope.get(key) : identityScope.getNoLock(key);
        if (noLock != null) {
            return noLock;
        }
        T entity3 = readEntity(cursor, i);
        attachEntity(key, entity3, z);
        return entity3;
    }

    public T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    public abstract T readEntity(Cursor cursor, int i);

    public abstract void readEntity(Cursor cursor, T t, int i);

    public abstract K readKey(Cursor cursor, int i);

    public void refresh(T t) {
        assertSinglePk();
        K keyVerified = getKeyVerified(t);
        Cursor cursorRawQuery = this.db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (!cursorRawQuery.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t.getClass() + " with key " + keyVerified);
            }
            if (cursorRawQuery.isLast()) {
                readEntity(cursorRawQuery, t, 0);
                attachEntity(keyVerified, t, true);
            } else {
                throw new DaoException("Expected unique result, but count was " + cursorRawQuery.getCount());
            }
        } finally {
            cursorRawQuery.close();
        }
    }

    public void update(T t) {
        assertSinglePk();
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                if (this.isStandardSQLite) {
                    updateInsideSynchronized((AbstractDao<T, K>) t, (SQLiteStatement) updateStatement.getRawStatement(), true);
                } else {
                    updateInsideSynchronized((AbstractDao<T, K>) t, updateStatement, true);
                }
            }
            return;
        }
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized((AbstractDao<T, K>) t, updateStatement, true);
            }
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    public void updateInTx(Iterable<T> iterable) {
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                IdentityScope<K, T> identityScope = this.identityScope;
                if (identityScope != null) {
                    identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) updateStatement.getRawStatement();
                        Iterator<T> it = iterable.iterator();
                        while (it.hasNext()) {
                            updateInsideSynchronized((AbstractDao<T, K>) it.next(), sQLiteStatement, false);
                        }
                    } else {
                        Iterator<T> it2 = iterable.iterator();
                        while (it2.hasNext()) {
                            updateInsideSynchronized((AbstractDao<T, K>) it2.next(), updateStatement, false);
                        }
                    }
                } finally {
                    IdentityScope<K, T> identityScope2 = this.identityScope;
                    if (identityScope2 != null) {
                        identityScope2.unlock();
                    }
                }
            }
            this.db.setTransactionSuccessful();
        } catch (RuntimeException e2) {
            e = e2;
            try {
                this.db.endTransaction();
            } catch (RuntimeException e3) {
                DaoLog.w("Could not end transaction (rethrowing initial exception)", e3);
                throw e;
            }
        } catch (Throwable th) {
            try {
                this.db.endTransaction();
                throw th;
            } catch (RuntimeException e4) {
                throw e4;
            }
        }
        try {
            this.db.endTransaction();
            e = null;
            if (e != null) {
                throw e;
            }
        } catch (RuntimeException e5) {
            throw e5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateInsideSynchronized(T t, DatabaseStatement databaseStatement, boolean z) {
        bindValues(databaseStatement, (DatabaseStatement) t);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t);
        if (key instanceof Long) {
            databaseStatement.bindLong(length, ((Long) key).longValue());
        } else {
            if (key == null) {
                throw new DaoException("Cannot update entity without key - was it inserted before?");
            }
            databaseStatement.bindString(length, key.toString());
        }
        databaseStatement.execute();
        attachEntity(key, t, z);
    }

    public abstract K updateKeyAfterInsert(T t, long j);

    public void updateKeyAfterInsertAndAttach(T t, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(t, j), t, z);
        } else {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
        }
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void insertInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateInsideSynchronized(T t, SQLiteStatement sQLiteStatement, boolean z) {
        bindValues(sQLiteStatement, (SQLiteStatement) t);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            sQLiteStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        sQLiteStatement.execute();
        attachEntity(key, t, z);
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }
}
