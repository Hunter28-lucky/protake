package com.mob.pushsdk.b;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public class e {

    public interface a {
        void a(View view);
    }

    public static boolean a() {
        try {
            return !a(ViewCompat.MEASURED_STATE_MASK, a(MobSDK.getContext()));
        } catch (Throwable th) {
            PLog.getInstance().w("MobPush get notification theme failed, error:" + th);
            return false;
        }
    }

    private static int a(Context context) {
        RemoteViews remoteViewsCreateContentView;
        try {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle("Notification Title");
            Notification notificationBuild = builder.build();
            remoteViewsCreateContentView = null;
            RemoteViews remoteViews = notificationBuild.contentView;
            if (remoteViews != null) {
                remoteViewsCreateContentView = remoteViews;
            } else if (Build.VERSION.SDK_INT >= 24) {
                remoteViewsCreateContentView = Notification.Builder.recoverBuilder(context, notificationBuild).createContentView();
            }
        } catch (Throwable th) {
            PLog.getInstance().w("MobPush get notification color failed, error:" + th);
        }
        if (remoteViewsCreateContentView == null) {
            return 0;
        }
        ViewGroup viewGroup = (ViewGroup) remoteViewsCreateContentView.apply(context, new FrameLayout(context));
        final int[] iArr = new int[1];
        if (((TextView) viewGroup.findViewById(R.id.title)) == null) {
            a(viewGroup, new a() { // from class: com.mob.pushsdk.b.e.1
                @Override // com.mob.pushsdk.b.e.a
                public void a(View view) {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        if ("Notification Title".equals(textView.getText().toString())) {
                            iArr[0] = textView.getCurrentTextColor();
                        }
                    }
                }
            });
            return iArr[0];
        }
        return 0;
    }

    private static void a(View view, a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        aVar.a(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(viewGroup.getChildAt(i), aVar);
            }
        }
    }

    private static boolean a(int i, int i2) {
        int i3 = i | ViewCompat.MEASURED_STATE_MASK;
        int i4 = i2 | ViewCompat.MEASURED_STATE_MASK;
        int iRed = Color.red(i3) - Color.red(i4);
        int iGreen = Color.green(i3) - Color.green(i4);
        int iBlue = Color.blue(i3) - Color.blue(i4);
        return Math.sqrt((double) (((iRed * iRed) + (iGreen * iGreen)) + (iBlue * iBlue))) < 180.0d;
    }
}
