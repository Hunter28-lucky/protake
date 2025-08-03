package cn.smssdk.gui;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.efs.sdk.base.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SearchEngine {
    private static final String DB_FILE = "smssdk_pydb";
    private static HashMap<String, Object> hanzi2Pinyin;
    private boolean caseSensitive;
    private ArrayList<SearchIndex> index;

    public static class SearchIndex {
        private String code;
        private ArrayList<String> firstLatters;
        private ArrayList<String> pinyin;
        private String text;

        public SearchIndex(String str, HashMap<String, Object> map) {
            this(str, null, map);
        }

        private void createPinyinList(HashMap<String, Object> map) {
            if (map == null || map.size() <= 0) {
                return;
            }
            char[] charArray = this.text.toCharArray();
            ArrayList<String[]> arrayList = new ArrayList<>();
            for (char c : charArray) {
                ArrayList arrayList2 = (ArrayList) map.get(String.valueOf(c));
                int size = arrayList2 == null ? 0 : arrayList2.size();
                String[] strArr = new String[size];
                for (int i = 0; i < size; i++) {
                    String str = (String) ((HashMap) arrayList2.get(i)).get("yin");
                    if (Constants.CP_NONE.equals(str)) {
                        str = "";
                    }
                    strArr[i] = str;
                }
                arrayList.add(strArr);
            }
            HashSet<String> hashSet = new HashSet<>();
            HashSet<String> hashSet2 = new HashSet<>();
            toPinyinArray("", "", hashSet, hashSet2, arrayList);
            this.pinyin.addAll(hashSet);
            this.firstLatters.addAll(hashSet2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean match(String str, boolean z) {
            if (str == null || str.trim().length() <= 0) {
                return true;
            }
            if (!z) {
                str = str.toLowerCase();
            }
            String str2 = this.text;
            if (str2 != null && str2.toLowerCase().contains(str)) {
                return true;
            }
            String str3 = this.code;
            if (str3 != null && str3.contains(str)) {
                return true;
            }
            Iterator<String> it = this.pinyin.iterator();
            while (it.hasNext()) {
                if (it.next().contains(str)) {
                    return true;
                }
            }
            Iterator<String> it2 = this.firstLatters.iterator();
            while (it2.hasNext()) {
                if (it2.next().contains(str)) {
                    return true;
                }
            }
            return false;
        }

        private void toPinyinArray(String str, String str2, HashSet<String> hashSet, HashSet<String> hashSet2, ArrayList<String[]> arrayList) {
            if (arrayList.size() <= 0) {
                hashSet.add(str);
                hashSet2.add(str2);
                return;
            }
            String[] strArr = arrayList.get(0);
            ArrayList<String[]> arrayList2 = new ArrayList<>();
            arrayList2.addAll(arrayList);
            arrayList2.remove(0);
            for (String str3 : strArr) {
                if (str3.length() > 0) {
                    toPinyinArray(str + str3, str2 + str3.charAt(0), hashSet, hashSet2, arrayList2);
                } else {
                    toPinyinArray(str, str2, hashSet, hashSet2, arrayList2);
                }
            }
        }

        public String getText() {
            return this.text;
        }

        public String toString() {
            HashMap map = new HashMap();
            map.put(NotificationCompat.MessagingStyle.Message.KEY_TEXT, this.text);
            map.put("pinyin", this.pinyin);
            map.put("firstLatters", this.firstLatters);
            return map.toString();
        }

        public SearchIndex(String str, String str2, HashMap<String, Object> map) {
            this.text = str;
            this.code = str2;
            this.pinyin = new ArrayList<>();
            this.firstLatters = new ArrayList<>();
            createPinyinList(map);
        }
    }

    public static void prepare(final Context context, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: cn.smssdk.gui.SearchEngine.1
            /* JADX WARN: Removed duplicated region for block: B:17:0x0067 A[Catch: all -> 0x006c, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:15:0x0063, B:17:0x0067, B:18:0x006a, B:14:0x0054, B:8:0x0013, B:10:0x001d, B:11:0x0026), top: B:26:0x0003, inners: #0 }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0054 -> B:23:0x0063). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r3 = this;
                    java.lang.String r0 = "smssdk_pydb"
                    monitor-enter(r0)
                    java.util.HashMap r1 = cn.smssdk.gui.SearchEngine.access$000()     // Catch: java.lang.Throwable -> L6c
                    if (r1 == 0) goto L13
                    java.util.HashMap r1 = cn.smssdk.gui.SearchEngine.access$000()     // Catch: java.lang.Throwable -> L6c
                    int r1 = r1.size()     // Catch: java.lang.Throwable -> L6c
                    if (r1 > 0) goto L63
                L13:
                    android.content.Context r1 = r1     // Catch: java.lang.Throwable -> L53
                    java.lang.String r2 = "smssdk_pydb"
                    int r1 = com.mob.tools.utils.ResHelper.getRawRes(r1, r2)     // Catch: java.lang.Throwable -> L53
                    if (r1 > 0) goto L26
                    java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L53
                    r1.<init>()     // Catch: java.lang.Throwable -> L53
                    cn.smssdk.gui.SearchEngine.access$002(r1)     // Catch: java.lang.Throwable -> L53
                    goto L63
                L26:
                    android.content.Context r2 = r1     // Catch: java.lang.Throwable -> L53
                    android.content.res.Resources r2 = r2.getResources()     // Catch: java.lang.Throwable -> L53
                    java.io.InputStream r1 = r2.openRawResource(r1)     // Catch: java.lang.Throwable -> L53
                    java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L53
                    r2.<init>(r1)     // Catch: java.lang.Throwable -> L53
                    java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L53
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L53
                    java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L53
                    r2.<init>(r1)     // Catch: java.lang.Throwable -> L53
                    java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L53
                    r2.close()     // Catch: java.lang.Throwable -> L53
                    com.mob.tools.utils.Hashon r2 = new com.mob.tools.utils.Hashon     // Catch: java.lang.Throwable -> L53
                    r2.<init>()     // Catch: java.lang.Throwable -> L53
                    java.util.HashMap r1 = r2.fromJson(r1)     // Catch: java.lang.Throwable -> L53
                    cn.smssdk.gui.SearchEngine.access$002(r1)     // Catch: java.lang.Throwable -> L53
                    goto L63
                L53:
                    r1 = move-exception
                    com.mob.tools.log.NLog r2 = cn.smssdk.utils.SMSLog.getInstance()     // Catch: java.lang.Throwable -> L6c
                    r2.w(r1)     // Catch: java.lang.Throwable -> L6c
                    java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L6c
                    r1.<init>()     // Catch: java.lang.Throwable -> L6c
                    cn.smssdk.gui.SearchEngine.access$002(r1)     // Catch: java.lang.Throwable -> L6c
                L63:
                    java.lang.Runnable r1 = r2     // Catch: java.lang.Throwable -> L6c
                    if (r1 == 0) goto L6a
                    r1.run()     // Catch: java.lang.Throwable -> L6c
                L6a:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L6c
                    return
                L6c:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L6c
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.smssdk.gui.SearchEngine.AnonymousClass1.run():void");
            }
        };
        if (runnable != null) {
            new Thread(runnable2).start();
        } else {
            runnable2.run();
        }
    }

    public ArrayList<String> match(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<SearchIndex> arrayList2 = this.index;
        if (arrayList2 == null) {
            return arrayList;
        }
        Iterator<SearchIndex> it = arrayList2.iterator();
        while (it.hasNext()) {
            SearchIndex next = it.next();
            if (next.match(str, this.caseSensitive)) {
                arrayList.add(next.getText());
            }
        }
        return arrayList;
    }

    public void setCaseSensitive(boolean z) {
        this.caseSensitive = z;
    }

    public void setIndex(ArrayList<String> arrayList) {
        this.index = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.index.add(new SearchIndex(it.next(), hanzi2Pinyin));
        }
    }

    public void setIndexSet(ArrayList<String[]> arrayList) {
        this.index = new ArrayList<>();
        Iterator<String[]> it = arrayList.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            if (next != null && next.length >= 2) {
                this.index.add(new SearchIndex(next[0], next[1], hanzi2Pinyin));
            }
        }
    }
}
