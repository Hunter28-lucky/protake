package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

/* loaded from: classes2.dex */
abstract class AbstractQueryWithLimit<T> extends AbstractQuery<T> {
    public final int limitPosition;
    public final int offsetPosition;

    public AbstractQueryWithLimit(AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i, int i2) {
        super(abstractDao, str, strArr);
        this.limitPosition = i;
        this.offsetPosition = i2;
    }
}
