package org.greenrobot.greendao.query;

import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.mipush.sdk.Constants;
import io.jsonwebtoken.JwtParser;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

/* loaded from: classes2.dex */
public class QueryBuilder<T> {
    public static boolean LOG_SQL;
    public static boolean LOG_VALUES;
    private final AbstractDao<T, ?> dao;
    private boolean distinct;
    private final List<Join<T, ?>> joins;
    private Integer limit;
    private Integer offset;
    private StringBuilder orderBuilder;
    private String stringOrderCollation;
    private final String tablePrefix;
    private final List<Object> values;
    private final WhereCollector<T> whereCollector;

    public QueryBuilder(AbstractDao<T, ?> abstractDao) {
        this(abstractDao, ExifInterface.GPS_DIRECTION_TRUE);
    }

    private void appendJoinsAndWheres(StringBuilder sb, String str) {
        this.values.clear();
        for (Join<T, ?> join : this.joins) {
            sb.append(" JOIN ");
            sb.append(join.daoDestination.getTablename());
            sb.append(' ');
            sb.append(join.tablePrefix);
            sb.append(" ON ");
            SqlUtils.appendProperty(sb, join.sourceTablePrefix, join.joinPropertySource).append('=');
            SqlUtils.appendProperty(sb, join.tablePrefix, join.joinPropertyDestination);
        }
        boolean z = !this.whereCollector.isEmpty();
        if (z) {
            sb.append(" WHERE ");
            this.whereCollector.appendWhereClause(sb, str, this.values);
        }
        for (Join<T, ?> join2 : this.joins) {
            if (!join2.whereCollector.isEmpty()) {
                if (z) {
                    sb.append(" AND ");
                } else {
                    sb.append(" WHERE ");
                    z = true;
                }
                join2.whereCollector.appendWhereClause(sb, join2.tablePrefix, this.values);
            }
        }
    }

    private int checkAddLimit(StringBuilder sb) {
        if (this.limit == null) {
            return -1;
        }
        sb.append(" LIMIT ?");
        this.values.add(this.limit);
        return this.values.size() - 1;
    }

    private int checkAddOffset(StringBuilder sb) {
        if (this.offset == null) {
            return -1;
        }
        if (this.limit == null) {
            throw new IllegalStateException("Offset cannot be set without limit");
        }
        sb.append(" OFFSET ?");
        this.values.add(this.offset);
        return this.values.size() - 1;
    }

    private void checkLog(String str) {
        if (LOG_SQL) {
            DaoLog.d("Built SQL for query: " + str);
        }
        if (LOG_VALUES) {
            DaoLog.d("Values for query: " + this.values);
        }
    }

    private void checkOrderBuilder() {
        StringBuilder sb = this.orderBuilder;
        if (sb == null) {
            this.orderBuilder = new StringBuilder();
        } else if (sb.length() > 0) {
            this.orderBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }

    private StringBuilder createSelectBuilder() {
        StringBuilder sb = new StringBuilder(SqlUtils.createSqlSelect(this.dao.getTablename(), this.tablePrefix, this.dao.getAllColumns(), this.distinct));
        appendJoinsAndWheres(sb, this.tablePrefix);
        StringBuilder sb2 = this.orderBuilder;
        if (sb2 != null && sb2.length() > 0) {
            sb.append(" ORDER BY ");
            sb.append((CharSequence) this.orderBuilder);
        }
        return sb;
    }

    public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> abstractDao) {
        return new QueryBuilder<>(abstractDao);
    }

    private void orderAscOrDesc(String str, Property... propertyArr) {
        String str2;
        for (Property property : propertyArr) {
            checkOrderBuilder();
            append(this.orderBuilder, property);
            if (String.class.equals(property.type) && (str2 = this.stringOrderCollation) != null) {
                this.orderBuilder.append(str2);
            }
            this.orderBuilder.append(str);
        }
    }

    public StringBuilder append(StringBuilder sb, Property property) {
        this.whereCollector.checkProperty(property);
        sb.append(this.tablePrefix);
        sb.append(JwtParser.SEPARATOR_CHAR);
        sb.append('\'');
        sb.append(property.columnName);
        sb.append('\'');
        return sb;
    }

    public Query<T> build() {
        StringBuilder sbCreateSelectBuilder = createSelectBuilder();
        int iCheckAddLimit = checkAddLimit(sbCreateSelectBuilder);
        int iCheckAddOffset = checkAddOffset(sbCreateSelectBuilder);
        String string = sbCreateSelectBuilder.toString();
        checkLog(string);
        return Query.create(this.dao, string, this.values.toArray(), iCheckAddLimit, iCheckAddOffset);
    }

    public List<T> list() {
        return build().list();
    }

    public QueryBuilder<T> orderDesc(Property... propertyArr) {
        orderAscOrDesc(" DESC", propertyArr);
        return this;
    }

    public QueryBuilder(AbstractDao<T, ?> abstractDao, String str) {
        this.dao = abstractDao;
        this.tablePrefix = str;
        this.values = new ArrayList();
        this.joins = new ArrayList();
        this.whereCollector = new WhereCollector<>(abstractDao, str);
        this.stringOrderCollation = " COLLATE NOCASE";
    }
}
