package cn.smssdk.ui;

import android.R;
import android.widget.LinearLayout;
import cn.smssdk.OnDialogListener;
import cn.smssdk.entity.UiSettings;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AlertPage extends FakeActivity {
    private static AlertPage instance;
    private ArrayList<Runnable> cancelActions;
    private String msg;
    private ArrayList<Runnable> okActions;
    private HashMap<String, Object> res;

    public class a implements OnDialogListener {
        public a() {
        }

        @Override // cn.smssdk.OnDialogListener
        public void onAgree() {
            AlertPage.this.res.put("res", Boolean.TRUE);
            AlertPage.instance.finish();
        }

        @Override // cn.smssdk.OnDialogListener
        public void onDisagree() {
            AlertPage.this.res.put("res", Boolean.FALSE);
            AlertPage.instance.finish();
        }
    }

    public AlertPage() {
        instance = this;
        this.okActions = new ArrayList<>();
        this.cancelActions = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        this.res = map;
        map.put("okActions", this.okActions);
        this.res.put("cancelActions", this.cancelActions);
        setResult(this.res);
    }

    private LinearLayout createPage() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        return linearLayout;
    }

    public static boolean isShow() {
        return instance != null;
    }

    public static void setActions(Runnable runnable, Runnable runnable2) {
        instance.okActions.add(runnable);
        instance.cancelActions.add(runnable2);
    }

    public static void setMsg(String str) {
        instance.msg = str;
    }

    private void showDialog() {
        new cn.smssdk.ui.a(getContext(), new UiSettings.Builder().setMsgText(this.msg).build(), new a()).show();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        int styleRes = ResHelper.getStyleRes(this.activity, "smssdk_DialogStyle");
        if (styleRes > 0) {
            this.activity.setTheme(styleRes);
        } else {
            this.activity.setTheme(R.style.Theme.Dialog);
        }
        this.activity.setContentView(createPage());
        showDialog();
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        instance = null;
        super.onDestroy();
    }
}
