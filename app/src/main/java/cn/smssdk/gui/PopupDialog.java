package cn.smssdk.gui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class PopupDialog extends AlertDialog {
    private static final String TAG = "PopupDialog";
    private LinearLayout bottomLl;
    private TextView cancel;
    private ImageView close;
    private TextView confirm;
    private Context context;
    private TextView msg;
    private TextView title;
    private RelativeLayout topRl;
    private View verticalLine;
    private View view;
    private int width;

    public PopupDialog(Context context, boolean z, boolean z2) {
        super(context, ResHelper.getStyleRes(context, "Dialog_Common"));
        this.context = context;
        this.width = (int) (getScreenWidth(context) * 0.7d);
        setCancelable(z);
        setCanceledOnTouchOutside(z2);
        this.view = LayoutInflater.from(this.context).inflate(ResHelper.getLayoutRes(context, "smssdk_popup_dialog"), (ViewGroup) null);
        initView();
    }

    public static PopupDialog create(Context context, String str, String str2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2, boolean z, boolean z2, boolean z3) {
        PopupDialog popupDialog = new PopupDialog(context, z, z2);
        popupDialog.setDialogTitle(str, z3);
        popupDialog.setDialogMessage(str2);
        popupDialog.setDialogButton(str3, onClickListener, str4, onClickListener2);
        return popupDialog;
    }

    private int getScreenHeight(Context context) {
        return getScreenSize(context)[1];
    }

    private int[] getScreenSize(Context context) {
        WindowManager windowManager;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Throwable th) {
            SMSLog.getInstance().w(SMSLog.FORMAT, TAG, "getScreenSize", th);
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
            SMSLog.getInstance().w(SMSLog.FORMAT, TAG, "getScreenSize", th2);
            return new int[]{0, 0};
        }
    }

    private int getScreenWidth(Context context) {
        return getScreenSize(context)[0];
    }

    private void initView() {
        this.title = (TextView) this.view.findViewById(ResHelper.getIdRes(this.context, "common_dialog_title_tv"));
        this.close = (ImageView) this.view.findViewById(ResHelper.getIdRes(this.context, "common_dialog_close_iv"));
        TextView textView = (TextView) this.view.findViewById(ResHelper.getIdRes(this.context, "common_dialog_message_tv"));
        this.msg = textView;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.confirm = (TextView) this.view.findViewById(ResHelper.getIdRes(this.context, "common_dialog_confirm_tv"));
        this.cancel = (TextView) this.view.findViewById(ResHelper.getIdRes(this.context, "common_dialog_cancel_tv"));
        this.bottomLl = (LinearLayout) this.view.findViewById(ResHelper.getIdRes(this.context, "common_dialog_bottom_ll"));
        this.topRl = (RelativeLayout) this.view.findViewById(ResHelper.getIdRes(this.context, "common_dialog_top_rl"));
        this.verticalLine = this.view.findViewById(ResHelper.getIdRes(this.context, "common_dialog_vertical_line"));
        ImageView imageView = this.close;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.PopupDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PopupDialog.this.dismiss();
                }
            });
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.view, new LinearLayout.LayoutParams(this.width, -2, 0.0f));
    }

    public void setCancel(int i) {
        this.cancel.setText(this.context.getResources().getString(i));
    }

    public void setDialogButton(int i, CharSequence charSequence, final View.OnClickListener onClickListener) {
        if (charSequence == null || "".equals(charSequence)) {
            if (i == -2) {
                TextView textView = this.cancel;
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                }
                return;
            }
            if (i == -1) {
                TextView textView2 = this.confirm;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    return;
                }
                return;
            }
            SMSLog.getInstance().e(SMSLog.FORMAT, TAG, "setDialogButton", "Button can not be found. whichButton=" + i);
            return;
        }
        if (i == -2) {
            TextView textView3 = this.cancel;
            if (textView3 != null) {
                textView3.setText(charSequence);
                this.cancel.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.PopupDialog.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        View.OnClickListener onClickListener2 = onClickListener;
                        if (onClickListener2 != null) {
                            onClickListener2.onClick(view);
                        }
                        PopupDialog.this.dismiss();
                    }
                });
                return;
            }
            return;
        }
        if (i != -1) {
            SMSLog.getInstance().e(SMSLog.FORMAT, TAG, "setDialogButton", "Button can not be found. whichButton=" + i);
            return;
        }
        TextView textView4 = this.confirm;
        if (textView4 != null) {
            textView4.setText(charSequence);
            this.confirm.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.PopupDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    View.OnClickListener onClickListener2 = onClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view);
                    }
                    PopupDialog.this.dismiss();
                }
            });
        }
    }

    public void setDialogMessage(CharSequence charSequence) {
        if (charSequence == null || "".equals(charSequence)) {
            TextView textView = this.msg;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.msg;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
    }

    public void setDialogTitle(CharSequence charSequence, boolean z) {
        ImageView imageView;
        if (charSequence == null || "".equals(charSequence)) {
            TextView textView = this.title;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            TextView textView2 = this.title;
            if (textView2 != null) {
                textView2.setText(charSequence);
            }
        }
        if (!z || (imageView = this.close) == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    public static PopupDialog create(Context context, int i, int i2, int i3, View.OnClickListener onClickListener, int i4, View.OnClickListener onClickListener2, boolean z, boolean z2, boolean z3) {
        return create(context, i, i2, i3, onClickListener, i4, onClickListener2, z, z2, z3, null);
    }

    public static PopupDialog create(Context context, int i, int i2, int i3, View.OnClickListener onClickListener, int i4, View.OnClickListener onClickListener2, boolean z, boolean z2, boolean z3, DialogInterface.OnDismissListener onDismissListener) throws Resources.NotFoundException {
        boolean z4;
        String string;
        String string2;
        String string3;
        PopupDialog popupDialog = new PopupDialog(context, z, z2);
        if (onDismissListener != null) {
            popupDialog.setOnDismissListener(onDismissListener);
        }
        String string4 = null;
        if (i > 0) {
            try {
                string = context.getResources().getString(i);
            } catch (Resources.NotFoundException e2) {
                SMSLog.getInstance().w(SMSLog.FORMAT, TAG, "create", "Resource not found. resId=" + i, e2);
                z4 = z3;
                string = null;
            }
        } else {
            string = null;
        }
        z4 = z3;
        popupDialog.setDialogTitle(string, z4);
        if (i2 > 0) {
            try {
                string2 = context.getResources().getString(i2);
            } catch (Resources.NotFoundException e3) {
                SMSLog.getInstance().w(SMSLog.FORMAT, TAG, "create", "Resource not found. resId=" + i2, e3);
            }
        } else {
            string2 = null;
        }
        popupDialog.setDialogMessage(string2);
        if (i3 > 0) {
            try {
                string3 = context.getResources().getString(i3);
            } catch (Resources.NotFoundException e4) {
                e = e4;
                string3 = null;
                SMSLog.getInstance().w(SMSLog.FORMAT, TAG, "create", "Resource not found.", e);
                popupDialog.setDialogButton(string3, onClickListener, string4, onClickListener2);
                return popupDialog;
            }
        } else {
            string3 = null;
        }
        if (i4 > 0) {
            try {
                string4 = context.getResources().getString(i4);
            } catch (Resources.NotFoundException e5) {
                e = e5;
                SMSLog.getInstance().w(SMSLog.FORMAT, TAG, "create", "Resource not found.", e);
                popupDialog.setDialogButton(string3, onClickListener, string4, onClickListener2);
                return popupDialog;
            }
        }
        popupDialog.setDialogButton(string3, onClickListener, string4, onClickListener2);
        return popupDialog;
    }

    public void setDialogButton(String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2) {
        if ((str != null && !"".equals(str)) || (str2 != null && !"".equals(str2))) {
            if (str != null && !"".equals(str) && str2 != null && !"".equals(str2)) {
                setDialogButton(-1, str, onClickListener);
                setDialogButton(-2, str2, onClickListener2);
                return;
            }
            this.verticalLine.setVisibility(8);
            setDialogButton(-1, null, null);
            if (str != null && !"".equals(str)) {
                setDialogButton(-2, str, onClickListener);
                return;
            } else {
                setDialogButton(-2, str2, onClickListener2);
                return;
            }
        }
        LinearLayout linearLayout = this.bottomLl;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }
}
