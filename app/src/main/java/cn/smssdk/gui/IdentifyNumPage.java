package cn.smssdk.gui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.layout.IdentifyNumPageLayout;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IdentifyNumPage extends FakeActivity implements View.OnClickListener, TextWatcher {
    private static final int MIN_REQUEST_VOICE_VERIFY_INTERVAL = 1000;
    private static final int RETRY_INTERVAL = 60;
    private TextView btnSounds;
    private Button btnSubmit;
    private String code;
    private EditText etIdentifyNum;
    private String formatedPhone;
    private EventHandler handler;
    private ImageView ivClear;
    private long lastRequestVVTime;
    private Dialog pd;
    private String phone;
    private BroadcastReceiver smsReceiver;
    private String tempCode;
    private int time = 60;
    private TextView tvIdentifyNotify;
    private TextView tvPhone;
    private TextView tvResend;

    public static /* synthetic */ int access$410(IdentifyNumPage identifyNumPage) {
        int i = identifyNumPage.time;
        identifyNumPage.time = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterGet(final int i, final Object obj) {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.7
            /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
            /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r5 = this;
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Dialog r0 = cn.smssdk.gui.IdentifyNumPage.access$700(r0)
                    if (r0 == 0) goto L1d
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Dialog r0 = cn.smssdk.gui.IdentifyNumPage.access$700(r0)
                    boolean r0 = r0.isShowing()
                    if (r0 == 0) goto L1d
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Dialog r0 = cn.smssdk.gui.IdentifyNumPage.access$700(r0)
                    r0.dismiss()
                L1d:
                    int r0 = r2
                    r1 = -1
                    r2 = 0
                    if (r0 != r1) goto L4c
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r0 = cn.smssdk.gui.IdentifyNumPage.access$1400(r0)
                    java.lang.String r1 = "smssdk_virificaition_code_sent"
                    int r0 = com.mob.tools.utils.ResHelper.getStringRes(r0, r1)
                    if (r0 <= 0) goto L3e
                    cn.smssdk.gui.IdentifyNumPage r1 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r1 = cn.smssdk.gui.IdentifyNumPage.access$1500(r1)
                    android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)
                    r0.show()
                L3e:
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    r1 = 60
                    cn.smssdk.gui.IdentifyNumPage.access$402(r0, r1)
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    cn.smssdk.gui.IdentifyNumPage.access$1600(r0)
                    goto Lc6
                L4c:
                    java.lang.Object r0 = r3
                    java.lang.Throwable r0 = (java.lang.Throwable) r0
                    r0.printStackTrace()
                    java.lang.Object r0 = r3
                    java.lang.Throwable r0 = (java.lang.Throwable) r0
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L82
                    java.lang.String r0 = r0.getMessage()     // Catch: org.json.JSONException -> L82
                    r1.<init>(r0)     // Catch: org.json.JSONException -> L82
                    java.lang.String r0 = "detail"
                    java.lang.String r0 = r1.optString(r0)     // Catch: org.json.JSONException -> L82
                    java.lang.String r3 = "status"
                    int r1 = r1.optInt(r3)     // Catch: org.json.JSONException -> L82
                    boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: org.json.JSONException -> L80
                    if (r3 != 0) goto L8b
                    cn.smssdk.gui.IdentifyNumPage r3 = cn.smssdk.gui.IdentifyNumPage.this     // Catch: org.json.JSONException -> L80
                    android.app.Activity r3 = cn.smssdk.gui.IdentifyNumPage.access$1700(r3)     // Catch: org.json.JSONException -> L80
                    android.widget.Toast r0 = android.widget.Toast.makeText(r3, r0, r2)     // Catch: org.json.JSONException -> L80
                    r0.show()     // Catch: org.json.JSONException -> L80
                    return
                L80:
                    r0 = move-exception
                    goto L84
                L82:
                    r0 = move-exception
                    r1 = r2
                L84:
                    com.mob.tools.log.NLog r3 = cn.smssdk.utils.SMSLog.getInstance()
                    r3.w(r0)
                L8b:
                    r0 = 400(0x190, float:5.6E-43)
                    if (r1 < r0) goto Lab
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r0 = cn.smssdk.gui.IdentifyNumPage.access$1800(r0)
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "smssdk_error_desc_"
                    r3.append(r4)
                    r3.append(r1)
                    java.lang.String r1 = r3.toString()
                    int r0 = com.mob.tools.utils.ResHelper.getStringRes(r0, r1)
                    goto Lb7
                Lab:
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r0 = cn.smssdk.gui.IdentifyNumPage.access$1900(r0)
                    java.lang.String r1 = "smssdk_network_error"
                    int r0 = com.mob.tools.utils.ResHelper.getStringRes(r0, r1)
                Lb7:
                    if (r0 <= 0) goto Lc6
                    cn.smssdk.gui.IdentifyNumPage r1 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r1 = cn.smssdk.gui.IdentifyNumPage.access$2000(r1)
                    android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)
                    r0.show()
                Lc6:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.smssdk.gui.IdentifyNumPage.AnonymousClass7.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterGetVoice(final int i, final Object obj) {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.8
            /* JADX WARN: Removed duplicated region for block: B:25:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00ad  */
            /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r5 = this;
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Dialog r0 = cn.smssdk.gui.IdentifyNumPage.access$700(r0)
                    if (r0 == 0) goto L1d
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Dialog r0 = cn.smssdk.gui.IdentifyNumPage.access$700(r0)
                    boolean r0 = r0.isShowing()
                    if (r0 == 0) goto L1d
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Dialog r0 = cn.smssdk.gui.IdentifyNumPage.access$700(r0)
                    r0.dismiss()
                L1d:
                    int r0 = r2
                    r1 = -1
                    r2 = 0
                    if (r0 != r1) goto L40
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r0 = cn.smssdk.gui.IdentifyNumPage.access$2100(r0)
                    java.lang.String r1 = "smssdk_send_sounds_success"
                    int r0 = com.mob.tools.utils.ResHelper.getStringRes(r0, r1)
                    if (r0 <= 0) goto Lba
                    cn.smssdk.gui.IdentifyNumPage r1 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r1 = cn.smssdk.gui.IdentifyNumPage.access$2200(r1)
                    android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)
                    r0.show()
                    goto Lba
                L40:
                    java.lang.Object r0 = r3
                    java.lang.Throwable r0 = (java.lang.Throwable) r0
                    r0.printStackTrace()
                    java.lang.Object r0 = r3
                    java.lang.Throwable r0 = (java.lang.Throwable) r0
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L76
                    java.lang.String r0 = r0.getMessage()     // Catch: org.json.JSONException -> L76
                    r1.<init>(r0)     // Catch: org.json.JSONException -> L76
                    java.lang.String r0 = "detail"
                    java.lang.String r0 = r1.optString(r0)     // Catch: org.json.JSONException -> L76
                    java.lang.String r3 = "status"
                    int r1 = r1.optInt(r3)     // Catch: org.json.JSONException -> L76
                    boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: org.json.JSONException -> L74
                    if (r3 != 0) goto L7f
                    cn.smssdk.gui.IdentifyNumPage r3 = cn.smssdk.gui.IdentifyNumPage.this     // Catch: org.json.JSONException -> L74
                    android.app.Activity r3 = cn.smssdk.gui.IdentifyNumPage.access$2300(r3)     // Catch: org.json.JSONException -> L74
                    android.widget.Toast r0 = android.widget.Toast.makeText(r3, r0, r2)     // Catch: org.json.JSONException -> L74
                    r0.show()     // Catch: org.json.JSONException -> L74
                    return
                L74:
                    r0 = move-exception
                    goto L78
                L76:
                    r0 = move-exception
                    r1 = r2
                L78:
                    com.mob.tools.log.NLog r3 = cn.smssdk.utils.SMSLog.getInstance()
                    r3.w(r0)
                L7f:
                    r0 = 400(0x190, float:5.6E-43)
                    if (r1 < r0) goto L9f
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r0 = cn.smssdk.gui.IdentifyNumPage.access$2400(r0)
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "smssdk_error_desc_"
                    r3.append(r4)
                    r3.append(r1)
                    java.lang.String r1 = r3.toString()
                    int r0 = com.mob.tools.utils.ResHelper.getStringRes(r0, r1)
                    goto Lab
                L9f:
                    cn.smssdk.gui.IdentifyNumPage r0 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r0 = cn.smssdk.gui.IdentifyNumPage.access$2500(r0)
                    java.lang.String r1 = "smssdk_network_error"
                    int r0 = com.mob.tools.utils.ResHelper.getStringRes(r0, r1)
                Lab:
                    if (r0 <= 0) goto Lba
                    cn.smssdk.gui.IdentifyNumPage r1 = cn.smssdk.gui.IdentifyNumPage.this
                    android.app.Activity r1 = cn.smssdk.gui.IdentifyNumPage.access$2600(r1)
                    android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)
                    r0.show()
                Lba:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.smssdk.gui.IdentifyNumPage.AnonymousClass8.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterSubmit(final int i, final Object obj) {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.6
            @Override // java.lang.Runnable
            public void run() throws JSONException, Resources.NotFoundException {
                if (IdentifyNumPage.this.pd != null && IdentifyNumPage.this.pd.isShowing()) {
                    IdentifyNumPage.this.pd.dismiss();
                }
                if (i == -1) {
                    IdentifyNumPage.this.stopCountDown();
                    PopupDialog.create(IdentifyNumPage.this.getContext(), (String) null, IdentifyNumPage.this.getContext().getResources().getString(ResHelper.getStringRes(IdentifyNumPage.this.getContext(), "smssdk_identify_success")), IdentifyNumPage.this.getContext().getResources().getString(ResHelper.getStringRes(IdentifyNumPage.this.getContext(), "smssdk_confirm")), new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("res", Boolean.TRUE);
                            map.put("page", 2);
                            map.put("phone", obj);
                            IdentifyNumPage.this.setResult(map);
                            IdentifyNumPage.this.finish();
                        }
                    }, (String) null, (View.OnClickListener) null, false, false, false).show();
                    return;
                }
                ((Throwable) obj).printStackTrace();
                int stringRes = 0;
                try {
                    int i2 = new JSONObject(((Throwable) obj).getMessage()).getInt(NotificationCompat.CATEGORY_STATUS);
                    stringRes = ResHelper.getStringRes(IdentifyNumPage.this.activity, "smssdk_error_detail_" + i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (stringRes == 0) {
                    stringRes = ResHelper.getStringRes(IdentifyNumPage.this.activity, "smssdk_virificaition_code_wrong");
                }
                if (stringRes > 0) {
                    PopupDialog.create(IdentifyNumPage.this.getContext(), (String) null, IdentifyNumPage.this.getContext().getResources().getString(stringRes), IdentifyNumPage.this.getContext().getResources().getString(ResHelper.getStringRes(IdentifyNumPage.this.getContext(), "smssdk_confirm")), new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.6.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                        }
                    }, (String) null, (View.OnClickListener) null, true, true, false).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.3
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                IdentifyNumPage.access$410(IdentifyNumPage.this);
                IdentifyNumPage identifyNumPage = IdentifyNumPage.this;
                identifyNumPage.setResendText(identifyNumPage.time);
                if (IdentifyNumPage.this.time <= 0) {
                    IdentifyNumPage.this.time = 60;
                } else {
                    IdentifyNumPage.this.runOnUIThread(this, 1000L);
                }
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResendText(int i) throws Resources.NotFoundException {
        if (this.tvResend != null) {
            String string = getContext().getResources().getString(ResHelper.getStringRes(getContext(), "smssdk_identify_num_page_resend"));
            if (i == 0) {
                this.tvResend.setText(string);
                this.tvResend.setTextColor(getContext().getResources().getColor(ResHelper.getColorRes(getContext(), "smssdk_main_color")));
                this.tvResend.setClickable(true);
                return;
            }
            this.tvResend.setText(string + "(" + i + ")");
            this.tvResend.setTextColor(getContext().getResources().getColor(ResHelper.getColorRes(getContext(), "smssdk_tv_light_gray")));
            this.tvResend.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotifyDialog() throws Resources.NotFoundException {
        PopupDialog.create(getContext(), (String) null, getContext().getResources().getString(ResHelper.getStringRes(getContext(), "smssdk_close_identify_page_dialog")), getContext().getResources().getString(ResHelper.getStringRes(getContext(), "smssdk_confirm")), new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IdentifyNumPage.this.stopCountDown();
                IdentifyNumPage.this.finish();
            }
        }, getContext().getResources().getString(ResHelper.getStringRes(getContext(), "smssdk_wait")), new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, true, true, false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCountDown() {
        this.time = 1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int id = view.getId();
        int idRes = ResHelper.getIdRes(this.activity, "ll_back");
        int idRes2 = ResHelper.getIdRes(this.activity, "btn_submit");
        int idRes3 = ResHelper.getIdRes(this.activity, "iv_clear");
        int idRes4 = ResHelper.getIdRes(this.activity, "tv_voice");
        int idRes5 = ResHelper.getIdRes(this.activity, "tv_resend");
        if (id == idRes) {
            runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.4
                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    IdentifyNumPage.this.showNotifyDialog();
                }
            });
            return;
        }
        if (id == idRes2) {
            String strTrim = this.etIdentifyNum.getText().toString().trim();
            if (TextUtils.isEmpty(this.code)) {
                int stringRes = ResHelper.getStringRes(this.activity, "smssdk_write_identify_code");
                if (stringRes > 0) {
                    Toast.makeText(getContext(), stringRes, 0).show();
                    return;
                }
                return;
            }
            Dialog dialog = this.pd;
            if (dialog != null && dialog.isShowing()) {
                this.pd.dismiss();
            }
            Dialog dialogProgressDialog = CommonDialog.ProgressDialog(this.activity);
            this.pd = dialogProgressDialog;
            if (dialogProgressDialog != null) {
                dialogProgressDialog.show();
            }
            SMSSDK.submitVerificationCode(this.code, this.phone, strTrim);
            return;
        }
        if (id == idRes3) {
            this.etIdentifyNum.getText().clear();
            return;
        }
        if (id == idRes4) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastRequestVVTime > 1000) {
                this.lastRequestVVTime = jCurrentTimeMillis;
                PopupDialog.create(getContext(), (String) null, getContext().getResources().getString(ResHelper.getStringRes(this.activity, "smssdk_send_sounds_identify_code")), getContext().getResources().getString(ResHelper.getStringRes(this.activity, "smssdk_i_know")), new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (IdentifyNumPage.this.pd != null && IdentifyNumPage.this.pd.isShowing()) {
                            IdentifyNumPage.this.pd.dismiss();
                        }
                        IdentifyNumPage identifyNumPage = IdentifyNumPage.this;
                        identifyNumPage.pd = CommonDialog.ProgressDialog(identifyNumPage.activity);
                        if (IdentifyNumPage.this.pd != null) {
                            IdentifyNumPage.this.pd.show();
                        }
                        SMSSDK.getVoiceVerifyCode(IdentifyNumPage.this.code, IdentifyNumPage.this.phone);
                    }
                }, (String) null, (View.OnClickListener) null, true, true, false).show();
                return;
            }
            return;
        }
        if (id == idRes5) {
            Dialog dialog2 = this.pd;
            if (dialog2 != null && dialog2.isShowing()) {
                this.pd.dismiss();
            }
            Dialog dialogProgressDialog2 = CommonDialog.ProgressDialog(this.activity);
            this.pd = dialogProgressDialog2;
            if (dialogProgressDialog2 != null) {
                dialogProgressDialog2.show();
            }
            SMSSDK.getVerificationCode(this.code, this.phone.trim(), this.tempCode, null);
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
            EditText editText = (EditText) activity3.findViewById(ResHelper.getIdRes(activity3, "et_put_identify"));
            this.etIdentifyNum = editText;
            editText.addTextChangedListener(this);
            Activity activity4 = this.activity;
            this.tvIdentifyNotify = (TextView) activity4.findViewById(ResHelper.getIdRes(activity4, "tv_identify_notify"));
            int stringRes = ResHelper.getStringRes(this.activity, "smssdk_send_mobile_detail");
            if (stringRes > 0) {
                this.tvIdentifyNotify.setText(Html.fromHtml(getContext().getString(stringRes)));
            }
            Activity activity5 = this.activity;
            TextView textView = (TextView) activity5.findViewById(ResHelper.getIdRes(activity5, "tv_phone"));
            this.tvPhone = textView;
            textView.setText(this.formatedPhone);
            Activity activity6 = this.activity;
            ImageView imageView = (ImageView) activity6.findViewById(ResHelper.getIdRes(activity6, "iv_clear"));
            this.ivClear = imageView;
            imageView.setOnClickListener(this);
            Activity activity7 = this.activity;
            TextView textView2 = (TextView) activity7.findViewById(ResHelper.getIdRes(activity7, "tv_resend"));
            this.tvResend = textView2;
            textView2.setOnClickListener(this);
            Activity activity8 = this.activity;
            TextView textView3 = (TextView) activity8.findViewById(ResHelper.getIdRes(activity8, "tv_voice"));
            this.btnSounds = textView3;
            textView3.setOnClickListener(this);
            EventHandler eventHandler = new EventHandler() { // from class: cn.smssdk.gui.IdentifyNumPage.1
                @Override // cn.smssdk.EventHandler
                public void afterEvent(int i, int i2, Object obj) {
                    if (i == 3) {
                        IdentifyNumPage.this.afterSubmit(i2, obj);
                    } else if (i == 2) {
                        IdentifyNumPage.this.afterGet(i2, obj);
                    } else if (i == 8) {
                        IdentifyNumPage.this.afterGetVoice(i2, obj);
                    }
                }
            };
            this.handler = eventHandler;
            SMSSDK.registerEventHandler(eventHandler);
            countDown();
        }
        try {
            if (DH.SyncMtd.checkPermission("android.permission.RECEIVE_SMS")) {
                SMSReceiver sMSReceiver = new SMSReceiver(new SMSSDK.VerifyCodeReadListener() { // from class: cn.smssdk.gui.IdentifyNumPage.2
                    @Override // cn.smssdk.SMSSDK.VerifyCodeReadListener
                    public void onReadVerifyCode(final String str) {
                        IdentifyNumPage.this.runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                IdentifyNumPage.this.etIdentifyNum.setText(str);
                            }
                        });
                    }
                });
                this.smsReceiver = sMSReceiver;
                this.activity.registerReceiver(sMSReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.smsReceiver = null;
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        SMSSDK.unregisterEventHandler(this.handler);
        BroadcastReceiver broadcastReceiver = this.smsReceiver;
        if (broadcastReceiver != null) {
            try {
                this.activity.unregisterReceiver(broadcastReceiver);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.11
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                IdentifyNumPage.this.showNotifyDialog();
            }
        });
        return true;
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.btnSubmit.setEnabled(true);
            this.ivClear.setVisibility(0);
            int bitmapRes = ResHelper.getBitmapRes(this.activity, "smssdk_btn_enable");
            if (bitmapRes > 0) {
                this.btnSubmit.setBackgroundResource(bitmapRes);
                return;
            }
            return;
        }
        this.btnSubmit.setEnabled(false);
        this.ivClear.setVisibility(8);
        int bitmapRes2 = ResHelper.getBitmapRes(this.activity, "smssdk_btn_disenable");
        if (bitmapRes2 > 0) {
            this.btnSubmit.setBackgroundResource(bitmapRes2);
        }
    }

    public void setPhone(String str, String str2, String str3) {
        this.phone = str;
        this.code = str2;
        this.formatedPhone = str3;
    }

    public void setTempCode(String str) {
        this.tempCode = str;
    }
}
