package cn.smssdk.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.OnDialogListener;
import cn.smssdk.entity.UiSettings;
import cn.smssdk.ui.companent.CircleImageView;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SmsResHelper;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;

/* compiled from: AuthorizeDialog.java */
/* loaded from: classes.dex */
public class a extends AlertDialog {
    private View a;
    private Context b;
    private int c;
    private TextView d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f17622e;
    private CircleImageView f;
    private TextView g;
    private TextView h;
    private OnDialogListener i;
    private UiSettings j;

    /* compiled from: AuthorizeDialog.java */
    /* renamed from: cn.smssdk.ui.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0066a implements View.OnClickListener {
        public ViewOnClickListenerC0066a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.isShowing()) {
                a.this.dismiss();
            }
            if (a.this.i != null) {
                a.this.i.onAgree();
            }
        }
    }

    /* compiled from: AuthorizeDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.isShowing()) {
                a.this.dismiss();
            }
            if (a.this.i != null) {
                a.this.i.onDisagree();
            }
        }
    }

    public a(Context context, OnDialogListener onDialogListener) {
        this(context, new UiSettings.Builder().buildDefault(), onDialogListener);
    }

    private void b() {
        this.d = (TextView) this.a.findViewById(ResHelper.getIdRes(this.b, "smssdk_authorize_dialog_title_tv"));
        this.f17622e = (TextView) this.a.findViewById(ResHelper.getIdRes(this.b, "smssdk_authorize_dialog_msg"));
        this.f = (CircleImageView) this.a.findViewById(ResHelper.getIdRes(this.b, "smssdk_authorize_dialog_logo_iv"));
        this.h = (TextView) this.a.findViewById(ResHelper.getIdRes(this.b, "smssdk_authorize_dialog_accept_tv"));
        this.g = (TextView) this.a.findViewById(ResHelper.getIdRes(this.b, "smssdk_authorize_dialog_reject_tv"));
        UiSettings uiSettings = this.j;
        if (uiSettings != null) {
            this.d.setText(SmsResHelper.getStringSafe(uiSettings.getTitleTextId(), UiSettings.DEFAULT_TITLE_TEXT_ID));
            this.d.setTextColor(SmsResHelper.getColorSafe(this.j.getTitleTextColorId(), UiSettings.DEFAULT_TITLE_TEXT_COLOR_ID));
            int titleTextSizeDp = this.j.getTitleTextSizeDp();
            if (titleTextSizeDp <= 0) {
                titleTextSizeDp = UiSettings.DEFAULT_TITLE_TEXT_SIZE_DP;
            }
            this.d.setTextSize(titleTextSizeDp);
            this.f17622e.setText(this.j.getMsgText());
        }
    }

    private int c(Context context) {
        return b(context)[0];
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.a, new LinearLayout.LayoutParams(this.c, -2, 0.0f));
        b();
        a();
    }

    public a(Context context, UiSettings uiSettings, OnDialogListener onDialogListener) {
        super(context, ResHelper.getStyleRes(context, "smssdk_DialogStyle"));
        this.b = context;
        this.j = uiSettings;
        this.i = onDialogListener;
        if (context.getResources().getConfiguration().orientation == 2) {
            this.c = (int) (a(this.b) * 0.7d);
        } else {
            this.c = (int) (c(this.b) * 0.7d);
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        this.a = LayoutInflater.from(this.b).inflate(ResHelper.getLayoutRes(context, "smssdk_authorize_dialog"), (ViewGroup) null);
    }

    private void a() {
        int iconIdSafe = SmsResHelper.getIconIdSafe(-1);
        if (iconIdSafe == -1) {
            this.f.setVisibility(8);
        } else {
            this.f.setImageResource(iconIdSafe);
        }
        this.h.setOnClickListener(new ViewOnClickListenerC0066a());
        this.g.setOnClickListener(new b());
    }

    private int a(Context context) {
        return b(context)[1];
    }

    private int[] b(Context context) {
        WindowManager windowManager;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Throwable th) {
            SMSLog.getInstance().w(th, SMSLog.FORMAT, "AuthorizeDialog", "getScreenSize", "get SCreenSize Exception");
            windowManager = null;
        }
        if (windowManager == null) {
            return new int[]{0, 0};
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
            Point point = new Point();
            Method method = defaultDisplay.getClass().getMethod("getRealSize", Point.class);
            method.setAccessible(true);
            method.invoke(defaultDisplay, point);
            return new int[]{point.x, point.y};
        } catch (Throwable th2) {
            SMSLog.getInstance().w(th2, SMSLog.FORMAT, "AuthorizeDialog", "getScreenSize", "get SCreenSize Exception");
            return new int[]{0, 0};
        }
    }
}
