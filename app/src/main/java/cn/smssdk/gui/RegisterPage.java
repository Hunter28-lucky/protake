package cn.smssdk.gui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.UserInterruptException;
import cn.smssdk.gui.layout.RegisterPageLayout;
import cn.smssdk.gui.util.GUISPDB;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.wrapper.TokenVerifyResult;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RegisterPage extends FakeActivity implements View.OnClickListener, TextWatcher {
    private static final String DEFAULT_COUNTRY_ID = "42";
    private Button btnNext;
    private EventHandler callback;
    private String currentCode;
    private String currentId;
    private EditText etPhoneNum;
    private EventHandler handler;
    private ImageView ivClear;
    private OnSendMessageHandler osmHandler;
    private Dialog pd;
    private String tempCode;
    private TextView tvCountry;
    private TextView tvCountryNum;
    private TokenVerifyResult verifyResult;

    /* JADX INFO: Access modifiers changed from: private */
    public void afterVerificationCodeRequested(boolean z) {
        String strReplaceAll = this.etPhoneNum.getText().toString().trim().replaceAll("\\s*", "");
        String strTrim = this.tvCountryNum.getText().toString().trim();
        if (strTrim.startsWith("+")) {
            strTrim = strTrim.substring(1);
        }
        String str = "+" + strTrim + MyUTIL.white_space + splitPhoneNum(strReplaceAll);
        if (z) {
            SmartVerifyPage smartVerifyPage = new SmartVerifyPage();
            smartVerifyPage.setPhone(strReplaceAll, strTrim, str);
            smartVerifyPage.showForResult(this.activity, null, this);
        } else {
            IdentifyNumPage identifyNumPage = new IdentifyNumPage();
            identifyNumPage.setPhone(strReplaceAll, strTrim, str);
            identifyNumPage.setTempCode(this.tempCode);
            identifyNumPage.showForResult(this.activity, null, this);
            SMSSDK.unregisterEventHandler(this.handler);
        }
    }

    private String[] getCurrentCountry() {
        String mcc = getMCC();
        String[] countryByMCC = !TextUtils.isEmpty(mcc) ? SMSSDK.getCountryByMCC(mcc) : null;
        if (countryByMCC != null) {
            return countryByMCC;
        }
        SMSLog.getInstance().d("no country found by MCC: " + mcc, new Object[0]);
        return SMSSDK.getCountry(DEFAULT_COUNTRY_ID);
    }

    private String getMCC() {
        TelephonyManager telephonyManager = (TelephonyManager) this.activity.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        return !TextUtils.isEmpty(networkOperator) ? networkOperator : telephonyManager.getSimOperator();
    }

    private void hideKeyboard() {
        ((InputMethodManager) this.activity.getSystemService("input_method")).hideSoftInputFromWindow(this.activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showVerifyResult() throws Resources.NotFoundException {
        hideKeyboard();
        Activity activity = this.activity;
        PopupDialog.create((Context) this.activity, (String) null, activity.getString(ResHelper.getStringRes(activity, "smssdk_identify_success")), this.activity.getResources().getString(ResHelper.getStringRes(this.activity, "smssdk_confirm")), new View.OnClickListener() { // from class: cn.smssdk.gui.RegisterPage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RegisterPage.this.finish();
            }
        }, (String) null, (View.OnClickListener) null, false, false, false).show();
    }

    private String splitPhoneNum(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        int length = sb.length();
        for (int i = 4; i < length; i += 5) {
            sb.insert(i, ' ');
        }
        sb.reverse();
        return sb.toString();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void confirmSend(final String str, final String str2) throws Resources.NotFoundException {
        PopupDialog.create(getContext(), getContext().getResources().getString(ResHelper.getStringRes(this.activity, "smssdk_make_sure_mobile_num")), String.format(getContext().getResources().getString(ResHelper.getStringRes(this.activity, "smssdk_make_sure_mobile_detail")), str2 + MyUTIL.white_space + splitPhoneNum(str)), getContext().getResources().getString(ResHelper.getStringRes(this.activity, "smssdk_ok")), new View.OnClickListener() { // from class: cn.smssdk.gui.RegisterPage.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RegisterPage.this.pd != null && RegisterPage.this.pd.isShowing()) {
                    RegisterPage.this.pd.dismiss();
                }
                RegisterPage registerPage = RegisterPage.this;
                registerPage.pd = CommonDialog.ProgressDialog(registerPage.activity);
                if (RegisterPage.this.pd != null) {
                    RegisterPage.this.pd.show();
                }
                if (TextUtils.isEmpty(RegisterPage.this.tempCode)) {
                    RegisterPage.this.tempCode = GUISPDB.getTempCode();
                }
                SMSLog.getInstance().i("verification phone ==>>" + str);
                SMSLog.getInstance().i("verification tempCode ==>>" + RegisterPage.this.tempCode);
                SMSSDK.getVerificationCode(str2, str.trim(), RegisterPage.this.tempCode, RegisterPage.this.osmHandler);
            }
        }, getContext().getResources().getString(ResHelper.getStringRes(this.activity, "smssdk_cancel")), new View.OnClickListener() { // from class: cn.smssdk.gui.RegisterPage.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, true, true, false).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int id = view.getId();
        int idRes = ResHelper.getIdRes(this.activity, "ll_back");
        int idRes2 = ResHelper.getIdRes(this.activity, "rl_country");
        int idRes3 = ResHelper.getIdRes(this.activity, "btn_next");
        int idRes4 = ResHelper.getIdRes(this.activity, "iv_clear");
        if (id == idRes) {
            finish();
            return;
        }
        if (id == idRes2) {
            CountryPage countryPage = new CountryPage();
            countryPage.setCountryId(this.currentId);
            countryPage.showForResult(this.activity, null, this);
        } else {
            if (id != idRes3) {
                if (id == idRes4) {
                    this.etPhoneNum.getText().clear();
                    return;
                }
                return;
            }
            String strReplaceAll = this.etPhoneNum.getText().toString().trim().replaceAll("\\s*", "");
            String strTrim = this.tvCountryNum.getText().toString().trim();
            TokenVerifyResult tokenVerifyResult = this.verifyResult;
            if (tokenVerifyResult == null) {
                confirmSend(strReplaceAll, strTrim);
            } else {
                SMSSDK.login(strReplaceAll, tokenVerifyResult);
            }
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        LinearLayout layout = new RegisterPageLayout(this.activity).getLayout();
        if (layout != null) {
            this.activity.setContentView(layout);
            this.currentId = DEFAULT_COUNTRY_ID;
            Activity activity = this.activity;
            View viewFindViewById = activity.findViewById(ResHelper.getIdRes(activity, "ll_back"));
            Activity activity2 = this.activity;
            View viewFindViewById2 = activity2.findViewById(ResHelper.getIdRes(activity2, "rl_country"));
            Activity activity3 = this.activity;
            this.btnNext = (Button) activity3.findViewById(ResHelper.getIdRes(activity3, "btn_next"));
            Activity activity4 = this.activity;
            this.tvCountry = (TextView) activity4.findViewById(ResHelper.getIdRes(activity4, "tv_country"));
            String[] currentCountry = getCurrentCountry();
            if (currentCountry != null) {
                this.currentCode = currentCountry[1];
                this.tvCountry.setText(currentCountry[0]);
            }
            Activity activity5 = this.activity;
            TextView textView = (TextView) activity5.findViewById(ResHelper.getIdRes(activity5, "tv_country_num"));
            this.tvCountryNum = textView;
            textView.setText("+" + this.currentCode);
            Activity activity6 = this.activity;
            EditText editText = (EditText) activity6.findViewById(ResHelper.getIdRes(activity6, "et_write_phone"));
            this.etPhoneNum = editText;
            editText.setText("");
            this.etPhoneNum.addTextChangedListener(this);
            this.etPhoneNum.requestFocus();
            if (this.etPhoneNum.getText().length() > 0) {
                this.btnNext.setEnabled(true);
                Activity activity7 = this.activity;
                ImageView imageView = (ImageView) activity7.findViewById(ResHelper.getIdRes(activity7, "iv_clear"));
                this.ivClear = imageView;
                imageView.setVisibility(0);
                int bitmapRes = ResHelper.getBitmapRes(this.activity, "smssdk_btn_enable");
                if (bitmapRes > 0) {
                    this.btnNext.setBackgroundResource(bitmapRes);
                }
            }
            Activity activity8 = this.activity;
            this.ivClear = (ImageView) activity8.findViewById(ResHelper.getIdRes(activity8, "iv_clear"));
            viewFindViewById.setOnClickListener(this);
            this.btnNext.setOnClickListener(this);
            this.ivClear.setOnClickListener(this);
            viewFindViewById2.setOnClickListener(this);
            this.handler = new EventHandler() { // from class: cn.smssdk.gui.RegisterPage.1
                @Override // cn.smssdk.EventHandler
                public void afterEvent(final int i, final int i2, final Object obj) {
                    RegisterPage.this.runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.RegisterPage.1.1
                        @Override // java.lang.Runnable
                        public void run() throws Resources.NotFoundException {
                            int stringRes;
                            if (RegisterPage.this.pd != null && RegisterPage.this.pd.isShowing()) {
                                RegisterPage.this.pd.dismiss();
                            }
                            if (i2 == -1) {
                                int i3 = i;
                                if (i3 == 2) {
                                    RegisterPage.this.afterVerificationCodeRequested(((Boolean) obj).booleanValue());
                                    return;
                                } else if (i3 == 9) {
                                    RegisterPage.this.verifyResult = (TokenVerifyResult) obj;
                                    return;
                                } else {
                                    if (i3 == 10) {
                                        RegisterPage.this.showVerifyResult();
                                        return;
                                    }
                                    return;
                                }
                            }
                            int i4 = i;
                            if (i4 != 2) {
                                if (i4 == 9) {
                                    RegisterPage.this.verifyResult = null;
                                    return;
                                } else {
                                    if (i4 == 10) {
                                        RegisterPage.this.confirmSend(RegisterPage.this.etPhoneNum.getText().toString().trim().replaceAll("\\s*", ""), RegisterPage.this.tvCountryNum.getText().toString().trim());
                                        return;
                                    }
                                    return;
                                }
                            }
                            Object obj2 = obj;
                            if (obj2 == null || !(obj2 instanceof UserInterruptException)) {
                                int iOptInt = 0;
                                String string = RegisterPage.this.getContext().getString(ResHelper.getStringRes(RegisterPage.this.getContext(), "smssdk_confirm"));
                                try {
                                    ((Throwable) obj).printStackTrace();
                                    JSONObject jSONObject = new JSONObject(((Throwable) obj).getMessage());
                                    String strOptString = jSONObject.optString("detail");
                                    iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                                    if (!TextUtils.isEmpty(strOptString)) {
                                        PopupDialog.create(RegisterPage.this.getContext(), (String) null, strOptString, string, new View.OnClickListener() { // from class: cn.smssdk.gui.RegisterPage.1.1.1
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                            }
                                        }, (String) null, (View.OnClickListener) null, true, true, false).show();
                                        return;
                                    }
                                } catch (Exception e2) {
                                    SMSLog.getInstance().w(e2);
                                }
                                if (iOptInt >= 400) {
                                    stringRes = ResHelper.getStringRes(RegisterPage.this.activity, "smssdk_error_desc_" + iOptInt);
                                } else {
                                    stringRes = ResHelper.getStringRes(RegisterPage.this.activity, "smssdk_network_error");
                                }
                                if (stringRes > 0) {
                                    PopupDialog.create(RegisterPage.this.getContext(), (String) null, RegisterPage.this.getContext().getString(stringRes), string, new View.OnClickListener() { // from class: cn.smssdk.gui.RegisterPage.1.1.2
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                        }
                                    }, (String) null, (View.OnClickListener) null, true, true, false).show();
                                }
                            }
                        }
                    });
                }
            };
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        SMSSDK.unregisterEventHandler(this.handler);
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
    }

    @Override // com.mob.tools.FakeActivity
    public void onResult(HashMap<String, Object> map) {
        if (map != null) {
            int iIntValue = ((Integer) map.get("page")).intValue();
            if (iIntValue != 1) {
                if (iIntValue == 2) {
                    Object obj = map.get("res");
                    HashMap map2 = (HashMap) map.get("phone");
                    if (obj == null || map2 == null) {
                        return;
                    }
                    EventHandler eventHandler = this.callback;
                    if (eventHandler != null) {
                        eventHandler.afterEvent(3, -1, map2);
                    }
                    finish();
                    return;
                }
                return;
            }
            String str = (String) map.get("id");
            this.currentId = str;
            String[] country = SMSSDK.getCountry(str);
            if (country != null) {
                this.currentCode = country[1];
                this.tvCountryNum.setText("+" + this.currentCode);
                this.tvCountry.setText(country[0]);
            }
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() throws JSONException, Resources.NotFoundException {
        SMSSDK.registerEventHandler(this.handler);
        SMSSDK.getToken();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.btnNext.setEnabled(true);
            this.ivClear.setVisibility(0);
            int bitmapRes = ResHelper.getBitmapRes(this.activity, "smssdk_btn_enable");
            if (bitmapRes > 0) {
                this.btnNext.setBackgroundResource(bitmapRes);
                return;
            }
            return;
        }
        this.btnNext.setEnabled(false);
        this.ivClear.setVisibility(8);
        int bitmapRes2 = ResHelper.getBitmapRes(this.activity, "smssdk_btn_disenable");
        if (bitmapRes2 > 0) {
            this.btnNext.setBackgroundResource(bitmapRes2);
        }
    }

    public void setOnSendMessageHandler(OnSendMessageHandler onSendMessageHandler) {
        this.osmHandler = onSendMessageHandler;
    }

    public void setRegisterCallback(EventHandler eventHandler) {
        this.callback = eventHandler;
    }

    public void setTempCode(String str) {
        this.tempCode = str;
        GUISPDB.setTempCode(str);
    }

    public void show(Context context) {
        super.show(context, null);
    }
}
