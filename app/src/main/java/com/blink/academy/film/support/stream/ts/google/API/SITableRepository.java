package com.blink.academy.film.support.stream.ts.google.API;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class SITableRepository {
    private static SITableRepository singleton_instance;
    public TreeMap<Integer, SITable> si_tables = new TreeMap<>();

    private SITableRepository() {
    }

    public static synchronized boolean addTable(SITable sITable) {
        return getInstance().si_tables.put(new Integer(sITable.getUniqueID()), sITable) == null;
    }

    public static String dump() {
        String str = new String();
        SITable[] allTables = getAllTables();
        for (int i = 0; i < allTables.length; i++) {
            str = str + "UID:" + allTables[i].getUniqueID() + " ," + allTables[i].getTableID() + "\n";
        }
        return str;
    }

    public static synchronized SITable[] getAllTables() {
        SITable[] sITableArr;
        Collection<SITable> collectionValues = getInstance().si_tables.values();
        sITableArr = new SITable[collectionValues.size()];
        Iterator<SITable> it = collectionValues.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            sITableArr[i] = it.next().clone();
            i = i2;
        }
        return sITableArr;
    }

    private static synchronized SITableRepository getInstance() {
        if (singleton_instance == null) {
            singleton_instance = new SITableRepository();
        }
        return singleton_instance;
    }

    public static synchronized SITable getTable(int i) {
        return getInstance().si_tables.get(new Integer(i)).clone();
    }

    public static synchronized int getTableSize() {
        return getInstance().si_tables.size();
    }

    public static synchronized boolean removeTable(SITable sITable) {
        return getInstance().si_tables.remove(new Integer(sITable.getUniqueID())) != null;
    }
}
