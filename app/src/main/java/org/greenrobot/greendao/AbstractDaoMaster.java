package org.greenrobot.greendao;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes2.dex */
public abstract class AbstractDaoMaster {
    public final Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap = new HashMap();
    public final Database db;
    public final int schemaVersion;

    public AbstractDaoMaster(Database database, int i) {
        this.db = database;
        this.schemaVersion = i;
    }

    public void registerDaoClass(Class<? extends AbstractDao<?, ?>> cls) {
        this.daoConfigMap.put(cls, new DaoConfig(this.db, cls));
    }
}
