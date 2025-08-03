package cn.smssdk.gui;

import android.app.Activity;
import android.app.Dialog;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.BackVerifyDialogLayout;
import cn.smssdk.gui.layout.IdentifyNumPageLayout;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
import com.umeng.analytics.pro.am;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SmartVerifyPage extends FakeActivity implements View.OnClickListener {
    private static final int RETRY_INTERVAL = 60;
    private Button btnSubmit;
    private String code;
    private EditText etIdentifyNum;
    private String formatedPhone;
    private ImageView ivClear;
    private LinearLayout llVoice;
    private Dialog pd;
    private String phone;
    private TextView tvIdentifyNotify;
    private TextView tvPhone;
    private TextView tvResend;
    private int time = 60;
    private boolean showSmart = false;

    public static /* synthetic */ int access$010(SmartVerifyPage smartVerifyPage) {
        int i = smartVerifyPage.time;
        smartVerifyPage.time = i - 1;
        return i;
    }

    private void afterSubmit(final Object obj) {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.SmartVerifyPage.3
            @Override // java.lang.Runnable
            public void run() {
                if (SmartVerifyPage.this.pd != null && SmartVerifyPage.this.pd.isShowing()) {
                    SmartVerifyPage.this.pd.dismiss();
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("res", Boolean.TRUE);
                map.put("page", 2);
                map.put("phone", obj);
                SmartVerifyPage.this.setResult(map);
                SmartVerifyPage.this.finish();
            }
        });
    }

    private void countDown() {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.SmartVerifyPage.1
            @Override // java.lang.Runnable
            public void run() {
                SmartVerifyPage.access$010(SmartVerifyPage.this);
                if (SmartVerifyPage.this.time != 58) {
                    SmartVerifyPage.this.runOnUIThread(this, 1000L);
                    return;
                }
                SmartVerifyPage.this.btnSubmit.setEnabled(true);
                int bitmapRes = ResHelper.getBitmapRes(SmartVerifyPage.this.activity, "smssdk_btn_enable");
                if (bitmapRes > 0) {
                    SmartVerifyPage.this.btnSubmit.setBackgroundResource(bitmapRes);
                }
                SmartVerifyPage.this.etIdentifyNum.setText(ResHelper.getStringRes(SmartVerifyPage.this.activity, "smssdk_smart_verify_already"));
                SmartVerifyPage.this.etIdentifyNum.setEnabled(false);
                SmartVerifyPage.this.tvResend.setVisibility(8);
                SmartVerifyPage.this.llVoice.setVisibility(8);
                SmartVerifyPage.this.tvIdentifyNotify.setText(ResHelper.getStringRes(SmartVerifyPage.this.activity, "smssdk_smart_verify_tips"));
                SmartVerifyPage.this.showSmart = true;
                SmartVerifyPage.this.time = 60;
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotifyDialog() {
        int styleRes = ResHelper.getStyleRes(this.activity, "CommonDialog");
        if (styleRes > 0) {
            final Dialog dialog = new Dialog(getContext(), styleRes);
            LinearLayout linearLayoutCreate = BackVerifyDialogLayout.create(this.activity);
            if (linearLayoutCreate != null) {
                dialog.setContentView(linearLayoutCreate);
                TextView textView = (TextView) dialog.findViewById(ResHelper.getIdRes(this.activity, "tv_dialog_hint"));
                int stringRes = ResHelper.getStringRes(this.activity, "smssdk_close_identify_page_dialog");
                if (stringRes > 0) {
                    textView.setText(stringRes);
                }
                Button button = (Button) dialog.findViewById(ResHelper.getIdRes(this.activity, "btn_dialog_ok"));
                int stringRes2 = ResHelper.getStringRes(this.activity, "smssdk_wait");
                if (stringRes2 > 0) {
                    button.setText(stringRes2);
                }
                button.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.SmartVerifyPage.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Button button2 = (Button) dialog.findViewById(ResHelper.getIdRes(this.activity, "btn_dialog_cancel"));
                int stringRes3 = ResHelper.getStringRes(this.activity, "smssdk_back");
                if (stringRes3 > 0) {
                    button2.setText(stringRes3);
                }
                button2.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.SmartVerifyPage.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                        SmartVerifyPage.this.finish();
                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int idRes = ResHelper.getIdRes(this.activity, "ll_back");
        int idRes2 = ResHelper.getIdRes(this.activity, "btn_submit");
        int idRes3 = ResHelper.getIdRes(this.activity, "iv_clear");
        if (id == idRes) {
            if (this.showSmart) {
                finish();
                return;
            } else {
                runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.SmartVerifyPage.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SmartVerifyPage.this.showNotifyDialog();
                    }
                });
                return;
            }
        }
        if (id != idRes2) {
            if (id == idRes3) {
                this.etIdentifyNum.getText().clear();
            }
        } else {
            HashMap map = new HashMap();
            map.put(am.O, this.code);
            map.put("phone", this.phone);
            afterSubmit(map);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        LinearLayout layout = new IdentifyNumPageLayout(this.activity).getLayout();
        if (layout != null) {
            this.activity.setContentView(layout);
            Activity activity = this.activity;
            activity.findViewById(ResHelper.getIdRes(activity, "ll_back")).setOnClickListener(this);
            Activity activity2 = this.activity;
            Button button = (Button) activity2.findViewById(ResHelper.getIdRes(activity2, "btn_submit"));
            this.btnSubmit = button;
            button.setOnClickListener(this);
            this.btnSubmit.setEnabled(false);
            Activity activity3 = this.activity;
            this.etIdentifyNum = (EditText) activity3.findViewById(ResHelper.getIdRes(activity3, "et_put_identify"));
            Activity activity4 = this.activity;
            this.tvResend = (TextView) activity4.findViewById(ResHelper.getIdRes(activity4, "tv_resend"));
            Activity activity5 = this.activity;
            this.llVoice = (LinearLayout) activity5.findViewById(ResHelper.getIdRes(activity5, "ll_voice"));
            Activity activity6 = this.activity;
            this.tvIdentifyNotify = (TextView) activity6.findViewById(ResHelper.getIdRes(activity6, "tv_identify_notify"));
            int stringRes = ResHelper.getStringRes(this.activity, "smssdk_send_mobile_detail");
            if (stringRes > 0) {
                this.tvIdentifyNotify.setText(Html.fromHtml(getContext().getString(stringRes)));
            }
            Activity activity7 = this.activity;
            TextView textView = (TextView) activity7.findViewById(ResHelper.getIdRes(activity7, "tv_phone"));
            this.tvPhone = textView;
            textView.setText(this.formatedPhone);
            Activity activity8 = this.activity;
            ImageView imageView = (ImageView) activity8.findViewById(ResHelper.getIdRes(activity8, "iv_clear"));
            this.ivClear = imageView;
            imageView.setOnClickListener(this);
            countDown();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        finish();
        return true;
    }

    public void setPhone(String str, String str2, String str3) {
        this.phone = str;
        this.code = str2;
        this.formatedPhone = str3;
    }
}
