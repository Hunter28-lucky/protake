package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class dy extends dw {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    public Bitmap f5813a;

    /* renamed from: a, reason: collision with other field name */
    private RemoteViews f5814a;

    /* renamed from: a, reason: collision with other field name */
    public CharSequence f5815a;

    /* renamed from: a, reason: collision with other field name */
    private String f5816a;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<Notification.Action> f5817a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f5818a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5819a;
    private int b;

    /* renamed from: b, reason: collision with other field name */
    public CharSequence f5820b;

    /* renamed from: b, reason: collision with other field name */
    private boolean f5821b;

    public dy(Context context, String str) {
        this(context, 0, str);
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m5429c() {
        Map<String, String> map = this.f5818a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f5815a);
        super.setContentText(this.f5820b);
    }

    private boolean e() {
        return m5430d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> listM5753b = com.xiaomi.push.service.af.a(a(), this.f5816a).m5753b();
        if (listM5753b != null && !listM5753b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : listM5753b) {
                if (statusBarNotification.getId() == this.a) {
                    if (statusBarNotification.getNotification() == null) {
                        return false;
                    }
                    return !r0.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dy setContentTitle(CharSequence charSequence) {
        this.f5815a = charSequence;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public abstract String mo5432a();

    public void a(int i, Notification.Action action) {
    }

    /* renamed from: a */
    public abstract boolean mo5426a();

    @Override // android.app.Notification.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public dy setContentText(CharSequence charSequence) {
        this.f5820b = charSequence;
        return this;
    }

    public abstract String b();

    public dy(Context context, int i, String str) {
        super(context);
        this.f5817a = new ArrayList<>();
        this.b = 0;
        this.f5816a = str;
        this.a = i;
        m5428c();
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dy setLargeIcon(Bitmap bitmap) {
        this.f5813a = bitmap;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public final void m5434b() {
        super.setContentTitle(this.f5815a);
        super.setContentText(this.f5820b);
        Bitmap bitmap = this.f5813a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m5430d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f5816a)) ? false : true;
    }

    @Override // com.xiaomi.push.dw
    public dw a(Map<String, String> map) {
        this.f5818a = map;
        return this;
    }

    /* renamed from: c, reason: collision with other method in class */
    private void m5428c() {
        int iA = a(a().getResources(), c(), "layout", a().getPackageName());
        if (iA != 0) {
            this.f5814a = new RemoteViews(a().getPackageName(), iA);
            this.f5819a = mo5426a();
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5113a("create RemoteViews failed, no such layout resource was found");
        }
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dy addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public dy addAction(Notification.Action action) {
        if (action != null) {
            this.f5817a.add(action);
        }
        int i = this.b;
        this.b = i + 1;
        a(i, action);
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public final boolean m5435b() {
        return this.f5819a;
    }

    @Override // com.xiaomi.push.dw
    /* renamed from: a */
    public void mo5425a() {
        super.mo5425a();
        Bundle bundle = new Bundle();
        if (m5430d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f5821b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f5817a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f5817a.size()];
            this.f5817a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (!m5429c() && com.xiaomi.push.service.ag.m5755a(a().getContentResolver())) {
            bundle.putCharSequence("mipush.customTitle", this.f5815a);
            bundle.putCharSequence("mipush.customContent", this.f5820b);
        } else {
            d();
        }
        addExtras(bundle);
    }

    private String c() {
        boolean zE = e();
        this.f5821b = zE;
        return zE ? b() : mo5432a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public final RemoteViews m5431a() {
        return this.f5814a;
    }

    public void a(int i) {
        Bitmap bitmapA = a();
        if (bitmapA != null) {
            m5431a().setImageViewBitmap(i, bitmapA);
            return;
        }
        int iB = g.b(a(), this.f5816a);
        if (iB != 0) {
            m5431a().setImageViewResource(i, iB);
        }
    }

    private Bitmap a() {
        return com.xiaomi.push.service.x.a(g.m5510a(a(), this.f5816a));
    }

    public int a(float f) {
        return (int) ((f * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public Bitmap a(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m5433a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }
}
