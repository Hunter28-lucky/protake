package org.jcodec.containers.mp4.boxes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class MetaBox extends NodeBox {
    private static final String FOURCC = "meta";

    public MetaBox(Header header) {
        super(header);
    }

    public static MetaBox createMetaBox() {
        return new MetaBox(Header.createHeader(fourcc(), 0L));
    }

    private void dropChildBox(List<Box> list, String str) {
        ListIterator<Box> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (str.equals(listIterator.next().getFourcc())) {
                listIterator.remove();
            }
        }
    }

    public static String fourcc() {
        return FOURCC;
    }

    private DataBox getDataBox(List<Box> list) {
        for (Box box : list) {
            if (box instanceof DataBox) {
                return (DataBox) box;
            }
        }
        return null;
    }

    public Map<Integer, MetaValue> getItunesMeta() {
        DataBox dataBox;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        IListBox iListBox = (IListBox) NodeBox.findFirst(this, IListBox.class, IListBox.fourcc());
        if (iListBox == null) {
            return linkedHashMap;
        }
        for (Map.Entry<Integer, List<Box>> entry : iListBox.getValues().entrySet()) {
            Integer key = entry.getKey();
            if (key != null && (dataBox = getDataBox(entry.getValue())) != null) {
                linkedHashMap.put(key, MetaValue.createOtherWithLocale(dataBox.getType(), dataBox.getLocale(), dataBox.getData()));
            }
        }
        return linkedHashMap;
    }

    public Map<String, MetaValue> getKeyedMeta() {
        DataBox dataBox;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        IListBox iListBox = (IListBox) NodeBox.findFirst(this, IListBox.class, IListBox.fourcc());
        MdtaBox[] mdtaBoxArr = (MdtaBox[]) NodeBox.findAllPath(this, MdtaBox.class, new String[]{KeysBox.fourcc(), MdtaBox.fourcc()});
        if (iListBox != null && mdtaBoxArr.length != 0) {
            for (Map.Entry<Integer, List<Box>> entry : iListBox.getValues().entrySet()) {
                Integer key = entry.getKey();
                if (key != null && (dataBox = getDataBox(entry.getValue())) != null) {
                    MetaValue metaValueCreateOtherWithLocale = MetaValue.createOtherWithLocale(dataBox.getType(), dataBox.getLocale(), dataBox.getData());
                    if (key.intValue() > 0 && key.intValue() <= mdtaBoxArr.length) {
                        linkedHashMap.put(mdtaBoxArr[key.intValue() - 1].getKey(), metaValueCreateOtherWithLocale);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public void setItunesMeta(Map<Integer, MetaValue> map) {
        Map<Integer, List<Box>> values;
        if (map.isEmpty()) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        IListBox iListBox = (IListBox) NodeBox.findFirst(this, IListBox.class, IListBox.fourcc());
        if (iListBox == null) {
            values = new LinkedHashMap<>();
        } else {
            values = iListBox.getValues();
            for (Map.Entry<Integer, List<Box>> entry : values.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                MetaValue metaValue = (MetaValue) linkedHashMap.get(Integer.valueOf(iIntValue));
                if (metaValue != null) {
                    DataBox dataBoxCreateDataBox = DataBox.createDataBox(metaValue.getType(), metaValue.getLocale(), metaValue.getData());
                    dropChildBox(entry.getValue(), DataBox.fourcc());
                    entry.getValue().add(dataBoxCreateDataBox);
                    linkedHashMap.remove(Integer.valueOf(iIntValue));
                }
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            int iIntValue2 = ((Integer) entry2.getKey()).intValue();
            MetaValue metaValue2 = (MetaValue) entry2.getValue();
            DataBox dataBoxCreateDataBox2 = DataBox.createDataBox(metaValue2.getType(), metaValue2.getLocale(), metaValue2.getData());
            ArrayList arrayList = new ArrayList();
            values.put(Integer.valueOf(iIntValue2), arrayList);
            arrayList.add(dataBoxCreateDataBox2);
        }
        HashSet hashSet = new HashSet(values.keySet());
        hashSet.removeAll(map.keySet());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            values.remove((Integer) it.next());
        }
        replaceBox(IListBox.createIListBox(values));
    }

    public void setKeyedMeta(Map<String, MetaValue> map) {
        if (map.isEmpty()) {
            return;
        }
        KeysBox keysBoxCreateKeysBox = KeysBox.createKeysBox();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 1;
        for (Map.Entry<String, MetaValue> entry : map.entrySet()) {
            keysBoxCreateKeysBox.add(MdtaBox.createMdtaBox(entry.getKey()));
            MetaValue value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add(DataBox.createDataBox(value.getType(), value.getLocale(), value.getData()));
            linkedHashMap.put(Integer.valueOf(i), arrayList);
            i++;
        }
        Box boxCreateIListBox = IListBox.createIListBox(linkedHashMap);
        replaceBox(keysBoxCreateKeysBox);
        replaceBox(boxCreateIListBox);
    }
}
