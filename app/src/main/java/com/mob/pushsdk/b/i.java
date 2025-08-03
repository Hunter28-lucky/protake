package com.mob.pushsdk.b;

import java.util.Calendar;
import java.util.Random;

/* loaded from: classes2.dex */
public class i {
    private static i a;
    private int b;

    public static i a() {
        if (a == null) {
            a = new i();
        }
        return a;
    }

    public int b() {
        int iNextInt = new Random().nextInt(100) + 1;
        Calendar calendar = Calendar.getInstance();
        int iIntValue = Integer.valueOf(calendar.get(12)).intValue();
        int iIntValue2 = iNextInt + iIntValue + Integer.valueOf(calendar.get(13)).intValue() + Integer.valueOf(calendar.get(14)).intValue();
        if (this.b == iIntValue2) {
            return b();
        }
        this.b = iIntValue2;
        return iIntValue2;
    }
}
