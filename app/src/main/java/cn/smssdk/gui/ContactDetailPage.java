package cn.smssdk.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.ContactDetailPageLayout;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ContactDetailPage extends FakeActivity implements View.OnClickListener {
    private String phoneName = "";
    private ArrayList<String> phoneList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        int stringRes = ResHelper.getStringRes(this.activity, "smssdk_invite_content");
        if (stringRes > 0) {
            intent.putExtra("sms_body", this.activity.getString(stringRes));
        }
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void showDialog() {
        String[] strArr = (String[]) this.phoneList.toArray(new String[this.phoneList.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        int stringRes = ResHelper.getStringRes(this.activity, "smssdk_invite_content");
        if (stringRes > 0) {
            builder.setTitle(stringRes);
        }
        builder.setCancelable(true);
        int stringRes2 = ResHelper.getStringRes(this.activity, "smssdk_cancel");
        if (stringRes2 > 0) {
            builder.setNegativeButton(stringRes2, new DialogInterface.OnClickListener() { // from class: cn.smssdk.gui.ContactDetailPage.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: cn.smssdk.gui.ContactDetailPage.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ContactDetailPage contactDetailPage = ContactDetailPage.this;
                contactDetailPage.sendMsg((String) contactDetailPage.phoneList.get(i));
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int idRes = ResHelper.getIdRes(this.activity, "ll_back");
        int idRes2 = ResHelper.getIdRes(this.activity, "btn_invite");
        if (id == idRes) {
            finish();
        } else if (id == idRes2) {
            if (this.phoneList.size() > 1) {
                showDialog();
            } else {
                sendMsg(this.phoneList.size() > 0 ? this.phoneList.get(0) : "");
            }
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        LinearLayout layout = new ContactDetailPageLayout(this.activity).getLayout();
        if (layout != null) {
            this.activity.setContentView(layout);
            Activity activity = this.activity;
            activity.findViewById(ResHelper.getIdRes(activity, "ll_back")).setOnClickListener(this);
            Activity activity2 = this.activity;
            ((TextView) activity2.findViewById(ResHelper.getIdRes(activity2, "tv_title"))).setText(ResHelper.getStringRes(this.activity, "smssdk_invite_friend"));
            Activity activity3 = this.activity;
            ((TextView) activity3.findViewById(ResHelper.getIdRes(activity3, "tv_contact_name"))).setText(this.phoneName);
            ArrayList<String> arrayList = this.phoneList;
            if (arrayList != null && !arrayList.isEmpty()) {
                Activity activity4 = this.activity;
                ((TextView) activity4.findViewById(ResHelper.getIdRes(activity4, "tv_phone"))).setText(this.phoneList.get(0));
                if (this.phoneList.size() > 1) {
                    Activity activity5 = this.activity;
                    ((LinearLayout) activity5.findViewById(ResHelper.getIdRes(activity5, "ll_phone2"))).setVisibility(0);
                    Activity activity6 = this.activity;
                    activity6.findViewById(ResHelper.getIdRes(activity6, "vw_divider2")).setVisibility(0);
                    Activity activity7 = this.activity;
                    ((TextView) activity7.findViewById(ResHelper.getIdRes(activity7, "tv_phone2"))).setText(this.phoneList.get(1));
                }
            }
            Activity activity8 = this.activity;
            activity8.findViewById(ResHelper.getIdRes(activity8, "btn_invite")).setOnClickListener(this);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
    }

    public void setContact(HashMap<String, Object> map) {
        ArrayList arrayList;
        if (map.containsKey("displayname")) {
            this.phoneName = String.valueOf(map.get("displayname"));
        } else if (map.containsKey("phones") && (arrayList = (ArrayList) map.get("phones")) != null && arrayList.size() > 0) {
            this.phoneName = (String) ((HashMap) arrayList.get(0)).get("phone");
        }
        ArrayList arrayList2 = (ArrayList) map.get("phones");
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.phoneList.add((String) ((HashMap) it.next()).get("phone"));
        }
    }
}
