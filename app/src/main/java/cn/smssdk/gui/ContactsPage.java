package cn.smssdk.gui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.entity.Profile;
import cn.smssdk.gui.layout.ContactListPageLayout;
import cn.smssdk.gui.util.GUISPDB;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ContactsPage extends FakeActivity implements View.OnClickListener, TextWatcher {
    private ContactsAdapter adapter;
    private ArrayList<HashMap<String, Object>> contactsInMobile;
    private EditText etSearch;
    private ArrayList<HashMap<String, Object>> friendsInApp;
    private EventHandler handler;
    private ContactItemMaker itemMaker;
    private ContactsListView listView;
    private LinearLayout llProfile;
    private OnUserInfoSubmitListener onUserInfoSubmitListener;
    private Dialog pd;
    private TextView tvBind;

    public interface OnUserInfoSubmitListener {
        void onSubmitted(Profile profile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterPrepare() {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.ContactsPage.2
            @Override // java.lang.Runnable
            public void run() {
                ContactsPage.this.friendsInApp = new ArrayList();
                ContactsPage.this.contactsInMobile = new ArrayList();
                ContactListPageLayout contactListPageLayout = new ContactListPageLayout(ContactsPage.this.activity);
                LinearLayout layout = contactListPageLayout.getLayout();
                ContactsPage.this.onUserInfoSubmitListener = contactListPageLayout.getUserInfoSubmitListenerInstance();
                if (layout != null) {
                    ContactsPage.this.activity.setContentView(layout);
                    ContactsPage.this.initView();
                    ContactsPage.this.initData();
                }
            }
        });
    }

    private void bindProfile() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() { // from class: cn.smssdk.gui.ContactsPage.4
            @Override // cn.smssdk.EventHandler
            public void afterEvent(int i, int i2, Object obj) {
                if (i2 == -1) {
                    HashMap map = (HashMap) obj;
                    String str = (String) map.get(am.O);
                    String str2 = (String) map.get("phone");
                    Profile profile = GUISPDB.getProfile();
                    if (profile == null) {
                        profile = new Profile(null, str2, null, str, String.valueOf(Math.abs(new Random().nextInt())));
                    } else {
                        profile.setPhoneNum(str2);
                        profile.setCountry(str);
                    }
                    AvatarPage avatarPage = new AvatarPage();
                    Intent intent = new Intent();
                    intent.putExtra(AvatarPage.EXTRA_PROFILE, profile);
                    avatarPage.showForResult(ContactsPage.this.activity, intent, ContactsPage.this);
                    SMSSDK.unregisterEventHandler(ContactsPage.this.handler);
                }
            }
        });
        registerPage.show(this.activity.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        EventHandler eventHandler = new EventHandler() { // from class: cn.smssdk.gui.ContactsPage.3
            @Override // cn.smssdk.EventHandler
            public void afterEvent(int i, int i2, final Object obj) {
                if (i2 != -1) {
                    ContactsPage.this.runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.ContactsPage.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ContactsPage.this.pd != null && ContactsPage.this.pd.isShowing()) {
                                ContactsPage.this.pd.dismiss();
                            }
                            try {
                                ((Throwable) obj).printStackTrace();
                                JSONObject jSONObject = new JSONObject(((Throwable) obj).getMessage());
                                String strOptString = jSONObject.optString("detail");
                                jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                                if (!TextUtils.isEmpty(strOptString)) {
                                    Toast.makeText(ContactsPage.this.activity.getApplicationContext(), strOptString, 0).show();
                                    return;
                                }
                            } catch (Exception e2) {
                                SMSLog.getInstance().w(e2);
                            }
                            int stringRes = ResHelper.getStringRes(ContactsPage.this.activity, "smssdk_network_error");
                            if (stringRes > 0) {
                                Toast.makeText(ContactsPage.this.activity.getApplicationContext(), stringRes, 0).show();
                            }
                            ContactsPage.this.llProfile.setVisibility(0);
                        }
                    });
                    return;
                }
                if (i != 4) {
                    if (i == 6) {
                        ContactsPage.this.friendsInApp = (ArrayList) obj;
                        SMSSDK.getContacts(false);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList == null) {
                    ContactsPage.this.contactsInMobile = new ArrayList();
                } else {
                    ContactsPage.this.contactsInMobile = (ArrayList) arrayList.clone();
                }
                ContactsPage.this.refreshContactList();
            }
        };
        this.handler = eventHandler;
        SMSSDK.registerEventHandler(eventHandler);
        ArrayList<HashMap<String, Object>> arrayList = this.friendsInApp;
        if (arrayList == null || arrayList.size() <= 0) {
            SMSSDK.getFriendsInApp();
        } else {
            SMSSDK.getContacts(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        Activity activity = this.activity;
        this.llProfile = (LinearLayout) activity.findViewById(ResHelper.getIdRes(activity, "ll_profile"));
        Activity activity2 = this.activity;
        this.tvBind = (TextView) activity2.findViewById(ResHelper.getIdRes(activity2, "tv_profile_rebind"));
        Activity activity3 = this.activity;
        this.listView = (ContactsListView) activity3.findViewById(ResHelper.getIdRes(activity3, "clContact"));
        Activity activity4 = this.activity;
        activity4.findViewById(ResHelper.getIdRes(activity4, "ll_back")).setOnClickListener(this);
        Activity activity5 = this.activity;
        activity5.findViewById(ResHelper.getIdRes(activity5, "iv_clear")).setOnClickListener(this);
        this.tvBind.setOnClickListener(this);
        Activity activity6 = this.activity;
        TextView textView = (TextView) activity6.findViewById(ResHelper.getIdRes(activity6, "tv_title"));
        int stringRes = ResHelper.getStringRes(this.activity, "smssdk_search_contact");
        if (stringRes > 0) {
            textView.setText(stringRes);
        }
        Activity activity7 = this.activity;
        EditText editText = (EditText) activity7.findViewById(ResHelper.getIdRes(activity7, "et_put_identify"));
        this.etSearch = editText;
        editText.addTextChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshContactList() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator<HashMap<String, Object>> it = this.contactsInMobile.iterator();
        while (it.hasNext()) {
            HashMap<String, Object> next = it.next();
            ArrayList arrayList2 = (ArrayList) next.get("phones");
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new ContactEntry((String) ((HashMap) it2.next()).get("phone"), next));
                }
            }
        }
        ArrayList<HashMap<String, Object>> arrayList3 = new ArrayList<>();
        int size = arrayList.size();
        Iterator<HashMap<String, Object>> it3 = this.friendsInApp.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HashMap<String, Object> next2 = it3.next();
            String strValueOf = String.valueOf(next2.get("phone"));
            for (int i = 0; i < size; i++) {
                ContactEntry contactEntry = (ContactEntry) arrayList.get(i);
                if (strValueOf.equals(contactEntry.getKey())) {
                    next2.put("contact", contactEntry.getValue());
                    next2.put("fia", Boolean.TRUE);
                    arrayList3.add((HashMap) next2.clone());
                }
            }
        }
        this.friendsInApp = arrayList3;
        HashSet hashSet = new HashSet();
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ContactEntry contactEntry2 = (ContactEntry) it4.next();
            String key = contactEntry2.getKey();
            HashMap<String, Object> value = contactEntry2.getValue();
            if (key != null && value != null) {
                Iterator<HashMap<String, Object>> it5 = this.friendsInApp.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        if (key.equals(String.valueOf(it5.next().get("phone")))) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    hashSet.add(value);
                }
            }
        }
        this.contactsInMobile.clear();
        this.contactsInMobile.addAll(hashSet);
        Iterator<HashMap<String, Object>> it6 = this.friendsInApp.iterator();
        while (it6.hasNext()) {
            HashMap<String, Object> next3 = it6.next();
            HashMap map = (HashMap) next3.remove("contact");
            if (map != null) {
                String strValueOf2 = String.valueOf(next3.get("phone"));
                ArrayList arrayList4 = (ArrayList) map.get("phones");
                if (arrayList4 != null && arrayList4.size() > 0) {
                    ArrayList arrayList5 = new ArrayList();
                    Iterator it7 = arrayList4.iterator();
                    while (it7.hasNext()) {
                        HashMap map2 = (HashMap) it7.next();
                        if (!strValueOf2.equals((String) map2.get("phone"))) {
                            arrayList5.add(map2);
                        }
                    }
                    map.put("phones", arrayList5);
                }
                next3.put("displayname", map.get("displayname"));
            }
        }
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.ContactsPage.5
            @Override // java.lang.Runnable
            public void run() {
                if (ContactsPage.this.pd != null && ContactsPage.this.pd.isShowing()) {
                    ContactsPage.this.pd.dismiss();
                }
                ContactsPage contactsPage = ContactsPage.this;
                contactsPage.adapter = new ContactsAdapter(contactsPage.listView, ContactsPage.this.friendsInApp, ContactsPage.this.contactsInMobile);
                ContactsPage.this.adapter.setContactItemMaker(ContactsPage.this.itemMaker);
                ContactsPage.this.listView.setAdapter(ContactsPage.this.adapter);
                ContactsPage.this.llProfile.setVisibility(0);
            }
        });
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int idRes = ResHelper.getIdRes(this.activity, "ll_back");
        int idRes2 = ResHelper.getIdRes(this.activity, "iv_clear");
        int idRes3 = ResHelper.getIdRes(this.activity, "tv_profile_rebind");
        if (id == idRes) {
            finish();
        } else if (id == idRes2) {
            this.etSearch.getText().clear();
        } else if (id == idRes3) {
            bindProfile();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        Dialog dialog = this.pd;
        if (dialog != null && dialog.isShowing()) {
            this.pd.dismiss();
        }
        Dialog dialogProgressDialog = CommonDialog.ProgressDialog(this.activity);
        this.pd = dialogProgressDialog;
        if (dialogProgressDialog != null) {
            dialogProgressDialog.show();
        }
        SearchEngine.prepare(this.activity, new Runnable() { // from class: cn.smssdk.gui.ContactsPage.1
            @Override // java.lang.Runnable
            public void run() {
                ContactsPage.this.afterPrepare();
            }
        });
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        SMSSDK.unregisterEventHandler(this.handler);
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        try {
            int idRes = ResHelper.getIdRes(this.activity, "llSearch");
            if (i == 4 && keyEvent.getAction() == 0 && this.activity.findViewById(idRes).getVisibility() == 0) {
                this.activity.findViewById(idRes).setVisibility(8);
                this.activity.findViewById(ResHelper.getIdRes(this.activity, "llTitle")).setVisibility(0);
                this.etSearch.setText("");
                return true;
            }
        } catch (Exception e2) {
            SMSLog.getInstance().w(e2);
        }
        return super.onKeyEvent(i, keyEvent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
    }

    @Override // com.mob.tools.FakeActivity
    public void onResult(HashMap<String, Object> map) {
        Boolean bool;
        OnUserInfoSubmitListener onUserInfoSubmitListener;
        super.onResult(map);
        if (map == null || (bool = (Boolean) map.get("res")) == null || !bool.booleanValue() || (onUserInfoSubmitListener = this.onUserInfoSubmitListener) == null) {
            return;
        }
        onUserInfoSubmitListener.onSubmitted(GUISPDB.getProfile());
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        EventHandler eventHandler = this.handler;
        if (eventHandler != null) {
            SMSSDK.registerEventHandler(eventHandler);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ContactsAdapter contactsAdapter = this.adapter;
        if (contactsAdapter != null) {
            contactsAdapter.search(charSequence.toString());
            this.adapter.notifyDataSetChanged();
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.llProfile.setVisibility(0);
        } else {
            this.llProfile.setVisibility(8);
        }
    }

    public void setOnUserInfoSubmitListener(OnUserInfoSubmitListener onUserInfoSubmitListener) {
        this.onUserInfoSubmitListener = onUserInfoSubmitListener;
    }

    public void show(Context context) {
        show(context, new DefaultContactViewItem());
    }

    public void show(Context context, ContactItemMaker contactItemMaker) {
        this.itemMaker = contactItemMaker;
        super.show(context, (Intent) null);
    }
}
