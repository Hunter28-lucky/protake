package org.greenrobot.greendao.query;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;

/* loaded from: classes2.dex */
class WhereCollector<T> {
    private final AbstractDao<T, ?> dao;
    private final String tablePrefix;
    private final List<WhereCondition> whereConditions = new ArrayList();

    public WhereCollector(AbstractDao<T, ?> abstractDao, String str) {
        this.dao = abstractDao;
        this.tablePrefix = str;
    }

    public void appendWhereClause(StringBuilder sb, String str, List<Object> list) {
        ListIterator<WhereCondition> listIterator = this.whereConditions.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious()) {
                sb.append(" AND ");
            }
            WhereCondition next = listIterator.next();
            next.appendTo(sb, str);
            next.appendValuesTo(list);
        }
    }

    public void checkProperty(Property property) {
        AbstractDao<T, ?> abstractDao = this.dao;
        if (abstractDao != null) {
            Property[] properties = abstractDao.getProperties();
            int length = properties.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (property == properties[i]) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return;
            }
            throw new DaoException("Property '" + property.name + "' is not part of " + this.dao);
        }
    }

    public boolean isEmpty() {
        return this.whereConditions.isEmpty();
    }
}
