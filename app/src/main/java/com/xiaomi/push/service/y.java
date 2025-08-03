package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes2.dex */
public class y {
    private static Object a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private static Map<String, Queue<String>> f6503a = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f6503a.get(str);
            if (queue == null) {
                String[] strArrSplit = sharedPreferences.getString(str, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                LinkedList linkedList = new LinkedList();
                for (String str3 : strArrSplit) {
                    linkedList.add(str3);
                }
                f6503a.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String strA = com.xiaomi.push.bc.a(queue, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, strA);
            editorEdit.commit();
            return false;
        }
    }
}
