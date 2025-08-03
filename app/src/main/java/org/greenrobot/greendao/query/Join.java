package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;

/* loaded from: classes2.dex */
public class Join<SRC, DST> {
    public final AbstractDao<DST, ?> daoDestination;
    public final Property joinPropertyDestination;
    public final Property joinPropertySource;
    public final String sourceTablePrefix;
    public final String tablePrefix;
    public final WhereCollector<DST> whereCollector;
}
