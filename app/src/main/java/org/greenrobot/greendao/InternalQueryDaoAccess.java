package org.greenrobot.greendao;

import android.database.Cursor;
import java.util.List;

/* loaded from: classes2.dex */
public final class InternalQueryDaoAccess<T> {
    private final AbstractDao<T, ?> dao;

    public InternalQueryDaoAccess(AbstractDao<T, ?> abstractDao) {
        this.dao = abstractDao;
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        return this.dao.loadAllAndCloseCursor(cursor);
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        return this.dao.loadUniqueAndCloseCursor(cursor);
    }
}
