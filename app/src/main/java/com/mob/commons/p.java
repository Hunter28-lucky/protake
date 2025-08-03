package com.mob.commons;

import com.mob.extension.AWe;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class p {
    public static final List<Object> a;

    static {
        LinkedList linkedList = new LinkedList();
        a = linkedList;
        try {
            linkedList.add(SHARESDK.class);
        } catch (Throwable unused) {
        }
        try {
            a.add(SMSSDK.class);
        } catch (Throwable unused2) {
        }
        try {
            a.add(MOBLINK.class);
        } catch (Throwable unused3) {
        }
        try {
            a.add(MOBPUSH.class);
        } catch (Throwable unused4) {
        }
        try {
            a.add(AWe.class);
        } catch (Throwable unused5) {
        }
        try {
            a.add(SECVERIFY.class);
        } catch (Throwable unused6) {
        }
        try {
            a.add(MOBADSDK.class);
        } catch (Throwable unused7) {
        }
        try {
            a.add(MOBGUARD.class);
        } catch (Throwable unused8) {
        }
        try {
            a.add(GESVERIFY.class);
        } catch (Throwable unused9) {
        }
        try {
            a.add(MOBAPM.class);
        } catch (Throwable unused10) {
        }
        try {
            a.add(ADPUSH.class);
        } catch (Throwable unused11) {
        }
    }
}
