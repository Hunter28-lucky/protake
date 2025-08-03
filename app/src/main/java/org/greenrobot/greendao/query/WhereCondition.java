package org.greenrobot.greendao.query;

import java.util.List;

/* loaded from: classes2.dex */
public interface WhereCondition {
    void appendTo(StringBuilder sb, String str);

    void appendValuesTo(List<Object> list);
}
