package cn.smssdk.gui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.entity.Profile;
import cn.smssdk.gui.util.GUISPDB;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AvatarPage extends FakeActivity implements View.OnClickListener {
    public static final String EXTRA_PROFILE = "extra_profile";
    private String avatarUrl;
    private Button btSubmit;
    private EventHandler handler;
    private AsyncImageView ivAvatar;
    private Dialog pd;
    private Profile profile;

    private void initView() {
        TextView textView = (TextView) findViewById(ResHelper.getIdRes(getContext(), "tv_left"));
        textView.setText("");
        textView.setOnClickListener(this);
        ((TextView) findViewById(ResHelper.getIdRes(getContext(), "tv_title"))).setText("");
        ((TextView) findViewById(ResHelper.getIdRes(getContext(), "tv_right"))).setVisibility(4);
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(ResHelper.getIdRes(getContext(), "iv_avatar"));
        this.ivAvatar = asyncImageView;
        asyncImageView.setRound(ResHelper.dipToPx(getContext(), 60));
        this.ivAvatar.setOnClickListener(this);
        Button button = (Button) findViewById(ResHelper.getIdRes(getContext(), "bt_submit_profile"));
        this.btSubmit = button;
        button.setOnClickListener(this);
        Intent intent = this.activity.getIntent();
        if (intent != null) {
            this.profile = (Profile) intent.getSerializableExtra(EXTRA_PROFILE);
        }
        Profile profile = this.profile;
        if (profile != null) {
            refreshAvator(profile.getAvatar(), this.profile.getNickName());
        }
    }

    private void refreshAvator(String str, String str2) {
        this.avatarUrl = str;
        if (!TextUtils.isEmpty(str)) {
            this.ivAvatar.execute(this.avatarUrl, ResHelper.getBitmapRes(this.activity, "smssdk_cp_default_avatar"));
            ((TextView) findViewById(ResHelper.getIdRes(getContext(), "tv_avatar"))).setVisibility(4);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((TextView) findViewById(ResHelper.getIdRes(getContext(), "et_nickname"))).setText(str2);
    }

    private void submitProfile() {
        Profile profile = this.profile;
        if (profile == null) {
            Toast.makeText(getContext(), ResHelper.getStringRes(getContext(), "smssdk_msg_profile_empty"), 0).show();
            return;
        }
        profile.setAvatar(this.avatarUrl);
        this.profile.setNickName(((TextView) findViewById(ResHelper.getIdRes(getContext(), "et_nickname"))).getText().toString());
        Dialog dialog = this.pd;
        if (dialog != null && dialog.isShowing()) {
            this.pd.dismiss();
        }
        Dialog dialogProgressDialog = CommonDialog.ProgressDialog(this.activity);
        this.pd = dialogProgressDialog;
        if (dialogProgressDialog != null) {
            dialogProgressDialog.show();
        }
        SMSSDK.submitUserInfo(this.profile.getUid(), this.profile.getNickName(), this.profile.getAvatar(), this.profile.getCountry(), this.profile.getPhoneNum());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == ResHelper.getIdRes(getContext(), "tv_left")) {
            finish();
        } else if (id == ResHelper.getIdRes(getContext(), "iv_avatar")) {
            new AvatarPickerPage().showForResult(this.activity, null, this);
        } else if (id == ResHelper.getIdRes(getContext(), "bt_submit_profile")) {
            submitProfile();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        super.onCreate();
        this.activity.setContentView(ResHelper.getLayoutRes(getContext(), "smssdk_avatar_page"));
        initView();
        EventHandler eventHandler = new EventHandler() { // from class: cn.smssdk.gui.AvatarPage.1
            @Override // cn.smssdk.EventHandler
            public void afterEvent(int i, int i2, Object obj) {
                super.afterEvent(i, i2, obj);
                if (AvatarPage.this.pd != null && AvatarPage.this.pd.isShowing()) {
                    AvatarPage.this.pd.dismiss();
                }
                if (i2 == -1) {
                    if (i == 5) {
                        GUISPDB.setProfile(AvatarPage.this.profile);
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("res", Boolean.TRUE);
                        AvatarPage.this.setResult(map);
                        AvatarPage.this.finish();
                        return;
                    }
                    return;
                }
                if (i == 5) {
                    try {
                        ((Throwable) obj).printStackTrace();
                        JSONObject jSONObject = new JSONObject(((Throwable) obj).getMessage());
                        String strOptString = jSONObject.optString("detail");
                        jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                        if (TextUtils.isEmpty(strOptString)) {
                            return;
                        }
                        Toast.makeText(AvatarPage.this.activity, strOptString, 0).show();
                    } catch (Exception e2) {
                        SMSLog.getInstance().w(e2);
                    }
                }
            }
        };
        this.handler = eventHandler;
        SMSSDK.registerEventHandler(eventHandler);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        SMSSDK.unregisterEventHandler(this.handler);
    }

    @Override // com.mob.tools.FakeActivity
    public void onResult(HashMap<String, Object> map) {
        super.onResult(map);
        refreshAvator(map != null ? String.valueOf(map.get(AvatarPickerPage.INTENT_PICK_URL)) : null, null);
    }

    public void show(Context context) {
        show(context, null);
    }
}
