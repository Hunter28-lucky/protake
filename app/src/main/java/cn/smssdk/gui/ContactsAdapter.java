package cn.smssdk.gui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import cn.smssdk.gui.ContactsListView;
import cn.smssdk.gui.layout.SizeHelper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ContactsAdapter extends ContactsListView.GroupAdapter {
    private ArrayList<ArrayList<HashMap<String, Object>>> contacts;
    private ArrayList<HashMap<String, Object>> contactsOutApp;
    private ArrayList<HashMap<String, Object>> friendsInApp;
    private ContactItemMaker itemMaker;
    private SearchEngine sEngine;
    private ArrayList<String> titles;

    public ContactsAdapter(ContactsListView contactsListView, ArrayList<HashMap<String, Object>> arrayList, ArrayList<HashMap<String, Object>> arrayList2) {
        super(contactsListView);
        this.friendsInApp = new ArrayList<>();
        new ArrayList();
        this.friendsInApp = arrayList;
        this.contactsOutApp = arrayList2;
        initSearchEngine();
        search(null);
    }

    private void initSearchEngine() {
        this.sEngine = new SearchEngine();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<HashMap<String, Object>> it = this.friendsInApp.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            HashMap<String, Object> next = it.next();
            String strValueOf = next.containsKey("displayname") ? String.valueOf(next.get("displayname")) : "";
            if (!TextUtils.isEmpty(strValueOf)) {
                arrayList.add(strValueOf);
            }
        }
        Iterator<HashMap<String, Object>> it2 = this.contactsOutApp.iterator();
        while (it2.hasNext()) {
            HashMap<String, Object> next2 = it2.next();
            String strValueOf2 = next2.containsKey("displayname") ? String.valueOf(next2.get("displayname")) : "";
            if (!TextUtils.isEmpty(strValueOf2)) {
                arrayList.add(strValueOf2);
            }
        }
        this.sEngine.setIndex(arrayList);
    }

    private void reSortFia(HashMap<String, String> map, boolean z, ArrayList<HashMap<String, Object>> arrayList) {
        ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
        Iterator<HashMap<String, Object>> it = arrayList.iterator();
        while (it.hasNext()) {
            HashMap<String, Object> next = it.next();
            String strValueOf = next.containsKey("displayname") ? String.valueOf(next.get("displayname")) : "";
            if (!TextUtils.isEmpty(strValueOf) && (z || map.containsKey(strValueOf))) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.size() > 0) {
            int stringRes = ResHelper.getStringRes(this.view.getContext(), "smssdk_contacts_in_app");
            if (stringRes > 0) {
                this.titles.add(this.view.getContext().getResources().getString(stringRes));
            }
            this.contacts.add(arrayList2);
        }
    }

    private void reSortFoa(HashMap<String, String> map, boolean z, ArrayList<HashMap<String, Object>> arrayList) {
        ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
        Iterator<HashMap<String, Object>> it = arrayList.iterator();
        while (it.hasNext()) {
            HashMap<String, Object> next = it.next();
            String strValueOf = next.containsKey("displayname") ? String.valueOf(next.get("displayname")) : "";
            if (!TextUtils.isEmpty(strValueOf) && (z || map.containsKey(strValueOf))) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.size() > 0) {
            int stringRes = ResHelper.getStringRes(this.view.getContext(), "smssdk_contacts_out_app");
            if (stringRes > 0) {
                this.titles.add(this.view.getContext().getResources().getString(stringRes));
            }
            this.contacts.add(arrayList2);
        }
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public int getCount(int i) {
        ArrayList<HashMap<String, Object>> arrayList;
        ArrayList<ArrayList<HashMap<String, Object>>> arrayList2 = this.contacts;
        if (arrayList2 == null || (arrayList = arrayList2.get(i)) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public int getGroupCount() {
        ArrayList<String> arrayList = this.titles;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public String getGroupTitle(int i) {
        if (this.titles.size() > 0) {
            return this.titles.get(i).toString();
        }
        return null;
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public TextView getTitleView(int i, TextView textView, ViewGroup viewGroup) {
        if (textView == null) {
            textView = new TextView(viewGroup.getContext());
            textView.setBackgroundResource(ResHelper.getColorRes(viewGroup.getContext(), "smssdk_bg_gray"));
            textView.setTextSize(0, SizeHelper.fromPxWidth(viewGroup.getContext(), 25));
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setPadding(SizeHelper.fromPxWidth(viewGroup.getContext(), 18), 0, 0, 0);
            textView.setWidth(-1);
            textView.setHeight(SizeHelper.fromPxWidth(viewGroup.getContext(), 40));
            textView.setGravity(16);
        }
        String groupTitle = getGroupTitle(i);
        if (!TextUtils.isEmpty(groupTitle)) {
            textView.setText(groupTitle);
        }
        return textView;
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public View getView(int i, int i2, View view, ViewGroup viewGroup) {
        return this.itemMaker.getView(getItem(i, i2), view, viewGroup);
    }

    public void search(String str) {
        boolean z;
        ArrayList<String> arrayListMatch = this.sEngine.match(str);
        if (arrayListMatch == null || arrayListMatch.size() <= 0) {
            arrayListMatch = new ArrayList<>();
            z = true;
        } else {
            z = false;
        }
        HashMap<String, String> map = new HashMap<>();
        Iterator<String> it = arrayListMatch.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, next);
        }
        this.titles = new ArrayList<>();
        this.contacts = new ArrayList<>();
        if (this.friendsInApp.size() > 0) {
            reSortFia(map, z, this.friendsInApp);
        }
        if (this.contactsOutApp.size() > 0) {
            reSortFoa(map, z, this.contactsOutApp);
        }
    }

    public void setContactItemMaker(ContactItemMaker contactItemMaker) {
        this.itemMaker = contactItemMaker;
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public HashMap<String, Object> getItem(int i, int i2) {
        if (this.contacts.size() > 0) {
            return this.contacts.get(i).get(i2);
        }
        return null;
    }
}
